package net.one97.paytm.p2mNewDesign.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentModesV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "clientPriotity")
    private Integer clientPriotity;
    @b(a = "displayName")
    private String displayName;
    @b(a = "feeAmount")
    private String feeAmount;
    @b(a = "isDisabled")
    private IsDisabledV2 isDisabled;
    @b(a = "isHybridDisabled")
    private String isHybridDisabled;
    @b(a = "onboarding")
    private String onboarding;
    @b(a = "payChannelOptions")
    private ArrayList<PayChannelOptionsV2> payChannelOptions;
    @b(a = "paymentMode")
    private String paymentMode;
    @b(a = "priority")
    private String priority;
    @b(a = "storeFrontUrl")
    private String storeFrontUrl;
    @b(a = "taxAmount")
    private String taxAmount;
    @b(a = "totalTransactionAmount")
    private String totalTransactionAmount;

    public PaymentModesV2() {
        this((ArrayList) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (IsDisabledV2) null, (String) null, (String) null, (Integer) null, (String) null, 4095, (g) null);
    }

    public static /* synthetic */ PaymentModesV2 copy$default(PaymentModesV2 paymentModesV2, ArrayList arrayList, String str, String str2, String str3, String str4, String str5, String str6, IsDisabledV2 isDisabledV2, String str7, String str8, Integer num, String str9, int i2, Object obj) {
        PaymentModesV2 paymentModesV22 = paymentModesV2;
        int i3 = i2;
        return paymentModesV2.copy((i3 & 1) != 0 ? paymentModesV22.payChannelOptions : arrayList, (i3 & 2) != 0 ? paymentModesV22.feeAmount : str, (i3 & 4) != 0 ? paymentModesV22.totalTransactionAmount : str2, (i3 & 8) != 0 ? paymentModesV22.paymentMode : str3, (i3 & 16) != 0 ? paymentModesV22.isHybridDisabled : str4, (i3 & 32) != 0 ? paymentModesV22.displayName : str5, (i3 & 64) != 0 ? paymentModesV22.onboarding : str6, (i3 & 128) != 0 ? paymentModesV22.isDisabled : isDisabledV2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentModesV22.taxAmount : str7, (i3 & 512) != 0 ? paymentModesV22.priority : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentModesV22.clientPriotity : num, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentModesV22.storeFrontUrl : str9);
    }

    public final ArrayList<PayChannelOptionsV2> component1() {
        return this.payChannelOptions;
    }

    public final String component10() {
        return this.priority;
    }

    public final Integer component11() {
        return this.clientPriotity;
    }

    public final String component12() {
        return this.storeFrontUrl;
    }

    public final String component2() {
        return this.feeAmount;
    }

    public final String component3() {
        return this.totalTransactionAmount;
    }

    public final String component4() {
        return this.paymentMode;
    }

    public final String component5() {
        return this.isHybridDisabled;
    }

    public final String component6() {
        return this.displayName;
    }

    public final String component7() {
        return this.onboarding;
    }

    public final IsDisabledV2 component8() {
        return this.isDisabled;
    }

    public final String component9() {
        return this.taxAmount;
    }

    public final PaymentModesV2 copy(ArrayList<PayChannelOptionsV2> arrayList, String str, String str2, String str3, String str4, String str5, String str6, IsDisabledV2 isDisabledV2, String str7, String str8, Integer num, String str9) {
        return new PaymentModesV2(arrayList, str, str2, str3, str4, str5, str6, isDisabledV2, str7, str8, num, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentModesV2)) {
            return false;
        }
        PaymentModesV2 paymentModesV2 = (PaymentModesV2) obj;
        return k.a((Object) this.payChannelOptions, (Object) paymentModesV2.payChannelOptions) && k.a((Object) this.feeAmount, (Object) paymentModesV2.feeAmount) && k.a((Object) this.totalTransactionAmount, (Object) paymentModesV2.totalTransactionAmount) && k.a((Object) this.paymentMode, (Object) paymentModesV2.paymentMode) && k.a((Object) this.isHybridDisabled, (Object) paymentModesV2.isHybridDisabled) && k.a((Object) this.displayName, (Object) paymentModesV2.displayName) && k.a((Object) this.onboarding, (Object) paymentModesV2.onboarding) && k.a((Object) this.isDisabled, (Object) paymentModesV2.isDisabled) && k.a((Object) this.taxAmount, (Object) paymentModesV2.taxAmount) && k.a((Object) this.priority, (Object) paymentModesV2.priority) && k.a((Object) this.clientPriotity, (Object) paymentModesV2.clientPriotity) && k.a((Object) this.storeFrontUrl, (Object) paymentModesV2.storeFrontUrl);
    }

    public final int hashCode() {
        ArrayList<PayChannelOptionsV2> arrayList = this.payChannelOptions;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        String str = this.feeAmount;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.totalTransactionAmount;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.paymentMode;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.isHybridDisabled;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.displayName;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.onboarding;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        IsDisabledV2 isDisabledV2 = this.isDisabled;
        int hashCode8 = (hashCode7 + (isDisabledV2 != null ? isDisabledV2.hashCode() : 0)) * 31;
        String str7 = this.taxAmount;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.priority;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num = this.clientPriotity;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        String str9 = this.storeFrontUrl;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "PaymentModesV2(payChannelOptions=" + this.payChannelOptions + ", feeAmount=" + this.feeAmount + ", totalTransactionAmount=" + this.totalTransactionAmount + ", paymentMode=" + this.paymentMode + ", isHybridDisabled=" + this.isHybridDisabled + ", displayName=" + this.displayName + ", onboarding=" + this.onboarding + ", isDisabled=" + this.isDisabled + ", taxAmount=" + this.taxAmount + ", priority=" + this.priority + ", clientPriotity=" + this.clientPriotity + ", storeFrontUrl=" + this.storeFrontUrl + ")";
    }

    public final ArrayList<PayChannelOptionsV2> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public final void setPayChannelOptions(ArrayList<PayChannelOptionsV2> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public final String getFeeAmount() {
        return this.feeAmount;
    }

    public final void setFeeAmount(String str) {
        this.feeAmount = str;
    }

    public final String getTotalTransactionAmount() {
        return this.totalTransactionAmount;
    }

    public final void setTotalTransactionAmount(String str) {
        this.totalTransactionAmount = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final String isHybridDisabled() {
        return this.isHybridDisabled;
    }

    public final void setHybridDisabled(String str) {
        this.isHybridDisabled = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getOnboarding() {
        return this.onboarding;
    }

    public final void setOnboarding(String str) {
        this.onboarding = str;
    }

    public final IsDisabledV2 isDisabled() {
        return this.isDisabled;
    }

    public final void setDisabled(IsDisabledV2 isDisabledV2) {
        this.isDisabled = isDisabledV2;
    }

    public final String getTaxAmount() {
        return this.taxAmount;
    }

    public final void setTaxAmount(String str) {
        this.taxAmount = str;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentModesV2(java.util.ArrayList r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r21, java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.String r25, int r26, kotlin.g.b.g r27) {
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
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005b
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x005d
        L_0x005b:
            r12 = r24
        L_0x005d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r2 = r25
        L_0x0064:
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.PaymentModesV2.<init>(java.util.ArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.models.IsDisabledV2, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getClientPriotity() {
        return this.clientPriotity;
    }

    public final void setClientPriotity(Integer num) {
        this.clientPriotity = num;
    }

    public PaymentModesV2(ArrayList<PayChannelOptionsV2> arrayList, String str, String str2, String str3, String str4, String str5, String str6, IsDisabledV2 isDisabledV2, String str7, String str8, Integer num, String str9) {
        this.payChannelOptions = arrayList;
        this.feeAmount = str;
        this.totalTransactionAmount = str2;
        this.paymentMode = str3;
        this.isHybridDisabled = str4;
        this.displayName = str5;
        this.onboarding = str6;
        this.isDisabled = isDisabledV2;
        this.taxAmount = str7;
        this.priority = str8;
        this.clientPriotity = num;
        this.storeFrontUrl = str9;
    }

    public final String getStoreFrontUrl() {
        return this.storeFrontUrl;
    }

    public final void setStoreFrontUrl(String str) {
        this.storeFrontUrl = str;
    }
}
