package com.paytm.location;

import android.content.Context;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f42839a = new a();

    private a() {
    }

    public static boolean a(Context context) {
        if (context == null) {
            k.a();
        }
        return androidx.core.app.a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.app.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
