package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.ah;

abstract class a extends ah {

    /* renamed from: b  reason: collision with root package name */
    private final int f32787b;

    /* renamed from: c  reason: collision with root package name */
    private final w f32788c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32789d = false;

    /* access modifiers changed from: protected */
    public abstract int b(int i2);

    /* access modifiers changed from: protected */
    public abstract int c(int i2);

    /* access modifiers changed from: protected */
    public abstract int c(Object obj);

    /* access modifiers changed from: protected */
    public abstract int d(int i2);

    /* access modifiers changed from: protected */
    public abstract ah d();

    /* access modifiers changed from: protected */
    public abstract int e(int i2);

    /* access modifiers changed from: protected */
    public abstract Object f(int i2);

    public static Object b(Object obj) {
        return ((Pair) obj).second;
    }

    public a(w wVar) {
        this.f32788c = wVar;
        this.f32787b = wVar.a();
    }

    public final int a(int i2, int i3, boolean z) {
        int i4 = 0;
        if (this.f32789d) {
            if (i3 == 1) {
                i3 = 2;
            }
            z = false;
        }
        int c2 = c(i2);
        int e2 = e(c2);
        ah d2 = d();
        int i5 = i2 - e2;
        if (i3 != 2) {
            i4 = i3;
        }
        int a2 = d2.a(i5, i4, z);
        if (a2 != -1) {
            return e2 + a2;
        }
        int a3 = a(c2, z);
        while (a3 != -1 && d().a()) {
            a3 = a(a3, z);
        }
        if (a3 != -1) {
            return e(a3) + d().b(z);
        }
        if (i3 == 2) {
            return b(z);
        }
        return -1;
    }

    public final int b(int i2, int i3, boolean z) {
        int i4 = 0;
        if (this.f32789d) {
            if (i3 == 1) {
                i3 = 2;
            }
            z = false;
        }
        int c2 = c(i2);
        int e2 = e(c2);
        ah d2 = d();
        int i5 = i2 - e2;
        if (i3 != 2) {
            i4 = i3;
        }
        int b2 = d2.b(i5, i4, z);
        if (b2 != -1) {
            return e2 + b2;
        }
        int b3 = b(c2, z);
        while (b3 != -1 && d().a()) {
            b3 = b(b3, z);
        }
        if (b3 != -1) {
            return e(b3) + d().a(z);
        }
        if (i3 == 2) {
            return a(z);
        }
        return -1;
    }

    public final int a(boolean z) {
        if (this.f32787b == 0) {
            return -1;
        }
        if (this.f32789d) {
            z = false;
        }
        int b2 = z ? this.f32788c.b() : this.f32787b - 1;
        while (d().a()) {
            b2 = b(b2, z);
            if (b2 == -1) {
                return -1;
            }
        }
        return e(b2) + d().a(z);
    }

    public final int b(boolean z) {
        if (this.f32787b == 0) {
            return -1;
        }
        int i2 = 0;
        if (this.f32789d) {
            z = false;
        }
        if (z) {
            i2 = this.f32788c.c();
        }
        while (d().a()) {
            i2 = a(i2, z);
            if (i2 == -1) {
                return -1;
            }
        }
        return e(i2) + d().b(z);
    }

    public final ah.b a(int i2, ah.b bVar, boolean z, long j) {
        int c2 = c(i2);
        int e2 = e(c2);
        int d2 = d(c2);
        d().a(i2 - e2, bVar, z, j);
        bVar.f31134f += d2;
        bVar.f31135g += d2;
        return bVar;
    }

    public final ah.a a(int i2, ah.a aVar, boolean z) {
        int b2 = b(i2);
        int e2 = e(b2);
        d().a(i2 - d(b2), aVar, z);
        aVar.f31125c += e2;
        if (z) {
            aVar.f31124b = Pair.create(f(b2), aVar.f31124b);
        }
        return aVar;
    }

    public final int a(Object obj) {
        int a2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int c2 = c(obj2);
        if (c2 == -1 || (a2 = d().a(obj3)) == -1) {
            return -1;
        }
        return d(c2) + a2;
    }

    public final Object a(int i2) {
        int b2 = b(i2);
        return Pair.create(f(b2), d().a(i2 - d(b2)));
    }

    private int a(int i2, boolean z) {
        if (z) {
            return this.f32788c.a(i2);
        }
        if (i2 < this.f32787b - 1) {
            return i2 + 1;
        }
        return -1;
    }

    private int b(int i2, boolean z) {
        if (z) {
            return this.f32788c.b(i2);
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return -1;
    }

    public final ah.a a(Object obj, ah.a aVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int e2 = e(c(obj2));
        d().a(obj3, aVar);
        aVar.f31125c += e2;
        aVar.f31124b = obj;
        return aVar;
    }
}
