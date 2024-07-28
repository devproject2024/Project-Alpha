package com.alipay.mobile.nebula.util.monitor;

import com.alipay.iap.android.common.b.d;

public class H5Monitor {
    private static final String BIZ_TYPE = "H5Container";
    public static final String KEY_MONITOR_SWITCH = "h5_container_monitor_switch";
    private static SwitchConfig switchConfig;

    static {
        SwitchConfig switchConfig2 = new SwitchConfig();
        switchConfig = switchConfig2;
        switchConfig2.setMainSwitchEnable(false);
        switchConfig.setjSApiSwitchEnable(false);
    }

    public static void setSwitchConfig(SwitchConfig switchConfig2) {
        if (switchConfig2 != null) {
            switchConfig = switchConfig2;
        }
    }

    public static void behavior(H5BaseMonitorModel h5BaseMonitorModel) {
        if (h5BaseMonitorModel != null && switchConfig.isMainSwitchEnable()) {
            h5BaseMonitorModel.getSeedId();
            h5BaseMonitorModel.getExtParams();
            d.b();
        }
    }

    public static void exception(H5BaseMonitorModel h5BaseMonitorModel) {
        if (h5BaseMonitorModel != null && switchConfig.isMainSwitchEnable()) {
            h5BaseMonitorModel.getExtParams();
            d.g();
        }
    }

    public static boolean isJSApiMonitorEnabled() {
        return switchConfig.isjSApiSwitchEnable();
    }
}
