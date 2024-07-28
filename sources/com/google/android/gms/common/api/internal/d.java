package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.u;

public final class d {

    public interface b<R> {
        void a(R r);
    }

    public static abstract class a<R extends l, A extends a.b> extends BasePendingResult<R> implements b<R> {

        /* renamed from: a  reason: collision with root package name */
        final a.c<A> f8568a;

        /* renamed from: b  reason: collision with root package name */
        final com.google.android.gms.common.api.a<?> f8569b;

        /* access modifiers changed from: protected */
        public abstract void a(A a2) throws RemoteException;

        protected a(com.google.android.gms.common.api.a<?> aVar, e eVar) {
            super((e) s.a(eVar, (Object) "GoogleApiClient must not be null"));
            s.a(aVar, (Object) "Api must not be null");
            this.f8568a = aVar.b();
            this.f8569b = aVar;
        }

        public final void b(A a2) throws DeadObjectException {
            if (a2 instanceof u) {
                a2 = ((u) a2).f8867a;
            }
            try {
                a(a2);
            } catch (DeadObjectException e2) {
                a((RemoteException) e2);
                throw e2;
            } catch (RemoteException e3) {
                a(e3);
            }
        }

        public final void b(Status status) {
            s.b(!status.c(), "Failed result must not be success");
            a(a(status));
        }

        private void a(RemoteException remoteException) {
            b(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        public /* bridge */ /* synthetic */ void a(Object obj) {
            super.a((l) obj);
        }
    }
}
