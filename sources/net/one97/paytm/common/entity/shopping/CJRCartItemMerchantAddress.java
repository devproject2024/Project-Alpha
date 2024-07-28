package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCartItemMerchantAddress implements IJRDataModel {
    @b(a = "city")
    private String city;
    @b(a = "state")
    private String state;

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }
}
