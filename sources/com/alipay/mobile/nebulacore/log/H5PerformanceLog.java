package com.alipay.mobile.nebulacore.log;

import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5JsCallData;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.alipay.mobile.nebulacore.wallet.H5LoggerPlugin;
import java.util.HashMap;
import java.util.Map;

public class H5PerformanceLog implements Runnable {
    private static final String TAG = "H5PerformanceLog";
    private static Boolean sUploadHttp2Stuff;
    private static Boolean sUseUcNetwork;
    private Map<String, String> addToParam4;
    private APWebView apWebView;
    private H5AvailablePageData availablePageData;
    private String bizScenario;
    private Map<String, String> extraJSReport;
    private boolean isOfflineApp;
    private String jsError;
    private H5PageData pageData;
    private Map<String, Object> performanceMap;

    public H5PerformanceLog(H5PageData h5PageData, Map<String, Object> map, Map<String, String> map2, H5AvailablePageData h5AvailablePageData, H5Page h5Page, String str, boolean z, String str2) {
        this.pageData = h5PageData;
        this.performanceMap = map;
        this.extraJSReport = map2;
        this.availablePageData = h5AvailablePageData;
        this.bizScenario = str;
        this.isOfflineApp = z;
        this.jsError = str2;
        if (h5Page != null) {
            this.addToParam4 = new HashMap();
            this.addToParam4.put("type", H5FileUtil.getMimeType(h5Page.getUrl()));
            Map<String, String> map3 = this.addToParam4;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            map3.put("end", sb.toString());
            this.apWebView = h5Page.getWebView();
        }
    }

    /* access modifiers changed from: package-private */
    public void setPerformanceData(String str, Object obj) {
        this.performanceMap.put(str, obj);
    }

    /* access modifiers changed from: package-private */
    public Object getPerformanceData(String str) {
        return this.performanceMap.get(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0166 A[Catch:{ all -> 0x0513 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0167 A[Catch:{ all -> 0x0513 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "YES"
            java.lang.String r3 = " "
            java.lang.String r4 = "pageLoad"
            java.lang.String r5 = "H5PerformanceLog"
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r8 = r0.getPageUrl()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.getPublicId()     // Catch:{ all -> 0x0513 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0513 }
            if (r6 == 0) goto L_0x0022
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.getAppId()     // Catch:{ all -> 0x0513 }
        L_0x0022:
            r9 = r0
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r10 = r0.getTitle()     // Catch:{ all -> 0x0513 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0513 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0513 }
            r0.<init>()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r7 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r7 = r7.getPageInfo()     // Catch:{ all -> 0x0513 }
            r0.append(r7)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r7 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r7 = com.alipay.mobile.nebulacore.wallet.H5Logger.getPerformanceData(r7)     // Catch:{ all -> 0x0513 }
            r0.append(r7)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0513 }
            r6.<init>(r0)     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.performanceMap     // Catch:{ all -> 0x0513 }
            java.lang.String r11 = "="
            java.lang.String r12 = "^"
            if (r0 == 0) goto L_0x015e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.performanceMap     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x015e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.performanceMap     // Catch:{ all -> 0x0513 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0513 }
            java.util.Iterator r15 = r0.iterator()     // Catch:{ all -> 0x0513 }
            r7 = 0
        L_0x0064:
            boolean r0 = r15.hasNext()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0151
            java.lang.Object r0 = r15.next()     // Catch:{ all -> 0x0513 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0513 }
            java.lang.Object r17 = r0.getKey()     // Catch:{ all -> 0x0513 }
            r13 = r17
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0513 }
            java.lang.Object r14 = r0.getValue()     // Catch:{ all -> 0x0513 }
            if (r14 == 0) goto L_0x013f
            java.lang.String r14 = "jsErrors"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x0513 }
            if (r14 == 0) goto L_0x0089
            int r7 = r7 + 1
            goto L_0x0064
        L_0x0089:
            boolean r14 = r4.equals(r13)     // Catch:{ all -> 0x0513 }
            if (r14 != 0) goto L_0x00d9
            java.lang.String r14 = "domReady"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x0513 }
            if (r14 == 0) goto L_0x0098
            goto L_0x00d9
        L_0x0098:
            java.lang.String r14 = "headScreen"
            boolean r14 = r14.equals(r13)     // Catch:{ all -> 0x0513 }
            if (r14 == 0) goto L_0x00bc
            java.lang.Object r14 = r0.getValue()     // Catch:{ all -> 0x0513 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0513 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0513 }
            r17 = r15
            com.alipay.mobile.h5container.api.H5PageData r15 = r1.pageData     // Catch:{ all -> 0x0513 }
            r19 = r9
            r20 = r10
            long r9 = r14.longValue()     // Catch:{ all -> 0x0513 }
            r15.setHeadScreen(r9)     // Catch:{ all -> 0x0513 }
            goto L_0x00c2
        L_0x00bc:
            r19 = r9
            r20 = r10
            r17 = r15
        L_0x00c2:
            boolean r9 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0513 }
            if (r9 != 0) goto L_0x00d5
            java.util.Map<java.lang.String, java.lang.String> r9 = r1.extraJSReport     // Catch:{ all -> 0x0513 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0513 }
            r9.put(r13, r0)     // Catch:{ all -> 0x0513 }
        L_0x00d5:
            r21 = r4
            goto L_0x0147
        L_0x00d9:
            r19 = r9
            r20 = r10
            r17 = r15
            com.alipay.mobile.h5container.api.H5PageData r9 = r1.pageData     // Catch:{ Exception -> 0x0138 }
            long r9 = com.alipay.mobile.nebulacore.wallet.H5Logger.getCorrectStartTime(r9)     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r14 = r0.getValue()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0138 }
            long r14 = com.alipay.mobile.nebulacore.wallet.H5Logger.getLongValue(r14)     // Catch:{ Exception -> 0x0138 }
            int r21 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r21 <= 0) goto L_0x00f8
            long r9 = r14 - r9
            goto L_0x00fa
        L_0x00f8:
            r9 = 0
        L_0x00fa:
            boolean r21 = r4.equals(r13)     // Catch:{ Exception -> 0x0138 }
            if (r21 == 0) goto L_0x010a
            r21 = r4
            com.alipay.mobile.h5container.api.H5PageData r4 = r1.pageData     // Catch:{ Exception -> 0x0108 }
            r4.setPageLoad(r14)     // Catch:{ Exception -> 0x0108 }
            goto L_0x010c
        L_0x0108:
            r0 = move-exception
            goto L_0x013b
        L_0x010a:
            r21 = r4
        L_0x010c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0108 }
            r4.<init>()     // Catch:{ Exception -> 0x0108 }
            r4.append(r13)     // Catch:{ Exception -> 0x0108 }
            r4.append(r3)     // Catch:{ Exception -> 0x0108 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0108 }
            r4.append(r0)     // Catch:{ Exception -> 0x0108 }
            r4.append(r3)     // Catch:{ Exception -> 0x0108 }
            r4.append(r9)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0108 }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r0)     // Catch:{ Exception -> 0x0108 }
            r6.append(r12)     // Catch:{ Exception -> 0x0108 }
            r6.append(r13)     // Catch:{ Exception -> 0x0108 }
            r6.append(r11)     // Catch:{ Exception -> 0x0108 }
            r6.append(r9)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0147
        L_0x0138:
            r0 = move-exception
            r21 = r4
        L_0x013b:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r5, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0513 }
            goto L_0x0147
        L_0x013f:
            r21 = r4
            r19 = r9
            r20 = r10
            r17 = r15
        L_0x0147:
            r15 = r17
            r9 = r19
            r10 = r20
            r4 = r21
            goto L_0x0064
        L_0x0151:
            r19 = r9
            r20 = r10
            java.lang.String r0 = "^jsErrors="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r7)     // Catch:{ all -> 0x0513 }
            goto L_0x0162
        L_0x015e:
            r19 = r9
            r20 = r10
        L_0x0162:
            com.alipay.mobile.h5container.api.H5AvailablePageData r0 = r1.availablePageData     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0167
            return
        L_0x0167:
            com.alipay.mobile.h5container.api.H5AvailablePageData r0 = r1.availablePageData     // Catch:{ all -> 0x0513 }
            long r3 = r0.getStopLoadingTime()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5AvailablePageData r7 = r1.availablePageData     // Catch:{ all -> 0x0513 }
            long r3 = com.alipay.mobile.nebulacore.wallet.H5Logger.getCorrectStopLoading(r3, r0, r7)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5AvailablePageData r0 = r1.availablePageData     // Catch:{ all -> 0x0513 }
            long r9 = r0.getStopLoadingTimeWithLoc()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5AvailablePageData r7 = r1.availablePageData     // Catch:{ all -> 0x0513 }
            long r9 = com.alipay.mobile.nebulacore.wallet.H5Logger.getCorrectStopLoading(r9, r0, r7)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^stopLoading="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^stopLoadingWithoutLocating="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r9)     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.extraJSReport     // Catch:{ all -> 0x0513 }
            int r0 = r0.size()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x01c6
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.extraJSReport     // Catch:{ all -> 0x0513 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0513 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0513 }
        L_0x01a5:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x01c6
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0513 }
            r6.append(r12)     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r11)     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r1.extraJSReport     // Catch:{ all -> 0x0513 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            goto L_0x01a5
        L_0x01c6:
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.addToParam4     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x01fd
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.addToParam4     // Catch:{ all -> 0x0513 }
            int r0 = r0.size()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x01fd
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.addToParam4     // Catch:{ all -> 0x0513 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0513 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0513 }
        L_0x01dc:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x01fd
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0513 }
            r6.append(r12)     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r11)     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r1.addToParam4     // Catch:{ all -> 0x0513 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            goto L_0x01dc
        L_0x01fd:
            com.alipay.mobile.nebula.webview.APWebView r0 = r1.apWebView     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x020f
            java.lang.String r0 = "^webViewVersion="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.nebula.webview.APWebView r0 = r1.apWebView     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.getVersion()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x020f:
            java.lang.String r0 = "no"
            java.lang.String r3 = "h5_uploadCacheResNum"
            java.lang.String r3 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r3)     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0239
            java.lang.String r0 = "^cacheResNum="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            int r0 = r0.getUcCacheResNum()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^aliResNum"
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            int r0 = r0.getAliRequestResNum()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x0239:
            boolean r0 = com.alipay.mobile.nebula.dev.H5BugmeLogCollector.enabled()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0244
            java.lang.String r0 = "^enableBugmeDump=true"
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x0244:
            android.content.Context r0 = com.alipay.mobile.nebula.util.H5Utils.getContext()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0263
            int r3 = com.alipay.mobile.nebula.util.H5DimensionUtil.getScreenWidth(r0)     // Catch:{ all -> 0x0513 }
            int r0 = com.alipay.mobile.nebula.util.H5DimensionUtil.getScreenHeight(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r4 = "^screenDisplay="
            r6.append(r4)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "x"
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r3)     // Catch:{ all -> 0x0513 }
        L_0x0263:
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5DeviceHelper.getCpuHardware()     // Catch:{ all -> 0x0513 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x027d
            java.lang.String r3 = "\\s+"
            java.lang.String r0 = r0.replaceAll(r3, r4)     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = "^cpuHardware="
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x027d:
            java.lang.String r0 = r22.getJsApiCalledLog()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.extraJSReport     // Catch:{ all -> 0x0513 }
            r0.clear()     // Catch:{ all -> 0x0513 }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.performanceMap     // Catch:{ all -> 0x0513 }
            r0.clear()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x02be
            java.lang.String r0 = "^isLocal="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.getIsLocal()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^usePreRequest="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.isUsePreRequest()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            int r0 = r0.getAbTestUsedTime()     // Catch:{ all -> 0x0513 }
            if (r0 <= 0) goto L_0x02be
            java.lang.String r3 = "^abtestUsedTime="
            r6.append(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x02be:
            long r9 = com.alipay.mobile.h5container.api.H5PageData.swFirstJsApiCallTime     // Catch:{ all -> 0x0513 }
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x02e5
            long r9 = com.alipay.mobile.h5container.api.H5PageData.swFirstJsApiCallTime     // Catch:{ all -> 0x0513 }
            long r11 = com.alipay.mobile.h5container.api.H5PageData.createAppTime     // Catch:{ all -> 0x0513 }
            long r9 = r9 - r11
            java.lang.String r0 = "^swFirstJsApiCallTime="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r9)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "tinyApp swFirstJsApiCallTime "
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r0)     // Catch:{ all -> 0x0513 }
            r9 = 0
            com.alipay.mobile.h5container.api.H5PageData.swFirstJsApiCallTime = r9     // Catch:{ all -> 0x0513 }
        L_0x02e5:
            java.lang.Boolean r0 = sUploadHttp2Stuff     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0332
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0513 }
            r3 = 23
            if (r0 < r3) goto L_0x0322
            java.lang.String r0 = "h5_loghttp2performance"
            java.lang.String r0 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r0)     // Catch:{ all -> 0x0513 }
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0322
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0513 }
            if (r3 != 0) goto L_0x0322
            java.lang.String r3 = "upload"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0513 }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x0312
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0513 }
            sUploadHttp2Stuff = r3     // Catch:{ all -> 0x0513 }
        L_0x0312:
            java.lang.String r3 = "UCNetwork"
            java.lang.String r0 = r0.getString(r3)     // Catch:{ all -> 0x0513 }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0322
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0513 }
            sUseUcNetwork = r0     // Catch:{ all -> 0x0513 }
        L_0x0322:
            java.lang.Boolean r0 = sUploadHttp2Stuff     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x032a
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0513 }
            sUploadHttp2Stuff = r0     // Catch:{ all -> 0x0513 }
        L_0x032a:
            java.lang.Boolean r0 = sUseUcNetwork     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0332
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0513 }
            sUseUcNetwork = r0     // Catch:{ all -> 0x0513 }
        L_0x0332:
            java.lang.Boolean r0 = sUploadHttp2Stuff     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0513 }
            java.lang.String r2 = "^spdy="
            if (r0 == 0) goto L_0x03a2
            java.lang.String r0 = "^ucnetwork="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.Boolean r0 = sUseUcNetwork     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x034b
            r7 = 1
            goto L_0x034c
        L_0x034b:
            r7 = 0
        L_0x034c:
            r6.append(r7)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^protocal="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.getProtocol()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^responseDuration="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            long r9 = r0.getLastResponseTimestamp()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            long r11 = r0.getStart()     // Catch:{ all -> 0x0513 }
            long r9 = r9 - r11
            r6.append(r9)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^h2="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = "h2"
            int r0 = r0.getRequestCountByProtocal(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            r6.append(r2)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = "spdy"
            int r0 = r0.getRequestCountByProtocal(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "^h1="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = "h1"
            int r0 = r0.getRequestCountByProtocal(r3)     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            goto L_0x03a7
        L_0x03a2:
            java.lang.String r0 = "^ucnetwork=0"
            r6.append(r0)     // Catch:{ all -> 0x0513 }
        L_0x03a7:
            java.lang.String r0 = "^useWebViewPool="
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            boolean r0 = r0.isUseWebViewPool()     // Catch:{ all -> 0x0513 }
            r6.append(r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "param4:"
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r0)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = "H5_PAGE_PERFORMANCE"
            r7 = 0
            java.lang.String r11 = r6.toString()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r6 = com.alipay.mobile.nebula.appcenter.model.H5Refer.referUrl     // Catch:{ all -> 0x0513 }
            java.lang.String r9 = r1.bizScenario     // Catch:{ all -> 0x0513 }
            boolean r10 = r1.isOfflineApp     // Catch:{ all -> 0x0513 }
            java.lang.String r12 = com.alipay.mobile.nebulacore.wallet.H5Logger.getUniteParam4(r3, r6, r9, r10)     // Catch:{ all -> 0x0513 }
            java.lang.String r13 = "H-MM"
            r6 = r0
            r9 = r19
            r10 = r20
            com.alipay.mobile.nebulacore.wallet.H5Logger.performanceLoggerV2(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0513 }
            java.lang.String r0 = r1.jsError     // Catch:{ all -> 0x0513 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0415
            java.lang.String r6 = com.alipay.mobile.nebulacore.wallet.H5Logger.H5_AL_PAGE_JSERROR     // Catch:{ all -> 0x0513 }
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = r1.jsError     // Catch:{ all -> 0x0513 }
            r11 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0513 }
            r0.<init>()     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r12 = com.alipay.mobile.nebula.appcenter.model.H5Refer.referUrl     // Catch:{ all -> 0x0513 }
            java.lang.String r13 = r1.bizScenario     // Catch:{ all -> 0x0513 }
            boolean r14 = r1.isOfflineApp     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = com.alipay.mobile.nebulacore.wallet.H5Logger.getUniteParam4(r3, r12, r13, r14)     // Catch:{ all -> 0x0513 }
            r0.append(r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r1.getDslVersion(r3)     // Catch:{ all -> 0x0513 }
            r0.append(r3)     // Catch:{ all -> 0x0513 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x0513 }
            java.lang.String r13 = "H-EM"
            com.alipay.mobile.nebulacore.wallet.H5Logger.performanceLoggerV2(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0513 }
        L_0x0415:
            java.lang.String r0 = "h5_secJsApiCallConfig"
            java.lang.String r0 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r0)     // Catch:{ all -> 0x0513 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x0422
            return
        L_0x0422:
            java.lang.Class<com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel> r3 = com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel.class
            java.lang.Object r0 = com.alibaba.a.a.parseObject((java.lang.String) r0, r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel r0 = (com.alipay.mobile.nebulacore.wallet.H5JsApiConfigModel) r0     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getJsApiDetail()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0512
            boolean r0 = r0.isEnable()     // Catch:{ all -> 0x0513 }
            if (r0 == 0) goto L_0x0512
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0513 }
            if (r0 != 0) goto L_0x0512
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0513 }
            java.lang.String r6 = "logVersion=1^jsapi="
            r0.<init>(r6)     // Catch:{ all -> 0x0513 }
            r0.append(r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getErrorSpdyMsg()     // Catch:{ all -> 0x0513 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0513 }
            if (r3 != 0) goto L_0x0471
            java.lang.String r2 = "^spdy=Y`_`Y`_`"
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r2 = r1.pageData     // Catch:{ all -> 0x0513 }
            int r2 = r2.getErrorCode()     // Catch:{ all -> 0x0513 }
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            java.lang.String r2 = "`_`"
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.h5container.api.H5PageData r2 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r2 = r2.getErrorSpdyMsg()     // Catch:{ all -> 0x0513 }
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            goto L_0x0489
        L_0x0471:
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            boolean r3 = r3.isSpdy()     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x047c
            java.lang.String r3 = "Y"
            goto L_0x047e
        L_0x047c:
            java.lang.String r3 = "N"
        L_0x047e:
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            r0.append(r3)     // Catch:{ all -> 0x0513 }
            java.lang.String r2 = "`_`N`_``_`"
            r0.append(r2)     // Catch:{ all -> 0x0513 }
        L_0x0489:
            com.alipay.mobile.nebula.provider.H5ProviderManager r2 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()     // Catch:{ all -> 0x0513 }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r3 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0513 }
            java.lang.Object r2 = r2.getProvider(r3)     // Catch:{ all -> 0x0513 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r2 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r2     // Catch:{ all -> 0x0513 }
            if (r2 == 0) goto L_0x04e8
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getPageUrl()     // Catch:{ all -> 0x0513 }
            boolean r3 = r2.isRpcDomains(r3)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x04aa
            java.lang.String r4 = "rpc"
            goto L_0x04e8
        L_0x04aa:
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getPageUrl()     // Catch:{ all -> 0x0513 }
            boolean r3 = r2.isAlipayDomains(r3)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x04b9
            java.lang.String r4 = "alipay"
            goto L_0x04e8
        L_0x04b9:
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getPageUrl()     // Catch:{ all -> 0x0513 }
            boolean r3 = r2.isSeriousAliDomains(r3)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x04c8
            java.lang.String r4 = "seriousAli"
            goto L_0x04e8
        L_0x04c8:
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getPageUrl()     // Catch:{ all -> 0x0513 }
            boolean r3 = r2.isAliDomains(r3)     // Catch:{ all -> 0x0513 }
            if (r3 == 0) goto L_0x04d7
            java.lang.String r4 = "ali"
            goto L_0x04e8
        L_0x04d7:
            com.alipay.mobile.h5container.api.H5PageData r3 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r3.getPageUrl()     // Catch:{ all -> 0x0513 }
            boolean r2 = r2.isPartnerDomains(r3)     // Catch:{ all -> 0x0513 }
            if (r2 == 0) goto L_0x04e6
            java.lang.String r4 = "partner"
            goto L_0x04e8
        L_0x04e6:
            java.lang.String r4 = "else"
        L_0x04e8:
            java.lang.String r2 = "^pageLevel="
            r0.append(r2)     // Catch:{ all -> 0x0513 }
            r0.append(r4)     // Catch:{ all -> 0x0513 }
            java.lang.String r6 = "H5SECURITY"
            java.lang.String r7 = "H5_SEC_JSAPICALL"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            java.lang.String r14 = r0.toString()     // Catch:{ all -> 0x0513 }
            r15 = 0
            com.alipay.mobile.h5container.api.H5PageData r0 = r1.pageData     // Catch:{ all -> 0x0513 }
            java.lang.String r2 = com.alipay.mobile.nebula.appcenter.model.H5Refer.referUrl     // Catch:{ all -> 0x0513 }
            java.lang.String r3 = r1.bizScenario     // Catch:{ all -> 0x0513 }
            boolean r4 = r1.isOfflineApp     // Catch:{ all -> 0x0513 }
            java.lang.String r16 = com.alipay.mobile.nebulacore.wallet.H5Logger.getUniteParam4(r0, r2, r3, r4)     // Catch:{ all -> 0x0513 }
            r17 = 0
            java.lang.String r18 = ""
            com.alipay.mobile.nebulacore.wallet.H5Logger.h5BehaviorLogger(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0513 }
        L_0x0512:
            return
        L_0x0513:
            r0 = move-exception
            java.lang.String r2 = "logPagePerformance exception."
            com.alipay.mobile.nebula.util.H5Log.e(r5, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.log.H5PerformanceLog.run():void");
    }

    private String getDslVersion(H5PageData h5PageData) {
        if (h5PageData == null || !H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(h5PageData.getIsTinyApp())) {
            return "";
        }
        return "^dslVersion=" + H5Logger.getDslVersion(h5PageData);
    }

    private String getJsApiCalledLog() {
        H5PageData h5PageData = this.pageData;
        if (h5PageData != null) {
            int i2 = 0;
            String str = "";
            for (Map.Entry<String, H5JsCallData> value : h5PageData.getJsapiInfoList().entrySet()) {
                str = str + ((H5JsCallData) value.getValue()).getAction() + "|";
                i2++;
            }
            if (i2 > 0) {
                String str2 = "^jsApiNum=" + i2 + "^jsApiNames=" + str;
                H5LoggerPlugin.jsApiNumStr = str2;
                return str2;
            }
        }
        return "";
    }
}
