package net.one97.paytm.wifi.models;

import kotlin.g.b.k;

public final class WifiConnectionStatus {
    private InternetStatus internetStatus;
    private final String message;
    private final ConnectionStatus status;

    public static /* synthetic */ WifiConnectionStatus copy$default(WifiConnectionStatus wifiConnectionStatus, ConnectionStatus connectionStatus, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            connectionStatus = wifiConnectionStatus.status;
        }
        if ((i2 & 2) != 0) {
            str = wifiConnectionStatus.message;
        }
        return wifiConnectionStatus.copy(connectionStatus, str);
    }

    public final ConnectionStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final WifiConnectionStatus copy(ConnectionStatus connectionStatus, String str) {
        k.c(connectionStatus, "status");
        k.c(str, "message");
        return new WifiConnectionStatus(connectionStatus, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiConnectionStatus)) {
            return false;
        }
        WifiConnectionStatus wifiConnectionStatus = (WifiConnectionStatus) obj;
        return k.a((Object) this.status, (Object) wifiConnectionStatus.status) && k.a((Object) this.message, (Object) wifiConnectionStatus.message);
    }

    public final int hashCode() {
        ConnectionStatus connectionStatus = this.status;
        int i2 = 0;
        int hashCode = (connectionStatus != null ? connectionStatus.hashCode() : 0) * 31;
        String str = this.message;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "WifiConnectionStatus(status=" + this.status + ", message=" + this.message + ")";
    }

    public WifiConnectionStatus(ConnectionStatus connectionStatus, String str) {
        k.c(connectionStatus, "status");
        k.c(str, "message");
        this.status = connectionStatus;
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ConnectionStatus getStatus() {
        return this.status;
    }

    public final InternetStatus getInternetStatus() {
        return this.internetStatus;
    }

    public final void setInternetStatus(InternetStatus internetStatus2) {
        this.internetStatus = internetStatus2;
    }
}
