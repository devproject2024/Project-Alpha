package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class SubApiItem extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "name")
    private String name;
    @c(a = "version")
    private int version;

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "SubApiItem{name = '" + this.name + '\'' + ",version = '" + this.version + '\'' + "}";
    }
}
