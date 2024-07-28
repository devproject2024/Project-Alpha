package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConfigurationModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "conv_fee")
    private String conv_fee;
    @b(a = "price")
    private String price;

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getconv_fee() {
        return this.conv_fee;
    }

    public void setconv_fee(String str) {
        this.conv_fee = str;
    }
}
