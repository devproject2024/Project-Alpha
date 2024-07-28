package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.ArrayList;
import kotlin.g.b.k;

public final class GroupGridLayoutDataModel {
    private int count;
    private final String mCategoryTitle;
    private final ArrayList<Item> mGridItemlist;
    private final Item mTickerItem;

    public static /* synthetic */ GroupGridLayoutDataModel copy$default(GroupGridLayoutDataModel groupGridLayoutDataModel, String str, Item item, int i2, ArrayList<Item> arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = groupGridLayoutDataModel.mCategoryTitle;
        }
        if ((i3 & 2) != 0) {
            item = groupGridLayoutDataModel.mTickerItem;
        }
        if ((i3 & 4) != 0) {
            i2 = groupGridLayoutDataModel.count;
        }
        if ((i3 & 8) != 0) {
            arrayList = groupGridLayoutDataModel.mGridItemlist;
        }
        return groupGridLayoutDataModel.copy(str, item, i2, arrayList);
    }

    public final String component1() {
        return this.mCategoryTitle;
    }

    public final Item component2() {
        return this.mTickerItem;
    }

    public final int component3() {
        return this.count;
    }

    public final ArrayList<Item> component4() {
        return this.mGridItemlist;
    }

    public final GroupGridLayoutDataModel copy(String str, Item item, int i2, ArrayList<Item> arrayList) {
        k.c(str, "mCategoryTitle");
        k.c(item, "mTickerItem");
        k.c(arrayList, "mGridItemlist");
        return new GroupGridLayoutDataModel(str, item, i2, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GroupGridLayoutDataModel) {
                GroupGridLayoutDataModel groupGridLayoutDataModel = (GroupGridLayoutDataModel) obj;
                if (k.a((Object) this.mCategoryTitle, (Object) groupGridLayoutDataModel.mCategoryTitle) && k.a((Object) this.mTickerItem, (Object) groupGridLayoutDataModel.mTickerItem)) {
                    if (!(this.count == groupGridLayoutDataModel.count) || !k.a((Object) this.mGridItemlist, (Object) groupGridLayoutDataModel.mGridItemlist)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.mCategoryTitle;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Item item = this.mTickerItem;
        int hashCode2 = (((hashCode + (item != null ? item.hashCode() : 0)) * 31) + this.count) * 31;
        ArrayList<Item> arrayList = this.mGridItemlist;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "GroupGridLayoutDataModel(mCategoryTitle=" + this.mCategoryTitle + ", mTickerItem=" + this.mTickerItem + ", count=" + this.count + ", mGridItemlist=" + this.mGridItemlist + ")";
    }

    public GroupGridLayoutDataModel(String str, Item item, int i2, ArrayList<Item> arrayList) {
        k.c(str, "mCategoryTitle");
        k.c(item, "mTickerItem");
        k.c(arrayList, "mGridItemlist");
        this.mCategoryTitle = str;
        this.mTickerItem = item;
        this.count = i2;
        this.mGridItemlist = arrayList;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getMCategoryTitle() {
        return this.mCategoryTitle;
    }

    public final ArrayList<Item> getMGridItemlist() {
        return this.mGridItemlist;
    }

    public final Item getMTickerItem() {
        return this.mTickerItem;
    }

    public final void setCount(int i2) {
        this.count = i2;
    }
}
