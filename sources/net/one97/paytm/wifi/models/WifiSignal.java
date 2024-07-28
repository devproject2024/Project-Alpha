package net.one97.paytm.wifi.models;

import kotlin.g.b.k;

public final class WifiSignal {
    private final int centerFrequency;
    private final int level;
    private final int primaryFrequency;
    private final WiFiWidth wiFiWidth;

    public static /* synthetic */ WifiSignal copy$default(WifiSignal wifiSignal, int i2, int i3, int i4, WiFiWidth wiFiWidth2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = wifiSignal.primaryFrequency;
        }
        if ((i5 & 2) != 0) {
            i3 = wifiSignal.centerFrequency;
        }
        if ((i5 & 4) != 0) {
            i4 = wifiSignal.level;
        }
        if ((i5 & 8) != 0) {
            wiFiWidth2 = wifiSignal.wiFiWidth;
        }
        return wifiSignal.copy(i2, i3, i4, wiFiWidth2);
    }

    public final int component1() {
        return this.primaryFrequency;
    }

    public final int component2() {
        return this.centerFrequency;
    }

    public final int component3() {
        return this.level;
    }

    public final WiFiWidth component4() {
        return this.wiFiWidth;
    }

    public final WifiSignal copy(int i2, int i3, int i4, WiFiWidth wiFiWidth2) {
        k.c(wiFiWidth2, "wiFiWidth");
        return new WifiSignal(i2, i3, i4, wiFiWidth2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WifiSignal) {
                WifiSignal wifiSignal = (WifiSignal) obj;
                if (this.primaryFrequency == wifiSignal.primaryFrequency) {
                    if (this.centerFrequency == wifiSignal.centerFrequency) {
                        if (!(this.level == wifiSignal.level) || !k.a((Object) this.wiFiWidth, (Object) wifiSignal.wiFiWidth)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = ((((this.primaryFrequency * 31) + this.centerFrequency) * 31) + this.level) * 31;
        WiFiWidth wiFiWidth2 = this.wiFiWidth;
        return i2 + (wiFiWidth2 != null ? wiFiWidth2.hashCode() : 0);
    }

    public final String toString() {
        return "WifiSignal(primaryFrequency=" + this.primaryFrequency + ", centerFrequency=" + this.centerFrequency + ", level=" + this.level + ", wiFiWidth=" + this.wiFiWidth + ")";
    }

    public WifiSignal(int i2, int i3, int i4, WiFiWidth wiFiWidth2) {
        k.c(wiFiWidth2, "wiFiWidth");
        this.primaryFrequency = i2;
        this.centerFrequency = i3;
        this.level = i4;
        this.wiFiWidth = wiFiWidth2;
    }

    public final int getPrimaryFrequency() {
        return this.primaryFrequency;
    }

    public final int getCenterFrequency() {
        return this.centerFrequency;
    }

    public final int getLevel() {
        return this.level;
    }

    public final WiFiWidth getWiFiWidth() {
        return this.wiFiWidth;
    }
}
