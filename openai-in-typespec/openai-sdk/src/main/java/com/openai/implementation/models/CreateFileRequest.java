// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.openai.implementation.models;

import com.generic.core.annotation.Generated;
import com.generic.core.annotation.Immutable;
import com.generic.json.JsonReader;
import com.generic.json.JsonSerializable;
import com.generic.json.JsonToken;
import com.generic.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** The CreateFileRequest model. */
@Immutable
public final class CreateFileRequest implements JsonSerializable<CreateFileRequest> {
    /*
     * Name of the [JSON Lines](https://jsonlines.readthedocs.io/en/latest/) file to be uploaded.
     *
     * If the `purpose` is set to "fine-tune", the file will be used for fine-tuning.
     */
    @Generated private final byte[] file;

    /*
     * The intended purpose of the uploaded documents. Use "fine-tune" for
     * [fine-tuning](/docs/api-reference/fine-tuning). This allows us to validate the format of the
     * uploaded file.
     */
    @Generated private final String purpose;

    /**
     * Creates an instance of CreateFileRequest class.
     *
     * @param file the file value to set.
     * @param purpose the purpose value to set.
     */
    @Generated
    public CreateFileRequest(byte[] file, String purpose) {
        this.file = file;
        this.purpose = purpose;
    }

    /**
     * Get the file property: Name of the [JSON Lines](https://jsonlines.readthedocs.io/en/latest/) file to be uploaded.
     *
     * <p>If the `purpose` is set to "fine-tune", the file will be used for fine-tuning.
     *
     * @return the file value.
     */
    @Generated
    public byte[] getFile() {
        return this.file;
    }

    /**
     * Get the purpose property: The intended purpose of the uploaded documents. Use "fine-tune" for
     * [fine-tuning](/docs/api-reference/fine-tuning). This allows us to validate the format of the uploaded file.
     *
     * @return the purpose value.
     */
    @Generated
    public String getPurpose() {
        return this.purpose;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBinaryField("file", this.file);
        jsonWriter.writeStringField("purpose", this.purpose);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CreateFileRequest from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of CreateFileRequest if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CreateFileRequest.
     */
    public static CreateFileRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    boolean fileFound = false;
                    byte[] file = null;
                    boolean purposeFound = false;
                    String purpose = null;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("file".equals(fieldName)) {
                            file = reader.getBinary();
                            fileFound = true;
                        } else if ("purpose".equals(fieldName)) {
                            purpose = reader.getString();
                            purposeFound = true;
                        } else {
                            reader.skipChildren();
                        }
                    }
                    if (fileFound && purposeFound) {
                        CreateFileRequest deserializedCreateFileRequest = new CreateFileRequest(file, purpose);

                        return deserializedCreateFileRequest;
                    }
                    List<String> missingProperties = new ArrayList<>();
                    if (!fileFound) {
                        missingProperties.add("file");
                    }
                    if (!purposeFound) {
                        missingProperties.add("purpose");
                    }

                    throw new IllegalStateException(
                            "Missing required property/properties: " + String.join(", ", missingProperties));
                });
    }
}