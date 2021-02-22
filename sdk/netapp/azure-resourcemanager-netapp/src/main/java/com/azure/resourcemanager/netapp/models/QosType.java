// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for QosType. */
public final class QosType extends ExpandableStringEnum<QosType> {
    /** Static value Auto for QosType. */
    public static final QosType AUTO = fromString("Auto");

    /** Static value Manual for QosType. */
    public static final QosType MANUAL = fromString("Manual");

    /**
     * Creates or finds a QosType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding QosType.
     */
    @JsonCreator
    public static QosType fromString(String name) {
        return fromString(name, QosType.class);
    }

    /** @return known QosType values. */
    public static Collection<QosType> values() {
        return values(QosType.class);
    }
}