package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.c;

final class ay implements au {

    /* renamed from: b  reason: collision with root package name */
    private static ay f10470b;

    /* renamed from: a  reason: collision with root package name */
    final Context f10471a;

    /* renamed from: c  reason: collision with root package name */
    private final ContentObserver f10472c;

    static ay a(Context context) {
        ay ayVar;
        synchronized (ay.class) {
            if (f10470b == null) {
                f10470b = c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new ay(context) : new ay();
            }
            ayVar = f10470b;
        }
        return ayVar;
    }

    private ay(Context context) {
        this.f10471a = context;
        this.f10472c = new ba();
        context.getContentResolver().registerContentObserver(ao.f10445a, true, this.f10472c);
    }

    private ay() {
        this.f10471a = null;
        this.f10472c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String a(String str) {
        if (this.f10471a == null) {
            return null;
        }
        try {
            return (String) aw.a(new ax(this, str));
        } catch (IllegalStateException | SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
            } else {
                new String("Unable to read GServices for: ");
            }
            return null;
        }
    }

    static synchronized void a() {
        synchronized (ay.class) {
            if (!(f10470b == null || f10470b.f10471a == null || f10470b.f10472c == null)) {
                f10470b.f10471a.getContentResolver().unregisterContentObserver(f10470b.f10472c);
            }
            f10470b = null;
        }
    }
}
