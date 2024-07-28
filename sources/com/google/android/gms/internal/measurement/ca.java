package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class ca extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f10518a;

    public ca(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f10518a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f10518a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            ca caVar = (ca) obj;
            return this.f10518a == caVar.f10518a && get() == caVar.get();
        }
    }
}
