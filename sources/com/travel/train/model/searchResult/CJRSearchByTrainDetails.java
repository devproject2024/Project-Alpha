package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSearchByTrainDetails extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "duration")
    private String duration;
    @a
    @b(a = "message")
    private DynamicPricingMessage dynamicPricingMessage;
    @a
    @b(a = "fareRange")
    private List<FareData> fareRange;
    @a
    @b(a = "fromStation")
    private FromStation fromStation;
    @a
    @b(a = "journeyClasses")
    private List<String> journeyClasses;
    @a
    @b(a = "quota")
    private List<String> quota;
    @a
    @b(a = "runningOn")
    private String runningOn;
    @a
    @b(a = "toStation")
    private ToStation toStation;
    @a
    @b(a = "trainFullName")
    private String trainFullName;
    @a
    @b(a = "trainName")
    private String trainName;
    @a
    @b(a = "trainNumber")
    private String trainNumber;
    @a
    @b(a = "train_type")
    private String trainType;

    public CJRSearchByTrainDetails() {
        this((String) null, (List) null, (String) null, (String) null, (String) null, (List) null, (String) null, (FromStation) null, (ToStation) null, (String) null, (DynamicPricingMessage) null, (List) null, 4095, (g) null);
    }

    public final String getTrainName() {
        return this.trainName;
    }

    public final void setTrainName(String str) {
        this.trainName = str;
    }

    public final List<String> getJourneyClasses() {
        return this.journeyClasses;
    }

    public final void setJourneyClasses(List<String> list) {
        this.journeyClasses = list;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    public final void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public final String getRunningOn() {
        return this.runningOn;
    }

    public final void setRunningOn(String str) {
        this.runningOn = str;
    }

    public final String getTrainFullName() {
        return this.trainFullName;
    }

    public final void setTrainFullName(String str) {
        this.trainFullName = str;
    }

    public final List<String> getQuota() {
        return this.quota;
    }

    public final void setQuota(List<String> list) {
        this.quota = list;
    }

    public final String getTrainType() {
        return this.trainType;
    }

    public final void setTrainType(String str) {
        this.trainType = str;
    }

    public final FromStation getFromStation() {
        return this.fromStation;
    }

    public final void setFromStation(FromStation fromStation2) {
        this.fromStation = fromStation2;
    }

    public final ToStation getToStation() {
        return this.toStation;
    }

    public final void setToStation(ToStation toStation2) {
        this.toStation = toStation2;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final DynamicPricingMessage getDynamicPricingMessage() {
        return this.dynamicPricingMessage;
    }

    public final void setDynamicPricingMessage(DynamicPricingMessage dynamicPricingMessage2) {
        this.dynamicPricingMessage = dynamicPricingMessage2;
    }

    public CJRSearchByTrainDetails(String str, List<String> list, String str2, String str3, String str4, List<String> list2, String str5, FromStation fromStation2, ToStation toStation2, String str6, DynamicPricingMessage dynamicPricingMessage2, List<FareData> list3) {
        this.trainName = str;
        this.journeyClasses = list;
        this.trainNumber = str2;
        this.runningOn = str3;
        this.trainFullName = str4;
        this.quota = list2;
        this.trainType = str5;
        this.fromStation = fromStation2;
        this.toStation = toStation2;
        this.duration = str6;
        this.dynamicPricingMessage = dynamicPricingMessage2;
        this.fareRange = list3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSearchByTrainDetails(java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List r19, java.lang.String r20, com.travel.train.model.searchResult.FromStation r21, com.travel.train.model.searchResult.ToStation r22, java.lang.String r23, com.travel.train.model.searchResult.DynamicPricingMessage r24, java.util.List r25, int r26, kotlin.g.b.g r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.searchResult.CJRSearchByTrainDetails.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, com.travel.train.model.searchResult.FromStation, com.travel.train.model.searchResult.ToStation, java.lang.String, com.travel.train.model.searchResult.DynamicPricingMessage, java.util.List, int, kotlin.g.b.g):void");
    }

    public final List<FareData> getFareRange() {
        return this.fareRange;
    }

    public final void setFareRange(List<FareData> list) {
        this.fareRange = list;
    }
}
