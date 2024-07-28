package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class Card extends IJRPaytmDataModel {
    @a
    @b(a = "amount")
    private String amount;
    @a
    @b(a = "icon")
    private String icon;
    @a
    @b(a = "info")
    private List<Info> info;
    @a
    @b(a = "source")
    private String source;

    public Card() {
        this((String) null, (String) null, (String) null, (List) null, 15, (g) null);
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Card(String str, String str2, String str3, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : list);
    }

    public final List<Info> getInfo() {
        return this.info;
    }

    public final void setInfo(List<Info> list) {
        this.info = list;
    }

    public Card(String str, String str2, String str3, List<Info> list) {
        this.source = str;
        this.amount = str2;
        this.icon = str3;
        this.info = list;
    }
}
