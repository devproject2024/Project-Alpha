package com.paytmmall.artifact.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public class CJRRawDataModel extends IJRPaytmDataModel {
    private Map<String, String> headers;
    protected String rawContent;

    public String getRawContent() {
        return this.rawContent;
    }

    public void setRawContent(String str) {
        this.rawContent = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }
}
