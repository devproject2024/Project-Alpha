package com.alipay.mobile.nebula.appcenter.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AppRes extends BaseRes implements Serializable {
    public Map<String, Object> config;
    public List<AppInfo> data;
    public List<String> removeAppIdList;
    public String rpcFailDes;
}
