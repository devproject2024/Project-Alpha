package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;

public class CJRAncestor extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "id")
    private String mAncestorID;
    @b(a = "name")
    private String mAncestorName;
    @b(a = "url_key")
    private String mURLKey;

    public String getName() {
        return this.mAncestorName;
    }

    public String getAncestorID() {
        return this.mAncestorID;
    }

    public String getURLKey() {
        return this.mURLKey;
    }
}
