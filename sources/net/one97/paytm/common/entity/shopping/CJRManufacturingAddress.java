package net.one97.paytm.common.entity.shopping;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRManufacturingAddress implements IJRDataModel {
    private String address;
    private String name;

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
}
