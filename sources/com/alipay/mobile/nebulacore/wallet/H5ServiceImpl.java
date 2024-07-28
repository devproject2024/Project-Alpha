package com.alipay.mobile.nebulacore.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.framework.app.e;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.api.H5BaseFragment;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Data;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Listener;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5PageReadyListener;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.api.H5SsoFlagHolder;
import com.alipay.mobile.h5container.api.H5UcReadyCallBack;
import com.alipay.mobile.h5container.api.H5WebDriverHelper;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.appcenter.common.NebulaCommonManager;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppManager;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.model.AppRes;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.config.H5EmbedViewConfig;
import com.alipay.mobile.nebula.config.H5PluginConfig;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.provider.H5AppBizRpcProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.provider.H5ServiceWorkerPushProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.TestDataUtils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.api.NebulaService;
import com.alipay.mobile.nebulacore.appcenter.H5IApplicationInstallerImpl;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalPackage;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg;
import com.alipay.mobile.nebulacore.config.H5PluginConfigManager;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.embedview.H5EmbededViewConfigManager;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5PluginManagerImpl;
import com.alipay.mobile.nebulacore.plugin.H5ActionSheetPlugin;
import com.alipay.mobile.nebulacore.plugin.H5AlertPlugin;
import com.alipay.mobile.nebulacore.plugin.H5HttpPlugin;
import com.alipay.mobile.nebulacore.plugin.H5LoadingPlugin;
import com.alipay.mobile.nebulacore.plugin.H5NotifyPlugin;
import com.alipay.mobile.nebulacore.plugin.H5SystemPlugin;
import com.alipay.mobile.nebulacore.web.H5HardwarePolicy;
import com.alipay.mobileappconfig.core.model.hybirdPB.PackInfoReq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class H5ServiceImpl extends H5Service {
    public static final String TAG = "H5ServiceImpl";
    public e iApplicationInstaller;

    public void preLoadInTinyProcess() {
    }

    public void onCreate(Bundle bundle) {
        H5Log.d(TAG, "onCreate");
        Nebula.getService().setH5TaskScheduleProvider(new H5TaskScheduleProviderImpl());
        NebulaService service = Nebula.getService();
        b.a();
        service.onCreate(b.c());
        H5Engine h5Engine = new H5Engine();
        c microApplicationContext = getMicroApplicationContext();
        if (!TextUtils.isEmpty(H5Service.H5APP_ENGINE_TYPE)) {
            microApplicationContext.f14960a.put(H5Service.H5APP_ENGINE_TYPE, h5Engine);
            return;
        }
        throw new IllegalArgumentException("engineType can't be empty");
    }

    public void onDestroy(Bundle bundle) {
        H5Log.d(TAG, "onDestroy");
    }

    public void setSharedData(String str, String str2) {
        H5Data data = Nebula.getService().getData();
        if (data != null) {
            data.set(str, str2);
        }
    }

    public String getSharedData(String str) {
        H5Data data = Nebula.getService().getData();
        if (data != null) {
            return data.get(str);
        }
        return null;
    }

    public void removeSharedData(String str) {
        H5Data data = Nebula.getService().getData();
        if (data != null) {
            data.remove(str);
        }
    }

    public boolean sendEvent(H5Event h5Event) {
        return Nebula.getService().sendEvent(h5Event);
    }

    public void setWebDriverHelper(H5WebDriverHelper h5WebDriverHelper) {
        Nebula.getService().setWebDriverHelper(h5WebDriverHelper);
    }

    public H5WebDriverHelper getWebDriverHelper() {
        return Nebula.getService().getWebDriverHelper();
    }

    public void startWebActivity(f fVar, Bundle bundle) {
        startWebActivity(fVar, bundle, (List<Object>) null);
    }

    public void startWebActivity(f fVar, Bundle bundle, List<Object> list) {
        H5Bundle h5Bundle = new H5Bundle();
        if (bundle == null) {
            bundle = new Bundle();
        }
        h5Bundle.setParams(bundle);
        startPage(fVar, h5Bundle);
    }

    private void setInitScene() {
        if (H5PageData.sCreateTimestamp < 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!H5Flag.ucReady) {
                H5PageData.setInitScenario(currentTimeMillis, 1);
            } else if (!H5Application.sNebulaReady) {
                H5PageData.setInitScenario(currentTimeMillis, 2);
            } else {
                H5PageData.setInitScenario(currentTimeMillis, 3);
            }
            H5Application.sNebulaReady = true;
        }
    }

    public void startPage(f fVar, final H5Bundle h5Bundle) {
        H5EventHandlerService h5EventHandlerService;
        H5EnvProvider h5EnvProvider;
        if (Nebula.DEBUG) {
            TestDataUtils.storeJSParams("pageLoad|startPagePoint", Long.valueOf(System.currentTimeMillis()));
        }
        if (H5PageData.iconClickTime == -1) {
            H5PageData.iconClickTime = System.currentTimeMillis();
        }
        H5PageData.launchAppFlag = true;
        H5PageData.walletServiceCreate = System.currentTimeMillis();
        setInitScene();
        if (h5Bundle == null) {
            H5Log.w(TAG, "invalid start page parameters!");
            return;
        }
        Bundle params = h5Bundle.getParams();
        if (params == null) {
            params = new Bundle();
            h5Bundle.setParams(params);
        }
        String string = H5Utils.getString(params, "url");
        if (TextUtils.isEmpty(string)) {
            string = H5Utils.getString(params, "u");
        }
        if (Nebula.enableOpenScheme(string)) {
            H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink");
            return;
        }
        if (H5Utils.isStripLandingURLEnable(string)) {
            String stripLandingURL = H5Utils.getStripLandingURL(string);
            if (!TextUtils.equals(string, stripLandingURL) && !TextUtils.isEmpty(stripLandingURL) && stripLandingURL.startsWith("alipay") && (h5EnvProvider = (H5EnvProvider) Nebula.getProviderManager().getProvider(H5EnvProvider.class.getName())) != null && h5EnvProvider.goToSchemeService(stripLandingURL)) {
                H5Log.d(TAG, "stripLandingURL&Deeplink url " + string + " bingo deeplink in landing");
                return;
            }
        }
        H5Log.d(TAG, "startPage appId ".concat(String.valueOf(fVar != null ? fVar.getAppId() : null)));
        try {
            H5Log.d(TAG, "in H5ServiceImpl, startParams is " + params.toString());
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        h5Bundle.addListener(new WalletListener(params));
        final WalletContext walletContext = new WalletContext((Context) null);
        walletContext.setMicroApplication(fVar);
        H5Log.d(TAG, "startPage execute runnable");
        H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
            public void run() {
                Nebula.getService().startPage(walletContext, h5Bundle);
            }
        });
        if (H5Utils.isInTinyProcess() && (h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName())) != null) {
            h5EventHandlerService.preConnectSpdy();
        }
    }

    public H5Page createPage(Activity activity, H5Bundle h5Bundle) {
        H5Log.d(TAG, "createPage ".concat(String.valueOf(activity)));
        if (Nebula.DEBUG) {
            TestDataUtils.storeJSParams("pageLoad|createPagePoint", Long.valueOf(System.currentTimeMillis()));
        }
        setInitScene();
        WalletContext walletContext = new WalletContext(activity);
        return Nebula.getService().createPage(walletContext, setCommonCreatePage(walletContext, h5Bundle));
    }

    public void createPageAsync(Activity activity, H5Bundle h5Bundle, H5PageReadyListener h5PageReadyListener) {
        H5Log.d(TAG, "createPageAsync ".concat(String.valueOf(activity)));
        if (Nebula.DEBUG) {
            TestDataUtils.storeJSParams("pageLoad|createPageAsyncPoint", Long.valueOf(System.currentTimeMillis()));
        }
        setInitScene();
        WalletContext walletContext = new WalletContext(activity);
        Nebula.getService().createPageAsync(walletContext, setCommonCreatePage(walletContext, h5Bundle), h5PageReadyListener);
    }

    private H5Bundle setCommonCreatePage(WalletContext walletContext, H5Bundle h5Bundle) {
        if (h5Bundle == null) {
            h5Bundle = new H5Bundle();
        }
        if (h5Bundle.getParams() == null) {
            h5Bundle.setParams(new Bundle());
        }
        f microApplication = H5WalletWrapper.getMicroApplication(walletContext);
        walletContext.setMicroApplication(microApplication);
        String str = null;
        if (microApplication != null) {
            str = microApplication.getAppId();
        }
        H5Log.d(TAG, "createPage appId ".concat(String.valueOf(str)));
        h5Bundle.addListener(new WalletListener(h5Bundle.getParams()));
        return h5Bundle;
    }

    public H5PluginManager getPluginManager() {
        return Nebula.getService().getPluginManager();
    }

    public void addPluginConfig(H5PluginConfig h5PluginConfig) {
        H5PluginConfigManager.getInstance().addConfig(h5PluginConfig);
    }

    public void addH5PluginConfigList(List<H5PluginConfig> list) {
        H5PluginConfigManager.getInstance().addH5PluginConfigList(list);
    }

    public void addEmbedViewConfig(H5EmbedViewConfig h5EmbedViewConfig) {
        H5EmbededViewConfigManager.getInstance().addTypeConfig(h5EmbedViewConfig);
    }

    public void addEmbedViewConfig(List<H5EmbedViewConfig> list) {
        H5EmbededViewConfigManager.getInstance().addTypeConfigs(list);
    }

    public H5ProviderManager getProviderManager() {
        return Nebula.getProviderManager();
    }

    public boolean isAliDomain(String str) {
        return Nebula.getService().isAliDomain(str);
    }

    public boolean permitLocation(String str) {
        return Nebula.getService().permitLocation(str);
    }

    class WalletListener implements H5Listener {
        private Bundle bundle;

        public void onPageCreated(H5Page h5Page) {
        }

        public void onPageDestroyed(H5Page h5Page) {
        }

        public WalletListener(Bundle bundle2) {
            this.bundle = bundle2;
        }

        public void onSessionCreated(H5Session h5Session) {
            if (h5Session instanceof H5SessionImpl) {
                ((H5SessionImpl) h5Session).setParams(this.bundle);
            }
            H5Log.d(H5ServiceImpl.TAG, "onSessionCreated ".concat(String.valueOf(H5Utils.getString(this.bundle, "appId"))));
        }

        public void onSessionDestroyed(H5Session h5Session) {
            H5SsoFlagHolder.setFlag("laiwangDomains", true);
        }
    }

    public void prepareApp(String str, String str2, H5AppInstallProcess h5AppInstallProcess) {
        Nebula.getService().prepareApp(str, str2, h5AppInstallProcess);
    }

    public void ucIsReady(H5UcReadyCallBack h5UcReadyCallBack) {
        Nebula.getService().ucIsReady(h5UcReadyCallBack);
    }

    public H5BugMeManager getBugMeManager() {
        return Nebula.getService().getBugMeManager();
    }

    public H5Page getTopH5Page() {
        return Nebula.getService().getTopH5Page();
    }

    public Fragment getTopH5Fragment() {
        return Nebula.getService().getTopH5Fragment();
    }

    public H5BaseFragment getTopH5BaseFragment() {
        return Nebula.getService().getTopH5BaseFragment();
    }

    public H5BaseFragment getTopH5BaseFragmentByWorkerId(String str) {
        return Nebula.getService().getTopH5BaseFragmentByWorkerId(str);
    }

    public H5BaseFragment getTopH5BaseFragmentByViewId(int i2) {
        return Nebula.getService().getTopH5BaseFragmentByViewId(i2);
    }

    public H5Session getSessionByWorkerId(String str) {
        return Nebula.getService().getSessionByWorkerId(str);
    }

    public H5Session getTopSession() {
        return Nebula.getService().getTopSession();
    }

    public void prepareRNApp(String str, H5AppInstallProcess h5AppInstallProcess) {
        Nebula.getService().prepareRNApp(str, h5AppInstallProcess);
    }

    public int parseRNPkg(String str) {
        return Nebula.getService().parseRNPkg(str);
    }

    public void initServicePlugin() {
        Nebula.getService().initServicePlugin();
    }

    public boolean sendEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        return Nebula.getDispatcher().dispatch(h5Event, h5BridgeContext) == H5Event.Error.NONE;
    }

    public H5CoreNode getItsOwnNode() {
        return Nebula.getService();
    }

    public H5Plugin createPlugin(String str, H5PluginManager h5PluginManager) {
        if (H5Param.PAGE.equals(str)) {
            h5PluginManager.register((H5Plugin) new H5HttpPlugin());
            h5PluginManager.register((H5Plugin) new H5NotifyPlugin());
            h5PluginManager.register((H5Plugin) new H5LoggerPlugin());
        }
        return H5PluginConfigManager.getInstance().createPlugin(str, h5PluginManager);
    }

    public H5Plugin createPlugin(String str, H5Page h5Page, H5PluginManager h5PluginManager) {
        if (H5Param.PAGE.equals(str)) {
            h5PluginManager.register((H5Plugin) new H5HttpPlugin());
            h5PluginManager.register((H5Plugin) new H5SystemPlugin());
            h5PluginManager.register((H5Plugin) new H5NotifyPlugin());
            h5PluginManager.register((H5Plugin) new H5LoggerPlugin());
            h5PluginManager.register((H5Plugin) new H5AlertPlugin());
            h5PluginManager.register((H5Plugin) new H5LoadingPlugin(h5Page));
            h5PluginManager.register((H5Plugin) new H5ActionSheetPlugin());
        }
        return H5PluginConfigManager.getInstance().createPlugin(str, h5PluginManager);
    }

    public H5PluginManager createPluginManager(H5CoreNode h5CoreNode) {
        return new H5PluginManagerImpl(h5CoreNode);
    }

    public NebulaAppManager getNebulaAppManager() {
        return Nebula.getService().getNebulaAppManager();
    }

    public NebulaCommonManager getNebulaCommonManager() {
        return Nebula.getService().getNebulaCommonManager();
    }

    public Class[] getProcessH5Activity() {
        return Nebula.LITE_PROCESS_H5_ACTIVITY;
    }

    public Class[] getProcessH5TransActivity() {
        return Nebula.LITE_PROCESS_H5TRANS_ACTIVITY;
    }

    public void sendServiceWorkerPushMessage(HashMap<String, String> hashMap) {
        sendServiceWorkerPushMessage(hashMap, (H5CallBack) null);
    }

    public void sendServiceWorkerPushMessage(final HashMap<String, String> hashMap, final H5CallBack h5CallBack) {
        if (!H5Flag.ucReady) {
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public void run() {
                    UcService ucService = H5Environment.getUcService();
                    if (ucService == null) {
                        H5Log.e(H5ServiceImpl.TAG, "ucService == null");
                        return;
                    }
                    if (Nebula.disableHWACByUCStyle()) {
                        ucService.init(!H5HardwarePolicy.disableHardwareAccelerate((Bundle) null, (String) null));
                    } else {
                        ucService.init(H5HardwarePolicy.isAbove14Level());
                    }
                    H5ServiceImpl.this.sendPushMsg(hashMap, h5CallBack);
                }
            });
        } else {
            sendPushMsg(hashMap, h5CallBack);
        }
    }

    /* access modifiers changed from: private */
    public void sendPushMsg(HashMap<String, String> hashMap, H5CallBack h5CallBack) {
        H5ServiceWorkerPushProvider h5ServiceWorkerPushProvider = (H5ServiceWorkerPushProvider) getProviderManager().getProvider(H5ServiceWorkerPushProvider.class.getName());
        if (h5ServiceWorkerPushProvider == null) {
            H5Log.w(TAG, "sendServiceWorkerPushMessage provider == null");
        } else if (h5CallBack == null) {
            h5ServiceWorkerPushProvider.sendServiceWorkerPushMessage(hashMap);
        } else {
            h5ServiceWorkerPushProvider.sendServiceWorkerPushMessage(hashMap, h5CallBack);
        }
    }

    public void clearServiceWorker(final String str) {
        try {
            if (!H5Flag.ucReady) {
                H5Log.w(TAG, "clearServiceWorker !H5Flag.ucReady");
                H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                    public void run() {
                        UcService ucService = H5Environment.getUcService();
                        if (ucService == null) {
                            H5Log.e(H5ServiceImpl.TAG, "ucService == null");
                            return;
                        }
                        if (Nebula.disableHWACByUCStyle()) {
                            ucService.init(!H5HardwarePolicy.disableHardwareAccelerate((Bundle) null, (String) null));
                        } else {
                            ucService.init(H5HardwarePolicy.isAbove14Level());
                        }
                        H5ServiceImpl.this.clearWork(str);
                    }
                });
                return;
            }
            clearWork(str);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public void clearServiceWorkerSync(final String str, final H5CallBack h5CallBack) {
        try {
            if (!H5Flag.ucReady) {
                H5Log.w(TAG, "clearServiceWorkerSync !H5Flag.ucReady");
                H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                    public void run() {
                        UcService ucService = H5Environment.getUcService();
                        if (ucService == null) {
                            H5Log.e(H5ServiceImpl.TAG, "ucService == null");
                            return;
                        }
                        if (Nebula.disableHWACByUCStyle()) {
                            ucService.init(!H5HardwarePolicy.disableHardwareAccelerate((Bundle) null, (String) null));
                        } else {
                            ucService.init(H5HardwarePolicy.isAbove14Level());
                        }
                        H5ServiceImpl.this.clearWorkSync(str, h5CallBack);
                    }
                });
                return;
            }
            clearWorkSync(str, h5CallBack);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    /* access modifiers changed from: private */
    public void clearWork(String str) {
        H5ServiceWorkerPushProvider h5ServiceWorkerPushProvider = (H5ServiceWorkerPushProvider) getProviderManager().getProvider(H5ServiceWorkerPushProvider.class.getName());
        if (h5ServiceWorkerPushProvider != null) {
            h5ServiceWorkerPushProvider.clearServiceWorker(str);
        } else {
            H5Log.w(TAG, "clearWork provider == null");
        }
    }

    /* access modifiers changed from: private */
    public void clearWorkSync(String str, H5CallBack h5CallBack) {
        H5ServiceWorkerPushProvider h5ServiceWorkerPushProvider = (H5ServiceWorkerPushProvider) getProviderManager().getProvider(H5ServiceWorkerPushProvider.class.getName());
        if (h5ServiceWorkerPushProvider != null) {
            h5ServiceWorkerPushProvider.clearServiceWorkerSync(str, h5CallBack);
        } else {
            H5Log.w(TAG, "clearWorkSync provider == null");
        }
    }

    public Stack<H5Session> getSessions() {
        return Nebula.getService().getSessions();
    }

    public void sendToWebFromMainProcess(final String str, final String str2, final com.alibaba.a.e eVar) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                H5Bridge bridge;
                H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
                if (h5AppProvider != null) {
                    boolean isXiaoChengXu = h5AppProvider.isXiaoChengXu(str);
                    H5Log.d(H5ServiceImpl.TAG, "appId " + str + " action:" + str2 + " jsonObject:" + eVar + " openMulti " + isXiaoChengXu);
                    if (!isXiaoChengXu) {
                        H5Page topH5Page = H5ServiceImpl.this.getTopH5Page();
                        if (topH5Page != null && (bridge = topH5Page.getBridge()) != null) {
                            bridge.sendToWeb(str2, eVar, (H5CallBack) null);
                            return;
                        }
                        return;
                    }
                    H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
                    if (h5EventHandlerService != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(H5Param.FUNC, str2);
                        com.alibaba.a.e eVar = eVar;
                        if (eVar != null) {
                            bundle.putString(H5Param.PARAM, eVar.toString());
                        }
                        h5EventHandlerService.sendDataToTinyProcess(str, bundle);
                    }
                }
            }
        });
    }

    public void startPageFromActivity(final Activity activity, final H5Bundle h5Bundle) {
        H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
            public void run() {
                Nebula.getService().startPage(new H5Context(activity), h5Bundle);
            }
        });
    }

    public void savePackJson(String str) {
        H5AppBizRpcProvider h5AppBizRpcProvider;
        H5Log.d(TAG, "savePackJson ".concat(String.valueOf(str)));
        if (Nebula.DEBUG && H5Utils.isMain()) {
            throw new RuntimeException("not invoke on ui thread!!!");
        } else if (!TextUtils.isEmpty(str) && (h5AppBizRpcProvider = (H5AppBizRpcProvider) Nebula.getProviderManager().getProvider(H5AppBizRpcProvider.class.getName())) != null) {
            AppRes handlerPkgJson = h5AppBizRpcProvider.handlerPkgJson(str);
            H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
            if (h5AppCenterService != null) {
                h5AppCenterService.setUpInfo(handlerPkgJson, true, true);
            }
        }
    }

    public PackInfoReq generatePackInfoReq(List<String> list) {
        if (!Nebula.DEBUG || !H5Utils.isMain()) {
            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
            AppReq appReq = new AppReq();
            if (h5AppProvider != null) {
                appReq.stableRpc = H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO;
                appReq = h5AppProvider.makeAppReq((Map<String, String>) null, true, appReq, (List<String>) null);
            }
            if (appReq == null) {
                H5Log.e(TAG, "appReq == null ");
                appReq = new AppReq();
            }
            com.alibaba.a.e eVar = new com.alibaba.a.e();
            for (String next : list) {
                com.alibaba.a.e eVar2 = new com.alibaba.a.e();
                eVar2.put("app_id", (Object) next);
                eVar2.put("version", (Object) h5AppProvider != null ? h5AppProvider.getWalletConfigNebulaVersion(next) : "");
                eVar.put(next, (Object) eVar2);
            }
            if (!eVar.isEmpty()) {
                appReq.query = eVar.toJSONString();
            }
            H5Log.d(TAG, "appReq.query : " + appReq.query);
            return H5AppUtil.getPkgReqFromAppReq(appReq);
        }
        throw new RuntimeException("not invoke on ui thread!!!");
    }

    public e H5IApplicationInstaller() {
        if (this.iApplicationInstaller == null) {
            this.iApplicationInstaller = new H5IApplicationInstallerImpl();
        }
        return this.iApplicationInstaller;
    }

    public byte[] getH5GlobalDegradePkg(String str) {
        byte[] content = H5GlobalTempPkg.getInstance().getContent(str);
        if (content != null) {
            return content;
        }
        return H5GlobalPackage.getContent(str);
    }

    public void fireUrgentUcInit() {
        Nebula.getService().fireUrgentUcInit();
    }
}
