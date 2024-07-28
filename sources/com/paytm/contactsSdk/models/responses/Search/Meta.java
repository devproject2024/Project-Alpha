package com.paytm.contactsSdk.models.responses.Search;

import kotlin.g.b.k;

public final class Meta {
    private final ExtendedInfo extendedInfo;

    public static /* synthetic */ Meta copy$default(Meta meta, ExtendedInfo extendedInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            extendedInfo2 = meta.extendedInfo;
        }
        return meta.copy(extendedInfo2);
    }

    public final ExtendedInfo component1() {
        return this.extendedInfo;
    }

    public final Meta copy(ExtendedInfo extendedInfo2) {
        k.c(extendedInfo2, "extendedInfo");
        return new Meta(extendedInfo2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Meta) && k.a((Object) this.extendedInfo, (Object) ((Meta) obj).extendedInfo);
        }
        return true;
    }

    public final int hashCode() {
        ExtendedInfo extendedInfo2 = this.extendedInfo;
        if (extendedInfo2 != null) {
            return extendedInfo2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Meta(extendedInfo=" + this.extendedInfo + ")";
    }

    public Meta(ExtendedInfo extendedInfo2) {
        k.c(extendedInfo2, "extendedInfo");
        this.extendedInfo = extendedInfo2;
    }

    public final ExtendedInfo getExtendedInfo() {
        return this.extendedInfo;
    }
}
