package com.alipay.mobile.nebulacore.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.util.PingUtil;
import java.text.DecimalFormat;
import java.util.HashMap;

public class H5NetworkAnalysisPlugin extends H5SimplePlugin {
    private static final String NETWORK_ANALYSIS = "ping";
    public static final String TAG = "H5NetworkAnalysisPlugin";
    /* access modifiers changed from: private */
    public static final HashMap<String, e> sCachedPingResults = new HashMap<>();

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(NETWORK_ANALYSIS);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!NETWORK_ANALYSIS.equals(h5Event.getAction())) {
            return false;
        }
        e param = h5Event.getParam();
        if (param != null) {
            final String string = H5Utils.getString(param, H5Param.HOST);
            final int i2 = H5Utils.getInt(param, "numOfRound", 3);
            boolean z = H5Utils.getBoolean(param, "useCached", true);
            final e eVar = new e();
            if (TextUtils.isEmpty(string) || i2 <= 0) {
                H5Log.e(TAG, "illegal arguments(host:" + string + " numOfRound:" + i2 + ")");
                h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            } else if (!z || sCachedPingResults.get(string) == null) {
                final H5BridgeContext h5BridgeContext2 = h5BridgeContext;
                H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                    public void run() {
                        PingUtil.PingResult pingResult;
                        try {
                            pingResult = PingUtil.ping(string, i2);
                        } catch (Exception e2) {
                            H5Log.e(H5NetworkAnalysisPlugin.TAG, "exception detail.", e2);
                            pingResult = null;
                        }
                        H5NetworkAnalysisPlugin.this.deliverPingResult(pingResult, eVar, h5BridgeContext2);
                        if (pingResult != null) {
                            H5NetworkAnalysisPlugin.sCachedPingResults.put(string, eVar);
                        }
                    }
                });
            } else {
                h5BridgeContext.sendBridgeResult(sCachedPingResults.get(string));
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void deliverPingResult(PingUtil.PingResult pingResult, e eVar, H5BridgeContext h5BridgeContext) {
        if (pingResult != null) {
            eVar.put("avgConsumedTimeMs", (Object) Float.valueOf(pingResult.avgConsumedTimeMs));
            float f2 = 0.0f;
            try {
                if (pingResult.loss != null && pingResult.loss.endsWith("%")) {
                    f2 = Float.parseFloat(pingResult.loss.substring(0, pingResult.loss.length() - 1)) / 100.0f;
                }
            } catch (NumberFormatException e2) {
                H5Log.e(TAG, "exception detail", e2);
            }
            eVar.put("loss", (Object) new DecimalFormat("##0.00").format((double) f2));
            if (pingResult.timePerRound != null && pingResult.timePerRound.length > 0) {
                b bVar = new b();
                for (Float add : pingResult.timePerRound) {
                    bVar.add(add);
                }
                Context context = H5Environment.getContext();
                eVar.put("timePerRound", (Object) bVar);
                eVar.put("networkType", (Object) H5Utils.getNetworkType(context));
                eVar.put("timeStamp", (Object) Long.valueOf(System.currentTimeMillis()));
            }
        } else {
            eVar.put("error", (Object) Integer.valueOf(H5Event.Error.UNKNOWN_ERROR.ordinal()));
        }
        h5BridgeContext.sendBridgeResult(eVar);
    }
}
