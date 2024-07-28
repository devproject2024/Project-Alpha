package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.s;
import java.util.List;

final class fb {
    private boolean A;
    private String B;
    private Boolean C;
    private long D;
    private String E;
    private long F;
    private long G;

    /* renamed from: a  reason: collision with root package name */
    final fc f11932a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f11933b;

    /* renamed from: c  reason: collision with root package name */
    long f11934c;

    /* renamed from: d  reason: collision with root package name */
    long f11935d;

    /* renamed from: e  reason: collision with root package name */
    long f11936e;

    /* renamed from: f  reason: collision with root package name */
    long f11937f;

    /* renamed from: g  reason: collision with root package name */
    long f11938g;

    /* renamed from: h  reason: collision with root package name */
    long f11939h;

    /* renamed from: i  reason: collision with root package name */
    String f11940i;
    boolean j;
    private final String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private long p;
    private long q;
    private long r;
    private String s;
    private long t;
    private String u;
    private long v;
    private long w;
    private boolean x;
    private long y;
    private boolean z;

    fb(fc fcVar, String str) {
        s.a(fcVar);
        s.a(str);
        this.f11932a = fcVar;
        this.k = str;
        this.f11932a.K_().h();
    }

    public final boolean a() {
        this.f11932a.K_().h();
        return this.j;
    }

    public final String b() {
        this.f11932a.K_().h();
        return this.k;
    }

    public final String c() {
        this.f11932a.K_().h();
        return this.l;
    }

    public final void a(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.l, str);
        this.l = str;
    }

    public final String d() {
        this.f11932a.K_().h();
        return this.m;
    }

    public final void b(String str) {
        this.f11932a.K_().h();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.j |= !jq.c(this.m, str);
        this.m = str;
    }

    public final String e() {
        this.f11932a.K_().h();
        return this.B;
    }

    public final void c(String str) {
        this.f11932a.K_().h();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.j |= !jq.c(this.B, str);
        this.B = str;
    }

    public final String f() {
        this.f11932a.K_().h();
        return this.E;
    }

    public final void d(String str) {
        this.f11932a.K_().h();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.j |= !jq.c(this.E, str);
        this.E = str;
    }

    public final String g() {
        this.f11932a.K_().h();
        return this.n;
    }

    public final void e(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.n, str);
        this.n = str;
    }

    public final String h() {
        this.f11932a.K_().h();
        return this.o;
    }

    public final void f(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.o, str);
        this.o = str;
    }

    public final long i() {
        this.f11932a.K_().h();
        return this.q;
    }

    public final void a(long j2) {
        this.f11932a.K_().h();
        this.j |= this.q != j2;
        this.q = j2;
    }

    public final long j() {
        this.f11932a.K_().h();
        return this.r;
    }

    public final void b(long j2) {
        this.f11932a.K_().h();
        this.j |= this.r != j2;
        this.r = j2;
    }

    public final String k() {
        this.f11932a.K_().h();
        return this.s;
    }

    public final void g(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.s, str);
        this.s = str;
    }

    public final long l() {
        this.f11932a.K_().h();
        return this.t;
    }

    public final void c(long j2) {
        this.f11932a.K_().h();
        this.j |= this.t != j2;
        this.t = j2;
    }

    public final String m() {
        this.f11932a.K_().h();
        return this.u;
    }

    public final void h(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.u, str);
        this.u = str;
    }

    public final long n() {
        this.f11932a.K_().h();
        return this.v;
    }

    public final void d(long j2) {
        this.f11932a.K_().h();
        this.j |= this.v != j2;
        this.v = j2;
    }

    public final long o() {
        this.f11932a.K_().h();
        return this.w;
    }

    public final void e(long j2) {
        this.f11932a.K_().h();
        this.j |= this.w != j2;
        this.w = j2;
    }

    public final long p() {
        this.f11932a.K_().h();
        return this.D;
    }

    public final void f(long j2) {
        this.f11932a.K_().h();
        this.j |= this.D != j2;
        this.D = j2;
    }

    public final boolean q() {
        this.f11932a.K_().h();
        return this.x;
    }

    public final void a(boolean z2) {
        this.f11932a.K_().h();
        this.j |= this.x != z2;
        this.x = z2;
    }

    public final void g(long j2) {
        boolean z2 = true;
        s.b(j2 >= 0);
        this.f11932a.K_().h();
        boolean z3 = this.j;
        if (this.p == j2) {
            z2 = false;
        }
        this.j = z2 | z3;
        this.p = j2;
    }

    public final long r() {
        this.f11932a.K_().h();
        return this.p;
    }

    public final long s() {
        this.f11932a.K_().h();
        return this.F;
    }

    public final void h(long j2) {
        this.f11932a.K_().h();
        this.j |= this.F != j2;
        this.F = j2;
    }

    public final long t() {
        this.f11932a.K_().h();
        return this.G;
    }

    public final void i(long j2) {
        this.f11932a.K_().h();
        this.j |= this.G != j2;
        this.G = j2;
    }

    public final void u() {
        this.f11932a.K_().h();
        long j2 = this.p + 1;
        if (j2 > 2147483647L) {
            this.f11932a.J_().f11831f.a("Bundle index overflow. appId", dy.a(this.k));
            j2 = 0;
        }
        this.j = true;
        this.p = j2;
    }

    public final String v() {
        this.f11932a.K_().h();
        return this.f11940i;
    }

    public final void i(String str) {
        this.f11932a.K_().h();
        this.j |= !jq.c(this.f11940i, str);
        this.f11940i = str;
    }

    public final long w() {
        this.f11932a.K_().h();
        return this.y;
    }

    public final void j(long j2) {
        this.f11932a.K_().h();
        this.j |= this.y != j2;
        this.y = j2;
    }

    public final boolean x() {
        this.f11932a.K_().h();
        return this.z;
    }

    public final void b(boolean z2) {
        this.f11932a.K_().h();
        this.j |= this.z != z2;
        this.z = z2;
    }

    public final boolean y() {
        this.f11932a.K_().h();
        return this.A;
    }

    public final void c(boolean z2) {
        this.f11932a.K_().h();
        this.j |= this.A != z2;
        this.A = z2;
    }

    public final Boolean z() {
        this.f11932a.K_().h();
        return this.C;
    }

    public final void a(Boolean bool) {
        this.f11932a.K_().h();
        this.j |= !jq.a(this.C, bool);
        this.C = bool;
    }

    public final List<String> A() {
        this.f11932a.K_().h();
        return this.f11933b;
    }
}
