// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.requiredheaderquery;

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
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;

/** Initializes a new instance of the synchronous DpgRequiredHeaderQueryClient type. */
@ServiceClient(builder = DpgRequiredHeaderQueryClientBuilder.class)
public final class DpgRequiredHeaderQueryClient {
    @Generated private final DpgRequiredHeaderQueryAsyncClient client;

    /**
     * Initializes an instance of DpgRequiredHeaderQueryClient class.
     *
     * @param client the async client.
     */
    @Generated
    DpgRequiredHeaderQueryClient(DpgRequiredHeaderQueryAsyncClient client) {
        this.client = client;
    }

    /**
     * Get Required Query Parameters.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * Object
     * }</pre>
     *
     * @param parameterInt I am a required int parameter.
     * @param parameterBoolean I am a required boolean parameter.
     * @param parameterCsvStringArray I am a required csv string array parameter.
     * @param parameterCsvIntArray I am a required csv int array parameter.
     * @param parameterMultiStringArray The array of string collect by multi.
     * @param parameterMultiIntArray The array of integer collect by multi.
     * @param parameterMultiEnumArray The array of enum collect by multi.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return required Query Parameters along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getRequiredQueryParamWithResponse(
            int parameterInt,
            boolean parameterBoolean,
            List<String> parameterCsvStringArray,
            List<Integer> parameterCsvIntArray,
            List<String> parameterMultiStringArray,
            List<Integer> parameterMultiIntArray,
            List<String> parameterMultiEnumArray,
            RequestOptions requestOptions) {
        return this.client
                .getRequiredQueryParamWithResponse(
                        parameterInt,
                        parameterBoolean,
                        parameterCsvStringArray,
                        parameterCsvIntArray,
                        parameterMultiStringArray,
                        parameterMultiIntArray,
                        parameterMultiEnumArray,
                        requestOptions)
                .block();
    }

    /**
     * Get Required Header Parameters.
     *
     * <p><strong>Header Parameters</strong>
     *
     * <table border="1">
     *     <caption>Header Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * Object
     * }</pre>
     *
     * @param parameterInt I am a required int parameter.
     * @param parameterBoolean I am a required boolean parameter.
     * @param parameterCsvStringArray The array of string collect by csv.
     * @param parameterCsvIntArray The array of integer collect by csv.
     * @param parameterDatetime The datetime parameter.
     * @param parameterDuration The duration parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return required Header Parameters along with {@link Response}.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getRequiredHeaderWithResponse(
            int parameterInt,
            boolean parameterBoolean,
            List<String> parameterCsvStringArray,
            List<Integer> parameterCsvIntArray,
            OffsetDateTime parameterDatetime,
            Duration parameterDuration,
            RequestOptions requestOptions) {
        return this.client
                .getRequiredHeaderWithResponse(
                        parameterInt,
                        parameterBoolean,
                        parameterCsvStringArray,
                        parameterCsvIntArray,
                        parameterDatetime,
                        parameterDuration,
                        requestOptions)
                .block();
    }
}
