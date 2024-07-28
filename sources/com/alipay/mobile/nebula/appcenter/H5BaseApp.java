package com.alipay.mobile.nebula.appcenter;

import com.alipay.mobile.nebula.appcenter.api.H5AppInstallListen;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;

public interface H5BaseApp {
    void downloadApp();

    void downloadApp(H5DownloadCallback h5DownloadCallback);

    void downloadApp(H5DownloadCallback h5DownloadCallback, String str);

    String getAppVersion();

    String getDownloadLocalPath();

    String getDownloadUrl();

    String getInstalledPath();

    boolean installApp();

    boolean installApp(H5AppInstallListen h5AppInstallListen);

    boolean installApp(boolean z);

    boolean isAvailable();

    boolean isDownloading();

    boolean isInstalled();

    void setAppInfo(AppInfo appInfo);
}
