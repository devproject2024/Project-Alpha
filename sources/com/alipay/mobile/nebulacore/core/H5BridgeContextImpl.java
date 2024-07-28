package com.alipay.mobile.nebulacore.core;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.basebridge.H5BaseBridgeContext;
import com.alipay.mobile.nebula.util.H5Log;

public class H5BridgeContextImpl extends H5BaseBridgeContext {
    public static final String FORBIDDEN = "forbidden!";
    public static final String INVALID_PARAM = "invalid parameter!";
    public static final String NONE_ERROR = "none error!";
    public static final String NOT_FOUND = "not implemented!";
    private static final String TAG = "H5BridgeContextImpl";
    public static final String UNKNOWN_ERROR = "unknown error!";
    private String action;

    public H5BridgeContextImpl(H5Bridge h5Bridge, String str, String str2) {
        this.bridge = h5Bridge;
        this.action = str2;
        if (TextUtils.isEmpty(str)) {
            this.id = H5BridgeContext.INVALID_ID;
        } else {
            this.id = str;
        }
    }

    public boolean sendBack(e eVar, boolean z) {
        if (TextUtils.isEmpty(this.id) || H5BridgeContext.INVALID_ID.equals(this.id)) {
            H5Log.w(TAG, "client id not specified " + this.action);
            return false;
        } else if (this.id.startsWith("native_")) {
            H5Log.w(TAG, "ignore native fired event " + this.action);
            return false;
        } else {
            H5Event.Builder builder = new H5Event.Builder();
            builder.id(this.id).action(this.action).keepCallback(z).param(eVar).type(H5Event.TYPE_CALL_BACK);
            H5Event build = builder.build();
            if (this.bridge != null) {
                this.bridge.sendToWeb(build);
                return true;
            }
            H5Log.e(TAG, "[FATAL ERROR] in sendBack() bridge is null");
            return false;
        }
    }
}
