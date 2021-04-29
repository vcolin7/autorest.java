package com.azure.autorest.mapper;

import com.azure.autorest.extension.base.model.codemodel.Operation;
import com.azure.autorest.extension.base.model.codemodel.OperationGroup;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.model.clientmodel.ClientMethod;
import com.azure.autorest.model.clientmodel.ClientModels;
import com.azure.autorest.model.clientmodel.IType;
import com.azure.autorest.model.clientmodel.MethodGroupClient;
import com.azure.autorest.model.clientmodel.Proxy;
import com.azure.autorest.model.clientmodel.ProxyMethod;
import com.azure.autorest.util.CodeNamer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodGroupMapper implements IMapper<OperationGroup, MethodGroupClient> {
    private static MethodGroupMapper instance = new MethodGroupMapper();
    private Map<OperationGroup, MethodGroupClient> parsed = new HashMap<>();

    protected MethodGroupMapper() {
    }

    public static MethodGroupMapper getInstance() {
        return instance;
    }

    @Override
    public MethodGroupClient map(OperationGroup methodGroup) {
        JavaSettings settings = JavaSettings.getInstance();
        if (parsed.containsKey(methodGroup)) {
            return parsed.get(methodGroup);
        }
        MethodGroupClient.Builder builder = createMethodGroupClientBuilder();

        String classBaseName = methodGroup.getLanguage().getJava().getName();
        builder.classBaseName(classBaseName);
        String interfaceName = CodeNamer.getPlural(classBaseName);
        final String interfaceNameForCheckDeduplicate = interfaceName;
        if (ClientModels.Instance.getTypes().stream().anyMatch(cm -> interfaceNameForCheckDeduplicate.equals(cm.getName()))
                || parsed.values().stream().anyMatch(mg -> interfaceNameForCheckDeduplicate.equals(mg.getInterfaceName()))) {
            interfaceName += "Operations";
        }
        builder.interfaceName(interfaceName);
        String className = interfaceName;
        if (settings.isFluent()) {
            if (settings.shouldGenerateClientAsImpl()) {
                className += "ClientImpl";
            } else {
                className += "Client";
            }
        } else if (settings.shouldGenerateClientAsImpl()) {
            className += "Impl";
        }
        builder.className(className);

        Proxy.Builder proxyBuilder = createProxyBuilder();

        String restAPIName = CodeNamer.toPascalCase(CodeNamer.getPlural(methodGroup.getLanguage().getJava().getName()));
        restAPIName += "Service";
        String serviceClientName = methodGroup.getCodeModel().getLanguage().getJava().getName();
        // TODO: Assume all operations share the same base url
        proxyBuilder.name(restAPIName)
                .clientTypeName(serviceClientName + interfaceName)
                .baseURL(methodGroup.getOperations().get(0).getRequests().get(0).getProtocol().getHttp().getUri());

        List<ProxyMethod> restAPIMethods = new ArrayList<>();
        for (Operation method : methodGroup.getOperations()) {
            // azure-core does not support OPTIONS HTTP method.
            // https://github.com/Azure/autorest.java/issues/453
            if (!"options".equals(method.getRequests().get(0).getProtocol().getHttp().getMethod())) {
                restAPIMethods.addAll(Mappers.getProxyMethodMapper().map(method).values());
            }
        }
        proxyBuilder.methods(restAPIMethods);

        if (settings.shouldGenerateClientAsImpl()) {
            serviceClientName += "Impl";
        }

        builder.proxy(proxyBuilder.build())
                .serviceClientName(serviceClientName);

        builder.variableName(CodeNamer.toCamelCase(interfaceName));

        if (settings.isFluent() && settings.shouldGenerateClientInterfaces()) {
            interfaceName += "Client";
            builder.interfaceName(interfaceName);
        }

        builder.variableType(settings.shouldGenerateClientInterfaces() ? interfaceName : className);

        List<String> implementedInterfaces = new ArrayList<>();
        if (settings.shouldGenerateClientInterfaces()) {
            implementedInterfaces.add(interfaceName);
        }
        builder.implementedInterfaces(implementedInterfaces);

        String packageName;
        if (settings.isFluent()) {
            packageName = settings.getPackage(settings.shouldGenerateClientAsImpl() ? settings.getImplementationSubpackage() : settings.getFluentSubpackage());
        } else {
            boolean isCustomType = settings.isCustomType(className);
            packageName = settings.getPackage(isCustomType ? settings.getCustomTypesSubpackage() : (settings.shouldGenerateClientAsImpl() ? settings.getImplementationSubpackage() : null));
        }
        builder.packageName(packageName);

        List<ClientMethod> clientMethods = new ArrayList<>();
        for (Operation operation : methodGroup.getOperations()) {
            // "options" is not supported in HttpMethod in azure-core
            // https://github.com/Azure/autorest.java/issues/453
            if (!"options".equals(operation.getRequests().get(0).getProtocol().getHttp().getMethod())) {
                clientMethods.addAll(Mappers.getClientMethodMapper().map(operation));
            }
        }
        builder.clientMethods(clientMethods);
        builder.supportedInterfaces(supportedInterfaces(methodGroup, clientMethods));

        MethodGroupClient methodGroupClient = builder.build();

        parsed.put(methodGroup, methodGroupClient);

        return methodGroupClient;
    }

    protected MethodGroupClient.Builder createMethodGroupClientBuilder() {
        return new MethodGroupClient.Builder();
    }

    protected Proxy.Builder createProxyBuilder() {
        return new Proxy.Builder();
    }

    protected List<IType> supportedInterfaces(OperationGroup operationGroup, List<ClientMethod> clientMethods) {
        return Collections.emptyList();
    }
}
