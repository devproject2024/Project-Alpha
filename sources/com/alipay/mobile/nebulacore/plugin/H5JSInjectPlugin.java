package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.dev.trace.H5DevCpuTracker;
import com.alipay.mobile.nebulacore.web.H5WebView;

public class H5JSInjectPlugin extends H5SimplePlugin {
    private static final String GET_PHONESTATEINFO = "getPhoneStateInfo4Debug";
    private static final String INSERT_JS = "insertJS";
    private static final String SWICTH_WEBVIEW = "switchWebView";
    private static final String TAG = "H5JSInjectPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(INSERT_JS);
        h5EventFilter.addAction(SWICTH_WEBVIEW);
        h5EventFilter.addAction(GET_PHONESTATEINFO);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (INSERT_JS.equals(action)) {
            insertJS(h5Event);
            return true;
        } else if (SWICTH_WEBVIEW.equals(action)) {
            swicthWebView(h5Event);
            return true;
        } else if (!GET_PHONESTATEINFO.equals(action)) {
            return false;
        } else {
            getPhoneStateInfo4Debug(h5Event, h5BridgeContext);
            return true;
        }
    }

    private void insertJS(H5Event h5Event) {
        e param = h5Event.getParam();
        if (param == null) {
            H5Log.e(TAG, "param is null");
            return;
        }
        String string = param.getString("jsUrl");
        H5Log.d(TAG, "jsUrl = ".concat(String.valueOf(string)));
        if (!TextUtils.isEmpty(string)) {
            H5DevConfig.H5_LOAD_JS = string;
            H5Page h5Page = (H5Page) h5Event.getTarget();
            if (h5Page != null && (h5Page instanceof H5PageImpl)) {
                ((H5PageImpl) h5Page).getScriptLoader().loadDynamicJs4Jsapi((H5WebView) h5Page.getWebView(), string);
            }
        }
    }

    private void swicthWebView(H5Event h5Event) {
        e param = h5Event.getParam();
        if (param != null && !param.isEmpty()) {
            H5DevConfig.setBooleanConfig(H5DevConfig.H5_READ_USE_WEBVIEW_CONFIG, true);
            boolean z = H5Utils.getBoolean(param, "useUC", true);
            H5Log.d(TAG, "useUCWebView ".concat(String.valueOf(z)));
            H5DevConfig.setBooleanConfig(H5DevConfig.H5_USE_UC_WEBVIEW, z);
        }
    }

    private void getPhoneStateInfo4Debug(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        int myPid = Process.myPid();
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            e eVar = new e();
            eVar.put("success", (Object) Boolean.FALSE);
            h5BridgeContext.sendBridgeResult(eVar);
            return;
        }
        H5DevCpuTracker instance = H5DevCpuTracker.getInstance();
        instance.updateProcess();
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) activity.getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
        e eVar2 = new e();
        try {
            eVar2.put("success", (Object) Boolean.TRUE);
            eVar2.put("cpurate", (Object) Float.valueOf(instance.getProcessCpuUsagePercent()));
            e eVar3 = new e();
            eVar3.put("totalPrivateDirty", (Object) Integer.valueOf(processMemoryInfo[0].getTotalPrivateDirty()));
            eVar3.put("totalPss", (Object) Integer.valueOf(processMemoryInfo[0].getTotalPss()));
            eVar2.put("meminfo", (Object) eVar3);
            h5BridgeContext.sendBridgeResult(eVar2);
        } catch (Exception e2) {
            H5Log.e(TAG, "catch exception ", e2);
            eVar2.put("success", (Object) Boolean.FALSE);
            h5BridgeContext.sendBridgeResult(eVar2);
        }
    }
}
