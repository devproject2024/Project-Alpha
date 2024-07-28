package com.alipay.mobile.nebulacore.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.a.b;
import com.alipay.mobile.c.a;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5WebViewChoose;
import com.alipay.mobile.nebulacore.ui.H5Activity;

public class H5WebViewFactory {
    private static final String TAG = "H5WebViewFactory";
    private static H5WebViewFactory sInstance;

    private H5WebViewFactory() {
    }

    public static H5WebViewFactory instance() {
        if (sInstance == null) {
            sInstance = new H5WebViewFactory();
        }
        return sInstance;
    }

    private boolean canUseAndroidWebView(Activity activity, String str, Bundle bundle) {
        b parseArray;
        if (!H5Flag.initUcNormal) {
            H5Log.e(TAG, "uc init throw exception, so not need init ");
            return true;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if ((h5ConfigProvider != null && (parseArray = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_first_init_use_android_webView_biz"))) != null && !parseArray.isEmpty() && parseArray.contains(str)) || H5WebViewChoose.useSysWebWillCrash()) {
            return false;
        }
        if ((activity instanceof H5Activity) && !H5Utils.getBoolean(bundle, H5Param.FIRST_INIT_USE_ANDROID_WEBVIEW, false) && h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_first_init_use_android_webView_startPage"))) {
            return false;
        }
        return true;
    }

    private void checkSplitCompat(Context context) {
        H5SplitCompatUtils.doInstall(context);
        H5SplitCompatUtils.doInstall(a.f14949b);
        H5SplitCompatUtils.doInstall(a.f14950c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alipay.mobile.nebula.webview.APWebView createWebView(android.app.Activity r24, java.lang.String r25, android.content.Context r26, android.os.Bundle r27) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            long r6 = java.lang.System.currentTimeMillis()
            com.alipay.mobile.h5container.api.H5PageData.webViewCreateStart = r6
            long r6 = java.lang.System.currentTimeMillis()
            com.alipay.mobile.nebula.webview.WebViewType r8 = com.alipay.mobile.nebulacore.env.H5WebViewChoose.getWebViewType(r25, r26, r27)
            com.alibaba.a.e r9 = new com.alibaba.a.e
            r9.<init>()
            com.alipay.mobile.nebula.webview.WebViewType r0 = com.alipay.mobile.nebula.webview.WebViewType.RN_VIEW
            java.lang.String r10 = "degradeWebView"
            java.lang.String r12 = "H5WebViewFactory"
            if (r8 != r0) goto L_0x0054
            com.alipay.mobile.h5container.service.RnService r0 = com.alipay.mobile.nebulacore.env.H5Environment.getRnService()
            if (r0 == 0) goto L_0x004f
            java.lang.String r13 = "create rn view"
            com.alipay.mobile.nebula.util.H5Log.d(r12, r13)     // Catch:{ all -> 0x003a }
            com.alipay.mobile.nebula.webview.APWebView r13 = r0.createWebView(r4)     // Catch:{ all -> 0x003a }
            r1.checkSplitCompat(r4)     // Catch:{ all -> 0x0038 }
            goto L_0x0055
        L_0x0038:
            r0 = move-exception
            goto L_0x003c
        L_0x003a:
            r0 = move-exception
            r13 = 0
        L_0x003c:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r9.put((java.lang.String) r10, (java.lang.Object) r14)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r14 = "create ReactNebulaView fail:"
            java.lang.String r0 = r14.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r12, (java.lang.String) r0)
            goto L_0x0055
        L_0x004f:
            java.lang.String r0 = "failed to get rn service"
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)
        L_0x0054:
            r13 = 0
        L_0x0055:
            com.alipay.mobile.nebula.webview.WebViewType r0 = com.alipay.mobile.nebula.webview.WebViewType.THIRD_PARTY
            java.lang.String r14 = "H5WebViewFactory^createAndroidWebViewException="
            java.lang.String r15 = "create android webview failed"
            if (r8 != r0) goto L_0x0105
            boolean r0 = com.alipay.mobile.h5container.api.H5Flag.ucReady
            if (r0 != 0) goto L_0x009d
            boolean r0 = r1.canUseAndroidWebView(r2, r3, r5)
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = "uc is not Ready canUseAndroidWebView create android web view "
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)     // Catch:{ all -> 0x0074 }
            com.alipay.mobile.nebulacore.android.AndroidWebView r13 = new com.alipay.mobile.nebulacore.android.AndroidWebView     // Catch:{ all -> 0x0074 }
            r13.<init>(r4)     // Catch:{ all -> 0x0074 }
            goto L_0x0105
        L_0x0074:
            r0 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r12, r15, r0)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r2 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r3 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.Object r2 = r2.getProvider(r3)
            r3 = r2
            com.alipay.mobile.nebula.provider.H5LogProvider r3 = (com.alipay.mobile.nebula.provider.H5LogProvider) r3
            if (r3 == 0) goto L_0x009c
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r9 = r14.concat(r2)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r4 = "H5WebViewFactory"
            r3.log(r4, r5, r6, r7, r8, r9)
        L_0x009c:
            throw r0
        L_0x009d:
            com.alipay.mobile.h5container.service.UcService r0 = com.alipay.mobile.nebulacore.env.H5Environment.getUcService()
            if (r0 != 0) goto L_0x00a9
            java.lang.String r0 = "failed to get uc service"
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)
            goto L_0x0105
        L_0x00a9:
            java.lang.String r11 = "create uc web view"
            com.alipay.mobile.nebula.util.H5Log.d(r12, r11)     // Catch:{ all -> 0x00cf }
            boolean r11 = com.alipay.mobile.nebulacore.Nebula.disableHWACByUCStyle()     // Catch:{ all -> 0x00cf }
            if (r11 == 0) goto L_0x00c2
            boolean r3 = com.alipay.mobile.nebulacore.web.H5HardwarePolicy.disableHardwareAccelerate(r5, r3)     // Catch:{ all -> 0x00cf }
            if (r3 != 0) goto L_0x00bc
            r11 = 1
            goto L_0x00bd
        L_0x00bc:
            r11 = 0
        L_0x00bd:
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.createWebView(r4, r11)     // Catch:{ all -> 0x00cf }
            goto L_0x00ca
        L_0x00c2:
            boolean r3 = com.alipay.mobile.nebulacore.web.H5HardwarePolicy.isAbove14Level()     // Catch:{ all -> 0x00cf }
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.createWebView(r4, r3)     // Catch:{ all -> 0x00cf }
        L_0x00ca:
            r13 = r0
            r1.checkSplitCompat(r4)     // Catch:{ all -> 0x00cf }
            goto L_0x0105
        L_0x00cf:
            r0 = move-exception
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r9.put((java.lang.String) r10, (java.lang.Object) r3)
            java.lang.String r3 = "create uc web view failed"
            com.alipay.mobile.nebula.util.H5Log.e(r12, r3, r0)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r3 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r10 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r10 = r10.getName()
            java.lang.Object r3 = r3.getProvider(r10)
            r16 = r3
            com.alipay.mobile.nebula.provider.H5LogProvider r16 = (com.alipay.mobile.nebula.provider.H5LogProvider) r16
            if (r16 == 0) goto L_0x0105
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "H5WebViewFactory^createUCWebViewException="
            java.lang.String r22 = r3.concat(r0)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r17 = "H5WebViewFactory"
            r16.log(r17, r18, r19, r20, r21, r22)
        L_0x0105:
            if (r13 != 0) goto L_0x0113
            boolean r0 = com.alipay.mobile.h5container.api.H5Flag.ucReady
            if (r0 != 0) goto L_0x0113
            com.alipay.mobile.nebula.webview.WebViewType r0 = com.alipay.mobile.nebula.webview.WebViewType.THIRD_PARTY
            if (r8 != r0) goto L_0x0113
            r3 = 0
            com.alipay.mobile.nebulacore.env.H5WebViewChoose.sendUcReceiver(r3)
        L_0x0113:
            if (r13 != 0) goto L_0x0162
            java.lang.String r0 = "create android webview"
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.android.AndroidWebViewPreCreator.init()     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.android.AndroidWebView r3 = com.alipay.mobile.nebulacore.android.AndroidWebViewPreCreator.getInstance(r26)     // Catch:{ all -> 0x012f }
            if (r3 != 0) goto L_0x012d
            com.alipay.mobile.nebulacore.android.AndroidWebView r0 = new com.alipay.mobile.nebulacore.android.AndroidWebView     // Catch:{ all -> 0x012a }
            r0.<init>(r4)     // Catch:{ all -> 0x012a }
            r13 = r0
            goto L_0x0162
        L_0x012a:
            r0 = move-exception
            r13 = r3
            goto L_0x0130
        L_0x012d:
            r13 = r3
            goto L_0x0162
        L_0x012f:
            r0 = move-exception
        L_0x0130:
            com.alipay.mobile.nebula.util.H5Log.e(r12, r15, r0)
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r3 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r4 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r4 = r4.getName()
            java.lang.Object r3 = r3.getProvider(r4)
            r16 = r3
            com.alipay.mobile.nebula.provider.H5LogProvider r16 = (com.alipay.mobile.nebula.provider.H5LogProvider) r16
            if (r16 == 0) goto L_0x015c
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r22 = r14.concat(r3)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r17 = "H5WebViewFactory"
            r16.log(r17, r18, r19, r20, r21, r22)
        L_0x015c:
            boolean r2 = r2 instanceof com.alipay.mobile.nebulacore.ui.H5Activity
            if (r2 != 0) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            throw r0
        L_0x0162:
            if (r13 == 0) goto L_0x017c
            java.lang.String r0 = r13.getVersion()
            java.lang.String r2 = "version"
            r9.put((java.lang.String) r2, (java.lang.Object) r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "webview version: "
            java.lang.String r0 = r2.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)
        L_0x017c:
            com.alipay.mobile.nebulacore.api.NebulaService r0 = com.alipay.mobile.nebulacore.Nebula.getService()
            if (r0 == 0) goto L_0x01ad
            com.alipay.mobile.nebulacore.api.NebulaService r0 = com.alipay.mobile.nebulacore.Nebula.getService()
            com.alipay.mobile.h5container.api.H5Session r0 = r0.getTopSession()
            if (r0 == 0) goto L_0x01ad
            com.alipay.mobile.nebulacore.api.NebulaService r0 = com.alipay.mobile.nebulacore.Nebula.getService()
            com.alipay.mobile.h5container.api.H5Session r0 = r0.getTopSession()
            com.alipay.mobile.h5container.api.H5Page r0 = r0.getTopPage()
            if (r0 == 0) goto L_0x01ad
            com.alipay.mobile.nebulacore.api.NebulaService r0 = com.alipay.mobile.nebulacore.Nebula.getService()
            com.alipay.mobile.h5container.api.H5Session r0 = r0.getTopSession()
            com.alipay.mobile.h5container.api.H5Page r0 = r0.getTopPage()
            if (r0 == 0) goto L_0x01ad
            java.lang.String r2 = "h5PageCreateWebView"
            r0.sendEvent(r2, r9)
        L_0x01ad:
            if (r13 == 0) goto L_0x01f4
            com.alipay.mobile.nebula.webview.WebViewType r0 = com.alipay.mobile.nebula.webview.WebViewType.SYSTEM_BUILD_IN
            com.alipay.mobile.nebula.webview.WebViewType r2 = r13.getType()
            if (r0 != r2) goto L_0x01f4
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r0 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r2 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r0 = r0.getProvider(r2)
            r16 = r0
            com.alipay.mobile.nebula.provider.H5LogProvider r16 = (com.alipay.mobile.nebula.provider.H5LogProvider) r16
            if (r16 == 0) goto L_0x01f4
            java.lang.String r0 = "appId"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r5, (java.lang.String) r0)
            java.lang.String r2 = "isTinyApp"
            r3 = 0
            boolean r2 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r5, (java.lang.String) r2, (boolean) r3)
            java.lang.String r20 = java.lang.String.valueOf(r2)
            r22 = 0
            java.lang.String r17 = "H5_WebView_Type"
            java.lang.String r19 = "AndroidWebView"
            java.lang.String r21 = "use Android System WebView"
            r18 = r0
            r16.log(r17, r18, r19, r20, r21, r22)
            if (r2 == 0) goto L_0x01f4
            java.lang.String r2 = "MTBIZ_H5"
            java.lang.String r3 = "H5_TinyApp_Use_AndroidWebView"
            r4 = 0
            com.alipay.mobile.nebulacore.wallet.H5Logger.mtBizReport(r2, r3, r0, r4)
        L_0x01f4:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r0 == 0) goto L_0x0205
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "pageLoad|createWebViewFinishPoint"
            com.alipay.mobile.nebula.util.TestDataUtils.storeJSParams(r2, r0)
        L_0x0205:
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r6
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "createWebView elapse "
            java.lang.String r0 = r2.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r12, r0)
            java.lang.String r0 = "create_webView"
            com.alipay.mobile.nebulacore.util.H5TimeUtil.timeLog(r0, r0, r6)
            long r2 = java.lang.System.currentTimeMillis()
            com.alipay.mobile.h5container.api.H5PageData.webViewCreateEnd = r2
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.wallet.H5WebViewFactory.createWebView(android.app.Activity, java.lang.String, android.content.Context, android.os.Bundle):com.alipay.mobile.nebula.webview.APWebView");
    }
}
