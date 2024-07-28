package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Attributes extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "points_price")
    private Double points_price;

    public Attributes() {
        this((Double) null, 1, (g) null);
    }

    public static /* synthetic */ Attributes copy$default(Attributes attributes, Double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = attributes.points_price;
        }
        return attributes.copy(d2);
    }

    public final Double component1() {
        return this.points_price;
    }

    public final Attributes copy(Double d2) {
        return new Attributes(d2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Attributes) && k.a((Object) this.points_price, (Object) ((Attributes) obj).points_price);
        }
        return true;
    }

    public final int hashCode() {
        Double d2 = this.points_price;
        if (d2 != null) {
            return d2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Attributes(points_price=" + this.points_price + ")";
    }

    public Attributes(Double d2) {
        this.points_price = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Attributes(Double d2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2);
    }

    public final Double getPoints_price() {
        return this.points_price;
    }

    public final void setPoints_price(Double d2) {
        this.points_price = d2;
    }
}
