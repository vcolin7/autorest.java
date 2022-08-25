// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.testserver.collectionpropertiesbasic.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Round-trip model with collection properties. */
@Fluent
public final class RoundTripModel {
    /*
     * Required collection of strings, illustrating a collection of reference types.
     */
    @JsonProperty(value = "requiredStringList", required = true)
    private List<String> requiredStringList;

    /*
     * Required collection of ints, illustrating a collection of value types.
     */
    @JsonProperty(value = "requiredIntList", required = true)
    private List<Long> requiredIntList;

    /**
     * Creates an instance of RoundTripModel class.
     *
     * @param requiredStringList the requiredStringList value to set.
     * @param requiredIntList the requiredIntList value to set.
     */
    @JsonCreator
    public RoundTripModel(
            @JsonProperty(value = "requiredStringList", required = true) List<String> requiredStringList,
            @JsonProperty(value = "requiredIntList", required = true) List<Long> requiredIntList) {
        this.requiredStringList = requiredStringList;
        this.requiredIntList = requiredIntList;
    }

    /**
     * Get the requiredStringList property: Required collection of strings, illustrating a collection of reference
     * types.
     *
     * @return the requiredStringList value.
     */
    public List<String> getRequiredStringList() {
        return this.requiredStringList;
    }

    /**
     * Get the requiredIntList property: Required collection of ints, illustrating a collection of value types.
     *
     * @return the requiredIntList value.
     */
    public List<Long> getRequiredIntList() {
        return this.requiredIntList;
    }
}