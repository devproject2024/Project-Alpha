package com.business.merchant_payments.mapqr.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.common_module.f.a;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class MapResponse extends a {
    public String category;
    public String displayName;
    public String mappingId;
    public String mappingType;
    public String metadata;
    public String posId;
    public String secondaryPhoneNumber;
    public String status;
    public String subCategory;
    public String tagLine;
    public String typeOfQrCode;

    public static /* synthetic */ MapResponse copy$default(MapResponse mapResponse, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        MapResponse mapResponse2 = mapResponse;
        int i3 = i2;
        return mapResponse.copy((i3 & 1) != 0 ? mapResponse2.mappingId : str, (i3 & 2) != 0 ? mapResponse2.mappingType : str2, (i3 & 4) != 0 ? mapResponse2.typeOfQrCode : str3, (i3 & 8) != 0 ? mapResponse2.status : str4, (i3 & 16) != 0 ? mapResponse2.displayName : str5, (i3 & 32) != 0 ? mapResponse2.category : str6, (i3 & 64) != 0 ? mapResponse2.subCategory : str7, (i3 & 128) != 0 ? mapResponse2.tagLine : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mapResponse2.secondaryPhoneNumber : str9, (i3 & 512) != 0 ? mapResponse2.posId : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? mapResponse2.metadata : str11);
    }

    public final String component1() {
        return this.mappingId;
    }

    public final String component10() {
        return this.posId;
    }

    public final String component11() {
        return this.metadata;
    }

    public final String component2() {
        return this.mappingType;
    }

    public final String component3() {
        return this.typeOfQrCode;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.displayName;
    }

    public final String component6() {
        return this.category;
    }

    public final String component7() {
        return this.subCategory;
    }

    public final String component8() {
        return this.tagLine;
    }

    public final String component9() {
        return this.secondaryPhoneNumber;
    }

    public final MapResponse copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return new MapResponse(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapResponse)) {
            return false;
        }
        MapResponse mapResponse = (MapResponse) obj;
        return k.a((Object) this.mappingId, (Object) mapResponse.mappingId) && k.a((Object) this.mappingType, (Object) mapResponse.mappingType) && k.a((Object) this.typeOfQrCode, (Object) mapResponse.typeOfQrCode) && k.a((Object) this.status, (Object) mapResponse.status) && k.a((Object) this.displayName, (Object) mapResponse.displayName) && k.a((Object) this.category, (Object) mapResponse.category) && k.a((Object) this.subCategory, (Object) mapResponse.subCategory) && k.a((Object) this.tagLine, (Object) mapResponse.tagLine) && k.a((Object) this.secondaryPhoneNumber, (Object) mapResponse.secondaryPhoneNumber) && k.a((Object) this.posId, (Object) mapResponse.posId) && k.a((Object) this.metadata, (Object) mapResponse.metadata);
    }

    public final int hashCode() {
        String str = this.mappingId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mappingType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.typeOfQrCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.displayName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.category;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.subCategory;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.tagLine;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.secondaryPhoneNumber;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.posId;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.metadata;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "MapResponse(mappingId=" + this.mappingId + ", mappingType=" + this.mappingType + ", typeOfQrCode=" + this.typeOfQrCode + ", status=" + this.status + ", displayName=" + this.displayName + ", category=" + this.category + ", subCategory=" + this.subCategory + ", tagLine=" + this.tagLine + ", secondaryPhoneNumber=" + this.secondaryPhoneNumber + ", posId=" + this.posId + ", metadata=" + this.metadata + ")";
    }

    public final String getMappingId() {
        return this.mappingId;
    }

    public final void setMappingId(String str) {
        this.mappingId = str;
    }

    public final String getMappingType() {
        return this.mappingType;
    }

    public final void setMappingType(String str) {
        this.mappingType = str;
    }

    public final String getTypeOfQrCode() {
        return this.typeOfQrCode;
    }

    public final void setTypeOfQrCode(String str) {
        this.typeOfQrCode = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getSubCategory() {
        return this.subCategory;
    }

    public final void setSubCategory(String str) {
        this.subCategory = str;
    }

    public final String getTagLine() {
        return this.tagLine;
    }

    public final void setTagLine(String str) {
        this.tagLine = str;
    }

    public final String getSecondaryPhoneNumber() {
        return this.secondaryPhoneNumber;
    }

    public final void setSecondaryPhoneNumber(String str) {
        this.secondaryPhoneNumber = str;
    }

    public final String getPosId() {
        return this.posId;
    }

    public final void setPosId(String str) {
        this.posId = str;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(String str) {
        this.metadata = str;
    }

    public MapResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.mappingId = str;
        this.mappingType = str2;
        this.typeOfQrCode = str3;
        this.status = str4;
        this.displayName = str5;
        this.category = str6;
        this.subCategory = str7;
        this.tagLine = str8;
        this.secondaryPhoneNumber = str9;
        this.posId = str10;
        this.metadata = str11;
    }
}
