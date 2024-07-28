package com.alipay.mobile.h5container.api;

import com.alibaba.a.e;

public interface H5CoreNode extends H5DataProvider, H5Plugin {
    boolean addChild(H5CoreNode h5CoreNode);

    H5CoreNode getParent();

    H5PluginManager getPluginManager();

    boolean removeChild(H5CoreNode h5CoreNode);

    void sendEvent(String str, e eVar);

    void setParent(H5CoreNode h5CoreNode);
}
