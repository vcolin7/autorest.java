// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.requiredfieldsascotrargstransformation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The TransformationAsParentRequiredFields model. */
@Fluent
public final class TransformationAsParentRequiredFields extends TransformationAsRequiredFields {
    /*
     * The rfc1123RequiredChild property.
     */
    @JsonProperty(value = "rfc1123RequiredChild", required = true)
    private DateTimeRfc1123 rfc1123RequiredChild;

    /*
     * The rfc1123NonRequiredChild property.
     */
    @JsonProperty(value = "rfc1123NonRequiredChild")
    private DateTimeRfc1123 rfc1123NonRequiredChild;

    /**
     * Creates an instance of TransformationAsParentRequiredFields class.
     *
     * @param rfc1123Required the rfc1123Required value to set.
     * @param nameRequired the nameRequired value to set.
     * @param urlBase64EncodedRequired the urlBase64EncodedRequired value to set.
     * @param unixTimeLongRequired the unixTimeLongRequired value to set.
     * @param unixTimeDateTimeRequired the unixTimeDateTimeRequired value to set.
     * @param rfc1123RequiredChild the rfc1123RequiredChild value to set.
     */
    @JsonCreator
    public TransformationAsParentRequiredFields(
            @JsonProperty(value = "rfc1123Required", required = true) OffsetDateTime rfc1123Required,
            @JsonProperty(value = "nameRequired", required = true) String nameRequired,
            @JsonProperty(value = "urlBase64EncodedRequired", required = true) byte[] urlBase64EncodedRequired,
            @JsonProperty(value = "unixTimeLongRequired", required = true) OffsetDateTime unixTimeLongRequired,
            @JsonProperty(value = "unixTimeDateTimeRequired", required = true) OffsetDateTime unixTimeDateTimeRequired,
            @JsonProperty(value = "rfc1123RequiredChild", required = true) OffsetDateTime rfc1123RequiredChild) {
        super(rfc1123Required, nameRequired, urlBase64EncodedRequired, unixTimeLongRequired, unixTimeDateTimeRequired);
        this.rfc1123RequiredChild = new DateTimeRfc1123(rfc1123RequiredChild);
    }

    /**
     * Get the rfc1123RequiredChild property: The rfc1123RequiredChild property.
     *
     * @return the rfc1123RequiredChild value.
     */
    public OffsetDateTime getRfc1123RequiredChild() {
        if (this.rfc1123RequiredChild == null) {
            return null;
        }
        return this.rfc1123RequiredChild.getDateTime();
    }

    /**
     * Get the rfc1123NonRequiredChild property: The rfc1123NonRequiredChild property.
     *
     * @return the rfc1123NonRequiredChild value.
     */
    public OffsetDateTime getRfc1123NonRequiredChild() {
        if (this.rfc1123NonRequiredChild == null) {
            return null;
        }
        return this.rfc1123NonRequiredChild.getDateTime();
    }

    /**
     * Set the rfc1123NonRequiredChild property: The rfc1123NonRequiredChild property.
     *
     * @param rfc1123NonRequiredChild the rfc1123NonRequiredChild value to set.
     * @return the TransformationAsParentRequiredFields object itself.
     */
    public TransformationAsParentRequiredFields setRfc1123NonRequiredChild(OffsetDateTime rfc1123NonRequiredChild) {
        if (rfc1123NonRequiredChild == null) {
            this.rfc1123NonRequiredChild = null;
        } else {
            this.rfc1123NonRequiredChild = new DateTimeRfc1123(rfc1123NonRequiredChild);
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public TransformationAsParentRequiredFields setRfc1123NonRequired(OffsetDateTime rfc1123NonRequired) {
        super.setRfc1123NonRequired(rfc1123NonRequired);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (getRfc1123RequiredChild() == null) {
            throw new IllegalArgumentException(
                    "Missing required property rfc1123RequiredChild in model TransformationAsParentRequiredFields");
        }
    }
}