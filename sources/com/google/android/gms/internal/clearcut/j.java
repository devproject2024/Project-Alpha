package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

final class j extends e<String> {
    j(n nVar, String str) {
        super(nVar, str, (Object) null, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String a(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.f9323b, (String) null);
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f9323b);
            if (valueOf.length() != 0) {
                "Invalid string value in SharedPreferences for ".concat(valueOf);
            } else {
                new String("Invalid string value in SharedPreferences for ");
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(String str) {
        return str;
    }
}
