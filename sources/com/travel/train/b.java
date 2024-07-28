package com.travel.train;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.gson.f;
import com.paytm.network.model.NetworkCustomError;
import com.travel.common.a.c;
import com.travel.utils.q;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.m;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f26155a;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.common.a f26156b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.travel.common.a.a f26157c;

    private b() {
    }

    public static b a() {
        if (f26155a == null) {
            synchronized (b.class) {
                if (f26155a == null && f26155a == null) {
                    b bVar = new b();
                    f26155a = bVar;
                    bVar.f26157c = q.a();
                    f26155a.f26156b = new a((byte) 0);
                }
            }
        }
        return f26155a;
    }

    public static void a(String str, String str2, String str3, String str4, c cVar, Map<String, Object> map) {
        a().f26157c.sendPulseEvents(str, str2, str3, str4, cVar, map);
    }

    public static void a(Activity activity, Exception exc) {
        a().f26157c.showSessionTimeoutAlert(activity, (String) null, (Bundle) null, exc, false, true);
    }

    public static com.travel.common.a b() {
        return a().f26156b;
    }

    public static void a(Activity activity, com.paytm.network.listener.b bVar) {
        a().f26157c.getWalletToken((String) null, (Context) activity, bVar);
    }

    public static String a(Context context) {
        return a().f26157c.getSelectedProfileType(context);
    }

    static class a implements com.travel.common.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void a(Context context, Intent intent) {
            b.a().f26157c.startHomeScreen(context, intent);
        }

        public final void a(String str, Map<String, Object> map, Context context) {
            if (map != null) {
                b.a().f26157c.sendCustomEventWithMap(str, new HashMap(map), context);
            }
        }

        public final Context a() {
            return b.a().f26157c.getApplicationContext();
        }

        public final String b() {
            return b.a().f26157c.getAppManagerStringValue("PaymentConfirmation", "");
        }

        public final Fragment a(WeakReference<View> weakReference) {
            return b.a().f26157c.getTravelOfferFragment((com.travel.g.b) null, weakReference);
        }

        public final Map<String, Map<String, String>> c() {
            return b.a().f26157c.getUnknownUrlMessageMap();
        }

        public final String d() {
            return b.a().f26157c.getAppManagerStringValue("trainVerifyOtp", "");
        }

        public final String e() {
            return b.a().f26157c.getAppManagerStringValue("resendOtp", "");
        }

        public final void a(String str, String str2, Context context) {
            b.a().f26157c.sendOpenScreenWithDeviceInfo(str, str2, context);
        }

        public final String f() {
            return b.a().f26157c.getAppManagerStringValue("TrainMaxAdvanceBookingDays", "");
        }

        public final String g() {
            return b.a().f26157c.getAppManagerStringValue("digitalcredit", "");
        }

        public final void a(Context context, Intent intent, int i2) {
            b.a().f26157c.startLoginActivityForResult(context, intent, i2);
        }

        public final String h() {
            return b.a().f26157c.getAppManagerStringValue("shopSummary", "");
        }

        public final int i() {
            return b.a().f26157c.getAppManagerIntegerValue("trainOrderStatusRetryCount", 0);
        }

        public final List<String> j() {
            try {
                String appManagerStringValue = b.a().f26157c.getAppManagerStringValue("whiteListedWebViewDomain", "");
                if (TextUtils.isEmpty(appManagerStringValue)) {
                    return new ArrayList(0);
                }
                return Arrays.asList((String[]) new f().a(appManagerStringValue, String[].class));
            } catch (Exception unused) {
                return new ArrayList(0);
            }
        }

        public final boolean a(Context context) {
            return b.a().f26157c.isVerticalVIPOfferEnabled(context, c.TRAIN);
        }

        public final void b(Context context, Intent intent) {
            b.a().f26157c.openItemLevelOrder(context, intent);
        }

        public final void c(Context context, Intent intent) {
            b.a().f26157c.startOldOrderSummary(context, intent);
        }

        public final String k() {
            return b.a().f26157c.getAppManagerStringValue("tpGetTravelers", "");
        }

        public final void a(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
            b.a().f26157c.loadPage(context, str, iJRDataModel, str2, i2, arrayList, z, str3);
        }

        public final boolean l() {
            return b.a().f26157c.getAppManagerBooleanValue("TrainIRCTCPaymentNativeButtons", false);
        }

        public final String m() {
            return b.a().f26157c.getAppManagerStringValue("URLTrainLiveStatus", "");
        }

        public final boolean n() {
            return b.a().f26157c.getAppManagerBooleanValue("enableTrainAssistAutoRetry", false);
        }

        public final boolean o() {
            return b.a().f26157c.getAppManagerBooleanValue("enableTrainAssist", false);
        }

        public final String p() {
            return b.a().f26157c.getAppManagerStringValue("CancelRequest", "");
        }

        public final String q() {
            return b.a().f26157c.getAppManagerStringValue("trainRedirectionTrackUrl", "");
        }

        public final String r() {
            return b.a().f26157c.getAppManagerStringValue("forgotIRCTCpassword", "");
        }

        public final String s() {
            return b.a().f26157c.getAppManagerStringValue("referValidatePromocode", "");
        }

        public final String t() {
            return b.a().f26157c.getAppManagerStringValue("cashbackInfoMessage", "");
        }

        public final String u() {
            return b.a().f26157c.getAppManagerStringValue("TrainPromoDiscovery", "");
        }

        public final String v() {
            return b.a().f26157c.getAppManagerStringValue("TrainPromoVerifyUrl", "");
        }

        public final void a(Activity activity, NetworkCustomError networkCustomError) {
            b.a().f26157c.handleCustomError(activity, networkCustomError);
        }

        public final boolean w() {
            return b.a().f26157c.getAppManagerBooleanValue("trainInsuranceDefaultSelected", false);
        }

        public final boolean x() {
            return b.a().f26157c.getAppManagerBooleanValue("tpTrainStatus", false);
        }

        public final String y() {
            return b.a().f26157c.getAppManagerStringValue("IRCTCuserStatus", "");
        }

        public final String z() {
            return b.a().f26157c.getAppManagerStringValue("tpDeleteTraveler", "");
        }

        public final String A() {
            return b.a().f26157c.getAppManagerStringValue("seniorCitizenDiscountText", "");
        }

        public final String B() {
            return b.a().f26157c.getAppManagerStringValue("berthPreferenceText", "");
        }

        public final String C() {
            return b.a().f26157c.getAppManagerStringValue("bedrollText", "");
        }

        public final String D() {
            return b.a().f26157c.getAppManagerStringValue("trainTravellerDetailsDialogInfoText", "");
        }

        public final String E() {
            return b.a().f26157c.getAppManagerStringValue("trainQuickBookURL", "");
        }

        public final String F() {
            return b.a().f26157c.getAppManagerStringValue("userDropPushTrainTitle", "");
        }

        public final String G() {
            return b.a().f26157c.getAppManagerStringValue("UserDropTrainMessage", "");
        }

        public final boolean H() {
            return b.a().f26157c.getAppManagerBooleanValue("trainItineraryTimerEnable", false);
        }

        public final int I() {
            return b.a().f26157c.getAppManagerIntegerValue("trainItineraryTimerLength", 0);
        }

        public final String J() {
            return b.a().f26157c.getAppManagerStringValue("trainDetailsURL", "");
        }

        public final String b(String str) {
            return b.a().f26157c.initPreVerifyNativePGFlow(str);
        }

        public final void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
            b.a().f26157c.initPostVerifyNativePGFlow(cJRRechargePayment, intent);
        }

        public final void d(Context context, Intent intent) {
            b.a().f26157c.startReachargePaymentActivity(context, intent);
        }

        public final String K() {
            return b.a().f26157c.getAppManagerStringValue("URLSearchTrainsV3", "");
        }

        public final String L() {
            return b.a().f26157c.getAppManagerStringValue("trainStationSearchV3_URL", "");
        }

        public final String M() {
            return b.a().f26157c.getAppManagerStringValue("trainTicketStatusGuideURL", "");
        }

        public final String N() {
            return b.a().f26157c.getAppManagerStringValue("promoSearchUrl", "");
        }

        public final void a(Context context, String str) {
            b.a().f26157c.openPassbook(context, str);
        }

        public final String O() {
            return b.a().f26157c.getAppManagerStringValue("trainScheduleURL", "");
        }

        public final void a(Context context, Bundle bundle, m mVar) {
            b.a().f26157c.startCSTOrderIssuesActivity(context, bundle, mVar);
        }

        public final String P() {
            return b.a().f26157c.getAppManagerStringValue("npsFeedbackUrl", "");
        }

        public final String Q() {
            return b.a().f26157c.getAppManagerStringValue("URLTrainsNewOrderSummary", "");
        }

        public final Intent b(Context context) {
            return b.a().f26157c.getSplashScreenIntent(context);
        }

        public final int R() {
            return b.a().f26157c.getAppManagerIntegerValue("UserDropPushTime", 0);
        }

        public final String S() {
            return b.a().f26157c.getAppManagerStringValue("roamingEnabled", "");
        }

        public final String T() {
            return b.a().f26157c.getAppManagerStringValue("roamingContent", "");
        }

        public final String U() {
            return b.a().f26157c.getAppManagerStringValue("roamingTitle", "");
        }

        public final int V() {
            return b.a().f26157c.getAppManagerIntegerValue("roamingSecondTime", 0);
        }

        public final String W() {
            return b.a().f26157c.getAppManagerStringValue("TrainCountryCode", "");
        }

        public final String X() {
            return b.a().f26157c.getAppManagerStringValue("LoadStateAndCity", "");
        }

        public final String Y() {
            return b.a().f26157c.getAppManagerStringValue("LoadCountryList", "");
        }

        public final String Z() {
            return b.a().f26157c.getAppManagerStringValue("IRCTCRegistration", "");
        }

        public final String aa() {
            return b.a().f26157c.getAppManagerStringValue("IRCTCUserAvailabilty", "");
        }

        public final String ab() {
            return b.a().f26157c.getAppManagerStringValue("trainCancellationPolicyURL", "");
        }

        public final String ac() {
            return b.a().f26157c.getAppManagerStringValue("trainRefundPolicyPdf", "");
        }

        public final String ad() {
            return b.a().f26157c.getAppManagerStringValue("trainLiveTrackingStoreFrontURL", "");
        }

        public final String ae() {
            return b.a().f26157c.getAppManagerStringValue("trainResendTicketUrl", "");
        }

        public final boolean a(Context context, Exception exc, String str) {
            return b.a().f26157c.reportError(context, exc, str);
        }

        public final Context c(Context context) {
            return b.a().f26157c.attachBaseContext(context);
        }

        public final void a(Activity activity, String str) {
            com.paytm.utility.b.a(activity, str);
        }

        public final boolean a(Context context, String str, Bundle bundle) {
            return b.a().f26157c.handleDeeplink(context, str, bundle);
        }

        public final String af() {
            return b.a().f26157c.getAppManagerStringValue("travelMetroModeListURL", "");
        }

        public final String ag() {
            return b.a().f26157c.getAppManagerStringValue("travelMetroStationURL", "");
        }

        public final String ah() {
            return b.a().f26157c.getAppManagerStringValue("travelMetroRouteSearchURL", "");
        }

        public final void a(Fragment fragment) {
            b.a().f26157c.loadMoreTravelOffer(fragment);
        }

        public final String ai() {
            return b.a().f26157c.getAppManagerStringValue("trainRetargetUrl", "");
        }

        public final void b(Fragment fragment) {
            b.a().f26157c.updateNestedScroll(fragment);
        }

        public final Intent a(Activity activity, Locale locale, Date date, long j, int i2, String str, String str2, String str3) {
            return b.a().f26157c.getOneWayCalendarIntent(activity, c.TRAIN, new SimpleDateFormat("yyyy MM dd", locale).format(date), j, i2, str, false, false, (String) null, str2, (String) null, str3);
        }

        public final String a(String str) {
            return b.a().f26157c.getAppManagerStringValue(str, "");
        }
    }
}
