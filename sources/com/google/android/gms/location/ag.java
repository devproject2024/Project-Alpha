package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.location.g;
import com.google.android.gms.internal.location.zzad;
import com.google.android.gms.tasks.f;

final class ag extends g {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ f f11370a;

    ag(f fVar) {
        this.f11370a = fVar;
    }

    public final void a(zzad zzad) throws RemoteException {
        Status status = zzad.f10400a;
        if (status == null) {
            this.f11370a.b((Exception) new ApiException(new Status(8, "Got null status from location service")));
        } else if (status.f8360g == 0) {
            this.f11370a.a(Boolean.TRUE);
        } else {
            this.f11370a.b((Exception) b.a(status));
        }
    }
}
