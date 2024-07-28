package com.paytm.android.chat.network.response;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class View {
    private ArrayList<HomeChips> items;

    public View(ArrayList<HomeChips> arrayList) {
        k.c(arrayList, "items");
        this.items = arrayList;
    }

    public final ArrayList<HomeChips> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<HomeChips> arrayList) {
        k.c(arrayList, "<set-?>");
        this.items = arrayList;
    }
}
