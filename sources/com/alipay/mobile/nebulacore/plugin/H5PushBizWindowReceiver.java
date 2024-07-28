package com.alipay.mobile.nebulacore.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.pushbiz.H5PushBizPlugin;
import com.alipay.mobile.nebulacore.pushbiz.H5PushBizUtil;

public class H5PushBizWindowReceiver extends BroadcastReceiver {
    private static final String TAG = "H5PushBizWindowReceiver";
    private H5BridgeContext h5BridgeContext;

    public H5PushBizWindowReceiver(H5BridgeContext h5BridgeContext2) {
        this.h5BridgeContext = h5BridgeContext2;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && H5PushBizUtil.getH5BridgeContext() != null) {
            H5Log.d(TAG, "intent " + intent.getExtras());
            if (H5PushBizPlugin.pushBizWindowAction.equals(intent.getAction())) {
                H5PushBizUtil.setH5BridgeContext((H5BridgeContext) null);
                b.a().f14954a.a((String) null, H5PushBizPlugin.pushBizAppId, (Bundle) null);
                H5BridgeContext h5BridgeContext2 = this.h5BridgeContext;
                if (h5BridgeContext2 != null) {
                    h5BridgeContext2.sendBridgeResult(H5Utils.toJSONObject(intent.getExtras()));
                }
                try {
                    a.a(H5Utils.getContext()).a((BroadcastReceiver) this);
                } catch (Exception e2) {
                    H5Log.e(TAG, (Throwable) e2);
                }
            }
        }
    }
}
