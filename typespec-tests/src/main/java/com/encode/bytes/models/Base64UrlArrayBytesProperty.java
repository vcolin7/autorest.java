// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.encode.bytes.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.Base64Url;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The Base64UrlArrayBytesProperty model.
 */
@Immutable
public final class Base64UrlArrayBytesProperty {

    /*
     * The value property.
     */
    @Generated
    @JsonProperty(value = "value")
    private List<Base64Url> value;

    /**
     * Creates an instance of Base64UrlArrayBytesProperty class.
     *
     * @param value the value value to set.
     */
    @Generated
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    public Base64UrlArrayBytesProperty(@JsonProperty(value = "value") List<byte[]> value) {
        this.value = value.stream().map(el -> Base64Url.encode(el)).collect(java.util.stream.Collectors.toList());
    }

    @Generated
    private Base64UrlArrayBytesProperty() {
    }

    /**
     * Get the value property: The value property.
     *
     * @return the value value.
     */
    @Generated
    public List<byte[]> getValue() {
        if (this.value == null) {
            return null;
        }
        return this.value.stream().map(el -> el.decodedBytes()).collect(java.util.stream.Collectors.toList());
    }
}
