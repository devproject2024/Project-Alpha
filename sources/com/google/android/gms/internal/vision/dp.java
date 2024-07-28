package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

final class dp implements gj {

    /* renamed from: a  reason: collision with root package name */
    private final dl f11050a;

    /* renamed from: b  reason: collision with root package name */
    private int f11051b;

    /* renamed from: c  reason: collision with root package name */
    private int f11052c;

    /* renamed from: d  reason: collision with root package name */
    private int f11053d = 0;

    dp(dl dlVar) {
        this.f11050a = (dl) ek.a(dlVar, "input");
        this.f11050a.f11040c = this;
    }

    public final int a() throws IOException {
        int i2 = this.f11053d;
        if (i2 != 0) {
            this.f11051b = i2;
            this.f11053d = 0;
        } else {
            this.f11051b = this.f11050a.a();
        }
        int i3 = this.f11051b;
        if (i3 == 0 || i3 == this.f11052c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    public final int b() {
        return this.f11051b;
    }

    public final boolean c() throws IOException {
        int i2;
        if (this.f11050a.t() || (i2 = this.f11051b) == this.f11052c) {
            return false;
        }
        return this.f11050a.b(i2);
    }

    private final void a(int i2) throws IOException {
        if ((this.f11051b & 7) != i2) {
            throw eu.zzgr();
        }
    }

    public final double d() throws IOException {
        a(1);
        return this.f11050a.b();
    }

    public final float e() throws IOException {
        a(5);
        return this.f11050a.c();
    }

    public final long f() throws IOException {
        a(0);
        return this.f11050a.d();
    }

    public final long g() throws IOException {
        a(0);
        return this.f11050a.e();
    }

    public final int h() throws IOException {
        a(0);
        return this.f11050a.f();
    }

    public final long i() throws IOException {
        a(1);
        return this.f11050a.g();
    }

    public final int j() throws IOException {
        a(5);
        return this.f11050a.h();
    }

    public final boolean k() throws IOException {
        a(0);
        return this.f11050a.i();
    }

    public final String l() throws IOException {
        a(2);
        return this.f11050a.j();
    }

    public final String m() throws IOException {
        a(2);
        return this.f11050a.k();
    }

    public final <T> T a(Class<T> cls, du duVar) throws IOException {
        a(2);
        return c(ge.a().a(cls), duVar);
    }

    public final <T> T a(gi<T> giVar, du duVar) throws IOException {
        a(2);
        return c(giVar, duVar);
    }

    public final <T> T b(Class<T> cls, du duVar) throws IOException {
        a(3);
        return d(ge.a().a(cls), duVar);
    }

    public final <T> T b(gi<T> giVar, du duVar) throws IOException {
        a(3);
        return d(giVar, duVar);
    }

    private final <T> T c(gi<T> giVar, du duVar) throws IOException {
        int m = this.f11050a.m();
        if (this.f11050a.f11038a < this.f11050a.f11039b) {
            int c2 = this.f11050a.c(m);
            T a2 = giVar.a();
            this.f11050a.f11038a++;
            giVar.a(a2, this, duVar);
            giVar.c(a2);
            this.f11050a.a(0);
            dl dlVar = this.f11050a;
            dlVar.f11038a--;
            this.f11050a.d(c2);
            return a2;
        }
        throw new eu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T d(gi<T> giVar, du duVar) throws IOException {
        int i2 = this.f11052c;
        this.f11052c = ((this.f11051b >>> 3) << 3) | 4;
        try {
            T a2 = giVar.a();
            giVar.a(a2, this, duVar);
            giVar.c(a2);
            if (this.f11051b == this.f11052c) {
                return a2;
            }
            throw eu.zzgs();
        } finally {
            this.f11052c = i2;
        }
    }

    public final cz n() throws IOException {
        a(2);
        return this.f11050a.l();
    }

    public final int o() throws IOException {
        a(0);
        return this.f11050a.m();
    }

    public final int p() throws IOException {
        a(0);
        return this.f11050a.n();
    }

    public final int q() throws IOException {
        a(5);
        return this.f11050a.o();
    }

    public final long r() throws IOException {
        a(1);
        return this.f11050a.p();
    }

    public final int s() throws IOException {
        a(0);
        return this.f11050a.q();
    }

    public final long t() throws IOException {
        a(0);
        return this.f11050a.r();
    }

    public final void a(List<Double> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ds) {
            ds dsVar = (ds) list;
            int i2 = this.f11051b & 7;
            if (i2 == 1) {
                do {
                    dsVar.a(this.f11050a.b());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int m = this.f11050a.m();
                b(m);
                int u = this.f11050a.u() + m;
                do {
                    dsVar.a(this.f11050a.b());
                } while (this.f11050a.u() < u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.f11050a.b()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int m2 = this.f11050a.m();
                b(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Double.valueOf(this.f11050a.b()));
                } while (this.f11050a.u() < u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void b(List<Float> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ef) {
            ef efVar = (ef) list;
            int i2 = this.f11051b & 7;
            if (i2 == 2) {
                int m = this.f11050a.m();
                c(m);
                int u = this.f11050a.u() + m;
                do {
                    efVar.a(this.f11050a.c());
                } while (this.f11050a.u() < u);
            } else if (i2 == 5) {
                do {
                    efVar.a(this.f11050a.c());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 2) {
                int m2 = this.f11050a.m();
                c(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Float.valueOf(this.f11050a.c()));
                } while (this.f11050a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.f11050a.c()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void c(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    fgVar.a(this.f11050a.d());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    fgVar.a(this.f11050a.d());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f11050a.d()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Long.valueOf(this.f11050a.d()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void d(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    fgVar.a(this.f11050a.e());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    fgVar.a(this.f11050a.e());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f11050a.e()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Long.valueOf(this.f11050a.e()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void e(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    elVar.c(this.f11050a.f());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    elVar.c(this.f11050a.f());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11050a.f()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Integer.valueOf(this.f11050a.f()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void f(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i2 = this.f11051b & 7;
            if (i2 == 1) {
                do {
                    fgVar.a(this.f11050a.g());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int m = this.f11050a.m();
                b(m);
                int u = this.f11050a.u() + m;
                do {
                    fgVar.a(this.f11050a.g());
                } while (this.f11050a.u() < u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f11050a.g()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int m2 = this.f11050a.m();
                b(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f11050a.g()));
                } while (this.f11050a.u() < u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void g(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 2) {
                int m = this.f11050a.m();
                c(m);
                int u = this.f11050a.u() + m;
                do {
                    elVar.c(this.f11050a.h());
                } while (this.f11050a.u() < u);
            } else if (i2 == 5) {
                do {
                    elVar.c(this.f11050a.h());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 2) {
                int m2 = this.f11050a.m();
                c(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f11050a.h()));
                } while (this.f11050a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f11050a.h()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void h(List<Boolean> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof cx) {
            cx cxVar = (cx) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    cxVar.a(this.f11050a.i());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    cxVar.a(this.f11050a.i());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f11050a.i()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Boolean.valueOf(this.f11050a.i()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int a2;
        int a3;
        if ((this.f11051b & 7) != 2) {
            throw eu.zzgr();
        } else if (!(list instanceof fa) || z) {
            do {
                list.add(z ? m() : l());
                if (!this.f11050a.t()) {
                    a2 = this.f11050a.a();
                } else {
                    return;
                }
            } while (a2 == this.f11051b);
            this.f11053d = a2;
        } else {
            fa faVar = (fa) list;
            do {
                faVar.a(n());
                if (!this.f11050a.t()) {
                    a3 = this.f11050a.a();
                } else {
                    return;
                }
            } while (a3 == this.f11051b);
            this.f11053d = a3;
        }
    }

    public final <T> void a(List<T> list, gi<T> giVar, du duVar) throws IOException {
        int a2;
        int i2 = this.f11051b;
        if ((i2 & 7) == 2) {
            do {
                list.add(c(giVar, duVar));
                if (!this.f11050a.t() && this.f11053d == 0) {
                    a2 = this.f11050a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f11053d = a2;
            return;
        }
        throw eu.zzgr();
    }

    public final <T> void b(List<T> list, gi<T> giVar, du duVar) throws IOException {
        int a2;
        int i2 = this.f11051b;
        if ((i2 & 7) == 3) {
            do {
                list.add(d(giVar, duVar));
                if (!this.f11050a.t() && this.f11053d == 0) {
                    a2 = this.f11050a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f11053d = a2;
            return;
        }
        throw eu.zzgr();
    }

    public final void k(List<cz> list) throws IOException {
        int a2;
        if ((this.f11051b & 7) == 2) {
            do {
                list.add(n());
                if (!this.f11050a.t()) {
                    a2 = this.f11050a.a();
                } else {
                    return;
                }
            } while (a2 == this.f11051b);
            this.f11053d = a2;
            return;
        }
        throw eu.zzgr();
    }

    public final void l(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    elVar.c(this.f11050a.m());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    elVar.c(this.f11050a.m());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11050a.m()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Integer.valueOf(this.f11050a.m()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void m(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    elVar.c(this.f11050a.n());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    elVar.c(this.f11050a.n());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11050a.n()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Integer.valueOf(this.f11050a.n()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void n(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 2) {
                int m = this.f11050a.m();
                c(m);
                int u = this.f11050a.u() + m;
                do {
                    elVar.c(this.f11050a.o());
                } while (this.f11050a.u() < u);
            } else if (i2 == 5) {
                do {
                    elVar.c(this.f11050a.o());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 2) {
                int m2 = this.f11050a.m();
                c(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f11050a.o()));
                } while (this.f11050a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f11050a.o()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void o(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i2 = this.f11051b & 7;
            if (i2 == 1) {
                do {
                    fgVar.a(this.f11050a.p());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int m = this.f11050a.m();
                b(m);
                int u = this.f11050a.u() + m;
                do {
                    fgVar.a(this.f11050a.p());
                } while (this.f11050a.u() < u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f11050a.p()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int m2 = this.f11050a.m();
                b(m2);
                int u2 = this.f11050a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f11050a.p()));
                } while (this.f11050a.u() < u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void p(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof el) {
            el elVar = (el) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    elVar.c(this.f11050a.q());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    elVar.c(this.f11050a.q());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f11050a.q()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Integer.valueOf(this.f11050a.q()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    public final void q(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof fg) {
            fg fgVar = (fg) list;
            int i2 = this.f11051b & 7;
            if (i2 == 0) {
                do {
                    fgVar.a(this.f11050a.r());
                    if (!this.f11050a.t()) {
                        a3 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f11051b);
                this.f11053d = a3;
            } else if (i2 == 2) {
                int u = this.f11050a.u() + this.f11050a.m();
                do {
                    fgVar.a(this.f11050a.r());
                } while (this.f11050a.u() < u);
                d(u);
            } else {
                throw eu.zzgr();
            }
        } else {
            int i3 = this.f11051b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f11050a.r()));
                    if (!this.f11050a.t()) {
                        a2 = this.f11050a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f11051b);
                this.f11053d = a2;
            } else if (i3 == 2) {
                int u2 = this.f11050a.u() + this.f11050a.m();
                do {
                    list.add(Long.valueOf(this.f11050a.r()));
                } while (this.f11050a.u() < u2);
                d(u2);
            } else {
                throw eu.zzgr();
            }
        }
    }

    private static void b(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw eu.zzgs();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (c() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.vision.eu("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void a(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.fj<K, V> r9, com.google.android.gms.internal.vision.du r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.a((int) r0)
            com.google.android.gms.internal.vision.dl r1 = r7.f11050a
            int r1 = r1.m()
            com.google.android.gms.internal.vision.dl r2 = r7.f11050a
            int r1 = r2.c(r1)
            K r2 = r9.f11139b
            V r3 = r9.f11141d
        L_0x0014:
            int r4 = r7.a()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.vision.dl r5 = r7.f11050a     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.t()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.c()     // Catch:{ et -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.vision.eu r4 = new com.google.android.gms.internal.vision.eu     // Catch:{ et -> 0x004e }
            r4.<init>(r6)     // Catch:{ et -> 0x004e }
            throw r4     // Catch:{ et -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.vision.hs r4 = r9.f11140c     // Catch:{ et -> 0x004e }
            V r5 = r9.f11141d     // Catch:{ et -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ et -> 0x004e }
            java.lang.Object r3 = r7.a((com.google.android.gms.internal.vision.hs) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.du) r10)     // Catch:{ et -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.vision.hs r4 = r9.f11138a     // Catch:{ et -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.a((com.google.android.gms.internal.vision.hs) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.du) r5)     // Catch:{ et -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.c()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.vision.eu r8 = new com.google.android.gms.internal.vision.eu     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.vision.dl r8 = r7.f11050a
            r8.d(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.vision.dl r9 = r7.f11050a
            r9.d(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.dp.a(java.util.Map, com.google.android.gms.internal.vision.fj, com.google.android.gms.internal.vision.du):void");
    }

    private final Object a(hs hsVar, Class<?> cls, du duVar) throws IOException {
        switch (Cdo.f11049a[hsVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(k());
            case 2:
                return n();
            case 3:
                return Double.valueOf(d());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Integer.valueOf(j());
            case 6:
                return Long.valueOf(i());
            case 7:
                return Float.valueOf(e());
            case 8:
                return Integer.valueOf(h());
            case 9:
                return Long.valueOf(g());
            case 10:
                return a(cls, duVar);
            case 11:
                return Integer.valueOf(q());
            case 12:
                return Long.valueOf(r());
            case 13:
                return Integer.valueOf(s());
            case 14:
                return Long.valueOf(t());
            case 15:
                return m();
            case 16:
                return Integer.valueOf(o());
            case 17:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void c(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw eu.zzgs();
        }
    }

    private final void d(int i2) throws IOException {
        if (this.f11050a.u() != i2) {
            throw eu.zzgm();
        }
    }
}
