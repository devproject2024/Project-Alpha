package com.google.c;

import com.google.c.bz;
import java.io.IOException;
import java.util.List;

final class l implements bk {

    /* renamed from: a  reason: collision with root package name */
    private final k f37885a;

    /* renamed from: b  reason: collision with root package name */
    private int f37886b;

    /* renamed from: c  reason: collision with root package name */
    private int f37887c;

    /* renamed from: d  reason: collision with root package name */
    private int f37888d = 0;

    l(k kVar) {
        this.f37885a = (k) ac.a(kVar, "input");
        this.f37885a.f37868d = this;
    }

    public final int a() throws IOException {
        int i2 = this.f37888d;
        if (i2 != 0) {
            this.f37886b = i2;
            this.f37888d = 0;
        } else {
            this.f37886b = this.f37885a.a();
        }
        int i3 = this.f37886b;
        if (i3 == 0 || i3 == this.f37887c) {
            return Integer.MAX_VALUE;
        }
        return bz.b(i3);
    }

    public final int b() {
        return this.f37886b;
    }

    public final boolean c() throws IOException {
        int i2;
        if (this.f37885a.t() || (i2 = this.f37886b) == this.f37887c) {
            return false;
        }
        return this.f37885a.b(i2);
    }

    private void a(int i2) throws IOException {
        if (bz.a(this.f37886b) != i2) {
            throw ad.invalidWireType();
        }
    }

    public final double d() throws IOException {
        a(1);
        return this.f37885a.b();
    }

    public final float e() throws IOException {
        a(5);
        return this.f37885a.c();
    }

    public final long f() throws IOException {
        a(0);
        return this.f37885a.d();
    }

    public final long g() throws IOException {
        a(0);
        return this.f37885a.e();
    }

    public final int h() throws IOException {
        a(0);
        return this.f37885a.f();
    }

    public final long i() throws IOException {
        a(1);
        return this.f37885a.g();
    }

    public final int j() throws IOException {
        a(5);
        return this.f37885a.h();
    }

    public final boolean k() throws IOException {
        a(0);
        return this.f37885a.i();
    }

    public final String l() throws IOException {
        a(2);
        return this.f37885a.j();
    }

    public final String m() throws IOException {
        a(2);
        return this.f37885a.k();
    }

    public final <T> T a(Class<T> cls, r rVar) throws IOException {
        a(2);
        return c(bg.a().a(cls), rVar);
    }

    public final <T> T a(bm<T> bmVar, r rVar) throws IOException {
        a(2);
        return c(bmVar, rVar);
    }

    public final <T> T b(Class<T> cls, r rVar) throws IOException {
        a(3);
        return d(bg.a().a(cls), rVar);
    }

    public final <T> T b(bm<T> bmVar, r rVar) throws IOException {
        a(3);
        return d(bmVar, rVar);
    }

    private <T> T c(bm<T> bmVar, r rVar) throws IOException {
        int m = this.f37885a.m();
        if (this.f37885a.f37865a < this.f37885a.f37866b) {
            int c2 = this.f37885a.c(m);
            T a2 = bmVar.a();
            this.f37885a.f37865a++;
            bmVar.a(a2, this, rVar);
            bmVar.d(a2);
            this.f37885a.a(0);
            k kVar = this.f37885a;
            kVar.f37865a--;
            this.f37885a.d(c2);
            return a2;
        }
        throw ad.recursionLimitExceeded();
    }

    private <T> T d(bm<T> bmVar, r rVar) throws IOException {
        int i2 = this.f37887c;
        this.f37887c = bz.a(bz.b(this.f37886b), 4);
        try {
            T a2 = bmVar.a();
            bmVar.a(a2, this, rVar);
            bmVar.d(a2);
            if (this.f37886b == this.f37887c) {
                return a2;
            }
            throw ad.parseFailure();
        } finally {
            this.f37887c = i2;
        }
    }

    public final j n() throws IOException {
        a(2);
        return this.f37885a.l();
    }

    public final int o() throws IOException {
        a(0);
        return this.f37885a.m();
    }

    public final int p() throws IOException {
        a(0);
        return this.f37885a.n();
    }

    public final int q() throws IOException {
        a(5);
        return this.f37885a.o();
    }

    public final long r() throws IOException {
        a(1);
        return this.f37885a.p();
    }

    public final int s() throws IOException {
        a(0);
        return this.f37885a.q();
    }

    public final long t() throws IOException {
        a(0);
        return this.f37885a.r();
    }

    public final void a(List<Double> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof o) {
            o oVar = (o) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 1) {
                do {
                    oVar.a(this.f37885a.b());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int m = this.f37885a.m();
                b(m);
                int u = this.f37885a.u() + m;
                do {
                    oVar.a(this.f37885a.b());
                } while (this.f37885a.u() < u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 1) {
                do {
                    list.add(Double.valueOf(this.f37885a.b()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int m2 = this.f37885a.m();
                b(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Double.valueOf(this.f37885a.b()));
                } while (this.f37885a.u() < u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void b(List<Float> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof y) {
            y yVar = (y) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 2) {
                int m = this.f37885a.m();
                c(m);
                int u = this.f37885a.u() + m;
                do {
                    yVar.a(this.f37885a.c());
                } while (this.f37885a.u() < u);
            } else if (a4 == 5) {
                do {
                    yVar.a(this.f37885a.c());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 2) {
                int m2 = this.f37885a.m();
                c(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Float.valueOf(this.f37885a.c()));
                } while (this.f37885a.u() < u2);
            } else if (a5 == 5) {
                do {
                    list.add(Float.valueOf(this.f37885a.c()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void c(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    akVar.a(this.f37885a.d());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    akVar.a(this.f37885a.d());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Long.valueOf(this.f37885a.d()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Long.valueOf(this.f37885a.d()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void d(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    akVar.a(this.f37885a.e());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    akVar.a(this.f37885a.e());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Long.valueOf(this.f37885a.e()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Long.valueOf(this.f37885a.e()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void e(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    abVar.c(this.f37885a.f());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    abVar.c(this.f37885a.f());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Integer.valueOf(this.f37885a.f()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Integer.valueOf(this.f37885a.f()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void f(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 1) {
                do {
                    akVar.a(this.f37885a.g());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int m = this.f37885a.m();
                b(m);
                int u = this.f37885a.u() + m;
                do {
                    akVar.a(this.f37885a.g());
                } while (this.f37885a.u() < u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 1) {
                do {
                    list.add(Long.valueOf(this.f37885a.g()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int m2 = this.f37885a.m();
                b(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f37885a.g()));
                } while (this.f37885a.u() < u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void g(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 2) {
                int m = this.f37885a.m();
                c(m);
                int u = this.f37885a.u() + m;
                do {
                    abVar.c(this.f37885a.h());
                } while (this.f37885a.u() < u);
            } else if (a4 == 5) {
                do {
                    abVar.c(this.f37885a.h());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 2) {
                int m2 = this.f37885a.m();
                c(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f37885a.h()));
                } while (this.f37885a.u() < u2);
            } else if (a5 == 5) {
                do {
                    list.add(Integer.valueOf(this.f37885a.h()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void h(List<Boolean> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof g) {
            g gVar = (g) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    gVar.a(this.f37885a.i());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    gVar.a(this.f37885a.i());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f37885a.i()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Boolean.valueOf(this.f37885a.i()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void i(List<String> list) throws IOException {
        a(list, false);
    }

    public final void j(List<String> list) throws IOException {
        a(list, true);
    }

    private void a(List<String> list, boolean z) throws IOException {
        int a2;
        int a3;
        if (bz.a(this.f37886b) != 2) {
            throw ad.invalidWireType();
        } else if (!(list instanceof ai) || z) {
            do {
                list.add(z ? m() : l());
                if (!this.f37885a.t()) {
                    a2 = this.f37885a.a();
                } else {
                    return;
                }
            } while (a2 == this.f37886b);
            this.f37888d = a2;
        } else {
            ai aiVar = (ai) list;
            do {
                aiVar.a(n());
                if (!this.f37885a.t()) {
                    a3 = this.f37885a.a();
                } else {
                    return;
                }
            } while (a3 == this.f37886b);
            this.f37888d = a3;
        }
    }

    public final <T> void a(List<T> list, bm<T> bmVar, r rVar) throws IOException {
        int a2;
        if (bz.a(this.f37886b) == 2) {
            int i2 = this.f37886b;
            do {
                list.add(c(bmVar, rVar));
                if (!this.f37885a.t() && this.f37888d == 0) {
                    a2 = this.f37885a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f37888d = a2;
            return;
        }
        throw ad.invalidWireType();
    }

    public final <T> void b(List<T> list, bm<T> bmVar, r rVar) throws IOException {
        int a2;
        if (bz.a(this.f37886b) == 3) {
            int i2 = this.f37886b;
            do {
                list.add(d(bmVar, rVar));
                if (!this.f37885a.t() && this.f37888d == 0) {
                    a2 = this.f37885a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f37888d = a2;
            return;
        }
        throw ad.invalidWireType();
    }

    public final void k(List<j> list) throws IOException {
        int a2;
        if (bz.a(this.f37886b) == 2) {
            do {
                list.add(n());
                if (!this.f37885a.t()) {
                    a2 = this.f37885a.a();
                } else {
                    return;
                }
            } while (a2 == this.f37886b);
            this.f37888d = a2;
            return;
        }
        throw ad.invalidWireType();
    }

    public final void l(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    abVar.c(this.f37885a.m());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    abVar.c(this.f37885a.m());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Integer.valueOf(this.f37885a.m()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Integer.valueOf(this.f37885a.m()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void m(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    abVar.c(this.f37885a.n());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    abVar.c(this.f37885a.n());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Integer.valueOf(this.f37885a.n()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Integer.valueOf(this.f37885a.n()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void n(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 2) {
                int m = this.f37885a.m();
                c(m);
                int u = this.f37885a.u() + m;
                do {
                    abVar.c(this.f37885a.o());
                } while (this.f37885a.u() < u);
            } else if (a4 == 5) {
                do {
                    abVar.c(this.f37885a.o());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 2) {
                int m2 = this.f37885a.m();
                c(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f37885a.o()));
                } while (this.f37885a.u() < u2);
            } else if (a5 == 5) {
                do {
                    list.add(Integer.valueOf(this.f37885a.o()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void o(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 1) {
                do {
                    akVar.a(this.f37885a.p());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int m = this.f37885a.m();
                b(m);
                int u = this.f37885a.u() + m;
                do {
                    akVar.a(this.f37885a.p());
                } while (this.f37885a.u() < u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 1) {
                do {
                    list.add(Long.valueOf(this.f37885a.p()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int m2 = this.f37885a.m();
                b(m2);
                int u2 = this.f37885a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f37885a.p()));
                } while (this.f37885a.u() < u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void p(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ab) {
            ab abVar = (ab) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    abVar.c(this.f37885a.q());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    abVar.c(this.f37885a.q());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Integer.valueOf(this.f37885a.q()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Integer.valueOf(this.f37885a.q()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    public final void q(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ak) {
            ak akVar = (ak) list;
            int a4 = bz.a(this.f37886b);
            if (a4 == 0) {
                do {
                    akVar.a(this.f37885a.r());
                    if (!this.f37885a.t()) {
                        a3 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f37886b);
                this.f37888d = a3;
            } else if (a4 == 2) {
                int u = this.f37885a.u() + this.f37885a.m();
                do {
                    akVar.a(this.f37885a.r());
                } while (this.f37885a.u() < u);
                d(u);
            } else {
                throw ad.invalidWireType();
            }
        } else {
            int a5 = bz.a(this.f37886b);
            if (a5 == 0) {
                do {
                    list.add(Long.valueOf(this.f37885a.r()));
                    if (!this.f37885a.t()) {
                        a2 = this.f37885a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f37886b);
                this.f37888d = a2;
            } else if (a5 == 2) {
                int u2 = this.f37885a.u() + this.f37885a.m();
                do {
                    list.add(Long.valueOf(this.f37885a.r()));
                } while (this.f37885a.u() < u2);
                d(u2);
            } else {
                throw ad.invalidWireType();
            }
        }
    }

    private static void b(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw ad.parseFailure();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (c() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.c.ad("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void a(java.util.Map<K, V> r8, com.google.c.am.a<K, V> r9, com.google.c.r r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.a((int) r0)
            com.google.c.k r1 = r7.f37885a
            int r1 = r1.m()
            com.google.c.k r2 = r7.f37885a
            int r1 = r2.c(r1)
            K r2 = r9.f37724b
            V r3 = r9.f37726d
        L_0x0014:
            int r4 = r7.a()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.c.k r5 = r7.f37885a     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.t()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.c()     // Catch:{ a -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.c.ad r4 = new com.google.c.ad     // Catch:{ a -> 0x004e }
            r4.<init>((java.lang.String) r6)     // Catch:{ a -> 0x004e }
            throw r4     // Catch:{ a -> 0x004e }
        L_0x0039:
            com.google.c.bz$a r4 = r9.f37725c     // Catch:{ a -> 0x004e }
            V r5 = r9.f37726d     // Catch:{ a -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ a -> 0x004e }
            java.lang.Object r3 = r7.a((com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.r) r10)     // Catch:{ a -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.c.bz$a r4 = r9.f37723a     // Catch:{ a -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.a((com.google.c.bz.a) r4, (java.lang.Class<?>) r5, (com.google.c.r) r5)     // Catch:{ a -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.c()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.c.ad r8 = new com.google.c.ad     // Catch:{ all -> 0x0064 }
            r8.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.c.k r8 = r7.f37885a
            r8.d(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.c.k r9 = r7.f37885a
            r9.d(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.c.l.a(java.util.Map, com.google.c.am$a, com.google.c.r):void");
    }

    private Object a(bz.a aVar, Class<?> cls, r rVar) throws IOException {
        switch (aVar) {
            case BOOL:
                return Boolean.valueOf(k());
            case BYTES:
                return n();
            case DOUBLE:
                return Double.valueOf(d());
            case ENUM:
                return Integer.valueOf(p());
            case FIXED32:
                return Integer.valueOf(j());
            case FIXED64:
                return Long.valueOf(i());
            case FLOAT:
                return Float.valueOf(e());
            case INT32:
                return Integer.valueOf(h());
            case INT64:
                return Long.valueOf(g());
            case MESSAGE:
                return a(cls, rVar);
            case SFIXED32:
                return Integer.valueOf(q());
            case SFIXED64:
                return Long.valueOf(r());
            case SINT32:
                return Integer.valueOf(s());
            case SINT64:
                return Long.valueOf(t());
            case STRING:
                return m();
            case UINT32:
                return Integer.valueOf(o());
            case UINT64:
                return Long.valueOf(f());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void c(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw ad.parseFailure();
        }
    }

    private void d(int i2) throws IOException {
        if (this.f37885a.u() != i2) {
            throw ad.truncatedMessage();
        }
    }
}
