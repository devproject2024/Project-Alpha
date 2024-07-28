package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRSortingKeys implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean isSelected;
    @c(a = "default")
    private String mDefault;
    @c(a = "name")
    private String mName;
    @c(a = "urlParams")
    private String mUrlParams;

    public String getDefault() {
        return this.mDefault;
    }

    public String getUrlParams() {
        return this.mUrlParams;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUrlParams(String str) {
        this.mUrlParams = str;
    }

    public void setDefault(String str) {
        this.mDefault = str;
    }
}
