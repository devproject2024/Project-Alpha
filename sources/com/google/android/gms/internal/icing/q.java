package com.google.android.gms.internal.icing;

import android.os.Binder;

public final /* synthetic */ class q {
    public static <V> V a(t<V> tVar) {
        long clearCallingIdentity;
        try {
            return tVar.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = tVar.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
