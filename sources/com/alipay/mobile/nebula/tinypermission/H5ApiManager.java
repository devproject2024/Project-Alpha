package com.alipay.mobile.nebula.tinypermission;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;

public interface H5ApiManager {
    public static final String EVENT_List = "EVENT_List";
    public static final String Enable_Proxy = "Enable_Proxy";
    public static final String HttpLink_SubResMimeList = "HttpLink_SubResMimeList";
    public static final String JSAPI_List = "JSAPI_List";
    public static final String JSAPI_SP_Config = "JSAPI_SP_Config";
    public static final String Valid_SubResMimeList = "Valid_SubResMimeList";
    public static final String allowedDomain = "allowedDomain";
    public static final String api_permission = "api_permission";
    public static final String httpRequest = "httpRequest";
    public static final String validDomain = "validDomain";

    void clear(String str);

    boolean hasPermission(String str, String str2, String str3);

    boolean hasPermissionFile(String str);

    void put(String str, byte[] bArr);

    void putJson(String str, e eVar);

    boolean setPermission(H5Event h5Event, String str, H5BridgeContext h5BridgeContext, boolean z);
}
