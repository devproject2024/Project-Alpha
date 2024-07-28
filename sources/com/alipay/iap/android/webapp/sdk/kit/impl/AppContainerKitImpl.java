package com.alipay.iap.android.webapp.sdk.kit.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.alipay.iap.android.common.a.a;
import com.alipay.iap.android.common.a.b;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.app.AppSessionListener;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.iap.android.webapp.sdk.app.WebAppListener;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManager;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKit;
import com.alipay.iap.android.webapp.sdk.kit.AppContainerKitConfig;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.util.monitor.SwitchConfig;
import com.alipay.mobile.nebulaappcenter.H5AppCenterServiceImpl;
import com.alipay.mobile.nebulacore.wallet.H5ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppContainerKitImpl extends AppContainerKit {
    private static AppContainerKitImpl INSTANCE = null;
    private static final String TAG = "AppContainerKitImpl";
    private static b monitorSwitchListener = new b() {
        public final void onConfigChanged(String str, String str2) {
            if (TextUtils.equals(str, H5Monitor.KEY_MONITOR_SWITCH)) {
                AppContainerKitImpl.dealWithSwitchConfig(str2);
            }
        }
    };
    private AppManager mAppManagerFacade = new AppManager();
    private AppContainerManager mContainerManager = new AppContainerManager();
    private Context mContext;
    private AppContainerKitConfig mKitConfig;

    interface ServiceCreator<T> {
        T createService();
    }

    public static AppContainerKitImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppContainerKitImpl();
        }
        return INSTANCE;
    }

    private AppContainerKitImpl() {
    }

    private void initH5MonitorConfig() {
        String a2 = a.a().a(H5Monitor.KEY_MONITOR_SWITCH);
        a.a().a(H5Monitor.KEY_MONITOR_SWITCH, monitorSwitchListener);
        dealWithSwitchConfig(a2);
    }

    /* access modifiers changed from: private */
    public static void dealWithSwitchConfig(String str) {
        try {
            H5Monitor.setSwitchConfig((SwitchConfig) com.alibaba.a.a.parseObject(str, SwitchConfig.class));
        } catch (Exception e2) {
            H5Log.e(TAG, "parse monitor config failed", e2);
        }
    }

    public void initialize(Application application, AppContainerKitConfig appContainerKitConfig) {
        c.e();
        if (this.mContext == null) {
            initH5MonitorConfig();
            long currentTimeMillis = System.currentTimeMillis();
            H5Monitor.behavior(new H5MonitorModel().start().seedId(H5MonitorModel.SEED_ID_INIT_CONTAINER));
            this.mContext = application;
            this.mKitConfig = appContainerKitConfig;
            com.alipay.mobile.c.a.f14948a = appContainerKitConfig.checkPreCreateWebViewDelay;
            if (com.alipay.mobile.c.a.f14950c == null && application != null) {
                com.alipay.mobile.c.a.f14950c = application;
                com.alipay.mobile.c.a.f14949b = application.getApplicationContext();
                com.alipay.mobile.framework.b.b bVar = new com.alipay.mobile.framework.b.b();
                bVar.f14959b = "com.alipay.mobile.h5container.service.H5Service";
                bVar.f14958a = "com.alipay.mobile.nebulacore.wallet.H5ServiceImpl";
                com.alipay.mobile.c.a.a(bVar);
                com.alipay.mobile.framework.b.b bVar2 = new com.alipay.mobile.framework.b.b();
                bVar2.f14959b = "com.alipay.mobile.h5container.service.H5AppCenterService";
                bVar2.f14958a = "com.alipay.mobile.nebulaappcenter.H5AppCenterServiceImpl";
                com.alipay.mobile.c.a.a(bVar2);
                com.alipay.mobile.framework.b.b bVar3 = new com.alipay.mobile.framework.b.b();
                bVar3.f14959b = "com.alipay.mobile.h5container.service.UcService";
                bVar3.f14958a = "com.alipay.mobile.nebulauc.impl.UcServiceImpl";
                com.alipay.mobile.c.a.a(bVar3);
                com.alipay.mobile.framework.b.b bVar4 = new com.alipay.mobile.framework.b.b();
                bVar4.f14959b = "com.alipay.mobile.h5container.service.H5ConfigService";
                bVar4.f14958a = "com.alipay.mobile.nebulaconfig.service.H5ConfigServiceImpl";
                com.alipay.mobile.c.a.a(bVar4);
            }
            initCompatible();
            initH5Services();
            this.mContainerManager.initialize(this.mContext);
            this.mAppManagerFacade.initialize(this.mContext);
            H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_INIT_CONTAINER).appendCostTime(System.currentTimeMillis() - currentTimeMillis));
            H5PageData.firstLaunchFlag = true;
        }
    }

    public Application getApplication() {
        return (Application) this.mContext;
    }

    public AppContainerKitConfig getKitConfig() {
        return this.mKitConfig;
    }

    private void initCompatible() {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                CookieSyncManager.createInstance(this.mContext);
            } catch (Throwable unused) {
                c.h();
            }
        }
    }

    private void initH5Services() {
        ensureService(H5Service.class, new ServiceCreator<H5Service>() {
            public H5Service createService() {
                return new H5ServiceImpl();
            }
        });
        ensureService(H5AppCenterService.class, new ServiceCreator<H5AppCenterService>() {
            public H5AppCenterService createService() {
                return new H5AppCenterServiceImpl();
            }
        });
    }

    private <T> void ensureService(Class<T> cls, ServiceCreator<T> serviceCreator) {
        String name = cls.getName();
        if (H5Utils.findServiceByInterface(name) == null) {
            com.alipay.mobile.framework.b.a.a().a(name, serviceCreator.createService());
        }
    }

    public void startContainerActivity(Context context, Bundle bundle, WebAppListener webAppListener) {
        H5PageData.iconClickTime = System.currentTimeMillis();
        c.e();
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        H5Bundle h5Bundle = getH5Bundle(bundle, webAppListener);
        if (context instanceof Activity) {
            h5Service.startPageFromActivity((Activity) context, h5Bundle);
        } else {
            h5Service.startPage((f) null, h5Bundle);
        }
    }

    public void configSubapps(Map<String, SubAppConfig> map, List<String> list) {
        this.mAppManagerFacade.handlePackages(map, list);
    }

    public List<String> getResourceAppIds() {
        return this.mAppManagerFacade.getSharedPackages();
    }

    public void configCommonResource(Map<String, SubAppConfig> map) {
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, SubAppConfig> key : map.entrySet()) {
                arrayList.add(key.getKey());
            }
            this.mAppManagerFacade.handlePackages(map, arrayList);
        }
    }

    public void configSubappsOnly(Map<String, SubAppConfig> map) {
        this.mAppManagerFacade.handlePackages(map);
    }

    public String getOnlineAppId(String str) {
        return this.mAppManagerFacade.getOnlineAppId(str);
    }

    public void openUrl(Context context, String str, Bundle bundle, WebAppListener webAppListener) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("url", str);
        startContainerActivity(context, bundle, webAppListener);
    }

    public void openUrl(Context context, String str) {
        openUrl(context, str, (Bundle) null);
    }

    public void openApp(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        startContainerActivity(context, bundle);
    }

    public void registerPlugin(H5Plugin h5Plugin) {
        this.mContainerManager.registerPlugin(h5Plugin);
    }

    public void unRegisterPlugin(H5Plugin h5Plugin) {
        this.mContainerManager.unRegisterPlugin(h5Plugin);
    }

    public void setProvider(String str, Object obj) {
        this.mContainerManager.setProvider(str, obj);
    }

    public H5Bundle getH5Bundle(Bundle bundle, WebAppListener webAppListener) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("url", bundle.getString("url", (String) null));
        bundle2.putString(H5Param.LONG_DEFAULT_TITLE, bundle.getString(H5Param.LONG_DEFAULT_TITLE, ""));
        bundle2.putString("showLoading", bundle.getString("showLoading", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO));
        bundle2.putString("showTitleLoading", bundle.getString("showTitleLoading", H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO));
        bundle2.putString(H5Param.LONG_SHOW_PROGRESS, bundle.getString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        bundle2.putBoolean("showOptionMenu", false);
        bundle2.putString(H5Param.LONG_BACK_BEHAVIOR, bundle.getString(H5Param.LONG_BACK_BEHAVIOR, H5Param.DEFAULT_LONG_BACK_BEHAVIOR));
        bundle2.putString("adjustResize", bundle.getString("adjustResize", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        H5Bundle h5Bundle = new H5Bundle();
        h5Bundle.setParams(bundle2);
        AppSessionListener appSessionListener = new AppSessionListener(bundle);
        if (webAppListener != null) {
            appSessionListener.addWebAppListener(webAppListener);
        }
        h5Bundle.addListener(appSessionListener);
        this.mAppManagerFacade.handleBundleForH5Page(h5Bundle);
        return h5Bundle;
    }

    public void release() {
        super.release();
        a.a().a(monitorSwitchListener);
    }
}
