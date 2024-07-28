package net.one97.paytm.common.entity.p2p;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class SourcePayment extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "accRefId")
    private String accRefId;
    @b(a = "accountType")
    private String accountType;
    @b(a = "balance")
    private String balance;
    @b(a = "bankAccountNumber")
    private String bankAccountNumber;
    @b(a = "bankName")
    private String bankName;
    @b(a = "credsAllowed")
    private ArrayList<CredsAllowed> credsAllowed;
    @b(a = "heading")
    private String heading;
    @b(a = "ifscCode")
    private String ifscCode;
    @b(a = "mpinSet")
    private String mpinSet;
    @b(a = "paymentInstrumentStatus")
    private String paymentInstrumentStatus;
    @b(a = "paymentType")
    private String paymentType;
    @b(a = "subHeading")
    private String subHeading;
    @b(a = "vpaId")
    private String vpaId;

    public SourcePayment() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, 8191, (g) null);
    }

    public static /* synthetic */ SourcePayment copy$default(SourcePayment sourcePayment, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList arrayList, int i2, Object obj) {
        SourcePayment sourcePayment2 = sourcePayment;
        int i3 = i2;
        return sourcePayment.copy((i3 & 1) != 0 ? sourcePayment2.vpaId : str, (i3 & 2) != 0 ? sourcePayment2.bankAccountNumber : str2, (i3 & 4) != 0 ? sourcePayment2.accRefId : str3, (i3 & 8) != 0 ? sourcePayment2.ifscCode : str4, (i3 & 16) != 0 ? sourcePayment2.bankName : str5, (i3 & 32) != 0 ? sourcePayment2.paymentType : str6, (i3 & 64) != 0 ? sourcePayment2.balance : str7, (i3 & 128) != 0 ? sourcePayment2.accountType : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? sourcePayment2.heading : str9, (i3 & 512) != 0 ? sourcePayment2.subHeading : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? sourcePayment2.paymentInstrumentStatus : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? sourcePayment2.mpinSet : str12, (i3 & 4096) != 0 ? sourcePayment2.credsAllowed : arrayList);
    }

    public final String component1() {
        return this.vpaId;
    }

    public final String component10() {
        return this.subHeading;
    }

    public final String component11() {
        return this.paymentInstrumentStatus;
    }

    public final String component12() {
        return this.mpinSet;
    }

    public final ArrayList<CredsAllowed> component13() {
        return this.credsAllowed;
    }

    public final String component2() {
        return this.bankAccountNumber;
    }

    public final String component3() {
        return this.accRefId;
    }

    public final String component4() {
        return this.ifscCode;
    }

    public final String component5() {
        return this.bankName;
    }

    public final String component6() {
        return this.paymentType;
    }

    public final String component7() {
        return this.balance;
    }

    public final String component8() {
        return this.accountType;
    }

    public final String component9() {
        return this.heading;
    }

    public final SourcePayment copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<CredsAllowed> arrayList) {
        return new SourcePayment(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourcePayment)) {
            return false;
        }
        SourcePayment sourcePayment = (SourcePayment) obj;
        return k.a((Object) this.vpaId, (Object) sourcePayment.vpaId) && k.a((Object) this.bankAccountNumber, (Object) sourcePayment.bankAccountNumber) && k.a((Object) this.accRefId, (Object) sourcePayment.accRefId) && k.a((Object) this.ifscCode, (Object) sourcePayment.ifscCode) && k.a((Object) this.bankName, (Object) sourcePayment.bankName) && k.a((Object) this.paymentType, (Object) sourcePayment.paymentType) && k.a((Object) this.balance, (Object) sourcePayment.balance) && k.a((Object) this.accountType, (Object) sourcePayment.accountType) && k.a((Object) this.heading, (Object) sourcePayment.heading) && k.a((Object) this.subHeading, (Object) sourcePayment.subHeading) && k.a((Object) this.paymentInstrumentStatus, (Object) sourcePayment.paymentInstrumentStatus) && k.a((Object) this.mpinSet, (Object) sourcePayment.mpinSet) && k.a((Object) this.credsAllowed, (Object) sourcePayment.credsAllowed);
    }

    public final int hashCode() {
        String str = this.vpaId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankAccountNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accRefId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ifscCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paymentType;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.balance;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.accountType;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.heading;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.subHeading;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.paymentInstrumentStatus;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.mpinSet;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        ArrayList<CredsAllowed> arrayList = this.credsAllowed;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "SourcePayment(vpaId=" + this.vpaId + ", bankAccountNumber=" + this.bankAccountNumber + ", accRefId=" + this.accRefId + ", ifscCode=" + this.ifscCode + ", bankName=" + this.bankName + ", paymentType=" + this.paymentType + ", balance=" + this.balance + ", accountType=" + this.accountType + ", heading=" + this.heading + ", subHeading=" + this.subHeading + ", paymentInstrumentStatus=" + this.paymentInstrumentStatus + ", mpinSet=" + this.mpinSet + ", credsAllowed=" + this.credsAllowed + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getVpaId() {
        return this.vpaId;
    }

    public final void setVpaId(String str) {
        this.vpaId = str;
    }

    public final String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public final void setBankAccountNumber(String str) {
        this.bankAccountNumber = str;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final void setAccRefId(String str) {
        this.accRefId = str;
    }

    public final String getIfscCode() {
        return this.ifscCode;
    }

    public final void setIfscCode(String str) {
        this.ifscCode = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final void setPaymentType(String str) {
        this.paymentType = str;
    }

    public final String getBalance() {
        return this.balance;
    }

    public final void setBalance(String str) {
        this.balance = str;
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final void setAccountType(String str) {
        this.accountType = str;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final String getSubHeading() {
        return this.subHeading;
    }

    public final void setSubHeading(String str) {
        this.subHeading = str;
    }

    public final String getPaymentInstrumentStatus() {
        return this.paymentInstrumentStatus;
    }

    public final void setPaymentInstrumentStatus(String str) {
        this.paymentInstrumentStatus = str;
    }

    public final String getMpinSet() {
        return this.mpinSet;
    }

    public final void setMpinSet(String str) {
        this.mpinSet = str;
    }

    public SourcePayment(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, ArrayList<CredsAllowed> arrayList) {
        this.vpaId = str;
        this.bankAccountNumber = str2;
        this.accRefId = str3;
        this.ifscCode = str4;
        this.bankName = str5;
        this.paymentType = str6;
        this.balance = str7;
        this.accountType = str8;
        this.heading = str9;
        this.subHeading = str10;
        this.paymentInstrumentStatus = str11;
        this.mpinSet = str12;
        this.credsAllowed = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SourcePayment(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.ArrayList r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.SourcePayment.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final ArrayList<CredsAllowed> getCredsAllowed() {
        return this.credsAllowed;
    }

    public final void setCredsAllowed(ArrayList<CredsAllowed> arrayList) {
        this.credsAllowed = arrayList;
    }
}
