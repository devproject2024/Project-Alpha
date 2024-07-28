package net.one97.paytm.passbook.beans.mgv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class UserCardDetail extends IJRDataModel {
    @b(a = "activeTime")
    private String activeTime;
    @b(a = "availableAmount")
    private MGVAmount availableAmount;
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
    private MGVAmount totalAmount;

    public static /* synthetic */ UserCardDetail copy$default(UserCardDetail userCardDetail, String str, String str2, String str3, String str4, String str5, HashMap hashMap, MGVAmount mGVAmount, MGVAmount mGVAmount2, String str6, String str7, String str8, int i2, Object obj) {
        UserCardDetail userCardDetail2 = userCardDetail;
        int i3 = i2;
        return userCardDetail.copy((i3 & 1) != 0 ? userCardDetail2.cardId : str, (i3 & 2) != 0 ? userCardDetail2.templateId : str2, (i3 & 4) != 0 ? userCardDetail2.cardNo : str3, (i3 & 8) != 0 ? userCardDetail2.cardName : str4, (i3 & 16) != 0 ? userCardDetail2.status : str5, (i3 & 32) != 0 ? userCardDetail2.extendInfoMap : hashMap, (i3 & 64) != 0 ? userCardDetail2.totalAmount : mGVAmount, (i3 & 128) != 0 ? userCardDetail2.availableAmount : mGVAmount2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? userCardDetail2.activeTime : str6, (i3 & 512) != 0 ? userCardDetail2.expiredTime : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? userCardDetail2.createTime : str8);
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

    public final MGVAmount component7() {
        return this.totalAmount;
    }

    public final MGVAmount component8() {
        return this.availableAmount;
    }

    public final String component9() {
        return this.activeTime;
    }

    public final UserCardDetail copy(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, MGVAmount mGVAmount, MGVAmount mGVAmount2, String str6, String str7, String str8) {
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
        MGVAmount mGVAmount3 = mGVAmount;
        k.c(mGVAmount3, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        MGVAmount mGVAmount4 = mGVAmount2;
        k.c(mGVAmount4, "availableAmount");
        String str12 = str6;
        k.c(str12, "activeTime");
        String str13 = str7;
        k.c(str13, "expiredTime");
        String str14 = str8;
        k.c(str14, "createTime");
        return new UserCardDetail(str, str2, str9, str10, str11, hashMap2, mGVAmount3, mGVAmount4, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserCardDetail)) {
            return false;
        }
        UserCardDetail userCardDetail = (UserCardDetail) obj;
        return k.a((Object) this.cardId, (Object) userCardDetail.cardId) && k.a((Object) this.templateId, (Object) userCardDetail.templateId) && k.a((Object) this.cardNo, (Object) userCardDetail.cardNo) && k.a((Object) this.cardName, (Object) userCardDetail.cardName) && k.a((Object) this.status, (Object) userCardDetail.status) && k.a((Object) this.extendInfoMap, (Object) userCardDetail.extendInfoMap) && k.a((Object) this.totalAmount, (Object) userCardDetail.totalAmount) && k.a((Object) this.availableAmount, (Object) userCardDetail.availableAmount) && k.a((Object) this.activeTime, (Object) userCardDetail.activeTime) && k.a((Object) this.expiredTime, (Object) userCardDetail.expiredTime) && k.a((Object) this.createTime, (Object) userCardDetail.createTime);
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
        MGVAmount mGVAmount = this.totalAmount;
        int hashCode7 = (hashCode6 + (mGVAmount != null ? mGVAmount.hashCode() : 0)) * 31;
        MGVAmount mGVAmount2 = this.availableAmount;
        int hashCode8 = (hashCode7 + (mGVAmount2 != null ? mGVAmount2.hashCode() : 0)) * 31;
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
        return "UserCardDetail(cardId=" + this.cardId + ", templateId=" + this.templateId + ", cardNo=" + this.cardNo + ", cardName=" + this.cardName + ", status=" + this.status + ", extendInfoMap=" + this.extendInfoMap + ", totalAmount=" + this.totalAmount + ", availableAmount=" + this.availableAmount + ", activeTime=" + this.activeTime + ", expiredTime=" + this.expiredTime + ", createTime=" + this.createTime + ")";
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

    public final MGVAmount getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(MGVAmount mGVAmount) {
        k.c(mGVAmount, "<set-?>");
        this.totalAmount = mGVAmount;
    }

    public final MGVAmount getAvailableAmount() {
        return this.availableAmount;
    }

    public final void setAvailableAmount(MGVAmount mGVAmount) {
        k.c(mGVAmount, "<set-?>");
        this.availableAmount = mGVAmount;
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

    public UserCardDetail(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, MGVAmount mGVAmount, MGVAmount mGVAmount2, String str6, String str7, String str8) {
        k.c(str, "cardId");
        k.c(str2, PayUtility.TEMPLATE_ID);
        k.c(str3, "cardNo");
        k.c(str4, "cardName");
        k.c(str5, "status");
        k.c(hashMap, "extendInfoMap");
        k.c(mGVAmount, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(mGVAmount2, "availableAmount");
        k.c(str6, "activeTime");
        k.c(str7, "expiredTime");
        k.c(str8, "createTime");
        this.cardId = str;
        this.templateId = str2;
        this.cardNo = str3;
        this.cardName = str4;
        this.status = str5;
        this.extendInfoMap = hashMap;
        this.totalAmount = mGVAmount;
        this.availableAmount = mGVAmount2;
        this.activeTime = str6;
        this.expiredTime = str7;
        this.createTime = str8;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(String str) {
        k.c(str, "<set-?>");
        this.createTime = str;
    }
}
