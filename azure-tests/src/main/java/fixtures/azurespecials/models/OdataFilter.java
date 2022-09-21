// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.azurespecials.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The OdataFilter model. */
@Fluent
public final class OdataFilter {
    /*
     * The id property.
     */
    @JsonProperty(value = "id")
    private Integer id;

    /*
     * The name property.
     */
    @JsonProperty(value = "name")
    private String name;

    /** Creates an instance of OdataFilter class. */
    public OdataFilter() {}

    /**
     * Get the id property: The id property.
     *
     * @return the id value.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Set the id property: The id property.
     *
     * @param id the id value to set.
     * @return the OdataFilter object itself.
     */
    public OdataFilter setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: The name property.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     *
     * @param name the name value to set.
     * @return the OdataFilter object itself.
     */
    public OdataFilter setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {}
}
