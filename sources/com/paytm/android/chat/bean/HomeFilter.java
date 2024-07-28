package com.paytm.android.chat.bean;

import java.util.ArrayList;
import kotlin.g.b.k;

public final class HomeFilter {
    private int count;
    private ArrayList<String> filters;

    public static /* synthetic */ HomeFilter copy$default(HomeFilter homeFilter, int i2, ArrayList<String> arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = homeFilter.count;
        }
        if ((i3 & 2) != 0) {
            arrayList = homeFilter.filters;
        }
        return homeFilter.copy(i2, arrayList);
    }

    public final int component1() {
        return this.count;
    }

    public final ArrayList<String> component2() {
        return this.filters;
    }

    public final HomeFilter copy(int i2, ArrayList<String> arrayList) {
        k.c(arrayList, "filters");
        return new HomeFilter(i2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeFilter)) {
            return false;
        }
        HomeFilter homeFilter = (HomeFilter) obj;
        return this.count == homeFilter.count && k.a((Object) this.filters, (Object) homeFilter.filters);
    }

    public final int hashCode() {
        int i2 = this.count * 31;
        ArrayList<String> arrayList = this.filters;
        return i2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        return "HomeFilter(count=" + this.count + ", filters=" + this.filters + ")";
    }

    public HomeFilter(int i2, ArrayList<String> arrayList) {
        k.c(arrayList, "filters");
        this.count = i2;
        this.filters = arrayList;
    }

    public final int getCount() {
        return this.count;
    }

    public final ArrayList<String> getFilters() {
        return this.filters;
    }

    public final void setCount(int i2) {
        this.count = i2;
    }

    public final void setFilters(ArrayList<String> arrayList) {
        k.c(arrayList, "<set-?>");
        this.filters = arrayList;
    }
}
