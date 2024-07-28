package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class dd implements fw {

    /* renamed from: a  reason: collision with root package name */
    private final cz f10554a;

    /* renamed from: b  reason: collision with root package name */
    private int f10555b;

    /* renamed from: c  reason: collision with root package name */
    private int f10556c;

    /* renamed from: d  reason: collision with root package name */
    private int f10557d = 0;

    dd(cz czVar) {
        this.f10554a = (cz) dx.a(czVar, "input");
        this.f10554a.f10540c = this;
    }

    public final int a() throws IOException {
        int i2 = this.f10557d;
        if (i2 != 0) {
            this.f10555b = i2;
            this.f10557d = 0;
        } else {
            this.f10555b = this.f10554a.a();
        }
        int i3 = this.f10555b;
        if (i3 == 0 || i3 == this.f10556c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    public final int b() {
        return this.f10555b;
    }

    public final boolean c() throws IOException {
        int i2;
        if (this.f10554a.t() || (i2 = this.f10555b) == this.f10556c) {
            return false;
        }
        return this.f10554a.b(i2);
    }

    private final void a(int i2) throws IOException {
        if ((this.f10555b & 7) != i2) {
            throw eg.zzf();
        }
    }

    public final double d() throws IOException {
        a(1);
        return this.f10554a.b();
    }

    public final float e() throws IOException {
        a(5);
        return this.f10554a.c();
    }

    public final long f() throws IOException {
        a(0);
        return this.f10554a.d();
    }

    public final long g() throws IOException {
        a(0);
        return this.f10554a.e();
    }

    public final int h() throws IOException {
        a(0);
        return this.f10554a.f();
    }

    public final long i() throws IOException {
        a(1);
        return this.f10554a.g();
    }

    public final int j() throws IOException {
        a(5);
        return this.f10554a.h();
    }

    public final boolean k() throws IOException {
        a(0);
        return this.f10554a.i();
    }

    public final String l() throws IOException {
        a(2);
        return this.f10554a.j();
    }

    public final String m() throws IOException {
        a(2);
        return this.f10554a.k();
    }

    public final <T> T a(fv<T> fvVar, dh dhVar) throws IOException {
        a(2);
        return c(fvVar, dhVar);
    }

    public final <T> T b(fv<T> fvVar, dh dhVar) throws IOException {
        a(3);
        return d(fvVar, dhVar);
    }

    private final <T> T c(fv<T> fvVar, dh dhVar) throws IOException {
        int m = this.f10554a.m();
        if (this.f10554a.f10538a < this.f10554a.f10539b) {
            int c2 = this.f10554a.c(m);
            T a2 = fvVar.a();
            this.f10554a.f10538a++;
            fvVar.a(a2, this, dhVar);
            fvVar.c(a2);
            this.f10554a.a(0);
            cz czVar = this.f10554a;
            czVar.f10538a--;
            this.f10554a.d(c2);
            return a2;
        }
        throw new eg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T d(fv<T> fvVar, dh dhVar) throws IOException {
        int i2 = this.f10556c;
        this.f10556c = ((this.f10555b >>> 3) << 3) | 4;
        try {
            T a2 = fvVar.a();
            fvVar.a(a2, this, dhVar);
            fvVar.c(a2);
            if (this.f10555b == this.f10556c) {
                return a2;
            }
            throw eg.zzg();
        } finally {
            this.f10556c = i2;
        }
    }

    public final cm n() throws IOException {
        a(2);
        return this.f10554a.l();
    }

    public final int o() throws IOException {
        a(0);
        return this.f10554a.m();
    }

    public final int p() throws IOException {
        a(0);
        return this.f10554a.n();
    }

    public final int q() throws IOException {
        a(5);
        return this.f10554a.o();
    }

    public final long r() throws IOException {
        a(1);
        return this.f10554a.p();
    }

    public final int s() throws IOException {
        a(0);
        return this.f10554a.q();
    }

    public final long t() throws IOException {
        a(0);
        return this.f10554a.r();
    }

    public final void a(List<Double> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof df) {
            df dfVar = (df) list;
            int i2 = this.f10555b & 7;
            if (i2 == 1) {
                do {
                    dfVar.a(this.f10554a.b());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int m = this.f10554a.m();
                b(m);
                int u = this.f10554a.u() + m;
                do {
                    dfVar.a(this.f10554a.b());
                } while (this.f10554a.u() < u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.f10554a.b()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int m2 = this.f10554a.m();
                b(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Double.valueOf(this.f10554a.b()));
                } while (this.f10554a.u() < u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void b(List<Float> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof du) {
            du duVar = (du) list;
            int i2 = this.f10555b & 7;
            if (i2 == 2) {
                int m = this.f10554a.m();
                c(m);
                int u = this.f10554a.u() + m;
                do {
                    duVar.a(this.f10554a.c());
                } while (this.f10554a.u() < u);
            } else if (i2 == 5) {
                do {
                    duVar.a(this.f10554a.c());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 2) {
                int m2 = this.f10554a.m();
                c(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Float.valueOf(this.f10554a.c()));
                } while (this.f10554a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.f10554a.c()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void c(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof et) {
            et etVar = (et) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    etVar.a(this.f10554a.d());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    etVar.a(this.f10554a.d());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10554a.d()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Long.valueOf(this.f10554a.d()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void d(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof et) {
            et etVar = (et) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    etVar.a(this.f10554a.e());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    etVar.a(this.f10554a.e());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10554a.e()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Long.valueOf(this.f10554a.e()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void e(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    dyVar.d(this.f10554a.f());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    dyVar.d(this.f10554a.f());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10554a.f()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Integer.valueOf(this.f10554a.f()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void f(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof et) {
            et etVar = (et) list;
            int i2 = this.f10555b & 7;
            if (i2 == 1) {
                do {
                    etVar.a(this.f10554a.g());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int m = this.f10554a.m();
                b(m);
                int u = this.f10554a.u() + m;
                do {
                    etVar.a(this.f10554a.g());
                } while (this.f10554a.u() < u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f10554a.g()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int m2 = this.f10554a.m();
                b(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f10554a.g()));
                } while (this.f10554a.u() < u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void g(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 2) {
                int m = this.f10554a.m();
                c(m);
                int u = this.f10554a.u() + m;
                do {
                    dyVar.d(this.f10554a.h());
                } while (this.f10554a.u() < u);
            } else if (i2 == 5) {
                do {
                    dyVar.d(this.f10554a.h());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 2) {
                int m2 = this.f10554a.m();
                c(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f10554a.h()));
                } while (this.f10554a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f10554a.h()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void h(List<Boolean> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof ck) {
            ck ckVar = (ck) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    ckVar.a(this.f10554a.i());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    ckVar.a(this.f10554a.i());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f10554a.i()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Boolean.valueOf(this.f10554a.i()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
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
        if ((this.f10555b & 7) != 2) {
            throw eg.zzf();
        } else if (!(list instanceof em) || z) {
            do {
                list.add(z ? m() : l());
                if (!this.f10554a.t()) {
                    a2 = this.f10554a.a();
                } else {
                    return;
                }
            } while (a2 == this.f10555b);
            this.f10557d = a2;
        } else {
            em emVar = (em) list;
            do {
                emVar.a(n());
                if (!this.f10554a.t()) {
                    a3 = this.f10554a.a();
                } else {
                    return;
                }
            } while (a3 == this.f10555b);
            this.f10557d = a3;
        }
    }

    public final <T> void a(List<T> list, fv<T> fvVar, dh dhVar) throws IOException {
        int a2;
        int i2 = this.f10555b;
        if ((i2 & 7) == 2) {
            do {
                list.add(c(fvVar, dhVar));
                if (!this.f10554a.t() && this.f10557d == 0) {
                    a2 = this.f10554a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f10557d = a2;
            return;
        }
        throw eg.zzf();
    }

    public final <T> void b(List<T> list, fv<T> fvVar, dh dhVar) throws IOException {
        int a2;
        int i2 = this.f10555b;
        if ((i2 & 7) == 3) {
            do {
                list.add(d(fvVar, dhVar));
                if (!this.f10554a.t() && this.f10557d == 0) {
                    a2 = this.f10554a.a();
                } else {
                    return;
                }
            } while (a2 == i2);
            this.f10557d = a2;
            return;
        }
        throw eg.zzf();
    }

    public final void k(List<cm> list) throws IOException {
        int a2;
        if ((this.f10555b & 7) == 2) {
            do {
                list.add(n());
                if (!this.f10554a.t()) {
                    a2 = this.f10554a.a();
                } else {
                    return;
                }
            } while (a2 == this.f10555b);
            this.f10557d = a2;
            return;
        }
        throw eg.zzf();
    }

    public final void l(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    dyVar.d(this.f10554a.m());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    dyVar.d(this.f10554a.m());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10554a.m()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Integer.valueOf(this.f10554a.m()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void m(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    dyVar.d(this.f10554a.n());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    dyVar.d(this.f10554a.n());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10554a.n()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Integer.valueOf(this.f10554a.n()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void n(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 2) {
                int m = this.f10554a.m();
                c(m);
                int u = this.f10554a.u() + m;
                do {
                    dyVar.d(this.f10554a.o());
                } while (this.f10554a.u() < u);
            } else if (i2 == 5) {
                do {
                    dyVar.d(this.f10554a.o());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 2) {
                int m2 = this.f10554a.m();
                c(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Integer.valueOf(this.f10554a.o()));
                } while (this.f10554a.u() < u2);
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.f10554a.o()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void o(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof et) {
            et etVar = (et) list;
            int i2 = this.f10555b & 7;
            if (i2 == 1) {
                do {
                    etVar.a(this.f10554a.p());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int m = this.f10554a.m();
                b(m);
                int u = this.f10554a.u() + m;
                do {
                    etVar.a(this.f10554a.p());
                } while (this.f10554a.u() < u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.f10554a.p()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int m2 = this.f10554a.m();
                b(m2);
                int u2 = this.f10554a.u() + m2;
                do {
                    list.add(Long.valueOf(this.f10554a.p()));
                } while (this.f10554a.u() < u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void p(List<Integer> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof dy) {
            dy dyVar = (dy) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    dyVar.d(this.f10554a.q());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    dyVar.d(this.f10554a.q());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f10554a.q()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Integer.valueOf(this.f10554a.q()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    public final void q(List<Long> list) throws IOException {
        int a2;
        int a3;
        if (list instanceof et) {
            et etVar = (et) list;
            int i2 = this.f10555b & 7;
            if (i2 == 0) {
                do {
                    etVar.a(this.f10554a.r());
                    if (!this.f10554a.t()) {
                        a3 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a3 == this.f10555b);
                this.f10557d = a3;
            } else if (i2 == 2) {
                int u = this.f10554a.u() + this.f10554a.m();
                do {
                    etVar.a(this.f10554a.r());
                } while (this.f10554a.u() < u);
                d(u);
            } else {
                throw eg.zzf();
            }
        } else {
            int i3 = this.f10555b & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.f10554a.r()));
                    if (!this.f10554a.t()) {
                        a2 = this.f10554a.a();
                    } else {
                        return;
                    }
                } while (a2 == this.f10555b);
                this.f10557d = a2;
            } else if (i3 == 2) {
                int u2 = this.f10554a.u() + this.f10554a.m();
                do {
                    list.add(Long.valueOf(this.f10554a.r()));
                } while (this.f10554a.u() < u2);
                d(u2);
            } else {
                throw eg.zzf();
            }
        }
    }

    private static void b(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw eg.zzg();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (c() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.measurement.eg("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void a(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.ew<K, V> r9, com.google.android.gms.internal.measurement.dh r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.a((int) r0)
            com.google.android.gms.internal.measurement.cz r1 = r7.f10554a
            int r1 = r1.m()
            com.google.android.gms.internal.measurement.cz r2 = r7.f10554a
            int r1 = r2.c(r1)
            K r2 = r9.f10635b
            V r3 = r9.f10637d
        L_0x0014:
            int r4 = r7.a()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.measurement.cz r5 = r7.f10554a     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.t()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.c()     // Catch:{ ef -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.measurement.eg r4 = new com.google.android.gms.internal.measurement.eg     // Catch:{ ef -> 0x004e }
            r4.<init>(r6)     // Catch:{ ef -> 0x004e }
            throw r4     // Catch:{ ef -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.measurement.he r4 = r9.f10636c     // Catch:{ ef -> 0x004e }
            V r5 = r9.f10637d     // Catch:{ ef -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ ef -> 0x004e }
            java.lang.Object r3 = r7.a((com.google.android.gms.internal.measurement.he) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.dh) r10)     // Catch:{ ef -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.measurement.he r4 = r9.f10634a     // Catch:{ ef -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.a((com.google.android.gms.internal.measurement.he) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.dh) r5)     // Catch:{ ef -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.c()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.measurement.eg r8 = new com.google.android.gms.internal.measurement.eg     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.measurement.cz r8 = r7.f10554a
            r8.d(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.measurement.cz r9 = r7.f10554a
            r9.d(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dd.a(java.util.Map, com.google.android.gms.internal.measurement.ew, com.google.android.gms.internal.measurement.dh):void");
    }

    private final Object a(he heVar, Class<?> cls, dh dhVar) throws IOException {
        switch (dc.f10553a[heVar.ordinal()]) {
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
                a(2);
                return c(fq.a().a(cls), dhVar);
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
            throw eg.zzg();
        }
    }

    private final void d(int i2) throws IOException {
        if (this.f10554a.u() != i2) {
            throw eg.zza();
        }
    }
}
