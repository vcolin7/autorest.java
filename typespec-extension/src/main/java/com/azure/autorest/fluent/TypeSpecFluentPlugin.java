// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.fluent;

import com.azure.autorest.JavaSettingsAccessor;
import com.azure.autorest.TypeSpecPlugin;
import com.azure.autorest.extension.base.model.Message;
import com.azure.autorest.extension.base.model.codemodel.CodeModel;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.fluent.mapper.FluentMapper;
import com.azure.autorest.fluent.model.javamodel.FluentJavaPackage;
import com.azure.autorest.fluentnamer.FluentNamer;
import com.azure.autorest.mapper.Mappers;
import com.azure.autorest.model.clientmodel.Client;
import com.azure.core.util.CoreUtils;
import com.azure.typespec.model.EmitterOptions;
import com.azure.typespec.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeSpecFluentPlugin extends FluentGen {
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeSpecFluentPlugin.class);
    private final EmitterOptions emitterOptions;

    public TypeSpecFluentPlugin(EmitterOptions emitterOptions, boolean sdkIntegration) {
        super(new TypeSpecPlugin.MockConnection(), "dummy", "dummy");

        this.emitterOptions = emitterOptions;
        SETTINGS_MAP.put("namespace", emitterOptions.getNamespace());
        if (!CoreUtils.isNullOrEmpty(emitterOptions.getOutputDir())) {
            SETTINGS_MAP.put("output-folder", emitterOptions.getOutputDir());
        }
        if (!CoreUtils.isNullOrEmpty(emitterOptions.getServiceName())) {
            SETTINGS_MAP.put("service-name", emitterOptions.getServiceName());
        }
        if (emitterOptions.getGenerateSamples() != null) {
            SETTINGS_MAP.put("generate-samples", emitterOptions.getGenerateSamples());
        }
        if (emitterOptions.getGenerateTests() != null) {
            SETTINGS_MAP.put("generate-tests", emitterOptions.getGenerateTests());
        }
        if (emitterOptions.getArm()) {
            SETTINGS_MAP.put("fluent", "lite");
        }
        SETTINGS_MAP.put("sdk-integration", sdkIntegration);

        JavaSettingsAccessor.setHost(this);
        LOGGER.info("Output folder: {}", emitterOptions.getOutputDir());
        LOGGER.info("Namespace: {}", JavaSettings.getInstance().getPackage());
    }

    public Client processClient(CodeModel codeModel) {
        // transform code model
        FluentNamer fluentNamer = new TypeSpecFluentNamer(SETTINGS_MAP);
        codeModel = fluentNamer.transform(codeModel);

        // call FluentGen.handleMap
        Client client = handleMap(codeModel);

        return client;
    }

    public FluentJavaPackage processTemplates(CodeModel codeModel, Client client) {
        FluentJavaPackage javaPackage = handleTemplate(client);
        handleFluentLite(codeModel, client, javaPackage);
        return javaPackage;
    }

    @Override
    public void writeFile(String fileName, String content, List<Object> sourceMap) {
        File outputFile = FileUtil.writeToFile(emitterOptions.getOutputDir(), fileName, content);
        LOGGER.info("Write file: {}", outputFile.getAbsolutePath());
    }

    @Override
    protected FluentMapper getFluentMapper() {
        FluentMapper fluentMapper = super.getFluentMapper();
        Mappers.setFactory(new TypeSpecFluentMapperFactory());
        return fluentMapper;
    }

    private static final Map<String, Object> SETTINGS_MAP = new HashMap<>();

    // from fluentnamer/readme.md
    static {
        SETTINGS_MAP.put("data-plane", false);

        SETTINGS_MAP.put("sdk-integration", true);
        SETTINGS_MAP.put("regenerate-pom", true);

        SETTINGS_MAP.put("license-header", "MICROSOFT_MIT_SMALL_TYPESPEC");

        SETTINGS_MAP.put("generic-response-type", true);
        SETTINGS_MAP.put("generate-client-interfaces", true);
        SETTINGS_MAP.put("client-logger", true);

        SETTINGS_MAP.put("required-parameter-client-methods", true);
        SETTINGS_MAP.put("client-flattened-annotation-target", "none");
        SETTINGS_MAP.put("null-byte-array-maps-to-empty-array", true);
        SETTINGS_MAP.put("graal-vm-config", true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getValue(Type type, String key) {
        return (T) SETTINGS_MAP.get(key);
    }

    @Override
    public void message(Message message) {
        String log = message.getText();
        switch (message.getChannel()) {
            case INFORMATION:
                LOGGER.info(log);
                break;

            case WARNING:
                LOGGER.warn(log);
                break;

            case ERROR:
            case FATAL:
                LOGGER.error(log);
                break;

            case DEBUG:
                LOGGER.debug(log);
                break;

            default:
                LOGGER.info(log);
                break;
        }
    }
}
