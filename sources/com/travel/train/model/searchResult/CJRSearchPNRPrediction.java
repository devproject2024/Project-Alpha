package com.travel.train.model.searchResult;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSearchPNRPrediction extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "color")
    private String color;
    @a
    @b(a = "value")
    private int value;

    public CJRSearchPNRPrediction() {
        this(0, (String) null, 3, (g) null);
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i2) {
        this.value = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRSearchPNRPrediction(int i2, String str, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str);
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public CJRSearchPNRPrediction(int i2, String str) {
        this.value = i2;
        this.color = str;
    }
}
