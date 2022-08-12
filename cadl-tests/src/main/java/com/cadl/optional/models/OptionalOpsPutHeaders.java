// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.optional.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.http.HttpHeaders;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The OptionalOpsPutHeaders model. */
@Fluent
public final class OptionalOpsPutHeaders {
    /*
     * The header-required property.
     */
    @JsonProperty(value = "header-required")
    private String headerRequired;

    /*
     * The header-optional property.
     */
    @JsonProperty(value = "header-optional")
    private String headerOptional;

    // HttpHeaders containing the raw property values.
    /**
     * Creates an instance of OptionalOpsPutHeaders class.
     *
     * @param rawHeaders The raw HttpHeaders that will be used to create the property values.
     */
    public OptionalOpsPutHeaders(HttpHeaders rawHeaders) {
        this.headerRequired = rawHeaders.getValue("header-required");
        this.headerOptional = rawHeaders.getValue("header-optional");
    }

    /**
     * Get the headerRequired property: The header-required property.
     *
     * @return the headerRequired value.
     */
    public String getHeaderRequired() {
        return this.headerRequired;
    }

    /**
     * Set the headerRequired property: The header-required property.
     *
     * @param headerRequired the headerRequired value to set.
     * @return the OptionalOpsPutHeaders object itself.
     */
    public OptionalOpsPutHeaders setHeaderRequired(String headerRequired) {
        this.headerRequired = headerRequired;
        return this;
    }

    /**
     * Get the headerOptional property: The header-optional property.
     *
     * @return the headerOptional value.
     */
    public String getHeaderOptional() {
        return this.headerOptional;
    }

    /**
     * Set the headerOptional property: The header-optional property.
     *
     * @param headerOptional the headerOptional value to set.
     * @return the OptionalOpsPutHeaders object itself.
     */
    public OptionalOpsPutHeaders setHeaderOptional(String headerOptional) {
        this.headerOptional = headerOptional;
        return this;
    }
}