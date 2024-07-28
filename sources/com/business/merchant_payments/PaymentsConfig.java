package com.business.merchant_payments;

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
import com.business.merchant_payments.common.repo.AppExecutors;
import com.business.merchant_payments.common.utility.APSharedPreferences;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.utility.APKotlinNetworkService;
import com.business.merchant_payments.utility.MPConstants;
import com.business.merchant_payments.utility.NetworkService;
import com.paytm.utility.x;

public class PaymentsConfig {
    public static PaymentsConfig instance;
    public static AppExecutors sAppExecutors;
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
    public APKotlinNetworkService kotlinNetworkService;
    public Context mAppContext;
    public final i merchantDataProvider;
    public final g nativeAppKeyManager;
    public NetworkService networkService;

    public PaymentsConfig(PaymentsInitConfig paymentsInitConfig) {
        this.application = paymentsInitConfig.getApplication();
        this.mAppContext = paymentsInitConfig.getAppContext();
        this.commonUtils = paymentsInitConfig.getCommonUtils();
        this.merchantDataProvider = paymentsInitConfig.getMerchantDataProvider();
        this.appSharedPreference = paymentsInitConfig.getAppSharedPreference();
        this.deepLinkUtils = paymentsInitConfig.getDeepLinkUtils();
        this.errorHandlerListener = paymentsInitConfig.getErrorHandler();
        this.appKeys = paymentsInitConfig.getAppKeys();
        this.eventPublisher = paymentsInitConfig.getGaEventPublisher();
        this.GTMDataProvider = paymentsInitConfig.getGtmDataProvider();
        this.deepLinkTargetScreenIntentString = paymentsInitConfig.getDeepLinkTargetScreenIntentString();
        this.hawkEyeNetworkInterface = paymentsInitConfig.getHawkEyeNetworkInterface();
        this.commonHeaderInterface = paymentsInitConfig.getCommonHeaderInterface();
        this.nativeAppKeyManager = paymentsInitConfig.getNativeAppKeyManager();
        this.clientName = paymentsInitConfig.getClientName();
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

    public i getMerchantDataProvider() {
        return this.merchantDataProvider;
    }

    public NetworkService getNetworkService() {
        if (this.networkService == null) {
            this.networkService = (NetworkService) NetworkDataImpl.getAPIService(NetworkService.class, false);
        }
        return this.networkService;
    }

    public APKotlinNetworkService getKotlinNetworkService() {
        if (this.kotlinNetworkService == null) {
            this.kotlinNetworkService = (APKotlinNetworkService) NetworkDataImpl.getAPIService(APKotlinNetworkService.class, false);
        }
        return this.kotlinNetworkService;
    }

    public static PaymentsConfig getInstance() {
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

    public static void init(PaymentsInitConfig paymentsInitConfig) {
        if (instance == null) {
            instance = new PaymentsConfig(paymentsInitConfig);
        }
        if (MPConstants.isP4BClient()) {
            initLibraries();
        }
    }

    public AppExecutors getAppExecutors() {
        if (sAppExecutors == null) {
            sAppExecutors = new AppExecutors();
        }
        return sAppExecutors;
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

    public void onSignOut(Context context) {
        APSharedPreferences.getInstance().onSignOut(context);
    }

    public void onSignOut() {
        APSharedPreferences.getInstance().onSignOut();
    }
}
