package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAttribute implements IJRDataModel {
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
