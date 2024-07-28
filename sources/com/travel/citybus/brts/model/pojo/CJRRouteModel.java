package com.travel.citybus.brts.model.pojo;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRRouteModel {
    @c(a = "brandId")
    private Object brandId;
    @c(a = "city")
    private String city;
    @c(a = "destinationId")
    private int destinationId;
    @c(a = "displayMerchantName")
    private String displayMerchantName;
    @c(a = "merchantCityMappingId")
    private int merchantCityMappingId;
    @c(a = "merchantDestinationId")
    private String merchantDestinationId;
    @c(a = "merchantDestinationName")
    private String merchantDestinationName;
    @c(a = "merchantId")
    private String merchantId;
    @c(a = "merchantLogo")
    private String merchantLogo;
    @c(a = "merchantName")
    private String merchantName;
    @c(a = "merchantSourceId")
    private String merchantSourceId;
    @c(a = "merchantSourceName")
    private String merchantSourceName;
    @c(a = "productId")
    private String productId;
    @c(a = "routeInfoList")
    private List<CJRRouteInfoModel> routeInfoList;
    @c(a = "sourceId")
    private int sourceId;
    @c(a = "vehicleNo")
    private Object vehicleNo;

    public static /* synthetic */ CJRRouteModel copy$default(CJRRouteModel cJRRouteModel, int i2, String str, String str2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, Object obj, Object obj2, String str10, List list, int i5, Object obj3) {
        CJRRouteModel cJRRouteModel2 = cJRRouteModel;
        int i6 = i5;
        return cJRRouteModel.copy((i6 & 1) != 0 ? cJRRouteModel2.sourceId : i2, (i6 & 2) != 0 ? cJRRouteModel2.merchantSourceId : str, (i6 & 4) != 0 ? cJRRouteModel2.merchantSourceName : str2, (i6 & 8) != 0 ? cJRRouteModel2.destinationId : i3, (i6 & 16) != 0 ? cJRRouteModel2.merchantDestinationId : str3, (i6 & 32) != 0 ? cJRRouteModel2.merchantDestinationName : str4, (i6 & 64) != 0 ? cJRRouteModel2.merchantId : str5, (i6 & 128) != 0 ? cJRRouteModel2.merchantCityMappingId : i4, (i6 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRRouteModel2.merchantName : str6, (i6 & 512) != 0 ? cJRRouteModel2.displayMerchantName : str7, (i6 & TarConstants.EOF_BLOCK) != 0 ? cJRRouteModel2.merchantLogo : str8, (i6 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRRouteModel2.productId : str9, (i6 & 4096) != 0 ? cJRRouteModel2.brandId : obj, (i6 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRRouteModel2.vehicleNo : obj2, (i6 & 16384) != 0 ? cJRRouteModel2.city : str10, (i6 & 32768) != 0 ? cJRRouteModel2.routeInfoList : list);
    }

    public final int component1() {
        return this.sourceId;
    }

    public final String component10() {
        return this.displayMerchantName;
    }

    public final String component11() {
        return this.merchantLogo;
    }

    public final String component12() {
        return this.productId;
    }

    public final Object component13() {
        return this.brandId;
    }

    public final Object component14() {
        return this.vehicleNo;
    }

    public final String component15() {
        return this.city;
    }

    public final List<CJRRouteInfoModel> component16() {
        return this.routeInfoList;
    }

    public final String component2() {
        return this.merchantSourceId;
    }

    public final String component3() {
        return this.merchantSourceName;
    }

    public final int component4() {
        return this.destinationId;
    }

    public final String component5() {
        return this.merchantDestinationId;
    }

    public final String component6() {
        return this.merchantDestinationName;
    }

    public final String component7() {
        return this.merchantId;
    }

    public final int component8() {
        return this.merchantCityMappingId;
    }

    public final String component9() {
        return this.merchantName;
    }

    public final CJRRouteModel copy(int i2, String str, String str2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, Object obj, Object obj2, String str10, List<CJRRouteInfoModel> list) {
        int i5 = i2;
        k.c(str, "merchantSourceId");
        k.c(str2, "merchantSourceName");
        k.c(str3, "merchantDestinationId");
        k.c(str4, "merchantDestinationName");
        k.c(str5, SDKConstants.KEY_MERCHANT_ID);
        k.c(str6, "merchantName");
        k.c(str7, "displayMerchantName");
        k.c(str8, "merchantLogo");
        k.c(str9, "productId");
        k.c(obj, "brandId");
        k.c(obj2, "vehicleNo");
        k.c(str10, "city");
        k.c(list, "routeInfoList");
        return new CJRRouteModel(i2, str, str2, i3, str3, str4, str5, i4, str6, str7, str8, str9, obj, obj2, str10, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRouteModel)) {
            return false;
        }
        CJRRouteModel cJRRouteModel = (CJRRouteModel) obj;
        return this.sourceId == cJRRouteModel.sourceId && k.a((Object) this.merchantSourceId, (Object) cJRRouteModel.merchantSourceId) && k.a((Object) this.merchantSourceName, (Object) cJRRouteModel.merchantSourceName) && this.destinationId == cJRRouteModel.destinationId && k.a((Object) this.merchantDestinationId, (Object) cJRRouteModel.merchantDestinationId) && k.a((Object) this.merchantDestinationName, (Object) cJRRouteModel.merchantDestinationName) && k.a((Object) this.merchantId, (Object) cJRRouteModel.merchantId) && this.merchantCityMappingId == cJRRouteModel.merchantCityMappingId && k.a((Object) this.merchantName, (Object) cJRRouteModel.merchantName) && k.a((Object) this.displayMerchantName, (Object) cJRRouteModel.displayMerchantName) && k.a((Object) this.merchantLogo, (Object) cJRRouteModel.merchantLogo) && k.a((Object) this.productId, (Object) cJRRouteModel.productId) && k.a(this.brandId, cJRRouteModel.brandId) && k.a(this.vehicleNo, cJRRouteModel.vehicleNo) && k.a((Object) this.city, (Object) cJRRouteModel.city) && k.a((Object) this.routeInfoList, (Object) cJRRouteModel.routeInfoList);
    }

    public final int hashCode() {
        int i2 = this.sourceId * 31;
        String str = this.merchantSourceId;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.merchantSourceName;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.destinationId) * 31;
        String str3 = this.merchantDestinationId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantDestinationName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.merchantId;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.merchantCityMappingId) * 31;
        String str6 = this.merchantName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.displayMerchantName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.merchantLogo;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.productId;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Object obj = this.brandId;
        int hashCode10 = (hashCode9 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.vehicleNo;
        int hashCode11 = (hashCode10 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str10 = this.city;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        List<CJRRouteInfoModel> list = this.routeInfoList;
        if (list != null) {
            i3 = list.hashCode();
        }
        return hashCode12 + i3;
    }

    public final String toString() {
        return "CJRRouteModel(sourceId=" + this.sourceId + ", merchantSourceId=" + this.merchantSourceId + ", merchantSourceName=" + this.merchantSourceName + ", destinationId=" + this.destinationId + ", merchantDestinationId=" + this.merchantDestinationId + ", merchantDestinationName=" + this.merchantDestinationName + ", merchantId=" + this.merchantId + ", merchantCityMappingId=" + this.merchantCityMappingId + ", merchantName=" + this.merchantName + ", displayMerchantName=" + this.displayMerchantName + ", merchantLogo=" + this.merchantLogo + ", productId=" + this.productId + ", brandId=" + this.brandId + ", vehicleNo=" + this.vehicleNo + ", city=" + this.city + ", routeInfoList=" + this.routeInfoList + ")";
    }

    public CJRRouteModel(int i2, String str, String str2, int i3, String str3, String str4, String str5, int i4, String str6, String str7, String str8, String str9, Object obj, Object obj2, String str10, List<CJRRouteInfoModel> list) {
        String str11 = str;
        String str12 = str2;
        String str13 = str3;
        String str14 = str4;
        String str15 = str5;
        String str16 = str6;
        String str17 = str7;
        String str18 = str8;
        String str19 = str9;
        Object obj3 = obj;
        Object obj4 = obj2;
        String str20 = str10;
        List<CJRRouteInfoModel> list2 = list;
        k.c(str11, "merchantSourceId");
        k.c(str12, "merchantSourceName");
        k.c(str13, "merchantDestinationId");
        k.c(str14, "merchantDestinationName");
        k.c(str15, SDKConstants.KEY_MERCHANT_ID);
        k.c(str16, "merchantName");
        k.c(str17, "displayMerchantName");
        k.c(str18, "merchantLogo");
        k.c(str19, "productId");
        k.c(obj3, "brandId");
        k.c(obj4, "vehicleNo");
        k.c(str20, "city");
        k.c(list2, "routeInfoList");
        this.sourceId = i2;
        this.merchantSourceId = str11;
        this.merchantSourceName = str12;
        this.destinationId = i3;
        this.merchantDestinationId = str13;
        this.merchantDestinationName = str14;
        this.merchantId = str15;
        this.merchantCityMappingId = i4;
        this.merchantName = str16;
        this.displayMerchantName = str17;
        this.merchantLogo = str18;
        this.productId = str19;
        this.brandId = obj3;
        this.vehicleNo = obj4;
        this.city = str20;
        this.routeInfoList = list2;
    }

    public final int getSourceId() {
        return this.sourceId;
    }

    public final void setSourceId(int i2) {
        this.sourceId = i2;
    }

    public final String getMerchantSourceId() {
        return this.merchantSourceId;
    }

    public final void setMerchantSourceId(String str) {
        k.c(str, "<set-?>");
        this.merchantSourceId = str;
    }

    public final String getMerchantSourceName() {
        return this.merchantSourceName;
    }

    public final void setMerchantSourceName(String str) {
        k.c(str, "<set-?>");
        this.merchantSourceName = str;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void setDestinationId(int i2) {
        this.destinationId = i2;
    }

    public final String getMerchantDestinationId() {
        return this.merchantDestinationId;
    }

    public final void setMerchantDestinationId(String str) {
        k.c(str, "<set-?>");
        this.merchantDestinationId = str;
    }

    public final String getMerchantDestinationName() {
        return this.merchantDestinationName;
    }

    public final void setMerchantDestinationName(String str) {
        k.c(str, "<set-?>");
        this.merchantDestinationName = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        k.c(str, "<set-?>");
        this.merchantId = str;
    }

    public final int getMerchantCityMappingId() {
        return this.merchantCityMappingId;
    }

    public final void setMerchantCityMappingId(int i2) {
        this.merchantCityMappingId = i2;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        k.c(str, "<set-?>");
        this.merchantName = str;
    }

    public final String getDisplayMerchantName() {
        return this.displayMerchantName;
    }

    public final void setDisplayMerchantName(String str) {
        k.c(str, "<set-?>");
        this.displayMerchantName = str;
    }

    public final String getMerchantLogo() {
        return this.merchantLogo;
    }

    public final void setMerchantLogo(String str) {
        k.c(str, "<set-?>");
        this.merchantLogo = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        k.c(str, "<set-?>");
        this.productId = str;
    }

    public final Object getBrandId() {
        return this.brandId;
    }

    public final void setBrandId(Object obj) {
        k.c(obj, "<set-?>");
        this.brandId = obj;
    }

    public final Object getVehicleNo() {
        return this.vehicleNo;
    }

    public final void setVehicleNo(Object obj) {
        k.c(obj, "<set-?>");
        this.vehicleNo = obj;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        k.c(str, "<set-?>");
        this.city = str;
    }

    public final List<CJRRouteInfoModel> getRouteInfoList() {
        return this.routeInfoList;
    }

    public final void setRouteInfoList(List<CJRRouteInfoModel> list) {
        k.c(list, "<set-?>");
        this.routeInfoList = list;
    }
}
