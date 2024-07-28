package com.alipay.iap.android.webapp.sdk.provider;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.d;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IAPLogProvider implements H5LogProvider {
    public static final String EXT_PARAM_DIVIDER = "\\^";
    public static final String TAG = "IAPLogProvider";
    private Map<String, String> contextParam = new HashMap();
    private Map<String, String> mPageIdMap = new HashMap();
    private boolean mPageStarted = false;

    public boolean disableHardwareAccelerate() {
        return false;
    }

    public String getAutoSpmRpcId(Object obj) {
        return null;
    }

    public String getLastClickSpmId() {
        return null;
    }

    public String getSpmRpcId(Object obj) {
        return null;
    }

    public String getSrcSpm(Object obj) {
        return null;
    }

    public Map<String, String> getTracerInfo(Object obj) {
        return null;
    }

    public String getUniteParam4(H5Page h5Page) {
        return null;
    }

    public void log(String str, String str2, String str3, String str4, String str5) {
    }

    public void log(String str, String str2, String str3, String str4, String str5, String str6) {
    }

    public void logV2(String str, String str2, String str3, String str4, String str5, String str6) {
    }

    public void logV2(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }

    public void setLastClickSpm(String str) {
    }

    public void upload() {
    }

    public void putContextParam(String str, String str2) {
        this.contextParam.put(str, str2);
    }

    public String getContextParam(String str) {
        return this.contextParam.get(str);
    }

    public void exceptionLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        splitParamString(str6, EXT_PARAM_DIVIDER);
        d.g();
    }

    public void performanceLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        splitParamString(str6, EXT_PARAM_DIVIDER).get("actionId");
        d.h();
    }

    public void h5BehaviorLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12, String str13) {
        splitParamString(str10, EXT_PARAM_DIVIDER).putAll(splitParamString(str11, EXT_PARAM_DIVIDER));
        d.b();
    }

    public void h5RemoteLogClickLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, String str11, String str12) {
        Map<String, String> splitParamString = splitParamString(str9, EXT_PARAM_DIVIDER);
        splitParamString.putAll(splitParamString(str10, EXT_PARAM_DIVIDER));
        splitParamString.put("abTestInfo", str4);
        if ("exposure".equals(str11)) {
            d.f();
        } else {
            d.e();
        }
    }

    public void mtBizReport(String str, String str2, String str3, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("subName", str2);
        map.put("failCode", str3);
        d.b();
    }

    public String getToken() {
        String valueOf = String.valueOf(UUID.randomUUID().toString() + "_" + System.currentTimeMillis());
        this.mPageIdMap.put(valueOf, valueOf);
        return valueOf;
    }

    public void autoClick(H5Event h5Event) {
        e param = h5Event.getParam();
        if (param != null) {
            if (!(h5Event.getH5page() == null || h5Event.getH5page().getSession() == null)) {
                param.put("acsId", (Object) Long.valueOf(h5Event.getH5page().getSession().getSessionTag()));
            }
            H5Utils.getString(param, H5Param.LONG_BIZ_TYPE);
            String string = H5Utils.getString(param, "spmId");
            HashMap hashMap = new HashMap();
            for (Map.Entry next : param.entrySet()) {
                hashMap.put(next.getKey(), next.getValue().toString());
            }
            if (!TextUtils.isEmpty(string)) {
                h5Event.getActivity();
                d.e();
            } else if (!TextUtils.isEmpty(H5Utils.getString(param, "seedId"))) {
                d.b();
            }
        }
    }

    public void logAutoBehavorPageStart(String str, Object obj) {
        d.c();
        this.mPageStarted = true;
    }

    public void logAutoBehavorPageStart(String str, Object obj, boolean z) {
        d.c();
        this.mPageStarted = true;
    }

    public void logAutoBehavorPageEnd(String str, String str2, Object obj, String str3, Map<String, String> map) {
        d.d();
        this.mPageStarted = false;
    }

    public String getPageId(Object obj) {
        return obj instanceof String ? this.mPageIdMap.get(obj) : "";
    }

    public Long getTrackLastClickTime() {
        return 0L;
    }

    public boolean isPageStarted(Object obj) {
        return this.mPageStarted;
    }

    private Map<String, String> splitParamString(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (String str3 : str.split(str2)) {
                int indexOf = str3.indexOf("=");
                if (indexOf > 0) {
                    hashMap.put(str3.substring(0, indexOf), str3.substring(indexOf + 1));
                }
            }
        }
        return hashMap;
    }
}
