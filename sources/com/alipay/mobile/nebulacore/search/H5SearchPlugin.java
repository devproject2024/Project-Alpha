package com.alipay.mobile.nebulacore.search;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.search.H5InputCallback;
import com.alipay.mobile.nebula.search.H5InputListen;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;

public class H5SearchPlugin extends H5SimplePlugin {
    private static final String navSearchBar = "navSearchBar";
    private H5Page h5Page;

    public H5SearchPlugin(H5Page h5Page2) {
        this.h5Page = h5Page2;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(navSearchBar);
    }

    private H5InputCallback getH5InputCallback() {
        return (H5InputCallback) Nebula.getProviderManager().getProvider(H5InputCallback.class.getName());
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (!TextUtils.equals(action, navSearchBar)) {
            return true;
        }
        String string = H5Utils.getString(param, "actionType");
        if (TextUtils.equals(string, "show")) {
            Bundle bundle = new Bundle();
            e jSONObject = H5Utils.getJSONObject(param, H5Param.PARAM, (e) null);
            bundle.putString(H5Param.LONG_NAV_SEARCH_BAR_PLACEHOLDER, H5Utils.getString(jSONObject, "placeholder"));
            bundle.putString(H5Param.LONG_NAV_SEARCH_BAR_VALUE, H5Utils.getString(jSONObject, "value"));
            bundle.putInt(H5Param.LONG_NAV_SEARCH_BAR_MAX_LENGTH, H5Utils.getInt(jSONObject, "maxLength"));
            this.h5Page.getH5TitleBar().setTitleBarSearch(bundle);
            Nebula.getProviderManager().setProvider(H5InputListen.class.getName(), new H5SearchInputListen(this.h5Page));
            h5BridgeContext.sendSuccess();
            return true;
        } else if (TextUtils.equals(string, "hide")) {
            H5Page h5Page2 = this.h5Page;
            if (h5Page2 == null) {
                return true;
            }
            h5Page2.getH5TitleBar().switchToTitleBar();
            h5BridgeContext.sendSuccess();
            return true;
        } else if (TextUtils.equals(string, "focus")) {
            if (getH5InputCallback() == null || h5BridgeContext == null) {
                return true;
            }
            getH5InputCallback().focusInNavSearchBar();
            h5BridgeContext.sendSuccess();
            return true;
        } else if (TextUtils.equals(string, "blur")) {
            if (getH5InputCallback() == null || h5BridgeContext == null) {
                return true;
            }
            getH5InputCallback().focusOutNavSearchBar();
            h5BridgeContext.sendSuccess();
            return true;
        } else if (TextUtils.equals(string, "set")) {
            if (getH5InputCallback() == null || h5BridgeContext == null) {
                return true;
            }
            getH5InputCallback().setNavSearchBarValue(H5Utils.getString(H5Utils.getJSONObject(param, H5Param.PARAM, (e) null), "value"));
            h5BridgeContext.sendSuccess();
            return true;
        } else if (TextUtils.equals(string, "get")) {
            if (getH5InputCallback() == null || h5BridgeContext == null) {
                return true;
            }
            e eVar = new e();
            eVar.put("success", (Object) Boolean.TRUE);
            eVar.put("value", (Object) getH5InputCallback().getNavSearchBarValue());
            h5BridgeContext.sendBridgeResult(eVar);
            return true;
        } else if (TextUtils.equals(string, "enable")) {
            if (getH5InputCallback() == null || h5BridgeContext == null) {
                return true;
            }
            getH5InputCallback().enable();
            h5BridgeContext.sendSuccess();
            return true;
        } else if (!TextUtils.equals(string, "disable") || getH5InputCallback() == null || h5BridgeContext == null) {
            return true;
        } else {
            getH5InputCallback().disable();
            h5BridgeContext.sendSuccess();
            return true;
        }
    }
}
