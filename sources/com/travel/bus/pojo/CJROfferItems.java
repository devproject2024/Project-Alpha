package com.travel.bus.pojo;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRRelatedCategory;

public class CJROfferItems extends CJRItem {
    private static final long serialVersionUID = 1;
    @b(a = "id")
    private int mId;
    @b(a = "image_url")
    private String mImageUrl;
    @b(a = "name")
    private String mName;
    @b(a = "url")
    private String mUrl;
    @b(a = "url_type")
    private String mUrlType;

    public String getBrand() {
        return null;
    }

    public String getCategoryId() {
        return null;
    }

    public String getLabel() {
        return null;
    }

    public String getListId() {
        return "";
    }

    public String getListName() {
        return null;
    }

    public int getListPosition() {
        return 0;
    }

    public String getParentID() {
        return "";
    }

    public ArrayList<CJRRelatedCategory> getRelatedCategories() {
        return null;
    }

    public String getSearchABValue() {
        return null;
    }

    public String getSearchCategory() {
        return null;
    }

    public String getSearchResultType() {
        return null;
    }

    public String getSearchTerm() {
        return null;
    }

    public String getSearchType() {
        return null;
    }

    public String getSource() {
        return null;
    }

    public String getmContainerInstanceID() {
        return "";
    }

    public String getmImageUrl() {
        return this.mImageUrl;
    }

    public String getURLType() {
        return this.mUrlType;
    }

    public String getURL() {
        return this.mUrl;
    }

    public String getName() {
        return this.mName;
    }

    public String getItemID() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mId);
        return sb.toString();
    }
}
