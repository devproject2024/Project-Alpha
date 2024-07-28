package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class Facets {
    @b(a = "displayFilterType")
    private String displayFilterType;
    @b(a = "displayName")
    private String displayName;
    @b(a = "field")
    private String field;
    @b(a = "items")
    private ArrayList<VoucherFilterItem> items;

    public String getDisplayFilterType() {
        return this.displayFilterType;
    }

    public void setDisplayFilterType(String str) {
        this.displayFilterType = str;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String str) {
        this.field = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public ArrayList<VoucherFilterItem> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<VoucherFilterItem> arrayList) {
        this.items = arrayList;
    }
}
