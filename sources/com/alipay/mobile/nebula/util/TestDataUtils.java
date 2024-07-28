package com.alipay.mobile.nebula.util;

import com.alibaba.a.e;
import com.alipay.mobile.nebula.webview.APWebView;

public class TestDataUtils {
    private static final String TAG = "H5TestDataUtils";
    private static e bridgeParams = new e();

    public static void storeJSParams(String str, Object obj) {
        e eVar = bridgeParams;
        if (eVar != null && !eVar.containsKey(str)) {
            H5Log.d(TAG, "store key ".concat(String.valueOf(str)));
            String[] split = str.split("\\|");
            if (split.length < 2) {
                bridgeParams.put(str, obj);
            } else if (bridgeParams.containsKey(split[0])) {
                e jSONObject = bridgeParams.getJSONObject(split[0]);
                if (jSONObject != null) {
                    jSONObject.put(split[1], obj);
                }
            } else {
                e eVar2 = new e();
                eVar2.put(split[1], obj);
                bridgeParams.put(split[0], (Object) eVar2);
            }
        }
    }

    public static synchronized void injectJSParams(APWebView aPWebView) {
        synchronized (TestDataUtils.class) {
            if (bridgeParams != null && !bridgeParams.isEmpty()) {
                H5Log.d(TAG, "will be inject into AlipayJSBridge.devPerformance");
                aPWebView.loadUrl("javascript:(function(){if(typeof AlipayJSBridge === 'object'){AlipayJSBridge.devPerformance4Test='" + bridgeParams.toJSONString() + "';}})();");
                bridgeParams.clear();
            }
        }
    }
}
