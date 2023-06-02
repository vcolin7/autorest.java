// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.dpgcustomization.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Product model. */
@Immutable
public class Product {
    /*
     * The received property.
     */
    @Generated
    @JsonProperty(value = "received", required = true)
    private ProductReceived received;

    /**
     * Creates an instance of Product class.
     *
     * @param received the received value to set.
     */
    @Generated
    @JsonCreator
    public Product(@JsonProperty(value = "received", required = true) ProductReceived received) {
        this.received = received;
    }

    /**
     * Get the received property: The received property.
     *
     * @return the received value.
     */
    @Generated
    public ProductReceived getReceived() {
        return this.received;
    }
}
