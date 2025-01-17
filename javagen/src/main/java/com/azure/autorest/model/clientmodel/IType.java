// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.model.clientmodel;

import com.azure.json.JsonReader;
import com.azure.json.JsonWriter;
import com.azure.xml.XmlWriter;

import java.util.Set;

/**
 * A type used by a client.
 */
public interface IType {
    /**
     * The type variant that users interact with.
     *
     * @return The type's client-side variant.
     */
    IType getClientType();

    /**
     * Convert this type to the type users interact with.
     *
     * @param expression The expression used to convert the type to a client type.
     * @return Java code to convert an expression to client type.
     */
    String convertToClientType(String expression);

    /**
     * Convert the client type variant of this type to the original form that should be sent on the wire.
     *
     * @param expression The expression used to convert from the client type.
     * @return Java code to convert a client type expression to wire format.
     */
    String convertFromClientType(String expression);

    /**
     * Indicates whether the type is nullable.
     *
     * @return Whether the type is nullable.
     */
    default boolean isNullable() {
        return true;
    }

    /**
     * Convert this IType to an IType that is nullable.
     *
     * @return A version of this IType that is nullable.
     */
    IType asNullable();

    /**
     * Get whether this IType contains (or is) the provided type.
     *
     * @param type The type to search for.
     * @return Whether this IType contains (or is) the provided type.
     */
    boolean contains(IType type);

    /**
     * Add this type's imports to the provided ISet of imports.
     *
     * @param imports The set of imports to add to.
     * @param includeImplementationImports Whether to include imports that are only necessary for method
     * implementations.
     */
    void addImportsTo(Set<String> imports, boolean includeImplementationImports);

    /**
     * Convert the provided default value expression to this type's default value expression.
     *
     * @param sourceExpression The source expression to convert to this type's default value expression.
     * @return This type's default value expression.
     */
    String defaultValueExpression(String sourceExpression);

    /**
     * The default value expression, when this type does not have data.
     * <p>
     * This is the expression of the type provided as client. By default, the expression is "null" for class types. For
     * primitive types, this would be the Java default value, usually "0". For some collection types, this could be the
     * empty collection.
     *
     * @return the default value expression, when this type does not have data.
     */
    String defaultValueExpression();

    /**
     * Gets the Java code used to validate the type.
     *
     * @param expression The expression used during validation.
     * @return The Java code used to validate the type.
     */
    String validate(String expression);

    /**
     * Gets the method that handles JSON deserialization for the type.
     * <p>
     * If null is returned it either means the type is complex, such as a List or Map, or doesn't have a JSON
     * deserialization method and support needs to be added.
     *
     * @param jsonReaderName The name of the {@link JsonReader} performing deserialization.
     * @return The JSON deserialization method, or null i it isn't supported directly.
     */
    String jsonDeserializationMethod(String jsonReaderName);

    /**
     * Gets the method call that will handle JSON serialization.
     * <p>
     * If {@code fieldName} is null it is assumed that a JSON value is being serialized.
     * <p>
     * If null is returned it either means the type is complex, such as a List or Map, or doesn't have a serialization
     * method and support needs to be added.
     *
     * @param jsonWriterName The name of the {@link JsonWriter} performing serialization.
     * @param fieldName The name of the JSON field, optional.
     * @param valueGetter The value getter.
     * @return The method call that will handle JSON serialization, or null if it isn't supported directly.
     */
    String jsonSerializationMethodCall(String jsonWriterName, String fieldName, String valueGetter);

    /**
     * Gets the method that handles XML deserialization for the type.
     * <p>
     * This method handles both XML attributes and elements. If {@code attributeName} is null the XML element
     * deserialization method is returned.
     * <p>
     * If null is returned it either means the type is complex, such as a List or Map, or doesn't have an XML
     * deserialization method and support needs to be added.
     *
     * @param attributeName The attribute name, if null this is considered to be an element call.
     * @param attributeNamespace The attribute namespace, optional, ignored if {@code attributeName} is null.
     * @return The XML deserialization method, or null i it isn't supported directly.
     */
    String xmlDeserializationMethod(String attributeName, String attributeNamespace);

    /**
     * Gets the method call that will handle XML serialization.
     * <p>
     * If {@code attributeOrElementName} is null it is assumed that an XML value is being serialized.
     * <p>
     * If null is returned it either means the type is complex, such as a List or Map, or doesn't have a serialization
     * method and support needs to be added.
     *
     * @param xmlWriterName The name of the {@link XmlWriter} performing serialization.
     * @param attributeOrElementName The name of the XML attribute or element, optional.
     * @param namespaceUri The namespace URI of the XML attribute or element, optional.
     * @param valueGetter The value getter.
     * @param isAttribute Whether an attribute is being written, if true {@code attributeOrElementName} must be set.
     * @param nameIsVariable Whether the {@code attributeOrElementName} is a variable instead of a string.
     * @return The method call that will handle XML serialization, or null if it isn't supported directly.
     */
    String xmlSerializationMethodCall(String xmlWriterName, String attributeOrElementName, String namespaceUri,
        String valueGetter, boolean isAttribute, boolean nameIsVariable);

    /**
     * Whether the type is used with XML serialization.
     *
     * @return Whether the type is used with XML serialization.
     */
    boolean isUsedInXml();
}
