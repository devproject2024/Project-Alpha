package com.google.android.gms.internal.f;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class o extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9484a;

    public o(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f9484a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f9484a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            o oVar = (o) obj;
            return this.f9484a == oVar.f9484a && get() == oVar.get();
        }
    }
}
