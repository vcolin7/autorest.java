// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.bodycomplex.generated;

import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import fixtures.bodycomplex.InheritanceClient;
import fixtures.bodycomplex.InheritanceClientBuilder;

public class InheritancePutValid {
    public static void main(String[] args) {
        InheritanceClient inheritanceClient =
                new InheritanceClientBuilder().host("http://localhost:3000").buildClient();
        // BEGIN:fixtures.bodycomplex.generated.inheritanceputvalid.inheritanceputvalid
        BinaryData complexBody =
                BinaryData.fromString(
                        "{\"name\":\"Siameee\",\"breed\":\"persion\",\"color\":\"green\",\"hates\":[{\"name\":\"Potato\",\"food\":\"tomato\",\"id\":1},{\"name\":\"Tomato\",\"food\":\"french fries\",\"id\":-1}],\"id\":2}");
        RequestOptions requestOptions = new RequestOptions();
        Response<Void> response = inheritanceClient.putValidWithResponse(complexBody, requestOptions);
        // END:fixtures.bodycomplex.generated.inheritanceputvalid.inheritanceputvalid
    }
}