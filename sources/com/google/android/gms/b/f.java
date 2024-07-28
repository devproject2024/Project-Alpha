package com.google.android.gms.b;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.s;

public abstract class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f8279a;

    /* renamed from: b  reason: collision with root package name */
    private T f8280b;

    protected f(String str) {
        this.f8279a = str;
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* access modifiers changed from: protected */
    public final T a(Context context) throws a {
        if (this.f8280b == null) {
            s.a(context);
            Context i2 = h.i(context);
            if (i2 != null) {
                try {
                    this.f8280b = a((IBinder) i2.getClassLoader().loadClass(this.f8279a).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new a("Could not load creator class.", e2);
                } catch (InstantiationException e3) {
                    throw new a("Could not instantiate creator.", e3);
                } catch (IllegalAccessException e4) {
                    throw new a("Could not access creator.", e4);
                }
            } else {
                throw new a("Could not get remote context.");
            }
        }
        return this.f8280b;
    }
}
