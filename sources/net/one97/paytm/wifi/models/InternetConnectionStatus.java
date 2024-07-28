package net.one97.paytm.wifi.models;

import kotlin.g.b.k;

public final class InternetConnectionStatus {
    private final InternetStatus internetStatus;

    public static /* synthetic */ InternetConnectionStatus copy$default(InternetConnectionStatus internetConnectionStatus, InternetStatus internetStatus2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            internetStatus2 = internetConnectionStatus.internetStatus;
        }
        return internetConnectionStatus.copy(internetStatus2);
    }

    public final InternetStatus component1() {
        return this.internetStatus;
    }

    public final InternetConnectionStatus copy(InternetStatus internetStatus2) {
        k.c(internetStatus2, "internetStatus");
        return new InternetConnectionStatus(internetStatus2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof InternetConnectionStatus) && k.a((Object) this.internetStatus, (Object) ((InternetConnectionStatus) obj).internetStatus);
        }
        return true;
    }

    public final int hashCode() {
        InternetStatus internetStatus2 = this.internetStatus;
        if (internetStatus2 != null) {
            return internetStatus2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "InternetConnectionStatus(internetStatus=" + this.internetStatus + ")";
    }

    public InternetConnectionStatus(InternetStatus internetStatus2) {
        k.c(internetStatus2, "internetStatus");
        this.internetStatus = internetStatus2;
    }

    public final InternetStatus getInternetStatus() {
        return this.internetStatus;
    }
}
