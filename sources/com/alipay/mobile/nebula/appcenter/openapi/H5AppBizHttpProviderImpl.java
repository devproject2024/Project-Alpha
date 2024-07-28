package com.alipay.mobile.nebula.appcenter.openapi;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.openapi.H5AppHttpRequest;
import com.alipay.mobile.nebula.baseprovider.H5BaseAppBizRpcProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;

public class H5AppBizHttpProviderImpl extends H5BaseAppBizRpcProvider {
    private static final String TAG = "H5AppBizHttpProviderImpl";

    public String rpcCall(String str, AppReq appReq) {
        return rpcCall(appReq);
    }

    private String rpcCall(AppReq appReq) {
        String str = !TextUtils.isEmpty(appReq.httpReqUrl) ? appReq.httpReqUrl : H5AppOpenApiUrl.ENVIRONMENT_ONLINE;
        String appReqToParam = appReqToParam(appReq);
        String execute = new H5AppHttpRequest.Builder().url(str).body(appReqToParam).build().execute();
        H5Log.d(TAG, "reqString " + appReqToParam + " data " + execute);
        return execute;
    }

    private String appReqToParam(AppReq appReq) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(appReq.system)) {
            hashMap.put("system", appReq.system);
        }
        if (!TextUtils.isEmpty(appReq.client)) {
            hashMap.put("client", appReq.client);
        }
        if (!TextUtils.isEmpty(appReq.sdk)) {
            hashMap.put("sdk", appReq.sdk);
        }
        if (!TextUtils.isEmpty(appReq.platform)) {
            hashMap.put("platform", appReq.platform);
        }
        if (!TextUtils.isEmpty(appReq.env)) {
            hashMap.put("env", appReq.env);
        }
        if (!TextUtils.isEmpty(appReq.channel)) {
            hashMap.put("channel", appReq.channel);
        }
        if (!TextUtils.isEmpty(appReq.query)) {
            hashMap.put("query", appReq.query);
        }
        if (!TextUtils.isEmpty(appReq.bundleid)) {
            hashMap.put("bundleid", appReq.bundleid);
        }
        if (!TextUtils.isEmpty(appReq.existed)) {
            hashMap.put("existed", appReq.existed);
        }
        if (!TextUtils.isEmpty(appReq.grayRules)) {
            hashMap.put("grayRules", appReq.grayRules);
        }
        if (!TextUtils.isEmpty(appReq.stableRpc)) {
            hashMap.put("stableRpc", appReq.stableRpc);
        } else {
            hashMap.put("stableRpc", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (!hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append(AppConstants.AND_SIGN);
            }
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}
