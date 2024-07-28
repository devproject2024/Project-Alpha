package net.one97.paytm.common.entity.p2p;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentOptionItem extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "alertAmountThreshold")
    private Double alertAmountThreshold;
    @b(a = "combinationName")
    private String combinationName;
    @b(a = "deepLink")
    private String deepLink;
    @b(a = "destinationDisplayMessage")
    private String destinationDisplayMessage;
    @b(a = "destinationPayment")
    private DestinationPayment destinationPayment;
    @b(a = "extendedInfo")
    private HashMap<String, String> extendedInfo;
    @b(a = "maxLimit")
    private Integer maxLimit;
    @b(a = "minLimit")
    private Integer minLimit;
    @b(a = "ppblLimits")
    private PPBLLimits ppblLimits;
    @b(a = "priority")
    private Integer priority;
    @b(a = "receiverDisplayInformation")
    private SenderDisplayInformation receiverDisplayInformation;
    @b(a = "senderDisplayInformation")
    private SenderDisplayInformation senderDisplayInformation;
    @b(a = "sourcePayment")
    private SourcePayment sourcePayment;
    @b(a = "status")
    private String status;

    public PaymentOptionItem() {
        this((SourcePayment) null, (DestinationPayment) null, (String) null, (String) null, (String) null, (Integer) null, (PPBLLimits) null, (HashMap) null, (Integer) null, (String) null, (SenderDisplayInformation) null, (SenderDisplayInformation) null, (Integer) null, (Double) null, 16383, (g) null);
    }

    public static /* synthetic */ PaymentOptionItem copy$default(PaymentOptionItem paymentOptionItem, SourcePayment sourcePayment2, DestinationPayment destinationPayment2, String str, String str2, String str3, Integer num, PPBLLimits pPBLLimits, HashMap hashMap, Integer num2, String str4, SenderDisplayInformation senderDisplayInformation2, SenderDisplayInformation senderDisplayInformation3, Integer num3, Double d2, int i2, Object obj) {
        PaymentOptionItem paymentOptionItem2 = paymentOptionItem;
        int i3 = i2;
        return paymentOptionItem.copy((i3 & 1) != 0 ? paymentOptionItem2.sourcePayment : sourcePayment2, (i3 & 2) != 0 ? paymentOptionItem2.destinationPayment : destinationPayment2, (i3 & 4) != 0 ? paymentOptionItem2.status : str, (i3 & 8) != 0 ? paymentOptionItem2.destinationDisplayMessage : str2, (i3 & 16) != 0 ? paymentOptionItem2.deepLink : str3, (i3 & 32) != 0 ? paymentOptionItem2.priority : num, (i3 & 64) != 0 ? paymentOptionItem2.ppblLimits : pPBLLimits, (i3 & 128) != 0 ? paymentOptionItem2.extendedInfo : hashMap, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentOptionItem2.minLimit : num2, (i3 & 512) != 0 ? paymentOptionItem2.combinationName : str4, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentOptionItem2.senderDisplayInformation : senderDisplayInformation2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentOptionItem2.receiverDisplayInformation : senderDisplayInformation3, (i3 & 4096) != 0 ? paymentOptionItem2.maxLimit : num3, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? paymentOptionItem2.alertAmountThreshold : d2);
    }

    public final SourcePayment component1() {
        return this.sourcePayment;
    }

    public final String component10() {
        return this.combinationName;
    }

    public final SenderDisplayInformation component11() {
        return this.senderDisplayInformation;
    }

    public final SenderDisplayInformation component12() {
        return this.receiverDisplayInformation;
    }

    public final Integer component13() {
        return this.maxLimit;
    }

    public final Double component14() {
        return this.alertAmountThreshold;
    }

    public final DestinationPayment component2() {
        return this.destinationPayment;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.destinationDisplayMessage;
    }

    public final String component5() {
        return this.deepLink;
    }

    public final Integer component6() {
        return this.priority;
    }

    public final PPBLLimits component7() {
        return this.ppblLimits;
    }

    public final HashMap<String, String> component8() {
        return this.extendedInfo;
    }

    public final Integer component9() {
        return this.minLimit;
    }

    public final PaymentOptionItem copy(SourcePayment sourcePayment2, DestinationPayment destinationPayment2, String str, String str2, String str3, Integer num, PPBLLimits pPBLLimits, HashMap<String, String> hashMap, Integer num2, String str4, SenderDisplayInformation senderDisplayInformation2, SenderDisplayInformation senderDisplayInformation3, Integer num3, Double d2) {
        return new PaymentOptionItem(sourcePayment2, destinationPayment2, str, str2, str3, num, pPBLLimits, hashMap, num2, str4, senderDisplayInformation2, senderDisplayInformation3, num3, d2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentOptionItem)) {
            return false;
        }
        PaymentOptionItem paymentOptionItem = (PaymentOptionItem) obj;
        return k.a((Object) this.sourcePayment, (Object) paymentOptionItem.sourcePayment) && k.a((Object) this.destinationPayment, (Object) paymentOptionItem.destinationPayment) && k.a((Object) this.status, (Object) paymentOptionItem.status) && k.a((Object) this.destinationDisplayMessage, (Object) paymentOptionItem.destinationDisplayMessage) && k.a((Object) this.deepLink, (Object) paymentOptionItem.deepLink) && k.a((Object) this.priority, (Object) paymentOptionItem.priority) && k.a((Object) this.ppblLimits, (Object) paymentOptionItem.ppblLimits) && k.a((Object) this.extendedInfo, (Object) paymentOptionItem.extendedInfo) && k.a((Object) this.minLimit, (Object) paymentOptionItem.minLimit) && k.a((Object) this.combinationName, (Object) paymentOptionItem.combinationName) && k.a((Object) this.senderDisplayInformation, (Object) paymentOptionItem.senderDisplayInformation) && k.a((Object) this.receiverDisplayInformation, (Object) paymentOptionItem.receiverDisplayInformation) && k.a((Object) this.maxLimit, (Object) paymentOptionItem.maxLimit) && k.a((Object) this.alertAmountThreshold, (Object) paymentOptionItem.alertAmountThreshold);
    }

    public final int hashCode() {
        SourcePayment sourcePayment2 = this.sourcePayment;
        int i2 = 0;
        int hashCode = (sourcePayment2 != null ? sourcePayment2.hashCode() : 0) * 31;
        DestinationPayment destinationPayment2 = this.destinationPayment;
        int hashCode2 = (hashCode + (destinationPayment2 != null ? destinationPayment2.hashCode() : 0)) * 31;
        String str = this.status;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.destinationDisplayMessage;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deepLink;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.priority;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        PPBLLimits pPBLLimits = this.ppblLimits;
        int hashCode7 = (hashCode6 + (pPBLLimits != null ? pPBLLimits.hashCode() : 0)) * 31;
        HashMap<String, String> hashMap = this.extendedInfo;
        int hashCode8 = (hashCode7 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        Integer num2 = this.minLimit;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str4 = this.combinationName;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        SenderDisplayInformation senderDisplayInformation2 = this.senderDisplayInformation;
        int hashCode11 = (hashCode10 + (senderDisplayInformation2 != null ? senderDisplayInformation2.hashCode() : 0)) * 31;
        SenderDisplayInformation senderDisplayInformation3 = this.receiverDisplayInformation;
        int hashCode12 = (hashCode11 + (senderDisplayInformation3 != null ? senderDisplayInformation3.hashCode() : 0)) * 31;
        Integer num3 = this.maxLimit;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Double d2 = this.alertAmountThreshold;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        return hashCode13 + i2;
    }

    public final String toString() {
        return "PaymentOptionItem(sourcePayment=" + this.sourcePayment + ", destinationPayment=" + this.destinationPayment + ", status=" + this.status + ", destinationDisplayMessage=" + this.destinationDisplayMessage + ", deepLink=" + this.deepLink + ", priority=" + this.priority + ", ppblLimits=" + this.ppblLimits + ", extendedInfo=" + this.extendedInfo + ", minLimit=" + this.minLimit + ", combinationName=" + this.combinationName + ", senderDisplayInformation=" + this.senderDisplayInformation + ", receiverDisplayInformation=" + this.receiverDisplayInformation + ", maxLimit=" + this.maxLimit + ", alertAmountThreshold=" + this.alertAmountThreshold + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final SourcePayment getSourcePayment() {
        return this.sourcePayment;
    }

    public final void setSourcePayment(SourcePayment sourcePayment2) {
        this.sourcePayment = sourcePayment2;
    }

    public final DestinationPayment getDestinationPayment() {
        return this.destinationPayment;
    }

    public final void setDestinationPayment(DestinationPayment destinationPayment2) {
        this.destinationPayment = destinationPayment2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getDestinationDisplayMessage() {
        return this.destinationDisplayMessage;
    }

    public final void setDestinationDisplayMessage(String str) {
        this.destinationDisplayMessage = str;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final PPBLLimits getPpblLimits() {
        return this.ppblLimits;
    }

    public final void setPpblLimits(PPBLLimits pPBLLimits) {
        this.ppblLimits = pPBLLimits;
    }

    public final HashMap<String, String> getExtendedInfo() {
        return this.extendedInfo;
    }

    public final void setExtendedInfo(HashMap<String, String> hashMap) {
        this.extendedInfo = hashMap;
    }

    public final Integer getMinLimit() {
        return this.minLimit;
    }

    public final void setMinLimit(Integer num) {
        this.minLimit = num;
    }

    public final String getCombinationName() {
        return this.combinationName;
    }

    public final void setCombinationName(String str) {
        this.combinationName = str;
    }

    public final SenderDisplayInformation getSenderDisplayInformation() {
        return this.senderDisplayInformation;
    }

    public final void setSenderDisplayInformation(SenderDisplayInformation senderDisplayInformation2) {
        this.senderDisplayInformation = senderDisplayInformation2;
    }

    public final SenderDisplayInformation getReceiverDisplayInformation() {
        return this.receiverDisplayInformation;
    }

    public final void setReceiverDisplayInformation(SenderDisplayInformation senderDisplayInformation2) {
        this.receiverDisplayInformation = senderDisplayInformation2;
    }

    public final Integer getMaxLimit() {
        return this.maxLimit;
    }

    public final void setMaxLimit(Integer num) {
        this.maxLimit = num;
    }

    public PaymentOptionItem(SourcePayment sourcePayment2, DestinationPayment destinationPayment2, String str, String str2, String str3, Integer num, PPBLLimits pPBLLimits, HashMap<String, String> hashMap, Integer num2, String str4, SenderDisplayInformation senderDisplayInformation2, SenderDisplayInformation senderDisplayInformation3, Integer num3, Double d2) {
        this.sourcePayment = sourcePayment2;
        this.destinationPayment = destinationPayment2;
        this.status = str;
        this.destinationDisplayMessage = str2;
        this.deepLink = str3;
        this.priority = num;
        this.ppblLimits = pPBLLimits;
        this.extendedInfo = hashMap;
        this.minLimit = num2;
        this.combinationName = str4;
        this.senderDisplayInformation = senderDisplayInformation2;
        this.receiverDisplayInformation = senderDisplayInformation3;
        this.maxLimit = num3;
        this.alertAmountThreshold = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentOptionItem(net.one97.paytm.common.entity.p2p.SourcePayment r16, net.one97.paytm.common.entity.p2p.DestinationPayment r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, net.one97.paytm.common.entity.p2p.PPBLLimits r22, java.util.HashMap r23, java.lang.Integer r24, java.lang.String r25, net.one97.paytm.common.entity.p2p.SenderDisplayInformation r26, net.one97.paytm.common.entity.p2p.SenderDisplayInformation r27, java.lang.Integer r28, java.lang.Double r29, int r30, kotlin.g.b.g r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.PaymentOptionItem.<init>(net.one97.paytm.common.entity.p2p.SourcePayment, net.one97.paytm.common.entity.p2p.DestinationPayment, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, net.one97.paytm.common.entity.p2p.PPBLLimits, java.util.HashMap, java.lang.Integer, java.lang.String, net.one97.paytm.common.entity.p2p.SenderDisplayInformation, net.one97.paytm.common.entity.p2p.SenderDisplayInformation, java.lang.Integer, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getAlertAmountThreshold() {
        return this.alertAmountThreshold;
    }

    public final void setAlertAmountThreshold(Double d2) {
        this.alertAmountThreshold = d2;
    }
}
