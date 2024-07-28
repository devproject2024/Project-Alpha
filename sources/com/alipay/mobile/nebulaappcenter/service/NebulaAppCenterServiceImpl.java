package com.alipay.mobile.nebulaappcenter.service;

import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5PreSetPkgInfo;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.appcenter.util.H5LoadingApp;
import com.alipay.mobile.nebula.appcenter.wifidownload.H5WifiDownloadList;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulaappcenter.app.H5App;
import com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService;
import com.alipay.mobile.nebulaappcenter.dbbean.H5NebulaAppBean;
import com.alipay.mobile.nebulaappcenter.util.H5AppGlobal;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NebulaAppCenterServiceImpl extends NebulaAppCenterService {
    private static String SDK_VERSION = "1.3.0.0";
    /* access modifiers changed from: private */
    public static String TAG = "H5AppCenterServiceImpl";
    private static List<H5PreSetPkgInfo> h5PreSetPkgInfoList;
    private H5NebulaDBService h5AppDBService;

    public void onDestroy(Bundle bundle) {
    }

    public void onCreate(Bundle bundle) {
        H5Log.d(TAG, "create DBService.");
        this.h5AppDBService = H5NebulaDBService.getInstance();
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                NebulaAppCenterServiceImpl.this.deleteOldDownloadDir();
                NebulaAppCenterServiceImpl.this.deleteOldInstallPath();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deleteOldInstallPath() {
        String installPath = H5AppGlobal.getInstallPath(H5AppGlobal.OLD_APP_INSTALL_PATH);
        if (!TextUtils.isEmpty(installPath) && installPath.contains(H5AppGlobal.OLD_APP_INSTALL_PATH)) {
            File file = new File(installPath);
            boolean exists = H5FileUtil.exists(file);
            String str = TAG;
            H5Log.d(str, "delete file " + installPath + " exist:" + exists);
            if (exists) {
                H5FileUtil.delete(file);
            }
        }
    }

    /* access modifiers changed from: private */
    public void deleteOldDownloadDir() {
        try {
            String str = H5DownloadRequest.getOldDownloadDir(H5Utils.getContext()) + "/";
            if (!TextUtils.isEmpty(str)) {
                H5Log.d(TAG, str);
                if (str.contains("nebulaH5App")) {
                    File file = new File(str);
                    boolean exists = H5FileUtil.exists(file);
                    if (exists) {
                        H5FileUtil.delete(file);
                    }
                    H5Log.d(TAG, "delete file " + str + " exist:" + exists);
                }
            }
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073 A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b A[Catch:{ Exception -> 0x009c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadPresetAppList(java.io.InputStream r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r9 = com.alipay.mobile.nebulaappcenter.util.H5AppGlobal.getFromAssets(r9)     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = "loadPresetApp:"
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ Exception -> 0x009c }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ Exception -> 0x009c }
            com.alibaba.a.e r9 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r9)     // Catch:{ Exception -> 0x009c }
            com.alipay.mobile.nebula.appcenter.model.AppRes r0 = new com.alipay.mobile.nebula.appcenter.model.AppRes     // Catch:{ Exception -> 0x009c }
            r0.<init>()     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = "config"
            r2 = 0
            com.alibaba.a.e r1 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r9, r1, r2)     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5Utils.toJSONString(r1)     // Catch:{ Exception -> 0x009c }
            java.util.Map r1 = com.alipay.mobile.nebula.util.H5Utils.jsonToMap(r1)     // Catch:{ Exception -> 0x009c }
            r0.config = r1     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = "data"
            com.alibaba.a.b r9 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r9, r1, r2)     // Catch:{ Exception -> 0x009c }
            if (r9 != 0) goto L_0x0040
            java.lang.String r9 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = "dataList == null return"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ Exception -> 0x009c }
            return
        L_0x0040:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x009c }
            r1.<init>()     // Catch:{ Exception -> 0x009c }
            r0.data = r1     // Catch:{ Exception -> 0x009c }
            r1 = 0
            r3 = 0
        L_0x0049:
            int r4 = r9.size()     // Catch:{ Exception -> 0x009c }
            if (r3 >= r4) goto L_0x0098
            java.lang.Object r4 = r9.get(r3)     // Catch:{ Exception -> 0x006a }
            boolean r4 = r4 instanceof com.alibaba.a.e     // Catch:{ Exception -> 0x006a }
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r9.get(r3)     // Catch:{ Exception -> 0x006a }
            com.alibaba.a.e r4 = (com.alibaba.a.e) r4     // Catch:{ Exception -> 0x006a }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.toAppInfo(r4)     // Catch:{ Exception -> 0x006a }
            goto L_0x0071
        L_0x0062:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x006a }
            java.lang.String r5 = "dataList.get(index) is not JSONObject"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r5)     // Catch:{ Exception -> 0x006a }
            goto L_0x0070
        L_0x006a:
            r4 = move-exception
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x009c }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r5, (java.lang.Throwable) r4)     // Catch:{ Exception -> 0x009c }
        L_0x0070:
            r4 = r2
        L_0x0071:
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.String r5 = "appInfo == null continue "
            com.alipay.mobile.nebula.util.H5Log.d(r4, r5)     // Catch:{ Exception -> 0x009c }
            goto L_0x0095
        L_0x007b:
            java.lang.String r5 = TAG     // Catch:{ Exception -> 0x009c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009c }
            java.lang.String r7 = "preset appId:"
            r6.<init>(r7)     // Catch:{ Exception -> 0x009c }
            java.lang.String r7 = r4.app_id     // Catch:{ Exception -> 0x009c }
            r6.append(r7)     // Catch:{ Exception -> 0x009c }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x009c }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r6)     // Catch:{ Exception -> 0x009c }
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r5 = r0.data     // Catch:{ Exception -> 0x009c }
            r5.add(r4)     // Catch:{ Exception -> 0x009c }
        L_0x0095:
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0098:
            r8.setUpInfo((com.alipay.mobile.nebula.appcenter.model.AppRes) r0, (boolean) r1, (boolean) r1)     // Catch:{ Exception -> 0x009c }
            return
        L_0x009c:
            r9 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "Exception:"
            com.alipay.mobile.nebula.util.H5Log.e(r0, r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.service.NebulaAppCenterServiceImpl.loadPresetAppList(java.io.InputStream):void");
    }

    public H5AppDBService getAppDBService() {
        return H5NebulaDBService.getInstance();
    }

    public H5BaseApp getH5App() {
        return new H5App();
    }

    public String getSDKVersion() {
        return SDK_VERSION;
    }

    public void loadPresetApp(List<H5PreSetPkgInfo> list) {
        h5PreSetPkgInfoList = list;
    }

    public void loadPresetAppNow(List<H5PreSetPkgInfo> list, H5LoadPresetListen h5LoadPresetListen) {
        for (H5PreSetPkgInfo next : list) {
            if (next != null && next.getInputStream() != null && !TextUtils.isEmpty(next.getAppId()) && !TextUtils.isEmpty(next.getVersion())) {
                H5App h5App = new H5App();
                AppInfo appInfo = new AppInfo();
                appInfo.app_id = next.getAppId();
                appInfo.version = next.getVersion();
                appInfo.package_url = next.getDownloadUrl();
                h5App.setAppInfo(appInfo);
                h5App.presetApp(next.getInputStream(), h5LoadPresetListen);
            }
        }
    }

    public void setUpInfo(AppRes appRes, boolean z) {
        setUpInfo(appRes, z, true);
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2) {
        setUpInfo(appRes, z, z2, false);
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3) {
        setUpInfo(appRes, z, z2, z3, (String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean enableLock() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_enable_lock"));
    }

    public void setUpInfo(AppRes appRes, boolean z, boolean z2, boolean z3, String str) {
        if (enableLock()) {
            setUpInfoLock(appRes, z, z2, z3, str);
        } else {
            setUpInfoNotLock(appRes, z, z2, z3, str);
        }
    }

    private synchronized void setUpInfoLock(AppRes appRes, boolean z, boolean z2, boolean z3, String str) {
        _setUpInfo(appRes, z, z2, z3, str);
    }

    private void setUpInfoNotLock(AppRes appRes, boolean z, boolean z2, boolean z3, String str) {
        _setUpInfo(appRes, z, z2, z3, str);
    }

    /* access modifiers changed from: package-private */
    public boolean enablePutConfigOne() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_saveDBConfig"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x022a A[Catch:{ all -> 0x02a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _setUpInfo(com.alipay.mobile.nebula.appcenter.model.AppRes r17, boolean r18, boolean r19, boolean r20, java.lang.String r21) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            java.lang.String r0 = "et"
            java.lang.String r1 = "pr"
            java.lang.String r2 = "limitReqRate"
            java.lang.String r3 = "lr"
            java.lang.String r4 = "updateReqRate"
            java.lang.String r5 = "ur"
            java.lang.String r6 = "appPoolLimit"
            java.lang.String r9 = "al"
            java.lang.String r10 = "expireTime"
            java.lang.String r11 = "preReqRate"
            if (r8 == 0) goto L_0x0366
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r12 = r7.h5AppDBService
            if (r12 != 0) goto L_0x0022
            goto L_0x0366
        L_0x0022:
            long r12 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.String, java.lang.Object> r14 = r8.config
            if (r14 == 0) goto L_0x0208
            if (r18 != 0) goto L_0x003e
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r14 = r7.h5AppDBService     // Catch:{ Exception -> 0x0200 }
            boolean r14 = r14.hasSetConfig()     // Catch:{ Exception -> 0x0200 }
            if (r14 != 0) goto L_0x0035
            goto L_0x003e
        L_0x0035:
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x0200 }
            java.lang.String r1 = " has set Preset App not add to db config"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ Exception -> 0x0200 }
            goto L_0x0208
        L_0x003e:
            java.util.Map<java.lang.String, java.lang.Object> r14 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r14 = r14.get(r9)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r15 = ""
            if (r14 == 0) goto L_0x0053
            java.util.Map<java.lang.String, java.lang.Object> r14 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r9 = r14.get(r9)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0200 }
            goto L_0x0054
        L_0x0053:
            r9 = r15
        L_0x0054:
            java.util.Map<java.lang.String, java.lang.Object> r14 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r14 = r14.get(r6)     // Catch:{ Exception -> 0x0200 }
            if (r14 == 0) goto L_0x0066
            java.util.Map<java.lang.String, java.lang.Object> r9 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r6 = r9.get(r6)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x0200 }
        L_0x0066:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x0200 }
            if (r6 == 0) goto L_0x0079
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0200 }
            goto L_0x007a
        L_0x0079:
            r5 = r15
        L_0x007a:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x0200 }
            if (r6 == 0) goto L_0x008c
            java.util.Map<java.lang.String, java.lang.Object> r5 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0200 }
        L_0x008c:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x009f
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0200 }
            goto L_0x00a0
        L_0x009f:
            r3 = r15
        L_0x00a0:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x00b2
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0200 }
        L_0x00b2:
            com.alibaba.a.e r2 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0200 }
            r2.<init>()     // Catch:{ Exception -> 0x0200 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x00ca
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0200 }
            goto L_0x00cb
        L_0x00ca:
            r1 = r15
        L_0x00cb:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r11)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x00dd
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0200 }
        L_0x00dd:
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x00e7
            r2.put((java.lang.String) r11, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0200 }
            goto L_0x00ea
        L_0x00e7:
            r2.put((java.lang.String) r11, (java.lang.Object) r15)     // Catch:{ Exception -> 0x0200 }
        L_0x00ea:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x00fd
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0200 }
            goto L_0x00fe
        L_0x00fd:
            r0 = r15
        L_0x00fe:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r4 = r4.get(r10)     // Catch:{ Exception -> 0x0200 }
            if (r4 == 0) goto L_0x0110
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.config     // Catch:{ Exception -> 0x0200 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0200 }
        L_0x0110:
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x011a
            r2.put((java.lang.String) r10, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0200 }
            goto L_0x011d
        L_0x011a:
            r2.put((java.lang.String) r10, (java.lang.Object) r15)     // Catch:{ Exception -> 0x0200 }
        L_0x011d:
            boolean r0 = r16.enablePutConfigOne()     // Catch:{ Exception -> 0x0200 }
            if (r0 == 0) goto L_0x0178
            com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean r0 = new com.alipay.mobile.nebulaappcenter.dbbean.H5AppConfigBean     // Catch:{ Exception -> 0x0200 }
            r0.<init>()     // Catch:{ Exception -> 0x0200 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x0136
            int r4 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0200 }
            r0.setApp_pool_limit(r4)     // Catch:{ Exception -> 0x0200 }
            goto L_0x013a
        L_0x0136:
            r4 = 0
            r0.setApp_pool_limit(r4)     // Catch:{ Exception -> 0x01fe }
        L_0x013a:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x0148
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x0200 }
            r0.setNormalReqRate(r10)     // Catch:{ Exception -> 0x0200 }
            goto L_0x014d
        L_0x0148:
            r10 = 0
            r0.setNormalReqRate(r10)     // Catch:{ Exception -> 0x0200 }
        L_0x014d:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x015b
            double r10 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x0200 }
            r0.setLimitReqRate(r10)     // Catch:{ Exception -> 0x0200 }
            goto L_0x0160
        L_0x015b:
            r10 = 0
            r0.setLimitReqRate(r10)     // Catch:{ Exception -> 0x0200 }
        L_0x0160:
            boolean r4 = r2.isEmpty()     // Catch:{ Exception -> 0x0200 }
            if (r4 != 0) goto L_0x016e
            java.lang.String r2 = r2.toJSONString()     // Catch:{ Exception -> 0x0200 }
            r0.setExtra(r2)     // Catch:{ Exception -> 0x0200 }
            goto L_0x0171
        L_0x016e:
            r0.setExtra(r15)     // Catch:{ Exception -> 0x0200 }
        L_0x0171:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r2 = r7.h5AppDBService     // Catch:{ Exception -> 0x0200 }
            r2.createOrUpdateConfig(r0)     // Catch:{ Exception -> 0x0200 }
            r4 = 0
            goto L_0x01d2
        L_0x0178:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0200 }
            if (r0 != 0) goto L_0x0189
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x0200 }
            int r4 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0200 }
            r0.createOrUpdateAppPoolLimit(r4)     // Catch:{ Exception -> 0x0200 }
            r4 = 0
            goto L_0x018f
        L_0x0189:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x0200 }
            r4 = 0
            r0.createOrUpdateAppPoolLimit(r4)     // Catch:{ Exception -> 0x01fe }
        L_0x018f:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01fe }
            if (r0 != 0) goto L_0x019f
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x01fe }
            r0.createOrUpdateNormalReqRate(r10)     // Catch:{ Exception -> 0x01fe }
            goto L_0x01a6
        L_0x019f:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            r10 = 0
            r0.createOrUpdateNormalReqRate(r10)     // Catch:{ Exception -> 0x01fe }
        L_0x01a6:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01fe }
            if (r0 != 0) goto L_0x01b6
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            double r10 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x01fe }
            r0.createOrUpdateLimitReqRate(r10)     // Catch:{ Exception -> 0x01fe }
            goto L_0x01bd
        L_0x01b6:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            r10 = 0
            r0.createOrUpdateLimitReqRate(r10)     // Catch:{ Exception -> 0x01fe }
        L_0x01bd:
            boolean r0 = r2.isEmpty()     // Catch:{ Exception -> 0x01fe }
            if (r0 != 0) goto L_0x01cd
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            java.lang.String r2 = r2.toJSONString()     // Catch:{ Exception -> 0x01fe }
            r0.createOrUpdateExtra(r2)     // Catch:{ Exception -> 0x01fe }
            goto L_0x01d2
        L_0x01cd:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService     // Catch:{ Exception -> 0x01fe }
            r0.createOrUpdateExtra(r15)     // Catch:{ Exception -> 0x01fe }
        L_0x01d2:
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x01fe }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fe }
            java.lang.String r6 = "appPoolLimit "
            r2.<init>(r6)     // Catch:{ Exception -> 0x01fe }
            r2.append(r9)     // Catch:{ Exception -> 0x01fe }
            java.lang.String r6 = " updateReqRate:"
            r2.append(r6)     // Catch:{ Exception -> 0x01fe }
            r2.append(r5)     // Catch:{ Exception -> 0x01fe }
            java.lang.String r5 = " limitReqRate:"
            r2.append(r5)     // Catch:{ Exception -> 0x01fe }
            r2.append(r3)     // Catch:{ Exception -> 0x01fe }
            java.lang.String r3 = " preReqRate:"
            r2.append(r3)     // Catch:{ Exception -> 0x01fe }
            r2.append(r1)     // Catch:{ Exception -> 0x01fe }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x01fe }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ Exception -> 0x01fe }
            goto L_0x0209
        L_0x01fe:
            r0 = move-exception
            goto L_0x0202
        L_0x0200:
            r0 = move-exception
            r4 = 0
        L_0x0202:
            java.lang.String r1 = TAG
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
            goto L_0x0209
        L_0x0208:
            r4 = 0
        L_0x0209:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r0)
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r0 = r8.data
            java.lang.String r10 = "H5NebulaAppDBCost"
            if (r0 == 0) goto L_0x02ab
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r0 = r8.data
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x02ab
            r0 = 0
        L_0x0220:
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = r8.data     // Catch:{ all -> 0x02a2 }
            int r1 = r1.size()     // Catch:{ all -> 0x02a2 }
            int r1 = r1 + -1
            if (r0 > r1) goto L_0x02ab
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = r8.data     // Catch:{ all -> 0x02a2 }
            if (r1 == 0) goto L_0x029e
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = r8.data     // Catch:{ all -> 0x02a2 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x02a2 }
            if (r1 == 0) goto L_0x029e
            java.util.List<com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = r8.data     // Catch:{ all -> 0x02a2 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x02a2 }
            r11 = r1
            com.alipay.mobile.nebula.appcenter.model.AppInfo r11 = (com.alipay.mobile.nebula.appcenter.model.AppInfo) r11     // Catch:{ all -> 0x02a2 }
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02a2 }
            if (r18 != 0) goto L_0x0272
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r1 = r7.h5AppDBService     // Catch:{ all -> 0x02a2 }
            java.lang.String r2 = r11.app_id     // Catch:{ all -> 0x02a2 }
            java.lang.String r3 = r11.version     // Catch:{ all -> 0x02a2 }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r1 = r1.getAppInfo(r2, r3)     // Catch:{ all -> 0x02a2 }
            if (r1 != 0) goto L_0x0252
            goto L_0x0272
        L_0x0252:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x02a2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
            java.lang.String r3 = " has set Preset App not add to db data"
            r2.<init>(r3)     // Catch:{ all -> 0x02a2 }
            java.lang.String r3 = r11.app_id     // Catch:{ all -> 0x02a2 }
            r2.append(r3)     // Catch:{ all -> 0x02a2 }
            java.lang.String r3 = " version:"
            r2.append(r3)     // Catch:{ all -> 0x02a2 }
            java.lang.String r3 = r11.version     // Catch:{ all -> 0x02a2 }
            r2.append(r3)     // Catch:{ all -> 0x02a2 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02a2 }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)     // Catch:{ all -> 0x02a2 }
            goto L_0x0280
        L_0x0272:
            r1 = r16
            r2 = r11
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r1.setUpInfo((com.alipay.mobile.nebula.appcenter.model.AppInfo) r2, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.String) r6)     // Catch:{ all -> 0x02a2 }
        L_0x0280:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
            r1.<init>()     // Catch:{ all -> 0x02a2 }
            java.lang.String r2 = r11.app_id     // Catch:{ all -> 0x02a2 }
            r1.append(r2)     // Catch:{ all -> 0x02a2 }
            java.lang.String r2 = " setUpInfo cost"
            r1.append(r2)     // Catch:{ all -> 0x02a2 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02a2 }
            long r2 = r2 - r14
            r1.append(r2)     // Catch:{ all -> 0x02a2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02a2 }
            com.alipay.mobile.nebula.util.H5Log.d(r10, r1)     // Catch:{ all -> 0x02a2 }
        L_0x029e:
            int r0 = r0 + 1
            goto L_0x0220
        L_0x02a2:
            r0 = move-exception
            java.lang.String r1 = TAG     // Catch:{ all -> 0x02a9 }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02a9 }
            goto L_0x02ab
        L_0x02a9:
            r0 = move-exception
            throw r0
        L_0x02ab:
            java.util.List<java.lang.String> r0 = r8.removeAppIdList
            if (r0 == 0) goto L_0x0331
            java.util.List<java.lang.String> r0 = r8.removeAppIdList
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0331
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r0 = r7.h5AppDBService
            java.util.Map r0 = r0.getAllApp()
            if (r0 == 0) goto L_0x0331
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0331
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x02cd:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0331
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02cd
            java.util.List<java.lang.String> r2 = r8.removeAppIdList
            java.lang.Object r3 = r1.getKey()
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x02cd
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x02cd
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x02cd
            java.util.Iterator r1 = r1.iterator()
        L_0x0303:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02cd
            java.lang.Object r2 = r1.next()
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = (com.alipay.mobile.nebula.appcenter.model.AppInfo) r2
            com.alipay.mobile.nebulaappcenter.app.H5App r3 = new com.alipay.mobile.nebulaappcenter.app.H5App
            r3.<init>()
            if (r2 == 0) goto L_0x0303
            r3.setAppInfo(r2)
            java.lang.String r4 = r3.getDownloadLocalPath()
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r4)
            java.lang.String r3 = r3.getInstalledPath()
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r3)
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r3 = r7.h5AppDBService
            java.lang.String r4 = r2.app_id
            java.lang.String r2 = r2.version
            r3.deleteAppInfo(r4, r2)
            goto L_0x0303
        L_0x0331:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "AppRes total cost"
            r0.<init>(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r12
            r0.append(r1)
            java.lang.String r1 = " setAppConfig:"
            r0.append(r1)
            long r1 = r9.longValue()
            long r1 = r1 - r12
            r0.append(r1)
            java.lang.String r1 = " setAllAppInfo:"
            r0.append(r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r9.longValue()
            long r1 = r1 - r3
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r10, r0)
            return
        L_0x0366:
            java.lang.String r0 = TAG
            java.lang.String r1 = "appRes==null"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.service.NebulaAppCenterServiceImpl._setUpInfo(com.alipay.mobile.nebula.appcenter.model.AppRes, boolean, boolean, boolean, java.lang.String):void");
    }

    public void setUpInfo(AppInfo appInfo, boolean z) {
        setUpInfo(appInfo, z, true);
    }

    public void setUpInfo(AppInfo appInfo, boolean z, boolean z2) {
        setUpInfo(appInfo, z, z2, false);
    }

    public void setUpInfo(AppInfo appInfo, boolean z, boolean z2, boolean z3) {
        setUpInfo(appInfo, z, z2, z3, (String) null);
    }

    public void clearAppAmrPackage() {
        Map<String, AppInfo> allHighestAppInfo = this.h5AppDBService.getAllHighestAppInfo();
        if (allHighestAppInfo == null || allHighestAppInfo.isEmpty()) {
            H5Log.d(TAG, "allHigAppInfoMap == null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, AppInfo> value : allHighestAppInfo.entrySet()) {
            AppInfo appInfo = (AppInfo) value.getValue();
            if (appInfo != null) {
                H5App h5App = new H5App();
                h5App.setAppInfo(appInfo);
                arrayList.add(h5App.getDownloadLocalPath());
            }
        }
        String defaultDownloadDir = H5DownloadRequest.getDefaultDownloadDir(H5Utils.getContext());
        if (arrayList.size() == 0 || TextUtils.isEmpty(defaultDownloadDir) || !defaultDownloadDir.contains(H5DownloadRequest.nebulaDownload)) {
            H5Log.d(TAG, "empty return, downloadAmrPath : ".concat(String.valueOf(defaultDownloadDir)));
            return;
        }
        File file = new File(defaultDownloadDir);
        if (!file.isDirectory()) {
            H5Log.d(TAG, defaultDownloadDir + " downloadDirectory is not Directory");
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File absolutePath : listFiles) {
                arrayList2.add(absolutePath.getAbsolutePath());
            }
            if (arrayList2.size() != 0) {
                for (String str : arrayList2) {
                    if (!arrayList.contains(str)) {
                        H5Log.d(TAG, "delete amr : ".concat(String.valueOf(str)));
                        H5FileUtil.delete(str);
                    }
                }
            }
        }
    }

    public void clearAppUnzipPackage(long j) {
        File[] listFiles;
        String installPath = H5AppGlobal.getInstallPath(H5AppGlobal.INSTALL_APP_PATH);
        if (!TextUtils.isEmpty(installPath)) {
            ArrayList<String> arrayList = new ArrayList<>();
            File file = new File(installPath);
            if (!file.isDirectory()) {
                H5Log.d(TAG, installPath + " installDirectory is not Directory");
                return;
            }
            File[] listFiles2 = file.listFiles();
            if (listFiles2 != null && listFiles2.length != 0) {
                for (File file2 : listFiles2) {
                    if (!(file2 == null || !file2.isDirectory() || (listFiles = file2.listFiles()) == null)) {
                        if (listFiles.length > 1) {
                            File file3 = listFiles[0];
                            for (int i2 = 1; i2 < listFiles.length; i2++) {
                                File file4 = listFiles[i2];
                                if (!(file4 == null || file3 == null)) {
                                    String absolutePath = file4.lastModified() > file3.lastModified() ? file3.getAbsolutePath() : file4.getAbsolutePath();
                                    H5Log.d(TAG, "deleteInstallList add : ".concat(String.valueOf(absolutePath)));
                                    arrayList.add(absolutePath);
                                    if (file4.lastModified() > file3.lastModified()) {
                                        file3 = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    H5Log.d(TAG, "deleteInstallList is Empty");
                    return;
                }
                for (String str : arrayList) {
                    H5Log.d(TAG, "delete installPkg : ".concat(String.valueOf(str)));
                    H5FileUtil.delete(str);
                }
            }
        }
    }

    private void setUpInfo(AppInfo appInfo, boolean z, boolean z2, boolean z3, String str) {
        if (enableLock()) {
            setUpInfoWithLoc(appInfo, z, z2, z3, str);
        } else {
            setUpInfoNotLoc(appInfo, z, z2, z3, str);
        }
    }

    private synchronized void setUpInfoWithLoc(AppInfo appInfo, boolean z, boolean z2, boolean z3, String str) {
        _setUpInfo(appInfo, z, z2, z3, str);
    }

    private void setUpInfoNotLoc(AppInfo appInfo, boolean z, boolean z2, boolean z3, String str) {
        _setUpInfo(appInfo, z, z2, z3, str);
    }

    private void _setUpInfo(AppInfo appInfo, boolean z, boolean z2, boolean z3, String str) {
        if (appInfo == null) {
            H5Log.e(TAG, "appInfo == null return");
            return;
        }
        List<H5NebulaAppBean> canDeleteAppPooIdList = this.h5AppDBService.getCanDeleteAppPooIdList(appInfo.app_id);
        int appPoolLimit = this.h5AppDBService.getAppPoolLimit();
        if (!(canDeleteAppPooIdList == null || canDeleteAppPooIdList.isEmpty() || appPoolLimit == 0)) {
            while (canDeleteAppPooIdList != null && !canDeleteAppPooIdList.isEmpty() && canDeleteAppPooIdList.size() >= appPoolLimit) {
                String str2 = TAG;
                H5Log.d(str2, "getCanDeleteAppPooIdList size:" + canDeleteAppPooIdList.size() + " limit:" + appPoolLimit);
                H5NebulaAppBean h5NebulaAppBean = canDeleteAppPooIdList.get(0);
                H5App h5App = new H5App();
                if (h5NebulaAppBean != null) {
                    if (H5LoadingApp.contain(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion())) {
                        H5Log.d(TAG, "H5LoadingApp contain this not delete");
                    } else {
                        H5Log.d("deleteAppInfo:" + h5NebulaAppBean.getApp_id() + " version:" + h5NebulaAppBean.getVersion());
                        AppInfo appInfo2 = new AppInfo();
                        appInfo2.app_id = h5NebulaAppBean.getApp_id();
                        appInfo2.version = h5NebulaAppBean.getVersion();
                        appInfo2.package_url = h5NebulaAppBean.getPackage_url();
                        h5App.setAppInfo(appInfo2);
                        H5FileUtil.delete(h5App.getDownloadedFilePath());
                        H5FileUtil.delete(h5App.getInstalledPath());
                        this.h5AppDBService.deleteAppInfo(h5NebulaAppBean.getApp_id(), h5NebulaAppBean.getVersion());
                    }
                }
                canDeleteAppPooIdList.remove(0);
            }
        }
        this.h5AppDBService.saveAppInfo(appInfo, z);
        List<H5PreSetPkgInfo> list = h5PreSetPkgInfoList;
        if (list != null && !list.isEmpty()) {
            for (H5PreSetPkgInfo next : h5PreSetPkgInfoList) {
                if (next != null && next.getInputStream() != null && TextUtils.equals(next.getAppId(), appInfo.app_id) && TextUtils.equals(next.getVersion(), appInfo.version)) {
                    String str3 = TAG;
                    H5Log.d(str3, "set h5PreSetPkgInfo appId:" + appInfo.app_id + " version:" + appInfo.version);
                    presetAppPackagePath(next.getInputStream(), appInfo, next.getForceSync());
                }
            }
        }
        String str4 = TAG;
        H5Log.d(str4, "downApp:" + appInfo.app_id + " version:" + appInfo.version + " auto_install:" + appInfo.auto_install + " downLoadAmr:" + z2 + " downloadRandom " + z3);
        if (H5AppUtil.downloadH5App(appInfo)) {
            if (z2) {
                if (!z3) {
                    downLoadApp(appInfo, str);
                    return;
                }
                try {
                    H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                    if (h5ConfigProvider != null) {
                        String configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5_download_app_delayTime");
                        if (!TextUtils.isEmpty(configWithProcessCache)) {
                            long random = (long) (Math.random() * ((double) Integer.parseInt(configWithProcessCache)));
                            H5Utils.getScheduledExecutor().schedule(new H5TimeTask(appInfo, random), random, TimeUnit.SECONDS);
                            return;
                        }
                    }
                    downLoadApp(appInfo, str);
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        } else if (appInfo.auto_install == 0) {
            H5WifiDownloadList.put(appInfo.app_id, appInfo.version);
            String str5 = TAG;
            H5Log.d(str5, "not in wifi save data to H5WifiDownloadList" + appInfo.app_id + " " + appInfo.version);
        }
    }

    public class H5TimeTask implements Runnable {
        private AppInfo appInfo;
        private long currentTime = System.currentTimeMillis();

        public H5TimeTask(AppInfo appInfo2, long j) {
            String access$200 = NebulaAppCenterServiceImpl.TAG;
            H5Log.d(access$200, "H5TimeTask set appInfo:" + appInfo2.app_id + " " + appInfo2.version + " delayTime " + j);
            this.appInfo = appInfo2;
        }

        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - this.currentTime;
            String access$200 = NebulaAppCenterServiceImpl.TAG;
            H5Log.d(access$200, "H5TimeTask begin download app " + this.appInfo.app_id + " " + this.appInfo.version + " " + (currentTimeMillis / 1000));
            NebulaAppCenterServiceImpl.this.downLoadApp(this.appInfo, (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void downLoadApp(AppInfo appInfo, String str) {
        if (appInfo != null) {
            H5App h5App = new H5App();
            h5App.setAppInfo(appInfo);
            h5App.downloadApp((H5DownloadCallback) null, str);
        }
    }

    public void presetAppPackagePath(InputStream inputStream, AppInfo appInfo, boolean z) {
        H5App h5App = new H5App();
        h5App.setAppInfo(appInfo);
        h5App.presetAppPackage(inputStream, z);
    }
}
