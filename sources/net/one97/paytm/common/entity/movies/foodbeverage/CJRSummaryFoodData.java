package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSummaryFoodData implements IJRDataModel {
    @b(a = "itemDescription")
    private String itemDescription;
    @b(a = "itemImageUrl")
    private String itemImageUrl;
    @b(a = "itemName")
    private String itemName;
    @b(a = "quantity")
    private int quantity;
    @b(a = "totalChargedPrice")
    private String totalChargedPrice;

    public String getItemDescription() {
        return this.itemDescription;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getTotalChargedPrice() {
        return this.totalChargedPrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setItemDescription(String str) {
        this.itemDescription = str;
    }

    public String getItemImageUrl() {
        return this.itemImageUrl;
    }
}
