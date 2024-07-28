package androidx.transition;

import android.os.IBinder;

final class ar implements at {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4769a;

    ar(IBinder iBinder) {
        this.f4769a = iBinder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ar) && ((ar) obj).f4769a.equals(this.f4769a);
    }

    public final int hashCode() {
        return this.f4769a.hashCode();
    }
}
