package net.one97.paytm.wifi.models;

import java.util.List;
import kotlin.a.w;
import kotlin.g.b.k;

public final class WifiAccessPoint {
    private final String SSID;
    private List<BSSIDData> bssids = w.INSTANCE;
    private String capabilities;
    private String connectionStatus;
    private WifiAdditional wifiAdditional;
    private WifiSignal wifiSignal;

    public static /* synthetic */ WifiAccessPoint copy$default(WifiAccessPoint wifiAccessPoint, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wifiAccessPoint.SSID;
        }
        if ((i2 & 2) != 0) {
            str2 = wifiAccessPoint.capabilities;
        }
        return wifiAccessPoint.copy(str, str2);
    }

    public final String component1() {
        return this.SSID;
    }

    public final String component2() {
        return this.capabilities;
    }

    public final WifiAccessPoint copy(String str, String str2) {
        k.c(str, "SSID");
        k.c(str2, "capabilities");
        return new WifiAccessPoint(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiAccessPoint)) {
            return false;
        }
        WifiAccessPoint wifiAccessPoint = (WifiAccessPoint) obj;
        return k.a((Object) this.SSID, (Object) wifiAccessPoint.SSID) && k.a((Object) this.capabilities, (Object) wifiAccessPoint.capabilities);
    }

    public final int hashCode() {
        String str = this.SSID;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.capabilities;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public WifiAccessPoint(String str, String str2) {
        k.c(str, "SSID");
        k.c(str2, "capabilities");
        this.SSID = str;
        this.capabilities = str2;
    }

    public final String getCapabilities() {
        return this.capabilities;
    }

    public final String getSSID() {
        return this.SSID;
    }

    public final void setCapabilities(String str) {
        k.c(str, "<set-?>");
        this.capabilities = str;
    }

    public final WifiAdditional getWifiAdditional() {
        return this.wifiAdditional;
    }

    public final void setWifiAdditional(WifiAdditional wifiAdditional2) {
        this.wifiAdditional = wifiAdditional2;
    }

    public final WifiSignal getWifiSignal() {
        return this.wifiSignal;
    }

    public final void setWifiSignal(WifiSignal wifiSignal2) {
        this.wifiSignal = wifiSignal2;
    }

    public final List<BSSIDData> getBssids() {
        return this.bssids;
    }

    public final void setBssids(List<BSSIDData> list) {
        k.c(list, "<set-?>");
        this.bssids = list;
    }

    public final String getConnectionStatus() {
        return this.connectionStatus;
    }

    public final void setConnectionStatus(String str) {
        this.connectionStatus = str;
    }

    public final String toString() {
        return "WifiAccessPoint(SSID='" + this.SSID + "', capabilities='" + this.capabilities + "', wifiAdditional=" + this.wifiAdditional + ',' + " wifiSignal=" + this.wifiSignal + ", bssids=" + this.bssids + ')';
    }
}
