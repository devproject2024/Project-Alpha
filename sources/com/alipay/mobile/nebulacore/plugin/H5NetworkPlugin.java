package com.alipay.mobile.nebulacore.plugin;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class H5NetworkPlugin extends H5SimplePlugin {
    public static final String TAG = "H5NetworkPlugin";

    private static String getNetworkType() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) H5Environment.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            H5Log.e(TAG, "Exception", th);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL;
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 9) ? "wifi" : "wwan";
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_NETWORK_TYPE);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.CommonEvents.GET_NETWORK_TYPE.equals(h5Event.getAction())) {
            return true;
        }
        getNetworkType(h5BridgeContext);
        return true;
    }

    private void getNetworkType(H5BridgeContext h5BridgeContext) {
        String networkType = getNetworkType();
        String concat = "network_type:".concat(String.valueOf(networkType));
        e eVar = new e();
        eVar.put("err_msg", (Object) concat);
        eVar.put("networkType", (Object) networkType);
        eVar.put("networkInfo", (Object) H5Utils.getNetworkType(H5Environment.getContext()));
        eVar.put("networkAvailable", (Object) Boolean.valueOf(!SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL.equals(networkType)));
        h5BridgeContext.sendBridgeResult(eVar);
    }
}
