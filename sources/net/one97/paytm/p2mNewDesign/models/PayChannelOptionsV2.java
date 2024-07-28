package net.one97.paytm.p2mNewDesign.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PayChannelOptionsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "balanceInfo")
    private BalanceInfoV2 balanceInfo;
    @b(a = "channelCode")
    private final String channelCode;
    @b(a = "channelName")
    private final String channelName;
    @b(a = "emiType")
    private final String emiType;
    @b(a = "hasLowSuccess")
    private HasLowSuccessV2 hasLowSuccess;
    @b(a = "iconUrl")
    private String iconUrl;
    @b(a = "isDisabled")
    private IsDisabledV2 isDisabled;
    @b(a = "isHybridDisabled")
    private String isHybridDisabled;
    @b(a = "isSelected")
    private Boolean isSelected;
    @b(a = "maxAmount")
    private final AmountV2 maxAmount;
    @b(a = "minAmount")
    private final AmountV2 minAmount;
    @b(a = "templateId")
    private String templateId;

    public PayChannelOptionsV2() {
        this((HasLowSuccessV2) null, (String) null, (BalanceInfoV2) null, (IsDisabledV2) null, (String) null, (String) null, (String) null, (Boolean) null, (AmountV2) null, (AmountV2) null, (String) null, (String) null, 4095, (g) null);
    }

    public static /* synthetic */ PayChannelOptionsV2 copy$default(PayChannelOptionsV2 payChannelOptionsV2, HasLowSuccessV2 hasLowSuccessV2, String str, BalanceInfoV2 balanceInfoV2, IsDisabledV2 isDisabledV2, String str2, String str3, String str4, Boolean bool, AmountV2 amountV2, AmountV2 amountV22, String str5, String str6, int i2, Object obj) {
        PayChannelOptionsV2 payChannelOptionsV22 = payChannelOptionsV2;
        int i3 = i2;
        return payChannelOptionsV2.copy((i3 & 1) != 0 ? payChannelOptionsV22.hasLowSuccess : hasLowSuccessV2, (i3 & 2) != 0 ? payChannelOptionsV22.isHybridDisabled : str, (i3 & 4) != 0 ? payChannelOptionsV22.balanceInfo : balanceInfoV2, (i3 & 8) != 0 ? payChannelOptionsV22.isDisabled : isDisabledV2, (i3 & 16) != 0 ? payChannelOptionsV22.iconUrl : str2, (i3 & 32) != 0 ? payChannelOptionsV22.channelCode : str3, (i3 & 64) != 0 ? payChannelOptionsV22.channelName : str4, (i3 & 128) != 0 ? payChannelOptionsV22.isSelected : bool, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? payChannelOptionsV22.minAmount : amountV2, (i3 & 512) != 0 ? payChannelOptionsV22.maxAmount : amountV22, (i3 & TarConstants.EOF_BLOCK) != 0 ? payChannelOptionsV22.emiType : str5, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? payChannelOptionsV22.templateId : str6);
    }

    public final HasLowSuccessV2 component1() {
        return this.hasLowSuccess;
    }

    public final AmountV2 component10() {
        return this.maxAmount;
    }

    public final String component11() {
        return this.emiType;
    }

    public final String component12() {
        return this.templateId;
    }

    public final String component2() {
        return this.isHybridDisabled;
    }

    public final BalanceInfoV2 component3() {
        return this.balanceInfo;
    }

    public final IsDisabledV2 component4() {
        return this.isDisabled;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final String component6() {
        return this.channelCode;
    }

    public final String component7() {
        return this.channelName;
    }

    public final Boolean component8() {
        return this.isSelected;
    }

    public final AmountV2 component9() {
        return this.minAmount;
    }

    public final PayChannelOptionsV2 copy(HasLowSuccessV2 hasLowSuccessV2, String str, BalanceInfoV2 balanceInfoV2, IsDisabledV2 isDisabledV2, String str2, String str3, String str4, Boolean bool, AmountV2 amountV2, AmountV2 amountV22, String str5, String str6) {
        return new PayChannelOptionsV2(hasLowSuccessV2, str, balanceInfoV2, isDisabledV2, str2, str3, str4, bool, amountV2, amountV22, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayChannelOptionsV2)) {
            return false;
        }
        PayChannelOptionsV2 payChannelOptionsV2 = (PayChannelOptionsV2) obj;
        return k.a((Object) this.hasLowSuccess, (Object) payChannelOptionsV2.hasLowSuccess) && k.a((Object) this.isHybridDisabled, (Object) payChannelOptionsV2.isHybridDisabled) && k.a((Object) this.balanceInfo, (Object) payChannelOptionsV2.balanceInfo) && k.a((Object) this.isDisabled, (Object) payChannelOptionsV2.isDisabled) && k.a((Object) this.iconUrl, (Object) payChannelOptionsV2.iconUrl) && k.a((Object) this.channelCode, (Object) payChannelOptionsV2.channelCode) && k.a((Object) this.channelName, (Object) payChannelOptionsV2.channelName) && k.a((Object) this.isSelected, (Object) payChannelOptionsV2.isSelected) && k.a((Object) this.minAmount, (Object) payChannelOptionsV2.minAmount) && k.a((Object) this.maxAmount, (Object) payChannelOptionsV2.maxAmount) && k.a((Object) this.emiType, (Object) payChannelOptionsV2.emiType) && k.a((Object) this.templateId, (Object) payChannelOptionsV2.templateId);
    }

    public final int hashCode() {
        HasLowSuccessV2 hasLowSuccessV2 = this.hasLowSuccess;
        int i2 = 0;
        int hashCode = (hasLowSuccessV2 != null ? hasLowSuccessV2.hashCode() : 0) * 31;
        String str = this.isHybridDisabled;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        BalanceInfoV2 balanceInfoV2 = this.balanceInfo;
        int hashCode3 = (hashCode2 + (balanceInfoV2 != null ? balanceInfoV2.hashCode() : 0)) * 31;
        IsDisabledV2 isDisabledV2 = this.isDisabled;
        int hashCode4 = (hashCode3 + (isDisabledV2 != null ? isDisabledV2.hashCode() : 0)) * 31;
        String str2 = this.iconUrl;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelCode;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelName;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.isSelected;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        AmountV2 amountV2 = this.minAmount;
        int hashCode9 = (hashCode8 + (amountV2 != null ? amountV2.hashCode() : 0)) * 31;
        AmountV2 amountV22 = this.maxAmount;
        int hashCode10 = (hashCode9 + (amountV22 != null ? amountV22.hashCode() : 0)) * 31;
        String str5 = this.emiType;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.templateId;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "PayChannelOptionsV2(hasLowSuccess=" + this.hasLowSuccess + ", isHybridDisabled=" + this.isHybridDisabled + ", balanceInfo=" + this.balanceInfo + ", isDisabled=" + this.isDisabled + ", iconUrl=" + this.iconUrl + ", channelCode=" + this.channelCode + ", channelName=" + this.channelName + ", isSelected=" + this.isSelected + ", minAmount=" + this.minAmount + ", maxAmount=" + this.maxAmount + ", emiType=" + this.emiType + ", templateId=" + this.templateId + ")";
    }

    public PayChannelOptionsV2(HasLowSuccessV2 hasLowSuccessV2, String str, BalanceInfoV2 balanceInfoV2, IsDisabledV2 isDisabledV2, String str2, String str3, String str4, Boolean bool, AmountV2 amountV2, AmountV2 amountV22, String str5, String str6) {
        this.hasLowSuccess = hasLowSuccessV2;
        this.isHybridDisabled = str;
        this.balanceInfo = balanceInfoV2;
        this.isDisabled = isDisabledV2;
        this.iconUrl = str2;
        this.channelCode = str3;
        this.channelName = str4;
        this.isSelected = bool;
        this.minAmount = amountV2;
        this.maxAmount = amountV22;
        this.emiType = str5;
        this.templateId = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PayChannelOptionsV2(net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2 r14, java.lang.String r15, net.one97.paytm.p2mNewDesign.models.BalanceInfoV2 r16, net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Boolean r21, net.one97.paytm.p2mNewDesign.models.AmountV2 r22, net.one97.paytm.p2mNewDesign.models.AmountV2 r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.g.b.g r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            goto L_0x0042
        L_0x0040:
            r9 = r21
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r22
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r23
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r24
        L_0x005a:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r2 = r25
        L_0x0061:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2.<init>(net.one97.paytm.p2mNewDesign.models.HasLowSuccessV2, java.lang.String, net.one97.paytm.p2mNewDesign.models.BalanceInfoV2, net.one97.paytm.p2mNewDesign.models.IsDisabledV2, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, net.one97.paytm.p2mNewDesign.models.AmountV2, net.one97.paytm.p2mNewDesign.models.AmountV2, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final BalanceInfoV2 getBalanceInfo() {
        return this.balanceInfo;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getEmiType() {
        return this.emiType;
    }

    public final HasLowSuccessV2 getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final AmountV2 getMaxAmount() {
        return this.maxAmount;
    }

    public final AmountV2 getMinAmount() {
        return this.minAmount;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final IsDisabledV2 isDisabled() {
        return this.isDisabled;
    }

    public final String isHybridDisabled() {
        return this.isHybridDisabled;
    }

    public final Boolean isSelected() {
        return this.isSelected;
    }

    public final void setBalanceInfo(BalanceInfoV2 balanceInfoV2) {
        this.balanceInfo = balanceInfoV2;
    }

    public final void setDisabled(IsDisabledV2 isDisabledV2) {
        this.isDisabled = isDisabledV2;
    }

    public final void setHasLowSuccess(HasLowSuccessV2 hasLowSuccessV2) {
        this.hasLowSuccess = hasLowSuccessV2;
    }

    public final void setHybridDisabled(String str) {
        this.isHybridDisabled = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setSelected(Boolean bool) {
        this.isSelected = bool;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }
}
