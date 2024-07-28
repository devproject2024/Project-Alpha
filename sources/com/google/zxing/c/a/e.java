package com.google.zxing.c.a;

import com.google.zxing.h;
import easypay.manager.Constants;

public final class e {

    /* renamed from: h  reason: collision with root package name */
    private static final e[] f39953h = {new e(1, 10, 10, 8, 8, new b(5, new a(1, 3, (byte) 0), (byte) 0)), new e(2, 12, 12, 10, 10, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(3, 14, 14, 12, 12, new b(10, new a(1, 8, (byte) 0), (byte) 0)), new e(4, 16, 16, 14, 14, new b(12, new a(1, 12, (byte) 0), (byte) 0)), new e(5, 18, 18, 16, 16, new b(14, new a(1, 18, (byte) 0), (byte) 0)), new e(6, 20, 20, 18, 18, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(7, 22, 22, 20, 20, new b(20, new a(1, 30, (byte) 0), (byte) 0)), new e(8, 24, 24, 22, 22, new b(24, new a(1, 36, (byte) 0), (byte) 0)), new e(9, 26, 26, 24, 24, new b(28, new a(1, 44, (byte) 0), (byte) 0)), new e(10, 32, 32, 14, 14, new b(36, new a(1, 62, (byte) 0), (byte) 0)), new e(11, 36, 36, 16, 16, new b(42, new a(1, 86, (byte) 0), (byte) 0)), new e(12, 40, 40, 18, 18, new b(48, new a(1, 114, (byte) 0), (byte) 0)), new e(13, 44, 44, 20, 20, new b(56, new a(1, 144, (byte) 0), (byte) 0)), new e(14, 48, 48, 22, 22, new b(68, new a(1, 174, (byte) 0), (byte) 0)), new e(15, 52, 52, 24, 24, new b(42, new a(2, 102, (byte) 0), (byte) 0)), new e(16, 64, 64, 14, 14, new b(56, new a(2, 140, (byte) 0), (byte) 0)), new e(17, 72, 72, 16, 16, new b(36, new a(4, 92, (byte) 0), (byte) 0)), new e(18, 80, 80, 18, 18, new b(48, new a(4, 114, (byte) 0), (byte) 0)), new e(19, 88, 88, 20, 20, new b(56, new a(4, 144, (byte) 0), (byte) 0)), new e(20, 96, 96, 22, 22, new b(68, new a(4, 174, (byte) 0), (byte) 0)), new e(21, 104, 104, 24, 24, new b(56, new a(6, 136, (byte) 0), (byte) 0)), new e(22, 120, 120, 18, 18, new b(68, new a(6, 175, (byte) 0), (byte) 0)), new e(23, 132, 132, 20, 20, new b(62, new a(8, 163, (byte) 0), (byte) 0)), new e(24, 144, 144, 22, 22, new b(new a(8, Constants.ACTION_DELAY_PASSWORD_FOUND, (byte) 0), new a(2, 155, (byte) 0), (byte) 0)), new e(25, 8, 18, 6, 16, new b(7, new a(1, 5, (byte) 0), (byte) 0)), new e(26, 8, 32, 6, 14, new b(11, new a(1, 10, (byte) 0), (byte) 0)), new e(27, 12, 26, 10, 24, new b(14, new a(1, 16, (byte) 0), (byte) 0)), new e(28, 12, 36, 10, 16, new b(18, new a(1, 22, (byte) 0), (byte) 0)), new e(29, 16, 36, 14, 16, new b(24, new a(1, 32, (byte) 0), (byte) 0)), new e(30, 16, 48, 14, 22, new b(28, new a(1, 49, (byte) 0), (byte) 0))};

    /* renamed from: a  reason: collision with root package name */
    final int f39954a;

    /* renamed from: b  reason: collision with root package name */
    final int f39955b;

    /* renamed from: c  reason: collision with root package name */
    final int f39956c;

    /* renamed from: d  reason: collision with root package name */
    final int f39957d;

    /* renamed from: e  reason: collision with root package name */
    final int f39958e;

    /* renamed from: f  reason: collision with root package name */
    final b f39959f;

    /* renamed from: g  reason: collision with root package name */
    final int f39960g;

    private e(int i2, int i3, int i4, int i5, int i6, b bVar) {
        this.f39954a = i2;
        this.f39955b = i3;
        this.f39956c = i4;
        this.f39957d = i5;
        this.f39958e = i6;
        this.f39959f = bVar;
        int i7 = bVar.f39963a;
        int i8 = 0;
        for (a aVar : bVar.f39964b) {
            i8 += aVar.f39961a * (aVar.f39962b + i7);
        }
        this.f39960g = i8;
    }

    public static e a(int i2, int i3) throws h {
        if ((i2 & 1) == 0 && (i3 & 1) == 0) {
            for (e eVar : f39953h) {
                if (eVar.f39955b == i2 && eVar.f39956c == i3) {
                    return eVar;
                }
            }
            throw h.getFormatInstance();
        }
        throw h.getFormatInstance();
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f39963a;

        /* renamed from: b  reason: collision with root package name */
        final a[] f39964b;

        /* synthetic */ b(int i2, a aVar, byte b2) {
            this(i2, aVar);
        }

        /* synthetic */ b(a aVar, a aVar2, byte b2) {
            this(aVar, aVar2);
        }

        private b(int i2, a aVar) {
            this.f39963a = i2;
            this.f39964b = new a[]{aVar};
        }

        private b(a aVar, a aVar2) {
            this.f39963a = 62;
            this.f39964b = new a[]{aVar, aVar2};
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f39961a;

        /* renamed from: b  reason: collision with root package name */
        final int f39962b;

        /* synthetic */ a(int i2, int i3, byte b2) {
            this(i2, i3);
        }

        private a(int i2, int i3) {
            this.f39961a = i2;
            this.f39962b = i3;
        }
    }

    public final String toString() {
        return String.valueOf(this.f39954a);
    }
}
