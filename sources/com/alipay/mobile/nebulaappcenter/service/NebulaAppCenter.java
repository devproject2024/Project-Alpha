package com.alipay.mobile.nebulaappcenter.service;

public class NebulaAppCenter {
    private static NebulaAppCenterService service;

    public static NebulaAppCenterService getService() {
        synchronized (NebulaAppCenter.class) {
            if (service == null) {
                service = new NebulaAppCenterServiceImpl();
            }
        }
        return service;
    }
}
