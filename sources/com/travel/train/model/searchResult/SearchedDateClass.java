package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SearchedDateClass extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "availability_type")
    private String availability_type;
    @a
    @b(a = "background-colour")
    private String background_colour;
    @a
    @b(a = "name")
    private String className;
    @a
    @b(a = "code")
    private String classType;
    @a
    @b(a = "colour")
    private String colour;
    @a
    @b(a = "fare")
    private String fare;
    private boolean isCreated;
    @a
    @b(a = "pnr_prediction")
    private CJRSearchPNRPrediction mSearchPNRPrediction;
    @a
    @b(a = "quota")
    private String quota;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "text-colour")
    private String text_colour;
    @a
    @b(a = "time_diff")
    private String timeDiff;
    @a
    @b(a = "time_of_availability")
    private String timeOfAvailability;
    @a
    @b(a = "tip_text")
    private String tipText;

    public SearchedDateClass() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRSearchPNRPrediction) null, false, 16383, (g) null);
    }

    public final String getClassType() {
        return this.classType;
    }

    public final void setClassType(String str) {
        this.classType = str;
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getFare() {
        return this.fare;
    }

    public final void setFare(String str) {
        this.fare = str;
    }

    public final String getAvailability_type() {
        return this.availability_type;
    }

    public final void setAvailability_type(String str) {
        this.availability_type = str;
    }

    public final String getBackground_colour() {
        return this.background_colour;
    }

    public final void setBackground_colour(String str) {
        this.background_colour = str;
    }

    public final String getText_colour() {
        return this.text_colour;
    }

    public final void setText_colour(String str) {
        this.text_colour = str;
    }

    public final String getColour() {
        return this.colour;
    }

    public final void setColour(String str) {
        this.colour = str;
    }

    public final String getTimeOfAvailability() {
        return this.timeOfAvailability;
    }

    public final void setTimeOfAvailability(String str) {
        this.timeOfAvailability = str;
    }

    public final String getTimeDiff() {
        return this.timeDiff;
    }

    public final void setTimeDiff(String str) {
        this.timeDiff = str;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final void setTipText(String str) {
        this.tipText = str;
    }

    public final String getQuota() {
        return this.quota;
    }

    public final void setQuota(String str) {
        this.quota = str;
    }

    public final CJRSearchPNRPrediction getMSearchPNRPrediction() {
        return this.mSearchPNRPrediction;
    }

    public final void setMSearchPNRPrediction(CJRSearchPNRPrediction cJRSearchPNRPrediction) {
        this.mSearchPNRPrediction = cJRSearchPNRPrediction;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SearchedDateClass(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, com.travel.train.model.searchResult.CJRSearchPNRPrediction r28, boolean r29, int r30, kotlin.g.b.g r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r2 = r28
        L_0x006a:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            r0 = 0
            goto L_0x0072
        L_0x0070:
            r0 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r2
            r30 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.searchResult.SearchedDateClass.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.travel.train.model.searchResult.CJRSearchPNRPrediction, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isCreated() {
        return this.isCreated;
    }

    public final void setCreated(boolean z) {
        this.isCreated = z;
    }

    public SearchedDateClass(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, CJRSearchPNRPrediction cJRSearchPNRPrediction, boolean z) {
        this.classType = str;
        this.className = str2;
        this.status = str3;
        this.fare = str4;
        this.availability_type = str5;
        this.background_colour = str6;
        this.text_colour = str7;
        this.colour = str8;
        this.timeOfAvailability = str9;
        this.timeDiff = str10;
        this.tipText = str11;
        this.quota = str12;
        this.mSearchPNRPrediction = cJRSearchPNRPrediction;
        this.isCreated = z;
    }
}
