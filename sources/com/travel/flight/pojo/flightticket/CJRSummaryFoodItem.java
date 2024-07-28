package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.foodbeverage.CJRSummaryFoodData;

public class CJRSummaryFoodItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public CJRSummaryFoodData foodData;
    /* access modifiers changed from: private */
    public int itemPos;
    /* access modifiers changed from: private */
    public int size;

    public CJRSummaryFoodData getFoodData() {
        return this.foodData;
    }

    public int getItemPos() {
        return this.itemPos;
    }

    public int getSize() {
        return this.size;
    }
}
