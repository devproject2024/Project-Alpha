package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class SAUserInstrumentLogos extends IJRDataModel {
    @b(a = "logoUrl")
    private String logoUrl;
    @b(a = "sequence")
    private String sequence;

    public SAUserInstrumentLogos() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ SAUserInstrumentLogos copy$default(SAUserInstrumentLogos sAUserInstrumentLogos, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sAUserInstrumentLogos.logoUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = sAUserInstrumentLogos.sequence;
        }
        return sAUserInstrumentLogos.copy(str, str2);
    }

    public final String component1() {
        return this.logoUrl;
    }

    public final String component2() {
        return this.sequence;
    }

    public final SAUserInstrumentLogos copy(String str, String str2) {
        return new SAUserInstrumentLogos(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SAUserInstrumentLogos)) {
            return false;
        }
        SAUserInstrumentLogos sAUserInstrumentLogos = (SAUserInstrumentLogos) obj;
        return k.a((Object) this.logoUrl, (Object) sAUserInstrumentLogos.logoUrl) && k.a((Object) this.sequence, (Object) sAUserInstrumentLogos.sequence);
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
        return "SAUserInstrumentLogos(logoUrl=" + this.logoUrl + ", sequence=" + this.sequence + ")";
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SAUserInstrumentLogos(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getSequence() {
        return this.sequence;
    }

    public final void setSequence(String str) {
        this.sequence = str;
    }

    public SAUserInstrumentLogos(String str, String str2) {
        this.logoUrl = str;
        this.sequence = str2;
    }
}
