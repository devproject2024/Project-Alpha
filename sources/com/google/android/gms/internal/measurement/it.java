package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

public final class it extends me {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<Bundle> f10775a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f10776b;

    public final void a(Bundle bundle) {
        synchronized (this.f10775a) {
            try {
                this.f10775a.set(bundle);
                this.f10776b = true;
                this.f10775a.notify();
            } catch (Throwable th) {
                this.f10775a.notify();
                throw th;
            }
        }
    }

    public final String a(long j) {
        return (String) a(b(j), String.class);
    }

    public final Bundle b(long j) {
        Bundle bundle;
        synchronized (this.f10775a) {
            if (!this.f10776b) {
                try {
                    this.f10775a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f10775a.get();
        }
        return bundle;
    }

    public static <T> T a(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[]{canonicalName, canonicalName2});
            throw e2;
        }
    }
}
