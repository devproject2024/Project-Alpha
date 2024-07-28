package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "callbackUrl")
    private String callbackUrl;
    @b(a = "disablePaymentMode")
    private List<DisablePaymentMode> disablePaymentMode;
    @b(a = "enablePaymentMode")
    private List<? extends Object> enablePaymentMode;
    @b(a = "goods")
    private List<Good> goods;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "message")
    private String message;
    @b(a = "mid")
    private String mid;
    @b(a = "native")

    /* renamed from: native  reason: not valid java name */
    private Boolean f379native;
    @b(a = "native_withdraw")
    private Integer nativeWithdraw;
    @b(a = "payableAmount")
    private PayableAmount payableAmount;
    @b(a = "promoCode")
    private String promoCode;
    @b(a = "requestType")
    private String requestType;
    @b(a = "shippingInfo")
    private List<? extends Object> shippingInfo;
    @b(a = "status")
    private String status;
    @b(a = "subwalletAmount")
    private String subwalletAmount;
    @b(a = "txnAmount")
    private TxnAmount txnAmount;
    @b(a = "websiteName")
    private String websiteName;

    public PaymentInfo() {
        this((String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (TxnAmount) null, (String) null, (String) null, (String) null, (PayableAmount) null, (String) null, (List) null, (List) null, (List) null, (List) null, (Integer) null, 131071, (g) null);
    }

    public static /* synthetic */ PaymentInfo copy$default(PaymentInfo paymentInfo, String str, String str2, String str3, Boolean bool, String str4, String str5, TxnAmount txnAmount2, String str6, String str7, String str8, PayableAmount payableAmount2, String str9, List list, List list2, List list3, List list4, Integer num, int i2, Object obj) {
        PaymentInfo paymentInfo2 = paymentInfo;
        int i3 = i2;
        return paymentInfo.copy((i3 & 1) != 0 ? paymentInfo2.status : str, (i3 & 2) != 0 ? paymentInfo2.message : str2, (i3 & 4) != 0 ? paymentInfo2.hitPG : str3, (i3 & 8) != 0 ? paymentInfo2.f379native : bool, (i3 & 16) != 0 ? paymentInfo2.requestType : str4, (i3 & 32) != 0 ? paymentInfo2.mid : str5, (i3 & 64) != 0 ? paymentInfo2.txnAmount : txnAmount2, (i3 & 128) != 0 ? paymentInfo2.websiteName : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentInfo2.promoCode : str7, (i3 & 512) != 0 ? paymentInfo2.callbackUrl : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentInfo2.payableAmount : payableAmount2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentInfo2.subwalletAmount : str9, (i3 & 4096) != 0 ? paymentInfo2.shippingInfo : list, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? paymentInfo2.goods : list2, (i3 & 16384) != 0 ? paymentInfo2.enablePaymentMode : list3, (i3 & 32768) != 0 ? paymentInfo2.disablePaymentMode : list4, (i3 & 65536) != 0 ? paymentInfo2.nativeWithdraw : num);
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.callbackUrl;
    }

    public final PayableAmount component11() {
        return this.payableAmount;
    }

    public final String component12() {
        return this.subwalletAmount;
    }

    public final List<Object> component13() {
        return this.shippingInfo;
    }

    public final List<Good> component14() {
        return this.goods;
    }

    public final List<Object> component15() {
        return this.enablePaymentMode;
    }

    public final List<DisablePaymentMode> component16() {
        return this.disablePaymentMode;
    }

    public final Integer component17() {
        return this.nativeWithdraw;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.hitPG;
    }

    public final Boolean component4() {
        return this.f379native;
    }

    public final String component5() {
        return this.requestType;
    }

    public final String component6() {
        return this.mid;
    }

    public final TxnAmount component7() {
        return this.txnAmount;
    }

    public final String component8() {
        return this.websiteName;
    }

    public final String component9() {
        return this.promoCode;
    }

    public final PaymentInfo copy(String str, String str2, String str3, Boolean bool, String str4, String str5, TxnAmount txnAmount2, String str6, String str7, String str8, PayableAmount payableAmount2, String str9, List<? extends Object> list, List<Good> list2, List<? extends Object> list3, List<DisablePaymentMode> list4, Integer num) {
        return new PaymentInfo(str, str2, str3, bool, str4, str5, txnAmount2, str6, str7, str8, payableAmount2, str9, list, list2, list3, list4, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentInfo)) {
            return false;
        }
        PaymentInfo paymentInfo = (PaymentInfo) obj;
        return k.a((Object) this.status, (Object) paymentInfo.status) && k.a((Object) this.message, (Object) paymentInfo.message) && k.a((Object) this.hitPG, (Object) paymentInfo.hitPG) && k.a((Object) this.f379native, (Object) paymentInfo.f379native) && k.a((Object) this.requestType, (Object) paymentInfo.requestType) && k.a((Object) this.mid, (Object) paymentInfo.mid) && k.a((Object) this.txnAmount, (Object) paymentInfo.txnAmount) && k.a((Object) this.websiteName, (Object) paymentInfo.websiteName) && k.a((Object) this.promoCode, (Object) paymentInfo.promoCode) && k.a((Object) this.callbackUrl, (Object) paymentInfo.callbackUrl) && k.a((Object) this.payableAmount, (Object) paymentInfo.payableAmount) && k.a((Object) this.subwalletAmount, (Object) paymentInfo.subwalletAmount) && k.a((Object) this.shippingInfo, (Object) paymentInfo.shippingInfo) && k.a((Object) this.goods, (Object) paymentInfo.goods) && k.a((Object) this.enablePaymentMode, (Object) paymentInfo.enablePaymentMode) && k.a((Object) this.disablePaymentMode, (Object) paymentInfo.disablePaymentMode) && k.a((Object) this.nativeWithdraw, (Object) paymentInfo.nativeWithdraw);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.hitPG;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.f379native;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str4 = this.requestType;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mid;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        TxnAmount txnAmount2 = this.txnAmount;
        int hashCode7 = (hashCode6 + (txnAmount2 != null ? txnAmount2.hashCode() : 0)) * 31;
        String str6 = this.websiteName;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.promoCode;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.callbackUrl;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        PayableAmount payableAmount2 = this.payableAmount;
        int hashCode11 = (hashCode10 + (payableAmount2 != null ? payableAmount2.hashCode() : 0)) * 31;
        String str9 = this.subwalletAmount;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        List<? extends Object> list = this.shippingInfo;
        int hashCode13 = (hashCode12 + (list != null ? list.hashCode() : 0)) * 31;
        List<Good> list2 = this.goods;
        int hashCode14 = (hashCode13 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<? extends Object> list3 = this.enablePaymentMode;
        int hashCode15 = (hashCode14 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<DisablePaymentMode> list4 = this.disablePaymentMode;
        int hashCode16 = (hashCode15 + (list4 != null ? list4.hashCode() : 0)) * 31;
        Integer num = this.nativeWithdraw;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode16 + i2;
    }

    public final String toString() {
        return "PaymentInfo(status=" + this.status + ", message=" + this.message + ", hitPG=" + this.hitPG + ", native=" + this.f379native + ", requestType=" + this.requestType + ", mid=" + this.mid + ", txnAmount=" + this.txnAmount + ", websiteName=" + this.websiteName + ", promoCode=" + this.promoCode + ", callbackUrl=" + this.callbackUrl + ", payableAmount=" + this.payableAmount + ", subwalletAmount=" + this.subwalletAmount + ", shippingInfo=" + this.shippingInfo + ", goods=" + this.goods + ", enablePaymentMode=" + this.enablePaymentMode + ", disablePaymentMode=" + this.disablePaymentMode + ", nativeWithdraw=" + this.nativeWithdraw + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getHitPG() {
        return this.hitPG;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getMid() {
        return this.mid;
    }

    public final Boolean getNative() {
        return this.f379native;
    }

    public final String getRequestType() {
        return this.requestType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final TxnAmount getTxnAmount() {
        return this.txnAmount;
    }

    public final String getWebsiteName() {
        return this.websiteName;
    }

    public final void setHitPG(String str) {
        this.hitPG = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final void setNative(Boolean bool) {
        this.f379native = bool;
    }

    public final void setRequestType(String str) {
        this.requestType = str;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setTxnAmount(TxnAmount txnAmount2) {
        this.txnAmount = txnAmount2;
    }

    public final void setWebsiteName(String str) {
        this.websiteName = str;
    }

    public final String getCallbackUrl() {
        return this.callbackUrl;
    }

    public final List<Object> getEnablePaymentMode() {
        return this.enablePaymentMode;
    }

    public final List<Good> getGoods() {
        return this.goods;
    }

    public final PayableAmount getPayableAmount() {
        return this.payableAmount;
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final List<Object> getShippingInfo() {
        return this.shippingInfo;
    }

    public final String getSubwalletAmount() {
        return this.subwalletAmount;
    }

    public final void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public final void setEnablePaymentMode(List<? extends Object> list) {
        this.enablePaymentMode = list;
    }

    public final void setGoods(List<Good> list) {
        this.goods = list;
    }

    public final void setPayableAmount(PayableAmount payableAmount2) {
        this.payableAmount = payableAmount2;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public final void setShippingInfo(List<? extends Object> list) {
        this.shippingInfo = list;
    }

    public final void setSubwalletAmount(String str) {
        this.subwalletAmount = str;
    }

    public PaymentInfo(String str, String str2, String str3, Boolean bool, String str4, String str5, TxnAmount txnAmount2, String str6, String str7, String str8, PayableAmount payableAmount2, String str9, List<? extends Object> list, List<Good> list2, List<? extends Object> list3, List<DisablePaymentMode> list4, Integer num) {
        this.status = str;
        this.message = str2;
        this.hitPG = str3;
        this.f379native = bool;
        this.requestType = str4;
        this.mid = str5;
        this.txnAmount = txnAmount2;
        this.websiteName = str6;
        this.promoCode = str7;
        this.callbackUrl = str8;
        this.payableAmount = payableAmount2;
        this.subwalletAmount = str9;
        this.shippingInfo = list;
        this.goods = list2;
        this.enablePaymentMode = list3;
        this.disablePaymentMode = list4;
        this.nativeWithdraw = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentInfo(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Boolean r22, java.lang.String r23, java.lang.String r24, net.one97.paytm.p2mNewDesign.entity.mlv.TxnAmount r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, net.one97.paytm.p2mNewDesign.entity.mlv.PayableAmount r29, java.lang.String r30, java.util.List r31, java.util.List r32, java.util.List r33, java.util.List r34, java.lang.Integer r35, int r36, kotlin.g.b.g r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r29
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r30
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r31
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r32
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.PaymentInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.TxnAmount, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.PayableAmount, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final List<DisablePaymentMode> getDisablePaymentMode() {
        return this.disablePaymentMode;
    }

    public final Integer getNativeWithdraw() {
        return this.nativeWithdraw;
    }

    public final void setDisablePaymentMode(List<DisablePaymentMode> list) {
        this.disablePaymentMode = list;
    }

    public final void setNativeWithdraw(Integer num) {
        this.nativeWithdraw = num;
    }
}
