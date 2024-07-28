package com.alipay.mobile.nebulacore.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class H5ScriptLoader {
    public static final String TAG = "H5ScriptLoader";
    public static final String startupParams = "startupParams";
    public boolean bizLoaded = false;
    public boolean bridgeLoaded = false;
    private HashMap<String, String> bridgeParams;
    private String curAppId;
    private String curPublicId;
    private String curUrl;
    private boolean enableScan;
    private H5Page h5Page;
    private final Object loaderLock;
    private Bundle startParam;
    private boolean tinyApp;
    private H5WebView webView;

    public H5ScriptLoader(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
        this.webView = h5PageImpl.getWebView();
        this.startParam = h5PageImpl.getParams();
        this.curPublicId = H5Utils.getString(this.startParam, H5Param.PUBLIC_ID);
        this.curAppId = H5Utils.getString(this.startParam, "appId");
        this.tinyApp = H5Utils.getBoolean(this.startParam, H5Param.isTinyApp, false);
        this.loaderLock = new Object();
        this.enableScan = false;
        this.bridgeParams = new HashMap<>();
        e jSONObject = H5Utils.toJSONObject(this.startParam);
        if (H5Param.SCAN_APP.equals(H5Utils.getString(jSONObject, H5Param.LONG_BIZ_SCENARIO))) {
            enableScanJS(true);
        }
        Nebula.removeBridgeTimeParam(jSONObject);
        setParamsToWebPage(startupParams, jSONObject.toJSONString());
    }

    private void enableScanJS(boolean z) {
        this.enableScan = z;
    }

    public void resetBridge() {
        H5Log.d(TAG, "resetBridge " + System.currentTimeMillis());
        this.bizLoaded = false;
        this.bridgeLoaded = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e5, code lost:
        r0 = java.lang.System.currentTimeMillis() - r2;
        com.alipay.mobile.nebula.util.H5Log.d(TAG, "load javascript elapse [" + r0 + "] for " + r8.curUrl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0107, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean loadScript() {
        /*
            r8 = this;
            com.alipay.mobile.nebulacore.web.H5WebView r0 = r8.webView
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = "H5ScriptLoader"
            java.lang.String r2 = "invalid web view parameter!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r2)
            return r1
        L_0x000d:
            java.lang.String r0 = r0.getUrl()
            r8.curUrl = r0
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Object r0 = r8.loaderLock
            monitor-enter(r0)
            com.alipay.mobile.nebulacore.web.H5WebView r4 = r8.webView     // Catch:{ all -> 0x0108 }
            r8.loadDynamic(r4)     // Catch:{ all -> 0x0108 }
            boolean r4 = r8.bridgeLoaded     // Catch:{ all -> 0x0108 }
            r5 = 1
            if (r4 == 0) goto L_0x002a
            boolean r4 = r8.bizLoaded     // Catch:{ all -> 0x0108 }
            if (r4 == 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            return r5
        L_0x002a:
            android.os.Bundle r4 = r8.startParam     // Catch:{ all -> 0x0108 }
            java.lang.String r6 = "isPrerender"
            boolean r1 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r4, (java.lang.String) r6, (boolean) r1)     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x0046
            com.alipay.mobile.h5container.api.H5Page r1 = r8.h5Page     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = "H5ScriptLoader"
            java.lang.String r4 = "injectPageReady when normal window present"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r4)     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.h5container.api.H5Page r1 = r8.h5Page     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.nebulacore.core.H5PageImpl r1 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r1     // Catch:{ all -> 0x0108 }
            r1.injectPageReady()     // Catch:{ all -> 0x0108 }
        L_0x0046:
            boolean r1 = r8.bridgeLoaded     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x004f
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            r8.loadBridge(r1)     // Catch:{ all -> 0x0108 }
        L_0x004f:
            boolean r1 = r8.bizLoaded     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x00ba
            r8.bizLoaded = r5     // Catch:{ all -> 0x0108 }
            boolean r1 = r8.enableScan     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0064
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5_scan     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
        L_0x0064:
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5_share_new_min     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
            boolean r1 = r8.tinyApp     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = "yes"
            java.lang.String r4 = "h5_loadJavascript_for_tiny"
            java.lang.String r4 = com.alipay.mobile.nebulacore.env.H5Environment.getConfigWithProcessCache(r4)     // Catch:{ all -> 0x0108 }
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0108 }
            if (r1 != 0) goto L_0x0084
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            return r5
        L_0x0084:
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5_performance     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5_bizlog_pre     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5_startparam     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.h5container.api.H5Page r1 = r8.h5Page     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "getLocation"
            boolean r1 = com.alipay.mobile.nebulacore.Nebula.supportJsaApi(r1, r4)     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x00ba
            com.alipay.mobile.nebulacore.web.H5WebView r1 = r8.webView     // Catch:{ all -> 0x0108 }
            int r4 = com.alipay.mobile.nebulacore.R.raw.h5location_min     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.getRaw(r4)     // Catch:{ all -> 0x0108 }
            r8.loadJavascript(r1, r4)     // Catch:{ all -> 0x0108 }
        L_0x00ba:
            boolean r1 = com.alipay.mobile.nebulacore.Nebula.DEBUG     // Catch:{ all -> 0x0108 }
            if (r1 == 0) goto L_0x00e4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            r1.<init>()     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "console.log('%cWelcome to NEBULA%c powered by UC\\n%cTips:\\n', 'color:#1874CD;font-size:20px','color:#FF7F24;font-size:15px','color:red;font-size:13px');"
            r1.append(r4)     // Catch:{ all -> 0x0108 }
            java.lang.String r4 = "console.log('%c1.ajax with get method may be cached, you can try to set \\'Cache-control: no-cache\\' in server side or add random param in request url','color:red;font-size:13px');"
            r1.append(r4)     // Catch:{ all -> 0x0108 }
            com.alipay.mobile.nebulacore.web.H5WebView r4 = r8.webView     // Catch:{ all -> 0x0108 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0108 }
            java.lang.String r7 = "javascript:"
            r6.<init>(r7)     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0108 }
            r6.append(r1)     // Catch:{ all -> 0x0108 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0108 }
            r4.loadUrl(r1)     // Catch:{ all -> 0x0108 }
        L_0x00e4:
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "load javascript elapse ["
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = "] for "
            r2.append(r0)
            java.lang.String r0 = r8.curUrl
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "H5ScriptLoader"
            com.alipay.mobile.nebula.util.H5Log.d(r1, r0)
            return r5
        L_0x0108:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0108 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5ScriptLoader.loadScript():boolean");
    }

    public void setParamsToWebPage(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            H5Log.e(TAG, "invalid js parameters!");
            return;
        }
        synchronized (this.loaderLock) {
            this.bridgeParams.put(str, str2);
            if (!this.bridgeLoaded) {
                H5Log.d(TAG, "bridge not loaded.");
                return;
            }
            H5Log.d(TAG, "setParamsToWebPage [key] " + str + " [value] " + str2);
            H5WebView h5WebView = this.webView;
            h5WebView.loadUrl("javascript:if(typeof AlipayJSBridge === 'object'){AlipayJSBridge." + str + "=" + str2 + "}");
        }
    }

    private void loadBridge(H5WebView h5WebView) {
        long currentTimeMillis = System.currentTimeMillis();
        String composeBridge = composeBridge();
        H5Log.d(TAG, "bridgeStr ".concat(String.valueOf(composeBridge)));
        h5WebView.loadUrl("javascript:".concat(String.valueOf(composeBridge)));
        H5Log.d(TAG, "bridge data loaded!");
        H5Log.d(TAG, "load bridge delta time ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public String composeBridge() {
        if (this.bridgeLoaded) {
            H5Log.d(TAG, "bridge already loaded!");
            return null;
        }
        H5Log.d(TAG, "composeBridge " + System.currentTimeMillis());
        this.bridgeLoaded = true;
        HashMap<String, String> hashMap = this.bridgeParams;
        H5Page h5Page2 = this.h5Page;
        return Nebula.loadJsBridge(hashMap, 1, h5Page2 != null ? h5Page2.getWebViewId() : -1);
    }

    private void loadDynamic(final H5WebView h5WebView) {
        final String configWithProcessCache = H5Environment.getConfigWithProcessCache(this.tinyApp ? "h5_dsRulesForTinyApp" : "h5_dsRules");
        if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isTinyApp, false)) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5ScriptLoader.this.loadDynamicJs(h5WebView, configWithProcessCache);
                }
            }, 1000);
        } else {
            loadDynamicJs(h5WebView, configWithProcessCache);
        }
        if (Nebula.DEBUG) {
            loadDynamicJs4Jsapi(h5WebView, (String) null);
        }
    }

    public void loadDynamicJs(H5WebView h5WebView, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String sb = getDynamicScriptBuilder(h5WebView, str).toString();
        if (!TextUtils.isEmpty(sb)) {
            loadJavascript(h5WebView, getAllJsV2(sb));
            H5Log.d(TAG, "load dynamic delta time ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    public void loadDynamicJs4Jsapi(H5WebView h5WebView, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(H5DevConfig.H5_LOAD_JS)) {
            str = H5DevConfig.H5_LOAD_JS;
        }
        if (TextUtils.isEmpty(str)) {
            H5Log.d(TAG, "load loadDynamicJs4Jsapi none return");
            return;
        }
        StringBuilder dynamicScriptBuilder = getDynamicScriptBuilder(h5WebView, str);
        loadJavascript(h5WebView, "(function(){function onDOMReady(callback){var readyRE=/complete|loaded|interactive/;if(readyRE.test(document.readyState)){setTimeout(function(){callback()},1);}else{document.defaultView.addEventListener(\"DOMContentLoaded\",function(){callback()},false);}}onDOMReady(function(){" + dynamicScriptBuilder + "console.log(\"load insertJS success\")});})();");
        H5Log.d(TAG, "load dynamic4jsapi delta time ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    private StringBuilder getDynamicScriptBuilder(H5WebView h5WebView, String str) {
        StringBuilder sb = new StringBuilder();
        if (h5WebView == null || TextUtils.isEmpty(str)) {
            H5Log.d(TAG, "no config found for dynamic script");
            return sb;
        }
        b parseArray = H5Utils.parseArray(str);
        if (parseArray == null || parseArray.isEmpty()) {
            H5Log.w(TAG, "invalid dynamic script.");
            return sb;
        }
        for (int i2 = 0; i2 < parseArray.size(); i2++) {
            List<String> list = null;
            try {
                list = parseDynamic(parseArray.getJSONObject(i2));
            } catch (Throwable th) {
                H5Log.e(TAG, "parse dynamic script exception.", th);
            }
            if (list != null && !list.isEmpty()) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        sb.append(getLoadJsStrV2(next));
                    }
                }
            }
        }
        return sb;
    }

    private String getAllJsV2(String str) {
        return "(function(){if(window.HASINJECTDRNAMICSCRIPT){console.log(\"has load h5_dsRulesV2: \"+window.HASINJECTDRNAMICSCRIPT);return}window.HASINJECTDRNAMICSCRIPT=false;function onDOMReady(callback){var readyRE=/complete|loaded|interactive/;if(readyRE.test(document.readyState)){setTimeout(function(){callback()},1)}else{document.defaultView.addEventListener(\"DOMContentLoaded\",function(){callback()},false)}}onDOMReady(function(){if(!window.HASINJECTDRNAMICSCRIPT){" + str + "console.log(\"load h5_dsRulesV2 success\");window.HASINJECTDRNAMICSCRIPT=true}})})();";
    }

    private String getLoadJsStrV2(String str) {
        H5Log.d(TAG, "load dynamicV2 script ".concat(String.valueOf(str)));
        return "var script,head=document.head||document.documentElement;script=document.createElement(\"script\");script.async=true;script.charset=\"UTF-8\";script.src=\"" + str + "\";" + getCrossOrigin(str) + "head.insertBefore(script,head.firstChild);";
    }

    private String getCrossOrigin(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("nebula-addcors")) ? "" : "script.setAttribute('crossorigin','');";
    }

    private List<String> parseDynamic(e eVar) {
        if (this.webView == null || eVar == null || eVar.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : eVar.keySet()) {
            if (!TextUtils.isEmpty(next)) {
                b jSONArray = eVar.getJSONArray(next);
                if (jSONArray != null && !jSONArray.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.size()) {
                            break;
                        }
                        e jSONObject = jSONArray.getJSONObject(i2);
                        String string = H5Utils.getString(jSONObject, "appId");
                        String string2 = H5Utils.getString(jSONObject, H5Param.PUBLIC_ID);
                        String string3 = H5Utils.getString(jSONObject, "url");
                        if ((TextUtils.isEmpty(string) || ifMatch(this.curAppId, string)) && (TextUtils.isEmpty(string2) || ifMatch(this.curPublicId, string2)) && (TextUtils.isEmpty(string3) || ifMatch(this.curUrl, string3))) {
                            arrayList.add(next);
                            break;
                        }
                        i2++;
                    }
                } else {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private boolean ifMatch(String str, String str2) {
        Pattern compile = H5PatternHelper.compile(str2);
        if (compile == null) {
            return false;
        }
        return compile.matcher(str).find();
    }

    private void loadJavascript(H5WebView h5WebView, String str) {
        if (!TextUtils.isEmpty(str)) {
            h5WebView.loadUrl("javascript:".concat(String.valueOf(str)));
        }
    }
}
