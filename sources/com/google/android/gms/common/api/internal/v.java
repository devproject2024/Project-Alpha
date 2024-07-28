package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.f;

public abstract class v<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    public final k.a<L> f8632a;

    protected v(k.a<L> aVar) {
        this.f8632a = aVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a(A a2, f<Boolean> fVar) throws RemoteException;
}
