// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.url.multi;

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
import fixtures.url.multi.implementation.QueriesImpl;
import reactor.core.publisher.Mono;

/** Initializes a new instance of the asynchronous AutoRestUrlMutliCollectionFormatTestServiceClient type. */
@ServiceClient(builder = AutoRestUrlMutliCollectionFormatTestServiceClientBuilder.class, isAsync = true)
public final class AutoRestUrlMutliCollectionFormatTestServiceAsyncClient {
    @Generated private final QueriesImpl serviceClient;

    /**
     * Initializes an instance of Queries client.
     *
     * @param serviceClient the service client implementation.
     */
    @Generated
    AutoRestUrlMutliCollectionFormatTestServiceAsyncClient(QueriesImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Get a null array of string using the multi-array format.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>arrayQuery</td><td>String</td><td>No</td><td>a null array of string using the multi-array format. Call {@link RequestOptions#addQueryParam} to add string to array.</td></tr>
     * </table>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return a null array of string using the multi-array format along with {@link Response} on successful completion
     *     of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> arrayStringMultiNullWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.arrayStringMultiNullWithResponseAsync(requestOptions);
    }

    /**
     * Get an empty array [] of string using the multi-array format.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>arrayQuery</td><td>String</td><td>No</td><td>an empty array [] of string using the multi-array format. Call {@link RequestOptions#addQueryParam} to add string to array.</td></tr>
     * </table>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return an empty array [] of string using the multi-array format along with {@link Response} on successful
     *     completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> arrayStringMultiEmptyWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.arrayStringMultiEmptyWithResponseAsync(requestOptions);
    }

    /**
     * Get an array of string ['ArrayQuery1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the mult-array format.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>arrayQuery</td><td>String</td><td>No</td><td>an array of string ['ArrayQuery1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the mult-array format. Call {@link RequestOptions#addQueryParam} to add string to array.</td></tr>
     * </table>
     *
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return an array of string ['ArrayQuery1', 'begin!*'();:@ &amp;=+$,/?#[]end' , null, ''] using the mult-array
     *     format along with {@link Response} on successful completion of {@link Mono}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> arrayStringMultiValidWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.arrayStringMultiValidWithResponseAsync(requestOptions);
    }
}
