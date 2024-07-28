package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SecondPartyInfo extends IJRDataModel {
    @b(a = "logoUrl")
    private String logoUrl;
    @b(a = "name")
    private String name;

    public SecondPartyInfo() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ SecondPartyInfo copy$default(SecondPartyInfo secondPartyInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = secondPartyInfo.logoUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = secondPartyInfo.name;
        }
        return secondPartyInfo.copy(str, str2);
    }

    public final String component1() {
        return this.logoUrl;
    }

    public final String component2() {
        return this.name;
    }

    public final SecondPartyInfo copy(String str, String str2) {
        return new SecondPartyInfo(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SecondPartyInfo)) {
            return false;
        }
        SecondPartyInfo secondPartyInfo = (SecondPartyInfo) obj;
        return k.a((Object) this.logoUrl, (Object) secondPartyInfo.logoUrl) && k.a((Object) this.name, (Object) secondPartyInfo.name);
    }

    public final int hashCode() {
        String str = this.logoUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SecondPartyInfo(logoUrl=" + this.logoUrl + ", name=" + this.name + ")";
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SecondPartyInfo(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public SecondPartyInfo(String str, String str2) {
        this.logoUrl = str;
        this.name = str2;
    }
}
