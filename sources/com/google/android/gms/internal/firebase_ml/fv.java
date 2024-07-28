package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class fv implements s {

    /* renamed from: a  reason: collision with root package name */
    private final ft f9901a;

    fv(ft ftVar) {
        this.f9901a = (ft) gk.a(ftVar, "output");
        this.f9901a.f9889c = this;
    }

    public final int a() {
        return gg.e.j;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f9901a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f9901a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f9901a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f9901a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f9901a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f9901a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f9901a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f9901a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f9901a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f9901a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f9901a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f9901a.a(i2, str);
    }

    public final void a(int i2, fh fhVar) throws IOException {
        this.f9901a.a(i2, fhVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f9901a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f9901a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f9901a.b(i2, j);
    }

    public final void a(int i2, Object obj, ig igVar) throws IOException {
        this.f9901a.a(i2, (hn) obj, igVar);
    }

    public final void b(int i2, Object obj, ig igVar) throws IOException {
        ft ftVar = this.f9901a;
        ftVar.a(i2, 3);
        igVar.a((hn) obj, (s) ftVar.f9889c);
        ftVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f9901a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f9901a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof fh) {
            this.f9901a.b(i2, (fh) obj);
        } else {
            this.f9901a.a(i2, (hn) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.m(list.get(i5).intValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += ft.a();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.d(list.get(i5).longValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.e(list.get(i5).longValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += ft.c();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += ft.e();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += ft.f();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.p(list.get(i5).intValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += ft.g();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof gz) {
            gz gzVar = (gz) list;
            while (i3 < list.size()) {
                Object a2 = gzVar.a(i3);
                if (a2 instanceof String) {
                    this.f9901a.a(i2, (String) a2);
                } else {
                    this.f9901a.a(i2, (fh) a2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<fh> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f9901a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.n(list.get(i5).intValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += ft.b();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += ft.d();
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.o(list.get(i5).intValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f9901a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += ft.f(list.get(i5).longValue());
            }
            this.f9901a.b(i4);
            while (i3 < list.size()) {
                this.f9901a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f9901a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, ig igVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), igVar);
        }
    }

    public final void b(int i2, List<?> list, ig igVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), igVar);
        }
    }

    public final <K, V> void a(int i2, hi<K, V> hiVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f9901a.a(i2, 2);
            this.f9901a.b(hf.a(hiVar, next.getKey(), next.getValue()));
            ft ftVar = this.f9901a;
            Object key = next.getKey();
            Object value = next.getValue();
            fz.a(ftVar, hiVar.f9959a, 1, key);
            fz.a(ftVar, hiVar.f9960b, 2, value);
        }
    }
}
