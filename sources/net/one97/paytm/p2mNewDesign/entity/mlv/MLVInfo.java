package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MLVInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "availableBalance")
    private AvailableBalance availableBalance;
    @b(a = "bonusPointsValue")
    private String bonusPointsValue;
    @b(a = "bonusText")
    private String bonusText;
    @b(a = "context")
    private String context;
    @b(a = "promotionText")
    private String promotionText;
    @b(a = "provider")
    private String provider;
    @b(a = "redeemPolicy")
    private RedeemPolicy redeemPolicy;
    @b(a = "result")
    private Result result;
    @b(a = "templateId")
    private String templateId;

    public static /* synthetic */ MLVInfo copy$default(MLVInfo mLVInfo, Result result2, AvailableBalance availableBalance2, String str, RedeemPolicy redeemPolicy2, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        MLVInfo mLVInfo2 = mLVInfo;
        int i3 = i2;
        return mLVInfo.copy((i3 & 1) != 0 ? mLVInfo2.result : result2, (i3 & 2) != 0 ? mLVInfo2.availableBalance : availableBalance2, (i3 & 4) != 0 ? mLVInfo2.templateId : str, (i3 & 8) != 0 ? mLVInfo2.redeemPolicy : redeemPolicy2, (i3 & 16) != 0 ? mLVInfo2.promotionText : str2, (i3 & 32) != 0 ? mLVInfo2.provider : str3, (i3 & 64) != 0 ? mLVInfo2.bonusText : str4, (i3 & 128) != 0 ? mLVInfo2.context : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mLVInfo2.bonusPointsValue : str6);
    }

    public final Result component1() {
        return this.result;
    }

    public final AvailableBalance component2() {
        return this.availableBalance;
    }

    public final String component3() {
        return this.templateId;
    }

    public final RedeemPolicy component4() {
        return this.redeemPolicy;
    }

    public final String component5() {
        return this.promotionText;
    }

    public final String component6() {
        return this.provider;
    }

    public final String component7() {
        return this.bonusText;
    }

    public final String component8() {
        return this.context;
    }

    public final String component9() {
        return this.bonusPointsValue;
    }

    public final MLVInfo copy(Result result2, AvailableBalance availableBalance2, String str, RedeemPolicy redeemPolicy2, String str2, String str3, String str4, String str5, String str6) {
        return new MLVInfo(result2, availableBalance2, str, redeemPolicy2, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLVInfo)) {
            return false;
        }
        MLVInfo mLVInfo = (MLVInfo) obj;
        return k.a((Object) this.result, (Object) mLVInfo.result) && k.a((Object) this.availableBalance, (Object) mLVInfo.availableBalance) && k.a((Object) this.templateId, (Object) mLVInfo.templateId) && k.a((Object) this.redeemPolicy, (Object) mLVInfo.redeemPolicy) && k.a((Object) this.promotionText, (Object) mLVInfo.promotionText) && k.a((Object) this.provider, (Object) mLVInfo.provider) && k.a((Object) this.bonusText, (Object) mLVInfo.bonusText) && k.a((Object) this.context, (Object) mLVInfo.context) && k.a((Object) this.bonusPointsValue, (Object) mLVInfo.bonusPointsValue);
    }

    public final int hashCode() {
        Result result2 = this.result;
        int i2 = 0;
        int hashCode = (result2 != null ? result2.hashCode() : 0) * 31;
        AvailableBalance availableBalance2 = this.availableBalance;
        int hashCode2 = (hashCode + (availableBalance2 != null ? availableBalance2.hashCode() : 0)) * 31;
        String str = this.templateId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        RedeemPolicy redeemPolicy2 = this.redeemPolicy;
        int hashCode4 = (hashCode3 + (redeemPolicy2 != null ? redeemPolicy2.hashCode() : 0)) * 31;
        String str2 = this.promotionText;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.provider;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bonusText;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.context;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bonusPointsValue;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "MLVInfo(result=" + this.result + ", availableBalance=" + this.availableBalance + ", templateId=" + this.templateId + ", redeemPolicy=" + this.redeemPolicy + ", promotionText=" + this.promotionText + ", provider=" + this.provider + ", bonusText=" + this.bonusText + ", context=" + this.context + ", bonusPointsValue=" + this.bonusPointsValue + ")";
    }

    public MLVInfo(Result result2, AvailableBalance availableBalance2, String str, RedeemPolicy redeemPolicy2, String str2, String str3, String str4, String str5, String str6) {
        this.result = result2;
        this.availableBalance = availableBalance2;
        this.templateId = str;
        this.redeemPolicy = redeemPolicy2;
        this.promotionText = str2;
        this.provider = str3;
        this.bonusText = str4;
        this.context = str5;
        this.bonusPointsValue = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MLVInfo(net.one97.paytm.p2mNewDesign.entity.mlv.Result r14, net.one97.paytm.p2mNewDesign.entity.mlv.AvailableBalance r15, java.lang.String r16, net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, kotlin.g.b.g r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000a
        L_0x0009:
            r4 = r14
        L_0x000a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0010
            r5 = r2
            goto L_0x0011
        L_0x0010:
            r5 = r15
        L_0x0011:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            r6 = r2
            goto L_0x0019
        L_0x0017:
            r6 = r16
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001f
            r7 = r2
            goto L_0x0021
        L_0x001f:
            r7 = r17
        L_0x0021:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            r8 = r2
            goto L_0x0029
        L_0x0027:
            r8 = r18
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = ""
            r9 = r1
            goto L_0x0033
        L_0x0031:
            r9 = r19
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r20
        L_0x003b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r21
        L_0x0043:
            r3 = r13
            r12 = r22
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo.<init>(net.one97.paytm.p2mNewDesign.entity.mlv.Result, net.one97.paytm.p2mNewDesign.entity.mlv.AvailableBalance, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Object clone() {
        return super.clone();
    }

    public final AvailableBalance getAvailableBalance() {
        return this.availableBalance;
    }

    public final String getBonusPointsValue() {
        return this.bonusPointsValue;
    }

    public final String getBonusText() {
        return this.bonusText;
    }

    public final String getContext() {
        return this.context;
    }

    public final String getPromotionText() {
        return this.promotionText;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final RedeemPolicy getRedeemPolicy() {
        return this.redeemPolicy;
    }

    public final Result getResult() {
        return this.result;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setAvailableBalance(AvailableBalance availableBalance2) {
        this.availableBalance = availableBalance2;
    }

    public final void setBonusPointsValue(String str) {
        this.bonusPointsValue = str;
    }

    public final void setBonusText(String str) {
        this.bonusText = str;
    }

    public final void setContext(String str) {
        this.context = str;
    }

    public final void setPromotionText(String str) {
        this.promotionText = str;
    }

    public final void setProvider(String str) {
        this.provider = str;
    }

    public final void setRedeemPolicy(RedeemPolicy redeemPolicy2) {
        this.redeemPolicy = redeemPolicy2;
    }

    public final void setResult(Result result2) {
        this.result = result2;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }
}
