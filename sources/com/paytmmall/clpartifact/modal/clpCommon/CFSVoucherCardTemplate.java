package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class CFSVoucherCardTemplate {
    @c(a = "createTime")
    private final String createTime;
    @c(a = "description")
    private final String description;
    @c(a = "extendInfo")
    private final String extendInfo;
    @c(a = "id")
    private final String id;
    @c(a = "merchantLogoInfo")
    private final CFSVoucherMerchantLogoInfo merchantLogoInfo;
    @c(a = "merchantScope")
    private final String merchantScope;
    @c(a = "name")
    private final String name;
    @c(a = "ownerId")
    private final String ownerId;
    @c(a = "status")
    private final String status;
    @c(a = "storeFrontUrl")
    private final String storeFrontUrl;

    public static /* synthetic */ CFSVoucherCardTemplate copy$default(CFSVoucherCardTemplate cFSVoucherCardTemplate, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo, int i2, Object obj) {
        CFSVoucherCardTemplate cFSVoucherCardTemplate2 = cFSVoucherCardTemplate;
        int i3 = i2;
        return cFSVoucherCardTemplate.copy((i3 & 1) != 0 ? cFSVoucherCardTemplate2.id : str, (i3 & 2) != 0 ? cFSVoucherCardTemplate2.name : str2, (i3 & 4) != 0 ? cFSVoucherCardTemplate2.description : str3, (i3 & 8) != 0 ? cFSVoucherCardTemplate2.merchantScope : str4, (i3 & 16) != 0 ? cFSVoucherCardTemplate2.status : str5, (i3 & 32) != 0 ? cFSVoucherCardTemplate2.ownerId : str6, (i3 & 64) != 0 ? cFSVoucherCardTemplate2.createTime : str7, (i3 & 128) != 0 ? cFSVoucherCardTemplate2.extendInfo : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cFSVoucherCardTemplate2.storeFrontUrl : str9, (i3 & 512) != 0 ? cFSVoucherCardTemplate2.merchantLogoInfo : cFSVoucherMerchantLogoInfo);
    }

    public final String component1() {
        return this.id;
    }

    public final CFSVoucherMerchantLogoInfo component10() {
        return this.merchantLogoInfo;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.merchantScope;
    }

    public final String component5() {
        return this.status;
    }

    public final String component6() {
        return this.ownerId;
    }

    public final String component7() {
        return this.createTime;
    }

    public final String component8() {
        return this.extendInfo;
    }

    public final String component9() {
        return this.storeFrontUrl;
    }

    public final CFSVoucherCardTemplate copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo) {
        return new CFSVoucherCardTemplate(str, str2, str3, str4, str5, str6, str7, str8, str9, cFSVoucherMerchantLogoInfo);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFSVoucherCardTemplate)) {
            return false;
        }
        CFSVoucherCardTemplate cFSVoucherCardTemplate = (CFSVoucherCardTemplate) obj;
        return k.a((Object) this.id, (Object) cFSVoucherCardTemplate.id) && k.a((Object) this.name, (Object) cFSVoucherCardTemplate.name) && k.a((Object) this.description, (Object) cFSVoucherCardTemplate.description) && k.a((Object) this.merchantScope, (Object) cFSVoucherCardTemplate.merchantScope) && k.a((Object) this.status, (Object) cFSVoucherCardTemplate.status) && k.a((Object) this.ownerId, (Object) cFSVoucherCardTemplate.ownerId) && k.a((Object) this.createTime, (Object) cFSVoucherCardTemplate.createTime) && k.a((Object) this.extendInfo, (Object) cFSVoucherCardTemplate.extendInfo) && k.a((Object) this.storeFrontUrl, (Object) cFSVoucherCardTemplate.storeFrontUrl) && k.a((Object) this.merchantLogoInfo, (Object) cFSVoucherCardTemplate.merchantLogoInfo);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.merchantScope;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.ownerId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.createTime;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.extendInfo;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.storeFrontUrl;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo = this.merchantLogoInfo;
        if (cFSVoucherMerchantLogoInfo != null) {
            i2 = cFSVoucherMerchantLogoInfo.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "CFSVoucherCardTemplate(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", merchantScope=" + this.merchantScope + ", status=" + this.status + ", ownerId=" + this.ownerId + ", createTime=" + this.createTime + ", extendInfo=" + this.extendInfo + ", storeFrontUrl=" + this.storeFrontUrl + ", merchantLogoInfo=" + this.merchantLogoInfo + ")";
    }

    public CFSVoucherCardTemplate(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo) {
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.merchantScope = str4;
        this.status = str5;
        this.ownerId = str6;
        this.createTime = str7;
        this.extendInfo = str8;
        this.storeFrontUrl = str9;
        this.merchantLogoInfo = cFSVoucherMerchantLogoInfo;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMerchantScope() {
        return this.merchantScope;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getExtendInfo() {
        return this.extendInfo;
    }

    public final String getStoreFrontUrl() {
        return this.storeFrontUrl;
    }

    public final CFSVoucherMerchantLogoInfo getMerchantLogoInfo() {
        return this.merchantLogoInfo;
    }
}
