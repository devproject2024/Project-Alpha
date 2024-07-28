package com.paytm.business.merchantprofile;

import android.app.Application;
import android.content.Context;
import com.business.a.a;
import com.business.common_module.b.b;
import com.business.common_module.b.c;
import com.business.common_module.b.d;
import com.business.common_module.b.e;
import com.business.common_module.b.f;
import com.business.common_module.b.g;
import com.business.common_module.b.h;
import com.business.common_module.b.i;
import com.business.common_module.b.j;
import com.paytm.business.merchantprofile.common.NetworkDataImpl;
import com.paytm.business.merchantprofile.common.ProfileConstants;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.common.utility.NetworkService;
import com.paytm.business.merchantprofile.common.utility.ProfileKotlinNetworkService;
import com.paytm.business.merchantprofile.common.utility.ProfileSharedPreferences;
import com.paytm.utility.x;

public class ProfileConfig {
    public static ProfileConfig instance;
    public final f GTMDataProvider;
    public final h appKeys;
    public final j appSharedPreference;
    public Application application;
    public final String clientName;
    public final a.C0102a commonHeaderInterface;
    public final b commonUtils;
    public final String deepLinkTargetScreenIntentString;
    public final c deepLinkUtils;
    public final d errorHandlerListener;
    public final e eventPublisher;
    public final a.b hawkEyeNetworkInterface;
    public ProfileKotlinNetworkService kotlinNetworkService;
    public Context mAppContext;
    public final i merchantDataProvider;
    public final g nativeAppKeyManager;
    public NetworkService networkService;

    public ProfileConfig(ProfileInitConfig profileInitConfig) {
        this.application = profileInitConfig.getApplication();
        this.mAppContext = profileInitConfig.getAppContext();
        this.commonUtils = profileInitConfig.getCommonUtils();
        this.appSharedPreference = profileInitConfig.getAppSharedPreference();
        this.deepLinkUtils = profileInitConfig.getDeepLinkUtils();
        this.errorHandlerListener = profileInitConfig.getErrorHandler();
        this.merchantDataProvider = profileInitConfig.getMerchantDataProvider();
        this.appKeys = profileInitConfig.getAppKeys();
        this.eventPublisher = profileInitConfig.getGaEventPublisher();
        this.GTMDataProvider = profileInitConfig.getGTMDataProvider();
        this.deepLinkTargetScreenIntentString = profileInitConfig.getDeepLinkTargetScreenIntentString();
        this.hawkEyeNetworkInterface = profileInitConfig.getHawkEyeNetworkInterface();
        this.commonHeaderInterface = profileInitConfig.getCommonHeaderInterface();
        this.nativeAppKeyManager = profileInitConfig.getNativeAppKeyManager();
        this.clientName = profileInitConfig.getClientName();
    }

    public String getClientName() {
        return this.clientName;
    }

    public Application getApplication() {
        return this.application;
    }

    public f getGTMDataProvider() {
        return this.GTMDataProvider;
    }

    public i getMerchantDataProvider() {
        return this.merchantDataProvider;
    }

    public b getCommonUtils() {
        return this.commonUtils;
    }

    public j getAppSharedPreference() {
        return this.appSharedPreference;
    }

    public c getDeepLinkUtils() {
        return this.deepLinkUtils;
    }

    public d getErrorHandlerListener() {
        return this.errorHandlerListener;
    }

    public h getAppKeys() {
        return this.appKeys;
    }

    public e getEventPublisher() {
        return this.eventPublisher;
    }

    public NetworkService getNetworkService() {
        if (this.networkService == null) {
            this.networkService = (NetworkService) NetworkDataImpl.getAPIService(NetworkService.class, false);
        }
        return this.networkService;
    }

    public ProfileKotlinNetworkService getKotlinNetworkService() {
        if (this.kotlinNetworkService == null) {
            this.kotlinNetworkService = (ProfileKotlinNetworkService) NetworkDataImpl.getAPIService(ProfileKotlinNetworkService.class, false);
        }
        return this.kotlinNetworkService;
    }

    public static ProfileConfig getInstance() {
        return instance;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public a.b getHawkEyeNetworkInterface() {
        return this.hawkEyeNetworkInterface;
    }

    public a.C0102a getCommonHeaderInterface() {
        return this.commonHeaderInterface;
    }

    public static void init(ProfileInitConfig profileInitConfig) {
        if (instance == null) {
            instance = new ProfileConfig(profileInitConfig);
        }
        if (ProfileConstants.isP4BClient()) {
            initLibraries();
        }
    }

    public static void initLibraries() {
        x.a(AppConstants.KeyValues.APP_CLIENT, AppConstants.KeyValues.CLIENT_ID, AppConstants.KeyValues.CLIENT_SECRET, AppConstants.KeyValues.AUTHORIZATION_VALUE, getInstance().getNativeAppKeyManager().a(), "1", "1", "paytmba", "prod");
        com.paytm.network.b.i.a(getInstance().getNativeAppKeyManager().a(), "1", "1");
        com.paytm.network.i.a();
        com.paytm.network.i.f42955b = false;
        com.paytm.network.i.f42954a = 100;
        com.paytm.network.a.a.a.a();
    }

    public String getDeepLinkTargetScreenIntentString() {
        return this.deepLinkTargetScreenIntentString;
    }

    public g getNativeAppKeyManager() {
        return this.nativeAppKeyManager;
    }

    public void onSigbOut(Context context) {
        ProfileSharedPreferences.getInstance().onSignOut(context);
    }

    public void onSignOut() {
        ProfileSharedPreferences.getInstance().onSignOut();
    }
}
