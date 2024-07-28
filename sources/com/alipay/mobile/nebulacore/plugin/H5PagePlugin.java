package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.model.H5Refer;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.dev.H5BugmeIdGenerator;
import com.alipay.mobile.nebula.provider.H5CardShareProvider;
import com.alipay.mobile.nebula.provider.H5HttpHeadersProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.api.BackBehavior;
import com.alipay.mobile.nebulacore.api.PageStatus;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.view.H5FontBar;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.alipay.mobile.nebulacore.web.H5WebView;
import java.util.HashMap;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5PagePlugin extends H5SimplePlugin {
    private static final String COOL_LOADING_CTRL = "coolLoadingCtrl";
    private static final String GET_STARTUP_PARAMS = "getStartupParams";
    private static final String INPUT_FOCUS = "inputFocus4Android";
    public static final String SHOW_SOFT_INPUT = "showSoftInput";
    private static final String STOP_LOADING = "stopLoading";
    public static final String TAG = "H5PagePlugin";
    public static final String TOGGLE_SOFT_INPUT = "toggleSoftInput";
    private static final int UNKNOWN_ERROR_NUM = 12;
    private int backBehavior;
    private H5BackHandler backHandler = new H5BackHandler();
    private H5Bridge h5Bridge;
    private H5PageImpl h5Page;
    /* access modifiers changed from: private */
    public H5WebView h5WebView;
    private H5LogProvider logProvider;
    private int pageStatus = PageStatus.NONE;

    public H5PagePlugin(H5PageImpl h5PageImpl) {
        this.h5Page = h5PageImpl;
        this.h5WebView = h5PageImpl.getWebView();
        this.h5Bridge = h5PageImpl.getBridge();
        setBackBehavior(H5Utils.getString(h5PageImpl.getParams(), H5Param.LONG_BACK_BEHAVIOR));
        this.logProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
    }

    public void onRelease() {
        H5CardShareProvider h5CardShareProvider = (H5CardShareProvider) Nebula.getProviderManager().getProvider(H5CardShareProvider.class.getName());
        if (h5CardShareProvider != null) {
            h5CardShareProvider.release();
        }
        this.h5Bridge = null;
        this.h5WebView = null;
        this.h5Page = null;
        this.backHandler = null;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACK_BEHAVIOR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_LOAD_URL);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_LOAD_DATA);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RELOAD);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FONT_SIZE);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_RESUME);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_ERROR);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACK);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_STARTED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PROGRESS);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_FINISHED);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_CLOSE);
        h5EventFilter.addAction("h5PageClose_tab");
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_BACKGROUND);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_DO_LOAD_URL);
        h5EventFilter.addAction(TOGGLE_SOFT_INPUT);
        h5EventFilter.addAction(SHOW_SOFT_INPUT);
        h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PAUSE);
        h5EventFilter.addAction(STOP_LOADING);
        h5EventFilter.addAction(INPUT_FOCUS);
        h5EventFilter.addAction(GET_STARTUP_PARAMS);
        h5EventFilter.addAction(COOL_LOADING_CTRL);
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (this.h5Page == null) {
            return false;
        }
        if (H5Plugin.InternalEvents.H5_PAGE_ERROR.equals(action)) {
            this.pageStatus = PageStatus.ERROR;
            return true;
        }
        H5Plugin.InternalEvents.H5_PAGE_BACKGROUND.equals(action);
        return false;
    }

    private void setBackBehavior(String str) {
        H5Log.d(TAG, "setBackBehavior ".concat(String.valueOf(str)));
        if ("pop".equals(str)) {
            this.backBehavior = BackBehavior.POP;
        } else {
            this.backBehavior = BackBehavior.BACK;
        }
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5PageImpl h5PageImpl;
        H5PageImpl h5PageImpl2;
        H5Session session;
        H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        String action = h5Event.getAction();
        e param = h5Event.getParam();
        if (H5Plugin.InternalEvents.H5_PAGE_BACK_BEHAVIOR.equals(action)) {
            setBackBehavior(H5Utils.getString(param, H5Param.LONG_BACK_BEHAVIOR));
        } else if (H5Plugin.InternalEvents.H5_PAGE_LOAD_URL.equals(action)) {
            if (TextUtils.isEmpty(this.h5WebView.getUrl())) {
                Bundle params = this.h5Page.getParams();
                if (params != null) {
                    param.put("appId", (Object) H5Utils.getString(params, "appId"));
                    String string = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN);
                    String string2 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_BINDINGPAGE);
                    String string3 = H5Utils.getString(params, H5Param.LONG_PRESSO_LOGIN_URL);
                    param.put(H5Param.PRESSO_LOGIN, (Object) string);
                    param.put(H5Param.PRESSO_LOGIN_BINDINGPAGE, (Object) string2);
                    param.put(H5Param.PRESSO_LOGIN_URL, (Object) string3);
                }
                param.put(H5Param.START_URL, (Object) Boolean.TRUE);
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_SHOULD_LOAD_URL, param);
            } else {
                loadUrl(h5Event);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_LOAD_DATA.equals(action)) {
            loadData(h5Event);
        } else if (H5Plugin.InternalEvents.H5_PAGE_DO_LOAD_URL.equals(action)) {
            String string4 = H5Utils.getString(param, "url");
            String url = this.h5WebView.getUrl();
            boolean z = H5Utils.getBoolean(param, "force", false);
            if (!TextUtils.isEmpty(url)) {
                this.h5Page.getWebViewClient().setCheckingUrl(string4);
            }
            if (TextUtils.isEmpty(url) || url.equals(string4) || z) {
                loadUrl(h5Event);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_RELOAD.equals(action)) {
            this.h5WebView.reload();
        } else if (H5Plugin.InternalEvents.H5_PAGE_BACK.equals(action)) {
            pageBack();
        } else if (H5Plugin.InternalEvents.H5_PAGE_PAUSE.equals(action)) {
            H5Log.d(TAG, "sendToWeb page event pause");
            H5Bridge h5Bridge2 = this.h5Bridge;
            if (h5Bridge2 != null) {
                h5Bridge2.sendToWeb("pause", (e) null, (H5CallBack) null);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_RESUME.equals(action)) {
            String remove = this.h5Page.getSession().getData().remove(H5Param.H5_SESSION_POP_PARAM);
            String remove2 = this.h5Page.getSession().getData().remove(H5Param.H5_SESSION_RESUME_PARAM);
            String remove3 = this.h5Page.getSession().getData().remove(Nebula.H5_PAGE_RESUME);
            e eVar = new e();
            if (!TextUtils.isEmpty(remove)) {
                e parseObject = H5Utils.parseObject(remove);
                if (parseObject != null) {
                    eVar.put("data", (Object) parseObject);
                } else {
                    b parseArray = H5Utils.parseArray(remove);
                    if (parseArray != null) {
                        eVar.put("data", (Object) parseArray);
                    } else {
                        eVar.put("data", (Object) remove);
                    }
                }
            }
            if (!TextUtils.isEmpty(remove2)) {
                eVar.put("resumeParams", (Object) H5Utils.parseObject(remove2));
            }
            H5Log.d(TAG, "sendToWeb page event resume");
            if (!TextUtils.isEmpty(remove3)) {
                H5Log.d(TAG, "sendToWeb page event pageResume");
                this.h5Bridge.sendToWeb("pageResume", eVar, (H5CallBack) null);
            }
            this.h5Bridge.sendToWeb("resume", eVar, (H5CallBack) null);
            if (H5PageLoader.isPageClose) {
                this.h5Page.getPageData().setReferUrl(H5Refer.referUrl);
                if (Nebula.DEBUG) {
                    H5Log.d(TAG, "h5page resume, getRefer : " + H5Refer.referUrl);
                }
                this.h5Page.sendEvent(H5Logger.H5_AL_PAGE_RESUME, (e) null);
                H5PageLoader.isPageClose = false;
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_FONT_SIZE.equals(action)) {
            int i2 = H5Utils.getInt(param, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, -1);
            if (i2 != -1) {
                this.h5WebView.setTextSize(i2);
            }
            H5PageImpl h5PageImpl3 = this.h5Page;
            if (!(h5PageImpl3 == null || h5PageImpl3.getSession() == null || this.h5Page.getSession().getScenario() == null || this.h5Page.getSession().getScenario().getData() == null)) {
                this.h5Page.getSession().getScenario().getData().set(H5Param.FONT_SIZE, String.valueOf(i2));
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_STARTED.equals(action)) {
            this.pageStatus = PageStatus.LOADING;
            Bundle params2 = this.h5Page.getParams();
            if (H5Utils.getBoolean(params2, "showLoading", false)) {
                this.h5Page.sendEvent("showLoading", (e) null);
            } else if (H5Utils.getBoolean(params2, "showTitleLoading", false)) {
                this.h5Page.sendEvent("showTitleLoading", (e) null);
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_FINISHED.equals(action)) {
            this.pageStatus = PageStatus.FINISHED;
            this.h5Page.sendEvent(H5Plugin.CommonEvents.HIDE_LOADING, (e) null);
            this.h5Page.sendEvent(H5Plugin.CommonEvents.HIDE_TITLE_LOADING, (e) null);
            int i3 = H5Utils.getInt(param, "historySize");
            boolean z2 = H5Utils.getBoolean(this.h5Page.getParams(), H5Param.isTinyApp, false);
            if (!(!z2 || (session = Nebula.getService().getSession(H5Utils.getString(this.h5Page.getParams(), (String) H5Param.SESSION_ID))) == null || session.getPages() == null)) {
                i3 = Nebula.getSessionPagesWithOutPrerender(session.getPages()).size();
            }
            if (i3 > 1 && (BackBehavior.BACK == this.backBehavior || z2)) {
                if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(this.h5Page.getParams(), H5Plugin.CommonEvents.HIDE_CLOSE_BUTTON))) {
                    H5Log.d(TAG, "set hideCloseButton yes");
                } else {
                    e eVar2 = new e();
                    eVar2.put("show", (Object) Boolean.TRUE);
                    this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_SHOW_CLOSE, eVar2);
                }
            }
        } else if (H5Plugin.InternalEvents.H5_PAGE_RECEIVED_TITLE.equals(action)) {
            this.pageStatus = PageStatus.FINISHED;
        } else if (H5Plugin.InternalEvents.H5_PAGE_CLOSE.equals(action) || "h5PageClose_tab".equals(action)) {
            if (H5Plugin.InternalEvents.H5_PAGE_CLOSE.equals(action)) {
                exit(false);
            } else {
                exit(true);
            }
        } else if (H5Plugin.InternalEvents.H5_TOOLBAR_MENU_BT.equals(action)) {
            String string5 = H5Utils.getString(param, "tag");
            if (H5Param.MENU_FONT.equals(string5)) {
                this.h5Page.sendEvent(H5FontBar.SHOW_FONT_BAR, (e) null);
            } else if (H5Param.MENU_REFRESH.equals(string5)) {
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RELOAD, (e) null);
            } else if (H5Param.MENU_COPY.equals(string5)) {
                e eVar3 = new e();
                eVar3.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, (Object) this.h5Page.getShareUrl());
                this.h5Page.sendEvent(H5Plugin.CommonEvents.SET_CLIPBOARD, eVar3);
                H5Environment.showToast(this.h5Page.getContext().getContext(), H5Environment.getResources().getString(R.string.h5_copied), 0);
            } else if (!"openInBrowser".equals(string5)) {
                return false;
            } else {
                Uri parseUrl = H5UrlHelper.parseUrl(this.h5Page.getShareUrl());
                if (parseUrl == null) {
                    e eVar4 = new e();
                    eVar4.put("error", (Object) 2);
                    h5BridgeContext2.sendBridgeResult(eVar4);
                }
                String shareUrl = this.h5Page.getShareUrl();
                if (TextUtils.isEmpty(shareUrl)) {
                    return false;
                }
                H5PageImpl h5PageImpl4 = this.h5Page;
                if (!(h5PageImpl4 == null || h5PageImpl4.getParams() == null)) {
                    String string6 = H5Utils.getString(this.h5Page.getParams(), H5Param.ONLINE_HOST, "");
                    if (!TextUtils.isEmpty(string6) && shareUrl.startsWith(string6)) {
                        try {
                            String shareLoadingScheme = H5Utils.getShareLoadingScheme(shareUrl, H5Utils.getString(this.h5Page.getParams(), "appId"), this.h5Page);
                            shareUrl = "https://ds.alipay.com/?scheme=" + H5UrlHelper.encode(shareLoadingScheme);
                            parseUrl = Uri.parse(shareUrl);
                        } catch (Throwable th) {
                            H5Log.e(TAG, th);
                        }
                    }
                }
                String uCMPackageName = Nebula.getUCMPackageName(Nebula.getPackageInfos(this.h5Page.getContext().getContext()));
                if (shareUrl.startsWith("https://ds.alipay.com/error/securityLink.htm") || shareUrl.startsWith("https://ds.alipay.com/error/redirectLink.htm")) {
                    parseUrl = Uri.parse(Uri.parse(shareUrl).getQueryParameter("url"));
                    H5Log.d(TAG, "competitive link special text is " + parseUrl.getHost());
                }
                if (TextUtils.isEmpty(uCMPackageName) || (h5PageImpl2 = this.h5Page) == null || h5PageImpl2.getContext() == null) {
                    Intent intent = new Intent("android.intent.action.VIEW", parseUrl);
                    Intent createChooser = Intent.createChooser(intent, H5Environment.getResources().getString(R.string.h5_menu_open_in_browser));
                    createChooser.setFlags(268435456);
                    if (intent.resolveActivity(H5Environment.getContext().getPackageManager()) != null) {
                        H5Environment.startActivity((H5Context) null, createChooser);
                    }
                } else {
                    Nebula.startUCMIntentLoadUrl(this.h5Page.getContext().getContext(), parseUrl, uCMPackageName, (H5BridgeContext) null);
                    H5LogProvider h5LogProvider = this.logProvider;
                    if (h5LogProvider != null) {
                        h5LogProvider.log(H5Logger.H5_OPEN_URL_UC, (String) null, (String) null, "url=".concat(String.valueOf(shareUrl)), (String) null, H5Logger.getUniteParam4(this.h5Page.getPageData(), this.h5Page.getParams()));
                        H5Log.d(TAG, "log open url in uc");
                    }
                }
                this.h5Page.sendEvent(H5Plugin.CommonEvents.H5_OPEN_IN_BROWSER, (e) null);
            }
        } else if (TOGGLE_SOFT_INPUT.equals(action)) {
            ((InputMethodManager) H5Environment.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        } else if (SHOW_SOFT_INPUT.equals(action)) {
            if (!param.containsKey("show") || (h5PageImpl = this.h5Page) == null || h5PageImpl.getWebView() == null) {
                e eVar5 = new e();
                eVar5.put("error", (Object) 2);
                H5Log.e(TAG, "you should specify whether to or not to show soft input or internal error occurred!");
                h5BridgeContext2.sendBridgeResult(eVar5);
            } else {
                boolean booleanValue = param.getBooleanValue("show");
                InputMethodManager inputMethodManager = (InputMethodManager) H5Environment.getContext().getSystemService("input_method");
                View view = this.h5WebView.getView();
                if (booleanValue) {
                    inputMethodManager.showSoftInput(view, 2);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        } else if (STOP_LOADING.equals(action)) {
            H5WebView h5WebView2 = this.h5WebView;
            if (h5WebView2 != null) {
                h5WebView2.stopLoading();
            }
        } else if (INPUT_FOCUS.equals(action)) {
            simulateAutoFocus(h5Event, h5BridgeContext);
        } else if (GET_STARTUP_PARAMS.equals(action)) {
            getStartupParams(h5Event, h5BridgeContext);
        } else if (!COOL_LOADING_CTRL.equals(action)) {
            return false;
        } else {
            if ("close".equals(H5Utils.getString(param, "action"))) {
                this.h5Page.hideLoadingView();
                h5BridgeContext.sendSuccess();
            } else {
                sendError(h5BridgeContext2, H5Event.Error.INVALID_PARAM.ordinal(), "invalid api param");
            }
        }
        return true;
    }

    private void getStartupParams(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl == null) {
            sendError(h5BridgeContext, 12, "page is null");
            return;
        }
        e jSONObject = H5Utils.toJSONObject(h5PageImpl.getParams());
        if (jSONObject == null || jSONObject.isEmpty()) {
            sendError(h5BridgeContext, 12, "params is null");
            return;
        }
        e param = h5Event.getParam();
        if (!param.containsKey("key")) {
            sendResult(h5BridgeContext, jSONObject);
            return;
        }
        b jSONArray = H5Utils.getJSONArray(param, "key", (b) null);
        if (jSONArray == null || jSONArray.isEmpty()) {
            sendError(h5BridgeContext, H5Event.Error.INVALID_PARAM.ordinal(), "invalid api param");
            return;
        }
        e eVar = new e();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            String string = jSONArray.getString(i2);
            if (jSONObject.containsKey(string)) {
                eVar.put(string, H5Utils.getValue(jSONObject, string, new Object()));
            }
        }
        sendResult(h5BridgeContext, eVar);
    }

    private void sendError(H5BridgeContext h5BridgeContext, int i2, String str) {
        if (h5BridgeContext != null) {
            h5BridgeContext.sendError(i2, str);
        }
    }

    private void sendResult(H5BridgeContext h5BridgeContext, e eVar) {
        if (h5BridgeContext != null) {
            h5BridgeContext.sendBridgeResult(eVar);
        }
    }

    private void simulateAutoFocus(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5BridgeContext h5BridgeContext2 = h5BridgeContext;
        H5WebView h5WebView2 = this.h5WebView;
        if (h5WebView2 == null) {
            H5Log.d(TAG, "inputFocus4Android h5WebView == null");
            if (h5BridgeContext2 != null) {
                h5BridgeContext2.sendBridgeResult("success", Boolean.FALSE);
                return;
            }
            return;
        }
        View view = h5WebView2.getView();
        if (view == null) {
            H5Log.d(TAG, "inputFocus4Android realWebView == null");
            if (h5BridgeContext2 != null) {
                h5BridgeContext2.sendBridgeResult("success", Boolean.FALSE);
                return;
            }
            return;
        }
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "coordinateX");
        String string2 = H5Utils.getString(param, "coordinateY");
        H5Log.d(TAG, "x " + string + ", y " + string2);
        try {
            float floatValue = Float.valueOf(string).floatValue();
            float floatValue2 = Float.valueOf(string2).floatValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis + 300;
            float f2 = floatValue2;
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, floatValue, floatValue2, 0);
            MotionEvent obtain2 = MotionEvent.obtain(j, j, 1, floatValue, f2, 0);
            view.dispatchTouchEvent(obtain);
            view.dispatchTouchEvent(obtain2);
            obtain.recycle();
            obtain2.recycle();
            if (h5BridgeContext2 != null) {
                h5BridgeContext.sendSuccess();
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            if (h5BridgeContext2 != null) {
                h5BridgeContext2.sendError(2, "invalid parameter!");
            }
        }
    }

    private void exit(boolean z) {
        if (this.h5Page != null) {
            if (H5Logger.enableStockTradeLog()) {
                H5Refer.referUrl = this.h5Page.getUrl();
            }
            if (Nebula.DEBUG) {
                H5Log.d(TAG, "h5page close, setRefer : " + H5Refer.referUrl);
            }
            if (z) {
                this.h5Page.exitTabPage();
            } else {
                this.h5Page.exitPage();
            }
            H5PageLoader.isPageClose = true;
        }
    }

    private void pageBack() {
        H5PageImpl h5PageImpl;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        boolean z2 = this.pageStatus == PageStatus.FINISHED && !this.backHandler.waiting;
        boolean z3 = currentTimeMillis - this.backHandler.lastBack > 500;
        if (!z2 || !z3) {
            z = true;
        }
        if (!(!H5Utils.isInTinyProcess() || (h5PageImpl = this.h5Page) == null || h5PageImpl.getContext() == null || this.h5Page.getContext().getContext() == null)) {
            Activity activity = (Activity) this.h5Page.getContext().getContext();
            if (this.backBehavior != BackBehavior.POP) {
                H5WebView h5WebView2 = this.h5WebView;
                if (h5WebView2 == null || !h5WebView2.canGoBack()) {
                    H5Log.d(TAG, "webview can't go back and do exit!");
                    if (Nebula.needPageKeepAlive(this.h5Page, activity)) {
                        Nebula.doKeepAlive(activity, this.h5Page.getParams());
                        return;
                    }
                }
                if (this.h5WebView.copyBackForwardList().getCurrentIndex() <= 0 && Nebula.needPageKeepAlive(this.h5Page, activity)) {
                    Nebula.doKeepAlive(activity, this.h5Page.getParams());
                    return;
                }
            } else if (Nebula.needPageKeepAlive(this.h5Page, activity)) {
                Nebula.doKeepAlive(activity, this.h5Page.getParams());
                return;
            }
        }
        if (!z) {
            H5Log.d(TAG, "send back event to bridge!");
            H5BackHandler h5BackHandler = this.backHandler;
            h5BackHandler.waiting = true;
            h5BackHandler.lastBack = currentTimeMillis;
            this.h5Bridge.sendToWeb(H5Param.DEFAULT_LONG_BACK_BEHAVIOR, (e) null, h5BackHandler);
            return;
        }
        H5Log.d(TAG, "ignore bridge, perform back!");
        performBack();
    }

    private void loadUrl(H5Event h5Event) {
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, "url");
        if (TextUtils.isEmpty(string)) {
            H5Log.w(TAG, "h5_url_isnull");
            return;
        }
        H5Trace.event("loadUrl", H5BugmeIdGenerator.getBugmeViewId(this.h5Page), "url", string);
        Nebula.getH5BugMeManager().setWebViewDebugging(string, this.h5WebView);
        H5PageImpl h5PageImpl = this.h5Page;
        if (h5PageImpl != null) {
            Bundle params = h5PageImpl.getParams();
            if (TextUtils.equals(H5Utils.getString(params, "openUrlMethod"), "POST")) {
                String string2 = H5Utils.getString(params, "openUrlPostParams");
                if (params != null) {
                    params.putString("openUrlMethod", H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD);
                    params.putString("openUrlPostParams", "");
                }
                this.h5WebView.postUrl(string, string2.getBytes());
                return;
            }
        }
        HashMap hashMap = new HashMap();
        H5HttpHeadersProvider h5HttpHeadersProvider = (H5HttpHeadersProvider) H5Utils.getProvider(H5HttpHeadersProvider.class.getName());
        if (h5HttpHeadersProvider != null) {
            hashMap.putAll(h5HttpHeadersProvider.getHeaders(string, param));
            H5Log.d(TAG, "get headers from provider: ".concat(String.valueOf(hashMap)));
        }
        if (param.containsKey(H5Param.REFERER)) {
            hashMap.put(H5Param.REFERER, param.getString(H5Param.REFERER));
        }
        if (hashMap.isEmpty()) {
            this.h5WebView.loadUrl(string);
        } else {
            this.h5WebView.loadUrl(string, hashMap);
        }
    }

    private void loadData(H5Event h5Event) {
        e param = h5Event.getParam();
        final String string = H5Utils.getString(param, "baseUrl");
        final String string2 = H5Utils.getString(param, "data");
        final String string3 = H5Utils.getString(param, ImagePickerUtils.IMAGE_PICKER_KEY_MIME_TYPE);
        final String string4 = H5Utils.getString(param, "encoding");
        final String string5 = H5Utils.getString(param, "historyUrl");
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                H5PagePlugin.this.h5WebView.loadDataWithBaseURL(string, string2, string3, string4, string5);
            }
        });
    }

    /* access modifiers changed from: private */
    public void performBack() {
        H5Log.d(TAG, "perform back behavior " + this.backBehavior);
        if (this.backBehavior == BackBehavior.POP) {
            this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
        } else if (this.backBehavior == BackBehavior.BACK) {
            H5WebView h5WebView2 = this.h5WebView;
            if (h5WebView2 == null || !h5WebView2.canGoBack()) {
                H5Log.d(TAG, "webview can't go back and do exit!");
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
            } else if (this.h5WebView.copyBackForwardList().getCurrentIndex() <= 0) {
                H5Log.d(TAG, "webview with no history and do exit!");
                this.h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_CLOSE, (e) null);
            } else {
                this.h5WebView.goBack();
            }
        }
    }

    class H5BackHandler implements H5CallBack {
        public long lastBack = 0;
        public boolean waiting = false;

        public H5BackHandler() {
        }

        public void onCallBack(e eVar) {
            this.waiting = false;
            boolean z = H5Utils.getBoolean(eVar, "prevent", false);
            H5Log.d(H5PagePlugin.TAG, "back event prevent ".concat(String.valueOf(z)));
            if (!z) {
                H5PagePlugin.this.performBack();
            }
        }
    }
}
