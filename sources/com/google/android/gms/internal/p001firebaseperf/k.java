package com.google.android.gms.internal.p001firebaseperf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.firebase-perf.k  reason: invalid package */
final class k extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9705a;

    public k(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f9705a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f9705a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            k kVar = (k) obj;
            return this.f9705a == kVar.f9705a && get() == kVar.get();
        }
    }
}
