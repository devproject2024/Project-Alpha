package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class an implements ep {

    /* renamed from: a  reason: collision with root package name */
    private final am f9156a;

    an(am amVar) {
        this.f9156a = (am) bh.a(amVar, "output");
        this.f9156a.f9139b = this;
    }

    public final int a() {
        return bf.g.j;
    }

    public final void a(int i2) throws IOException {
        this.f9156a.a(i2, 3);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f9156a.a(i2, d2);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f9156a.a(i2, f2);
    }

    public final void a(int i2, int i3) throws IOException {
        this.f9156a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f9156a.a(i2, j);
    }

    public final void a(int i2, ab abVar) throws IOException {
        this.f9156a.a(i2, abVar);
    }

    public final <K, V> void a(int i2, cf<K, V> cfVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f9156a.a(i2, 2);
            this.f9156a.b(ce.a(cfVar, next.getKey(), next.getValue()));
            ce.a(this.f9156a, cfVar, next.getKey(), next.getValue());
        }
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof ab) {
            this.f9156a.b(i2, (ab) obj);
        } else {
            this.f9156a.b(i2, (cm) obj);
        }
    }

    public final void a(int i2, Object obj, de deVar) throws IOException {
        this.f9156a.a(i2, (cm) obj, deVar);
    }

    public final void a(int i2, String str) throws IOException {
        this.f9156a.a(i2, str);
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof bv) {
            bv bvVar = (bv) list;
            while (i3 < list.size()) {
                Object b2 = bvVar.b(i3);
                if (b2 instanceof String) {
                    this.f9156a.a(i2, (String) b2);
                } else {
                    this.f9156a.a(i2, (ab) b2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void a(int i2, List<?> list, de deVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), deVar);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.m(list.get(i5).intValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f9156a.a(i2, z);
    }

    public final void b(int i2) throws IOException {
        this.f9156a.a(i2, 4);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f9156a.b(i2, i3);
    }

    public final void b(int i2, long j) throws IOException {
        this.f9156a.c(i2, j);
    }

    public final void b(int i2, Object obj, de deVar) throws IOException {
        am amVar = this.f9156a;
        amVar.a(i2, 3);
        deVar.a((cm) obj, (ep) amVar.f9139b);
        amVar.a(i2, 4);
    }

    public final void b(int i2, List<ab> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f9156a.a(i2, list.get(i3));
        }
    }

    public final void b(int i2, List<?> list, de deVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), deVar);
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += am.a();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, int i3) throws IOException {
        this.f9156a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f9156a.a(i2, j);
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.d(list.get(i5).longValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, int i3) throws IOException {
        this.f9156a.e(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f9156a.c(i2, j);
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.e(list.get(i5).longValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, int i3) throws IOException {
        this.f9156a.c(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f9156a.b(i2, j);
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += am.c();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, int i3) throws IOException {
        this.f9156a.d(i2, i3);
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += am.e();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += am.f();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.p(list.get(i5).intValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += am.g();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.n(list.get(i5).intValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += am.b();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += am.d();
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.o(list.get(i5).intValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9156a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += am.f(list.get(i5).longValue());
            }
            this.f9156a.b(i4);
            while (i3 < list.size()) {
                this.f9156a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9156a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }
}
