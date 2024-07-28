package net.one97.paytm.hotels2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.travel.g.b;
import com.travel.utils.q;
import java.lang.ref.WeakReference;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f29990a;

    /* renamed from: b  reason: collision with root package name */
    private d f29991b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.travel.common.a.a f29992c;

    private c() {
    }

    public static d b() {
        return a().f29991b;
    }

    static class a implements d {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final Fragment a(WeakReference<View> weakReference) {
            return c.a().f29992c.getTravelOfferFragment((b) null, weakReference);
        }

        public final String a(CJRPGTokenList cJRPGTokenList) {
            return c.a().f29992c.getPgToken(cJRPGTokenList);
        }

        public final void a(Context context, String str) {
            c.a().f29992c.sendOpenScreenEvent(context, str);
        }

        public final Context a() {
            return c.a().f29992c.getApplicationContext();
        }

        public final String b() {
            return c.a().f29992c.getBuildTypeString();
        }

        public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
            c.a().f29992c.sendCustomGTMEvents(context, str, str2, str3, str4, str5, str6);
        }

        public final String c() {
            return c.a().f29992c.getBuildAppId();
        }

        public final void a(Activity activity, CJRRechargePayment cJRRechargePayment, net.one97.paytm.hotels2.a.a aVar) {
            c.a().f29992c.openPaymentPageForHotel(activity, cJRRechargePayment, aVar);
        }

        public final String a(String str) {
            return c.a().f29992c.getAppManagerStringValue(str, "");
        }

        public final Integer b(String str) {
            return Integer.valueOf(c.a().f29992c.getAppManagerIntegerValue(str, 1));
        }

        public final void a(Fragment fragment) {
            c.a().f29992c.loadMoreTravelOffer(fragment);
        }

        public final void b(Fragment fragment) {
            c.a().f29992c.updateNestedScroll(fragment);
        }

        public final Intent a(Context context, String str, String str2, String str3, String str4, String str5, int i2) {
            return c.a().f29992c.getOneWayCalendarMultipleDateSelectIntent(context, com.travel.common.a.c.HOTEL, str, 0, str2, i2, str5, false, false, (String) null, str3, str4, (String) null);
        }

        public final String d() {
            return c.a().f29992c.getAppManagerStringValue("TrainHolidayList", "");
        }

        public final void a(Context context, Intent intent, int i2) {
            c.a().f29992c.startLoginActivityForResult(context, intent, i2);
        }

        public final void a(Activity activity, com.paytm.network.listener.b bVar) {
            c.a().f29992c.getWalletToken(a.c.HOTELS, activity, bVar);
        }

        public final String e() {
            return c.a().f29992c.getRestApiKeyMap();
        }

        public final void a(Context context, Intent intent) {
            c.a().f29992c.startHomeScreen(context, intent);
        }

        public final void a(FragmentActivity fragmentActivity) {
            c.a().f29992c.showSessionTimeoutAlert(fragmentActivity, (String) null, (Bundle) null, (Exception) null, false, false);
        }

        public final void a(String str, String str2, String str3, String str4, Map<String, Object> map) {
            c.a().f29992c.sendPulseEvents(str, str2, str3, str4, com.travel.common.a.c.HOTEL, map);
        }

        public final void a(Context context, Map<String, String> map, String str) {
            c.a().f29992c.generateSmartLinkAndShare(context, map, str);
        }

        public final String a(Context context) {
            return com.paytm.utility.a.q(context);
        }
    }

    public static c a() {
        if (f29990a == null) {
            synchronized (c.class) {
                if (f29990a == null) {
                    c cVar = new c();
                    f29990a = cVar;
                    cVar.f29991b = new a((byte) 0);
                    f29990a.f29992c = q.a();
                }
            }
        }
        return f29990a;
    }
}
