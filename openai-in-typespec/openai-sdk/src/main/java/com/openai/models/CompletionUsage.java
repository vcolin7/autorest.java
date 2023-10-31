// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.openai.models;

import com.generic.core.annotation.Generated;
import com.generic.core.annotation.Immutable;
import com.generic.json.JsonReader;
import com.generic.json.JsonSerializable;
import com.generic.json.JsonToken;
import com.generic.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Usage statistics for the completion request. */
@Immutable
public final class CompletionUsage implements JsonSerializable<CompletionUsage> {
    /*
     * Number of tokens in the prompt.
     */
    @Generated private final long promptTokens;

    /*
     * Number of tokens in the generated completion
     */
    @Generated private final long completionTokens;

    /*
     * Total number of tokens used in the request (prompt + completion).
     */
    @Generated private final long totalTokens;

    /**
     * Creates an instance of CompletionUsage class.
     *
     * @param promptTokens the promptTokens value to set.
     * @param completionTokens the completionTokens value to set.
     * @param totalTokens the totalTokens value to set.
     */
    @Generated
    private CompletionUsage(long promptTokens, long completionTokens, long totalTokens) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
    }

    /**
     * Get the promptTokens property: Number of tokens in the prompt.
     *
     * @return the promptTokens value.
     */
    @Generated
    public long getPromptTokens() {
        return this.promptTokens;
    }

    /**
     * Get the completionTokens property: Number of tokens in the generated completion.
     *
     * @return the completionTokens value.
     */
    @Generated
    public long getCompletionTokens() {
        return this.completionTokens;
    }

    /**
     * Get the totalTokens property: Total number of tokens used in the request (prompt + completion).
     *
     * @return the totalTokens value.
     */
    @Generated
    public long getTotalTokens() {
        return this.totalTokens;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeLongField("prompt_tokens", this.promptTokens);
        jsonWriter.writeLongField("completion_tokens", this.completionTokens);
        jsonWriter.writeLongField("total_tokens", this.totalTokens);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CompletionUsage from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of CompletionUsage if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CompletionUsage.
     */
    public static CompletionUsage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    boolean promptTokensFound = false;
                    long promptTokens = 0L;
                    boolean completionTokensFound = false;
                    long completionTokens = 0L;
                    boolean totalTokensFound = false;
                    long totalTokens = 0L;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("prompt_tokens".equals(fieldName)) {
                            promptTokens = reader.getLong();
                            promptTokensFound = true;
                        } else if ("completion_tokens".equals(fieldName)) {
                            completionTokens = reader.getLong();
                            completionTokensFound = true;
                        } else if ("total_tokens".equals(fieldName)) {
                            totalTokens = reader.getLong();
                            totalTokensFound = true;
                        } else {
                            reader.skipChildren();
                        }
                    }
                    if (promptTokensFound && completionTokensFound && totalTokensFound) {
                        CompletionUsage deserializedCompletionUsage =
                                new CompletionUsage(promptTokens, completionTokens, totalTokens);

                        return deserializedCompletionUsage;
                    }
                    List<String> missingProperties = new ArrayList<>();
                    if (!promptTokensFound) {
                        missingProperties.add("prompt_tokens");
                    }
                    if (!completionTokensFound) {
                        missingProperties.add("completion_tokens");
                    }
                    if (!totalTokensFound) {
                        missingProperties.add("total_tokens");
                    }

                    throw new IllegalStateException(
                            "Missing required property/properties: " + String.join(", ", missingProperties));
                });
    }
}