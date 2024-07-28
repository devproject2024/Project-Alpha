package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class bi implements fc {

    /* renamed from: a  reason: collision with root package name */
    private final bf f10085a;

    bi(bf bfVar) {
        this.f10085a = (bf) bx.a(bfVar, "output");
        this.f10085a.f10072c = this;
    }

    public final int a() {
        return bv.c.j;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f10085a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f10085a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f10085a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f10085a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f10085a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f10085a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f10085a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f10085a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f10085a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f10085a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f10085a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f10085a.a(i2, str);
    }

    public final void a(int i2, at atVar) throws IOException {
        this.f10085a.a(i2, atVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f10085a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f10085a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f10085a.b(i2, j);
    }

    public final void a(int i2, Object obj, dr drVar) throws IOException {
        this.f10085a.a(i2, (dd) obj, drVar);
    }

    public final void b(int i2, Object obj, dr drVar) throws IOException {
        bf bfVar = this.f10085a;
        bfVar.a(i2, 3);
        drVar.a((dd) obj, (fc) bfVar.f10072c);
        bfVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f10085a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f10085a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof at) {
            this.f10085a.b(i2, (at) obj);
        } else {
            this.f10085a.a(i2, (dd) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.m(list.get(i5).intValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += bf.a();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.d(list.get(i5).longValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.e(list.get(i5).longValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += bf.c();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += bf.e();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += bf.f();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.p(list.get(i5).intValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += bf.g();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof co) {
            co coVar = (co) list;
            while (i3 < list.size()) {
                Object b2 = coVar.b(i3);
                if (b2 instanceof String) {
                    this.f10085a.a(i2, (String) b2);
                } else {
                    this.f10085a.a(i2, (at) b2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<at> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f10085a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.n(list.get(i5).intValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += bf.b();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += bf.d();
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.o(list.get(i5).intValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f10085a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += bf.f(list.get(i5).longValue());
            }
            this.f10085a.b(i4);
            while (i3 < list.size()) {
                this.f10085a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f10085a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, dr drVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), drVar);
        }
    }

    public final void b(int i2, List<?> list, dr drVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), drVar);
        }
    }

    public final <K, V> void a(int i2, cu<K, V> cuVar, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.f10085a.a(i2, 2);
            this.f10085a.b(bq.a(cuVar.f10144a, 1, next.getKey()) + bq.a(cuVar.f10145b, 2, next.getValue()));
            bf bfVar = this.f10085a;
            Object key = next.getKey();
            Object value = next.getValue();
            bq.a(bfVar, cuVar.f10144a, 1, key);
            bq.a(bfVar, cuVar.f10145b, 2, value);
        }
    }
}
