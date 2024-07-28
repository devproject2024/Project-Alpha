package com.alipay.iap.android.webapp.sdk.provider;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class BaseJSApiPermissionProvider implements H5JSApiPermissionProvider {
    private static final String H5_JSAPI_BANNED = "isBanned";
    public static final String H5_JSAPI_BAN_CONFIG = "h5_jsapi_ban_config";
    private static final String H5_JSAPI_DISABLE_HTTP = "disableHttp";
    public static final String PROTOCOL_HTTP = "http:";
    public static final String PROTOCOL_HTTPS = "https:";
    public static final String TAG = "BaseJsPermissionProvider";

    public abstract Map<String, List<String>> getJSApiPermissionConfig();

    public boolean hasDomainPermission(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            c.e();
            return false;
        } else if (!Nebula.DEBUG && !str2.startsWith(PROTOCOL_HTTP) && !str2.startsWith(PROTOCOL_HTTPS)) {
            c.e();
            return false;
        } else if (!isBannedJSAPI(str, str2)) {
            return true;
        } else {
            c.e();
            return false;
        }
    }

    public final boolean isBannedJSAPI(String str, String str2) {
        if (!Nebula.DEBUG && !str2.startsWith(PROTOCOL_HTTP) && !str2.startsWith(PROTOCOL_HTTPS)) {
            return true;
        }
        String purifyUrl = H5UrlHelper.purifyUrl(str2);
        Map<String, List<String>> jSApiPermissionConfig = getJSApiPermissionConfig();
        boolean z = jSApiPermissionConfig != null && jSApiPermissionConfig.containsKey(str);
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            e configJSONObject = h5ConfigProvider.getConfigJSONObject(H5_JSAPI_BAN_CONFIG);
            if (configJSONObject != null && configJSONObject.containsKey(str)) {
                return checkJSAPIBanned(configJSONObject.getJSONObject(str), purifyUrl, z ? jSApiPermissionConfig.get(str) : Collections.EMPTY_LIST);
            } else if (!z || inWhitelist(purifyUrl, jSApiPermissionConfig.get(str))) {
                return false;
            } else {
                return true;
            }
        } else if (!z || inWhitelist(purifyUrl, jSApiPermissionConfig.get(str))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean inWhitelist(String str, List<String> list) {
        if (list == null || list.isEmpty() || list.contains(str)) {
            return true;
        }
        boolean z = false;
        for (String next : list) {
            if (z || !KitUtils.isDomainMatch(next, str)) {
                if (!KitUtils.isDomainMatch(H5UrlHelper.getHost(next), str)) {
                    continue;
                } else if (!TextUtils.isEmpty(H5UrlHelper.getPath(next))) {
                    return false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean checkJSAPIBanned(e eVar, String str, List<String> list) {
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(eVar.getString(H5_JSAPI_BANNED))) {
            return true;
        }
        return (list == null || list.isEmpty()) ? H5AppHandler.CHECK_VALUE.equalsIgnoreCase(eVar.getString(H5_JSAPI_DISABLE_HTTP)) && !str.startsWith(PROTOCOL_HTTPS) : !inWhitelist(str, list);
    }
}
