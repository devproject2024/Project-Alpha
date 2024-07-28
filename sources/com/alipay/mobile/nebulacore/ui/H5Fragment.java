package com.alipay.mobile.nebulacore.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BaseFragment;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5PageFactoryImpl;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.prerender.H5PreRenderPool;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import com.alipay.mobile.nebulacore.web.H5WebView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Stack;

public class H5Fragment extends Fragment implements H5BaseFragment {
    private static final String TAG = "H5Fragment";
    public static final String fragmentType = "fragmentType";
    public static final String normal = "normal";
    public static final String subtab = "subtab";
    /* access modifiers changed from: private */
    public WeakReference<H5Activity> activity;
    protected H5WebView h5WebView;
    private boolean hasPreRender = false;
    private boolean isCallbackResumed = false;
    private boolean isRunning = false;
    private View rootView;
    protected H5ViewHolder rootViewHolder;
    private boolean useTranslateAnim = false;

    public void onAttach(Activity activity2) {
        super.onAttach(activity2);
        H5Log.d(TAG, "onAttach ".concat(String.valueOf(this)));
        this.activity = new WeakReference<>((H5Activity) activity2);
    }

    public void onDetach() {
        super.onDetach();
        H5Log.d(TAG, "onDetach ".concat(String.valueOf(this)));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H5Log.d(TAG, "onCreate ".concat(String.valueOf(this)));
        if (H5PageLoader.sServiceStart == 0) {
            H5PageLoader.sServiceStart = System.currentTimeMillis();
        }
    }

    private View generateRootView() {
        H5FragmentRootView h5FragmentRootView = new H5FragmentRootView(getActivity());
        h5FragmentRootView.init(getActivity(), getArguments());
        h5FragmentRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        h5FragmentRootView.setBackgroundColor(getResources().getColor(R.color.h5_transparent));
        return h5FragmentRootView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        H5Page.H5TitleBarReadyCallback titleBarReadyCallBack;
        H5Log.d(TAG, "onCreateView ".concat(String.valueOf(this)));
        try {
            if (this.rootView == null) {
                this.rootView = generateRootView();
                H5PageFactoryImpl h5PageFactoryImpl = new H5PageFactoryImpl((Activity) this.activity.get());
                Bundle arguments = getArguments();
                if (((H5Activity) this.activity.get()).isFinishing()) {
                    H5Log.e(TAG, "activity is finish");
                    return null;
                }
                this.rootViewHolder = h5PageFactoryImpl.createPage((Activity) this.activity.get(), arguments);
                NebulaUtil.parseNoAlphaColor(arguments);
                this.rootViewHolder.setRootView((ViewGroup) this.rootView);
                this.rootViewHolder.getH5Page().setH5Fragment(this);
                this.rootViewHolder.getH5Page().setRootView(this.rootView);
                this.rootViewHolder.getH5Page().applyParams();
                applyParams(arguments);
                this.h5WebView = this.rootViewHolder.getH5Page().getWebView();
                if (this.h5WebView == null) {
                    return null;
                }
                if (this.h5WebView.getView() != null && !NebulaUtil.isShowTransAnimate(arguments)) {
                    this.h5WebView.getView().setBackgroundColor(H5Utils.getInt(arguments, "backgroundColor"));
                }
                H5PageData.walletServiceStart = System.currentTimeMillis();
                this.rootViewHolder.refreshView();
                if (!(this.rootViewHolder.getH5Page() == null || (titleBarReadyCallBack = this.rootViewHolder.getH5Page().getTitleBarReadyCallBack()) == null)) {
                    titleBarReadyCallBack.onCreate();
                }
            } else {
                ViewParent parent = this.rootView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeAllViews();
                }
            }
            return this.rootView;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    private void postPreRenderRunnable() {
        if (this.hasPreRender) {
            H5Log.d(TAG, "hasPreRender not to postPreRenderRunnable");
            return;
        }
        boolean z = true;
        this.hasPreRender = true;
        if (H5Utils.getBoolean(getArguments(), H5Param.isTinyApp, false)) {
            final AnonymousClass1 r1 = new Runnable() {
                public void run() {
                    if (H5Fragment.this.getActivity() == null || H5Fragment.this.getActivity().isFinishing()) {
                        H5Log.d(H5Fragment.TAG, "isFinishing" + H5Fragment.this);
                    } else if (H5Fragment.this.activity.get() == null || ((H5Activity) H5Fragment.this.activity.get()).isBetweenResumePause()) {
                        e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_preRenderConfig"));
                        b jSONArray = H5Utils.getJSONArray(parseObject, "appBlackList4Android", (b) null);
                        b jSONArray2 = H5Utils.getJSONArray(parseObject, "appForceWhiteList4Android", (b) null);
                        String string = H5Utils.getString(H5Fragment.this.getArguments(), "appId");
                        if (jSONArray == null || !jSONArray.contains(string)) {
                            Uri parseUrl = H5UrlHelper.parseUrl(H5Utils.getString(H5Fragment.this.getArguments(), "url"));
                            if (parseUrl != null) {
                                String encodedFragment = parseUrl.getEncodedFragment();
                                H5Log.d(H5Fragment.TAG, parseUrl + " ##h5prerender## fragmentPart " + encodedFragment);
                                if ((jSONArray2 == null || (jSONArray2 != null && !jSONArray2.contains(string))) && TextUtils.isEmpty(encodedFragment)) {
                                    H5Log.d(H5Fragment.TAG, "##h5prerender## disable nodsl");
                                    return;
                                }
                            }
                            H5Session session = Nebula.getService().getSession(H5Utils.getString(H5Fragment.this.getArguments(), H5Param.SESSION_ID));
                            if (session != null) {
                                String serviceWorkerID = session.getServiceWorkerID();
                                H5Log.d(H5Fragment.TAG, "workId ".concat(String.valueOf(serviceWorkerID)));
                                if (TextUtils.isEmpty(serviceWorkerID)) {
                                    return;
                                }
                            }
                            if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(parseObject, "shouldUsePreRender")) && H5PreRenderPool.getInstance().getPreFragmentCount() == 0) {
                                String h5PreRenderPage = H5StartParamManager.getInstance().getH5PreRenderPage(string);
                                H5Log.d(H5Fragment.TAG, "##h5prerender## get urlSuffix from appConfig.json ".concat(String.valueOf(h5PreRenderPage)));
                                if (TextUtils.isEmpty(h5PreRenderPage)) {
                                    h5PreRenderPage = H5Utils.getString(parseObject, "prerenderPage");
                                    H5Log.d(H5Fragment.TAG, "##h5prerender## get urlSuffix from online config ".concat(String.valueOf(h5PreRenderPage)));
                                }
                                if (!TextUtils.isEmpty(h5PreRenderPage)) {
                                    Bundle bundle = (Bundle) H5Fragment.this.getArguments().clone();
                                    if (h5PreRenderPage.startsWith("/")) {
                                        h5PreRenderPage = h5PreRenderPage.substring(1);
                                    }
                                    bundle.putString("url", H5Utils.getString(H5Fragment.this.getArguments(), H5Param.ONLINE_HOST) + h5PreRenderPage);
                                    bundle.putBoolean(H5Param.LONG_ISPRERENDER, true);
                                    bundle.remove(H5Fragment.fragmentType);
                                    if (!H5PreRenderPool.getInstance().containsPoolKey(bundle, 2)) {
                                        H5Log.d(H5Fragment.TAG, "##h5prerender## add prerender in tiny first time");
                                        ((H5Activity) H5Fragment.this.getActivity()).getH5FragmentManager().addPreFragment(bundle, 2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        H5Log.d(H5Fragment.TAG, "##h5prerender## disable by appBlackList4Android");
                    } else {
                        H5Log.d(H5Fragment.TAG, "##h5prerender## cannot use prerender " + H5Fragment.this);
                    }
                }
            };
            e parseObject = H5Utils.parseObject(H5Environment.getConfig("h5_addIdleHandler"));
            final int i2 = 3000;
            if (parseObject != null && parseObject.isEmpty()) {
                z = H5Utils.getBoolean(parseObject, "useIdle", true);
                i2 = H5Utils.getInt(parseObject, "time", 3000);
            }
            if (!z) {
                H5Utils.runOnMain(r1, (long) i2);
            } else {
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        H5Log.d(H5Fragment.TAG, "runOnMain " + i2);
                        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                            public boolean queueIdle() {
                                H5Log.d(H5Fragment.TAG, "queueIdle");
                                r1.run();
                                return false;
                            }
                        });
                    }
                }, (long) i2);
            }
        }
    }

    public void onResume() {
        super.onResume();
        H5Log.d(TAG, "onResume ".concat(String.valueOf(this)));
        try {
            Nebula.getService().getWebDriverHelper().onWebViewCreated(this.h5WebView);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        H5ViewHolder h5ViewHolder = this.rootViewHolder;
        if (h5ViewHolder != null && h5ViewHolder.getH5Page() != null) {
            H5PageImpl h5Page = this.rootViewHolder.getH5Page();
            if (H5Utils.getBoolean(h5Page.getParams(), H5Param.LONG_FULLSCREEN, false) && !this.isCallbackResumed) {
                h5Page.sendEvent(H5Plugin.InternalEvents.H5_PAGE_RESUME, (e) null);
            }
        }
    }

    public void onPause() {
        super.onPause();
        H5Log.d(TAG, "onPause ".concat(String.valueOf(this)));
        this.isCallbackResumed = false;
    }

    public void onStart() {
        H5WebView h5WebView2;
        super.onStart();
        H5Log.d(TAG, "onStart ".concat(String.valueOf(this)));
        this.isCallbackResumed = true;
        if (Build.VERSION.SDK_INT >= 11 && (h5WebView2 = this.h5WebView) != null) {
            try {
                h5WebView2.onResume();
            } catch (Throwable th) {
                H5Log.e(TAG, "webview onResume exception.", th);
            }
        }
        if (!this.isRunning) {
            this.isRunning = true;
        } else {
            H5ViewHolder h5ViewHolder = this.rootViewHolder;
            if (!(h5ViewHolder == null || h5ViewHolder.getH5Page() == null)) {
                this.rootViewHolder.getH5Page().sendEvent(H5Plugin.InternalEvents.H5_PAGE_RESUME, (e) null);
            }
        }
        setTabbarVisible();
    }

    public void setTabbarVisible() {
        H5Session topSession;
        boolean z = H5Utils.getBoolean(getArguments(), H5Param.LONG_ISPRERENDER, false);
        H5ViewHolder h5ViewHolder = this.rootViewHolder;
        if (h5ViewHolder != null && h5ViewHolder.getH5Page() != null && !z && (topSession = Nebula.getService().getTopSession()) != null) {
            Stack stack = (Stack) topSession.getPages().clone();
            H5PageImpl h5Page = this.rootViewHolder.getH5Page();
            if (h5Page == null) {
                return;
            }
            if (TextUtils.equals(H5Utils.getString(h5Page.getParams(), fragmentType, "normal"), subtab)) {
                ((H5Activity) this.activity.get()).getSessionTabContainer().setVisibility(0);
                Iterator it2 = stack.iterator();
                while (it2.hasNext()) {
                    H5Page h5Page2 = (H5Page) it2.next();
                    if ((h5Page2 == null || !h5Page2.equals(h5Page)) && h5Page2 != null) {
                        Bundle params = h5Page2.getParams();
                        if (!TextUtils.equals(H5Utils.getString(params, fragmentType, "normal"), subtab) && !H5Utils.getBoolean(params, H5Param.LONG_ISPRERENDER, false)) {
                            h5Page2.exitPage();
                        }
                    }
                }
            } else if (((H5Activity) this.activity.get()).isTabContainerVisible()) {
                ((H5Activity) this.activity.get()).getSessionTabContainer().setVisibility(8);
            }
        }
    }

    public void onStop() {
        H5WebView h5WebView2;
        super.onStop();
        H5Log.d(TAG, "onStop ".concat(String.valueOf(this)));
        if (Build.VERSION.SDK_INT >= 11 && (h5WebView2 = this.h5WebView) != null) {
            try {
                h5WebView2.onPause();
            } catch (Throwable th) {
                H5Log.e(TAG, "webview onPause exception.", th);
            }
        }
        H5ViewHolder h5ViewHolder = this.rootViewHolder;
        if (h5ViewHolder != null && h5ViewHolder.getH5Page() != null) {
            this.rootViewHolder.getH5Page().sendEvent(H5Plugin.InternalEvents.H5_PAGE_PAUSE, (e) null);
        }
    }

    private void applyParams(Bundle bundle) {
        String str;
        if (TextUtils.isEmpty(H5Utils.getString(bundle, "url"))) {
            this.rootViewHolder.getH5Page().sendEvent(H5Plugin.CommonEvents.H5_AL_SESSION_ENTRY_ERROR, (e) null);
        }
        for (String str2 : bundle.keySet()) {
            e eVar = new e();
            if ("showFavorites".equals(str2)) {
                if (H5Utils.getBoolean(bundle, str2, false)) {
                    str = "showFavorites";
                } else {
                    str = H5Plugin.InternalEvents.HIDE_FAVORITES;
                }
            } else if (H5Param.LONG_TOOLBAR_MENU.equals(str2)) {
                eVar = H5Utils.parseObject(H5Utils.getString(bundle, str2));
                str = H5Plugin.CommonEvents.SET_TOOL_MENU;
            } else if (!"prefetchLocation".equals(str2) || !H5Utils.getBoolean(bundle, str2, false)) {
                str = null;
            } else {
                str = "prefetchLocation";
            }
            if (!TextUtils.isEmpty(str)) {
                this.rootViewHolder.getH5Page().sendEvent(str, eVar);
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        H5ViewHolder h5ViewHolder;
        if (!(keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) || (h5ViewHolder = this.rootViewHolder) == null || h5ViewHolder.getH5Page() == null) {
            return false;
        }
        H5WebChromeClient webChromeClient = this.rootViewHolder.getH5Page().getWebChromeClient();
        if (webChromeClient == null || webChromeClient.mCustomViewCallback == null) {
            H5Log.d(TAG, "onKeyDown H5_PAGE_PHYSICAL_BACK");
            this.rootViewHolder.getH5Page().sendEvent(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK, (e) null);
        } else {
            try {
                webChromeClient.mCustomViewCallback.onCustomViewHidden();
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.isRunning) {
            this.isRunning = false;
            H5Log.d(TAG, "onDestroy ".concat(String.valueOf(this)));
            H5PageImpl h5Page = this.rootViewHolder.getH5Page();
            if (h5Page != null) {
                h5Page.doExitPage(false);
            }
            this.rootView = null;
            this.rootViewHolder = null;
            this.h5WebView = null;
        }
    }

    public void onDestroyView() {
        H5Log.d(TAG, "onDestroyView ".concat(String.valueOf(this)));
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        H5Log.d(TAG, "onSaveInstanceState ".concat(String.valueOf(this)));
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        H5Log.d(TAG, "onViewStateRestored ".concat(String.valueOf(this)));
        super.onViewStateRestored(bundle);
    }

    public H5Page getH5Page() {
        H5ViewHolder h5ViewHolder = this.rootViewHolder;
        if (h5ViewHolder != null) {
            return h5ViewHolder.getH5Page();
        }
        return null;
    }

    public H5ViewHolder getRootViewHolder() {
        return this.rootViewHolder;
    }

    public void setUseTranslateAnim(boolean z) {
        this.useTranslateAnim = z;
    }

    public boolean isUseTranslateAnim() {
        return this.useTranslateAnim;
    }

    public void onPageFinish() {
        H5Log.d(TAG, "onPageFinish");
        postPreRenderRunnable();
    }
}
