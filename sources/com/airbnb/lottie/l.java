package com.airbnb.lottie;

import java.util.Arrays;

public final class l<V> {

    /* renamed from: a  reason: collision with root package name */
    public final V f6164a;

    /* renamed from: b  reason: collision with root package name */
    final Throwable f6165b;

    public l(V v) {
        this.f6164a = v;
        this.f6165b = null;
    }

    public l(Throwable th) {
        this.f6165b = th;
        this.f6164a = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        V v = this.f6164a;
        if (v != null && v.equals(lVar.f6164a)) {
            return true;
        }
        Throwable th = this.f6165b;
        if (th == null || lVar.f6165b == null) {
            return false;
        }
        return th.toString().equals(this.f6165b.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6164a, this.f6165b});
    }
}
