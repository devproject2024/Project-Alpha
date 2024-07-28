package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.b.a.a;
import com.paytm.utility.f;
import net.one97.paytm.deeplink.aj;
import net.one97.paytm.deeplink.y;
import net.one97.paytm.finance.JarvisFinanceHelper;

public final class ba {
    private static String A = "com.travel.flight.activity.AJRPriorityCheckin";
    private static String B = "com.travel.travels.activity.AJRReferEarnActivity";
    private static String C = "com.travel.sale.TravelSalesActivity";
    private static String D = "net.one97.travelpass.ordersummary.activity.activity.TPOrderSummaryActivity";
    private static String E = "net.one97.paytm.hotel4.view.ui.activity.AJRHotelsBookingStatusNew";
    private static String F = "net.one97.paytm.hotel4.view.ui.activity.AJRHotelsBookingStatusNew";
    private static String G = "com.travel.booking.activity.AJRTravelBookingList";
    private static String H = "com.travel.cst.fragment.TravelCSTFragment";
    private static String I = "com.travel.AJRTravelContactUs";
    private static String J = "com.travel.citybus.best.ui.activities.CityBusOrderSummaryActivity";
    private static String K = "com.travel.citybus.best.ui.activities.CityBusRechargeOrderSummaryActivity";
    private static String L = "com.travel.citybus.brts.BCLLSuccessBookingActivity";

    /* renamed from: a  reason: collision with root package name */
    public static String f69705a = "SMART_NOTIFICATION_ID";

    /* renamed from: b  reason: collision with root package name */
    public static int f69706b = 26;

    /* renamed from: c  reason: collision with root package name */
    public static int f69707c = 27;

    /* renamed from: d  reason: collision with root package name */
    public static int f69708d = 28;

    /* renamed from: e  reason: collision with root package name */
    private static String f69709e = "com.travel.travels.CJRTravelRoamingNotificationPublisher";

    /* renamed from: f  reason: collision with root package name */
    private static String f69710f = "com.travel.travels.activity.AJRReferDeepLinkActivity";

    /* renamed from: g  reason: collision with root package name */
    private static String f69711g = "com.travel.travels.activity.AJRTravelReferralHomeActivity";

    /* renamed from: h  reason: collision with root package name */
    private static String f69712h = "com.travel.travels.activity.AJRTravelsHomeActivity";

    /* renamed from: i  reason: collision with root package name */
    private static String f69713i = "com.travel.bus.busticket.activity.AJRBusTicketsHomePAge";
    private static String j = "com.travel.flight.flightticket.activity.AJRFlightTicketHomePage";
    private static String k = "com.travel.train.activity.AJRTrainOrderStatus";
    private static String l = "com.travel.bus.orders.activity.BusOrderSummary";
    private static String m = "com.travel.flight.flightorder.activity.FlightOrderSummary";
    private static String n = "net.one97.travelpass.ordersummary.activity.activity.TPOrderSummaryActivity";
    private static String o = "com.travel.train.activity.AJRTrainLiveStatus";
    private static String p = "com.travel.train.activity.AJRPNRStatus";
    private static String q = "com.travel.train.activity.AJRTrainOrderSummaryNew";
    private static String r = "com.travel.train.activity.AJRTrainSearchActivity";
    private static String s = "com.travel.train.activity.AJRTrainQuickBookActivity";
    private static String t = "com.travel.bus.busticket.activity.AJRBusReviewNotification";
    private static String u = "com.travel.bus.busticket.activity.AJRBusRatingScreenActivity";
    private static String v = "com.travel.bus.busticket.activity.AJRBusSearchSRPActivity";
    private static String w = "com.travel.flight.flightticket.activity.AJRFlightReviewItenarary";
    private static String x = "com.finance.gold.order.NewOrderSummary";
    private static String y = "com.travel.AJRTravelPreferencesActivity";
    private static String z = "com.finance.weex.AJRWeexActivity";

    public static Intent a(Context context) {
        return b(context, f69712h);
    }

    public static Intent b(Context context) {
        return b(context, f69713i);
    }

    public static String a() {
        return m;
    }

    public static String b() {
        return l;
    }

    public static String c() {
        return D;
    }

    public static String d() {
        return A;
    }

    public static String e() {
        return E;
    }

    private static Intent b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new Intent();
        }
        aj ajVar = aj.f50320a;
        return aj.a(context, new y(str, "flight_dynamic"));
    }

    public static Intent c(Context context) {
        return b(context, k);
    }

    public static Intent d(Context context) {
        return b(context, l);
    }

    public static Intent e(Context context) {
        return b(context, E);
    }

    public static Intent f(Context context) {
        return b(context, m);
    }

    public static Intent g(Context context) {
        return b(context, n);
    }

    public static Intent h(Context context) {
        return b(context, f69711g);
    }

    public static String f() {
        return o;
    }

    public static String g() {
        return p;
    }

    public static Intent i(Context context) {
        return b(context, q);
    }

    public static String h() {
        return s;
    }

    public static String i() {
        return q;
    }

    public static String j() {
        return f69712h;
    }

    public static String k() {
        return r;
    }

    public static String l() {
        return u;
    }

    public static String m() {
        return B;
    }

    public static String n() {
        return z;
    }

    public static String o() {
        return J;
    }

    static void j(Context context) {
        if (context != null) {
            try {
                a a2 = ag.a(context, f.a.TRAIN_MOST_PREF_KEY);
                if (a2 != null) {
                    a2.a("searchedcitieswithdate", false);
                    a2.a("searchedcitiesforsource", false);
                    a2.a("searchedcitiesfordestination", false);
                    a2.a(com.paytm.utility.a.a(context), false);
                }
            } catch (Exception unused) {
            }
        }
        k(context);
    }

    public static void k(Context context) {
        try {
            a a2 = ag.a(context, f.a.TRAIN_MOST_PREF_KEY);
            a a3 = ag.a(context, f.a.TRAIN_SEARCH_NOTIFICATION_SHARED);
            if (a2 != null) {
                a2.a("notificationread", false);
                if (a3 != null) {
                    a3.a("train_search_notification_key", false);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String p() {
        return t;
    }

    public static String q() {
        return f69710f;
    }

    public static String r() {
        return f69711g;
    }

    public static Intent l(Context context) {
        return b(context, G);
    }

    public static Intent m(Context context) {
        return b(context, y);
    }

    public static Intent n(Context context) {
        return b(context, I);
    }

    public static Intent o(Context context) {
        return JarvisFinanceHelper.getInstance().getFinanceAccessProviderListener().getForexOrderSummaryIntent(context);
    }

    public static String s() {
        return w;
    }

    public static void a(Context context, String str) {
        Intent b2 = b(context, L);
        b2.putExtra("is_from_payment", true);
        b2.putExtra("order_id", str);
        context.startActivity(b2);
    }

    public static void a(Context context, Intent intent, boolean z2) {
        Intent b2 = b(context, L);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            b2.putExtras(extras);
        }
        b2.putExtra("is_from_payment", z2);
        context.startActivity(b2);
    }
}
