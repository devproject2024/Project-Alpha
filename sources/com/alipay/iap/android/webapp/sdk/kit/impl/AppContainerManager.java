package com.alipay.iap.android.webapp.sdk.kit.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.a.a;
import com.alipay.iap.android.common.a.b;
import com.alipay.iap.android.common.b.c;
import com.alipay.iap.android.webapp.sdk.plugin.LoadLocalImagePlugin;
import com.alipay.iap.android.webapp.sdk.provider.AppProvider;
import com.alipay.iap.android.webapp.sdk.provider.IAPLogProvider;
import com.alipay.iap.android.webapp.sdk.provider.OKHttpDownloadManager;
import com.alipay.iap.android.webapp.sdk.provider.PresetProvider;
import com.alipay.iap.android.webapp.sdk.provider.PublicRsaProvider;
import com.alipay.iap.android.webapp.sdk.provider.UaProvider;
import com.alipay.iap.android.webapp.sdk.provider.UrlMapProvider;
import com.alipay.iap.android.webapp.sdk.provider.VersionLabelProvider;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.download.H5ExternalDownloadManager;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5AppUrlMapProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5NebulaLabelProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.provider.H5PublicRsaProvider;
import com.alipay.mobile.nebula.provider.H5UaProvider;
import com.alipay.mobile.nebula.util.H5Utils;

public class AppContainerManager {
    private static final String E2E_LOG_ENABLE = "yes";
    private static final String KEY_E2E_LOG_ENABLE = "h5_e2e_log_enable";
    private static final String KEY_USE_EXTERNAL_DOWNLOADER = "h5_container_download_provider_enable";
    private static final String TAG = "AppContainerManager";
    private static final String USE_EXTERNAL_DOWNLOADER_ENABLE = "yes";
    private static b downloaderSwitchListener = new b() {
        public final void onConfigChanged(String str, String str2) {
            if (TextUtils.equals(str, AppContainerManager.KEY_USE_EXTERNAL_DOWNLOADER)) {
                AppContainerManager.dealWithDownloaderSwitch(str2);
            }
        }
    };
    private static b e2eLogSwitchListener = new b() {
        public final void onConfigChanged(String str, String str2) {
            if (TextUtils.equals(str, AppContainerManager.KEY_E2E_LOG_ENABLE)) {
                AppContainerManager.dealWithE2ELogProvider(str2);
            }
        }
    };

    public void initialize(Context context) {
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        initPlugins(h5Service.getPluginManager());
        initProviders(h5Service.getProviderManager());
    }

    private void initPlugins(H5PluginManager h5PluginManager) {
        c.e();
        h5PluginManager.register((H5Plugin) new LoadLocalImagePlugin());
    }

    private void initProviders(H5ProviderManager h5ProviderManager) {
        c.e();
        h5ProviderManager.setProvider(H5NebulaLabelProvider.class.getName(), new VersionLabelProvider());
        h5ProviderManager.setProvider(H5AppProvider.class.getName(), new AppProvider());
        h5ProviderManager.setProvider(H5AppUrlMapProvider.class.getName(), new UrlMapProvider());
        h5ProviderManager.setProvider(H5PublicRsaProvider.class.getName(), new PublicRsaProvider());
        h5ProviderManager.setProvider(H5AppCenterPresetProvider.class.getName(), new PresetProvider());
        h5ProviderManager.setProvider(H5UaProvider.class.getName(), new UaProvider());
        String a2 = a.a().a(KEY_USE_EXTERNAL_DOWNLOADER);
        a.a().a(KEY_USE_EXTERNAL_DOWNLOADER, downloaderSwitchListener);
        dealWithDownloaderSwitch(a2);
        initE2ELogProvider();
    }

    private void initE2ELogProvider() {
        dealWithE2ELogProvider(a.a().a(KEY_E2E_LOG_ENABLE));
        a.a().a(KEY_E2E_LOG_ENABLE, e2eLogSwitchListener);
    }

    /* access modifiers changed from: private */
    public static void dealWithE2ELogProvider(String str) {
        H5ProviderManager providerManager = ((H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())).getProviderManager();
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(str)) {
            providerManager.setProvider(H5LogProvider.class.getName(), new IAPLogProvider());
        } else {
            providerManager.removeProvider(H5LogProvider.class.getName());
        }
    }

    /* access modifiers changed from: private */
    public static void dealWithDownloaderSwitch(String str) {
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        if (TextUtils.isEmpty(str)) {
            initOKHttpDownloaderProvider(h5Service.getProviderManager());
        } else if (str.equalsIgnoreCase(H5AppHandler.CHECK_VALUE)) {
            initOKHttpDownloaderProvider(h5Service.getProviderManager());
        } else {
            h5Service.getProviderManager().removeProvider(H5ExternalDownloadManager.class.getName());
        }
    }

    private static void initOKHttpDownloaderProvider(H5ProviderManager h5ProviderManager) {
        try {
            Class.forName("okhttp3.OkHttpClient");
            Class.forName("okhttp3.Request");
            Class.forName("okhttp3.Response");
            Class.forName("okhttp3.Call");
            h5ProviderManager.setProvider(H5ExternalDownloadManager.class.getName(), new OKHttpDownloadManager());
        } catch (ClassNotFoundException unused) {
            c.i();
        }
    }

    public void registerPlugin(H5Plugin h5Plugin) {
        ((H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())).getPluginManager().register(h5Plugin);
    }

    public void unRegisterPlugin(H5Plugin h5Plugin) {
        ((H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())).getPluginManager().unregister(h5Plugin);
    }

    public void setProvider(String str, Object obj) {
        ((H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())).getProviderManager().setProvider(str, obj);
    }
}
