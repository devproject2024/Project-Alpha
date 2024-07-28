package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class bp extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f11003a;

    public bp(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f11003a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f11003a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            bp bpVar = (bp) obj;
            return this.f11003a == bpVar.f11003a && get() == bpVar.get();
        }
    }
}
