package com.appsflyer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AFDeepLinkManager {
    public static AFDeepLinkManager instance;
    public static Uri trampolineUri;

    /* renamed from: ı  reason: contains not printable characters */
    public static String[] f0;

    /* renamed from: ǃ  reason: contains not printable characters */
    static String[] f1;

    /* renamed from: ɩ  reason: contains not printable characters */
    static volatile boolean f2;

    /* renamed from: Ι  reason: contains not printable characters */
    static final int f3 = ((int) TimeUnit.SECONDS.toMillis(2));

    private AFDeepLinkManager() {
    }

    public static AFDeepLinkManager getInstance() {
        if (instance == null) {
            instance = new AFDeepLinkManager();
        }
        return instance;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static boolean m1(String str) {
        if (f1 == null || str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate ESP URLs :");
        sb.append(Arrays.asList(f1));
        AFLogger.afRDLog(sb.toString());
        for (String str2 : f1) {
            if (str.contains("://".concat(String.valueOf(str2)))) {
                AFLogger.afRDLog("Deeplink matches ESP domain: ".concat(String.valueOf(str2)));
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static void m3(final Context context, final Map<String, Object> map, final Uri uri) {
        if (m1(uri.toString())) {
            f2 = true;
            AFExecutor instance2 = AFExecutor.getInstance();
            if (instance2.f25 == null) {
                instance2.f25 = Executors.newSingleThreadScheduledExecutor(instance2.f24);
            }
            instance2.f25.execute(new Runnable() {
                public final void run() {
                    long j;
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = System.currentTimeMillis();
                    Uri uri = null;
                    try {
                        StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
                        sb.append(uri.toString());
                        AFLogger.afDebugLog(sb.toString());
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setReadTimeout(AFDeepLinkManager.f3);
                        httpURLConnection.setConnectTimeout(AFDeepLinkManager.f3);
                        httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                        httpURLConnection.connect();
                        AFLogger.afDebugLog("ESP deeplink resolving is finished");
                        hashMap.put("status", String.valueOf(httpURLConnection.getResponseCode()));
                        if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() <= 305) {
                            uri = Uri.parse(httpURLConnection.getHeaderField("Location"));
                        }
                        j = System.currentTimeMillis() - currentTimeMillis;
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        hashMap.put("error", th.getLocalizedMessage());
                        hashMap.put("status", H5BridgeContext.INVALID_ID);
                        j = System.currentTimeMillis() - currentTimeMillis;
                        AFLogger.afErrorLog(th.getMessage(), th);
                    }
                    hashMap.put("latency", Long.toString(j));
                    if (uri != null) {
                        hashMap.put("res", uri.toString());
                    } else {
                        hashMap.put("res", "");
                    }
                    synchronized (map) {
                        map.put("af_deeplink_r", hashMap);
                        map.put("af_deeplink", uri.toString());
                    }
                    AFDeepLinkManager.f2 = false;
                    if (uri == null) {
                        uri = uri;
                    }
                    AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri);
                }
            });
        } else {
            AppsFlyerLibCore.getInstance().handleDeepLinkCallback(context, map, uri);
        }
        trampolineUri = null;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static void m2(Intent intent, Context context, Map<String, Object> map) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null) {
            if (!intent.hasExtra("af_consumed")) {
                intent.putExtra("af_consumed", System.currentTimeMillis());
                m3(context, map, uri);
                return;
            }
            StringBuilder sb = new StringBuilder("skipping re-use of previously consumed deep link: ");
            sb.append(uri.toString());
            sb.append(" w/af_consumed");
            AFLogger.afInfoLog(sb.toString());
        } else if (trampolineUri != null) {
            StringBuilder sb2 = new StringBuilder("using trampoline Intent fallback with URI: ");
            sb2.append(trampolineUri);
            AFLogger.afInfoLog(sb2.toString());
            m3(context, map, trampolineUri);
        } else if (AppsFlyerLibCore.getInstance().latestDeepLink != null) {
            StringBuilder sb3 = new StringBuilder("using Unity/plugin Intent fallback with URI: ");
            sb3.append(AppsFlyerLibCore.getInstance().latestDeepLink.toString());
            AFLogger.afInfoLog(sb3.toString());
            m3(context, map, AppsFlyerLibCore.getInstance().latestDeepLink);
        } else {
            AFLogger.afDebugLog("No deep link detected");
        }
    }

    /* access modifiers changed from: protected */
    public void collectIntentsFromActivities(Intent intent) {
        Uri uri;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            uri = null;
        } else {
            uri = intent.getData();
        }
        if (uri != null && intent.getData() != trampolineUri) {
            trampolineUri = intent.getData();
        }
    }
}
