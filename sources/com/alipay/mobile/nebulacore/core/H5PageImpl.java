package com.alipay.mobile.nebulacore.core;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageCount;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5Scenario;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5ABTestProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ChannelProvider;
import com.alipay.mobile.nebula.provider.H5EmbededViewProvider;
import com.alipay.mobile.nebula.provider.H5LottieViewProvider;
import com.alipay.mobile.nebula.provider.H5PageHandlerProvider;
import com.alipay.mobile.nebula.provider.H5PreConnectProvider;
import com.alipay.mobile.nebula.provider.H5SharePanelProvider;
import com.alipay.mobile.nebula.search.H5InputCallback;
import com.alipay.mobile.nebula.search.H5InputListen;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebula.view.H5TitleView;
import com.alipay.mobile.nebula.view.IH5EmbedViewJSCallback;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebula.webview.APDownloadListener;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.bridge.H5BridgeImpl;
import com.alipay.mobile.nebulacore.config.H5PluginConfigManager;
import com.alipay.mobile.nebulacore.data.H5MemData;
import com.alipay.mobile.nebulacore.embedview.H5EmbededViewProviderImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.plugin.H5ActionSheetPlugin;
import com.alipay.mobile.nebulacore.plugin.H5AlertPlugin;
import com.alipay.mobile.nebulacore.plugin.H5ApkLoadPlugin;
import com.alipay.mobile.nebulacore.plugin.H5BridgePlugin;
import com.alipay.mobile.nebulacore.plugin.H5DatePlugin;
import com.alipay.mobile.nebulacore.plugin.H5EmbedViewPlugin;
import com.alipay.mobile.nebulacore.plugin.H5HttpPlugin;
import com.alipay.mobile.nebulacore.plugin.H5JSInjectPlugin;
import com.alipay.mobile.nebulacore.plugin.H5LoadingPlugin;
import com.alipay.mobile.nebulacore.plugin.H5LongClickPlugin;
import com.alipay.mobile.nebulacore.plugin.H5NotifyPlugin;
import com.alipay.mobile.nebulacore.plugin.H5PPDownloadPlugin;
import com.alipay.mobile.nebulacore.plugin.H5PagePlugin;
import com.alipay.mobile.nebulacore.plugin.H5PermissionPlugin;
import com.alipay.mobile.nebulacore.plugin.H5ScreenBrightnessPlugin;
import com.alipay.mobile.nebulacore.plugin.H5ShakePlugin;
import com.alipay.mobile.nebulacore.plugin.H5StartParamPlugin;
import com.alipay.mobile.nebulacore.plugin.H5ToastPlugin;
import com.alipay.mobile.nebulacore.plugin.H5UrlInterceptPlugin;
import com.alipay.mobile.nebulacore.search.H5SearchPlugin;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import com.alipay.mobile.nebulacore.util.H5ParamCheckUtil;
import com.alipay.mobile.nebulacore.util.H5TimeUtil;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.wallet.H5AutoClickPlugin;
import com.alipay.mobile.nebulacore.wallet.H5LoggerPlugin;
import com.alipay.mobile.nebulacore.wallet.H5WalletPageNotifyPlugin;
import com.alipay.mobile.nebulacore.web.H5ScriptLoader;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import com.alipay.mobile.nebulacore.web.H5WebView;
import com.alipay.mobile.nebulacore.web.H5WebViewClient;
import com.alipay.mobile.nebulacore.web.extension.H5WebChromeClientProvider;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Stack;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class H5PageImpl extends H5CoreTarget implements H5Page {
    public static final String LOG_NOT_SHOW_LOADINGVIEW = "Don't show loading view : ";
    public static final String LOTTIE_LAUNCH_FILE_PATH = "_animation/launch/";
    public static final String LOTTIE_LAUNCH_MANUAL_HIDE = "manualHide";
    public static final String TAG = "H5PageImpl";
    /* access modifiers changed from: private */
    public int H5PAGE_INDEX = 0;
    private Activity activity;
    private boolean autoHideLoading = true;
    /* access modifiers changed from: private */
    public H5CollectJsApiHandler collectJsApiHandler;
    private APDownloadListener downloadListener = new APDownloadListener() {
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            String str5;
            String str6 = str;
            String str7 = str3;
            String fileExtensionFromUrl = H5FileUtil.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(fileExtensionFromUrl)) {
                H5Monitor.exception(new H5MonitorModel().fail().exceptionType(H5MonitorModel.EXCEPTION_DOWNLOAD_JUMP_URL_INVALID).appendUrl(str6).appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, str4).appendExtParams("contentDisposition", str7).appendExtParams("contentLength", String.valueOf(j)).appendMessage("download url is invalid"));
            } else {
                String str8 = str4;
            }
            if (TextUtils.isEmpty(str3) || !str7.startsWith("attachment; filename=")) {
                str5 = null;
            } else {
                str5 = str7.replace("attachment; filename=", "");
                if (str5.endsWith("\"") && str5.startsWith("\"")) {
                    str5 = str5.substring(1, str5.length() - 1);
                }
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = H5PageImpl.this.getFileName(str6);
            }
            String str9 = str5;
            boolean z = false;
            boolean z2 = (!TextUtils.isEmpty(str) && str6.endsWith(".apk")) || (!TextUtils.isEmpty(str9) && str9.endsWith(".apk"));
            H5Log.d(H5PageImpl.TAG, "download filename is " + str9 + ", isapk " + z2);
            boolean access$200 = H5PageImpl.this.isInCompetitiveAliWhiteList();
            H5Log.d(H5PageImpl.TAG, "isInCompetitiveAliWhiteList ".concat(String.valueOf(access$200)));
            H5ChannelProvider h5ChannelProvider = (H5ChannelProvider) Nebula.getProviderManager().getProvider(H5ChannelProvider.class.getName());
            String channelId = h5ChannelProvider != null ? h5ChannelProvider.getChannelId() : "default";
            boolean equals = "5136".equals(channelId);
            H5Log.d(H5PageImpl.TAG, "channelId is " + channelId + ", isGooglePlayChannel " + equals);
            long start = H5PageImpl.this.h5PageData.getStart() - H5PageImpl.this.lastTouchTime;
            if (start < 1000) {
                z = true;
            }
            H5Log.d(H5PageImpl.TAG, "user trigger apk " + z + " elapse " + start);
            e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_ppConfig"));
            boolean equals2 = parseObject != null ? H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(H5Utils.getString(parseObject, "jumpToPP")) : true;
            H5Log.d(H5PageImpl.TAG, "jumpToPP ".concat(String.valueOf(equals2)));
            boolean access$500 = H5PageImpl.this.isApkWhiteList(str6);
            e eVar = new e();
            eVar.put("url", (Object) str6);
            eVar.put("contentLength", (Object) Long.valueOf(j));
            eVar.put("inApkWhiteList", (Object) Boolean.valueOf(access$500));
            H5PageImpl.this.sendEvent(H5Plugin.InternalEvents.H5_PAGE_DOWNLOAD_APK, eVar);
            if (equals && z2) {
                H5Log.d(H5PageImpl.TAG, "isGooglePlayChannel && isApk");
                if (access$500 || access$200) {
                    if (!equals2) {
                        return;
                    }
                    if (z || str6.equals(H5Utils.getString(H5PageImpl.this.startParams, "url")) || (str6.equals(H5PageImpl.this.getRedirectUrl()) && H5PageImpl.this.getLastTouch() == 0)) {
                        H5PageImpl.this.sendPPDownloadEvent(str, str9, str2, str3, str4, j);
                    }
                } else if (z || str6.equals(H5Utils.getString(H5PageImpl.this.startParams, "url")) || (str6.equals(H5PageImpl.this.getRedirectUrl()) && H5PageImpl.this.getLastTouch() == 0)) {
                    H5PageImpl.this.showInterceptPage(str6);
                }
            } else if (!z2) {
                H5Log.d(H5PageImpl.TAG, "!isApk");
                if (TextUtils.equals(H5Environment.getConfigWithProcessCache("h5_open_openInBrowser"), "no")) {
                    H5PageImpl.this.sendDownloadEvent(str, str9, str2, str3, str4, j);
                } else {
                    Nebula.openInBrowser(H5PageImpl.this, str6, (H5BridgeContext) null);
                }
            } else if (access$200) {
                H5Log.d(H5PageImpl.TAG, "isApk && isInCompetitiveAliWhiteList");
                H5PageImpl.this.handleDownload(equals2, z, str, str9, str2, str3, str4, j);
            } else {
                H5Log.d(H5PageImpl.TAG, "isApk && !isInCompetitiveAliWhiteList");
                if (access$500) {
                    H5PageImpl.this.handleDownload(equals2, z, str, str9, str2, str3, str4, j);
                } else if (z || str6.equals(H5Utils.getString(H5PageImpl.this.startParams, "url")) || (str6.equals(H5PageImpl.this.getRedirectUrl()) && H5PageImpl.this.getLastTouch() == 0)) {
                    H5PageImpl.this.showInterceptPage(str6);
                }
            }
        }
    };
    private H5EmbededViewProvider embededViewProvider;
    private boolean exited;
    /* access modifiers changed from: private */
    public GestureDetector gestureDetector;
    private H5AvailablePageData h5AvailablePageData;
    private H5BridgeImpl h5Bridge;
    private H5WebChromeClient h5ChromeClient;
    /* access modifiers changed from: private */
    public H5Context h5Context;
    private H5Fragment h5Fragment;
    /* access modifiers changed from: private */
    public H5PageData h5PageData;
    private H5Page.H5PageHandler h5PageHandler;
    private H5ScriptLoader h5ScriptLoader;
    private H5SessionImpl h5Session;
    private H5TitleView h5TitleBar;
    private H5Page.H5TitleBarReadyCallback h5TitleBarReadyCallback;
    private H5WebViewClient h5ViewClient;
    private H5ViewHolder h5ViewHolder;
    private H5WebView h5WebView;
    private boolean hasSendExitEvent;
    private boolean isEmbedViewScene;
    private boolean isFirstPage = false;
    /* access modifiers changed from: private */
    public long lastTouchTime;
    private ViewGroup lottieLoadingView;
    private H5LottieViewProvider lottieViewProvider;
    private H5Page.H5ErrorHandler mH5ErrorHandler;
    private boolean needShowLoading;
    private H5NetworkUtil.NetworkListener networkListener;
    private int pageId;
    private String pagePerformance;
    private View rootView;
    /* access modifiers changed from: private */
    public boolean showingLoading;
    /* access modifiers changed from: private */
    public Bundle startParams;
    private String title = "";
    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            H5PageImpl.this.gestureDetector.onTouchEvent(motionEvent);
            return false;
        }
    };
    /* access modifiers changed from: private */
    public boolean waitCheckDsl;
    private int webViewId;

    public H5PageImpl(Activity activity2, Bundle bundle, H5ViewHolder h5ViewHolder2) {
        long currentTimeMillis = System.currentTimeMillis();
        H5Log.d(TAG, "h5startParamTime currentTimeMillis ".concat(String.valueOf(currentTimeMillis)));
        this.h5ViewHolder = h5ViewHolder2;
        H5Environment.setContext(activity2);
        this.isEmbedViewScene = false;
        this.h5Context = new H5Context(activity2);
        this.activity = activity2;
        this.exited = false;
        this.h5PageData = new H5PageData();
        this.h5PageData.setCreate(System.currentTimeMillis(), 4);
        this.h5AvailablePageData = new H5AvailablePageData();
        this.lastTouchTime = 0;
        this.showingLoading = false;
        this.needShowLoading = true;
        this.waitCheckDsl = false;
        this.hasSendExitEvent = false;
        if (Nebula.DEBUG) {
            H5Log.d(TAG, "h5 page host in activity ".concat(String.valueOf(H5Utils.getClassName(activity2))));
        }
        this.startParams = bundle;
        if (this.startParams == null) {
            try {
                this.startParams = activity2.getIntent().getExtras();
            } catch (Exception e2) {
                H5Log.e(TAG, "startParams getExtras Exception", e2);
            }
        }
        if (this.startParams == null) {
            this.startParams = new Bundle();
        }
        initPageData(this.startParams);
        H5ParamParser.parseMagicOptions(this.startParams, TAG);
        this.startParams = H5ParamParser.parse(this.startParams, true);
        H5ParamCheckUtil.checkParams(this.startParams);
        showStartParams();
        this.h5Data = new H5MemData();
        String string = H5Utils.getString(this.startParams, H5Param.LONG_BIZ_TYPE, "");
        string = TextUtils.isEmpty(string) ? H5Utils.getString(bundle, H5Param.PUBLIC_ID, "") : string;
        string = TextUtils.isEmpty(string) ? H5Utils.getString(bundle, "appId") : string;
        Bundle bundle2 = new Bundle();
        bundle2.putString(H5Param.LONG_BIZ_TYPE, string);
        this.h5WebView = new H5WebView(activity2, this, bundle2);
        H5Log.d(TAG, "h5_create_webview appId={} params={}");
        boolean whetherAllowAccessFromFileURL = whetherAllowAccessFromFileURL();
        H5Log.d(TAG, "allow webview access from file URL ".concat(String.valueOf(whetherAllowAccessFromFileURL)));
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.init(whetherAllowAccessFromFileURL);
            this.h5WebView.setDownloadListener(this.downloadListener);
            this.h5Bridge = new H5BridgeImpl(this.h5WebView, this);
            this.h5ChromeClient = createH5WebChromeClient(this);
            this.h5WebView.setWebChromeClient(this.h5ChromeClient);
            this.h5ViewClient = new H5WebViewClient(this);
            this.h5WebView.setWebViewClient(this.h5ViewClient);
        }
        this.h5ScriptLoader = new H5ScriptLoader(this);
        initPlugins();
        this.H5PAGE_INDEX++;
        H5PageCount.addUrl(H5Utils.getString(bundle, "url"));
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                if (H5PageImpl.this.h5Context != null && H5PageImpl.this.h5Context.getContext() != null) {
                    try {
                        String str = H5PageCount.totalRamMemorySize(H5PageImpl.this.h5Context.getContext());
                        String all = H5PageCount.getAll();
                        H5Log.d(H5PageImpl.TAG, "H5PAGE_INDEX create " + H5PageImpl.this.H5PAGE_INDEX + " walletMem " + "0" + " urls " + all + " totalRam " + str);
                        if (H5PageImpl.this.H5PAGE_INDEX > 8) {
                            H5Log.d(H5PageImpl.TAG, "H5PAGE_INDEX > 8 send monitor");
                            e eVar = new e();
                            eVar.put("urls", (Object) all);
                            eVar.put("usedMemory", (Object) "0");
                            eVar.put("totalMemory", (Object) str);
                            H5PageImpl.this.sendEvent(H5Plugin.CommonEvents.H5_VC_OVERLIMIT, eVar);
                        }
                    } catch (Throwable th) {
                        H5Log.e(H5PageImpl.TAG, th);
                    }
                }
            }
        });
        initSession();
        if (!(activity2 instanceof H5Activity)) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                applyParams();
                H5Log.d(TAG, "createPage applyParams cost ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
        this.gestureDetector = new GestureDetector(activity2, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                long unused = H5PageImpl.this.lastTouchTime = System.currentTimeMillis();
                H5Flag.lastTouchTime = H5PageImpl.this.lastTouchTime;
                H5Log.d(H5PageImpl.TAG, "onDown " + H5PageImpl.this.lastTouchTime);
                return false;
            }
        });
        H5WebView h5WebView3 = this.h5WebView;
        if (h5WebView3 != null) {
            h5WebView3.getView().setOnTouchListener(this.touchListener);
        }
        this.embededViewProvider = new H5EmbededViewProviderImpl(activity2, this);
        H5TimeUtil.timeLog(H5TimeUtil.CREATE_PAGE, currentTimeMillis);
        if (Nebula.isDSL && getWebView().getType() == WebViewType.SYSTEM_BUILD_IN) {
            Nebula.isDSL = false;
            sendEvent(H5AlertPlugin.SHOW_UC_FAIL_DIALOG, (e) null);
            sendPageAbnormalEvent();
        }
    }

    private H5WebChromeClient createH5WebChromeClient(H5PageImpl h5PageImpl) {
        H5WebChromeClientProvider h5WebChromeClientProvider = (H5WebChromeClientProvider) H5Utils.getProvider(H5WebChromeClientProvider.class.getName());
        H5WebChromeClient createWebChromeClient = (h5WebChromeClientProvider == null || H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(H5Environment.getConfig("h5_use_custom_webChromeClient"))) ? null : h5WebChromeClientProvider.createWebChromeClient(h5PageImpl);
        return (createWebChromeClient == null || createWebChromeClient.getH5Page() == null) ? new H5WebChromeClient(h5PageImpl) : createWebChromeClient;
    }

    private void sendPageAbnormalEvent() {
        if (getPageData() != null && NebulaUtil.isLogBlankScreen(getPageData().getAppId())) {
            e eVar = new e();
            eVar.put("errorType", (Object) "errorRender");
            eVar.put(CLConstants.FIELD_ERROR_CODE, (Object) Integer.valueOf(H5ErrorCode.BLANK_SCREEN_NEBULA_ERROR));
            H5Log.d(TAG, "send page abnormal event : ".concat(String.valueOf(eVar)));
            sendEvent(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL, eVar);
        }
    }

    private void initNetWorkListen(final H5Bridge h5Bridge2) {
        this.networkListener = new H5NetworkUtil.NetworkListener() {
            public void onNetworkChanged(H5NetworkUtil.Network network, H5NetworkUtil.Network network2) {
                if (H5PageImpl.this.getBridge() != null) {
                    H5Log.d(H5PageImpl.TAG, "H5_NETWORK_CHANGE");
                    String TransferNetworkType = H5NetworkUtil.TransferNetworkType(network2);
                    e eVar = new e();
                    eVar.put("isConnected", (Object) Boolean.valueOf(!"none".equals(TransferNetworkType)));
                    eVar.put("networkType", (Object) TransferNetworkType);
                    H5Bridge h5Bridge = h5Bridge2;
                    if (h5Bridge != null) {
                        h5Bridge.sendDataWarpToWeb(H5Plugin.CommonEvents.H5_NETWORK_CHANGE, eVar, (H5CallBack) null);
                    }
                }
            }
        };
        H5NetworkUtil.getInstance().addListener(this.networkListener);
    }

    private void initPageData(Bundle bundle) {
        this.h5PageData.setAppId(H5Utils.getString(bundle, "appId"));
        this.h5PageData.setPublicId(H5Utils.getString(bundle, H5Param.PUBLIC_ID));
        this.h5PageData.setAppVersion(H5Utils.getString(bundle, "appVersion"));
        this.h5PageData.setOpenAppId(H5Utils.getString(bundle, H5Param.OPEN_APP_ID));
        this.h5PageData.setShopId(H5Utils.getString(bundle, H5Param.SHOP_ID));
        this.h5PageData.setCustomParams(H5Utils.getString(bundle, H5Param.CUSTOM_PARAMS));
        this.h5PageData.setReleaseType(H5Utils.getString(bundle, "release_type"));
        this.h5PageData.setSessionId(H5Utils.getString(bundle, H5Param.SESSION_ID));
        if (H5Utils.getBoolean(bundle, H5Param.isTinyApp, false)) {
            this.h5PageData.setIsTinyApp(H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        } else {
            this.h5PageData.setIsTinyApp(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        }
        if (H5Utils.getBoolean(bundle, H5Param.LONG_ISPRERENDER, false)) {
            this.h5PageData.setPreRender(1);
        } else {
            this.h5PageData.setPreRender(0);
        }
    }

    private void showStartParams() {
        StringBuilder sb = new StringBuilder();
        sb.append("H5 start params:");
        for (String str : this.startParams.keySet()) {
            Object obj = this.startParams.get(str);
            sb.append("\n[");
            sb.append(str);
            sb.append(" ==> ");
            sb.append(obj);
            sb.append("]");
        }
        H5Log.d(TAG, sb.toString());
    }

    /* access modifiers changed from: private */
    public void showInterceptPage(String str) {
        try {
            H5Log.d(TAG, "showInterceptPage loadUrl");
            loadUrl("https://ds.alipay.com/error/securityLink.htm?url=" + URLEncoder.encode(str, "utf-8"));
        } catch (Throwable unused) {
            H5Log.d(TAG, "Error: Unsupported encoding exception on ".concat(String.valueOf(str)));
        }
    }

    /* access modifiers changed from: private */
    public void handleDownload(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, long j) {
        String str6 = str;
        if (!z2 && !str.equals(H5Utils.getString(this.startParams, "url")) && (!str.equals(getRedirectUrl()) || getLastTouch() != 0)) {
            return;
        }
        if (!z) {
            sendDownloadEvent(str, str2, str3, str4, str5, j);
        } else {
            sendPPDownloadEvent(str, str2, str3, str4, str5, j);
        }
    }

    /* access modifiers changed from: private */
    public void sendPPDownloadEvent(String str, String str2, String str3, String str4, String str5, long j) {
        e eVar = new e();
        eVar.put("url", (Object) str);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, (Object) str2);
        eVar.put("userAgent", (Object) str3);
        eVar.put("contentDisposition", (Object) str4);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, (Object) str5);
        eVar.put("contentLength", (Object) Long.valueOf(j));
        sendEvent("ppdownload", eVar);
    }

    /* access modifiers changed from: private */
    public void sendDownloadEvent(String str, String str2, String str3, String str4, String str5, long j) {
        e eVar = new e();
        eVar.put("url", (Object) str);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME, (Object) str2);
        eVar.put("userAgent", (Object) str3);
        eVar.put("contentDisposition", (Object) str4);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, (Object) str5);
        eVar.put("contentLength", (Object) Long.valueOf(j));
        sendEvent(H5Plugin.InternalEvents.H5_PAGE_DOWNLOAD, eVar);
    }

    /* access modifiers changed from: private */
    public boolean isApkWhiteList(String str) {
        Uri parseUrl = H5UrlHelper.parseUrl(str);
        if (parseUrl == null || TextUtils.isEmpty(parseUrl.getHost())) {
            return false;
        }
        String host = parseUrl.getHost();
        String config = H5Environment.getConfig(H5Utils.KEY_APK_WHITE_LIST);
        if (TextUtils.isEmpty(config)) {
            return true;
        }
        return H5PatternHelper.matchRegex(config, host);
    }

    /* access modifiers changed from: private */
    public boolean isInCompetitiveAliWhiteList() {
        b parseArray;
        String host = H5UrlHelper.getHost(getShareUrl());
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_competitiveList"));
        if (parseObject == null || TextUtils.isEmpty(host) || (parseArray = H5Utils.parseArray(parseObject.getString("aliWhiteList"))) == null) {
            return false;
        }
        for (int i2 = 0; i2 < parseArray.size(); i2++) {
            if (H5PatternHelper.matchRegex(parseArray.getString(i2), host)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String getFileName(String str) {
        String path = H5UrlHelper.getPath(str);
        String fileName = !TextUtils.isEmpty(path) ? H5FileUtil.fileName(path) : null;
        if (!TextUtils.isEmpty(fileName)) {
            return fileName;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    public H5ScriptLoader getScriptLoader() {
        return this.h5ScriptLoader;
    }

    private boolean whetherAllowAccessFromFileURL() {
        Uri parseUrl = H5UrlHelper.parseUrl(H5Utils.getString(this.startParams, "url"));
        if (parseUrl == null || !CommunityPostActivity.TYPE_FILE.equals(parseUrl.getScheme())) {
            return false;
        }
        String path = parseUrl.getPath();
        H5Log.d(TAG, "uri path : ".concat(String.valueOf(path)));
        if (TextUtils.isEmpty(path) || path.contains("..") || path.contains("\\") || path.contains("%")) {
            return false;
        }
        if (path.startsWith("/android_asset") || path.startsWith("/android_res")) {
            return true;
        }
        try {
            String absolutePath = H5Utils.getContext().getFilesDir().getAbsolutePath();
            H5Log.d(TAG, "fileDir : ".concat(String.valueOf(absolutePath)));
            if (!path.startsWith(absolutePath)) {
                return false;
            }
            String substring = path.substring(absolutePath.length());
            H5Log.d(TAG, "checkPath : ".concat(String.valueOf(substring)));
            return NebulaUtil.enableAllowFileAccess(substring);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return false;
        }
    }

    public void onRelease() {
        Nebula.getProviderManager().removeProvider(H5InputCallback.class.getName());
        Nebula.getProviderManager().removeProvider(H5InputListen.class.getName());
        H5WebViewClient h5WebViewClient = this.h5ViewClient;
        if (h5WebViewClient != null) {
            h5WebViewClient.onRelease();
        }
        this.h5ViewClient = null;
        H5WebChromeClient h5WebChromeClient = this.h5ChromeClient;
        if (h5WebChromeClient != null) {
            h5WebChromeClient.onRelease();
        }
        this.h5ChromeClient = null;
        H5BridgeImpl h5BridgeImpl = this.h5Bridge;
        if (h5BridgeImpl != null) {
            h5BridgeImpl.onRelease();
        }
        this.h5Bridge = null;
        this.startParams = null;
        this.activity = null;
        this.h5Session = null;
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.setDownloadListener((APDownloadListener) null);
            this.h5WebView.onRelease();
        }
        this.h5WebView = null;
        this.h5Context = null;
        this.h5ScriptLoader = null;
        this.h5PageHandler = null;
        H5NetworkUtil.getInstance().removeListener(this.networkListener);
        this.networkListener = null;
        this.collectJsApiHandler = null;
        super.onRelease();
    }

    public H5Context getContext() {
        return this.h5Context;
    }

    public H5Session getSession() {
        return this.h5Session;
    }

    public String getUrl() {
        H5WebViewClient h5WebViewClient = this.h5ViewClient;
        return h5WebViewClient != null ? h5WebViewClient.getPageUrl() : "";
    }

    public String getShareUrl() {
        if (TextUtils.equals("NEW", H5Environment.getConfig("h5_ShareUrlConfig"))) {
            H5WebView h5WebView2 = this.h5WebView;
            if (h5WebView2 != null) {
                return h5WebView2.getUrl();
            }
            return "";
        }
        H5WebViewClient h5WebViewClient = this.h5ViewClient;
        if (h5WebViewClient != null) {
            return h5WebViewClient.getShareUrl();
        }
        return "";
    }

    public String getRedirectUrl() {
        H5WebViewClient h5WebViewClient = this.h5ViewClient;
        return h5WebViewClient != null ? h5WebViewClient.getRedirectUrl() : "";
    }

    public Bundle getParams() {
        return this.startParams;
    }

    public String getTitle() {
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            return TextUtils.isEmpty(h5WebView2.getTitle()) ? this.title : this.h5WebView.getTitle();
        }
        return this.title;
    }

    public H5Bridge getBridge() {
        return this.h5Bridge;
    }

    public H5WebView getWebView() {
        return this.h5WebView;
    }

    public H5WebViewClient getWebViewClient() {
        return this.h5ViewClient;
    }

    public H5WebChromeClient getWebChromeClient() {
        return this.h5ChromeClient;
    }

    public boolean exitPage() {
        try {
            H5PageHandlerProvider h5PageHandlerProvider = (H5PageHandlerProvider) Nebula.getProviderManager().getProvider(H5PageHandlerProvider.class.getName());
            if (h5PageHandlerProvider != null && h5PageHandlerProvider.handlerPageExit(this, this.activity)) {
                H5Log.d(TAG, "exitPage handler by h5PageHandlerProvider");
                return false;
            } else if (Nebula.needPageKeepAlive(this, this.activity)) {
                Nebula.doKeepAlive(this.activity, getParams());
                return false;
            } else if (isCollectDestroyJsApi()) {
                collectJsApiAndExit(false);
                return true;
            } else if (!isCheckDslError()) {
                return doExitPage(false);
            } else {
                checkDslErrorAndExit(false);
                return true;
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return true;
        }
    }

    public boolean exitTabPage() {
        if (isCollectDestroyJsApi()) {
            collectJsApiAndExit(true);
            return true;
        } else if (!isCheckDslError()) {
            return doExitPage(true);
        } else {
            checkDslErrorAndExit(true);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean isCheckDslError() {
        if (!H5Utils.getBoolean(getParams(), H5Param.isTinyApp, false) || !NebulaUtil.isCloseCheckDsl() || getWebView() == null || getWebView().getType() != WebViewType.THIRD_PARTY) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void checkDslErrorAndExit(final boolean z) {
        if (!this.waitCheckDsl) {
            e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_logNewBlankScreenConfig"));
            if (parseObject == null || parseObject.isEmpty() || this.h5PageData == null) {
                doExitPage(z);
                return;
            }
            String string = H5Utils.getString(parseObject, "enable");
            String string2 = H5Utils.getString(parseObject, "appId");
            if (TextUtils.isEmpty(NebulaUtil.dslJs)) {
                NebulaUtil.dslJs = H5Utils.getString(parseObject, "script");
            }
            int i2 = H5Utils.getInt(parseObject, "testFilter") != 0 ? H5Utils.getInt(parseObject, "testFilter") : 1;
            long currentTimeMillis = System.currentTimeMillis();
            long start = this.h5PageData.getStart();
            boolean z2 = (currentTimeMillis - start) / 1000 < ((long) i2);
            H5Log.d(TAG, "check dsl currentTime : " + currentTimeMillis + " startTime : " + start + " filterTime : " + i2 + " filter : " + z2);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.h5PageData.getAppId()) || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string) || !NebulaUtil.isAppIdMatch(string2, this.h5PageData.getAppId()) || z2 || getWebView() == null || TextUtils.isEmpty(NebulaUtil.dslJs)) {
                doExitPage(z);
                return;
            }
            this.waitCheckDsl = true;
            getWebView().evaluateJavascript(NebulaUtil.dslJs, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    boolean unused = H5PageImpl.this.waitCheckDsl = false;
                    H5Log.d(H5PageImpl.TAG, "check dsl result : ".concat(String.valueOf(str)));
                    e parseObject = H5Utils.parseObject(str);
                    if (parseObject != null) {
                        try {
                            if (parseObject.containsKey("isDSLError") && "true".equalsIgnoreCase(String.valueOf(parseObject.get("isDSLError")))) {
                                H5PageImpl.this.sendEvent(H5LoggerPlugin.DSL_ERROR_LOG, (e) null);
                            }
                        } catch (Exception e2) {
                            H5Log.e(H5PageImpl.TAG, (Throwable) e2);
                        }
                    }
                    H5PageImpl.this.doExitPage(z);
                }
            });
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    if (H5PageImpl.this.waitCheckDsl) {
                        H5Log.d(H5PageImpl.TAG, "check dsl overtime : " + H5PageImpl.this.waitCheckDsl);
                        H5PageImpl.this.doExitPage(z);
                    }
                }
            }, 200);
        }
    }

    private boolean isCollectDestroyJsApi() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_isCollectDestroyJsApi"));
        if (!(parseObject == null || parseObject.isEmpty() || this.h5PageData == null)) {
            String string = H5Utils.getString(parseObject, "enable");
            String string2 = H5Utils.getString(parseObject, "appId");
            if (!H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string) || !NebulaUtil.isAppIdMatch(string2, this.h5PageData.getAppId())) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void collectJsApiAndExit(final boolean z) {
        if (this.collectJsApiHandler == null && this.h5Bridge != null) {
            this.collectJsApiHandler = new H5CollectJsApiHandler();
            H5CollectJsApiHandler h5CollectJsApiHandler = this.collectJsApiHandler;
            h5CollectJsApiHandler.exitTabScene = z;
            h5CollectJsApiHandler.waiting = true;
            this.h5Bridge.sendToWeb("collectDestroyJsApi", (e) null, h5CollectJsApiHandler);
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    if (H5PageImpl.this.collectJsApiHandler != null && H5PageImpl.this.collectJsApiHandler.waiting) {
                        H5Log.d(H5PageImpl.TAG, "collectJsApiHandler overtime, do exit");
                        H5PageImpl.this.doExitPage(z);
                    }
                }
            }, 1000);
        }
    }

    public boolean onInterceptError(String str, int i2) {
        H5Page.H5ErrorHandler h5ErrorHandler = this.mH5ErrorHandler;
        if (h5ErrorHandler == null) {
            return false;
        }
        boolean shouldInterceptError = h5ErrorHandler.shouldInterceptError(str, i2);
        if (!shouldInterceptError) {
            return shouldInterceptError;
        }
        H5Log.w(TAG, "page error intercepted: " + str + ", " + i2);
        return shouldInterceptError;
    }

    public boolean doExitPage(boolean z) {
        H5Page.H5PageHandler h5PageHandler2 = this.h5PageHandler;
        if (h5PageHandler2 != null && !h5PageHandler2.shouldExit()) {
            H5Log.w(TAG, "page exit intercepted by host!");
            return false;
        } else if (this.exited) {
            H5Log.d(TAG, "page already exited!");
            return false;
        } else {
            boolean z2 = true;
            this.exited = true;
            if (this.h5Bridge != null) {
                sendExitEvent();
            }
            H5SharePanelProvider h5SharePanelProvider = (H5SharePanelProvider) Nebula.getProviderManager().getProvider(H5SharePanelProvider.class.getName());
            if (h5SharePanelProvider != null) {
                h5SharePanelProvider.removeMenuList(hashCode());
            }
            H5PreConnectProvider h5PreConnectProvider = (H5PreConnectProvider) H5Utils.getProvider(H5PreConnectProvider.class.getName());
            if (h5PreConnectProvider != null) {
                h5PreConnectProvider.clearPreRequest(this);
            }
            H5Log.d("H5SharePanelProviderImp", "h5page quit , hashCode = " + hashCode());
            this.H5PAGE_INDEX = this.H5PAGE_INDEX - 1;
            H5PageCount.removeUrl(H5Utils.getString(this.startParams, "url"));
            H5Log.d(TAG, "H5PAGE_INDEX exit " + this.H5PAGE_INDEX);
            H5Log.d(TAG, "exitPage");
            sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSED, (e) null);
            H5WebView h5WebView2 = this.h5WebView;
            if (h5WebView2 != null) {
                try {
                    h5WebView2.getSettings().setJavaScriptEnabled(false);
                    ((InputMethodManager) H5Environment.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.h5WebView.getView().getWindowToken(), 0);
                } catch (Exception e2) {
                    H5Log.e(TAG, (Throwable) e2);
                }
            }
            Activity activity2 = this.activity;
            if (activity2 != null) {
                if ((activity2 instanceof H5Activity) && this.h5Fragment != null) {
                    try {
                        H5Session session = getSession();
                        if (session != null) {
                            session.getData().set(Nebula.H5_PAGE_RESUME, Nebula.H5_PAGE_RESUME);
                        }
                        z2 = true ^ ((H5Activity) this.activity).getH5FragmentManager().removeFragment(this.h5Fragment, getParams(), z);
                    } catch (Throwable th) {
                        H5Log.e(TAG, "exception detail", th);
                    }
                }
                if (z2) {
                    Activity activity3 = this.activity;
                    if (activity3 instanceof H5Activity) {
                        activity3.finish();
                    }
                }
            }
            return this.h5Session.removePage(this);
        }
    }

    private void initPlugins() {
        H5Plugin h5NumInputKeyboard;
        long currentTimeMillis = System.currentTimeMillis();
        H5PluginManager pluginManager = getPluginManager();
        pluginManager.register((H5Plugin) new H5AlertPlugin());
        pluginManager.register((H5Plugin) new H5NotifyPlugin());
        pluginManager.register((H5Plugin) new H5ShakePlugin());
        pluginManager.register((H5Plugin) new H5BridgePlugin(this));
        pluginManager.register((H5Plugin) new H5PagePlugin(this));
        pluginManager.register((H5Plugin) new H5DatePlugin());
        pluginManager.register((H5Plugin) new H5LongClickPlugin(this));
        pluginManager.register((H5Plugin) new H5HttpPlugin());
        pluginManager.register((H5Plugin) new H5UrlInterceptPlugin());
        pluginManager.register((H5Plugin) new H5PPDownloadPlugin());
        pluginManager.register((H5Plugin) new H5ActionSheetPlugin());
        if (H5Utils.isInWallet()) {
            pluginManager.register((H5Plugin) new H5ApkLoadPlugin());
        }
        pluginManager.register((H5Plugin) new H5PermissionPlugin());
        H5WebView h5WebView2 = this.h5WebView;
        if (!(h5WebView2 == null || (h5NumInputKeyboard = h5WebView2.getH5NumInputKeyboard()) == null)) {
            pluginManager.register(h5NumInputKeyboard);
        }
        pluginManager.register((H5Plugin) new H5ScreenBrightnessPlugin());
        if (!(this.activity instanceof H5Activity)) {
            pluginManager.register((H5Plugin) new H5WalletPageNotifyPlugin());
        }
        pluginManager.register((H5Plugin) new H5LoggerPlugin());
        pluginManager.register((H5Plugin) new H5AutoClickPlugin());
        pluginManager.register((H5Plugin) new H5SearchPlugin(this));
        pluginManager.register((H5Plugin) new H5LoadingPlugin(this));
        pluginManager.register((H5Plugin) new H5StartParamPlugin());
        pluginManager.register((H5Plugin) new H5EmbedViewPlugin());
        if (!H5Utils.isInWallet()) {
            pluginManager.register((H5Plugin) new H5ToastPlugin());
        }
        H5Plugin createPlugin = H5PluginConfigManager.getInstance().createPlugin(H5Param.PAGE, pluginManager);
        if (createPlugin != null) {
            pluginManager.register(createPlugin);
        }
        if (Nebula.DEBUG) {
            pluginManager.register((H5Plugin) new H5JSInjectPlugin());
        }
        H5TimeUtil.timeLog(H5TimeUtil.CREATE_PAGE, H5TimeUtil.INIT_PLUGIN, currentTimeMillis);
    }

    private void initSession() {
        this.h5Session = (H5SessionImpl) Nebula.getService().getSession(H5Utils.getString(this.startParams, H5Param.SESSION_ID));
        H5SessionImpl h5SessionImpl = this.h5Session;
        if (h5SessionImpl != null) {
            H5Scenario scenario = h5SessionImpl.getScenario();
            String string = H5Utils.getString(this.startParams, H5Param.LONG_BIZ_SCENARIO);
            if (!TextUtils.isEmpty(string) && scenario == null) {
                H5Log.d(TAG, "set session scenario ".concat(String.valueOf(string)));
                this.h5Session.setScenario(new H5ScenarioImpl(string));
            }
        }
    }

    public boolean isFirstPage() {
        return this.isFirstPage;
    }

    private void loadUrlEvent() {
        H5ABTestProvider h5ABTestProvider;
        H5WebView h5WebView2;
        e eVar = new e();
        String string = H5Utils.getString(this.startParams, "url");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if ((this.activity instanceof H5Activity) && Nebula.enableOpenScheme(string)) {
            exitPage();
        } else if (!H5Utils.isInTinyProcess() || (h5WebView2 = this.h5WebView) == null || !TextUtils.isEmpty(h5WebView2.getUrl()) || !enableLoadUrlWithWebView()) {
            if (TextUtils.isEmpty(H5AppUtil.matchAppId(string)) && (h5ABTestProvider = (H5ABTestProvider) H5Utils.getProvider(H5ABTestProvider.class.getName())) != null) {
                String handleURL = h5ABTestProvider.handleURL(this, string);
                if (!TextUtils.isEmpty(handleURL)) {
                    string = handleURL;
                }
            }
            eVar.put("url", (Object) string);
            eVar.put("requestPreAuth", (Object) Boolean.valueOf(H5Utils.getBoolean(this.startParams, "requestPreAuth", false)));
            if (this.startParams.containsKey(H5Param.REFERER)) {
                eVar.put(H5Param.REFERER, (Object) H5Utils.getString(this.startParams, H5Param.REFERER));
            }
            eVar.put(H5Param.PUBLIC_ID, (Object) H5Utils.getString(this.startParams, H5Param.PUBLIC_ID, ""));
            eVar.put(H5Param.HTTP_ADDITIONAL_HEADERS, (Object) H5Utils.getString(this.startParams, H5Param.HTTP_ADDITIONAL_HEADERS));
            if (!TextUtils.isEmpty(H5Plugin.InternalEvents.H5_PAGE_LOAD_URL)) {
                sendEvent(H5Plugin.InternalEvents.H5_PAGE_LOAD_URL, eVar);
            }
        } else if (!H5UrlInterceptPlugin.interceptXiaoChengXu(string, H5Utils.getString(this.startParams, "appId"), this)) {
            loadUrlWithWebView(string);
        }
    }

    private void showTinyLoading(Bundle bundle) {
        if (H5Utils.isInTinyProcess() && TextUtils.isEmpty(H5Utils.getString(bundle, "showLoading")) && isFirstPage()) {
            String string = H5Utils.getString(bundle, "appId");
            b parseArray = H5Utils.parseArray(H5Environment.getConfig("h5_show_tiny_loading"));
            if (parseArray == null || (!parseArray.contains(string) && !parseArray.contains(StringSet.all))) {
                e eVar = new e();
                eVar.put(H5Param.isTinyApp, (Object) Boolean.TRUE);
                sendEvent("showLoading", eVar);
                return;
            }
            H5Log.d(TAG, string + " not show TinyLoading");
        }
    }

    public void applyParams() {
        H5Page topPage;
        this.h5Session.addPage(this);
        Stack<H5Page> pages = this.h5Session.getPages();
        if (pages != null && pages.size() == 1) {
            H5Log.d(TAG, " is First Page");
            this.isFirstPage = true;
        }
        if (!H5Utils.getBoolean(this.startParams, H5Param.isTinyApp, false)) {
            initNetWorkListen(getBridge());
        } else if (isFirstPage()) {
            H5Session session = getSession();
            if (!(session == null || (topPage = session.getTopPage()) == null)) {
                initNetWorkListen(topPage.getBridge());
            }
        } else {
            H5Log.d(TAG, "is not isFirstPage not initNetWorkListen");
        }
        this.h5ViewClient.setWebProvider(this.h5Session.getWebProvider());
        loadUrlEvent();
        showTinyLoading(this.startParams);
        for (String str : this.startParams.keySet()) {
            String str2 = null;
            e eVar = new e();
            if ("url".equals(str)) {
                H5Log.d(TAG, str + " already sendEvent use loadUrlEvent");
            } else {
                if ("showLoading".equals(str)) {
                    if (H5Utils.getBoolean(this.startParams, str, false)) {
                        str2 = "showLoading";
                    }
                } else if ("backgroundColor".equals(str)) {
                    eVar.put(str, (Object) Integer.valueOf(H5Utils.getInt(this.startParams, str, -16777216) | -16777216));
                    str2 = H5Plugin.InternalEvents.H5_PAGE_BACKGROUND;
                }
                if (!TextUtils.isEmpty(str2)) {
                    sendEvent(str2, eVar);
                }
            }
        }
        Bundle bundle = this.startParams;
        if (bundle != null) {
            bundle.remove("requestPreAuth");
        }
        initTextSize();
        H5Log.d(TAG, "H5pageImpl applyParam");
    }

    private void initTextSize() {
        H5Scenario scenario;
        H5SessionImpl h5SessionImpl = this.h5Session;
        if (h5SessionImpl != null && (scenario = h5SessionImpl.getScenario()) != null && scenario.getData() != null) {
            String str = scenario.getData().get(H5Param.FONT_SIZE);
            if (!TextUtils.isEmpty(str)) {
                try {
                    setTextSize(Integer.parseInt(str));
                } catch (Exception e2) {
                    H5Log.e(TAG, "failed to parse scenario font size.", e2);
                }
            }
        }
    }

    public void showLoadingView() {
        ViewGroup viewGroup;
        if (this.needShowLoading && !this.showingLoading) {
            H5Log.d(TAG, "show web loading view");
            if (this.lottieViewProvider != null && (viewGroup = this.lottieLoadingView) != null && this.rootView != null) {
                this.showingLoading = true;
                Activity activity2 = this.activity;
                if (activity2 != null && (activity2 instanceof H5Activity)) {
                    ((H5Activity) activity2).showFrameworkLoadingView(viewGroup);
                }
                this.lottieViewProvider.playAnimation();
            }
        }
    }

    public void hideLoadingView() {
        H5LottieViewProvider h5LottieViewProvider;
        H5Log.d(TAG, "hide web loading view");
        this.needShowLoading = false;
        if (this.showingLoading && (h5LottieViewProvider = this.lottieViewProvider) != null && this.rootView != null) {
            this.showingLoading = false;
            h5LottieViewProvider.stopAnimation();
            Activity activity2 = this.activity;
            if (activity2 != null && (activity2 instanceof H5Activity)) {
                ((H5Activity) activity2).stopLoading();
            }
        }
    }

    private boolean shouldShowLoadingView() {
        AppInfo appInfo;
        if (!enableNebulaAppLoadingView()) {
            return false;
        }
        if ("pushWindow".equals(H5Utils.getString(this.startParams, H5Param.FROM_TYPE, ""))) {
            H5Log.d(TAG, "Don't show loading view : pushWindow");
            return false;
        } else if (!H5Utils.getBoolean(this.startParams, H5Param.IS_NEBULA_APP, false)) {
            H5Log.d(TAG, "Don't show loading view : isn't nebula app");
            return false;
        } else if (H5Utils.getBoolean(this.startParams, H5Param.LONG_PACKAGE_LOADING_SHOWN, false)) {
            H5Log.d(TAG, "Don't show loading view : packageLoadingShown");
            return false;
        } else if (H5Utils.getBoolean(this.startParams, H5Param.LONG_UC_INIT_LOADING_SHOWN, false)) {
            H5Log.d(TAG, "Don't show loading view : UCInitLoadingShown");
            return false;
        } else {
            H5Context h5Context2 = this.h5Context;
            if (h5Context2 == null || h5Context2.getContext() == null || !H5Utils.NETWORK_TYPE_NOTREACHABLE.equals(H5Utils.getNetworkType(this.h5Context.getContext()))) {
                H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                if (h5AppProvider == null || (appInfo = h5AppProvider.getAppInfo(this.h5PageData.getAppId(), this.h5PageData.getAppVersion())) == null) {
                    return true;
                }
                e jSONObject = H5Utils.getJSONObject(H5Utils.parseObject(appInfo.extend_info_jo), "lottieAnimation", (e) null);
                if (jSONObject == null || jSONObject.isEmpty()) {
                    H5Log.d(TAG, "Don't show loading view : lack lottie config");
                    return false;
                }
                e jSONObject2 = H5Utils.getJSONObject(jSONObject, "launchConfig", (e) null);
                if (jSONObject2 == null || jSONObject2.size() <= 0) {
                    return true;
                }
                String string = H5Utils.getString(jSONObject2, "matchUrl", "");
                if (TextUtils.isEmpty(string) || H5PatternHelper.matchRegex(string, H5Utils.getString(this.startParams, "url"))) {
                    if (LOTTIE_LAUNCH_MANUAL_HIDE.equals(H5Utils.getString(jSONObject2, "mode", ""))) {
                        this.autoHideLoading = false;
                    }
                    int i2 = H5Utils.getInt(jSONObject2, StringSet.width, 0);
                    int i3 = H5Utils.getInt(jSONObject2, StringSet.height, 0);
                    int i4 = H5Utils.getInt(jSONObject2, "locationX", 0);
                    int i5 = H5Utils.getInt(jSONObject2, "locationY", 0);
                    if (i2 <= 0 && i3 <= 0 && i4 <= 0 && i5 <= 0) {
                        return true;
                    }
                    ensureLottieViewProviderExist();
                    H5LottieViewProvider h5LottieViewProvider = this.lottieViewProvider;
                    if (h5LottieViewProvider == null) {
                        return true;
                    }
                    h5LottieViewProvider.setWidthAndHeight(i2, i3);
                    this.lottieViewProvider.setLocationXY(i4, i5);
                    return true;
                }
                H5Log.d(TAG, "Don't show loading view : not match url");
                return false;
            }
            H5Log.d(TAG, "Don't show loading view : network is unreachable");
            return false;
        }
    }

    public void checkIfShowLoadingView() {
        H5ContentProviderImpl h5ContentProviderImpl;
        byte[] localResource;
        if (shouldShowLoadingView()) {
            ensureLottieViewProviderExist();
            H5SessionImpl h5SessionImpl = this.h5Session;
            if (h5SessionImpl != null && (h5ContentProviderImpl = (H5ContentProviderImpl) h5SessionImpl.getWebProvider()) != null && (localResource = h5ContentProviderImpl.getLocalResource("_animation/launch/loading.json")) != null && localResource.length != 0 && this.h5Fragment != null) {
                H5LottieViewProvider h5LottieViewProvider = this.lottieViewProvider;
                if (h5LottieViewProvider != null) {
                    h5LottieViewProvider.setMainJson(localResource);
                }
                int lottieAnimationImgsCount = h5ContentProviderImpl.getLottieAnimationImgsCount("_animation/launch/images");
                H5Log.d(TAG, "loading img count ".concat(String.valueOf(lottieAnimationImgsCount)));
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < lottieAnimationImgsCount; i2++) {
                    String str = "_animation/launch/images/img_" + i2 + ".png";
                    byte[] localResource2 = h5ContentProviderImpl.getLocalResource(str);
                    if (localResource2 != null && localResource2.length > 0) {
                        hashMap.put(str, localResource2);
                    }
                }
                if (this.lottieViewProvider != null && hashMap.size() > 0) {
                    this.lottieViewProvider.setImgs(hashMap);
                }
                try {
                    showLoadingView();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            if (H5PageImpl.this.showingLoading) {
                                H5Log.d(H5PageImpl.TAG, "time is up, hide LoadingView");
                                H5PageImpl.this.hideLoadingView();
                            }
                        }
                    }, (long) (this.autoHideLoading ? 3000 : AppConstants.START_OTP_FLOW));
                } catch (Throwable th) {
                    H5Log.e(TAG, "play lottie loading animation failed", th);
                }
            }
        }
    }

    private void ensureLottieViewProviderExist() {
        if (this.lottieViewProvider == null) {
            this.lottieViewProvider = (H5LottieViewProvider) Nebula.getProviderManager().getProvider(H5LottieViewProvider.class.getName());
            H5LottieViewProvider h5LottieViewProvider = this.lottieViewProvider;
            if (h5LottieViewProvider != null) {
                this.lottieLoadingView = h5LottieViewProvider.createLoadingView(this.activity);
            }
        }
    }

    public static boolean enableNebulaAppLoadingView() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_enableNebulaAppLoadingView"));
        if (parseObject == null || parseObject.isEmpty() || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(parseObject, "enable")) || "no".equalsIgnoreCase(H5Utils.getString(parseObject, "framework"))) {
            return false;
        }
        return true;
    }

    public void setHandler(H5Page.H5PageHandler h5PageHandler2) {
        this.h5PageHandler = h5PageHandler2;
    }

    public void setH5ErrorHandler(H5Page.H5ErrorHandler h5ErrorHandler) {
        this.mH5ErrorHandler = h5ErrorHandler;
    }

    public View getContentView() {
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            return h5WebView2.getView();
        }
        return null;
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        e eVar = new e();
        eVar.put("baseUrl", (Object) str);
        eVar.put("data", (Object) str2);
        eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE, (Object) str3);
        eVar.put("encoding", (Object) str4);
        eVar.put("historyUrl", (Object) str5);
        sendEvent(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_DATA, eVar);
    }

    public void loadUrl(String str) {
        e eVar = new e();
        eVar.put("url", (Object) str);
        sendEvent(H5Plugin.InternalEvents.H5_PAGE_LOAD_URL, eVar);
        H5Log.d(TAG, "page loadurl");
    }

    private void loadUrlWithWebView(String str) {
        if (TextUtils.isEmpty(str)) {
            H5Log.w(TAG, "h5 url isEmpty");
            return;
        }
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.loadUrl(str);
        }
    }

    private boolean enableLoadUrlWithWebView() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableLoadUrlWithWebView"));
    }

    public void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.execJavaScript4EmbedView(str, iH5EmbedViewJSCallback);
        }
    }

    public void setTextSize(int i2) {
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.setTextSize(i2);
        }
    }

    public H5Fragment getH5Fragment() {
        return this.h5Fragment;
    }

    public void setH5Fragment(H5Fragment h5Fragment2) {
        this.h5Fragment = h5Fragment2;
    }

    public H5PageData getPageData() {
        return this.h5PageData;
    }

    public H5AvailablePageData getAvailablePageData() {
        return this.h5AvailablePageData;
    }

    public String getVersion() {
        H5WebView h5WebView2 = this.h5WebView;
        return h5WebView2 != null ? h5WebView2.getVersion() : "";
    }

    public long getLastTouch() {
        return this.lastTouchTime;
    }

    public View getRootView() {
        return this.rootView;
    }

    public void setRootView(View view) {
        this.rootView = view;
    }

    public String getPerformance() {
        return this.pagePerformance;
    }

    public void setPerformance(String str) {
        this.pagePerformance = str;
    }

    public boolean scriptbizLoadedAndBridgeLoaded() {
        H5ScriptLoader h5ScriptLoader2 = this.h5ScriptLoader;
        return h5ScriptLoader2 != null && h5ScriptLoader2.bizLoaded && this.h5ScriptLoader.bridgeLoaded;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setH5TitleBar(H5TitleView h5TitleView) {
        this.h5TitleBar = h5TitleView;
    }

    public H5TitleView getH5TitleBar() {
        return this.h5TitleBar;
    }

    public H5EmbededViewProvider getEmbededViewProvider() {
        return this.embededViewProvider;
    }

    public void setPageId(int i2) {
        this.pageId = i2;
    }

    public int getPageId() {
        return this.pageId;
    }

    public void setWebViewId(int i2) {
        this.webViewId = i2;
    }

    public int getWebViewId() {
        return this.webViewId;
    }

    public H5Page.H5TitleBarReadyCallback getTitleBarReadyCallBack() {
        return this.h5TitleBarReadyCallback;
    }

    public void setTitleBarReadyCallBack(H5Page.H5TitleBarReadyCallback h5TitleBarReadyCallback2) {
        this.h5TitleBarReadyCallback = h5TitleBarReadyCallback2;
    }

    public boolean ifContainsEmbedView() {
        return this.isEmbedViewScene;
    }

    public void setContainsEmbedView(boolean z) {
        this.isEmbedViewScene = z;
    }

    public APWebViewClient getAPWebViewClient() {
        return this.h5ViewClient;
    }

    public void sendExitEvent() {
        H5BridgeImpl h5BridgeImpl = this.h5Bridge;
        if (h5BridgeImpl != null && !this.hasSendExitEvent) {
            this.hasSendExitEvent = true;
            h5BridgeImpl.sendToWeb("beforeunload", (e) null, (H5CallBack) null);
            this.h5Bridge.sendToWeb("beforeDestroy", (e) null, (H5CallBack) null);
        }
    }

    public H5LoadingView getH5LoadingView() {
        H5ViewHolder h5ViewHolder2 = this.h5ViewHolder;
        if (h5ViewHolder2 != null) {
            return h5ViewHolder2.getH5LoadingView();
        }
        return null;
    }

    public boolean isTransparentTitleState() {
        String string = H5Utils.getString(this.startParams, H5Param.LONG_TRANSPARENT_TITLE);
        return TextUtils.equals(string, "auto") || TextUtils.equals(string, "always") || TextUtils.equals(string, "custom");
    }

    public boolean pageIsClose() {
        H5Log.d(TAG, "pageIsClose " + this.exited);
        return this.exited;
    }

    public ViewGroup getViewGroup() {
        H5ViewHolder h5ViewHolder2 = this.h5ViewHolder;
        if (h5ViewHolder2 != null) {
            return h5ViewHolder2.getRootView();
        }
        return null;
    }

    public void replace(String str) {
        loadUrl("javascript:location.replace('" + str + "');");
    }

    public void injectPageReady() {
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 != null) {
            h5WebView2.loadUrl("javascript:(function(){window.ALIPAYVIEWAPPEARED=1})();");
        }
        H5BridgeImpl h5BridgeImpl = this.h5Bridge;
        if (h5BridgeImpl != null) {
            h5BridgeImpl.sendToWeb("appearAfterPreRender", (e) null, (H5CallBack) null);
        }
    }

    class H5CollectJsApiHandler implements H5CallBack {
        public boolean exitTabScene = false;
        public boolean waiting = false;

        public H5CollectJsApiHandler() {
        }

        public void onCallBack(e eVar) {
            this.waiting = false;
            H5Log.d(H5PageImpl.TAG, "collectJsApi param : ".concat(String.valueOf(eVar)));
            b jSONArray = H5Utils.getJSONArray(eVar, "syncJsApis", (b) null);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                    e jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        H5PageImpl.this.sendEvent(H5Utils.getString(jSONObject, "apiName"), H5Utils.getJSONObject(jSONObject, "params", (e) null));
                    }
                }
            }
            if (H5PageImpl.this.isCheckDslError()) {
                H5PageImpl.this.checkDslErrorAndExit(this.exitTabScene);
            } else {
                H5PageImpl.this.doExitPage(this.exitTabScene);
            }
        }
    }

    public boolean getAutoHideLoading() {
        return this.autoHideLoading;
    }
}
