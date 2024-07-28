package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class Item extends IJRPaytmDataModel {
    private transient boolean isBold;
    @a
    @b(a = "price")
    private Integer price;
    @a
    @b(a = "text")
    private String text;

    public Item() {
        this((String) null, (Integer) null, false, 7, (g) null);
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final void setPrice(Integer num) {
        this.price = num;
    }

    public Item(String str, Integer num, boolean z) {
        this.text = str;
        this.price = num;
        this.isBold = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Item(String str, Integer num, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z);
    }

    public final boolean isBold() {
        return this.isBold;
    }

    public final void setBold(boolean z) {
        this.isBold = z;
    }
}
