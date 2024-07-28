package net.one97.paytm.o2o.movies.entity;

public final class CJROrderPricing {
    private double convFee;
    private double cpPrice;
    private double fnbPrice;
    private double glassPrice;
    private double promoDiscount;
    private double seatPrice;

    public static /* synthetic */ CJROrderPricing copy$default(CJROrderPricing cJROrderPricing, double d2, double d3, double d4, double d5, double d6, double d7, int i2, Object obj) {
        CJROrderPricing cJROrderPricing2 = cJROrderPricing;
        return cJROrderPricing.copy((i2 & 1) != 0 ? cJROrderPricing2.seatPrice : d2, (i2 & 2) != 0 ? cJROrderPricing2.convFee : d3, (i2 & 4) != 0 ? cJROrderPricing2.promoDiscount : d4, (i2 & 8) != 0 ? cJROrderPricing2.fnbPrice : d5, (i2 & 16) != 0 ? cJROrderPricing2.cpPrice : d6, (i2 & 32) != 0 ? cJROrderPricing2.glassPrice : d7);
    }

    public final double component1() {
        return this.seatPrice;
    }

    public final double component2() {
        return this.convFee;
    }

    public final double component3() {
        return this.promoDiscount;
    }

    public final double component4() {
        return this.fnbPrice;
    }

    public final double component5() {
        return this.cpPrice;
    }

    public final double component6() {
        return this.glassPrice;
    }

    public final CJROrderPricing copy(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new CJROrderPricing(d2, d3, d4, d5, d6, d7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJROrderPricing)) {
            return false;
        }
        CJROrderPricing cJROrderPricing = (CJROrderPricing) obj;
        return Double.compare(this.seatPrice, cJROrderPricing.seatPrice) == 0 && Double.compare(this.convFee, cJROrderPricing.convFee) == 0 && Double.compare(this.promoDiscount, cJROrderPricing.promoDiscount) == 0 && Double.compare(this.fnbPrice, cJROrderPricing.fnbPrice) == 0 && Double.compare(this.cpPrice, cJROrderPricing.cpPrice) == 0 && Double.compare(this.glassPrice, cJROrderPricing.glassPrice) == 0;
    }

    public final int hashCode() {
        return (((((((((Double.valueOf(this.seatPrice).hashCode() * 31) + Double.valueOf(this.convFee).hashCode()) * 31) + Double.valueOf(this.promoDiscount).hashCode()) * 31) + Double.valueOf(this.fnbPrice).hashCode()) * 31) + Double.valueOf(this.cpPrice).hashCode()) * 31) + Double.valueOf(this.glassPrice).hashCode();
    }

    public final String toString() {
        return "CJROrderPricing(seatPrice=" + this.seatPrice + ", convFee=" + this.convFee + ", promoDiscount=" + this.promoDiscount + ", fnbPrice=" + this.fnbPrice + ", cpPrice=" + this.cpPrice + ", glassPrice=" + this.glassPrice + ")";
    }

    public CJROrderPricing(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.seatPrice = d2;
        this.convFee = d3;
        this.promoDiscount = d4;
        this.fnbPrice = d5;
        this.cpPrice = d6;
        this.glassPrice = d7;
    }

    public final double getConvFee() {
        return this.convFee;
    }

    public final double getCpPrice() {
        return this.cpPrice;
    }

    public final double getFnbPrice() {
        return this.fnbPrice;
    }

    public final double getGlassPrice() {
        return this.glassPrice;
    }

    public final double getPromoDiscount() {
        return this.promoDiscount;
    }

    public final double getSeatPrice() {
        return this.seatPrice;
    }

    public final void setConvFee(double d2) {
        this.convFee = d2;
    }

    public final void setCpPrice(double d2) {
        this.cpPrice = d2;
    }

    public final void setFnbPrice(double d2) {
        this.fnbPrice = d2;
    }

    public final void setGlassPrice(double d2) {
        this.glassPrice = d2;
    }

    public final void setPromoDiscount(double d2) {
        this.promoDiscount = d2;
    }

    public final void setSeatPrice(double d2) {
        this.seatPrice = d2;
    }
}
