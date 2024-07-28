package com.google.android.gms.internal.icing;

import android.content.Context;
import androidx.core.content.c;

final class s implements r {

    /* renamed from: a  reason: collision with root package name */
    static s f10273a;

    /* renamed from: b  reason: collision with root package name */
    final Context f10274b;

    static s a(Context context) {
        s sVar;
        synchronized (s.class) {
            if (f10273a == null) {
                f10273a = c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new s(context) : new s();
            }
            sVar = f10273a;
        }
        return sVar;
    }

    private s(Context context) {
        this.f10274b = context;
        this.f10274b.getContentResolver().registerContentObserver(j.f10250a, true, new u());
    }

    private s() {
        this.f10274b = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String a(String str) {
        if (this.f10274b == null) {
            return null;
        }
        try {
            return (String) q.a(new v(this, str));
        } catch (SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
            } else {
                new String("Unable to read GServices for: ");
            }
            return null;
        }
    }
}
