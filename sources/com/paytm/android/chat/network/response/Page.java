package com.paytm.android.chat.network.response;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class Page {
    private ArrayList<View> views;

    public Page(ArrayList<View> arrayList) {
        k.c(arrayList, "views");
        this.views = arrayList;
    }

    public final ArrayList<View> getViews() {
        return this.views;
    }

    public final void setViews(ArrayList<View> arrayList) {
        k.c(arrayList, "<set-?>");
        this.views = arrayList;
    }
}
