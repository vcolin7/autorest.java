// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.internal;

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
import com.azure.core.util.FluxUtil;
import com.cadl.internal.implementation.InternalClientImpl;
import com.cadl.internal.implementation.models.ResponseInternal;
import com.cadl.internal.models.ApiRequest;
import com.cadl.internal.models.ApiResponse;
import reactor.core.publisher.Mono;

/**
 * Initializes a new instance of the asynchronous InternalClient type.
 */
@ServiceClient(builder = InternalClientBuilder.class, isAsync = true)
public final class InternalAsyncClient {
    @Generated
    private final InternalClientImpl serviceClient;

    /**
     * Initializes an instance of InternalAsyncClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    InternalAsyncClient(InternalClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * The postInternal operation.
     * <p>
     * <strong>Request Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     property (Required): {
     *         name: String (Required)
     *     }
     * }
     * }</pre>
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     property (Required): {
     *         name: String (Required)
     *     }
     * }
     * }</pre>
     * 
     * @param apiRequest The apiRequest parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<BinaryData>> postInternalWithResponse(BinaryData apiRequest, RequestOptions requestOptions) {
        return this.serviceClient.postInternalWithResponseAsync(apiRequest, requestOptions);
    }

    /**
     * The getInternal operation.
     * <p>
     * <strong>Response Body Schema</strong>
     * </p>
     * <pre>{@code
     * {
     *     name: String (Required)
     * }
     * }</pre>
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Response<BinaryData>> getInternalWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getInternalWithResponseAsync(requestOptions);
    }

    /**
     * The postInternal operation.
     * 
     * @param apiRequest The apiRequest parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ResponseInternal> postInternal(ApiRequest apiRequest) {
        // Generated convenience method for postInternalWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return postInternalWithResponse(BinaryData.fromObject(apiRequest), requestOptions).flatMap(FluxUtil::toMono)
            .map(protocolMethodData -> protocolMethodData.toObject(ResponseInternal.class));
    }

    /**
     * The getInternal operation.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response body on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<ApiResponse> getInternal() {
        // Generated convenience method for getInternalWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getInternalWithResponse(requestOptions).flatMap(FluxUtil::toMono)
            .map(protocolMethodData -> protocolMethodData.toObject(ApiResponse.class));
    }
}
