package com.paytm.analytics.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class LocationEvent {
    public static final Companion Companion = new Companion((g) null);
    public static final String EVENT_TYPE_LOCATION_EVENT = "location_event";
    private Double latitude;
    private Double longitude;
    private Float speed;

    public LocationEvent() {
        this((Double) null, (Double) null, (Float) null, 7, (g) null);
    }

    public static /* synthetic */ LocationEvent copy$default(LocationEvent locationEvent, Double d2, Double d3, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = locationEvent.latitude;
        }
        if ((i2 & 2) != 0) {
            d3 = locationEvent.longitude;
        }
        if ((i2 & 4) != 0) {
            f2 = locationEvent.speed;
        }
        return locationEvent.copy(d2, d3, f2);
    }

    public final Double component1() {
        return this.latitude;
    }

    public final Double component2() {
        return this.longitude;
    }

    public final Float component3() {
        return this.speed;
    }

    public final LocationEvent copy(Double d2, Double d3, Float f2) {
        return new LocationEvent(d2, d3, f2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationEvent)) {
            return false;
        }
        LocationEvent locationEvent = (LocationEvent) obj;
        return k.a((Object) this.latitude, (Object) locationEvent.latitude) && k.a((Object) this.longitude, (Object) locationEvent.longitude) && k.a((Object) this.speed, (Object) locationEvent.speed);
    }

    public final int hashCode() {
        Double d2 = this.latitude;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Double d3 = this.longitude;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 31;
        Float f2 = this.speed;
        if (f2 != null) {
            i2 = f2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "LocationEvent(latitude=" + this.latitude + ", longitude=" + this.longitude + ", speed=" + this.speed + ")";
    }

    public LocationEvent(Double d2, Double d3, Float f2) {
        this.latitude = d2;
        this.longitude = d3;
        this.speed = f2;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(Double d2) {
        this.latitude = d2;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(Double d2) {
        this.longitude = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LocationEvent(java.lang.Double r3, java.lang.Double r4, java.lang.Float r5, int r6, kotlin.g.b.g r7) {
        /*
            r2 = this;
            r7 = r6 & 1
            r0 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            if (r7 == 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x0010
            r4 = r0
        L_0x0010:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x0019
            r5 = 0
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
        L_0x0019:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.models.LocationEvent.<init>(java.lang.Double, java.lang.Double, java.lang.Float, int, kotlin.g.b.g):void");
    }

    public final Float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(Float f2) {
        this.speed = f2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
