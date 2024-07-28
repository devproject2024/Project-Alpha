package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.tasks.f;

public abstract class n<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    public final k<L> f8624a;

    /* renamed from: b  reason: collision with root package name */
    final Feature[] f8625b = null;

    /* renamed from: c  reason: collision with root package name */
    final boolean f8626c = false;

    protected n(k<L> kVar) {
        this.f8624a = kVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a(A a2, f<Void> fVar) throws RemoteException;
}
