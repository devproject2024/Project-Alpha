package com.paytm.analytics.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PaytmLocation {
    private Boolean gpslastState;
    private Float lastDistanceDelta;
    private Float latitude;
    private Float longitude;
    private Long time;

    public PaytmLocation() {
        this((Float) null, (Float) null, (Long) null, (Float) null, (Boolean) null, 31, (g) null);
    }

    public static /* synthetic */ PaytmLocation copy$default(PaytmLocation paytmLocation, Float f2, Float f3, Long l, Float f4, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = paytmLocation.latitude;
        }
        if ((i2 & 2) != 0) {
            f3 = paytmLocation.longitude;
        }
        Float f5 = f3;
        if ((i2 & 4) != 0) {
            l = paytmLocation.time;
        }
        Long l2 = l;
        if ((i2 & 8) != 0) {
            f4 = paytmLocation.lastDistanceDelta;
        }
        Float f6 = f4;
        if ((i2 & 16) != 0) {
            bool = paytmLocation.gpslastState;
        }
        return paytmLocation.copy(f2, f5, l2, f6, bool);
    }

    public final Float component1() {
        return this.latitude;
    }

    public final Float component2() {
        return this.longitude;
    }

    public final Long component3() {
        return this.time;
    }

    public final Float component4() {
        return this.lastDistanceDelta;
    }

    public final Boolean component5() {
        return this.gpslastState;
    }

    public final PaytmLocation copy(Float f2, Float f3, Long l, Float f4, Boolean bool) {
        return new PaytmLocation(f2, f3, l, f4, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaytmLocation)) {
            return false;
        }
        PaytmLocation paytmLocation = (PaytmLocation) obj;
        return k.a((Object) this.latitude, (Object) paytmLocation.latitude) && k.a((Object) this.longitude, (Object) paytmLocation.longitude) && k.a((Object) this.time, (Object) paytmLocation.time) && k.a((Object) this.lastDistanceDelta, (Object) paytmLocation.lastDistanceDelta) && k.a((Object) this.gpslastState, (Object) paytmLocation.gpslastState);
    }

    public final int hashCode() {
        Float f2 = this.latitude;
        int i2 = 0;
        int hashCode = (f2 != null ? f2.hashCode() : 0) * 31;
        Float f3 = this.longitude;
        int hashCode2 = (hashCode + (f3 != null ? f3.hashCode() : 0)) * 31;
        Long l = this.time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Float f4 = this.lastDistanceDelta;
        int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 31;
        Boolean bool = this.gpslastState;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "PaytmLocation(latitude=" + this.latitude + ", longitude=" + this.longitude + ", time=" + this.time + ", lastDistanceDelta=" + this.lastDistanceDelta + ", gpslastState=" + this.gpslastState + ")";
    }

    public PaytmLocation(Float f2, Float f3, Long l, Float f4, Boolean bool) {
        this.latitude = f2;
        this.longitude = f3;
        this.time = l;
        this.lastDistanceDelta = f4;
        this.gpslastState = bool;
    }

    public final Float getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(Float f2) {
        this.latitude = f2;
    }

    public final Float getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(Float f2) {
        this.longitude = f2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaytmLocation(java.lang.Float r4, java.lang.Float r5, java.lang.Long r6, java.lang.Float r7, java.lang.Boolean r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            if (r10 == 0) goto L_0x000b
            r10 = r0
            goto L_0x000c
        L_0x000b:
            r10 = r4
        L_0x000c:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x0012
            r1 = r0
            goto L_0x0013
        L_0x0012:
            r1 = r5
        L_0x0013:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x001d
            r4 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r4)
        L_0x001d:
            r2 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r7
        L_0x0024:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x002a
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
        L_0x002a:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.models.PaytmLocation.<init>(java.lang.Float, java.lang.Float, java.lang.Long, java.lang.Float, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final Float getLastDistanceDelta() {
        return this.lastDistanceDelta;
    }

    public final void setLastDistanceDelta(Float f2) {
        this.lastDistanceDelta = f2;
    }

    public final Boolean getGpslastState() {
        return this.gpslastState;
    }

    public final void setGpslastState(Boolean bool) {
        this.gpslastState = bool;
    }
}
