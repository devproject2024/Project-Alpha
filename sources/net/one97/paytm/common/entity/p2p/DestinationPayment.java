package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class DestinationPayment extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "bankAccountNumber")
    private String bankAccountNumber;
    @b(a = "bankName")
    private String bankName;
    @b(a = "ifscCode")
    private String ifscCode;
    @b(a = "paymentInstrumentStatus")
    private String paymentInstrumentStatus;
    @b(a = "paymentType")
    private String paymentType;
    @b(a = "vpaId")
    private String vpaId;

    public DestinationPayment() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ DestinationPayment copy$default(DestinationPayment destinationPayment, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = destinationPayment.bankAccountNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = destinationPayment.ifscCode;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = destinationPayment.bankName;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = destinationPayment.paymentType;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = destinationPayment.vpaId;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = destinationPayment.paymentInstrumentStatus;
        }
        return destinationPayment.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.bankAccountNumber;
    }

    public final String component2() {
        return this.ifscCode;
    }

    public final String component3() {
        return this.bankName;
    }

    public final String component4() {
        return this.paymentType;
    }

    public final String component5() {
        return this.vpaId;
    }

    public final String component6() {
        return this.paymentInstrumentStatus;
    }

    public final DestinationPayment copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new DestinationPayment(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DestinationPayment)) {
            return false;
        }
        DestinationPayment destinationPayment = (DestinationPayment) obj;
        return k.a((Object) this.bankAccountNumber, (Object) destinationPayment.bankAccountNumber) && k.a((Object) this.ifscCode, (Object) destinationPayment.ifscCode) && k.a((Object) this.bankName, (Object) destinationPayment.bankName) && k.a((Object) this.paymentType, (Object) destinationPayment.paymentType) && k.a((Object) this.vpaId, (Object) destinationPayment.vpaId) && k.a((Object) this.paymentInstrumentStatus, (Object) destinationPayment.paymentInstrumentStatus);
    }

    public final int hashCode() {
        String str = this.bankAccountNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ifscCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.paymentType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.vpaId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paymentInstrumentStatus;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "DestinationPayment(bankAccountNumber=" + this.bankAccountNumber + ", ifscCode=" + this.ifscCode + ", bankName=" + this.bankName + ", paymentType=" + this.paymentType + ", vpaId=" + this.vpaId + ", paymentInstrumentStatus=" + this.paymentInstrumentStatus + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public final void setBankAccountNumber(String str) {
        this.bankAccountNumber = str;
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

    public final String getVpaId() {
        return this.vpaId;
    }

    public final void setVpaId(String str) {
        this.vpaId = str;
    }

    public DestinationPayment(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bankAccountNumber = str;
        this.ifscCode = str2;
        this.bankName = str3;
        this.paymentType = str4;
        this.vpaId = str5;
        this.paymentInstrumentStatus = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DestinationPayment(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.DestinationPayment.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPaymentInstrumentStatus() {
        return this.paymentInstrumentStatus;
    }

    public final void setPaymentInstrumentStatus(String str) {
        this.paymentInstrumentStatus = str;
    }
}
