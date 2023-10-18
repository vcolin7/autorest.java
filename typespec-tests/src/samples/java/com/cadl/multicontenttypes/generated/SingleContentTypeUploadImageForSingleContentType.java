// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.multicontenttypes.generated;

import com.azure.core.util.BinaryData;
import com.azure.core.util.Configuration;
import com.cadl.multicontenttypes.MultiContentTypesClient;
import com.cadl.multicontenttypes.MultiContentTypesClientBuilder;

public class SingleContentTypeUploadImageForSingleContentType {
    public static void main(String[] args) {
        MultiContentTypesClient multiContentTypesClient =
                new MultiContentTypesClientBuilder()
                        .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT"))
                        .buildClient();
        // BEGIN:com.cadl.multicontenttypes.generated.uploadimageforsinglecontenttype.singlecontenttypeuploadimageforsinglecontenttype
        multiContentTypesClient.uploadImageForSingleContentType(BinaryData.fromObject("{}"));
        // END:com.cadl.multicontenttypes.generated.uploadimageforsinglecontenttype.singlecontenttypeuploadimageforsinglecontenttype
    }
}