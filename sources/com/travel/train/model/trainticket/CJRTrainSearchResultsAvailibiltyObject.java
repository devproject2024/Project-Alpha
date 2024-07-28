package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsAvailibiltyObject extends IJRPaytmDataModel implements IJRDataModel {
    private String backgroundColour;
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
    private CJRTrainSearchResultsPNRPrediction mSearchPNRPrediction;
    @a
    @b(a = "quota")
    private String quota;
    @a
    @b(a = "status")
    private String status;
    @a
    @b(a = "time_diff")
    private final String timeDiff;
    @a
    @b(a = "time_of_availability")
    private final String timeOfAvailability;
    @a
    @b(a = "tip_text")
    private String tipText;
    private String txtColour;

    public CJRTrainSearchResultsAvailibiltyObject() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRTrainSearchResultsPNRPrediction) null, false, 8191, (g) null);
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

    public final String getTimeOfAvailability() {
        return this.timeOfAvailability;
    }

    public final String getTimeDiff() {
        return this.timeDiff;
    }

    public final String getColour() {
        return this.colour;
    }

    public final void setColour(String str) {
        this.colour = str;
    }

    public final String getTxtColour() {
        return this.txtColour;
    }

    public final void setTxtColour(String str) {
        this.txtColour = str;
    }

    public final String getBackgroundColour() {
        return this.backgroundColour;
    }

    public final void setBackgroundColour(String str) {
        this.backgroundColour = str;
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

    public final CJRTrainSearchResultsPNRPrediction getMSearchPNRPrediction() {
        return this.mSearchPNRPrediction;
    }

    public final void setMSearchPNRPrediction(CJRTrainSearchResultsPNRPrediction cJRTrainSearchResultsPNRPrediction) {
        this.mSearchPNRPrediction = cJRTrainSearchResultsPNRPrediction;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsAvailibiltyObject(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction r26, boolean r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r2 = r26
        L_0x0061:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            r0 = 0
            goto L_0x0069
        L_0x0067:
            r0 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r2
            r28 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isCreated() {
        return this.isCreated;
    }

    public final void setCreated(boolean z) {
        this.isCreated = z;
    }

    public CJRTrainSearchResultsAvailibiltyObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, CJRTrainSearchResultsPNRPrediction cJRTrainSearchResultsPNRPrediction, boolean z) {
        this.classType = str;
        this.className = str2;
        this.status = str3;
        this.fare = str4;
        this.timeOfAvailability = str5;
        this.timeDiff = str6;
        this.colour = str7;
        this.txtColour = str8;
        this.backgroundColour = str9;
        this.tipText = str10;
        this.quota = str11;
        this.mSearchPNRPrediction = cJRTrainSearchResultsPNRPrediction;
        this.isCreated = z;
    }
}
