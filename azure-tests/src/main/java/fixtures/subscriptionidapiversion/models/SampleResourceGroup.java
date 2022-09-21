// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.subscriptionidapiversion.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The SampleResourceGroup model. */
@Fluent
public final class SampleResourceGroup {
    /*
     * resource group name 'testgroup101'
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * resource group location 'West US'
     */
    @JsonProperty(value = "location")
    private String location;

    /** Creates an instance of SampleResourceGroup class. */
    public SampleResourceGroup() {}

    /**
     * Get the name property: resource group name 'testgroup101'.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: resource group name 'testgroup101'.
     *
     * @param name the name value to set.
     * @return the SampleResourceGroup object itself.
     */
    public SampleResourceGroup setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the location property: resource group location 'West US'.
     *
     * @return the location value.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Set the location property: resource group location 'West US'.
     *
     * @param location the location value to set.
     * @return the SampleResourceGroup object itself.
     */
    public SampleResourceGroup setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {}
}
