package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.internal.icing.b;
import com.google.android.gms.internal.icing.h;
import com.google.android.gms.tasks.f;

abstract class u extends t<h, Void> implements d.b<Status> {

    /* renamed from: a  reason: collision with root package name */
    private f<Void> f38042a;

    private u() {
    }

    /* access modifiers changed from: protected */
    public abstract void a(b bVar) throws RemoteException;

    public /* synthetic */ void doExecute(a.b bVar, f fVar) throws RemoteException {
        this.f38042a = fVar;
        a((b) ((h) bVar).r());
    }

    public final /* synthetic */ void a(Object obj) {
        Status status = (Status) obj;
        if (status.c()) {
            this.f38042a.a(null);
        } else {
            this.f38042a.a((Exception) e.a(status, "User Action indexing error, please try again."));
        }
    }

    /* synthetic */ u(byte b2) {
        this();
    }
}
