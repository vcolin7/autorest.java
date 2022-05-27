// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.constants.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ModelAsStringNoRequiredTwoValueNoDefaultEnum. */
public final class ModelAsStringNoRequiredTwoValueNoDefaultEnum
        extends ExpandableStringEnum<ModelAsStringNoRequiredTwoValueNoDefaultEnum> {
    /** Static value value1 for ModelAsStringNoRequiredTwoValueNoDefaultEnum. */
    public static final ModelAsStringNoRequiredTwoValueNoDefaultEnum VALUE1 = fromString("value1");

    /** Static value value2 for ModelAsStringNoRequiredTwoValueNoDefaultEnum. */
    public static final ModelAsStringNoRequiredTwoValueNoDefaultEnum VALUE2 = fromString("value2");

    /**
     * Creates or finds a ModelAsStringNoRequiredTwoValueNoDefaultEnum from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ModelAsStringNoRequiredTwoValueNoDefaultEnum.
     */
    @JsonCreator
    public static ModelAsStringNoRequiredTwoValueNoDefaultEnum fromString(String name) {
        return fromString(name, ModelAsStringNoRequiredTwoValueNoDefaultEnum.class);
    }

    /**
     * Gets known ModelAsStringNoRequiredTwoValueNoDefaultEnum values.
     *
     * @return known ModelAsStringNoRequiredTwoValueNoDefaultEnum values.
     */
    public static Collection<ModelAsStringNoRequiredTwoValueNoDefaultEnum> values() {
        return values(ModelAsStringNoRequiredTwoValueNoDefaultEnum.class);
    }
}