package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class Header extends IJRPaytmDataModel {
    @a
    @b(a = "desc")
    private String desc;
    @a
    @b(a = "price")
    private Integer price;
    @a
    @b(a = "title")
    private String title;

    public Header() {
        this((String) null, (String) null, (Integer) null, 7, (g) null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public Header(String str, String str2, Integer num) {
        this.title = str;
        this.desc = str2;
        this.price = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Header(String str, String str2, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : num);
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final void setPrice(Integer num) {
        this.price = num;
    }
}
