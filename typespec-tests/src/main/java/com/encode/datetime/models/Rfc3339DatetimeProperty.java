// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.encode.datetime.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * The Rfc3339DatetimeProperty model.
 */
@Immutable
public final class Rfc3339DatetimeProperty {
    /*
     * The value property.
     */
    @Generated
    @JsonProperty(value = "value")
    private OffsetDateTime value;

    /**
     * Creates an instance of Rfc3339DatetimeProperty class.
     * 
     * @param value the value value to set.
     */
    @Generated
    @JsonCreator
    public Rfc3339DatetimeProperty(@JsonProperty(value = "value") OffsetDateTime value) {
        this.value = value;
    }

    /**
     * Get the value property: The value property.
     * 
     * @return the value value.
     */
    @Generated
    public OffsetDateTime getValue() {
        return this.value;
    }
}
