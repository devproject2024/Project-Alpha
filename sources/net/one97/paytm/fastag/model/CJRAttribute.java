package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAttribute extends IJRPaytmDataModel {
    @b(a = "Color")
    private String color;
    @b(a = "Size")
    private String mSize;

    public String getSize() {
        return this.mSize;
    }

    public String getColor() {
        return this.color;
    }
}
