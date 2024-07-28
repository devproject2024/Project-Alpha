package com.alipay.mobile.nebulaappcenter.app;

import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.db.H5GetAppInfoListen;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean;
import com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean;
import com.alipay.mobile.nebulaappcenter.dbdao.H5AppConfigDao;
import com.alipay.mobile.nebulaappcenter.dbdao.H5AppInstallDao;
import com.alipay.mobile.nebulaappcenter.dbdao.H5NebulaAppDao;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5DBUtil;
import com.alipay.mobile.nebulaappcenter.preset.H5PresetAppInfoUtil;
import java.util.List;
import java.util.Map;

public class H5NebulaDBService implements H5AppDBService {
    public static int LIMIT_CODE = 1024;
    private static H5NebulaDBService h5NebulaDBService;
    private String extraCache = null;
    private Boolean isLimitCache = null;
    private double limitRateCache;
    private double normalRateCache;
    private int poolLimitCache = 0;

    public static synchronized H5NebulaDBService getInstance() {
        H5NebulaDBService h5NebulaDBService2;
        synchronized (H5NebulaDBService.class) {
            if (h5NebulaDBService == null) {
                h5NebulaDBService = new H5NebulaDBService();
            }
            h5NebulaDBService2 = h5NebulaDBService;
        }
        return h5NebulaDBService2;
    }

    public AppInfo getAppInfo(String str, String str2) {
        return H5NebulaAppDao.getDao().getAppInfo(str, str2);
    }

    public void getAppInfoAsync(final String str, final String str2, final H5GetAppInfoListen h5GetAppInfoListen) {
        H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
            public void run() {
                H5Utils.runOnMain(new AppInfoRunnable(H5NebulaDBService.this.getAppInfo(str, str2), h5GetAppInfoListen));
            }
        });
    }

    class AppInfoRunnable implements Runnable {
        private AppInfo appInfo;
        private H5GetAppInfoListen h5GetAppInfoListen;

        AppInfoRunnable(AppInfo appInfo2, H5GetAppInfoListen h5GetAppInfoListen2) {
            this.appInfo = appInfo2;
            this.h5GetAppInfoListen = h5GetAppInfoListen2;
        }

        public void run() {
            H5GetAppInfoListen h5GetAppInfoListen2 = this.h5GetAppInfoListen;
            if (h5GetAppInfoListen2 != null) {
                h5GetAppInfoListen2.getAppInfoReady(this.appInfo);
            }
        }
    }

    public Map<String, String> getInstalledApp() {
        return H5AppInstallDao.getDao().getInstalledApp();
    }

    public Map<String, List<AppInfo>> getAllApp() {
        return H5NebulaAppDao.getDao().getAllApp();
    }

    public Map<String, String> getAllHighestAppVersion() {
        return H5NebulaAppDao.getDao().getAllHighestAppVersion();
    }

    public Map<String, String> getAllHighestLocalReportAppVersion() {
        return H5NebulaAppDao.getDao().getAllHighestLocalReportAppVersion();
    }

    public double getLimitReqRate() {
        if (this.limitRateCache <= 0.0d) {
            this.limitRateCache = H5AppConfigDao.getDao().getLimitReqRate();
        }
        return this.limitRateCache;
    }

    public void createOrUpdateLimitReqRate(double d2) {
        this.limitRateCache = d2;
        H5AppConfigDao.getDao().createOrUpdateLimitReqRate(d2);
    }

    public int getStrictReqRate() {
        return H5AppConfigDao.getDao().getStrictReqRate();
    }

    public String getLastAllUpdateTime() {
        return H5AppConfigDao.getDao().getLastAllUpdateTime();
    }

    public String getHighestAppVersion(String str) {
        AppInfo highestAppVersion = H5NebulaAppDao.getDao().getHighestAppVersion(str);
        if (highestAppVersion != null) {
            return highestAppVersion.version;
        }
        return null;
    }

    public String getMatchHighestAppVersion(String str, String str2) {
        AppInfo matchHighestAppVersion = H5NebulaAppDao.getDao().getMatchHighestAppVersion(str, str2);
        if (matchHighestAppVersion != null) {
            return matchHighestAppVersion.version;
        }
        return null;
    }

    public void updateAppLimit(String str, String str2) {
        H5NebulaAppDao.getDao().updateAppLimit(str, str2);
    }

    public void cleanAppLimit(String str, String str2) {
        H5NebulaAppDao.getDao().cleanAppLimit(str, str2);
    }

    public boolean isLimitApp(String str, String str2) {
        return H5NebulaAppDao.getDao().isLimitApp(str, str2);
    }

    public String getUpdateAppTime(String str, String str2) {
        return H5NebulaAppDao.getDao().getUpdateAppTime(str, str2);
    }

    public void saveAppInfo(AppInfo appInfo, boolean z) {
        H5NebulaAppDao.getDao().saveAppInfo(appInfo, z);
    }

    public void insertInstalledAppInfo(String str, String str2, String str3) {
        H5NebulaAppDao.getDao().insertInstalledAppInfo(str, str2, str3);
    }

    public double getNormalReqRate() {
        if (this.normalRateCache <= 0.0d) {
            this.normalRateCache = H5AppConfigDao.getDao().getNormalReqRate();
        }
        return this.normalRateCache;
    }

    public void createOrUpdateNormalReqRate(double d2) {
        this.normalRateCache = d2;
        H5AppConfigDao.getDao().createOrUpdateNormalReqRate(d2);
    }

    public void cleanFailedRequestAppList(Map<String, String> map) {
        H5AppConfigDao.getDao().cleanFailedRequestAppList(map);
    }

    public void setFailedRequestAppList(Map<String, String> map) {
        H5AppConfigDao.getDao().setFailedRequestAppList(map);
    }

    public Map<String, String> getFailedRequestAppList() {
        return H5AppConfigDao.getDao().getFailedRequestAppList();
    }

    public void createOrUpdateAppPoolLimit(int i2) {
        this.poolLimitCache = i2;
        H5AppConfigDao.getDao().createOrUpdateAppPoolLimit(i2);
    }

    public int getAppPoolLimit() {
        if (this.poolLimitCache <= 0) {
            this.poolLimitCache = H5AppConfigDao.getDao().getAppPoolLimit();
        }
        return this.poolLimitCache;
    }

    public String findInstallAppVersion(String str) {
        return H5AppInstallDao.getDao().findInstallAppVersion(str);
    }

    public void deleteAppInfo(String str, String str2) {
        H5NebulaAppDao.getDao().deleteAppInfo(str, str2);
    }

    public void clearAllTable(H5AppDBService.ClearTableCallback clearTableCallback) {
        H5DBUtil.getOnLineDBHelperInstance().clearAllTable();
        if (H5DBUtil.devDBIsUsing()) {
            H5DBUtil.getDevDBHelperInstance().clearAllTable();
        }
        if (clearTableCallback != null) {
            clearTableCallback.getCleared();
        }
    }

    public void updateUpdateTime(String str, String str2) {
        H5NebulaAppDao.getDao().updateUpdateTime(str, str2);
    }

    public void markNoDeleteAppVersion(String str, String str2) {
        H5NebulaAppDao.getDao().markNoDeleteAppVersion(str, str2);
    }

    public void unMarkNoDeleteAppVersion(String str, String str2) {
        H5NebulaAppDao.getDao().unMarkNoDeleteAppVersion(str, str2);
    }

    public void clearPresetMemory() {
        H5PresetAppInfoUtil.clearPresetMemory();
    }

    public List<H5NebulaAppBean> getCanDeleteAppPooIdList(String str) {
        return H5NebulaAppDao.getDao().getCanDeleteAppPooIdList(str);
    }

    public void setDefaultConfig() {
        H5AppConfigDao.getDao().setDefaultConfig();
    }

    public void cleanAllFailList() {
        H5AppConfigDao.getDao().cleanAllFailList();
    }

    public boolean hasSetConfig() {
        return H5AppConfigDao.getDao().hasSetConfig();
    }

    public void deleteAppInstall(String str) {
        H5AppInstallDao.getDao().deleteAppInstall(str);
    }

    public void setRpcIsLimit(boolean z) {
        this.isLimitCache = Boolean.valueOf(z);
        H5AppConfigDao.getDao().createOrUpdateStrictReqRate(z ? LIMIT_CODE : 0);
    }

    public boolean rpcIsLimit() {
        if (this.isLimitCache == null) {
            this.isLimitCache = Boolean.valueOf(H5AppConfigDao.getDao().getStrictReqRate() == LIMIT_CODE);
        }
        return this.isLimitCache.booleanValue();
    }

    public void updateCurrentAppUpdateTime(String str, String str2) {
        H5NebulaAppDao.getDao().updateUpdateTime(str, str2);
    }

    public Map<String, AppInfo> getAllHighestAppInfo() {
        return H5NebulaAppDao.getDao().getAllHighestAppInfo();
    }

    public void createOrUpdateConfig(H5AppConfigBean h5AppConfigBean) {
        this.poolLimitCache = h5AppConfigBean.getApp_pool_limit();
        this.normalRateCache = h5AppConfigBean.getNormalReqRate();
        this.extraCache = h5AppConfigBean.getExtra();
        this.limitRateCache = h5AppConfigBean.getLimitReqRate();
        H5AppConfigDao.getDao().createOrUpdateConfig(h5AppConfigBean);
    }

    public String getConfigExtra() {
        if (this.extraCache == null) {
            this.extraCache = H5AppConfigDao.getDao().getExtra();
        }
        return this.extraCache;
    }

    public void createOrUpdateExtra(String str) {
        this.extraCache = str;
        H5AppConfigDao.getDao().createOrUpdateExtra(str);
    }
}
