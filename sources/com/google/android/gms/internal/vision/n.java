package com.google.android.gms.internal.vision;

import android.os.Binder;

public final /* synthetic */ class n {
    public static <V> V a(q<V> qVar) {
        long clearCallingIdentity;
        try {
            return qVar.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = qVar.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
