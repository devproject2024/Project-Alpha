package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRTrainSearchResultsAlternateStationData extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "button_text")
    private String buttonText;
    @a
    @b(a = "expand_text")
    private String expandText;
    private boolean isSelected;
    @a
    @b(a = "availability")
    private ArrayList<CJRTrainSearchResultsAvailibiltyObject> mAvailability;
    @a
    @b(a = "new_arrival")
    private String newArrival;
    @a
    @b(a = "new_departure")
    private String newDeparture;
    @a
    @b(a = "new_departure_date")
    private String newDepartureDate;
    @a
    @b(a = "new_destination")
    private String newDestination;
    @a
    @b(a = "new_destination_name")
    private String newDestinationName;
    @a
    @b(a = "new_duration")
    private String newDuration;
    @a
    @b(a = "new_source")
    private String newSource;
    @a
    @b(a = "new_source_name")
    private String newSourceName;
    @a
    @b(a = "original_departure_date")
    private String originalDepartureDate;
    @a
    @b(a = "original_destination")
    private String originalDestination;
    @a
    @b(a = "original_source")
    private String originalSource;

    public CJRTrainSearchResultsAlternateStationData() {
        this((ArrayList) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 32767, (g) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRTrainSearchResultsAlternateStationData(java.util.ArrayList r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, boolean r31, int r32, kotlin.g.b.g r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            goto L_0x000e
        L_0x000c:
            r1 = r17
        L_0x000e:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0017
        L_0x0015:
            r2 = r18
        L_0x0017:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001d
            r4 = r3
            goto L_0x001f
        L_0x001d:
            r4 = r19
        L_0x001f:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0025
            r5 = r3
            goto L_0x0027
        L_0x0025:
            r5 = r20
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002d
            r6 = r3
            goto L_0x002f
        L_0x002d:
            r6 = r21
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0035
            r7 = r3
            goto L_0x0037
        L_0x0035:
            r7 = r22
        L_0x0037:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003d
            r8 = r3
            goto L_0x003f
        L_0x003d:
            r8 = r23
        L_0x003f:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0045
            r9 = r3
            goto L_0x0047
        L_0x0045:
            r9 = r24
        L_0x0047:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004d
            r10 = r3
            goto L_0x004f
        L_0x004d:
            r10 = r25
        L_0x004f:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0055
            r11 = r3
            goto L_0x0057
        L_0x0055:
            r11 = r26
        L_0x0057:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005d
            r12 = r3
            goto L_0x005f
        L_0x005d:
            r12 = r27
        L_0x005f:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0065
            r13 = r3
            goto L_0x0067
        L_0x0065:
            r13 = r28
        L_0x0067:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006d
            r14 = r3
            goto L_0x006f
        L_0x006d:
            r14 = r29
        L_0x006f:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r3 = r30
        L_0x0076:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007c
            r0 = 0
            goto L_0x007e
        L_0x007c:
            r0 = r31
        L_0x007e:
            r17 = r16
            r18 = r1
            r19 = r2
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r3
            r32 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData.<init>(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.g.b.g):void");
    }

    public final ArrayList<CJRTrainSearchResultsAvailibiltyObject> getMAvailability() {
        return this.mAvailability;
    }

    public final void setMAvailability(ArrayList<CJRTrainSearchResultsAvailibiltyObject> arrayList) {
        k.c(arrayList, "<set-?>");
        this.mAvailability = arrayList;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final String getExpandText() {
        return this.expandText;
    }

    public final void setExpandText(String str) {
        this.expandText = str;
    }

    public final String getNewDepartureDate() {
        return this.newDepartureDate;
    }

    public final void setNewDepartureDate(String str) {
        this.newDepartureDate = str;
    }

    public final String getNewDestination() {
        return this.newDestination;
    }

    public final void setNewDestination(String str) {
        this.newDestination = str;
    }

    public final String getNewDestinationName() {
        return this.newDestinationName;
    }

    public final void setNewDestinationName(String str) {
        this.newDestinationName = str;
    }

    public final String getNewSource() {
        return this.newSource;
    }

    public final void setNewSource(String str) {
        this.newSource = str;
    }

    public final String getNewSourceName() {
        return this.newSourceName;
    }

    public final void setNewSourceName(String str) {
        this.newSourceName = str;
    }

    public final String getOriginalDepartureDate() {
        return this.originalDepartureDate;
    }

    public final void setOriginalDepartureDate(String str) {
        this.originalDepartureDate = str;
    }

    public final String getOriginalDestination() {
        return this.originalDestination;
    }

    public final void setOriginalDestination(String str) {
        this.originalDestination = str;
    }

    public final String getOriginalSource() {
        return this.originalSource;
    }

    public final void setOriginalSource(String str) {
        this.originalSource = str;
    }

    public final String getNewDeparture() {
        return this.newDeparture;
    }

    public final void setNewDeparture(String str) {
        this.newDeparture = str;
    }

    public final String getNewArrival() {
        return this.newArrival;
    }

    public final void setNewArrival(String str) {
        this.newArrival = str;
    }

    public final String getNewDuration() {
        return this.newDuration;
    }

    public final void setNewDuration(String str) {
        this.newDuration = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public CJRTrainSearchResultsAlternateStationData(ArrayList<CJRTrainSearchResultsAvailibiltyObject> arrayList, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z) {
        k.c(arrayList, "mAvailability");
        this.mAvailability = arrayList;
        this.buttonText = str;
        this.expandText = str2;
        this.newDepartureDate = str3;
        this.newDestination = str4;
        this.newDestinationName = str5;
        this.newSource = str6;
        this.newSourceName = str7;
        this.originalDepartureDate = str8;
        this.originalDestination = str9;
        this.originalSource = str10;
        this.newDeparture = str11;
        this.newArrival = str12;
        this.newDuration = str13;
        this.isSelected = z;
    }
}
