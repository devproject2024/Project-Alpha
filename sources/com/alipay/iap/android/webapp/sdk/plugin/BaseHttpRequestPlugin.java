package com.alipay.iap.android.webapp.sdk.plugin;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceResponse;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest;
import com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage;
import com.alipay.mobile.nebulacore.core.H5ContentProviderImpl;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public abstract class BaseHttpRequestPlugin extends H5SimplePlugin {
    private static final double DEFAULT_NETWORK_SAMPLE_RATE = 0.5d;
    public static final String HEADERS = "headers";
    private static final String KEY_NETWORK_SAMPLE_RATE = "h5_http_request_sample_rate";
    private static final String TAG = "HttpRequestPlugin";
    private static final String X_SUBAPP = "X-Subapp";

    public abstract HttpResponse performRequest(HttpRequest httpRequest) throws Exception;

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction("httpRequest");
    }

    private static void sendResult(H5Event h5Event, e eVar, H5BridgeContext h5BridgeContext) {
        "sendResult event=".concat(String.valueOf(h5Event));
        c.e();
        "sendResult bridgeContext=".concat(String.valueOf(h5BridgeContext));
        c.e();
        "sendResult result=".concat(String.valueOf(eVar));
        c.e();
        if (h5Event != null && eVar != null && h5BridgeContext != null) {
            c.e();
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    static void sendFailed(H5Event h5Event, int i2, H5BridgeContext h5BridgeContext) {
        c.e();
        e eVar = new e();
        eVar.put("error", (Object) Integer.valueOf(i2));
        sendResult(h5Event, eVar, h5BridgeContext);
    }

    public boolean interceptEvent(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        c.e();
        if (TextUtils.isEmpty(H5Utils.getString(h5Event.getParam(), "url"))) {
            c.e();
            sendFailed(h5Event, 2, h5BridgeContext);
            return true;
        }
        final H5Page h5Page = h5Event.getTarget() instanceof H5Page ? (H5Page) h5Event.getTarget() : null;
        H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0176  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x019c  */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01be  */
            /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r20 = this;
                    r1 = r20
                    com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin r0 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.this
                    com.alipay.mobile.h5container.api.H5Event r2 = r5
                    com.alipay.mobile.h5container.api.H5BridgeContext r3 = r6
                    com.alipay.mobile.h5container.api.H5Page r4 = r0
                    boolean r0 = r0.getContent(r2, r3, r4)
                    if (r0 == 0) goto L_0x0014
                    com.alipay.iap.android.common.b.c.e()
                    return
                L_0x0014:
                    long r2 = java.lang.System.currentTimeMillis()
                    java.util.Random r4 = new java.util.Random
                    long r5 = java.lang.System.currentTimeMillis()
                    r4.<init>(r5)
                    com.alipay.iap.android.common.b.c.e()
                    com.alipay.mobile.h5container.api.H5Event r5 = r5
                    com.alibaba.a.e r5 = r5.getParam()
                    java.lang.String r6 = "url"
                    java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r5, (java.lang.String) r6)
                    java.lang.String r7 = "method"
                    java.lang.String r8 = "GET"
                    java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r5, (java.lang.String) r7, (java.lang.String) r8)
                    java.lang.String r15 = "data"
                    java.lang.String r14 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r5, (java.lang.String) r15)
                    r7 = -1
                    java.lang.String r8 = "timeout"
                    int r9 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r5, (java.lang.String) r8, (int) r7)
                    java.lang.String r7 = "responseType"
                    java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r5, (java.lang.String) r7)
                    java.lang.String r7 = "responseCharset"
                    java.lang.String r11 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r5, (java.lang.String) r7)
                    com.alibaba.a.b r7 = new com.alibaba.a.b
                    r7.<init>()
                    java.lang.String r10 = "headers"
                    com.alibaba.a.b r16 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r5, r10, r7)
                    com.alibaba.a.e r7 = new com.alibaba.a.e
                    r7.<init>()
                    com.alibaba.a.e r5 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r5, r10, r7)
                    java.util.HashMap r8 = new java.util.HashMap
                    r8.<init>()
                    boolean r7 = android.text.TextUtils.isEmpty(r11)
                    if (r7 == 0) goto L_0x0075
                    java.lang.String r7 = "UTF-8"
                    goto L_0x0076
                L_0x0075:
                    r7 = r11
                L_0x0076:
                    java.lang.String r0 = "Accept-Charset"
                    r8.put(r0, r7)
                    com.alipay.mobile.h5container.api.H5Page r0 = r0
                    if (r0 == 0) goto L_0x00a4
                    com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
                    if (r0 == 0) goto L_0x00a4
                    com.alipay.mobile.h5container.api.H5Page r0 = r0
                    com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
                    com.alipay.mobile.nebula.webview.APWebSettings r0 = r0.getSettings()
                    if (r0 == 0) goto L_0x00a4
                    com.alipay.mobile.h5container.api.H5Page r0 = r0
                    com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
                    com.alipay.mobile.nebula.webview.APWebSettings r0 = r0.getSettings()
                    java.lang.String r0 = r0.getUserAgentString()
                    java.lang.String r7 = "User-Agent"
                    r8.put(r7, r0)
                L_0x00a4:
                    com.alipay.mobile.h5container.api.H5Page r0 = r0
                    if (r0 == 0) goto L_0x00b8
                    java.lang.String r0 = r0.getUrl()
                    java.lang.String r7 = "referer"
                    r8.put(r7, r0)
                    com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin r0 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.this
                    com.alipay.mobile.h5container.api.H5Page r7 = r0
                    r0.setHeaderXSubapp(r8, r7)
                L_0x00b8:
                    com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest r0 = new com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest     // Catch:{ Exception -> 0x0158 }
                    r7 = r0
                    r18 = r8
                    r8 = r6
                    r19 = r6
                    r6 = r10
                    r10 = r16
                    r16 = r11
                    r11 = r5
                    r5 = r12
                    r12 = r18
                    r7.<init>(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0156 }
                    com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin r7 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.this     // Catch:{ Exception -> 0x0156 }
                    com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse r0 = r7.performRequest(r0)     // Catch:{ Exception -> 0x0156 }
                    java.lang.String r7 = "response="
                    java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0156 }
                    r7.concat(r8)     // Catch:{ Exception -> 0x0156 }
                    com.alipay.iap.android.common.b.c.e()     // Catch:{ Exception -> 0x0156 }
                    com.alibaba.a.e r7 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0156 }
                    r7.<init>()     // Catch:{ Exception -> 0x0156 }
                    java.lang.String r8 = "status"
                    int r9 = r0.statusCode     // Catch:{ Exception -> 0x0156 }
                    java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0156 }
                    r7.put((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0156 }
                    byte[] r8 = r0.data     // Catch:{ Exception -> 0x0156 }
                    if (r8 == 0) goto L_0x011d
                    java.lang.String r8 = "base64"
                    boolean r5 = r8.equals(r5)     // Catch:{ Exception -> 0x0156 }
                    if (r5 == 0) goto L_0x0103
                    byte[] r5 = r0.data     // Catch:{ Exception -> 0x0156 }
                    r8 = 2
                    java.lang.String r5 = android.util.Base64.encodeToString(r5, r8)     // Catch:{ Exception -> 0x0156 }
                    goto L_0x011a
                L_0x0103:
                    boolean r5 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0156 }
                    if (r5 != 0) goto L_0x0113
                    java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0156 }
                    byte[] r8 = r0.data     // Catch:{ Exception -> 0x0156 }
                    r9 = r16
                    r5.<init>(r8, r9)     // Catch:{ Exception -> 0x0156 }
                    goto L_0x011a
                L_0x0113:
                    java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0156 }
                    byte[] r8 = r0.data     // Catch:{ Exception -> 0x0156 }
                    r5.<init>(r8)     // Catch:{ Exception -> 0x0156 }
                L_0x011a:
                    r7.put((java.lang.String) r15, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0156 }
                L_0x011d:
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r0.headers     // Catch:{ Exception -> 0x0156 }
                    if (r5 == 0) goto L_0x013b
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r0.headers     // Catch:{ Exception -> 0x0156 }
                    int r5 = r5.size()     // Catch:{ Exception -> 0x0156 }
                    if (r5 <= 0) goto L_0x013b
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r0.headers     // Catch:{ Exception -> 0x0156 }
                    java.util.Map r5 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.fixEmptyKeyHeader(r5)     // Catch:{ Exception -> 0x0156 }
                    java.lang.String r8 = "headersStr"
                    java.lang.String r9 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.getHeaderStr(r5)     // Catch:{ Exception -> 0x0156 }
                    r7.put((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0156 }
                    r7.put((java.lang.String) r6, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0156 }
                L_0x013b:
                    java.lang.String r5 = "result="
                    java.lang.String r6 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0156 }
                    r5.concat(r6)     // Catch:{ Exception -> 0x0156 }
                    com.alipay.iap.android.common.b.c.e()     // Catch:{ Exception -> 0x0156 }
                    com.alipay.mobile.h5container.api.H5BridgeContext r5 = r6     // Catch:{ Exception -> 0x0156 }
                    r5.sendBridgeResult(r7)     // Catch:{ Exception -> 0x0156 }
                    com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin r5 = com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.this     // Catch:{ Exception -> 0x0156 }
                    com.alipay.mobile.h5container.api.H5Page r6 = r0     // Catch:{ Exception -> 0x0156 }
                    r5.switchFromOfflineToOnlineIfNeeded(r0, r6)     // Catch:{ Exception -> 0x0156 }
                    r17 = 1
                    goto L_0x018c
                L_0x0156:
                    r0 = move-exception
                    goto L_0x015b
                L_0x0158:
                    r0 = move-exception
                    r19 = r6
                L_0x015b:
                    com.alipay.iap.android.common.b.c.j()
                    com.alipay.mobile.h5container.api.H5Event r5 = r5
                    r6 = 12
                    com.alipay.mobile.h5container.api.H5BridgeContext r7 = r6
                    com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.sendFailed(r5, r6, r7)
                    java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r5 = com.alipay.mobile.nebula.provider.H5LogProvider.class
                    java.lang.String r5 = r5.getName()
                    java.lang.Object r5 = com.alipay.iap.android.webapp.sdk.utils.KitUtils.getH5Provider(r5)
                    r6 = r5
                    com.alipay.mobile.nebula.provider.H5LogProvider r6 = (com.alipay.mobile.nebula.provider.H5LogProvider) r6
                    if (r6 == 0) goto L_0x0189
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    java.lang.String r0 = java.lang.String.valueOf(r0)
                    java.lang.String r5 = "HttpRequestPlugin^executeException="
                    java.lang.String r12 = r5.concat(r0)
                    java.lang.String r7 = "HttpRequestPlugin"
                    r6.logV2(r7, r8, r9, r10, r11, r12)
                L_0x0189:
                    r0 = 0
                    r17 = 0
                L_0x018c:
                    r5 = 4602678819172646912(0x3fe0000000000000, double:0.5)
                    java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
                    java.lang.String r0 = r0.getName()
                    java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
                    com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0
                    if (r0 == 0) goto L_0x01b6
                    java.lang.String r7 = "h5_http_request_sample_rate"
                    java.lang.String r0 = r0.getConfig(r7)
                    boolean r7 = android.text.TextUtils.isEmpty(r0)
                    if (r7 != 0) goto L_0x01b6
                    double r5 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x01ad }
                    goto L_0x01b6
                L_0x01ad:
                    r0 = move-exception
                    r7 = r0
                    java.lang.String r0 = "HttpRequestPlugin"
                    java.lang.String r8 = "parse sample config failed"
                    com.alipay.mobile.nebula.util.H5Log.e(r0, r8, r7)
                L_0x01b6:
                    double r7 = r4.nextDouble()
                    int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                    if (r0 > 0) goto L_0x01e9
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
                    r0.<init>()
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.success()
                    long r4 = java.lang.System.currentTimeMillis()
                    long r4 = r4 - r2
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendCostTime(r4)
                    r2 = r19
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendUrl(r2)
                    java.lang.String r2 = "H5_CONTAINER_HTTP_REQUEST"
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.seedId(r2)
                    java.lang.String r2 = java.lang.String.valueOf(r17)
                    java.lang.String r3 = "httpResult"
                    com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r3, r2)
                    com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r0)
                L_0x01e9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin.AnonymousClass1.run():void");
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public void setHeaderXSubapp(HashMap<String, String> hashMap, H5Page h5Page) {
        H5ContentPackage contentPackage;
        if (h5Page != null && h5Page.getSession() != null && h5Page.getSession().getWebProvider() != null) {
            H5ContentProvider webProvider = h5Page.getSession().getWebProvider();
            if ((webProvider instanceof H5ContentProviderImpl) && (contentPackage = ((H5ContentProviderImpl) webProvider).getContentPackage()) != null && !TextUtils.isEmpty(contentPackage.getAppId()) && !TextUtils.isEmpty(contentPackage.getVersion())) {
                StringBuilder sb = new StringBuilder();
                sb.append(contentPackage.getAppId());
                sb.append(", ");
                sb.append(contentPackage.getVersion());
                sb.append(", ");
                String url = h5Page.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    if (contentPackage.get(H5UrlHelper.purifyUrl(url)) != null) {
                        sb.append(P4BSettlementsDataHelperMP.OFFLINE_SETTLEMENT);
                    } else {
                        sb.append(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT);
                    }
                }
                hashMap.put(X_SUBAPP, sb.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, List<String>> fixEmptyKeyHeader(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (String next : map.keySet()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, map.get(next));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static String getHeaderStr(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            List list = map.get(next);
            if (!(list == null || list.size() == 0)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (!TextUtils.isEmpty((CharSequence) list.get(i2)) && !TextUtils.isEmpty(next)) {
                        sb.append(next);
                        sb.append(AppConstants.COLON);
                        sb.append((String) list.get(i2));
                        sb.append("\\r\\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public boolean getContent(H5Event h5Event, H5BridgeContext h5BridgeContext, H5Page h5Page) {
        String str;
        try {
            new StringBuilder("getContent ").append(H5Utils.getString(h5Event.getParam(), "url"));
            c.e();
            WebResourceResponse content = h5Page.getSession().getWebProvider().getContent(H5Utils.getString(h5Event.getParam(), "url"));
            "getContent resourceResponse=".concat(String.valueOf(content));
            c.e();
            if (content == null) {
                return false;
            }
            String string = H5Utils.getString(h5Event.getParam(), "responseType");
            String string2 = H5Utils.getString(h5Event.getParam(), "responseCharset");
            e eVar = new e();
            eVar.put("status", (Object) 200);
            if (content.getData() != null) {
                if (ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64.equals(string)) {
                    str = Base64.encodeToString(H5Utils.readBytes(content.getData()), 2);
                } else if (!TextUtils.isEmpty(string2)) {
                    str = new String(H5Utils.readBytes(content.getData()), string2);
                } else {
                    str = new String(H5Utils.readBytes(content.getData()));
                }
                eVar.put("data", (Object) str);
            }
            "result=".concat(String.valueOf(eVar));
            c.e();
            h5BridgeContext.sendBridgeResult(eVar);
            return true;
        } catch (Exception unused) {
            c.j();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void switchFromOfflineToOnlineIfNeeded(HttpResponse httpResponse, H5Page h5Page) {
        c.e();
        if (httpResponse == null || httpResponse.headers == null || !httpResponse.headers.containsKey(X_SUBAPP)) {
            c.e();
            return;
        }
        List list = httpResponse.headers.get(X_SUBAPP);
        if (list.size() != 0) {
            String str = (String) list.get(0);
            "header = ".concat(String.valueOf(str));
            c.e();
            if (TextUtils.isEmpty(str) || !str.contains(P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT)) {
                return;
            }
            if (h5Page == null || h5Page.getSession() == null || h5Page.getSession().getWebProvider() == null) {
                c.e();
                return;
            }
            H5ContentProvider webProvider = h5Page.getSession().getWebProvider();
            if (!(webProvider instanceof H5ContentProviderImpl)) {
                c.e();
                return;
            }
            H5ContentPackage contentPackage = ((H5ContentProviderImpl) webProvider).getContentPackage();
            if (contentPackage != null) {
                contentPackage.releaseContent();
            } else {
                c.e();
            }
        }
    }
}
