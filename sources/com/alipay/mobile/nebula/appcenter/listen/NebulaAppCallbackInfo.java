package com.alipay.mobile.nebula.appcenter.listen;

import java.util.List;

public class NebulaAppCallbackInfo {
    private List<String> appIdList;
    private int callBackSource;

    public List<String> getAppIdList() {
        return this.appIdList;
    }

    public void setAppIdList(List<String> list) {
        this.appIdList = list;
    }

    public int getCallBackSource() {
        return this.callBackSource;
    }

    public void setCallBackSource(int i2) {
        this.callBackSource = i2;
    }
}
