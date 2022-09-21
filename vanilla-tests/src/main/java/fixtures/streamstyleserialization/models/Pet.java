// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.streamstyleserialization.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

/** The Pet model. */
@Fluent
public class Pet implements JsonSerializable<Pet> {
    /*
     * The id property.
     */
    private Integer id;

    /*
     * The name property.
     */
    private String name;

    /** Creates an instance of Pet class. */
    public Pet() {}

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
     * @return the Pet object itself.
     */
    public Pet setId(Integer id) {
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
     * @return the Pet object itself.
     */
    public Pet setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {}

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntegerField("id", this.id, false);
        jsonWriter.writeStringField("name", this.name, false);
        return jsonWriter.writeEndObject().flush();
    }

    /**
     * Reads an instance of Pet from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of Pet if the JsonReader was pointing to an instance of it, or null if it was pointing to
     *     JSON null.
     */
    public static Pet fromJson(JsonReader jsonReader) {
        return jsonReader.readObject(
                reader -> {
                    Integer id = null;
                    String name = null;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("id".equals(fieldName)) {
                            id = reader.getIntegerNullableValue();
                        } else if ("name".equals(fieldName)) {
                            name = reader.getStringValue();
                        } else {
                            reader.skipChildren();
                        }
                    }
                    Pet deserializedValue = new Pet();
                    deserializedValue.id = id;
                    deserializedValue.name = name;

                    return deserializedValue;
                });
    }
}
