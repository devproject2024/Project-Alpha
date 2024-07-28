package net.one97.paytm.wifi.models;

public final class WifiTimeData {
    private final long day;
    private final long hour;
    private final long minute;

    public static /* synthetic */ WifiTimeData copy$default(WifiTimeData wifiTimeData, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = wifiTimeData.day;
        }
        long j4 = j;
        if ((i2 & 2) != 0) {
            j2 = wifiTimeData.hour;
        }
        long j5 = j2;
        if ((i2 & 4) != 0) {
            j3 = wifiTimeData.minute;
        }
        return wifiTimeData.copy(j4, j5, j3);
    }

    public final long component1() {
        return this.day;
    }

    public final long component2() {
        return this.hour;
    }

    public final long component3() {
        return this.minute;
    }

    public final WifiTimeData copy(long j, long j2, long j3) {
        return new WifiTimeData(j, j2, j3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WifiTimeData) {
                WifiTimeData wifiTimeData = (WifiTimeData) obj;
                if (this.day == wifiTimeData.day) {
                    if (this.hour == wifiTimeData.hour) {
                        if (this.minute == wifiTimeData.minute) {
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
        long j = this.day;
        long j2 = this.hour;
        long j3 = this.minute;
        return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    public final String toString() {
        return "WifiTimeData(day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ")";
    }

    public WifiTimeData(long j, long j2, long j3) {
        this.day = j;
        this.hour = j2;
        this.minute = j3;
    }

    public final long getDay() {
        return this.day;
    }

    public final long getHour() {
        return this.hour;
    }

    public final long getMinute() {
        return this.minute;
    }
}
