package com.alipay.mobile.nebulacore.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import com.alibaba.a.e;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.loading.LoadingView;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5LoadingView;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.nebula.activity.H5ActivityResultManager;
import com.alipay.mobile.nebula.activity.H5BaseActivity;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LoadingViewProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebula.view.ManagerToastLikeDialog;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.data.H5ParamHolder;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.env.H5WebViewChoose;
import com.alipay.mobile.nebulacore.prerender.H5PreRenderPool;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabBar;
import com.alipay.mobile.nebulacore.tabbar.H5SessionTabInfoParser;
import com.alipay.mobile.nebulacore.util.H5AnimatorUtil;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.alipay.mobile.nebulacore.wallet.H5LoggerPlugin;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.util.Map;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public class H5Activity extends H5BaseActivity {
    public static final int FILE_CHOOSER_REQUEST_CODE = 1;
    private static final String SAVED_INSTANCE_STATE_KEY = "savedInstanceStateKey";
    public static final String TAG = "H5Activity";
    private String appPause = "appPause";
    /* access modifiers changed from: private */
    public H5FragmentManager fragmentManager;
    private H5LoadingDialog fullScreenLoading;
    private H5LoadingViewProvider h5LoadingViewProvider;
    /* access modifiers changed from: private */
    public H5SessionImpl h5Session;
    private boolean hasSaveData = false;
    private boolean hasSendResumeFromOnNewIntent = false;
    private boolean hasShowTab = false;
    private boolean isBetweenResumePause = false;
    private boolean isResumeFirst = true;
    private boolean openPreRenderByPlugin = false;
    private H5ParamHolder.PageParamListener pageParamListener = null;
    private BroadcastReceiver receiver = null;
    private RelativeLayout sessionTabContainer;
    private boolean showLoading = true;
    /* access modifiers changed from: private */
    public Bundle startParams = null;

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        H5Log.d(TAG, "requestCode " + i2 + " resultCode:" + i3 + " " + intent);
        H5ActivityResultManager.getInstance().sendResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        e parseObject;
        super.onCreate(bundle);
        H5Log.d(TAG, "onCreate ".concat(String.valueOf(this)));
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable th) {
            H5Log.e(TAG, "Exception", th);
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        if (!(bundle == null || (parseObject = H5Utils.parseObject(H5Utils.getString(bundle, (String) SAVED_INSTANCE_STATE_KEY))) == null || parseObject.isEmpty())) {
            H5Log.d(TAG, " savedInstanceState ".concat(String.valueOf(parseObject)));
            this.startParams = H5Utils.toBundle(parseObject);
            this.hasSaveData = true;
            if (H5Utils.isMainProcess()) {
                finish();
                return;
            }
        }
        String string = H5Utils.getString(extras, H5Param.SNAPSHOT);
        try {
            z = H5Utils.getBoolean(extras, H5Param.LONG_FULLSCREEN, false);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            z = false;
        }
        if (!TextUtils.isEmpty(string) && "no".equalsIgnoreCase(string)) {
            H5Log.d(TAG, "snapshot ".concat(String.valueOf(string)));
            getWindow().addFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        requestWindowFeature(1);
        if (z) {
            getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        }
        H5Environment.setContext(this);
        H5Log.d(TAG, "h5_activity " + getResources());
        setContentView(R.layout.h5_activity);
        boolean z2 = H5Utils.getBoolean(extras, "showLoadingView", false);
        if (!z2 && !z) {
            try {
                showLoadingView(H5Utils.getString(extras, H5Param.LONG_WALLET_APP_NAME), H5Utils.getString(extras, H5Param.LONG_WALLET_APP_ICON));
            } catch (Throwable th2) {
                H5Log.e(TAG, th2);
            }
        }
        if (!H5WebViewChoose.notNeedInitUc(this.startParams) && (z2 || z)) {
            addFullView();
        }
        if (Nebula.getService().getTopSession() instanceof H5SessionImpl) {
            this.h5Session = (H5SessionImpl) Nebula.getService().getTopSession();
        }
        String string2 = H5Utils.getString(extras, "appId");
        Nebula.initInfo(string2, this);
        try {
            Nebula.setWindowSoftInputMode(this, string2, extras, z2);
        } catch (Exception e3) {
            H5Log.e(TAG, (Throwable) e3);
        }
    }

    public H5Session getH5Session() {
        return this.h5Session;
    }

    private synchronized void showLoadingView(String str, String str2) {
        if (this.showLoading) {
            this.showLoading = false;
            H5Log.d(TAG, "show loading view.");
            this.h5LoadingViewProvider = (H5LoadingViewProvider) H5Utils.getProvider(H5LoadingViewProvider.class.getName());
            if (this.h5LoadingViewProvider == null) {
                this.h5LoadingViewProvider = new H5LoadingView();
            }
            View contentView = this.h5LoadingViewProvider.getContentView(this);
            if (!TextUtils.isEmpty(str)) {
                this.h5LoadingViewProvider.setTitle(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.h5LoadingViewProvider.setIcon(str2);
            }
            if (contentView != null && H5StatusBarUtils.isSupport() && H5StatusBarUtils.isConfigSupport()) {
                contentView.setPadding(0, H5StatusBarUtils.getStatusBarHeight(this), 0, 0);
                H5StatusBarUtils.setTransparentColor(this, 855638016);
            }
            if (getFrameworkLoadingViewConfig()) {
                addWhiteBg();
                showFrameworkLoadingView(contentView);
                return;
            }
            addWhiteBg();
            ((RelativeLayout) findViewById(R.id.h5_fragment)).addView(contentView, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private void addWhiteBg() {
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        view.setBackgroundColor(-1);
        ((ViewGroup) findViewById(R.id.h5_fragment)).addView(view, 0);
    }

    public void showFrameworkLoadingView(View view) {
        H5Log.d(TAG, "show framework loading view.".concat(String.valueOf(view)));
        if (view instanceof LoadingView) {
            addLoadingView((LoadingView) view);
        } else {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AnonymousClass1 r1 = new LoadingView(this) {
                public void onHandleMessage(String str, Map<String, Object> map) {
                }

                public void onStart() {
                }

                public void onStop() {
                }
            };
            r1.addView(view, layoutParams);
            addLoadingView(r1);
        }
        startLoading();
    }

    private boolean getFrameworkLoadingViewConfig() {
        b.a();
        return false;
    }

    private void addFullView() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        if (!H5WebViewChoose.notNeedInitUc(this.startParams)) {
            this.fullScreenLoading = new H5LoadingDialog(this);
            this.fullScreenLoading.show();
        }
        ((RelativeLayout) findViewById(R.id.h5_fragment)).addView(relativeLayout, layoutParams);
    }

    public void onDestroy() {
        try {
            if (canUsePreRender()) {
                H5PreRenderPool.getInstance().release();
            }
            super.onDestroy();
            if (this.receiver != null) {
                a.a((Context) this).a(this.receiver);
                this.receiver = null;
            }
            this.pageParamListener = null;
            if (!H5Utils.isInWallet() && ManagerToastLikeDialog.hasManagerInstance()) {
                ManagerToastLikeDialog.getInstance().cancelAllToastLikeDialogs();
            }
            H5Log.d(TAG, "onDestroy ".concat(String.valueOf(this)));
        } catch (Throwable th) {
            H5Log.e(TAG, "destroy exception.", th);
            H5LogProvider h5LogProvider = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
            if (h5LogProvider != null) {
                h5LogProvider.log("H5_DESTROY_EXCEPTION", String.valueOf(th), H5AppUtil.secAppId, (String) null, (String) null);
            }
        }
    }

    public void onStart() {
        super.onStart();
        H5Log.d(TAG, "onStart ".concat(String.valueOf(this)));
    }

    public void onStop() {
        super.onStop();
        H5Log.d(TAG, "onStop ".concat(String.valueOf(this)));
        H5Page topPage = getTopPage();
        if (topPage == null || topPage.getBridge() == null) {
            H5Log.d(TAG, "h5page==null");
            return;
        }
        H5Log.d(TAG, "appPause form onStop");
        topPage.getBridge().sendToWeb(this.appPause, (e) null, (H5CallBack) null);
    }

    private void initPageParams() {
        if (this.hasSaveData) {
            H5Log.d(TAG, "hasSaveData onPageParamReady " + this.startParams);
            onPageParamReady(this.startParams);
        } else if (!(this.startParams == null && this.pageParamListener == null)) {
            return;
        }
        this.pageParamListener = new H5ParamHolder.PageParamListener() {
            public void onPageParam(final Bundle bundle) {
                if (!H5Activity.this.isFinishing()) {
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            H5Activity.this.onPageParamReady(bundle);
                        }
                    });
                }
            }
        };
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = H5Utils.getString(extras, H5Param.LONG_LANDSCAPE);
        if (H5Param.LONG_LANDSCAPE.equals(string)) {
            if (getRequestedOrientation() != 0) {
                setRequestedOrientation(0);
            }
        } else if ("auto".equals(string) && getRequestedOrientation() != -1) {
            setRequestedOrientation(-1);
        }
        String string2 = H5Utils.getString(extras, H5Param.ASYNCINDEX);
        if (!TextUtils.isEmpty(string2)) {
            H5ParamHolder.retrievePageParam(string2, this.pageParamListener);
        } else {
            this.pageParamListener.onPageParam(extras);
        }
    }

    /* access modifiers changed from: private */
    public void onPageParamReady(Bundle bundle) {
        H5Log.d(TAG, "onPageParamReady");
        this.startParams = bundle;
        if (H5WebViewChoose.notNeedInitUc(this.startParams)) {
            initPageContent();
            return;
        }
        initUcReceiver();
        int timeout4Degrade = getTimeout4Degrade();
        if (timeout4Degrade == -1) {
            return;
        }
        if (H5Utils.getBoolean(this.startParams, H5Param.FIRST_INIT_USE_ANDROID_WEBVIEW, false)) {
            H5Log.d(TAG, "FIRST_INIT_USE_ANDROID_WEBVIEW");
            initPageContent();
            return;
        }
        H5Utils.runOnMain(new Runnable() {
            public void run() {
                if (!H5Activity.this.isFinishing()) {
                    H5Log.d(H5Activity.TAG, "fragmentManager " + H5Activity.this.fragmentManager + " " + H5Activity.this.startParams);
                    if (H5Activity.this.fragmentManager == null) {
                        H5LogProvider h5LogProvider = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            h5LogProvider.log("h5_wait_uc_init_timeout", (String) null, (String) null, (String) null, (String) null);
                        }
                        H5Activity.this.initPageContent();
                    }
                }
            }
        }, (long) timeout4Degrade);
    }

    private int getTimeout4Degrade() {
        e parseObject;
        if (H5WebViewChoose.useSysWebWillCrash()) {
            return -1;
        }
        int i2 = 45000;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (!(h5ConfigProvider == null || (parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5WaitUCConfig"))) == null || parseObject.isEmpty())) {
            i2 = H5Utils.getInt(parseObject, "waitTime", (int) SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES);
            H5Log.d(TAG, "getTimeout from configservice ".concat(String.valueOf(i2)));
        }
        H5Log.d(TAG, "getTimeout final ".concat(String.valueOf(i2)));
        return i2;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            H5Log.d(TAG, "onNewIntent");
            H5Page topPage = getTopPage();
            if (topPage != null) {
                this.hasSendResumeFromOnNewIntent = true;
                Nebula.sendAppResume(topPage.getBridge(), intent == null ? null : intent.getExtras());
                H5Log.d(TAG, "appResume form onNewIntent");
                if (H5Utils.isInTinyProcess()) {
                    topPage.sendEvent(H5LoggerPlugin.KEEP_ALIVE_PAGE_PERFORMANCE, (e) null);
                }
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    private H5Page getTopPage() {
        H5SessionImpl h5SessionImpl = this.h5Session;
        if (h5SessionImpl != null) {
            return h5SessionImpl.getTopPage();
        }
        H5Log.d(TAG, "h5Session==null");
        return null;
    }

    public void onResume() {
        super.onResume();
        try {
            H5Log.d(TAG, "onResume ".concat(String.valueOf(this)));
            this.isBetweenResumePause = true;
            initPageParams();
            if (!this.isResumeFirst) {
                if (this.hasSendResumeFromOnNewIntent) {
                    H5Log.d(TAG, "hasSendResumeFromOnNewIntent");
                    this.hasSendResumeFromOnNewIntent = false;
                } else {
                    H5Page topPage = getTopPage();
                    if (topPage == null || topPage.getBridge() == null) {
                        H5Log.d(TAG, "h5page==null");
                    } else {
                        H5Log.d(TAG, "appResume form onResume");
                        Nebula.sendAppResume(topPage.getBridge(), (Bundle) null);
                    }
                }
            }
            this.isResumeFirst = false;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    private void initUcReceiver() {
        if (this.receiver == null) {
            this.receiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent != null && intent.getAction() != null && H5Param.H5_ACTION_UC_INIT_FINISH.equals(intent.getAction()) && !H5Activity.this.isFinishing()) {
                        if (H5Activity.this.startParams != null) {
                            H5Activity.this.startParams.putBoolean(H5Param.LONG_UC_INIT_LOADING_SHOWN, true);
                        }
                        H5Log.d(H5Activity.TAG, "uc init result ".concat(String.valueOf(H5Utils.getBoolean(intent.getExtras(), "result", false))));
                        H5Activity.this.initPageContent();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(H5Param.H5_ACTION_UC_INIT_FINISH);
            a.a((Context) this).a(this.receiver, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public void initPageContent() {
        H5Log.d(TAG, "initPageContent");
        if (!isFinishing() && this.fragmentManager == null) {
            this.fragmentManager = new H5FragmentManager(this);
            hideLoadingView();
            if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(this.startParams, "enableTabBar"))) {
                String string = H5Utils.getString(this.startParams, "tabBarJson");
                if (!TextUtils.isEmpty(string)) {
                    H5SessionTabInfoParser.getOnlineData(string, new H5SessionTabInfoParser.H5SessionTabInfoListener() {
                        public void onGetSyncData(e eVar) {
                        }

                        public void onGetAsyncData(e eVar) {
                            H5Activity.this.showTabBar(eVar);
                        }

                        public void onShowDefaultTab() {
                            H5Activity.this.showDefaultSessionTab();
                        }
                    }, H5Utils.getString(this.startParams, "appId"));
                } else {
                    H5SessionTabInfoParser.getOfflineData(this.h5Session, new H5SessionTabInfoParser.H5SessionTabInfoListener() {
                        public void onGetSyncData(e eVar) {
                            H5Activity.this.showTabBar(eVar);
                        }

                        public void onGetAsyncData(e eVar) {
                            H5Activity.this.showTabBar(eVar);
                        }

                        public void onShowDefaultTab() {
                            H5Activity.this.showDefaultSessionTab();
                        }
                    }, H5Utils.getString(this.startParams, "appId"));
                }
            } else {
                this.fragmentManager.addFragment(this.startParams, false, false);
            }
            boolean z = H5Utils.getBoolean(this.startParams, H5Param.isH5app, false);
            String string2 = H5Utils.getString(this.startParams, "appId");
            if (!TextUtils.isEmpty(string2) && z && !H5AppUtil.isH5ContainerAppId(string2)) {
                Nebula.checkOffline(this, string2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showDefaultSessionTab() {
        if (!isFinishing()) {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5SessionTabBar h5SessionTabBar;
                    if (H5Activity.this.h5Session != null && (h5SessionTabBar = H5Activity.this.h5Session.getH5SessionTabBar()) != null) {
                        h5SessionTabBar.createDefaultSessionTab(H5Activity.this, H5Utils.getInt(H5Activity.this.startParams, "tabItemCount"));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showTabBar(final e eVar) {
        if (!isFinishing() && !this.hasShowTab) {
            this.hasShowTab = true;
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    boolean z;
                    H5SessionTabBar h5SessionTabBar;
                    e eVar = eVar;
                    if (eVar == null || eVar.isEmpty()) {
                        H5Activity.this.fragmentManager.addFragment(H5Activity.this.startParams, false, false);
                        H5Activity.this.showSessionTabErrorDialog();
                        return;
                    }
                    if (H5Activity.this.h5Session == null || (h5SessionTabBar = H5Activity.this.h5Session.getH5SessionTabBar()) == null) {
                        z = false;
                    } else {
                        e eVar2 = eVar;
                        H5Activity h5Activity = H5Activity.this;
                        z = h5SessionTabBar.createSessionTab(eVar2, h5Activity, h5Activity.startParams);
                    }
                    if (!z) {
                        H5Activity.this.fragmentManager.addFragment(H5Activity.this.startParams, false, false);
                        H5Activity.this.showSessionTabErrorToast();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showSessionTabErrorToast() {
        H5Log.e(TAG, "showSessionTabErrorToast");
        if (Nebula.DEBUG) {
            Toast.makeText(this, H5Environment.getResources().getString(R.string.h5_sessiontab_toast), 1).show();
        }
        H5Logger.reportTabBarLog(this.startParams, "H5_AL_TABBAR_ERROR", "H5-EM");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r0 = (com.alipay.mobile.nebula.provider.H5DialogManagerProvider) com.alipay.mobile.nebula.util.H5Utils.getProvider(com.alipay.mobile.nebula.provider.H5DialogManagerProvider.class.getName());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showSessionTabErrorDialog() {
        /*
            r8 = this;
            java.lang.String r0 = "showSessionTabErrorDialog"
            java.lang.String r1 = "H5Activity"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.String) r0)
            java.lang.String r0 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r0)
            java.lang.String r1 = "YES"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L_0x005c
            java.lang.Class<com.alipay.mobile.nebula.provider.H5DialogManagerProvider> r0 = com.alipay.mobile.nebula.provider.H5DialogManagerProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5DialogManagerProvider r0 = (com.alipay.mobile.nebula.provider.H5DialogManagerProvider) r0
            if (r0 == 0) goto L_0x005c
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_sessiontab_notice_failtitle
            java.lang.String r3 = r1.getString(r2)
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_sessiontab_notice_failmsg
            java.lang.String r4 = r1.getString(r2)
            android.content.res.Resources r1 = com.alipay.mobile.nebulacore.env.H5Environment.getResources()
            int r2 = com.alipay.mobile.nebulacore.R.string.h5_default_confirm
            java.lang.String r5 = r1.getString(r2)
            r6 = 0
            r7 = 0
            r1 = r0
            r2 = r8
            android.app.Dialog r1 = r1.createDialog(r2, r3, r4, r5, r6, r7)
            com.alipay.mobile.nebulacore.ui.H5Activity$9 r2 = new com.alipay.mobile.nebulacore.ui.H5Activity$9
            r2.<init>(r0)
            r0.setPositiveListener(r2)
            if (r1 == 0) goto L_0x0059
            com.alipay.mobile.nebulacore.ui.H5Activity$10 r2 = new com.alipay.mobile.nebulacore.ui.H5Activity$10
            r2.<init>()
            r1.setOnKeyListener(r2)
        L_0x0059:
            r0.showDialog()
        L_0x005c:
            android.os.Bundle r0 = r8.startParams
            java.lang.String r1 = "H5_AL_TABBAR_WARN"
            java.lang.String r2 = "H5-VM"
            com.alipay.mobile.nebulacore.wallet.H5Logger.reportTabBarLog(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.ui.H5Activity.showSessionTabErrorDialog():void");
    }

    public void hideLoadingView() {
        H5Log.d(TAG, "hide loading view");
        H5LoadingViewProvider h5LoadingViewProvider2 = this.h5LoadingViewProvider;
        if (h5LoadingViewProvider2 != null) {
            h5LoadingViewProvider2.stopLoading(this);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.h5_fragment);
            if (viewGroup != null) {
                viewGroup.removeView(this.h5LoadingViewProvider.getContentView(this));
            }
        }
        stopLoading();
        H5LoadingDialog h5LoadingDialog = this.fullScreenLoading;
        if (h5LoadingDialog != null) {
            h5LoadingDialog.dismiss();
            this.fullScreenLoading = null;
        }
    }

    public void onPause() {
        try {
            super.onPause();
            this.isBetweenResumePause = false;
            H5Log.d(TAG, "onPause ".concat(String.valueOf(this)));
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public boolean isTabContainerVisible() {
        View findViewById;
        if (findViewById(R.id.h5_sessiontab_stub) == null && (findViewById = findViewById(R.id.h5_sessiontabcontainer)) != null && findViewById.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public View getSessionTabContainer() {
        if (this.sessionTabContainer == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.h5_sessiontab_stub);
            if (viewStub != null) {
                this.sessionTabContainer = (RelativeLayout) viewStub.inflate();
            } else {
                this.sessionTabContainer = (RelativeLayout) findViewById(R.id.h5_sessiontabcontainer);
            }
        }
        return this.sessionTabContainer;
    }

    public boolean canUsePreRender() {
        if (H5Utils.getBoolean(this.startParams, H5Param.isTinyApp, false) || this.openPreRenderByPlugin) {
            return true;
        }
        return false;
    }

    public void openPreRenderByPlugin(boolean z) {
        this.openPreRenderByPlugin = z;
    }

    public boolean isBetweenResumePause() {
        return this.isBetweenResumePause;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment currentFragment = getCurrentFragment();
        if (currentFragment == null || !(currentFragment instanceof H5Fragment)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return ((H5Fragment) currentFragment).onKeyDown(i2, keyEvent);
    }

    public Fragment getCurrentFragment() {
        return this.fragmentManager.getCurrentFragment();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(SAVED_INSTANCE_STATE_KEY, H5Utils.toJSONObject(this.startParams).toString());
        }
    }

    public void finish() {
        if (H5Utils.getBoolean(this.startParams, H5Param.SHOW_ACTIVITY_FINISH_ANIMATION, true)) {
            super.finish();
            H5Log.d(TAG, "finish:".concat(String.valueOf(this)));
            if (NebulaUtil.isShowTransAnimate(this.startParams)) {
                H5AnimatorUtil.setActivityFadingFinish();
            } else {
                H5AnimatorUtil.setActivityFinish(this);
            }
        } else if (!"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_showActivityFinishAnimation"))) {
            getWindow().setWindowAnimations(0);
            new Handler(getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    try {
                        H5Activity.super.finish();
                        H5Log.d(H5Activity.TAG, "finish:".concat(String.valueOf(this)));
                    } catch (Throwable th) {
                        H5Log.e(H5Activity.TAG, th);
                    }
                }
            }, 1);
        } else {
            super.finish();
            H5Log.d(TAG, "finish:".concat(String.valueOf(this)));
        }
    }

    public H5FragmentManager getH5FragmentManager() {
        return this.fragmentManager;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (canUsePreRender()) {
            return H5PreRenderPool.getInstance().isIntercept() || super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static class H5Activity1 extends H5Activity {
        public void onCreate(Bundle bundle) {
            H5Activity.super.onCreate(bundle);
            H5Log.d(H5Activity.TAG, "onCreate H5Activity1");
        }
    }

    public static class H5Activity2 extends H5Activity {
        public void onCreate(Bundle bundle) {
            H5Activity.super.onCreate(bundle);
            H5Log.d(H5Activity.TAG, "onCreate H5Activity2");
        }
    }

    public static class H5Activity3 extends H5Activity {
        public void onCreate(Bundle bundle) {
            H5Activity.super.onCreate(bundle);
            H5Log.d(H5Activity.TAG, "onCreate H5Activity3");
        }
    }

    public static class H5Activity4 extends H5Activity {
        public void onCreate(Bundle bundle) {
            H5Activity.super.onCreate(bundle);
            H5Log.d(H5Activity.TAG, "onCreate H5Activity4");
        }
    }

    public static class H5Activity5 extends H5Activity {
        public void onCreate(Bundle bundle) {
            H5Activity.super.onCreate(bundle);
            H5Log.d(H5Activity.TAG, "onCreate H5Activity5");
        }
    }
}
