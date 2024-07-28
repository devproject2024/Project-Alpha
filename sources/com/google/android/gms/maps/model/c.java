package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.h.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final k f11665a;

    public c(k kVar) {
        this.f11665a = (k) s.a(kVar);
    }

    public final LatLng a() {
        try {
            return this.f11665a.a();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a(float f2) {
        try {
            this.f11665a.a(f2);
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            try {
                this.f11665a.a((b) null);
            } catch (RemoteException e2) {
                throw new d(e2);
            }
        } else {
            this.f11665a.a(aVar.f11663a);
        }
    }

    public final void b() {
        try {
            this.f11665a.b();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void c() {
        try {
            this.f11665a.c();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final void a(Object obj) {
        try {
            this.f11665a.b(d.a(obj));
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final Object d() {
        try {
            return d.a(this.f11665a.e());
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        try {
            return this.f11665a.a(((c) obj).f11665a);
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }

    public final int hashCode() {
        try {
            return this.f11665a.d();
        } catch (RemoteException e2) {
            throw new d(e2);
        }
    }
}
