package com.alipay.mobile.nebula.provider;

import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.appcenter.api.H5AppInstallListen;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import java.util.List;
import java.util.Map;

public interface H5AppProvider {
    public static final String DEBUG = "DEBUG";
    public static final String TRIAL = "TRIAL";

    void downloadApp(String str, String str2);

    void downloadApp(String str, String str2, H5DownloadCallback h5DownloadCallback);

    void downloadApp(String str, String str2, H5DownloadCallback h5DownloadCallback, String str3);

    boolean enableMultiProcess(String str, Bundle bundle);

    String getAppDesc(String str);

    void getAppFromServerWhenAppIsEmpty(String str);

    AppInfo getAppInfo(String str);

    AppInfo getAppInfo(String str, String str2);

    String getAppName(String str);

    String getAppName(String str, String str2);

    String getConfigExtra(String str);

    String getDownloadLocalPath(String str, String str2);

    Map<String, String> getExtra(String str, String str2);

    String getExtraJo(String str, String str2);

    String getH5AppCdnBaseUrl(String str, String str2);

    String getIconUrl(String str);

    String getIconUrl(String str, String str2);

    String getInstallPath(String str, String str2);

    int getLocalReport(String str, String str2);

    String getPackageNick(String str);

    String getPackageNick(String str, String str2);

    long getPackageSize(String str, String str2);

    String getScene(String str, String str2);

    String getSubUrl(String str, String str2);

    String getThirdPlatform(String str, String str2);

    String getVersion(String str);

    String getVhost(String str, String str2);

    String getWalletAppDesc(String str);

    String getWalletAppName(String str);

    String getWalletConfigNebulaVersion(String str);

    String getWalletDownloadPkgUrl(String str);

    String getWalletIconUrl(String str);

    String getWalletVersion(String str);

    e getlaunchParams(String str);

    boolean hasPackage(String str, String str2);

    void installApp(String str, String str2);

    void installApp(String str, String str2, H5AppInstallListen h5AppInstallListen);

    void installApp(String str, String str2, boolean z);

    boolean isAutoInstall(String str, String str2);

    boolean isAvailable(String str, String str2);

    boolean isH5App(String str);

    boolean isH5TinyApp(String str);

    boolean isInstalled(String str, String str2);

    boolean isNebulaApp(String str);

    boolean isOffline(String str);

    boolean isRNApp(String str);

    boolean isResourceApp(String str);

    boolean isUseAppX(String str);

    boolean isXiaoChengXu(String str);

    AppReq makeAppReq(Map<String, String> map, boolean z, AppReq appReq, List<String> list);

    void offlineFromOpenPlat(String str);

    void showOfflinePage(String str, Bundle bundle);

    void startUpdateAllApp(H5AppInstallProcess h5AppInstallProcess);

    void startUpdateApp(Map<String, String> map, H5AppInstallProcess h5AppInstallProcess);

    Map<String, String> syncAppManage();

    void updateApp(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3);

    void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq);

    void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq, boolean z4);

    void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq, boolean z4, List<String> list);

    void updateAppWithReqFinally(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq, boolean z4, Long l, List<String> list);
}
