package com.alipay.mobile.h5container.api;

import com.alibaba.a.e;

public interface H5Bridge {
    void sendDataWarpToWeb(String str, e eVar, H5CallBack h5CallBack);

    void sendToNative(H5Event h5Event);

    void sendToNative(H5Event h5Event, H5BridgeContext h5BridgeContext);

    void sendToWeb(H5Event h5Event);

    @Deprecated
    void sendToWeb(String str, e eVar, H5CallBack h5CallBack);
}
