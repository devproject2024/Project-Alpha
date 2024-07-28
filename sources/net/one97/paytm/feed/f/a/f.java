package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;

public final class f implements Serializable {
    @c(a = "arrival_time")
    private String arrivalTime;
    @c(a = "day_count")
    private String dayCount;
    @c(a = "station_code")
    private String stationCode;
    @c(a = "station_name")
    private String stationName;

    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    public final void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public final String getDayCount() {
        return this.dayCount;
    }

    public final void setDayCount(String str) {
        this.dayCount = str;
    }

    public final String getStationCode() {
        return this.stationCode;
    }

    public final void setStationCode(String str) {
        this.stationCode = str;
    }

    public final String getStationName() {
        return this.stationName;
    }

    public final void setStationName(String str) {
        this.stationName = str;
    }
}
