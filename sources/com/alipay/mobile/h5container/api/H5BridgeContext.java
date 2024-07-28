package com.alipay.mobile.h5container.api;

import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Event;

public interface H5BridgeContext {
    public static final String INVALID_ID = "-1";

    String getId();

    String getInvokeType();

    boolean sendBridgeResult(e eVar);

    boolean sendBridgeResult(String str, Object obj);

    boolean sendBridgeResultWithCallbackKept(e eVar);

    boolean sendBridgeResultWithCallbackKept(String str, Object obj);

    void sendError(int i2, String str);

    boolean sendError(H5Event h5Event, H5Event.Error error);

    void sendNoRightToInvoke();

    void sendNotGrantPermission();

    void sendSuccess();

    void sendToWeb(String str, e eVar, H5CallBack h5CallBack);

    void userCancel();
}
