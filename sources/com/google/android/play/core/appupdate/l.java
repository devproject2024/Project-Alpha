package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bx;
import com.google.android.play.core.e.p;

class l<T> extends bx {

    /* renamed from: a  reason: collision with root package name */
    final b f36912a;

    /* renamed from: b  reason: collision with root package name */
    final p<T> f36913b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ o f36914c;

    l(o oVar, b bVar, p<T> pVar) {
        this.f36914c = oVar;
        this.f36912a = bVar;
        this.f36913b = pVar;
    }

    public void a(Bundle bundle) throws RemoteException {
        this.f36914c.f36919b.a();
        this.f36912a.d("onRequestInfo", new Object[0]);
    }

    public void b(Bundle bundle) throws RemoteException {
        this.f36914c.f36919b.a();
        this.f36912a.d("onCompleteUpdate", new Object[0]);
    }
}
