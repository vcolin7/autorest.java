// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com._specs_.azure.core.lro.rpc.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Options for the generation.
 */
@Immutable
public final class GenerationOptions {
    /*
     * Prompt.
     */
    @Generated
    @JsonProperty(value = "prompt")
    private String prompt;

    /**
     * Creates an instance of GenerationOptions class.
     * 
     * @param prompt the prompt value to set.
     */
    @Generated
    @JsonCreator
    public GenerationOptions(@JsonProperty(value = "prompt") String prompt) {
        this.prompt = prompt;
    }

    /**
     * Get the prompt property: Prompt.
     * 
     * @return the prompt value.
     */
    @Generated
    public String getPrompt() {
        return this.prompt;
    }
}
