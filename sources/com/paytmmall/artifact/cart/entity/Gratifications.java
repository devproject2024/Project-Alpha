package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class Gratifications extends IJRPaytmDataModel {
    @a
    @b(a = "label")
    private String label;
    @a
    @b(a = "type")
    private String type;
    @a
    @b(a = "value")
    private Integer value;

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer num) {
        this.value = num;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
