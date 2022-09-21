// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.builtin.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.Base64Url;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** The FormatString model. */
@Immutable
public final class FormatString {
    /*
     * The base64Encoded property.
     */
    @JsonProperty(value = "base64Encoded", required = true)
    private Base64Url base64Encoded;

    /*
     * The binary property.
     */
    @JsonProperty(value = "binary", required = true)
    private byte[] binary;

    /*
     * The dateTime property.
     */
    @JsonProperty(value = "dateTime", required = true)
    private OffsetDateTime dateTime;

    /*
     * The dateTimeRfc1123 property.
     */
    @JsonProperty(value = "dateTimeRfc1123", required = true)
    private DateTimeRfc1123 dateTimeRfc1123;

    /*
     * The password property.
     */
    @JsonProperty(value = "password", required = true)
    private String password;

    /**
     * Creates an instance of FormatString class.
     *
     * @param base64Encoded the base64Encoded value to set.
     * @param binary the binary value to set.
     * @param dateTime the dateTime value to set.
     * @param dateTimeRfc1123 the dateTimeRfc1123 value to set.
     * @param password the password value to set.
     */
    @JsonCreator
    private FormatString(
            @JsonProperty(value = "base64Encoded", required = true) byte[] base64Encoded,
            @JsonProperty(value = "binary", required = true) byte[] binary,
            @JsonProperty(value = "dateTime", required = true) OffsetDateTime dateTime,
            @JsonProperty(value = "dateTimeRfc1123", required = true) OffsetDateTime dateTimeRfc1123,
            @JsonProperty(value = "password", required = true) String password) {
        this.base64Encoded = Base64Url.encode(base64Encoded);
        this.binary = binary;
        this.dateTime = dateTime;
        this.dateTimeRfc1123 = new DateTimeRfc1123(dateTimeRfc1123);
        this.password = password;
    }

    /**
     * Get the base64Encoded property: The base64Encoded property.
     *
     * @return the base64Encoded value.
     */
    public byte[] getBase64Encoded() {
        if (this.base64Encoded == null) {
            return new byte[0];
        }
        return this.base64Encoded.decodedBytes();
    }

    /**
     * Get the binary property: The binary property.
     *
     * @return the binary value.
     */
    public byte[] getBinary() {
        return CoreUtils.clone(this.binary);
    }

    /**
     * Get the dateTime property: The dateTime property.
     *
     * @return the dateTime value.
     */
    public OffsetDateTime getDateTime() {
        return this.dateTime;
    }

    /**
     * Get the dateTimeRfc1123 property: The dateTimeRfc1123 property.
     *
     * @return the dateTimeRfc1123 value.
     */
    public OffsetDateTime getDateTimeRfc1123() {
        if (this.dateTimeRfc1123 == null) {
            return null;
        }
        return this.dateTimeRfc1123.getDateTime();
    }

    /**
     * Get the password property: The password property.
     *
     * @return the password value.
     */
    public String getPassword() {
        return this.password;
    }
}
