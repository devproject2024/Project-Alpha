package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRQueryListTabContainer implements IJRDataModel {
    @b(a = "items")
    private ArrayList<CJRQueryListTab> items;

    public ArrayList<CJRQueryListTab> getQueryListTabs() {
        return this.items;
    }

    public void setQueryListTabs(ArrayList<CJRQueryListTab> arrayList) {
        this.items = arrayList;
    }
}
