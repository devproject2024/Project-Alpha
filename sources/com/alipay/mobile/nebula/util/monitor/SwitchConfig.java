package com.alipay.mobile.nebula.util.monitor;

import java.io.Serializable;

public class SwitchConfig implements Serializable {
    private boolean jSApiSwitchEnable = false;
    private boolean mainSwitchEnable = false;

    public boolean isMainSwitchEnable() {
        return this.mainSwitchEnable;
    }

    public void setMainSwitchEnable(boolean z) {
        this.mainSwitchEnable = z;
    }

    public boolean isjSApiSwitchEnable() {
        return this.jSApiSwitchEnable;
    }

    public void setjSApiSwitchEnable(boolean z) {
        this.jSApiSwitchEnable = z;
    }
}
