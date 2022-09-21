// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.inputbasic;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.inputbasic.implementation.InputBasicsImpl;
import com.inputbasic.models.InputModel;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous InputBasicClient type. */
@ServiceClient(builder = InputBasicClientBuilder.class, isAsync = true)
public final class InputBasicAsyncClient {
    @Generated private final InputBasicsImpl serviceClient;

    /**
     * Initializes an instance of InputBasicAsyncClient class.
     *
     * @param serviceClient the service client implementation.
     */
    @Generated
    InputBasicAsyncClient(InputBasicsImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The getModel operation.
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     requiredString: String (Required)
     *     requiredInt: int (Required)
     * }
     * }</pre>
     *
     * @param input Input Model.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> getModelWithResponse(BinaryData input, RequestOptions requestOptions) {
        return this.serviceClient.getModelWithResponseAsync(input, requestOptions);
    }

    /**
     * The getModel operation.
     *
     * @param input Input Model.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> getModel(InputModel input) {
        // Generated convenience method for getModelWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getModelWithResponse(BinaryData.fromObject(input), requestOptions).then();
    }
}