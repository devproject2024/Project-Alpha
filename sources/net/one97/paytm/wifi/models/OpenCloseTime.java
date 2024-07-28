package net.one97.paytm.wifi.models;

import kotlin.g.b.k;

public final class OpenCloseTime {
    private final String closeTime;
    private final String openTime;

    public static /* synthetic */ OpenCloseTime copy$default(OpenCloseTime openCloseTime, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = openCloseTime.openTime;
        }
        if ((i2 & 2) != 0) {
            str2 = openCloseTime.closeTime;
        }
        return openCloseTime.copy(str, str2);
    }

    public final String component1() {
        return this.openTime;
    }

    public final String component2() {
        return this.closeTime;
    }

    public final OpenCloseTime copy(String str, String str2) {
        k.c(str, "openTime");
        k.c(str2, "closeTime");
        return new OpenCloseTime(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenCloseTime)) {
            return false;
        }
        OpenCloseTime openCloseTime = (OpenCloseTime) obj;
        return k.a((Object) this.openTime, (Object) openCloseTime.openTime) && k.a((Object) this.closeTime, (Object) openCloseTime.closeTime);
    }

    public final int hashCode() {
        String str = this.openTime;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.closeTime;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OpenCloseTime(openTime=" + this.openTime + ", closeTime=" + this.closeTime + ")";
    }

    public OpenCloseTime(String str, String str2) {
        k.c(str, "openTime");
        k.c(str2, "closeTime");
        this.openTime = str;
        this.closeTime = str2;
    }

    public final String getCloseTime() {
        return this.closeTime;
    }

    public final String getOpenTime() {
        return this.openTime;
    }
}
