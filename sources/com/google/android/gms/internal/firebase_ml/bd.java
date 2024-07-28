package com.google.android.gms.internal.firebase_ml;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class bd extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9764a;

    public bd(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f9764a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f9764a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            bd bdVar = (bd) obj;
            return this.f9764a == bdVar.f9764a && get() == bdVar.get();
        }
    }
}
