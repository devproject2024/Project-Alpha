package com.alipay.mobile.nebula.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class H5ParamParser {
    private static final String LAUNCHER_PARAM_URL = "launcherParamUrl";
    public static final String TAG = "H5ParamParser";
    private static Map<String, H5ParamImpl> paramMap = new HashMap<String, H5ParamImpl>() {
        {
            put("url", new H5ParamImpl("url", "u", H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_DEFAULT_TITLE, new H5ParamImpl(H5Param.LONG_DEFAULT_TITLE, H5Param.DEFAULT_TITLE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_TITLE_IMAGE, new H5ParamImpl(H5Param.LONG_TITLE_IMAGE, H5Param.TITLE_IMAGE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_SHOW_TITLEBAR, new H5ParamImpl(H5Param.LONG_SHOW_TITLEBAR, H5Param.SHOW_TITLEBAR, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put("showFavorites", new H5ParamImpl("showFavorites", H5Param.SHOW_FAVORITES, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put("showReportBtn", new H5ParamImpl("showReportBtn", H5Param.SHOW_REPORT_BTN, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_SHOW_TOOLBAR, new H5ParamImpl(H5Param.LONG_SHOW_TOOLBAR, H5Param.SHOW_TOOLBAR, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put("showLoading", new H5ParamImpl("showLoading", H5Param.SHOW_LOADING, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_CLOSE_BUTTON_TEXT, new H5ParamImpl(H5Param.LONG_CLOSE_BUTTON_TEXT, H5Param.CLOSE_BUTTON_TEXT, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_SSO_LOGIN_ENABLE, new H5ParamImpl(H5Param.LONG_SSO_LOGIN_ENABLE, H5Param.SSO_LOGIN_ENABLE, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_SAFEPAY_ENABLE, new H5ParamImpl(H5Param.LONG_SAFEPAY_ENABLE, H5Param.SAFEPAY_ENABLE, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_SAFEPAY_CONTEXT, new H5ParamImpl(H5Param.LONG_SAFEPAY_CONTEXT, H5Param.SAFEPAY_CONTEXT, H5Param.ParamType.STRING, ""));
            put("readTitle", new H5ParamImpl("readTitle", H5Param.READ_TITLE, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_BIZ_SCENARIO, new H5ParamImpl(H5Param.LONG_BIZ_SCENARIO, H5Param.BIZ_SCENARIO, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_ANTI_PHISHING, new H5ParamImpl(H5Param.LONG_ANTI_PHISHING, H5Param.ANTI_PHISHING, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_TOOLBAR_MENU, new H5ParamImpl(H5Param.LONG_TOOLBAR_MENU, H5Param.TOOLBAR_MENU, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_BACK_BEHAVIOR, new H5ParamImpl(H5Param.LONG_BACK_BEHAVIOR, H5Param.BACK_BEHAVIOR, H5Param.ParamType.STRING, H5Param.DEFAULT_LONG_BACK_BEHAVIOR));
            put("pullRefresh", new H5ParamImpl("pullRefresh", "pr", H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put("showTitleLoading", new H5ParamImpl("showTitleLoading", H5Param.SHOW_TITLE_LOADING, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_SHOW_PROGRESS, new H5ParamImpl(H5Param.LONG_SHOW_PROGRESS, H5Param.SHOW_PROGRESS, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_SMART_TOOLBAR, new H5ParamImpl(H5Param.LONG_SMART_TOOLBAR, H5Param.SMART_TOOLBAR, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_ENABLE_PROXY, new H5ParamImpl(H5Param.LONG_ENABLE_PROXY, H5Param.ENABLE_PROXY, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put("canPullDown", new H5ParamImpl("canPullDown", H5Param.CAN_PULL_DOWN, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put("showDomain", new H5ParamImpl("showDomain", H5Param.SHOW_DOMAIN, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put("prefetchLocation", new H5ParamImpl("prefetchLocation", H5Param.PREFETCH_LOCATION, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put("showOptionMenu", new H5ParamImpl("showOptionMenu", H5Param.SHOW_OPTION_MENU, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put("backgroundColor", new H5ParamImpl("backgroundColor", H5Param.BACKGROUND_COLOR, H5Param.ParamType.INT, -1));
            put(H5Param.LONG_INTERCEPT_JUMP, new H5ParamImpl(H5Param.LONG_INTERCEPT_JUMP, H5Param.INTERCEPT_JUMP, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_CLOSE_AFTER_PAY_FINISH, new H5ParamImpl(H5Param.LONG_CLOSE_AFTER_PAY_FINISH, H5Param.CLOSE_AFTER_PAY_FINISH, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_TRANSPARENT, new H5ParamImpl(H5Param.LONG_TRANSPARENT, H5Param.TRANSPARENT, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_FULLSCREEN, new H5ParamImpl(H5Param.LONG_FULLSCREEN, H5Param.FULLSCREEN, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_LANDSCAPE, new H5ParamImpl(H5Param.LONG_LANDSCAPE, H5Param.LANDSCAPE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_ENABLE_SCROLLBAR, new H5ParamImpl(H5Param.LONG_ENABLE_SCROLLBAR, H5Param.ENABLE_SCROLLBAR, H5Param.ParamType.BOOLEAN, Boolean.TRUE));
            put(H5Param.LONG_DELAY_RENDER, new H5ParamImpl(H5Param.LONG_DELAY_RENDER, H5Param.DELAY_RENDER, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_CAN_DESTROY, new H5ParamImpl(H5Param.LONG_CAN_DESTROY, H5Param.CAN_DESTROY, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_TRANSPARENT_TITLE, new H5ParamImpl(H5Param.LONG_TRANSPARENT_TITLE, H5Param.TRANSPARENT_TITLE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_TITLE_BAR_COLOR, new H5ParamImpl(H5Param.LONG_TITLE_BAR_COLOR, H5Param.TITLE_BAR_COLOR, H5Param.ParamType.INT, 0));
            put(H5Param.LONG_TITLE_SCROLLDISTANCE, new H5ParamImpl(H5Param.LONG_TITLE_SCROLLDISTANCE, H5Param.TITLE_SCROLLDISTANCE, H5Param.ParamType.INT, Integer.valueOf(PriceRangeSeekBar.INVALID_POINTER_ID)));
            put(H5Param.LONG_BOUNCE_TOP_COLOR, new H5ParamImpl(H5Param.LONG_BOUNCE_TOP_COLOR, H5Param.BOUNCE_TOP_COLOR, H5Param.ParamType.INT, Integer.valueOf(H5Param.DEFAULT_LONG_BOUNCE_TOP_COLOR)));
            put(H5Param.LONG_ALLOWS_BOUNCE_VERTICAL, new H5ParamImpl(H5Param.LONG_ALLOWS_BOUNCE_VERTICAL, H5Param.ALLOWS_BOUNCE_VERTICAL, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NB_UPDATE, new H5ParamImpl(H5Param.LONG_NB_UPDATE, H5Param.NB_UPDATE, H5Param.ParamType.STRING, "async"));
            put(H5Param.LONG_NB_OFFLINE, new H5ParamImpl(H5Param.LONG_NB_OFFLINE, H5Param.NB_OFFLINE, H5Param.ParamType.STRING, "async"));
            put(H5Param.LONG_NB_URL, new H5ParamImpl(H5Param.LONG_NB_URL, H5Param.NB_URL, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_OB_VERSION, new H5ParamImpl(H5Param.LONG_OB_VERSION, H5Param.OB_VERSION, H5Param.ParamType.STRING, ""));
            put("nbversion", new H5ParamImpl("nbversion", H5Param.NB_VERSION, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NAV_SEARCH_BAR_TYPE, new H5ParamImpl(H5Param.LONG_NAV_SEARCH_BAR_TYPE, H5Param.NAV_SEARCH_BAR_TYPE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NAV_SEARCH_BAR_PLACEHOLDER, new H5ParamImpl(H5Param.LONG_NAV_SEARCH_BAR_PLACEHOLDER, H5Param.NAV_SEARCH_BAR_PLACEHOLDER, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NAV_SEARCH_BAR_VALUE, new H5ParamImpl(H5Param.LONG_NAV_SEARCH_BAR_VALUE, H5Param.NAV_SEARCH_BAR_VALUE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NAV_SEARCH_BAR_MAX_LENGTH, new H5ParamImpl(H5Param.LONG_NAV_SEARCH_BAR_MAX_LENGTH, H5Param.NAV_SEARCH_BAR_MAX_LENGTH, H5Param.ParamType.INT, 0));
            put(H5Param.LONG_BACKBTN_IMAGE, new H5ParamImpl(H5Param.LONG_BACKBTN_IMAGE, H5Param.BACKBTN_IMAGE, H5Param.ParamType.STRING, "default"));
            put(H5Param.LONG_BACKBTN_TEXTCOLOR, new H5ParamImpl(H5Param.LONG_BACKBTN_TEXTCOLOR, H5Param.BACKBTN_TEXTCOLOR, H5Param.ParamType.INT, -16777216));
            put(H5Param.LONG_TITLE_COLOR, new H5ParamImpl(H5Param.LONG_TITLE_COLOR, H5Param.TITLE_COLOR, H5Param.ParamType.INT, -16777216));
            put(H5Param.LONG_TRANSPARENT_TITLE_TEXTAUTO, new H5ParamImpl(H5Param.LONG_TRANSPARENT_TITLE_TEXTAUTO, H5Param.TRANSPARENT_TITLE_TEXTAUTO, H5Param.ParamType.STRING, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO));
            put(H5Param.LONG_PRESSO_LOGIN, new H5ParamImpl(H5Param.LONG_PRESSO_LOGIN, H5Param.PRESSO_LOGIN, H5Param.ParamType.STRING, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
            put(H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE, new H5ParamImpl(H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE, H5Param.PRESSO_LOGIN_BINDINGPAGE, H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_PRESSO_LOGIN_URL, new H5ParamImpl(H5Param.LONG_PRESSO_LOGIN_URL, H5Param.PRESSO_LOGIN_URL, H5Param.ParamType.STRING, ""));
            put("tabBarJson", new H5ParamImpl("tabBarJson", "tabBarJson", H5Param.ParamType.STRING, ""));
            put("enableTabBar", new H5ParamImpl("enableTabBar", "enableTabBar", H5Param.ParamType.STRING, "default"));
            put("tabItemCount", new H5ParamImpl("tabItemCount", "tabItemCount", H5Param.ParamType.INT, -1));
            put("preventAutoLoginLoop", new H5ParamImpl("preventAutoLoginLoop", "preventAutoLoginLoop", H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_TRANS_ANIMATE, new H5ParamImpl(H5Param.LONG_TRANS_ANIMATE, H5Param.TRANS_ANIMATE, H5Param.ParamType.BOOLEAN, Boolean.FALSE));
            put(H5Param.LONG_NB_OFFMODE, new H5ParamImpl(H5Param.LONG_NB_OFFMODE, H5Param.NB_OFFMODE, H5Param.ParamType.STRING, "force"));
            put("openUrlMethod", new H5ParamImpl("openUrlMethod", "openUrlMethod", H5Param.ParamType.STRING, H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD));
            put("openUrlPostParams", new H5ParamImpl("openUrlPostParams", "openUrlPostParams", H5Param.ParamType.STRING, ""));
            put(H5Param.LONG_NB_APP_TYPE, new H5ParamImpl(H5Param.LONG_NB_APP_TYPE, H5Param.NB_APP_TYPE, H5Param.ParamType.STRING, ""));
        }
    };

    public static Bundle transParamParse(Bundle bundle) {
        if (bundle == null) {
            return bundle;
        }
        String string = H5Utils.getString(bundle, H5Param.TRANSPARENT);
        if (TextUtils.isEmpty(string)) {
            string = H5Utils.getString(bundle, H5Param.LONG_TRANSPARENT);
        }
        if (TextUtils.isEmpty(string) && (H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false) || H5Utils.getBoolean(bundle, H5Param.TRANSPARENT, false))) {
            string = H5Param.DEFAULT_LONG_PRESSO_LOGIN;
        }
        if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(string)) {
            bundle.remove(H5Param.SHOW_TITLEBAR);
            bundle.remove(H5Param.LONG_SHOW_TITLEBAR);
            bundle.remove(H5Param.SHOW_TOOLBAR);
            bundle.remove(H5Param.LONG_SHOW_TOOLBAR);
            bundle.remove(H5Param.SHOW_PROGRESS);
            bundle.remove(H5Param.LONG_SHOW_PROGRESS);
            bundle.remove(H5Param.SHOW_DOMAIN);
            bundle.remove("showDomain");
            bundle.remove(H5Param.CAN_PULL_DOWN);
            bundle.remove("canPullDown");
            bundle.remove(H5Param.ALLOWS_BOUNCE_VERTICAL);
            bundle.remove(H5Param.LONG_ALLOWS_BOUNCE_VERTICAL);
            bundle.putString(H5Param.SHOW_TITLEBAR, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.LONG_SHOW_TITLEBAR, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.SHOW_TOOLBAR, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.LONG_SHOW_TOOLBAR, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.SHOW_DOMAIN, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("showDomain", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.CAN_PULL_DOWN, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString("canPullDown", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.ALLOWS_BOUNCE_VERTICAL, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            bundle.putString(H5Param.LONG_ALLOWS_BOUNCE_VERTICAL, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
            if (!bundle.containsKey("backgroundColor") && !bundle.containsKey(H5Param.BACKGROUND_COLOR)) {
                String string2 = H5Utils.getString(bundle, H5Param.LONG_FULLSCREEN);
                if (!H5Utils.getBoolean(bundle, H5Param.LONG_FULLSCREEN, false) && (TextUtils.isEmpty(string2) || !H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(string2))) {
                    String string3 = H5Utils.getString(bundle, H5Param.LONG_TRANS_ANIMATE);
                    boolean z = H5Utils.getBoolean(bundle, H5Param.LONG_TRANS_ANIMATE, false);
                    if ((TextUtils.isEmpty(string3) || !H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(string3)) && !z) {
                        bundle.putInt(H5Param.BACKGROUND_COLOR, 855638016);
                        bundle.putInt("backgroundColor", 855638016);
                    } else {
                        bundle.putInt(H5Param.BACKGROUND_COLOR, -1291845632);
                        bundle.putInt("backgroundColor", -1291845632);
                    }
                }
            }
        }
        return bundle;
    }

    public static Bundle parse(Bundle bundle, String str, boolean z) {
        if (!paramMap.containsKey(str)) {
            return bundle;
        }
        return paramMap.get(str).unify(bundle, z);
    }

    public static Bundle parse(Bundle bundle, boolean z) {
        if (bundle == null) {
            return bundle;
        }
        transParamParse(bundle);
        paramMap.get(H5Param.LONG_SHOW_PROGRESS).setDefaultValue(Boolean.valueOf("20000067".equals(H5Utils.getString(bundle, "appId"))));
        if (z) {
            preFillDefault(bundle);
        }
        for (String str : paramMap.keySet()) {
            bundle = paramMap.get(str).unify(bundle, z);
        }
        String string = H5Utils.getString(bundle, H5Param.LONG_ALLOWS_BOUNCE_VERTICAL, "");
        H5Log.d(TAG, "merge LONG_ALLOWS_BOUNCE_VERTICAL & LONG_CAN_PULL_DOWN ".concat(String.valueOf(string)));
        if (!TextUtils.isEmpty(string)) {
            if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equals(string)) {
                bundle.putBoolean("canPullDown", true);
            } else if (H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equals(string)) {
                bundle.putBoolean("canPullDown", false);
            }
        }
        int i2 = H5Utils.getInt(bundle, "tabItemCount", -1);
        String string2 = H5Utils.getString(bundle, "enableTabBar", "default");
        H5Log.d(TAG, "tabItemCount " + i2 + ", enableTabBar " + string2);
        if (TextUtils.equals("default", string2)) {
            if (i2 != -1) {
                bundle.putString("enableTabBar", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
            }
        } else if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, string2) && i2 == -1) {
            bundle.putInt("tabItemCount", 4);
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.mobile.nebula.util.H5ParamImpl getParamImp(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map<java.lang.String, com.alipay.mobile.nebula.util.H5ParamImpl> r0 = paramMap
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map<java.lang.String, com.alipay.mobile.nebula.util.H5ParamImpl> r3 = paramMap
            java.lang.Object r2 = r3.get(r2)
            com.alipay.mobile.nebula.util.H5ParamImpl r2 = (com.alipay.mobile.nebula.util.H5ParamImpl) r2
            java.lang.String r3 = r2.getLongName()
            java.lang.String r4 = r2.getShortName()
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L_0x003a
            boolean r3 = r5.equals(r4)
            if (r3 == 0) goto L_0x0012
        L_0x003a:
            return r2
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5ParamParser.getParamImp(java.lang.String):com.alipay.mobile.nebula.util.H5ParamImpl");
    }

    public static void remove(Bundle bundle, String str) {
        H5ParamImpl paramImp;
        if (bundle != null && !TextUtils.isEmpty(str) && (paramImp = getParamImp(str)) != null) {
            bundle.remove(paramImp.getLongName());
            bundle.remove(paramImp.getShortName());
        }
    }

    private static void preFillDefault(Bundle bundle) {
        if (!bundle.containsKey("showOptionMenu") && !bundle.containsKey(H5Param.SHOW_OPTION_MENU)) {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            boolean z = false;
            if (h5ConfigProvider == null || "no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_preFillDefault_h5App"))) {
                String string = H5Utils.getString(bundle, "appId");
                if (TextUtils.isEmpty(string)) {
                    string = "20000067";
                }
                if (H5AppUtil.isH5ContainerAppId(string) || "20000101".equals(string) || "20000042".equals(string)) {
                    z = true;
                }
                H5Log.d(TAG, "pre-fill set showOptionMenu as ".concat(String.valueOf(z)));
                bundle.putBoolean("showOptionMenu", z);
                return;
            }
            boolean z2 = H5Utils.getBoolean(bundle, H5Param.isH5app, false);
            StringBuilder sb = new StringBuilder("pre-fill set showOptionMenu as ");
            sb.append(!z2);
            H5Log.d(TAG, sb.toString());
            bundle.putBoolean("showOptionMenu", !z2);
        }
    }

    public static void parseMagicOptions(Bundle bundle, String str) {
        Bundle h5StartParam;
        if (bundle == null) {
            H5Log.w(str, "invalid magic parameter!");
            return;
        }
        String string = H5Utils.getString(bundle, "u");
        if (TextUtils.isEmpty(string)) {
            string = H5Utils.getString(bundle, "url");
        }
        if (TextUtils.isEmpty(string)) {
            H5Log.w(str, "no url found in magic parameter");
            return;
        }
        String str2 = null;
        String param = H5UrlHelper.getParam(H5UrlHelper.parseUrl(string), "__webview_options__", (String) null);
        if (TextUtils.isEmpty(param)) {
            H5Log.w(str, "no magic options found");
            return;
        }
        H5Log.d(str, "found magic options ".concat(String.valueOf(param)));
        try {
            str2 = URLDecoder.decode(param, AppConstants.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            H5Log.e(str, "UnsupportedEncodingException", e2);
        }
        if (TextUtils.isEmpty(str2)) {
            H5Log.e(str, "failed to decode magic options");
        } else if (str2 == null) {
            try {
                H5Log.d(str, "decodedOptions is null.");
            } catch (Exception e3) {
                H5Log.e(str, "failed to decode magic option.", e3);
            }
        } else {
            for (String split : str2.split(AppConstants.AND_SIGN)) {
                String[] split2 = split.split("=");
                if (split2.length >= 2) {
                    String decode = URLDecoder.decode(split2[0], AppConstants.UTF_8);
                    String decode2 = URLDecoder.decode(split2[1], AppConstants.UTF_8);
                    if (H5StartParamManager.launchParamsTag.equalsIgnoreCase(decode) && !TextUtils.isEmpty(decode2) && (h5StartParam = H5StartParamManager.getInstance().getH5StartParam(H5Utils.getString(bundle, "appId"), decode2)) != null && !h5StartParam.isEmpty()) {
                        H5Log.d(str, "launchParamsTag ".concat(String.valueOf(h5StartParam)));
                        bundle.putAll(h5StartParam);
                    }
                    if (!H5Param.DELAY_RENDER.equals(decode) && !H5Param.LONG_DELAY_RENDER.equals(decode) && !H5Param.TRANSPARENT.equals(decode) && !H5Param.LONG_TRANSPARENT.equals(decode)) {
                        remove(bundle, decode);
                        bundle.putString(decode, decode2);
                        H5Log.d(str, "decode magic option [key] " + decode + " [value] " + decode2);
                    }
                }
            }
        }
    }

    public static void setLauncherParams(e eVar, Bundle bundle) {
        if (eVar == null || eVar.isEmpty()) {
            H5Log.e(TAG, "can't parse launch parameters as json");
            return;
        }
        Set<String> keySet = eVar.keySet();
        bundle.putString(LAUNCHER_PARAM_URL, H5Utils.getString(eVar, "url"));
        for (String next : keySet) {
            H5ParamImpl paramImp = getParamImp(next);
            if (paramImp == null || ((!bundle.containsKey(paramImp.getLongName()) && !bundle.containsKey(paramImp.getShortName())) || (bundle.get(paramImp.getLongName()) == null && bundle.get(paramImp.getShortName()) == null))) {
                Object obj = eVar.get(next);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!bundle.containsKey(next) || TextUtils.isEmpty(H5Utils.getString(bundle, next))) {
                        bundle.putString(next, str);
                    } else {
                        H5Log.d(TAG, "bundle contain " + next + " value:" + H5Utils.getString(bundle, next) + " not to merge appInfo");
                    }
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof BigDecimal) {
                    bundle.putDouble(next, ((BigDecimal) obj).doubleValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof e) {
                    bundle.putString(next, ((e) obj).toString());
                } else if (obj instanceof b) {
                    bundle.putString(next, ((b) obj).toString());
                } else {
                    H5Log.d(TAG, "ignore launch param [key] " + next + " [value] " + obj);
                }
                H5Log.d(TAG, "read launch param [key] " + next + " [value] " + obj);
            } else {
                H5Log.d(TAG, "merge config [key] " + next + " already exists and value not empty");
            }
        }
    }
}
