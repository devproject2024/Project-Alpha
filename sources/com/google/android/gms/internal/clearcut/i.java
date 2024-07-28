package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;

final class i extends e<Boolean> {
    i(n nVar, String str, Boolean bool) {
        super(nVar, str, bool, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final Boolean a(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.f9323b, false));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f9323b);
            if (valueOf.length() != 0) {
                "Invalid boolean value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid boolean value in SharedPreferences for ");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(String str) {
        if (gr.f9406a.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (gr.f9407b.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.f9323b;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        return null;
    }
}
