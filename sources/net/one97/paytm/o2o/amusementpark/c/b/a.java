package net.one97.paytm.o2o.amusementpark.c.b;

import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.io.Serializable;

public final class a implements Serializable {
    private String displayPriceText;
    private String mPackageType;
    private int maxPrice;
    private int minPrice;
    private String packageDescription;

    public final String getDisplayPriceText() {
        int i2 = this.minPrice;
        int i3 = this.maxPrice;
        if (i2 == i3) {
            return FilterPriceSliderFragment.RUPEE_SYMBOL + String.valueOf(this.minPrice);
        } else if (i2 > i3) {
            return FilterPriceSliderFragment.RUPEE_SYMBOL + this.maxPrice + " - ₹" + this.minPrice;
        } else {
            return FilterPriceSliderFragment.RUPEE_SYMBOL + this.minPrice + " - ₹" + this.maxPrice;
        }
    }

    public final String getmPackageType() {
        return this.mPackageType;
    }

    public final void setmPackageType(String str) {
        this.mPackageType = str;
    }

    public final double getMinPrice() {
        return (double) this.minPrice;
    }

    public final void setMinPrice(int i2) {
        this.minPrice = i2;
    }

    public final void setMaxPrice(int i2) {
        this.maxPrice = i2;
    }

    public final String getPackageDescription() {
        return this.packageDescription;
    }

    public final void setPackageDescription(String str) {
        this.packageDescription = str;
    }
}
