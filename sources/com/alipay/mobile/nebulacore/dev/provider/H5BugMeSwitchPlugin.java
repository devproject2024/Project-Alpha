package com.alipay.mobile.nebulacore.dev.provider;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5BugMeRpcAuthProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.sendbird.android.constant.StringSet;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5BugMeSwitchPlugin extends H5SimplePlugin {
    private static final String ACTION_CLOSE = "close";
    private static final String EVENT_NB_DEBUG_SWITCH = "NBDebugSwitch";
    private static final String TAG = "H5BugMeSwitchPlugin";

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return false;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(EVENT_NB_DEBUG_SWITCH);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!EVENT_NB_DEBUG_SWITCH.equals(h5Event.getAction())) {
            return false;
        }
        debugSwitch(h5Event.getParam(), h5BridgeContext);
        return true;
    }

    private boolean debugSwitch(e eVar, final H5BridgeContext h5BridgeContext) {
        String string = H5Utils.getString(eVar, StringSet.token);
        String string2 = H5Utils.getString(eVar, "action");
        final boolean z = H5Utils.getBoolean(eVar, "silent", false);
        if (TextUtils.equals(string2, ACTION_CLOSE)) {
            H5DevConfig.resetBugMeSettings();
            h5BridgeContext.sendBridgeResult("success", "true");
            return true;
        } else if (TextUtils.isEmpty(string)) {
            e eVar2 = new e();
            eVar2.put("error", (Object) "1");
            eVar2.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Environment.getResources().getString(R.string.h5_bug_me_error_param));
            h5BridgeContext.sendBridgeResult(eVar2);
            return true;
        } else {
            H5BugMeRpcAuthProvider h5BugMeRpcAuthProvider = (H5BugMeRpcAuthProvider) H5Utils.getProvider(H5BugMeRpcAuthProvider.class.getName());
            if (h5BugMeRpcAuthProvider == null) {
                return true;
            }
            h5BugMeRpcAuthProvider.rpcAuth((String) null, (String) null, (String) null, string, new H5BugMeRpcAuthProvider.AuthRpcCallback() {
                public void onResponse(boolean z, boolean z2, String[] strArr) {
                    H5Log.d(H5BugMeSwitchPlugin.TAG, "pass: " + z + " isSuperUser: " + z2);
                    H5BugMeManager bugMeManager = Nebula.getService().getBugMeManager();
                    if (z) {
                        H5BridgeContext h5BridgeContext = h5BridgeContext;
                        if (h5BridgeContext != null) {
                            h5BridgeContext.sendBridgeResult("success", "true");
                        }
                        bugMeManager.setDomainWhiteList(strArr);
                        H5DevConfig.setBooleanConfig(H5DevConfig.H5_BUG_ME_SUPER_USER, z2);
                        H5DevConfig.debugSwitch(true, !z, true, true, false);
                        if (!z) {
                            bugMeManager.openSettingPanel(false);
                            return;
                        }
                        return;
                    }
                    bugMeManager.release();
                    e eVar = new e();
                    eVar.put("error", (Object) "1");
                    eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) H5Environment.getResources().getString(R.string.h5_bug_me_err_user));
                    H5BridgeContext h5BridgeContext2 = h5BridgeContext;
                    if (h5BridgeContext2 != null) {
                        h5BridgeContext2.sendBridgeResult(eVar);
                    }
                }
            });
            return true;
        }
    }
}
