// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.naming;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpHeaderName;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.cadl.naming.implementation.NamingClientImpl;
import com.cadl.naming.models.DataRequest;
import com.cadl.naming.models.DataResponse;
import com.cadl.naming.models.GetAnonymouseResponse;

/**
 * Initializes a new instance of the synchronous NamingClient type.
 */
@ServiceClient(builder = NamingClientBuilder.class)
public final class NamingClient {
    @Generated
    private final NamingClientImpl serviceClient;

    /**
     * Initializes an instance of NamingClient class.
     * 
     * @param serviceClient the service client implementation.
     */
    @Generated
    NamingClient(NamingClientImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Protocol method for POST operation.
     * 
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @param request summary of Request
     * @param name summary of name query parameter
     * @return summary of Response along with {@link Response}.
     * @throws ResourceModifiedException ResourceModifiedException thrown if the request is rejected by server on status
     * code 409.
     * @throws ResourceNotFoundException ResourceNotFoundException thrown if the request is rejected by server on status
     * code 404.
     * @throws ClientAuthenticationException ClientAuthenticationException thrown if the request is rejected by server
     * on status code 401.
     * @throws HttpResponseException HttpResponseException thrown if the request is rejected by server.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> postWithResponse(String name, BinaryData request, RequestOptions requestOptions) {
        return this.serviceClient.postWithResponse(name, request, requestOptions);
    }

    /**
     * The getAnonymouse operation.
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
     * @return the response body along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getAnonymouseWithResponse(RequestOptions requestOptions) {
        return this.serviceClient.getAnonymouseWithResponse(requestOptions);
    }

    /**
     * summary of POST op
     * 
     * description of POST op.
     * 
     * @param name summary of name query parameter
     * 
     * description of name query parameter.
     * @param request summary of Request
     * 
     * description of Request.
     * @param etag summary of etag header parameter
     * 
     * description of etag header parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return summary of Response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DataResponse post(String name, DataRequest request, String etag) {
        // Generated convenience method for postWithResponse
        RequestOptions requestOptions = new RequestOptions();
        if (etag != null) {
            requestOptions.setHeader(HttpHeaderName.ETAG, etag);
        }
        return postWithResponse(name, BinaryData.fromObject(request), requestOptions).getValue()
            .toObject(DataResponse.class);
    }

    /**
     * summary of POST op
     * 
     * description of POST op.
     * 
     * @param name summary of name query parameter
     * 
     * description of name query parameter.
     * @param request summary of Request
     * 
     * description of Request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return summary of Response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DataResponse post(String name, DataRequest request) {
        // Generated convenience method for postWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return postWithResponse(name, BinaryData.fromObject(request), requestOptions).getValue()
            .toObject(DataResponse.class);
    }

    /**
     * The getAnonymouse operation.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public GetAnonymouseResponse getAnonymouse() {
        // Generated convenience method for getAnonymouseWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getAnonymouseWithResponse(requestOptions).getValue().toObject(GetAnonymouseResponse.class);
    }
}
