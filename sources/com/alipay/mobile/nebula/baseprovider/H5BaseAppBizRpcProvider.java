package com.alipay.mobile.nebula.baseprovider;

import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.appcenter.H5RpcFailResult;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AppBizRpcProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LoginProvider;
import com.alipay.mobile.nebula.provider.H5RpcProxyProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.ArrayList;

public abstract class H5BaseAppBizRpcProvider implements H5AppBizRpcProvider {
    private static String TAG = "H5AppRpc";
    private static final String bugMeRpcName = "com.alipay.hpmweb.app";
    private static final String normalRpcName = "com.alipay.wapcenter.rpc.clientService.app";

    public AppRes app(AppReq appReq) {
        String str;
        if (appReq == null) {
            AppRes appRes = new AppRes();
            appRes.rpcFailDes = H5RpcFailResult.INVALID_PARAM;
            return appRes;
        }
        H5LoginProvider h5LoginProvider = (H5LoginProvider) H5Utils.getProvider(H5LoginProvider.class.getName());
        if (h5LoginProvider == null || h5LoginProvider.isLogin()) {
            String str2 = TextUtils.equals(appReq.nbsource, "debug") ? bugMeRpcName : normalRpcName;
            if (TextUtils.isEmpty(appReq.reqmode)) {
                appReq.reqmode = "async";
            }
            long currentTimeMillis = System.currentTimeMillis();
            H5RpcProxyProvider h5RpcProxyProvider = (H5RpcProxyProvider) H5Utils.getProvider(H5RpcProxyProvider.class.getName());
            if (h5RpcProxyProvider == null || !normalRpcName.equals(str2) || !enableUse()) {
                str = rpcCall(str2, appReq);
            } else {
                if (bugMeRpcName.equals(str2)) {
                    appReq.openPlatReqMode = 3;
                }
                String str3 = TAG;
                H5Log.d(str3, " req:" + appReq.toString());
                str = h5RpcProxyProvider.getPkgJson(appReq);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            AppRes handlerPkgJson = handlerPkgJson(str);
            H5Log.d("H5NebulaAppRpcTimeCost", "RpcTime rpcCall cost " + (currentTimeMillis2 - currentTimeMillis) + " handlerJsonTime: " + (System.currentTimeMillis() - currentTimeMillis2));
            return handlerPkgJson;
        }
        H5Log.d(TAG, "!h5LoginProvider.isLogin() not handle rpc data ");
        AppRes appRes2 = new AppRes();
        appRes2.rpcFailDes = H5RpcFailResult.NOT_LOGIN;
        return appRes2;
    }

    public AppRes handlerPkgJson(String str) {
        if ("limit".equals(str)) {
            AppRes appRes = new AppRes();
            appRes.rpcFailDes = "limit";
            return appRes;
        }
        e parseObject = H5Utils.parseObject(str);
        if (parseObject == null || parseObject.isEmpty()) {
            return null;
        }
        H5Log.d(TAG, "result:".concat(String.valueOf(parseObject)));
        if (H5Utils.getInt(parseObject, "resultCode", 0) == 100) {
            AppRes appRes2 = new AppRes();
            b jSONArray = H5Utils.getJSONArray(parseObject, "data", (b) null);
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 <= jSONArray.size() - 1; i2++) {
                    AppInfo appInfo = H5AppUtil.toAppInfo((e) jSONArray.get(i2));
                    if (appInfo != null) {
                        arrayList.add(appInfo);
                    }
                }
                String str2 = TAG;
                H5Log.d(str2, "get rpc result appInfo :" + arrayList.size());
                appRes2.data = arrayList;
            }
            b jSONArray2 = H5Utils.getJSONArray(parseObject, "removeAppIdList", (b) null);
            H5Log.d(TAG, "removeAppIdList:".concat(String.valueOf(jSONArray2)));
            if (jSONArray2 != null && !jSONArray2.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 <= jSONArray2.size() - 1; i3++) {
                    if (jSONArray2.get(i3) instanceof String) {
                        arrayList2.add((String) jSONArray2.get(i3));
                    }
                }
                appRes2.removeAppIdList = arrayList2;
            }
            H5AppUtil.setConfig(parseObject, appRes2);
            return appRes2;
        }
        AppRes appRes3 = new AppRes();
        appRes3.rpcFailDes = H5RpcFailResult.RESULT_CODE_NOT_100;
        H5Log.d(TAG, "resultCode !== 100");
        return appRes3;
    }

    private boolean enableUse() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_nbmergerpc"));
    }
}
