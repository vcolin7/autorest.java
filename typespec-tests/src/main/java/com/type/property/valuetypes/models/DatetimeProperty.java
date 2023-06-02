// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.type.property.valuetypes.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Model with a datetime property. */
@Immutable
public final class DatetimeProperty {
    /*
     * Property
     */
    @Generated
    @JsonProperty(value = "property", required = true)
    private OffsetDateTime property;

    /**
     * Creates an instance of DatetimeProperty class.
     *
     * @param property the property value to set.
     */
    @Generated
    @JsonCreator
    public DatetimeProperty(@JsonProperty(value = "property", required = true) OffsetDateTime property) {
        this.property = property;
    }

    /**
     * Get the property property: Property.
     *
     * @return the property value.
     */
    @Generated
    public OffsetDateTime getProperty() {
        return this.property;
    }
}
