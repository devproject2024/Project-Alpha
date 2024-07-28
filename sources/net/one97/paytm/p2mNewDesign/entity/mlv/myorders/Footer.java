package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Footer extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "header")
    private String header;

    public Footer() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ Footer copy$default(Footer footer, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = footer.header;
        }
        if ((i2 & 2) != 0) {
            str2 = footer.description;
        }
        return footer.copy(str, str2);
    }

    public final String component1() {
        return this.header;
    }

    public final String component2() {
        return this.description;
    }

    public final Footer copy(String str, String str2) {
        return new Footer(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Footer)) {
            return false;
        }
        Footer footer = (Footer) obj;
        return k.a((Object) this.header, (Object) footer.header) && k.a((Object) this.description, (Object) footer.description);
    }

    public final int hashCode() {
        String str = this.header;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Footer(header=" + this.header + ", description=" + this.description + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public Footer(String str, String str2) {
        this.header = str;
        this.description = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Footer(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }
}
