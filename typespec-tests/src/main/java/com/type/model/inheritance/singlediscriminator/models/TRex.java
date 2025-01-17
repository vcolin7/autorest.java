// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.type.model.inheritance.singlediscriminator.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The second level legacy model in polymorphic single level inheritance.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonTypeName("t-rex")
@Immutable
public final class TRex extends Dinosaur {
    /**
     * Creates an instance of TRex class.
     * 
     * @param size the size value to set.
     */
    @Generated
    @JsonCreator
    private TRex(@JsonProperty(value = "size") int size) {
        super(size);
    }
}
