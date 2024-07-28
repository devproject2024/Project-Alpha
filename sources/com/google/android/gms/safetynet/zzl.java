package com.google.android.gms.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.internal.j.i;
import com.google.android.gms.internal.j.x;
import com.google.android.gms.tasks.f;

final class zzl extends t<x, Void> {
    zzl(SafetyNetClient safetyNetClient) {
    }

    public final /* synthetic */ void doExecute(a.b bVar, f fVar) throws RemoteException {
        ((i) ((x) bVar).r()).a(new zzm(this, fVar));
    }
}
