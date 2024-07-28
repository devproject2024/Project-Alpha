package net.one97.paytm.common.entity.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryOrderItem implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "name")
    private String name;
    @b(a = "price")
    private Double price;
    @b(a = "quantity")
    private Double quantity;
    @b(a = "total_price")
    private Double total_price;
    @b(a = "total_weight")
    private Double total_weight;
    @b(a = "type")
    private String type;
    @b(a = "unit")
    private String unit;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public double getTotal_price() {
        return this.total_price.doubleValue();
    }

    public void setTotal_price(double d2) {
        this.total_price = Double.valueOf(d2);
    }

    public double getTotal_weight() {
        return this.total_weight.doubleValue();
    }

    public void setTotal_weight(double d2) {
        this.total_weight = Double.valueOf(d2);
    }

    public double getPrice() {
        return this.price.doubleValue();
    }

    public void setPrice(double d2) {
        this.price = Double.valueOf(d2);
    }

    public void setPrice(Double d2) {
        this.price = d2;
    }

    public void setTotal_price(Double d2) {
        this.total_price = d2;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double d2) {
        this.quantity = d2;
    }

    public void setTotal_weight(Double d2) {
        this.total_weight = d2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }
}
