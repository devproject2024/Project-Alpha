package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRQueryListTab implements IJRDataModel {
    @b(a = "display_label")
    private String displayLabel;
    @b(a = "searchKey")
    private String searchKey;
    @b(a = "searchUrl")
    private String searchUrl;

    public String getSearchKey() {
        return this.searchKey;
    }

    public void setSearchKey(String str) {
        this.searchKey = str;
    }

    public String getDisplayLabel() {
        return this.displayLabel;
    }

    public void setDisplayLabel(String str) {
        this.displayLabel = str;
    }

    public String getSearchUrl() {
        return this.searchUrl;
    }

    public void setSearchUrl(String str) {
        this.searchUrl = str;
    }
}
