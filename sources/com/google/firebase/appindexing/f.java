package com.google.firebase.appindexing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.appindexing.internal.p;
import com.google.firebase.c;
import java.lang.ref.WeakReference;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<f> f38006a;

    public abstract Task<Void> a(a aVar);

    public abstract Task<Void> b(a aVar);

    public static synchronized f a() {
        p pVar;
        synchronized (f.class) {
            pVar = f38006a == null ? null : (f) f38006a.get();
            if (pVar == null) {
                p pVar2 = new p(c.e().a());
                f38006a = new WeakReference<>(pVar2);
                pVar = pVar2;
            }
        }
        return pVar;
    }
}
