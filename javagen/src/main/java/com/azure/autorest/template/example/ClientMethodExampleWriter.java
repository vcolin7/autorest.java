// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.template.example;

import com.azure.autorest.model.clientmodel.ClassType;
import com.azure.autorest.model.clientmodel.ClientMethod;
import com.azure.autorest.model.clientmodel.ClientMethodParameter;
import com.azure.autorest.model.clientmodel.ClientModel;
import com.azure.autorest.model.clientmodel.ClientModelProperty;
import com.azure.autorest.model.clientmodel.EnumType;
import com.azure.autorest.model.clientmodel.GenericType;
import com.azure.autorest.model.clientmodel.IType;
import com.azure.autorest.model.clientmodel.ListType;
import com.azure.autorest.model.clientmodel.MethodTransformationDetail;
import com.azure.autorest.model.clientmodel.ParameterMapping;
import com.azure.autorest.model.clientmodel.PrimitiveType;
import com.azure.autorest.model.clientmodel.ProxyMethodExample;
import com.azure.autorest.model.clientmodel.examplemodel.ExampleHelperFeature;
import com.azure.autorest.model.clientmodel.examplemodel.ExampleNode;
import com.azure.autorest.model.clientmodel.examplemodel.MethodParameter;
import com.azure.autorest.model.javamodel.JavaBlock;
import com.azure.autorest.model.javamodel.JavaFileContents;
import com.azure.autorest.util.ClientModelUtil;
import com.azure.autorest.util.CodeNamer;
import com.azure.autorest.util.MethodUtil;
import com.azure.autorest.util.ModelExampleUtil;
import com.azure.core.http.ContentType;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.polling.SyncPoller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ClientMethodExampleWriter {

    private final Set<String> imports = new HashSet<>();
    private final Consumer<JavaBlock> methodBodyWriter;
    private final Consumer<JavaBlock> responseAssertionWriter;
    private final ModelExampleWriter.ExampleNodeModelInitializationVisitor nodeVisitor = new ModelExampleWriter.ExampleNodeModelInitializationVisitor();

    public ClientMethodExampleWriter(ClientMethod method, String clientVarName, ProxyMethodExample proxyMethodExample){

        List<MethodParameter> methodParameters = MethodUtil.getParameters(method, true);
        List<ExampleNode> exampleNodes = methodParameters
                .stream()
                .map(methodParameter -> parseNodeFromParameter(method, proxyMethodExample, methodParameter))
                .collect(Collectors.toList());

        String parameterInvocations = exampleNodes.stream()
                .map(nodeVisitor::accept)
                .collect(Collectors.joining(", "));

        this.imports.add("org.junit.jupiter.api.Assertions");
        method.getReturnValue().getType().addImportsTo(imports, false);

        StringBuilder methodInvocation = new StringBuilder();

        if (method.getReturnValue().getType().asNullable() != ClassType.Void) {
            String assignment = String.format("%s %s = ", method.getReturnValue().getType(), "response");
            methodInvocation.append(assignment);
        }

        methodInvocation.append(
                String.format("%s.%s(%s);",
                        clientVarName,
                        method.getName(),
                        parameterInvocations));

        methodBodyWriter = methodBlock -> {
            methodBlock.line(methodInvocation.toString());
        };
        responseAssertionWriter = methodBlock -> {
            Optional<ProxyMethodExample.Response> responseOpt = proxyMethodExample.getPrimaryResponse();
            if (responseOpt.isPresent()) {
                ProxyMethodExample.Response response = responseOpt.get();
                IType returnType = method.getReturnValue().getType();
                if (returnType instanceof GenericType) {
                    GenericType responseType = (GenericType) returnType;
                    if (SyncPoller.class.getSimpleName().equals(responseType.getName())) {
                        // SyncPoller<>

                        if (response.getStatusCode() / 100 == 2) {
                            methodBlock.line();
                            methodBlock.line("// response assertion");
                            // it should have a 202 leading to SUCCESSFULLY_COMPLETED
                            // but x-ms-examples usually does not include the final result
                            methodBlock.line("Assertions.assertEquals(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED, response.waitForCompletion().getStatus());");
                        }
                    } else if (PagedIterable.class.getSimpleName().equals(responseType.getName())) {
                        // PagedIterable<>

                        methodBlock.line();
                        methodBlock.line("// response assertion");
                        // assert status code
                        methodBlock.line(String.format("Assertions.assertEquals(%1$s, response.iterableByPage().iterator().next().getStatusCode());", response.getStatusCode()));
                        // assert headers
                        response.getHttpHeaders().stream().forEach(header -> {
                            String expectedValueStr = ClassType.String.defaultValueExpression(header.getValue());
                            String keyStr = ClassType.String.defaultValueExpression(header.getName());
                            methodBlock.line(String.format("Assertions.assertEquals(%1$s, response.iterableByPage().iterator().next().getHeaders().get(HttpHeaderName.fromString(%2$s)).getValue());", expectedValueStr, keyStr));
                        });
                        // assert JSON of first item, or assert count=0
                        if (method.getProxyMethod().getResponseContentTypes() != null
                                && method.getProxyMethod().getResponseContentTypes().contains(ContentType.APPLICATION_JSON)
                                && responseType.getTypeArguments().length > 0
                                && ClientModelUtil.isClientModel(responseType.getTypeArguments()[0])
                                && method.getMethodPageDetails() != null
                                && response.getBody() instanceof Map) {
                            Map<String, Object> bodyMap = (Map<String, Object>) response.getBody();
                            if (bodyMap.containsKey(method.getMethodPageDetails().getSerializedItemName())) {
                                Object items = bodyMap.get(method.getMethodPageDetails().getSerializedItemName());
                                if (items instanceof List) {
                                    List<Object> itemArray = (List<Object>) items;
                                    if (itemArray.isEmpty()) {
                                        methodBlock.line("Assertions.assertEquals(0, response.stream().count());");
                                    } else {
                                        Object firstItem = itemArray.iterator().next();
                                        methodBlock.line("%s firstItem = %s;", responseType.getTypeArguments()[0], "response.iterator().next()");
                                        writeModelAssertion(methodBlock, nodeVisitor, responseType.getTypeArguments()[0], responseType.getTypeArguments()[0], firstItem, "firstItem", true);
                                    }
                                }
                            }
                        }
                    }
                } else if (ClassType.Boolean.equals(returnType.asNullable()) && HttpMethod.HEAD.equals(method.getProxyMethod().getHttpMethod())) {
                    methodBlock.line();
                    methodBlock.line("// response assertion");
                    if (response.getStatusCode() == 200) {
                        methodBlock.line("Assertions.assertTrue(response);");
                    } else if (response.getStatusCode() == 404) {
                        methodBlock.line("Assertions.assertFalse(response)");
                    }
                } else if (!ClassType.Void.equals(returnType.asNullable())){
                    methodBlock.line();
                    methodBlock.line("// response assertion");
                    writeModelAssertion(methodBlock, nodeVisitor, returnType, returnType, response.getBody(), "response", true);
                }
            } else {
                methodBlock.line();
                methodBlock.line("// response assertion");
                methodBlock.line("Assertions.assertNotNull(response);");
            }
        };

        addNecessaryImports();
    }

    private void addNecessaryImports() {
        // write dummy, allow nodeVisitor to collect all necessary imports
        responseAssertionWriter.accept(new JavaBlock(new JavaFileContents()));
        this.imports.addAll(nodeVisitor.getImports());
    }

    /**
     * Write assertions for the given model and its example value.
     *
     * @param methodBlock the method block to write assertions to
     * @param nodeVisitor node visitor for example values
     * @param modelClientType client type of the model
     * @param modelWireType wire type of the model
     * @param modelValue example value of the model
     * @param modelReference reference of the model that can be used to access the model in generated code
     * @param rootModel whether the model is in the root of the response
     */
    private void writeModelAssertion(JavaBlock methodBlock, ModelExampleWriter.ExampleNodeModelInitializationVisitor nodeVisitor,
                                     IType modelClientType, IType modelWireType, Object modelValue, String modelReference, boolean rootModel) {
        if (modelValue != null) {
            modelClientType.addImportsTo(this.imports, false);
            if (modelWireType != null) {
                modelWireType.addImportsTo(this.imports, false);
            }
            if (isClientModel(modelClientType, modelValue)) {
                methodBlock.line("Assertions.assertNotNull(%s);", modelReference);
                // Client Model
                ClassType modelClassType = (ClassType) modelClientType;
                ClientModel clientModel = ClientModelUtil.getClientModel(modelClassType.getName());
                if (clientModel.getProperties() != null) {
                    for (ClientModelProperty property : clientModel.getProperties()) {
                        String serializedName = property.getSerializedName();
                        Object propertyValue = ((Map) modelValue).get(serializedName);
                        if (propertyValue != null) {
                            if (rootModel) {
                                methodBlock.line("// verify property \"%s\"", property.getName());
                            }
                            String propertyGetter = String.format("%s.%s()", modelReference, property.getGetterName());
                            if (isClientModel(property.getClientType(), propertyValue) || isList(property.getClientType(), propertyValue)) {
                                String propertyReference = String.format("%s%s", modelReference, CodeNamer.toPascalCase(property.getName()));
                                methodBlock.line("%s %s = %s;", property.getClientType(), propertyReference, propertyGetter);
                                writeModelAssertion(methodBlock, nodeVisitor, property.getClientType(), property.getWireType(), propertyValue, propertyReference, false);
                            } else {
                                writeModelAssertion(methodBlock, nodeVisitor, property.getClientType(), property.getWireType(), propertyValue, propertyGetter, false);
                            }
                        }
                    }
                }
            } else if (isList(modelClientType, modelValue)) {
                // List
                List<Object> values = (List<Object>) modelValue;
                if (values.size() > 0) {
                    ListType listType = (ListType) modelClientType;
                    IType elementType = listType.getElementType();
                    Object firstItemValue = values.iterator().next();
                    if (firstItemValue != null) {
                        String firstItemGetter = String.format("%s.iterator().next()", modelReference);
                        if (isClientModel(elementType, firstItemValue) || isList(elementType, firstItemValue)) {
                            String firstItemReference = String.format("%s%s", modelReference, "FirstItem");
                            methodBlock.line("%s %s = %s;", elementType, firstItemReference, firstItemGetter);
                            writeModelAssertion(methodBlock, nodeVisitor, elementType, elementType, values.iterator().next(), firstItemReference, rootModel);
                        } else {
                            writeModelAssertion(methodBlock, nodeVisitor, elementType, elementType, values.iterator().next(), firstItemGetter, rootModel);
                        }
                    }
                } else {
                    methodBlock.line("Assertions.assertEquals(0, %s);", String.format("%s.size()", modelReference));
                }
            } else if (modelClientType instanceof PrimitiveType || modelClientType instanceof EnumType
                    || ClassType.String.equals(modelClientType) || ClassType.URL.equals(modelClientType)
                    || (modelClientType instanceof ClassType && ((ClassType) modelClientType).isBoxedType())) {
                // simple models that can be compared by "Assertions.assertEquals()"
                methodBlock.line(String.format(
                        "Assertions.assertEquals(%s, %s);",
                        nodeVisitor.accept(ModelExampleUtil.parseNode(modelClientType, modelWireType, modelValue)),
                        modelReference
                ));
            } else {
                methodBlock.line("Assertions.assertNotNull(%s);", modelReference);
            }
        }
    }

    private boolean isList(IType modelClientType, Object modelValue) {
        return modelClientType instanceof ListType && modelValue instanceof List;
    }

    private boolean isClientModel(IType modelClientType, Object modelValue) {
        return modelClientType instanceof ClassType
                && ClientModelUtil.isClientModel(modelClientType)
                && modelValue instanceof Map;
    }

    /**
     * Parse example node from given parameter, taking into account parameter grouping.
     *
     * @param convenienceMethod the convenience method to generate example for
     * @param proxyMethodExample the proxy method example
     * @param methodParameter mapped convenience method parameter to protocol(proxy) method parameter
     * @return example node
     */
    private ExampleNode parseNodeFromParameter(ClientMethod convenienceMethod, ProxyMethodExample proxyMethodExample, MethodParameter methodParameter) {
        if (isGroupingParameter(convenienceMethod, methodParameter)) {
            // grouping, possible with flattening first

            // group example values into a map
            Map<String, Object> exampleValue = new HashMap<>();
            for (MethodTransformationDetail detail : convenienceMethod.getMethodTransformationDetails()) {
                for (ParameterMapping parameterMapping : detail.getParameterMappings()) {
                    if (parameterMapping.getOutputParameterPropertyName() != null) {
                        // this is a flattened property, so put flattening(real parameter) value

                        // output parameter's name is the "escaped reserved client method parameter name" of the real parameter's serialized name
                        // since flattened parameter is always in body, we can deal with that explicitly
                        ClientMethodParameter outputParameter = detail.getOutParameter();
                        Map<String, Object> flattenedParameterValue = getFlattenedBodyParameterExampleValue(proxyMethodExample, outputParameter.getName());
                        if (flattenedParameterValue != null) {
                            exampleValue.putAll(flattenedParameterValue);
                        }
                        // since it's flattened property, all parameterMappings share the same outputParameter(real parameter)
                        // we only need to put example value once, which is the flattened(real) parameter's value
                        break;
                    } else {
                        // Group property's "serializedName" is the real parameter's "serializedName" on the wire.
                        // This implicit equivalence is defined in emitter and preserved in mapping client method.
                        String serializedParameterName = parameterMapping.getInputParameterProperty().getSerializedName();
                        ClientMethodParameter parameter = detail.getOutParameter();
                        exampleValue.put(serializedParameterName,
                                ModelExampleUtil.getParameterExampleValue(
                                        proxyMethodExample, serializedParameterName, parameter.getRequestParameterLocation()));
                    }
                }
            }
            IType type = methodParameter.getClientMethodParameter().getClientType();
            IType wireType = methodParameter.getClientMethodParameter().getWireType();
            return ModelExampleUtil.parseNode(type, wireType, exampleValue);
        } else if (isFlattenParameter(convenienceMethod, methodParameter)) {
            // flatten, no grouping
            String outputParameterName = convenienceMethod.getMethodTransformationDetails().iterator().next().getOutParameter().getName();
            Map<String, Object> realParameterValue = getFlattenedBodyParameterExampleValue(proxyMethodExample, outputParameterName);

            IType type = methodParameter.getClientMethodParameter().getClientType();
            IType wireType = methodParameter.getClientMethodParameter().getWireType();

            ParameterMapping parameterMapping = convenienceMethod.getMethodTransformationDetails().iterator().next()
                    .getParameterMappings()
                    .stream()
                    .filter(mapping -> Objects.equals(mapping.getInputParameter().getName(), methodParameter.getClientMethodParameter().getName()))
                    .findFirst().orElse(null);

            Object methodParameterValue = null;
            if (realParameterValue != null && parameterMapping != null) {
                methodParameterValue = realParameterValue.get(parameterMapping.getOutputParameterProperty().getSerializedName());
            }
            return ModelExampleUtil.parseNode(type, wireType, methodParameterValue);
        } else {
            return ModelExampleUtil.parseNodeFromParameter(proxyMethodExample, methodParameter);
        }
    }

    private Map<String, Object> getFlattenedBodyParameterExampleValue(ProxyMethodExample example, String clientMethodParameterName) {
        ProxyMethodExample.ParameterValue parameterValue = example.getParameters().entrySet()
                .stream().filter(
                        p -> CodeNamer.getEscapedReservedClientMethodParameterName(p.getKey())
                                .equalsIgnoreCase(clientMethodParameterName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
        if (parameterValue == null) {
            return null;
        }
        return (Map<String, Object>) parameterValue.getObjectValue();
    }

    private boolean isGroupingParameter(ClientMethod convenienceMethod, MethodParameter methodParameter) {
        List<MethodTransformationDetail> details = convenienceMethod.getMethodTransformationDetails();
        if (CoreUtils.isNullOrEmpty(details) || details.size() <= 1) {
            return false;
        }

        return details.stream().allMatch(
                detail ->
                        !CoreUtils.isNullOrEmpty(detail.getParameterMappings())
                                && detail.getOutParameter() != null
                                &&
                                // same name
                                detail.getParameterMappings()
                                        .stream()
                                        .allMatch(mapping -> Objects.equals(
                                                mapping.getInputParameter().getName(),
                                                methodParameter.getClientMethodParameter().getName()))
        );
    }

    private boolean isFlattenParameter(ClientMethod convenienceMethod, MethodParameter methodParameter) {
        List<MethodTransformationDetail> details = convenienceMethod.getMethodTransformationDetails();
        if (CoreUtils.isNullOrEmpty(details) || details.size() != 1) {
            return false;
        }
        return details.stream().anyMatch(
                detail ->
                        !CoreUtils.isNullOrEmpty(detail.getParameterMappings())
                                && detail.getOutParameter() != null
                                && detail.getParameterMappings().stream()
                                .allMatch(mapping -> mapping.getOutputParameterPropertyName() != null
                                        && mapping.getInputParameterProperty() == null)
                        && detail.getParameterMappings()
                                .stream()
                                .anyMatch(mapping -> Objects.equals(methodParameter.getClientMethodParameter().getName(), mapping.getInputParameter().getName()))
        );
    }

    public Set<String> getImports() {
        return new HashSet<>(this.imports);
    }

    public void writeMethodInvocation(JavaBlock javaBlock) {
        methodBodyWriter.accept(javaBlock);
    }

    public Set<ExampleHelperFeature> getHelperFeatures() {
        return new HashSet<>(nodeVisitor.getHelperFeatures());
    }

    public void writeResponseAssertion(JavaBlock methodBlock) {
        responseAssertionWriter.accept(methodBlock);
    }
}
