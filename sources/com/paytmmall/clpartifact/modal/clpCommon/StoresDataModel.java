package com.paytmmall.clpartifact.modal.clpCommon;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class StoresDataModel implements Serializable {
    @c(a = "address")
    private final String address;
    @c(a = "brandList")
    private final String brandList;
    @c(a = "categories")
    private final String categories;
    @c(a = "contact")
    private final String contact;
    @c(a = "deepLink")
    private final String deepLink;
    @c(a = "distance")
    private final String distance;
    @c(a = "id")
    private final String id;
    @c(a = "location")
    private final String location;
    @c(a = "logoUrl")
    private final String logoUrl;
    @c(a = "name")
    private final String name;
    @c(a = "openingTime")
    private final String openingTime;
    @c(a = "partnerId")
    private final Integer partnerId;
    @c(a = "rating")
    private final Float rating;
    @c(a = "ratingCount")
    private final Integer ratingCount;
    @c(a = "seourl")
    private final String seourl;
    @c(a = "type")
    private final String type;
    @c(a = "url_type")
    private final String urlType;
    @c(a = "workingHours")
    private final List<WorkingHoursDataModel> workingHours;

    public static /* synthetic */ StoresDataModel copy$default(StoresDataModel storesDataModel, String str, String str2, Integer num, String str3, String str4, String str5, Float f2, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, String str13, String str14, int i2, Object obj) {
        StoresDataModel storesDataModel2 = storesDataModel;
        int i3 = i2;
        return storesDataModel.copy((i3 & 1) != 0 ? storesDataModel2.id : str, (i3 & 2) != 0 ? storesDataModel2.name : str2, (i3 & 4) != 0 ? storesDataModel2.partnerId : num, (i3 & 8) != 0 ? storesDataModel2.logoUrl : str3, (i3 & 16) != 0 ? storesDataModel2.type : str4, (i3 & 32) != 0 ? storesDataModel2.address : str5, (i3 & 64) != 0 ? storesDataModel2.rating : f2, (i3 & 128) != 0 ? storesDataModel2.ratingCount : num2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? storesDataModel2.openingTime : str6, (i3 & 512) != 0 ? storesDataModel2.distance : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? storesDataModel2.location : str8, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? storesDataModel2.categories : str9, (i3 & 4096) != 0 ? storesDataModel2.contact : str10, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? storesDataModel2.brandList : str11, (i3 & 16384) != 0 ? storesDataModel2.deepLink : str12, (i3 & 32768) != 0 ? storesDataModel2.workingHours : list, (i3 & 65536) != 0 ? storesDataModel2.seourl : str13, (i3 & 131072) != 0 ? storesDataModel2.urlType : str14);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.distance;
    }

    public final String component11() {
        return this.location;
    }

    public final String component12() {
        return this.categories;
    }

    public final String component13() {
        return this.contact;
    }

    public final String component14() {
        return this.brandList;
    }

    public final String component15() {
        return this.deepLink;
    }

    public final List<WorkingHoursDataModel> component16() {
        return this.workingHours;
    }

    public final String component17() {
        return this.seourl;
    }

    public final String component18() {
        return this.urlType;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.partnerId;
    }

    public final String component4() {
        return this.logoUrl;
    }

    public final String component5() {
        return this.type;
    }

    public final String component6() {
        return this.address;
    }

    public final Float component7() {
        return this.rating;
    }

    public final Integer component8() {
        return this.ratingCount;
    }

    public final String component9() {
        return this.openingTime;
    }

    public final StoresDataModel copy(String str, String str2, Integer num, String str3, String str4, String str5, Float f2, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<WorkingHoursDataModel> list, String str13, String str14) {
        String str15 = str;
        k.c(str14, "urlType");
        return new StoresDataModel(str, str2, num, str3, str4, str5, f2, num2, str6, str7, str8, str9, str10, str11, str12, list, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoresDataModel)) {
            return false;
        }
        StoresDataModel storesDataModel = (StoresDataModel) obj;
        return k.a((Object) this.id, (Object) storesDataModel.id) && k.a((Object) this.name, (Object) storesDataModel.name) && k.a((Object) this.partnerId, (Object) storesDataModel.partnerId) && k.a((Object) this.logoUrl, (Object) storesDataModel.logoUrl) && k.a((Object) this.type, (Object) storesDataModel.type) && k.a((Object) this.address, (Object) storesDataModel.address) && k.a((Object) this.rating, (Object) storesDataModel.rating) && k.a((Object) this.ratingCount, (Object) storesDataModel.ratingCount) && k.a((Object) this.openingTime, (Object) storesDataModel.openingTime) && k.a((Object) this.distance, (Object) storesDataModel.distance) && k.a((Object) this.location, (Object) storesDataModel.location) && k.a((Object) this.categories, (Object) storesDataModel.categories) && k.a((Object) this.contact, (Object) storesDataModel.contact) && k.a((Object) this.brandList, (Object) storesDataModel.brandList) && k.a((Object) this.deepLink, (Object) storesDataModel.deepLink) && k.a((Object) this.workingHours, (Object) storesDataModel.workingHours) && k.a((Object) this.seourl, (Object) storesDataModel.seourl) && k.a((Object) this.urlType, (Object) storesDataModel.urlType);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.partnerId;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.logoUrl;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.type;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.address;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Float f2 = this.rating;
        int hashCode7 = (hashCode6 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Integer num2 = this.ratingCount;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str6 = this.openingTime;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.distance;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.location;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.categories;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.contact;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.brandList;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.deepLink;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        List<WorkingHoursDataModel> list = this.workingHours;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        String str13 = this.seourl;
        int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.urlType;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        return hashCode17 + i2;
    }

    public final String toString() {
        return "StoresDataModel(id=" + this.id + ", name=" + this.name + ", partnerId=" + this.partnerId + ", logoUrl=" + this.logoUrl + ", type=" + this.type + ", address=" + this.address + ", rating=" + this.rating + ", ratingCount=" + this.ratingCount + ", openingTime=" + this.openingTime + ", distance=" + this.distance + ", location=" + this.location + ", categories=" + this.categories + ", contact=" + this.contact + ", brandList=" + this.brandList + ", deepLink=" + this.deepLink + ", workingHours=" + this.workingHours + ", seourl=" + this.seourl + ", urlType=" + this.urlType + ")";
    }

    public StoresDataModel(String str, String str2, Integer num, String str3, String str4, String str5, Float f2, Integer num2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<WorkingHoursDataModel> list, String str13, String str14) {
        String str15 = str14;
        k.c(str15, "urlType");
        this.id = str;
        this.name = str2;
        this.partnerId = num;
        this.logoUrl = str3;
        this.type = str4;
        this.address = str5;
        this.rating = f2;
        this.ratingCount = num2;
        this.openingTime = str6;
        this.distance = str7;
        this.location = str8;
        this.categories = str9;
        this.contact = str10;
        this.brandList = str11;
        this.deepLink = str12;
        this.workingHours = list;
        this.seourl = str13;
        this.urlType = str15;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPartnerId() {
        return this.partnerId;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getType() {
        return this.type;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Float getRating() {
        return this.rating;
    }

    public final Integer getRatingCount() {
        return this.ratingCount;
    }

    public final String getOpeningTime() {
        return this.openingTime;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getCategories() {
        return this.categories;
    }

    public final String getContact() {
        return this.contact;
    }

    public final String getBrandList() {
        return this.brandList;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final List<WorkingHoursDataModel> getWorkingHours() {
        return this.workingHours;
    }

    public final String getSeourl() {
        return this.seourl;
    }

    public final String getUrlType() {
        return this.urlType;
    }
}
