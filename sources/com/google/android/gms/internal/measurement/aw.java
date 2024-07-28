package com.google.android.gms.internal.measurement;

import android.os.Binder;

public final /* synthetic */ class aw {
    public static <V> V a(av<V> avVar) {
        long clearCallingIdentity;
        try {
            return avVar.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = avVar.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
