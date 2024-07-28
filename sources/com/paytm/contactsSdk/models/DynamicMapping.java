package com.paytm.contactsSdk.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class DynamicMapping {
    private final long bitCode;
    private final int columnNumber;
    private final String feature;

    public static /* synthetic */ DynamicMapping copy$default(DynamicMapping dynamicMapping, String str, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dynamicMapping.feature;
        }
        if ((i3 & 2) != 0) {
            i2 = dynamicMapping.columnNumber;
        }
        if ((i3 & 4) != 0) {
            j = dynamicMapping.bitCode;
        }
        return dynamicMapping.copy(str, i2, j);
    }

    public final String component1() {
        return this.feature;
    }

    public final int component2() {
        return this.columnNumber;
    }

    public final long component3() {
        return this.bitCode;
    }

    public final DynamicMapping copy(String str, int i2, long j) {
        k.c(str, "feature");
        return new DynamicMapping(str, i2, j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicMapping)) {
            return false;
        }
        DynamicMapping dynamicMapping = (DynamicMapping) obj;
        return k.a((Object) this.feature, (Object) dynamicMapping.feature) && this.columnNumber == dynamicMapping.columnNumber && this.bitCode == dynamicMapping.bitCode;
    }

    public final int hashCode() {
        String str = this.feature;
        return ((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.columnNumber).hashCode()) * 31) + Long.valueOf(this.bitCode).hashCode();
    }

    public final String toString() {
        return "DynamicMapping(feature=" + this.feature + ", columnNumber=" + this.columnNumber + ", bitCode=" + this.bitCode + ")";
    }

    public DynamicMapping(String str, int i2, long j) {
        k.c(str, "feature");
        this.feature = str;
        this.columnNumber = i2;
        this.bitCode = j;
    }

    public final String getFeature() {
        return this.feature;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicMapping(String str, int i2, long j, int i3, g gVar) {
        this(str, (i3 & 2) != 0 ? 0 : i2, j);
    }

    public final int getColumnNumber() {
        return this.columnNumber;
    }

    public final long getBitCode() {
        return this.bitCode;
    }
}
