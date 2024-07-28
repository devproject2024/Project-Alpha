package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.f;

public final class cx<O extends a.d> extends com.google.android.gms.common.api.d<O> {

    /* renamed from: a  reason: collision with root package name */
    private final a.f f8561a;

    /* renamed from: b  reason: collision with root package name */
    private final cq f8562b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.internal.d f8563c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> f8564d;

    public cx(Context context, a<O> aVar, Looper looper, a.f fVar, cq cqVar, com.google.android.gms.common.internal.d dVar, a.C0125a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.a> aVar2) {
        super(context, aVar, looper);
        this.f8561a = fVar;
        this.f8562b = cqVar;
        this.f8563c = dVar;
        this.f8564d = aVar2;
        this.zabo.a((com.google.android.gms.common.api.d<?>) this);
    }

    public final a.f zaa(Looper looper, f.a<O> aVar) {
        this.f8562b.f8538b = aVar;
        return this.f8561a;
    }

    public final bs zaa(Context context, Handler handler) {
        return new bs(context, handler, this.f8563c, this.f8564d);
    }
}
