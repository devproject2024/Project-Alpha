package net.one97.paytm.h5.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class H5AppAllowedBridgeModel implements IJRDataModel {
    @b(a = "name")
    private String name;

    public H5AppAllowedBridgeModel(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "MiniAppAllowedBridgeModel{name='" + this.name + '\'' + '}';
    }
}
