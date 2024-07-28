package com.alipay.mobile.nebula.provider;

import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;

public interface H5PreRpcProvider {
    void clearPreAll();

    void clearPreState(String str);

    boolean enableUsePreRpc(Bundle bundle);

    boolean getPreFlag(String str);

    e getResult(String str, H5BridgeContext h5BridgeContext);

    void handleResultPool(String str, int i2);

    void handleResultPool(String str, e eVar);

    void preRpc();

    void setStartParams(Bundle bundle);
}
