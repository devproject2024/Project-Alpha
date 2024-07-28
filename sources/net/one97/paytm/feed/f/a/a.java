package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;

public final class a implements Serializable {
    @c(a = "day_count")
    private String dayCount;
    @c(a = "departure_time")
    private String departureTime;
    @c(a = "station_code")
    private String stationCode;
    @c(a = "station_name")
    private String stationName;

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final void setDepartureTime(String str) {
        this.departureTime = str;
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
