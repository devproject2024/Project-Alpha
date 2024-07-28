package com.alipay.mobile.nebulacore.plugin;

import android.content.Context;
import com.alibaba.a.e;
import com.alipay.android.phone.androidannotations.utils.PermissionUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5PermissionPlugin extends H5SimplePlugin {
    public static final String TAG = "H5PermissionPlugin";

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_CAMERA_AUTHORIZED_STATUS);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!H5Plugin.CommonEvents.GET_CAMERA_AUTHORIZED_STATUS.equals(h5Event.getAction())) {
            return true;
        }
        getCameraAuthorizedStatus(h5BridgeContext);
        return true;
    }

    private void getCameraAuthorizedStatus(H5BridgeContext h5BridgeContext) {
        Context context = H5Environment.getContext();
        e eVar = new e();
        if (PermissionUtils.hasSelfPermissions(context, "android.permission.CAMERA")) {
            H5Log.d(TAG, "get CAMERA permission PERMISSION_GRANTED!");
            eVar.put("authorizedStatus", (Object) "Authorized");
        } else {
            H5Log.d(TAG, "get CAMERA permission PERMISSION_DENIED!");
            eVar.put("authorizedStatus", (Object) "NotDetermined");
        }
        h5BridgeContext.sendBridgeResult(eVar);
    }
}
