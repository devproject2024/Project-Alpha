package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5ScriptLoader;

public class H5BridgePlugin extends H5SimplePlugin {
    public static final String TAG = "H5BridgePlugin";
    private H5PageImpl h5Page;
    private H5ScriptLoader scriptLoader = this.h5Page.getScriptLoader();

    public H5BridgePlugin(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
    }

    public void onRelease() {
        this.scriptLoader = null;
        this.h5Page = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED_SYNC);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED_SYNC);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_JS_PARAM);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        String string = H5Utils.getString(h5Event.getParam(), "url");
        boolean z = !TextUtils.isEmpty(string) && (string.startsWith("file://") || string.startsWith("http://") || string.startsWith("https://"));
        if (!z) {
            H5Log.w(TAG, "skip load js for abnormal url: ".concat(String.valueOf(string)));
        }
        if (H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE.equals(action)) {
            if (z) {
                this.scriptLoader.loadScript();
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED_SYNC.equals(action)) {
            if (z) {
                this.scriptLoader.loadScript();
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_STARTED_SYNC.equals(action)) {
            this.scriptLoader.resetBridge();
        }
        return false;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.InternalEvents.H5_PAGE_JS_PARAM.equals(h5Event.getAction())) {
            return false;
        }
        e param = h5Event.getParam();
        for (String next : param.keySet()) {
            String string = H5Utils.getString(param, next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                this.scriptLoader.setParamsToWebPage(next, string);
            }
        }
        return true;
    }
}
