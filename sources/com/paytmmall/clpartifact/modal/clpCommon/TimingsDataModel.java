package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;
import kotlin.g.b.k;

public final class TimingsDataModel implements Serializable {
    @c(a = "closingTime")
    private final String mClosingTime;
    @c(a = "openingTime")
    private final String mOpeningTime;

    public static /* synthetic */ TimingsDataModel copy$default(TimingsDataModel timingsDataModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = timingsDataModel.mOpeningTime;
        }
        if ((i2 & 2) != 0) {
            str2 = timingsDataModel.mClosingTime;
        }
        return timingsDataModel.copy(str, str2);
    }

    public final String component1() {
        return this.mOpeningTime;
    }

    public final String component2() {
        return this.mClosingTime;
    }

    public final TimingsDataModel copy(String str, String str2) {
        return new TimingsDataModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimingsDataModel)) {
            return false;
        }
        TimingsDataModel timingsDataModel = (TimingsDataModel) obj;
        return k.a((Object) this.mOpeningTime, (Object) timingsDataModel.mOpeningTime) && k.a((Object) this.mClosingTime, (Object) timingsDataModel.mClosingTime);
    }

    public final int hashCode() {
        String str = this.mOpeningTime;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mClosingTime;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TimingsDataModel(mOpeningTime=" + this.mOpeningTime + ", mClosingTime=" + this.mClosingTime + ")";
    }

    public TimingsDataModel(String str, String str2) {
        this.mOpeningTime = str;
        this.mClosingTime = str2;
    }

    public final String getMOpeningTime() {
        return this.mOpeningTime;
    }

    public final String getMClosingTime() {
        return this.mClosingTime;
    }
}
