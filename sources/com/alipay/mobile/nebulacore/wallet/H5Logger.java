package com.alipay.mobile.nebulacore.wallet;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alipay.mobile.h5container.api.H5AvailablePageData;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulacore.Nebula;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.Map;

public class H5Logger {
    public static String DIAGNOSE = "diagnose";
    public static String H5_AL_JSAPI_CALL = "H5_AL_JSAPI_CALL";
    public static String H5_AL_PAGE_JSERROR = "H5_AL_PAGE_JSERROR";
    public static String H5_AL_PAGE_LOAD_FAIL = "H5_AL_PAGE_LOAD_FAIL";
    public static String H5_AL_PAGE_RESUME = "H5_AL_PAGE_RESUME";
    public static String H5_AL_PAGE_SYNCAJAX = "H5_AL_PAGE_SYNCAJAX";
    public static String H5_AL_SESSION_HTTPPROXY = "H5_AL_SESSION_HTTPPROXY";
    public static final String H5_AL_SESSION_HTTPPROXY_FAIL = "H5_AL_SESSION_HTTPPROXY_FAIL";
    public static String H5_AL_SESSION_START = "H5_AL_SESSION_START";
    public static String H5_AL_SESSION_VERIFYTAR_FAIL = "H5_AL_SESSION_VERIFYTAR_FAIL";
    public static String H5_GETLOCATION_RESULT = "H5_GETLOCATION_RESULT";
    public static String H5_OPEN_URL_UC = "H5_OPEN_URL_UC";
    public static String H5_PAGE_ABNORMAL = "H5_PAGE_ABNORMAL";
    public static final String H5_SHOW_LOG_UPLOAD_CONFIG = "h5_show_log_upload";
    public static String H5_TITLEBAR_RIGHT_BT = "H5_TITLEBAR_RIGHT_BT";
    public static String H5_TITLEBAR_SUBTITLE_BT = "H5_TITLEBAR_SUBTITLE_BT";
    public static String H5_TOOLBAR_BACK_BT = "H5_TOOLBAR_BACK_BT";
    public static String H5_TOOLBAR_CLOSE_BT = "H5_TOOLBAR_CLOSE_BT";
    public static String H5_TOOLBAR_MEMU = "H5_TOOLBAR_MEMU";
    public static String H5_TOOLBAR_MEMU_BT = "H5_TOOLBAR_MEMU_BT";
    public static String H5_TOOLBAR_REFRESH_BT = "H5_TOOLBAR_REFRESH_BT";
    public static final String HEADER = "header";
    public static final String LOG_HEADER_AM = "H5-AM";
    public static final String LOG_HEADER_VM = "H5-VM";
    public static String MONITOR = "monitor";
    public static final String MTBIZ_H5 = "MTBIZ_H5";
    public static final String TAG = "H5Logger";
    public static String bizScenario = "";
    public static boolean isH5Activity = true;
    public static boolean isOfflineApp = false;
    public static b sDefaultLogWebAppWhiteList;

    static {
        b bVar = new b();
        sDefaultLogWebAppWhiteList = bVar;
        bVar.add("H5_PAGE_PERFORMANCE|H5_AL_SESSION_FROM_NATIVE|H5_AL_SESSION_MAP_SUCCESS|H5_AL_SESSION_FALLBACK|H5_GETLOCATION_RESULT");
    }

    public static void performanceLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        performanceLogger(str, str2, str3, str4, str5, str6 + "^" + str7);
    }

    public static void performanceLoggerV2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        performanceLoggerV2(str, str2, str3, str4, str5, str6 + "^" + str7, str8);
    }

    public static void performanceH5Exception(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        StringBuilder sb = new StringBuilder();
        String str10 = str6;
        sb.append(str6);
        sb.append("^");
        String str11 = str7;
        sb.append(str7);
        exceptionLog(str, str2, str3, str4, str5, sb.toString(), str8, str9);
    }

    public static void performanceLogger(String str, String str2, String str3, String str4, String str5, String str6) {
        if (enableStockTradeLog()) {
            final String str7 = str;
            final String str8 = str2;
            final String str9 = str3;
            final String str10 = str4;
            final String str11 = str5;
            final String str12 = str6;
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                public final void run() {
                    b parseArray;
                    if (Nebula.getH5LogHandler() != null) {
                        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                        if (h5ConfigProvider == null || (parseArray = H5Utils.parseArray(h5ConfigProvider.getConfigWithProcessCache("h5_log_blackList"))) == null || !parseArray.contains(str7)) {
                            Nebula.getH5LogHandler().performanceLogger(str7, str8, str9, str10, str11, str12, H5Logger.bizScenario);
                            return;
                        }
                        H5Log.d(H5Logger.TAG, "h5_log_blackList contain " + str7 + " not log");
                    }
                }
            });
        }
    }

    private static void exceptionLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (enableStockTradeLog()) {
            final String str9 = str;
            final String str10 = str2;
            final String str11 = str3;
            final String str12 = str4;
            final String str13 = str5;
            final String str14 = str6;
            final String str15 = str7;
            final String str16 = str8;
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                public final void run() {
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().exceptionLog(str9, str10, str11, str12, str13, str14, str15, str16, H5Logger.bizScenario);
                    }
                }
            });
        }
    }

    public static void performanceLoggerV2(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        exceptionLog(str, str2, str3, str4, str5, str6, str7, "");
    }

    public static void h5BehaviorLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, String str12) {
        if (enableStockTradeLog()) {
            final String str13 = str;
            final String str14 = str2;
            final String str15 = str3;
            final String str16 = str4;
            final String str17 = str5;
            final String str18 = str6;
            final String str19 = str7;
            final String str20 = str8;
            final String str21 = str9;
            final String str22 = str10;
            final String str23 = str11;
            final int i3 = i2;
            final String str24 = str12;
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                public final void run() {
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().h5BehaviorLogger(str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, i3, str24, H5Logger.bizScenario);
                    }
                }
            });
        }
    }

    static void h5RemoteLogClickLogger(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, String str11) {
        if (enableStockTradeLog()) {
            final String str12 = str;
            final String str13 = str2;
            final String str14 = str3;
            final String str15 = str4;
            final String str16 = str5;
            final String str17 = str6;
            final String str18 = str7;
            final String str19 = str8;
            final String str20 = str9;
            final String str21 = str10;
            final int i3 = i2;
            final String str22 = str11;
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                public final void run() {
                    if (Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().h5RemoteLogClickLogger(str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, i3, str22, H5Logger.bizScenario);
                    }
                }
            });
        }
    }

    public static void mtBizReport(final String str, final String str2, final String str3, final Map<String, String> map) {
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public final void run() {
                if (Nebula.getH5LogHandler() != null) {
                    Nebula.getH5LogHandler().mtBizReport(str, str2, str3, map);
                }
            }
        });
    }

    public static String getToken() {
        return Nebula.getH5LogHandler() != null ? Nebula.getH5LogHandler().getToken() : "";
    }

    private static String getPsd(H5PageData h5PageData, boolean z) {
        if (TextUtils.isEmpty(H5AppUtil.currentPsd)) {
            return (H5AppUtil.isH5ContainerAppId(h5PageData.getAppId()) || z) ? "local" : P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT;
        }
        return H5AppUtil.currentPsd;
    }

    public static String getUniteParam4(H5PageData h5PageData, Bundle bundle) {
        return getUniteParam4(h5PageData, H5Utils.getString(bundle, H5Param.LONG_BIZ_SCENARIO), bundle != null && !TextUtils.isEmpty(H5Utils.getString(bundle, H5Param.OFFLINE_HOST)));
    }

    private static String getUniteParam4(H5PageData h5PageData, String str, boolean z) {
        return getUniteParam4(h5PageData, "", str, z);
    }

    public static String getUniteParam4(H5PageData h5PageData, String str, String str2, boolean z) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        try {
            String title = h5PageData.getTitle();
            try {
                if (!TextUtils.isEmpty(title)) {
                    title = title.trim().replace(" ", "").replace(AppConstants.COMMA, "").replace(StringUtility.NEW_LINE, "");
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
            try {
                str3 = URLEncoder.encode(h5PageData.getCustomParams(), "utf-8");
            } catch (Exception e3) {
                H5Log.e(TAG, (Throwable) e3);
                str3 = "";
            }
            H5Log.debug(TAG, "g5PageData : " + h5PageData.hashCode() + " ,referer :  " + h5PageData.getReferUrl() + " pageUrl:" + h5PageData.getPageUrl());
            if (isH5Activity) {
                if (TextUtils.isEmpty(h5PageData.getPageUrl())) {
                    str5 = Nebula.getH5LogHandler() != null ? Nebula.getH5LogHandler().getContextParam("viewID") : "";
                } else {
                    str5 = h5PageData.getPageUrl();
                    if (enableStockTradeLog() && Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().putContextParam("viewID", str5);
                    }
                }
                if (TextUtils.isEmpty(h5PageData.getReferUrl())) {
                    str4 = Nebula.getH5LogHandler() != null ? Nebula.getH5LogHandler().getContextParam("refViewID") : "";
                } else {
                    String referUrl = h5PageData.getReferUrl();
                    if (enableStockTradeLog() && Nebula.getH5LogHandler() != null) {
                        Nebula.getH5LogHandler().putContextParam("refViewID", referUrl);
                    }
                    str4 = referUrl;
                }
            } else if (Nebula.getH5LogHandler() != null) {
                str5 = Nebula.getH5LogHandler().getContextParam("viewID");
                str4 = Nebula.getH5LogHandler().getContextParam("refViewID");
            } else {
                str5 = "";
                str4 = str5;
            }
            if (!TextUtils.isEmpty(h5PageData.getXContentVersion())) {
                str6 = "^xContentVersion=" + h5PageData.getXContentVersion();
            } else {
                str6 = "";
            }
            if (!TextUtils.isEmpty(h5PageData.getEagleId())) {
                str7 = "^eagleId=" + h5PageData.getEagleId();
            } else {
                str7 = "";
            }
            if (!TextUtils.isEmpty(h5PageData.getRequestId())) {
                str8 = "^requestId=" + h5PageData.getRequestId();
            } else {
                str8 = "";
            }
            if (!TextUtils.isEmpty(h5PageData.getSpmId())) {
                str9 = "^spmId=".concat("");
            } else {
                str9 = "";
            }
            String str10 = "url=" + h5PageData.getPageUrl() + str6 + str7 + str8 + str9 + "^referer=" + h5PageData.getReferUrl() + "^appId=" + h5PageData.getAppId() + "^version=" + h5PageData.getAppVersion() + "^publicId=" + h5PageData.getPublicId() + "^sourceId=" + H5AppUtil.secAppId + "^psd=" + getPsd(h5PageData, z) + "^viewId=" + str5 + "^refviewId=" + str4 + "^bizScenario=" + str2 + "^token=" + h5PageData.getToken() + "^h5Token=" + h5PageData.getH5Token() + "^h5SessionToken=H5Session" + h5PageData.getH5SessionToken() + "^openAppId=" + h5PageData.getOpenAppId() + "^shopId=" + h5PageData.getShopId() + "^title=" + title + "^customParams=" + str3 + "^webViewType=" + h5PageData.getWebViewType() + "^isTinyApp=" + h5PageData.getIsTinyApp();
            if (TextUtils.isEmpty(h5PageData.getReleaseType())) {
                return str10;
            }
            return str10 + "^log_release_type=" + h5PageData.getReleaseType();
        } catch (Exception e4) {
            H5Log.e(TAG, (Throwable) e4);
            return "";
        }
    }

    public static String getPerformanceData(H5PageData h5PageData) {
        StringBuilder sb = new StringBuilder("^start=");
        sb.append(h5PageData.getStart());
        sb.append("^finishLoad=");
        sb.append(h5PageData.getComplete());
        sb.append("^blankScreen=");
        sb.append(h5PageData.getFirstVisuallyRender());
        sb.append("^MCCMNC=^router=");
        sb.append("[" + h5PageData.getPageUrl() + "{" + h5PageData.getPageNetLoad() + "}->(" + h5PageData.getStatusCode() + ")]");
        sb.append("^cssReqNum=");
        sb.append(h5PageData.getCssReqNum());
        sb.append("^jsReqNum=");
        sb.append(h5PageData.getJsReqNum());
        sb.append("^imgReqNum=");
        sb.append(h5PageData.getImgReqNum());
        sb.append("^otherReqNum=");
        sb.append(h5PageData.getOtherReqNum());
        sb.append("^requestNum=");
        sb.append(h5PageData.getRequestNum());
        sb.append("^bizScenario=");
        sb.append(bizScenario);
        sb.append("^pageSize=");
        sb.append(h5PageData.getPageSize());
        sb.append("^status=");
        sb.append(h5PageData.getStatusCode());
        sb.append("^htmlSize=");
        sb.append(h5PageData.getHtmlSize());
        sb.append("^firstByte=");
        sb.append(h5PageData.getFirstByte());
        sb.append("^startRender=");
        sb.append(h5PageData.getAppear());
        sb.append("^startRenderFromNative=");
        sb.append(h5PageData.getAppearFromNative());
        sb.append("^cssSize=");
        sb.append(h5PageData.getCssSize());
        sb.append("^jsSize=");
        sb.append(h5PageData.getJsSize());
        sb.append("^imgSize=");
        sb.append(h5PageData.getImgSize());
        sb.append("^otherSize=");
        sb.append(h5PageData.getOtherSize());
        sb.append("^imageSizeLimit60=");
        sb.append(h5PageData.getSizeLimit60());
        sb.append("^imageSizeLoadLimit60=");
        sb.append(h5PageData.getSizeLoadLimit60());
        sb.append("^sizeLimit200=");
        sb.append(h5PageData.getSizeLimit200());
        sb.append("^302Num=");
        sb.append(h5PageData.getNum302());
        sb.append("^304Num=");
        sb.append(h5PageData.getNum304());
        sb.append("^300Num=");
        sb.append(h5PageData.getNum300());
        sb.append("^404Num=");
        sb.append(h5PageData.getNum404());
        sb.append("^400Num=");
        sb.append(h5PageData.getNum400());
        sb.append("^500Num=");
        sb.append(h5PageData.getNum500());
        sb.append("^1000Num=");
        sb.append(h5PageData.getNum1000());
        sb.append("^pageNetLoad=");
        sb.append(h5PageData.getPageNetLoad());
        sb.append("^jsLoadNum=");
        sb.append(h5PageData.getJsLoadNum());
        sb.append("^cssLoadNum=");
        sb.append(h5PageData.getCssLoadNum());
        sb.append("^imgLoadNum=");
        sb.append(h5PageData.getImgLoadNum());
        sb.append("^otherLoadNum=");
        sb.append(h5PageData.getOtherLoadNum());
        sb.append("^requestLoadNum=");
        sb.append(h5PageData.getRequestLoadNum());
        sb.append("^serverResponse=");
        sb.append(h5PageData.getPageNetLoad());
        sb.append("^imageSizeLimit60Urls=[");
        sb.append(h5PageData.getImageSizeLimit60Urls());
        sb.append("]^sizeLimit200Urls=[");
        sb.append(h5PageData.getSizeLimit200Urls());
        sb.append("]^create=");
        sb.append(h5PageData.getCreate() != 0 ? h5PageData.getCreate() : H5PageLoader.sServiceStart);
        sb.append("^createScenario=");
        sb.append(h5PageData.getCreateScenario());
        sb.append("^aboutBlank=");
        sb.append(h5PageData.getAboutBlankNum());
        sb.append("^htmlLoadSize=");
        sb.append(h5PageData.getHtmlLoadSize());
        sb.append("^fromType=");
        sb.append(h5PageData.getFromType());
        sb.append("^srcClick=");
        sb.append(h5PageData.getSrcClick());
        sb.append("^containerVisible=");
        sb.append(h5PageData.getContainerVisible());
        sb.append("^preRender=");
        sb.append(h5PageData.getPreRender());
        sb.append("^pkg=");
        sb.append(h5PageData.getResPkgInfo());
        sb.append("^netperf=");
        sb.append(getNetPerfStr(h5PageData));
        return sb.toString();
    }

    public static String getNetPerfStr(H5PageData h5PageData) {
        return "1" + "_" + h5PageData.getNetJsReqNum() + "_" + h5PageData.getNetOtherReqNum() + "_" + h5PageData.getNetErrorJsNum() + "_" + h5PageData.getNetErrorOtherNum() + "_" + h5PageData.getNetJsSize() + "_" + h5PageData.getNetOtherSize() + "_" + h5PageData.getNetJsTime() + "_" + h5PageData.getNetOtherTime();
    }

    public static void reportTabBarLog(Bundle bundle, String str, String str2) {
        String string = H5Utils.getString(bundle, "appId");
        String string2 = H5Utils.getString(bundle, "url");
        String string3 = H5Utils.getString(bundle, "appVersion");
        performanceLoggerV2(str, (String) null, (String) null, (String) null, (String) null, "appId=" + string + "^version=" + string3 + "^url=" + string2, (String) null, str2);
    }

    public static boolean enableStockTradeLog() {
        return H5Flag.isUploadLog;
    }

    public static long getLongValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains(AppUtility.CENTER_DOT)) {
            return Long.valueOf(str.substring(0, str.indexOf(AppUtility.CENTER_DOT))).longValue();
        }
        return Long.valueOf(str).longValue();
    }

    public static long getCorrectStopLoading(long j, H5PageData h5PageData, H5AvailablePageData h5AvailablePageData) {
        long j2;
        if (h5PageData == null || h5AvailablePageData == null) {
            return 0;
        }
        if (j == 0) {
            j = System.currentTimeMillis();
            j2 = getCorrectStartTime(h5PageData);
        } else {
            j2 = getCorrectStartTime(h5PageData);
        }
        return j - j2;
    }

    public static long getCorrectStartTime(H5PageData h5PageData) {
        if (h5PageData == null) {
            return 0;
        }
        return h5PageData.getNavigationStart() > 0 ? h5PageData.getNavigationStart() : h5PageData.getStart();
    }

    public static String getDslVersion(H5PageData h5PageData) {
        String[] split;
        if (h5PageData == null) {
            return "";
        }
        String resPkgInfo = h5PageData.getResPkgInfo();
        if (!TextUtils.isEmpty(resPkgInfo) && resPkgInfo.contains("66666692") && (split = resPkgInfo.split("\\|")) != null && split.length != 0) {
            for (String str : split) {
                if (str.contains("66666692")) {
                    String[] split2 = str.split("_");
                    if (split2 == null || split2.length != 3) {
                        return "";
                    }
                    return split2[2];
                }
            }
        }
        return "";
    }
}
