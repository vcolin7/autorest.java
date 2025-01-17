// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.encode.bytes.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The DefaultBytesProperty model.
 */
@Immutable
public final class DefaultBytesProperty {
    /*
     * The value property.
     */
    @Generated
    @JsonProperty(value = "value")
    private byte[] value;

    /**
     * Creates an instance of DefaultBytesProperty class.
     * 
     * @param value the value value to set.
     */
    @Generated
    @JsonCreator
    public DefaultBytesProperty(@JsonProperty(value = "value") byte[] value) {
        this.value = value;
    }

    /**
     * Get the value property: The value property.
     * 
     * @return the value value.
     */
    @Generated
    public byte[] getValue() {
        return CoreUtils.clone(this.value);
    }
}
