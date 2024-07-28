package com.alipay.mobile.nebulacore.biz;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.framework.app.a;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5JSApiPermissionProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;

public class H5BizPlugin extends H5SimplePlugin {
    private static final String BIZ_SERVICE_CONFIG = "h5_bizServiceConfig";
    private static final String SAVE_BIZ_SERVICE_RESULT = "saveBizServiceResult";
    private static final String START_BIZ_SERVICE = "startBizService";
    private static final String TAG = "H5BizPlugin";
    private static int sSourceIdCounter;

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(START_BIZ_SERVICE);
        h5EventFilter.addAction(SAVE_BIZ_SERVICE_RESULT);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (START_BIZ_SERVICE.equals(h5Event.getAction())) {
            return startBizService(h5Event, h5BridgeContext);
        }
        if (SAVE_BIZ_SERVICE_RESULT.equals(h5Event.getAction())) {
            return saveBizServiceResult(h5Event, h5BridgeContext);
        }
        return super.handleEvent(h5Event, h5BridgeContext);
    }

    private boolean startBizService(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String str;
        H5Page h5Page;
        String str2;
        String string = H5Utils.getString(h5Event.getParam(), "name");
        if (TextUtils.isEmpty(string)) {
            h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
            return true;
        }
        e serviceInfo = getServiceInfo(string);
        String string2 = H5Utils.getString(serviceInfo, "appId");
        String string3 = H5Utils.getString(serviceInfo, H5PermissionManager.level);
        String str3 = "";
        if (TextUtils.isEmpty(string2)) {
            int ordinal = H5Event.Error.UNKNOWN_ERROR.ordinal();
            if (H5Environment.getResources() != null) {
                str3 = H5Environment.getResources().getString(R.string.h5_biz_cannot_find_service);
            }
            h5BridgeContext.sendError(ordinal, str3);
            return true;
        }
        H5Log.d(TAG, "startBizService: ".concat(String.valueOf(string2)));
        if (h5Event.getTarget() instanceof H5Page) {
            h5Page = (H5Page) h5Event.getTarget();
            str2 = H5Utils.getString(h5Page.getParams(), "appId");
            str = h5Page.getUrl();
        } else {
            str2 = str3;
            str = str2;
            h5Page = null;
        }
        H5JSApiPermissionProvider h5JSApiPermissionProvider = (H5JSApiPermissionProvider) H5ProviderManagerImpl.getInstance().getProvider(H5JSApiPermissionProvider.class.getName());
        if (h5JSApiPermissionProvider == null || h5JSApiPermissionProvider.hasThisPermission(string3, str)) {
            if (!TextUtils.isEmpty(str2) && h5Page != null) {
                Bundle bundle = new Bundle();
                int i2 = sSourceIdCounter + 1;
                sSourceIdCounter = i2;
                String valueOf = String.valueOf(i2);
                bundle.putString("bizParam", h5Event.getParam().getString(H5Param.PARAM));
                bundle.putString("fromAppId", str2);
                bundle.putString("fromPageUrl", str);
                bundle.putString("isAppServiceMode", "true");
                bundle.putBoolean(f.KEY_APP_CLEAR_TOP, false);
                bundle.putString("startMultApp", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
                bundle.putString("sourceId", valueOf);
                String str4 = string2 + valueOf;
                if (!H5BizUtil.registerServicePointCut(str4, h5BridgeContext)) {
                    int ordinal2 = H5Event.Error.UNKNOWN_ERROR.ordinal();
                    if (H5Environment.getResources() != null) {
                        str3 = H5Environment.getResources().getString(R.string.h5_biz_service_already_started);
                    }
                    h5BridgeContext.sendError(ordinal2, str3);
                    return true;
                }
                try {
                    b.a().f14954a.a((String) null, string2, bundle);
                } catch (Exception unused) {
                    H5BizUtil.sendErrorCode(h5BridgeContext, "6002");
                    H5BizUtil.unregisterServicePointCut(str4);
                }
            }
            return true;
        }
        int ordinal3 = H5Event.Error.UNKNOWN_ERROR.ordinal();
        if (H5Environment.getResources() != null) {
            str3 = H5Environment.getResources().getString(R.string.h5_biz_no_permission);
        }
        h5BridgeContext.sendError(ordinal3, str3);
        return true;
    }

    private boolean saveBizServiceResult(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (h5Event.getTarget() instanceof H5Page) {
            String string = H5Utils.getString(((H5Page) h5Event.getTarget()).getParams(), "appId");
            b.a();
            StringBuilder sb = new StringBuilder("getTopApplication: ");
            a aVar = null;
            sb.append(aVar.getAppId());
            sb.append(" ");
            sb.append(aVar.getParams());
            H5Log.d(TAG, sb.toString());
            String sourceId = aVar.getSourceId();
            if (string != null) {
                H5Log.d(TAG, "saveBizServiceResult: " + string + ", sourceId: " + sourceId);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(sourceId);
                String sb3 = sb2.toString();
                if (H5BizUtil.isStartedBizService(sb3)) {
                    H5BizUtil.saveResult(sb3, h5Event.getParam());
                    e eVar = new e();
                    eVar.put("success", (Object) Boolean.TRUE);
                    eVar.put("savedData", (Object) h5Event.getParam());
                    h5BridgeContext.sendBridgeResult(eVar);
                    return true;
                }
            }
        }
        h5BridgeContext.sendError(H5Event.Error.UNKNOWN_ERROR.ordinal(), H5Environment.getResources() == null ? "" : H5Environment.getResources().getString(R.string.h5_biz_cannot_save_result));
        return true;
    }

    private e getServiceInfo(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String config = h5ConfigProvider.getConfig(BIZ_SERVICE_CONFIG);
            H5Log.d(TAG, "getServiceInfo: ".concat(String.valueOf(config)));
            e parseObject = H5Utils.parseObject(config);
            if (parseObject != null && !parseObject.isEmpty()) {
                return H5Utils.getJSONObject(parseObject, str, (e) null);
            }
        }
        return null;
    }
}
