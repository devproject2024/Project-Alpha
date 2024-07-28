package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Iterator;

public class CJRFrontEndFilterItem extends CJRFilterValue {
    private static final long serialVersionUID = 1;
    @b(a = "cats")
    private ArrayList<CJRFrontEndFilterItem> mFrontEndFilterItemList = new ArrayList<>();
    private CJRFrontEndFilterItem mParentFrontEndFilterItem;
    @b(a = "parent_id")
    private String mParentId = null;

    public void setParentFrontEndFilterItem(CJRFrontEndFilterItem cJRFrontEndFilterItem) {
        this.mParentFrontEndFilterItem = cJRFrontEndFilterItem;
    }

    public CJRFrontEndFilterItem getParentFrontEndFilterItem() {
        return this.mParentFrontEndFilterItem;
    }

    public ArrayList<CJRFrontEndFilterItem> getFrontEndFilterItemList() {
        return this.mFrontEndFilterItemList;
    }

    public CJRFrontEndFilterItem getFrontEndFilterItemById(String str) {
        ArrayList<CJRFrontEndFilterItem> arrayList = this.mFrontEndFilterItemList;
        if (arrayList == null) {
            return null;
        }
        Iterator<CJRFrontEndFilterItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRFrontEndFilterItem next = it2.next();
            if (next.getID().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public CJRFrontEndFilterItem searchFrontEndFilterItemById(CJRFrontEndFilterItem cJRFrontEndFilterItem, String str, String str2, CJRFrontEndFilterItem cJRFrontEndFilterItem2) {
        if (cJRFrontEndFilterItem2 == null) {
            CJRFrontEndFilterItem frontEndFilterItemByName = cJRFrontEndFilterItem.getFrontEndFilterItemByName(str, str2);
            if (frontEndFilterItemByName != null) {
                return frontEndFilterItemByName;
            }
            if (cJRFrontEndFilterItem.getFrontEndFilterItemList() != null) {
                Iterator<CJRFrontEndFilterItem> it2 = cJRFrontEndFilterItem.getFrontEndFilterItemList().iterator();
                while (it2.hasNext()) {
                    cJRFrontEndFilterItem2 = searchFrontEndFilterItemById(it2.next(), str, str2, cJRFrontEndFilterItem2);
                }
            }
        }
        return cJRFrontEndFilterItem2;
    }

    public CJRFrontEndFilterItem getFrontEndFilterItemByName(String str, String str2) {
        ArrayList<CJRFrontEndFilterItem> arrayList = this.mFrontEndFilterItemList;
        if (arrayList == null) {
            return null;
        }
        Iterator<CJRFrontEndFilterItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRFrontEndFilterItem next = it2.next();
            if (next.getID().equalsIgnoreCase(str) && next.getName().equalsIgnoreCase(str2)) {
                return next;
            }
        }
        return null;
    }

    public String getParentId() {
        return this.mParentId;
    }
}
