package com.alipay.mobile.nebulacore.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AliPayUaProvider;
import com.alipay.mobile.nebula.provider.H5ChannelProvider;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5NebulaLabelProvider;
import com.alipay.mobile.nebula.provider.H5PreConnectProvider;
import com.alipay.mobile.nebula.provider.H5UaProvider;
import com.alipay.mobile.nebula.provider.H5WebViewSettingsProvider;
import com.alipay.mobile.nebula.refresh.H5OverScrollListener;
import com.alipay.mobile.nebula.refresh.H5PullableView;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback;
import com.alipay.mobile.nebula.webview.APDownloadListener;
import com.alipay.mobile.nebula.webview.APHitTestResult;
import com.alipay.mobile.nebula.webview.APWebBackForwardList;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebSettings;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebula.webview.APWebViewListener;
import com.alipay.mobile.nebula.webview.H5ScrollChangedCallback;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.wallet.H5WebViewFactory;
import java.util.Map;

public class H5WebView implements H5PullableView, APWebView {
    public static final String ENABLE_WEBVIEW_DATABASE = "h5_enableDatabase";
    private static int WEB_VIEW_INDEX;
    public String TAG = "H5WebView";
    protected APWebView apWebView;
    private String appId;
    private H5Page h5Page;
    /* access modifiers changed from: private */
    public H5OverScrollListener mH5OverScrollListener;
    private float mScale = 1.0f;
    private boolean released = false;
    private Bundle startParam;
    private String userAgent;
    private Bundle webViewConfig;
    private int webViewIndex = 0;

    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
    }

    public H5WebView(final Activity activity, final H5Page h5Page2, Bundle bundle) {
        this.TAG += hashCode();
        this.webViewConfig = bundle;
        this.h5Page = h5Page2;
        this.startParam = h5Page2.getParams();
        String string = H5Utils.getString(bundle, H5Param.LONG_BIZ_TYPE);
        this.appId = H5Utils.getString(h5Page2.getParams(), "appId");
        H5Log.d(this.TAG, "createWebView bizType ".concat(String.valueOf(string)));
        this.apWebView = H5WebViewFactory.instance().createWebView(activity, string, activity, h5Page2.getParams());
        h5Page2.setWebViewId(Nebula.getWebViewId());
        APWebView aPWebView = this.apWebView;
        if (aPWebView == null) {
            H5Log.e(this.TAG, "apWebView == null return");
            return;
        }
        String version = aPWebView.getVersion();
        H5Log.d(this.TAG, "webViewVersion is " + version + " webViewId " + h5Page2.getWebViewId());
        if (!Nebula.disableHWACByUCStyle() && H5HardwarePolicy.disableHardwareAccelerate(this.startParam, string)) {
            H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log("H5UcService", (String) null, (String) null, (String) null, "hardware accelerate off");
            }
            View view = this.apWebView.getView();
            if (view != null) {
                try {
                    H5Log.d(this.TAG, "diable webview layer hardware accelerate.");
                    view.setLayerType(1, (Paint) null);
                } catch (Throwable th) {
                    H5Log.e(this.TAG, "set webview layer exception.", th);
                }
            }
        }
        this.apWebView.setAPWebViewListener(new APWebViewListener() {
            public boolean overScrollBy(int i2, int i3, int i4, int i5) {
                String str = H5WebView.this.TAG;
                H5Log.d(str, "overScrollBy: " + i2 + ", " + i3 + ", " + i4 + ", " + i5);
                if (H5WebView.this.mH5OverScrollListener == null) {
                    return false;
                }
                H5WebView.this.mH5OverScrollListener.onOverScrolled(i2, i3, i4, i5);
                return false;
            }

            public void onDetachedFromWindow() {
                H5Log.w(H5WebView.this.TAG, "onDetachedFromWindow");
                if (!(activity instanceof H5Activity)) {
                    H5Log.d(H5WebView.this.TAG, "onDetachedFromWindow h5Page.doExitPage()");
                    H5Page h5Page = h5Page2;
                    if (h5Page != null) {
                        h5Page.exitPage();
                    }
                }
            }

            public View getEmbedView(int i2, int i3, String str, String str2, Map<String, String> map) {
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient getEmbedView");
                H5Page h5Page = h5Page2;
                if (h5Page == null) {
                    return null;
                }
                h5Page.setContainsEmbedView(true);
                H5EmbededViewProvider embededViewProvider = h5Page2.getEmbededViewProvider();
                if (embededViewProvider != null) {
                    return embededViewProvider.getEmbedView(i2, i3, str, str2, map);
                }
                return null;
            }

            public void onEmbedViewAttachedToWebView(int i2, int i3, String str, String str2, Map<String, String> map) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient onEmbedViewAttachedToWebView");
                H5Page h5Page = h5Page2;
                if (h5Page != null && (embededViewProvider = h5Page.getEmbededViewProvider()) != null) {
                    embededViewProvider.onEmbedViewAttachedToWebView(i2, i3, str, str2, map);
                }
            }

            public void onEmbedViewDetachedFromWebView(int i2, int i3, String str, String str2, Map<String, String> map) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient onEmbedViewDetachedFromWebView");
                H5Page h5Page = h5Page2;
                if (h5Page != null && (embededViewProvider = h5Page.getEmbededViewProvider()) != null) {
                    embededViewProvider.onEmbedViewDetachedFromWebView(i2, i3, str, str2, map);
                }
            }

            public void onEmbedViewDestory(int i2, int i3, String str, String str2, Map<String, String> map) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient onEmbedViewDestory");
                H5Page h5Page = h5Page2;
                if (h5Page != null && (embededViewProvider = h5Page.getEmbededViewProvider()) != null) {
                    embededViewProvider.onEmbedViewDestory(i2, i3, str, str2, map);
                }
            }

            public void onEmbedViewParamChanged(int i2, int i3, String str, String str2, Map<String, String> map, String[] strArr, String[] strArr2) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient onEmbedViewParamChanged");
                H5Page h5Page = h5Page2;
                if (h5Page != null && (embededViewProvider = h5Page.getEmbededViewProvider()) != null) {
                    embededViewProvider.onEmbedViewParamChanged(i2, i3, str, str2, map, strArr, strArr2);
                }
            }

            public void onEmbedViewVisibilityChanged(int i2, int i3, String str, String str2, Map<String, String> map, int i4) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient onEmbedViewVisibilityChanged");
                H5Page h5Page = h5Page2;
                if (h5Page != null && (embededViewProvider = h5Page.getEmbededViewProvider()) != null) {
                    embededViewProvider.onEmbedViewVisibilityChanged(i2, i3, str, str2, map, i4);
                }
            }

            public Bitmap getSnapshot(int i2, int i3, String str, String str2, Map<String, String> map) {
                H5EmbededViewProvider embededViewProvider;
                H5Log.d(H5WebView.this.TAG, "H5WebViewClient getSnapshot");
                H5Page h5Page = h5Page2;
                if (h5Page == null || (embededViewProvider = h5Page.getEmbededViewProvider()) == null) {
                    return null;
                }
                return embededViewProvider.getSnapshot(i2, i3, str, str2, map);
            }
        });
        boolean z = H5Utils.getBoolean(h5Page2.getParams(), H5Param.LONG_ENABLE_SCROLLBAR, true);
        H5Log.d(this.TAG, "enableScrollBar:".concat(String.valueOf(z)));
        if (!z) {
            this.apWebView.setHorizontalScrollBarEnabled(z);
            this.apWebView.setVerticalScrollBarEnabled(z);
        }
        int i2 = WEB_VIEW_INDEX;
        WEB_VIEW_INDEX = i2 + 1;
        this.webViewIndex = i2;
    }

    public int getWebViewIndex() {
        return this.webViewIndex;
    }

    public void init(boolean z) {
        H5Log.d(this.TAG, "initWebView");
        initUserAgent();
        preRequestMainFrame();
        applyCustomSettings(z);
        if (this.apWebView == null) {
            H5Log.e(this.TAG, "FATAL ERROR, the internal glue apWebView is null!");
        }
        if (Nebula.DEBUG) {
            setWebContentsDebuggingEnabled(true);
        }
    }

    private void preRequestMainFrame() {
        H5PreConnectProvider h5PreConnectProvider;
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null) {
            String string = H5Utils.getString(h5Page2.getParams(), "url");
            if (!TextUtils.isEmpty(string) && (h5PreConnectProvider = (H5PreConnectProvider) H5Utils.getProvider(H5PreConnectProvider.class.getName())) != null) {
                h5PreConnectProvider.preConnect(string, this.h5Page);
                if (TextUtils.isEmpty(H5AppUtil.matchAppId(string))) {
                    h5PreConnectProvider.preRequest(string, this.h5Page);
                }
            }
        }
    }

    private void applyCustomSettings(boolean z) {
        H5Log.d(this.TAG, "applyCustomSettings allowAccessFromFileURL ".concat(String.valueOf(z)));
        APWebSettings settings = getSettings();
        settings.setEnableFastScroller(false);
        settings.setPageCacheCapacity(0);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setSupportMultipleWindows(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            H5Log.d(this.TAG, "Ignore the exception in AccessibilityInjector when init");
            H5Log.e(this.TAG, "exception detail", e2);
        }
        settings.setDefaultFontSize(16);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setPluginState(APWebSettings.PluginState.ON);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(z);
        String str = NebulaUtil.getApplicationDir() + "/app_h5container";
        H5FileUtil.mkdirs(str);
        settings.setDatabaseEnabled(H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Environment.getConfig(ENABLE_WEBVIEW_DATABASE)));
        if (Build.VERSION.SDK_INT < 19) {
            H5FileUtil.mkdirs(str + "/databases");
            settings.setDatabasePath(str + "/databases");
        }
        H5FileUtil.mkdirs(str + "/appcache");
        settings.setAppCachePath(str + "/appcache");
        settings.setAppCacheEnabled(true);
        settings.getUserAgentString();
        if (H5NetworkUtil.getInstance().getNetworkType() == H5NetworkUtil.Network.NETWORK_NO_CONNECTION) {
            settings.setCacheMode(1);
        } else {
            settings.setCacheMode(-1);
        }
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setGeolocationEnabled(true);
        H5FileUtil.mkdirs(str + "/geolocation");
        settings.setGeolocationDatabasePath(str + "/geolocation");
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        settings.setAllowFileAccessFromFileURLs(z);
        settings.setAllowUniversalAccessFromFileURLs(z);
        settings.setTextSize(APWebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        final H5WebViewSettingsProvider h5WebViewSettingsProvider = (H5WebViewSettingsProvider) H5Utils.getProvider(H5WebViewSettingsProvider.class.getName());
        if (h5WebViewSettingsProvider != null && !H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(H5Environment.getConfig("h5_custom_websettings"))) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    try {
                        View view = H5WebView.this.getView();
                        WebView webView = null;
                        if (view instanceof WebView) {
                            webView = (WebView) view;
                        }
                        if (webView != null) {
                            h5WebViewSettingsProvider.customWebViewSettings(webView.getSettings());
                        }
                    } catch (Exception e2) {
                        H5Log.e(H5WebView.this.TAG, "custom websettings failed", e2);
                    }
                }
            });
        }
    }

    private void initUserAgent() {
        String str;
        APWebSettings settings = getSettings();
        try {
            String userAgentString = settings.getUserAgentString();
            H5ChannelProvider h5ChannelProvider = (H5ChannelProvider) Nebula.getProviderManager().getProvider(H5ChannelProvider.class.getName());
            String str2 = "default";
            if (h5ChannelProvider != null) {
                str2 = h5ChannelProvider.getChannelId();
            }
            if ("5136".equals(str2)) {
                str = userAgentString.replace("534.30", "537.36") + " AlipayChannelId/" + str2;
            } else {
                str = userAgentString;
            }
            if (!str.contains("UCBS") && str.contains("UWS")) {
                str = str + " UCBS/" + getVersion();
            }
            String str3 = " Nebula NebulaSDK/1.7.0";
            H5NebulaLabelProvider h5NebulaLabelProvider = (H5NebulaLabelProvider) H5Utils.getProvider(H5NebulaLabelProvider.class.getName());
            if (h5NebulaLabelProvider != null) {
                str3 = h5NebulaLabelProvider.getLabel();
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
            }
            String str4 = str + str3;
            H5UaProvider h5UaProvider = (H5UaProvider) Nebula.getProviderManager().getProvider(H5UaProvider.class.getName());
            H5AliPayUaProvider h5AliPayUaProvider = (H5AliPayUaProvider) Nebula.getProviderManager().getProvider(H5AliPayUaProvider.class.getName());
            if (h5UaProvider != null) {
                this.userAgent = h5UaProvider.getUa(str4);
            } else {
                this.userAgent = getDefaultUserAgent(str4);
                if (h5AliPayUaProvider != null) {
                    this.userAgent = h5AliPayUaProvider.getUa(this.userAgent);
                }
            }
            setUserAgent(settings, this.userAgent, userAgentString);
            H5Log.d(this.TAG, "set final ua " + this.userAgent);
            if (Nebula.DEBUG) {
                H5Log.d(this.TAG, "final user agent " + settings.getUserAgentString());
            }
        } catch (Exception e2) {
            H5Log.e(this.TAG, "setUserAgent exception", e2);
        }
    }

    private void setUserAgent(APWebSettings aPWebSettings, String str, String str2) {
        b parseArray = H5Utils.parseArray(H5Environment.getConfig("h5_handle4ua"));
        if (parseArray == null || !parseArray.contains(this.appId)) {
            aPWebSettings.setUserAgentString(str);
        } else {
            aPWebSettings.setUserAgentString(str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getDefaultUserAgent(java.lang.String r10) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r9 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = com.alipay.mobile.nebulacore.env.H5Environment.getContext()
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x008a }
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()     // Catch:{ Exception -> 0x008a }
            if (r1 == 0) goto L_0x0092
            float r2 = r1.density     // Catch:{ Exception -> 0x008a }
            int r3 = r1.widthPixels     // Catch:{ Exception -> 0x008a }
            float r3 = (float) r3     // Catch:{ Exception -> 0x008a }
            float r3 = r3 / r2
            int r3 = java.lang.Math.round(r3)     // Catch:{ Exception -> 0x008a }
            com.alipay.mobile.h5container.api.H5Page r4 = r9.h5Page     // Catch:{ Exception -> 0x008a }
            int r1 = com.alipay.mobile.nebulacore.Nebula.getHeight(r4, r2, r1)     // Catch:{ Exception -> 0x008a }
            java.lang.String r4 = com.alipay.mobile.nebulacore.util.AccessibilityUtil.getEnabledAccessibilities()     // Catch:{ Exception -> 0x008a }
            java.lang.String r5 = ")"
            java.lang.String r6 = ",ws:"
            java.lang.String r7 = " AlipayDefined(nt:"
            java.lang.String r8 = "|"
            if (r4 == 0) goto L_0x0060
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008a }
            r4.<init>(r7)     // Catch:{ Exception -> 0x008a }
            com.alipay.mobile.nebula.util.H5NetworkUtil r7 = com.alipay.mobile.nebula.util.H5NetworkUtil.getInstance()     // Catch:{ Exception -> 0x008a }
            java.lang.String r7 = r7.getNetworkString()     // Catch:{ Exception -> 0x008a }
            r4.append(r7)     // Catch:{ Exception -> 0x008a }
            r4.append(r6)     // Catch:{ Exception -> 0x008a }
            r4.append(r3)     // Catch:{ Exception -> 0x008a }
            r4.append(r8)     // Catch:{ Exception -> 0x008a }
            r4.append(r1)     // Catch:{ Exception -> 0x008a }
            r4.append(r8)     // Catch:{ Exception -> 0x008a }
            r4.append(r2)     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = com.alipay.mobile.nebulacore.util.AccessibilityUtil.getEnabledAccessibilities()     // Catch:{ Exception -> 0x008a }
            r4.append(r1)     // Catch:{ Exception -> 0x008a }
            r4.append(r5)     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x008a }
            goto L_0x0093
        L_0x0060:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008a }
            r4.<init>(r7)     // Catch:{ Exception -> 0x008a }
            com.alipay.mobile.nebula.util.H5NetworkUtil r7 = com.alipay.mobile.nebula.util.H5NetworkUtil.getInstance()     // Catch:{ Exception -> 0x008a }
            java.lang.String r7 = r7.getNetworkString()     // Catch:{ Exception -> 0x008a }
            r4.append(r7)     // Catch:{ Exception -> 0x008a }
            r4.append(r6)     // Catch:{ Exception -> 0x008a }
            r4.append(r3)     // Catch:{ Exception -> 0x008a }
            r4.append(r8)     // Catch:{ Exception -> 0x008a }
            r4.append(r1)     // Catch:{ Exception -> 0x008a }
            r4.append(r8)     // Catch:{ Exception -> 0x008a }
            r4.append(r2)     // Catch:{ Exception -> 0x008a }
            r4.append(r5)     // Catch:{ Exception -> 0x008a }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x008a }
            goto L_0x0093
        L_0x008a:
            r1 = move-exception
            java.lang.String r2 = r9.TAG
            java.lang.String r3 = "exception detail"
            com.alipay.mobile.nebula.util.H5Log.e(r2, r3, r1)
        L_0x0092:
            r1 = r0
        L_0x0093:
            com.alipay.mobile.nebula.provider.H5ProviderManager r2 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5EnvProvider> r3 = com.alipay.mobile.nebula.provider.H5EnvProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.Object r2 = r2.getProvider(r3)
            com.alipay.mobile.nebula.provider.H5EnvProvider r2 = (com.alipay.mobile.nebula.provider.H5EnvProvider) r2
            if (r2 == 0) goto L_0x00ae
            java.lang.String r0 = r2.getProductVersion()
            java.lang.String r3 = r2.getLanguage()
            goto L_0x00af
        L_0x00ae:
            r3 = r0
        L_0x00af:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r10)
            r4.append(r1)
            java.lang.String r10 = " AliApp(AP/"
            r4.append(r10)
            r4.append(r0)
            java.lang.String r10 = ") AlipayClient/"
            r4.append(r10)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r10 = r4.toString()
            com.alipay.mobile.h5container.api.H5Page r0 = r9.h5Page
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.useH5StatusBar(r0)
            if (r0 == 0) goto L_0x00ea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = " useStatusBar/true"
            r0.append(r10)
            java.lang.String r10 = r0.toString()
        L_0x00ea:
            boolean r0 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r0 == 0) goto L_0x0175
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r0 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r1 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r0 = r0.getProvider(r1)
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = (com.alipay.mobile.nebula.provider.H5AppProvider) r0
            if (r0 != 0) goto L_0x0108
            java.lang.String r0 = r9.TAG
            java.lang.String r1 = "failed to get app info!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)
            return r10
        L_0x0108:
            android.os.Bundle r0 = r9.startParam
            java.lang.String r1 = "host"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r1)
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)
            if (r0 == 0) goto L_0x016e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x011d
            goto L_0x016e
        L_0x011d:
            r0 = 0
            if (r2 == 0) goto L_0x0124
            java.lang.String r0 = r2.getRpcUrl()
        L_0x0124:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0137
            java.lang.String r1 = "test.alipay.net"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0137
            java.lang.String r0 = "test"
            goto L_0x014a
        L_0x0137:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0148
            java.lang.String r1 = "mobilegwpre.alipay.com"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0148
            java.lang.String r0 = "rc"
            goto L_0x014a
        L_0x0148:
            java.lang.String r0 = "dev"
        L_0x014a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            java.lang.String r10 = " ProductType/"
            r1.append(r10)
            r1.append(r0)
            java.lang.String r10 = r1.toString()
            java.lang.String r0 = r9.TAG
            java.lang.String r1 = java.lang.String.valueOf(r10)
            java.lang.String r2 = "debug ua"
            java.lang.String r1 = r2.concat(r1)
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)
            goto L_0x0175
        L_0x016e:
            java.lang.String r0 = r9.TAG
            java.lang.String r1 = "can't parse host parameter as json"
            com.alipay.mobile.nebula.util.H5Log.w(r0, r1)
        L_0x0175:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5WebView.getDefaultUserAgent(java.lang.String):java.lang.String");
    }

    public void setTextSize(int i2) {
        APWebSettings settings = getSettings();
        if (Build.VERSION.SDK_INT >= 14) {
            settings.setTextZoom(i2);
        } else {
            settings.setTextSize(getTextSize(i2));
        }
    }

    public APWebSettings.TextSize getTextSize(int i2) {
        if (i2 >= 200) {
            return APWebSettings.TextSize.LARGEST;
        }
        if (i2 >= 150) {
            return APWebSettings.TextSize.LARGER;
        }
        if (i2 >= 100) {
            return APWebSettings.TextSize.NORMAL;
        }
        if (i2 >= 75) {
            return APWebSettings.TextSize.SMALLER;
        }
        return APWebSettings.TextSize.NORMAL;
    }

    public void loadUrl(final String str) {
        if (!TextUtils.isEmpty(str)) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5WebView.this.loadUrlInternal(str, (IH5EmbedViewJSCallback) null);
                }
            });
        }
    }

    public void execJavaScript4EmbedView(final String str, final IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        if (!TextUtils.isEmpty(str)) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5WebView.this.loadUrlInternal(str, iH5EmbedViewJSCallback);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[Catch:{ all -> 0x0066 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUrlInternal(java.lang.String r6, final com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback r7) {
        /*
            r5 = this;
            java.lang.String r0 = "javascript"
            boolean r0 = r6.startsWith(r0)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0060
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0066 }
            r1 = 19
            r2 = 1
            r3 = 0
            if (r0 < r1) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            java.lang.String r1 = r5.userAgent     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0036
            java.lang.String r1 = r5.userAgent     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = "UCBS"
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = r5.userAgent     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = "UWS"
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0066 }
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = r5.userAgent     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = "U3"
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            r1 = 0
            if (r2 == 0) goto L_0x0049
            if (r7 != 0) goto L_0x0040
            r5.evaluateJavascript(r6, r1)     // Catch:{ all -> 0x0066 }
            return
        L_0x0040:
            com.alipay.mobile.nebulacore.web.H5WebView$5 r0 = new com.alipay.mobile.nebulacore.web.H5WebView$5     // Catch:{ all -> 0x0066 }
            r0.<init>(r7)     // Catch:{ all -> 0x0066 }
            r5.evaluateJavascript(r6, r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x0049:
            if (r0 == 0) goto L_0x005a
            if (r7 != 0) goto L_0x0051
            r5.evaluateJavascript(r6, r1)     // Catch:{ all -> 0x0066 }
            return
        L_0x0051:
            com.alipay.mobile.nebulacore.web.H5WebView$6 r0 = new com.alipay.mobile.nebulacore.web.H5WebView$6     // Catch:{ all -> 0x0066 }
            r0.<init>(r7)     // Catch:{ all -> 0x0066 }
            r5.evaluateJavascript(r6, r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x005a:
            com.alipay.mobile.nebula.webview.APWebView r7 = r5.apWebView     // Catch:{ all -> 0x0066 }
            r7.loadUrl(r6)     // Catch:{ all -> 0x0066 }
            return
        L_0x0060:
            com.alipay.mobile.nebula.webview.APWebView r7 = r5.apWebView     // Catch:{ all -> 0x0066 }
            r7.loadUrl(r6)     // Catch:{ all -> 0x0066 }
            return
        L_0x0066:
            r7 = move-exception
            java.lang.String r0 = r5.TAG
            java.lang.String r1 = "loadUrl exception."
            com.alipay.mobile.nebula.util.H5Log.e(r0, r1, r7)
            com.alipay.mobile.nebula.webview.APWebView r7 = r5.apWebView
            r7.loadUrl(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5WebView.loadUrlInternal(java.lang.String, com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback):void");
    }

    public void setH5OverScrollListener(H5OverScrollListener h5OverScrollListener) {
        this.mH5OverScrollListener = h5OverScrollListener;
    }

    public final Bundle getWebViewConfig() {
        return this.webViewConfig;
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.apWebView.addJavascriptInterface(obj, str);
    }

    public void setWebContentsDebuggingEnabled(boolean z) {
        this.apWebView.setWebContentsDebuggingEnabled(z);
    }

    public void flingScroll(int i2, int i3) {
        this.apWebView.flingScroll(i2, i3);
    }

    public boolean zoomIn() {
        return this.apWebView.zoomIn();
    }

    public boolean zoomOut() {
        return this.apWebView.zoomOut();
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        this.apWebView.setHorizontalScrollbarOverlay(z);
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        this.apWebView.setVerticalScrollbarOverlay(z);
    }

    public boolean overlayHorizontalScrollbar() {
        return this.apWebView.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.apWebView.overlayVerticalScrollbar();
    }

    public SslCertificate getCertificate() {
        return this.apWebView.getCertificate();
    }

    public void savePassword(String str, String str2, String str3) {
        this.apWebView.savePassword(str, str2, str3);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.apWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.apWebView.getHttpAuthUsernamePassword(str, str2);
    }

    public void destroy() {
        this.apWebView.destroy();
    }

    public void setNetworkAvailable(boolean z) {
        this.apWebView.setNetworkAvailable(z);
    }

    public APWebBackForwardList saveState(Bundle bundle) {
        return this.apWebView.saveState(bundle);
    }

    public APWebBackForwardList restoreState(Bundle bundle) {
        return this.apWebView.restoreState(bundle);
    }

    public void loadUrl(String str, Map<String, String> map) {
        this.apWebView.loadUrl(str, map);
    }

    public void postUrl(String str, byte[] bArr) {
        this.apWebView.postUrl(str, bArr);
    }

    public void loadData(String str, String str2, String str3) {
        this.apWebView.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.apWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.apWebView.evaluateJavascript(str, valueCallback);
    }

    public void stopLoading() {
        this.apWebView.stopLoading();
    }

    public void reload() {
        this.apWebView.reload();
    }

    public boolean canGoBack() {
        return this.apWebView.canGoBack();
    }

    public void goBack() {
        this.apWebView.goBack();
    }

    public boolean canGoForward() {
        return this.apWebView.canGoForward();
    }

    public void goForward() {
        this.apWebView.goForward();
    }

    public boolean canGoBackOrForward(int i2) {
        return this.apWebView.canGoForward();
    }

    public void goBackOrForward(int i2) {
        this.apWebView.goBackOrForward(i2);
    }

    public boolean pageUp(boolean z) {
        return this.apWebView.pageUp(z);
    }

    public boolean pageDown(boolean z) {
        return this.apWebView.pageDown(z);
    }

    public void setInitialScale(int i2) {
        this.apWebView.setInitialScale(i2);
    }

    public void invokeZoomPicker() {
        this.apWebView.invokeZoomPicker();
    }

    public String getUrl() {
        return this.apWebView.getUrl();
    }

    public String getOriginalUrl() {
        return this.apWebView.getOriginalUrl();
    }

    public String getTitle() {
        return this.apWebView.getTitle();
    }

    public Bitmap getFavicon() {
        return this.apWebView.getFavicon();
    }

    public int getProgress() {
        return this.apWebView.getProgress();
    }

    public int getContentHeight() {
        return this.apWebView.getContentHeight();
    }

    public int getContentWidth() {
        return this.apWebView.getContentWidth();
    }

    public void onPause() {
        H5EmbededViewProvider embededViewProvider;
        this.apWebView.onPause();
        H5Log.d(this.TAG, "H5WebView onWebViewPause");
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.ifContainsEmbedView() && (embededViewProvider = this.h5Page.getEmbededViewProvider()) != null) {
            embededViewProvider.onWebViewPause();
        }
    }

    public void onResume() {
        H5EmbededViewProvider embededViewProvider;
        this.apWebView.onResume();
        H5Log.d(this.TAG, "H5WebView onWebViewResume");
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.ifContainsEmbedView() && (embededViewProvider = this.h5Page.getEmbededViewProvider()) != null) {
            embededViewProvider.onWebViewResume();
        }
    }

    public boolean isPaused() {
        return this.apWebView.isPaused();
    }

    public void freeMemory() {
        this.apWebView.freeMemory();
    }

    public void clearCache(boolean z) {
        this.apWebView.clearCache(z);
    }

    public void clearFormData() {
        this.apWebView.clearFormData();
    }

    public void clearHistory() {
        this.apWebView.clearHistory();
    }

    public void clearSslPreferences() {
        this.apWebView.clearSslPreferences();
    }

    public APWebBackForwardList copyBackForwardList() {
        return this.apWebView.copyBackForwardList();
    }

    public void setDownloadListener(APDownloadListener aPDownloadListener) {
        this.apWebView.setDownloadListener(aPDownloadListener);
    }

    public void setWebViewClient(APWebViewClient aPWebViewClient) {
        this.apWebView.setWebViewClient(aPWebViewClient);
    }

    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
        this.apWebView.setWebChromeClient(aPWebChromeClient);
    }

    public void removeJavascriptInterface(String str) {
        H5Log.d(this.TAG, "removeJavascriptInterface ".concat(String.valueOf(str)));
        if (Build.VERSION.SDK_INT >= 11) {
            this.apWebView.removeJavascriptInterface(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        H5Log.d(this.TAG, "onAttachedToWindow");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        H5Log.d(this.TAG, "onDetachedFromWindow");
    }

    public void onRelease() {
        if (!this.released) {
            this.released = true;
            H5Log.d(this.TAG, "releaseWebView!");
            if (H5ProviderManagerImpl.getInstance().getProvider(H5DevDebugProvider.class.getName()) != null) {
                Nebula.getService().sendEvent(H5Plugin.CommonEvents.H5_DEV_WEBVIEW_RELEASE, (e) null);
            }
            final int i2 = 1000;
            if (H5Utils.isMainProcess() && ((Nebula.useSW(this.startParam) || H5Utils.getBoolean(this.startParam, H5Param.isTinyApp, false)) && !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_webview_release")))) {
                i2 = 500;
                H5Log.d(this.TAG, "useSw use 500");
            }
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5WebView.this.loadBlankPage(i2);
                }
            }, (long) i2);
        }
    }

    /* access modifiers changed from: private */
    public void loadBlankPage(int i2) {
        H5EmbededViewProvider embededViewProvider;
        try {
            H5Log.d(this.TAG, "loadBlankPage");
            H5Log.d(this.TAG, "H5WebView onWebViewDestory");
            if (!(this.h5Page == null || !this.h5Page.ifContainsEmbedView() || (embededViewProvider = this.h5Page.getEmbededViewProvider()) == null)) {
                embededViewProvider.onWebViewDestory();
            }
            loadUrl(H5Param.ABOUT_BLANK);
            reload();
        } catch (Throwable th) {
            H5Log.e(this.TAG, "loadBlankPage exception.", th);
        }
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                H5WebView.this.releaseWebView();
            }
        }, (long) i2);
    }

    /* access modifiers changed from: private */
    public void releaseWebView() {
        try {
            H5Log.d(this.TAG, "releaseWebView");
            if (this.h5Page != null) {
                this.h5Page.getEmbededViewProvider().releaseView();
            }
            this.h5Page = null;
            View view = this.apWebView.getView();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            view.setVisibility(8);
            view.clearFocus();
            view.clearAnimation();
            setDownloadListener((APDownloadListener) null);
            setWebViewClient((APWebViewClient) null);
            setWebChromeClient((APWebChromeClient) null);
            stopLoading();
            clearHistory();
            clearSslPreferences();
            view.destroyDrawingCache();
            freeMemory();
        } catch (Throwable th) {
            H5Log.e(this.TAG, "releaseWebView exception.", th);
        } finally {
            destroy();
        }
    }

    public APWebSettings getSettings() {
        return this.apWebView.getSettings();
    }

    public APHitTestResult getHitTestResult() {
        return this.apWebView.getHitTestResult();
    }

    public Picture capturePicture() {
        return this.apWebView.capturePicture();
    }

    public View getView() {
        return this.apWebView.getView();
    }

    public WebViewType getType() {
        return this.apWebView.getType();
    }

    public String getVersion() {
        APWebView aPWebView = this.apWebView;
        if (aPWebView == null) {
            return "(Null webview)";
        }
        return aPWebView.getVersion();
    }

    public H5Plugin getH5NumInputKeyboard() {
        return this.apWebView.getH5NumInputKeyboard();
    }

    public void setScale(float f2) {
        this.mScale = f2;
    }

    public float getScale() {
        return this.mScale;
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        this.apWebView.setVerticalScrollBarEnabled(z);
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        this.apWebView.setHorizontalScrollBarEnabled(z);
    }

    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
        this.apWebView.setOnScrollChangedCallback(h5ScrollChangedCallback);
    }

    public int getScrollY() {
        return this.apWebView.getScrollY();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.apWebView.dispatchKeyEvent(keyEvent);
    }

    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i2) {
        return this.apWebView.getCurrentPageSnapshot(rect, rect2, bitmap, z, i2);
    }

    public H5Page getH5Page() {
        return this.h5Page;
    }

    public APWebView getInternalContentView() {
        return this.apWebView;
    }
}
