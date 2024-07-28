package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSearchPage extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "app_display_count")
    public int mDisplayCount;
    @b(a = "keywords")
    public ArrayList<CJRSearchLayout> mKeyWordsLayoutList = new ArrayList<>();
    public ArrayList<CJRSearchLayout> mProductsLayout = new ArrayList<>();
    @b(a = "s")
    public String mQueryString;
    @b(a = "products")
    private ArrayList<CJRSearchPopularProduct> mSearchPopularProductsList;
    @b(a = "search_user_id")
    private String mSearchUserId;
    private String searchCookie;

    public String getName() {
        return null;
    }

    public ArrayList<CJRSearchLayout> getKeyWordsLayoutList() {
        return this.mKeyWordsLayoutList;
    }

    public ArrayList<CJRSearchLayout> getProductsLayoutList() {
        return this.mProductsLayout;
    }

    public String getQueryString() {
        return this.mQueryString;
    }

    public int getDisplayCount() {
        return this.mDisplayCount;
    }

    public String getSearchUserId() {
        return this.mSearchUserId;
    }

    public ArrayList<CJRSearchPopularProduct> getmSearchPopularProductsList() {
        return this.mSearchPopularProductsList;
    }

    public void setmSearchPopularProductsList(ArrayList<CJRSearchPopularProduct> arrayList) {
        this.mSearchPopularProductsList = arrayList;
    }

    public String getSearchCookie() {
        return this.searchCookie;
    }

    public void setSearchCookie(String str) {
        this.searchCookie = str;
    }
}
