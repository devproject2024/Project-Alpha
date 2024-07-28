package net.one97.paytm.passbook.beans.mlv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MLVUserCardDetail extends IJRDataModel {
    @b(a = "activeTime")
    private String activeTime;
    @b(a = "availableAmount")
    private MLVAmount availableAmount;
    @b(a = "cardId")
    private String cardId;
    @b(a = "cardName")
    private String cardName;
    @b(a = "cardNo")
    private String cardNo;
    @b(a = "createTime")
    private String createTime;
    @b(a = "expiredTime")
    private String expiredTime;
    @b(a = "extendInfoMap")
    private HashMap<String, String> extendInfoMap;
    @b(a = "status")
    private String status;
    @b(a = "templateId")
    private String templateId;
    @b(a = "totalAmount")
    private MLVAmount totalAmount;

    public static /* synthetic */ MLVUserCardDetail copy$default(MLVUserCardDetail mLVUserCardDetail, String str, String str2, String str3, String str4, String str5, HashMap hashMap, MLVAmount mLVAmount, MLVAmount mLVAmount2, String str6, String str7, String str8, int i2, Object obj) {
        MLVUserCardDetail mLVUserCardDetail2 = mLVUserCardDetail;
        int i3 = i2;
        return mLVUserCardDetail.copy((i3 & 1) != 0 ? mLVUserCardDetail2.cardId : str, (i3 & 2) != 0 ? mLVUserCardDetail2.templateId : str2, (i3 & 4) != 0 ? mLVUserCardDetail2.cardNo : str3, (i3 & 8) != 0 ? mLVUserCardDetail2.cardName : str4, (i3 & 16) != 0 ? mLVUserCardDetail2.status : str5, (i3 & 32) != 0 ? mLVUserCardDetail2.extendInfoMap : hashMap, (i3 & 64) != 0 ? mLVUserCardDetail2.totalAmount : mLVAmount, (i3 & 128) != 0 ? mLVUserCardDetail2.availableAmount : mLVAmount2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mLVUserCardDetail2.activeTime : str6, (i3 & 512) != 0 ? mLVUserCardDetail2.expiredTime : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? mLVUserCardDetail2.createTime : str8);
    }

    public final String component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.expiredTime;
    }

    public final String component11() {
        return this.createTime;
    }

    public final String component2() {
        return this.templateId;
    }

    public final String component3() {
        return this.cardNo;
    }

    public final String component4() {
        return this.cardName;
    }

    public final String component5() {
        return this.status;
    }

    public final HashMap<String, String> component6() {
        return this.extendInfoMap;
    }

    public final MLVAmount component7() {
        return this.totalAmount;
    }

    public final MLVAmount component8() {
        return this.availableAmount;
    }

    public final String component9() {
        return this.activeTime;
    }

    public final MLVUserCardDetail copy(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, MLVAmount mLVAmount, MLVAmount mLVAmount2, String str6, String str7, String str8) {
        k.c(str, "cardId");
        k.c(str2, PayUtility.TEMPLATE_ID);
        String str9 = str3;
        k.c(str9, "cardNo");
        String str10 = str4;
        k.c(str10, "cardName");
        String str11 = str5;
        k.c(str11, "status");
        HashMap<String, String> hashMap2 = hashMap;
        k.c(hashMap2, "extendInfoMap");
        MLVAmount mLVAmount3 = mLVAmount;
        k.c(mLVAmount3, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        MLVAmount mLVAmount4 = mLVAmount2;
        k.c(mLVAmount4, "availableAmount");
        String str12 = str6;
        k.c(str12, "activeTime");
        String str13 = str7;
        k.c(str13, "expiredTime");
        String str14 = str8;
        k.c(str14, "createTime");
        return new MLVUserCardDetail(str, str2, str9, str10, str11, hashMap2, mLVAmount3, mLVAmount4, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLVUserCardDetail)) {
            return false;
        }
        MLVUserCardDetail mLVUserCardDetail = (MLVUserCardDetail) obj;
        return k.a((Object) this.cardId, (Object) mLVUserCardDetail.cardId) && k.a((Object) this.templateId, (Object) mLVUserCardDetail.templateId) && k.a((Object) this.cardNo, (Object) mLVUserCardDetail.cardNo) && k.a((Object) this.cardName, (Object) mLVUserCardDetail.cardName) && k.a((Object) this.status, (Object) mLVUserCardDetail.status) && k.a((Object) this.extendInfoMap, (Object) mLVUserCardDetail.extendInfoMap) && k.a((Object) this.totalAmount, (Object) mLVUserCardDetail.totalAmount) && k.a((Object) this.availableAmount, (Object) mLVUserCardDetail.availableAmount) && k.a((Object) this.activeTime, (Object) mLVUserCardDetail.activeTime) && k.a((Object) this.expiredTime, (Object) mLVUserCardDetail.expiredTime) && k.a((Object) this.createTime, (Object) mLVUserCardDetail.createTime);
    }

    public final int hashCode() {
        String str = this.cardId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.templateId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cardNo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cardName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        HashMap<String, String> hashMap = this.extendInfoMap;
        int hashCode6 = (hashCode5 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        MLVAmount mLVAmount = this.totalAmount;
        int hashCode7 = (hashCode6 + (mLVAmount != null ? mLVAmount.hashCode() : 0)) * 31;
        MLVAmount mLVAmount2 = this.availableAmount;
        int hashCode8 = (hashCode7 + (mLVAmount2 != null ? mLVAmount2.hashCode() : 0)) * 31;
        String str6 = this.activeTime;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.expiredTime;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.createTime;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "MLVUserCardDetail(cardId=" + this.cardId + ", templateId=" + this.templateId + ", cardNo=" + this.cardNo + ", cardName=" + this.cardName + ", status=" + this.status + ", extendInfoMap=" + this.extendInfoMap + ", totalAmount=" + this.totalAmount + ", availableAmount=" + this.availableAmount + ", activeTime=" + this.activeTime + ", expiredTime=" + this.expiredTime + ", createTime=" + this.createTime + ")";
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        k.c(str, "<set-?>");
        this.cardId = str;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        k.c(str, "<set-?>");
        this.templateId = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final void setCardNo(String str) {
        k.c(str, "<set-?>");
        this.cardNo = str;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final void setCardName(String str) {
        k.c(str, "<set-?>");
        this.cardName = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final HashMap<String, String> getExtendInfoMap() {
        return this.extendInfoMap;
    }

    public final void setExtendInfoMap(HashMap<String, String> hashMap) {
        k.c(hashMap, "<set-?>");
        this.extendInfoMap = hashMap;
    }

    public final MLVAmount getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(MLVAmount mLVAmount) {
        k.c(mLVAmount, "<set-?>");
        this.totalAmount = mLVAmount;
    }

    public final MLVAmount getAvailableAmount() {
        return this.availableAmount;
    }

    public final void setAvailableAmount(MLVAmount mLVAmount) {
        k.c(mLVAmount, "<set-?>");
        this.availableAmount = mLVAmount;
    }

    public final String getActiveTime() {
        return this.activeTime;
    }

    public final void setActiveTime(String str) {
        k.c(str, "<set-?>");
        this.activeTime = str;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }

    public final void setExpiredTime(String str) {
        k.c(str, "<set-?>");
        this.expiredTime = str;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        k.c(str, "<set-?>");
        this.createTime = str;
    }

    public MLVUserCardDetail(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, MLVAmount mLVAmount, MLVAmount mLVAmount2, String str6, String str7, String str8) {
        k.c(str, "cardId");
        k.c(str2, PayUtility.TEMPLATE_ID);
        k.c(str3, "cardNo");
        k.c(str4, "cardName");
        k.c(str5, "status");
        k.c(hashMap, "extendInfoMap");
        k.c(mLVAmount, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(mLVAmount2, "availableAmount");
        k.c(str6, "activeTime");
        k.c(str7, "expiredTime");
        k.c(str8, "createTime");
        this.cardId = str;
        this.templateId = str2;
        this.cardNo = str3;
        this.cardName = str4;
        this.status = str5;
        this.extendInfoMap = hashMap;
        this.totalAmount = mLVAmount;
        this.availableAmount = mLVAmount2;
        this.activeTime = str6;
        this.expiredTime = str7;
        this.createTime = str8;
    }
}
