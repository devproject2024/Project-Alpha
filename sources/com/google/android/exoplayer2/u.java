package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;

final class u {

    /* renamed from: a  reason: collision with root package name */
    ah f33513a = ah.f31122a;

    /* renamed from: b  reason: collision with root package name */
    int f33514b;

    /* renamed from: c  reason: collision with root package name */
    boolean f33515c;

    /* renamed from: d  reason: collision with root package name */
    s f33516d;

    /* renamed from: e  reason: collision with root package name */
    s f33517e;

    /* renamed from: f  reason: collision with root package name */
    s f33518f;

    /* renamed from: g  reason: collision with root package name */
    int f33519g;

    /* renamed from: h  reason: collision with root package name */
    Object f33520h;

    /* renamed from: i  reason: collision with root package name */
    private final ah.a f33521i = new ah.a();
    private final ah.b j = new ah.b();
    private long k;
    private long l;

    public final boolean a(n nVar) {
        s sVar = this.f33518f;
        return sVar != null && sVar.f32770a == nVar;
    }

    public final void a(long j2) {
        s sVar = this.f33518f;
        if (sVar != null) {
            sVar.a(j2);
        }
    }

    public final s a() {
        return b() ? this.f33516d : this.f33518f;
    }

    public final boolean b() {
        return this.f33516d != null;
    }

    public final s c() {
        s sVar = this.f33516d;
        if (sVar != null) {
            if (sVar == this.f33517e) {
                this.f33517e = sVar.f32776g;
            }
            this.f33516d.d();
            this.f33519g--;
            if (this.f33519g == 0) {
                this.f33518f = null;
                this.f33520h = this.f33516d.f32771b;
                this.l = this.f33516d.f32775f.f33411a.f33227d;
            }
            this.f33516d = this.f33516d.f32776g;
        } else {
            s sVar2 = this.f33518f;
            this.f33516d = sVar2;
            this.f33517e = sVar2;
        }
        return this.f33516d;
    }

    public final boolean a(s sVar) {
        boolean z = false;
        a.b(sVar != null);
        this.f33518f = sVar;
        while (sVar.f32776g != null) {
            sVar = sVar.f32776g;
            if (sVar == this.f33517e) {
                this.f33517e = this.f33516d;
                z = true;
            }
            sVar.d();
            this.f33519g--;
        }
        this.f33518f.a((s) null);
        return z;
    }

    public final void a(boolean z) {
        s a2 = a();
        if (a2 != null) {
            this.f33520h = z ? a2.f32771b : null;
            this.l = a2.f32775f.f33411a.f33227d;
            a2.d();
            a(a2);
        } else if (!z) {
            this.f33520h = null;
        }
        this.f33516d = null;
        this.f33518f = null;
        this.f33517e = null;
        this.f33519g = 0;
    }

    public final t a(t tVar) {
        long j2;
        o.a aVar = tVar.f33411a;
        boolean a2 = a(aVar);
        boolean a3 = a(aVar, a2);
        this.f33513a.a(tVar.f33411a.f33224a, this.f33521i);
        if (aVar.a()) {
            j2 = this.f33521i.c(aVar.f33225b, aVar.f33226c);
        } else if (tVar.f33414d == -9223372036854775807L || tVar.f33414d == Long.MIN_VALUE) {
            j2 = this.f33521i.f31126d;
        } else {
            j2 = tVar.f33414d;
        }
        return new t(aVar, tVar.f33412b, tVar.f33413c, tVar.f33414d, j2, a2, a3);
    }

    public final o.a a(Object obj, long j2) {
        return a(obj, j2, a(obj));
    }

    private o.a a(Object obj, long j2, long j3) {
        this.f33513a.a(obj, this.f33521i);
        int a2 = this.f33521i.a(j2);
        if (a2 == -1) {
            return new o.a(obj, j3, this.f33521i.b(j2));
        }
        return new o.a(obj, a2, this.f33521i.b(a2), j3);
    }

    private long a(Object obj) {
        int a2;
        int i2 = this.f33513a.a(obj, this.f33521i).f31125c;
        Object obj2 = this.f33520h;
        if (obj2 != null && (a2 = this.f33513a.a(obj2)) != -1 && this.f33513a.a(a2, this.f33521i, false).f31125c == i2) {
            return this.l;
        }
        for (s a3 = a(); a3 != null; a3 = a3.f32776g) {
            if (a3.f32771b.equals(obj)) {
                return a3.f32775f.f33411a.f33227d;
            }
        }
        for (s a4 = a(); a4 != null; a4 = a4.f32776g) {
            int a5 = this.f33513a.a(a4.f32771b);
            if (a5 != -1 && this.f33513a.a(a5, this.f33521i, false).f31125c == i2) {
                return a4.f32775f.f33411a.f33227d;
            }
        }
        long j2 = this.k;
        this.k = 1 + j2;
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        s a2 = a();
        if (a2 == null) {
            return true;
        }
        int a3 = this.f33513a.a(a2.f32771b);
        while (true) {
            a3 = this.f33513a.a(a3, this.f33521i, this.j, this.f33514b, this.f33515c);
            while (a2.f32776g != null && !a2.f32775f.f33416f) {
                a2 = a2.f32776g;
            }
            s sVar = a2.f32776g;
            if (a3 == -1 || sVar == null || this.f33513a.a(sVar.f32771b) != a3) {
                boolean a4 = a(a2);
                a2.f32775f = a(a2.f32775f);
            } else {
                a2 = sVar;
            }
        }
        boolean a42 = a(a2);
        a2.f32775f = a(a2.f32775f);
        if (!a42 || !b()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final t a(s sVar, long j2) {
        long j3;
        long j4;
        long j5;
        Object obj;
        long j6;
        s sVar2 = sVar;
        t tVar = sVar2.f32775f;
        long j7 = (sVar2.f32778i + tVar.f33415e) - j2;
        long j8 = 0;
        if (tVar.f33416f) {
            int a2 = this.f33513a.a(this.f33513a.a(tVar.f33411a.f33224a), this.f33521i, this.j, this.f33514b, this.f33515c);
            if (a2 == -1) {
                return null;
            }
            int i2 = this.f33513a.a(a2, this.f33521i, true).f31125c;
            Object obj2 = this.f33521i.f31124b;
            long j9 = tVar.f33411a.f33227d;
            if (this.f33513a.a(i2, this.j).f31134f == a2) {
                Pair<Object, Long> a3 = this.f33513a.a(this.j, this.f33521i, i2, -9223372036854775807L, Math.max(0, j7));
                if (a3 == null) {
                    return null;
                }
                Object obj3 = a3.first;
                long longValue = ((Long) a3.second).longValue();
                s sVar3 = sVar2.f32776g;
                if (sVar3 == null || !sVar3.f32771b.equals(obj3)) {
                    j6 = this.k;
                    this.k = 1 + j6;
                } else {
                    j6 = sVar3.f32775f.f33411a.f33227d;
                }
                j8 = longValue;
                j4 = -9223372036854775807L;
                j5 = j6;
                obj = obj3;
            } else {
                obj = obj2;
                j5 = j9;
                j4 = 0;
            }
            return a(a(obj, j8, j5), j4, j8);
        }
        o.a aVar = tVar.f33411a;
        this.f33513a.a(aVar.f33224a, this.f33521i);
        if (aVar.a()) {
            int i3 = aVar.f33225b;
            int d2 = this.f33521i.d(i3);
            if (d2 == -1) {
                return null;
            }
            int a4 = this.f33521i.a(i3, aVar.f33226c);
            if (a4 >= d2) {
                long j10 = tVar.f33413c;
                if (j10 == -9223372036854775807L) {
                    ah ahVar = this.f33513a;
                    ah.b bVar = this.j;
                    ah.a aVar2 = this.f33521i;
                    Pair<Object, Long> a5 = ahVar.a(bVar, aVar2, aVar2.f31125c, -9223372036854775807L, Math.max(0, j7));
                    if (a5 == null) {
                        return null;
                    }
                    j3 = ((Long) a5.second).longValue();
                } else {
                    j3 = j10;
                }
                return b(aVar.f33224a, j3, aVar.f33227d);
            } else if (!this.f33521i.b(i3, a4)) {
                return null;
            } else {
                return a(aVar.f33224a, i3, a4, tVar.f33413c, aVar.f33227d);
            }
        } else {
            int a6 = this.f33521i.a(tVar.f33414d);
            if (a6 == -1) {
                return b(aVar.f33224a, tVar.f33415e, aVar.f33227d);
            }
            int b2 = this.f33521i.b(a6);
            if (!this.f33521i.b(a6, b2)) {
                return null;
            }
            return a(aVar.f33224a, a6, b2, tVar.f33415e, aVar.f33227d);
        }
    }

    /* access modifiers changed from: package-private */
    public final t a(o.a aVar, long j2, long j3) {
        this.f33513a.a(aVar.f33224a, this.f33521i);
        if (!aVar.a()) {
            return b(aVar.f33224a, j3, aVar.f33227d);
        } else if (!this.f33521i.b(aVar.f33225b, aVar.f33226c)) {
            return null;
        } else {
            return a(aVar.f33224a, aVar.f33225b, aVar.f33226c, j2, aVar.f33227d);
        }
    }

    private t a(Object obj, int i2, int i3, long j2, long j3) {
        o.a aVar = new o.a(obj, i2, i3, j3);
        return new t(aVar, i3 == this.f33521i.b(i2) ? this.f33521i.f31128f.f32794e : 0, j2, -9223372036854775807L, this.f33513a.a(aVar.f33224a, this.f33521i).c(aVar.f33225b, aVar.f33226c), false, false);
    }

    private t b(Object obj, long j2, long j3) {
        long j4;
        int b2 = this.f33521i.b(j2);
        Object obj2 = obj;
        o.a aVar = new o.a(obj, j3, b2);
        boolean a2 = a(aVar);
        boolean a3 = a(aVar, a2);
        long a4 = b2 != -1 ? this.f33521i.a(b2) : -9223372036854775807L;
        if (a4 == -9223372036854775807L || a4 == Long.MIN_VALUE) {
            j4 = this.f33521i.f31126d;
        } else {
            j4 = a4;
        }
        return new t(aVar, j2, -9223372036854775807L, a4, j4, a2, a3);
    }

    private static boolean a(o.a aVar) {
        return !aVar.a() && aVar.f33228e == -1;
    }

    private boolean a(o.a aVar, boolean z) {
        int a2 = this.f33513a.a(aVar.f33224a);
        if (this.f33513a.a(this.f33513a.a(a2, this.f33521i, false).f31125c, this.j).f31133e || !this.f33513a.b(a2, this.f33521i, this.j, this.f33514b, this.f33515c) || !z) {
            return false;
        }
        return true;
    }
}
