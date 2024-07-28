package com.paytmmall.artifact.common.entity;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRRelatedCategory extends CJRItem {
    private static final long serialVersionUID = 1;
    private String listId = "";
    @b(a = "label")
    private String mLabel;
    @b(a = "url")
    public String mUrl;
    public String mUrlType;

    public String getBrand() {
        return null;
    }

    public String getCategoryId() {
        return null;
    }

    public String getItemID() {
        return null;
    }

    public String getListName() {
        return null;
    }

    public int getListPosition() {
        return -1;
    }

    public String getName() {
        return null;
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

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getListId() {
        return this.listId;
    }

    public String getURL() {
        return this.mUrl;
    }

    public String getURLType() {
        return this.mUrlType;
    }

    public void setUrlType(String str) {
        this.mUrlType = str;
    }
}
