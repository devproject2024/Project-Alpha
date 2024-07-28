package com.paytmmall.artifact.search.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;

public class CJRSearchPageItem extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "id")
    public String mId;
    @b(a = "searchUrl")
    public String mSearchUrl;
    @b(a = "text")
    public String mText;
    @b(a = "seourl")
    public String mUrl;

    public String getName() {
        return null;
    }

    public String getText() {
        return this.mText;
    }

    public String getId() {
        return this.mId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getSearchUrl() {
        return this.mSearchUrl;
    }
}
