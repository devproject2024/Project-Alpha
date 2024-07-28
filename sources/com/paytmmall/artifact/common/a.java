package com.paytmmall.artifact.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.android.volley.VolleyError;
import com.paytmmall.a.b.c;
import com.paytmmall.artifact.common.entity.CJRItem;
import com.paytmmall.artifact.d.w;
import com.paytmmall.artifact.search.activity.AJRSearchActivity;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface a {
    void applyManualPromo(Activity activity, HashMap<String, Object> hashMap, w wVar);

    boolean checkDeepLinking(Activity activity, String str);

    void clearSessionData(Activity activity);

    Context getApplicationContext();

    boolean getBooleanValue(String str, boolean z);

    String getBuildConstant(String str);

    ICLPCommunicationListener getCLPCommunicationListener();

    Exception getCropError(Object obj);

    void getDeviceInfoDetails(Map<String, Object> map, Context context);

    Object getFetchValueKeysProvider();

    int getInt(String str, int i2);

    Class<? extends Activity> getIntentClass(Activity activity, String str);

    ArrayList<CJRItem> getRecentlyViewedItems();

    String getSSOToken(Context context);

    Class<?> getSearchActivity();

    String getStringValue(String str, String str2);

    View getTabView(Activity activity);

    void handleErrorCall(Activity activity, VolleyError volleyError, String str, Bundle bundle, String str2);

    void handleErrorReport(Activity activity, VolleyError volleyError, String str);

    void handleLink(Activity activity, String str);

    void handleNotificationSettingsClick(Activity activity);

    void handlePlayServicesError(Activity activity);

    boolean isMallApp();

    boolean isNativeIntentPresent();

    boolean isServifyEnabled();

    boolean isStagingApp();

    boolean isWhiteListedURL(String str, Context context);

    void launchHome(Activity activity, Intent intent);

    void loadPage(Context context, String str, String str2, String str3, int i2, String str4, boolean z, String str5);

    void openCheckoutActivity(Context context, Intent intent, String str, String str2, String str3, String str4, w wVar);

    void openContactUs(Activity activity, String str, String str2, com.paytmmall.artifact.a.a.a aVar);

    void openImageCropActivity(Activity activity, boolean z, boolean z2);

    void openPromoListActivity(Activity activity, HashMap<String, Object> hashMap, w wVar);

    String postRequestBodyForV2();

    void redirectToPaytm(Context context, String str);

    void resetNativeIntent();

    void resolveIntentByMainApp(Activity activity, Intent intent, String str, int i2);

    void sendAppsFlyerFbSearchClickEvent(Context context, String str, String[] strArr);

    void sendErrorAnalyticsLogs(String str, boolean z);

    <T> void sendEventToPaytmAnalytics(T t, String str, boolean z, boolean z2, boolean z3);

    void setCrashlyticsEmailAndIdentifier();

    boolean setPaymentInstruments(String str, w wVar);

    void setSearchMap(HashMap<String, Object> hashMap);

    void setShoppingCart(String str);

    void setUTMData(Uri uri);

    void setUTMData(String str);

    void setWishList(Context context);

    /* renamed from: com.paytmmall.artifact.common.a$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getSearchActivity(a _this) {
            return AJRSearchActivity.class;
        }

        public static Object $default$getFetchValueKeysProvider(a _this) {
            return new c();
        }

        public static void $default$setSearchMap(a _this, HashMap hashMap) {
            com.paytmmall.artifact.common.b.a.f15656a = hashMap;
        }
    }
}
