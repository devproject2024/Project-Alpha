package com.travel.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CalendarHoliday implements IJRDataModel {
    @a
    @b(a = "date")
    private String date;
    @a
    @b(a = "id")
    private String id;
    @a
    @b(a = "name")
    private String name;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }
}
