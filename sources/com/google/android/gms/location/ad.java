package com.google.android.gms.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.tasks.f;

final class ad extends t<com.google.android.gms.internal.location.t, Location> {
    ad() {
    }

    public final /* synthetic */ void doExecute(a.b bVar, f fVar) throws RemoteException {
        fVar.a(((com.google.android.gms.internal.location.t) bVar).t());
    }
}
