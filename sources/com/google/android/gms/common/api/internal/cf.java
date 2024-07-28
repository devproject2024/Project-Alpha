package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.tasks.f;

abstract class cf<T> extends au {

    /* renamed from: a  reason: collision with root package name */
    protected final f<T> f8510a;

    public cf(int i2, f<T> fVar) {
        super(i2);
        this.f8510a = fVar;
    }

    public void a(cz czVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    public abstract void d(f.a<?> aVar) throws RemoteException;

    public void a(Status status) {
        this.f8510a.b((Exception) new ApiException(status));
    }

    public void a(RuntimeException runtimeException) {
        this.f8510a.b((Exception) runtimeException);
    }

    public final void c(f.a<?> aVar) throws DeadObjectException {
        try {
            d(aVar);
        } catch (DeadObjectException e2) {
            a(bo.a((RemoteException) e2));
            throw e2;
        } catch (RemoteException e3) {
            a(bo.a(e3));
        } catch (RuntimeException e4) {
            a(e4);
        }
    }
}
