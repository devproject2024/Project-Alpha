package net.one97.paytm.o2o.movies.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class Views extends IJRPaytmDataModel {
    @b(a = "items")
    private List<Items> items;
    @b(a = "title")
    private String title = "";
    @b(a = "type")
    private String type;

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final List<Items> getItems() {
        return this.items;
    }

    public final void setItems(List<Items> list) {
        this.items = list;
    }
}
