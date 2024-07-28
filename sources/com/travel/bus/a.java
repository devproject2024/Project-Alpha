package com.travel.bus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.travel.bus.busticket.i.r;
import com.travel.common.a.c;
import com.travel.g.b;
import com.travel.utils.q;
import easypay.manager.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.m;
import net.one97.paytm.upi.util.UpiConstants;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f21495a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.travel.common.a.a f21496b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.g.a f21497c;

    private a() {
    }

    public static a a() {
        if (f21495a == null) {
            synchronized (a.class) {
                if (f21495a == null && f21495a == null) {
                    a aVar = new a();
                    f21495a = aVar;
                    aVar.f21496b = q.a();
                    f21495a.f21497c = new C0428a((byte) 0);
                }
            }
        }
        return f21495a;
    }

    public static com.travel.g.a b() {
        return a().f21497c;
    }

    /* renamed from: com.travel.bus.a$a  reason: collision with other inner class name */
    static class C0428a implements com.travel.g.a {
        public final String C() {
            return "pdc_qrcode_id";
        }

        private C0428a() {
        }

        /* synthetic */ C0428a(byte b2) {
            this();
        }

        public final void a(String str, Map<String, Object> map, Context context) {
            if (map != null) {
                a.a().f21496b.sendCustomEventWithMap(str, new HashMap(map), context);
            }
        }

        public final void a(String str, String str2, Context context) {
            a.a().f21496b.sendOpenScreenWithDeviceInfo(str, str2, context);
        }

        public final Fragment a(WeakReference<View> weakReference) {
            return a.a().f21496b.getTravelOfferFragment((b) null, weakReference);
        }

        public final Fragment a(b bVar) {
            return a.a().f21496b.getTravelOfferFragment(bVar, (WeakReference<View>) null);
        }

        public final void a(Context context, Intent intent) {
            a.a().f21496b.startHomeScreen(context, intent);
        }

        public final String a() {
            return a.a().f21496b.getAppManagerStringValue("showLadiesSeatMessage", "");
        }

        public final String b() {
            return a.a().f21496b.getMainActivityClassName();
        }

        public final void b(Context context, Intent intent) {
            a.a().f21496b.startOldOrderSummary(context, intent);
        }

        public final void a(Context context, Intent intent, int i2) {
            a.a().f21496b.startLoginActivityForResult(context, intent, i2);
        }

        public final String c() {
            return a.a().f21496b.getAppManagerStringValue("busTripV2", "");
        }

        public final void a(String str, String str2, String str3, String str4, Context context) {
            a.a().f21496b.sendCustomEventScreenWithMap(str, str2, str3, str4, context);
        }

        public final boolean d() {
            return a.a().f21496b.getAppManagerBooleanValue("showDontKeepActivitiesWarningAlert", false);
        }

        public final String e() {
            return a.a().f21496b.getAppManagerStringValue("userDropPushBusTitle", "");
        }

        public final String f() {
            return a.a().f21496b.getAppManagerStringValue("UserDropBusMessage", "");
        }

        public final String g() {
            return a.a().f21496b.getAppManagerStringValue("busBlockTwoApiUrl", "");
        }

        public final String h() {
            return a.a().f21496b.getAppManagerStringValue("busWarningPopupMessage", "");
        }

        public final void c(Context context, Intent intent) {
            a.a().f21496b.startReachargePaymentActivityForResult(context, intent, Constants.EASY_PAY_VISIBLE_ASSIST);
        }

        public final void a(Context context, CJRCart cJRCart) {
            a.a().f21496b.sendRechargeCheckOutEvent(context, cJRCart);
        }

        public final int i() {
            return a.a().f21496b.getAppManagerIntegerValue("busAutoOptJournyTime", 0);
        }

        public final int j() {
            return a.a().f21496b.getAppManagerIntegerValue("busAutoOptTicketPrice", 0);
        }

        public final boolean k() {
            return a.a().f21496b.getAppManagerBooleanValue("busFastForwardVisible", false);
        }

        public final String l() {
            return a.a().f21496b.getAppManagerStringValue("busCancellationPolicy", "");
        }

        public final boolean m() {
            return a.a().f21496b.getAppManagerBooleanValue("is_bus_insurance_enabled", false);
        }

        public final void b(String str, String str2, Context context) {
            a.a().f21496b.sendCustomEventsWithScreenName(str, str2, context);
        }

        public final String n() {
            return a.a().f21496b.getAppManagerStringValue("bus_refund_summary_url", "");
        }

        public final String o() {
            return a.a().f21496b.getAppManagerStringValue("busOrderSummaryRatings", "");
        }

        public final boolean a(Context context) {
            return a.a().f21496b.isVerticalVIPOfferEnabled(context, c.BUS);
        }

        public final void a(String str, CJRHomePageItem cJRHomePageItem, Context context) {
            a.a().f21496b.sendDeepLinkOpen(str, cJRHomePageItem, context);
        }

        public final void a(String str, Context context) {
            a.a().f21496b.sendCustomEvents(str, context);
        }

        public final String p() {
            return a.a().f21496b.getAppManagerStringValue("TrainHolidayList", "");
        }

        public final boolean q() {
            return a.a().f21496b.getAppManagerBooleanValue("busTravellerExtraDetailsRequired", false);
        }

        public final String r() {
            return a.a().f21496b.getAppManagerStringValue("hotelTermsAndConditions", "");
        }

        public final String s() {
            return a.a().f21496b.getAppManagerStringValue("busSearchV3", "");
        }

        public final String t() {
            return a.a().f21496b.getAppManagerStringValue("FetchInsurancePlanUrlToPostBody", "");
        }

        public final String u() {
            return a.a().f21496b.getAppManagerStringValue("checkBalance", "");
        }

        public final String v() {
            return a.a().f21496b.getAppManagerStringValue("busBlockV3Url", "");
        }

        public final String w() {
            return a.a().f21496b.getAppManagerStringValue("busTravellerDetailsDynamicForm", "");
        }

        public final String x() {
            return a.a().f21496b.getAppManagerStringValue("referGetPromocode", "");
        }

        public final String y() {
            return a.a().f21496b.getAppManagerStringValue("referHistory", "");
        }

        public final String z() {
            return a.a().f21496b.getAppManagerStringValue("tpGetTravelers", "");
        }

        public final String A() {
            return a.a().f21496b.getAppManagerStringValue("tpDeleteTraveler", "");
        }

        public final boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                return UpiConstants.URL_TYPE_BRANCH_SHARE.equalsIgnoreCase(Uri.parse(str).getHost());
            }
            return false;
        }

        public final List<String> B() {
            try {
                String appManagerStringValue = a.a().f21496b.getAppManagerStringValue("whiteListedDeeplinkUrls", "");
                if (TextUtils.isEmpty(appManagerStringValue)) {
                    return new ArrayList(0);
                }
                return Arrays.asList((String[]) new f().a(appManagerStringValue, String[].class));
            } catch (Exception unused) {
                return new ArrayList(0);
            }
        }

        public final void a(CJRUrlUtmData cJRUrlUtmData) {
            a.a().f21496b.setUtmData(cJRUrlUtmData);
        }

        public final Context D() {
            return a.a().f21496b.getApplicationContext();
        }

        public final Intent c(Context context) {
            return a.a().f21496b.getSplashScreenIntent(context);
        }

        public final int E() {
            return a.a().f21496b.getAppManagerIntegerValue("UserDropPushTime", 0);
        }

        public final String F() {
            return a.a().f21496b.getAppManagerStringValue("roamingEnabled", "");
        }

        public final String G() {
            return a.a().f21496b.getAppManagerStringValue("roamingContent", "");
        }

        public final int H() {
            return a.a().f21496b.getAppManagerIntegerValue("roamingSecondTime", 0);
        }

        public final void a(Context context, Bundle bundle, m mVar) {
            a.a().f21496b.startCSTOrderIssuesActivity(context, bundle, mVar);
        }

        public final String I() {
            return a.a().f21496b.getAppManagerStringValue("roamingTitle", "");
        }

        public final void a(Context context, String str, String str2, String str3, String str4) {
            a.a().f21496b.sendCustomGTMEvents(context, str, str2, (String) null, (String) null, str3, str4);
        }

        public final void b(String str, Context context) {
            a.a().f21496b.launchDeeplink(str, context, (String) null);
        }

        public final void d(Context context, Intent intent) {
            a.a().f21496b.openPassbookMainActivity(context, intent);
        }

        public final String J() {
            return a.a().f21496b.getAppManagerStringValue("npsFeedbackUrl", "");
        }

        public final String K() {
            return a.a().f21496b.getAppManagerStringValue("digitalcredit", "");
        }

        public final String L() {
            return a.a().f21496b.getAppManagerStringValue("shopSummary", "");
        }

        public final List<String> M() {
            try {
                String appManagerStringValue = a.a().f21496b.getAppManagerStringValue("whiteListedWebViewDomain", "");
                if (TextUtils.isEmpty(appManagerStringValue)) {
                    return new ArrayList(0);
                }
                return Arrays.asList((String[]) new f().a(appManagerStringValue, String[].class));
            } catch (Exception unused) {
                return new ArrayList(0);
            }
        }

        public final void e(Context context, Intent intent) {
            a.a().f21496b.openItemLevelOrder(context, intent);
        }

        public final String N() {
            return a.a().f21496b.getAppManagerStringValue("URLBusOrderDetail", "");
        }

        public final void a(Context context, String str, Double d2) {
            a.a().f21496b.saveTransactionIdForBus(context, str, d2);
        }

        public final void a(Activity activity, NetworkCustomError networkCustomError) {
            a.a().f21496b.handleCustomError(activity, networkCustomError);
        }

        public final boolean O() {
            return a.a().f21496b.getAppManagerBooleanValue("busWarningPopupEnabled", false);
        }

        public final void a(Activity activity) {
            a.a().f21496b.showSessionTimeoutAlert(activity, (String) null, (Bundle) null, (Exception) null, false, true);
        }

        public final String P() {
            return a.a().f21496b.getAppManagerStringValue("busStoreFrontPostTxnUrl", "");
        }

        public final String b(String str) {
            return a.a().f21496b.getAppManagerStringValue(str, "");
        }

        public final String c(String str) {
            return a.a().f21496b.getAppManagerStringValue(str, "");
        }

        public final String d(String str) {
            return a.a().f21496b.getAppManagerStringValue(str, "");
        }

        public final String e(String str) {
            return a.a().f21496b.getAppManagerStringValue(str, "");
        }

        public final String f(String str) {
            return a.a().f21496b.getAppManagerStringValue(str, "");
        }

        public final int a(String str, int i2) {
            return a.a().f21496b.getAppManagerIntegerValue(str, i2);
        }

        public final boolean a(String str, boolean z) {
            return a.a().f21496b.getAppManagerBooleanValue(str, z);
        }

        public final String a(String str, String str2) {
            return a.a().f21496b.getAppManagerStringValue(str, str2);
        }

        public final void a(Fragment fragment) {
            a.a().f21496b.loadMoreTravelOffer(fragment);
        }

        public final void b(Fragment fragment) {
            a.a().f21496b.updateNestedScroll(fragment);
        }

        public final void a(a.c cVar, Activity activity, com.paytm.network.listener.b bVar) {
            a.a().f21496b.getWalletToken(cVar, activity, bVar);
        }

        public final String d(Context context) {
            String selectedProfileType = a.a().f21496b.getSelectedProfileType(context);
            return !TextUtils.isEmpty(selectedProfileType) ? selectedProfileType.toUpperCase() : "";
        }

        public final Intent a(Activity activity, String str, String str2, long j, String str3) {
            String a2 = r.a(activity, str2, "dd MMMM yy", "yyyy MM dd");
            a.a();
            String f2 = a.b().f("maxAdvanceBookingDays");
            return a.a().f21496b.getOneWayCalendarIntent(activity, c.BUS, a2, j, !TextUtils.isEmpty(f2) ? Integer.parseInt(f2) : 60, str3, false, false, (String) null, str, (String) null, (String) null);
        }

        public final TreeMap<String, String> a(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8) {
            return a.a().f21496b.getMappedItemsForSFGAPulse(str, str2, str3, str4, i2, str5, i3, str6, str7, str8);
        }

        public final void a(List<TreeMap<String, String>> list, Context context) {
            a.a().f21496b.addToQueue(list, context);
        }

        public final boolean Q() {
            return a.a().f21496b.getAppManagerBooleanValue("enableBusDeferredCheckout", false);
        }

        public final String R() {
            return a.a().f21496b.getAppManagerStringValue("URLBusVerifyAPI", "");
        }

        public final String S() {
            return a.a().f21496b.getAppManagerStringValue("URLBusDefferedAPI", "");
        }

        public final String a(CJRPGTokenList cJRPGTokenList) {
            return a.a().f21496b.getPgToken(cJRPGTokenList);
        }

        public final String b(Context context) {
            return com.paytm.utility.a.q(context);
        }
    }

    public static void a(String str, String str2, String str3, String str4, Map<String, Object> map) {
        a().f21496b.sendPulseEvents(str, str2, str3, str4, c.BUS, map);
    }
}
