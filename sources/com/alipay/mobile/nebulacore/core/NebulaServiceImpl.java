package com.alipay.mobile.nebulacore.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5BaseFragment;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Listener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageReadyListener;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5UcReadyCallBack;
import com.alipay.mobile.h5container.api.H5ViewCache;
import com.alipay.mobile.h5container.api.H5WebDriverHelper;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.common.NebulaCommonManager;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppManager;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.config.H5PluginConfig;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.dev.H5DevConfig;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import com.alipay.mobile.nebula.process.H5IpcServer;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5CacheProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5PreRpcProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.provider.H5TaskScheduleProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.android.AndroidWebViewPreCreator;
import com.alipay.mobile.nebulacore.api.H5UcInitReceiver;
import com.alipay.mobile.nebulacore.api.H5UcInitTask;
import com.alipay.mobile.nebulacore.api.NebulaService;
import com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg;
import com.alipay.mobile.nebulacore.appcenter.parse.H5PackageParserRn;
import com.alipay.mobile.nebulacore.config.H5PluginConfigManager;
import com.alipay.mobile.nebulacore.data.H5ParamHolder;
import com.alipay.mobile.nebulacore.dev.provider.H5BugMeSwitchPlugin;
import com.alipay.mobile.nebulacore.dev.ui.H5DevSettingsActivity;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.env.H5WebViewChoose;
import com.alipay.mobile.nebulacore.manager.H5NebulaAppManager;
import com.alipay.mobile.nebulacore.manager.H5NebulaCommonManager;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.plugin.H5ChannelPlugin;
import com.alipay.mobile.nebulacore.plugin.H5ClipboardPlugin;
import com.alipay.mobile.nebulacore.plugin.H5CookiePlugin;
import com.alipay.mobile.nebulacore.plugin.H5DefaultPlugin;
import com.alipay.mobile.nebulacore.plugin.H5NetworkPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SecurePlugin;
import com.alipay.mobile.nebulacore.plugin.H5ShareDataPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SystemPlugin;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5Fragment;
import com.alipay.mobile.nebulacore.ui.H5ViewHolder;
import com.alipay.mobile.nebulacore.util.H5AnimatorUtil;
import com.alipay.mobile.nebulacore.web.H5BridgePolicy;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class NebulaServiceImpl extends H5CoreTarget implements NebulaService {
    public static final String TAG = "H5NebulaService";
    private BroadcastReceiver bugMeReceiver = null;
    private H5TaskScheduleProvider h5TaskScheduleProvider;
    private boolean hasLoadDevHelp;
    private H5UcInitTask idleTask;
    private NebulaAppManager nebulaAppManager;
    private NebulaCommonManager nebulaCommonManager;
    private boolean pluginsInited = false;
    private Stack<H5Session> sessions = new Stack<>();
    private Map<String, List<H5Listener>> ssListeners = new ConcurrentHashMap();
    private H5UcInitReceiver ucIsReadyReceiver = null;
    private H5UcInitReceiver ucPageReadyReceiver = null;
    private H5WebDriverHelper webDriverHelper;

    public NebulaServiceImpl() {
        H5Log.d(TAG, "init nebula service  ");
    }

    private void initPlugins() {
        H5Log.d(TAG, "initPlugins");
        this.pluginsInited = true;
        long currentTimeMillis = System.currentTimeMillis();
        H5PluginManager pluginManager = getPluginManager();
        pluginManager.register((H5Plugin) new H5ShareDataPlugin());
        pluginManager.register((H5Plugin) new H5NetworkPlugin());
        pluginManager.register((H5Plugin) new H5SystemPlugin());
        pluginManager.register((H5Plugin) new H5SecurePlugin());
        pluginManager.register((H5Plugin) new H5CookiePlugin());
        pluginManager.register((H5Plugin) new H5ClipboardPlugin());
        pluginManager.register((H5Plugin) new H5DefaultPlugin());
        pluginManager.register((H5Plugin) new H5ChannelPlugin());
        pluginManager.register((H5Plugin) new H5BugMeSwitchPlugin());
        H5Plugin createPlugin = H5PluginConfigManager.getInstance().createPlugin("service", pluginManager);
        if (createPlugin != null) {
            pluginManager.register(createPlugin);
        }
        H5Log.d(TAG, "initPlugins delta ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    public void onRelease() {
        super.onRelease();
    }

    public H5Page createPage(H5Context h5Context, H5Bundle h5Bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        if (h5Bundle == null) {
            h5Bundle = new H5Bundle();
        }
        if (h5Bundle.getParams() == null) {
            h5Bundle.setParams(new Bundle());
        }
        if (h5Context == null || h5Context.getContext() == null) {
            H5Log.e(TAG, "invalid h5 context!");
            return null;
        } else if (!(h5Context.getContext() instanceof Activity)) {
            H5Log.e(TAG, "not activity context!");
            return null;
        } else {
            Bundle commonSet = commonSet(h5Context, h5Bundle, true);
            H5PageImpl h5PageImpl = new H5PageImpl((Activity) h5Context.getContext(), commonSet, (H5ViewHolder) null);
            if (Nebula.DEBUG) {
                H5Log.d(TAG, "h5_app_start createPage appId={" + H5Utils.getString(commonSet, "appId") + "} params={" + commonSet.toString() + "}");
            }
            h5PageImpl.getWebView().getView().setBackgroundColor(H5Utils.getInt(h5PageImpl.getParams(), "backgroundColor"));
            H5Log.d(TAG, "createPage cost ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            return h5PageImpl;
        }
    }

    public void createPageAsync(H5Context h5Context, H5Bundle h5Bundle, H5PageReadyListener h5PageReadyListener) {
        if (h5Bundle == null) {
            h5Bundle = new H5Bundle();
        }
        if (h5Bundle.getParams() == null) {
            h5Bundle.setParams(new Bundle());
        }
        if (h5Context == null || h5Context.getContext() == null) {
            H5Log.e(TAG, "invalid h5 context!");
        } else if (!(h5Context.getContext() instanceof Activity)) {
            H5Log.e(TAG, "not activity context!");
        } else if (H5WebViewChoose.notNeedInitUc(h5Bundle.getParams())) {
            H5Log.d(TAG, "createPageAsync notNeedInitUc");
            if (h5PageReadyListener != null) {
                h5PageReadyListener.getH5Page(createPage(h5Context, h5Bundle));
            }
        } else if (this.ucPageReadyReceiver == null) {
            H5Log.d(TAG, "createPageAsync !notNeedInitUc init ucPageReadyReceiver");
            this.ucPageReadyReceiver = new H5UcInitReceiver(true);
            this.ucPageReadyReceiver.addH5Bundle(h5Bundle);
            this.ucPageReadyReceiver.addH5Context(h5Context);
            this.ucPageReadyReceiver.addH5PageReadyListener(h5PageReadyListener);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(H5Param.H5_ACTION_UC_INIT_FINISH);
            a.a(H5Environment.getContext()).a(this.ucPageReadyReceiver, intentFilter);
            try {
                fireUrgentUcInit(h5Bundle.getParams());
            } catch (Exception e2) {
                H5Log.e(TAG, "Urgent uc init:".concat(String.valueOf(e2)));
            }
        } else {
            H5Log.d(TAG, "createPageAsync !notNeedInitUc add xxx");
            this.ucPageReadyReceiver.addH5Bundle(h5Bundle);
            this.ucPageReadyReceiver.addH5Context(h5Context);
            this.ucPageReadyReceiver.addH5PageReadyListener(h5PageReadyListener);
        }
    }

    public void ucIsReady(H5UcReadyCallBack h5UcReadyCallBack) {
        if (H5WebViewChoose.notNeedInitUc((Bundle) null)) {
            H5Log.d(TAG, "ucIsReady notNeedInitUc");
            if (h5UcReadyCallBack != null) {
                h5UcReadyCallBack.usIsReady(true);
            }
        } else if (this.ucIsReadyReceiver == null) {
            H5Log.d(TAG, "ucIsReady !notNeedInitUc init ucIsReadyReceiver");
            this.ucIsReadyReceiver = new H5UcInitReceiver(false);
            this.ucIsReadyReceiver.addH5UcReadyCallBack(h5UcReadyCallBack);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(H5Param.H5_ACTION_UC_INIT_FINISH);
            a.a(H5Environment.getContext()).a(this.ucIsReadyReceiver, intentFilter);
            try {
                fireUrgentUcInit((Bundle) null);
            } catch (Exception e2) {
                H5Log.e(TAG, " ucIsReady Urgent uc init:".concat(String.valueOf(e2)));
                h5UcReadyCallBack.usIsReady(false);
            }
        } else {
            H5Log.d(TAG, "ucIsReady !notNeedInitUc add xxx");
            this.ucIsReadyReceiver.addH5UcReadyCallBack(h5UcReadyCallBack);
        }
    }

    public H5BugMeManager getBugMeManager() {
        return Nebula.getH5BugMeManager();
    }

    public H5Page getTopH5Page() {
        H5Session topSession = getTopSession();
        if (topSession != null) {
            return topSession.getTopPage();
        }
        H5Log.e(TAG, "getTopH5Page fatal error h5Session == null");
        return null;
    }

    public Fragment getTopH5Fragment() {
        return getFragmentCommon(getTopH5Page());
    }

    private Fragment getFragmentCommon(H5Page h5Page) {
        if (h5Page == null || h5Page.getContext() == null || h5Page.getContext().getContext() == null) {
            return null;
        }
        Activity activity = (Activity) h5Page.getContext().getContext();
        if (!(activity instanceof H5Activity)) {
            return null;
        }
        return ((H5Activity) activity).getCurrentFragment();
    }

    public H5BaseFragment getTopH5BaseFragment() {
        Fragment topH5Fragment = getTopH5Fragment();
        if (topH5Fragment == null || !(topH5Fragment instanceof H5Fragment)) {
            return null;
        }
        return (H5BaseFragment) topH5Fragment;
    }

    public H5BaseFragment getTopH5BaseFragmentByWorkerId(String str) {
        Fragment fragmentCommon;
        H5Session sessionByWorkerId = getSessionByWorkerId(str);
        if (sessionByWorkerId == null || (fragmentCommon = getFragmentCommon(sessionByWorkerId.getTopPage())) == null || !(fragmentCommon instanceof H5Fragment)) {
            return null;
        }
        return (H5BaseFragment) fragmentCommon;
    }

    public H5BaseFragment getTopH5BaseFragmentByViewId(int i2) {
        Fragment fragmentCommon;
        Stack<H5Session> stack = this.sessions;
        if (stack == null) {
            return null;
        }
        synchronized (stack) {
            Iterator it2 = this.sessions.iterator();
            while (it2.hasNext()) {
                H5Session h5Session = (H5Session) it2.next();
                if (h5Session != null) {
                    Iterator it3 = h5Session.getPages().iterator();
                    while (it3.hasNext()) {
                        H5Page h5Page = (H5Page) it3.next();
                        if (h5Page != null && h5Page.getWebViewId() == i2 && (fragmentCommon = getFragmentCommon(h5Page)) != null && (fragmentCommon instanceof H5Fragment)) {
                            H5BaseFragment h5BaseFragment = (H5BaseFragment) fragmentCommon;
                            return h5BaseFragment;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public void prepareRNApp(final String str, final H5AppInstallProcess h5AppInstallProcess) {
        H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
            public void run() {
                HashMap hashMap = new HashMap();
                H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
                if (h5AppProvider == null) {
                    H5Log.e(NebulaServiceImpl.TAG, "nebulaAppProvider==null");
                    return;
                }
                String walletConfigNebulaVersion = h5AppProvider.getWalletConfigNebulaVersion(str);
                String version = h5AppProvider.getVersion(str);
                if (!TextUtils.isEmpty(str)) {
                    H5Log.d(NebulaServiceImpl.TAG, "prepareApp: send rpc appId:" + str + " walletConfigNebulaVersion:" + walletConfigNebulaVersion + " version:" + version);
                    hashMap.put(str, walletConfigNebulaVersion);
                }
                h5AppProvider.startUpdateApp(hashMap, h5AppInstallProcess);
                Nebula.prepare(h5AppProvider, str, version, h5AppInstallProcess);
            }
        });
    }

    public int parseRNPkg(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        return H5PackageParserRn.parseRNPackage(str);
    }

    public void initServicePlugin() {
        if (!this.pluginsInited) {
            initPlugins();
        }
    }

    public NebulaAppManager getNebulaAppManager() {
        if (this.nebulaAppManager == null) {
            this.nebulaAppManager = new H5NebulaAppManager();
        }
        return this.nebulaAppManager;
    }

    public NebulaCommonManager getNebulaCommonManager() {
        if (this.nebulaCommonManager == null) {
            this.nebulaCommonManager = new H5NebulaCommonManager();
        }
        return this.nebulaCommonManager;
    }

    public void fireUrgentUcInit() {
        fireUrgentUcInit((Bundle) null);
    }

    public boolean startPage(final H5Context h5Context, H5Bundle h5Bundle) {
        final Context context;
        H5PreRpcProvider h5PreRpcProvider;
        if (h5Bundle == null) {
            H5Log.w(TAG, "invalid start page parameters!");
            return false;
        }
        if (h5Bundle.getParams() == null) {
            h5Bundle.setParams(new Bundle());
        }
        if (h5Context == null || h5Context.getContext() == null) {
            context = H5Environment.getContext();
        } else {
            context = h5Context.getContext();
        }
        Bundle params = h5Bundle.getParams();
        if (!TextUtils.isEmpty(H5Utils.getString(params, "preRpc")) && (h5PreRpcProvider = (H5PreRpcProvider) Nebula.getProviderManager().getProvider(H5PreRpcProvider.class.getName())) != null) {
            h5PreRpcProvider.setStartParams(params);
            h5PreRpcProvider.preRpc();
        }
        final Bundle commonSet = commonSet(h5Context, h5Bundle, false);
        if (!enableStockTradeLog(commonSet)) {
            H5Flag.isUploadLog = false;
        } else {
            H5Flag.isUploadLog = true;
        }
        String string = H5Utils.getString(commonSet, H5Param.ASYNCINDEX);
        if (H5ParamHolder.hasPageParam(string)) {
            H5ParamHolder.deliveryPageParam(string, commonSet);
        } else {
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    Nebula.commonParamParse(commonSet);
                    H5Environment.startActivity(h5Context, Nebula.commonStartActivity(context, commonSet));
                    H5AnimatorUtil.setActivityStart(h5Context);
                }
            });
        }
        if (Nebula.DEBUG) {
            H5Log.d(TAG, "h5_app_start startPage appId={" + H5Utils.getString(commonSet, "appId") + "} params={" + h5Bundle.toString() + "}");
        }
        return true;
    }

    private boolean enableStockTradeLog(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        try {
            String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_enableStockLogSwitch");
            if (configWithProcessCache != null) {
                if (H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(configWithProcessCache)) {
                    if (H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equalsIgnoreCase(H5Utils.getString(bundle, "isStockTradeLog"))) {
                        return false;
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    private Bundle commonSet(H5Context h5Context, H5Bundle h5Bundle, boolean z) {
        H5PermissionManager h5PermissionManager;
        if (Nebula.DEBUG) {
            Nebula.h5_dev_uc = H5Utils.getConfigBoolean(H5Utils.getContext(), "h5_dev_uc");
        }
        try {
            fireUrgentUcInit(h5Bundle.getParams());
        } catch (Exception e2) {
            H5Log.e(TAG, "Urgent uc init:".concat(String.valueOf(e2)));
        }
        if (!this.pluginsInited) {
            initPlugins();
        }
        if (!H5Utils.isInTinyProcess() && (h5PermissionManager = (H5PermissionManager) H5Utils.getProvider(H5PermissionManager.class.getName())) != null) {
            h5PermissionManager.setDefaultPermissionConfig();
        }
        Bundle params = h5Bundle.getParams();
        String string = H5Utils.getString(params, "appId");
        if (!params.containsKey(H5Param.SESSION_ID)) {
            Nebula.initSession(string, params, h5Context);
        }
        String string2 = H5Utils.getString(params, H5Param.SESSION_ID);
        boolean hasCheckParam = H5AppHandler.hasCheckParam(params);
        H5Log.d(TAG, "appId " + string + " hasCheck " + hasCheckParam);
        H5TabbarUtils.clearTabDataByAppId(string);
        Nebula.isDSL = false;
        long currentTimeMillis = System.currentTimeMillis();
        H5AppCenter.setupPage(params, hasCheckParam, z, h5Context);
        H5Log.d(TAG, "startPage setupPage cost " + (System.currentTimeMillis() - currentTimeMillis));
        H5Log.d(TAG, " session ".concat(String.valueOf(string2)));
        List<H5Listener> listeners = h5Bundle.getListeners();
        if (listeners != null && !listeners.isEmpty()) {
            this.ssListeners.put(string2, listeners);
        }
        H5AppUtil.currentPsd = !TextUtils.isEmpty(H5Utils.getString(params, H5Param.OFFLINE_HOST)) ? "local" : P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT;
        logStart(params, string);
        return params;
    }

    private void logStart(Bundle bundle, String str) {
        H5LogProvider h5LogProvider = (H5LogProvider) H5ProviderManagerImpl.getInstance().getProvider(H5LogProvider.class.getName());
        if (h5LogProvider != null) {
            h5LogProvider.logV2("H5_AL_SESSION_START", "diagnose", "appId=" + str + "^version=" + H5Utils.getString(bundle, "appVersion") + "^publicId=" + H5Utils.getString(bundle, H5Param.PUBLIC_ID) + "^url=" + H5Utils.getString(bundle, "url"), (String) null, (String) null, "HD-VM");
        }
    }

    public void prepareApp(final String str, String str2, final H5AppInstallProcess h5AppInstallProcess) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
                if (h5AppProvider == null) {
                    H5Log.e(NebulaServiceImpl.TAG, "nebulaAppProvider==null");
                    return;
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    String walletConfigNebulaVersion = h5AppProvider.getWalletConfigNebulaVersion(str);
                    H5Log.d(NebulaServiceImpl.TAG, "prepareApp: send rpc appId:" + str + " walletConfigNebulaVersion:" + walletConfigNebulaVersion);
                    hashMap.put(str, walletConfigNebulaVersion);
                }
                if (!hashMap.isEmpty()) {
                    h5AppProvider.startUpdateApp(hashMap, h5AppInstallProcess);
                }
            }
        });
    }

    public boolean addSession(H5Session h5Session) {
        if (h5Session == null) {
            return false;
        }
        synchronized (this.sessions) {
            Iterator it2 = this.sessions.iterator();
            while (it2.hasNext()) {
                if (((H5Session) it2.next()).equals(h5Session)) {
                    return false;
                }
            }
            h5Session.setParent(this);
            this.sessions.add(h5Session);
            return true;
        }
    }

    public H5Session getSession(String str) {
        H5Session h5Session;
        synchronized (this.sessions) {
            Iterator it2 = this.sessions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    h5Session = null;
                    break;
                }
                h5Session = (H5Session) it2.next();
                if (str.equals(h5Session.getId())) {
                    break;
                }
            }
        }
        if (h5Session == null) {
            h5Session = new H5SessionImpl();
            h5Session.setId(str);
            addSession(h5Session);
        }
        try {
            synchronized (this.ssListeners) {
                if (this.ssListeners.containsKey(str)) {
                    for (H5Listener addListener : this.ssListeners.remove(str)) {
                        h5Session.addListener(addListener);
                    }
                }
            }
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
        return h5Session;
    }

    public H5Session getSessionByWorkerId(String str) {
        Stack<H5Session> stack = this.sessions;
        if (stack == null) {
            return null;
        }
        synchronized (stack) {
            Iterator it2 = this.sessions.iterator();
            while (it2.hasNext()) {
                H5Session h5Session = (H5Session) it2.next();
                if (h5Session != null && TextUtils.equals(str, h5Session.getServiceWorkerID())) {
                    return h5Session;
                }
            }
            return null;
        }
    }

    public boolean removeSession(String str) {
        try {
            H5Log.d(TAG, "unregisterReceiver in removeSession");
            a.a(H5Environment.getContext()).a((BroadcastReceiver) this.ucIsReadyReceiver);
            a.a(H5Environment.getContext()).a((BroadcastReceiver) this.ucPageReadyReceiver);
            this.ucIsReadyReceiver = null;
            this.ucPageReadyReceiver = null;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.sessions) {
            Iterator it2 = this.sessions.iterator();
            while (it2.hasNext()) {
                H5Session h5Session = (H5Session) it2.next();
                if (str.equals(h5Session.getId())) {
                    this.ssListeners.remove(str);
                    it2.remove();
                    h5Session.setParent((H5CoreNode) null);
                    h5Session.onRelease();
                    return true;
                }
            }
            return false;
        }
    }

    public H5Session getTopSession() {
        synchronized (this.sessions) {
            if (this.sessions.isEmpty()) {
                return null;
            }
            H5Session peek = this.sessions.peek();
            return peek;
        }
    }

    public void onCreate(Context context) {
        try {
            fireIdleUcInit();
        } catch (Exception e2) {
            H5Log.e(TAG, "ui init ".concat(String.valueOf(e2)));
        }
        long currentTimeMillis = System.currentTimeMillis();
        H5Environment.setContext(context);
        H5NetworkUtil.getInstance().init(context);
        if (Nebula.DEBUG) {
            registerH5BugMeStartUp();
        }
        postInit();
        H5Log.d(TAG, "onCrate delta ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    private void postInit() {
        H5Log.d(TAG, "post init");
        if (Looper.myLooper() == null) {
            H5Log.d(TAG, "looper == null");
            Looper.prepare();
        }
        Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                NebulaServiceImpl.this.initWithDelay();
            }
        });
        handler.postDelayed(new Runnable() {
            public void run() {
                AndroidWebViewPreCreator.init();
            }
        }, com.alipay.mobile.c.a.f14948a);
    }

    /* access modifiers changed from: private */
    public void initWithDelay() {
        init();
    }

    private void init() {
        H5ThreadPoolFactory.getDefaultScheduledExecutor().schedule(new Runnable() {
            public void run() {
                try {
                    H5BridgePolicy.negotiate();
                } catch (Throwable th) {
                    H5Log.e(NebulaServiceImpl.TAG, th);
                }
                H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                if (h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_preParse_CommApp"))) {
                    if (H5Utils.isInTinyProcess()) {
                        H5Log.d(NebulaServiceImpl.TAG, "preLoadInTinyProcess");
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(H5Param.isTinyApp, true);
                        H5AppCenter.initTinyAppRes(bundle, true);
                        H5ViewCache.initViewCache();
                    }
                    H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
                    if (h5AppCenterPresetProvider != null) {
                        Set<String> enableDegradeApp = h5AppCenterPresetProvider.getEnableDegradeApp();
                        if (H5Utils.isInTinyProcess()) {
                            enableDegradeApp.add("20000202");
                        }
                        if (enableDegradeApp != null && !enableDegradeApp.isEmpty()) {
                            for (String prepareContent : enableDegradeApp) {
                                try {
                                    H5GlobalTempPkg.getInstance().prepareContent(prepareContent);
                                } catch (Throwable th2) {
                                    H5Log.e(NebulaServiceImpl.TAG, th2);
                                }
                            }
                        }
                    }
                }
            }
        }, (long) (H5Utils.isInTinyProcess() ? 2 : 5), TimeUnit.SECONDS);
    }

    private void registerH5BugMeStartUp() {
        if (this.bugMeReceiver == null) {
            this.bugMeReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    H5Log.d(NebulaServiceImpl.TAG, "h5bugMeStartUpReceiver" + NebulaServiceImpl.this.hashCode());
                    if (intent.getAction().equals(H5Param.H5_BUG_ME_STARTUP)) {
                        try {
                            if (intent.getExtras() == null || !TextUtils.equals(H5Utils.getString(intent.getExtras(), H5Param.H5_DEV_TYPE), H5Param.H5_DEV_H5APP)) {
                                NebulaServiceImpl.this.getBugMeManager().openSettingPanel(true);
                                return;
                            }
                            try {
                                Intent intent2 = new Intent(H5Environment.getContext(), H5DevSettingsActivity.class);
                                intent2.putExtra(H5Param.H5_DEV_TYPE, H5Param.H5_DEV_H5APP);
                                intent2.addFlags(268435456);
                                H5Environment.startActivity((H5Context) null, intent2);
                            } catch (Exception e2) {
                                H5Log.e(NebulaServiceImpl.TAG, (Throwable) e2);
                            }
                        } catch (Exception e3) {
                            H5Log.e(NebulaServiceImpl.TAG, (Throwable) e3);
                        }
                    }
                }
            };
            a a2 = a.a(H5Environment.getContext());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(H5Param.H5_BUG_ME_STARTUP);
            H5Log.d(TAG, "register h5bugMeStartUp");
            a2.a(this.bugMeReceiver, intentFilter);
        }
    }

    public boolean sendEvent(H5Event h5Event) {
        return Nebula.getDispatcher().dispatch(h5Event) == H5Event.Error.NONE;
    }

    public void addPluginConfig(H5PluginConfig h5PluginConfig) {
        H5PluginConfigManager.getInstance().addConfig(h5PluginConfig);
    }

    public H5ProviderManager getProviderManager() {
        return H5ProviderManagerImpl.getInstance();
    }

    public boolean isAliDomain(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            return h5ConfigProvider.isAliDomains(str);
        }
        H5Log.d(TAG, "not implement H5ConfigProvider.");
        return false;
    }

    public boolean permitLocation(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            return h5ConfigProvider.permitLocation(str);
        }
        H5Log.d(TAG, "not implement H5ConfigProvider.");
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean enableUseDevTool() {
        if (H5Utils.isMainProcess()) {
            return H5DevConfig.getBooleanConfig("h5_dev_webDriver", false);
        }
        H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
        if (h5EventHandlerService != null) {
            try {
                H5IpcServer h5IpcServer = (H5IpcServer) h5EventHandlerService.getIpcProxy(H5IpcServer.class);
                if (h5IpcServer != null) {
                    return h5IpcServer.getBooleanConfig("h5_dev_webDriver", false);
                }
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
        return false;
    }

    public H5WebDriverHelper getWebDriverHelper() {
        if (Nebula.DEBUG && this.webDriverHelper == null && !this.hasLoadDevHelp && enableUseDevTool()) {
            this.hasLoadDevHelp = true;
            try {
                Class<?> cls = H5Environment.getClass("android-phone-wallet-birdnestdevtools", "com.alipay.archimedes.ArchimedesHelper");
                if (cls != null) {
                    Field declaredField = cls.getDeclaredField("sharedInstance");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get((Object) null);
                    if (obj instanceof H5WebDriverHelper) {
                        H5Log.d(TAG, "getWebDriverHelper ".concat(String.valueOf(obj)));
                        this.webDriverHelper = (H5WebDriverHelper) obj;
                    }
                }
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
        H5WebDriverHelper h5WebDriverHelper = this.webDriverHelper;
        return h5WebDriverHelper == null ? H5WebDriverHelper.defaultHelper : h5WebDriverHelper;
    }

    public void setWebDriverHelper(H5WebDriverHelper h5WebDriverHelper) {
        this.webDriverHelper = h5WebDriverHelper;
    }

    public void setH5TaskScheduleProvider(H5TaskScheduleProvider h5TaskScheduleProvider2) {
        this.h5TaskScheduleProvider = h5TaskScheduleProvider2;
    }

    public H5TaskScheduleProvider getH5TaskScheduleProvider() {
        return this.h5TaskScheduleProvider;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void fireIdleUcInit() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.alipay.mobile.nebulacore.api.H5UcInitTask r0 = r4.idleTask     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            java.lang.String r0 = "H5NebulaService"
            java.lang.String r1 = "fire idle task to init uc service"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ all -> 0x0042 }
            com.alipay.mobile.nebulacore.api.H5UcInitTask r0 = new com.alipay.mobile.nebulacore.api.H5UcInitTask     // Catch:{ all -> 0x0042 }
            r1 = 0
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0042 }
            r4.idleTask = r0     // Catch:{ all -> 0x0042 }
            boolean r0 = com.alipay.mobile.nebula.util.H5Utils.isInTinyProcess()     // Catch:{ all -> 0x0042 }
            r1 = 10
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x0042 }
            com.alipay.mobile.nebulacore.api.H5UcInitTask r2 = r4.idleTask     // Catch:{ all -> 0x0042 }
            r0.<init>(r2)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "h5_tiny_initUc_idleTask"
            r0.setName(r2)     // Catch:{ all -> 0x0042 }
            r0.setPriority(r1)     // Catch:{ all -> 0x0042 }
            r0.start()     // Catch:{ all -> 0x0042 }
            monitor-exit(r4)
            return
        L_0x0033:
            com.alipay.mobile.nebula.provider.H5TaskScheduleProvider r0 = r4.h5TaskScheduleProvider     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0040
            com.alipay.mobile.nebula.provider.H5TaskScheduleProvider r0 = r4.h5TaskScheduleProvider     // Catch:{ all -> 0x0042 }
            com.alipay.mobile.nebulacore.api.H5UcInitTask r2 = r4.idleTask     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = "H5"
            r0.addIdleTask(r2, r3, r1)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r4)
            return
        L_0x0042:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.core.NebulaServiceImpl.fireIdleUcInit():void");
    }

    public synchronized void fireUrgentUcInit(Bundle bundle) {
        if (!H5Flag.ucReady) {
            H5Log.d(TAG, "fire urgent task to init uc service");
            H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new H5UcInitTask(true, bundle));
            return;
        }
        H5Log.d(TAG, "uc isReady");
    }

    public boolean exitService() {
        Iterator it2 = this.sessions.iterator();
        while (it2.hasNext()) {
            ((H5Session) it2.next()).exitSession();
        }
        return true;
    }

    public Stack<H5Session> getSessions() {
        return this.sessions;
    }

    public H5Data getData() {
        if (this.h5Data == null) {
            this.h5Data = (H5Data) Nebula.getProviderManager().getProvider(H5CacheProvider.class.getName());
        }
        return this.h5Data;
    }
}
