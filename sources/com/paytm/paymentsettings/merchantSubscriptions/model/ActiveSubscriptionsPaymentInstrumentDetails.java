package com.paytm.paymentsettings.merchantSubscriptions.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class ActiveSubscriptionsPaymentInstrumentDetails extends IJRPaytmDataModel {
    @b(a = "bin")
    private String bin;
    @b(a = "cardScheme")
    private String cardScheme;
    @b(a = "cardSchemeLogo")
    private String cardSchemeLogo;
    @b(a = "expiryDate")
    private String expiryDate;
    @b(a = "ifsc")
    private String ifsc;
    @b(a = "instrumentStatus")
    private String instrumentStatus;
    @b(a = "bankName")
    private String issuingBank;
    @b(a = "bankLogo")
    private String issuingBankLogo;
    @b(a = "lastFourDigits")
    private String lastFourDigits;
    @b(a = "maskedAccountNumber")
    private String maskedAccountNumber;
    @b(a = "maskedCardNumber")
    private String maskedCardNumber;
    @b(a = "maskedMobileNumber")
    private String maskedMobileNumber;
    @b(a = "maskedVpa")
    private String maskedVpa;
    @b(a = "paymentMode")
    private String paymode;

    public ActiveSubscriptionsPaymentInstrumentDetails() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16383, (g) null);
    }

    public static /* synthetic */ ActiveSubscriptionsPaymentInstrumentDetails copy$default(ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i2, Object obj) {
        ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails2 = activeSubscriptionsPaymentInstrumentDetails;
        int i3 = i2;
        return activeSubscriptionsPaymentInstrumentDetails.copy((i3 & 1) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.expiryDate : str, (i3 & 2) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.instrumentStatus : str2, (i3 & 4) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.issuingBank : str3, (i3 & 8) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.issuingBankLogo : str4, (i3 & 16) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.cardSchemeLogo : str5, (i3 & 32) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.cardScheme : str6, (i3 & 64) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.paymode : str7, (i3 & 128) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.maskedMobileNumber : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.ifsc : str9, (i3 & 512) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.maskedCardNumber : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.maskedAccountNumber : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.lastFourDigits : str12, (i3 & 4096) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.bin : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? activeSubscriptionsPaymentInstrumentDetails2.maskedVpa : str14);
    }

    public final String component1() {
        return this.expiryDate;
    }

    public final String component10() {
        return this.maskedCardNumber;
    }

    public final String component11() {
        return this.maskedAccountNumber;
    }

    public final String component12() {
        return this.lastFourDigits;
    }

    public final String component13() {
        return this.bin;
    }

    public final String component14() {
        return this.maskedVpa;
    }

    public final String component2() {
        return this.instrumentStatus;
    }

    public final String component3() {
        return this.issuingBank;
    }

    public final String component4() {
        return this.issuingBankLogo;
    }

    public final String component5() {
        return this.cardSchemeLogo;
    }

    public final String component6() {
        return this.cardScheme;
    }

    public final String component7() {
        return this.paymode;
    }

    public final String component8() {
        return this.maskedMobileNumber;
    }

    public final String component9() {
        return this.ifsc;
    }

    public final ActiveSubscriptionsPaymentInstrumentDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        return new ActiveSubscriptionsPaymentInstrumentDetails(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSubscriptionsPaymentInstrumentDetails)) {
            return false;
        }
        ActiveSubscriptionsPaymentInstrumentDetails activeSubscriptionsPaymentInstrumentDetails = (ActiveSubscriptionsPaymentInstrumentDetails) obj;
        return k.a((Object) this.expiryDate, (Object) activeSubscriptionsPaymentInstrumentDetails.expiryDate) && k.a((Object) this.instrumentStatus, (Object) activeSubscriptionsPaymentInstrumentDetails.instrumentStatus) && k.a((Object) this.issuingBank, (Object) activeSubscriptionsPaymentInstrumentDetails.issuingBank) && k.a((Object) this.issuingBankLogo, (Object) activeSubscriptionsPaymentInstrumentDetails.issuingBankLogo) && k.a((Object) this.cardSchemeLogo, (Object) activeSubscriptionsPaymentInstrumentDetails.cardSchemeLogo) && k.a((Object) this.cardScheme, (Object) activeSubscriptionsPaymentInstrumentDetails.cardScheme) && k.a((Object) this.paymode, (Object) activeSubscriptionsPaymentInstrumentDetails.paymode) && k.a((Object) this.maskedMobileNumber, (Object) activeSubscriptionsPaymentInstrumentDetails.maskedMobileNumber) && k.a((Object) this.ifsc, (Object) activeSubscriptionsPaymentInstrumentDetails.ifsc) && k.a((Object) this.maskedCardNumber, (Object) activeSubscriptionsPaymentInstrumentDetails.maskedCardNumber) && k.a((Object) this.maskedAccountNumber, (Object) activeSubscriptionsPaymentInstrumentDetails.maskedAccountNumber) && k.a((Object) this.lastFourDigits, (Object) activeSubscriptionsPaymentInstrumentDetails.lastFourDigits) && k.a((Object) this.bin, (Object) activeSubscriptionsPaymentInstrumentDetails.bin) && k.a((Object) this.maskedVpa, (Object) activeSubscriptionsPaymentInstrumentDetails.maskedVpa);
    }

    public final int hashCode() {
        String str = this.expiryDate;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.instrumentStatus;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.issuingBank;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.issuingBankLogo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cardSchemeLogo;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.cardScheme;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.paymode;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.maskedMobileNumber;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ifsc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.maskedCardNumber;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.maskedAccountNumber;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.lastFourDigits;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.bin;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.maskedVpa;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        return hashCode13 + i2;
    }

    public final String toString() {
        return "ActiveSubscriptionsPaymentInstrumentDetails(expiryDate=" + this.expiryDate + ", instrumentStatus=" + this.instrumentStatus + ", issuingBank=" + this.issuingBank + ", issuingBankLogo=" + this.issuingBankLogo + ", cardSchemeLogo=" + this.cardSchemeLogo + ", cardScheme=" + this.cardScheme + ", paymode=" + this.paymode + ", maskedMobileNumber=" + this.maskedMobileNumber + ", ifsc=" + this.ifsc + ", maskedCardNumber=" + this.maskedCardNumber + ", maskedAccountNumber=" + this.maskedAccountNumber + ", lastFourDigits=" + this.lastFourDigits + ", bin=" + this.bin + ", maskedVpa=" + this.maskedVpa + ")";
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public final String getInstrumentStatus() {
        return this.instrumentStatus;
    }

    public final void setInstrumentStatus(String str) {
        this.instrumentStatus = str;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public final String getIssuingBankLogo() {
        return this.issuingBankLogo;
    }

    public final void setIssuingBankLogo(String str) {
        this.issuingBankLogo = str;
    }

    public final String getCardSchemeLogo() {
        return this.cardSchemeLogo;
    }

    public final void setCardSchemeLogo(String str) {
        this.cardSchemeLogo = str;
    }

    public final String getCardScheme() {
        return this.cardScheme;
    }

    public final void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public final String getPaymode() {
        return this.paymode;
    }

    public final void setPaymode(String str) {
        this.paymode = str;
    }

    public final String getMaskedMobileNumber() {
        return this.maskedMobileNumber;
    }

    public final void setMaskedMobileNumber(String str) {
        this.maskedMobileNumber = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public final void setMaskedCardNumber(String str) {
        this.maskedCardNumber = str;
    }

    public final String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public final void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public final String getLastFourDigits() {
        return this.lastFourDigits;
    }

    public final void setLastFourDigits(String str) {
        this.lastFourDigits = str;
    }

    public final String getBin() {
        return this.bin;
    }

    public final void setBin(String str) {
        this.bin = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ActiveSubscriptionsPaymentInstrumentDetails(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.g.b.g r31) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMaskedVpa() {
        return this.maskedVpa;
    }

    public final void setMaskedVpa(String str) {
        this.maskedVpa = str;
    }

    public ActiveSubscriptionsPaymentInstrumentDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.expiryDate = str;
        this.instrumentStatus = str2;
        this.issuingBank = str3;
        this.issuingBankLogo = str4;
        this.cardSchemeLogo = str5;
        this.cardScheme = str6;
        this.paymode = str7;
        this.maskedMobileNumber = str8;
        this.ifsc = str9;
        this.maskedCardNumber = str10;
        this.maskedAccountNumber = str11;
        this.lastFourDigits = str12;
        this.bin = str13;
        this.maskedVpa = str14;
    }
}
