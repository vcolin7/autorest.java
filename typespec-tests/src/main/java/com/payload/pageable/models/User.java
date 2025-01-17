// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.payload.pageable.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User model.
 */
@Immutable
public final class User {
    /*
     * User name
     */
    @Generated
    @JsonProperty(value = "name")
    private String name;

    /**
     * Creates an instance of User class.
     * 
     * @param name the name value to set.
     */
    @Generated
    @JsonCreator
    private User(@JsonProperty(value = "name") String name) {
        this.name = name;
    }

    /**
     * Get the name property: User name.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }
}
