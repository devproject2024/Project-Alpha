package com.alipay.mobile.nebulacore.wallet;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.a.b;
import com.alipay.mobile.framework.app.a;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList;
import com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.dev.H5BugmeLogCollector;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.startParam.H5AppStartParam;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.webview.H5ResContentList;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalPackage;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg;
import com.alipay.mobile.nebulacore.data.H5ParamHolder;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.util.H5AnimatorUtil;
import com.alipay.mobile.nebulacore.util.H5TimeUtil;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import java.util.ArrayList;

public class H5Application extends a {
    public static final String TAG = "H5Application";
    private static int sIndex = 0;
    public static boolean sNebulaReady = false;
    private String appId;
    private Bundle onCreateParam;
    private boolean openAppWithBugme;
    private Bundle param;
    private long time;

    public String getEntryClassName() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        this.time = System.currentTimeMillis();
        if (!H5Flag.ucReady) {
            H5PageData.setInitScenario(this.time, 1);
        } else if (!sNebulaReady) {
            H5PageData.setInitScenario(this.time, 2);
        } else {
            H5PageData.setInitScenario(this.time, 3);
        }
        sNebulaReady = true;
        if (bundle != null) {
            setSourceId(bundle.getString("sourceId"));
        }
        this.appId = getAppId();
        H5Log.d(TAG, "onCreate " + this.appId + " @" + hashCode() + " param " + bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.param = bundle;
        this.param.putString("appId", this.appId);
        if (H5Utils.isInTinyProcess()) {
            H5PageData.createAppTime = this.time;
            H5Log.d(TAG, "h5EventHandlerService ".concat(String.valueOf((H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName()))));
        }
        setupBugMeIfNeed();
        this.onCreateParam = Nebula.copyBundle(this.param);
    }

    private boolean hasShowNebulaLoading(Bundle bundle) {
        return H5Utils.getBoolean(bundle, H5Param.LONG_PACKAGE_LOADING_SHOWN, false);
    }

    private void setupBugMeIfNeed() {
        Nebula.getService().getBugMeManager().setUp();
        boolean equals = "true".equals(this.param.getString("enableBugme"));
        boolean booleanConfig = H5DevConfig.getBooleanConfig(H5DevConfig.H5_BUG_ME_DEBUG_SWITCH, false);
        if (equals && !booleanConfig) {
            openBugMeByStartParam();
        }
    }

    private void openBugMeByStartParam() {
        H5Log.d(TAG, "openBugMeByStartParam");
        this.openAppWithBugme = true;
        String string = this.param.getString("domainWhiteList");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split("\\|");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    String decode = H5UrlHelper.decode(str);
                    arrayList.add(decode);
                    H5Log.d(TAG, "Got domain whitelist: ".concat(String.valueOf(decode)));
                }
            }
            Nebula.getH5BugMeManager().setDomainWhiteList((String[]) arrayList.toArray(new String[0]));
        }
        H5DevConfig.debugSwitch(true, false, true, false, false);
    }

    public void onDestroy(Bundle bundle) {
        H5Log.d(TAG, "onDestroy " + this.appId + " @" + hashCode() + " param " + bundle);
        if (Nebula.getH5TinyAppService() != null) {
            Nebula.getH5TinyAppService().clear(this.appId);
        }
        H5BugmeLogCollector.flushFile();
        H5DevAppList.getInstance().setUseDevMode(this.appId, false);
        if (this.openAppWithBugme) {
            Nebula.getService().getBugMeManager().release();
        }
        H5StartParamManager.getInstance().clear(this.appId);
        H5GlobalPackage.clearResourcePackages(this.appId);
        H5GlobalTempPkg.getInstance().clear(this.appId);
        H5ResContentList.getInstance().clear();
        if (!TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, H5Utils.getString(this.param, H5Param.MULTI_APP_TAG))) {
            H5TabbarUtils.clearTabDataByAppId(this.appId);
        }
        H5PreferAppList.getInstance().clearProcessCache(this.appId);
        H5Flag.isUploadLog = true;
        if (H5Utils.isInTinyProcess()) {
            H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
            if (h5EventHandlerService != null) {
                h5EventHandlerService.stopSelfProcess();
            } else {
                H5Log.d(TAG, "onDestroy h5EventHandlerService == null");
            }
        } else {
            Nebula.clearServiceWork(this.param);
        }
    }

    public void onStart() {
        try {
            H5Log.d(TAG, "onStart " + this.appId + " @" + hashCode() + " sourceId:" + getSourceId() + " mSceneId:" + getSceneId());
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        H5AppUtil.secAppId = getSourceId();
        getMicroApplicationContext();
        H5Environment.setContext(com.alipay.mobile.c.a.f14950c);
        startPage(this.param);
    }

    public void onStop() {
        H5Log.d(TAG, "onStop " + this.appId + " @" + hashCode());
    }

    public boolean canRestart(Bundle bundle) {
        boolean startMultApp = startMultApp(bundle);
        H5Log.d(TAG, "canRestart " + this.appId + " @" + hashCode() + ", enableMultiApp " + startMultApp);
        if (startMultApp) {
            bundle.putString(H5Param.MULTI_APP_TAG, H5Param.DEFAULT_LONG_PRESSO_LOGIN);
        }
        return !startMultApp;
    }

    private boolean startMultApp(Bundle bundle) {
        String string = H5Utils.getString(bundle, "startMultApp");
        boolean z = !TextUtils.isEmpty(string) && H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(string);
        if (H5Utils.getBoolean(bundle, "startMultApp", false)) {
            z = true;
        }
        if (!z || !H5Utils.getBoolean(this.param, H5Param.isTinyApp, false) || "no".equalsIgnoreCase(H5Environment.getConfig("h5_tiny_multiApp"))) {
            return z;
        }
        if (H5Utils.isDebug()) {
            Toast.makeText(H5Utils.getContext(), "Tiny app don't support MutliApp(this only show in debug mode)", 1).show();
        }
        return false;
    }

    public void onRestart(Bundle bundle) {
        b jSONArray;
        if (bundle != null) {
            String string = H5Utils.getString(bundle, "u");
            if (TextUtils.isEmpty(string)) {
                string = H5Utils.getString(bundle, "url");
            }
            this.appId = getAppId();
            bundle.putString("appId", this.appId);
            H5Log.d(TAG, "onRestart " + this.appId + " @" + hashCode() + " param " + bundle);
            H5Session topSession = Nebula.getService().getTopSession();
            String jSONString = H5Utils.toJSONObject(bundle).toJSONString();
            if (startMultApp(bundle)) {
                H5Log.d(TAG, "startMultiApp");
                startPage(bundle);
                return;
            }
            if (!TextUtils.isEmpty(string) || topSession == null) {
                H5Log.w(TAG, "onRestart start page ".concat(String.valueOf(string)));
                String string2 = H5Utils.getString(bundle, H5Param.CAN_DESTROY);
                if (TextUtils.isEmpty(string2)) {
                    string2 = H5Utils.getString(bundle, H5Param.LONG_CAN_DESTROY);
                }
                if (TextUtils.isEmpty(string2) && H5Utils.getBoolean(bundle, H5Param.LONG_CAN_DESTROY, true)) {
                    string2 = H5Param.DEFAULT_LONG_PRESSO_LOGIN;
                }
                if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(string2)) {
                    H5Log.d(TAG, "OnRestart -> destroy same app");
                    destroy((Bundle) null);
                    if (bundle != null && bundle.containsKey(H5AppHandler.CHECK_KEY) && !"no".equalsIgnoreCase(H5Environment.getConfig("h5_delete_CHECK_KEY"))) {
                        bundle.remove(H5AppHandler.CHECK_KEY);
                    }
                    getMicroApplicationContext().a("20000067", this.appId, bundle);
                } else {
                    startPage(bundle);
                    H5Log.d(TAG, "OnRestart -> startPage");
                }
            } else {
                H5Log.w(TAG, "onRestart set resumeParams ".concat(String.valueOf(jSONString)));
                topSession.getData().set(H5Param.H5_SESSION_RESUME_PARAM, jSONString);
                H5LogProvider h5LogHandler = Nebula.getH5LogHandler();
                if (h5LogHandler != null) {
                    h5LogHandler.log("H5_ReStart_Without_URL", (String) null, (String) null, (String) null, this.appId);
                }
                String config = H5Environment.getConfig("h5_optionConfig");
                if (!TextUtils.isEmpty(config) && (jSONArray = H5Utils.getJSONArray(H5Utils.parseObject(config), "reStartAppIdList", (b) null)) != null && !jSONArray.isEmpty() && jSONArray.contains(this.appId)) {
                    Bundle copyBundle = Nebula.copyBundle(bundle);
                    copyBundle.putString("startMultApp", H5Param.DEFAULT_LONG_PRESSO_LOGIN);
                    copyBundle.remove(H5AppHandler.CHECK_KEY);
                    c microApplicationContext = getMicroApplicationContext();
                    String str = this.appId;
                    microApplicationContext.a(str, str, copyBundle);
                    return;
                }
            }
            H5Log.d(TAG, "h5_app_restart appId={" + getAppId() + "} params={" + bundle.toString() + "}");
        }
    }

    private void startPage(Bundle bundle) {
        H5EnvProvider h5EnvProvider;
        String string = H5Utils.getString(bundle, "url");
        if (TextUtils.isEmpty(string)) {
            string = H5Utils.getString(bundle, "u");
        }
        H5Trace.event("startPage", (String) null, "appId", this.appId);
        H5Log.d(TAG, "startPage " + this.appId + " " + string);
        if (H5AppUtil.isH5ContainerAppId(this.appId) && !TextUtils.isEmpty(string)) {
            String matchAppId = H5AppUtil.matchAppId(string);
            H5Log.d(TAG, "matchAppId:".concat(String.valueOf(matchAppId)));
            if (!TextUtils.isEmpty(matchAppId) && !H5AppUtil.isH5ContainerAppId(matchAppId)) {
                com.alipay.mobile.framework.b.a().f14954a.a(this.appId, matchAppId, this.param);
                destroy((Bundle) null);
                return;
            }
        }
        if (Nebula.enableOpenScheme(string)) {
            H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink");
            destroy((Bundle) null);
            return;
        }
        if (H5Utils.isStripLandingURLEnable(string)) {
            String stripLandingURL = H5Utils.getStripLandingURL(string);
            if (!TextUtils.equals(string, stripLandingURL) && !TextUtils.isEmpty(stripLandingURL) && stripLandingURL.startsWith("alipay") && (h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName())) != null && h5EnvProvider.goToSchemeService(stripLandingURL)) {
                H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink in landing");
                destroy((Bundle) null);
                return;
            }
        }
        com.alipay.mobile.framework.b.a();
        H5Service h5Service = (H5Service) c.a(H5Service.class.getName());
        if (h5Service == null) {
            H5Log.e(TAG, "failed to get h5 service!");
            destroy((Bundle) null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.appId);
        sb.append("_");
        int i2 = sIndex;
        sIndex = i2 + 1;
        sb.append(i2);
        String sb2 = sb.toString();
        H5ParamHolder.addPageParam(sb2);
        Nebula.commonParamParse(bundle);
        bundle.putString(H5Param.FROM_TYPE, H5PageData.FROM_TYPE_START_APP);
        getMicroApplicationContext();
        Application application = com.alipay.mobile.c.a.f14950c;
        WalletContext walletContext = new WalletContext((Context) null);
        walletContext.setMicroApplication(this);
        Nebula.initSession(this.appId, bundle, walletContext);
        H5AppStartParam.getInstance().put(H5Utils.getString(bundle, H5Param.SESSION_ID), this.onCreateParam);
        Intent commonStartActivity = Nebula.commonStartActivity(application, bundle);
        if (commonStartActivity == null) {
            destroy((Bundle) null);
            return;
        }
        commonStartActivity.putExtra(H5Param.ASYNCINDEX, sb2);
        bundle.putString(H5Param.ASYNCINDEX, sb2);
        asyncStartPage(bundle, h5Service);
        getMicroApplicationContext().a(this, commonStartActivity);
        if (NebulaUtil.isShowTransAnimate(bundle)) {
            H5AnimatorUtil.setActivityFadingStart();
        } else if (!hasShowNebulaLoading(this.param) || "no".equalsIgnoreCase(H5Environment.getConfig("h5_newloadpage"))) {
            H5AnimatorUtil.setActivityStart(walletContext);
        } else {
            H5AnimatorUtil.setActivityNoAnimStart();
        }
    }

    private void asyncStartPage(Bundle bundle, H5Service h5Service) {
        H5Log.d(TAG, "asyncStartPage " + this.appId);
        H5Bundle h5Bundle = new H5Bundle(bundle);
        h5Service.startPage(this, h5Bundle);
        H5Log.d(TAG, "h5_app_start appId={" + getAppId() + "} params={" + h5Bundle.toString() + "}");
        H5TimeUtil.timeLog(H5TimeUtil.START_APP, this.time);
    }
}
