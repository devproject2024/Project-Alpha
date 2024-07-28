package com.paytmmall.clpartifact.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RedirectorModel implements Serializable {
    private Map<String, Object> dataMap;
    private int request;

    public RedirectorModel() {
        this.request = -1;
        this.dataMap = new HashMap();
    }

    public RedirectorModel(int i2, Map<String, Object> map) {
        this.request = i2;
        this.dataMap = map;
    }

    public RedirectorModel(int i2) {
        this.request = i2;
        this.dataMap = new HashMap();
    }

    public int getRequest() {
        return this.request;
    }

    public void setRequest(int i2) {
        this.request = i2;
    }

    public Map<String, Object> getDataMap() {
        return this.dataMap;
    }

    public void setDataMap(Map<String, Object> map) {
        this.dataMap = map;
    }
}
