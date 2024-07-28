package com.paytm.utility;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.UUID;
import kotlin.g.b.k;
import kotlin.u;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f43829a = new j();

    /* renamed from: b  reason: collision with root package name */
    private static final String f43830b = "imei";

    /* renamed from: c  reason: collision with root package name */
    private static final String f43831c = f43831c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f43832d = "android_id";

    /* renamed from: e  reason: collision with root package name */
    private static final String f43833e = "device_id";

    /* renamed from: f  reason: collision with root package name */
    private static final String f43834f = f43834f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f43835g = f43835g;

    private j() {
    }

    public static String a(Context context) {
        k.c(context, "context");
        String e2 = e(context);
        if (!v.a(e2)) {
            if (e2 == null) {
                k.a();
            }
            return e2;
        }
        k.c(context, "context");
        String b2 = b(context);
        if (b2 != null) {
            a(context, b2, f43832d);
        } else {
            String c2 = c(context);
            if (c2 != null) {
                a(context, c2, f43833e);
            } else {
                String d2 = d(context);
                if (d2 != null) {
                    a(context, d2, f43834f);
                } else {
                    String uuid = UUID.randomUUID().toString();
                    k.a((Object) uuid, "UUID.randomUUID().toString()");
                    a(context, uuid, f43835g);
                }
            }
        }
        String e3 = e(context);
        if (e3 == null) {
            k.a();
        }
        return e3;
    }

    public static String b(Context context) {
        k.c(context, "context");
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(Context context) {
        k.c(context, "context");
        if (!s.a(context)) {
            return null;
        }
        Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
        if (systemService != null) {
            try {
                return ((TelephonyManager) systemService).getDeviceId();
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
    }

    private static String d(Context context) {
        k.c(context, "context");
        if (!s.a(context)) {
            return null;
        }
        Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
        if (systemService != null) {
            try {
                return ((TelephonyManager) systemService).getSubscriberId();
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
    }

    private static String e(Context context) {
        k.c(context, "context");
        return a.a(context, f43830b);
    }

    private static void a(Context context, String str, String str2) {
        a.a(context, f43830b, str);
        a.a(context, f43831c, str2);
    }
}
