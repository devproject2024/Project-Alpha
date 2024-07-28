package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.icing.b;
import com.google.android.gms.internal.icing.i;

final class s extends u {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zza[] f38041a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(zza[] zzaArr) {
        super((byte) 0);
        this.f38041a = zzaArr;
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar) throws RemoteException {
        bVar.a(new i.a(this), this.f38041a);
    }
}
