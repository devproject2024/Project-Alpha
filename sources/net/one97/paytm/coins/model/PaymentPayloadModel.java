package net.one97.paytm.coins.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentPayloadModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "AppIP")
    private String AppIP;
    @b(a = "AuthMode")
    private String AuthMode;
    @b(a = "Channel")
    private String Channel;
    @b(a = "CheckSum")
    private String CheckSum;
    @b(a = "Currency")
    private String Currency;
    @b(a = "CustomerId")
    private String CustomerId;
    @b(a = "DeviceId")
    private String DeviceId;
    @b(a = "ExchangeRate")
    private String ExchangeRate;
    @b(a = "IndustryType")
    private String IndustryType;
    @b(a = "MId")
    private String MId;
    @b(a = "OrderId")
    private String OrderId;
    @b(a = "PaymentMode")
    private String PaymentMode;
    @b(a = "ReqType")
    private String ReqType;
    @b(a = "SSOToken")
    private String SSOToken;
    @b(a = "TokenType")
    private String TokenType;
    @b(a = "TxnAmount")
    private String TxnAmount;

    public PaymentPayloadModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 65535, (g) null);
    }

    public static /* synthetic */ PaymentPayloadModel copy$default(PaymentPayloadModel paymentPayloadModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i2, Object obj) {
        PaymentPayloadModel paymentPayloadModel2 = paymentPayloadModel;
        int i3 = i2;
        return paymentPayloadModel.copy((i3 & 1) != 0 ? paymentPayloadModel2.ReqType : str, (i3 & 2) != 0 ? paymentPayloadModel2.MId : str2, (i3 & 4) != 0 ? paymentPayloadModel2.OrderId : str3, (i3 & 8) != 0 ? paymentPayloadModel2.TxnAmount : str4, (i3 & 16) != 0 ? paymentPayloadModel2.CustomerId : str5, (i3 & 32) != 0 ? paymentPayloadModel2.Currency : str6, (i3 & 64) != 0 ? paymentPayloadModel2.DeviceId : str7, (i3 & 128) != 0 ? paymentPayloadModel2.SSOToken : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentPayloadModel2.PaymentMode : str9, (i3 & 512) != 0 ? paymentPayloadModel2.IndustryType : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? paymentPayloadModel2.ExchangeRate : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentPayloadModel2.CheckSum : str12, (i3 & 4096) != 0 ? paymentPayloadModel2.AppIP : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? paymentPayloadModel2.AuthMode : str14, (i3 & 16384) != 0 ? paymentPayloadModel2.Channel : str15, (i3 & 32768) != 0 ? paymentPayloadModel2.TokenType : str16);
    }

    public final String component1() {
        return this.ReqType;
    }

    public final String component10() {
        return this.IndustryType;
    }

    public final String component11() {
        return this.ExchangeRate;
    }

    public final String component12() {
        return this.CheckSum;
    }

    public final String component13() {
        return this.AppIP;
    }

    public final String component14() {
        return this.AuthMode;
    }

    public final String component15() {
        return this.Channel;
    }

    public final String component16() {
        return this.TokenType;
    }

    public final String component2() {
        return this.MId;
    }

    public final String component3() {
        return this.OrderId;
    }

    public final String component4() {
        return this.TxnAmount;
    }

    public final String component5() {
        return this.CustomerId;
    }

    public final String component6() {
        return this.Currency;
    }

    public final String component7() {
        return this.DeviceId;
    }

    public final String component8() {
        return this.SSOToken;
    }

    public final String component9() {
        return this.PaymentMode;
    }

    public final PaymentPayloadModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        return new PaymentPayloadModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentPayloadModel)) {
            return false;
        }
        PaymentPayloadModel paymentPayloadModel = (PaymentPayloadModel) obj;
        return k.a((Object) this.ReqType, (Object) paymentPayloadModel.ReqType) && k.a((Object) this.MId, (Object) paymentPayloadModel.MId) && k.a((Object) this.OrderId, (Object) paymentPayloadModel.OrderId) && k.a((Object) this.TxnAmount, (Object) paymentPayloadModel.TxnAmount) && k.a((Object) this.CustomerId, (Object) paymentPayloadModel.CustomerId) && k.a((Object) this.Currency, (Object) paymentPayloadModel.Currency) && k.a((Object) this.DeviceId, (Object) paymentPayloadModel.DeviceId) && k.a((Object) this.SSOToken, (Object) paymentPayloadModel.SSOToken) && k.a((Object) this.PaymentMode, (Object) paymentPayloadModel.PaymentMode) && k.a((Object) this.IndustryType, (Object) paymentPayloadModel.IndustryType) && k.a((Object) this.ExchangeRate, (Object) paymentPayloadModel.ExchangeRate) && k.a((Object) this.CheckSum, (Object) paymentPayloadModel.CheckSum) && k.a((Object) this.AppIP, (Object) paymentPayloadModel.AppIP) && k.a((Object) this.AuthMode, (Object) paymentPayloadModel.AuthMode) && k.a((Object) this.Channel, (Object) paymentPayloadModel.Channel) && k.a((Object) this.TokenType, (Object) paymentPayloadModel.TokenType);
    }

    public final int hashCode() {
        String str = this.ReqType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.MId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.OrderId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.TxnAmount;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.CustomerId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Currency;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.DeviceId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.SSOToken;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.PaymentMode;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.IndustryType;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.ExchangeRate;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.CheckSum;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.AppIP;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.AuthMode;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.Channel;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.TokenType;
        if (str16 != null) {
            i2 = str16.hashCode();
        }
        return hashCode15 + i2;
    }

    public final String toString() {
        return "PaymentPayloadModel(ReqType=" + this.ReqType + ", MId=" + this.MId + ", OrderId=" + this.OrderId + ", TxnAmount=" + this.TxnAmount + ", CustomerId=" + this.CustomerId + ", Currency=" + this.Currency + ", DeviceId=" + this.DeviceId + ", SSOToken=" + this.SSOToken + ", PaymentMode=" + this.PaymentMode + ", IndustryType=" + this.IndustryType + ", ExchangeRate=" + this.ExchangeRate + ", CheckSum=" + this.CheckSum + ", AppIP=" + this.AppIP + ", AuthMode=" + this.AuthMode + ", Channel=" + this.Channel + ", TokenType=" + this.TokenType + ")";
    }

    public final String getReqType() {
        return this.ReqType;
    }

    public final void setReqType(String str) {
        this.ReqType = str;
    }

    public final String getMId() {
        return this.MId;
    }

    public final void setMId(String str) {
        this.MId = str;
    }

    public final String getOrderId() {
        return this.OrderId;
    }

    public final void setOrderId(String str) {
        this.OrderId = str;
    }

    public final String getTxnAmount() {
        return this.TxnAmount;
    }

    public final void setTxnAmount(String str) {
        this.TxnAmount = str;
    }

    public final String getCustomerId() {
        return this.CustomerId;
    }

    public final void setCustomerId(String str) {
        this.CustomerId = str;
    }

    public final String getCurrency() {
        return this.Currency;
    }

    public final void setCurrency(String str) {
        this.Currency = str;
    }

    public final String getDeviceId() {
        return this.DeviceId;
    }

    public final void setDeviceId(String str) {
        this.DeviceId = str;
    }

    public final String getSSOToken() {
        return this.SSOToken;
    }

    public final void setSSOToken(String str) {
        this.SSOToken = str;
    }

    public final String getPaymentMode() {
        return this.PaymentMode;
    }

    public final void setPaymentMode(String str) {
        this.PaymentMode = str;
    }

    public final String getIndustryType() {
        return this.IndustryType;
    }

    public final void setIndustryType(String str) {
        this.IndustryType = str;
    }

    public final String getExchangeRate() {
        return this.ExchangeRate;
    }

    public final void setExchangeRate(String str) {
        this.ExchangeRate = str;
    }

    public final String getCheckSum() {
        return this.CheckSum;
    }

    public final void setCheckSum(String str) {
        this.CheckSum = str;
    }

    public final String getAppIP() {
        return this.AppIP;
    }

    public final void setAppIP(String str) {
        this.AppIP = str;
    }

    public final String getAuthMode() {
        return this.AuthMode;
    }

    public final void setAuthMode(String str) {
        this.AuthMode = str;
    }

    public final String getChannel() {
        return this.Channel;
    }

    public final void setChannel(String str) {
        this.Channel = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentPayloadModel(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, kotlin.g.b.g r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r18
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r19
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r22
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r23
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r24
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r25
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r26
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r27
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r28
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r29
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r30
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r31
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r32
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0083
            r0 = 0
            goto L_0x0085
        L_0x0083:
            r0 = r33
        L_0x0085:
            r18 = r17
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.PaymentPayloadModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTokenType() {
        return this.TokenType;
    }

    public final void setTokenType(String str) {
        this.TokenType = str;
    }

    public PaymentPayloadModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.ReqType = str;
        this.MId = str2;
        this.OrderId = str3;
        this.TxnAmount = str4;
        this.CustomerId = str5;
        this.Currency = str6;
        this.DeviceId = str7;
        this.SSOToken = str8;
        this.PaymentMode = str9;
        this.IndustryType = str10;
        this.ExchangeRate = str11;
        this.CheckSum = str12;
        this.AppIP = str13;
        this.AuthMode = str14;
        this.Channel = str15;
        this.TokenType = str16;
    }
}
