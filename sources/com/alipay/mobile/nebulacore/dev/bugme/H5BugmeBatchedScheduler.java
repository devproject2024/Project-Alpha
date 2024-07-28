package com.alipay.mobile.nebulacore.dev.bugme;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.nebula.appcenter.openapi.H5AppHttpRequest;
import com.alipay.mobile.nebula.dev.H5BugmeLogCollector;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5LoginProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.batched.BatchedScheduler;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.dev.provider.H5DebugConsolePool;
import com.alipay.mobile.nebulacore.dev.provider.H5WalletDevDebugProvider;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.List;

public class H5BugmeBatchedScheduler extends BatchedScheduler<e> {
    private static final int DUMP_VALUE_LENGTH_LIMIT = 1024;
    private String uidCache = null;

    public H5BugmeBatchedScheduler() {
        super(H5Utils.getExecutor(H5ThreadType.RPC));
    }

    private String getUid() {
        H5LoginProvider h5LoginProvider;
        String str = H5Utils.isInTinyProcess() ? this.uidCache : "";
        if (!TextUtils.isEmpty(str) || (h5LoginProvider = (H5LoginProvider) Nebula.getProviderManager().getProvider(H5LoginProvider.class.getName())) == null) {
            return str;
        }
        String userId = h5LoginProvider.getUserId();
        this.uidCache = userId;
        return userId;
    }

    public void onSchedule(List<e> list) {
        StringBuilder sb = new StringBuilder();
        for (e next : list) {
            boolean z = H5Utils.getBoolean(next, "bugmeSwitchOpen", false);
            next.remove("bugmeSwitchOpen");
            H5EnvProvider h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName());
            if (h5EnvProvider != null) {
                next.put("did", (Object) h5EnvProvider.getmDid());
            }
            next.put("uid", (Object) getUid());
            e jSONObject = H5Utils.getJSONObject(next, "extra", (e) null);
            if (jSONObject == null) {
                jSONObject = new e();
            }
            jSONObject.put("vorlon", (Object) Boolean.valueOf(H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DOM_DEBUG, false)));
            jSONObject.put("performance", (Object) Boolean.valueOf(z));
            next.put("extra", (Object) jSONObject);
            e parseObject = H5Utils.parseObject(H5Utils.getString(next, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
            if (parseObject != null) {
                next.put(AppManagerUtil.EXTEND_PREFIX_DEFAULT, (Object) parseObject);
            }
            if (!"performance".equals(H5Utils.getString(next, "type")) && H5BugmeLogCollector.enabled()) {
                H5BugmeLogCollector.enqueueLog(clipLength(next, 1024));
            }
            if (z) {
                H5BugmeConsole console = H5DebugConsolePool.getInstance().getConsole(H5Utils.getString(next, "viewId"));
                if (console != null) {
                    console.recordLog(next);
                }
                e clipLength = clipLength(next, 5000);
                String eVar = clipLength.toString();
                H5Log.d(H5WalletDevDebugProvider.TAG, "send data:".concat(String.valueOf(clipLength)));
                sb.append(eVar);
                sb.append(StringUtility.NEW_LINE);
            }
        }
        if (sb.length() > 0) {
            new H5AppHttpRequest.Builder().url(H5DevConfig.BATCHED_SERVER).addHeader("Content-Type", "text/plain").addHeader("User-Agent", "").body(sb.toString()).build().execute();
        }
    }

    private static e clipLength(e eVar, int i2) {
        e eVar2 = new e();
        for (String next : eVar.keySet()) {
            Object obj = eVar.get(next);
            if ("extra".equals(next) || AppManagerUtil.EXTEND_PREFIX_DEFAULT.equals(next) || "img".equals(next) || !(obj instanceof String)) {
                eVar2.put(next, obj);
            } else {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    if (str.length() > i2) {
                        str = str.substring(0, i2) + AppConstants.DOTS;
                    }
                    eVar2.put(next, (Object) str);
                }
            }
        }
        return eVar2;
    }
}
