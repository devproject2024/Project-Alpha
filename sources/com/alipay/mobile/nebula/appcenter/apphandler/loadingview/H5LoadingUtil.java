package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;

public class H5LoadingUtil {
    private static H5LoadingActivity h5LoadingActivity;
    private static H5LoadingManager h5LoadingManager;
    private static H5LoadingTypeListen h5LoadingTypeListen;
    private static H5StartAppInfo h5StartAppInfo;

    public static H5LoadingTypeListen getH5LoadingTypeListen() {
        return h5LoadingTypeListen;
    }

    public static void setH5LoadingTypeListen(H5LoadingTypeListen h5LoadingTypeListen2) {
        h5LoadingTypeListen = h5LoadingTypeListen2;
    }

    public static H5StartAppInfo getH5StartAppInfo() {
        return h5StartAppInfo;
    }

    public static void setH5StartAppInfo(H5StartAppInfo h5StartAppInfo2) {
        h5StartAppInfo = h5StartAppInfo2;
    }

    public static H5LoadingManager getH5LoadingManager() {
        return h5LoadingManager;
    }

    public static void setH5LoadingManager(H5LoadingManager h5LoadingManager2) {
        h5LoadingManager = h5LoadingManager2;
    }

    public static H5LoadingActivity getH5LoadingActivity() {
        return h5LoadingActivity;
    }

    public static void setH5LoadingActivity(H5LoadingActivity h5LoadingActivity2) {
        h5LoadingActivity = h5LoadingActivity2;
    }
}
