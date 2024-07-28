package com.alipay.mobile.nebulaappcenter.dbdao;

import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoExecutor;
import com.alipay.mobile.nebulaappcenter.dbapi.H5DaoTemplate;
import com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean;
import com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.util.HashMap;
import java.util.Map;

public class H5AppConfigDao extends H5DaoTemplate {
    private static final String TAG = "H5AppConfigDao";
    private static final int appPoolCapacity = 3;
    private static H5AppConfigDao instance = new H5AppConfigDao();
    private static final double limitReqRate = 600.0d;
    private static final double updateReqRate = 1800.0d;

    public static synchronized H5AppConfigDao getDao() {
        H5AppConfigDao h5AppConfigDao;
        synchronized (H5AppConfigDao.class) {
            if (instance == null) {
                instance = new H5AppConfigDao();
            }
            h5AppConfigDao = instance;
        }
        return h5AppConfigDao;
    }

    @Deprecated
    public void cleanFailedRequestAppList(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            execute(new H5DaoExecutor<Object>() {
                public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                    QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                    if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                        return null;
                    }
                    H5AppConfigBean queryForFirst = queryBuilder.queryForFirst();
                    queryForFirst.setFailed_request_app_list("");
                    h5AppConfigDao.update(queryForFirst);
                    return null;
                }
            });
        }
    }

    @Deprecated
    public void setFailedRequestAppList(Map<String, String> map) {
        final String mapToString = mapToString(map);
        if (!TextUtils.isEmpty(mapToString)) {
            execute(new H5DaoExecutor<Object>() {
                public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                    Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                    QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                    if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                        return null;
                    }
                    H5AppConfigBean queryForFirst = queryBuilder.queryForFirst();
                    queryForFirst.setFailed_request_app_list(mapToString);
                    H5Log.d(H5AppConfigDao.TAG, "setFailedRequestAppList:" + mapToString);
                    h5AppConfigDao.update(queryForFirst);
                    return null;
                }
            });
        }
    }

    @Deprecated
    public Map<String, String> getFailedRequestAppList() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = (String) execute(new H5DaoExecutor<String>() {
            public String execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    return null;
                }
                return queryBuilder.queryForFirst().getFailed_request_app_list();
            }
        });
        H5Log.d(TAG, "getFailedRequestAppList:" + str + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return jsonStrToMap(str);
    }

    public void cleanAllFailList() {
        execute(new H5DaoExecutor<String>() {
            public String execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    return null;
                }
                H5AppConfigBean queryForFirst = queryBuilder.queryForFirst();
                queryForFirst.setFailed_request_app_list("");
                h5AppConfigDao.update(queryForFirst);
                return null;
            }
        });
    }

    public double getNormalReqRate() {
        long currentTimeMillis = System.currentTimeMillis();
        double doubleValue = ((Double) execute(new H5DaoExecutor<Double>() {
            public Double execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean queryForFirst;
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                    return Double.valueOf(0.0d);
                }
                return Double.valueOf(queryForFirst.getNormalReqRate());
            }
        })).doubleValue();
        if (doubleValue == 0.0d) {
            doubleValue = updateReqRate;
        }
        H5Log.d(TAG, "getNormalReqRate limit:" + doubleValue + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return doubleValue;
    }

    public double getLimitReqRate() {
        double doubleValue = ((Double) execute(new H5DaoExecutor<Double>() {
            public Double execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean queryForFirst;
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                    return Double.valueOf(0.0d);
                }
                return Double.valueOf(queryForFirst.getLimitReqRate());
            }
        })).doubleValue();
        if (doubleValue == 0.0d) {
            doubleValue = limitReqRate;
        }
        H5Log.d(TAG, "getLimitReqRate limit:".concat(String.valueOf(doubleValue)));
        return doubleValue;
    }

    public String getLastAllUpdateTime() {
        String str = (String) execute(new H5DaoExecutor<String>() {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
                r2 = r2.queryForFirst();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String execute(com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper r2) throws java.lang.Exception {
                /*
                    r1 = this;
                    com.j256.ormlite.dao.Dao r2 = r2.getH5AppConfigDao()
                    com.j256.ormlite.stmt.QueryBuilder r2 = r2.queryBuilder()
                    if (r2 == 0) goto L_0x001d
                    java.lang.Object r0 = r2.queryForFirst()
                    if (r0 == 0) goto L_0x001d
                    java.lang.Object r2 = r2.queryForFirst()
                    com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean r2 = (com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean) r2
                    if (r2 == 0) goto L_0x001d
                    java.lang.String r2 = r2.getLast_update_date()
                    return r2
                L_0x001d:
                    java.lang.String r2 = "0"
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.dbdao.H5AppConfigDao.AnonymousClass7.execute(com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper):java.lang.String");
            }
        });
        H5Log.d(TAG, "getLastAllUpdateTime :".concat(String.valueOf(str)));
        return str;
    }

    public void createOrUpdateAppPoolLimit(final int i2) {
        H5Log.d(TAG, "updateAppPoolLimit:".concat(String.valueOf(i2)));
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                h5AppConfigBean.setApp_pool_limit(i2);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
    }

    public boolean hasSetConfig() {
        return execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    return null;
                }
                return queryBuilder.queryForFirst();
            }
        }) != null;
    }

    public void createOrUpdateNormalReqRate(final double d2) {
        H5Log.d(TAG, "updateNormalReqRate rate:".concat(String.valueOf(d2)));
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                h5AppConfigBean.setNormalReqRate(d2);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
    }

    public void createOrUpdateConfig(final H5AppConfigBean h5AppConfigBean) {
        long currentTimeMillis = System.currentTimeMillis();
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = H5AppConfigDao.this.makeConfig((H5AppConfigBean) null, h5AppConfigBean);
                } else {
                    h5AppConfigBean = H5AppConfigDao.this.makeConfig(queryBuilder.queryForFirst(), h5AppConfigBean);
                }
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
        H5Log.d(TAG, "createOrUpdateConfig cost " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: private */
    public H5AppConfigBean makeConfig(H5AppConfigBean h5AppConfigBean, H5AppConfigBean h5AppConfigBean2) {
        if (h5AppConfigBean == null) {
            h5AppConfigBean = new H5AppConfigBean();
        }
        h5AppConfigBean.setApp_pool_limit(h5AppConfigBean2.getApp_pool_limit());
        h5AppConfigBean.setNormalReqRate(h5AppConfigBean2.getNormalReqRate());
        h5AppConfigBean.setLimitReqRate(h5AppConfigBean2.getLimitReqRate());
        h5AppConfigBean.setExtra(h5AppConfigBean2.getExtra());
        return h5AppConfigBean;
    }

    public void createOrUpdateStrictReqRate(final int i2) {
        H5Log.d(TAG, "createOrUpdateStrictReqRate rate:".concat(String.valueOf(i2)));
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                h5AppConfigBean.setStrictReqRate(i2);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
    }

    public String getExtra() {
        String str = (String) execute(new H5DaoExecutor<String>() {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
                r2 = r2.queryForFirst();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String execute(com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper r2) throws java.lang.Exception {
                /*
                    r1 = this;
                    com.j256.ormlite.dao.Dao r2 = r2.getH5AppConfigDao()
                    com.j256.ormlite.stmt.QueryBuilder r2 = r2.queryBuilder()
                    if (r2 == 0) goto L_0x001d
                    java.lang.Object r0 = r2.queryForFirst()
                    if (r0 == 0) goto L_0x001d
                    java.lang.Object r2 = r2.queryForFirst()
                    com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean r2 = (com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean) r2
                    if (r2 == 0) goto L_0x001d
                    java.lang.String r2 = r2.getExtra()
                    return r2
                L_0x001d:
                    java.lang.String r2 = ""
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.dbdao.H5AppConfigDao.AnonymousClass13.execute(com.alipay.mobile.nebulaappcenter.dbhelp.H5BaseDBHelper):java.lang.String");
            }
        });
        H5Log.d(TAG, "getExtra :".concat(String.valueOf(str)));
        return str;
    }

    public void createOrUpdateExtra(final String str) {
        long currentTimeMillis = System.currentTimeMillis();
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                h5AppConfigBean.setExtra(str);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
        H5Log.d(TAG, "createOrUpdateExtra extra:" + str + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void createOrUpdateLimitReqRate(final double d2) {
        H5Log.d(TAG, "updateLimitReqRate rate:".concat(String.valueOf(d2)));
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                if (h5AppConfigBean == null) {
                    return null;
                }
                h5AppConfigBean.setLimitReqRate(d2);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
    }

    public int getAppPoolLimit() {
        int intValue = ((Integer) execute(new H5DaoExecutor<Integer>() {
            public Integer execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean queryForFirst;
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                    return 0;
                }
                return Integer.valueOf(queryForFirst.getApp_pool_limit());
            }
        })).intValue();
        if (intValue == 0) {
            intValue = 3;
        }
        H5Log.d(TAG, "getAppPoolLimit limit:".concat(String.valueOf(intValue)));
        return intValue;
    }

    public int getStrictReqRate() {
        int intValue = ((Integer) execute(new H5DaoExecutor<Integer>() {
            public Integer execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean queryForFirst;
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5BaseDBHelper.getH5AppConfigDao().queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null || (queryForFirst = queryBuilder.queryForFirst()) == null) {
                    return 0;
                }
                return Integer.valueOf(queryForFirst.getStrictReqRate());
            }
        })).intValue();
        H5Log.d(TAG, "getStrictReqRate :".concat(String.valueOf(intValue)));
        return intValue;
    }

    public void setDefaultConfig() {
        execute(new H5DaoExecutor<Object>() {
            public Object execute(H5BaseDBHelper h5BaseDBHelper) throws Exception {
                H5AppConfigBean h5AppConfigBean;
                Dao<H5AppConfigBean, Integer> h5AppConfigDao = h5BaseDBHelper.getH5AppConfigDao();
                QueryBuilder<H5AppConfigBean, Integer> queryBuilder = h5AppConfigDao.queryBuilder();
                if (queryBuilder == null || queryBuilder.queryForFirst() == null) {
                    h5AppConfigBean = new H5AppConfigBean();
                } else {
                    h5AppConfigBean = queryBuilder.queryForFirst();
                }
                if (h5AppConfigBean == null) {
                    return null;
                }
                h5AppConfigBean.setApp_pool_limit(3);
                h5AppConfigBean.setLimitReqRate(H5AppConfigDao.limitReqRate);
                h5AppConfigBean.setNormalReqRate(H5AppConfigDao.updateReqRate);
                h5AppConfigBean.setStrictReqRate(0);
                h5AppConfigDao.createOrUpdate(h5AppConfigBean);
                return null;
            }
        });
    }

    private static Map<String, String> jsonStrToMap(String str) {
        e eVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            eVar = a.parseObject(str);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            H5NebulaDBService.getInstance().cleanAllFailList();
            eVar = null;
        }
        if (eVar == null || eVar.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : eVar.keySet()) {
            hashMap.put(next, eVar.get(next).toString());
        }
        return hashMap;
    }

    private static String mapToString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        e eVar = new e();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!eVar.containsKey(str)) {
                eVar.put(str, (Object) str2);
            }
        }
        if (eVar.isEmpty()) {
            return "";
        }
        return eVar.toJSONString();
    }
}
