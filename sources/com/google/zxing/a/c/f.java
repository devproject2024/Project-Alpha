package com.google.zxing.a.c;

import com.google.zxing.b.a;
import java.util.LinkedList;

final class f {

    /* renamed from: a  reason: collision with root package name */
    static final f f39872a = new f(g.f39877a, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    final int f39873b;

    /* renamed from: c  reason: collision with root package name */
    final int f39874c;

    /* renamed from: d  reason: collision with root package name */
    final int f39875d;

    /* renamed from: e  reason: collision with root package name */
    private final g f39876e;

    private f(g gVar, int i2, int i3, int i4) {
        this.f39876e = gVar;
        this.f39873b = i2;
        this.f39874c = i3;
        this.f39875d = i4;
    }

    /* access modifiers changed from: package-private */
    public final f a(int i2, int i3) {
        int i4 = this.f39875d;
        g gVar = this.f39876e;
        if (i2 != this.f39873b) {
            int i5 = d.f39865b[this.f39873b][i2];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
        }
        int i8 = i2 == 2 ? 4 : 5;
        return new f(gVar.a(i3, i8), i2, 0, i4 + i8);
    }

    /* access modifiers changed from: package-private */
    public final f b(int i2, int i3) {
        g gVar = this.f39876e;
        int i4 = this.f39873b == 2 ? 4 : 5;
        return new f(gVar.a(d.f39866c[this.f39873b][i2], i4).a(i3, 5), this.f39873b, 0, this.f39875d + i4 + 5);
    }

    /* access modifiers changed from: package-private */
    public final f a(int i2) {
        g gVar = this.f39876e;
        int i3 = this.f39873b;
        int i4 = this.f39875d;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f39865b[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f39874c;
        f fVar = new f(gVar, i3, this.f39874c + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f39874c == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    /* access modifiers changed from: package-private */
    public final f b(int i2) {
        int i3 = this.f39874c;
        if (i3 == 0) {
            return this;
        }
        return new f(this.f39876e.b(i2 - i3, i3), this.f39873b, 0, this.f39875d);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(f fVar) {
        int i2;
        int i3 = this.f39875d + (d.f39865b[this.f39873b][fVar.f39873b] >> 16);
        int i4 = fVar.f39874c;
        if (i4 > 0 && ((i2 = this.f39874c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f39875d;
    }

    /* access modifiers changed from: package-private */
    public final a a(byte[] bArr) {
        LinkedList<g> linkedList = new LinkedList<>();
        for (g gVar = b(bArr.length).f39876e; gVar != null; gVar = gVar.f39878b) {
            linkedList.addFirst(gVar);
        }
        a aVar = new a();
        for (g a2 : linkedList) {
            a2.a(aVar, bArr);
        }
        return aVar;
    }

    public final String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{d.f39864a[this.f39873b], Integer.valueOf(this.f39875d), Integer.valueOf(this.f39874c)});
    }
}
