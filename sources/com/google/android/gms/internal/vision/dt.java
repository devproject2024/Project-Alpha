package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class dt implements hx {

    /* renamed from: a  reason: collision with root package name */
    private final dr f11064a;

    dt(dr drVar) {
        this.f11064a = (dr) ek.a(drVar, "output");
        this.f11064a.f11056c = this;
    }

    public final int a() {
        return ej.e.j;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f11064a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f11064a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f11064a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f11064a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f11064a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f11064a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f11064a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f11064a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f11064a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f11064a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f11064a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f11064a.a(i2, str);
    }

    public final void a(int i2, cz czVar) throws IOException {
        this.f11064a.a(i2, czVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f11064a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f11064a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f11064a.b(i2, j);
    }

    public final void a(int i2, Object obj, gi giVar) throws IOException {
        this.f11064a.a(i2, (ft) obj, giVar);
    }

    public final void b(int i2, Object obj, gi giVar) throws IOException {
        dr drVar = this.f11064a;
        drVar.a(i2, 3);
        giVar.a((ft) obj, (hx) drVar.f11056c);
        drVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f11064a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f11064a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof cz) {
            this.f11064a.b(i2, (cz) obj);
        } else {
            this.f11064a.a(i2, (ft) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.m(list.get(i5).intValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += dr.a();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.d(list.get(i5).longValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.e(list.get(i5).longValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += dr.c();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += dr.e();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += dr.f();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.p(list.get(i5).intValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += dr.g();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof fa) {
            fa faVar = (fa) list;
            while (i3 < list.size()) {
                Object b2 = faVar.b(i3);
                if (b2 instanceof String) {
                    this.f11064a.a(i2, (String) b2);
                } else {
                    this.f11064a.a(i2, (cz) b2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<cz> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f11064a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.n(list.get(i5).intValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += dr.b();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += dr.d();
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.o(list.get(i5).intValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f11064a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += dr.f(list.get(i5).longValue());
            }
            this.f11064a.b(i4);
            while (i3 < list.size()) {
                this.f11064a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f11064a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, gi giVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), giVar);
        }
    }

    public final void b(int i2, List<?> list, gi giVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), giVar);
        }
    }

    public final <K, V> void a(int i2, fj<K, V> fjVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f11064a.a(i2, 2);
            this.f11064a.b(fk.a(fjVar, next.getKey(), next.getValue()));
            fk.a(this.f11064a, fjVar, next.getKey(), next.getValue());
        }
    }
}
