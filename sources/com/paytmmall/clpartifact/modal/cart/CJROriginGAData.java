package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class CJROriginGAData {
    @c(a = "grid_type")
    private final String mGridType;
    @c(a = "prev_screen_name")
    private final String mPrevScreenName;
    @c(a = "prev_screen_type")
    private final String mPrevScreenType;

    public static /* synthetic */ CJROriginGAData copy$default(CJROriginGAData cJROriginGAData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJROriginGAData.mGridType;
        }
        if ((i2 & 2) != 0) {
            str2 = cJROriginGAData.mPrevScreenName;
        }
        if ((i2 & 4) != 0) {
            str3 = cJROriginGAData.mPrevScreenType;
        }
        return cJROriginGAData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.mGridType;
    }

    public final String component2() {
        return this.mPrevScreenName;
    }

    public final String component3() {
        return this.mPrevScreenType;
    }

    public final CJROriginGAData copy(String str, String str2, String str3) {
        return new CJROriginGAData(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJROriginGAData)) {
            return false;
        }
        CJROriginGAData cJROriginGAData = (CJROriginGAData) obj;
        return k.a((Object) this.mGridType, (Object) cJROriginGAData.mGridType) && k.a((Object) this.mPrevScreenName, (Object) cJROriginGAData.mPrevScreenName) && k.a((Object) this.mPrevScreenType, (Object) cJROriginGAData.mPrevScreenType);
    }

    public final int hashCode() {
        String str = this.mGridType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mPrevScreenName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mPrevScreenType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJROriginGAData(mGridType=" + this.mGridType + ", mPrevScreenName=" + this.mPrevScreenName + ", mPrevScreenType=" + this.mPrevScreenType + ")";
    }

    public CJROriginGAData(String str, String str2, String str3) {
        this.mGridType = str;
        this.mPrevScreenName = str2;
        this.mPrevScreenType = str3;
    }

    public final String getMGridType() {
        return this.mGridType;
    }

    public final String getMPrevScreenName() {
        return this.mPrevScreenName;
    }

    public final String getMPrevScreenType() {
        return this.mPrevScreenType;
    }
}
