package net.one97.paytm.common.entity.p2p;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentCombinationAPIResponse extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "category")
    private String category;
    private ExtraData extraData;
    @b(a = "globalError")
    private GlobalError globalError;
    @b(a = "isFailSafe")
    private Boolean isFailSafe;
    @b(a = "isIntermediateScreenEnabled")
    private Boolean isIntermediateScreenEnabled;
    @b(a = "merchantInfo")
    private MerchantInfo merchantInfo;
    @b(a = "paymentOptionList")
    private List<PaymentOptionItem> paymentOptionList;
    @b(a = "receiverInfo")
    private ReceiverInfo receiverInfo;
    @b(a = "respCode")
    private String respCode;
    @b(a = "respMessage")
    private String respMessage;
    @b(a = "senderInfo")
    private SenderInfo senderInfo;
    @b(a = "status")
    private String status;

    public PaymentCombinationAPIResponse() {
        this((SenderInfo) null, (MerchantInfo) null, (ReceiverInfo) null, (List) null, (GlobalError) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (ExtraData) null, (Boolean) null, 4095, (g) null);
    }

    public static /* synthetic */ PaymentCombinationAPIResponse copy$default(PaymentCombinationAPIResponse paymentCombinationAPIResponse, SenderInfo senderInfo2, MerchantInfo merchantInfo2, ReceiverInfo receiverInfo2, List list, GlobalError globalError2, String str, String str2, String str3, Boolean bool, String str4, ExtraData extraData2, Boolean bool2, int i2, Object obj) {
        PaymentCombinationAPIResponse paymentCombinationAPIResponse2 = paymentCombinationAPIResponse;
        int i3 = i2;
        return paymentCombinationAPIResponse.copy((i3 & 1) != 0 ? paymentCombinationAPIResponse2.senderInfo : senderInfo2, (i3 & 2) != 0 ? paymentCombinationAPIResponse2.merchantInfo : merchantInfo2, (i3 & 4) != 0 ? paymentCombinationAPIResponse2.receiverInfo : receiverInfo2, (i3 & 8) != 0 ? paymentCombinationAPIResponse2.paymentOptionList : list, (i3 & 16) != 0 ? paymentCombinationAPIResponse2.globalError : globalError2, (i3 & 32) != 0 ? paymentCombinationAPIResponse2.category : str, (i3 & 64) != 0 ? paymentCombinationAPIResponse2.status : str2, (i3 & 128) != 0 ? paymentCombinationAPIResponse2.respCode : str3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentCombinationAPIResponse2.isIntermediateScreenEnabled : bool, (i3 & 512) != 0 ? paymentCombinationAPIResponse2.respMessage : str4, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentCombinationAPIResponse2.extraData : extraData2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentCombinationAPIResponse2.isFailSafe : bool2);
    }

    public final SenderInfo component1() {
        return this.senderInfo;
    }

    public final String component10() {
        return this.respMessage;
    }

    public final ExtraData component11() {
        return this.extraData;
    }

    public final Boolean component12() {
        return this.isFailSafe;
    }

    public final MerchantInfo component2() {
        return this.merchantInfo;
    }

    public final ReceiverInfo component3() {
        return this.receiverInfo;
    }

    public final List<PaymentOptionItem> component4() {
        return this.paymentOptionList;
    }

    public final GlobalError component5() {
        return this.globalError;
    }

    public final String component6() {
        return this.category;
    }

    public final String component7() {
        return this.status;
    }

    public final String component8() {
        return this.respCode;
    }

    public final Boolean component9() {
        return this.isIntermediateScreenEnabled;
    }

    public final PaymentCombinationAPIResponse copy(SenderInfo senderInfo2, MerchantInfo merchantInfo2, ReceiverInfo receiverInfo2, List<PaymentOptionItem> list, GlobalError globalError2, String str, String str2, String str3, Boolean bool, String str4, ExtraData extraData2, Boolean bool2) {
        return new PaymentCombinationAPIResponse(senderInfo2, merchantInfo2, receiverInfo2, list, globalError2, str, str2, str3, bool, str4, extraData2, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentCombinationAPIResponse)) {
            return false;
        }
        PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) obj;
        return k.a((Object) this.senderInfo, (Object) paymentCombinationAPIResponse.senderInfo) && k.a((Object) this.merchantInfo, (Object) paymentCombinationAPIResponse.merchantInfo) && k.a((Object) this.receiverInfo, (Object) paymentCombinationAPIResponse.receiverInfo) && k.a((Object) this.paymentOptionList, (Object) paymentCombinationAPIResponse.paymentOptionList) && k.a((Object) this.globalError, (Object) paymentCombinationAPIResponse.globalError) && k.a((Object) this.category, (Object) paymentCombinationAPIResponse.category) && k.a((Object) this.status, (Object) paymentCombinationAPIResponse.status) && k.a((Object) this.respCode, (Object) paymentCombinationAPIResponse.respCode) && k.a((Object) this.isIntermediateScreenEnabled, (Object) paymentCombinationAPIResponse.isIntermediateScreenEnabled) && k.a((Object) this.respMessage, (Object) paymentCombinationAPIResponse.respMessage) && k.a((Object) this.extraData, (Object) paymentCombinationAPIResponse.extraData) && k.a((Object) this.isFailSafe, (Object) paymentCombinationAPIResponse.isFailSafe);
    }

    public final int hashCode() {
        SenderInfo senderInfo2 = this.senderInfo;
        int i2 = 0;
        int hashCode = (senderInfo2 != null ? senderInfo2.hashCode() : 0) * 31;
        MerchantInfo merchantInfo2 = this.merchantInfo;
        int hashCode2 = (hashCode + (merchantInfo2 != null ? merchantInfo2.hashCode() : 0)) * 31;
        ReceiverInfo receiverInfo2 = this.receiverInfo;
        int hashCode3 = (hashCode2 + (receiverInfo2 != null ? receiverInfo2.hashCode() : 0)) * 31;
        List<PaymentOptionItem> list = this.paymentOptionList;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        GlobalError globalError2 = this.globalError;
        int hashCode5 = (hashCode4 + (globalError2 != null ? globalError2.hashCode() : 0)) * 31;
        String str = this.category;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.status;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respCode;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.isIntermediateScreenEnabled;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str4 = this.respMessage;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        ExtraData extraData2 = this.extraData;
        int hashCode11 = (hashCode10 + (extraData2 != null ? extraData2.hashCode() : 0)) * 31;
        Boolean bool2 = this.isFailSafe;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "PaymentCombinationAPIResponse(senderInfo=" + this.senderInfo + ", merchantInfo=" + this.merchantInfo + ", receiverInfo=" + this.receiverInfo + ", paymentOptionList=" + this.paymentOptionList + ", globalError=" + this.globalError + ", category=" + this.category + ", status=" + this.status + ", respCode=" + this.respCode + ", isIntermediateScreenEnabled=" + this.isIntermediateScreenEnabled + ", respMessage=" + this.respMessage + ", extraData=" + this.extraData + ", isFailSafe=" + this.isFailSafe + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final SenderInfo getSenderInfo() {
        return this.senderInfo;
    }

    public final void setSenderInfo(SenderInfo senderInfo2) {
        this.senderInfo = senderInfo2;
    }

    public final MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public final void setMerchantInfo(MerchantInfo merchantInfo2) {
        this.merchantInfo = merchantInfo2;
    }

    public final ReceiverInfo getReceiverInfo() {
        return this.receiverInfo;
    }

    public final void setReceiverInfo(ReceiverInfo receiverInfo2) {
        this.receiverInfo = receiverInfo2;
    }

    public final List<PaymentOptionItem> getPaymentOptionList() {
        return this.paymentOptionList;
    }

    public final void setPaymentOptionList(List<PaymentOptionItem> list) {
        this.paymentOptionList = list;
    }

    public final GlobalError getGlobalError() {
        return this.globalError;
    }

    public final void setGlobalError(GlobalError globalError2) {
        this.globalError = globalError2;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final void setRespCode(String str) {
        this.respCode = str;
    }

    public final Boolean isIntermediateScreenEnabled() {
        return this.isIntermediateScreenEnabled;
    }

    public final void setIntermediateScreenEnabled(Boolean bool) {
        this.isIntermediateScreenEnabled = bool;
    }

    public final ExtraData getExtraData() {
        return this.extraData;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final void setExtraData(ExtraData extraData2) {
        this.extraData = extraData2;
    }

    public final void setRespMessage(String str) {
        this.respMessage = str;
    }

    public PaymentCombinationAPIResponse(SenderInfo senderInfo2, MerchantInfo merchantInfo2, ReceiverInfo receiverInfo2, List<PaymentOptionItem> list, GlobalError globalError2, String str, String str2, String str3, Boolean bool, String str4, ExtraData extraData2, Boolean bool2) {
        this.senderInfo = senderInfo2;
        this.merchantInfo = merchantInfo2;
        this.receiverInfo = receiverInfo2;
        this.paymentOptionList = list;
        this.globalError = globalError2;
        this.category = str;
        this.status = str2;
        this.respCode = str3;
        this.isIntermediateScreenEnabled = bool;
        this.respMessage = str4;
        this.extraData = extraData2;
        this.isFailSafe = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentCombinationAPIResponse(net.one97.paytm.common.entity.p2p.SenderInfo r14, net.one97.paytm.common.entity.p2p.MerchantInfo r15, net.one97.paytm.common.entity.p2p.ReceiverInfo r16, java.util.List r17, net.one97.paytm.common.entity.p2p.GlobalError r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Boolean r22, java.lang.String r23, net.one97.paytm.common.entity.p2p.ExtraData r24, java.lang.Boolean r25, int r26, kotlin.g.b.g r27) {
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
            if (r12 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r2 = r24
        L_0x0058:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0061
        L_0x005f:
            r0 = r25
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
            r25 = r2
            r26 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse.<init>(net.one97.paytm.common.entity.p2p.SenderInfo, net.one97.paytm.common.entity.p2p.MerchantInfo, net.one97.paytm.common.entity.p2p.ReceiverInfo, java.util.List, net.one97.paytm.common.entity.p2p.GlobalError, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, net.one97.paytm.common.entity.p2p.ExtraData, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Boolean isFailSafe() {
        return this.isFailSafe;
    }

    public final void setFailSafe(Boolean bool) {
        this.isFailSafe = bool;
    }
}
