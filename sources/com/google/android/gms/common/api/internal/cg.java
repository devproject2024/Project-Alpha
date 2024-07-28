package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.tasks.f;

public final class cg<ResultT> extends au {

    /* renamed from: a  reason: collision with root package name */
    private final t<a.b, ResultT> f8511a;

    /* renamed from: b  reason: collision with root package name */
    private final f<ResultT> f8512b;

    /* renamed from: c  reason: collision with root package name */
    private final r f8513c;

    public cg(int i2, t<a.b, ResultT> tVar, f<ResultT> fVar, r rVar) {
        super(i2);
        this.f8512b = fVar;
        this.f8511a = tVar;
        this.f8513c = rVar;
    }

    public final void c(f.a<?> aVar) throws DeadObjectException {
        try {
            this.f8511a.doExecute(aVar.f8593a, this.f8512b);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            a(bo.a(e3));
        } catch (RuntimeException e4) {
            a(e4);
        }
    }

    public final void a(Status status) {
        this.f8512b.b(this.f8513c.a(status));
    }

    public final void a(RuntimeException runtimeException) {
        this.f8512b.b((Exception) runtimeException);
    }

    public final void a(cz czVar, boolean z) {
        com.google.android.gms.tasks.f<ResultT> fVar = this.f8512b;
        czVar.f8567b.put(fVar, Boolean.valueOf(z));
        fVar.f12478a.a(new x(czVar, fVar));
    }

    public final Feature[] a(f.a<?> aVar) {
        return this.f8511a.zabr();
    }

    public final boolean b(f.a<?> aVar) {
        return this.f8511a.shouldAutoResolveMissingFeatures();
    }
}
