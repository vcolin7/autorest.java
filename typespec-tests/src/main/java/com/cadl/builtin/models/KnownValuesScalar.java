// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.builtin.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for KnownValuesScalar. */
public final class KnownValuesScalar extends ExpandableStringEnum<KnownValuesScalar> {
    /** Static value Value1 for KnownValuesScalar. */
    @Generated public static final KnownValuesScalar VALUE1 = fromString("Value1");

    /** Static value Value2 for KnownValuesScalar. */
    @Generated public static final KnownValuesScalar VALUE2 = fromString("Value2");

    /**
     * Creates a new instance of KnownValuesScalar value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public KnownValuesScalar() {}

    /**
     * Creates or finds a KnownValuesScalar from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding KnownValuesScalar.
     */
    @Generated
    @JsonCreator
    public static KnownValuesScalar fromString(String name) {
        return fromString(name, KnownValuesScalar.class);
    }

    /**
     * Gets known KnownValuesScalar values.
     *
     * @return known KnownValuesScalar values.
     */
    @Generated
    public static Collection<KnownValuesScalar> values() {
        return values(KnownValuesScalar.class);
    }
}
