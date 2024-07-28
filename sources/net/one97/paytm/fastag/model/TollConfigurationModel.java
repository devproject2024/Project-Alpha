package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class TollConfigurationModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "price")
    private String price;
    @b(a = "totalamount")
    private String totalamount;

    public String getTotalamount() {
        return this.totalamount;
    }

    public void setTotalamount(String str) {
        this.totalamount = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }
}
