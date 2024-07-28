package com.alipay.mobile.nebulacore.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.model.H5Refer;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5PreRpcProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5PatternHelper;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.TestDataUtils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabBar;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import com.alipay.mobile.nebulacore.ui.H5FragmentManager;
import com.alipay.mobile.nebulacore.ui.H5NetworkCheckActivity;
import com.alipay.mobile.nebulacore.ui.H5TransActivity;
import com.alipay.mobile.nebulacore.util.H5AnimatorUtil;
import com.alipay.mobile.nebulacore.util.H5ErrorMsgUtil;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

public class H5SessionPlugin extends H5SimplePlugin {
    private static final String GET_SCENE_STACK_INFO = "getSceneStackInfo";
    public static final String SHOW_NETWORK_CHECK_ACTIVITY = "showNetWorkCheckActivity";
    public static final String TAG = "H5SessionPlugin";
    private int SPACE_TIME = 200;
    private boolean enableAntiDuplicate4Tiny;
    /* access modifiers changed from: private */
    public H5SessionImpl h5Session;
    private e lastCallParam;
    private long lastClickTime = 0;
    private Boolean showFavorites = Boolean.FALSE;

    public H5SessionPlugin(H5SessionImpl h5SessionImpl) {
        this.h5Session = h5SessionImpl;
    }

    private void initConfig() {
        e parseObject = H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_pushWindowSpace"));
        try {
            this.SPACE_TIME = H5Utils.getInt(parseObject, "spaceTime");
            this.enableAntiDuplicate4Tiny = H5Utils.getBoolean(parseObject, "enable", false);
            H5Log.d(TAG, "H5SessionPlugin get config SPACE_TIME " + this.SPACE_TIME + ", enableAntiDuplicate4Tiny " + this.enableAntiDuplicate4Tiny);
        } catch (Exception e2) {
            H5Log.e(TAG, "catch exception ", e2);
        }
    }

    public void onRelease() {
        this.h5Session = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.CommonEvents.GET_SESSION_DATA);
        h5EventFilter.addAction(H5Plugin.CommonEvents.SET_SESSION_DATA);
        h5EventFilter.addAction(H5Plugin.CommonEvents.EXIT_SESSION);
        h5EventFilter.addAction(H5Plugin.CommonEvents.POP_WINDOW);
        h5EventFilter.addAction(H5Plugin.CommonEvents.POP_TO);
        h5EventFilter.addAction("pushWindow");
        h5EventFilter.addAction("showFavorites");
        h5EventFilter.addAction(H5Plugin.InternalEvents.HIDE_FAVORITES);
        h5EventFilter.addAction(SHOW_NETWORK_CHECK_ACTIVITY);
        h5EventFilter.addAction(GET_SCENE_STACK_INFO);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if ("showFavorites".equals(action)) {
            this.showFavorites = Boolean.TRUE;
            return false;
        } else if (!H5Plugin.InternalEvents.HIDE_FAVORITES.equals(action)) {
            return false;
        } else {
            this.showFavorites = Boolean.FALSE;
            return false;
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.SET_SESSION_DATA.equals(action)) {
            setSessionData(h5Event);
            h5BridgeContext.sendSuccess();
        } else if (H5Plugin.CommonEvents.GET_SESSION_DATA.equals(action)) {
            getSessionData(h5Event, h5BridgeContext);
        } else if (H5Plugin.CommonEvents.EXIT_SESSION.equals(action)) {
            exitSession();
        } else if (H5Plugin.CommonEvents.POP_TO.equals(action)) {
            popTo(h5Event, h5BridgeContext);
        } else if (H5Plugin.CommonEvents.POP_WINDOW.equals(action)) {
            popWindow(h5Event);
            h5BridgeContext.sendSuccess();
        } else if ("pushWindow".equals(action)) {
            String string = H5Utils.getString(h5Event.getParam(), "url", (String) null);
            if (TextUtils.isEmpty(string)) {
                string = H5Utils.getString(h5Event.getParam(), "u", (String) null);
            }
            if (!H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableInterceptJavascriptInPushWindow")) || TextUtils.isEmpty(string) || !string.startsWith("javascript:")) {
                if (!TextUtils.isEmpty(string)) {
                    H5EnvProvider h5EnvProvider = (H5EnvProvider) H5Utils.getProvider(H5EnvProvider.class.getName());
                    if (h5EnvProvider != null && h5EnvProvider.goToSchemeService(string)) {
                        H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink");
                        return true;
                    } else if (H5Utils.isStripLandingURLEnable(string)) {
                        String stripLandingURL = H5Utils.getStripLandingURL(string);
                        if (!TextUtils.equals(string, stripLandingURL) && !TextUtils.isEmpty(stripLandingURL) && stripLandingURL.startsWith("alipay") && h5EnvProvider != null && h5EnvProvider.goToSchemeService(stripLandingURL)) {
                            H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink in landing");
                            return true;
                        }
                    }
                }
                pushWindow(h5Event, h5BridgeContext);
                h5BridgeContext.sendSuccess();
            } else {
                H5Log.d(TAG, "pushWindow intercept javascript success");
                h5BridgeContext.sendNoRightToInvoke();
                return true;
            }
        } else if (SHOW_NETWORK_CHECK_ACTIVITY.equals(action)) {
            Intent intent = new Intent(H5Environment.getContext(), H5NetworkCheckActivity.class);
            e param = h5Event.getParam();
            if (param != null) {
                intent.putExtra("error_code", param.getString("error_code"));
                intent.putExtra("url", param.getString("url"));
                intent.putExtra(Item.KEY_REASON, param.getString(Item.KEY_REASON));
            }
            try {
                c cVar = b.a().f14954a;
                b.a();
                cVar.a((f) null, intent);
            } catch (Exception e2) {
                H5Log.e(TAG, "showNetWorkCheckActivity, " + e2.toString());
            }
        } else if (GET_SCENE_STACK_INFO.equals(action)) {
            getSceneStackInfo(h5Event, h5BridgeContext);
        }
        return true;
    }

    private void getSessionData(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        com.alibaba.a.b jSONArray;
        H5Data data = this.h5Session.getData();
        e param = h5Event.getParam();
        if (param != null && data != null && (jSONArray = H5Utils.getJSONArray(param, "keys", (com.alibaba.a.b) null)) != null && !jSONArray.isEmpty()) {
            e eVar = new e();
            e eVar2 = new e();
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                String string = jSONArray.getString(i2);
                eVar2.put(string, (Object) data.get(string));
            }
            eVar.put("data", (Object) eVar2);
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    private void setSessionData(H5Event h5Event) {
        e jSONObject;
        H5Data data = this.h5Session.getData();
        e param = h5Event.getParam();
        if (param != null && data != null && (jSONObject = H5Utils.getJSONObject(param, "data", (e) null)) != null && !jSONObject.isEmpty()) {
            for (String next : jSONObject.keySet()) {
                data.set(next, jSONObject.getString(next));
            }
        }
    }

    private void exitSession() {
        this.h5Session.exitSession();
    }

    private void popWindow(H5Event h5Event) {
        e param = h5Event.getParam();
        if (param != null) {
            this.h5Session.getData().set(H5Param.H5_SESSION_POP_PARAM, H5Utils.getJSONObject(param, "data", (e) null).toJSONString());
        }
        H5Page topPage = this.h5Session.getTopPage();
        if (topPage != null) {
            topPage.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
        }
    }

    private void popTo(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (!doPopTo(h5Event)) {
            h5BridgeContext.sendError(10, H5ErrorMsgUtil.getErrorPageMsg(10));
        } else {
            h5BridgeContext.sendSuccess();
        }
    }

    private boolean doPopTo(H5Event h5Event) {
        e param = h5Event.getParam();
        int i2 = (param == null || !param.containsKey(H5StartParamManager.index)) ? Integer.MAX_VALUE : H5Utils.getInt(param, H5StartParamManager.index, Integer.MAX_VALUE);
        if (i2 == Integer.MAX_VALUE) {
            i2 = getUrlIndex(H5Utils.getString(param, "url", (String) null), false);
        }
        if (i2 == Integer.MAX_VALUE) {
            i2 = getUrlIndex(H5Utils.getString(param, "urlPattern", (String) null), true);
        }
        if (i2 == Integer.MAX_VALUE) {
            H5Log.e(TAG, "can't find page index");
            return false;
        } else if (!doPopWindow(param, i2, false, false)) {
            return true;
        } else {
            return false;
        }
    }

    private int getUrlIndex(String str, boolean z) {
        Stack<H5Page> pages = this.h5Session.getPages();
        if (pages == null) {
            return Integer.MAX_VALUE;
        }
        Stack<H5Page> sessionPagesWithOutPrerender = Nebula.getSessionPagesWithOutPrerender(pages);
        if (TextUtils.isEmpty(str) || sessionPagesWithOutPrerender == null || sessionPagesWithOutPrerender.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        int size = sessionPagesWithOutPrerender.size();
        for (int i2 = 0; i2 <= size - 1; i2++) {
            String url = ((H5Page) sessionPagesWithOutPrerender.get(i2)).getUrl();
            if (!TextUtils.isEmpty(url)) {
                if (z) {
                    Pattern compile = H5PatternHelper.compile(str);
                    if (compile != null && compile.matcher(url).find()) {
                    }
                } else if (str.equals(url)) {
                }
                return i2;
            }
        }
        return Integer.MAX_VALUE;
    }

    private void pushWindow(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String str;
        int i2;
        Bundle h5StartParam;
        H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        if (H5Environment.getContext() != null) {
            StringBuilder sb = new StringBuilder("H5");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis() + ((long) H5Utils.getUid(H5Environment.getContext())));
            sb.append(H5SecurityUtil.getMD5(sb2.toString()));
            H5PageLoader.h5Token = sb.toString();
        }
        e param = h5Event.getParam();
        H5CoreNode target = h5Event.getTarget();
        if (!(target instanceof H5Page)) {
            H5Log.w(TAG, "invalid target!");
            return;
        }
        final H5Page h5Page = (H5Page) target;
        Bundle params = h5Page.getParams();
        if (H5Utils.getBoolean(params, H5Param.isTinyApp, false)) {
            str = H5Utils.getString(params, "url");
            initConfig();
            if (this.enableAntiDuplicate4Tiny && isFastClick() && param != null && param.equals(this.lastCallParam)) {
                H5Log.d(TAG, "in tinyapp pushWindow duplicated");
                return;
            } else if (param != null) {
                this.lastCallParam = (e) param.clone();
            }
        } else {
            str = h5Page.getUrl();
        }
        if (TextUtils.isEmpty(H5Refer.referUrl)) {
            if (Nebula.getH5LogHandler() != null) {
                H5Refer.referUrl = Nebula.getH5LogHandler().getContextParam("refViewID");
            }
        } else if (!TextUtils.equals(str, H5Refer.referUrl) && H5Logger.enableStockTradeLog()) {
            H5Refer.referUrl = str;
        }
        H5Log.d("H5LoggerPlugins", "push window , g5PageData : " + h5Page.getPageData().hashCode() + " , public ReferUrl :  " + H5Refer.referUrl);
        if (!H5Utils.getBoolean(params, H5Param.LONG_TRANSPARENT, false) || H5Utils.getBoolean(params, H5Param.LONG_FULLSCREEN, false)) {
            if (h5Page != null) {
                H5Log.d(TAG, "sendToWeb page event pagePause");
                h5Page.getBridge().sendToWeb("pagePause", (e) null, (H5CallBack) null);
            }
            Bundle bundle = new Bundle();
            bundle.putAll(params);
            if (bundle.containsKey("preRpc")) {
                H5Log.d(TAG, "in H5SessionPlugin delete preRpc startparam");
                bundle.remove("preRpc");
            }
            if (bundle.containsKey(H5Param.LONG_NAV_SEARCH_BAR_TYPE)) {
                bundle.remove(H5Param.LONG_NAV_SEARCH_BAR_TYPE);
            }
            if (bundle.containsKey("backgroundColor")) {
                bundle.remove("backgroundColor");
            }
            if (bundle.containsKey(H5Param.LONG_TRANSPARENT_TITLE)) {
                H5Log.d(TAG, "in H5SessionPlugin delete transparentTitle startparam");
                bundle.remove(H5Param.LONG_TRANSPARENT_TITLE);
            }
            if (bundle.containsKey(H5Param.LONG_TRANSPARENT_TITLE_TEXTAUTO)) {
                H5Log.d(TAG, "in H5SessionPlugin delete transparentTitleTextAuto startparam");
                bundle.remove(H5Param.LONG_TRANSPARENT_TITLE_TEXTAUTO);
            }
            if (bundle.containsKey(H5Param.LONG_TITLE_IMAGE)) {
                H5Log.d(TAG, "in H5SessionPlugin delete titleImage startparam");
                bundle.remove(H5Param.LONG_TITLE_IMAGE);
            }
            if (bundle.containsKey(H5Param.LONG_BOUNCE_TOP_COLOR)) {
                bundle.remove(H5Param.LONG_BOUNCE_TOP_COLOR);
            }
            if (bundle.containsKey(H5Fragment.fragmentType)) {
                H5Log.d(TAG, "in H5SessionPlugin delete fragmentType startparam");
                bundle.remove(H5Fragment.fragmentType);
            }
            final e jSONObject = H5Utils.getJSONObject(param, H5Param.PARAM, (e) null);
            int i3 = H5Utils.getInt(param, H5Param.LONG_TITLE_BAR_COLOR);
            boolean z = H5Utils.getBoolean(jSONObject, "closeCurrentWindow", false);
            final boolean z2 = H5Utils.getBoolean(jSONObject, "closeAllWindow", false);
            final int i4 = H5Utils.getInt(param, "popToIndex", z2 ? 0 : Integer.MIN_VALUE);
            if (i3 == -1) {
                param.put(H5Param.LONG_TITLE_BAR_COLOR, (Object) Integer.valueOf(i3 | -16777216));
            }
            if (jSONObject != null && !jSONObject.isEmpty()) {
                Bundle bundle2 = new Bundle();
                H5Utils.toBundle(bundle2, jSONObject);
                Bundle parse = H5ParamParser.parse(bundle2, false);
                for (String remove : parse.keySet()) {
                    H5ParamParser.remove(bundle, remove);
                }
                bundle.putAll(parse);
            }
            bundle.putBoolean("showFavorites", this.showFavorites.booleanValue());
            String string = H5Utils.getString(param, "url", (String) null);
            if (TextUtils.isEmpty(string)) {
                H5Log.e(TAG, "can't get url parameter!");
                return;
            }
            if (string.startsWith("#")) {
                int indexOf = str.indexOf(35);
                if (indexOf != -1) {
                    string = str.substring(0, indexOf) + string;
                    H5Log.d(TAG, "stripAnchor url:".concat(String.valueOf(string)));
                }
            } else {
                string = H5Utils.getAbsoluteUrl(str, string, this.h5Session.getParams());
            }
            H5Log.d(TAG, "pushWindow url ".concat(String.valueOf(string)));
            bundle.putString("url", string);
            if (addRefererUrl(string)) {
                bundle.putString(H5Param.REFERER, str);
            }
            String string2 = H5Utils.getString(param, H5StartParamManager.launchParamsTag);
            if (!TextUtils.isEmpty(string2) && (h5StartParam = H5StartParamManager.getInstance().getH5StartParam(H5Utils.getString(bundle, "appId"), string2)) != null && !h5StartParam.isEmpty()) {
                H5Log.d(TAG, "launcher ".concat(String.valueOf(h5StartParam)));
                bundle.putAll(h5StartParam);
            }
            H5ParamParser.parseMagicOptions(bundle, TAG);
            H5ParamParser.parse(bundle, false);
            if (h5Page != null && h5Page.getContext() != null && h5Page.getContext().getContext() != null) {
                bundle.putString(H5Param.FROM_TYPE, "pushWindow");
                H5Log.d(TAG, "in H5SessionPlugin, oldParams is " + bundle.toString());
                H5PreRpcProvider h5PreRpcProvider = (H5PreRpcProvider) Nebula.getProviderManager().getProvider(H5PreRpcProvider.class.getName());
                if (h5PreRpcProvider != null) {
                    h5PreRpcProvider.setStartParams(bundle);
                    h5PreRpcProvider.preRpc();
                }
                if (H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false) || TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(bundle, H5Param.LONG_TRANSPARENT, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO))) {
                    Intent intent = new Intent(h5Page.getContext().getContext(), H5TransActivity.class);
                    bundle.remove(H5Param.LONG_TRANSPARENT);
                    bundle.putBoolean(H5Param.LONG_TRANSPARENT, true);
                    bundle.putBoolean("showLoadingView", true);
                    if (bundle.containsKey(H5Param.ASYNCINDEX)) {
                        bundle.remove(H5Param.ASYNCINDEX);
                    }
                    intent.putExtras(bundle);
                    H5Environment.startActivity(h5Page.getContext(), intent);
                    if (H5Utils.getBoolean(bundle, H5Param.LONG_TRANS_ANIMATE, false)) {
                        H5AnimatorUtil.setActivityFadingStart();
                    }
                    if (z) {
                        h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
                        return;
                    }
                    return;
                }
                boolean isDelayRender = Nebula.isDelayRender(bundle);
                bundle.putBoolean(H5Param.LONG_DELAY_RENDER, isDelayRender);
                if (isDelayRender) {
                    Intent intent2 = new Intent(h5Page.getContext().getContext(), H5TransActivity.class);
                    bundle.putBoolean(H5Param.LONG_DELAY_RENDER, true);
                    intent2.putExtras(bundle);
                    H5Environment.startActivity(h5Page.getContext(), intent2);
                    if (z) {
                        h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
                        return;
                    }
                    return;
                }
                if (Nebula.DEBUG) {
                    TestDataUtils.storeJSParams("pageLoad|pushWindowPoint", Long.valueOf(System.currentTimeMillis()));
                }
                if (h5Event.getActivity() instanceof H5Activity) {
                    H5FragmentManager h5FragmentManager = ((H5Activity) h5Event.getActivity()).getH5FragmentManager();
                    if (h5FragmentManager.getEnableTranslateAnimForVIP()) {
                        h5FragmentManager.addFragment(bundle, true, true);
                    } else {
                        h5FragmentManager.addFragment(bundle, h5FragmentManager.getEnableTranslateAnimForUser(), Boolean.valueOf(H5Utils.getBoolean(bundle, H5Param.LONG_PUSHWINDOW_WITH_TRANS_ANIM, false)).booleanValue());
                    }
                    i2 = h5FragmentManager.getFragmentCount();
                } else {
                    H5Bundle h5Bundle = new H5Bundle();
                    h5Bundle.setParams(bundle);
                    Nebula.getService().startPage(h5Page.getContext(), h5Bundle);
                    i2 = 0;
                }
                if (z) {
                    if (TextUtils.equals(H5Fragment.subtab, H5Utils.getString(h5Page.getParams(), H5Fragment.fragmentType, "normal"))) {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                H5SessionTabBar h5SessionTabBar;
                                if (H5SessionPlugin.this.h5Session != null) {
                                    H5SessionTabManager h5SessionTabManager = H5SessionPlugin.this.h5Session.getH5SessionTabManager();
                                    for (H5Fragment h5Page : h5SessionTabManager.getTabFragments().values()) {
                                        H5Page h5Page2 = h5Page.getH5Page();
                                        if (h5Page2 != null) {
                                            h5Page2.sendEvent("h5PageClose_tab", (e) null);
                                        }
                                    }
                                    if (h5SessionTabManager != null) {
                                        h5SessionTabManager.clearTabFragments();
                                    }
                                    if (H5SessionPlugin.this.h5Session != null && (h5SessionTabBar = H5SessionPlugin.this.h5Session.getH5SessionTabBar()) != null) {
                                        h5SessionTabBar.setHasShowTab(false);
                                    }
                                }
                            }
                        }, 500);
                    } else {
                        H5Utils.runOnMain(new Runnable() {
                            public void run() {
                                H5Page h5Page = h5Page;
                                if (h5Page != null) {
                                    h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
                                }
                            }
                        }, 500);
                    }
                }
                H5Log.d(TAG, "count:".concat(String.valueOf(i2)));
                if (Nebula.DEBUG && i2 >= 5) {
                    H5Environment.showToast(h5Event.getActivity(), H5Environment.getResources().getString(R.string.h5_sessionwarningpart1) + i2 + H5Environment.getResources().getString(R.string.h5_sessionwarningpart2), 1);
                }
                if (i4 != Integer.MIN_VALUE) {
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            boolean unused = H5SessionPlugin.this.doPopWindow(jSONObject, i4, true, z2);
                        }
                    }, 500);
                    return;
                }
                return;
            }
            return;
        }
        H5Log.d(TAG, "can not pushwindow in a transparent window");
        if (h5BridgeContext2 != null) {
            h5BridgeContext2.sendError(2, "Can't use pushWindow in transparent window");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d8 A[LOOP:0: B:65:0x00d6->B:66:0x00d8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doPopWindow(com.alibaba.a.e r10, int r11, boolean r12, boolean r13) {
        /*
            r9 = this;
            com.alipay.mobile.nebulacore.core.H5SessionImpl r0 = r9.h5Session
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.Stack r0 = r0.getPages()
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.util.Stack r0 = com.alipay.mobile.nebulacore.Nebula.getSessionPagesWithOutPrerender(r0)
            int r2 = r0.size()
            r3 = 2
            r4 = 1
            if (r11 >= 0) goto L_0x0020
            int r11 = r11 + r2
            if (r12 == 0) goto L_0x001e
            r5 = 2
            goto L_0x001f
        L_0x001e:
            r5 = 1
        L_0x001f:
            int r11 = r11 - r5
        L_0x0020:
            java.lang.String r5 = "H5SessionPlugin"
            if (r11 < 0) goto L_0x012f
            int r6 = r2 + -1
            if (r11 < r6) goto L_0x002a
            goto L_0x012f
        L_0x002a:
            java.lang.Object r6 = new java.lang.Object
            r6.<init>()
            java.lang.String r7 = "data"
            java.lang.Object r10 = com.alipay.mobile.nebula.util.H5Utils.getValue((com.alibaba.a.e) r10, (java.lang.String) r7, r6)
            r6 = 0
            if (r10 == 0) goto L_0x0096
            boolean r7 = r10 instanceof com.alibaba.a.e     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0043
            com.alibaba.a.e r10 = (com.alibaba.a.e) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = r10.toJSONString()     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0043:
            boolean r7 = r10 instanceof com.alibaba.a.b     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x004e
            com.alibaba.a.b r10 = (com.alibaba.a.b) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = r10.toJSONString()     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x004e:
            boolean r7 = r10 instanceof java.lang.String     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0055
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0055:
            boolean r7 = r10 instanceof java.lang.Boolean     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0060
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0060:
            boolean r7 = r10 instanceof java.lang.Double     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x006b
            java.lang.Double r10 = (java.lang.Double) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x006b:
            boolean r7 = r10 instanceof java.lang.Long     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0076
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0076:
            boolean r7 = r10 instanceof java.math.BigDecimal     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0085
            java.math.BigDecimal r10 = (java.math.BigDecimal) r10     // Catch:{ all -> 0x0090 }
            double r7 = r10.doubleValue()     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0085:
            boolean r7 = r10 instanceof java.lang.Integer     // Catch:{ all -> 0x0090 }
            if (r7 == 0) goto L_0x0096
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0090 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0090 }
            goto L_0x0097
        L_0x0090:
            r10 = move-exception
            java.lang.String r7 = "catch exception "
            com.alipay.mobile.nebula.util.H5Log.e(r5, r7, r10)
        L_0x0096:
            r10 = r6
        L_0x0097:
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 != 0) goto L_0x00a8
            com.alipay.mobile.nebulacore.core.H5SessionImpl r5 = r9.h5Session
            com.alipay.mobile.h5container.api.H5Data r5 = r5.getData()
            java.lang.String r7 = "h5_session_pop_param"
            r5.set(r7, r10)
        L_0x00a8:
            if (r12 == 0) goto L_0x00ac
            r10 = 2
            goto L_0x00ad
        L_0x00ac:
            r10 = 1
        L_0x00ad:
            int r10 = r2 - r10
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            if (r13 != 0) goto L_0x00d3
            com.alipay.mobile.nebulacore.core.H5SessionImpl r2 = r9.h5Session
            if (r2 == 0) goto L_0x00d6
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r2 = r2.getH5SessionTabManager()
            if (r2 == 0) goto L_0x00d6
            com.alipay.mobile.nebulacore.core.H5SessionImpl r2 = r9.h5Session
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r2 = r2.getH5SessionTabManager()
            int r2 = r2.countTabFragments()
            if (r2 <= 0) goto L_0x00d6
            int r3 = r11 + 1
            if (r3 > r2) goto L_0x00d6
            int r2 = r2 - r4
            r11 = r2
            goto L_0x00d6
        L_0x00d3:
            int r10 = r2 + -2
            r11 = -1
        L_0x00d6:
            if (r10 <= r11) goto L_0x00e4
            java.lang.Object r2 = r0.get(r10)
            com.alipay.mobile.nebulacore.core.H5PageImpl r2 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r2
            r12.add(r2)
            int r10 = r10 + -1
            goto L_0x00d6
        L_0x00e4:
            r10 = 0
        L_0x00e5:
            int r11 = r12.size()
            if (r10 >= r11) goto L_0x0116
            java.lang.Object r11 = r12.get(r10)
            com.alipay.mobile.nebulacore.core.H5PageImpl r11 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r11
            if (r13 == 0) goto L_0x010e
            android.os.Bundle r0 = r11.getParams()
            java.lang.String r2 = "fragmentType"
            java.lang.String r3 = "normal"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r2, (java.lang.String) r3)
            java.lang.String r2 = "subtab"
            boolean r0 = android.text.TextUtils.equals(r2, r0)
            if (r0 == 0) goto L_0x010e
            java.lang.String r0 = "h5PageClose_tab"
            r11.sendEvent(r0, r6)
            goto L_0x0113
        L_0x010e:
            java.lang.String r0 = "h5PageClose"
            r11.sendEvent(r0, r6)
        L_0x0113:
            int r10 = r10 + 1
            goto L_0x00e5
        L_0x0116:
            if (r13 == 0) goto L_0x012e
            com.alipay.mobile.nebulacore.core.H5SessionImpl r10 = r9.h5Session
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r10 = r10.getH5SessionTabManager()
            if (r10 == 0) goto L_0x0123
            r10.clearTabFragments()
        L_0x0123:
            com.alipay.mobile.nebulacore.core.H5SessionImpl r10 = r9.h5Session
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabBar r10 = r10.getH5SessionTabBar()
            if (r10 == 0) goto L_0x012e
            r10.setHasShowTab(r1)
        L_0x012e:
            return r1
        L_0x012f:
            java.lang.String r10 = "invalid page index"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r5, (java.lang.String) r10)
            java.lang.Object r10 = r0.peek()
            com.alipay.mobile.h5container.api.H5Page r10 = (com.alipay.mobile.h5container.api.H5Page) r10
            if (r10 == 0) goto L_0x0163
            com.alipay.mobile.h5container.api.H5Context r11 = r10.getContext()
            if (r11 == 0) goto L_0x0163
            com.alipay.mobile.h5container.api.H5Context r11 = r10.getContext()
            android.content.Context r11 = r11.getContext()
            if (r11 == 0) goto L_0x0163
            com.alipay.mobile.h5container.api.H5Context r11 = r10.getContext()
            android.content.Context r11 = r11.getContext()
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r12 = com.alipay.mobile.nebulacore.Nebula.needPageKeepAlive(r10, r11)
            if (r12 == 0) goto L_0x0163
            android.os.Bundle r10 = r10.getParams()
            com.alipay.mobile.nebulacore.Nebula.doKeepAlive(r11, r10)
        L_0x0163:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.plugin.H5SessionPlugin.doPopWindow(com.alibaba.a.e, int, boolean, boolean):boolean");
    }

    private void getSceneStackInfo(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (this.h5Session == null) {
            H5Log.w(TAG, "getSceneStackInfo : h5session is null !");
            return;
        }
        H5CoreNode target = h5Event.getTarget();
        if (!(target instanceof H5Page)) {
            H5Log.w(TAG, "getSceneStackInfo : invalid target!");
            return;
        }
        H5Page h5Page = (H5Page) target;
        Stack<H5Page> pages = this.h5Session.getPages();
        if (pages == null) {
            H5Log.w(TAG, "getSceneStackInfo : H5Page Stack is null !");
            return;
        }
        Stack<H5Page> sessionPagesWithOutPrerender = Nebula.getSessionPagesWithOutPrerender(pages);
        int size = sessionPagesWithOutPrerender.size();
        int indexOf = sessionPagesWithOutPrerender.indexOf(h5Page);
        com.alibaba.a.b bVar = new com.alibaba.a.b();
        Iterator it2 = sessionPagesWithOutPrerender.iterator();
        while (it2.hasNext()) {
            e eVar = new e();
            eVar.put("url", (Object) ((H5Page) it2.next()).getUrl());
            bVar.add(eVar);
        }
        e eVar2 = new e();
        eVar2.put("count", (Object) Integer.valueOf(size));
        eVar2.put("currentIndex", (Object) Integer.valueOf(indexOf));
        eVar2.put("detail", (Object) bVar);
        H5Log.d(TAG, "count = " + size + " , currentIndex = " + indexOf + " detail :" + bVar);
        h5BridgeContext.sendBridgeResult(eVar2);
    }

    public synchronized boolean isFastClick() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        z = currentTimeMillis - this.lastClickTime <= ((long) this.SPACE_TIME);
        this.lastClickTime = currentTimeMillis;
        return z;
    }

    private boolean addRefererUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.alibaba.a.b parseArray = H5Utils.parseArray(H5Environment.getConfigWithProcessCache("h5_documentRefererWhitelist"));
            if (parseArray != null) {
                for (int i2 = 0; i2 < parseArray.size(); i2++) {
                    if (H5PatternHelper.matchRegex(parseArray.getString(i2), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail.", th);
        }
        return false;
    }
}
