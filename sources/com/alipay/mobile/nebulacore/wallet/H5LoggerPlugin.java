package com.alipay.mobile.nebulacore.wallet;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.model.H5Refer;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LastKnowLocationProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebula.webview.WebViewType;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.log.H5PerformanceLog;
import com.alipay.mobile.nebulacore.log.H5PerformanceScheduler;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upi.util.UpiConstants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class H5LoggerPlugin extends H5SimplePlugin {
    private static final String BIZ_REPORT = "mtBizReport";
    public static final String DSL_ERROR_LOG = "dslErrorLog";
    public static final String KEEP_ALIVE_PAGE_PERFORMANCE = "keepAlivePagePerformance";
    private static final String REMOTE_LOG = "remoteLog";
    private static final String REMOTE_LOGGING = "remoteLogging";
    private static final int REMOTE_LOG_LIMIT = 1000;
    public static final String REPORT_DATA = "reportData";
    private static final String TAG = "H5LoggerPlugin";
    private static final StringBuilder builder = new StringBuilder();
    public static String jsApiNumStr = "";
    private static final String pageMonitor = "pageMonitor";
    private static int remoteLogCount = 0;
    private String abTestInfo;
    private long acsId;
    private H5AvailablePageData availablePageData;
    private String bizContext;
    private String bizScenario;
    private int blankErrorCode;
    private String bugmeViewId;
    private String chInfo;
    private String entityId;
    private String errorType;
    /* access modifiers changed from: private */
    public H5Page h5Page;
    private H5LogProvider h5TrackIntegrator;
    private AtomicBoolean isMixedContent = new AtomicBoolean(false);
    private boolean isOfflineApp = false;
    private boolean isSPM = true;
    private String jsError = "";
    private int jsErrorNum = 0;
    private boolean logH5Performance = true;
    private HashMap<String, String> mExtraJSReport;
    private HashMap<String, Object> mPerformanceMap;
    private b pageAbnormal;
    private H5PageData pageData;
    private String pageId;
    private boolean reportAbnormal;
    private boolean reportPerformance;
    private String spmBizType;
    private Map<String, String> spmDetail = new ConcurrentHashMap();
    private String spmId;
    private String spmUrl;
    private String webViewInfo;

    public void onInitialize(H5CoreNode h5CoreNode) {
        this.h5Page = (H5Page) h5CoreNode;
        Bundle params = this.h5Page.getParams();
        this.webViewInfo = this.h5Page.getVersion();
        this.bizContext = H5Utils.getString(params, H5Param.LONG_SAFEPAY_CONTEXT);
        this.bizScenario = H5Utils.getString(params, H5Param.LONG_BIZ_SCENARIO);
        this.pageData = this.h5Page.getPageData();
        this.availablePageData = this.h5Page.getAvailablePageData();
        this.reportAbnormal = false;
        this.bugmeViewId = H5BugmeIdGenerator.getBugmeViewId(this.h5Page);
        H5Logger.bizScenario = this.bizScenario;
        this.mExtraJSReport = new HashMap<>();
        this.mPerformanceMap = new HashMap<>();
        H5Page h5Page2 = this.h5Page;
        if (!(h5Page2 == null || h5Page2.getWebView() == null || this.pageData == null)) {
            if (this.h5Page.getWebView().getType() == WebViewType.SYSTEM_BUILD_IN) {
                this.pageData.setWebViewType("AndroidWebView");
            } else if (this.h5Page.getWebView().getType() == WebViewType.THIRD_PARTY) {
                this.pageData.setWebViewType("UCWebView");
            } else if (this.h5Page.getWebView().getType() == WebViewType.RN_VIEW) {
                this.pageData.setWebViewType("RNView");
            }
        }
        this.h5TrackIntegrator = Nebula.getH5LogHandler();
    }

    public void onRelease() {
        this.h5Page = null;
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        boolean z;
        b jSONArray;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        H5Logger.isH5Activity = h5Event.getActivity() instanceof H5Activity;
        String action = h5Event.getAction();
        final e param = h5Event.getParam();
        if (h5Event.getTarget() instanceof H5Page) {
            this.h5Page = (H5Page) h5Event.getTarget();
        }
        this.pageData = this.h5Page.getPageData();
        this.availablePageData = this.h5Page.getAvailablePageData();
        this.isOfflineApp = param != null && !TextUtils.isEmpty(H5Utils.getString(param, H5Param.OFFLINE_HOST));
        H5Logger.isOfflineApp = this.isOfflineApp;
        if (H5Plugin.InternalEvents.H5_TOOLBAR_BACK.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TOOLBAR_BACK_BT, "H5_TOOLBAR_BACK_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_PAGE_RESUME.equals(action)) {
            H5Log.d(TAG, "H5_PAGE_RESUME logPageResumeWithSpmId " + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + this.pageData.getPageToken());
            this.pageData.setPageToken(UUID.randomUUID().toString());
            startSpm();
            this.spmDetail.put("logStartFrom", "resume");
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_CLOSE.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TOOLBAR_CLOSE_BT, "H5_TOOLBAR_CLOSE_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_MENU.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TOOLBAR_MEMU, "H5_TOOLBAR_MEMU", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT.equals(action)) {
            String string = H5Utils.getString(param, "name");
            H5Logger.performanceLogger(H5Logger.H5_TOOLBAR_MEMU_BT, "H5_TOOLBAR_MEMU_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), string + "/" + this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_RELOAD.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TOOLBAR_REFRESH_BT, "H5_TOOLBAR_REFRESH_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_TITLEBAR_OPTIONS.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TITLEBAR_RIGHT_BT, "H5_TITLEBAR_RIGHT_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_TITLEBAR_SUBTITLE_CLICK.equals(action)) {
            H5Logger.performanceLogger(H5Logger.H5_TITLEBAR_SUBTITLE_BT, "H5_TITLEBAR_SUBTITLE_BT", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(action)) {
            String string2 = H5Utils.getString(param, "url");
            H5Log.d("h5PageStarted started");
            this.logH5Performance = true;
            if (H5Param.ABOUT_BLANK.equals(string2)) {
                return true;
            }
            if (TextUtils.isEmpty(string2) && (h5Event.getActivity() instanceof H5Activity) && H5Logger.enableStockTradeLog() && Nebula.getH5LogHandler() != null) {
                Nebula.getH5LogHandler().putContextParam("viewID", string2);
            }
            if (enableEndSpmClearSpmDetail()) {
                clearSpmDetail();
            }
            if (this.reportPerformance) {
                this.reportPerformance = false;
                logPagePerformance();
            }
            this.pageData.onPageEnded((String) null);
            logPageAbnormal();
            this.pageAbnormal = null;
            this.acsId = this.h5Page.getSession() == null ? 0 : this.h5Page.getSession().getSessionTag();
            H5Log.d(TAG, "sessionId=" + h5Event.getH5page().getSession().getId() + " acsId=" + this.acsId);
        } else if (H5Plugin.InternalEvents.H5_PAGE_ERROR.equals(action)) {
            this.acsId = this.h5Page.getSession() == null ? 0 : this.h5Page.getSession().getSessionTag();
            int i2 = H5Utils.getInt(param, CLConstants.FIELD_ERROR_CODE);
            String string3 = H5Utils.getString(param, "url");
            String string4 = H5Utils.getString(param, "type");
            String string5 = H5Utils.getString(param, "networkType");
            String string6 = H5Utils.getString(param, "deviceInfo");
            if (!H5Param.ABOUT_BLANK.equals(string3) && !TextUtils.isEmpty(string3)) {
                H5Logger.performanceLogger(H5Logger.H5_AL_PAGE_LOAD_FAIL, (String) null, H5Logger.DIAGNOSE, this.pageData.getPageInfo(), "error=".concat(String.valueOf(i2)), "url=" + string3 + "^errorCode=" + i2 + "^type=" + string4 + "^networkType=" + string5 + "^deviceInfo=" + string6, getUniteParam4());
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_CLOSED.equals(action)) {
            this.pageData.onPageEnded("close");
            if (this.logH5Performance) {
                logPagePerformance();
                logWhiteScreen();
                logPageAbnormal();
                this.logH5Performance = false;
            }
        } else if (H5Plugin.CommonEvents.H5_AL_PAY_RESULT.equals(action)) {
            String string7 = H5Utils.getString(param, "type");
            String string8 = H5Utils.getString(param, "url");
            String string9 = H5Utils.getString(param, "bzContext");
            if (TextUtils.isEmpty(string9)) {
                string9 = this.bizContext;
            }
            H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_PAY_RESULT, "UC-H5-03", string7, string8, "orderStr=" + string9 + "^webviewVerson=" + this.webViewInfo + "^" + ("type=JSAPI^parnter=" + H5Utils.getString(param, "partnerId") + "^tradeNo=" + H5Utils.getString(param, "tradeNo") + "^bizType=" + H5Utils.getString(param, H5Param.LONG_BIZ_TYPE) + "^bizSubType=" + H5Utils.getString(param, "bizSubType") + "^bizContext=" + H5Utils.getString(param, "bizContext") + "^shouldDisplayResultPage=" + H5Utils.getString(param, "^shouldDisplayResultPage") + "^resultCode=" + H5Utils.getString(param, "resultCode") + "^callbackUrl=" + H5Utils.getString(param, "callbackUrl") + "^memo=" + H5Utils.getString(param, "memo") + "^result=" + H5Utils.getString(param, "result")), (String) null, getUniteParam4(), "H-MM");
        } else if (H5Plugin.CommonEvents.H5_AL_PAY_START.equals(action)) {
            H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_PAY_START, "UC-H5-04", H5Utils.getString(param, "resultStatus"), H5Utils.getString(param, "resultCode"), H5Utils.getString(param, "callbackUrl") + "/" + this.webViewInfo + "^" + ("type=JSAPI^parnter=" + H5Utils.getString(param, "partnerId") + "^tradeNo=" + H5Utils.getString(param, "tradeNo") + "^bizType=" + H5Utils.getString(param, H5Param.LONG_BIZ_TYPE) + "^bizSubType=" + H5Utils.getString(param, "bizSubType") + "^bizContext=" + H5Utils.getString(param, "bizContext") + "^shouldDisplayResultPage=" + H5Utils.getString(param, "^shouldDisplayResultPage") + "^requestUrl=" + H5Utils.getString(param, "url")), (String) null, getUniteParam4(), "H-MM");
        } else if (H5Plugin.CommonEvents.H5_TAOBAOSSO_TIME.equals(action)) {
            H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_TAOBAOSSO_TIME, H5Utils.getString(param, "consumeTimeMs"), H5Utils.getString(param, "url"), "", this.webViewInfo, (String) null, getUniteParam4());
        } else if (H5Plugin.CommonEvents.H5_TAOBAOSSO_RESULT.equals(action)) {
            H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_TAOBAOSSO_RESULT, H5Utils.getString(param, "usecase"), H5Utils.getString(param, "result"), H5Utils.getString(param, "finalUrl"), this.webViewInfo, (String) null, getUniteParam4());
            return true;
        } else if (H5Plugin.CommonEvents.H5_SHARE_RESULT.equals(action)) {
            String string10 = H5Utils.getString(param, "channelName");
            boolean z2 = H5Utils.getBoolean(param, "shareResult", false);
            H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_SHARE_RESULT, (String) null, H5Logger.MONITOR, (String) null, "channelName=" + string10 + "^shareResult=" + (z2 ? 1 : 0) + "^bizType=" + H5Utils.getString(param, H5Param.LONG_BIZ_TYPE, "20000067"), "url=" + this.h5Page.getShareUrl(), getUniteParam4(), "H-MM");
            return true;
        } else if (H5Plugin.CommonEvents.H5_FAVORITES_RESULT.equals(action)) {
            String string11 = H5Utils.getString(param, "ucId");
            String string12 = H5Utils.getString(param, "url");
            String string13 = H5Utils.getString(param, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            String string14 = H5Utils.getString(param, H5Param.LONG_BIZ_SCENARIO);
            H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_FAVORITES_RESULT, string11, string12, string13, "appId=" + this.pageData.getAppId(), string14, getUniteParam4());
            return true;
        } else if (H5Plugin.CommonEvents.H5_LONG_CLICK.equals(action)) {
            String string15 = H5Utils.getString(param, "itemName");
            H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_LONG_CLICK, "UC-H5-29", this.h5Page.getUrl(), this.pageData.getPublicId(), string15 + "/" + this.webViewInfo, (String) null, getUniteParam4());
            return true;
        } else if (H5Plugin.CommonEvents.H5_OPEN_IN_BROWSER.equals(action)) {
            H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_OPEN_IN_BROWSER, "UC-H5-28", this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
            return true;
        } else if (H5Plugin.CommonEvents.SET_CLIPBOARD.equals(action)) {
            H5Logger.performanceLogger(H5Plugin.CommonEvents.SET_CLIPBOARD, (String) null, this.h5Page.getUrl(), this.pageData.getPublicId(), this.webViewInfo, (String) null, getUniteParam4());
            return true;
        } else if (H5Plugin.CommonEvents.H5_AL_SESSION_FROM_NATIVE.equals(action)) {
            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                public void run() {
                    if (H5LoggerPlugin.this.h5Page != null) {
                        try {
                            StringBuilder sb = new StringBuilder();
                            String string = H5Utils.getString(H5LoggerPlugin.this.h5Page.getParams(), "url");
                            sb.setLength(0);
                            sb.append("^url=");
                            sb.append(string);
                            sb.append("^originUrl=");
                            sb.append(string.replace(H5Utils.getString(H5LoggerPlugin.this.h5Page.getParams(), H5Param.ONLINE_HOST), "/"));
                            String string2 = H5Utils.getString(H5LoggerPlugin.this.h5Page.getParams(), "appId");
                            String string3 = H5Utils.getString(H5LoggerPlugin.this.h5Page.getParams(), "appVersion");
                            if (H5LoggerPlugin.this.h5Page != null) {
                                String string4 = H5Utils.getString(H5LoggerPlugin.this.h5Page.getParams(), H5AppUtil.package_nick);
                                if (!TextUtils.isEmpty(string3)) {
                                    sb.append("^localmaxnbv=");
                                    sb.append(string3);
                                }
                                String str = "currentTimestamp=" + System.currentTimeMillis() + "^package_nick=" + string4 + "^install=" + H5LoggerPlugin.this.getInstallStatus(string2, string3);
                                if (param != null && param.containsKey("fromKeepAlive")) {
                                    str = str + "^fromKeepAlive=1";
                                }
                                String str2 = str;
                                H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_SESSION_FROM_NATIVE, (String) null, string, "package_nick=" + string4 + "^install=", str2, sb.toString(), H5LoggerPlugin.this.getUniteParam4(), "HD-VM");
                            }
                        } catch (Throwable th) {
                            H5Log.e(H5LoggerPlugin.TAG, th);
                        }
                    }
                }
            });
            return true;
        } else {
            String str7 = "";
            if (H5Plugin.CommonEvents.H5_AL_SESSION_TO_NATIVE.equals(action)) {
                String url = this.h5Page.getUrl();
                if (Nebula.getH5LogHandler() != null) {
                    str7 = Nebula.getH5LogHandler().getContextParam("viewID");
                }
                builder.setLength(0);
                StringBuilder sb = builder;
                sb.append("^url=");
                sb.append(url);
                H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_SESSION_TO_NATIVE, (String) null, str7, (String) null, (String) null, builder.toString(), getUniteParam4(), "HD-VM");
                return true;
            } else if (H5Plugin.CommonEvents.H5_AL_SESSION_ENTRY_ERROR.equals(action)) {
                H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_AL_SESSION_ENTRY_ERROR, (String) null, H5Logger.DIAGNOSE, this.pageData.getPageInfo(), "h5_url_isnull", (String) null, getUniteParam4());
                return true;
            } else if (H5Plugin.CommonEvents.H5_AL_SESSION_ENTRYRPC_ERROR.equals(action)) {
                H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_SESSION_ENTRYRPC_ERROR, (String) null, H5Logger.DIAGNOSE, this.pageData.getPageInfo(), "errorType=BizError^errorCode=" + H5Utils.getString(param, CLConstants.FIELD_ERROR_CODE), (String) null, getUniteParam4(), "H-MM");
                return true;
            } else if (H5Plugin.CommonEvents.H5_AL_SESSION_AUTOLOGIN.equals(action)) {
                H5Logger.performanceLoggerV2(H5Plugin.CommonEvents.H5_AL_SESSION_AUTOLOGIN, (String) null, H5Logger.MONITOR, this.pageData.getPageInfo(), "result=" + H5Utils.getString(param, "result") + "^url=" + H5Utils.getString(param, "url"), (String) null, getUniteParam4(), "H-MM");
                return true;
            } else if (H5Plugin.CommonEvents.H5_AL_PAY_BEFORE_INTERCEPT.equals(action)) {
                H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_AL_PAY_BEFORE_INTERCEPT, (String) null, H5Logger.MONITOR, this.pageData.getPageInfo(), "requestUrl=" + H5Utils.getString(param, "requestUrl"), (String) null, getUniteParam4());
                return true;
            } else if (H5Logger.H5_GETLOCATION_RESULT.equals(action)) {
                if ("error".equals(H5Utils.getString(param, "result"))) {
                    str6 = "errorMessage=" + H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE) + "^errorCode=" + H5Utils.getString(param, CLConstants.FIELD_ERROR_CODE) + "^errorType=" + H5Utils.getString(param, "errorType");
                } else {
                    str6 = str7;
                }
                String str8 = H5Logger.H5_GETLOCATION_RESULT;
                String str9 = "result=" + H5Utils.getString(param, "result");
                String str10 = "locateDuration=" + H5Utils.getInt(param, "locateDuration") + "^currentTimestamp=" + System.currentTimeMillis();
                String str11 = "reGeocodeDuration=" + H5Utils.getInt(param, "reGeocodeDuration");
                String str12 = "locateStart=" + H5Utils.getString(param, "locateStart") + "^locateEnd=" + H5Utils.getString(param, "locateEnd") + "^reGeocodeStart=" + H5Utils.getString(param, "reGeocodeStart") + "^reGeocodeEnd=" + H5Utils.getString(param, "reGeocodeEnd");
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(str6)) {
                    str7 = "^";
                }
                sb2.append(str7);
                sb2.append(getUniteParam4());
                H5Logger.performanceLoggerV2(str8, (String) null, str9, str10, str11, str12, sb2.toString(), "H-MM");
                return true;
            } else if ("pushWindow".equals(action)) {
                String string16 = H5Utils.getString(param, "url");
                if (TextUtils.isEmpty(string16)) {
                    string16 = H5Utils.getString(param, "u");
                }
                builder.setLength(0);
                StringBuilder sb3 = builder;
                sb3.append("^url=");
                sb3.append(string16);
                sb3.append("^viewId=");
                sb3.append(string16);
                sb3.append("^referer=");
                sb3.append(this.pageData.getReferUrl());
                H5Log.d(TAG, "PUSH_WINDOW LOG:" + builder.toString());
                H5Logger.performanceLoggerV2("H5_PAGE_BEHAVIOR_AUTOCLICK", (String) null, (String) null, "opentype=pushWindow", (String) null, builder.toString(), getUniteParam4(), "HD-VM");
            } else if (REMOTE_LOG.equals(action)) {
                final H5Event h5Event2 = h5Event;
                H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                    public void run() {
                        try {
                            H5LoggerPlugin.this.remoteLog(h5Event2);
                        } catch (Exception e2) {
                            H5Log.e(H5LoggerPlugin.TAG, (Throwable) e2);
                        }
                    }
                });
                if (h5BridgeContext == null) {
                    return true;
                }
                h5BridgeContext.sendSuccess();
                return true;
            } else {
                H5Event h5Event3 = h5Event;
                if (REMOTE_LOGGING.equals(action)) {
                    remoteLogging(h5Event, h5BridgeContext);
                    return true;
                } else if (H5Plugin.CommonEvents.H5_AL_NETWORK_PERFORMANCE_ERROR.equals(action)) {
                    String string17 = H5Utils.getString(param, "targetUrl");
                    String str13 = H5Utils.getInt(this.h5Page.getParams(), H5Param.APP_TYPE, 2) == 2 ? P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT : "local";
                    int i3 = H5Utils.getInt(param, "status");
                    String string18 = H5Utils.getString(param, "type");
                    String string19 = H5Utils.getString(param, "method");
                    long j = H5Utils.getLong(param, "start");
                    String str14 = TAG;
                    long j2 = H5Utils.getLong(param, AppConstants.DURATION);
                    String str15 = "^errorCode=";
                    long j3 = H5Utils.getLong(param, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE);
                    int i4 = i3;
                    String string20 = H5Utils.getString(param, "isMainDoc");
                    int statusCode = H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(string20) ? this.pageData.getStatusCode() : i4;
                    String str16 = str14;
                    String str17 = string20;
                    String str18 = "appId=" + this.pageData.getAppId() + "^version=" + this.pageData.getAppVersion() + "^publicId=" + this.pageData.getPublicId() + "^url=" + this.h5Page.getUrl();
                    StringBuilder sb4 = new StringBuilder("targetUrl=");
                    sb4.append(string17);
                    sb4.append("^method=");
                    sb4.append(string19);
                    sb4.append("^psd=");
                    sb4.append(str13);
                    sb4.append("^status=");
                    sb4.append(statusCode);
                    sb4.append("^type=");
                    sb4.append(string18);
                    sb4.append("^size=");
                    sb4.append(j3);
                    sb4.append("^start=");
                    sb4.append(j);
                    sb4.append("^duration=");
                    sb4.append(j2);
                    sb4.append("errorType=");
                    sb4.append(this.errorType);
                    String str19 = str15;
                    sb4.append(str19);
                    sb4.append(statusCode);
                    sb4.append("^isMainDoc=");
                    String str20 = str17;
                    sb4.append(str20);
                    String sb5 = sb4.toString();
                    String str21 = !TextUtils.isEmpty(this.errorType) ? this.errorType : statusCode >= 400 ? "errorResponse" : "errorRequest";
                    if (TextUtils.isEmpty(str21) && j2 > 60000) {
                        str21 = "longRender";
                    }
                    String str22 = "errorType=" + str21 + str19 + statusCode + "^isMainDoc=" + str20;
                    if (Nebula.DEBUG) {
                        H5Log.d(str16, "H5_AL_NETWORK_PERFORMANCE_ERROR ".concat(String.valueOf(str22)));
                    }
                    H5Logger.performanceLoggerV2("H5_AL_NETWORK_PERFORMANCE_ERROR", (String) null, "performance", str18, sb5, str22, getUniteParam4(), "H-EM");
                    if (Nebula.getH5LogHandler() == null) {
                        return true;
                    }
                    Nebula.getH5LogHandler().upload();
                    return true;
                } else {
                    String str23 = TAG;
                    if (H5Plugin.InternalEvents.H5_PAGE_ABNORMAL.equals(action)) {
                        if (this.reportAbnormal) {
                            return true;
                        }
                        this.reportAbnormal = true;
                        this.errorType = H5Utils.getString(param, "errorType");
                        this.blankErrorCode = H5Utils.getInt(param, CLConstants.FIELD_ERROR_CODE);
                        return true;
                    } else if (H5Param.REPORT_ABNORMAL.equals(action)) {
                        if (param != null) {
                            this.pageAbnormal = param.getJSONArray("data");
                            this.reportAbnormal = true;
                        }
                        return true;
                    } else if (H5Param.MONITOR_PERFORMANCE.equals(action)) {
                        H5Log.d("H5LoggerPlugins", "MONITOR_PERFORMANCE : praram = ".concat(String.valueOf(param)));
                        if (!(param == null || (jSONArray = param.getJSONArray("data")) == null || jSONArray.size() <= 0)) {
                            for (int i5 = 0; i5 < jSONArray.size(); i5++) {
                                e jSONObject = jSONArray.getJSONObject(i5);
                                String string21 = H5Utils.getString(jSONObject, "name");
                                if ("mixedContent".equals(string21)) {
                                    this.reportAbnormal = true;
                                    this.isMixedContent.set(true);
                                }
                                H5Trace.event(string21, this.bugmeViewId, new String[0]);
                                this.mPerformanceMap.put(string21, jSONObject.get("value"));
                                try {
                                    if (TextUtils.equals(string21, "jsErrors")) {
                                        if (jSONObject.get("filename") == null || (str = jSONObject.getString("filename")) == null) {
                                            str = str7;
                                        }
                                        if (jSONObject.get("value") == null || (str2 = jSONObject.getString("value")) == null) {
                                            str2 = str7;
                                        }
                                        if (jSONObject.get("lineno") == null || (str3 = jSONObject.getString("lineno")) == null) {
                                            str3 = str7;
                                        }
                                        if (jSONObject.get("colno") == null || (str4 = jSONObject.getString("colno")) == null) {
                                            str4 = str7;
                                        }
                                        if (jSONObject.get(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR) == null || (str5 = jSONObject.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR)) == null) {
                                            str5 = str7;
                                        }
                                        if (this.jsErrorNum < 10) {
                                            if (TextUtils.isEmpty(this.jsError)) {
                                                this.jsError = "fileName=" + str + "^line=" + str3 + "^desc=" + str2 + "^date=" + str5 + "^colno=" + str4;
                                            } else {
                                                this.jsError += "|fileName=" + str + "^line=" + str3 + "^desc=" + str2 + "^date=" + str5 + "^colno=" + str4;
                                            }
                                            this.jsErrorNum++;
                                        }
                                        H5Log.d(str23, "jsErrors " + str + " " + str2);
                                    } else if (TextUtils.equals(string21, "navigationStart")) {
                                        long longValue = H5Logger.getLongValue(String.valueOf(jSONObject.get("value")));
                                        if (this.pageData != null) {
                                            this.pageData.setNavigationStart(longValue);
                                        }
                                        H5Log.d("current Time " + System.currentTimeMillis());
                                    } else if (TextUtils.equals(string21, "domReady")) {
                                        H5Logger.getLongValue(String.valueOf(jSONObject.get("value")));
                                    } else {
                                        TextUtils.equals(string21, "pageLoad");
                                    }
                                } catch (Exception e2) {
                                    H5Log.e(str23, (Throwable) e2);
                                }
                            }
                            H5Log.d("pageDataMonitor" + this.pageData.toString());
                        }
                        this.reportPerformance = true;
                        return true;
                    } else if (H5Plugin.InternalEvents.H5_PAGE_DOWNLOAD_APK.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb6 = builder;
                        sb6.append("apkurl=");
                        sb6.append(H5Utils.getString(param, "url"));
                        sb6.append("^contentLength=");
                        sb6.append(H5Utils.getLong(param, "contentLength"));
                        sb6.append("^inApkWhiteList=");
                        sb6.append(H5Utils.getBoolean(param, "inApkWhiteList", true));
                        H5Logger.performanceLogger("H5_AL_DOWNLOAD_APK", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                        return true;
                    } else if (H5Plugin.InternalEvents.H5_PAGE_INTERCEPT_SCHEME.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb7 = builder;
                        sb7.append("url=");
                        sb7.append(H5Utils.getString(param, "url"));
                        StringBuilder sb8 = builder;
                        sb8.append("^scheme=");
                        sb8.append(H5Utils.getString(param, "scheme"));
                        StringBuilder sb9 = builder;
                        sb9.append("^type=");
                        sb9.append(H5Utils.getString(param, "type"));
                        H5Logger.performanceLogger("H5_AL_INTERCEPT_SCHEME", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.InternalEvents.H5_PAGE_QUERY_PP.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb10 = builder;
                        sb10.append("queryUrl=");
                        sb10.append(H5Utils.getString(param, "queryUrl"));
                        StringBuilder sb11 = builder;
                        sb11.append("^queryParam=");
                        sb11.append(H5Utils.getString(param, "queryParam"));
                        StringBuilder sb12 = builder;
                        sb12.append("^statusCode=");
                        sb12.append(H5Utils.getString(param, "statusCode"));
                        H5Logger.performanceLogger("H5_AL_QUERY_PP", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.InternalEvents.H5_PAGE_QUERY_PP_COST.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb13 = builder;
                        sb13.append("httpcost=");
                        sb13.append(H5Utils.getLong(param, "httpcost"));
                        H5Logger.performanceLogger("H5_AL_QUERY_PP_COST", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.InternalEvents.H5_PAGE_JUMP_PP.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb14 = builder;
                        sb14.append("detailUrl=");
                        sb14.append(H5Utils.getString(param, "detailUrl"));
                        StringBuilder sb15 = builder;
                        sb15.append("^origin=");
                        sb15.append(H5Utils.getString(param, "origin"));
                        StringBuilder sb16 = builder;
                        sb16.append("^type=");
                        sb16.append(H5Utils.getString(param, "type"));
                        H5Logger.performanceLogger("H5_AL_JUMP_PP", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.InternalEvents.H5_PAGE_JUMP_PP_DOWNLOAD.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb17 = builder;
                        sb17.append("downloadUrl=");
                        sb17.append(H5Utils.getString(param, "downloadUrl"));
                        StringBuilder sb18 = builder;
                        sb18.append("^type=");
                        sb18.append(H5Utils.getString(param, "type"));
                        H5Logger.performanceLogger("H5_AL_JUMP_PP_DOWNLOAD", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.InternalEvents.H5_PAGE_JUMP_PP_DOWNLOAD_SUCCESS.equals(action)) {
                        builder.setLength(0);
                        StringBuilder sb19 = builder;
                        sb19.append("type=");
                        sb19.append(H5Utils.getString(param, "type"));
                        H5Logger.performanceLogger("H5_AL_JUMP_PP_DOWNLOAD_SUCCESS", (String) null, builder.toString(), this.pageData.getPageInfo(), (String) null, (String) null, getUniteParam4());
                    } else if (H5Plugin.CommonEvents.H5_VC_OVERLIMIT.equals(action)) {
                        String string22 = H5Utils.getString(param, "urls");
                        String string23 = H5Utils.getString(param, "usedMemory");
                        String string24 = H5Utils.getString(param, "totalMemory");
                        H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_VC_OVERLIMIT, (String) null, "urls=".concat(String.valueOf(string22)), "usedMemory=" + string23 + "^totalMemory=" + string24, (String) null, (String) null, getUniteParam4());
                    } else if (H5Logger.H5_AL_PAGE_RESUME.equals(action)) {
                        H5Logger.performanceLoggerV2(H5Logger.H5_AL_PAGE_RESUME, (String) null, (String) null, (String) null, (String) null, "url=" + this.h5Page.getUrl(), getUniteParam4(), "HD-VM");
                    } else if (H5Plugin.CommonEvents.H5_DOWNLOAD_APK_RESULT.equals(action)) {
                        String string25 = H5Utils.getString(param, "status");
                        if ("success".equals(string25)) {
                            str7 = "url=" + H5Utils.getString(param, "url") + "&size=" + H5Utils.getString(param, "apkSize");
                        } else if ("failed".equals(string25)) {
                            str7 = "errorMsg=" + H5Utils.getString(param, "errorMsg");
                        }
                        String str24 = str7;
                        H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_DOWNLOAD_APK_RESULT, (String) null, str24, this.h5Page.getUrl(), (String) null, (String) null, getUniteParam4());
                        H5Log.d(str23, str24);
                        return true;
                    } else if (H5Plugin.CommonEvents.H5_FILE_DOWNLOAD.equals(action)) {
                        String string26 = H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_NAME);
                        if (string26.split(AppUtility.CENTER_DOT).length == 2) {
                            str7 = string26.split(AppUtility.CENTER_DOT)[1];
                        }
                        String str25 = "url=" + H5Utils.getString(param, "url") + "&type=" + str7 + "&contentLength=" + H5Utils.getString(param, "contentLength") + "&status=" + H5Utils.getString(param, "status");
                        H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_FILE_DOWNLOAD, (String) null, str25, this.h5Page.getUrl(), (String) null, (String) null, getUniteParam4());
                        H5Log.d(str23, str25);
                        return true;
                    } else if (H5Plugin.CommonEvents.H5_PAGE_JSAPI_LOGIN.equals(action)) {
                        String url2 = this.h5Page.getUrl();
                        builder.setLength(0);
                        if (Nebula.getH5LogHandler() != null) {
                            String contextParam = Nebula.getH5LogHandler().getContextParam("refViewID");
                            String contextParam2 = Nebula.getH5LogHandler().getContextParam("viewID");
                            StringBuilder sb20 = builder;
                            sb20.append("^url=");
                            sb20.append(url2);
                            sb20.append("^viewId=");
                            sb20.append(contextParam2);
                            sb20.append("^refviewId=");
                            sb20.append(contextParam);
                        }
                        boolean z3 = H5Utils.getBoolean(param, "loginResult", false);
                        H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_PAGE_JSAPI_LOGIN, (String) null, "loginResult=".concat(String.valueOf(z3)), this.h5Page.getUrl(), (String) null, builder.toString(), getUniteParam4());
                        H5Log.d(str23, "JSAPI_RESULT:loginResult=" + z3 + " " + this.h5Page.getUrl() + " param4:" + builder.toString());
                        return true;
                    } else if (H5Plugin.CommonEvents.H5_AL_GETSHARECONTENT_RESULT.equals(action)) {
                        String string27 = H5Utils.getString(param, "url");
                        String string28 = H5Utils.getString(param, "content");
                        H5Logger.performanceLogger(H5Plugin.CommonEvents.H5_AL_GETSHARECONTENT_RESULT, (String) null, string27, string28, (String) null, (String) null, getUniteParam4());
                        H5Log.d(str23, "CARDSHARE : url = " + string27 + " , content = " + string28);
                    } else if (H5Plugin.InternalEvents.H5_PAGE_PAUSE.equals(action)) {
                        H5Log.d(str23, "H5_PAGE_PAUSE logPageEndWithSpmId " + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + this.pageData.getPageToken());
                        endSpm();
                        if (this.logH5Performance) {
                            H5Page h5Page2 = this.h5Page;
                            if (h5Page2 == null || h5Page2.getParams() == null) {
                                z = false;
                            } else {
                                z = false;
                                if (H5Utils.getBoolean(this.h5Page.getParams(), H5Param.LONG_ISPRERENDER, false)) {
                                    H5Log.d(str23, "preRender page return");
                                    return false;
                                }
                            }
                            H5Log.d(str23, "H5_PAGE_PAUSE log performance");
                            logPagePerformance();
                            logPageAbnormal();
                            this.logH5Performance = z;
                        }
                        if (H5Logger.isH5Activity && Nebula.getH5LogHandler() != null) {
                            Nebula.getH5LogHandler().upload();
                        }
                    } else if (H5Plugin.InternalEvents.H5_PAGE_BACK.equals(action)) {
                        H5Log.d(str23, "H5_PAGE_BACK logPageEndWithSpmId " + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + this.pageData.getPageToken());
                        endSpm();
                    } else if (KEEP_ALIVE_PAGE_PERFORMANCE.equals(action)) {
                        this.logH5Performance = true;
                        if (this.h5Page == null) {
                            return true;
                        }
                        e eVar = new e();
                        eVar.put("fromKeepAlive", (Object) "1");
                        this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_AL_SESSION_FROM_NATIVE, eVar);
                        return true;
                    } else if (DSL_ERROR_LOG.equals(action)) {
                        H5Log.d(str23, "DSL_ERROR_LOG");
                        this.reportAbnormal = true;
                        this.errorType = "errorRender";
                        this.blankErrorCode = H5ErrorCode.BLANK_SCREEN_DSL_ERROR;
                        logPageAbnormal();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void endSpm() {
        String str;
        String str2;
        if (H5Logger.enableStockTradeLog()) {
            if (!TextUtils.isEmpty(this.spmId) || "no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_filterEmptySpmId"))) {
                if (!TextUtils.isEmpty(this.chInfo)) {
                    this.spmDetail.put("chInfo", this.chInfo);
                }
                if (this.pageData != null) {
                    if (!this.spmDetail.containsKey("url")) {
                        this.spmDetail.put("url", this.pageData.getPageUrl());
                    }
                    if (!this.spmDetail.containsKey("appId")) {
                        this.spmDetail.put("appId", this.pageData.getAppId());
                    }
                    if (!this.spmDetail.containsKey("version")) {
                        this.spmDetail.put("version", this.pageData.getAppVersion());
                    }
                    this.spmDetail.put("h5pageurl", this.pageData.getPageUrl());
                    if (!TextUtils.isEmpty(this.pageData.getReleaseType())) {
                        this.spmDetail.put("log_release_type", this.pageData.getReleaseType());
                    }
                    String str3 = "";
                    if (Nebula.getH5LogHandler() != null) {
                        str2 = Nebula.getH5LogHandler().getContextParam("refViewID");
                        str = Nebula.getH5LogHandler().getContextParam("viewID");
                    } else {
                        str2 = str3;
                        str = str2;
                    }
                    Map<String, String> map = this.spmDetail;
                    if (str2 == null) {
                        str2 = str3;
                    }
                    map.put("refviewId", str2);
                    Map<String, String> map2 = this.spmDetail;
                    if (str != null) {
                        str3 = str;
                    }
                    map2.put("viewId", str3);
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(this.spmDetail);
                    H5LogProvider h5LogProvider = this.h5TrackIntegrator;
                    if (h5LogProvider == null) {
                        return;
                    }
                    if (this.isSPM) {
                        String str4 = this.spmId;
                        String str5 = this.abTestInfo;
                        h5LogProvider.logAutoBehavorPageEnd(str4, str5, this.spmId + "_" + this.pageData.getPageToken(), this.spmBizType, hashMap);
                        return;
                    }
                    String str6 = this.pageId;
                    if (TextUtils.isEmpty(str6)) {
                        str6 = this.pageData.getPageToken();
                    }
                    this.h5TrackIntegrator.logAutoBehavorPageEnd(this.spmUrl, this.abTestInfo, str6, this.spmBizType, hashMap);
                    return;
                }
                return;
            }
            H5Log.d(TAG, "return empty spmId : " + this.spmId);
        }
    }

    private static boolean enableEndSpmClearSpmDetail() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_endSpmClearSpmDetail"));
    }

    private void startSpm() {
        if (H5Logger.enableStockTradeLog()) {
            if (!H5Logger.isH5Activity) {
                H5Log.d(TAG, "is not H5Activity not log");
            }
            if (this.pageData != null) {
                if (Nebula.getH5LogHandler() != null) {
                    Nebula.getH5LogHandler().putContextParam("viewID", this.pageData.getPageUrl());
                }
                H5Log.d(TAG, "isSPM:" + this.isSPM + " h5TrackIntegrator:" + this.h5TrackIntegrator);
                if (this.isSPM) {
                    this.pageData.setSpmId(this.spmId);
                    H5LogProvider h5LogProvider = this.h5TrackIntegrator;
                    if (h5LogProvider != null) {
                        String str = this.spmId;
                        h5LogProvider.logAutoBehavorPageStart(str, this.spmId + "_" + this.pageData.getPageToken());
                    }
                } else if (this.h5TrackIntegrator != null) {
                    H5Log.d(TAG, "logAutoBehavorPageStart !isSPM  spmBizType spmUrl:" + this.spmUrl + " token:" + this.pageData.getPageToken());
                    String str2 = this.pageId;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.pageData.getPageToken();
                    }
                    this.h5TrackIntegrator.logAutoBehavorPageStart(this.spmUrl, str2, false);
                }
                this.spmDetail.put("acsId", String.valueOf(this.acsId));
            }
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!(h5Event == null || h5Event.getParam() == null || h5Event.getAction() == null)) {
            H5Page h5Page2 = h5Event.getTarget() instanceof H5Page ? (H5Page) h5Event.getTarget() : null;
            String action = h5Event.getAction();
            e param = h5Event.getParam();
            if (h5Page2 == null) {
                return false;
            }
            if (REPORT_DATA.equals(action)) {
                e jSONObject = H5Utils.getJSONObject(param, "spm", (e) null);
                if (jSONObject != null && !jSONObject.isEmpty()) {
                    this.spmId = H5Utils.getString(jSONObject, "spmId");
                    this.spmBizType = H5Utils.getString(jSONObject, H5Param.LONG_BIZ_TYPE);
                    this.abTestInfo = H5Utils.getString(jSONObject, "abTestInfo");
                    this.chInfo = H5Utils.getString(jSONObject, "chInfo");
                    this.isSPM = H5Utils.getBoolean(jSONObject, "isSPM", true);
                    this.spmUrl = H5Utils.getString(jSONObject, "url");
                    H5Log.d(TAG, "logPageStartWithSpmId spmId:" + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + this.pageData.getPageToken() + " isSPM:" + this.isSPM + " spmUrl:" + this.spmUrl + " abTestInfo:" + this.abTestInfo);
                    startSpm();
                }
                if (!enableEndSpmClearSpmDetail()) {
                    clearSpmDetail();
                }
                e jSONObject2 = H5Utils.getJSONObject(param, "spmDetail", (e) null);
                if (jSONObject2 != null && !jSONObject2.isEmpty()) {
                    for (String next : jSONObject2.keySet()) {
                        try {
                            if (jSONObject2.get(next) instanceof String) {
                                this.spmDetail.put(next, jSONObject2.get(next).toString());
                            }
                        } catch (Throwable th) {
                            H5Log.e(TAG, th);
                        }
                    }
                }
                h5BridgeContext.sendSuccess();
                return true;
            } else if (BIZ_REPORT.equals(action)) {
                String string = H5Utils.getString(param, "bizName");
                String string2 = H5Utils.getString(param, "subName");
                String string3 = H5Utils.getString(param, "failCode");
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                    h5BridgeContext.sendError(h5Event, H5Event.Error.INVALID_PARAM);
                } else {
                    try {
                        HashMap hashMap = new HashMap();
                        e jSONObject3 = H5Utils.getJSONObject(param, "extParams", (e) null);
                        if (jSONObject3 != null && !jSONObject3.isEmpty()) {
                            for (String next2 : jSONObject3.keySet()) {
                                hashMap.put(next2, jSONObject3.get(next2).toString());
                            }
                        }
                        if (!hashMap.containsKey("appId")) {
                            hashMap.put("appId", H5Utils.getString(h5Page2.getParams(), "appId"));
                        }
                        if (!hashMap.containsKey("version")) {
                            hashMap.put("version", H5Utils.getString(h5Page2.getParams(), "appVersion"));
                        }
                        H5Logger.mtBizReport(string, string2, string3, hashMap);
                        h5BridgeContext.sendSuccess();
                    } catch (Exception e2) {
                        H5Log.e(TAG, (Throwable) e2);
                    }
                }
                return true;
            } else if (pageMonitor.equals(action)) {
                String string4 = H5Utils.getString(h5Event.getParam(), "actionType");
                if (TextUtils.equals(UpiConstants.UPI_RESET_TOKEN, string4)) {
                    H5Log.d(TAG, "pageMonitor jsapi logPageEndWithSpmId " + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + this.pageData.getPageToken());
                    endSpm();
                    startSpm();
                } else if (TextUtils.equals("end", string4)) {
                    H5Log.d(TAG, "pageMonitor jsapi logPageEndWithSpmId end");
                    endSpm();
                }
                h5BridgeContext.sendSuccess();
                return true;
            }
        }
        return false;
    }

    private void clearSpmDetail() {
        try {
            synchronized (this.spmDetail) {
                this.spmDetail.clear();
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    private void logWhiteScreen() {
        H5PageData h5PageData;
        int i2;
        if (this.h5Page != null && (h5PageData = this.pageData) != null && !this.reportAbnormal) {
            String appId = h5PageData.getAppId();
            e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_logNewBlankScreenConfig"));
            if (parseObject != null && !parseObject.isEmpty()) {
                String string = H5Utils.getString(parseObject, "enable");
                String string2 = H5Utils.getString(parseObject, "appId");
                if (H5NetworkUtil.getInstance().getNetworkType() == H5NetworkUtil.Network.NETWORK_WIFI) {
                    i2 = H5Utils.getInt(parseObject, "wifiLimit");
                } else {
                    i2 = H5Utils.getInt(parseObject, "elseNetWork");
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(appId) && H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string) && NebulaUtil.isAppIdMatch(string2, appId)) {
                    if (this.pageData.getComplete() != 0 || (System.currentTimeMillis() - this.pageData.getCreate()) / 1000 <= ((long) i2)) {
                        if ((System.currentTimeMillis() - this.pageData.getCreate()) / 1000 >= ((long) (H5Utils.getInt(parseObject, "testFilter") != 0 ? H5Utils.getInt(parseObject, "testFilter") : 1))) {
                            if (this.h5Page.getWebView() == null || this.h5Page.getWebView().getType() != WebViewType.THIRD_PARTY) {
                                if (this.pageData.getAppear() == 0) {
                                    this.reportAbnormal = true;
                                    this.errorType = "errorRender";
                                    this.blankErrorCode = H5ErrorCode.BLANK_SCREEN_OTHER_ERROR;
                                    H5Log.d(TAG, "log Android WebView blank error");
                                }
                            } else if (this.pageData.getFirstVisuallyRender() == 0) {
                                this.reportAbnormal = true;
                                this.errorType = "errorRender";
                                this.blankErrorCode = H5ErrorCode.BLANK_SCREEN_OTHER_ERROR;
                                H5Log.d(TAG, "log UC WebView blank error");
                            }
                        }
                    } else {
                        this.reportAbnormal = true;
                        this.errorType = "errorRender";
                        this.blankErrorCode = H5ErrorCode.BLANK_SCREEN_UNFINISHED_ERROR;
                        H5Log.d(TAG, "log WebView page unfinished error");
                    }
                }
            }
        }
    }

    private void logPageAbnormal() {
        String str;
        String str2;
        HashMap<String, Object> hashMap;
        if (this.reportAbnormal) {
            H5Log.d(TAG, "logPageAbnormal " + this.pageData.getPageUrl());
            this.reportAbnormal = false;
            String pageUrl = this.pageData.getPageUrl();
            if (!TextUtils.isEmpty(pageUrl) && !H5Param.ABOUT_BLANK.equals(pageUrl)) {
                String str3 = null;
                if (!TextUtils.isEmpty(this.errorType)) {
                    str3 = this.errorType;
                } else if (this.pageData.getStatusCode() >= 400 || this.pageData.getErrorCode() >= 400) {
                    str3 = "errorResponse";
                } else if (this.pageData.getStatusCode() <= 13 || this.pageData.getErrorCode() != 7000 || (this.pageData.getErrorCode() >= 0 && this.pageData.getErrorCode() <= 6)) {
                    str3 = "errorRequest";
                }
                if (this.blankErrorCode != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.blankErrorCode);
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.pageData.getStatusCode());
                    str = sb2.toString();
                }
                String str4 = "auto";
                HashMap hashMap2 = new HashMap();
                b bVar = this.pageAbnormal;
                if (bVar != null && !bVar.isEmpty()) {
                    for (int i2 = 0; i2 < this.pageAbnormal.size(); i2++) {
                        e jSONObject = this.pageAbnormal.getJSONObject(i2);
                        String string = H5Utils.getString(jSONObject, "name");
                        String string2 = H5Utils.getString(jSONObject, "value");
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(string, string2);
                        }
                    }
                    if (hashMap2.containsKey("errorType")) {
                        str3 = (String) hashMap2.remove("errorType");
                    }
                    if (hashMap2.containsKey("errorTrigger")) {
                        str4 = (String) hashMap2.remove("errorTrigger");
                    }
                    if (hashMap2.containsKey(CLConstants.FIELD_ERROR_CODE)) {
                        str = (String) hashMap2.remove(CLConstants.FIELD_ERROR_CODE);
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "jsReport";
                    }
                }
                if (this.isMixedContent.compareAndSet(true, false)) {
                    str3 = "mixedContent";
                }
                String str5 = "url=" + pageUrl + "^referer=" + this.pageData.getReferUrl() + "^errorType=" + str3 + "^errorCode=" + str + "^errorTrigger=" + str4 + "^startRender=" + this.pageData.getAppear() + "^startRenderFromNative=" + this.pageData.getAppearFromNative() + "^pageSize=" + this.pageData.getPageSize() + "^htmlSize=" + this.pageData.getHtmlSize() + "^status=" + this.pageData.getStatusCode();
                if (!TextUtils.isEmpty(this.pageData.getMultimediaID())) {
                    str5 = str5 + "^snapshotId=" + this.pageData.getMultimediaID();
                }
                String str6 = str5;
                String str7 = "";
                String str8 = str7;
                for (String str9 : hashMap2.keySet()) {
                    if (!TextUtils.isEmpty(str8)) {
                        str8 = str8 + "^";
                    }
                    str8 = str8 + str9 + "=" + ((String) hashMap2.get(str9));
                }
                String title = this.pageData.getTitle();
                String str10 = H5Utils.getInt(this.h5Page.getParams(), H5Param.APP_TYPE, 2) == 2 ? P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT : "local";
                H5AvailablePageData h5AvailablePageData = this.availablePageData;
                if (h5AvailablePageData != null) {
                    String str11 = str8;
                    String str12 = title;
                    String str13 = "appId=" + this.pageData.getAppId() + "^version=" + this.pageData.getAppVersion() + "^publicId=" + this.pageData.getPublicId() + "^psd=" + str10 + H5Logger.getPerformanceData(this.pageData) + "^stopLoading=" + H5Logger.getCorrectStopLoading(h5AvailablePageData.getStopLoadingTime(), this.pageData, this.availablePageData) + "^stopLoadingWithoutLocating=" + H5Logger.getCorrectStopLoading(this.availablePageData.getStopLoadingTimeWithLoc(), this.pageData, this.availablePageData);
                    H5PageData h5PageData = this.pageData;
                    if (h5PageData != null && H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(h5PageData.getIsTinyApp())) {
                        str13 = str13 + "^dslVersion=" + H5Logger.getDslVersion(this.pageData);
                    }
                    if ("mixedContent".equals(str3) && (hashMap = this.mPerformanceMap) != null && hashMap.containsKey("mixedContent")) {
                        str13 = str13 + "^mixedContent=" + this.mPerformanceMap.get("mixedContent");
                    }
                    if (this.pageData.getNavigationStart() > 0) {
                        str13 = str13 + "^navigationStart=" + this.pageData.getNavigationStart();
                    }
                    if (Nebula.getH5LogHandler() != null) {
                        str7 = Nebula.getH5LogHandler().getContextParam("refViewID");
                        str2 = Nebula.getH5LogHandler().getContextParam("viewID");
                    } else {
                        str2 = str7;
                    }
                    String mimeType = H5FileUtil.getMimeType(this.h5Page.getUrl());
                    e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_ucNetConfig"));
                    String string3 = parseObject != null ? parseObject.getString("useAlipayNet") : H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
                    String isSpdy = isSpdy(this.pageData.getPageUrl());
                    H5Log.d(TAG, "useAlipayNet " + string3 + ", spdySwitch " + isSpdy);
                    String str14 = str13 + "^type=" + mimeType + "^charset=" + Charset.defaultCharset() + "^viewId=" + str2 + "^refviewId=" + str7 + "^isAlipayNetwork=" + string3 + "^SPDY=" + isSpdy + "^end=" + System.currentTimeMillis() + "^isLocal=" + this.pageData.getIsLocal() + jsApiNumStr;
                    H5Log.d(TAG, "H5_PAGE_ABNORMAL".concat(String.valueOf(str14)));
                    if (this.mExtraJSReport.size() != 0) {
                        for (String next : this.mExtraJSReport.keySet()) {
                            str14 = str14 + "^" + next + "=" + this.mExtraJSReport.get(next);
                        }
                    }
                    H5Logger.performanceLoggerV2(H5Logger.H5_PAGE_ABNORMAL, (String) null, str6, str11, str12, str14, getUniteParam4(), "H-EM");
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().upload();
                    }
                }
            }
        }
    }

    private String isSpdy(String str) {
        b bVar;
        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_androidSpdy"));
        String str2 = H5Param.DEFAULT_LONG_PRESSO_LOGIN;
        boolean equals = parseObject != null ? str2.equals(parseObject.getString("useSpdy")) : false;
        H5Log.d(TAG, "online config spdySwitch ".concat(String.valueOf(equals)));
        Pattern pattern = null;
        if (equals) {
            String string = parseObject.getString("whiteList");
            if (!TextUtils.isEmpty(string)) {
                pattern = H5PatternHelper.compile(string);
            }
            bVar = a.parseArray(parseObject.getString("blackList"));
            H5Log.d(TAG, "online config  whiteList " + string + ", blackList " + bVar.toJSONString());
        } else {
            bVar = null;
        }
        String host = H5UrlHelper.parseUrl(str).getHost();
        if (pattern == null || !pattern.matcher(host).matches()) {
            str2 = H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
        }
        if (bVar == null) {
            return str2;
        }
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            if (bVar.getString(i2).equals(host)) {
                return H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
            }
        }
        return str2;
    }

    private void logPagePerformance() {
        if (this.h5Page != null) {
            if (this.pageData.getStart() == 0) {
                H5Log.d(TAG, "pageData.start == 0 not logPagePerformance");
            } else if (H5Logger.enableStockTradeLog()) {
                H5PageData h5PageData = this.pageData;
                try {
                    h5PageData = h5PageData.clone();
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
                try {
                    H5PerformanceScheduler.scheduleH5PerfLog(new H5PerformanceLog(h5PageData, (Map) this.mPerformanceMap.clone(), (Map) this.mExtraJSReport.clone(), this.availablePageData, this.h5Page, this.bizScenario, this.isOfflineApp, new String(this.jsError.getBytes("utf-8"))));
                } catch (Exception e2) {
                    H5Log.d(TAG, "Exception".concat(String.valueOf(e2)));
                }
                this.jsError = "";
                H5Log.d(TAG, "logPagePerformance and logPageEndWithSpmId " + this.spmId + " spmBizType:" + this.spmBizType + " chInfo:" + this.chInfo + " token:" + h5PageData.getPageToken());
                endSpm();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        if ("".equals(r14) != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void remoteLogging(com.alipay.mobile.h5container.api.H5Event r14, com.alipay.mobile.h5container.api.H5BridgeContext r15) {
        /*
            r13 = this;
            com.alibaba.a.e r14 = r14.getParam()
            java.lang.String r0 = "logData"
            com.alibaba.a.b r0 = r14.getJSONArray(r0)
            java.lang.String r1 = "type"
            java.lang.String r14 = r14.getString(r1)
            if (r0 == 0) goto L_0x00dd
            int r1 = r0.size()
            if (r1 != 0) goto L_0x001b
            goto L_0x00dd
        L_0x001b:
            if (r14 == 0) goto L_0x0025
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r14)     // Catch:{ Exception -> 0x00c2 }
            if (r1 == 0) goto L_0x0027
        L_0x0025:
            java.lang.String r14 = "monitor"
        L_0x0027:
            int r1 = r0.size()     // Catch:{ Exception -> 0x00c2 }
            r9 = 1
            r10 = 0
            if (r1 != r9) goto L_0x0040
            r3 = 0
            java.lang.String r4 = r0.getString(r10)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            r8 = 0
            r1 = r13
            r2 = r14
            r1.executeLog(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x0040:
            int r1 = r0.size()     // Catch:{ Exception -> 0x00c2 }
            r11 = 2
            if (r1 != r11) goto L_0x005a
            r3 = 0
            java.lang.String r4 = r0.getString(r10)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = r0.getString(r9)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            r8 = 0
            r1 = r13
            r2 = r14
            r1.executeLog(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x005a:
            int r1 = r0.size()     // Catch:{ Exception -> 0x00c2 }
            r12 = 3
            if (r1 != r12) goto L_0x0076
            r3 = 0
            java.lang.String r4 = r0.getString(r10)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = r0.getString(r9)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r6 = r0.getString(r11)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r7 = ""
            r8 = 0
            r1 = r13
            r2 = r14
            r1.executeLog(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x0076:
            int r1 = r0.size()     // Catch:{ Exception -> 0x00c2 }
            r2 = 4
            if (r1 != r2) goto L_0x0094
            r3 = 0
            java.lang.String r4 = r0.getString(r10)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r5 = r0.getString(r9)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r6 = r0.getString(r11)     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r7 = r0.getString(r12)     // Catch:{ Exception -> 0x00c2 }
            r8 = 0
            r1 = r13
            r2 = r14
            r1.executeLog(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x0094:
            int r1 = r0.size()     // Catch:{ Exception -> 0x00c2 }
            r2 = 5
            if (r1 < r2) goto L_0x00c1
            java.lang.Object r1 = r0.remove((int) r10)     // Catch:{ Exception -> 0x00c2 }
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00c2 }
            java.lang.Object r1 = r0.remove((int) r10)     // Catch:{ Exception -> 0x00c2 }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00c2 }
            java.lang.Object r1 = r0.remove((int) r10)     // Catch:{ Exception -> 0x00c2 }
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00c2 }
            java.lang.Object r1 = r0.remove((int) r10)     // Catch:{ Exception -> 0x00c2 }
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r8 = r0.toJSONString()     // Catch:{ Exception -> 0x00c2 }
            r3 = 0
            r1 = r13
            r2 = r14
            r1.executeLog(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00c2 }
        L_0x00c1:
            return
        L_0x00c2:
            r14 = move-exception
            java.lang.String r0 = "H5LoggerPlugin"
            java.lang.String r1 = "exception detail"
            com.alipay.mobile.nebula.util.H5Log.e(r0, r1, r14)
            com.alibaba.a.e r14 = new com.alibaba.a.e
            r14.<init>()
            r0 = 10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "error"
            r14.put((java.lang.String) r1, (java.lang.Object) r0)
            r15.sendBridgeResult(r14)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.wallet.H5LoggerPlugin.remoteLogging(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):void");
    }

    private void executeLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        doLog(str, str2, str3, str4, str5, str6, str7, "", 0, "");
    }

    private void doLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9) {
        String str10;
        H5ConfigProvider h5ConfigProvider;
        H5LastKnowLocationProvider h5LastKnowLocationProvider;
        Location location;
        String str11 = str;
        if ("monitor".equals(str11) || "behavior".equals(str11) || "performance".equals(str11) || "monitorWithLocation".equals(str11) || "error".equals(str11) || "behaviorAuto".equals(str11) || "135".equals(str11)) {
            if (!"monitorWithLocation".equals(str11) || (h5LastKnowLocationProvider = (H5LastKnowLocationProvider) Nebula.getProviderManager().getProvider(H5LastKnowLocationProvider.class.getName())) == null || (location = h5LastKnowLocationProvider.getLocation()) == null) {
                str10 = str7;
            } else {
                str10 = str7 + "^longitude=" + location.getLongitude() + "^latitude=" + location.getLatitude();
            }
            if ("135".equals(str11)) {
                H5Logger.h5BehaviorLogger("135", str2, this.abTestInfo, this.entityId, this.pageId, str3, str4, str5, str6, str10, getUniteParam4(), i2, str9);
            } else if ("behavior".equals(str11) || "monitorWithLocation".equals(str11) || "monitor".equals(str11)) {
                H5Logger.h5BehaviorLogger(TextUtils.isEmpty(str8) ? "H5behavior" : str8, str2, this.abTestInfo, this.entityId, this.pageId, str3, str4, str5, str6, str10, getUniteParam4(), i2, str9);
            } else if ("performance".equals(str11)) {
                H5Logger.performanceLogger(str2, str3, str4, str5, str6, str10);
            } else {
                String str12 = "error".equals(str11) ? "H-EM" : "H-VM";
                if ("behaviorAuto".equals(str11)) {
                    str12 = "HD-VM";
                }
                H5Logger.performanceH5Exception(str2, str3, str4, str5, str6, str10, getUniteParam4(), str12, str);
                if (TextUtils.equals(str11, "error") && this.h5Page != null && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null && h5ConfigProvider.isAliDomains(this.h5Page.getUrl())) {
                    H5Log.debug(TAG, "is aliDomain upload now ");
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().upload();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void remoteLog(H5Event h5Event) {
        String str;
        String str2;
        String str3;
        String str4;
        e parseObject;
        String str5 = "";
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getParams() != null) {
            e param = h5Event.getParam();
            int i2 = remoteLogCount + 1;
            remoteLogCount = i2;
            boolean z = i2 > 1000;
            String string = H5Utils.getString(param, "seedId");
            String string2 = H5Utils.getString(param, "spmId");
            String string3 = H5Utils.getString(param, "abTestInfo");
            String string4 = H5Utils.getString(param, H5Param.LONG_BIZ_TYPE);
            this.entityId = H5Utils.getString(param, "entityId");
            try {
                str = (this.h5Page == null || this.h5Page.getParams() == null) ? str5 : H5Utils.getString(this.h5Page.getParams(), "extLogInfo");
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
                str = str5;
            }
            int i3 = H5Utils.getInt(param, "logLevel", 0);
            String string5 = H5Utils.getString(param, "actionId");
            if ((TextUtils.isEmpty(string5) || "clicked".equalsIgnoreCase(string5)) && !TextUtils.isEmpty(string2)) {
                try {
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().setLastClickSpm(string2);
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
            if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                if (("H5_PAGE_BEHAVIOR_AUTOCLICK".equals(string) || "H5_PAGE_BEHAVIOR_AUTOREPORT".equals(string) || "H5_PAGE_HASH_CHANGE".equals(string)) || (param != null && !param.isEmpty() && !z)) {
                    String string6 = H5Utils.getString(param, "type");
                    if (!"behavior".equals(string6) && !"performance".equals(string6) && !"monitorWithLocation".equals(string6) && !"error".equals(string6) && !"behaviorAuto".equals(string6) && !"135".equals(string6)) {
                        string6 = "monitor";
                    }
                    H5Log.debug(TAG, "remoteLog type ".concat(String.valueOf(string6)));
                    String string7 = H5Utils.getString(param, "ucId");
                    String string8 = H5Utils.getString(param, "param1");
                    String string9 = H5Utils.getString(param, "param2");
                    String string10 = H5Utils.getString(param, "param3");
                    Object obj = param.get("param4");
                    String str6 = str5 + "from=JSAPI^";
                    if (obj instanceof e) {
                        e eVar = (e) obj;
                        for (String next : eVar.keySet()) {
                            Object obj2 = eVar.get(next);
                            String str7 = str5;
                            if (obj2 instanceof String) {
                                str6 = str6 + next + "=" + obj2 + "^";
                            }
                            str5 = str7;
                        }
                    }
                    String str8 = str5;
                    if (obj instanceof String) {
                        str6 = str6 + obj;
                    }
                    if (Nebula.getH5LogHandler() != null) {
                        str3 = Nebula.getH5LogHandler().getContextParam("refViewID");
                        str2 = Nebula.getH5LogHandler().getContextParam("viewID");
                    } else {
                        str3 = str8;
                        str2 = str3;
                    }
                    if (!str6.endsWith("^")) {
                        str6 = str6 + "^";
                    }
                    String str9 = str6 + "actionId=" + string5 + "^ucId=" + string7 + "^viewId=" + str2 + "^refviewId=" + str3 + "^h5AppVersion=" + this.pageData.getAppVersion() + "^url=" + this.pageData.getPageUrl();
                    if (str9.endsWith("^")) {
                        str9 = str9.substring(0, str9.length() - 1);
                    }
                    String str10 = str9;
                    if (!TextUtils.isEmpty(str) && (parseObject = e.parseObject(str)) != null) {
                        this.pageId = parseObject.getString("pageId");
                    }
                    if (TextUtils.isEmpty(string2) || this.pageData == null) {
                        doLog(string6, string, string7, string8, string9, string10, str10, string4, i3, string5);
                        return;
                    }
                    H5Log.d(TAG, "h5RemoteLogClickLogger pageData.pageToken:" + this.pageData.getPageToken());
                    if (this.h5TrackIntegrator != null) {
                        String str11 = this.pageId;
                        if (TextUtils.isEmpty(str11)) {
                            String[] split = string2.split("\\.");
                            if (split.length > 2) {
                                str4 = split[0] + AppUtility.CENTER_DOT + split[1];
                            } else {
                                str4 = string2;
                            }
                            str11 = str4 + "_" + this.pageData.getPageToken();
                        }
                        H5Logger.h5RemoteLogClickLogger(str11, string2, string4, string3, this.entityId, string8, string9, string10, str10, getUniteParam4(), i3, string5);
                        return;
                    }
                    return;
                }
                return;
            }
            H5Log.w(TAG, "invalid seedId ".concat(String.valueOf(string)));
        }
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_CLOSE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_MENU);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_RELOAD);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TITLEBAR_OPTIONS);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TITLEBAR_SUBTITLE_CLICK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_CLOSED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_ERROR);
        h5EventFilter.addAction("pushWindow");
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_ABNORMAL);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_PAY_RESULT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_PAY_START);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_TAOBAOSSO_TIME);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_TAOBAOSSO_RESULT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_SHARE_RESULT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_FAVORITES_RESULT);
        h5EventFilter.addAction(H5Param.H5_PAGE_CREATE_WEBVIEW);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SESSION_FROM_NATIVE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SESSION_TO_NATIVE);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SESSION_ENTRY_ERROR);
        h5EventFilter.addAction(H5Logger.H5_AL_SESSION_START);
        h5EventFilter.addAction(H5Logger.H5_AL_SESSION_VERIFYTAR_FAIL);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SESSION_ENTRYRPC_ERROR);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SESSION_AUTOLOGIN);
        h5EventFilter.addAction(H5Logger.H5_AL_PAGE_LOAD_FAIL);
        h5EventFilter.addAction(H5Logger.H5_AL_PAGE_SYNCAJAX);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_NETWORK_PERFORMANCE_ERROR);
        h5EventFilter.addAction(H5Logger.H5_AL_JSAPI_CALL);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_PAY_BEFORE_INTERCEPT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_SHARE_RESULT);
        h5EventFilter.addAction(H5Logger.H5_AL_PAGE_RESUME);
        h5EventFilter.addAction(H5Logger.H5_GETLOCATION_RESULT);
        h5EventFilter.addAction(REMOTE_LOG);
        h5EventFilter.addAction(REMOTE_LOGGING);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_LONG_CLICK);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_OPEN_IN_BROWSER);
        h5EventFilter.addAction(H5Param.REPORT_ABNORMAL);
        h5EventFilter.addAction(H5Param.MONITOR_PERFORMANCE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_DOWNLOAD_APK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_INTERCEPT_SCHEME);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_QUERY_PP);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_QUERY_PP_COST);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_JUMP_PP);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_JUMP_PP_DOWNLOAD);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_JUMP_PP_DOWNLOAD_SUCCESS);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_DOWNLOAD_APK_RESULT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_FILE_DOWNLOAD);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_PAGE_JSAPI_LOGIN);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_VC_OVERLIMIT);
        h5EventFilter.addAction(H5Plugin.CommonEvents.H5_AL_GETSHARECONTENT_RESULT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PAUSE);
        h5EventFilter.addAction(REPORT_DATA);
        h5EventFilter.addAction(BIZ_REPORT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACK);
        h5EventFilter.addAction(pageMonitor);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RESUME);
        h5EventFilter.addAction(KEEP_ALIVE_PAGE_PERFORMANCE);
        h5EventFilter.addAction(DSL_ERROR_LOG);
    }

    /* access modifiers changed from: private */
    public String getUniteParam4() {
        String uniteParam4 = H5Logger.getUniteParam4(this.pageData, H5Refer.referUrl, this.bizScenario, this.isOfflineApp);
        return uniteParam4 + "^acsId=" + this.acsId;
    }

    /* access modifiers changed from: private */
    public String getInstallStatus(String str, String str2) {
        H5AppProvider h5AppProvider;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) == null || !h5AppProvider.isInstalled(str, str2)) {
            return "0";
        }
        return "1";
    }
}
