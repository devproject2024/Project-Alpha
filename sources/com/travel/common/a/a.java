package com.travel.common.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.travel.g.b;
import com.travel.utils.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;

public interface a {
    void addToQueue(List<TreeMap<String, String>> list, Context context);

    Context attachBaseContext(Context context);

    void clearRecentSearchedData(Context context);

    void generateSmartLinkAndShare(Context context, Map<String, String> map, String str);

    Intent getAJREmbedViewIntent(Context context, String str, String str2, String str3, String str4);

    boolean getAppManagerBooleanValue(String str, boolean z);

    int getAppManagerIntegerValue(String str, int i2);

    String getAppManagerStringValue(String str, String str2);

    Context getApplicationContext();

    String getBankQRCodeConstant();

    ContextWrapper getBaseContext(Context context);

    String getBuildAppId();

    String getBuildTypeString();

    String getCategoryId(CJRItem cJRItem);

    CJRError getErrorFromAppUtils(Context context, NetworkCustomError networkCustomError);

    String getHomeTabItemUrl(Object obj);

    Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem);

    Intent getLoginIntent(Context context);

    String getMainActivityClassName();

    TreeMap<String, String> getMappedItemsForSFGAPulse(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8);

    Intent getOneWayCalendarIntent(Context context, c cVar, String str, long j, int i2, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6);

    Intent getOneWayCalendarIntent(Context context, c cVar, String str, long j, int i2, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8);

    Intent getOneWayCalendarMultipleDateSelectIntent(Context context, c cVar, String str, long j, String str2, int i2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7);

    String getPgToken(CJRPGTokenList cJRPGTokenList);

    String getRestApiKeyMap();

    String getSelectedProfileType(Context context);

    Intent getSplashScreenIntent(Context context);

    Fragment getTravelOfferFragment(b bVar, WeakReference<View> weakReference);

    Intent getTwoWayCalendarIntent(Context context, c cVar, m mVar, String str, long j, String str2, int i2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7);

    Map<String, Map<String, String>> getUnknownUrlMessageMap();

    void getWalletToken(a.c cVar, Activity activity, com.paytm.network.listener.b bVar);

    void getWalletToken(String str, Context context, com.paytm.network.listener.b bVar);

    Class getYoutubeClass();

    void handleCustomError(Activity activity, NetworkCustomError networkCustomError);

    boolean handleDeeplink(Context context, String str, Bundle bundle);

    void initPostVerifyNativePGFlow(CJRRechargePayment cJRRechargePayment, Intent intent);

    String initPreVerifyNativePGFlow(String str);

    boolean isBuildTypeDebug();

    boolean isInStanceOfHomeTab(Object obj);

    boolean isVerticalVIPOfferEnabled(Context context, c cVar);

    void launchDeeplink(String str, Context context, String str2);

    void loadMoreTravelOffer(Fragment fragment);

    void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);

    <T> void logHawkeyeEvent(T t);

    void openItemLevelOrder(Context context, Intent intent);

    void openPassbook(Context context, String str);

    void openPassbookMainActivity(Context context, Intent intent);

    void openPaymentPageForHotel(Activity activity, CJRRechargePayment cJRRechargePayment, net.one97.paytm.hotels2.a.a aVar);

    void openPromoPayOptionsBottomSheet(String str, Context context, j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData);

    void openPromoScreen(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, String str3);

    boolean reportError(Context context, Exception exc, String str);

    void saveTransactionId(Context context, String str, String str2);

    void saveTransactionIdForBus(Context context, String str, Double d2);

    void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context);

    void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context);

    void sendCustomEvents(String str, Context context);

    void sendCustomEventsWithScreenName(String str, String str2, Context context);

    void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context);

    void sendOpenScreenEvent(Context context, String str);

    void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

    void sendPulseEvents(String str, String str2, String str3, String str4, c cVar, Map<String, Object> map);

    void sendRechargeCheckOutEvent(Context context, CJRCart cJRCart);

    void setUtmData(CJRUrlUtmData cJRUrlUtmData);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, VolleyError volleyError);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2);

    void startCSTOrderIssuesActivity(Context context, Bundle bundle, net.one97.paytm.m mVar);

    void startHomeScreen(Context context, Intent intent);

    void startLanguageActivityForResult(Context context, Intent intent, int i2);

    void startLoginActivityForResult(Context context, Intent intent, int i2);

    void startOldOrderSummary(Context context, Intent intent);

    void startReachargePaymentActivity(Context context, Intent intent);

    void startReachargePaymentActivityForResult(Context context, Intent intent, int i2);

    void updateNestedScroll(Fragment fragment);
}
