package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import org.json.JSONObject;

public final class h extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f15374a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static b f15375c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static H5Event f15376d;

    /* renamed from: b  reason: collision with root package name */
    private String f15377b = "H5LocationPlugin";

    public static final void a(Activity activity) {
        a.b(activity);
    }

    public h() {
        super("mpLocationBridge");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        if (h5Event.getActivity() == null) {
            return false;
        }
        f15376d = h5Event;
        if (bVar != null) {
            f15375c = bVar;
            Activity activity = h5Event.getActivity();
            if (activity != null) {
                k.c(activity, "activity");
                if (Build.VERSION.SDK_INT >= 19) {
                    try {
                        if (!a.a(activity)) {
                            activity.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 20022);
                        } else {
                            a.b(activity);
                        }
                    } catch (Settings.SettingNotFoundException e2) {
                        q.c(e2.getMessage());
                    }
                }
            }
        }
        return super.a(h5Event, bVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static boolean a(Activity activity) {
            return Settings.Secure.getInt(activity.getContentResolver(), "location_mode") != 0;
        }

        public static void b(Activity activity) {
            k.c(activity, "activity");
            if (h.f15375c != null && h.f15376d != null) {
                a aVar = h.f15374a;
                JSONObject c2 = c(activity);
                b a2 = h.f15375c;
                if (a2 == null) {
                    k.a();
                }
                H5Event c3 = h.f15376d;
                if (c3 == null) {
                    k.a();
                }
                a2.a(c3, c2);
                h.f15375c = null;
            }
        }

        private static JSONObject c(Activity activity) {
            boolean a2 = Build.VERSION.SDK_INT >= 19 ? a(activity) : false;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", a2);
            return jSONObject;
        }
    }
}
