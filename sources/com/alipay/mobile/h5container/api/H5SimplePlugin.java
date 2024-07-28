package com.alipay.mobile.h5container.api;

public class H5SimplePlugin implements H5Plugin {
    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return false;
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return false;
    }

    public void onInitialize(H5CoreNode h5CoreNode) {
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
    }

    public void onRelease() {
    }
}
