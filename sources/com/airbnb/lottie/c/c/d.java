package com.airbnb.lottie.c.c;

import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.b.g;
import com.business.merchant_payments.utility.StringUtility;
import java.util.List;
import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    final List<com.airbnb.lottie.c.b.b> f5941a;

    /* renamed from: b  reason: collision with root package name */
    final com.airbnb.lottie.d f5942b;

    /* renamed from: c  reason: collision with root package name */
    final String f5943c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5944d;

    /* renamed from: e  reason: collision with root package name */
    public final a f5945e;

    /* renamed from: f  reason: collision with root package name */
    final long f5946f;

    /* renamed from: g  reason: collision with root package name */
    final String f5947g;

    /* renamed from: h  reason: collision with root package name */
    final List<g> f5948h;

    /* renamed from: i  reason: collision with root package name */
    final l f5949i;
    final int j;
    final int k;
    final int l;
    final float m;
    final float n;
    final int o;
    final int p;
    final j q;
    final k r;
    final com.airbnb.lottie.c.a.b s;
    final List<com.airbnb.lottie.g.a<Float>> t;
    final b u;
    final boolean v;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List<com.airbnb.lottie.c.b.b> list, com.airbnb.lottie.d dVar, String str, long j2, a aVar, long j3, String str2, List<g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List<com.airbnb.lottie.g.a<Float>> list3, b bVar, com.airbnb.lottie.c.a.b bVar2, boolean z) {
        this.f5941a = list;
        this.f5942b = dVar;
        this.f5943c = str;
        this.f5944d = j2;
        this.f5945e = aVar;
        this.f5946f = j3;
        this.f5947g = str2;
        this.f5948h = list2;
        this.f5949i = lVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    public final String toString() {
        return a("");
    }

    public final String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.f5943c);
        sb.append(StringUtility.NEW_LINE);
        d a2 = this.f5942b.a(this.f5946f);
        if (a2 != null) {
            sb.append("\t\tParents: ");
            sb.append(a2.f5943c);
            d a3 = this.f5942b.a(a2.f5946f);
            while (a3 != null) {
                sb.append("->");
                sb.append(a3.f5943c);
                a3 = this.f5942b.a(a3.f5946f);
            }
            sb.append(str);
            sb.append(StringUtility.NEW_LINE);
        }
        if (!this.f5948h.isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(this.f5948h.size());
            sb.append(StringUtility.NEW_LINE);
        }
        if (!(this.j == 0 || this.k == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l)}));
        }
        if (!this.f5941a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.c.b.b next : this.f5941a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(next);
                sb.append(StringUtility.NEW_LINE);
            }
        }
        return sb.toString();
    }
}
