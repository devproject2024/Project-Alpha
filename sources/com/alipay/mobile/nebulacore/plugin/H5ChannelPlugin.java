package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;

public class H5ChannelPlugin extends H5SimplePlugin {
    private static final String POST_MESSAGE = "postMessage";
    private static final String TAG = "H5ChannelPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(POST_MESSAGE);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5Session session;
        if (!TextUtils.equals(h5Event.getAction(), POST_MESSAGE)) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        e param = h5Event.getParam();
        H5Page h5Page = (H5Page) h5Event.getTarget();
        if (h5Page == null || (session = h5Page.getSession()) == null) {
            return true;
        }
        String serviceWorkerID = session.getServiceWorkerID();
        if (TextUtils.isEmpty(serviceWorkerID)) {
            return true;
        }
        H5Log.d(TAG, "postMessage workId ".concat(String.valueOf(serviceWorkerID)));
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        if (h5Service == null) {
            return true;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("appId", serviceWorkerID);
            e eVar = new e();
            eVar.put("pageId", (Object) Integer.valueOf(h5Page.getPageId()));
            eVar.put("viewId", (Object) Integer.valueOf(h5Page.getWebViewId()));
            eVar.put("data", (Object) param);
            hashMap.put("message", eVar.toJSONString());
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            hashMap.put("messageId", sb.toString());
            h5Service.sendServiceWorkerPushMessage(hashMap);
            return true;
        } catch (Throwable th) {
            H5Log.e(TAG, "catch exception ", th);
            return true;
        }
    }
}
