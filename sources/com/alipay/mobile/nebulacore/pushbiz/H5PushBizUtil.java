package com.alipay.mobile.nebulacore.pushbiz;

import com.alipay.mobile.h5container.api.H5BridgeContext;

public class H5PushBizUtil {
    private static H5BridgeContext h5BridgeContext;

    public static void setH5BridgeContext(H5BridgeContext h5BridgeContext2) {
        h5BridgeContext = h5BridgeContext2;
    }

    public static H5BridgeContext getH5BridgeContext() {
        return h5BridgeContext;
    }
}
