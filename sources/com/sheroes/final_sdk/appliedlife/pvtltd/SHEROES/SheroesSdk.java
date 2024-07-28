package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.DaggerSheroesAppComponent;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppComponent;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppModule;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception.SheroesException;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.internel.Validate;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import java.io.File;
import java.util.Map;

public class SheroesSdk {
    private static AnalyticsCallback analyticsCallback;
    private static Context applicationContext;
    private static boolean loggingEnabled = false;
    private static LoginHelper loginHelper;
    private static SheroesAppComponent mSheroesAppComponent;
    private static Boolean sdkInitialized = Boolean.FALSE;
    private static String sheroesApiKey = "";

    public interface AnalyticsCallback {
        void onEventTriggered(Map<String, Object> map);
    }

    public interface InitializeCallback {
        void onInitialized();
    }

    public interface LogInCallback {
        void onFailure();

        void onLoggedInSuccess();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void sdkInitialize(android.content.Context r1, java.lang.String r2, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk.InitializeCallback r3, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk.AnalyticsCallback r4) {
        /*
            java.lang.Class<com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk> r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk.class
            monitor-enter(r0)
            sheroesApiKey = r2     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r2 = sdkInitialized     // Catch:{ all -> 0x0047 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0014
            if (r3 == 0) goto L_0x0012
            r3.onInitialized()     // Catch:{ all -> 0x0047 }
        L_0x0012:
            monitor-exit(r0)
            return
        L_0x0014:
            android.content.Context r2 = r1.getApplicationContext()     // Catch:{ all -> 0x0047 }
            applicationContext = r2     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "application context"
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.internel.Validate.notNull(r1, r2)     // Catch:{ all -> 0x0047 }
            r2 = 0
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.internel.Validate.hasInternetPermissions(r1, r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = sheroesApiKey     // Catch:{ all -> 0x0047 }
            boolean r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil.isNotEmpty(r1)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x003f
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0047 }
            sdkInitialized = r1     // Catch:{ all -> 0x0047 }
            initialiseComponents()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r0.getSimpleName()     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "Sheores Sdk initialized successfully"
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo.d(r1, r2)     // Catch:{ all -> 0x0047 }
            analyticsCallback = r4     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)
            return
        L_0x003f:
            com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception.SheroesException r1 = new com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception.SheroesException     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = "A valid Sheroes API key must be set"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0047 }
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk.sdkInitialize(android.content.Context, java.lang.String, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk$InitializeCallback, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk$AnalyticsCallback):void");
    }

    public static SheroesAppComponent getAppComponent(Context context) {
        return mSheroesAppComponent;
    }

    public static AnalyticsCallback getAnalyticsCallback() {
        return analyticsCallback;
    }

    private static void initialiseComponents() {
        mSheroesAppComponent = DaggerSheroesAppComponent.builder().sheroesAppModule(new SheroesAppModule(new File(applicationContext.getCacheDir(), "responses"), applicationContext)).build();
        loginHelper = new LoginHelper(applicationContext);
        AnalyticsManager.initializeAnalyticsManager(applicationContext);
    }

    public static String getSheroesAPIKey() {
        return sheroesApiKey;
    }

    public static void login(String str, String str2, LogInCallback logInCallback) {
        if (!isInitialized()) {
            throw new SheroesException("Sheroes Sdk must be initialised before logging in");
        } else if (loginHelper.isLoggedInUser()) {
            logInCallback.onLoggedInSuccess();
        } else {
            forceLogin(str, str2, logInCallback);
        }
    }

    public static void forceLogin(String str, String str2, LogInCallback logInCallback) {
        new LoginHelper(applicationContext).authenticateSdk(str, str2, logInCallback);
    }

    public static void logOut() {
        loginHelper.onUserLoggedOut();
    }

    public static boolean isLoggedInUser() {
        return new LoginHelper(applicationContext).isLoggedInUser();
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (SheroesSdk.class) {
            booleanValue = sdkInitialized.booleanValue();
        }
        return booleanValue;
    }

    public static Context getApplicationContext() {
        Validate.sdkInitialized();
        return applicationContext;
    }

    public static SharedPreferences getAppSharedPrefs() {
        Context context = applicationContext;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(AppConstants.SHARED_PREFS, 0);
    }

    public static void setLoggingEnable(boolean z) {
        loggingEnabled = z;
    }

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static FeedFragment getFeedFragment() {
        FeedFragment feedFragment = new FeedFragment();
        Bundle bundle = new Bundle();
        putDefaultBundle(bundle);
        feedFragment.setArguments(bundle);
        return feedFragment;
    }

    public static FeedFragment getFeedFragment(String str) {
        FeedFragment feedFragment = new FeedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("deep_link_url", str);
        putDefaultBundle(bundle);
        feedFragment.setArguments(bundle);
        return feedFragment;
    }

    public static Boolean handleBranchDeepLink(Activity activity, Intent intent) {
        boolean z = true;
        if (activity != null && TextUtils.equals(intent.getAction(), "android.intent.action.VIEW")) {
            if (CommonUtil.isBranchLink(Uri.parse(intent.getDataString()))) {
                intent.setClass(activity, BranchDeepLink.class);
                activity.startActivityForResult(intent, BaseActivity.BRANCH_REQUEST_CODE);
            } else if (AppUtils.matchesWebsiteURLPattern(intent.getDataString())) {
                AppUtils.openChromeTab(activity, Uri.parse(intent.getDataString()));
            }
            return Boolean.valueOf(z);
        }
        z = false;
        return Boolean.valueOf(z);
    }

    private static void putDefaultBundle(Bundle bundle) {
        bundle.putString(AppConstants.END_POINT_URL, "participant/feed/stream?setOrderKey=paytmUsers");
        bundle.putBoolean(FeedFragment.IS_HOME_FEED, true);
        bundle.putString("screen_name", "/sheroes/feed");
    }
}
