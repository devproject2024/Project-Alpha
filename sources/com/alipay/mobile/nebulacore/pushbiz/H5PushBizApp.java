package com.alipay.mobile.nebulacore.pushbiz;

import android.os.Bundle;
import com.alipay.mobile.framework.app.a;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5PushBizApp extends a {
    private Bundle param;

    public String getEntryClassName() {
        return null;
    }

    public void onStop() {
    }

    public void onCreate(Bundle bundle) {
        this.param = bundle;
    }

    public void onStart() {
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        if (h5Service != null) {
            H5Bundle h5Bundle = new H5Bundle();
            h5Bundle.setParams(this.param);
            h5Service.startPage(this, h5Bundle);
        }
    }

    public void onRestart(Bundle bundle) {
        H5PushBizUtil.setH5BridgeContext((H5BridgeContext) null);
        destroy((Bundle) null);
    }

    public void onDestroy(Bundle bundle) {
        H5BridgeContext h5BridgeContext = H5PushBizUtil.getH5BridgeContext();
        if (h5BridgeContext != null) {
            h5BridgeContext.sendError(11, H5Environment.getResources().getString(R.string.h5_user_cacel_operation));
        }
    }
}
