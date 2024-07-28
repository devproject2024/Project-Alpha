package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;

final class m extends o<Status> {
    m(e eVar) {
        super(eVar);
    }

    public final /* synthetic */ l a(Status status) {
        return status;
    }

    public final /* synthetic */ void a(a.b bVar) throws RemoteException {
        i iVar = (i) bVar;
        ((u) iVar.r()).b(new l(this), iVar.f8266a);
    }
}
