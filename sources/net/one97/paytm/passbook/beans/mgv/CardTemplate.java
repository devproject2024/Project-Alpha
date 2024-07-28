package net.one97.paytm.passbook.beans.mgv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import easypay.manager.Constants;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CardTemplate extends IJRDataModel {
    @b(a = "createTime")
    private String createTime;
    @b(a = "description")
    private String description;
    @b(a = "extendInfo")
    private String extendInfo;
    @b(a = "extendInfoMap")
    private HashMap<String, String> extendInfoMap;
    @b(a = "id")
    private String id;
    @b(a = "merchantLogoInfo")
    private MerchantLogoInfo merchantLogoInfo;
    @b(a = "merchantScope")
    private String merchantScope;
    @b(a = "name")
    private String name;
    @b(a = "ownerId")
    private String ownerId;
    @b(a = "status")
    private String status;
    @b(a = "storeFrontUrl")
    private String storeFrontUrl;

    public static /* synthetic */ CardTemplate copy$default(CardTemplate cardTemplate, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, MerchantLogoInfo merchantLogoInfo2, HashMap hashMap, int i2, Object obj) {
        CardTemplate cardTemplate2 = cardTemplate;
        int i3 = i2;
        return cardTemplate.copy((i3 & 1) != 0 ? cardTemplate2.id : str, (i3 & 2) != 0 ? cardTemplate2.name : str2, (i3 & 4) != 0 ? cardTemplate2.description : str3, (i3 & 8) != 0 ? cardTemplate2.merchantScope : str4, (i3 & 16) != 0 ? cardTemplate2.status : str5, (i3 & 32) != 0 ? cardTemplate2.ownerId : str6, (i3 & 64) != 0 ? cardTemplate2.createTime : str7, (i3 & 128) != 0 ? cardTemplate2.extendInfo : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cardTemplate2.storeFrontUrl : str9, (i3 & 512) != 0 ? cardTemplate2.merchantLogoInfo : merchantLogoInfo2, (i3 & TarConstants.EOF_BLOCK) != 0 ? cardTemplate2.extendInfoMap : hashMap);
    }

    public final String component1() {
        return this.id;
    }

    public final MerchantLogoInfo component10() {
        return this.merchantLogoInfo;
    }

    public final HashMap<String, String> component11() {
        return this.extendInfoMap;
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

    public final CardTemplate copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, MerchantLogoInfo merchantLogoInfo2, HashMap<String, String> hashMap) {
        k.c(str, "id");
        k.c(str2, "name");
        String str10 = str3;
        k.c(str10, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        String str11 = str4;
        k.c(str11, "merchantScope");
        String str12 = str5;
        k.c(str12, "status");
        String str13 = str6;
        k.c(str13, "ownerId");
        String str14 = str7;
        k.c(str14, "createTime");
        String str15 = str8;
        k.c(str15, Constants.RISK_EXTENDED_INFO);
        String str16 = str9;
        k.c(str16, "storeFrontUrl");
        MerchantLogoInfo merchantLogoInfo3 = merchantLogoInfo2;
        k.c(merchantLogoInfo3, "merchantLogoInfo");
        HashMap<String, String> hashMap2 = hashMap;
        k.c(hashMap2, "extendInfoMap");
        return new CardTemplate(str, str2, str10, str11, str12, str13, str14, str15, str16, merchantLogoInfo3, hashMap2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardTemplate)) {
            return false;
        }
        CardTemplate cardTemplate = (CardTemplate) obj;
        return k.a((Object) this.id, (Object) cardTemplate.id) && k.a((Object) this.name, (Object) cardTemplate.name) && k.a((Object) this.description, (Object) cardTemplate.description) && k.a((Object) this.merchantScope, (Object) cardTemplate.merchantScope) && k.a((Object) this.status, (Object) cardTemplate.status) && k.a((Object) this.ownerId, (Object) cardTemplate.ownerId) && k.a((Object) this.createTime, (Object) cardTemplate.createTime) && k.a((Object) this.extendInfo, (Object) cardTemplate.extendInfo) && k.a((Object) this.storeFrontUrl, (Object) cardTemplate.storeFrontUrl) && k.a((Object) this.merchantLogoInfo, (Object) cardTemplate.merchantLogoInfo) && k.a((Object) this.extendInfoMap, (Object) cardTemplate.extendInfoMap);
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
        MerchantLogoInfo merchantLogoInfo2 = this.merchantLogoInfo;
        int hashCode10 = (hashCode9 + (merchantLogoInfo2 != null ? merchantLogoInfo2.hashCode() : 0)) * 31;
        HashMap<String, String> hashMap = this.extendInfoMap;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "CardTemplate(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", merchantScope=" + this.merchantScope + ", status=" + this.status + ", ownerId=" + this.ownerId + ", createTime=" + this.createTime + ", extendInfo=" + this.extendInfo + ", storeFrontUrl=" + this.storeFrontUrl + ", merchantLogoInfo=" + this.merchantLogoInfo + ", extendInfoMap=" + this.extendInfoMap + ")";
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        k.c(str, "<set-?>");
        this.description = str;
    }

    public final String getMerchantScope() {
        return this.merchantScope;
    }

    public final void setMerchantScope(String str) {
        k.c(str, "<set-?>");
        this.merchantScope = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final void setOwnerId(String str) {
        k.c(str, "<set-?>");
        this.ownerId = str;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        k.c(str, "<set-?>");
        this.createTime = str;
    }

    public final String getExtendInfo() {
        return this.extendInfo;
    }

    public final void setExtendInfo(String str) {
        k.c(str, "<set-?>");
        this.extendInfo = str;
    }

    public final String getStoreFrontUrl() {
        return this.storeFrontUrl;
    }

    public final void setStoreFrontUrl(String str) {
        k.c(str, "<set-?>");
        this.storeFrontUrl = str;
    }

    public final MerchantLogoInfo getMerchantLogoInfo() {
        return this.merchantLogoInfo;
    }

    public final void setMerchantLogoInfo(MerchantLogoInfo merchantLogoInfo2) {
        k.c(merchantLogoInfo2, "<set-?>");
        this.merchantLogoInfo = merchantLogoInfo2;
    }

    public CardTemplate(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, MerchantLogoInfo merchantLogoInfo2, HashMap<String, String> hashMap) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(str3, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str4, "merchantScope");
        k.c(str5, "status");
        k.c(str6, "ownerId");
        k.c(str7, "createTime");
        k.c(str8, Constants.RISK_EXTENDED_INFO);
        k.c(str9, "storeFrontUrl");
        k.c(merchantLogoInfo2, "merchantLogoInfo");
        k.c(hashMap, "extendInfoMap");
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.merchantScope = str4;
        this.status = str5;
        this.ownerId = str6;
        this.createTime = str7;
        this.extendInfo = str8;
        this.storeFrontUrl = str9;
        this.merchantLogoInfo = merchantLogoInfo2;
        this.extendInfoMap = hashMap;
    }

    public final HashMap<String, String> getExtendInfoMap() {
        return this.extendInfoMap;
    }

    public final void setExtendInfoMap(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.extendInfoMap = hashMap;
    }
}
