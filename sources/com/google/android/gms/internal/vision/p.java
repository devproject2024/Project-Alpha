package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.c;

final class p implements o {

    /* renamed from: b  reason: collision with root package name */
    private static p f11262b;

    /* renamed from: a  reason: collision with root package name */
    final Context f11263a;

    /* renamed from: c  reason: collision with root package name */
    private final ContentObserver f11264c;

    static p a(Context context) {
        p pVar;
        synchronized (p.class) {
            if (f11262b == null) {
                f11262b = c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new p(context) : new p();
            }
            pVar = f11262b;
        }
        return pVar;
    }

    private p(Context context) {
        this.f11263a = context;
        this.f11264c = new r();
        context.getContentResolver().registerContentObserver(g.f11158a, true, this.f11264c);
    }

    private p() {
        this.f11263a = null;
        this.f11264c = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final String a(String str) {
        if (this.f11263a == null) {
            return null;
        }
        try {
            return (String) n.a(new s(this, str));
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
        synchronized (p.class) {
            if (!(f11262b == null || f11262b.f11263a == null || f11262b.f11264c == null)) {
                f11262b.f11263a.getContentResolver().unregisterContentObserver(f11262b.f11264c);
            }
            f11262b = null;
        }
    }
}
