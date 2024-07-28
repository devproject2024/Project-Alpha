package net.one97.paytm.common.entity.insurance;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class FulFillmentRequest implements IJRDataModel {
    @b(a = "category_id")
    private String categoryId;
    @b(a = "insurance_type")
    private int insurance_type;
    @b(a = "pointsOrderSummary")
    private String pointsOrderSummary;
    @b(a = "price")
    private String price;
    @b(a = "targetMobile")
    private String targetMobile;

    public int getInsurance_type() {
        return this.insurance_type;
    }

    public String getPrice() {
        return this.price;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getPointsOrderSummary() {
        return this.pointsOrderSummary;
    }

    public String getTargetMobile() {
        return this.targetMobile;
    }

    public void setTargetMobile(String str) {
        this.targetMobile = str;
    }
}
