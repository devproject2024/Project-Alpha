package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

final class k implements IJRDataModel {
    @a
    @b(a = "id")
    private String id;

    k() {
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }
}
