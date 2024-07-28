package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightMBChargeFlightItem extends IJRPaytmDataModel {
    @b(a = "aircraftTypeDisplayName")
    private String aircraftTypeDisplayName;
    @b(a = "airline")
    private String airline;
    @b(a = "airline_iata_code")
    private String airline_iata_code;
    @b(a = "airline_logo")
    private String airline_logo;
    @b(a = "arrival_date_local")
    private String arrival_date_local;
    @b(a = "departure_date_local")
    private String departure_date_local;
    @b(a = "destination")
    private String destination;
    @b(a = "destination_airport")
    private String destination_airport;
    @b(a = "destination_iata")
    private String destination_iata;
    @b(a = "direction")
    private String direction;
    @b(a = "duration")
    private String duration;
    @b(a = "flight_no")
    private String flight_no;
    @b(a = "item_id")
    private String item_id;
    @b(a = "origin")
    private String origin;
    @b(a = "origin_airport")
    private String origin_airport;
    @b(a = "origin_iata")
    private String origin_iata;

    public CJRFlightMBChargeFlightItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 65535, (g) null);
    }

    public final String getAirline() {
        return this.airline;
    }

    public final void setAirline(String str) {
        this.airline = str;
    }

    public final String getAirline_iata_code() {
        return this.airline_iata_code;
    }

    public final void setAirline_iata_code(String str) {
        this.airline_iata_code = str;
    }

    public final String getAirline_logo() {
        return this.airline_logo;
    }

    public final void setAirline_logo(String str) {
        this.airline_logo = str;
    }

    public final String getAircraftTypeDisplayName() {
        return this.aircraftTypeDisplayName;
    }

    public final void setAircraftTypeDisplayName(String str) {
        this.aircraftTypeDisplayName = str;
    }

    public final String getArrival_date_local() {
        return this.arrival_date_local;
    }

    public final void setArrival_date_local(String str) {
        this.arrival_date_local = str;
    }

    public final String getDeparture_date_local() {
        return this.departure_date_local;
    }

    public final void setDeparture_date_local(String str) {
        this.departure_date_local = str;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final String getDestination_airport() {
        return this.destination_airport;
    }

    public final void setDestination_airport(String str) {
        this.destination_airport = str;
    }

    public final String getDestination_iata() {
        return this.destination_iata;
    }

    public final void setDestination_iata(String str) {
        this.destination_iata = str;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final void setDirection(String str) {
        this.direction = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getFlight_no() {
        return this.flight_no;
    }

    public final void setFlight_no(String str) {
        this.flight_no = str;
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final void setItem_id(String str) {
        this.item_id = str;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final void setOrigin(String str) {
        this.origin = str;
    }

    public final String getOrigin_airport() {
        return this.origin_airport;
    }

    public final void setOrigin_airport(String str) {
        this.origin_airport = str;
    }

    public CJRFlightMBChargeFlightItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.airline = str;
        this.airline_iata_code = str2;
        this.airline_logo = str3;
        this.aircraftTypeDisplayName = str4;
        this.arrival_date_local = str5;
        this.departure_date_local = str6;
        this.destination = str7;
        this.destination_airport = str8;
        this.destination_iata = str9;
        this.direction = str10;
        this.duration = str11;
        this.flight_no = str12;
        this.item_id = str13;
        this.origin = str14;
        this.origin_airport = str15;
        this.origin_iata = str16;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRFlightMBChargeFlightItem(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.g.b.g r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r22
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r23
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r24
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r25
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r26
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r27
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r28
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r29
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r30
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r31
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r32
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0083
            r0 = 0
            goto L_0x0085
        L_0x0083:
            r0 = r33
        L_0x0085:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getOrigin_iata() {
        return this.origin_iata;
    }

    public final void setOrigin_iata(String str) {
        this.origin_iata = str;
    }
}
