package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class FulFillmentRequest implements IJRDataModel {
    @b(a = "insurance_type")
    private int insurance_type;
    @b(a = "price")
    private String price;

    public int getInsurance_type() {
        return this.insurance_type;
    }

    public String getPrice() {
        return this.price;
    }
}
