package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRCatalog extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private ArrayList<CJRCatalogItem> mCatalogItems = new ArrayList<>();
    @b(a = "search_query_url")
    private String mSearchQueryUrl;

    public String getName() {
        return null;
    }

    public ArrayList<CJRCatalogItem> getCatalogList() {
        return filterCatalogList();
    }

    public ArrayList<CJRCatalogItem> getCatalogList(int i2) {
        return filterCatalogList(i2);
    }

    private ArrayList<CJRCatalogItem> filterCatalogList() {
        ArrayList<CJRCatalogItem> arrayList = new ArrayList<>();
        Iterator<CJRCatalogItem> it2 = this.mCatalogItems.iterator();
        while (it2.hasNext()) {
            CJRCatalogItem next = it2.next();
            if ((next.getURLType() == null || !next.getURLType().equalsIgnoreCase("mobile-postpaid")) && (next.getURLType() == null || !next.getURLType().equalsIgnoreCase("datacard-postpaid"))) {
                arrayList.add(next);
            }
        }
        arrayList.trimToSize();
        this.mCatalogItems = arrayList;
        return arrayList;
    }

    private ArrayList<CJRCatalogItem> filterCatalogList(int i2) {
        ArrayList<CJRCatalogItem> arrayList = new ArrayList<>();
        while (i2 < this.mCatalogItems.size()) {
            arrayList.add(this.mCatalogItems.get(i2));
            i2++;
        }
        return arrayList;
    }

    public ArrayList<CJRCatalogItem> getAllCatalogList() {
        this.mCatalogItems.trimToSize();
        return this.mCatalogItems;
    }

    public void setAllCatalogList(ArrayList<CJRCatalogItem> arrayList) {
        this.mCatalogItems.clear();
        this.mCatalogItems = arrayList;
    }

    public String getSearchQueryUrl() {
        return this.mSearchQueryUrl;
    }

    public void setSearchQueryUrl(String str) {
        this.mSearchQueryUrl = str;
    }

    public CJRCatalogItem getHomeItem() {
        Iterator<CJRCatalogItem> it2 = this.mCatalogItems.iterator();
        CJRCatalogItem cJRCatalogItem = null;
        while (it2.hasNext()) {
            CJRCatalogItem next = it2.next();
            if (next.getName().equalsIgnoreCase("Paytm Home")) {
                cJRCatalogItem = next;
            }
        }
        return cJRCatalogItem;
    }

    public void setParentNameItems(ArrayList<String> arrayList) {
        ArrayList<CJRCatalogItem> arrayList2 = this.mCatalogItems;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = this.mCatalogItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mCatalogItems.get(i2).setParentNameItems(arrayList);
            }
        }
    }
}
