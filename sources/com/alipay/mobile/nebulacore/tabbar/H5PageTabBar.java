package com.alipay.mobile.nebulacore.tabbar;

import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import java.lang.ref.WeakReference;

public class H5PageTabBar extends H5BaseTabBar {
    private static final String PAGE_TAB_BAR = "tabBar";
    private boolean hasInvoke = false;

    public void setPageViewHolder(H5ViewHolder h5ViewHolder) {
        this.pageViewHolder = h5ViewHolder;
    }

    public void addTabBar() {
        if (this.pageViewHolder != null) {
            this.pageViewHolder.refreshView();
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(PAGE_TAB_BAR);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        this.context = new WeakReference(h5Event.getActivity());
        if (!PAGE_TAB_BAR.equals(action)) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        handleTabAction(h5Event.getParam(), h5BridgeContext);
        return true;
    }

    public void handleTabAction(e eVar, H5BridgeContext h5BridgeContext) {
        if (eVar != null && !eVar.isEmpty()) {
            String string = H5Utils.getString(eVar, "action");
            if ("create".equals(string)) {
                if (!this.hasInvoke) {
                    createTabBar(eVar, h5BridgeContext, (Bundle) null);
                    h5BridgeContext.sendSuccess();
                    this.hasInvoke = true;
                } else {
                    return;
                }
            }
            if ("redDot".equals(string)) {
                createTabBadge(eVar, h5BridgeContext);
            }
        }
    }
}
