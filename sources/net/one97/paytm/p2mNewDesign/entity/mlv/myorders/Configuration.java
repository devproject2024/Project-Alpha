package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Configuration extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "discoverability")
    private String discoverability;
    @b(a = "price")
    private Double price;

    public Configuration() {
        this((Double) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ Configuration copy$default(Configuration configuration, Double d2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = configuration.price;
        }
        if ((i2 & 2) != 0) {
            str = configuration.discoverability;
        }
        return configuration.copy(d2, str);
    }

    public final Double component1() {
        return this.price;
    }

    public final String component2() {
        return this.discoverability;
    }

    public final Configuration copy(Double d2, String str) {
        return new Configuration(d2, str);
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
        Double d2 = this.price;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.discoverability;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Configuration(price=" + this.price + ", discoverability=" + this.discoverability + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Double getPrice() {
        return this.price;
    }

    public final void setPrice(Double d2) {
        this.price = d2;
    }

    public Configuration(Double d2, String str) {
        this.price = d2;
        this.discoverability = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Configuration(Double d2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : str);
    }

    public final String getDiscoverability() {
        return this.discoverability;
    }

    public final void setDiscoverability(String str) {
        this.discoverability = str;
    }
}
