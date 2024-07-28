package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsRunningOn extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "fri")
    private String fri;
    @a
    @b(a = "mon")
    private String mon;
    @a
    @b(a = "sat")
    private String sat;
    @a
    @b(a = "sun")
    private String sun;
    @a
    @b(a = "thu")
    private String thu;
    @a
    @b(a = "tue")
    private String tue;
    @a
    @b(a = "wed")
    private String wed;

    public CJRTrainSearchResultsRunningOn() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public final String getSun() {
        return this.sun;
    }

    public final void setSun(String str) {
        this.sun = str;
    }

    public final String getMon() {
        return this.mon;
    }

    public final void setMon(String str) {
        this.mon = str;
    }

    public final String getTue() {
        return this.tue;
    }

    public final void setTue(String str) {
        this.tue = str;
    }

    public final String getWed() {
        return this.wed;
    }

    public final void setWed(String str) {
        this.wed = str;
    }

    public final String getThu() {
        return this.thu;
    }

    public final void setThu(String str) {
        this.thu = str;
    }

    public final String getFri() {
        return this.fri;
    }

    public final void setFri(String str) {
        this.fri = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsRunningOn(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsRunningOn.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getSat() {
        return this.sat;
    }

    public final void setSat(String str) {
        this.sat = str;
    }

    public CJRTrainSearchResultsRunningOn(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.sun = str;
        this.mon = str2;
        this.tue = str3;
        this.wed = str4;
        this.thu = str5;
        this.fri = str6;
        this.sat = str7;
    }
}
