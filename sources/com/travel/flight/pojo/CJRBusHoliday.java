package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusHoliday implements IJRDataModel {
    @a
    @b(a = "date")
    private String date;
    @a
    @b(a = "id")
    private String id;
    @a
    @b(a = "name")
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }
}
