package com.alipay.mobile.nebulaappcenter.dbdao;

import android.text.TextUtils;
import androidx.a.e;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoExecutor;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoTemplate;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppInstallBean;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper;
import com.alipay.mobile.nebulaappcenter.util.H5AppGlobal;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H5AppInstallDao extends H5DaoTemplate {
    private static final String TAG = "H5AppInstallDao";
    private static e<String, String> cache = new e<>(20);
    private static H5AppInstallDao instance = new H5AppInstallDao();

    private H5AppInstallDao() {
    }

    public static synchronized H5AppInstallDao getDao() {
        H5AppInstallDao h5AppInstallDao;
        synchronized (H5AppInstallDao.class) {
            if (instance == null) {
                instance = new H5AppInstallDao();
            }
            h5AppInstallDao = instance;
        }
        return h5AppInstallDao;
    }

    public void createOrUpdateAppInstalled(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final long currentTimeMillis = System.currentTimeMillis();
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            execute(new H5DaoExecutor<Object>() {
                public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    H5AppInstallBean h5AppInstallBean;
                    Dao<H5AppInstallBean, Integer> h5AppInstallDao = h5BaseDBHelper.getH5AppInstallDao();
                    QueryBuilder<H5AppInstallBean, Integer> queryBuilder = h5AppInstallDao.queryBuilder();
                    queryBuilder.where().eq(H5AppInstallBean.COL_APP_ID, str4);
                    if (queryBuilder.queryForFirst() != null) {
                        h5AppInstallBean = queryBuilder.queryForFirst();
                    } else {
                        h5AppInstallBean = new H5AppInstallBean();
                    }
                    if (h5AppInstallBean == null) {
                        return null;
                    }
                    h5AppInstallBean.setInstall_appId(str4);
                    h5AppInstallBean.setInstall_version(str5);
                    h5AppInstallBean.setInstallPath(str6);
                    h5AppInstallDao.createOrUpdate(h5AppInstallBean);
                    H5Log.d(H5AppInstallDao.TAG, "updateAppInstalled: appId:" + str4 + " version:" + str5 + " " + str6 + "  spend createOrUpdateAppInstalled " + (System.currentTimeMillis() - currentTimeMillis));
                    return null;
                }
            });
            cache.put(str, str2);
        }
    }

    public Map<String, String> getInstalledApp() {
        long currentTimeMillis = System.currentTimeMillis();
        List<H5AppInstallBean> list = (List) execute(new H5DaoExecutor<List<H5AppInstallBean>>() {
            public List<H5AppInstallBean> execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                return h5BaseDBHelper.getH5AppInstallDao().queryBuilder().query();
            }
        });
        if (list == null) {
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        HashMap hashMap = new HashMap();
        for (H5AppInstallBean h5AppInstallBean : list) {
            H5Log.d(TAG, "getInstalledApp: appId:" + h5AppInstallBean.getInstall_appId() + " version:" + h5AppInstallBean.getInstall_version() + " allCost:" + currentTimeMillis2);
            if (H5AppGlobal.hasInstallFile(h5AppInstallBean.getInstall_appId(), h5AppInstallBean.getInstall_version(), h5AppInstallBean.getInstallPath())) {
                cache.put(h5AppInstallBean.getInstall_appId(), h5AppInstallBean.getInstall_version());
                hashMap.put(h5AppInstallBean.getInstall_appId(), h5AppInstallBean.getInstall_version());
            } else {
                H5Log.d(TAG, h5AppInstallBean.getInstall_appId() + " is not install delete form db");
                deleteAppInstall(h5AppInstallBean.getInstall_appId());
            }
        }
        return hashMap;
    }

    private boolean enableUse() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_useInstall_cache"));
    }

    public String findInstallAppVersion(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = cache.get(str);
        if (str2 == null || !H5Utils.isMainProcess() || !enableUse()) {
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = (String) execute(new H5DaoExecutor<String>() {
                public String execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    H5AppInstallBean queryForFirst;
                    QueryBuilder<H5AppInstallBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppInstallDao().queryBuilder();
                    queryBuilder.where().eq(H5AppInstallBean.COL_APP_ID, str);
                    if (queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                        return null;
                    }
                    String installPath = queryForFirst.getInstallPath();
                    String install_version = queryForFirst.getInstall_version();
                    if (TextUtils.isEmpty(installPath) || H5FileUtil.exists(installPath)) {
                        return install_version;
                    }
                    H5Log.d(H5AppInstallDao.TAG, "path " + installPath + " is not exist");
                    H5AppInstallDao.this.deleteAppInstall(str);
                    return null;
                }
            });
            H5Log.d(TAG, "findInstallAppVersion  appId:" + str + " installVersion:" + str3 + " cost" + (System.currentTimeMillis() - currentTimeMillis));
            cache.put(str, str3 == null ? "" : str3);
            return str3;
        }
        H5Log.d(TAG, "findInstallAppVersion " + str + " form cache " + str2);
        return str2;
    }

    public void deleteAppInstall(final String str) {
        if (!TextUtils.isEmpty(str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            execute(new H5DaoExecutor<Integer>() {
                public Integer execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    H5AppInstallBean queryForFirst;
                    Dao<H5AppInstallBean, Integer> h5AppInstallDao = h5BaseDBHelper.getH5AppInstallDao();
                    QueryBuilder<H5AppInstallBean, Integer> queryBuilder = h5AppInstallDao.queryBuilder();
                    queryBuilder.where().eq(H5AppInstallBean.COL_APP_ID, str);
                    if (queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                        return null;
                    }
                    H5Log.d(H5AppInstallDao.TAG, "deleteAppInstall appId:" + str + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    h5AppInstallDao.delete(queryForFirst);
                    return null;
                }
            });
            cache.put(str, "");
        }
    }
}
