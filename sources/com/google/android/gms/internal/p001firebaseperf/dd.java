package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.dd  reason: invalid package */
final class dd implements ha {

    /* renamed from: a  reason: collision with root package name */
    private final da f9547a;

    dd(da daVar) {
        this.f9547a = (da) dt.a(daVar, "output");
        this.f9547a.f9535c = this;
    }

    public final int a() {
        return dq.d.j;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f9547a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f9547a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f9547a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f9547a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f9547a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f9547a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f9547a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f9547a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f9547a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f9547a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f9547a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f9547a.a(i2, str);
    }

    public final void a(int i2, co coVar) throws IOException {
        this.f9547a.a(i2, coVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f9547a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f9547a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f9547a.b(i2, j);
    }

    public final void a(int i2, Object obj, fp fpVar) throws IOException {
        this.f9547a.a(i2, (ex) obj, fpVar);
    }

    public final void b(int i2, Object obj, fp fpVar) throws IOException {
        da daVar = this.f9547a;
        daVar.a(i2, 3);
        fpVar.a((ex) obj, (ha) daVar.f9535c);
        daVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f9547a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f9547a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof co) {
            this.f9547a.b(i2, (co) obj);
        } else {
            this.f9547a.a(i2, (ex) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.m(list.get(i5).intValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += da.a();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.d(list.get(i5).longValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.e(list.get(i5).longValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += da.c();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += da.e();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += da.f();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.p(list.get(i5).intValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += da.g();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof ej) {
            ej ejVar = (ej) list;
            while (i3 < list.size()) {
                Object a2 = ejVar.a(i3);
                if (a2 instanceof String) {
                    this.f9547a.a(i2, (String) a2);
                } else {
                    this.f9547a.a(i2, (co) a2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<co> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f9547a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.n(list.get(i5).intValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += da.b();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += da.d();
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.o(list.get(i5).intValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9547a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += da.f(list.get(i5).longValue());
            }
            this.f9547a.b(i4);
            while (i3 < list.size()) {
                this.f9547a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9547a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, fp fpVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), fpVar);
        }
    }

    public final void b(int i2, List<?> list, fp fpVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), fpVar);
        }
    }

    public final <K, V> void a(int i2, es<K, V> esVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f9547a.a(i2, 2);
            this.f9547a.b(ep.a(esVar, next.getKey(), next.getValue()));
            da daVar = this.f9547a;
            Object key = next.getKey();
            Object value = next.getValue();
            di.a(daVar, esVar.f9607a, 1, key);
            di.a(daVar, esVar.f9608b, 2, value);
        }
    }
}
