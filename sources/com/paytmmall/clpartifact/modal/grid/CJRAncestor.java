package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRAncestor implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "id")
    private String mAncestorID;
    @c(a = "name")
    private String mAncestorName;
    @c(a = "url_key")
    private String mURLKey;

    public String getmAncestorName() {
        return this.mAncestorName;
    }

    public void setmAncestorName(String str) {
        this.mAncestorName = str;
    }

    public String getmAncestorID() {
        return this.mAncestorID;
    }

    public void setmAncestorID(String str) {
        this.mAncestorID = str;
    }

    public String getmURLKey() {
        return this.mURLKey;
    }

    public void setmURLKey(String str) {
        this.mURLKey = str;
    }
}
