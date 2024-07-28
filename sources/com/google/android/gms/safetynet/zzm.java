package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.internal.j.e;
import com.google.android.gms.tasks.f;

final class zzm extends e {
    private final /* synthetic */ f zzv;

    zzm(zzl zzl, f fVar) {
        this.zzv = fVar;
    }

    public final void zza(Status status) {
        u.a(status, this.zzv);
    }
}
