package net.one97.paytm.common.entity.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

class CJRMoviePassPriceModel implements IJRDataModel {
    @b(a = "base")
    private int basePrice;
    private float tax1;
    private float tax2;

    CJRMoviePassPriceModel() {
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public float getTax1() {
        return this.tax1;
    }

    public float getTax2() {
        return this.tax2;
    }
}
