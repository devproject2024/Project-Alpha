package com.alipay.mobile.nebula.appcenter.apphandler;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.callback.H5SimpleRpcListener;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5SimpleRpcProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SharedPreUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class H5AppScoreList {
    private static final int H5_LIMIT_CODE = 100201;
    public static final int PRE_ZIP_STRATEGY = 1;
    private static final String RPC_LIMIT_TAG = "limit_tag";
    private static final String SCORE_RPC_TYPE = "com.alipay.hpmweb.queryAppCredit";
    public static final int STRONG_REQ_STRATEGY = 2;
    private static final String TAG = "H5AppScoreList";
    private static H5AppScoreList instance;
    /* access modifiers changed from: private */
    public H5AppCreditInfo appCreditInfo;
    private boolean enable;
    private long limitRate;
    private long reqRate;

    private H5AppScoreList() {
        initSwitchConfig();
    }

    public static synchronized H5AppScoreList getInstance() {
        H5AppScoreList h5AppScoreList;
        synchronized (H5AppScoreList.class) {
            if (instance == null) {
                instance = new H5AppScoreList();
            }
            h5AppScoreList = instance;
        }
        return h5AppScoreList;
    }

    public boolean isInStrategy(String str, int i2) {
        List list;
        H5AppCreditInfo h5AppCreditInfo = this.appCreditInfo;
        if (h5AppCreditInfo == null || h5AppCreditInfo.getStrategyMap() == null || !this.appCreditInfo.getStrategyMap().containsKey(Integer.valueOf(i2)) || TextUtils.isEmpty(str) || (list = this.appCreditInfo.getStrategyMap().get(Integer.valueOf(i2))) == null) {
            return false;
        }
        return list.contains(str);
    }

    public List<String> getAppListWithStrategy(int i2) {
        H5AppCreditInfo h5AppCreditInfo = this.appCreditInfo;
        if (h5AppCreditInfo == null || h5AppCreditInfo.getStrategyMap() == null) {
            return null;
        }
        return this.appCreditInfo.getStrategyMap().get(Integer.valueOf(i2));
    }

    public String getAppCredit(String str) {
        H5AppCreditInfo h5AppCreditInfo = this.appCreditInfo;
        if (!(h5AppCreditInfo == null || h5AppCreditInfo.getCreditMap() == null || this.appCreditInfo.getCreditMap().size() == 0)) {
            for (Map.Entry next : this.appCreditInfo.getCreditMap().entrySet()) {
                List list = (List) next.getValue();
                if (list != null && list.size() > 0 && list.contains(str)) {
                    return (String) next.getKey();
                }
            }
        }
        return "0";
    }

    public void updateAppScoreInfo(final boolean z, final H5AppScoreRpcListener h5AppScoreRpcListener) {
        if (!this.enable) {
            invokeCallback(h5AppScoreRpcListener, false);
        } else {
            H5Utils.getExecutor(H5ThreadType.NORMAL).execute(new Runnable() {
                public void run() {
                    if (H5AppScoreList.this.enableSendRpc() || z) {
                        H5SimpleRpcProvider h5SimpleRpcProvider = (H5SimpleRpcProvider) H5Utils.getProvider(H5SimpleRpcProvider.class.getName());
                        if (h5SimpleRpcProvider != null) {
                            h5SimpleRpcProvider.sendSimpleRpc(H5AppScoreList.SCORE_RPC_TYPE, (String) null, (String) null, true, (e) null, (String) null, false, (H5Page) null, new H5SimpleRpcListener() {
                                public void onSuccess(String str) {
                                    H5Log.d(H5AppScoreList.TAG, " response : ".concat(String.valueOf(str)));
                                    H5AppScoreList.this.saveResponse(str);
                                    H5AppScoreList.this.initAppCreditInfo(H5Utils.parseObject(str));
                                    H5AppScoreList.this.invokeCallback(h5AppScoreRpcListener, true);
                                }

                                public void onFailed(int i2, String str) {
                                    if (H5AppScoreList.H5_LIMIT_CODE == i2) {
                                        H5SharedPreUtil.saveLongData(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME, System.currentTimeMillis());
                                        H5SharedPreUtil.saveStringData(H5SharedPreUtil.H5_SCORE_RPC_LIMIT, H5AppScoreList.RPC_LIMIT_TAG);
                                    }
                                    if (z) {
                                        H5SharedPreUtil.removeData(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME);
                                    }
                                    H5AppScoreList.this.initData();
                                    H5Log.d(H5AppScoreList.TAG, "errorCode : " + i2 + " errorMessage : " + str);
                                    H5AppScoreList.this.invokeCallback(h5AppScoreRpcListener, false);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    H5AppScoreList.this.initData();
                    H5AppScoreList.this.invokeCallback(h5AppScoreRpcListener, false);
                }
            });
        }
    }

    public void checkPreInstallApp() {
        if (this.enable) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    H5AppCenterService h5AppCenterService;
                    H5AppDBService appDBService;
                    if (H5AppScoreList.this.appCreditInfo == null) {
                        H5AppScoreList.this.initData();
                    }
                    List<String> appListWithStrategy = H5AppScoreList.this.getAppListWithStrategy(1);
                    if (appListWithStrategy != null && !appListWithStrategy.isEmpty() && (h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName())) != null && (appDBService = h5AppCenterService.getAppDBService()) != null) {
                        for (String next : appListWithStrategy) {
                            String highestAppVersion = appDBService.getHighestAppVersion(next);
                            AppInfo appInfo = appDBService.getAppInfo(next, highestAppVersion);
                            H5BaseApp h5App = h5AppCenterService.getH5App();
                            if (!(appInfo == null || h5App == null)) {
                                h5App.setAppInfo(appInfo);
                                if (h5App.isAvailable() && !h5App.isInstalled()) {
                                    H5Log.d(H5AppScoreList.TAG, "pre install appId : " + next + " version : " + highestAppVersion);
                                    h5App.installApp();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeCallback(H5AppScoreRpcListener h5AppScoreRpcListener, boolean z) {
        if (h5AppScoreRpcListener != null) {
            h5AppScoreRpcListener.onFinish(z);
        }
    }

    /* access modifiers changed from: private */
    public void initData() {
        String stringData = H5SharedPreUtil.getStringData(H5SharedPreUtil.H5_APP_SCORE_INFO);
        if (!TextUtils.isEmpty(stringData)) {
            initAppCreditInfo(H5Utils.parseObject(stringData));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x00a3=Splitter:B:38:0x00a3, B:42:0x00a7=Splitter:B:42:0x00a7, B:46:0x00ab=Splitter:B:46:0x00ab, B:50:0x00af=Splitter:B:50:0x00af} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initAppCreditInfo(com.alibaba.a.e r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 == 0) goto L_0x00af
            boolean r1 = r8.isEmpty()     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x000c
            goto L_0x00af
        L_0x000c:
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppCreditInfo r1 = new com.alipay.mobile.nebula.appcenter.apphandler.H5AppCreditInfo     // Catch:{ all -> 0x00b3 }
            r1.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = "data"
            com.alibaba.a.b r2 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r8, r2, r0)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00ab
            int r3 = r2.size()     // Catch:{ all -> 0x00b3 }
            if (r3 != 0) goto L_0x0021
            goto L_0x00ab
        L_0x0021:
            java.lang.String r3 = "config"
            com.alibaba.a.e r8 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r8, r3, r0)     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x00a7
            boolean r3 = r8.isEmpty()     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x0031
            goto L_0x00a7
        L_0x0031:
            r3 = 0
        L_0x0032:
            int r4 = r2.size()     // Catch:{ all -> 0x00b3 }
            if (r3 >= r4) goto L_0x004e
            com.alibaba.a.e r4 = r2.getJSONObject(r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r5 = "credit"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = "appId"
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r6)     // Catch:{ all -> 0x00b3 }
            r1.addCreditAppInfo(r5, r4)     // Catch:{ all -> 0x00b3 }
            int r3 = r3 + 1
            goto L_0x0032
        L_0x004e:
            java.util.Map r2 = r1.getCreditMap()     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00a3
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00b3 }
            if (r3 == 0) goto L_0x005b
            goto L_0x00a3
        L_0x005b:
            java.util.Set r0 = r2.entrySet()     // Catch:{ all -> 0x00b3 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00b3 }
        L_0x0063:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x0090
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00b3 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00b3 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00b3 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00b3 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x00b3 }
            int r3 = r7.getCreditStrategy(r3, r8)     // Catch:{ all -> 0x00b3 }
            r4 = r3 & 1
            r5 = 1
            if (r4 != r5) goto L_0x0087
            r1.addStrategyInfo(r5, r2)     // Catch:{ all -> 0x00b3 }
        L_0x0087:
            r3 = r3 & 2
            r4 = 2
            if (r3 != r4) goto L_0x0063
            r1.addStrategyInfo(r4, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x0063
        L_0x0090:
            java.lang.String r8 = "H5AppScoreList"
            java.lang.String r0 = "creditInfo : "
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x00b3 }
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)     // Catch:{ all -> 0x00b3 }
            r7.appCreditInfo = r1     // Catch:{ all -> 0x00b3 }
            monitor-exit(r7)
            return
        L_0x00a3:
            r7.appCreditInfo = r0     // Catch:{ all -> 0x00b3 }
            monitor-exit(r7)
            return
        L_0x00a7:
            r7.appCreditInfo = r0     // Catch:{ all -> 0x00b3 }
            monitor-exit(r7)
            return
        L_0x00ab:
            r7.appCreditInfo = r0     // Catch:{ all -> 0x00b3 }
            monitor-exit(r7)
            return
        L_0x00af:
            r7.appCreditInfo = r0     // Catch:{ all -> 0x00b3 }
            monitor-exit(r7)
            return
        L_0x00b3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.apphandler.H5AppScoreList.initAppCreditInfo(com.alibaba.a.e):void");
    }

    private int getCreditStrategy(String str, e eVar) {
        String string = H5Utils.getString(eVar, str);
        int i2 = 0;
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            i2 = Integer.decode(string).intValue();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        H5Log.d(TAG, " strategy : ".concat(String.valueOf(i2)));
        return i2;
    }

    /* access modifiers changed from: private */
    public boolean enableSendRpc() {
        long longData = H5SharedPreUtil.getLongData(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME);
        int i2 = (longData > 0 ? 1 : (longData == 0 ? 0 : -1));
        if (i2 > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            H5Log.d(TAG, "currentTime : " + currentTimeMillis + " lastTime : " + longData + " reqRate : " + this.reqRate + " limitRate : " + this.limitRate);
            long j = rpcLimit() ? this.limitRate : this.reqRate;
            if (i2 <= 0 || currentTimeMillis - longData <= j) {
                return false;
            }
            return true;
        }
        H5SharedPreUtil.saveLongData(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME, System.currentTimeMillis());
        return true;
    }

    private boolean rpcLimit() {
        return !TextUtils.isEmpty(H5SharedPreUtil.getStringData(H5SharedPreUtil.H5_SCORE_RPC_LIMIT));
    }

    private void initSwitchConfig() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        this.enable = false;
        if (h5ConfigProvider != null) {
            String configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5_nbcredit");
            if (!TextUtils.isEmpty(configWithProcessCache)) {
                e parseObject = H5Utils.parseObject(configWithProcessCache);
                if (parseObject != null && !parseObject.isEmpty()) {
                    this.enable = H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Utils.getString(parseObject, "switch"));
                    try {
                        int parseInt = Integer.parseInt(H5Utils.getString(parseObject, "reqrate"));
                        if (parseInt > 0) {
                            this.reqRate = TimeUnit.SECONDS.toMillis((long) parseInt);
                        } else {
                            this.reqRate = TimeUnit.HOURS.toMillis(24);
                        }
                        int parseInt2 = Integer.parseInt(H5Utils.getString(parseObject, "limitrate"));
                        if (parseInt2 > 0) {
                            this.limitRate = TimeUnit.SECONDS.toMillis((long) parseInt2);
                        } else {
                            this.limitRate = TimeUnit.MINUTES.toMillis(10);
                        }
                    } catch (Throwable th) {
                        H5Log.e(TAG, th);
                    }
                }
                H5Log.d(TAG, " enable : " + this.enable + " reqRate : " + this.reqRate + " limitRate : " + this.limitRate);
            }
        }
    }

    /* access modifiers changed from: private */
    public void saveResponse(String str) {
        try {
            H5SharedPreUtil.getSharedPreferences().edit().remove(H5SharedPreUtil.H5_SCORE_RPC_LIMIT).putLong(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME, System.currentTimeMillis()).putString(H5SharedPreUtil.H5_APP_SCORE_INFO, str).apply();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public void clearAppScoreInfo() {
        try {
            this.appCreditInfo = null;
            H5SharedPreUtil.getSharedPreferences().edit().remove(H5SharedPreUtil.H5_SCORE_RPC_LIMIT).remove(H5SharedPreUtil.H5_APP_SCORE_RPC_TIME).remove(H5SharedPreUtil.H5_APP_SCORE_INFO).apply();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }
}
