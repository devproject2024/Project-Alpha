package com.alipay.mobile.nebulacore.pushbiz;

import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.plugin.H5PushBizWindowReceiver;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class H5PushBizPlugin extends H5SimplePlugin {
    private static final String TAG = "H5PushBizPlugin";
    public static final String pushBizAppId = "20001111";
    public static String pushBizWindowAction = "IAPAppContainer_bizWindowCompleted";
    private String pushBizWindow = "pushBizWindow";
    private String pushBizWindowConfig = "h5_bizWindowUrlConfig";

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(this.pushBizWindow);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e parseObject;
        H5Page h5Page;
        String str;
        if (!this.pushBizWindow.endsWith(h5Event.getAction())) {
            return super.handleEvent(h5Event, h5BridgeContext);
        }
        String string = H5Utils.getString(h5Event.getParam(), "type");
        if (TextUtils.isEmpty(string)) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return true;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (!(h5ConfigProvider == null || (parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig(this.pushBizWindowConfig))) == null || parseObject.isEmpty())) {
            String string2 = H5Utils.getString(parseObject, string);
            if (!TextUtils.isEmpty(string2)) {
                if (!string2.endsWith("?")) {
                    string2 = string2 + "?";
                }
                e jSONObject = H5Utils.getJSONObject(h5Event.getParam(), "data", (e) null);
                if (jSONObject != null && !jSONObject.isEmpty()) {
                    for (String next : jSONObject.keySet()) {
                        try {
                            string2 = string2 + next + "=" + jSONObject.get(next).toString() + AppConstants.AND_SIGN;
                        } catch (Exception e2) {
                            H5Log.e(TAG, (Throwable) e2);
                        }
                    }
                }
                if (h5Event.getTarget() instanceof H5Page) {
                    h5Page = (H5Page) h5Event.getTarget();
                    str = H5Utils.getString(h5Page.getParams(), "appId");
                } else {
                    str = "";
                    h5Page = null;
                }
                a a2 = a.a(H5Utils.getContext());
                IntentFilter intentFilter = new IntentFilter();
                if (!TextUtils.isEmpty(str) && h5Page != null) {
                    pushBizWindowAction = "IAPAppContainer_bizWindowCompleted_" + string + "_" + str;
                    intentFilter.addAction(pushBizWindowAction);
                    a2.a(new H5PushBizWindowReceiver(h5BridgeContext), intentFilter);
                    H5Log.d(TAG, "pushBizWindowAction is " + pushBizWindowAction);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", string2 + "appId=" + str);
                    H5PushBizUtil.setH5BridgeContext(h5BridgeContext);
                    b.a().f14954a.a((String) null, pushBizAppId, bundle);
                }
                return true;
            }
        }
        h5BridgeContext.sendError(12, "not found config");
        return true;
    }
}
