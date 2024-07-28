package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainRecentsItemModel extends IJRPaytmDataModel implements IJRDataModel {
    private String dateOfTravel;
    private int destSelectedPosition;
    private String destinationAirportName;
    private String destinationCityCode;
    private String destinationCityName;
    private long serialVersionUID;
    private String sourceAirportName;
    private String sourceCityCode;
    private String sourceCityName;
    private int sourceSelectedPosition;
    private String trainName;
    private String trainNumber;

    public CJRTrainRecentsItemModel() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, 4095, (g) null);
    }

    public final long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public final void setSerialVersionUID(long j) {
        this.serialVersionUID = j;
    }

    public final String getSourceCityName() {
        return this.sourceCityName;
    }

    public final void setSourceCityName(String str) {
        this.sourceCityName = str;
    }

    public final String getSourceCityCode() {
        return this.sourceCityCode;
    }

    public final void setSourceCityCode(String str) {
        this.sourceCityCode = str;
    }

    public final String getDestinationCityName() {
        return this.destinationCityName;
    }

    public final void setDestinationCityName(String str) {
        this.destinationCityName = str;
    }

    public final String getDestinationCityCode() {
        return this.destinationCityCode;
    }

    public final void setDestinationCityCode(String str) {
        this.destinationCityCode = str;
    }

    public final String getSourceAirportName() {
        return this.sourceAirportName;
    }

    public final void setSourceAirportName(String str) {
        this.sourceAirportName = str;
    }

    public final String getDestinationAirportName() {
        return this.destinationAirportName;
    }

    public final void setDestinationAirportName(String str) {
        this.destinationAirportName = str;
    }

    public final String getDateOfTravel() {
        return this.dateOfTravel;
    }

    public final void setDateOfTravel(String str) {
        this.dateOfTravel = str;
    }

    public final String getTrainName() {
        return this.trainName;
    }

    public final void setTrainName(String str) {
        this.trainName = str;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    public final void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public final int getSourceSelectedPosition() {
        return this.sourceSelectedPosition;
    }

    public final void setSourceSelectedPosition(int i2) {
        this.sourceSelectedPosition = i2;
    }

    public CJRTrainRecentsItemModel(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, int i3) {
        this.serialVersionUID = j;
        this.sourceCityName = str;
        this.sourceCityCode = str2;
        this.destinationCityName = str3;
        this.destinationCityCode = str4;
        this.sourceAirportName = str5;
        this.destinationAirportName = str6;
        this.dateOfTravel = str7;
        this.trainName = str8;
        this.trainNumber = str9;
        this.sourceSelectedPosition = i2;
        this.destSelectedPosition = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainRecentsItemModel(long r15, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, int r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 1
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = r4
            goto L_0x001b
        L_0x0019:
            r5 = r18
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = r4
            goto L_0x0023
        L_0x0021:
            r6 = r19
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r4
            goto L_0x002b
        L_0x0029:
            r7 = r20
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r4
            goto L_0x0033
        L_0x0031:
            r8 = r21
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r4
            goto L_0x003b
        L_0x0039:
            r9 = r22
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r4
            goto L_0x0043
        L_0x0041:
            r10 = r23
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r4
            goto L_0x004b
        L_0x0049:
            r11 = r24
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r4 = r25
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            r13 = 0
            if (r12 == 0) goto L_0x0059
            r12 = 0
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r13 = r27
        L_0x0062:
            r15 = r14
            r16 = r1
            r18 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r4
            r27 = r12
            r28 = r13
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainRecentsItemModel.<init>(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, kotlin.g.b.g):void");
    }

    public final int getDestSelectedPosition() {
        return this.destSelectedPosition;
    }

    public final void setDestSelectedPosition(int i2) {
        this.destSelectedPosition = i2;
    }
}
