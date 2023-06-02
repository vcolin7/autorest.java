// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.type.property.nullable.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Template type for testing models with nullable property. Pass in the type of the property you are looking for. */
@Immutable
public final class BytesProperty {
    /*
     * Required property
     */
    @Generated
    @JsonProperty(value = "requiredProperty", required = true)
    private String requiredProperty;

    /*
     * Property
     */
    @Generated
    @JsonProperty(value = "nullableProperty", required = true)
    private byte[] nullableProperty;

    /**
     * Creates an instance of BytesProperty class.
     *
     * @param requiredProperty the requiredProperty value to set.
     * @param nullableProperty the nullableProperty value to set.
     */
    @Generated
    @JsonCreator
    public BytesProperty(
            @JsonProperty(value = "requiredProperty", required = true) String requiredProperty,
            @JsonProperty(value = "nullableProperty", required = true) byte[] nullableProperty) {
        this.requiredProperty = requiredProperty;
        this.nullableProperty = nullableProperty;
    }

    /**
     * Get the requiredProperty property: Required property.
     *
     * @return the requiredProperty value.
     */
    @Generated
    public String getRequiredProperty() {
        return this.requiredProperty;
    }

    /**
     * Get the nullableProperty property: Property.
     *
     * @return the nullableProperty value.
     */
    @Generated
    public byte[] getNullableProperty() {
        return CoreUtils.clone(this.nullableProperty);
    }
}
