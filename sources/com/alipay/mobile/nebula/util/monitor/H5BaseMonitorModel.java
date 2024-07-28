package com.alipay.mobile.nebula.util.monitor;

import java.util.HashMap;
import java.util.Map;

public class H5BaseMonitorModel {
    private String exceptionType;
    private Map<String, String> extParams = new HashMap();
    private String seedId;

    public String getExceptionType() {
        return this.exceptionType;
    }

    public void setExceptionType(String str) {
        this.exceptionType = str;
        this.extParams.put("exceptionType", str);
    }

    public String getSeedId() {
        return this.seedId;
    }

    public void setSeedId(String str) {
        this.seedId = str;
    }

    public Map<String, String> getExtParams() {
        return this.extParams;
    }

    public void setExtParams(Map<String, String> map) {
        this.extParams = map;
    }
}
