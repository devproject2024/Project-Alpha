package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsClasses extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "1A")
    private String _1A;
    @a
    @b(a = "2A")
    private String _2A;
    @a
    @b(a = "2S")
    private String _2S;
    @a
    @b(a = "3A")
    private String _3A;
    @a
    @b(a = "3E")
    private String _3E;
    @a
    @b(a = "CC")
    private String cC;
    @a
    @b(a = "FC")
    private String fC;
    @a
    @b(a = "SL")
    private String sL;

    public CJRTrainSearchResultsClasses() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public final String get_1A() {
        return this._1A;
    }

    public final void set_1A(String str) {
        this._1A = str;
    }

    public final String get_2A() {
        return this._2A;
    }

    public final void set_2A(String str) {
        this._2A = str;
    }

    public final String getFC() {
        return this.fC;
    }

    public final void setFC(String str) {
        this.fC = str;
    }

    public final String get_3A() {
        return this._3A;
    }

    public final void set_3A(String str) {
        this._3A = str;
    }

    public final String get_3E() {
        return this._3E;
    }

    public final void set_3E(String str) {
        this._3E = str;
    }

    public final String getCC() {
        return this.cC;
    }

    public final void setCC(String str) {
        this.cC = str;
    }

    public final String getSL() {
        return this.sL;
    }

    public final void setSL(String str) {
        this.sL = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsClasses(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsClasses.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String get_2S() {
        return this._2S;
    }

    public final void set_2S(String str) {
        this._2S = str;
    }

    public CJRTrainSearchResultsClasses(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this._1A = str;
        this._2A = str2;
        this.fC = str3;
        this._3A = str4;
        this._3E = str5;
        this.cC = str6;
        this.sL = str7;
        this._2S = str8;
    }
}
