package net.one97.paytm.wifi.models;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;

public final class WifiConnection {
    private final String BSSID;
    private final String SSID;
    private final String ipAddress;
    private final int linkSpeed;
    private int rssi = -100;
    private int signalStrength;

    public static /* synthetic */ WifiConnection copy$default(WifiConnection wifiConnection, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = wifiConnection.SSID;
        }
        if ((i3 & 2) != 0) {
            str2 = wifiConnection.BSSID;
        }
        if ((i3 & 4) != 0) {
            str3 = wifiConnection.ipAddress;
        }
        if ((i3 & 8) != 0) {
            i2 = wifiConnection.linkSpeed;
        }
        return wifiConnection.copy(str, str2, str3, i2);
    }

    public final String component1() {
        return this.SSID;
    }

    public final String component2() {
        return this.BSSID;
    }

    public final String component3() {
        return this.ipAddress;
    }

    public final int component4() {
        return this.linkSpeed;
    }

    public final WifiConnection copy(String str, String str2, String str3, int i2) {
        k.c(str, "SSID");
        k.c(str2, "BSSID");
        k.c(str3, NearbyRequestCreator.NearbyRequestConstants.ipAddress);
        return new WifiConnection(str, str2, str3, i2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WifiConnection) {
                WifiConnection wifiConnection = (WifiConnection) obj;
                if (k.a((Object) this.SSID, (Object) wifiConnection.SSID) && k.a((Object) this.BSSID, (Object) wifiConnection.BSSID) && k.a((Object) this.ipAddress, (Object) wifiConnection.ipAddress)) {
                    if (this.linkSpeed == wifiConnection.linkSpeed) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.SSID;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.BSSID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ipAddress;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.linkSpeed;
    }

    public WifiConnection(String str, String str2, String str3, int i2) {
        k.c(str, "SSID");
        k.c(str2, "BSSID");
        k.c(str3, NearbyRequestCreator.NearbyRequestConstants.ipAddress);
        this.SSID = str;
        this.BSSID = str2;
        this.ipAddress = str3;
        this.linkSpeed = i2;
    }

    public final String getSSID() {
        return this.SSID;
    }

    public final String getBSSID() {
        return this.BSSID;
    }

    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final int getLinkSpeed() {
        return this.linkSpeed;
    }

    public final int getSignalStrength() {
        return this.signalStrength;
    }

    public final void setSignalStrength(int i2) {
        this.signalStrength = i2;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final void setRssi(int i2) {
        this.rssi = i2;
    }

    public final String toString() {
        return "WifiConnection(SSID='" + this.SSID + "', BSSID='" + this.BSSID + "', ipAddress='" + this.ipAddress + "', linkSpeed=" + this.linkSpeed + ',' + " signalStrength=" + this.signalStrength + ", rssi=" + this.rssi + ')';
    }
}
