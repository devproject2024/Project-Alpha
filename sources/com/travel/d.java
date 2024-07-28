package com.travel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.google.gson.f;
import com.paytm.network.model.NetworkCustomError;
import com.travel.common.a.c;
import com.travel.common.b;
import com.travel.utils.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f23419a;

    /* renamed from: b  reason: collision with root package name */
    private b f23420b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.travel.common.a.a f23421c;

    private d() {
    }

    public static d a() {
        if (f23419a == null) {
            synchronized (d.class) {
                if (f23419a == null && f23419a == null) {
                    d dVar = new d();
                    f23419a = dVar;
                    dVar.f23421c = q.a();
                    f23419a.f23420b = new a((byte) 0);
                }
            }
        }
        return f23419a;
    }

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void a(Context context, Intent intent, int i2) {
            d.a().f23421c.startLoginActivityForResult(context, intent, i2);
        }

        public final void a(Context context, Intent intent) {
            d.a().f23421c.startHomeScreen(context, intent);
        }

        public final List<String> a() {
            try {
                String appManagerStringValue = d.a().f23421c.getAppManagerStringValue("whiteListedDeeplinkUrls", "");
                if (TextUtils.isEmpty(appManagerStringValue)) {
                    return new ArrayList(0);
                }
                return Arrays.asList((String[]) new f().a(appManagerStringValue, String[].class));
            } catch (Exception unused) {
                return new ArrayList(0);
            }
        }

        public final void a(CJRUrlUtmData cJRUrlUtmData) {
            d.a().f23421c.setUtmData(cJRUrlUtmData);
        }

        public final Intent a(String str, Context context, CJRHomePageItem cJRHomePageItem) {
            return d.a().f23421c.getIntent(str, context, cJRHomePageItem);
        }

        public final void a(Activity activity, NetworkCustomError networkCustomError) {
            d.a().f23421c.handleCustomError(activity, networkCustomError);
        }

        public final void a(Activity activity) {
            d.a().f23421c.showSessionTimeoutAlert(activity, (String) null, (Bundle) null, (VolleyError) null);
        }

        public final Fragment b() {
            return d.a().f23421c.getTravelOfferFragment((com.travel.g.b) null, (WeakReference<View>) null);
        }

        public final void b(Context context) {
            d.a().f23421c.clearRecentSearchedData(context);
        }

        public final String a(CJRHomePageItem cJRHomePageItem) {
            return d.a().f23421c.getCategoryId(cJRHomePageItem);
        }

        public final String c() {
            return d.a().f23421c.getBankQRCodeConstant();
        }

        public final boolean a(Context context, NetworkCustomError networkCustomError, String str) {
            return d.a().f23421c.reportError(context, networkCustomError, str);
        }

        public final void b(Context context, Intent intent, int i2) {
            d.a().f23421c.startLanguageActivityForResult(context, intent, i2);
        }

        public final Intent a(Context context, String str, String str2, String str3, String str4) {
            return d.a().f23421c.getAJREmbedViewIntent(context, str, str2, str3, str4);
        }

        public final Context c(Context context) {
            return d.a().f23421c.attachBaseContext(context);
        }

        public final boolean a(Context context, String str) {
            return d.a().f23421c.handleDeeplink(context, str, (Bundle) null);
        }

        public final void a(Fragment fragment) {
            d.a().f23421c.loadMoreTravelOffer(fragment);
        }

        public final Class d() {
            return d.a().f23421c.getYoutubeClass();
        }

        public final String e() {
            return d.a().f23421c.getAppManagerStringValue("TravelHomeV2API", "");
        }

        public final String f() {
            return d.a().f23421c.getAppManagerStringValue("travelMyBookingUrl", "");
        }

        public final String a(String str) {
            return d.a().f23421c.getAppManagerStringValue(str, "");
        }

        public final String a(String str, String str2) {
            return d.a().f23421c.getAppManagerStringValue(str, str2);
        }

        public final void a(String str, String str2, Context context) {
            d.a().f23421c.sendOpenScreenWithDeviceInfo(str, str2, context);
        }

        public final void a(String str, Map<String, Object> map, Context context) {
            d.a().f23421c.sendCustomEventWithMap(str, new HashMap(map), context);
        }

        public final boolean g() {
            return d.a().f23421c.getAppManagerBooleanValue("showDontKeepActivitiesWarningAlert", false);
        }

        public final void a(String str, Context context) {
            d.a().f23421c.sendCustomEvents(str, context);
        }

        public final void a(String str, String str2, String str3, String str4, HashMap<String, Object> hashMap) {
            d.a().f23421c.sendPulseEvents(str, str2, str3, str4, c.TRAVEL_HOME, hashMap);
        }

        public final Map<String, Map<String, String>> h() {
            return d.a().f23421c.getUnknownUrlMessageMap();
        }

        public final void a(Activity activity, Exception exc, boolean z) {
            d.a().f23421c.showSessionTimeoutAlert(activity, (String) null, (Bundle) null, exc, false, z);
        }

        public final String a(Context context) {
            return com.paytm.utility.a.q(context);
        }
    }

    public static b b() {
        return a().f23420b;
    }

    public static void a(Context context, String str) {
        a().f23420b.a(context, str);
    }
}
