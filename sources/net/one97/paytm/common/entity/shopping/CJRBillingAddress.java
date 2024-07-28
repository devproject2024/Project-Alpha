package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBillingAddress implements IJRDataModel {
    @b(a = "address")
    String address;
    @b(a = "name")
    String name;
    @b(a = "state")
    String state;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }
}
