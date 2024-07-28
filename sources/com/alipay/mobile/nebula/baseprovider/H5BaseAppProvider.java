package com.alipay.mobile.nebula.baseprovider;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.H5RpcFailResult;
import com.alipay.mobile.nebula.appcenter.api.H5AppInstallListen;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5NebulaAppCacheManager;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebula.appcenter.openapi.H5AppBizHttpProviderImpl;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.provider.H5AppBizRpcProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sendbird.android.constant.StringSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class H5BaseAppProvider implements H5AppProvider {
    public static final String TAG = "H5BaseAppProvider";
    private String config = "h5_enablestablerpc";
    public H5AppBizRpcProvider h5AppBizRpcProvider;
    public H5AppCenterService h5AppCenterService;
    public H5AppDBService h5AppDBService;
    public H5Service h5Service;

    public void getAppFromServerWhenAppIsEmpty(String str) {
    }

    public String getWalletAppDesc(String str) {
        return null;
    }

    public String getWalletAppName(String str) {
        return null;
    }

    public String getWalletConfigNebulaVersion(String str) {
        return null;
    }

    public String getWalletDownloadPkgUrl(String str) {
        return null;
    }

    public String getWalletIconUrl(String str) {
        return null;
    }

    public String getWalletVersion(String str) {
        return null;
    }

    public boolean isNebulaApp(String str) {
        return true;
    }

    public boolean isOffline(String str) {
        return false;
    }

    public boolean isResourceApp(String str) {
        return false;
    }

    public void offlineFromOpenPlat(String str) {
    }

    public abstract AppReq setReq(AppReq appReq);

    public void showOfflinePage(String str, Bundle bundle) {
    }

    public Map<String, String> syncAppManage() {
        return null;
    }

    public H5BaseAppProvider() {
        b.a();
        this.h5AppCenterService = (H5AppCenterService) c.a(H5AppCenterService.class.getName());
        H5AppCenterService h5AppCenterService2 = this.h5AppCenterService;
        if (h5AppCenterService2 != null) {
            this.h5AppDBService = h5AppCenterService2.getAppDBService();
        }
        b.a();
        this.h5Service = (H5Service) c.a(H5Service.class.getName());
        H5Service h5Service2 = this.h5Service;
        if (h5Service2 != null) {
            this.h5AppBizRpcProvider = (H5AppBizRpcProvider) h5Service2.getProviderManager().getProvider(H5AppBizRpcProvider.class.getName());
        }
        if (this.h5AppBizRpcProvider == null) {
            H5Log.e(TAG, "h5AppBizRpcProvider == null use H5AppBizHttpProviderImpl");
            this.h5AppBizRpcProvider = new H5AppBizHttpProviderImpl();
        }
    }

    public void updateApp(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3) {
        updateAppWithReq(map, z, h5AppInstallProcess, z2, z3, (AppReq) null);
    }

    public void startUpdateApp(Map<String, String> map, H5AppInstallProcess h5AppInstallProcess) {
        updateApp(map, true, h5AppInstallProcess, true, false);
    }

    public void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq) {
        updateAppWithReq(map, z, h5AppInstallProcess, z2, z3, appReq, false);
    }

    public void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq, boolean z4) {
        updateAppWithReq(map, z, h5AppInstallProcess, z2, z3, appReq, z4, (List<String>) null);
    }

    public void updateAppWithReq(Map<String, String> map, boolean z, H5AppInstallProcess h5AppInstallProcess, boolean z2, boolean z3, AppReq appReq, boolean z4, List<String> list) {
        boolean z5;
        ThreadPoolExecutor threadPoolExecutor;
        H5AppInstallProcess h5AppInstallProcess2 = h5AppInstallProcess;
        try {
            if (this.h5Service != null) {
                final long currentTimeMillis = System.currentTimeMillis();
                if (z3) {
                    threadPoolExecutor = H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY);
                } else {
                    threadPoolExecutor = H5Utils.getExecutor(H5ThreadType.RPC);
                }
                final Map<String, String> map2 = map;
                final boolean z6 = z;
                final H5AppInstallProcess h5AppInstallProcess3 = h5AppInstallProcess;
                final boolean z7 = z2;
                final boolean z8 = z3;
                final AppReq appReq2 = appReq;
                final boolean z9 = z4;
                AnonymousClass1 r14 = r1;
                final List<String> list2 = list;
                AnonymousClass1 r1 = new Runnable() {
                    public void run() {
                        H5BaseAppProvider.this.updateAppWithReqFinally(map2, z6, h5AppInstallProcess3, z7, z8, appReq2, z9, Long.valueOf(currentTimeMillis), list2);
                    }
                };
                threadPoolExecutor.execute(r14);
            } else if (h5AppInstallProcess2 != null) {
                z5 = false;
                try {
                    h5AppInstallProcess2.onResult(false, false);
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z5 = false;
            if (h5AppInstallProcess2 != null) {
                h5AppInstallProcess2.onResult(z5, z5);
            }
            H5Log.e(TAG, th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03ce, code lost:
        r0 = r0.getConfig(r1.config);
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027c A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x031f A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x034a A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0401 A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x04e6 A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }, LOOP:9: B:226:0x04e0->B:228:0x04e6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x050f A[SYNTHETIC, Splitter:B:231:0x050f] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x053d A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0544 A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0075 A[SYNTHETIC, Splitter:B:29:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9 A[Catch:{ Exception -> 0x03a2, all -> 0x0010 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alipay.mobile.nebula.appcenter.model.AppReq makeAppReq(java.util.Map<java.lang.String, java.lang.String> r26, boolean r27, com.alipay.mobile.nebula.appcenter.model.AppReq r28, java.util.List<java.lang.String> r29) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r0 = r29
            java.lang.String r4 = "H5BaseAppProvider"
            if (r28 != 0) goto L_0x0013
            com.alipay.mobile.nebula.appcenter.model.AppReq r5 = new com.alipay.mobile.nebula.appcenter.model.AppReq     // Catch:{ all -> 0x0010 }
            r5.<init>()     // Catch:{ all -> 0x0010 }
            goto L_0x0015
        L_0x0010:
            r0 = move-exception
            goto L_0x0582
        L_0x0013:
            r5 = r28
        L_0x0015:
            r6 = 2
            r7 = 1
            if (r2 != 0) goto L_0x001c
            r5.openPlatReqMode = r7     // Catch:{ all -> 0x0010 }
            goto L_0x001e
        L_0x001c:
            r5.openPlatReqMode = r6     // Catch:{ all -> 0x0010 }
        L_0x001e:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0010 }
            r8.<init>()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x002e
            int r9 = r29.size()     // Catch:{ all -> 0x0010 }
            if (r9 <= 0) goto L_0x002e
            r8.addAll(r0)     // Catch:{ all -> 0x0010 }
        L_0x002e:
            java.lang.String r9 = ""
            if (r2 == 0) goto L_0x0054
            int r0 = r26.size()     // Catch:{ all -> 0x0010 }
            if (r0 != r7) goto L_0x0054
            java.util.Set r0 = r26.entrySet()     // Catch:{ all -> 0x0010 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
            r10 = r9
        L_0x0041:
            boolean r11 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r11 == 0) goto L_0x0055
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0010 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0010 }
            java.lang.Object r10 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0010 }
            goto L_0x0041
        L_0x0054:
            r10 = r9
        L_0x0055:
            java.lang.String r0 = "invoke rpc queryAppId "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r0.concat(r10)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r5.nbsource     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = "debug"
            boolean r0 = android.text.TextUtils.equals(r0, r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r11 = "no"
            java.lang.String r12 = "YES"
            java.lang.String r13 = "version"
            java.lang.String r14 = "app_id"
            if (r0 == 0) goto L_0x00c9
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r0.<init>()     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x00b3
            boolean r6 = r26.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r6 != 0) goto L_0x00b3
            java.util.Set r2 = r26.entrySet()     // Catch:{ all -> 0x0010 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0010 }
        L_0x008a:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0010 }
            if (r6 == 0) goto L_0x00b3
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0010 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0010 }
            com.alibaba.a.e r8 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r8.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.Object r9 = r6.getKey()     // Catch:{ all -> 0x0010 }
            r8.put((java.lang.String) r14, (java.lang.Object) r9)     // Catch:{ all -> 0x0010 }
            java.lang.Object r9 = r6.getValue()     // Catch:{ all -> 0x0010 }
            r8.put((java.lang.String) r13, (java.lang.Object) r9)     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r6.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0010 }
            r0.put((java.lang.String) r6, (java.lang.Object) r8)     // Catch:{ all -> 0x0010 }
            goto L_0x008a
        L_0x00b3:
            java.lang.String r2 = "dev mode query "
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.concat(r6)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r0.toJSONString()     // Catch:{ all -> 0x0010 }
            r5.query = r0     // Catch:{ all -> 0x0010 }
            r2 = r12
            goto L_0x051a
        L_0x00c9:
            int r0 = r8.size()     // Catch:{ all -> 0x0010 }
            if (r0 <= 0) goto L_0x00f6
            java.util.Iterator r0 = r8.iterator()     // Catch:{ all -> 0x0010 }
        L_0x00d3:
            boolean r15 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r15 == 0) goto L_0x00f6
            java.lang.Object r15 = r0.next()     // Catch:{ all -> 0x0010 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x00f4
            boolean r16 = enableResDegrade()     // Catch:{ all -> 0x0010 }
            if (r16 == 0) goto L_0x00ed
            java.lang.String r7 = "*"
            r2.put(r15, r7)     // Catch:{ all -> 0x0010 }
            goto L_0x00f4
        L_0x00ed:
            java.lang.String r7 = r1.getWalletConfigNebulaVersion(r15)     // Catch:{ all -> 0x0010 }
            r2.put(r15, r7)     // Catch:{ all -> 0x0010 }
        L_0x00f4:
            r7 = 1
            goto L_0x00d3
        L_0x00f6:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider> r0 = com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider r0 = (com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider) r0     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0146
            java.util.Set r0 = r0.getCommonResourceAppList()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0146
            boolean r7 = r0.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r7 != 0) goto L_0x0146
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x0114:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r7 == 0) goto L_0x0146
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0010 }
            boolean r15 = r1.isNebulaApp(r7)     // Catch:{ all -> 0x0010 }
            if (r15 == 0) goto L_0x0114
            if (r2 == 0) goto L_0x0114
            boolean r15 = r2.containsKey(r7)     // Catch:{ all -> 0x0010 }
            if (r15 != 0) goto L_0x0114
            java.lang.String r15 = " add CommonResourceAppList to query "
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = r15.concat(r10)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = r1.getWalletConfigNebulaVersion(r7)     // Catch:{ all -> 0x0010 }
            r2.put(r7, r10)     // Catch:{ all -> 0x0010 }
            r8.add(r7)     // Catch:{ all -> 0x0010 }
            goto L_0x0114
        L_0x0146:
            com.alipay.mobile.h5container.service.H5Service r0 = r1.h5Service     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x01a7
            com.alipay.mobile.h5container.service.H5Service r0 = r1.h5Service     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.common.NebulaCommonManager r0 = r0.getNebulaCommonManager()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x01a7
            java.util.List r0 = r0.getNebulaAppCallbackList()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x01a7
            boolean r7 = r0.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r7 != 0) goto L_0x01a7
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x0162:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r7 == 0) goto L_0x01a7
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.common.NebulaCommonInfo r7 = (com.alipay.mobile.nebula.appcenter.common.NebulaCommonInfo) r7     // Catch:{ all -> 0x0010 }
            java.util.List r7 = r7.getAppIdList()     // Catch:{ all -> 0x0010 }
            if (r7 == 0) goto L_0x0162
            boolean r10 = r7.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r10 != 0) goto L_0x0162
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0010 }
        L_0x017e:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x0010 }
            if (r10 == 0) goto L_0x0162
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x017e
            boolean r15 = r2.containsKey(r10)     // Catch:{ all -> 0x0010 }
            if (r15 != 0) goto L_0x017e
            java.lang.String r15 = " add NebulaCommonInfo to query "
            java.lang.String r3 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r15.concat(r3)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r1.getWalletConfigNebulaVersion(r10)     // Catch:{ all -> 0x0010 }
            r2.put(r10, r3)     // Catch:{ all -> 0x0010 }
            goto L_0x017e
        L_0x01a7:
            com.alipay.mobile.nebula.provider.H5AppBizRpcProvider r0 = r1.h5AppBizRpcProvider     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x057b
            com.alipay.mobile.h5container.service.H5AppCenterService r0 = r1.h5AppCenterService     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x057b
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x01b5
            goto L_0x057b
        L_0x01b5:
            if (r2 == 0) goto L_0x03a7
            boolean r0 = r26.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x03a7
            com.alibaba.a.e r3 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r3.<init>()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            double r17 = r0.getNormalReqRate()     // Catch:{ all -> 0x0010 }
            java.util.Set r0 = r26.entrySet()     // Catch:{ all -> 0x0010 }
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x01d0:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0390
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0010 }
            r10 = r0
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = r10.getKey()     // Catch:{ all -> 0x0010 }
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = r10.getValue()     // Catch:{ all -> 0x0010 }
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r0 = new com.alipay.mobile.nebula.appcenter.model.AppInfo     // Catch:{ all -> 0x0010 }
            r0.<init>()     // Catch:{ all -> 0x0010 }
            r0.app_id = r15     // Catch:{ all -> 0x0010 }
            r0.version = r6     // Catch:{ all -> 0x0010 }
            if (r27 != 0) goto L_0x0323
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            r19 = r7
            com.alipay.mobile.nebula.appcenter.model.AppInfo r7 = r0.getAppInfo(r15, r6)     // Catch:{ all -> 0x0010 }
            if (r7 == 0) goto L_0x0206
            java.lang.String r0 = r7.update_app_time     // Catch:{ all -> 0x0010 }
            r20 = r9
            r9 = r0
            goto L_0x0208
        L_0x0206:
            r20 = r9
        L_0x0208:
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            boolean r0 = r0.rpcIsLimit()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x021c
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            double r17 = r0.getLimitReqRate()     // Catch:{ all -> 0x0010 }
            r21 = r12
        L_0x0218:
            r12 = r3
        L_0x0219:
            r2 = r17
            goto L_0x025b
        L_0x021c:
            com.alibaba.a.e r0 = r1.getlaunchParams((com.alipay.mobile.nebula.appcenter.model.AppInfo) r7)     // Catch:{ all -> 0x0253 }
            if (r0 == 0) goto L_0x023e
            boolean r21 = r0.isEmpty()     // Catch:{ all -> 0x0253 }
            if (r21 != 0) goto L_0x023e
            r21 = r12
            java.lang.String r12 = "asyncReqRate"
            java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r12)     // Catch:{ all -> 0x0251 }
            boolean r22 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0251 }
            if (r22 == 0) goto L_0x0242
            java.lang.String r12 = "ar"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r12)     // Catch:{ all -> 0x0251 }
            r12 = r0
            goto L_0x0242
        L_0x023e:
            r21 = r12
            r12 = r20
        L_0x0242:
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0251 }
            if (r0 != 0) goto L_0x0218
            int r0 = java.lang.Integer.parseInt(r12)     // Catch:{ all -> 0x0251 }
            r12 = r3
            double r2 = (double) r0
            r17 = r2
            goto L_0x0219
        L_0x0251:
            r0 = move-exception
            goto L_0x0256
        L_0x0253:
            r0 = move-exception
            r21 = r12
        L_0x0256:
            r12 = r3
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0010 }
            goto L_0x0219
        L_0x025b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r22 = r12
            java.lang.String r12 = "lastUpdateTime:"
            r0.<init>(r12)     // Catch:{ all -> 0x0010 }
            r0.append(r9)     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = " updateRate:"
            r0.append(r12)     // Catch:{ all -> 0x0010 }
            r0.append(r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x0010 }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x031f
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0010 }
            long r23 = java.lang.Long.parseLong(r9)     // Catch:{ all -> 0x0010 }
            long r17 = r17 - r23
            r23 = 1000(0x3e8, double:4.94E-321)
            long r17 = r17 / r23
            java.lang.Long r0 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r9.<init>()     // Catch:{ all -> 0x0010 }
            r9.append(r15)     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = ":diff(second):"
            r9.append(r12)     // Catch:{ all -> 0x0010 }
            r9.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = " updateRate(second):"
            r9.append(r12)     // Catch:{ all -> 0x0010 }
            r9.append(r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r9)     // Catch:{ all -> 0x0010 }
            r12 = r8
            long r8 = r0.longValue()     // Catch:{ all -> 0x0010 }
            double r8 = (double) r8
            java.lang.String r0 = "appId:"
            int r17 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r17 >= 0) goto L_0x02e3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r6.<init>(r0)     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0010 }
            r6.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = " timeDiff < updateRate, not to add query"
            r6.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x0010 }
            r17 = r2
            r8 = r12
            r7 = r19
            r9 = r20
            r12 = r21
            r3 = r22
            r6 = 2
            r2 = r26
            goto L_0x01d0
        L_0x02e3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r8.<init>(r0)     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0010 }
            r8.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = " match time to add query"
            r8.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x0010 }
            if (r7 == 0) goto L_0x0320
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0010 }
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0320
            java.lang.String r7 = "h5_updateCurrentAppUpdateTime"
            java.lang.String r0 = r0.getConfigWithProcessCache(r7)     // Catch:{ all -> 0x0010 }
            boolean r0 = r11.equalsIgnoreCase(r0)     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x0320
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            r0.updateCurrentAppUpdateTime(r15, r6)     // Catch:{ all -> 0x0010 }
            goto L_0x0320
        L_0x031f:
            r12 = r8
        L_0x0320:
            r17 = r2
            goto L_0x032c
        L_0x0323:
            r22 = r3
            r19 = r7
            r20 = r9
            r21 = r12
            r12 = r8
        L_0x032c:
            com.alibaba.a.e r0 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r0.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.Object r2 = r10.getKey()     // Catch:{ all -> 0x0010 }
            r0.put((java.lang.String) r14, (java.lang.Object) r2)     // Catch:{ all -> 0x0010 }
            java.lang.Object r2 = r10.getValue()     // Catch:{ all -> 0x0010 }
            r0.put((java.lang.String) r13, (java.lang.Object) r2)     // Catch:{ all -> 0x0010 }
            java.lang.Object r2 = r10.getKey()     // Catch:{ all -> 0x0010 }
            r3 = r12
            boolean r2 = r3.contains(r2)     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x0378
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = "add query resource : "
            r2.<init>(r6)     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0010 }
            r2.append(r6)     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = "version : "
            r2.append(r6)     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r10.getValue()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0010 }
            r2.append(r6)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "t"
            java.lang.String r6 = "res"
            r0.put((java.lang.String) r2, (java.lang.Object) r6)     // Catch:{ all -> 0x0010 }
        L_0x0378:
            java.lang.Object r2 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0010 }
            r6 = r22
            r6.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ all -> 0x0010 }
            r2 = r26
            r8 = r3
            r3 = r6
            r7 = r19
            r9 = r20
            r12 = r21
            r6 = 2
            goto L_0x01d0
        L_0x0390:
            r6 = r3
            r20 = r9
            r21 = r12
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x03ab
            java.lang.String r0 = r6.toJSONString()     // Catch:{ Exception -> 0x03a2 }
            r5.query = r0     // Catch:{ Exception -> 0x03a2 }
            goto L_0x03ab
        L_0x03a2:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0010 }
            goto L_0x03ab
        L_0x03a7:
            r20 = r9
            r21 = r12
        L_0x03ab:
            if (r26 == 0) goto L_0x03c0
            boolean r0 = r26.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x03c0
            java.lang.String r0 = r5.query     // Catch:{ all -> 0x0010 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x03c0
            r2 = r21
            r0 = 0
            goto L_0x051b
        L_0x03c0:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x03f3 }
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)     // Catch:{ Exception -> 0x03f3 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0     // Catch:{ Exception -> 0x03f3 }
            if (r0 == 0) goto L_0x03de
            java.lang.String r2 = r1.config     // Catch:{ Exception -> 0x03f3 }
            java.lang.String r0 = r0.getConfig(r2)     // Catch:{ Exception -> 0x03f3 }
            if (r0 == 0) goto L_0x03de
            boolean r0 = r11.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x03f3 }
            if (r0 == 0) goto L_0x03de
            r0 = 0
            goto L_0x03df
        L_0x03de:
            r0 = 1
        L_0x03df:
            if (r0 == 0) goto L_0x03f0
            java.lang.String r0 = r5.stableRpc     // Catch:{ Exception -> 0x03f3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03f3 }
            if (r0 == 0) goto L_0x03f0
            r2 = r21
            r5.stableRpc = r2     // Catch:{ Exception -> 0x03ee }
            goto L_0x03f9
        L_0x03ee:
            r0 = move-exception
            goto L_0x03f6
        L_0x03f0:
            r2 = r21
            goto L_0x03f9
        L_0x03f3:
            r0 = move-exception
            r2 = r21
        L_0x03f6:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0010 }
        L_0x03f9:
            java.lang.String r0 = r5.stableRpc     // Catch:{ all -> 0x0010 }
            boolean r0 = android.text.TextUtils.equals(r0, r2)     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x04c5
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            java.util.Map r0 = r0.getAllHighestLocalReportAppVersion()     // Catch:{ all -> 0x0010 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0010 }
            long r8 = r8 - r6
            com.alibaba.a.e r3 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r3.<init>()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0459
            boolean r10 = r0.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r10 != 0) goto L_0x0459
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0010 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x0425:
            boolean r10 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r10 == 0) goto L_0x0459
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0010 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0010 }
            java.lang.Object r12 = r10.getValue()     // Catch:{ all -> 0x0010 }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x0010 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0010 }
            if (r12 != 0) goto L_0x0425
            java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ all -> 0x0010 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0010 }
            if (r12 != 0) goto L_0x0425
            java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0010 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0010 }
            r3.put((java.lang.String) r12, (java.lang.Object) r10)     // Catch:{ all -> 0x0010 }
            goto L_0x0425
        L_0x0459:
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppScoreList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5AppScoreList.getInstance()     // Catch:{ all -> 0x0010 }
            r10 = 2
            java.util.List r0 = r0.getAppListWithStrategy(r10)     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0496
            boolean r10 = r0.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r10 != 0) goto L_0x0496
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x046e:
            boolean r10 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r10 == 0) goto L_0x0496
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = "H5AppScoreList "
            java.lang.String r15 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = r12.concat(r15)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r12)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r12 = r1.getAppInfo(r10)     // Catch:{ all -> 0x0010 }
            if (r12 == 0) goto L_0x0490
            java.lang.String r12 = r12.version     // Catch:{ all -> 0x0010 }
            goto L_0x0492
        L_0x0490:
            r12 = r20
        L_0x0492:
            r3.put((java.lang.String) r10, (java.lang.Object) r12)     // Catch:{ all -> 0x0010 }
            goto L_0x046e
        L_0x0496:
            java.lang.String r0 = "H5NebulaAppRpcTimeCost"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            java.lang.String r12 = "ReadyAppReqInfo getLocalAppInfo cost "
            r10.<init>(r12)     // Catch:{ all -> 0x0010 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0010 }
            long r17 = r17 - r6
            long r6 = r17 - r8
            r10.append(r6)     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = " getAllAppTime: "
            r10.append(r6)     // Catch:{ all -> 0x0010 }
            r10.append(r8)     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r6)     // Catch:{ all -> 0x0010 }
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x04c5
            java.lang.String r0 = r3.toJSONString()     // Catch:{ all -> 0x0010 }
            r5.localAppInfo = r0     // Catch:{ all -> 0x0010 }
        L_0x04c5:
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r1.h5AppDBService     // Catch:{ all -> 0x0010 }
            java.util.Map r0 = r0.getInstalledApp()     // Catch:{ all -> 0x0010 }
            com.alibaba.a.e r3 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r3.<init>()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0509
            boolean r6 = r0.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r6 != 0) goto L_0x0509
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0010 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0010 }
        L_0x04e0:
            boolean r6 = r0.hasNext()     // Catch:{ all -> 0x0010 }
            if (r6 == 0) goto L_0x0509
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x0010 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ all -> 0x0010 }
            com.alibaba.a.e r7 = new com.alibaba.a.e     // Catch:{ all -> 0x0010 }
            r7.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.Object r8 = r6.getKey()     // Catch:{ all -> 0x0010 }
            r7.put((java.lang.String) r14, (java.lang.Object) r8)     // Catch:{ all -> 0x0010 }
            java.lang.Object r8 = r6.getValue()     // Catch:{ all -> 0x0010 }
            r7.put((java.lang.String) r13, (java.lang.Object) r8)     // Catch:{ all -> 0x0010 }
            java.lang.Object r6 = r6.getKey()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0010 }
            r3.put((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0010 }
            goto L_0x04e0
        L_0x0509:
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x051a
            java.lang.String r0 = r3.toJSONString()     // Catch:{ Exception -> 0x0516 }
            r5.existed = r0     // Catch:{ Exception -> 0x0516 }
            goto L_0x051a
        L_0x0516:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0010 }
        L_0x051a:
            r0 = 1
        L_0x051b:
            java.lang.String r3 = "android"
            r5.platform = r3     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getVersion()     // Catch:{ all -> 0x0010 }
            r5.client = r3     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0010 }
            r5.system = r3     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.h5container.service.H5AppCenterService r3 = r1.h5AppCenterService     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r3.getSDKVersion()     // Catch:{ all -> 0x0010 }
            r5.sdk = r3     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.appcenter.model.AppReq r3 = r1.setReq(r5)     // Catch:{ all -> 0x0010 }
            java.lang.String r5 = r3.bundleid     // Catch:{ all -> 0x0010 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x0544
            java.lang.String r0 = "appReq.bundleid is null not send request "
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0010 }
            r2 = 0
            return r2
        L_0x0544:
            java.lang.String r5 = r3.query     // Catch:{ all -> 0x0010 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0010 }
            if (r5 != 0) goto L_0x0572
            r3.preferLocal = r2     // Catch:{ all -> 0x0010 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r2 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0010 }
            java.lang.Object r2 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r2)     // Catch:{ all -> 0x0010 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r2 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r2     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x0572
            java.lang.String r5 = "h5_enablepreferlocal"
            java.lang.String r2 = r2.getConfig(r5)     // Catch:{ all -> 0x0010 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0010 }
            if (r5 != 0) goto L_0x0572
            boolean r2 = r11.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0010 }
            if (r2 == 0) goto L_0x0572
            java.lang.String r2 = "NO"
            r3.preferLocal = r2     // Catch:{ all -> 0x0010 }
        L_0x0572:
            if (r0 == 0) goto L_0x0575
            return r3
        L_0x0575:
            java.lang.String r0 = " timeDiff < updateRate, this req is not send"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x0010 }
            goto L_0x0585
        L_0x057b:
            java.lang.String r0 = "h5AppBizRpcProvider == null."
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0010 }
            r2 = 0
            return r2
        L_0x0582:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)
        L_0x0585:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.baseprovider.H5BaseAppProvider.makeAppReq(java.util.Map, boolean, com.alipay.mobile.nebula.appcenter.model.AppReq, java.util.List):com.alipay.mobile.nebula.appcenter.model.AppReq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008f A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0098 A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d A[Catch:{ all -> 0x00cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateAppWithReqFinally(java.util.Map<java.lang.String, java.lang.String> r17, boolean r18, com.alipay.mobile.nebula.callback.H5AppInstallProcess r19, boolean r20, boolean r21, com.alipay.mobile.nebula.appcenter.model.AppReq r22, boolean r23, java.lang.Long r24, java.util.List<java.lang.String> r25) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r8 = r19
            r9 = 0
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            r12 = 1
            if (r0 == 0) goto L_0x001d
            boolean r1 = r17.isEmpty()     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x0015
            goto L_0x001d
        L_0x0015:
            r1 = r21
            r2 = r22
            r3 = r25
            r6 = 0
            goto L_0x0024
        L_0x001d:
            r1 = r21
            r2 = r22
            r3 = r25
            r6 = 1
        L_0x0024:
            com.alipay.mobile.nebula.appcenter.model.AppReq r2 = r7.makeAppReq(r0, r1, r2, r3)     // Catch:{ all -> 0x00cb }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            java.lang.Long r13 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00cb }
            if (r2 == 0) goto L_0x0043
            r1 = r16
            r3 = r18
            r4 = r20
            r5 = r23
            com.alipay.mobile.nebula.baseprovider.H5BaseAppProvider$H5RpcResult r1 = r1.request(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00cb }
            boolean r2 = r1.success     // Catch:{ all -> 0x00cb }
            boolean r1 = r1.isLimit     // Catch:{ all -> 0x00cb }
            goto L_0x0045
        L_0x0043:
            r1 = 0
            r2 = 0
        L_0x0045:
            java.lang.String r3 = "H5NebulaAppRpcTimeCost"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "Total Cost:"
            r4.<init>(r5)     // Catch:{ all -> 0x00cb }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            long r14 = r24.longValue()     // Catch:{ all -> 0x00cb }
            long r5 = r5 - r14
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = " ThreadBeginExecuteTime:"
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            long r5 = r24.longValue()     // Catch:{ all -> 0x00cb }
            long r5 = r10 - r5
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = " ReadyAppReqInfo "
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            long r5 = r13.longValue()     // Catch:{ all -> 0x00cb }
            long r5 = r5 - r10
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = " Rpc+SaveApp:"
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            long r10 = r13.longValue()     // Catch:{ all -> 0x00cb }
            long r5 = r5 - r10
            r4.append(r5)     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00cb }
            com.alipay.mobile.nebula.util.H5Log.d(r3, r4)     // Catch:{ all -> 0x00cb }
            if (r8 == 0) goto L_0x0096
            com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep r3 = com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep.APP_INSTALL_STEP_ACQUIRE_INFO     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = ""
            r8.prepare(r3, r4)     // Catch:{ all -> 0x00cb }
        L_0x0096:
            if (r8 == 0) goto L_0x009b
            r8.onResult(r2, r1)     // Catch:{ all -> 0x00cb }
        L_0x009b:
            if (r1 == 0) goto L_0x00ca
            com.alipay.mobile.nebula.appcenter.H5AppDBService r1 = r7.h5AppDBService     // Catch:{ all -> 0x00cb }
            r1.setRpcIsLimit(r12)     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00ca
            java.util.Set r0 = r17.entrySet()     // Catch:{ all -> 0x00cb }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00cb }
        L_0x00ac:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00ca
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00cb }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00cb }
            java.lang.Object r2 = r1.getKey()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00cb }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00cb }
            com.alipay.mobile.nebula.appcenter.H5AppDBService r3 = r7.h5AppDBService     // Catch:{ all -> 0x00cb }
            r3.updateCurrentAppUpdateTime(r2, r1)     // Catch:{ all -> 0x00cb }
            goto L_0x00ac
        L_0x00ca:
            return
        L_0x00cb:
            r0 = move-exception
            java.lang.String r1 = "H5BaseAppProvider"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r0)
            if (r8 == 0) goto L_0x00d6
            r8.onResult(r9, r9)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.baseprovider.H5BaseAppProvider.updateAppWithReqFinally(java.util.Map, boolean, com.alipay.mobile.nebula.callback.H5AppInstallProcess, boolean, boolean, com.alipay.mobile.nebula.appcenter.model.AppReq, boolean, java.lang.Long, java.util.List):void");
    }

    class H5RpcResult {
        boolean isLimit;
        boolean success;

        H5RpcResult() {
        }
    }

    private H5RpcResult getRpcResult(boolean z, boolean z2) {
        H5RpcResult h5RpcResult = new H5RpcResult();
        h5RpcResult.isLimit = z2;
        h5RpcResult.success = z;
        return h5RpcResult;
    }

    public H5RpcResult request(AppReq appReq, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            AppRes app = this.h5AppBizRpcProvider.app(appReq);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (app == null) {
                return getRpcResult(false, false);
            }
            if (this.h5AppDBService == null) {
                H5Log.d(TAG, "h5AppDBService init fail.");
                return getRpcResult(false, false);
            } else if (TextUtils.equals("limit", app.rpcFailDes)) {
                return getRpcResult(false, true);
            } else {
                if (this.h5AppDBService.rpcIsLimit()) {
                    this.h5AppDBService.setRpcIsLimit(false);
                }
                if (TextUtils.equals(H5RpcFailResult.RESULT_CODE_NOT_100, app.rpcFailDes)) {
                    return getRpcResult(false, false);
                }
                if (TextUtils.equals(H5RpcFailResult.NOT_LOGIN, app.rpcFailDes)) {
                    return getRpcResult(false, false);
                }
                if (this.h5AppCenterService != null) {
                    this.h5AppCenterService.setUpInfo(app, z, z2, z3, z4 ? H5DownloadRequest.FULL_RPC_SCENE : "");
                    LinkedList linkedList = new LinkedList();
                    for (AppInfo appInfo : app.data) {
                        linkedList.add(appInfo.app_id);
                    }
                    if (app.removeAppIdList != null && !app.removeAppIdList.isEmpty()) {
                        linkedList.addAll(app.removeAppIdList);
                    }
                    H5Utils.setNebulaAppCallback(0, linkedList);
                    H5Log.d("H5NebulaAppRpcTimeCost", "SaveAppTime  cost " + (System.currentTimeMillis() - valueOf.longValue()));
                    return getRpcResult(true, false);
                }
                H5Log.d(TAG, "save db fail.");
                return getRpcResult(false, false);
            }
        } catch (Exception e2) {
            H5Log.e(TAG, "updateApp exception", e2);
            return getRpcResult(false, false);
        }
    }

    public void startUpdateAllApp(H5AppInstallProcess h5AppInstallProcess) {
        updateApp((Map<String, String>) null, true, h5AppInstallProcess, true, false);
    }

    public Map<String, String> getExtra(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            return queryNebulaApp.extend_info;
        }
        return null;
    }

    public String getExtraJo(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            return queryNebulaApp.extend_info_jo;
        }
        return null;
    }

    public String getH5AppCdnBaseUrl(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            return queryNebulaApp.fallback_base_url;
        }
        return null;
    }

    public String getInstallPath(String str, String str2) {
        return getInstallPath(queryNebulaApp(str, str2));
    }

    public String getInstallPath(AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        H5BaseApp h5App = this.h5AppCenterService.getH5App();
        h5App.setAppInfo(appInfo);
        return h5App.getInstalledPath();
    }

    public String getDownloadLocalPath(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp == null) {
            return null;
        }
        H5BaseApp h5App = this.h5AppCenterService.getH5App();
        h5App.setAppInfo(queryNebulaApp);
        return h5App.getDownloadLocalPath();
    }

    public void installApp(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            H5BaseApp h5App = this.h5AppCenterService.getH5App();
            h5App.setAppInfo(queryNebulaApp);
            h5App.installApp();
        }
    }

    public void installApp(String str, String str2, H5AppInstallListen h5AppInstallListen) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            H5BaseApp h5App = this.h5AppCenterService.getH5App();
            h5App.setAppInfo(queryNebulaApp);
            h5App.installApp(h5AppInstallListen);
        }
    }

    public void installApp(String str, String str2, boolean z) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            H5BaseApp h5App = this.h5AppCenterService.getH5App();
            h5App.setAppInfo(queryNebulaApp);
            h5App.installApp(z);
        }
    }

    public void downloadApp(String str, String str2) {
        downloadApp(str, str2, (H5DownloadCallback) null);
    }

    public void downloadApp(String str, String str2, H5DownloadCallback h5DownloadCallback) {
        downloadApp(str, str2, h5DownloadCallback, (String) null);
    }

    public void downloadApp(String str, String str2, H5DownloadCallback h5DownloadCallback, String str3) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            H5BaseApp h5App = this.h5AppCenterService.getH5App();
            h5App.setAppInfo(queryNebulaApp);
            h5App.downloadApp(h5DownloadCallback, str3);
        }
    }

    public boolean isAvailable(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp == null) {
            return false;
        }
        H5BaseApp h5App = this.h5AppCenterService.getH5App();
        h5App.setAppInfo(queryNebulaApp);
        return h5App.isAvailable();
    }

    public boolean isH5App(String str) {
        if (!TextUtils.isEmpty(str) && queryNebulaApp(str, getVersion(str)) != null) {
            return true;
        }
        return false;
    }

    public boolean isInstalled(String str, String str2) {
        return isInstalled(queryNebulaApp(str, str2));
    }

    public boolean isInstalled(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        H5BaseApp h5App = this.h5AppCenterService.getH5App();
        h5App.setAppInfo(appInfo);
        return h5App.isInstalled();
    }

    public boolean hasPackage(String str, String str2) {
        return hasPackage(queryNebulaApp(str, str2));
    }

    public boolean hasPackage(AppInfo appInfo) {
        String str;
        if (appInfo == null) {
            return false;
        }
        H5BaseApp h5App = this.h5AppCenterService.getH5App();
        h5App.setAppInfo(appInfo);
        Uri parseUrl = H5UrlHelper.parseUrl(h5App.getDownloadUrl());
        if (parseUrl == null) {
            str = null;
        } else {
            str = parseUrl.getScheme();
        }
        if ("http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public String getVhost(String str, String str2) {
        H5AppDBService h5AppDBService2 = this.h5AppDBService;
        if (h5AppDBService2 == null) {
            H5Log.d(TAG, "h5AppDBService init fail.");
            return null;
        }
        AppInfo appInfo = h5AppDBService2.getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.vhost;
        }
        return null;
    }

    public AppInfo getAppInfo(String str, String str2) {
        AppInfo queryNebulaApp = queryNebulaApp(str, str2);
        if (queryNebulaApp != null) {
            return queryNebulaApp;
        }
        return null;
    }

    public AppInfo getAppInfo(String str) {
        return getAppInfo(str, getVersion(str));
    }

    public String getVersion(String str) {
        H5AppDBService h5AppDBService2 = this.h5AppDBService;
        if (h5AppDBService2 != null) {
            return h5AppDBService2.getHighestAppVersion(str);
        }
        return null;
    }

    public boolean isAutoInstall(String str, String str2) {
        H5AppDBService h5AppDBService2 = this.h5AppDBService;
        if (h5AppDBService2 == null || h5AppDBService2.getAppInfo(str, str2) == null || this.h5AppDBService.getAppInfo(str, str2).auto_install != 1) {
            return false;
        }
        return true;
    }

    private AppInfo queryNebulaApp(String str, String str2) {
        AppInfo appInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = getVersion(str);
        }
        H5AppDBService h5AppDBService2 = this.h5AppDBService;
        if (h5AppDBService2 == null || (appInfo = h5AppDBService2.getAppInfo(str, str2)) == null) {
            return null;
        }
        return appInfo;
    }

    public String getSubUrl(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.sub_url;
        }
        return null;
    }

    public String getThirdPlatform(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.third_platform;
        }
        return null;
    }

    public long getPackageSize(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.size;
        }
        return 0;
    }

    public boolean isRNApp(String str) {
        return H5AppUtil.isRNApp(getAppInfo(str, getVersion(str)));
    }

    public boolean isXiaoChengXu(String str) {
        H5ConfigProvider h5ConfigProvider;
        com.alibaba.a.b parseArray;
        String appType = H5NebulaAppCacheManager.getAppType(str);
        if ("nebulaH5App".equals(appType) || H5NebulaAppCacheManager.NEBULA_NATIVE_TINY_APP.equals(appType)) {
            return false;
        }
        if ((H5NebulaAppCacheManager.NEBULA_H5TINY_APP.equals(appType) || isH5TinyApp(str)) && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null) {
            String config2 = h5ConfigProvider.getConfig("h5_open_multi_process");
            if (!TextUtils.isEmpty(config2) && (parseArray = H5Utils.parseArray(config2)) != null && !parseArray.isEmpty()) {
                if (parseArray.contains(StringSet.all)) {
                    com.alibaba.a.b parseArray2 = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_open_multi_process_blacklist"));
                    if (parseArray2 == null || parseArray2.isEmpty() || !parseArray2.contains(str)) {
                        return true;
                    }
                    return false;
                } else if (parseArray.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isH5TinyApp(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppInfo appInfo = getAppInfo(str, getVersion(str));
        if (appInfo != null) {
            z = H5Utils.isTinyApp(appInfo);
        }
        H5Log.d(TAG, str + " isH5TinyApp " + z);
        return z;
    }

    public String getAppName(String str) {
        AppInfo appInfo = getAppInfo(str, getVersion(str));
        if (appInfo != null) {
            return appInfo.name;
        }
        return null;
    }

    public String getAppName(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.name;
        }
        return null;
    }

    public String getAppDesc(String str) {
        AppInfo appInfo = getAppInfo(str, getVersion(str));
        if (appInfo != null) {
            return appInfo.app_dsec;
        }
        return null;
    }

    public String getIconUrl(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.icon_url;
        }
        return null;
    }

    public String getIconUrl(String str) {
        AppInfo appInfo = getAppInfo(str, getVersion(str));
        if (appInfo != null) {
            return appInfo.icon_url;
        }
        return null;
    }

    public String getPackageNick(String str) {
        return getPackageNick(str, getVersion(str));
    }

    public String getPackageNick(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        return appInfo != null ? H5Utils.getString(H5Utils.parseObject(appInfo.extend_info_jo), H5AppUtil.package_nick) : "";
    }

    public int getLocalReport(String str, String str2) {
        AppInfo appInfo = this.h5AppDBService.getAppInfo(str, str2);
        if (appInfo != null) {
            return appInfo.localReport;
        }
        return 0;
    }

    public e getlaunchParams(String str) {
        AppInfo appInfo = getAppInfo(str);
        if (appInfo == null) {
            return null;
        }
        return getlaunchParams(appInfo);
    }

    private e getlaunchParams(AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        return H5Utils.getJSONObject(H5Utils.parseObject(appInfo.extend_info_jo), H5Param.LAUNCHER_PARAM, (e) null);
    }

    public String getConfigExtra(String str) {
        e parseObject;
        H5AppCenterService h5AppCenterService2 = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
        if (h5AppCenterService2 == null) {
            return null;
        }
        String configExtra = h5AppCenterService2.getAppDBService().getConfigExtra();
        if (TextUtils.isEmpty(configExtra) || (parseObject = H5Utils.parseObject(configExtra)) == null || parseObject.isEmpty()) {
            return null;
        }
        return H5Utils.getString(parseObject, str);
    }

    public String getScene(String str, String str2) {
        AppInfo appInfo = getAppInfo(str, str2);
        return appInfo != null ? H5Utils.getString(H5Utils.parseObject(appInfo.extend_info_jo), H5AppUtil.scene) : "";
    }

    private static boolean enableResDegrade() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_nbresmode"));
    }

    public boolean enableMultiProcess(String str, Bundle bundle) {
        H5ConfigProvider h5ConfigProvider;
        com.alibaba.a.b parseArray;
        H5ConfigProvider h5ConfigProvider2 = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider2 != null && "no".equalsIgnoreCase(h5ConfigProvider2.getConfigWithProcessCache("h5_enableMultiProcess_new"))) {
            return isXiaoChengXu(str);
        }
        if (H5NebulaAppCacheManager.enableMulti(str, bundle) && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null) {
            String config2 = h5ConfigProvider.getConfig("h5_open_multi_process");
            if (!TextUtils.isEmpty(config2) && (parseArray = H5Utils.parseArray(config2)) != null && !parseArray.isEmpty()) {
                if (parseArray.contains(StringSet.all)) {
                    com.alibaba.a.b parseArray2 = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_open_multi_process_blacklist"));
                    if (parseArray2 == null || parseArray2.isEmpty() || !parseArray2.contains(str)) {
                        return true;
                    }
                    return false;
                } else if (parseArray.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isUseAppX(String str) {
        return H5NebulaAppCacheManager.useAppX(str);
    }
}
