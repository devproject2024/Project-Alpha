package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import android.os.Bundle;
import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;

public interface H5LoadingManager {
    void exit();

    int getPageStatues();

    long getStartLoadingTime();

    boolean isReady();

    void open(Bundle bundle, String str, String str2, H5StartAppInfo h5StartAppInfo, int i2);

    boolean pageDestroy();

    void playExitAnimation();

    void sendToWebFail();

    void setPageStatue(int i2);
}
