package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import kotlin.g.b.g;

public final class PriceData {
    private final double finalPrice;
    private final double originalPrice;

    public PriceData() {
        this(0.0d, 0.0d, 3, (g) null);
    }

    public PriceData(double d2, double d3) {
        this.originalPrice = d2;
        this.finalPrice = d3;
    }

    public final double getOriginalPrice() {
        return this.originalPrice;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceData(double d2, double d3, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0.0d : d2, (i2 & 2) != 0 ? 0.0d : d3);
    }

    public final double getFinalPrice() {
        return this.finalPrice;
    }
}
