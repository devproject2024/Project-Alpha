package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.Map;

public final class d implements Serializable {
    @c(a = "berths")
    private Map<String, String> berths;
    @c(a = "booking_status")
    private Map<String, String> bookingStatus;
    @c(a = "classes")
    private Map<String, String> classes;

    public final Map<String, String> getBerths() {
        return this.berths;
    }

    public final void setBerths(Map<String, String> map) {
        this.berths = map;
    }

    public final Map<String, String> getClasses() {
        return this.classes;
    }

    public final void setClasses(Map<String, String> map) {
        this.classes = map;
    }

    public final Map<String, String> getBookingStatus() {
        return this.bookingStatus;
    }

    public final void setBookingStatus(Map<String, String> map) {
        this.bookingStatus = map;
    }
}
