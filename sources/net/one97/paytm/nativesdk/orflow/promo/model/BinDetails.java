package net.one97.paytm.nativesdk.orflow.promo.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class BinDetails implements Serializable {
    private String bin;
    private String channelCode;
    private String channelName;
    private String cnMax;
    private String cnMin;
    private String cvvL;
    private String cvvR;
    private String expR;
    private String isActive;
    private String issuingBank;
    private String issuingBankCode;
    private String paymentMode;

    public BinDetails() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 4095, (g) null);
    }

    public static /* synthetic */ BinDetails copy$default(BinDetails binDetails, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i2, Object obj) {
        BinDetails binDetails2 = binDetails;
        int i3 = i2;
        return binDetails.copy((i3 & 1) != 0 ? binDetails2.bin : str, (i3 & 2) != 0 ? binDetails2.issuingBank : str2, (i3 & 4) != 0 ? binDetails2.issuingBankCode : str3, (i3 & 8) != 0 ? binDetails2.paymentMode : str4, (i3 & 16) != 0 ? binDetails2.channelName : str5, (i3 & 32) != 0 ? binDetails2.channelCode : str6, (i3 & 64) != 0 ? binDetails2.cnMin : str7, (i3 & 128) != 0 ? binDetails2.cnMax : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? binDetails2.cvvR : str9, (i3 & 512) != 0 ? binDetails2.cvvL : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? binDetails2.expR : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? binDetails2.isActive : str12);
    }

    public final String component1() {
        return this.bin;
    }

    public final String component10() {
        return this.cvvL;
    }

    public final String component11() {
        return this.expR;
    }

    public final String component12() {
        return this.isActive;
    }

    public final String component2() {
        return this.issuingBank;
    }

    public final String component3() {
        return this.issuingBankCode;
    }

    public final String component4() {
        return this.paymentMode;
    }

    public final String component5() {
        return this.channelName;
    }

    public final String component6() {
        return this.channelCode;
    }

    public final String component7() {
        return this.cnMin;
    }

    public final String component8() {
        return this.cnMax;
    }

    public final String component9() {
        return this.cvvR;
    }

    public final BinDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return new BinDetails(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinDetails)) {
            return false;
        }
        BinDetails binDetails = (BinDetails) obj;
        return k.a((Object) this.bin, (Object) binDetails.bin) && k.a((Object) this.issuingBank, (Object) binDetails.issuingBank) && k.a((Object) this.issuingBankCode, (Object) binDetails.issuingBankCode) && k.a((Object) this.paymentMode, (Object) binDetails.paymentMode) && k.a((Object) this.channelName, (Object) binDetails.channelName) && k.a((Object) this.channelCode, (Object) binDetails.channelCode) && k.a((Object) this.cnMin, (Object) binDetails.cnMin) && k.a((Object) this.cnMax, (Object) binDetails.cnMax) && k.a((Object) this.cvvR, (Object) binDetails.cvvR) && k.a((Object) this.cvvL, (Object) binDetails.cvvL) && k.a((Object) this.expR, (Object) binDetails.expR) && k.a((Object) this.isActive, (Object) binDetails.isActive);
    }

    public final int hashCode() {
        String str = this.bin;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.issuingBank;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.issuingBankCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.paymentMode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.channelName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.channelCode;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.cnMin;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.cnMax;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.cvvR;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.cvvL;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.expR;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.isActive;
        if (str12 != null) {
            i2 = str12.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "BinDetails(bin=" + this.bin + ", issuingBank=" + this.issuingBank + ", issuingBankCode=" + this.issuingBankCode + ", paymentMode=" + this.paymentMode + ", channelName=" + this.channelName + ", channelCode=" + this.channelCode + ", cnMin=" + this.cnMin + ", cnMax=" + this.cnMax + ", cvvR=" + this.cvvR + ", cvvL=" + this.cvvL + ", expR=" + this.expR + ", isActive=" + this.isActive + ")";
    }

    public BinDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.bin = str;
        this.issuingBank = str2;
        this.issuingBankCode = str3;
        this.paymentMode = str4;
        this.channelName = str5;
        this.channelCode = str6;
        this.cnMin = str7;
        this.cnMax = str8;
        this.cvvR = str9;
        this.cvvL = str10;
        this.expR = str11;
        this.isActive = str12;
    }

    public final String getBin() {
        return this.bin;
    }

    public final void setBin(String str) {
        this.bin = str;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public final String getIssuingBankCode() {
        return this.issuingBankCode;
    }

    public final void setIssuingBankCode(String str) {
        this.issuingBankCode = str;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final void setChannelName(String str) {
        this.channelName = str;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }

    public final String getCnMin() {
        return this.cnMin;
    }

    public final void setCnMin(String str) {
        this.cnMin = str;
    }

    public final String getCnMax() {
        return this.cnMax;
    }

    public final void setCnMax(String str) {
        this.cnMax = str;
    }

    public final String getCvvR() {
        return this.cvvR;
    }

    public final void setCvvR(String str) {
        this.cvvR = str;
    }

    public final String getCvvL() {
        return this.cvvL;
    }

    public final void setCvvL(String str) {
        this.cvvL = str;
    }

    public final String getExpR() {
        return this.expR;
    }

    public final void setExpR(String str) {
        this.expR = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BinDetails(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.g.b.g r27) {
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
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.BinDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String isActive() {
        return this.isActive;
    }

    public final void setActive(String str) {
        this.isActive = str;
    }
}
