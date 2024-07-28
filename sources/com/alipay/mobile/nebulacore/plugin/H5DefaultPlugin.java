package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.Nebula;

public class H5DefaultPlugin extends H5SimplePlugin {
    public static final String TAG = "H5DefaultPlugin";

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL.equals(action)) {
            loadUrl(h5Event);
            return true;
        } else if (H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_DATA.equals(action)) {
            loadData(h5Event);
            return true;
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT.equals(action)) {
            e param = h5Event.getParam();
            e eVar = new e();
            eVar.put("data", (Object) param);
            H5Page h5Page = (H5Page) h5Event.getTarget();
            if (TextUtils.equals("popmenu", param.getString(H5Param.POP_MENU_TYPE))) {
                h5Page.getBridge().sendToWeb("popMenuClick", eVar, (H5CallBack) null);
                return true;
            }
            h5Page.getBridge().sendToWeb("toolbarMenuClick", eVar, (H5CallBack) null);
            return true;
        } else if (!Nebula.DEBUG) {
            return true;
        } else {
            H5Log.d(TAG, "default handler handle event ".concat(String.valueOf(action)));
            return true;
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_DATA);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PROGRESS);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_LOAD_RESOURCE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_CLOSED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACKGROUND);
    }

    private void loadUrl(H5Event h5Event) {
        H5Event.Builder builder = new H5Event.Builder();
        builder.action(H5Plugin.InternalEvents.H5_PAGE_DO_LOAD_URL).param(h5Event.getParam()).target(h5Event.getTarget());
        Nebula.getDispatcher().dispatch(builder.build(), (H5BridgeContext) null);
    }

    private void loadData(H5Event h5Event) {
        H5Event.Builder builder = new H5Event.Builder();
        builder.action(H5Plugin.InternalEvents.H5_PAGE_LOAD_DATA).param(h5Event.getParam()).target(h5Event.getTarget());
        Nebula.getDispatcher().dispatch(builder.build(), (H5BridgeContext) null);
    }
}
