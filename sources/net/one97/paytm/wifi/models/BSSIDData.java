package net.one97.paytm.wifi.models;

import kotlin.g.b.k;

public final class BSSIDData {
    private final String bssid;
    private final int rssi;
    private final int signalStrength;

    public static /* synthetic */ BSSIDData copy$default(BSSIDData bSSIDData, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = bSSIDData.bssid;
        }
        if ((i4 & 2) != 0) {
            i2 = bSSIDData.signalStrength;
        }
        if ((i4 & 4) != 0) {
            i3 = bSSIDData.rssi;
        }
        return bSSIDData.copy(str, i2, i3);
    }

    public final String component1() {
        return this.bssid;
    }

    public final int component2() {
        return this.signalStrength;
    }

    public final int component3() {
        return this.rssi;
    }

    public final BSSIDData copy(String str, int i2, int i3) {
        k.c(str, "bssid");
        return new BSSIDData(str, i2, i3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BSSIDData) {
                BSSIDData bSSIDData = (BSSIDData) obj;
                if (k.a((Object) this.bssid, (Object) bSSIDData.bssid)) {
                    if (this.signalStrength == bSSIDData.signalStrength) {
                        if (this.rssi == bSSIDData.rssi) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.bssid;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.signalStrength) * 31) + this.rssi;
    }

    public final String toString() {
        return "BSSIDData(bssid=" + this.bssid + ", signalStrength=" + this.signalStrength + ", rssi=" + this.rssi + ")";
    }

    public BSSIDData(String str, int i2, int i3) {
        k.c(str, "bssid");
        this.bssid = str;
        this.signalStrength = i2;
        this.rssi = i3;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final int getSignalStrength() {
        return this.signalStrength;
    }
}
