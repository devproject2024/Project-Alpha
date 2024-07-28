package com.alipay.mobile.nebula.provider;

import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Page;
import java.util.Map;

public interface H5LogProvider {
    void autoClick(H5Event h5Event);

    boolean disableHardwareAccelerate();

    void exceptionLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    String getAutoSpmRpcId(Object obj);

    String getContextParam(String str);

    String getLastClickSpmId();

    String getPageId(Object obj);

    String getSpmRpcId(Object obj);

    String getSrcSpm(Object obj);

    String getToken();

    Map<String, String> getTracerInfo(Object obj);

    Long getTrackLastClickTime();

    String getUniteParam4(H5Page h5Page);

    void h5BehaviorLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12, String str13);

    void h5RemoteLogClickLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, String str11, String str12);

    boolean isPageStarted(Object obj);

    void log(String str, String str2, String str3, String str4, String str5);

    void log(String str, String str2, String str3, String str4, String str5, String str6);

    void logAutoBehavorPageEnd(String str, String str2, Object obj, String str3, Map<String, String> map);

    void logAutoBehavorPageStart(String str, Object obj);

    void logAutoBehavorPageStart(String str, Object obj, boolean z);

    void logV2(String str, String str2, String str3, String str4, String str5, String str6);

    void logV2(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void mtBizReport(String str, String str2, String str3, Map<String, String> map);

    void performanceLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void putContextParam(String str, String str2);

    void setLastClickSpm(String str);

    void upload();
}
