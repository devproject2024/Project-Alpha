package com.alipay.mobile.nebulacore.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;

public class H5StartParamPlugin extends H5SimplePlugin {
    private static final String TAG = "H5StartParamPlugin";
    private static List<String> sendEventList = null;
    private static final String setStartParam = "setStartParam";
    private H5Page h5Page;

    static {
        ArrayList arrayList = new ArrayList();
        sendEventList = arrayList;
        arrayList.add(H5Plugin.CommonEvents.HIDE_CLOSE_BUTTON);
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(setStartParam);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        Bundle h5StartParam;
        String action = h5Event.getAction();
        if (h5Event.getTarget() instanceof H5Page) {
            this.h5Page = (H5Page) h5Event.getTarget();
        }
        if (!setStartParam.equals(action)) {
            return false;
        }
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 == null || h5Page2.getParams() == null) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return true;
        }
        try {
            String string = H5Utils.getString(h5Event.getParam(), "content");
            if (!TextUtils.isEmpty(string) && this.h5Page != null) {
                for (String split : string.split(AppConstants.AND_SIGN)) {
                    String[] split2 = split.split("=");
                    if (split2.length >= 2) {
                        String str = split2[0];
                        String str2 = split2[1];
                        synchronized (this.h5Page.getParams()) {
                            H5ParamParser.remove(this.h5Page.getParams(), str);
                            this.h5Page.getParams().putString(str, str2);
                            H5Log.d(TAG, "set startParam [key] " + str + " [value] " + str2);
                            if (sendEventList.contains(str)) {
                                e eVar = new e();
                                eVar.put("value", (Object) str2);
                                this.h5Page.sendEvent(str, eVar);
                            }
                        }
                    }
                }
            }
            String string2 = H5Utils.getString(h5Event.getParam(), H5StartParamManager.launchParamsTag);
            if (!(TextUtils.isEmpty(string2) || (h5StartParam = H5StartParamManager.getInstance().getH5StartParam(H5Utils.getString(this.h5Page.getParams(), "appId"), string2)) == null || h5StartParam.isEmpty() || this.h5Page == null || this.h5Page.getParams() == null)) {
                H5Log.d(TAG, "launchParamsTag ".concat(String.valueOf(h5StartParam)));
                this.h5Page.getParams().putAll(h5StartParam);
            }
            H5ParamParser.parse(this.h5Page.getParams(), false);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        h5BridgeContext.sendSuccess();
        return true;
    }
}
