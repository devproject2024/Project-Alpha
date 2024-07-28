package com.alipay.mobile.nebula.permission;

import java.util.ArrayList;
import java.util.List;

public class H5PermissionInfo {
    private String level = "";
    private List<String> whiteList = new ArrayList();

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public List<String> getWhiteList() {
        return this.whiteList;
    }

    public void setWhiteList(List<String> list) {
        this.whiteList = list;
    }
}
