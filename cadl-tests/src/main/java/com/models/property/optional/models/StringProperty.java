// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.models.property.optional.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Template type for testing models with optional property. Pass in the type of the property you are looking for. */
@Fluent
public final class StringProperty {
    /*
     * Property
     */
    @JsonProperty(value = "property")
    private String property;

    /** Creates an instance of StringProperty class. */
    public StringProperty() {}

    /**
     * Get the property property: Property.
     *
     * @return the property value.
     */
    public String getProperty() {
        return this.property;
    }

    /**
     * Set the property property: Property.
     *
     * @param property the property value to set.
     * @return the StringProperty object itself.
     */
    public StringProperty setProperty(String property) {
        this.property = property;
        return this;
    }
}
