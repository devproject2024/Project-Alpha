package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class dg implements hk {

    /* renamed from: a  reason: collision with root package name */
    private final de f10568a;

    dg(de deVar) {
        this.f10568a = (de) dx.a(deVar, "output");
        this.f10568a.f10560c = this;
    }

    public final int a() {
        return dv.d.j;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f10568a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f10568a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f10568a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f10568a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f10568a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f10568a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f10568a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f10568a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f10568a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f10568a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f10568a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f10568a.a(i2, str);
    }

    public final void a(int i2, cm cmVar) throws IOException {
        this.f10568a.a(i2, cmVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f10568a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f10568a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f10568a.b(i2, j);
    }

    public final void a(int i2, Object obj, fv fvVar) throws IOException {
        this.f10568a.a(i2, (ff) obj, fvVar);
    }

    public final void b(int i2, Object obj, fv fvVar) throws IOException {
        de deVar = this.f10568a;
        deVar.a(i2, 3);
        fvVar.a((ff) obj, (hk) deVar.f10560c);
        deVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f10568a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f10568a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof cm) {
            this.f10568a.b(i2, (cm) obj);
        } else {
            this.f10568a.a(i2, (ff) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.m(list.get(i5).intValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += de.a();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.d(list.get(i5).longValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.e(list.get(i5).longValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += de.c();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += de.e();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += de.f();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.p(list.get(i5).intValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += de.g();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof em) {
            em emVar = (em) list;
            while (i3 < list.size()) {
                Object b2 = emVar.b(i3);
                if (b2 instanceof String) {
                    this.f10568a.a(i2, (String) b2);
                } else {
                    this.f10568a.a(i2, (cm) b2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<cm> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f10568a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.n(list.get(i5).intValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += de.b();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += de.d();
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.o(list.get(i5).intValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10568a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += de.f(list.get(i5).longValue());
            }
            this.f10568a.b(i4);
            while (i3 < list.size()) {
                this.f10568a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10568a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, fv fvVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), fvVar);
        }
    }

    public final void b(int i2, List<?> list, fv fvVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), fvVar);
        }
    }

    public final <K, V> void a(int i2, ew<K, V> ewVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f10568a.a(i2, 2);
            this.f10568a.b(ex.a(ewVar, next.getKey(), next.getValue()));
            ex.a(this.f10568a, ewVar, next.getKey(), next.getValue());
        }
    }
}
