// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.type.union.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.BinaryData;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ModelWithNamedUnionProperty model.
 */
@Immutable
public final class ModelWithNamedUnionProperty implements JsonSerializable<ModelWithNamedUnionProperty> {
    /*
     * The namedUnion property.
     */
    @Generated
    private final BinaryData namedUnion;

    /**
     * Creates an instance of ModelWithNamedUnionProperty class.
     * 
     * @param namedUnion the namedUnion value to set.
     */
    @Generated
    public ModelWithNamedUnionProperty(BinaryData namedUnion) {
        this.namedUnion = namedUnion;
    }

    /**
     * Get the namedUnion property: The namedUnion property.
     * 
     * @return the namedUnion value.
     */
    @Generated
    public BinaryData getNamedUnion() {
        return this.namedUnion;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeUntypedField("namedUnion", this.namedUnion.toObject(Object.class));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ModelWithNamedUnionProperty from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ModelWithNamedUnionProperty if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ModelWithNamedUnionProperty.
     */
    public static ModelWithNamedUnionProperty fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            boolean namedUnionFound = false;
            BinaryData namedUnion = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("namedUnion".equals(fieldName)) {
                    namedUnion = BinaryData.fromObject(reader.readUntyped());
                    namedUnionFound = true;
                } else {
                    reader.skipChildren();
                }
            }
            if (namedUnionFound) {
                ModelWithNamedUnionProperty deserializedModelWithNamedUnionProperty
                    = new ModelWithNamedUnionProperty(namedUnion);

                return deserializedModelWithNamedUnionProperty;
            }
            List<String> missingProperties = new ArrayList<>();
            if (!namedUnionFound) {
                missingProperties.add("namedUnion");
            }

            throw new IllegalStateException(
                "Missing required property/properties: " + String.join(", ", missingProperties));
        });
    }
}
