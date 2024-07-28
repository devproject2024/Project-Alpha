package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f8050a;

    public b(Context context) {
        try {
            Context i2 = h.i(context);
            this.f8050a = i2 == null ? null : i2.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable unused) {
            this.f8050a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String a(String str, String str2) {
        try {
            return this.f8050a == null ? str2 : this.f8050a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public final boolean a(String str) {
        try {
            if (this.f8050a == null) {
                return false;
            }
            return this.f8050a.getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final float b(String str) {
        try {
            if (this.f8050a == null) {
                return 0.0f;
            }
            return this.f8050a.getFloat(str, 0.0f);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
