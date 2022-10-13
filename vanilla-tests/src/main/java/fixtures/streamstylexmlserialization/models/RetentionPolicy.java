// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.streamstylexmlserialization.models;

import com.azure.core.annotation.Fluent;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/** the retention policy. */
@Fluent
public final class RetentionPolicy implements XmlSerializable<RetentionPolicy> {
    /*
     * Indicates whether a retention policy is enabled for the storage service
     */
    private boolean enabled;

    /*
     * Indicates the number of days that metrics or logging or soft-deleted data should be retained. All data older
     * than this value will be deleted
     */
    private Integer days;

    /** Creates an instance of RetentionPolicy class. */
    public RetentionPolicy() {}

    /**
     * Get the enabled property: Indicates whether a retention policy is enabled for the storage service.
     *
     * @return the enabled value.
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Indicates whether a retention policy is enabled for the storage service.
     *
     * @param enabled the enabled value to set.
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the days property: Indicates the number of days that metrics or logging or soft-deleted data should be
     * retained. All data older than this value will be deleted.
     *
     * @return the days value.
     */
    public Integer getDays() {
        return this.days;
    }

    /**
     * Set the days property: Indicates the number of days that metrics or logging or soft-deleted data should be
     * retained. All data older than this value will be deleted.
     *
     * @param days the days value to set.
     * @return the RetentionPolicy object itself.
     */
    public RetentionPolicy setDays(Integer days) {
        this.days = days;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {}

    @Override
    public XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        xmlWriter.writeStartElement("RetentionPolicy");
        xmlWriter.writeBooleanElement("Enabled", this.enabled);
        xmlWriter.writeNumberElement("Days", this.days);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of RetentionPolicy from the XmlReader.
     *
     * @param xmlReader The XmlReader being read.
     * @return An instance of RetentionPolicy if the XmlReader was pointing to an instance of it, or null if it was
     *     pointing to XML null.
     */
    public static RetentionPolicy fromXml(XmlReader xmlReader) throws XMLStreamException {
        return xmlReader.readObject(
                "RetentionPolicy",
                reader -> {
                    boolean enabled = false;
                    Integer days = null;
                    while (reader.nextElement() != XmlToken.END_ELEMENT) {
                        QName fieldName = reader.getElementName();

                        if ("Enabled".equals(fieldName.getLocalPart())) {
                            enabled = reader.getBooleanElement();
                        } else if ("Days".equals(fieldName.getLocalPart())) {
                            days = reader.getNullableElement(Integer::parseInt);
                        } else {
                            reader.skipElement();
                        }
                    }
                    RetentionPolicy deserializedValue = new RetentionPolicy();
                    deserializedValue.enabled = enabled;
                    deserializedValue.days = days;

                    return deserializedValue;
                });
    }
}