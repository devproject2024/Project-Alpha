package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;
import com.google.android.gms.tasks.f;

final class q extends h.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ f f38039a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n f38040b;

    q(n nVar, f fVar) {
        this.f38040b = nVar;
        this.f38039a = fVar;
    }

    public final void a(Status status) throws RemoteException {
        if (!this.f38039a.b(null)) {
            return;
        }
        if (status.c()) {
            this.f38040b.f38036a.f38030b.a(null);
        } else {
            this.f38040b.f38036a.f38030b.a((Exception) e.a(status, "Indexing error, please try again."));
        }
    }
}
