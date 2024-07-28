package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.tasks.f;

final class bw extends t<A, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ t.a f8485a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bw(t.a aVar, Feature[] featureArr, boolean z) {
        super(featureArr, z);
        this.f8485a = aVar;
    }

    /* access modifiers changed from: protected */
    public final void doExecute(A a2, f<ResultT> fVar) throws RemoteException {
        this.f8485a.f8629a.a(a2, fVar);
    }
}
