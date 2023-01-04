// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.containers.containerregistry.implementation.models;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.ResponseBase;

/** Contains all response data for the createManifest operation. */
public final class ContainerRegistriesCreateManifestResponse
        extends ResponseBase<ContainerRegistriesCreateManifestHeaders, Void> {
    /**
     * Creates an instance of ContainerRegistriesCreateManifestResponse.
     *
     * @param request the request which resulted in this ContainerRegistriesCreateManifestResponse.
     * @param statusCode the status code of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param value the deserialized value of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     */
    public ContainerRegistriesCreateManifestResponse(
            HttpRequest request,
            int statusCode,
            HttpHeaders rawHeaders,
            Void value,
            ContainerRegistriesCreateManifestHeaders headers) {
        super(request, statusCode, rawHeaders, value, headers);
    }
}