// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.mapper;

import com.azure.autorest.extension.base.model.codemodel.BinarySchema;
import com.azure.autorest.model.clientmodel.GenericType;
import com.azure.autorest.model.clientmodel.IType;

/**
 * A mapper that maps a {@link BinarySchema} to {@link GenericType#FluxByteBuffer} when the schema isn't null.
 */
public class BinaryMapper implements IMapper<BinarySchema, IType> {

  private static final BinaryMapper INSTANCE = new BinaryMapper();

  /**
   * Gets the global {@link BinaryMapper} instance.
   *
   * @return The global {@link BinaryMapper} instance.
   */
  public static BinaryMapper getInstance() {
    return INSTANCE;
  }

  @Override
  public IType map(BinarySchema binarySchema) {
    if (binarySchema == null) {
      return null;
    }
    return GenericType.FluxByteBuffer;
  }
}
