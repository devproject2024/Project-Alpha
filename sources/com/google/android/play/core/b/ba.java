package com.google.android.play.core.b;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class ba extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f37279a;

    public ba(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f37279a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ba baVar = (ba) obj;
        return this.f37279a == baVar.f37279a && get() == baVar.get();
    }

    public final int hashCode() {
        return this.f37279a;
    }
}
