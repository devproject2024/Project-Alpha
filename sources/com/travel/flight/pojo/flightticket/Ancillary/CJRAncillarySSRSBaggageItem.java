package com.travel.flight.pojo.flightticket.Ancillary;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillarySSRSBaggageItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private Double amount;
    @b(a = "available_quantity")
    private String available_quantity;
    @b(a = "code")
    private String code;
    @b(a = "name")
    private String name;
    @a(a = false, b = false)
    private int selectedQuantity = 0;
    @b(a = "unit")
    private String unit;
    @b(a = "weight")
    private String weight;

    public Double getAmount() {
        return this.amount;
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

    public String getWeight() {
        return this.weight;
    }

    public String getUnit() {
        return this.unit;
    }

    public int getSelectedQuantity() {
        return this.selectedQuantity;
    }

    public void setSelectedQuantity(int i2) {
        this.selectedQuantity = i2;
    }
}
