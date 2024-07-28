package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class ExtraInfo extends IJRDataModel {
    @b(a = "payerVPA")
    private String payerVPA;
    @b(a = "remitterName")
    private String remitterName;
    @b(a = "upiTranId")
    private String upiTranId;

    public ExtraInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ExtraInfo copy$default(ExtraInfo extraInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = extraInfo.remitterName;
        }
        if ((i2 & 2) != 0) {
            str2 = extraInfo.upiTranId;
        }
        if ((i2 & 4) != 0) {
            str3 = extraInfo.payerVPA;
        }
        return extraInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.remitterName;
    }

    public final String component2() {
        return this.upiTranId;
    }

    public final String component3() {
        return this.payerVPA;
    }

    public final ExtraInfo copy(String str, String str2, String str3) {
        return new ExtraInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraInfo)) {
            return false;
        }
        ExtraInfo extraInfo = (ExtraInfo) obj;
        return k.a((Object) this.remitterName, (Object) extraInfo.remitterName) && k.a((Object) this.upiTranId, (Object) extraInfo.upiTranId) && k.a((Object) this.payerVPA, (Object) extraInfo.payerVPA);
    }

    public final int hashCode() {
        String str = this.remitterName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.upiTranId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.payerVPA;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ExtraInfo(remitterName=" + this.remitterName + ", upiTranId=" + this.upiTranId + ", payerVPA=" + this.payerVPA + ")";
    }

    public final String getRemitterName() {
        return this.remitterName;
    }

    public final void setRemitterName(String str) {
        this.remitterName = str;
    }

    public final String getUpiTranId() {
        return this.upiTranId;
    }

    public final void setUpiTranId(String str) {
        this.upiTranId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExtraInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getPayerVPA() {
        return this.payerVPA;
    }

    public final void setPayerVPA(String str) {
        this.payerVPA = str;
    }

    public ExtraInfo(String str, String str2, String str3) {
        this.remitterName = str;
        this.upiTranId = str2;
        this.payerVPA = str3;
    }
}
