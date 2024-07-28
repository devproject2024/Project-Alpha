package net.one97.paytm.ups.provider;

import android.app.Application;

public interface UpsJarvisInterface {
    String getAppVersion();

    Application getApplicationContext();

    String getDeviceId();

    String getSSOToken();

    String getUpsSdkURL();

    String getUserId();
}
