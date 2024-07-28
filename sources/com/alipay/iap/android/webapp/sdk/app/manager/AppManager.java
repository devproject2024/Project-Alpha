package com.alipay.iap.android.webapp.sdk.app.manager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.a;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.iap.android.webapp.sdk.kit.impl.AppContainerKitImpl;
import com.alipay.iap.android.webapp.sdk.utils.KitUtils;
import com.alipay.iap.android.webapp.sdk.utils.MapUtils;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulaappcenter.app.H5App;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5DBUtil;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppManager {
    private static final String CHECK_DB_ENABLED = "yes";
    private static final String KEY_APP_UNZIP_USE_SINGLE_THREAD = "h5_app_unzip_use_single_thread";
    private static final String KEY_CHECK_DB_ENABLED = "h5_check_db_enabled";
    private static final String KEY_CONFIG_UPDATE_FILTER = "h5_config_update_filter";
    private static final String KEY_CONFIG_UPDATE_USE_SINGLE_THREAD = "h5_config_update_use_single_thread";
    private static final int LIMIT_CONFIG_UPDATE = 20;
    private static final String OPTIMIZE_CLOSE_VALUE = "NO";
    private static final String TAG = "AppManager";
    private Map<String, SubAppConfig> mAppList;
    private List<String> mSharedPackages = Collections.emptyList();
    private Set<String> processedConfig = new HashSet();

    public void initialize(Context context) {
    }

    public void handlePackages(Map<String, SubAppConfig> map) {
        handlePackages(map, (List<String>) null);
    }

    public void handlePackages(final Map<String, SubAppConfig> map, final List<String> list) {
        if ("NO".equalsIgnoreCase(H5Environment.getConfig(KEY_CONFIG_UPDATE_USE_SINGLE_THREAD))) {
            configUpdate(map, list);
        } else {
            H5Utils.executeOrdered("handlePackages", new Runnable() {
                public void run() {
                    AppManager.this.configUpdate(map, list);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void configUpdate(Map<String, SubAppConfig> map, List<String> list) {
        c.e();
        if (map == null || map.isEmpty()) {
            c.e();
            Map<String, SubAppConfig> map2 = this.mAppList;
            if (map2 != null) {
                map2.clear();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap(map);
        long currentTimeMillis = System.currentTimeMillis();
        String reportConfigUpdateStart = reportConfigUpdateStart(hashMap);
        if (!"NO".equalsIgnoreCase(H5Environment.getConfig(KEY_CONFIG_UPDATE_FILTER))) {
            if (isProcessed(reportConfigUpdateStart, list)) {
                reportConfigUpdateEnd(currentTimeMillis);
                c.e();
                return;
            } else if (isLowerVersion(hashMap)) {
                reportConfigUpdateEnd(currentTimeMillis);
                c.e();
                return;
            }
        }
        this.mAppList = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && entry.getValue() != null) {
                this.mAppList.put(entry.getKey(), entry.getValue());
                handlePackage((String) entry.getKey(), (SubAppConfig) entry.getValue(), arrayList);
            }
        }
        installPresetPackages(arrayList);
        handleSharedPackages(list, hashMap);
        reportConfigUpdateEnd(currentTimeMillis);
    }

    private boolean isLowerVersion(Map<String, SubAppConfig> map) {
        if (this.mAppList == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            SubAppConfig subAppConfig = this.mAppList.get(next.getKey());
            if (!(subAppConfig == null || next.getValue() == null)) {
                String str = subAppConfig.version;
                String str2 = ((SubAppConfig) next.getValue()).version;
                if (KitUtils.compareVersion(str2, str) == 1) {
                    StringBuilder sb = new StringBuilder("compare config version: ");
                    sb.append((String) next.getKey());
                    sb.append(", current version: ");
                    sb.append(str);
                    sb.append(", config version: ");
                    sb.append(str2);
                    c.e();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isProcessed(String str, List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null) {
            arrayList.addAll(list);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder(str);
        for (String append : arrayList) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        boolean contains = this.processedConfig.contains(sb2);
        if (!contains) {
            this.processedConfig.add(sb2);
        }
        return contains;
    }

    private String reportConfigUpdateStart(Map<String, SubAppConfig> map) {
        String jSONString = a.toJSONString(MapUtils.sortMapByKey(map));
        "subapp configuration: ".concat(String.valueOf(jSONString));
        c.e();
        String md5 = H5SecurityUtil.getMD5(jSONString);
        H5MonitorModel appendMd5 = new H5MonitorModel().start().seedId(H5MonitorModel.SEED_ID_CONFIG_UPDATE).appendMd5(md5);
        if (map.size() < 20) {
            appendMd5.appendConfigs(jSONString);
        }
        H5Monitor.behavior(appendMd5);
        return md5;
    }

    private void reportConfigUpdateEnd(long j) {
        H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_CONFIG_UPDATE).appendCostTime(System.currentTimeMillis() - j));
    }

    public List<String> getSharedPackages() {
        return this.mSharedPackages;
    }

    public AppInfo getAppInfo(String str) {
        Map<String, SubAppConfig> map = this.mAppList;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str) || !this.mAppList.containsKey(str)) {
            return null;
        }
        return AppManagerUtil.getAppInfo(str);
    }

    private void handleSharedPackages(List<String> list, Map<String, SubAppConfig> map) {
        c.e();
        if (list == null || list.isEmpty()) {
            this.mSharedPackages.clear();
            return;
        }
        this.mSharedPackages = new ArrayList(list);
        Iterator<String> it2 = this.mSharedPackages.iterator();
        while (it2.hasNext()) {
            SubAppConfig subAppConfig = map.get(it2.next());
            if (subAppConfig == null || !subAppConfig.isResource()) {
                it2.remove();
            }
        }
        new StringBuilder("mSharedPackages: ").append(this.mSharedPackages);
        c.e();
    }

    private void handlePackage(String str, SubAppConfig subAppConfig, List<AppInfo> list) {
        "handlePackage ".concat(String.valueOf(str));
        c.e();
        AppInfo buildAppInfo = AppManagerUtil.buildAppInfo(str, subAppConfig);
        if (buildAppInfo != null) {
            AppManagerUtil.getH5AppDBService().saveAppInfo(buildAppInfo, true);
            checkDb(buildAppInfo);
            H5AppProvider h5AppProvider = (H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName());
            boolean isInstalled = h5AppProvider.isInstalled(buildAppInfo.app_id, buildAppInfo.version);
            "handlePackage isInstall = ".concat(String.valueOf(isInstalled));
            c.e();
            if (!isInstalled && !addPresetPackage(buildAppInfo, list)) {
                new StringBuilder("handlePackage shouldLoadRemote = ").append(subAppConfig.shouldLoadRemote);
                c.e();
                if (!subAppConfig.shouldLoadRemote) {
                    if (!h5AppProvider.isAvailable(buildAppInfo.app_id, buildAppInfo.version)) {
                        c.e();
                        h5AppProvider.downloadApp(buildAppInfo.app_id, buildAppInfo.version, new DownloadCallback(buildAppInfo));
                        return;
                    }
                    c.e();
                    if (needInstall(buildAppInfo.app_id, buildAppInfo.version)) {
                        h5AppProvider.installApp(buildAppInfo.app_id, buildAppInfo.version, true);
                    }
                }
            }
        }
    }

    private void checkDb(AppInfo appInfo) {
        if ("yes".equalsIgnoreCase(H5Utils.getStringConfig(KEY_CHECK_DB_ENABLED))) {
            H5Log.d(TAG, "check db enabled");
            if (((H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName())).getAppInfo(appInfo.app_id, appInfo.version) == null) {
                H5Log.d(TAG, "query saved app failed, reset database");
                H5DBUtil.checkDatabase();
                H5Log.d(TAG, "database resets, re-save app info");
                AppManagerUtil.getH5AppDBService().saveAppInfo(appInfo, true);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String getPresetAssetPathName() {
        String str = AppContainerKitImpl.getInstance().getKitConfig().presetAppsAssetsPathName;
        return str == null ? "" : str;
    }

    private boolean addPresetPackage(AppInfo appInfo, List<AppInfo> list) {
        c.e();
        try {
            String[] list2 = AppContainerKit.getInstance().getApplication().getAssets().list(getPresetAssetPathName());
            new StringBuilder("lists = ").append(list2.length);
            c.e();
            if (list2.length <= 0) {
                return false;
            }
            String presetFileName = AppManagerUtil.getPresetFileName(appInfo);
            for (int i2 = 0; i2 < list2.length; i2++) {
                StringBuilder sb = new StringBuilder("lists[");
                sb.append(i2);
                sb.append("]");
                sb.append(list2[i2]);
                c.e();
                if (list2[i2].equalsIgnoreCase(presetFileName)) {
                    new StringBuilder("addPresetPackage ").append(appInfo.app_id);
                    c.e();
                    list.add(appInfo);
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.getMessage();
            c.e();
        }
    }

    private void installPresetPackages(List<AppInfo> list) {
        c.e();
        if (list != null && !list.isEmpty()) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new InstallPresetPackageTask(list));
        }
    }

    public static class InstallPresetPackageTask implements Runnable {
        private List<AppInfo> mAppInfos = new ArrayList();

        public InstallPresetPackageTask(List<AppInfo> list) {
            this.mAppInfos.addAll(list);
        }

        public void run() {
            for (final AppInfo next : this.mAppInfos) {
                if (!"NO".equalsIgnoreCase(H5Environment.getConfig(AppManager.KEY_APP_UNZIP_USE_SINGLE_THREAD))) {
                    H5Utils.executeOrdered(next.app_id, new Runnable() {
                        public void run() {
                            if (AppManager.needInstall(next.app_id, next.version)) {
                                InstallPresetPackageTask.this.installPresetPackage(next);
                            }
                        }
                    });
                } else if (AppManager.needInstall(next.app_id, next.version)) {
                    installPresetPackage(next);
                }
            }
        }

        /* access modifiers changed from: private */
        public void installPresetPackage(final AppInfo appInfo) {
            new StringBuilder("installPresetPackage ").append(appInfo.app_id);
            c.e();
            try {
                H5App h5App = new H5App();
                h5App.setAppInfo(appInfo);
                h5App.presetApp(H5Utils.getContext().getAssets().open(AppManager.getPresetAssetPathName() + "/" + AppManagerUtil.getPresetFileName(appInfo)), new H5LoadPresetListen() {
                    public void getPresetPath(String str) {
                        "installPresetPackages s = ".concat(String.valueOf(str));
                        c.e();
                        ((H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName())).installApp(appInfo.app_id, appInfo.version, true);
                    }
                });
            } catch (Exception e2) {
                e2.getMessage();
                c.i();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean needInstall(String str, String str2) {
        AppInfo lastInstalledAppInfo = AppManagerUtil.getLastInstalledAppInfo(str);
        if (lastInstalledAppInfo == null) {
            c.e();
            return true;
        } else if (KitUtils.compareVersion(lastInstalledAppInfo.version, str2) != 1) {
            return false;
        } else {
            c.e();
            return true;
        }
    }

    private String getAppIdByUrl(String str) {
        Map<String, SubAppConfig> map = this.mAppList;
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (Map.Entry next : this.mAppList.entrySet()) {
                SubAppConfig subAppConfig = (SubAppConfig) next.getValue();
                if (subAppConfig != null && !TextUtils.isEmpty(subAppConfig.remoteURLPrefix) && str.startsWith(subAppConfig.remoteURLPrefix)) {
                    return (String) next.getKey();
                }
            }
        }
        return null;
    }

    private static void cleanAppInfo(H5Bundle h5Bundle) {
        h5Bundle.getParams().putString("appId", AppManagerUtil.getOnlineAppId(h5Bundle.getParams().getString("appId")));
        h5Bundle.getParams().remove(H5Param.INSTALL_VERSION);
    }

    private void updateSubAppConfig(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mAppList == null) {
                this.mAppList = new ConcurrentHashMap();
            }
            if (!this.mAppList.containsKey(str)) {
                this.mAppList.put(str, new SubAppConfig());
            }
        }
    }

    public void handleBundleForH5Page(H5Bundle h5Bundle) {
        c.e();
        Bundle params = h5Bundle.getParams();
        String string = params.getString("appId");
        String string2 = params.getString("url");
        if (TextUtils.isEmpty(string)) {
            c.e();
            string = getAppIdByUrl(string2);
        }
        updateSubAppConfig(string);
        Map<String, SubAppConfig> map = this.mAppList;
        if (map == null || map.isEmpty()) {
            cleanAppInfo(h5Bundle);
            c.e();
            return;
        }
        "handleBundleForH5Page appId = ".concat(String.valueOf(string));
        c.e();
        if (TextUtils.isEmpty(string) || !this.mAppList.containsKey(string)) {
            c.e();
            cleanAppInfo(h5Bundle);
            return;
        }
        SubAppConfig subAppConfig = this.mAppList.get(string);
        if (subAppConfig == null) {
            c.e();
            cleanAppInfo(h5Bundle);
            return;
        }
        params.putString("appId", string);
        String string3 = params.getString(H5Param.INSTALL_VERSION, subAppConfig.version);
        "handleBundleForH5Page version = ".concat(String.valueOf(string3));
        c.e();
        H5AppProvider h5AppProvider = (H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName());
        AppInfo appInfo = h5AppProvider.getAppInfo(string, string3);
        if (appInfo == null) {
            c.e();
            cleanAppInfo(h5Bundle);
        } else if (!handleShouldLoadRemote(h5Bundle, appInfo)) {
            boolean isInstalled = h5AppProvider.isInstalled(string, string3);
            "handleBundleForH5Page isInstall = ".concat(String.valueOf(isInstalled));
            c.e();
            if (isInstalled) {
                params.putString(H5Param.INSTALL_VERSION, string3);
            } else {
                handleUpdatePolicy(h5Bundle, appInfo, string2);
            }
        }
    }

    private boolean handleShouldLoadRemote(H5Bundle h5Bundle, AppInfo appInfo) {
        c.e();
        if (h5Bundle.getParams() == null || appInfo.extend_info == null) {
            c.e();
            return false;
        }
        String shouldLoadRemote = AppManagerUtil.getShouldLoadRemote(appInfo);
        "handleShouldLoadRemote shouldLoadRemote = ".concat(String.valueOf(shouldLoadRemote));
        c.e();
        if (!"true".equalsIgnoreCase(shouldLoadRemote)) {
            return false;
        }
        cleanAppInfo(h5Bundle);
        return true;
    }

    private void handleUpdatePolicy(H5Bundle h5Bundle, AppInfo appInfo, String str) {
        c.e();
        if (h5Bundle.getParams() == null || appInfo.extend_info == null) {
            c.e();
            return;
        }
        String updatePolicy = AppManagerUtil.getUpdatePolicy(appInfo);
        "handleUpdatePolicy updatePolicy = ".concat(String.valueOf(updatePolicy));
        c.e();
        if (SubAppConfig.UpdatePolicy.LOAD_REMOTE.equalsIgnoreCase(updatePolicy)) {
            c.e();
            cleanAppInfo(h5Bundle);
        } else if (SubAppConfig.UpdatePolicy.LOAD_PREVIOUS.equalsIgnoreCase(updatePolicy)) {
            AppInfo lastInstalledAppInfo = AppManagerUtil.getLastInstalledAppInfo(appInfo.app_id);
            if (lastInstalledAppInfo == null) {
                c.e();
                cleanAppInfo(h5Bundle);
            } else if (handleShouldLoadRemote(h5Bundle, lastInstalledAppInfo)) {
                c.e();
            } else {
                new StringBuilder("handleUpdatePolicy add appInfo.version = ").append(lastInstalledAppInfo.version);
                c.e();
                h5Bundle.getParams().putString(H5Param.INSTALL_VERSION, lastInstalledAppInfo.version);
            }
        }
    }

    static class DownloadCallback implements H5DownloadCallback {
        private AppInfo mAppInfo;

        public void onPrepare(H5DownloadRequest h5DownloadRequest) {
        }

        public void onProgress(H5DownloadRequest h5DownloadRequest, int i2) {
        }

        public DownloadCallback(AppInfo appInfo) {
            this.mAppInfo = appInfo;
        }

        public void onCancel(H5DownloadRequest h5DownloadRequest) {
            c.e();
        }

        public void onFinish(H5DownloadRequest h5DownloadRequest, String str) {
            "onFinish: savePath = ".concat(String.valueOf(str));
            c.e();
            if ("NO".equalsIgnoreCase(H5Environment.getConfig(AppManager.KEY_APP_UNZIP_USE_SINGLE_THREAD))) {
                installApp();
            } else {
                H5Utils.executeOrdered(this.mAppInfo.app_id, new Runnable() {
                    public void run() {
                        DownloadCallback.this.installApp();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void installApp() {
            H5AppProvider h5AppProvider = (H5AppProvider) KitUtils.getH5Provider(H5AppProvider.class.getName());
            if (!h5AppProvider.isInstalled(this.mAppInfo.app_id, this.mAppInfo.version) && h5AppProvider.isAvailable(this.mAppInfo.app_id, this.mAppInfo.version) && AppManager.needInstall(this.mAppInfo.app_id, this.mAppInfo.version)) {
                h5AppProvider.installApp(this.mAppInfo.app_id, this.mAppInfo.version, true);
            }
        }

        public void onFailed(H5DownloadRequest h5DownloadRequest, int i2, String str) {
            StringBuilder sb = new StringBuilder("onFailed: errorCode = ");
            sb.append(i2);
            sb.append(", errorMsg = ");
            sb.append(str);
            c.e();
        }
    }

    public String getOnlineAppId(String str) {
        return AppManagerUtil.getOnlineAppId(str);
    }
}
