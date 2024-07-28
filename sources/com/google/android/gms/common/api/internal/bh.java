package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;

public final class bh<O extends a.d> extends ac {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.common.api.d<O> f8463a;

    public bh(com.google.android.gms.common.api.d<O> dVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f8463a = dVar;
    }

    public final void a(bx bxVar) {
    }

    public final void b(bx bxVar) {
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        return this.f8463a.doRead(t);
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        return this.f8463a.doWrite(t);
    }

    public final Looper b() {
        return this.f8463a.getLooper();
    }
}
