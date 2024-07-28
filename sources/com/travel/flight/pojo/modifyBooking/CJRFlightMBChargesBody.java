package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRFlightMBChargesBody extends IJRPaytmDataModel {
    @b(a = "class")
    private String bookingClass;
    @b(a = "cp_enabled")
    private Boolean cp_enabled;
    @b(a = "important")
    private CJRFlightMBImportant important;
    @b(a = "is_modifiable")
    private Boolean is_modifiable;
    @b(a = "onward")
    private CJRFlightMBRoute onwardItem;
    @b(a = "order_id")
    private long order_id;
    @b(a = "return")
    private CJRFlightMBRoute returnItem;
    @b(a = "search_date_range")
    private CJRFlightMBSearchDateRange search_date_range;
    @b(a = "static_body")
    private String static_body;

    public CJRFlightMBChargesBody() {
        this(0, (Boolean) null, (String) null, (Boolean) null, (CJRFlightMBRoute) null, (CJRFlightMBRoute) null, (CJRFlightMBImportant) null, (CJRFlightMBSearchDateRange) null, (String) null, 511, (g) null);
    }

    public final long getOrder_id() {
        return this.order_id;
    }

    public final void setOrder_id(long j) {
        this.order_id = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRFlightMBChargesBody(long r12, java.lang.Boolean r14, java.lang.String r15, java.lang.Boolean r16, com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r17, com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute r18, com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant r19, com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            java.lang.String r4 = ""
            goto L_0x001a
        L_0x0019:
            r4 = r15
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x0023
        L_0x0021:
            r5 = r16
        L_0x0023:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002a
            r6 = r7
            goto L_0x002c
        L_0x002a:
            r6 = r17
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r7
            goto L_0x0034
        L_0x0032:
            r8 = r18
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r7
            goto L_0x003c
        L_0x003a:
            r9 = r19
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r7
            goto L_0x0044
        L_0x0042:
            r10 = r20
        L_0x0044:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r7 = r21
        L_0x004b:
            r12 = r11
            r13 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r7
            r12.<init>(r13, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.pojo.modifyBooking.CJRFlightMBChargesBody.<init>(long, java.lang.Boolean, java.lang.String, java.lang.Boolean, com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute, com.travel.flight.pojo.modifyBooking.CJRFlightMBRoute, com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant, com.travel.flight.pojo.modifyBooking.CJRFlightMBSearchDateRange, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Boolean getCp_enabled() {
        return this.cp_enabled;
    }

    public final void setCp_enabled(Boolean bool) {
        this.cp_enabled = bool;
    }

    public final String getBookingClass() {
        return this.bookingClass;
    }

    public final void setBookingClass(String str) {
        k.c(str, "<set-?>");
        this.bookingClass = str;
    }

    public final Boolean is_modifiable() {
        return this.is_modifiable;
    }

    public final void set_modifiable(Boolean bool) {
        this.is_modifiable = bool;
    }

    public final CJRFlightMBRoute getOnwardItem() {
        return this.onwardItem;
    }

    public final void setOnwardItem(CJRFlightMBRoute cJRFlightMBRoute) {
        this.onwardItem = cJRFlightMBRoute;
    }

    public final CJRFlightMBRoute getReturnItem() {
        return this.returnItem;
    }

    public final void setReturnItem(CJRFlightMBRoute cJRFlightMBRoute) {
        this.returnItem = cJRFlightMBRoute;
    }

    public final CJRFlightMBImportant getImportant() {
        return this.important;
    }

    public final void setImportant(CJRFlightMBImportant cJRFlightMBImportant) {
        this.important = cJRFlightMBImportant;
    }

    public final CJRFlightMBSearchDateRange getSearch_date_range() {
        return this.search_date_range;
    }

    public final void setSearch_date_range(CJRFlightMBSearchDateRange cJRFlightMBSearchDateRange) {
        this.search_date_range = cJRFlightMBSearchDateRange;
    }

    public CJRFlightMBChargesBody(long j, Boolean bool, String str, Boolean bool2, CJRFlightMBRoute cJRFlightMBRoute, CJRFlightMBRoute cJRFlightMBRoute2, CJRFlightMBImportant cJRFlightMBImportant, CJRFlightMBSearchDateRange cJRFlightMBSearchDateRange, String str2) {
        k.c(str, "bookingClass");
        this.order_id = j;
        this.cp_enabled = bool;
        this.bookingClass = str;
        this.is_modifiable = bool2;
        this.onwardItem = cJRFlightMBRoute;
        this.returnItem = cJRFlightMBRoute2;
        this.important = cJRFlightMBImportant;
        this.search_date_range = cJRFlightMBSearchDateRange;
        this.static_body = str2;
    }

    public final String getStatic_body() {
        return this.static_body;
    }

    public final void setStatic_body(String str) {
        this.static_body = str;
    }
}
