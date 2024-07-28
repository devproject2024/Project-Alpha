package com.travel.flight.pojo.flightticket.Ancillary;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySSRSFoodItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private Double amount;
    @b(a = "available_quantity")
    private String available_quantity;
    @b(a = "code")
    private String code;
    @b(a = "is_veg")
    private String isVeg = null;
    @b(a = "name")
    private String name;
    @a(a = false, b = false)
    private int selectedQuantity = 0;

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double d2) {
        this.amount = d2;
    }

    public String getAvailable_quantity() {
        return this.available_quantity;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public Boolean isVeg() {
        if (TextUtils.isEmpty(this.isVeg)) {
            return null;
        }
        if (this.isVeg.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (this.isVeg.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public int getSelectedQuantity() {
        return this.selectedQuantity;
    }

    public void setSelectedQuantity(int i2) {
        this.selectedQuantity = i2;
    }
}
