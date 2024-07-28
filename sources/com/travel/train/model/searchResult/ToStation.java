package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ToStation extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "arrivalDate")
    private String arrivalDate;
    @a
    @b(a = "arrivalDay")
    private String arrivalDay;
    @a
    @b(a = "arrivalTime")
    private String arrivalTime;
    @a
    @b(a = "stationCode")
    private String stationCode;
    @a
    @b(a = "stationName")
    private String stationName;

    public ToStation() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
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

    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    public final void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public final String getArrivalDay() {
        return this.arrivalDay;
    }

    public final void setArrivalDay(String str) {
        this.arrivalDay = str;
    }

    public ToStation(String str, String str2, String str3, String str4, String str5) {
        this.stationCode = str;
        this.stationName = str2;
        this.arrivalTime = str3;
        this.arrivalDay = str4;
        this.arrivalDate = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ToStation(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.searchResult.ToStation.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getArrivalDate() {
        return this.arrivalDate;
    }

    public final void setArrivalDate(String str) {
        this.arrivalDate = str;
    }
}
