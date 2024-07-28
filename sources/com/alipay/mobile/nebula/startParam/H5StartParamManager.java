package com.alipay.mobile.nebula.startParam;

import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5StartParamManager {
    public static final String appConfig = "appConfig.json";
    public static final String index = "index";
    private static H5StartParamManager instance = null;
    public static final String launchParamsTag = "launchParamsTag";
    private Map<String, String> prerenderPageInfoMap = new ConcurrentHashMap();
    private Map<String, List<H5StartParamInfo>> startParamInfoMap = new ConcurrentHashMap();

    public static synchronized H5StartParamManager getInstance() {
        H5StartParamManager h5StartParamManager;
        synchronized (H5StartParamManager.class) {
            if (instance == null) {
                instance = new H5StartParamManager();
            }
            h5StartParamManager = instance;
        }
        return h5StartParamManager;
    }

    private H5StartParamManager() {
    }

    public void put(String str, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        H5StartParamUtil.byteToInfo(str, bArr, arrayList, sb);
        if (!arrayList.isEmpty()) {
            this.startParamInfoMap.put(str, arrayList);
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            this.prerenderPageInfoMap.put(str, sb2);
        }
    }

    public void clear(String str) {
        if (this.startParamInfoMap.get(str) != null) {
            this.startParamInfoMap.remove(str);
        }
        if (this.prerenderPageInfoMap.get(str) != null) {
            this.prerenderPageInfoMap.remove(str);
        }
    }

    public Bundle getH5StartParam(String str, String str2) {
        List<H5StartParamInfo> list = this.startParamInfoMap.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (H5StartParamInfo h5StartParamInfo : list) {
            if (TextUtils.equals(h5StartParamInfo.tag, str2)) {
                return H5Utils.toBundle(h5StartParamInfo.param);
            }
        }
        return null;
    }

    public String getH5PreRenderPage(String str) {
        Map<String, String> map = this.prerenderPageInfoMap;
        return map != null ? map.get(str) : "";
    }
}
