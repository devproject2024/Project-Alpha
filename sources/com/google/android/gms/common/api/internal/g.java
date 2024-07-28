package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ay;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.v;

@Deprecated
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8610a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static g f8611b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8612c;

    /* renamed from: d  reason: collision with root package name */
    private final Status f8613d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8614e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8615f;

    private g(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) == 0 ? false : z;
            this.f8615f = !z;
        } else {
            this.f8615f = false;
        }
        this.f8614e = z;
        String a2 = ay.a(context);
        a2 = a2 == null ? new v(context).a("google_app_id") : a2;
        if (TextUtils.isEmpty(a2)) {
            this.f8613d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f8612c = null;
            return;
        }
        this.f8612c = a2;
        this.f8613d = Status.f8354a;
    }

    public static Status a(Context context) {
        Status status;
        s.a(context, (Object) "Context must not be null.");
        synchronized (f8610a) {
            if (f8611b == null) {
                f8611b = new g(context);
            }
            status = f8611b.f8613d;
        }
        return status;
    }

    public static String a() {
        return a("getGoogleAppId").f8612c;
    }

    public static boolean b() {
        return a("isMeasurementExplicitlyDisabled").f8615f;
    }

    private static g a(String str) {
        g gVar;
        synchronized (f8610a) {
            if (f8611b != null) {
                gVar = f8611b;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(AppUtility.CENTER_DOT);
                throw new IllegalStateException(sb.toString());
            }
        }
        return gVar;
    }
}
