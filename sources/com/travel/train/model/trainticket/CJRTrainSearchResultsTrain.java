package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsTrain extends IJRPaytmDataModel implements Cloneable, IJRDataModel {
    @a
    @b(a = "alternate_stations_data")
    private List<CJRTrainSearchResultsAlternateStationData> alternateStationsData;
    @a
    @b(a = "alternate_stations_text")
    private String alternateStationsText;
    @a
    @b(a = "alternate_stations_title")
    private String alternateStationsTitle;
    @a
    @b(a = "arrival")
    private String arrival;
    private String arrivalTime;
    @a
    @b(a = "boarding_station")
    private String boardingStation;
    private boolean checked;
    @a
    @b(a = "classes")
    private List<String> classes;
    @a
    @b(a = "delay_info")
    private final CJRTrainSearchResultsDelayInfo delayInfo;
    @a
    @b(a = "delay_score")
    private final int delayScore;
    @a
    @b(a = "departure")
    private String departure;
    private String departureTime;
    @a
    @b(a = "destination")
    private String destination;
    @b(a = "destination_name")
    private String destinationName;
    @b(a = "duration")
    private String duration;
    private String dynamicPricingMessage;
    @b(a = "alternate_stations")
    private boolean isAlternateStationEnabled;
    private boolean isDynamicPricingEnable;
    @b(a = "message_enabled")
    private boolean isMessageEnable;
    private boolean isSearchByTrainResult;
    @b(a = "alternate_confirm_availability")
    private final String mAlternateConfirmAvailibility;
    @b(a = "availability")
    private ArrayList<CJRTrainSearchResultsAvailibiltyObject> mAvailability;
    private boolean mIsCollapse;
    private String mSearchedTrainArrivalTime;
    private String mSearchedTrainDepartureTime;
    @b(a = "message_text")
    private String message;
    private String mirctcuserid;
    @a
    @b(a = "train_name")
    private String quickTrainName;
    @a
    @b(a = "train_number")
    private String quickTrainNumber;
    @a
    @b(a = "quota")
    private String quota;
    @a
    @b(a = "runningOn")
    private CJRTrainSearchResultsRunningOn runningOn;
    @a
    @b(a = "runs_on")
    private String runsOn;
    @a
    @b(a = "source")
    private String source;
    @b(a = "source_name")
    private String sourceName;
    @a
    @b(a = "class")
    private String trainClass;
    @a
    @b(a = "trainName")
    private String trainName;
    @a
    @b(a = "trainNumber")
    private String trainNumber;
    @b(a = "train_type")
    private String trainType;
    private boolean viewMoreClicked;

    public CJRTrainSearchResultsTrain() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (CJRTrainSearchResultsRunningOn) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (CJRTrainSearchResultsDelayInfo) null, false, false, false, (String) null, false, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, false, (List) null, (String) null, (String) null, false, (String) null, (String) null, -1, 127, (g) null);
    }

    public final String getDeparture() {
        return this.departure;
    }

    public final void setDeparture(String str) {
        this.departure = str;
    }

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final void setDepartureTime(String str) {
        this.departureTime = str;
    }

    public final String getArrival() {
        return this.arrival;
    }

    public final void setArrival(String str) {
        this.arrival = str;
    }

    public final String getArrivalTime() {
        return this.arrivalTime;
    }

    public final void setArrivalTime(String str) {
        this.arrivalTime = str;
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

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final CJRTrainSearchResultsRunningOn getRunningOn() {
        return this.runningOn;
    }

    public final void setRunningOn(CJRTrainSearchResultsRunningOn cJRTrainSearchResultsRunningOn) {
        this.runningOn = cJRTrainSearchResultsRunningOn;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsTrain(java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, com.travel.train.model.trainticket.CJRTrainSearchResultsRunningOn r48, java.util.List r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, int r56, com.travel.train.model.trainticket.CJRTrainSearchResultsDelayInfo r57, boolean r58, boolean r59, boolean r60, java.lang.String r61, boolean r62, java.lang.String r63, boolean r64, java.lang.String r65, java.lang.String r66, java.lang.String r67, java.lang.String r68, java.lang.String r69, java.util.ArrayList r70, java.lang.String r71, boolean r72, java.util.List r73, java.lang.String r74, java.lang.String r75, boolean r76, java.lang.String r77, java.lang.String r78, int r79, int r80, kotlin.g.b.g r81) {
        /*
            r39 = this;
            r0 = r79
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r40
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r41
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r42
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r43
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r44
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r45
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r46
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r47
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r48
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0056
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            goto L_0x0058
        L_0x0056:
            r11 = r49
        L_0x0058:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005e
            r12 = 0
            goto L_0x0060
        L_0x005e:
            r12 = r50
        L_0x0060:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0066
            r13 = 0
            goto L_0x0068
        L_0x0066:
            r13 = r51
        L_0x0068:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006e
            r14 = 0
            goto L_0x0070
        L_0x006e:
            r14 = r52
        L_0x0070:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0076
            r15 = 0
            goto L_0x0078
        L_0x0076:
            r15 = r53
        L_0x0078:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007e
            r2 = 0
            goto L_0x0080
        L_0x007e:
            r2 = r54
        L_0x0080:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008a
            r16 = 0
            goto L_0x008c
        L_0x008a:
            r16 = r55
        L_0x008c:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            r18 = 0
            if (r17 == 0) goto L_0x0097
            r17 = 0
            goto L_0x0099
        L_0x0097:
            r17 = r56
        L_0x0099:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a2
            r19 = 0
            goto L_0x00a4
        L_0x00a2:
            r19 = r57
        L_0x00a4:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00ad
            r20 = 0
            goto L_0x00af
        L_0x00ad:
            r20 = r58
        L_0x00af:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b8
            r21 = 0
            goto L_0x00ba
        L_0x00b8:
            r21 = r59
        L_0x00ba:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c3
            r22 = 0
            goto L_0x00c5
        L_0x00c3:
            r22 = r60
        L_0x00c5:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00ce
            r23 = 0
            goto L_0x00d0
        L_0x00ce:
            r23 = r61
        L_0x00d0:
            r24 = 4194304(0x400000, float:5.877472E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00d9
            r24 = 0
            goto L_0x00db
        L_0x00d9:
            r24 = r62
        L_0x00db:
            r25 = 8388608(0x800000, float:1.17549435E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e4
            r25 = 0
            goto L_0x00e6
        L_0x00e4:
            r25 = r63
        L_0x00e6:
            r26 = 16777216(0x1000000, float:2.3509887E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00ef
            r26 = 0
            goto L_0x00f1
        L_0x00ef:
            r26 = r64
        L_0x00f1:
            r27 = 33554432(0x2000000, float:9.403955E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fa
            r27 = 0
            goto L_0x00fc
        L_0x00fa:
            r27 = r65
        L_0x00fc:
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0105
            r28 = 0
            goto L_0x0107
        L_0x0105:
            r28 = r66
        L_0x0107:
            r29 = 134217728(0x8000000, float:3.85186E-34)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0110
            r29 = 0
            goto L_0x0112
        L_0x0110:
            r29 = r67
        L_0x0112:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011b
            r30 = 0
            goto L_0x011d
        L_0x011b:
            r30 = r68
        L_0x011d:
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0126
            r31 = 0
            goto L_0x0128
        L_0x0126:
            r31 = r69
        L_0x0128:
            r32 = 1073741824(0x40000000, float:2.0)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0134
            java.util.ArrayList r32 = new java.util.ArrayList
            r32.<init>()
            goto L_0x0136
        L_0x0134:
            r32 = r70
        L_0x0136:
            r33 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r33
            if (r0 == 0) goto L_0x013e
            r0 = 0
            goto L_0x0140
        L_0x013e:
            r0 = r71
        L_0x0140:
            r33 = r80 & 1
            if (r33 == 0) goto L_0x0145
            goto L_0x0147
        L_0x0145:
            r18 = r72
        L_0x0147:
            r33 = r80 & 2
            if (r33 == 0) goto L_0x014e
            r33 = 0
            goto L_0x0150
        L_0x014e:
            r33 = r73
        L_0x0150:
            r34 = r80 & 4
            if (r34 == 0) goto L_0x0157
            r34 = 0
            goto L_0x0159
        L_0x0157:
            r34 = r74
        L_0x0159:
            r35 = r80 & 8
            if (r35 == 0) goto L_0x0160
            r35 = 0
            goto L_0x0162
        L_0x0160:
            r35 = r75
        L_0x0162:
            r36 = r80 & 16
            if (r36 == 0) goto L_0x0169
            r36 = 1
            goto L_0x016b
        L_0x0169:
            r36 = r76
        L_0x016b:
            r37 = r80 & 32
            if (r37 == 0) goto L_0x0172
            r37 = 0
            goto L_0x0174
        L_0x0172:
            r37 = r77
        L_0x0174:
            r38 = r80 & 64
            if (r38 == 0) goto L_0x017b
            r38 = 0
            goto L_0x017d
        L_0x017b:
            r38 = r78
        L_0x017d:
            r40 = r39
            r41 = r1
            r42 = r3
            r43 = r4
            r44 = r5
            r45 = r6
            r46 = r7
            r47 = r8
            r48 = r9
            r49 = r10
            r50 = r11
            r51 = r12
            r52 = r13
            r53 = r14
            r54 = r15
            r55 = r2
            r56 = r16
            r57 = r17
            r58 = r19
            r59 = r20
            r60 = r21
            r61 = r22
            r62 = r23
            r63 = r24
            r64 = r25
            r65 = r26
            r66 = r27
            r67 = r28
            r68 = r29
            r69 = r30
            r70 = r31
            r71 = r32
            r72 = r0
            r73 = r18
            r74 = r33
            r75 = r34
            r76 = r35
            r77 = r36
            r78 = r37
            r79 = r38
            r40.<init>(r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsTrain.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.travel.train.model.trainticket.CJRTrainSearchResultsRunningOn, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.travel.train.model.trainticket.CJRTrainSearchResultsDelayInfo, boolean, boolean, boolean, java.lang.String, boolean, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, boolean, java.util.List, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, int, kotlin.g.b.g):void");
    }

    public final List<String> getClasses() {
        return this.classes;
    }

    public final void setClasses(List<String> list) {
        k.c(list, "<set-?>");
        this.classes = list;
    }

    public final String getBoardingStation() {
        return this.boardingStation;
    }

    public final void setBoardingStation(String str) {
        this.boardingStation = str;
    }

    public final String getQuota() {
        return this.quota;
    }

    public final void setQuota(String str) {
        this.quota = str;
    }

    public final String getTrainClass() {
        return this.trainClass;
    }

    public final void setTrainClass(String str) {
        this.trainClass = str;
    }

    public final String getRunsOn() {
        return this.runsOn;
    }

    public final void setRunsOn(String str) {
        this.runsOn = str;
    }

    public final String getQuickTrainName() {
        return this.quickTrainName;
    }

    public final void setQuickTrainName(String str) {
        this.quickTrainName = str;
    }

    public final String getQuickTrainNumber() {
        return this.quickTrainNumber;
    }

    public final void setQuickTrainNumber(String str) {
        this.quickTrainNumber = str;
    }

    public final int getDelayScore() {
        return this.delayScore;
    }

    public final CJRTrainSearchResultsDelayInfo getDelayInfo() {
        return this.delayInfo;
    }

    public final boolean getViewMoreClicked() {
        return this.viewMoreClicked;
    }

    public final void setViewMoreClicked(boolean z) {
        this.viewMoreClicked = z;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final boolean isMessageEnable() {
        return this.isMessageEnable;
    }

    public final void setMessageEnable(boolean z) {
        this.isMessageEnable = z;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final boolean isDynamicPricingEnable() {
        return this.isDynamicPricingEnable;
    }

    public final void setDynamicPricingEnable(boolean z) {
        this.isDynamicPricingEnable = z;
    }

    public final String getDynamicPricingMessage() {
        return this.dynamicPricingMessage;
    }

    public final void setDynamicPricingMessage(String str) {
        this.dynamicPricingMessage = str;
    }

    public final boolean isSearchByTrainResult() {
        return this.isSearchByTrainResult;
    }

    public final void setSearchByTrainResult(boolean z) {
        this.isSearchByTrainResult = z;
    }

    public final String getTrainType() {
        return this.trainType;
    }

    public final void setTrainType(String str) {
        this.trainType = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public final void setSourceName(String str) {
        this.sourceName = str;
    }

    public final String getDestinationName() {
        return this.destinationName;
    }

    public final void setDestinationName(String str) {
        this.destinationName = str;
    }

    public final String getMirctcuserid() {
        return this.mirctcuserid;
    }

    public final void setMirctcuserid(String str) {
        this.mirctcuserid = str;
    }

    public final ArrayList<CJRTrainSearchResultsAvailibiltyObject> getMAvailability() {
        return this.mAvailability;
    }

    public final void setMAvailability(ArrayList<CJRTrainSearchResultsAvailibiltyObject> arrayList) {
        k.c(arrayList, "<set-?>");
        this.mAvailability = arrayList;
    }

    public final String getMAlternateConfirmAvailibility() {
        return this.mAlternateConfirmAvailibility;
    }

    public final boolean isAlternateStationEnabled() {
        return this.isAlternateStationEnabled;
    }

    public final void setAlternateStationEnabled(boolean z) {
        this.isAlternateStationEnabled = z;
    }

    public final List<CJRTrainSearchResultsAlternateStationData> getAlternateStationsData() {
        return this.alternateStationsData;
    }

    public final void setAlternateStationsData(List<CJRTrainSearchResultsAlternateStationData> list) {
        this.alternateStationsData = list;
    }

    public final String getAlternateStationsTitle() {
        return this.alternateStationsTitle;
    }

    public final void setAlternateStationsTitle(String str) {
        this.alternateStationsTitle = str;
    }

    public final String getAlternateStationsText() {
        return this.alternateStationsText;
    }

    public final void setAlternateStationsText(String str) {
        this.alternateStationsText = str;
    }

    public final boolean getMIsCollapse() {
        return this.mIsCollapse;
    }

    public final void setMIsCollapse(boolean z) {
        this.mIsCollapse = z;
    }

    public final String getMSearchedTrainDepartureTime() {
        return this.mSearchedTrainDepartureTime;
    }

    public final void setMSearchedTrainDepartureTime(String str) {
        this.mSearchedTrainDepartureTime = str;
    }

    public final String getMSearchedTrainArrivalTime() {
        return this.mSearchedTrainArrivalTime;
    }

    public final void setMSearchedTrainArrivalTime(String str) {
        this.mSearchedTrainArrivalTime = str;
    }

    public CJRTrainSearchResultsTrain(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CJRTrainSearchResultsRunningOn cJRTrainSearchResultsRunningOn, List<String> list, String str9, String str10, String str11, String str12, String str13, String str14, int i2, CJRTrainSearchResultsDelayInfo cJRTrainSearchResultsDelayInfo, boolean z, boolean z2, boolean z3, String str15, boolean z4, String str16, boolean z5, String str17, String str18, String str19, String str20, String str21, ArrayList<CJRTrainSearchResultsAvailibiltyObject> arrayList, String str22, boolean z6, List<CJRTrainSearchResultsAlternateStationData> list2, String str23, String str24, boolean z7, String str25, String str26) {
        ArrayList<CJRTrainSearchResultsAvailibiltyObject> arrayList2 = arrayList;
        k.c(list, "classes");
        k.c(arrayList2, "mAvailability");
        this.departure = str;
        this.departureTime = str2;
        this.arrival = str3;
        this.arrivalTime = str4;
        this.trainName = str5;
        this.trainNumber = str6;
        this.source = str7;
        this.destination = str8;
        this.runningOn = cJRTrainSearchResultsRunningOn;
        this.classes = list;
        this.boardingStation = str9;
        this.quota = str10;
        this.trainClass = str11;
        this.runsOn = str12;
        this.quickTrainName = str13;
        this.quickTrainNumber = str14;
        this.delayScore = i2;
        this.delayInfo = cJRTrainSearchResultsDelayInfo;
        this.viewMoreClicked = z;
        this.checked = z2;
        this.isMessageEnable = z3;
        this.message = str15;
        this.isDynamicPricingEnable = z4;
        this.dynamicPricingMessage = str16;
        this.isSearchByTrainResult = z5;
        this.trainType = str17;
        this.duration = str18;
        this.sourceName = str19;
        this.destinationName = str20;
        this.mirctcuserid = str21;
        this.mAvailability = arrayList2;
        this.mAlternateConfirmAvailibility = str22;
        this.isAlternateStationEnabled = z6;
        this.alternateStationsData = list2;
        this.alternateStationsTitle = str23;
        this.alternateStationsText = str24;
        this.mIsCollapse = z7;
        this.mSearchedTrainDepartureTime = str25;
        this.mSearchedTrainArrivalTime = str26;
    }

    public final CJRTrainSearchResultsTrain clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        if (clone != null) {
            return (CJRTrainSearchResultsTrain) clone;
        }
        throw new u("null cannot be cast to non-null type com.travel.train.model.trainticket.CJRTrainSearchResultsTrain");
    }
}
