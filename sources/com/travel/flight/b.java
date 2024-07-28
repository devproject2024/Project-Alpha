package com.travel.flight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.travel.common.a.c;
import com.travel.flight.utils.e;
import com.travel.utils.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f23533a;

    /* renamed from: b  reason: collision with root package name */
    private static c f23534b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.travel.common.a.a f23535c;

    private b() {
    }

    public static c b() {
        a();
        return f23534b;
    }

    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final Context a() {
            return b.a().f23535c.getApplicationContext();
        }

        public final void a(Context context, Intent intent) {
            b.a().f23535c.startLoginActivityForResult(context, intent, -1);
        }

        public final void a(Context context, Intent intent, int i2) {
            b.a().f23535c.startLoginActivityForResult(context, intent, i2);
        }

        public final void b(Context context, Intent intent) {
            b.a().f23535c.startHomeScreen(context, intent);
        }

        public final void c(Context context, Intent intent) {
            b.a().f23535c.startOldOrderSummary(context, intent);
        }

        public final void d(Context context, Intent intent) {
            b.a().f23535c.startReachargePaymentActivity(context, intent);
        }

        public final void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
            b.a().f23535c.initPostVerifyNativePGFlow(cJRRechargePayment, intent);
        }

        public final void e(Context context, Intent intent) {
            b.a().f23535c.openPassbookMainActivity(context, intent);
        }

        public final void a(Context context, String str, String str2) {
            b.a().f23535c.saveTransactionId(context, str, str2);
        }

        public final void f(Context context, Intent intent) {
            intent.setClassName(context, "net.one97.paytm.hotels2.activity.AJRHotelsWebActivity");
            context.startActivity(intent);
        }

        public final void a(Context context, Bundle bundle, m mVar) {
            b.a().f23535c.startCSTOrderIssuesActivity(context, bundle, mVar);
        }

        public final CJRError a(Context context, NetworkCustomError networkCustomError) {
            return b.a().f23535c.getErrorFromAppUtils(context, networkCustomError);
        }

        public final String a(String str) {
            return b.a().f23535c.initPreVerifyNativePGFlow(str);
        }

        public final boolean b(Context context) {
            return b.a().f23535c.isVerticalVIPOfferEnabled(context, c.FLIGHT);
        }

        public final void a(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2) {
            b.a().f23535c.showSessionTimeoutAlert(activity, str, bundle, exc, z, z2);
        }

        public final void g(Context context, Intent intent) {
            b.a().f23535c.openItemLevelOrder(context, intent);
        }

        public final void a(String str, Map<String, Object> map, Context context) {
            b.a().f23535c.sendCustomEventWithMap(str, new HashMap(map), context);
        }

        public final String b() {
            return b.a().f23535c.getAppManagerStringValue("flightReviewAutoComplete", "");
        }

        public final String c() {
            return b.a().f23535c.getAppManagerStringValue("flight_ancillary_url", "");
        }

        public final String d() {
            return b.a().f23535c.getAppManagerStringValue("flight_new_checkout", "");
        }

        public final String e() {
            return b.a().f23535c.getAppManagerStringValue("flight_addons_insurance", "");
        }

        public final String f() {
            return b.a().f23535c.getAppManagerStringValue("flight_event_logger", "");
        }

        public final String g() {
            return b.a().f23535c.getAppManagerStringValue("TrainHolidayList", "");
        }

        public final String h() {
            return b.a().f23535c.getAppManagerStringValue("flightAirportSearchURL", "");
        }

        public final String i() {
            return b.a().f23535c.getAppManagerStringValue("flight_fares", "");
        }

        public final String j() {
            return b.a().f23535c.getAppManagerStringValue("flight_round_trip_fares_url", "");
        }

        public final String k() {
            return b.a().f23535c.getAppManagerStringValue("flightsHomePageSearchFiltersURL", "");
        }

        public final String l() {
            return b.a().f23535c.getAppManagerStringValue("leadAPIOnAppLaunch", "");
        }

        public final String m() {
            return b.a().f23535c.getAppManagerStringValue("base_url_auth", "");
        }

        public final String n() {
            return b.a().f23535c.getAppManagerStringValue("npsFeedbackUrl", "");
        }

        public final String o() {
            return b.a().f23535c.getAppManagerStringValue("flightImageUrl", "");
        }

        public final String p() {
            return b.a().f23535c.getAppManagerStringValue("flightOrderDetailsUrl", "");
        }

        public final String q() {
            return b.a().f23535c.getAppManagerStringValue("flightOrderSummaryURL", "");
        }

        public final String r() {
            return b.a().f23535c.getAppManagerStringValue("flightAirlinesSearchBaseURL", "");
        }

        public final String s() {
            return b.a().f23535c.getAppManagerStringValue("flightSearchListURLV2", "");
        }

        public final String t() {
            return b.a().f23535c.getAppManagerStringValue("flightReviewURL", "");
        }

        public final String u() {
            return b.a().f23535c.getAppManagerStringValue("flightsMinirulesURL", "");
        }

        public final String v() {
            return b.a().f23535c.getAppManagerStringValue("myorders_search", "");
        }

        public final boolean w() {
            return b.a().f23535c.getAppManagerBooleanValue("flight_exclude_convenience_fee_enable", false);
        }

        public final String x() {
            return b.a().f23535c.getAppManagerStringValue("flightFareAlertT&CUrl", "");
        }

        public final String y() {
            return b.a().f23535c.getAppManagerStringValue("flightTopAirportsURL", "");
        }

        public final boolean z() {
            return b.a().f23535c.getAppManagerBooleanValue("flightsShowRefundable", false);
        }

        public final boolean A() {
            return b.a().f23535c.getAppManagerBooleanValue("flightsShowCancellationChargesNote", false);
        }

        public final String B() {
            return b.a().f23535c.getAppManagerStringValue("flightAnalyticsHomeUrl", "");
        }

        public final String C() {
            return b.a().f23535c.getAppManagerStringValue("flightregisterFareAlertUrl", "");
        }

        public final String D() {
            return b.a().f23535c.getAppManagerStringValue("flightderegisterFareAlertUrl", "");
        }

        public final String E() {
            return b.a().f23535c.getAppManagerStringValue("flightViewFareAlertUrl", "");
        }

        public final String F() {
            return b.a().f23535c.getAppManagerStringValue("flightAnalyticsSrpUrl", "");
        }

        public final String G() {
            return b.a().f23535c.getAppManagerStringValue("roamingEnabled", "");
        }

        public final Intent c(Context context) {
            return b.a().f23535c.getSplashScreenIntent(context);
        }

        public final String H() {
            return b.a().f23535c.getAppManagerStringValue("roamingContent", "");
        }

        public final String I() {
            return b.a().f23535c.getAppManagerStringValue("roamingTitle", "");
        }

        public final int J() {
            return b.a().f23535c.getAppManagerIntegerValue("roamingSecondTime", 0);
        }

        public final String K() {
            return b.a().f23535c.getAppManagerStringValue("tpGetTravelers", "");
        }

        public final String L() {
            return b.a().f23535c.getAppManagerStringValue("tpDeleteTraveler", "");
        }

        public final String M() {
            return b.a().f23535c.getAppManagerStringValue("digitalcredit", "");
        }

        public final String N() {
            return b.a().f23535c.getAppManagerStringValue("shopSummary", "");
        }

        public final List<String> O() {
            try {
                String appManagerStringValue = b.a().f23535c.getAppManagerStringValue("whiteListedWebViewDomain", "");
                if (TextUtils.isEmpty(appManagerStringValue)) {
                    return new ArrayList(0);
                }
                return Arrays.asList((String[]) new f().a(appManagerStringValue, String[].class));
            } catch (Exception unused) {
                return new ArrayList(0);
            }
        }

        public final void a(String str, Context context, String str2) {
            b.a().f23535c.launchDeeplink(str, context, str2);
        }

        public final String P() {
            return b.a().f23535c.getAppManagerStringValue("flightSeatLayoutUrl", "");
        }

        public final String Q() {
            return b.a().f23535c.getAppManagerStringValue("flightSeatAvailabilityUrl", "");
        }

        public final Fragment a(WeakReference<View> weakReference) {
            return b.a().f23535c.getTravelOfferFragment((com.travel.g.b) null, weakReference);
        }

        public final Fragment a(com.travel.g.b bVar) {
            return b.a().f23535c.getTravelOfferFragment(bVar, (WeakReference<View>) null);
        }

        public final Context d(Context context) {
            return b.a().f23535c.attachBaseContext(context);
        }

        public final void a(Context context, String str) {
            b.a().f23535c.handleDeeplink(context, str, (Bundle) null);
        }

        public final String R() {
            return b.a().f23535c.getAppManagerStringValue("flightPriorityCheckInUrl", "");
        }

        public final String S() {
            return b.a().f23535c.getAppManagerStringValue("flightBundleUrl", "");
        }

        public final String T() {
            return b.a().f23535c.getAppManagerStringValue("flightModifyChargesDetailsURL", "");
        }

        public final String U() {
            return b.a().f23535c.getAppManagerStringValue("flightModifySearchListURL", "");
        }

        public final String V() {
            return b.a().f23535c.getAppManagerStringValue("flightModifyReviewItenaryURL", "");
        }

        public final String W() {
            return b.a().f23535c.getAppManagerStringValue("flightModifyCheckoutURL", "");
        }

        public final String a(String str, String str2) {
            return b.a().f23535c.getAppManagerStringValue(str, str2);
        }

        public final void a(Fragment fragment) {
            b.a().f23535c.loadMoreTravelOffer(fragment);
        }

        public final String X() {
            return b.a().f23535c.getAppManagerStringValue(net.one97.paytmflight.common.a.a.f30007a, "");
        }

        public final String Y() {
            return b.a().f23535c.getAppManagerStringValue(net.one97.paytmflight.common.a.a.f30008b, "");
        }

        public final String Z() {
            return b.a().f23535c.getAppManagerStringValue("flightPromoOffersListV2URL", "");
        }

        public final void a(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, String str3) {
            b.a().f23535c.openPromoScreen(str, context, d2, str2, verifyPromoCallbackListener, onPromoActivityDestroyListener, str3);
        }

        public final String aa() {
            return b.a().f23535c.getAppManagerStringValue("flightPromoVerifyV2URL", "");
        }

        public final void h(Context context, Intent intent) {
            b.a().f23535c.startReachargePaymentActivityForResult(context, intent, 111);
        }

        public final void a(String str, Context context, j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
            b.a().f23535c.openPromoPayOptionsBottomSheet(str, context, jVar, d2, cJPayMethodResponse, verifyPromoCallbackListener, onPromoActivityDestroyListener, verifyResponseData);
        }

        public final boolean ab() {
            return b.a().f23535c.isBuildTypeDebug();
        }

        public final <T> void a(T t) {
            b.a().f23535c.logHawkeyeEvent(t);
        }

        public final void a(String str, String str2, String str3, String str4, Map<String, Object> map) {
            b.a().f23535c.sendPulseEvents(str, str2, str3, str4, c.FLIGHT, map);
        }

        public final void b(Fragment fragment) {
            b.a().f23535c.updateNestedScroll(fragment);
        }

        public final void a(a.c cVar, Activity activity, com.paytm.network.listener.b bVar) {
            b.a().f23535c.getWalletToken(cVar, activity, bVar);
        }

        public final String e(Context context) {
            String selectedProfileType = b.a().f23535c.getSelectedProfileType(context);
            return !TextUtils.isEmpty(selectedProfileType) ? selectedProfileType.toLowerCase() : "";
        }

        public final Intent a(Activity activity, Locale locale, String str, long j, String str2, String str3) {
            Activity activity2 = activity;
            return b.a().f23535c.getOneWayCalendarIntent(activity2, c.FLIGHT, e.a(activity2, locale, str, "dd MMMM yy", "yyyy MM dd"), j, -1, str2, true, true, str3, (String) null, (String) null, (String) null);
        }

        public final Intent a(Activity activity, Locale locale, String str, long j, String str2, String str3, String str4, String str5) {
            String a2 = e.a(activity, locale, str, "dd MMMM yy", "yyyy MM dd");
            return b.a().f23535c.getOneWayCalendarIntent(activity, c.FLIGHT, a2, j, -1, str2, true, true, str3, (String) null, (String) null, (String) null, true, str4, str5);
        }

        public final Intent a(Activity activity, com.travel.utils.m mVar, Locale locale, String str, long j, String str2, String str3, String str4) {
            Activity activity2 = activity;
            Locale locale2 = locale;
            return b.a().f23535c.getTwoWayCalendarIntent(activity, c.FLIGHT, mVar, e.a(activity2, locale2, str, "dd MMMM yy", "yyyy MM dd"), j, (TextUtils.isEmpty(str2) || !e.a(str2)) ? null : e.a(activity2, locale2, str2, "dd MMMM yy", "yyyy MM dd"), -1, str3, true, true, str4, (String) null, (String) null, (String) null);
        }

        public final String ac() {
            return b.a().f23535c.getAppManagerStringValue("flightStoreFrontPostTxnUrl", "");
        }

        public final TreeMap<String, String> a(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8) {
            return b.a().f23535c.getMappedItemsForSFGAPulse(str, str2, str3, str4, i2, str5, i3, str6, str7, str8);
        }

        public final void a(List<TreeMap<String, String>> list, Context context) {
            b.a().f23535c.addToQueue(list, context);
        }

        public final String a(Context context) {
            return com.paytm.utility.a.q(context);
        }
    }

    public static b a() {
        if (f23533a == null) {
            synchronized (b.class) {
                if (f23533a == null) {
                    b bVar = new b();
                    f23533a = bVar;
                    bVar.f23535c = q.a();
                    f23534b = new a((byte) 0);
                }
            }
        }
        return f23533a;
    }
}
