package com.alipay.mobile.nebulaappcenter.dbdao;

import android.text.TextUtils;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoExecutor;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoTemplate;
import com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5DevDBOpenHelper;
import com.alipay.mobile.nebulaappcenter.preset.H5PresetAppInfoUtil;
import com.alipay.mobile.nebulaappcenter.service.H5MemoryCache;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H5NebulaAppDao extends H5DaoTemplate {
    private static final String TAG = "H5NebulaAppDao";
    private static H5NebulaAppDao instance = new H5NebulaAppDao();

    public static synchronized H5NebulaAppDao getDao() {
        H5NebulaAppDao h5NebulaAppDao;
        synchronized (H5NebulaAppDao.class) {
            if (instance == null) {
                instance = new H5NebulaAppDao();
            }
            h5NebulaAppDao = instance;
        }
        return h5NebulaAppDao;
    }

    private boolean enableUseCacheInTiny() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equals(h5ConfigProvider.getConfigWithProcessCache("h5_enableUseCacheInTiny"));
    }

    public AppInfo getAppInfo(final String str, final String str2) {
        AppInfo appInfoFromMemory;
        AppInfo presetAppInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!H5Utils.isDebuggable(H5Utils.getContext()) || !H5DevConfig.getBooleanConfig(H5DevConfig.H5_USE_PRESET_PKG_INFO, false) || (presetAppInfo = H5PresetAppInfoUtil.getPresetAppInfo(str)) == null || TextUtils.isEmpty(presetAppInfo.version)) {
            boolean contains = H5DevAppList.getInstance().contains(str);
            AppInfo checkVersion = checkVersion(str, str2);
            if (checkVersion != null) {
                if (!contains) {
                    H5MemoryCache.getInstance().saveAppInfoToMemory(checkVersion);
                }
                return checkVersion;
            } else if (!contains && (appInfoFromMemory = H5MemoryCache.getInstance().getAppInfoFromMemory(str, str2)) != null && (!H5Utils.isInTinyProcess() || enableUseCacheInTiny())) {
                return appInfoFromMemory;
            } else {
                if (TextUtils.isEmpty(str2) || H5AppUtil.isNativeApp(str)) {
                    return null;
                }
                AppInfo appInfo = (AppInfo) executeDB(new H5DaoExecutor<AppInfo>() {
                    public AppInfo execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                        QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInfoDao().queryBuilder();
                        queryBuilder.where().eq("app_id", str).and().eq("version", str2);
                        H5NebulaAppBean queryForFirst = queryBuilder.queryForFirst();
                        if (queryForFirst != null) {
                            return H5AppInfoUtil.beanToInfo(queryForFirst);
                        }
                        AppInfo presetAppInfo = H5PresetAppInfoUtil.getPresetAppInfo(str);
                        if (presetAppInfo != null && !TextUtils.isEmpty(presetAppInfo.version)) {
                            H5Log.d(H5NebulaAppDao.TAG, "ver " + str2 + " version:" + presetAppInfo.version + " appId" + str);
                            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                            boolean z = true;
                            if (h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_ignorePresetVer"))) {
                                if (str2.contains("*")) {
                                    int indexOf = str2.indexOf("*");
                                    if (str2.length() != 1) {
                                        z = presetAppInfo.version.startsWith(str2.substring(0, indexOf - 1));
                                    }
                                } else if (!TextUtils.equals(str2, presetAppInfo.version)) {
                                    z = false;
                                }
                            }
                            if (z) {
                                H5NebulaAppBean infoToBean = H5AppInfoUtil.infoToBean((H5NebulaAppBean) null, presetAppInfo, false);
                                H5Log.d(H5NebulaAppDao.TAG, "h5PresetFroMemory get appInfo from preset " + str + " " + presetAppInfo.version);
                                AppInfo beanToInfo = H5AppInfoUtil.beanToInfo(infoToBean);
                                beanToInfo.fromPreset = H5AppHandler.CHECK_VALUE;
                                return beanToInfo;
                            }
                        }
                        return null;
                    }
                }, contains);
                if (contains) {
                    if (appInfo != null) {
                        H5Log.d(TAG, "getAppInfo useDevDB" + str + appInfo.toString());
                    } else {
                        H5Log.d(TAG, "getAppInfo useDevDB" + str + " appInfo is null");
                    }
                }
                if (!contains) {
                    H5MemoryCache.getInstance().saveAppInfoToMemory(appInfo);
                }
                if (appInfo != null) {
                    H5Log.d(TAG, str + " getNebulaAppInfo from getAppInfo  " + appInfo.version);
                } else {
                    H5Log.d(TAG, str + " getNebulaAppInfo from getAppInfo is null");
                }
                return appInfo;
            }
        } else {
            H5NebulaAppBean infoToBean = H5AppInfoUtil.infoToBean((H5NebulaAppBean) null, presetAppInfo, false);
            H5Log.debug(TAG, "getAppInfo from presetInfo : " + str + " " + presetAppInfo.version);
            return H5AppInfoUtil.beanToInfo(infoToBean);
        }
    }

    public void saveAppInfo(final AppInfo appInfo, boolean z) {
        if (appInfo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            executeDB(new H5DaoExecutor<Object>() {
                public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    Dao<H5NebulaAppBean, Integer> h5AppInfoDao = h5BaseDBHelper.getH5AppInfoDao();
                    QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5AppInfoDao.queryBuilder();
                    queryBuilder.where().eq("app_id", appInfo.app_id).and().eq("version", appInfo.version);
                    H5NebulaAppBean queryForFirst = queryBuilder.queryForFirst();
                    boolean z = h5BaseDBHelper instanceof H5DevDBOpenHelper;
                    if (queryForFirst != null) {
                        h5AppInfoDao.update(H5AppInfoUtil.infoToBean(queryForFirst, appInfo, z));
                    } else {
                        h5AppInfoDao.create(H5AppInfoUtil.infoToBean((H5NebulaAppBean) null, appInfo, z));
                    }
                    return null;
                }
            }, H5DevAppList.getInstance().contains(appInfo.app_id));
            H5Log.d(TAG, "saveAppInfo " + appInfo.app_id + " " + appInfo.version + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void deleteAppInfo(final String str, final String str2) {
        AnonymousClass3 r0 = new H5DaoExecutor<Integer>() {
            public Integer execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5NebulaAppBean queryForFirst;
                Dao<H5NebulaAppBean, Integer> h5AppInfoDao = h5BaseDBHelper.getH5AppInfoDao();
                QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5AppInfoDao.queryBuilder();
                queryBuilder.where().eq("app_id", str).and().eq("version", str2);
                if (queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                    return null;
                }
                H5Log.d(H5NebulaAppDao.TAG, "deleteAppInfo:" + str + " " + str2);
                h5AppInfoDao.delete(queryForFirst);
                return null;
            }
        };
        boolean contains = H5DevAppList.getInstance().contains(str);
        executeDB(r0, contains);
        if (!contains) {
            H5MemoryCache.getInstance().deleteAppInfoFromMemory(str, str2);
        }
    }

    public List<H5NebulaAppBean> getCanDeleteAppPooIdList(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        final String findInstallAppVersion = H5AppInstallDao.getDao().findInstallAppVersion(str);
        List<H5NebulaAppBean> list = (List) executeDB(new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInfoDao().queryBuilder();
                if (TextUtils.isEmpty(findInstallAppVersion)) {
                    queryBuilder.where().eq("app_id", str).and().eq("is_mapping", 0);
                } else {
                    queryBuilder.where().eq("app_id", str).and().eq("is_mapping", 0).and().not().eq("version", findInstallAppVersion);
                }
                return queryBuilder.query();
            }
        }, H5DevAppList.getInstance().contains(str));
        if (list == null) {
            return null;
        }
        Collections.sort(list, new Comparator<H5NebulaAppBean>() {
            public int compare(H5NebulaAppBean h5NebulaAppBean, H5NebulaAppBean h5NebulaAppBean2) {
                return H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), h5NebulaAppBean2.getVersion());
            }
        });
        if (list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" getCanDeleteAppPooIdList ");
        for (H5NebulaAppBean version : list) {
            sb.append(" ");
            sb.append(version.getVersion());
        }
        H5Log.d(TAG, sb.toString());
        return list;
    }

    public void markNoDeleteAppVersion(String str, String str2) {
        H5Log.d(TAG, "markNoDeleteAppVersion " + str + " " + str2);
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            appInfo.is_mapping = 1;
            saveAppInfo(appInfo, true);
        }
    }

    public void unMarkNoDeleteAppVersion(String str, String str2) {
        H5Log.d(TAG, "unMarkNoDeleteAppVersion " + str + " " + str2);
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            appInfo.is_mapping = 0;
            saveAppInfo(appInfo, true);
        }
    }

    public Map<String, List<AppInfo>> getAllApp() {
        List<H5NebulaAppBean> list = (List) executeDB(new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                return h5BaseDBHelper.getH5AppInfoDao().queryBuilder().query();
            }
        }, H5DevAppList.getInstance().contains((String) null));
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (H5NebulaAppBean h5NebulaAppBean : list) {
            if (hashMap.get(h5NebulaAppBean.getApp_id()) != null) {
                List list2 = (List) hashMap.get(h5NebulaAppBean.getApp_id());
                list2.add(H5AppInfoUtil.beanToInfo(h5NebulaAppBean));
                hashMap.put(h5NebulaAppBean.getApp_id(), list2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(H5AppInfoUtil.beanToInfo(h5NebulaAppBean));
                hashMap.put(h5NebulaAppBean.getApp_id(), arrayList);
            }
        }
        return hashMap;
    }

    public Map<String, String> getAllHighestAppVersion() {
        long currentTimeMillis = System.currentTimeMillis();
        List<H5NebulaAppBean> list = (List) execute(new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                return h5BaseDBHelper.getH5AppInfoDao().queryBuilder().query();
            }
        });
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (H5NebulaAppBean h5NebulaAppBean : list) {
            if (h5NebulaAppBean.getApp_id() != null) {
                if (hashMap.containsKey(h5NebulaAppBean.getApp_id())) {
                    if (H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), (String) hashMap.get(h5NebulaAppBean.getApp_id())) > 0) {
                        hashMap.put(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion());
                    }
                } else {
                    hashMap.put(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion());
                }
            }
        }
        H5Log.d(TAG, "getAllHighestAppVersion cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return hashMap;
    }

    public Map<String, AppInfo> getAllHighestAppInfo() {
        long currentTimeMillis = System.currentTimeMillis();
        List<H5NebulaAppBean> list = (List) execute(new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                return h5BaseDBHelper.getH5AppInfoDao().queryBuilder().query();
            }
        });
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (H5NebulaAppBean h5NebulaAppBean : list) {
            if (h5NebulaAppBean.getApp_id() != null) {
                if (hashMap.containsKey(h5NebulaAppBean.getApp_id())) {
                    AppInfo appInfo = (AppInfo) hashMap.get(h5NebulaAppBean.getApp_id());
                    if (appInfo != null && H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), appInfo.version) > 0) {
                        hashMap.put(h5NebulaAppBean.getApp_id(), H5AppInfoUtil.beanToInfo(h5NebulaAppBean));
                    }
                } else {
                    hashMap.put(h5NebulaAppBean.getApp_id(), H5AppInfoUtil.beanToInfo(h5NebulaAppBean));
                }
            }
        }
        H5Log.d(TAG, "getAllHighestAppInfo cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return hashMap;
    }

    public Map<String, String> getAllHighestLocalReportAppVersion() {
        long currentTimeMillis = System.currentTimeMillis();
        List<H5NebulaAppBean> list = (List) execute(new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInfoDao().queryBuilder();
                queryBuilder.where().eq(H5NebulaAppBean.LOCAL_REPORT, 1);
                return queryBuilder.query();
            }
        });
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (H5NebulaAppBean h5NebulaAppBean : list) {
            if (h5NebulaAppBean.getApp_id() != null) {
                if (hashMap.containsKey(h5NebulaAppBean.getApp_id())) {
                    if (H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), (String) hashMap.get(h5NebulaAppBean.getApp_id())) > 0) {
                        hashMap.put(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion());
                    }
                } else {
                    hashMap.put(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion());
                }
            }
        }
        H5Log.d(TAG, "getAllHighestLocalReportAppVersion cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return hashMap;
    }

    public void updateAppLimit(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            appInfo.is_limit = 1;
            saveAppInfo(appInfo, true);
        }
    }

    public void cleanAppLimit(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            appInfo.is_limit = 0;
            saveAppInfo(appInfo, true);
        }
    }

    public boolean isLimitApp(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        boolean z = false;
        if (appInfo != null && appInfo.is_limit == 1) {
            z = true;
        }
        H5Log.d(TAG, "isLimitApp  appId:" + str + " version:" + str2 + " isLimit:" + z);
        return z;
    }

    public String getUpdateAppTime(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo == null) {
            return null;
        }
        H5Log.d(TAG, "getUpdateAppTime  appId:" + str + " version:" + str2 + " updateTime:" + appInfo.update_app_time);
        return appInfo.update_app_time;
    }

    public void insertInstalledAppInfo(String str, String str2, String str3) {
        H5AppInstallDao.getDao().createOrUpdateAppInstalled(str, str2, str3);
    }

    public AppInfo getHighestAppVersion(final String str) {
        if (TextUtils.isEmpty(str) || H5AppUtil.isNativeApp(str)) {
            return null;
        }
        try {
            List list = (List) executeDB(new H5DaoExecutor<List<H5NebulaAppBean>>() {
                public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInfoDao().queryBuilder();
                    queryBuilder.where().eq("app_id", str);
                    StringBuilder sb = new StringBuilder("getHighestAppVersion result version :");
                    for (H5NebulaAppBean version : queryBuilder.query()) {
                        sb.append(" ");
                        sb.append(version.getVersion());
                    }
                    H5Log.d(H5NebulaAppDao.TAG, sb.toString());
                    return queryBuilder.query();
                }
            }, H5DevAppList.getInstance().contains(str));
            if (list == null) {
                return null;
            }
            Collections.sort(list, new Comparator<H5NebulaAppBean>() {
                public int compare(H5NebulaAppBean h5NebulaAppBean, H5NebulaAppBean h5NebulaAppBean2) {
                    return H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), h5NebulaAppBean2.getVersion());
                }
            });
            if (list.size() == 0) {
                return null;
            }
            AppInfo beanToInfo = H5AppInfoUtil.beanToInfo((H5NebulaAppBean) list.get(list.size() - 1));
            H5Log.d(TAG, str + " getNebulaAppInfo from getHighestAppVersion  appId: version:" + beanToInfo.version);
            return beanToInfo;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }

    private AppInfo checkVersion(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return getHighestAppVersion(str);
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("*")) {
            return null;
        }
        return getMatchHighestAppVersion(str, str2);
    }

    public AppInfo getMatchHighestAppVersion(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return getHighestAppVersion(str);
        }
        if (!str2.contains("*")) {
            H5Log.d(TAG, "!version.contains *");
            return null;
        }
        int indexOf = str2.indexOf("*");
        if (str2.length() == 1) {
            return getHighestAppVersion(str);
        }
        String substring = str2.substring(0, indexOf - 1);
        AnonymousClass12 r2 = new H5DaoExecutor<List<H5NebulaAppBean>>() {
            public List<H5NebulaAppBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                QueryBuilder<H5NebulaAppBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInfoDao().queryBuilder();
                queryBuilder.where().eq("app_id", str);
                return queryBuilder.query();
            }
        };
        try {
            ArrayList arrayList = new ArrayList();
            List<H5NebulaAppBean> list = (List) executeDB(r2, H5DevAppList.getInstance().contains(str));
            if (list == null) {
                return null;
            }
            for (H5NebulaAppBean h5NebulaAppBean : list) {
                if (h5NebulaAppBean.getVersion() != null && !h5NebulaAppBean.getVersion().contains("*") && h5NebulaAppBean.getVersion().startsWith(substring)) {
                    arrayList.add(h5NebulaAppBean);
                }
            }
            Collections.sort(arrayList, new Comparator<H5NebulaAppBean>() {
                public int compare(H5NebulaAppBean h5NebulaAppBean, H5NebulaAppBean h5NebulaAppBean2) {
                    return H5AppUtil.compareVersion(h5NebulaAppBean.getVersion(), h5NebulaAppBean2.getVersion());
                }
            });
            if (arrayList.size() == 0) {
                return null;
            }
            AppInfo beanToInfo = H5AppInfoUtil.beanToInfo((H5NebulaAppBean) arrayList.get(arrayList.size() - 1));
            H5Log.d(TAG, str + " getNebulaAppInfo from getMatchHighestAppVersion " + beanToInfo.version);
            return beanToInfo;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    public void updateUpdateTime(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        saveAppInfo(getAppInfo(str, str2), true);
        H5Log.d(TAG, str + " updateUpdateTime cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
