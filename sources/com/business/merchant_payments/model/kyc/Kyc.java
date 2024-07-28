package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;

public final class Kyc {
    public final String bankAccountNumber;
    public final String bankIconUrl;
    public final String bankName;
    public final String ifsc;
    public final boolean isPreferred;

    public static /* synthetic */ Kyc copy$default(Kyc kyc, String str, String str2, String str3, String str4, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kyc.bankAccountNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = kyc.bankIconUrl;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = kyc.bankName;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = kyc.ifsc;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            z = kyc.isPreferred;
        }
        return kyc.copy(str, str5, str6, str7, z);
    }

    public final String component1() {
        return this.bankAccountNumber;
    }

    public final String component2() {
        return this.bankIconUrl;
    }

    public final String component3() {
        return this.bankName;
    }

    public final String component4() {
        return this.ifsc;
    }

    public final boolean component5() {
        return this.isPreferred;
    }

    public final Kyc copy(String str, String str2, String str3, String str4, boolean z) {
        k.d(str, "bankAccountNumber");
        k.d(str2, "bankIconUrl");
        k.d(str3, "bankName");
        k.d(str4, "ifsc");
        return new Kyc(str, str2, str3, str4, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Kyc)) {
            return false;
        }
        Kyc kyc = (Kyc) obj;
        return k.a((Object) this.bankAccountNumber, (Object) kyc.bankAccountNumber) && k.a((Object) this.bankIconUrl, (Object) kyc.bankIconUrl) && k.a((Object) this.bankName, (Object) kyc.bankName) && k.a((Object) this.ifsc, (Object) kyc.ifsc) && this.isPreferred == kyc.isPreferred;
    }

    public final int hashCode() {
        String str = this.bankAccountNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankIconUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ifsc;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.isPreferred;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Kyc(bankAccountNumber=" + this.bankAccountNumber + ", bankIconUrl=" + this.bankIconUrl + ", bankName=" + this.bankName + ", ifsc=" + this.ifsc + ", isPreferred=" + this.isPreferred + ")";
    }

    public Kyc(String str, String str2, String str3, String str4, boolean z) {
        k.d(str, "bankAccountNumber");
        k.d(str2, "bankIconUrl");
        k.d(str3, "bankName");
        k.d(str4, "ifsc");
        this.bankAccountNumber = str;
        this.bankIconUrl = str2;
        this.bankName = str3;
        this.ifsc = str4;
        this.isPreferred = z;
    }

    public final String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public final String getBankIconUrl() {
        return this.bankIconUrl;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final boolean isPreferred() {
        return this.isPreferred;
    }
}
