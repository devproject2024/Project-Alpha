package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSummaryFoodBeveragesResponse implements IJRDataModel {
    @b(a = "data")
    private ArrayList<CJRSummaryFoodData> data;
    @b(a = "totalChargedPrice")
    private String totalChargedPrice;

    public String getTotalChargedPrice() {
        return this.totalChargedPrice;
    }

    public ArrayList<CJRSummaryFoodData> getData() {
        return this.data;
    }
}
