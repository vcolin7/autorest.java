// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.openai.models;

import com.generic.core.annotation.Generated;
import com.generic.core.annotation.Immutable;
import com.generic.json.JsonReader;
import com.generic.json.JsonSerializable;
import com.generic.json.JsonToken;
import com.generic.json.JsonWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/** The FineTuneEvent model. */
@Immutable
public final class FineTuneEvent implements JsonSerializable<FineTuneEvent> {
    /*
     * The object property.
     */
    @Generated private final String object;

    /*
     * The created_at property.
     */
    @Generated private final long createdAt;

    /*
     * The level property.
     */
    @Generated private final String level;

    /*
     * The message property.
     */
    @Generated private final String message;

    /**
     * Creates an instance of FineTuneEvent class.
     *
     * @param object the object value to set.
     * @param createdAt the createdAt value to set.
     * @param level the level value to set.
     * @param message the message value to set.
     */
    @Generated
    private FineTuneEvent(String object, OffsetDateTime createdAt, String level, String message) {
        this.object = object;
        this.createdAt = createdAt.toEpochSecond();
        this.level = level;
        this.message = message;
    }

    /**
     * Get the object property: The object property.
     *
     * @return the object value.
     */
    @Generated
    public String getObject() {
        return this.object;
    }

    /**
     * Get the createdAt property: The created_at property.
     *
     * @return the createdAt value.
     */
    @Generated
    public OffsetDateTime getCreatedAt() {
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.createdAt), ZoneOffset.UTC);
    }

    /**
     * Get the level property: The level property.
     *
     * @return the level value.
     */
    @Generated
    public String getLevel() {
        return this.level;
    }

    /**
     * Get the message property: The message property.
     *
     * @return the message value.
     */
    @Generated
    public String getMessage() {
        return this.message;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("object", this.object);
        jsonWriter.writeLongField("created_at", this.createdAt);
        jsonWriter.writeStringField("level", this.level);
        jsonWriter.writeStringField("message", this.message);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FineTuneEvent from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of FineTuneEvent if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the FineTuneEvent.
     */
    public static FineTuneEvent fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    boolean objectFound = false;
                    String object = null;
                    boolean createdAtFound = false;
                    OffsetDateTime createdAt = null;
                    boolean levelFound = false;
                    String level = null;
                    boolean messageFound = false;
                    String message = null;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("object".equals(fieldName)) {
                            object = reader.getString();
                            objectFound = true;
                        } else if ("created_at".equals(fieldName)) {
                            createdAt =
                                    OffsetDateTime.ofInstant(Instant.ofEpochSecond(reader.getLong()), ZoneOffset.UTC);
                            createdAtFound = true;
                        } else if ("level".equals(fieldName)) {
                            level = reader.getString();
                            levelFound = true;
                        } else if ("message".equals(fieldName)) {
                            message = reader.getString();
                            messageFound = true;
                        } else {
                            reader.skipChildren();
                        }
                    }
                    if (objectFound && createdAtFound && levelFound && messageFound) {
                        FineTuneEvent deserializedFineTuneEvent = new FineTuneEvent(object, createdAt, level, message);

                        return deserializedFineTuneEvent;
                    }
                    List<String> missingProperties = new ArrayList<>();
                    if (!objectFound) {
                        missingProperties.add("object");
                    }
                    if (!createdAtFound) {
                        missingProperties.add("created_at");
                    }
                    if (!levelFound) {
                        missingProperties.add("level");
                    }
                    if (!messageFound) {
                        missingProperties.add("message");
                    }

                    throw new IllegalStateException(
                            "Missing required property/properties: " + String.join(", ", missingProperties));
                });
    }
}