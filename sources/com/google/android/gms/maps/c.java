package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.h.k;
import com.google.android.gms.maps.a.m;
import com.google.android.gms.maps.a.x;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.maps.a.b f11545a;

    public interface a {
    }

    public interface b {
        boolean a(com.google.android.gms.maps.model.c cVar);
    }

    /* renamed from: com.google.android.gms.maps.c$c  reason: collision with other inner class name */
    static final class C0160c extends x {

        /* renamed from: a  reason: collision with root package name */
        private final a f11546a;

        C0160c(a aVar) {
            this.f11546a = aVar;
        }
    }

    public c(com.google.android.gms.maps.a.b bVar) {
        this.f11545a = (com.google.android.gms.maps.a.b) s.a(bVar);
    }

    public final void a(a aVar) {
        try {
            this.f11545a.a(aVar.f11540a);
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void b(a aVar) {
        try {
            this.f11545a.b(aVar.f11540a);
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a(a aVar, a aVar2) {
        try {
            this.f11545a.a(aVar.f11540a, new C0160c(aVar2));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final com.google.android.gms.maps.model.c a(MarkerOptions markerOptions) {
        try {
            k a2 = this.f11545a.a(markerOptions);
            if (a2 != null) {
                return new com.google.android.gms.maps.model.c(a2);
            }
            return null;
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a(b bVar) {
        try {
            this.f11545a.a((m) new o(bVar));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a() {
        try {
            this.f11545a.a();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void b() {
        try {
            this.f11545a.b();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }
}
