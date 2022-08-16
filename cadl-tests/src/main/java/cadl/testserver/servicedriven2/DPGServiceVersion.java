// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package cadl.testserver.servicedriven2;

import com.azure.core.util.ServiceVersion;

/** Service version of DPGClient. */
public enum DPGServiceVersion implements ServiceVersion {
    /** Enum value 1.1.0. */
    V1_1_0("1.1.0");

    private final String version;

    DPGServiceVersion(String version) {
        this.version = version;
    }

    /** {@inheritDoc} */
    @Override
    public String getVersion() {
        return this.version;
    }

    /**
     * Gets the latest service version supported by this client library.
     *
     * @return The latest {@link DPGServiceVersion}.
     */
    public static DPGServiceVersion getLatest() {
        return V1_1_0;
    }
}
