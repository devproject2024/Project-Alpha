package com.travel.citybus.brts.model.pojo;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRRouteInfoModel {
    @c(a = "busType")
    private String busType;
    @c(a = "fareDetailsList")
    private List<CJRBusStopFareModel> fareDetailsList;
    @c(a = "intermediateBusStops")
    private ArrayList<CJRBusStopModel> intermediateBusStops;
    @c(a = "isAC")
    private Boolean isAC;
    @c(a = "merchantDestinationId")
    private String merchantDestinationId;
    @c(a = "merchantRouteId")
    private String merchantRouteId;
    @c(a = "merchantSourceId")
    private String merchantSourceId;
    @c(a = "noOfStops")
    private Integer noOfStops;
    @c(a = "routeId")
    private int routeId;
    @c(a = "routeName")
    private String routeName;

    public static /* synthetic */ CJRRouteInfoModel copy$default(CJRRouteInfoModel cJRRouteInfoModel, int i2, String str, String str2, String str3, ArrayList arrayList, Integer num, List list, Boolean bool, String str4, String str5, int i3, Object obj) {
        CJRRouteInfoModel cJRRouteInfoModel2 = cJRRouteInfoModel;
        int i4 = i3;
        return cJRRouteInfoModel.copy((i4 & 1) != 0 ? cJRRouteInfoModel2.routeId : i2, (i4 & 2) != 0 ? cJRRouteInfoModel2.routeName : str, (i4 & 4) != 0 ? cJRRouteInfoModel2.merchantRouteId : str2, (i4 & 8) != 0 ? cJRRouteInfoModel2.busType : str3, (i4 & 16) != 0 ? cJRRouteInfoModel2.intermediateBusStops : arrayList, (i4 & 32) != 0 ? cJRRouteInfoModel2.noOfStops : num, (i4 & 64) != 0 ? cJRRouteInfoModel2.fareDetailsList : list, (i4 & 128) != 0 ? cJRRouteInfoModel2.isAC : bool, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRRouteInfoModel2.merchantSourceId : str4, (i4 & 512) != 0 ? cJRRouteInfoModel2.merchantDestinationId : str5);
    }

    public final int component1() {
        return this.routeId;
    }

    public final String component10() {
        return this.merchantDestinationId;
    }

    public final String component2() {
        return this.routeName;
    }

    public final String component3() {
        return this.merchantRouteId;
    }

    public final String component4() {
        return this.busType;
    }

    public final ArrayList<CJRBusStopModel> component5() {
        return this.intermediateBusStops;
    }

    public final Integer component6() {
        return this.noOfStops;
    }

    public final List<CJRBusStopFareModel> component7() {
        return this.fareDetailsList;
    }

    public final Boolean component8() {
        return this.isAC;
    }

    public final String component9() {
        return this.merchantSourceId;
    }

    public final CJRRouteInfoModel copy(int i2, String str, String str2, String str3, ArrayList<CJRBusStopModel> arrayList, Integer num, List<CJRBusStopFareModel> list, Boolean bool, String str4, String str5) {
        k.c(str, "routeName");
        k.c(str2, "merchantRouteId");
        String str6 = str3;
        k.c(str6, "busType");
        List<CJRBusStopFareModel> list2 = list;
        k.c(list2, "fareDetailsList");
        return new CJRRouteInfoModel(i2, str, str2, str6, arrayList, num, list2, bool, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRouteInfoModel)) {
            return false;
        }
        CJRRouteInfoModel cJRRouteInfoModel = (CJRRouteInfoModel) obj;
        return this.routeId == cJRRouteInfoModel.routeId && k.a((Object) this.routeName, (Object) cJRRouteInfoModel.routeName) && k.a((Object) this.merchantRouteId, (Object) cJRRouteInfoModel.merchantRouteId) && k.a((Object) this.busType, (Object) cJRRouteInfoModel.busType) && k.a((Object) this.intermediateBusStops, (Object) cJRRouteInfoModel.intermediateBusStops) && k.a((Object) this.noOfStops, (Object) cJRRouteInfoModel.noOfStops) && k.a((Object) this.fareDetailsList, (Object) cJRRouteInfoModel.fareDetailsList) && k.a((Object) this.isAC, (Object) cJRRouteInfoModel.isAC) && k.a((Object) this.merchantSourceId, (Object) cJRRouteInfoModel.merchantSourceId) && k.a((Object) this.merchantDestinationId, (Object) cJRRouteInfoModel.merchantDestinationId);
    }

    public final int hashCode() {
        int i2 = this.routeId * 31;
        String str = this.routeName;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.merchantRouteId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.busType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ArrayList<CJRBusStopModel> arrayList = this.intermediateBusStops;
        int hashCode4 = (hashCode3 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        Integer num = this.noOfStops;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        List<CJRBusStopFareModel> list = this.fareDetailsList;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isAC;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str4 = this.merchantSourceId;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.merchantDestinationId;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return hashCode8 + i3;
    }

    public final String toString() {
        return "CJRRouteInfoModel(routeId=" + this.routeId + ", routeName=" + this.routeName + ", merchantRouteId=" + this.merchantRouteId + ", busType=" + this.busType + ", intermediateBusStops=" + this.intermediateBusStops + ", noOfStops=" + this.noOfStops + ", fareDetailsList=" + this.fareDetailsList + ", isAC=" + this.isAC + ", merchantSourceId=" + this.merchantSourceId + ", merchantDestinationId=" + this.merchantDestinationId + ")";
    }

    public CJRRouteInfoModel(int i2, String str, String str2, String str3, ArrayList<CJRBusStopModel> arrayList, Integer num, List<CJRBusStopFareModel> list, Boolean bool, String str4, String str5) {
        k.c(str, "routeName");
        k.c(str2, "merchantRouteId");
        k.c(str3, "busType");
        k.c(list, "fareDetailsList");
        this.routeId = i2;
        this.routeName = str;
        this.merchantRouteId = str2;
        this.busType = str3;
        this.intermediateBusStops = arrayList;
        this.noOfStops = num;
        this.fareDetailsList = list;
        this.isAC = bool;
        this.merchantSourceId = str4;
        this.merchantDestinationId = str5;
    }

    public final int getRouteId() {
        return this.routeId;
    }

    public final void setRouteId(int i2) {
        this.routeId = i2;
    }

    public final String getRouteName() {
        return this.routeName;
    }

    public final void setRouteName(String str) {
        k.c(str, "<set-?>");
        this.routeName = str;
    }

    public final String getMerchantRouteId() {
        return this.merchantRouteId;
    }

    public final void setMerchantRouteId(String str) {
        k.c(str, "<set-?>");
        this.merchantRouteId = str;
    }

    public final String getBusType() {
        return this.busType;
    }

    public final void setBusType(String str) {
        k.c(str, "<set-?>");
        this.busType = str;
    }

    public final ArrayList<CJRBusStopModel> getIntermediateBusStops() {
        return this.intermediateBusStops;
    }

    public final void setIntermediateBusStops(ArrayList<CJRBusStopModel> arrayList) {
        this.intermediateBusStops = arrayList;
    }

    public final Integer getNoOfStops() {
        return this.noOfStops;
    }

    public final void setNoOfStops(Integer num) {
        this.noOfStops = num;
    }

    public final List<CJRBusStopFareModel> getFareDetailsList() {
        return this.fareDetailsList;
    }

    public final void setFareDetailsList(List<CJRBusStopFareModel> list) {
        k.c(list, "<set-?>");
        this.fareDetailsList = list;
    }

    public final Boolean isAC() {
        return this.isAC;
    }

    public final void setAC(Boolean bool) {
        this.isAC = bool;
    }

    public final String getMerchantSourceId() {
        return this.merchantSourceId;
    }

    public final void setMerchantSourceId(String str) {
        this.merchantSourceId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRRouteInfoModel(int r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.ArrayList r19, java.lang.Integer r20, java.util.List r21, java.lang.Boolean r22, java.lang.String r23, java.lang.String r24, int r25, kotlin.g.b.g r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = r2
            goto L_0x000b
        L_0x0009:
            r11 = r22
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0011
            r12 = r2
            goto L_0x0013
        L_0x0011:
            r12 = r23
        L_0x0013:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0019
            r13 = r2
            goto L_0x001b
        L_0x0019:
            r13 = r24
        L_0x001b:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.model.pojo.CJRRouteInfoModel.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.Integer, java.util.List, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMerchantDestinationId() {
        return this.merchantDestinationId;
    }

    public final void setMerchantDestinationId(String str) {
        this.merchantDestinationId = str;
    }
}
