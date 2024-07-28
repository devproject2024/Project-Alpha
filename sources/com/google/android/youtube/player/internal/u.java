package com.google.android.youtube.player.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.youtube.player.c;
import com.google.android.youtube.player.internal.h;
import com.google.android.youtube.player.internal.j;

public final class u implements c {

    /* renamed from: a  reason: collision with root package name */
    public g f37607a;

    /* renamed from: b  reason: collision with root package name */
    private e f37608b;

    public u(e eVar, g gVar) {
        this.f37608b = (e) c.a(eVar, (Object) "connectionClient cannot be null");
        this.f37607a = (g) c.a(gVar, (Object) "embeddedPlayer cannot be null");
    }

    public final void a() {
        try {
            this.f37607a.c(0);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(final c.b bVar) {
        try {
            this.f37607a.a((h) new h.a() {
                public final void a(boolean z) {
                    bVar.a(z);
                }
            });
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(final c.d dVar) {
        try {
            this.f37607a.a((j) new j.a() {
                public final void a() {
                }

                public final void a(String str) {
                }

                public final void b() {
                }

                public final void b(String str) {
                    try {
                        c.a.valueOf(str);
                    } catch (IllegalArgumentException unused) {
                        c.a aVar = c.a.UNKNOWN;
                    } catch (NullPointerException unused2) {
                        c.a aVar2 = c.a.UNKNOWN;
                    }
                }

                public final void c() {
                    dVar.a();
                }

                public final void d() {
                    dVar.b();
                }
            });
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(boolean z) {
        try {
            this.f37607a.b(z);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean a(int i2, KeyEvent keyEvent) {
        try {
            return this.f37607a.a(i2, keyEvent);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean a(Bundle bundle) {
        try {
            return this.f37607a.a(bundle);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final View b() {
        try {
            return (View) x.a(this.f37607a.s());
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void b(boolean z) {
        try {
            this.f37607a.c(z);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final boolean b(int i2, KeyEvent keyEvent) {
        try {
            return this.f37607a.b(i2, keyEvent);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void c() {
        try {
            this.f37607a.m();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void c(boolean z) {
        try {
            this.f37607a.a(z);
            this.f37608b.a(z);
            this.f37608b.d();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void d() {
        try {
            this.f37607a.n();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void d(boolean z) {
        try {
            this.f37607a.e(z);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void e() {
        try {
            this.f37607a.o();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void f() {
        try {
            this.f37607a.p();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final Bundle g() {
        try {
            return this.f37607a.r();
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }

    public final void a(String str) {
        try {
            this.f37607a.b(str, 0);
        } catch (RemoteException e2) {
            throw new s(e2);
        }
    }
}
