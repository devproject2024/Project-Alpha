package com.alipay.mobile.nebulacore.ui;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.RnService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.prerender.H5PreRenderPool;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.view.H5NavigationBar;
import com.alipay.mobile.nebulacore.web.H5ScriptLoader;
import com.alipay.mobile.nebulacore.web.H5WebView;
import java.util.List;
import java.util.Stack;

public class H5FragmentManager {
    public static final String TAG = "H5FragmentManager";
    /* access modifiers changed from: private */
    public H5Activity activity;
    private int contentId;
    private Fragment currentFragment;
    private boolean enableTranslateAnimForUser = false;
    private boolean enableTranslateAnimForVIP = false;
    private j fragmentManager;
    private Stack<Fragment> fragmentStack;

    public H5FragmentManager(H5Activity h5Activity) {
        this.activity = h5Activity;
        this.fragmentManager = h5Activity.getSupportFragmentManager();
        this.contentId = R.id.h5_fragment;
        this.fragmentStack = new Stack<>();
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableFragmentTranslateAnimation"))) {
            this.enableTranslateAnimForUser = true;
        }
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableFragmentTranslateAnimationForVIP"))) {
            this.enableTranslateAnimForVIP = true;
        }
    }

    public int getFragmentCount() {
        Stack<Fragment> stack = this.fragmentStack;
        if (stack != null) {
            return stack.size();
        }
        return 0;
    }

    public Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    public void addFragment(Bundle bundle, boolean z, boolean z2) {
        try {
            H5Log.d(TAG, "addFragment ".concat(String.valueOf(bundle)));
            int i2 = 0;
            boolean z3 = H5Utils.getBoolean(bundle, H5Param.isTinyApp, false);
            if (z3) {
                i2 = 2;
            }
            if (this.activity.canUsePreRender()) {
                H5PreRenderPool instance = H5PreRenderPool.getInstance();
                if (instance.getPreFragmentCount() > 0) {
                    bundle.putBoolean(H5Param.LONG_ISPRERENDER, true);
                }
                if (instance.containsPoolKey(bundle, i2)) {
                    H5Fragment preFragment = instance.getPreFragment(bundle, i2);
                    if (preFragment.isAdded()) {
                        H5Log.d(TAG, "##h5prerender## get prerender fragment by mode ".concat(String.valueOf(i2)));
                        bundle.remove(H5Param.LONG_ISPRERENDER);
                        Bundle arguments = preFragment.getArguments();
                        int currentIndex = instance.getCurrentIndex(preFragment);
                        H5Log.d(TAG, "##h5prerender## currentIndex ".concat(String.valueOf(currentIndex)));
                        instance.putPreFragmentBundle(arguments, Integer.valueOf(currentIndex));
                        if (z3 && TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_preRenderConfig")), "shouldUsePreRender"))) {
                            arguments.clear();
                            arguments.putAll(bundle);
                            H5Page h5Page = preFragment.getH5Page();
                            H5ViewHolder rootViewHolder = preFragment.getRootViewHolder();
                            if (!(rootViewHolder == null || h5Page == null)) {
                                H5NavigationBar h5NavBar = rootViewHolder.getH5NavBar();
                                if (h5NavBar != null) {
                                    h5NavBar.setPage(h5Page);
                                }
                                H5WebContent h5WebContainer = rootViewHolder.getH5WebContainer();
                                if (h5WebContainer != null) {
                                    h5WebContainer.refreshView();
                                }
                                rootViewHolder.refreshView();
                            }
                            if (h5Page != null) {
                                H5WebView h5WebView = (H5WebView) h5Page.getWebView();
                                h5WebView.loadUrl("javascript:location.replace('" + bundle.getString("url") + "');");
                                H5ScriptLoader scriptLoader = ((H5PageImpl) h5Page).getScriptLoader();
                                if (scriptLoader != null) {
                                    scriptLoader.setParamsToWebPage(H5ScriptLoader.startupParams, H5Utils.toJSONObject(arguments).toJSONString());
                                }
                                h5Page.getPageData().onPageStarted(bundle.getString("url"));
                                h5Page.getPageData().setCreateScenario(4);
                                if (h5WebView.getView() != null && !NebulaUtil.isShowTransAnimate(arguments)) {
                                    h5WebView.getView().setBackgroundColor(H5Utils.getInt(arguments, "backgroundColor"));
                                }
                            }
                        }
                        arguments.remove(H5Param.LONG_ISPRERENDER);
                        pushFragment(preFragment, true, bundle, false, false);
                        return;
                    }
                }
            }
            bundle.remove(H5Param.LONG_ISPRERENDER);
            H5Fragment h5Fragment = null;
            if (RnService.isRnBiz(H5Utils.getString(bundle, H5Param.LONG_BIZ_TYPE, ""))) {
                if (H5Environment.getRnService() != null) {
                    h5Fragment = new RNFragment();
                } else {
                    RNFragment.resetToH5FragmentBundle(bundle);
                }
            }
            if (h5Fragment == null) {
                h5Fragment = new H5Fragment();
            }
            h5Fragment.setArguments(bundle);
            pushFragment(h5Fragment, false, bundle, z, z2);
        } catch (Exception e2) {
            H5Log.e(TAG, "catch exception ", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addPreFragment(android.os.Bundle r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.alipay.mobile.nebulacore.ui.H5Activity r0 = r4.activity     // Catch:{ all -> 0x0073 }
            boolean r0 = r0.isFinishing()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r4)
            return
        L_0x000b:
            java.lang.String r0 = "H5FragmentManager"
            java.lang.String r1 = "addPreFragment "
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x0073 }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ all -> 0x0073 }
            com.alipay.mobile.nebulacore.prerender.H5PreRenderPool r0 = com.alipay.mobile.nebulacore.prerender.H5PreRenderPool.getInstance()     // Catch:{ all -> 0x0073 }
            boolean r6 = r0.containsPoolKey(r5, r6)     // Catch:{ all -> 0x0073 }
            if (r6 != 0) goto L_0x0071
            java.lang.String r6 = "bizType"
            java.lang.String r1 = ""
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r5, (java.lang.String) r6, (java.lang.String) r1)     // Catch:{ all -> 0x0073 }
            r1 = 0
            boolean r6 = com.alipay.mobile.h5container.service.RnService.isRnBiz(r6)     // Catch:{ all -> 0x0073 }
            if (r6 == 0) goto L_0x0042
            com.alipay.mobile.h5container.service.RnService r6 = com.alipay.mobile.nebulacore.env.H5Environment.getRnService()     // Catch:{ all -> 0x0073 }
            if (r6 == 0) goto L_0x003f
            com.alipay.mobile.nebulacore.ui.RNFragment r1 = new com.alipay.mobile.nebulacore.ui.RNFragment     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
            goto L_0x0042
        L_0x003f:
            com.alipay.mobile.nebulacore.ui.RNFragment.resetToH5FragmentBundle(r5)     // Catch:{ all -> 0x0073 }
        L_0x0042:
            if (r1 != 0) goto L_0x0049
            com.alipay.mobile.nebulacore.ui.H5Fragment r1 = new com.alipay.mobile.nebulacore.ui.H5Fragment     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
        L_0x0049:
            java.lang.String r6 = "H5FragmentManager"
            java.lang.String r2 = "##h5prerender## did addPreFragment"
            com.alipay.mobile.nebula.util.H5Log.d(r6, r2)     // Catch:{ all -> 0x0073 }
            r1.setArguments(r5)     // Catch:{ all -> 0x0073 }
            androidx.fragment.app.j r6 = r4.fragmentManager     // Catch:{ all -> 0x0073 }
            androidx.fragment.app.q r6 = r6.a()     // Catch:{ all -> 0x0073 }
            int r2 = r4.contentId     // Catch:{ all -> 0x0066 }
            androidx.fragment.app.q r2 = r6.a((int) r2, (androidx.fragment.app.Fragment) r1)     // Catch:{ all -> 0x0066 }
            r2.b((androidx.fragment.app.Fragment) r1)     // Catch:{ all -> 0x0066 }
            r6.c()     // Catch:{ all -> 0x0066 }
            goto L_0x006e
        L_0x0066:
            r6 = move-exception
            java.lang.String r2 = "H5FragmentManager"
            java.lang.String r3 = "catch fragment exception "
            com.alipay.mobile.nebula.util.H5Log.e(r2, r3, r6)     // Catch:{ all -> 0x0073 }
        L_0x006e:
            r0.putPreFragment(r5, r1)     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r4)
            return
        L_0x0073:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5FragmentManager.addPreFragment(android.os.Bundle, int):void");
    }

    public Fragment peekFragment() {
        Stack<Fragment> stack = this.fragmentStack;
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return this.fragmentStack.peek();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean pushFragment(com.alipay.mobile.nebulacore.ui.H5Fragment r16, boolean r17, android.os.Bundle r18, boolean r19, boolean r20) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            com.alipay.mobile.nebulacore.ui.H5Activity r3 = r1.activity
            boolean r3 = r3.isFinishing()
            r4 = 0
            if (r3 == 0) goto L_0x000f
            return r4
        L_0x000f:
            if (r0 == 0) goto L_0x0187
            boolean r3 = r16.isAdded()
            if (r3 == 0) goto L_0x0019
            if (r2 == 0) goto L_0x0187
        L_0x0019:
            java.util.Stack<androidx.fragment.app.Fragment> r3 = r1.fragmentStack
            boolean r3 = r3.contains(r0)
            if (r3 == 0) goto L_0x0023
            goto L_0x0187
        L_0x0023:
            java.util.Stack<androidx.fragment.app.Fragment> r3 = r1.fragmentStack
            boolean r3 = r3.isEmpty()
            r5 = 1
            if (r3 != 0) goto L_0x007a
            java.lang.String r3 = "sessionId"
            r6 = r18
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r6, (java.lang.String) r3)
            com.alipay.mobile.nebulacore.api.NebulaService r6 = com.alipay.mobile.nebulacore.Nebula.getService()
            com.alipay.mobile.h5container.api.H5Session r3 = r6.getSession(r3)
            boolean r6 = r3 instanceof com.alipay.mobile.nebulacore.core.H5SessionImpl
            r7 = 0
            if (r6 == 0) goto L_0x005a
            com.alipay.mobile.nebulacore.core.H5SessionImpl r3 = (com.alipay.mobile.nebulacore.core.H5SessionImpl) r3
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r6 = r3.getH5SessionTabManager()
            if (r6 == 0) goto L_0x005a
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r6 = r3.getH5SessionTabManager()
            com.alipay.mobile.nebulacore.ui.H5Fragment r7 = r6.getCurrentFragment()
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r3 = r3.getH5SessionTabManager()
            java.util.Map r3 = r3.getTabFragments()
            goto L_0x005b
        L_0x005a:
            r3 = r7
        L_0x005b:
            java.util.Stack<androidx.fragment.app.Fragment> r6 = r1.fragmentStack
            java.lang.Object r6 = r6.peek()
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            if (r3 == 0) goto L_0x006f
            boolean r3 = r3.containsValue(r6)
            if (r3 == 0) goto L_0x006f
            r15.detachFragment(r7, r4)
            goto L_0x007a
        L_0x006f:
            if (r19 == 0) goto L_0x0077
            if (r20 == 0) goto L_0x0077
            r15.detachFragment(r6, r5)
            goto L_0x007a
        L_0x0077:
            r15.detachFragment(r6, r4)
        L_0x007a:
            java.util.Stack<androidx.fragment.app.Fragment> r3 = r1.fragmentStack
            boolean r3 = r3.contains(r0)
            if (r3 != 0) goto L_0x0087
            java.util.Stack<androidx.fragment.app.Fragment> r3 = r1.fragmentStack
            r3.push(r0)
        L_0x0087:
            androidx.fragment.app.j r3 = r1.fragmentManager
            androidx.fragment.app.q r3 = r3.a()
            com.alipay.mobile.nebulacore.ui.H5Activity r6 = r1.activity
            boolean r6 = r6.canUsePreRender()
            if (r6 == 0) goto L_0x00a5
            com.alipay.mobile.nebulacore.prerender.H5PreRenderPool r6 = com.alipay.mobile.nebulacore.prerender.H5PreRenderPool.getInstance()
            android.os.Bundle r7 = r16.getArguments()
            boolean r6 = r6.containsPoolKey(r7, r5)
            if (r6 == 0) goto L_0x00a5
            r6 = 1
            goto L_0x00a6
        L_0x00a5:
            r6 = 0
        L_0x00a6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "preRender:"
            r7.<init>(r8)
            r7.append(r2)
            java.lang.String r8 = " isAdded():"
            r7.append(r8)
            boolean r8 = r16.isAdded()
            r7.append(r8)
            java.lang.String r8 = " isContainKey:"
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "H5FragmentManager"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r7)
            if (r6 == 0) goto L_0x014d
            if (r2 == 0) goto L_0x014d
            com.alipay.mobile.nebulacore.ui.H5Activity r2 = r1.activity
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x00da
            return r4
        L_0x00da:
            com.alipay.mobile.h5container.api.H5Page r2 = r16.getH5Page()
            if (r2 == 0) goto L_0x00eb
            com.alipay.mobile.h5container.api.H5PageData r6 = r2.getPageData()
            long r9 = java.lang.System.currentTimeMillis()
            r6.setContainerVisible(r9)
        L_0x00eb:
            if (r19 == 0) goto L_0x00f4
            int r6 = com.alipay.mobile.nebulacore.R.anim.h5_tabswitch_in
            int r7 = com.alipay.mobile.nebulacore.R.anim.h5_tabswitch_out
            r3.a((int) r6, (int) r7)
        L_0x00f4:
            r16.setTabbarVisible()
            androidx.fragment.app.q r3 = r3.c(r0)
            r3.c()
            r1.currentFragment = r0
            com.alipay.mobile.nebulacore.prerender.H5PreRenderPool r3 = com.alipay.mobile.nebulacore.prerender.H5PreRenderPool.getInstance()
            android.os.Bundle r6 = r16.getArguments()
            r3.removeFragment(r6)
            if (r2 == 0) goto L_0x0117
            java.lang.String r3 = "injectPageReady when prerender window present"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r3)
            com.alipay.mobile.nebulacore.core.H5PageImpl r2 = (com.alipay.mobile.nebulacore.core.H5PageImpl) r2
            r2.injectPageReady()
        L_0x0117:
            android.os.Bundle r2 = r16.getArguments()
            java.lang.String r3 = "isTinyApp"
            boolean r2 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r2, (java.lang.String) r3, (boolean) r4)
            if (r2 == 0) goto L_0x0147
            r10 = 0
            r11 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = android.os.Build.MANUFACTURER
            r2.append(r3)
            java.lang.String r3 = android.os.Build.MODEL
            r2.append(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r2.append(r3)
            java.lang.String r12 = r2.toString()
            r13 = 0
            r14 = 0
            java.lang.String r9 = "H5_PRERENDER_BINGO"
            com.alipay.mobile.nebulacore.wallet.H5Logger.performanceLogger(r9, r10, r11, r12, r13, r14)
            r15.postPreRenderRunnable(r16)
        L_0x0147:
            java.lang.String r0 = " preRender hit show."
            com.alipay.mobile.nebula.util.H5Log.d(r8, r0)
            goto L_0x0186
        L_0x014d:
            com.alipay.mobile.nebulacore.ui.H5Activity r2 = r1.activity
            boolean r2 = r2.isFinishing()
            if (r2 == 0) goto L_0x0156
            return r4
        L_0x0156:
            java.lang.String r2 = " add fragment"
            com.alipay.mobile.nebula.util.H5Log.d(r8, r2)
            if (r19 == 0) goto L_0x0174
            if (r20 == 0) goto L_0x016d
            java.lang.String r2 = "fragment use translate anim."
            com.alipay.mobile.nebula.util.H5Log.d(r8, r2)     // Catch:{ all -> 0x0180 }
            r0.setUseTranslateAnim(r5)     // Catch:{ all -> 0x0180 }
            int r2 = com.alipay.mobile.nebulacore.R.anim.h5_translate_in_left     // Catch:{ all -> 0x0180 }
            r3.a((int) r2, (int) r4)     // Catch:{ all -> 0x0180 }
            goto L_0x0174
        L_0x016d:
            int r2 = com.alipay.mobile.nebulacore.R.anim.h5_tabswitch_in     // Catch:{ all -> 0x0180 }
            int r4 = com.alipay.mobile.nebulacore.R.anim.h5_tabswitch_out     // Catch:{ all -> 0x0180 }
            r3.a((int) r2, (int) r4)     // Catch:{ all -> 0x0180 }
        L_0x0174:
            int r2 = r1.contentId     // Catch:{ all -> 0x0180 }
            androidx.fragment.app.q r2 = r3.a((int) r2, (androidx.fragment.app.Fragment) r0)     // Catch:{ all -> 0x0180 }
            r2.c()     // Catch:{ all -> 0x0180 }
            r1.currentFragment = r0     // Catch:{ all -> 0x0180 }
            goto L_0x0186
        L_0x0180:
            r0 = move-exception
            java.lang.String r2 = "catch fragment exception "
            com.alipay.mobile.nebula.util.H5Log.e(r8, r2, r0)
        L_0x0186:
            return r5
        L_0x0187:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5FragmentManager.pushFragment(com.alipay.mobile.nebulacore.ui.H5Fragment, boolean, android.os.Bundle, boolean, boolean):boolean");
    }

    private void postPreRenderRunnable(final H5Fragment h5Fragment) {
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                if (H5FragmentManager.this.activity == null || H5FragmentManager.this.activity.isFinishing()) {
                    H5Log.d(H5FragmentManager.TAG, "isFinishing");
                } else if (H5FragmentManager.this.activity == null || H5FragmentManager.this.activity.isBetweenResumePause()) {
                    e parseObject = H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_preRenderConfig"));
                    b jSONArray = H5Utils.getJSONArray(parseObject, "appBlackList4Android", (b) null);
                    b jSONArray2 = H5Utils.getJSONArray(parseObject, "appForceWhiteList4Android", (b) null);
                    String string = H5Utils.getString(h5Fragment.getArguments(), "appId");
                    if (jSONArray == null || !jSONArray.contains(string)) {
                        Uri parseUrl = H5UrlHelper.parseUrl(H5Utils.getString(h5Fragment.getArguments(), "url"));
                        if (parseUrl != null) {
                            String encodedFragment = parseUrl.getEncodedFragment();
                            H5Log.d(H5FragmentManager.TAG, "##h5prerender## fragmentPart ".concat(String.valueOf(encodedFragment)));
                            if ((jSONArray2 == null || (jSONArray2 != null && !jSONArray2.contains(string))) && TextUtils.isEmpty(encodedFragment)) {
                                H5Log.d(H5FragmentManager.TAG, "##h5prerender## disable nodsl");
                                return;
                            }
                        }
                        if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(parseObject, "shouldUsePreRender")) && H5PreRenderPool.getInstance().getPreFragmentCount() == 0) {
                            String h5PreRenderPage = H5StartParamManager.getInstance().getH5PreRenderPage(string);
                            H5Log.d(H5FragmentManager.TAG, "##h5prerender## get urlSuffix from appConfig.json ".concat(String.valueOf(h5PreRenderPage)));
                            if (TextUtils.isEmpty(h5PreRenderPage)) {
                                h5PreRenderPage = H5Utils.getString(parseObject, "prerenderPage");
                                H5Log.d(H5FragmentManager.TAG, "##h5prerender## get urlSuffix from online config ".concat(String.valueOf(h5PreRenderPage)));
                            }
                            if (!TextUtils.isEmpty(h5PreRenderPage)) {
                                Bundle bundle = (Bundle) h5Fragment.getArguments().clone();
                                if (h5PreRenderPage.startsWith("/")) {
                                    h5PreRenderPage = h5PreRenderPage.substring(1);
                                }
                                bundle.putString("url", H5Utils.getString(h5Fragment.getArguments(), H5Param.ONLINE_HOST) + h5PreRenderPage);
                                bundle.putBoolean(H5Param.LONG_ISPRERENDER, true);
                                bundle.remove(H5Fragment.fragmentType);
                                if (!H5PreRenderPool.getInstance().containsPoolKey(bundle, 2)) {
                                    H5Log.d(H5FragmentManager.TAG, "##h5prerender## add prerender in tiny no first time");
                                    H5FragmentManager.this.addPreFragment(bundle, 2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    H5Log.d(H5FragmentManager.TAG, "##h5prerender## disable by appBlackList4Android");
                } else {
                    H5Log.d(H5FragmentManager.TAG, "##h5prerender## cannot use prerender");
                }
            }
        }, 3000);
    }

    public boolean attachFragment(Fragment fragment, boolean z, boolean z2) {
        if (this.activity.isFinishing()) {
            H5Log.d(TAG, "activity is finishing");
            return false;
        } else if (fragment == null || fragment.isVisible()) {
            return false;
        } else {
            printTrack("attachFragment");
            q a2 = this.fragmentManager.a();
            if (z) {
                if (z2) {
                    a2.a(R.anim.h5_translate_in_right, 0);
                } else {
                    a2.a(R.anim.h5_tabswitch_in, R.anim.h5_tabswitch_out);
                }
            }
            a2.f(fragment).c();
            this.currentFragment = fragment;
            return true;
        }
    }

    public boolean detachFragment(final Fragment fragment, boolean z) {
        if (this.activity.isFinishing()) {
            H5Log.d(TAG, "activity is finishing");
            return false;
        } else if (fragment == null || fragment.isHidden()) {
            return false;
        } else {
            printTrack("detachFragment");
            final q a2 = this.fragmentManager.a();
            if (H5Utils.getBoolean(fragment.getArguments(), H5Param.LONG_DELAY_RENDER, false)) {
                H5Utils.runOnMain(new Runnable() {
                    public void run() {
                        if (fragment.getActivity() == null || !fragment.getActivity().isFinishing()) {
                            a2.d(fragment).c();
                        }
                    }
                }, 600);
                return true;
            }
            if (z) {
                try {
                    a2.a(0, R.anim.h5_translate_out_left);
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                    return true;
                }
            }
            a2.d(fragment).c();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeFragment(com.alipay.mobile.nebulacore.ui.H5Fragment r6, android.os.Bundle r7, boolean r8) {
        /*
            r5 = this;
            com.alipay.mobile.nebulacore.ui.H5Activity r0 = r5.activity
            boolean r0 = r0.isFinishing()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.lang.String r6 = "H5FragmentManager"
            java.lang.String r7 = "activity is finishing"
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)
            return r1
        L_0x0011:
            if (r6 != 0) goto L_0x0014
            return r1
        L_0x0014:
            com.alipay.mobile.nebulacore.ui.H5Activity r0 = r5.activity
            boolean r0 = r0.canUsePreRender()
            r2 = 1
            if (r0 == 0) goto L_0x0034
            java.util.Stack<androidx.fragment.app.Fragment> r0 = r5.fragmentStack
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0034
            com.alipay.mobile.nebulacore.prerender.H5PreRenderPool r0 = com.alipay.mobile.nebulacore.prerender.H5PreRenderPool.getInstance()
            android.os.Bundle r3 = r6.getArguments()
            boolean r0 = r0.containsPoolKey(r3, r2)
            if (r0 != 0) goto L_0x0034
            return r1
        L_0x0034:
            java.lang.String r0 = "sessionId"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r7, (java.lang.String) r0)
            com.alipay.mobile.nebulacore.api.NebulaService r0 = com.alipay.mobile.nebulacore.Nebula.getService()
            com.alipay.mobile.h5container.api.H5Session r7 = r0.getSession(r7)
            boolean r0 = r7 instanceof com.alipay.mobile.nebulacore.core.H5SessionImpl
            r3 = 0
            if (r0 == 0) goto L_0x0072
            com.alipay.mobile.nebulacore.core.H5SessionImpl r7 = (com.alipay.mobile.nebulacore.core.H5SessionImpl) r7
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r0 = r7.getH5SessionTabManager()
            if (r0 == 0) goto L_0x0072
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r0 = r7.getH5SessionTabManager()
            int r0 = r0.countTabFragments()
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r3 = r7.getH5SessionTabManager()
            com.alipay.mobile.nebulacore.ui.H5Fragment r3 = r3.getCurrentFragment()
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabManager r7 = r7.getH5SessionTabManager()
            java.util.Map r7 = r7.getTabFragments()
            java.util.Stack<androidx.fragment.app.Fragment> r4 = r5.fragmentStack
            int r4 = r4.size()
            if (r4 != r0) goto L_0x0073
            if (r8 != 0) goto L_0x0073
            return r1
        L_0x0072:
            r7 = r3
        L_0x0073:
            java.util.Stack<androidx.fragment.app.Fragment> r0 = r5.fragmentStack
            int r0 = r0.size()
            if (r0 > r2) goto L_0x007c
            return r1
        L_0x007c:
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            if (r0 == 0) goto L_0x008d
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x008d
            return r2
        L_0x008d:
            java.util.Stack<androidx.fragment.app.Fragment> r0 = r5.fragmentStack
            java.lang.Object r0 = r0.peek()
            if (r6 != r0) goto L_0x0097
            r0 = 1
            goto L_0x0098
        L_0x0097:
            r0 = 0
        L_0x0098:
            if (r7 == 0) goto L_0x00a2
            boolean r4 = r7.containsValue(r6)
            if (r4 == 0) goto L_0x00a2
            if (r8 == 0) goto L_0x00bf
        L_0x00a2:
            androidx.fragment.app.j r8 = r5.fragmentManager
            androidx.fragment.app.q r8 = r8.a()
            boolean r4 = r6.isUseTranslateAnim()
            if (r4 == 0) goto L_0x00b3
            int r4 = com.alipay.mobile.nebulacore.R.anim.h5_translate_out_right
            r8.a((int) r1, (int) r4)
        L_0x00b3:
            androidx.fragment.app.q r8 = r8.a((androidx.fragment.app.Fragment) r6)
            r8.c()
            java.util.Stack<androidx.fragment.app.Fragment> r8 = r5.fragmentStack
            r8.remove(r6)
        L_0x00bf:
            if (r0 == 0) goto L_0x00ea
            java.util.Stack<androidx.fragment.app.Fragment> r8 = r5.fragmentStack
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00ea
            java.util.Stack<androidx.fragment.app.Fragment> r8 = r5.fragmentStack
            java.lang.Object r8 = r8.peek()
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            if (r7 == 0) goto L_0x00dd
            boolean r7 = r7.containsValue(r8)
            if (r7 == 0) goto L_0x00dd
            r5.attachFragment(r3, r1, r1)
            goto L_0x00ea
        L_0x00dd:
            boolean r6 = r6.isUseTranslateAnim()
            if (r6 == 0) goto L_0x00e7
            r5.attachFragment(r8, r2, r2)
            goto L_0x00ea
        L_0x00e7:
            r5.attachFragment(r8, r1, r1)
        L_0x00ea:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5FragmentManager.removeFragment(com.alipay.mobile.nebulacore.ui.H5Fragment, android.os.Bundle, boolean):boolean");
    }

    public void clearPreFragment(int i2, int i3) {
        H5PreRenderPool instance = H5PreRenderPool.getInstance();
        H5Log.d(TAG, "clearPreFragment location " + i2 + ", length " + i3);
        List<H5Fragment> preFragmentList = instance.getPreFragmentList();
        List<e> preParamContentList = instance.getPreParamContentList();
        List<String> preUrlList = instance.getPreUrlList();
        for (int i4 = i2; i4 <= i3; i4++) {
            int size = preFragmentList.size();
            int size2 = preParamContentList.size();
            int size3 = preUrlList.size();
            if (i2 >= 0 && i2 < size) {
                detachFragment(preFragmentList.get(i2), false);
                preFragmentList.remove(i2);
            }
            if (i2 >= 0 && i2 < size2) {
                preParamContentList.remove(i2);
            }
            if (i2 >= 0 && i2 < size3) {
                preUrlList.remove(i2);
            }
        }
    }

    private void printTrack(String str) {
        try {
            throw new Exception("print calling stack(not crash): " + toString());
        } catch (Exception e2) {
            H5Log.w(TAG, str + " track ", e2);
        }
    }

    public boolean getEnableTranslateAnimForUser() {
        return this.enableTranslateAnimForUser;
    }

    public boolean getEnableTranslateAnimForVIP() {
        return this.enableTranslateAnimForVIP;
    }
}
