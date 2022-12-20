// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.cadl.response;

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
import com.azure.core.util.serializer.TypeReference;
import com.cadl.response.models.Resource;
import java.util.List;

/** Initializes a new instance of the synchronous ResponseClient type. */
@ServiceClient(builder = ResponseClientBuilder.class)
public final class ResponseClient {
    @Generated private final ResponseAsyncClient client;

    /**
     * Initializes an instance of ResponseClient class.
     *
     * @param client the async client.
     */
    @Generated
    ResponseClient(ResponseAsyncClient client) {
        this.client = client;
    }

    /**
     * The getBinary operation.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * byte[]
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<byte[]> getBinaryWithResponse(RequestOptions requestOptions) {
        return this.client.getBinaryWithResponse(requestOptions).block();
    }

    /**
     * The getArray operation.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * [
     *      (Required){
     *         id: String (Required)
     *         name: String (Required)
     *         description: String (Optional)
     *         type: String (Required)
     *     }
     * ]
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return array of Resource along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getArrayWithResponse(RequestOptions requestOptions) {
        return this.client.getArrayWithResponse(requestOptions).block();
    }

    /**
     * The getAnotherArray operation.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * [
     *      (Required){
     *         id: String (Required)
     *         name: String (Required)
     *         description: String (Optional)
     *         type: String (Required)
     *     }
     * ]
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return array of Resource along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getAnotherArrayWithResponse(RequestOptions requestOptions) {
        return this.client.getAnotherArrayWithResponse(requestOptions).block();
    }

    /**
     * The createWithHeaders operation.
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String (Required)
     *     name: String (Required)
     *     description: String (Optional)
     *     type: String (Required)
     * }
     * }</pre>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> createWithHeadersWithResponse(RequestOptions requestOptions) {
        return this.client.createWithHeadersWithResponse(requestOptions).block();
    }

    /**
     * The deleteWithHeaders operation.
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteWithHeadersWithResponse(RequestOptions requestOptions) {
        return this.client.deleteWithHeadersWithResponse(requestOptions).block();
    }

    /**
     * The getBinary operation.
     *
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public byte[] getBinary() {
        // Generated convenience method for getBinaryWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getBinaryWithResponse(requestOptions).getValue();
    }

    /**
     * The getArray operation.
     *
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Resource.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<Resource> getArray() {
        // Generated convenience method for getArrayWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getArrayWithResponse(requestOptions).getValue().toObject(TYPE_REFERENCE_LIST_RESOURCE);
    }

    /**
     * The getAnotherArray operation.
     *
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return array of Resource.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<Resource> getAnotherArray() {
        // Generated convenience method for getAnotherArrayWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getAnotherArrayWithResponse(requestOptions).getValue().toObject(TYPE_REFERENCE_LIST_RESOURCE);
    }

    /**
     * The createWithHeaders operation.
     *
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Resource createWithHeaders() {
        // Generated convenience method for createWithHeadersWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return createWithHeadersWithResponse(requestOptions).getValue().toObject(Resource.class);
    }

    /**
     * The deleteWithHeaders operation.
     *
     * @throws com.azure.core.exception.HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteWithHeaders() {
        // Generated convenience method for deleteWithHeadersWithResponse
        RequestOptions requestOptions = new RequestOptions();
        deleteWithHeadersWithResponse(requestOptions).getValue();
    }

    private static final TypeReference<List<Resource>> TYPE_REFERENCE_LIST_RESOURCE =
            new TypeReference<List<Resource>>() {};
}
