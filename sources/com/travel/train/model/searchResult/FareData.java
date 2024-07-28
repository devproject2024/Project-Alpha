package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class FareData extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "class")
    private String className;
    @a
    @b(a = "price")
    private String price;

    public FareData() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getClassName() {
        return this.className;
    }

    public final void setClassName(String str) {
        this.className = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FareData(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public FareData(String str, String str2) {
        this.className = str;
        this.price = str2;
    }
}
