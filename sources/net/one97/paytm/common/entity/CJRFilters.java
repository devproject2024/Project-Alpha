package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Iterator;

public class CJRFilters extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "filters")
    private ArrayList<CJRFilterItem> mFilterList = new ArrayList<>();

    public String getName() {
        return null;
    }

    public ArrayList<CJRFilterItem> getFilterList() {
        return this.mFilterList;
    }

    public void setFilterList(ArrayList<CJRFilterItem> arrayList) {
        this.mFilterList = arrayList;
    }

    public CJRFilterItem getFilterItemByTitle(String str, String str2) {
        Iterator<CJRFilterItem> it2 = this.mFilterList.iterator();
        while (it2.hasNext()) {
            CJRFilterItem next = it2.next();
            if (next.getTitle().equalsIgnoreCase(str) && next.getType().equalsIgnoreCase(str2)) {
                return next;
            }
        }
        return null;
    }
}
