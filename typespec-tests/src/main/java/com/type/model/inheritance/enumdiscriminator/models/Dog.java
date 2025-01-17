// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.type.model.inheritance.enumdiscriminator.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Test extensible enum type for discriminator.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "kind",
    defaultImpl = Dog.class)
@JsonTypeName("Dog")
@JsonSubTypes({ @JsonSubTypes.Type(name = "golden", value = Golden.class) })
@Immutable
public class Dog {
    /*
     * Weight of the dog
     */
    @Generated
    @JsonProperty(value = "weight")
    private int weight;

    /**
     * Creates an instance of Dog class.
     * 
     * @param weight the weight value to set.
     */
    @Generated
    @JsonCreator
    public Dog(@JsonProperty(value = "weight") int weight) {
        this.weight = weight;
    }

    /**
     * Get the weight property: Weight of the dog.
     * 
     * @return the weight value.
     */
    @Generated
    public int getWeight() {
        return this.weight;
    }
}
