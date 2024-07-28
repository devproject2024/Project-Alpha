package net.one97.paytm.common.entity.upgradeKyc;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentSaveForm60 {
    private String agriculturalIncome;
    private String nonAgriculturalIncome;
    private String panAckDate;
    private String panAckNumber;

    public ConsentSaveForm60() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ ConsentSaveForm60 copy$default(ConsentSaveForm60 consentSaveForm60, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consentSaveForm60.agriculturalIncome;
        }
        if ((i2 & 2) != 0) {
            str2 = consentSaveForm60.nonAgriculturalIncome;
        }
        if ((i2 & 4) != 0) {
            str3 = consentSaveForm60.panAckNumber;
        }
        if ((i2 & 8) != 0) {
            str4 = consentSaveForm60.panAckDate;
        }
        return consentSaveForm60.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.agriculturalIncome;
    }

    public final String component2() {
        return this.nonAgriculturalIncome;
    }

    public final String component3() {
        return this.panAckNumber;
    }

    public final String component4() {
        return this.panAckDate;
    }

    public final ConsentSaveForm60 copy(String str, String str2, String str3, String str4) {
        k.c(str, "agriculturalIncome");
        k.c(str2, "nonAgriculturalIncome");
        k.c(str3, "panAckNumber");
        k.c(str4, "panAckDate");
        return new ConsentSaveForm60(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentSaveForm60)) {
            return false;
        }
        ConsentSaveForm60 consentSaveForm60 = (ConsentSaveForm60) obj;
        return k.a((Object) this.agriculturalIncome, (Object) consentSaveForm60.agriculturalIncome) && k.a((Object) this.nonAgriculturalIncome, (Object) consentSaveForm60.nonAgriculturalIncome) && k.a((Object) this.panAckNumber, (Object) consentSaveForm60.panAckNumber) && k.a((Object) this.panAckDate, (Object) consentSaveForm60.panAckDate);
    }

    public final int hashCode() {
        String str = this.agriculturalIncome;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nonAgriculturalIncome;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.panAckNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.panAckDate;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ConsentSaveForm60(agriculturalIncome=" + this.agriculturalIncome + ", nonAgriculturalIncome=" + this.nonAgriculturalIncome + ", panAckNumber=" + this.panAckNumber + ", panAckDate=" + this.panAckDate + ")";
    }

    public ConsentSaveForm60(String str, String str2, String str3, String str4) {
        k.c(str, "agriculturalIncome");
        k.c(str2, "nonAgriculturalIncome");
        k.c(str3, "panAckNumber");
        k.c(str4, "panAckDate");
        this.agriculturalIncome = str;
        this.nonAgriculturalIncome = str2;
        this.panAckNumber = str3;
        this.panAckDate = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentSaveForm60(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4);
    }

    public final String getAgriculturalIncome() {
        return this.agriculturalIncome;
    }

    public final String getNonAgriculturalIncome() {
        return this.nonAgriculturalIncome;
    }

    public final String getPanAckDate() {
        return this.panAckDate;
    }

    public final String getPanAckNumber() {
        return this.panAckNumber;
    }

    public final void setAgriculturalIncome(String str) {
        k.c(str, "<set-?>");
        this.agriculturalIncome = str;
    }

    public final void setNonAgriculturalIncome(String str) {
        k.c(str, "<set-?>");
        this.nonAgriculturalIncome = str;
    }

    public final void setPanAckDate(String str) {
        k.c(str, "<set-?>");
        this.panAckDate = str;
    }

    public final void setPanAckNumber(String str) {
        k.c(str, "<set-?>");
        this.panAckNumber = str;
    }
}
