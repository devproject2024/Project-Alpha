package com.alipay.mobile.nebulacore.biz;

import com.alibaba.a.e;
import com.alipay.mobile.a.a;
import com.alipay.mobile.a.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class H5BizUtil {
    private static HashMap<String, H5BridgeContext> mContextMap = new HashMap<>();
    private static HashMap<String, WeakReference<H5BizServiceAdvice>> mPointCutMap = new HashMap<>();
    private static HashMap<String, e> mResultMap = new HashMap<>();

    H5BizUtil() {
    }

    static boolean registerServicePointCut(String str, H5BridgeContext h5BridgeContext) {
        WeakReference weakReference = mPointCutMap.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return false;
        }
        H5BizServiceAdvice h5BizServiceAdvice = new H5BizServiceAdvice(str);
        mPointCutMap.put(str, new WeakReference(h5BizServiceAdvice));
        b.a().a(new String[]{"void com.alipay.mobile.framework.app.ui.BaseFragmentActivity.finish()", "void com.alipay.mobile.core.impl.MicroApplicationContextImpl.finishApp(String, String, Bundle)"}, h5BizServiceAdvice);
        mContextMap.put(str, h5BridgeContext);
        return true;
    }

    static void unregisterServicePointCut(String str) {
        WeakReference weakReference = mPointCutMap.get(str);
        if (weakReference != null && weakReference.get() != null) {
            b.a().a((a) weakReference.get());
        }
    }

    static boolean saveResult(String str, e eVar) {
        eVar.remove("funcName");
        mResultMap.put(str, eVar);
        return true;
    }

    static boolean popResult(String str) {
        H5BridgeContext h5BridgeContext = mContextMap.get(str);
        unregisterServicePointCut(str);
        if (h5BridgeContext != null) {
            e eVar = mResultMap.get(str);
            if (eVar == null) {
                sendErrorCode(h5BridgeContext, "6001");
            } else {
                h5BridgeContext.sendBridgeResult(eVar);
            }
        }
        mContextMap.remove(str);
        mResultMap.remove(str);
        mPointCutMap.remove(str);
        return true;
    }

    static void sendErrorCode(H5BridgeContext h5BridgeContext, String str) {
        e eVar = new e();
        eVar.put("resultStatus", (Object) str);
        h5BridgeContext.sendBridgeResult(eVar);
    }

    static boolean isStartedBizService(String str) {
        return mPointCutMap.containsKey(str);
    }
}
