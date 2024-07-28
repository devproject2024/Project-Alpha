package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class UserInstrumentLogos extends IJRDataModel {
    @b(a = "logoUrl")
    private String logoUrl;
    @b(a = "sequence")
    private String sequence;

    public UserInstrumentLogos() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ UserInstrumentLogos copy$default(UserInstrumentLogos userInstrumentLogos, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userInstrumentLogos.logoUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = userInstrumentLogos.sequence;
        }
        return userInstrumentLogos.copy(str, str2);
    }

    public final String component1() {
        return this.logoUrl;
    }

    public final String component2() {
        return this.sequence;
    }

    public final UserInstrumentLogos copy(String str, String str2) {
        return new UserInstrumentLogos(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInstrumentLogos)) {
            return false;
        }
        UserInstrumentLogos userInstrumentLogos = (UserInstrumentLogos) obj;
        return k.a((Object) this.logoUrl, (Object) userInstrumentLogos.logoUrl) && k.a((Object) this.sequence, (Object) userInstrumentLogos.sequence);
    }

    public final int hashCode() {
        String str = this.logoUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sequence;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UserInstrumentLogos(logoUrl=" + this.logoUrl + ", sequence=" + this.sequence + ")";
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserInstrumentLogos(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getSequence() {
        return this.sequence;
    }

    public final void setSequence(String str) {
        this.sequence = str;
    }

    public UserInstrumentLogos(String str, String str2) {
        this.logoUrl = str;
        this.sequence = str2;
    }
}
