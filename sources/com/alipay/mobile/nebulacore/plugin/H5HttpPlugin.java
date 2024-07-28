package com.alipay.mobile.nebulacore.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebResourceResponse;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.tinypermission.H5ApiManager;
import com.alipay.mobile.nebula.util.H5DomainUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulacore.Nebula;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Random;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5HttpPlugin extends H5SimplePlugin {
    private static final double DEFAULT_NETWORK_SAMPLE_RATE = 0.5d;
    public static final int DEFAULT_TIMEOUT = 30000;
    private static final String HEADERS = "headers";
    public static final String HTTP_REQUEST = "httpRequest";
    private static final String KEY_NETWORK_SAMPLE_RATE = "h5_http_request_sample_rate";
    public static final String TAG = "H5HttpPlugin";
    /* access modifiers changed from: private */
    public String appId;
    /* access modifiers changed from: private */
    public String appVersion;
    /* access modifiers changed from: private */
    public String bizScenario;
    private HttpURLConnection client;
    private H5EventHandlerService h5EventHandlerService;
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private boolean hasReleased = false;
    /* access modifiers changed from: private */
    public boolean hasResult = false;
    /* access modifiers changed from: private */
    public String packageNick;
    /* access modifiers changed from: private */
    public String publicId;
    /* access modifiers changed from: private */
    public String releaseType;

    private static void sendResult(e eVar, H5BridgeContext h5BridgeContext) {
        if (eVar != null && h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    static void sendFailed(int i2, H5BridgeContext h5BridgeContext) {
        e eVar = new e();
        eVar.put("error", (Object) Integer.valueOf(i2));
        sendResult(eVar, h5BridgeContext);
    }

    static void sendFailed(int i2, String str, H5BridgeContext h5BridgeContext) {
        e eVar = new e();
        eVar.put("error", (Object) Integer.valueOf(i2));
        eVar.put("errorMsg", (Object) str);
        sendResult(eVar, h5BridgeContext);
    }

    public void onRelease() {
        this.hasReleased = true;
        this.h5Page = null;
        try {
            if (this.client != null) {
                H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                    public void run() {
                        H5HttpPlugin.this.closeHttpClient();
                    }
                });
            }
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
        }
    }

    /* access modifiers changed from: private */
    public void closeHttpClient() {
        HttpURLConnection httpURLConnection = this.client;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.client = null;
        }
    }

    public boolean handleEvent(final H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (h5Event.getTarget() instanceof H5Page) {
            this.h5Page = (H5Page) h5Event.getTarget();
        }
        if (!"httpRequest".equals(action)) {
            return true;
        }
        H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                Random random = new Random(System.currentTimeMillis());
                boolean z = false;
                boolean unused = H5HttpPlugin.this.hasResult = false;
                try {
                    Bundle params = H5HttpPlugin.this.h5Page.getParams();
                    String unused2 = H5HttpPlugin.this.appId = H5Utils.getString(params, "appId");
                    String unused3 = H5HttpPlugin.this.publicId = H5Utils.getString(params, H5Param.PUBLIC_ID);
                    String unused4 = H5HttpPlugin.this.releaseType = H5Utils.getString(params, "release_type");
                    String unused5 = H5HttpPlugin.this.appVersion = H5Utils.getString(params, "appVersion");
                    String unused6 = H5HttpPlugin.this.packageNick = H5Utils.getString(params, H5AppUtil.package_nick);
                    String unused7 = H5HttpPlugin.this.bizScenario = H5Utils.getString(params, H5Param.LONG_BIZ_SCENARIO);
                    if (Nebula.getH5TinyAppService() != null ? Nebula.getH5TinyAppService().hasPermissionFile(H5HttpPlugin.this.appId) : false) {
                        z = Nebula.getH5TinyAppService().hasPermission(H5HttpPlugin.this.appId, (String) null, H5ApiManager.Enable_Proxy);
                    }
                    if (!z || H5HttpPlugin.this.getH5EventHandlerService() == null) {
                        H5HttpPlugin.this.httpRequest(h5Event, h5BridgeContext);
                    } else {
                        H5HttpPlugin.this.httpRequestWithAlipayNet(h5Event, h5BridgeContext);
                    }
                } catch (Throwable th) {
                    H5Log.e(H5HttpPlugin.TAG, th);
                    H5HttpPlugin.sendFailed(12, h5BridgeContext);
                }
                double d2 = H5HttpPlugin.DEFAULT_NETWORK_SAMPLE_RATE;
                H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                if (h5ConfigProvider != null) {
                    String config = h5ConfigProvider.getConfig(H5HttpPlugin.KEY_NETWORK_SAMPLE_RATE);
                    if (!TextUtils.isEmpty(config)) {
                        try {
                            d2 = Double.parseDouble(config);
                        } catch (Exception e2) {
                            H5Log.e(H5HttpPlugin.TAG, "parse sample config failed", e2);
                        }
                    }
                }
                if (random.nextDouble() <= d2) {
                    H5Monitor.behavior(new H5MonitorModel().success().appendCostTime(System.currentTimeMillis() - currentTimeMillis).appendUrl(H5Utils.getString(h5Event.getParam(), "url")).seedId(H5MonitorModel.SEED_ID_HTTP_REQUEST).appendExtParams("httpResult", String.valueOf(H5HttpPlugin.this.hasResult)));
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public H5EventHandlerService getH5EventHandlerService() {
        if (this.h5EventHandlerService == null) {
            this.h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
        }
        return this.h5EventHandlerService;
    }

    private boolean getFromPkg(String str, String str2, String str3, H5BridgeContext h5BridgeContext) {
        H5ContentProvider webProvider;
        WebResourceResponse content;
        String str4;
        H5Page h5Page2 = this.h5Page;
        if (!(h5Page2 == null || h5Page2.getParams() == null)) {
            String string = H5Utils.getString(this.h5Page.getParams(), H5Param.ONLINE_HOST);
            if (str.startsWith("http") && !str.contains(string)) {
                return false;
            }
            String absoluteUrl = getAbsoluteUrl(str, this.h5Page.getParams());
            H5Log.d(TAG, "getFromPkg realPath ".concat(String.valueOf(absoluteUrl)));
            H5Session session = this.h5Page.getSession();
            if (!(session == null || (webProvider = session.getWebProvider()) == null || (content = webProvider.getContent(absoluteUrl, true)) == null)) {
                try {
                    InputStream data = content.getData();
                    String str5 = null;
                    if (data != null) {
                        byte[] readBytes = H5Utils.readBytes(data);
                        if (ImagePickerUtils.IMAGE_PICKER_KEY_BASE_64.equals(str2)) {
                            str4 = Base64.encodeToString(readBytes, 2);
                        } else if (!TextUtils.isEmpty(str3)) {
                            str4 = new String(readBytes, str3);
                        } else {
                            str4 = new String(readBytes);
                        }
                        str5 = str4;
                        data.close();
                    }
                    e eVar = new e();
                    eVar.put("data", (Object) str5);
                    h5BridgeContext.sendBridgeResult(eVar);
                    return true;
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        }
        return false;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction("httpRequest");
    }

    private String getAbsoluteUrl(String str, Bundle bundle) {
        String string = H5Utils.getString(bundle, "url");
        if (!TextUtils.isEmpty(string)) {
            return H5Utils.getAbsoluteUrlV2(string, str, (Bundle) null);
        }
        return null;
    }

    private boolean hasPermission(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (this.h5Page == null || h5ConfigProvider == null || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(h5ConfigProvider.getConfig("h5_shouldCheckSPPermission"))) {
            return true;
        }
        String url = this.h5Page.getUrl();
        if (!h5ConfigProvider.isAliDomains(url) && !h5ConfigProvider.isAlipayDomains(url) && (h5ConfigProvider.isAliDomains(str) || h5ConfigProvider.isAlipayDomains(str))) {
            H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
            if (h5LogProvider == null) {
                return false;
            }
            h5LogProvider.log("h5_al_jsapi_permission_cors", "reqUrl=".concat(String.valueOf(str)), "currentUrl=".concat(String.valueOf(url)), this.appId, (String) null);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0233 A[Catch:{ Exception -> 0x0325 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0234 A[Catch:{ Exception -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0117 A[SYNTHETIC, Splitter:B:64:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x017b A[SYNTHETIC, Splitter:B:93:0x017b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpRequest(com.alipay.mobile.h5container.api.H5Event r21, com.alipay.mobile.h5container.api.H5BridgeContext r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "error"
            java.lang.String r4 = "H5HttpPlugin"
            r5 = 2
            if (r0 == 0) goto L_0x0357
            com.alibaba.a.e r6 = r21.getParam()
            if (r6 != 0) goto L_0x0015
            goto L_0x0357
        L_0x0015:
            com.alibaba.a.e r6 = r21.getParam()
            java.lang.String r7 = "url"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 == 0) goto L_0x002a
            sendFailed(r5, r2)
            return
        L_0x002a:
            boolean r8 = r1.hasPermission(r7)
            if (r8 != 0) goto L_0x0034
            r22.sendNoRightToInvoke()
            return
        L_0x0034:
            java.lang.String r8 = "http"
            boolean r8 = r7.startsWith(r8)
            if (r8 != 0) goto L_0x0042
            com.alipay.mobile.h5container.api.H5Event$Error r3 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            r2.sendError((com.alipay.mobile.h5container.api.H5Event) r0, (com.alipay.mobile.h5container.api.H5Event.Error) r3)
            return
        L_0x0042:
            java.lang.String r8 = "GET"
            java.lang.String r0 = "method"
            java.lang.String r9 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r0, (java.lang.String) r8)
            java.lang.String r10 = "headers"
            r11 = 0
            com.alibaba.a.b r12 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r6, r10, r11)
            com.alibaba.a.e r13 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r6, r10, r11)
            java.lang.String r14 = "data"
            java.lang.String r15 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r14)
            r11 = -1
            java.lang.String r0 = "timeout"
            int r16 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r6, (java.lang.String) r0, (int) r11)
            java.lang.String r0 = "responseType"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r0)
            java.lang.String r0 = "responseCharset"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r6, (java.lang.String) r0)
            java.net.URL r0 = new java.net.URL     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            r0.<init>(r7)     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            r1.client = r0     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            java.net.HttpURLConnection r0 = r1.client     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            java.lang.String r11 = r9.toUpperCase()     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            r0.setRequestMethod(r11)     // Catch:{ ProtocolException -> 0x0098, MalformedURLException -> 0x008f, IOException -> 0x0086 }
            goto L_0x00a0
        L_0x0086:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)
            goto L_0x00a0
        L_0x008f:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)
            goto L_0x00a0
        L_0x0098:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)
        L_0x00a0:
            java.net.HttpURLConnection r0 = r1.client
            if (r0 != 0) goto L_0x00aa
            java.lang.String r0 = "init urlconnection failed"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00aa:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r11 = "POST"
            r17 = r3
            r3 = 1
            if (r0 != 0) goto L_0x010a
            boolean r0 = r8.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x00bc
            goto L_0x010a
        L_0x00bc:
            java.lang.String r0 = "DELETE"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x0113
            java.lang.String r0 = "HEADER"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x0113
            java.lang.String r0 = "PUT"
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x0113
            boolean r0 = r11.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x0113
            if (r15 == 0) goto L_0x0113
            java.net.HttpURLConnection r0 = r1.client
            r0.setDoOutput(r3)
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            java.net.HttpURLConnection r0 = r1.client     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            r8.<init>(r0)     // Catch:{ IOException -> 0x00f8, all -> 0x00f5 }
            r8.writeBytes(r15)     // Catch:{ IOException -> 0x00f3 }
            r8.flush()     // Catch:{ IOException -> 0x00f3 }
            goto L_0x0101
        L_0x00f3:
            r0 = move-exception
            goto L_0x00fa
        L_0x00f5:
            r0 = move-exception
            r8 = 0
            goto L_0x0106
        L_0x00f8:
            r0 = move-exception
            r8 = 0
        L_0x00fa:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0105 }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0105 }
        L_0x0101:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r8)
            goto L_0x0113
        L_0x0105:
            r0 = move-exception
        L_0x0106:
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r8)
            throw r0
        L_0x010a:
            boolean r0 = r1.getFromPkg(r7, r5, r6, r2)
            if (r0 == 0) goto L_0x0113
            r1.hasResult = r3
            return
        L_0x0113:
            java.lang.String r8 = "exception detail"
            if (r12 == 0) goto L_0x0165
            boolean r0 = r12.isEmpty()     // Catch:{ Exception -> 0x0163 }
            if (r0 != 0) goto L_0x0165
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0163 }
        L_0x0121:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x0163 }
            if (r0 == 0) goto L_0x0165
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x0163 }
            com.alibaba.a.e r0 = (com.alibaba.a.e) r0     // Catch:{ Exception -> 0x0163 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x0163 }
            java.util.Iterator r15 = r0.iterator()     // Catch:{ Exception -> 0x0163 }
        L_0x0135:
            boolean r0 = r15.hasNext()     // Catch:{ Exception -> 0x0163 }
            if (r0 == 0) goto L_0x0121
            java.lang.Object r0 = r15.next()     // Catch:{ Exception -> 0x0163 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ Exception -> 0x0163 }
            java.net.HttpURLConnection r3 = r1.client     // Catch:{ ClassCastException -> 0x0159 }
            java.lang.Object r18 = r0.getKey()     // Catch:{ ClassCastException -> 0x0159 }
            r19 = r12
            r12 = r18
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ ClassCastException -> 0x0157 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ ClassCastException -> 0x0157 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ClassCastException -> 0x0157 }
            r3.setRequestProperty(r12, r0)     // Catch:{ ClassCastException -> 0x0157 }
            goto L_0x015f
        L_0x0157:
            r0 = move-exception
            goto L_0x015c
        L_0x0159:
            r0 = move-exception
            r19 = r12
        L_0x015c:
            com.alipay.mobile.nebula.util.H5Log.e(r4, r8, r0)     // Catch:{ Exception -> 0x0163 }
        L_0x015f:
            r12 = r19
            r3 = 1
            goto L_0x0135
        L_0x0163:
            r0 = move-exception
            goto L_0x0194
        L_0x0165:
            if (r13 == 0) goto L_0x0197
            boolean r0 = r13.isEmpty()     // Catch:{ Exception -> 0x0163 }
            if (r0 != 0) goto L_0x0197
            java.util.Set r0 = r13.keySet()     // Catch:{ Exception -> 0x0163 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ Exception -> 0x0163 }
        L_0x0175:
            boolean r0 = r3.hasNext()     // Catch:{ Exception -> 0x0163 }
            if (r0 == 0) goto L_0x0197
            java.lang.Object r0 = r3.next()     // Catch:{ Exception -> 0x018f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x018f }
            java.lang.Object r12 = r13.get(r0)     // Catch:{ Exception -> 0x018f }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x018f }
            java.net.HttpURLConnection r15 = r1.client     // Catch:{ Exception -> 0x018f }
            r15.setRequestProperty(r0, r12)     // Catch:{ Exception -> 0x018f }
            goto L_0x0175
        L_0x018f:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x0163 }
            goto L_0x0175
        L_0x0194:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.Throwable) r0)
        L_0x0197:
            java.net.HttpURLConnection r0 = r1.client
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 == 0) goto L_0x01a2
            java.lang.String r3 = "UTF-8"
            goto L_0x01a3
        L_0x01a2:
            r3 = r6
        L_0x01a3:
            java.lang.String r12 = "Accept-Charset"
            r0.setRequestProperty(r12, r3)
            boolean r0 = android.text.TextUtils.equals(r9, r11)
            if (r0 == 0) goto L_0x01c3
            java.net.HttpURLConnection r0 = r1.client
            java.lang.String r3 = "Content-Type"
            java.lang.String r0 = r0.getRequestProperty(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01c3
            java.net.HttpURLConnection r0 = r1.client
            java.lang.String r9 = "application/x-www-form-urlencoded"
            r0.setRequestProperty(r3, r9)
        L_0x01c3:
            java.net.HttpURLConnection r0 = r1.client
            java.lang.String r3 = "referer"
            java.lang.String r0 = r0.getRequestProperty(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01de
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            if (r0 == 0) goto L_0x01de
            java.net.HttpURLConnection r9 = r1.client
            java.lang.String r0 = r0.getUrl()
            r9.setRequestProperty(r3, r0)
        L_0x01de:
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5CookieUtil.getCookie(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01ef
            java.net.HttpURLConnection r3 = r1.client
            java.lang.String r9 = "Cookie"
            r3.setRequestProperty(r9, r0)
        L_0x01ef:
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            if (r0 == 0) goto L_0x021a
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
            if (r0 == 0) goto L_0x021a
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
            com.alipay.mobile.nebula.webview.APWebSettings r0 = r0.getSettings()
            if (r0 == 0) goto L_0x021a
            java.net.HttpURLConnection r0 = r1.client
            com.alipay.mobile.h5container.api.H5Page r3 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r3 = r3.getWebView()
            com.alipay.mobile.nebula.webview.APWebSettings r3 = r3.getSettings()
            java.lang.String r3 = r3.getUserAgentString()
            java.lang.String r9 = "User-Agent"
            r0.setRequestProperty(r9, r3)
        L_0x021a:
            if (r16 >= 0) goto L_0x0221
            r16 = 30000(0x7530, float:4.2039E-41)
            r0 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0223
        L_0x0221:
            r0 = r16
        L_0x0223:
            java.net.HttpURLConnection r3 = r1.client
            r3.setConnectTimeout(r0)
            r3 = 12
            java.lang.String r0 = "check point 1, ready to execute"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ Exception -> 0x0325 }
            java.net.HttpURLConnection r0 = r1.client     // Catch:{ Exception -> 0x0325 }
            if (r0 != 0) goto L_0x0234
            return
        L_0x0234:
            java.net.HttpURLConnection r0 = r1.client     // Catch:{ Exception -> 0x0325 }
            r0.connect()     // Catch:{ Exception -> 0x0325 }
            java.net.HttpURLConnection r0 = r1.client     // Catch:{ Exception -> 0x0325 }
            int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x0325 }
            r9 = -1
            if (r0 != r9) goto L_0x0250
            android.content.res.Resources r0 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()     // Catch:{ Exception -> 0x0325 }
            int r5 = com.alipay.mobile.nebulacore.R.string.h5_server_error     // Catch:{ Exception -> 0x0325 }
            java.lang.String r0 = r0.getString(r5)     // Catch:{ Exception -> 0x0325 }
            sendFailed(r3, r0, r2)     // Catch:{ Exception -> 0x0325 }
            return
        L_0x0250:
            java.lang.String r9 = "check point 3, execute done"
            com.alipay.mobile.nebula.util.H5Log.d(r4, r9)     // Catch:{ Exception -> 0x0325 }
            boolean r9 = r1.hasReleased     // Catch:{ Exception -> 0x0325 }
            if (r9 == 0) goto L_0x025a
            return
        L_0x025a:
            r9 = -1
            if (r0 == r9) goto L_0x0320
            java.net.HttpURLConnection r9 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.lang.String r9 = r9.getResponseMessage()     // Catch:{ Exception -> 0x0325 }
            com.alibaba.a.e r11 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0325 }
            r11.<init>()     // Catch:{ Exception -> 0x0325 }
            java.lang.String r12 = "status"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0325 }
            r11.put((java.lang.String) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0325 }
            java.net.HttpURLConnection r12 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.io.InputStream r12 = r12.getInputStream()     // Catch:{ Exception -> 0x0325 }
            if (r12 == 0) goto L_0x0291
            java.lang.String r13 = "base64"
            boolean r5 = r13.equals(r5)     // Catch:{ Exception -> 0x0325 }
            if (r5 == 0) goto L_0x028c
            byte[] r5 = com.alipay.mobile.nebula.util.H5Utils.readBytes(r12)     // Catch:{ Exception -> 0x0325 }
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch:{ Exception -> 0x0325 }
            goto L_0x0292
        L_0x028c:
            java.lang.String r5 = r1.readInputStreamToString(r12, r6)     // Catch:{ Exception -> 0x0325 }
            goto L_0x0292
        L_0x0291:
            r5 = 0
        L_0x0292:
            r11.put((java.lang.String) r14, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0325 }
            java.net.HttpURLConnection r5 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.util.Map r5 = r5.getHeaderFields()     // Catch:{ Exception -> 0x0325 }
            if (r5 == 0) goto L_0x02ea
            java.net.HttpURLConnection r5 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.util.Map r5 = r5.getHeaderFields()     // Catch:{ Exception -> 0x0325 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0325 }
            if (r5 <= 0) goto L_0x02ea
            com.alibaba.a.b r5 = new com.alibaba.a.b     // Catch:{ Exception -> 0x0325 }
            r5.<init>()     // Catch:{ Exception -> 0x0325 }
            java.net.HttpURLConnection r6 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.util.Map r6 = r6.getHeaderFields()     // Catch:{ Exception -> 0x0325 }
            java.util.Set r6 = r6.keySet()     // Catch:{ Exception -> 0x0325 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0325 }
        L_0x02bc:
            boolean r12 = r6.hasNext()     // Catch:{ Exception -> 0x0325 }
            if (r12 == 0) goto L_0x02e7
            java.lang.Object r12 = r6.next()     // Catch:{ Exception -> 0x0325 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x0325 }
            if (r12 == 0) goto L_0x02bc
            java.net.HttpURLConnection r13 = r1.client     // Catch:{ Exception -> 0x0325 }
            java.lang.String r13 = r13.getHeaderField(r12)     // Catch:{ Exception -> 0x0325 }
            com.alibaba.a.e r14 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0325 }
            r14.<init>()     // Catch:{ Exception -> 0x0325 }
            r14.put((java.lang.String) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0325 }
            r5.add(r14)     // Catch:{ Exception -> 0x0325 }
            java.lang.String r14 = "set-cookie"
            boolean r12 = r14.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x0325 }
            if (r12 == 0) goto L_0x02bc
            com.alipay.mobile.nebula.util.H5CookieUtil.setCookie(r7, r13)     // Catch:{ Exception -> 0x0325 }
            goto L_0x02bc
        L_0x02e7:
            r11.put((java.lang.String) r10, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0325 }
        L_0x02ea:
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0325 }
            r6 = r17
            r11.put((java.lang.String) r6, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0325 }
            r5 = 502(0x1f6, float:7.03E-43)
            java.lang.String r7 = "errorMsg"
            if (r0 != r5) goto L_0x0307
            r0 = 13
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0325 }
            r11.put((java.lang.String) r6, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0325 }
            r11.put((java.lang.String) r7, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0325 }
            goto L_0x0317
        L_0x0307:
            r5 = 403(0x193, float:5.65E-43)
            if (r0 != r5) goto L_0x0317
            r0 = 11
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0325 }
            r11.put((java.lang.String) r6, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0325 }
            r11.put((java.lang.String) r7, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0325 }
        L_0x0317:
            if (r2 == 0) goto L_0x031c
            r2.sendBridgeResult(r11)     // Catch:{ Exception -> 0x0325 }
        L_0x031c:
            r5 = 1
            r1.hasResult = r5     // Catch:{ Exception -> 0x0325 }
            return
        L_0x0320:
            r0 = 3
            sendFailed(r0, r2)     // Catch:{ Exception -> 0x0325 }
            return
        L_0x0325:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r4, r8, r0)
            java.lang.String r4 = r0.getMessage()
            sendFailed(r3, r4, r2)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r2 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r3 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.Object r2 = r2.getProvider(r3)
            r3 = r2
            com.alipay.mobile.nebula.provider.H5LogProvider r3 = (com.alipay.mobile.nebula.provider.H5LogProvider) r3
            if (r3 == 0) goto L_0x0356
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "H5HttpPlugin^executeException="
            java.lang.String r9 = r2.concat(r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r4 = "H5HttpPlugin"
            r3.log(r4, r5, r6, r7, r8, r9)
        L_0x0356:
            return
        L_0x0357:
            r3 = 2
            sendFailed(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5HttpPlugin.httpRequest(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }

    private String readInputStreamToString(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(TextUtils.isEmpty(str) ? new InputStreamReader(bufferedInputStream) : new InputStreamReader(bufferedInputStream, str));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                str2 = stringBuffer.toString();
            } catch (Exception unused) {
                try {
                    H5Log.e(TAG, "Error reading InputStream");
                    H5IOUtils.closeQuietly(bufferedInputStream);
                    return str2;
                } catch (Throwable th) {
                    th = th;
                    H5IOUtils.closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            bufferedInputStream = null;
            H5Log.e(TAG, "Error reading InputStream");
            H5IOUtils.closeQuietly(bufferedInputStream);
            return str2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            H5IOUtils.closeQuietly(bufferedInputStream);
            throw th;
        }
        H5IOUtils.closeQuietly(bufferedInputStream);
        return str2;
    }

    private boolean enableSpdyOnUrl(String str) {
        b parseArray;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5HttpRequestUseSpdyOnAppId");
            if (!TextUtils.isEmpty(configWithProcessCache) && (parseArray = H5Utils.parseArray(configWithProcessCache)) != null && parseArray.contains(this.appId)) {
                return false;
            }
            String configWithProcessCache2 = h5ConfigProvider.getConfigWithProcessCache("h5HttpRequestUseSpdyOnUrl");
            if (TextUtils.isEmpty(configWithProcessCache2) || !H5DomainUtil.isSomeDomainInternal(str, configWithProcessCache2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpRequestWithAlipayNet(com.alipay.mobile.h5container.api.H5Event r23, com.alipay.mobile.h5container.api.H5BridgeContext r24) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            r3 = r24
            r0 = 2
            if (r2 == 0) goto L_0x02b9
            com.alibaba.a.e r4 = r23.getParam()
            if (r4 != 0) goto L_0x0011
            goto L_0x02b9
        L_0x0011:
            com.alibaba.a.e r4 = r23.getParam()
            java.lang.String r5 = "url"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r5)
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 == 0) goto L_0x0026
            sendFailed(r0, r3)
            return
        L_0x0026:
            java.lang.String r0 = "GET"
            java.lang.String r5 = "method"
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r5, (java.lang.String) r0)
            r5 = 0
            java.lang.String r15 = "headers"
            com.alibaba.a.b r6 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r4, r15, r5)
            com.alibaba.a.e r9 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r4, r15, r5)
            java.lang.String r14 = "data"
            java.lang.String r10 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r14)
            r11 = -1
            java.lang.String r12 = "timeout"
            int r11 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r4, (java.lang.String) r12, (int) r11)
            if (r11 >= 0) goto L_0x004b
            r11 = 30000(0x7530, float:4.2039E-41)
        L_0x004b:
            java.lang.String r12 = "responseType"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r12)
            java.lang.String r12 = "responseCharset"
            java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r12)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            boolean r0 = r0.equalsIgnoreCase(r8)
            r17 = r14
            r14 = 1
            if (r0 == 0) goto L_0x006e
            boolean r0 = r1.getFromPkg(r7, r13, r12, r3)
            if (r0 == 0) goto L_0x006e
            r1.hasResult = r14
            return
        L_0x006e:
            java.lang.String r14 = "POST"
            boolean r0 = r14.equalsIgnoreCase(r8)
            r18 = r13
            java.lang.String r13 = "application/x-www-form-urlencoded"
            r19 = r11
            java.lang.String r11 = "UTF-8"
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "H5HttpPlugin"
            if (r0 == 0) goto L_0x009e
            if (r10 == 0) goto L_0x0090
            byte[] r0 = r10.getBytes(r11)     // Catch:{ Exception -> 0x008b }
            r16 = r0
            goto L_0x0092
        L_0x008b:
            r0 = move-exception
            r10 = r0
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r10)
        L_0x0090:
            r16 = 0
        L_0x0092:
            boolean r0 = r4.containsKey(r15)
            if (r0 != 0) goto L_0x009b
            r5.put(r2, r13)
        L_0x009b:
            r10 = r16
            goto L_0x009f
        L_0x009e:
            r10 = 0
        L_0x009f:
            java.lang.String r4 = "exception detail"
            if (r6 == 0) goto L_0x00e6
            boolean r0 = r6.isEmpty()     // Catch:{ Exception -> 0x00e4 }
            if (r0 != 0) goto L_0x00e6
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x00e4 }
        L_0x00ad:
            boolean r0 = r6.hasNext()     // Catch:{ Exception -> 0x00e4 }
            if (r0 == 0) goto L_0x00e6
            java.lang.Object r0 = r6.next()     // Catch:{ Exception -> 0x00e4 }
            com.alibaba.a.e r0 = (com.alibaba.a.e) r0     // Catch:{ Exception -> 0x00e4 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x00e4 }
            java.util.Iterator r16 = r0.iterator()     // Catch:{ Exception -> 0x00e4 }
        L_0x00c1:
            boolean r0 = r16.hasNext()     // Catch:{ Exception -> 0x00e4 }
            if (r0 == 0) goto L_0x00ad
            java.lang.Object r0 = r16.next()     // Catch:{ Exception -> 0x00e4 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ Exception -> 0x00e4 }
            r20 = r6
            java.lang.Object r6 = r0.getKey()     // Catch:{ ClassCastException -> 0x00df }
            java.lang.Object r0 = r0.getValue()     // Catch:{ ClassCastException -> 0x00df }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ClassCastException -> 0x00df }
            r5.put(r6, r0)     // Catch:{ ClassCastException -> 0x00df }
        L_0x00dc:
            r6 = r20
            goto L_0x00c1
        L_0x00df:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r3, r4, r0)     // Catch:{ Exception -> 0x00e4 }
            goto L_0x00dc
        L_0x00e4:
            r0 = move-exception
            goto L_0x011b
        L_0x00e6:
            if (r9 == 0) goto L_0x011e
            boolean r0 = r9.isEmpty()     // Catch:{ Exception -> 0x00e4 }
            if (r0 != 0) goto L_0x011e
            java.util.Set r0 = r9.keySet()     // Catch:{ Exception -> 0x00e4 }
            java.util.Iterator r6 = r0.iterator()     // Catch:{ Exception -> 0x00e4 }
        L_0x00f6:
            boolean r0 = r6.hasNext()     // Catch:{ Exception -> 0x00e4 }
            if (r0 == 0) goto L_0x011e
            java.lang.Object r0 = r6.next()     // Catch:{ Exception -> 0x0112 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0112 }
            java.lang.Object r16 = r9.get(r0)     // Catch:{ Exception -> 0x0112 }
            r20 = r6
            java.lang.String r6 = r16.toString()     // Catch:{ Exception -> 0x0110 }
            r5.put(r0, r6)     // Catch:{ Exception -> 0x0110 }
            goto L_0x0118
        L_0x0110:
            r0 = move-exception
            goto L_0x0115
        L_0x0112:
            r0 = move-exception
            r20 = r6
        L_0x0115:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x00e4 }
        L_0x0118:
            r6 = r20
            goto L_0x00f6
        L_0x011b:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x011e:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0125
            goto L_0x0126
        L_0x0125:
            r11 = r12
        L_0x0126:
            java.lang.String r0 = "Accept-Charset"
            r5.put(r0, r11)
            boolean r0 = r14.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x013a
            boolean r0 = r5.containsKey(r2)
            if (r0 != 0) goto L_0x013a
            r5.put(r2, r13)
        L_0x013a:
            java.lang.String r0 = r1.appId
            java.lang.String r2 = "su584appid"
            r5.put(r2, r0)
            java.lang.String r0 = r1.publicId
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0152
            java.lang.String r0 = r1.publicId
            java.lang.String r2 = "su584publicid"
            r5.put(r2, r0)
        L_0x0152:
            java.lang.String r0 = r1.releaseType
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0162
            java.lang.String r0 = r1.releaseType
            java.lang.String r2 = "x-release-type"
            r5.put(r2, r0)
        L_0x0162:
            java.lang.String r0 = r1.appVersion
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0172
            java.lang.String r0 = r1.appVersion
            java.lang.String r2 = "su584appversion"
            r5.put(r2, r0)
        L_0x0172:
            java.lang.String r0 = r1.packageNick
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0182
            java.lang.String r0 = r1.packageNick
            java.lang.String r2 = "su584tinyappversion"
            r5.put(r2, r0)
        L_0x0182:
            java.lang.String r0 = r1.bizScenario
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0192
            java.lang.String r0 = r1.bizScenario
            java.lang.String r2 = "su584bizscenario"
            r5.put(r2, r0)
        L_0x0192:
            com.alipay.mobile.h5container.api.H5Page r0 = r1.h5Page
            java.lang.String r0 = r0.getUrl()
            java.lang.String r2 = "su584appletpage"
            r5.put(r2, r0)
            java.lang.String r0 = "referer"
            boolean r2 = r5.containsKey(r0)
            if (r2 != 0) goto L_0x01b1
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page
            if (r2 == 0) goto L_0x01b1
            java.lang.String r2 = r2.getUrl()
            r5.put(r0, r2)
        L_0x01b1:
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5CookieUtil.getCookie(r7)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "getCookie cost "
            r2.<init>(r6)
            long r20 = java.lang.System.currentTimeMillis()
            long r13 = r20 - r13
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r3, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01db
            java.lang.String r2 = "Cookie"
            r5.put(r2, r0)
        L_0x01db:
            java.lang.String r0 = "User-Agent"
            boolean r2 = r5.containsKey(r0)
            if (r2 != 0) goto L_0x0213
            java.lang.String r2 = "user-agent"
            boolean r2 = r5.containsKey(r2)
            if (r2 != 0) goto L_0x0213
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page
            if (r2 == 0) goto L_0x0213
            com.alipay.mobile.nebula.webview.APWebView r2 = r2.getWebView()
            if (r2 == 0) goto L_0x0213
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r2 = r2.getWebView()
            com.alipay.mobile.nebula.webview.APWebSettings r2 = r2.getSettings()
            if (r2 == 0) goto L_0x0213
            com.alipay.mobile.h5container.api.H5Page r2 = r1.h5Page
            com.alipay.mobile.nebula.webview.APWebView r2 = r2.getWebView()
            com.alipay.mobile.nebula.webview.APWebSettings r2 = r2.getSettings()
            java.lang.String r2 = r2.getUserAgentString()
            r5.put(r0, r2)
        L_0x0213:
            java.lang.String r0 = "http"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0225
            com.alipay.mobile.h5container.api.H5Event$Error r0 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            r2 = r23
            r3 = r24
            r3.sendError((com.alipay.mobile.h5container.api.H5Event) r2, (com.alipay.mobile.h5container.api.H5Event.Error) r0)
            return
        L_0x0225:
            r2 = r3
            r3 = r24
            java.lang.String r0 = "check point 1, ready to execute"
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)     // Catch:{ Exception -> 0x0285 }
            java.lang.Class<com.alipay.mobile.h5container.service.H5EventHandlerService> r0 = com.alipay.mobile.h5container.service.H5EventHandlerService.class
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x0285 }
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.findServiceByInterface(r0)     // Catch:{ Exception -> 0x0285 }
            r6 = r0
            com.alipay.mobile.h5container.service.H5EventHandlerService r6 = (com.alipay.mobile.h5container.service.H5EventHandlerService) r6     // Catch:{ Exception -> 0x0285 }
            if (r6 == 0) goto L_0x0284
            r11 = r19
            long r13 = (long) r11     // Catch:{ Exception -> 0x0285 }
            boolean r0 = r1.enableSpdyOnUrl(r7)     // Catch:{ Exception -> 0x0285 }
            r9 = r5
            r5 = r12
            r11 = r13
            r13 = r18
            r16 = r2
            r2 = r17
            r14 = r5
            r5 = r15
            r15 = r0
            com.alipay.mobile.nebula.process.H5HttpRequestResult r0 = r6.httpRequest(r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ Exception -> 0x0282 }
            com.alibaba.a.e r6 = new com.alibaba.a.e     // Catch:{ Exception -> 0x0282 }
            r6.<init>()     // Catch:{ Exception -> 0x0282 }
            java.lang.String r7 = "status"
            int r8 = r0.responseStatues     // Catch:{ Exception -> 0x0282 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0282 }
            r6.put((java.lang.String) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0282 }
            java.lang.String r7 = r0.responseContext     // Catch:{ Exception -> 0x0282 }
            r6.put((java.lang.String) r2, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0282 }
            com.alibaba.a.b r2 = r0.responseHeader     // Catch:{ Exception -> 0x0282 }
            r6.put((java.lang.String) r5, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0282 }
            java.lang.String r2 = "error"
            int r0 = r0.error     // Catch:{ Exception -> 0x0282 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0282 }
            r6.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x0282 }
            if (r3 == 0) goto L_0x027e
            r3.sendBridgeResult(r6)     // Catch:{ Exception -> 0x0282 }
        L_0x027e:
            r2 = 1
            r1.hasResult = r2     // Catch:{ Exception -> 0x0282 }
            goto L_0x0284
        L_0x0282:
            r0 = move-exception
            goto L_0x0288
        L_0x0284:
            return
        L_0x0285:
            r0 = move-exception
            r16 = r2
        L_0x0288:
            r2 = 12
            sendFailed(r2, r3)
            r2 = r16
            com.alipay.mobile.nebula.util.H5Log.e(r2, r4, r0)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r2 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r3 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.Object r2 = r2.getProvider(r3)
            r3 = r2
            com.alipay.mobile.nebula.provider.H5LogProvider r3 = (com.alipay.mobile.nebula.provider.H5LogProvider) r3
            if (r3 == 0) goto L_0x02b8
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "H5HttpPlugin^executeException="
            java.lang.String r9 = r2.concat(r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r4 = "H5HttpPlugin"
            r3.log(r4, r5, r6, r7, r8, r9)
        L_0x02b8:
            return
        L_0x02b9:
            sendFailed(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5HttpPlugin.httpRequestWithAlipayNet(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }
}
