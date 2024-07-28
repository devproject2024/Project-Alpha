package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Configuration extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "discoverability")
    private String discoverability;
    @b(a = "price")
    private String price;

    public Configuration() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = configuration.price;
        }
        if ((i2 & 2) != 0) {
            str2 = configuration.discoverability;
        }
        return configuration.copy(str, str2);
    }

    public final String component1() {
        return this.price;
    }

    public final String component2() {
        return this.discoverability;
    }

    public final Configuration copy(String str, String str2) {
        return new Configuration(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return k.a((Object) this.price, (Object) configuration.price) && k.a((Object) this.discoverability, (Object) configuration.discoverability);
    }

    public final int hashCode() {
        String str = this.price;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.discoverability;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Configuration(price=" + this.price + ", discoverability=" + this.discoverability + ")";
    }

    public Configuration(String str, String str2) {
        this.price = str;
        this.discoverability = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Configuration(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getDiscoverability() {
        return this.discoverability;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setDiscoverability(String str) {
        this.discoverability = str;
    }

    public final void setPrice(String str) {
        this.price = str;
    }
}
