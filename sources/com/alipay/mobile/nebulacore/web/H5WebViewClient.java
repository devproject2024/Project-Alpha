package com.alipay.mobile.nebulacore.web;

import android.content.res.Resources;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5GetAllResponse;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5WebDriverHelper;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.res.H5ResourceManager;
import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.networksupervisor.H5NetworkSuScheduler;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5DevDebugProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5ErrorPageView;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5ReceivedSslErrorHandler;
import com.alipay.mobile.nebula.util.H5DomainUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.TestDataUtils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebula.webview.APHttpAuthHandler;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebBackForwardList;
import com.alipay.mobile.nebula.webview.APWebResourceRequest;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebula.webview.H5ResContentList;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.android.AndroidWebView;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalPackage;
import com.alipay.mobile.nebulacore.core.H5ContentProviderImpl;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.dev.trace.H5PerformanceUtils;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.plugin.H5SessionPlugin;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import com.alipay.mobile.nebulacore.util.H5ErrorMsgUtil;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.alipay.mobile.nebulacore.wallet.H5LoggerPlugin;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class H5WebViewClient implements APWebViewClient {
    public static final int DURATION_ERROR = 60000;
    private static final int DURATION_LOG = 10000;
    private static final int SIZE_200_KB = 204800;
    private static final int SIZE_60_KB = 61440;
    private static Executor sOrderedExecutor;
    private static VisitHistoryQueue<String> sVisitHistoryQueue = new VisitHistoryQueue<>(5);
    public String TAG = "H5WebViewClient";
    private H5AvailablePageData availablePageData;
    private String checkingUrl;
    private boolean enableFallbackPipline = false;
    private boolean enableLogForTinyTime = false;
    /* access modifiers changed from: private */
    public b fallbackLogArray;
    private boolean first404Page = true;
    /* access modifiers changed from: private */
    public H5PageImpl h5Page;
    private boolean hasOnPageStarted = false;
    private boolean hasShouldInterceptRequest = false;
    /* access modifiers changed from: private */
    public boolean isFirstPage = true;
    private long lastAbntime;
    private int lastPageIndex;
    private long logForTinyTime;
    private Handler mAsyncSendEventHandler = null;
    private String mBugMeViewId;
    private boolean mEnableAsyncSendEvent = true;
    /* access modifiers changed from: private */
    public H5ContentProviderImpl mH5ContentProvider;
    /* access modifiers changed from: private */
    public int mLastPageHeight;
    private boolean mPageUpdated;
    private boolean mResetChromeFileThreadPriority = false;
    private boolean mUcLongRender3s = false;
    private boolean mUcLongRender6s = false;
    /* access modifiers changed from: private */
    public H5PageData pageData;
    private long pageFinishedTime = 0;
    private long pageStartTime = 0;
    private Map<String, ResourceInfo> requestMap;
    /* access modifiers changed from: private */
    public List<String> resourcePkgIdList;
    private String shareUrl;
    private String tinyUrl = "https://appx/af-appx.min.js";
    private H5WebDriverHelper webDriverHelper;

    public void onFormResubmission(APWebView aPWebView, Message message, Message message2) {
    }

    public void onReceivedHttpAuthRequest(APWebView aPWebView, APHttpAuthHandler aPHttpAuthHandler, String str, String str2) {
    }

    public void onReceivedLoginRequest(APWebView aPWebView, String str, String str2, String str3) {
    }

    public void onTooManyRedirects(APWebView aPWebView, Message message, Message message2) {
    }

    public void onUnhandledKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
    }

    public boolean shouldOverrideKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        return false;
    }

    public H5WebViewClient(H5PageImpl h5PageImpl) {
        this.TAG += hashCode();
        this.h5Page = h5PageImpl;
        this.pageData = h5PageImpl.getPageData();
        this.availablePageData = h5PageImpl.getAvailablePageData();
        this.mPageUpdated = false;
        this.lastPageIndex = Integer.MIN_VALUE;
        this.mLastPageHeight = 0;
        this.mBugMeViewId = H5BugmeIdGenerator.getBugmeViewId(this.h5Page);
        this.pageData.setPageUrl(H5Utils.getString(h5PageImpl.getParams(), "url"));
        this.pageData.setPageToken(UUID.randomUUID().toString());
        this.requestMap = new HashMap();
        this.resourcePkgIdList = new ArrayList();
        h5PageImpl.getContentView().getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (H5WebViewClient.this.h5Page == null || H5WebViewClient.this.h5Page.getWebView() == null) {
                    return true;
                }
                if (H5WebViewClient.this.pageData.getContainerVisible() == 0) {
                    H5WebViewClient.this.pageData.setContainerVisible(System.currentTimeMillis());
                }
                if (H5WebViewClient.this.pageData.getAppear() != 0 && H5WebViewClient.this.pageData.getAppearFromNative() != 0) {
                    return true;
                }
                int contentHeight = H5WebViewClient.this.h5Page.getWebView().getContentHeight();
                if (H5WebViewClient.this.mLastPageHeight != contentHeight && H5WebViewClient.this.pageData.getAppear() == 0) {
                    H5WebViewClient.this.pageData.setAppear(System.currentTimeMillis() - H5WebViewClient.this.pageData.getStart());
                    String str = H5WebViewClient.this.TAG;
                    H5Log.d(str, "onPreDraw page appear " + H5WebViewClient.this.pageData.getAppear());
                }
                if (H5WebViewClient.this.mLastPageHeight != contentHeight && H5WebViewClient.this.pageData.getAppearFromNative() == 0) {
                    if (H5WebViewClient.this.isFirstPage) {
                        H5WebViewClient.this.pageData.setAppearFromNative(System.currentTimeMillis() - H5PageData.walletServiceStart);
                        boolean unused = H5WebViewClient.this.isFirstPage = false;
                        H5Monitor.behavior(new H5MonitorModel().start().seedId(H5MonitorModel.SEED_ID_OPEN_APP).appendSubappId(H5WebViewClient.this.pageData.getAppId()).appendPackageVersion(H5WebViewClient.this.pageData.getAppVersion()).appendUrl(H5WebViewClient.this.getPageUrl()).appendExtParams("local", H5WebViewClient.this.pageData.getIsLocal()));
                        H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_OPEN_APP).appendSubappId(H5WebViewClient.this.pageData.getAppId()).appendPackageVersion(H5WebViewClient.this.pageData.getAppVersion()).appendCostTime(System.currentTimeMillis() - H5PageData.walletServiceStart).appendUrl(H5WebViewClient.this.getPageUrl()).appendExtParams("local", H5WebViewClient.this.pageData.getIsLocal()));
                        H5WebViewClient.this.monitorFirstLaunch();
                    } else {
                        H5WebViewClient.this.pageData.setAppearFromNative(System.currentTimeMillis() - H5WebViewClient.this.pageData.getStart());
                    }
                    String str2 = H5WebViewClient.this.TAG;
                    H5Log.d(str2, "onPreDraw page appear native " + H5WebViewClient.this.pageData.getAppearFromNative());
                }
                int unused2 = H5WebViewClient.this.mLastPageHeight = contentHeight;
                return true;
            }
        });
        this.webDriverHelper = Nebula.getService().getWebDriverHelper();
        if (H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equals(H5Environment.getConfig("h5_asyncSendEvent"))) {
            this.mEnableAsyncSendEvent = false;
        }
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfig("h5_enableFallbackPiplineOpn"))) {
            this.enableFallbackPipline = true;
        }
        this.fallbackLogArray = H5Utils.parseArray(H5Environment.getConfig("h5_fallback_log"));
        this.enableLogForTinyTime = !"no".equalsIgnoreCase(H5Environment.getConfig("h5_preloadAppX"));
    }

    public String getPageUrl() {
        return this.pageData.getPageUrl();
    }

    public String getShareUrl() {
        if (TextUtils.isEmpty(this.shareUrl)) {
            return this.pageData.getPageUrl();
        }
        return this.shareUrl;
    }

    public String getRedirectUrl() {
        return this.pageData.getNavUrl();
    }

    public void setCheckingUrl(String str) {
        this.checkingUrl = str;
    }

    public void setWebProvider(H5ContentProvider h5ContentProvider) {
        this.mH5ContentProvider = (H5ContentProviderImpl) h5ContentProvider;
    }

    public boolean shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        int i2;
        H5EnvProvider h5EnvProvider;
        this.webDriverHelper.shouldOverrideUrlLoading(aPWebView, str);
        H5Log.debug(this.TAG, "gao shouldOverrideUrlLoading ".concat(String.valueOf(str)));
        H5ContentProviderImpl h5ContentProviderImpl = this.mH5ContentProvider;
        if (h5ContentProviderImpl != null) {
            h5ContentProviderImpl.disconnect();
        }
        if (this.h5Page == null || TextUtils.isEmpty(str)) {
            return true;
        }
        this.pageData.setNavUrl(str);
        this.checkingUrl = null;
        e eVar = new e();
        eVar.put("url", (Object) str);
        if (Nebula.enableOpenScheme(str)) {
            H5Log.d(this.TAG, "stripLandingURL&Deeplink url " + str + " bingo deeplink");
            return true;
        }
        if (H5Utils.isStripLandingURLEnable(str)) {
            String stripLandingURL = H5Utils.getStripLandingURL(str);
            if (!TextUtils.equals(str, stripLandingURL) && !TextUtils.isEmpty(stripLandingURL) && stripLandingURL.startsWith("alipay") && (h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName())) != null && h5EnvProvider.goToSchemeService(stripLandingURL)) {
                H5Log.d(this.TAG, "stripLandingURL&Deeplink url " + str + " bingo deeplink in landing");
                return true;
            }
        }
        if (aPWebView instanceof H5WebView) {
            try {
                if (H5Utils.getBoolean(((H5WebView) aPWebView).getWebViewConfig(), "needVerifyUrl", true)) {
                    eVar.put("needVerifyUrl", (Object) Boolean.FALSE);
                }
            } catch (Throwable th) {
                H5Log.e(this.TAG, "exception detail", th);
            }
        }
        APWebBackForwardList copyBackForwardList = aPWebView.copyBackForwardList();
        if (copyBackForwardList == null) {
            i2 = 0;
        } else {
            i2 = copyBackForwardList.getSize();
        }
        eVar.put("historySize", (Object) Integer.valueOf(i2));
        Bundle params = this.h5Page.getParams();
        if (params != null) {
            eVar.put("appId", (Object) H5Utils.getString(params, "appId"));
            String string = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN);
            String string2 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE);
            String string3 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_URL);
            eVar.put(H5Param.PRESSO_LOGIN, (Object) string);
            eVar.put(H5Param.PRESSO_LOGIN_BINDINGPAGE, (Object) string2);
            eVar.put(H5Param.PRESSO_LOGIN_URL, (Object) string3);
        }
        this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL, eVar);
        boolean z = !str.equals(this.checkingUrl);
        H5Log.d(this.TAG, "shouldOverrideUrlLoading ".concat(String.valueOf(z)));
        return z;
    }

    public void onReceivedError(APWebView aPWebView, int i2, String str, String str2) {
        this.webDriverHelper.onReceivedError(aPWebView, i2, str, str2);
        this.pageData.setErrorCode(i2);
        H5Log.d(this.TAG, "onReceivedError errorCode " + i2 + " description " + str + " failingUrl " + str2);
        sendErrorResource(str2, String.valueOf(i2), str);
        if (this.pageData.getErrorCode() < 0) {
            H5PageData h5PageData = this.pageData;
            h5PageData.setNum1000(h5PageData.getNum1000() + 1);
        }
        if (this.pageData.getErrorCode() != -97) {
            ResourceInfo resourceInfo = this.requestMap.get(str2);
            if (resourceInfo != null && resourceInfo.mIsMainDoc) {
                if (aPWebView.getType() != WebViewType.THIRD_PARTY) {
                    this.pageData.setStatusCode(i2);
                }
                reportAbnormalPage(false);
            }
            reportErrorPage(str2, "genericError");
            loadErrorPage(aPWebView, str2, this.pageData.getStatusCode());
            H5Monitor.exception(new H5MonitorModel().fail().appendPackageVersion(this.pageData.getAppVersion()).appendSubappId(this.pageData.getAppId()).appendUrl(str2).exceptionType(H5MonitorModel.EXCEPTION_PAGE_LOAD).appendMessage("load page failed"));
        }
    }

    public void onReceivedError(APWebView aPWebView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
            Uri url = webResourceRequest.getUrl();
            CharSequence description = webResourceError.getDescription();
            int errorCode = webResourceError.getErrorCode();
            String str = "";
            String charSequence = description == null ? str : description.toString();
            if (url != null) {
                str = url.toString();
            }
            onReceivedError(aPWebView, errorCode, charSequence, str);
        }
    }

    public void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        this.webDriverHelper.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
        H5LogProvider h5LogHandler = Nebula.getH5LogHandler();
        if (!(h5LogHandler == null || sslError == null)) {
            h5LogHandler.log("h5_onReceivedSslError", sslError.getUrl(), sslError.toString(), (String) null, (String) null);
        }
        H5ReceivedSslErrorHandler h5ReceivedSslErrorHandler = (H5ReceivedSslErrorHandler) Nebula.getProviderManager().getProvider(H5ReceivedSslErrorHandler.class.getName());
        if (h5ReceivedSslErrorHandler != null) {
            h5ReceivedSslErrorHandler.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
        } else if (sslError == null) {
            H5Log.e(this.TAG, "SslError==null");
        } else {
            int primaryError = sslError.getPrimaryError();
            this.pageData.setStatusCode(primaryError);
            this.pageData.setErrorCode(primaryError);
            String str = null;
            if (Build.VERSION.SDK_INT >= 14) {
                str = sslError.getUrl();
            }
            if (TextUtils.isEmpty(str)) {
                str = this.pageData.getPageUrl();
            }
            String str2 = this.TAG;
            H5Log.d(str2, "onReceivedSslError " + sslError + ", url is " + str);
            if (this.h5Page != null) {
                Uri parseUrl = H5UrlHelper.parseUrl(str);
                if (parseUrl == null || TextUtils.isEmpty(parseUrl.getScheme()) || TextUtils.isEmpty(parseUrl.getHost()) || TextUtils.equals(CommunityPostActivity.TYPE_FILE, parseUrl.getScheme())) {
                    H5Log.w(this.TAG, "ignore param check for ".concat(String.valueOf(str)));
                    return;
                } else if (TextUtils.equals(parseUrl.getHost(), H5UrlHelper.getHost(H5Utils.getString(this.h5Page.getParams(), H5Param.ONLINE_HOST)))) {
                    aPSslErrorHandler.proceed();
                    return;
                } else if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfig("h5_close_sslError"))) {
                    aPSslErrorHandler.proceed();
                    return;
                } else if (H5DomainUtil.isSomeDomainInternal(H5DomainUtil.getNewDomainSuffix(str), H5Environment.getConfig("h5_sslError_WhiteList"))) {
                    aPSslErrorHandler.proceed();
                    return;
                } else if (System.currentTimeMillis() - this.lastAbntime < 10000) {
                    aPSslErrorHandler.cancel();
                    aPWebView.stopLoading();
                    loadErrorPage(aPWebView, aPWebView.getUrl(), primaryError);
                    return;
                } else {
                    this.lastAbntime = System.currentTimeMillis();
                    reportAbnormalPage(false);
                    reportErrorPage(str, "sslError");
                }
            }
            aPSslErrorHandler.cancel();
            loadErrorPage(aPWebView, aPWebView.getUrl(), primaryError);
        }
    }

    public void onResourceResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        int parseInt = H5Utils.parseInt(hashMap.get("httpcode"));
        String str = hashMap.get("url");
        String str2 = this.TAG;
        H5Log.d(str2, "onResourceResponse statusCode " + parseInt + " url " + str);
        if (H5ResContentList.getInstance().contains(str)) {
            H5ResContentList.getInstance().remove(str);
            H5PageData h5PageData = this.pageData;
            if (h5PageData != null) {
                h5PageData.setUcCacheResNum(h5PageData.getUcCacheResNum() + 1);
            }
        }
        if (this.requestMap.containsKey(str)) {
            ResourceInfo resourceInfo = this.requestMap.get(str);
            if (this.h5Page != null && resourceInfo != null) {
                sendErrorResource(str, String.valueOf(parseInt), "");
                H5AvailablePageData h5AvailablePageData = this.availablePageData;
                if (h5AvailablePageData != null) {
                    h5AvailablePageData.reportReqEnd();
                }
                String unused = resourceInfo.mMimeType = hashMap.get("mimetype");
                int unused2 = resourceInfo.mStatusCode = parseInt;
                if (resourceInfo.mIsMainDoc) {
                    if (parseInt == 301 || parseInt == 302 || parseInt >= 400) {
                        this.h5Page.hideLoadingView();
                    }
                    this.pageData.setErrorCode(parseInt);
                    this.pageData.setFirstByte(System.currentTimeMillis() - this.pageData.getStart());
                }
                if (parseInt == 302) {
                    H5PageData h5PageData2 = this.pageData;
                    h5PageData2.setNum302(h5PageData2.getNum302() + 1);
                } else if (parseInt == 304) {
                    H5PageData h5PageData3 = this.pageData;
                    h5PageData3.setNum304(h5PageData3.getNum304() + 1);
                }
                if (parseInt >= 300 && parseInt < 400 && parseInt != 304) {
                    H5PageData h5PageData4 = this.pageData;
                    h5PageData4.setNum300(h5PageData4.getNum300() + 1);
                }
                if (parseInt == 404) {
                    H5PageData h5PageData5 = this.pageData;
                    h5PageData5.setNum404(h5PageData5.getNum404() + 1);
                }
                if (parseInt >= 400 && parseInt < 500) {
                    H5PageData h5PageData6 = this.pageData;
                    h5PageData6.setNum400(h5PageData6.getNum400() + 1);
                }
                if (parseInt >= 500) {
                    H5PageData h5PageData7 = this.pageData;
                    h5PageData7.setNum500(h5PageData7.getNum500() + 1);
                }
                if (resourceInfo.mStatusCode >= 400) {
                    if (resourceInfo.mIsMainDoc) {
                        reportErrorPage(resourceInfo.mUrl, "genericError");
                        reportAbnormalPage(false);
                    } else if (H5Utils.isJavascript(resourceInfo.mUrl)) {
                        H5PageData h5PageData8 = this.pageData;
                        h5PageData8.setNetErrorJsNum(h5PageData8.getNetErrorJsNum() + 1);
                        H5PageData h5PageData9 = this.pageData;
                        h5PageData9.setNetJsReqNum(h5PageData9.getNetJsReqNum() + 1);
                    } else {
                        H5PageData h5PageData10 = this.pageData;
                        h5PageData10.setNetErrorOtherNum(h5PageData10.getNetErrorOtherNum() + 1);
                        H5PageData h5PageData11 = this.pageData;
                        h5PageData11.setNetOtherReqNum(h5PageData11.getNetOtherReqNum() + 1);
                    }
                    reportErrorResource(resourceInfo);
                }
            }
        }
    }

    public void onResourceFinishLoad(APWebView aPWebView, String str, long j) {
        int i2;
        String str2 = str;
        long j2 = j;
        String str3 = this.TAG;
        H5Log.d(str3, "onResourceFinishLoad " + str2 + " size " + j2);
        if (!TextUtils.isEmpty(str) && this.pageData != null) {
            if (this.enableLogForTinyTime && H5Utils.isInTinyProcess() && this.tinyUrl.equals(str2)) {
                this.logForTinyTime = System.currentTimeMillis() - this.logForTinyTime;
                String str4 = this.TAG;
                H5Log.d(str4, this.tinyUrl + " load coast:" + this.logForTinyTime);
            }
            boolean equals = TextUtils.equals(this.pageData.getPageUrl(), str2);
            if (!equals && TextUtils.isEmpty(this.pageData.getResPkgInfo())) {
                getSingleThreadExecutor().execute(new Runnable() {
                    public void run() {
                        String resPkgInfo = H5GlobalPackage.getResPkgInfo(H5WebViewClient.this.pageData.getAppId());
                        String contentPackageStatus = H5WebViewClient.this.mH5ContentProvider != null ? H5WebViewClient.this.mH5ContentProvider.getContentPackageStatus() : "";
                        H5PageData access$100 = H5WebViewClient.this.pageData;
                        access$100.setResPkgInfo(resPkgInfo + contentPackageStatus);
                        H5WebViewClient.this.sendBugMeAppPkgInfo();
                    }
                });
            }
            if (equals && this.pageData.isShowErrorPage()) {
                if (j2 > 0) {
                    this.pageData.setShowErrorPage(false);
                }
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        if (H5WebViewClient.this.pageData != null && H5WebViewClient.this.h5Page != null) {
                            int reloadType = H5WebViewClient.this.pageData.getReloadType();
                            boolean isShowErrorPage = H5WebViewClient.this.pageData.isShowErrorPage();
                            H5Logger.performanceLoggerV2("H5_PAGE_REPAIR", (String) null, (String) null, (String) null, "result=" + (isShowErrorPage ? 1 : 0) + "^type=" + reloadType, (String) null, H5Logger.getUniteParam4(H5WebViewClient.this.pageData, H5WebViewClient.this.h5Page.getParams()), "H-MM");
                        }
                    }
                }, 3000);
            }
            ResourceInfo remove = this.requestMap.remove(str2);
            if (remove != null) {
                if (remove.mIsMainDoc) {
                    H5PageData h5PageData = this.pageData;
                    h5PageData.setHtmlSize(h5PageData.getHtmlSize() + j2);
                    this.pageData.setPageNetLoad(System.currentTimeMillis() - this.pageData.getStart());
                    String str5 = this.TAG;
                    H5Log.debug(str5, "url " + str2 + " pageNetLoad " + this.pageData.getPageNetLoad());
                }
                H5PageData h5PageData2 = this.pageData;
                h5PageData2.setPageLoadSize(h5PageData2.getPageLoadSize() + j2);
                H5PageData h5PageData3 = this.pageData;
                h5PageData3.setPageSize(h5PageData3.getPageSize() + j2);
                if (this.pageData.getComplete() == 0 && j2 >= 204800) {
                    H5PageData h5PageData4 = this.pageData;
                    h5PageData4.setSizeLimit200(h5PageData4.getSizeLimit200() + 1);
                    if (!H5Utils.isImage(str)) {
                        if (TextUtils.isEmpty(this.pageData.getSizeLimit200Urls())) {
                            H5PageData h5PageData5 = this.pageData;
                            h5PageData5.setSizeLimit200Urls(this.pageData.getSizeLimit200Urls() + str2 + "(" + ((int) (j2 / 1024)) + "KB)");
                        } else {
                            H5PageData h5PageData6 = this.pageData;
                            h5PageData6.setSizeLimit200Urls(this.pageData.getSizeLimit200Urls() + "|" + str2 + "(" + ((int) (j2 / 1024)) + "KB)");
                        }
                    }
                }
                if (H5Utils.isCss(str)) {
                    if (this.pageData.getComplete() == 0) {
                        H5PageData h5PageData7 = this.pageData;
                        h5PageData7.setCssLoadSize(h5PageData7.getCssLoadSize() + j2);
                    }
                    H5PageData h5PageData8 = this.pageData;
                    h5PageData8.setCssSize(h5PageData8.getCssSize() + j2);
                } else if (H5Utils.isJavascript(str)) {
                    if (this.pageData.getComplete() == 0) {
                        H5PageData h5PageData9 = this.pageData;
                        h5PageData9.setJsLoadSize(h5PageData9.getJsLoadSize() + j2);
                    }
                    H5PageData h5PageData10 = this.pageData;
                    h5PageData10.setJsSize(h5PageData10.getJsSize() + j2);
                } else if (H5Utils.isImage(str)) {
                    if (this.pageData.getComplete() == 0) {
                        if (j2 >= 61440) {
                            H5PageData h5PageData11 = this.pageData;
                            i2 = 1;
                            h5PageData11.setSizeLoadLimit60(h5PageData11.getSizeLoadLimit60() + 1);
                        } else {
                            i2 = 1;
                        }
                        if (j2 >= 204800) {
                            H5PageData h5PageData12 = this.pageData;
                            h5PageData12.setSizeLoadLimit200(h5PageData12.getSizeLoadLimit200() + i2);
                        }
                        H5PageData h5PageData13 = this.pageData;
                        h5PageData13.setImgLoadSize(h5PageData13.getImgLoadSize() + j2);
                    }
                    H5PageData h5PageData14 = this.pageData;
                    h5PageData14.setImgSize(h5PageData14.getImgSize() + j2);
                    if (j2 >= 61440) {
                        H5PageData h5PageData15 = this.pageData;
                        h5PageData15.setSizeLimit60(h5PageData15.getSizeLimit60() + 1);
                        if (TextUtils.isEmpty(this.pageData.getImageSizeLimit60Urls())) {
                            H5PageData h5PageData16 = this.pageData;
                            h5PageData16.setImageSizeLimit60Urls(this.pageData.getImageSizeLimit60Urls() + str2 + "(" + (j2 / 1024) + "KB)");
                        } else {
                            H5PageData h5PageData17 = this.pageData;
                            h5PageData17.setImageSizeLimit60Urls(this.pageData.getImageSizeLimit60Urls() + "|" + str2 + "(" + (j2 / 1024) + "KB)");
                        }
                    }
                    String str6 = this.TAG;
                    H5Log.debug(str6, "pageData.sizeLimit200Urls" + this.pageData.getSizeLimit200Urls() + " " + this.pageData.getImageSizeLimit60Urls());
                } else {
                    if (this.pageData.getComplete() == 0) {
                        H5PageData h5PageData18 = this.pageData;
                        h5PageData18.setOtherLoadSize(h5PageData18.getOtherLoadSize() + j2);
                    }
                    H5PageData h5PageData19 = this.pageData;
                    h5PageData19.setOtherSize(h5PageData19.getOtherSize() + j2);
                }
                long currentTimeMillis = System.currentTimeMillis() - remove.mStart;
                if (H5Utils.isJavascript(str)) {
                    H5PageData h5PageData20 = this.pageData;
                    h5PageData20.setNetJsReqNum(h5PageData20.getNetJsReqNum() + 1);
                    H5PageData h5PageData21 = this.pageData;
                    h5PageData21.setNetJsSize(h5PageData21.getNetJsSize() + j2);
                    H5PageData h5PageData22 = this.pageData;
                    h5PageData22.setNetJsTime(h5PageData22.getNetJsTime() + currentTimeMillis);
                } else {
                    H5PageData h5PageData23 = this.pageData;
                    h5PageData23.setNetOtherReqNum(h5PageData23.getNetOtherReqNum() + 1);
                    H5PageData h5PageData24 = this.pageData;
                    h5PageData24.setNetOtherSize(h5PageData24.getNetOtherSize() + j2);
                    H5PageData h5PageData25 = this.pageData;
                    h5PageData25.setNetOtherTime(h5PageData25.getNetOtherTime() + currentTimeMillis);
                }
                if (currentTimeMillis >= 60000) {
                    if (remove.mIsMainDoc) {
                        reportAbnormalPage(true);
                    } else {
                        reportErrorResource(remove);
                    }
                }
            }
        }
    }

    public void onReceivedResponseHeader(Map<String, List<String>> map) {
        List list;
        if (map != null && map.size() != 0 && map.containsKey("x-ap-pkg-id") && (list = map.get("x-ap-pkg-id")) != null && list.size() > 0) {
            addResourcePackage((String) list.get(0));
        }
    }

    private void addResourcePackage(String str) {
        H5ConfigProvider h5ConfigProvider;
        String[] split;
        if (!TextUtils.isEmpty(str) && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null) {
            e parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5_pkgresmode"));
            String string = H5Utils.getString(parseObject, "switchheader");
            int i2 = 3;
            try {
                i2 = Integer.parseInt(H5Utils.getString(parseObject, "limit", "3"));
            } catch (NumberFormatException e2) {
                H5Log.e(this.TAG, (Throwable) e2);
            }
            if (!StringSet.off.equalsIgnoreCase(string) && (split = str.split(AppConstants.COMMA)) != null && split.length != 0 && split.length <= i2) {
                final List asList = Arrays.asList(split);
                H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
                    public void run() {
                        if (H5WebViewClient.this.pageData != null) {
                            for (String str : asList) {
                                if (!str.equals(H5WebViewClient.this.pageData.getAppId())) {
                                    H5GlobalPackage.addResourcePackage(H5WebViewClient.this.pageData.getAppId(), str, true, false);
                                }
                            }
                        }
                        H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
                        if (h5AppProvider != null) {
                            HashMap hashMap = new HashMap();
                            for (String str2 : asList) {
                                if (!H5WebViewClient.this.resourcePkgIdList.contains(str2)) {
                                    if (NebulaUtil.enableResDegrade()) {
                                        hashMap.put(str2, "*");
                                    } else {
                                        hashMap.put(str2, h5AppProvider.getWalletConfigNebulaVersion(str2));
                                    }
                                    H5WebViewClient.this.resourcePkgIdList.add(str2);
                                    H5Log.d(H5WebViewClient.this.TAG, "resourcePkgIdList add : ".concat(String.valueOf(str2)));
                                }
                            }
                            if (hashMap.isEmpty()) {
                                H5Log.d(H5WebViewClient.this.TAG, "map.isEmpty , don't sent rpc");
                                return;
                            }
                            AppReq appReq = new AppReq();
                            appReq.stableRpc = H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
                            h5AppProvider.updateAppWithReq(hashMap, true, new H5AppInstallProcess() {
                                public void onResult(boolean z, boolean z2) {
                                }

                                public void prepare(H5AppInstallStep h5AppInstallStep, String str) {
                                }
                            }, true, false, appReq, false, asList);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendBugMeAppPkgInfo() {
        H5AppProvider h5AppProvider;
        H5PageData h5PageData;
        H5DevDebugProvider h5DevDebugProvider = (H5DevDebugProvider) H5ProviderManagerImpl.getInstance().getProvider(H5DevDebugProvider.class.getName());
        if (h5DevDebugProvider != null && (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) != null && this.h5Page != null && (h5PageData = this.pageData) != null) {
            String appName = h5AppProvider.getAppName(h5PageData.getAppId(), this.pageData.getAppVersion());
            String string = H5Utils.getString(this.h5Page.getParams(), H5AppUtil.package_nick);
            e eVar = new e();
            eVar.put("appId", (Object) this.pageData.getAppId());
            eVar.put("name", (Object) appName);
            eVar.put("version", (Object) this.pageData.getAppVersion());
            eVar.put("packageNick", (Object) string);
            eVar.put(SubAppConfig.AppType.RESOURCE, (Object) this.pageData.getResPkgInfo());
            h5DevDebugProvider.setPkgInfo(this.mBugMeViewId, eVar);
        }
    }

    private void sendErrorResource(String str, String str2, String str3) {
        if (this.h5Page != null && !TextUtils.equals(str2, "200") && !TextUtils.equals(str2, "302") && !TextUtils.equals(str2, "304")) {
            String str4 = this.TAG;
            H5Log.debug(str4, "sendErrorResource:" + str + "  errorCode:" + str2 + " description:" + str3);
            e eVar = new e();
            eVar.put("url", (Object) str);
            eVar.put("error", (Object) str2);
            eVar.put(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, (Object) str3);
            eVar.put("client", (Object) "android");
            e eVar2 = new e();
            eVar2.put("data", (Object) eVar);
            this.h5Page.getBridge().sendToWeb(H5Plugin.CommonEvents.H5_RESOURCE_LOST, eVar2, (H5CallBack) null);
        }
    }

    public boolean shouldInterceptResponse(final APWebView aPWebView, HashMap<String, String> hashMap) {
        final String str = hashMap.get("url");
        final int parseInt = H5Utils.parseInt(hashMap.get("httpcode"));
        if ((parseInt > 100 && parseInt < 400) || aPWebView == null) {
            return false;
        }
        if (parseInt == 404 || parseInt == 403) {
            H5Log.d(this.TAG, "404 or 403,shouldInterceptResponse return false ");
            return false;
        }
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                H5WebViewClient.this.loadErrorPage(aPWebView, str, parseInt);
            }
        }, 20);
        return true;
    }

    private void reportErrorResource(ResourceInfo resourceInfo) {
        if (this.h5Page != null) {
            e eVar = new e();
            eVar.put("targetUrl", (Object) resourceInfo.mUrl);
            eVar.put("method", (Object) resourceInfo.mMethod);
            eVar.put("type", (Object) resourceInfo.mMimeType);
            eVar.put("status", (Object) Integer.valueOf(resourceInfo.mStatusCode));
            eVar.put("start", (Object) Long.valueOf(resourceInfo.mStart));
            eVar.put(com.business.merchant_payments.common.utility.AppConstants.DURATION, (Object) Long.valueOf(System.currentTimeMillis() - resourceInfo.mStart));
            eVar.put("isMainDoc", (Object) resourceInfo.mIsMainDoc ? H5Param.DEFAULT_LONG_PRESSO_LOGIN : H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_AL_NETWORK_PERFORMANCE_ERROR, eVar);
        }
    }

    private void reportErrorPage(String str, String str2) {
        if (this.h5Page != null) {
            String str3 = this.TAG;
            H5Log.d(str3, "reportErrorPage errorCode " + this.pageData.getErrorCode());
            e eVar = new e();
            eVar.put(CLConstants.FIELD_ERROR_CODE, (Object) Integer.valueOf(this.pageData.getErrorCode()));
            eVar.put("type", (Object) str2);
            eVar.put("url", (Object) str);
            eVar.put("networkType", (Object) H5Utils.getNetworkType(H5Environment.getContext()));
            eVar.put("deviceInfo", (Object) H5Log.CURRENT_DEVICE_SPEC);
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_ERROR, eVar);
        }
    }

    private void reportAbnormalPage(boolean z) {
        if (this.h5Page != null) {
            e eVar = null;
            if (z) {
                eVar = new e();
                eVar.put("errorType", (Object) "longRender");
            }
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL, eVar);
        }
    }

    /* access modifiers changed from: private */
    public void loadErrorPage(APWebView aPWebView, String str, int i2) {
        String str2 = this.TAG;
        H5Log.d(str2, "loadErrorPage " + str + " statusCode " + i2);
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl != null) {
            if (h5PageImpl.getParams() != null) {
                this.h5Page.getParams().putBoolean(Nebula.DSL_ERROR, true);
            }
            if (!this.h5Page.onInterceptError(str, i2)) {
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL, (e) null);
                if (!preventShowErrorPage(aPWebView, str, i2)) {
                    this.h5Page.getScriptLoader().resetBridge();
                    if (this.h5Page.getPageData() != null) {
                        this.h5Page.getPageData().setShowErrorPage(true);
                    }
                    String errorPageMsg = H5ErrorMsgUtil.getErrorPageMsg(i2);
                    String str3 = this.TAG;
                    H5Log.d(str3, "load error page for: statusCode:" + i2 + " errorResult:" + errorPageMsg);
                    H5ErrorPageView h5ErrorPageView = (H5ErrorPageView) Nebula.getProviderManager().getProvider(H5ErrorPageView.class.getName());
                    if (h5ErrorPageView == null || !h5ErrorPageView.enableShowErrorPage()) {
                        showDefaultErrorPage(aPWebView, str, i2, errorPageMsg);
                    } else {
                        h5ErrorPageView.errorPageCallback(this.h5Page, aPWebView, str, i2, errorPageMsg);
                    }
                }
            }
        }
    }

    private void showDefaultErrorPage(APWebView aPWebView, String str, int i2, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Resources resources = H5Environment.getResources();
        if (resources != null) {
            str5 = resources.getString(R.string.h5_loading_failed);
            str4 = resources.getString(R.string.h5_menu_refresh);
            str3 = resources.getString(R.string.h5_network_check);
            if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_TRANS_ANIMATE, false)) {
                str6 = resources.getString(R.string.h5_backward);
            } else {
                str6 = resources.getString(R.string.h5_close);
            }
        } else {
            str6 = "";
            str5 = str6;
            str4 = str5;
            str3 = str4;
        }
        H5Log.d(this.TAG, "showDefaultErrorPage buttonText ".concat(String.valueOf(str4)));
        if (NebulaUtil.isShowTransAnimate(this.h5Page.getParams())) {
            str7 = H5ResourceManager.getRaw(R.raw.h5_trans_page_error);
        } else {
            str7 = H5ResourceManager.getRaw(R.raw.h5_page_error);
        }
        if (str7 != null) {
            if (!Nebula.DEBUG) {
                str7 = removeDebugStub(str7);
            }
            String replace = str7.replace("####", str4).replace("****", str3);
            String replace2 = replace.replaceAll("&&&&", str2 + " " + i2).replace("!!!!", str5).replace("$$$$", String.valueOf(i2)).replace("^^^^", str6);
            if (!TextUtils.isEmpty(str)) {
                str8 = replace2.replace("%%%%", str);
            } else {
                str8 = replace2.replace("%%%%", "");
            }
            aPWebView.loadDataWithBaseURL(str, str8.replace("@@@@", H5SessionPlugin.SHOW_NETWORK_CHECK_ACTIVITY), "text/html", "utf-8", str);
            if (this.h5Page != null) {
                e eVar = new e();
                e eVar2 = new e();
                eVar2.put("spmId", (Object) "H5_NONESPM_PAGE");
                eVar.put("spm", (Object) eVar2);
                this.h5Page.sendEvent(H5LoggerPlugin.REPORT_DATA, eVar);
            }
        }
    }

    private boolean preventShowErrorPage(APWebView aPWebView, String str, int i2) {
        String string = H5Utils.getString(this.h5Page.getParams(), H5Param.LONG_BIZ_TYPE);
        H5Log.d(this.TAG, "bizType:".concat(String.valueOf(string)));
        if (TextUtils.equals(string, "Advertisement")) {
            this.h5Page.getContentView().setVisibility(8);
            return true;
        } else if (!H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_TRANSPARENT, false) || H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_TRANS_ANIMATE, false)) {
            this.h5Page.sendEvent("h5PageErrorForTitlebar", (e) null);
            if (i2 != 403 && i2 != 404) {
                return false;
            }
            if (this.first404Page) {
                aPWebView.loadUrl(str);
                this.first404Page = false;
            }
            H5Log.d(this.TAG, "loadErrorPage:404 or 403,not show error page");
            return true;
        } else {
            H5Log.d(this.TAG, "loadErrorPage in transparent case return directly");
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
            return true;
        }
    }

    private String removeDebugStub(String str) {
        return str.replace("id=\"networkCheck\"", "id=\"networkCheck\" style=\"display: none\" ");
    }

    public void onWebViewEvent(APWebView aPWebView, int i2, Object obj) {
        H5Log.d(this.TAG, "onWebViewEvent ".concat(String.valueOf(i2)));
        if (i2 == 9) {
            String str = this.TAG;
            H5Log.d(str, "onWebViewEvent empty page " + aPWebView.getUrl());
            H5PageImpl h5PageImpl = this.h5Page;
            if (h5PageImpl == null || h5PageImpl.ifContainsEmbedView()) {
                H5Log.d(this.TAG, "onWebViewEvent h5Page == null || isEmbedViewScene return");
                return;
            }
            int i3 = 0;
            try {
                i3 = Integer.parseInt(String.valueOf(obj));
            } catch (Exception e2) {
                H5Log.e(this.TAG, (Throwable) e2);
            }
            H5Log.d(this.TAG, "onWebViewEvent empty page blankTime is ".concat(String.valueOf(i3)));
            if (i3 == 3) {
                this.mUcLongRender3s = true;
                if (Nebula.DEBUG) {
                    TestDataUtils.storeJSParams("pageLoad|emptyScreen", 3);
                }
            }
            if (i3 == 6) {
                this.mUcLongRender6s = true;
                if (Nebula.DEBUG) {
                    TestDataUtils.storeJSParams("pageLoad|emptyScreen", 6);
                }
                H5PageImpl h5PageImpl2 = this.h5Page;
                if (!(h5PageImpl2 == null || h5PageImpl2.getParams() == null)) {
                    this.h5Page.getParams().putBoolean(Nebula.DSL_ERROR, true);
                }
            }
            if (i3 == 9) {
                String str2 = this.TAG;
                H5Log.d(str2, "onWebViewEvent empty page blankTime 3&6 " + this.mUcLongRender3s + AppConstants.AND_SIGN + this.mUcLongRender6s);
                if (Nebula.DEBUG) {
                    TestDataUtils.storeJSParams("pageLoad|emptyScreen", 9);
                }
                if (!NebulaUtil.isScreenOn()) {
                    H5Log.d(this.TAG, "activity isBackgroundRunning or screenOff");
                    return;
                }
                if (this.mUcLongRender3s && this.mUcLongRender6s && !H5Flag.hasShowLoading) {
                    H5Log.d(this.TAG, "onWebViewEvent empty page blankTime is report monitor");
                    e eVar = new e();
                    eVar.put("errorType", (Object) "ucLongRender");
                    this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL, eVar);
                }
                NebulaUtil.whiteScreenSnapshotUpload(this.h5Page);
                checkDSLError(aPWebView);
            }
        }
    }

    private void checkDSLError(APWebView aPWebView) {
        if (NebulaUtil.isUcCheckDsl() && NebulaUtil.isLogBlankScreen(this.h5Page.getPageData().getAppId()) && H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isTinyApp, false) && !TextUtils.isEmpty(NebulaUtil.dslJs)) {
            aPWebView.evaluateJavascript(NebulaUtil.dslJs, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    H5Log.d(H5WebViewClient.this.TAG, "check dsl result : ".concat(String.valueOf(str)));
                    e parseObject = H5Utils.parseObject(str);
                    if (parseObject != null) {
                        try {
                            if (parseObject.containsKey("isDSLError") && "true".equalsIgnoreCase(String.valueOf(parseObject.get("isDSLError")))) {
                                e eVar = new e();
                                eVar.put("errorType", (Object) "errorRender");
                                eVar.put(CLConstants.FIELD_ERROR_CODE, (Object) Integer.valueOf(H5ErrorCode.BLANK_SCREEN_DSL_ERROR));
                                if (H5WebViewClient.this.h5Page != null && H5WebViewClient.this.h5Page.getParams() != null) {
                                    H5Log.d(H5WebViewClient.this.TAG, "send page abnormal event : ".concat(String.valueOf(eVar)));
                                    H5WebViewClient.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL, eVar);
                                }
                            }
                        } catch (Exception e2) {
                            H5Log.e(H5WebViewClient.this.TAG, (Throwable) e2);
                        }
                    }
                }
            });
        }
    }

    public void onFirstVisuallyRender(APWebView aPWebView) {
        long currentTimeMillis = System.currentTimeMillis();
        H5Log.d(this.TAG, "onFirstVisuallyRender ".concat(String.valueOf(currentTimeMillis)));
        e eVar = new e();
        if (aPWebView != null) {
            eVar.put("url", (Object) aPWebView.getUrl());
        }
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl != null) {
            h5PageImpl.getPageData().setFirstVisuallyRender(currentTimeMillis);
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RENDER, eVar);
        }
    }

    public void onScaleChanged(APWebView aPWebView, float f2, float f3) {
        if (aPWebView != null) {
            aPWebView.setScale(f3);
        }
    }

    public String getJSBridge() {
        e jSONObject;
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl == null || h5PageImpl.getParams() == null || (jSONObject = H5Utils.toJSONObject(this.h5Page.getParams())) == null || jSONObject.isEmpty()) {
            return null;
        }
        Nebula.removeBridgeTimeParam(jSONObject);
        HashMap hashMap = new HashMap();
        hashMap.put(H5ScriptLoader.startupParams, jSONObject.toJSONString());
        H5PageImpl h5PageImpl2 = this.h5Page;
        String loadJsBridge = Nebula.loadJsBridge(hashMap, 0, h5PageImpl2 != null ? h5PageImpl2.getWebViewId() : -1);
        H5Log.d(this.TAG, "begin set uc bridge ".concat(String.valueOf(loadJsBridge)));
        return loadJsBridge;
    }

    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
        return shouldInterceptRequest(aPWebView, aPWebResourceRequest.getUrl(), aPWebResourceRequest.getMethod());
    }

    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, String str) {
        return shouldInterceptRequest(aPWebView, H5UrlHelper.parseUrl(str), H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
    }

    private WebResourceResponse shouldInterceptRequest(final APWebView aPWebView, Uri uri, String str) {
        WebResourceResponse webResourceResponse = null;
        if (uri != null && !this.requestMap.containsKey(uri.toString())) {
            if (!this.mResetChromeFileThreadPriority && Looper.getMainLooper() != Looper.myLooper()) {
                this.mResetChromeFileThreadPriority = true;
                try {
                    Process.setThreadPriority(-20);
                } catch (Throwable th) {
                    H5Log.e(this.TAG, "setThreadPriority", th);
                }
            }
            final String uri2 = uri.toString();
            try {
                if (this.enableLogForTinyTime && H5Utils.isInTinyProcess() && this.tinyUrl.equals(uri2)) {
                    this.logForTinyTime = System.currentTimeMillis();
                }
                this.hasShouldInterceptRequest = true;
                String str2 = this.TAG;
                H5Log.d(str2, "shouldInterceptRequest " + uri2 + " method " + str);
                boolean equals = TextUtils.equals(this.pageData.getPageUrl(), uri2);
                if (this.mH5ContentProvider != null) {
                    this.mH5ContentProvider.clearInputException();
                    webResourceResponse = this.mH5ContentProvider.getContent(uri, uri2, this.h5Page, true, this.enableFallbackPipline);
                    if (this.mH5ContentProvider.hasInputException() && equals && !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_handleInputException"))) {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                H5Log.d(H5WebViewClient.this.TAG, "handle hasInputException");
                                H5WebViewClient.this.loadErrorPage(aPWebView, uri2, -1);
                            }
                        }, 20);
                    }
                    if (webResourceResponse != null) {
                        if (Nebula.DEBUG) {
                            copyReportMark(uri2, webResourceResponse);
                        }
                        if (equals) {
                            this.pageData.setIsLocal(this.mH5ContentProvider.getLocal());
                        }
                    } else if (equals) {
                        this.pageData.setIsLocal(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
                    }
                }
                final boolean z = webResourceResponse != null;
                if (!z) {
                    ResourceInfo resourceInfo = new ResourceInfo(System.currentTimeMillis(), str);
                    if (uri2 != null && equals) {
                        this.requestMap.clear();
                        boolean unused = resourceInfo.mIsMainDoc = true;
                    }
                    String unused2 = resourceInfo.mUrl = uri2;
                    this.requestMap.put(uri2, resourceInfo);
                }
                final Uri uri3 = uri;
                final String str3 = uri2;
                final String str4 = str;
                final boolean z2 = equals;
                getSingleThreadExecutor().execute(new Runnable() {
                    public void run() {
                        H5LogProvider h5LogHandler;
                        if (H5WebViewClient.this.h5Page == null) {
                            H5Log.d(H5WebViewClient.this.TAG, "page ==null not log");
                            return;
                        }
                        H5WebViewClient.this.initReqPageData(uri3);
                        H5WebViewClient h5WebViewClient = H5WebViewClient.this;
                        h5WebViewClient.reqStartLog(h5WebViewClient.pageData.getPageUrl(), str3, str4, z2);
                        H5DevDebugProvider h5DevDebugProvider = (H5DevDebugProvider) H5ProviderManagerImpl.getInstance().getProviderUseCache(H5DevDebugProvider.class.getName(), true);
                        if (z) {
                            H5WebViewClient.this.sendBugMeNetworkEvent(h5DevDebugProvider, str3, str4, true);
                        }
                        if (H5WebViewClient.this.fallbackLogArray != null && H5WebViewClient.this.fallbackLogArray.contains(str3) && (h5LogHandler = Nebula.getH5LogHandler()) != null) {
                            if (z) {
                                h5LogHandler.log("h5_goto_fallback", str3, (String) null, (String) null, "goto_fallback=false");
                            } else {
                                h5LogHandler.log("h5_goto_fallback", str3, (String) null, (String) null, "goto_fallback=true");
                            }
                        }
                    }
                });
            } catch (Throwable th2) {
                H5Log.e(this.TAG, th2);
            }
        }
        return webResourceResponse;
    }

    public static synchronized Executor getSingleThreadExecutor() {
        Executor executor;
        synchronized (H5WebViewClient.class) {
            if (sOrderedExecutor == null) {
                sOrderedExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(30), new H5ThreadPoolFactory.H5SingleThreadFactory("H5_InterceptRequest_SingleThreadExecutor"), new H5ThreadPoolFactory.DiscardOldestPolicy());
            }
            executor = sOrderedExecutor;
        }
        return executor;
    }

    /* access modifiers changed from: private */
    public void sendBugMeNetworkEvent(H5DevDebugProvider h5DevDebugProvider, String str, String str2, boolean z) {
        if (h5DevDebugProvider != null && this.h5Page != null) {
            e eVar = new e();
            int nextRequestId = H5BugmeIdGenerator.nextRequestId();
            eVar.put("reqId", (Object) Integer.valueOf(nextRequestId));
            eVar.put("reqUrl", (Object) str);
            eVar.put("method", (Object) str2);
            eVar.put("fromLocalPkg", (Object) Boolean.valueOf(z));
            this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_DEV_NETWORK_SRART, eVar);
            if (z) {
                e eVar2 = (e) eVar.clone();
                eVar2.put("reqId", (Object) Integer.valueOf(nextRequestId));
                eVar2.put("statusCode", (Object) 200);
                this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_DEV_NETWORK_FINISH, eVar2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reqStartLog(String str, String str2, String str3, boolean z) {
        try {
            H5Logger.performanceH5Exception("H5_AL_NETWORK_START", (String) null, (String) null, (String) null, "url=" + str + "^targetUrl=" + str2 + "^method=" + str3 + "^isMainDoc=" + z + "^start=" + System.currentTimeMillis(), H5Logger.getUniteParam4(this.pageData, this.h5Page.getParams()), (String) null, "H-MM", "");
        } catch (Exception e2) {
            H5Log.e(this.TAG, "reqStartLog catch exception ", e2);
        }
    }

    private void copyReportMark(String str, WebResourceResponse webResourceResponse) {
        H5GetAllResponse h5GetAllResponse = (H5GetAllResponse) H5Utils.getProvider(H5GetAllResponse.class.getName());
        if (h5GetAllResponse == null) {
            return;
        }
        if (H5Utils.getConfigBoolean(H5Environment.getContext(), "h5_stamper")) {
            H5Log.debug(this.TAG, "h5GetAllResponse is not null");
            PoolingByteArrayOutputStream poolingByteArrayOutputStream = null;
            byte[] buf = H5IOUtils.getBuf(TarConstants.EOF_BLOCK);
            try {
                PoolingByteArrayOutputStream poolingByteArrayOutputStream2 = new PoolingByteArrayOutputStream();
                while (true) {
                    try {
                        int read = webResourceResponse.getData().read(buf);
                        if (read >= 0) {
                            poolingByteArrayOutputStream2.write(buf, 0, read);
                        } else {
                            poolingByteArrayOutputStream2.flush();
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream2.toByteArray());
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(poolingByteArrayOutputStream2.toByteArray());
                            H5Log.debug(this.TAG, "call h5GetAllResponse.setData");
                            h5GetAllResponse.setData(str, byteArrayInputStream);
                            H5Log.debug(this.TAG, "response.setData(stream2)");
                            webResourceResponse.setData(byteArrayInputStream2);
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        poolingByteArrayOutputStream = poolingByteArrayOutputStream2;
                        try {
                            H5Log.debug(this.TAG, "copyReportMark exception : ".concat(String.valueOf(e)));
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            poolingByteArrayOutputStream2 = poolingByteArrayOutputStream;
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                H5Log.debug(this.TAG, "copyReportMark exception : ".concat(String.valueOf(e)));
                H5IOUtils.returnBuf(buf);
                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
            }
        } else {
            H5Log.d(this.TAG, "h5GetAllResponse is null");
        }
    }

    /* access modifiers changed from: private */
    public void initReqPageData(Uri uri) {
        H5AvailablePageData h5AvailablePageData = this.availablePageData;
        if (h5AvailablePageData != null) {
            h5AvailablePageData.reportReqStart();
        }
        String path = uri.getPath();
        H5PageData h5PageData = this.pageData;
        h5PageData.setRequestNum(h5PageData.getRequestNum() + 1);
        boolean z = this.pageData.getComplete() == 0;
        if (z) {
            H5PageData h5PageData2 = this.pageData;
            h5PageData2.setRequestLoadNum(h5PageData2.getRequestLoadNum() + 1);
        }
        if (H5Utils.isCss(path)) {
            if (z) {
                H5PageData h5PageData3 = this.pageData;
                h5PageData3.setCssLoadNum(h5PageData3.getCssLoadNum() + 1);
            }
            H5PageData h5PageData4 = this.pageData;
            h5PageData4.setCssReqNum(h5PageData4.getCssReqNum() + 1);
        } else if (H5Utils.isJavascript(path)) {
            if (z) {
                H5PageData h5PageData5 = this.pageData;
                h5PageData5.setJsLoadNum(h5PageData5.getJsLoadNum() + 1);
            }
            H5PageData h5PageData6 = this.pageData;
            h5PageData6.setJsReqNum(h5PageData6.getJsReqNum() + 1);
        } else if (H5Utils.isImage(path)) {
            if (z) {
                H5PageData h5PageData7 = this.pageData;
                h5PageData7.setImgLoadNum(h5PageData7.getImgLoadNum() + 1);
            }
            H5PageData h5PageData8 = this.pageData;
            h5PageData8.setImgReqNum(h5PageData8.getImgReqNum() + 1);
        } else {
            if (z) {
                H5PageData h5PageData9 = this.pageData;
                h5PageData9.setOtherLoadNum(h5PageData9.getOtherLoadNum() + 1);
            }
            H5PageData h5PageData10 = this.pageData;
            h5PageData10.setOtherReqNum(h5PageData10.getOtherReqNum() + 1);
        }
    }

    public void onLoadResource(APWebView aPWebView, final String str) {
        H5Log.d(this.TAG, "onLoadResource ".concat(String.valueOf(str)));
        if (this.h5Page != null && !TextUtils.isEmpty(str)) {
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                return;
            }
            if (this.mEnableAsyncSendEvent) {
                if (this.mAsyncSendEventHandler == null) {
                    this.mAsyncSendEventHandler = new Handler();
                }
                this.mAsyncSendEventHandler.post(new Runnable() {
                    public void run() {
                        if (H5WebViewClient.this.h5Page != null) {
                            e eVar = new e();
                            eVar.put("url", (Object) str);
                            Bundle params = H5WebViewClient.this.h5Page.getParams();
                            if (params != null) {
                                eVar.put("appId", (Object) H5Utils.getString(params, "appId"));
                                String string = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN);
                                String string2 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE);
                                String string3 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_URL);
                                eVar.put(H5Param.PRESSO_LOGIN, (Object) string);
                                eVar.put(H5Param.PRESSO_LOGIN_BINDINGPAGE, (Object) string2);
                                eVar.put(H5Param.PRESSO_LOGIN_URL, (Object) string3);
                            }
                            H5WebViewClient.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_LOAD_RESOURCE, eVar);
                        }
                    }
                });
                return;
            }
            e eVar = new e();
            eVar.put("url", (Object) str);
            Bundle params = this.h5Page.getParams();
            if (params != null) {
                eVar.put("appId", (Object) H5Utils.getString(params, "appId"));
                String string = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN);
                String string2 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE);
                String string3 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_URL);
                eVar.put(H5Param.PRESSO_LOGIN, (Object) string);
                eVar.put(H5Param.PRESSO_LOGIN_BINDINGPAGE, (Object) string2);
                eVar.put(H5Param.PRESSO_LOGIN_URL, (Object) string3);
            }
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_LOAD_RESOURCE, eVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b8, code lost:
        if (android.text.TextUtils.isEmpty(r13) != false) goto L_0x01ba;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageStarted(com.alipay.mobile.nebula.webview.APWebView r11, final java.lang.String r12, android.graphics.Bitmap r13) {
        /*
            r10 = this;
            r0 = 1
            r10.hasOnPageStarted = r0
            java.lang.String r1 = r10.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "onPageStarted "
            r2.<init>(r3)
            r2.append(r12)
            java.lang.String r3 = " originalUrl "
            r2.append(r3)
            java.lang.String r3 = r11.getOriginalUrl()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)
            com.alipay.mobile.h5container.api.H5WebDriverHelper r1 = r10.webDriverHelper
            r1.onPageStarted(r11, r12, r13)
            com.alipay.mobile.nebula.dev.H5BugMeManager r13 = com.alipay.mobile.nebulacore.Nebula.getH5BugMeManager()
            r13.setWebViewDebugging(r12, r11)
            android.content.Context r13 = com.alipay.mobile.nebulacore.env.H5Environment.getContext()
            if (r13 == 0) goto L_0x0062
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r1 = "H5"
            r13.<init>(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            android.content.Context r4 = com.alipay.mobile.nebulacore.env.H5Environment.getContext()
            int r4 = com.alipay.mobile.nebula.util.H5Utils.getUid(r4)
            long r4 = (long) r4
            long r2 = r2 + r4
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = com.alipay.mobile.nebula.util.H5SecurityUtil.getMD5(r1)
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            com.alipay.mobile.h5container.api.H5PageLoader.h5Token = r13
        L_0x0062:
            android.view.View r13 = r11.getView()
            r1 = 0
            if (r13 == 0) goto L_0x0070
            android.view.View r13 = r11.getView()
            r13.setVisibility(r1)
        L_0x0070:
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            if (r13 != 0) goto L_0x0075
            return
        L_0x0075:
            long r2 = r10.pageStartTime
            r4 = 0
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 != 0) goto L_0x00ad
            long r2 = java.lang.System.currentTimeMillis()
            r10.pageStartTime = r2
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r13.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = r13.start()
            java.lang.String r2 = "H5_CONTAINER_PAGE_LOAD"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = r13.seedId(r2)
            com.alipay.mobile.h5container.api.H5PageData r2 = r10.pageData
            java.lang.String r2 = r2.getAppVersion()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = r13.appendPackageVersion(r2)
            com.alipay.mobile.h5container.api.H5PageData r2 = r10.pageData
            java.lang.String r2 = r2.getAppId()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = r13.appendSubappId(r2)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r13 = r13.appendUrl(r12)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r13)
        L_0x00ad:
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            r13.setContainsEmbedView(r1)
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            int r2 = com.alipay.mobile.nebulacore.Nebula.getPageId()
            r13.setPageId(r2)
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r13 = r13.getContext()
            if (r13 == 0) goto L_0x0109
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r13 = r13.getContext()
            android.content.Context r13 = r13.getContext()
            boolean r13 = r13 instanceof com.alipay.mobile.nebulacore.ui.H5Activity
            if (r13 == 0) goto L_0x0109
            java.lang.String r13 = "h5_bug_me_show_icon"
            boolean r13 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r13, r1)
            if (r13 == 0) goto L_0x0109
            com.alipay.mobile.nebula.dev.H5BugMeManager r13 = com.alipay.mobile.nebulacore.Nebula.getH5BugMeManager()
            boolean r13 = r13.hasAccessToDebug(r12)
            if (r13 == 0) goto L_0x0109
            com.alipay.mobile.nebulacore.dev.provider.H5DebugConsolePool r13 = com.alipay.mobile.nebulacore.dev.provider.H5DebugConsolePool.getInstance()
            com.alipay.mobile.nebulacore.core.H5PageImpl r2 = r10.h5Page
            com.alipay.mobile.nebulacore.dev.bugme.H5BugmeConsole r13 = r13.addOrGetConsole(r2)
            r13.startup()
            java.lang.String r13 = "h5_bug_me_debug_switch_keep"
            boolean r13 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r13, r1)
            if (r13 == 0) goto L_0x0109
            java.lang.String r13 = "h5_bug_me_super_user"
            boolean r13 = com.alipay.mobile.nebula.dev.H5DevConfig.getBooleanConfig(r13, r1)
            if (r13 == 0) goto L_0x0109
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            com.alipay.mobile.nebulacore.web.H5WebView r13 = r13.getWebView()
            r13.clearCache(r0)
        L_0x0109:
            r10.mUcLongRender3s = r1
            r10.mUcLongRender6s = r1
            r10.mPageUpdated = r1
            com.alipay.mobile.nebulacore.core.H5ContentProviderImpl r13 = r10.mH5ContentProvider
            if (r13 == 0) goto L_0x0116
            r13.reSetLocal()
        L_0x0116:
            com.alipay.mobile.h5container.api.H5AvailablePageData r13 = r10.availablePageData
            if (r13 == 0) goto L_0x0126
            r13.clear()
            com.alipay.mobile.h5container.api.H5AvailablePageData r13 = r10.availablePageData
            long r2 = java.lang.System.currentTimeMillis()
            r13.setPageStartTime(r2)
        L_0x0126:
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r13 = r13.getNavUrl()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x014a
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r13 = r13.getNavUrl()
            com.alipay.mobile.h5container.api.H5PageData r2 = r10.pageData
            java.lang.String r2 = r2.getPageUrl()
            boolean r13 = r13.equals(r2)
            if (r13 == 0) goto L_0x014a
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r2 = 0
            r13.setNavUrl(r2)
        L_0x014a:
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            long r2 = r13.getStart()
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0190
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "["
            r2.<init>(r3)
            com.alipay.mobile.h5container.api.H5PageData r3 = r10.pageData
            java.lang.String r3 = r3.getPageUrl()
            r2.append(r3)
            java.lang.String r3 = "{"
            r2.append(r3)
            com.alipay.mobile.h5container.api.H5PageData r3 = r10.pageData
            long r3 = r3.getPageNetLoad()
            r2.append(r3)
            java.lang.String r3 = "}->("
            r2.append(r3)
            com.alipay.mobile.h5container.api.H5PageData r3 = r10.pageData
            int r3 = r3.getStatusCode()
            r2.append(r3)
            java.lang.String r3 = ")]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r13.setReferer(r2)
        L_0x0190:
            java.lang.String r13 = ""
            com.alipay.mobile.nebulacore.core.H5PageImpl r2 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r2 = r2.getContext()
            java.lang.String r3 = "fromType"
            if (r2 == 0) goto L_0x01bd
            com.alipay.mobile.nebulacore.core.H5PageImpl r2 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r2 = r2.getContext()
            android.content.Context r2 = r2.getContext()
            boolean r2 = r2 instanceof com.alipay.mobile.nebulacore.ui.H5Activity
            if (r2 == 0) goto L_0x01ba
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            android.os.Bundle r13 = r13.getParams()
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r3)
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x01bd
        L_0x01ba:
            r2 = r13
            r13 = 0
            goto L_0x01bf
        L_0x01bd:
            r2 = r13
            r13 = 1
        L_0x01bf:
            boolean r4 = r10.mEnableAsyncSendEvent
            java.lang.String r5 = "url"
            if (r4 == 0) goto L_0x01de
            if (r13 == 0) goto L_0x01de
            android.os.Handler r13 = r10.mAsyncSendEventHandler
            if (r13 != 0) goto L_0x01d3
            android.os.Handler r13 = new android.os.Handler
            r13.<init>()
            r10.mAsyncSendEventHandler = r13
        L_0x01d3:
            android.os.Handler r13 = r10.mAsyncSendEventHandler
            com.alipay.mobile.nebulacore.web.H5WebViewClient$10 r4 = new com.alipay.mobile.nebulacore.web.H5WebViewClient$10
            r4.<init>(r12)
            r13.post(r4)
            goto L_0x01f4
        L_0x01de:
            com.alibaba.a.e r13 = new com.alibaba.a.e
            r13.<init>()
            r13.put((java.lang.String) r5, (java.lang.Object) r12)
            com.alipay.mobile.nebulacore.core.H5PageImpl r4 = r10.h5Page
            java.lang.String r6 = "h5PageStarted"
            r4.sendEvent(r6, r13)
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            if (r13 == 0) goto L_0x01f4
            r13.resetPageToken()
        L_0x01f4:
            com.alibaba.a.e r13 = new com.alibaba.a.e
            r13.<init>()
            r13.put((java.lang.String) r5, (java.lang.Object) r12)
            com.alipay.mobile.nebulacore.core.H5PageImpl r4 = r10.h5Page
            java.lang.String r6 = "h5PageStartedSync"
            r4.sendEvent(r6, r13)
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r13.clear()
            boolean r13 = r11 instanceof com.alipay.mobile.nebulacore.web.H5WebView
            if (r13 == 0) goto L_0x0214
            r13 = r11
            com.alipay.mobile.nebulacore.web.H5WebView r13 = (com.alipay.mobile.nebulacore.web.H5WebView) r13
            int r13 = r13.getWebViewIndex()
            goto L_0x0215
        L_0x0214:
            r13 = 0
        L_0x0215:
            com.alipay.mobile.h5container.api.H5PageData r4 = r10.pageData
            r4.setWebViewIndex(r13)
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r13.onPageStarted(r12)
            com.alipay.mobile.nebula.provider.H5LogProvider r13 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
            if (r13 == 0) goto L_0x023c
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            long r6 = com.alipay.mobile.h5container.api.H5Flag.lastTouchTime
            com.alipay.mobile.nebula.provider.H5LogProvider r4 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
            java.lang.Long r4 = r4.getTrackLastClickTime()
            long r8 = r4.longValue()
            long r6 = java.lang.Math.max(r6, r8)
            r13.setSrcClick(r6)
        L_0x023c:
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r13 = r13.getContext()
            if (r13 == 0) goto L_0x0287
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            com.alipay.mobile.h5container.api.H5Context r13 = r13.getContext()
            android.content.Context r13 = r13.getContext()
            boolean r13 = r13 instanceof com.alipay.mobile.nebulacore.ui.H5Activity
            if (r13 == 0) goto L_0x027f
            boolean r13 = android.text.TextUtils.isEmpty(r2)
            if (r13 != 0) goto L_0x0267
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r13.setFromType(r2)
            com.alipay.mobile.nebulacore.core.H5PageImpl r13 = r10.h5Page
            android.os.Bundle r13 = r13.getParams()
            r13.remove(r3)
            goto L_0x0287
        L_0x0267:
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r2 = "hrefChange"
            r13.setFromType(r2)
            long r2 = java.lang.System.currentTimeMillis()
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r4 = -1
            r13.setCreate(r2, r4)
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            r4 = 5
            r13.setCreate(r2, r4)
            goto L_0x0287
        L_0x027f:
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r2 = "subView"
            r13.setFromType(r2)
        L_0x0287:
            com.alipay.mobile.nebula.provider.H5LogProvider r13 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
            if (r13 == 0) goto L_0x029a
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            com.alipay.mobile.nebula.provider.H5LogProvider r2 = com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
            java.lang.String r2 = r2.getToken()
            r13.setToken(r2)
        L_0x029a:
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r2 = com.alipay.mobile.h5container.api.H5PageLoader.h5Token
            r13.setH5Token(r2)
            com.alipay.mobile.h5container.api.H5PageData r13 = r10.pageData
            java.lang.String r2 = com.alipay.mobile.h5container.api.H5PageLoader.h5SessionToken
            r13.setH5SessionToken(r2)
            com.alipay.mobile.nebula.webview.APWebBackForwardList r11 = r11.copyBackForwardList()
            if (r11 == 0) goto L_0x02b1
            com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
        L_0x02b1:
            com.alipay.mobile.nebulacore.web.H5WebViewClient$VisitHistoryQueue<java.lang.String> r11 = sVisitHistoryQueue
            int r11 = r11.size()
            if (r11 <= 0) goto L_0x02d1
            java.lang.String r11 = r10.TAG
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r2 = "sVisitHistoryQueue: "
            r13.<init>(r2)
            com.alipay.mobile.nebulacore.web.H5WebViewClient$VisitHistoryQueue<java.lang.String> r2 = sVisitHistoryQueue
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r11, r13)
            com.alipay.mobile.nebulacore.Nebula.getH5LogHandler()
        L_0x02d1:
            com.alipay.mobile.nebulacore.web.H5WebViewClient$VisitHistoryQueue<java.lang.String> r11 = sVisitHistoryQueue
            r11.add(r12)
            java.lang.String r11 = r10.mBugMeViewId
            r13 = 2
            java.lang.String[] r13 = new java.lang.String[r13]
            r13[r1] = r5
            r13[r0] = r12
            java.lang.String r12 = "H5WebViewClient.onPageStarted"
            com.alipay.mobile.nebula.data.H5Trace.event(r12, r11, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5WebViewClient.onPageStarted(com.alipay.mobile.nebula.webview.APWebView, java.lang.String, android.graphics.Bitmap):void");
    }

    static class VisitHistoryQueue<E> extends LinkedList<E> {
        private int mKeepSize = 5;

        VisitHistoryQueue(int i2) {
            this.mKeepSize = i2;
        }

        public boolean add(E e2) {
            boolean add = super.add(e2);
            if (size() > this.mKeepSize) {
                removeFirst();
            }
            return add;
        }
    }

    public void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
        if (!TextUtils.equals(str, H5Param.ABOUT_BLANK)) {
            this.webDriverHelper.doUpdateVisitedHistory(aPWebView, str, z);
        }
        String str2 = this.TAG;
        H5Log.d(str2, "doUpdateVisitedHistory " + str + " isReload " + z);
        this.mPageUpdated = true;
        this.shareUrl = str;
    }

    private String getPageTitle(APWebView aPWebView, String str) {
        String title = aPWebView.getTitle();
        if (str == null || title == null) {
            return title;
        }
        if (str.contains(title) || title.contains(".html") || title.contains(".htm")) {
            return null;
        }
        H5Log.d(this.TAG, "!titlePartOfUrl");
        return title;
    }

    public void onPageFinished(APWebView aPWebView, String str, long j) {
        int i2;
        int i3;
        H5Fragment h5Fragment;
        H5AvailablePageData h5AvailablePageData;
        APWebView aPWebView2 = aPWebView;
        String str2 = str;
        long j2 = j;
        String str3 = this.TAG;
        H5Log.d(str3, "onPageFinished " + str2 + " pageSize " + j2);
        if (!TextUtils.equals(str2, H5Param.ABOUT_BLANK)) {
            this.webDriverHelper.onPageFinished(aPWebView2, str2);
        }
        if (this.h5Page != null && aPWebView2 != null) {
            if (!(str2 == null || !str2.equals(this.pageData.getPageUrl()) || (h5AvailablePageData = this.availablePageData) == null)) {
                h5AvailablePageData.reportDidFinishedLoadDate(System.currentTimeMillis());
            }
            if (this.h5Page != null && this.pageData.getAppear() == 0) {
                this.pageData.setAppear(System.currentTimeMillis() - this.pageData.getStart());
                String str4 = this.TAG;
                H5Log.debug(str4, "page appear " + this.pageData.getAppear());
            }
            if (this.h5Page != null && this.pageData.getAppearFromNative() == 0) {
                if (this.isFirstPage) {
                    this.pageData.setAppearFromNative(System.currentTimeMillis() - H5PageData.walletServiceStart);
                    this.isFirstPage = false;
                    H5Monitor.behavior(new H5MonitorModel().start().seedId(H5MonitorModel.SEED_ID_OPEN_APP).appendSubappId(this.pageData.getAppId()).appendPackageVersion(this.pageData.getAppVersion()).appendUrl(getPageUrl()).appendExtParams("local", this.pageData.getIsLocal()));
                    H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_OPEN_APP).appendSubappId(this.pageData.getAppId()).appendPackageVersion(this.pageData.getAppVersion()).appendCostTime(System.currentTimeMillis() - H5PageData.walletServiceStart).appendUrl(getPageUrl()).appendExtParams("local", this.pageData.getIsLocal()));
                    monitorFirstLaunch();
                } else {
                    this.pageData.setAppearFromNative(System.currentTimeMillis() - this.pageData.getStart());
                }
                String str5 = this.TAG;
                H5Log.debug(str5, "page appear native " + this.pageData.getAppearFromNative());
            }
            final e eVar = new e();
            eVar.put("url", (Object) str2);
            eVar.put("title", (Object) getPageTitle(aPWebView, str));
            APWebBackForwardList copyBackForwardList = aPWebView.copyBackForwardList();
            String originalUrl = aPWebView.getOriginalUrl();
            if (copyBackForwardList != null) {
                i2 = copyBackForwardList.getSize();
                i3 = copyBackForwardList.getCurrentIndex();
                boolean equals = TextUtils.equals(originalUrl, str2);
                if (i3 >= 0 && this.lastPageIndex != i3) {
                    this.mPageUpdated = true;
                }
                if (!this.mPageUpdated && this.lastPageIndex == i3 && copyBackForwardList.getCurrentItem().getUrl().equals(str2)) {
                    this.mPageUpdated = true;
                }
                String str6 = this.TAG;
                H5Log.debug(str6, "pageIndex " + i3 + " lastPageIndex " + this.lastPageIndex + " urlAsOriginal " + equals + " pageUpdated " + this.mPageUpdated);
                if (this.mPageUpdated) {
                    this.lastPageIndex = i3;
                }
                this.pageData.setPageIndex(i3);
                eVar.put("pageIndex", (Object) Integer.valueOf(i3));
            } else {
                i3 = 0;
                i2 = 0;
            }
            eVar.put("historySize", (Object) Integer.valueOf(i2));
            H5Log.debug(this.TAG, "historySize ".concat(String.valueOf(i2)));
            eVar.put(H5Param.PAGE_UPDATED, (Object) Boolean.valueOf(this.mPageUpdated));
            H5ContentProviderImpl h5ContentProviderImpl = this.mH5ContentProvider;
            if (h5ContentProviderImpl != null) {
                this.pageData.setIsLocal(h5ContentProviderImpl.getLocal());
            }
            if (this.pageData.getComplete() == 0) {
                this.pageData.setComplete(System.currentTimeMillis() - this.pageData.getStart());
            }
            if (Nebula.DEBUG) {
                TestDataUtils.storeJSParams("pageLoad|pageComplete", Long.valueOf(this.pageData.getComplete()));
                TestDataUtils.storeJSParams("pageLoad|url", str2);
                H5EnvProvider h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName());
                String productVersion = h5EnvProvider != null ? h5EnvProvider.getProductVersion() : "";
                e eVar2 = new e();
                eVar2.put("alipayVersion", (Object) productVersion);
                eVar2.put(CLPConstants.BRAND_PARAMS, (Object) Build.BRAND);
                eVar2.put("fingerprint", (Object) Build.FINGERPRINT);
                eVar2.put("manufacturer", (Object) Build.MANUFACTURER);
                eVar2.put("model", (Object) Build.MODEL);
                eVar2.put(ContactsConstant.NETWORK, (Object) H5NetworkUtil.getInstance().getNetworkString());
                eVar2.put("sdkInt", (Object) Integer.valueOf(Build.VERSION.SDK_INT));
                TestDataUtils.storeJSParams(ContactColumn.PHONE_NUMBER, eVar2);
                if (!(aPWebView2 instanceof AndroidWebView)) {
                    TestDataUtils.injectJSParams(aPWebView);
                }
            }
            if (this.pageData.getPageSize() == 0) {
                this.pageData.setPageSize(j2);
            }
            this.pageData.setHtmlLoadSize(j2);
            String str7 = this.TAG;
            H5Log.debug(str7, "onPageFinished " + str2 + " originalUrl " + originalUrl + " pageSize " + j2 + " pageIndex " + i3);
            String str8 = this.TAG;
            H5Log.debug(str8, "start=" + this.pageData.getStart() + "^appear=" + this.pageData.getAppear() + "^complete=" + this.pageData.getComplete() + "^pageSize=" + this.pageData.getPageSize() + "complete=" + this.pageData.getComplete() + "^create=" + this.pageData.getCreate() + "^appear=" + this.pageData.getAppear() + "^firstByte=" + this.pageData.getFirstByte() + "^jsSize=" + this.pageData.getJsSize() + "^cssSize=" + this.pageData.getCssSize() + "^imgSize=" + this.pageData.getImgSize() + "^htmlSize=" + this.pageData.getHtmlSize() + "^otherSize=" + this.pageData.getOtherSize() + "^requestNum=" + this.pageData.getRequestNum() + "^num404=" + this.pageData.getNum404() + "^num400=" + this.pageData.getNum400() + "^num500=" + this.pageData.getNum500() + "^num1000=" + this.pageData.getNum1000() + "^sizeLimit60=" + this.pageData.getSizeLimit60());
            H5Trace.event("H5WebViewClient.onPageFinished", this.mBugMeViewId, "url", str2);
            H5PageImpl h5PageImpl = this.h5Page;
            if ((h5PageImpl instanceof H5PageImpl) && (h5Fragment = h5PageImpl.getH5Fragment()) != null) {
                h5Fragment.onPageFinish();
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public boolean queueIdle() {
                    H5Log.d(H5WebViewClient.this.TAG, "h5netsupervisor exec onPageFinished");
                    H5NetworkSuScheduler.getInstance().exec();
                    return false;
                }
            });
            if (this.mEnableAsyncSendEvent) {
                if (this.mAsyncSendEventHandler == null) {
                    this.mAsyncSendEventHandler = new Handler();
                }
                this.mAsyncSendEventHandler.post(new Runnable() {
                    public void run() {
                        if (H5WebViewClient.this.h5Page != null) {
                            H5WebViewClient.this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_FINISHED, eVar);
                        }
                    }
                });
            } else {
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_FINISHED, eVar);
            }
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_FINISHED_SYNC, eVar);
            this.pageFinishedTime = System.currentTimeMillis();
            if (this.pageStartTime > 0) {
                H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_PAGE_LOAD).appendPackageVersion(this.pageData.getAppVersion()).appendSubappId(this.pageData.getAppId()).appendUrl(str2).appendCostTime(this.pageFinishedTime - this.pageStartTime));
            }
            this.pageStartTime = 0;
        }
    }

    /* access modifiers changed from: private */
    public void monitorFirstLaunch() {
        if (H5PageData.launchAppFlag) {
            H5PageData.launchAppFlag = false;
            if (H5PageData.firstLaunchFlag) {
                H5PageData.firstLaunchFlag = false;
                monitorLaunch(H5MonitorModel.SEED_ID_FIRST_LAUNCH);
                return;
            }
            monitorLaunch(H5MonitorModel.SEED_ID_APP_LAUNCH);
        }
    }

    private void monitorLaunch(String str) {
        H5MonitorModel appendCostTime = new H5MonitorModel().success().seedId(str).appendSubappId(this.pageData.getAppId()).appendPackageVersion(this.pageData.getAppVersion()).appendUrl(getPageUrl()).appendCostTime(System.currentTimeMillis() - H5PageData.iconClickTime);
        StringBuilder sb = new StringBuilder();
        sb.append(H5PageData.webViewCreateStart - H5PageData.iconClickTime);
        H5MonitorModel appendExtParams = appendCostTime.appendExtParams("prepareCost", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(H5PageData.webViewCreateEnd - H5PageData.webViewCreateStart);
        H5MonitorModel appendExtParams2 = appendExtParams.appendExtParams("webViewCreateCost", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(H5PageData.loadUrlStart - H5PageData.webViewCreateEnd);
        H5MonitorModel appendExtParams3 = appendExtParams2.appendExtParams("loadEventCost", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(System.currentTimeMillis() - H5PageData.loadUrlStart);
        H5Monitor.behavior(appendExtParams3.appendExtParams("pageLoadCost", sb4.toString()));
    }

    public void onRelease() {
        if (this.hasOnPageStarted && !this.hasShouldInterceptRequest) {
            H5Log.d(this.TAG, "hasOnPageStarted but no hasShouldInterceptRequest! Dump Thread Infos!");
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    List<String> allThreadsTraces = H5PerformanceUtils.getAllThreadsTraces();
                    if (allThreadsTraces != null) {
                        String str = H5WebViewClient.this.TAG;
                        H5Log.d(str, "All Threads Traces: ###" + allThreadsTraces.size());
                        for (String d2 : allThreadsTraces) {
                            H5Log.d(H5WebViewClient.this.TAG, d2);
                        }
                    }
                }
            });
        }
        this.h5Page = null;
        H5Log.d(this.TAG, "h5netsupervisor exec onRelease");
        H5NetworkSuScheduler.getInstance().exec();
    }

    class ResourceInfo {
        /* access modifiers changed from: private */
        public boolean mIsMainDoc;
        /* access modifiers changed from: private */
        public String mMethod = H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD;
        /* access modifiers changed from: private */
        public String mMimeType;
        /* access modifiers changed from: private */
        public long mStart;
        /* access modifiers changed from: private */
        public int mStatusCode;
        /* access modifiers changed from: private */
        public String mUrl;

        ResourceInfo(long j, String str) {
            this.mMethod = str;
            this.mStart = j;
        }
    }
}
