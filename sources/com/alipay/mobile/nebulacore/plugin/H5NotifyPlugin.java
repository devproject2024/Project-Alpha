package com.alipay.mobile.nebulacore.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class H5NotifyPlugin extends H5SimplePlugin {
    private static final String BROADCAST_NAME = "name";
    private static final String DATA = "data";
    private static final String NOTIFY_LISTENER = "addNotifyListener";
    public static final String NOTIFY_PREFIX = "IAPAppContainer_";
    private static final String POST_NOTIFY = "postNotification";
    private static final String REMOVE_NOTIFY_LISTENER = "removeNotifyListener";
    public static final String TAG = "H5NotifyPlugin";
    /* access modifiers changed from: private */
    public a mBroadcastManager = null;
    /* access modifiers changed from: private */
    public Map<String, Boolean> mBroadcastNameRemMap = null;
    private Map<String, BroadcastReceiver> mReceiverMap = null;

    public void onRelease() {
        super.onRelease();
        H5Log.d(TAG, "onRelease unregisterReceiver");
        resetParam();
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(POST_NOTIFY);
        h5EventFilter.addAction(NOTIFY_LISTENER);
        h5EventFilter.addAction(REMOVE_NOTIFY_LISTENER);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        this.mBroadcastManager = a.a(H5Environment.getContext());
        this.mBroadcastNameRemMap = new HashMap();
        this.mReceiverMap = new HashMap();
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5Log.d(TAG, "interceptEvent is " + h5Event.getAction() + ", data is " + h5Event.getParam().toJSONString());
        if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(h5Event.getAction())) {
            resetParam();
        }
        return super.interceptEvent(h5Event, h5BridgeContext);
    }

    private void resetParam() {
        this.mBroadcastNameRemMap.clear();
        H5Log.d(TAG, "H5_PAGE_STARTED unregisterReceiver");
        for (BroadcastReceiver a2 : this.mReceiverMap.values()) {
            this.mBroadcastManager.a(a2);
        }
        this.mReceiverMap.clear();
    }

    public boolean handleEvent(H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (NOTIFY_LISTENER.equals(action)) {
            e param = h5Event.getParam();
            final String string = H5Utils.getString(param, "name");
            if (TextUtils.isEmpty(string)) {
                e eVar = new e();
                eVar.put("message", (Object) "param name must not null");
                eVar.put("error", (Object) Integer.valueOf(H5Event.Error.INVALID_PARAM.ordinal()));
                h5BridgeContext.sendBridgeResult(eVar);
                H5Log.d(TAG, "broadcastname none");
                return true;
            } else if (this.mBroadcastNameRemMap.containsKey(string)) {
                e eVar2 = new e();
                eVar2.put("message", (Object) "repeat event");
                eVar2.put("error", (Object) 12);
                h5BridgeContext.sendBridgeResult(eVar2);
                H5Log.d(TAG, "repeat event");
                return true;
            } else {
                this.mBroadcastNameRemMap.put(string, Boolean.valueOf(H5Utils.getBoolean(param, "keep", true)));
                AnonymousClass1 r10 = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (intent != null && H5NotifyPlugin.this.mBroadcastNameRemMap != null && H5NotifyPlugin.this.mBroadcastNameRemMap.get(string) != null && h5BridgeContext != null && H5NotifyPlugin.this.mBroadcastManager != null && !TextUtils.isEmpty(string)) {
                            Bundle bundle = new Bundle();
                            try {
                                bundle = intent.getExtras();
                            } catch (Exception e2) {
                                H5Log.e(H5NotifyPlugin.TAG, "getExtras Exception", e2);
                            }
                            if (((Boolean) H5NotifyPlugin.this.mBroadcastNameRemMap.get(string)).booleanValue()) {
                                h5BridgeContext.sendBridgeResultWithCallbackKept(H5Utils.toJSONObject(bundle));
                                return;
                            }
                            h5BridgeContext.sendBridgeResult(H5Utils.toJSONObject(bundle));
                            H5Log.d(H5NotifyPlugin.TAG, "unregister receiver keepalive false");
                            H5NotifyPlugin.this.mBroadcastManager.a((BroadcastReceiver) this);
                            H5NotifyPlugin.this.mBroadcastNameRemMap.remove(string);
                        }
                    }
                };
                this.mBroadcastManager.a(r10, new IntentFilter(string));
                H5Log.d(TAG, "register receiver");
                this.mReceiverMap.put(string, r10);
            }
        } else if (REMOVE_NOTIFY_LISTENER.equals(action)) {
            String string2 = H5Utils.getString(h5Event.getParam(), "name");
            if (TextUtils.isEmpty(string2)) {
                e eVar3 = new e();
                eVar3.put("message", (Object) "param name must not null");
                eVar3.put("error", (Object) Integer.valueOf(H5Event.Error.INVALID_PARAM.ordinal()));
                h5BridgeContext.sendBridgeResult(eVar3);
                H5Log.d(TAG, "broadcastname none");
                return true;
            } else if (this.mReceiverMap.containsKey(string2)) {
                this.mBroadcastManager.a(this.mReceiverMap.get(string2));
                this.mBroadcastNameRemMap.remove(string2);
                h5BridgeContext.sendBridgeResult("success", "true");
            } else {
                h5BridgeContext.sendBridgeResult("success", "true");
            }
        } else if (POST_NOTIFY.equals(action)) {
            postNotify(h5Event, h5BridgeContext);
        }
        return true;
    }

    private void postNotify(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String str;
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "name", (String) null);
        e jSONObject = H5Utils.getJSONObject(param, "data", (e) null);
        if (TextUtils.isEmpty(string)) {
            e eVar = new e();
            eVar.put("error", (Object) Integer.valueOf(H5Event.Error.INVALID_PARAM.ordinal()));
            eVar.put("message", (Object) H5Environment.getResources().getString(R.string.h5_invalidparam));
            h5BridgeContext.sendBridgeResult(eVar);
            return;
        }
        Set<String> keySet = jSONObject.keySet();
        Intent intent = new Intent();
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null || (str = h5ConfigProvider.getConfig("h5_notify_prefix")) == null) {
            str = NOTIFY_PREFIX;
        }
        intent.setAction(str + string);
        for (String next : keySet) {
            intent.putExtra(next, String.valueOf(H5Utils.getValue(jSONObject, next, new Object())));
        }
        H5Log.d(TAG, "postNotify action:" + str + string + " intent data " + jSONObject);
        this.mBroadcastManager.a(intent);
        h5BridgeContext.sendBridgeResult("success", "true");
    }
}
