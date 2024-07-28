package com.google.zxing.c.b;

import com.google.zxing.b.i;
import com.google.zxing.m;
import com.google.zxing.t;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.zxing.b.b f39965a;

    /* renamed from: b  reason: collision with root package name */
    public final com.google.zxing.b.a.b f39966b;

    public a(com.google.zxing.b.b bVar) throws m {
        this.f39965a = bVar;
        this.f39966b = new com.google.zxing.b.a.b(bVar);
    }

    public static int a(t tVar, t tVar2) {
        return com.google.zxing.b.a.a.a(t.a(tVar, tVar2));
    }

    public static void a(Map<t, Integer> map, t tVar) {
        Integer num = map.get(tVar);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        map.put(tVar, Integer.valueOf(i2));
    }

    public static com.google.zxing.b.b a(com.google.zxing.b.b bVar, t tVar, t tVar2, t tVar3, t tVar4, int i2, int i3) throws m {
        t tVar5 = tVar;
        t tVar6 = tVar2;
        t tVar7 = tVar3;
        t tVar8 = tVar4;
        float f2 = ((float) i2) - 0.5f;
        float f3 = ((float) i3) - 0.5f;
        return i.a().a(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, tVar5.f40584a, tVar5.f40585b, tVar8.f40584a, tVar8.f40585b, tVar7.f40584a, tVar7.f40585b, tVar6.f40584a, tVar6.f40585b);
    }

    /* renamed from: com.google.zxing.c.b.a$a  reason: collision with other inner class name */
    public static final class C0672a {

        /* renamed from: a  reason: collision with root package name */
        public final t f39967a;

        /* renamed from: b  reason: collision with root package name */
        public final t f39968b;

        /* renamed from: c  reason: collision with root package name */
        public final int f39969c;

        /* synthetic */ C0672a(t tVar, t tVar2, int i2, byte b2) {
            this(tVar, tVar2, i2);
        }

        private C0672a(t tVar, t tVar2, int i2) {
            this.f39967a = tVar;
            this.f39968b = tVar2;
            this.f39969c = i2;
        }

        public final String toString() {
            return this.f39967a + "/" + this.f39968b + '/' + this.f39969c;
        }
    }

    public static final class b implements Serializable, Comparator<C0672a> {
        private b() {
        }

        public final int compare(C0672a aVar, C0672a aVar2) {
            return aVar.f39969c - aVar2.f39969c;
        }
    }

    public final boolean a(t tVar) {
        return tVar.f40584a >= 0.0f && tVar.f40584a < ((float) this.f39965a.f39889a) && tVar.f40585b > 0.0f && tVar.f40585b < ((float) this.f39965a.f39890b);
    }

    public final C0672a b(t tVar, t tVar2) {
        a aVar = this;
        t tVar3 = tVar;
        t tVar4 = tVar2;
        int i2 = (int) tVar3.f40584a;
        int i3 = (int) tVar3.f40585b;
        int i4 = (int) tVar4.f40584a;
        int i5 = (int) tVar4.f40585b;
        boolean z = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z) {
            int i6 = i3;
            i3 = i2;
            i2 = i6;
            int i7 = i5;
            i5 = i4;
            i4 = i7;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i5 - i3);
        int i8 = (-abs) / 2;
        int i9 = -1;
        int i10 = i3 < i5 ? 1 : -1;
        if (i2 < i4) {
            i9 = 1;
        }
        boolean a2 = aVar.f39965a.a(z ? i3 : i2, z ? i2 : i3);
        int i11 = 0;
        while (i2 != i4) {
            int i12 = i4;
            boolean a3 = aVar.f39965a.a(z ? i3 : i2, z ? i2 : i3);
            if (a3 != a2) {
                i11++;
                a2 = a3;
            }
            i8 += abs2;
            if (i8 > 0) {
                if (i3 == i5) {
                    break;
                }
                i3 += i10;
                i8 -= abs;
            }
            i2 += i9;
            aVar = this;
            i4 = i12;
        }
        return new C0672a(tVar3, tVar4, i11, (byte) 0);
    }
}
