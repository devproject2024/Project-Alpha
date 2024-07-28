package com.alipay.mobile.nebulacore.plugin;

import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.provider.H5CacheProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;

public class H5ShareDataPlugin extends H5SimplePlugin {
    public static final String TAG = "H5ShareDataPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_SHARE_DATA);
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_SHARE_DATA);
        h5EventFilter.addAction(H5Plugin.CommonEvents.REMOVE_SHARE_DATA);
    }

    public boolean handleEvent(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.GET_SHARE_DATA.equals(action)) {
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public void run() {
                    H5ShareDataPlugin.this.getSharedData(h5Event, h5BridgeContext);
                }
            });
            return true;
        } else if (H5Plugin.CommonEvents.SET_SHARE_DATA.equals(action)) {
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public void run() {
                    H5ShareDataPlugin.this.setSharedData(h5Event);
                    h5BridgeContext.sendSuccess();
                }
            });
            return true;
        } else if (!H5Plugin.CommonEvents.REMOVE_SHARE_DATA.equals(action)) {
            return true;
        } else {
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public void run() {
                    H5ShareDataPlugin.this.removeShareData(h5Event);
                    h5BridgeContext.sendSuccess();
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void setSharedData(H5Event h5Event) {
        e param = h5Event.getParam();
        e jSONObject = H5Utils.getJSONObject(param, "data", (e) null);
        if (jSONObject != null && !jSONObject.isEmpty()) {
            H5CacheProvider h5CacheProvider = (H5CacheProvider) Nebula.getProviderManager().getProvider(H5CacheProvider.class.getName());
            if (h5CacheProvider == null) {
                H5Log.e(TAG, " not set H5CacheProvider can not use shareData");
                return;
            }
            boolean z = H5Utils.getBoolean(param, "writeToFile", false);
            for (String next : jSONObject.keySet()) {
                String string = H5Utils.getString(jSONObject, next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                    h5CacheProvider.set(next, string, z);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void getSharedData(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        e eVar = new e();
        b jSONArray = H5Utils.getJSONArray(param, "keys", (b) null);
        H5Data data = Nebula.getService().getData();
        if (data == null) {
            H5Log.e(TAG, " not set H5CacheProvider can not use shareData");
            return;
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            int size = jSONArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = jSONArray.get(i2);
                if (obj instanceof String) {
                    String str = (String) obj;
                    eVar.put(str, (Object) data.get(str));
                }
            }
        }
        e eVar2 = new e();
        eVar2.put("data", (Object) eVar);
        h5BridgeContext.sendBridgeResult(eVar2);
    }

    /* access modifiers changed from: private */
    public void removeShareData(H5Event h5Event) {
        b jSONArray = H5Utils.getJSONArray(h5Event.getParam(), "keys", (b) null);
        H5Data data = Nebula.getService().getData();
        if (data == null) {
            H5Log.e(TAG, " not set H5CacheProvider can not use shareDate");
        } else if (jSONArray != null && !jSONArray.isEmpty()) {
            int size = jSONArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = jSONArray.get(i2);
                if (obj instanceof String) {
                    data.remove((String) obj);
                }
            }
        }
    }
}
