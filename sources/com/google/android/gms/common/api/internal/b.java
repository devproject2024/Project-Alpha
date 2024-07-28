package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.q;
import java.util.Arrays;

public final class b<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    public final a<O> f8451a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8452b = true;

    /* renamed from: c  reason: collision with root package name */
    private final int f8453c;

    /* renamed from: d  reason: collision with root package name */
    private final O f8454d;

    private b(a<O> aVar, O o) {
        this.f8451a = aVar;
        this.f8454d = o;
        this.f8453c = Arrays.hashCode(new Object[]{this.f8451a, this.f8454d});
    }

    public b(a<O> aVar) {
        this.f8451a = aVar;
        this.f8454d = null;
        this.f8453c = System.identityHashCode(this);
    }

    public static <O extends a.d> b<O> a(a<O> aVar, O o) {
        return new b<>(aVar, o);
    }

    public final int hashCode() {
        return this.f8453c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return !this.f8452b && !bVar.f8452b && q.a(this.f8451a, bVar.f8451a) && q.a(this.f8454d, bVar.f8454d);
    }
}
