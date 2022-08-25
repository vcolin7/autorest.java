// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.testserver.modelcollectionproperties.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Simple model with model collection properties. */
@Fluent
public final class ModelCollectionModel {
    /*
     * Required collection of models.
     */
    @JsonProperty(value = "requiredModelCollection", required = true)
    private List<SimpleModel> requiredModelCollection;

    /*
     * Optional collection of models.
     */
    @JsonProperty(value = "optionalModelCollection")
    private List<SimpleModel> optionalModelCollection;

    /**
     * Creates an instance of ModelCollectionModel class.
     *
     * @param requiredModelCollection the requiredModelCollection value to set.
     */
    @JsonCreator
    public ModelCollectionModel(
            @JsonProperty(value = "requiredModelCollection", required = true)
                    List<SimpleModel> requiredModelCollection) {
        this.requiredModelCollection = requiredModelCollection;
    }

    /**
     * Get the requiredModelCollection property: Required collection of models.
     *
     * @return the requiredModelCollection value.
     */
    public List<SimpleModel> getRequiredModelCollection() {
        return this.requiredModelCollection;
    }

    /**
     * Get the optionalModelCollection property: Optional collection of models.
     *
     * @return the optionalModelCollection value.
     */
    public List<SimpleModel> getOptionalModelCollection() {
        return this.optionalModelCollection;
    }

    /**
     * Set the optionalModelCollection property: Optional collection of models.
     *
     * @param optionalModelCollection the optionalModelCollection value to set.
     * @return the ModelCollectionModel object itself.
     */
    public ModelCollectionModel setOptionalModelCollection(List<SimpleModel> optionalModelCollection) {
        this.optionalModelCollection = optionalModelCollection;
        return this;
    }
}