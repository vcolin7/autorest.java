// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.extension.base.model.codemodel;

import java.util.ArrayList;
import java.util.List;

public class Client extends Metadata {

    private String summary;

    private List<OperationGroup> operationGroups = new ArrayList<OperationGroup>();

    private List<Parameter> globalParameters = new ArrayList<Parameter>();

    private Security security;

    private List<ApiVersion> apiVersions = new ArrayList<ApiVersion>();

    private ServiceVersion serviceVersion;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<OperationGroup> getOperationGroups() {
        return operationGroups;
    }

    public void setOperationGroups(List<OperationGroup> operationGroups) {
        this.operationGroups = operationGroups;
    }

    /**
     * all global parameters (ie, ImplementationLocation = client )
     *
     */
    public List<Parameter> getGlobalParameters() {
        return globalParameters;
    }

    /**
     * all global parameters (ie, ImplementationLocation = client )
     *
     */
    public void setGlobalParameters(List<Parameter> globalParameters) {
        this.globalParameters = globalParameters;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public List<ApiVersion> getApiVersions() {
        return apiVersions;
    }

    public void setApiVersions(List<ApiVersion> apiVersions) {
        this.apiVersions = apiVersions;
    }

    public ServiceVersion getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(ServiceVersion serviceVersion) {
        this.serviceVersion = serviceVersion;
    }
}
