// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.literalservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Model model.
 */
@Fluent
public final class Model {
    /*
     * The literal property.
     */
    @Generated
    @JsonProperty(value = "literal")
    private String literal = "literal";

    /*
     * The optionalLiteral property.
     */
    @Generated
    @JsonProperty(value = "optionalLiteral")
    private ModelOptionalLiteral optionalLiteral;

    /**
     * Creates an instance of Model class.
     */
    @Generated
    public Model() {
    }

    /**
     * Get the literal property: The literal property.
     * 
     * @return the literal value.
     */
    @Generated
    public String getLiteral() {
        return this.literal;
    }

    /**
     * Get the optionalLiteral property: The optionalLiteral property.
     * 
     * @return the optionalLiteral value.
     */
    @Generated
    public ModelOptionalLiteral getOptionalLiteral() {
        return this.optionalLiteral;
    }

    /**
     * Set the optionalLiteral property: The optionalLiteral property.
     * 
     * @param optionalLiteral the optionalLiteral value to set.
     * @return the Model object itself.
     */
    @Generated
    public Model setOptionalLiteral(ModelOptionalLiteral optionalLiteral) {
        this.optionalLiteral = optionalLiteral;
        return this;
    }
}
