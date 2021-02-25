// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for WafMetricsResponseGranularity. */
public final class WafMetricsResponseGranularity extends ExpandableStringEnum<WafMetricsResponseGranularity> {
    /** Static value PT5M for WafMetricsResponseGranularity. */
    public static final WafMetricsResponseGranularity PT5M = fromString("PT5M");

    /** Static value PT1H for WafMetricsResponseGranularity. */
    public static final WafMetricsResponseGranularity PT1H = fromString("PT1H");

    /** Static value P1D for WafMetricsResponseGranularity. */
    public static final WafMetricsResponseGranularity P1D = fromString("P1D");

    /**
     * Creates or finds a WafMetricsResponseGranularity from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding WafMetricsResponseGranularity.
     */
    @JsonCreator
    public static WafMetricsResponseGranularity fromString(String name) {
        return fromString(name, WafMetricsResponseGranularity.class);
    }

    /** @return known WafMetricsResponseGranularity values. */
    public static Collection<WafMetricsResponseGranularity> values() {
        return values(WafMetricsResponseGranularity.class);
    }
}