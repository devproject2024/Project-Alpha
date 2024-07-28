package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CalendarData extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "availability_type")
    private int availability_type;
    @a
    @b(a = "background-colour")
    private String background_color;
    @a
    @b(a = "class")
    private String classTypeCalendar;
    @a
    @b(a = "date")
    private String dateCalendar;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "text-colour")
    private String text_colour;

    public CalendarData() {
        this((String) null, 0, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public final String getDateCalendar() {
        return this.dateCalendar;
    }

    public final void setDateCalendar(String str) {
        this.dateCalendar = str;
    }

    public final int getAvailability_type() {
        return this.availability_type;
    }

    public final void setAvailability_type(int i2) {
        this.availability_type = i2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getBackground_color() {
        return this.background_color;
    }

    public final void setBackground_color(String str) {
        this.background_color = str;
    }

    public final String getText_colour() {
        return this.text_colour;
    }

    public final void setText_colour(String str) {
        this.text_colour = str;
    }

    public CalendarData(String str, int i2, String str2, String str3, String str4, String str5) {
        this.dateCalendar = str;
        this.availability_type = i2;
        this.status = str2;
        this.background_color = str3;
        this.text_colour = str4;
        this.classTypeCalendar = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CalendarData(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000f
            r7 = 0
            r1 = 0
            goto L_0x0010
        L_0x000f:
            r1 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002b
            r12 = r0
            goto L_0x002c
        L_0x002b:
            r12 = r11
        L_0x002c:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.searchResult.CalendarData.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getClassTypeCalendar() {
        return this.classTypeCalendar;
    }

    public final void setClassTypeCalendar(String str) {
        this.classTypeCalendar = str;
    }
}
