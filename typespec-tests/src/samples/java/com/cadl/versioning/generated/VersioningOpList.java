// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.cadl.versioning.generated;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Configuration;
import com.cadl.versioning.VersioningClient;
import com.cadl.versioning.VersioningClientBuilder;
import com.cadl.versioning.models.Resource;
import java.util.Arrays;

public class VersioningOpList {
    public static void main(String[] args) {
        VersioningClient versioningClient = new VersioningClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT")).buildClient();
        // BEGIN:com.cadl.versioning.generated.list.versioningoplist
        PagedIterable<Resource> response = versioningClient.list(Arrays.asList("name=name"), "age gt 18");
        // END:com.cadl.versioning.generated.list.versioningoplist
    }
}
