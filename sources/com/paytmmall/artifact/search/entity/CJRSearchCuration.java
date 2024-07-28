package com.paytmmall.artifact.search.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;

public class CJRSearchCuration extends CJRDataModelItem {
    @b(a = "app_url")
    private String mAppUrl;
    @b(a = "query_type")
    private String mQueryType;
    @b(a = "result_type")
    private String mResultType;

    public String getName() {
        return null;
    }

    public String getmResultType() {
        return this.mResultType;
    }

    public void setmResultType(String str) {
        this.mResultType = str;
    }

    public String getmQueryType() {
        return this.mQueryType;
    }

    public void setmQueryType(String str) {
        this.mQueryType = str;
    }

    public String getmAppUrl() {
        return this.mAppUrl;
    }

    public void setmAppUrl(String str) {
        this.mAppUrl = str;
    }
}
