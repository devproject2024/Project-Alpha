package com.google.firebase.appindexing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.k;
import com.google.firebase.c;
import java.lang.ref.WeakReference;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<b> f38005a;

    public abstract Task<Void> a(g... gVarArr);

    public static synchronized b a() {
        k kVar;
        synchronized (b.class) {
            kVar = f38005a == null ? null : (b) f38005a.get();
            if (kVar == null) {
                k kVar2 = new k(c.e().a());
                f38005a = new WeakReference<>(kVar2);
                kVar = kVar2;
            }
        }
        return kVar;
    }
}
