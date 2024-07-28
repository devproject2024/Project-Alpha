package net.one97.paytm.common.entity.landling;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCategoryHeader implements IJRDataModel {
    private String name;
    private int recyclerPos;
    private int tabPos;

    public CJRCategoryHeader(String str, int i2, int i3) {
        this.name = str;
        this.tabPos = i2;
        this.recyclerPos = i3;
    }

    public String getName() {
        return this.name;
    }

    public int getTabPos() {
        return this.tabPos;
    }

    public int getRecyclerPos() {
        return this.recyclerPos;
    }
}
