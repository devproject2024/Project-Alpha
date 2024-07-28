package com.google.c;

import com.google.c.am;
import com.google.c.ca;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

final class n implements ca {

    /* renamed from: a  reason: collision with root package name */
    private final m f37898a;

    n(m mVar) {
        this.f37898a = (m) ac.a(mVar, "output");
        this.f37898a.f37892b = this;
    }

    public final ca.a a() {
        return ca.a.ASCENDING;
    }

    public final void a(int i2, int i3) throws IOException {
        this.f37898a.e(i2, i3);
    }

    public final void a(int i2, long j) throws IOException {
        this.f37898a.a(i2, j);
    }

    public final void b(int i2, long j) throws IOException {
        this.f37898a.c(i2, j);
    }

    public final void a(int i2, float f2) throws IOException {
        this.f37898a.a(i2, f2);
    }

    public final void a(int i2, double d2) throws IOException {
        this.f37898a.a(i2, d2);
    }

    public final void b(int i2, int i3) throws IOException {
        this.f37898a.b(i2, i3);
    }

    public final void c(int i2, long j) throws IOException {
        this.f37898a.a(i2, j);
    }

    public final void c(int i2, int i3) throws IOException {
        this.f37898a.b(i2, i3);
    }

    public final void d(int i2, long j) throws IOException {
        this.f37898a.c(i2, j);
    }

    public final void d(int i2, int i3) throws IOException {
        this.f37898a.e(i2, i3);
    }

    public final void a(int i2, boolean z) throws IOException {
        this.f37898a.a(i2, z);
    }

    public final void a(int i2, String str) throws IOException {
        this.f37898a.a(i2, str);
    }

    public final void a(int i2, j jVar) throws IOException {
        this.f37898a.a(i2, jVar);
    }

    public final void e(int i2, int i3) throws IOException {
        this.f37898a.c(i2, i3);
    }

    public final void f(int i2, int i3) throws IOException {
        this.f37898a.d(i2, i3);
    }

    public final void e(int i2, long j) throws IOException {
        this.f37898a.b(i2, j);
    }

    public final void a(int i2, Object obj, bm bmVar) throws IOException {
        this.f37898a.a(i2, (at) obj, bmVar);
    }

    public final void b(int i2, Object obj, bm bmVar) throws IOException {
        m mVar = this.f37898a;
        mVar.a(i2, 3);
        bmVar.a((at) obj, (ca) mVar.f37892b);
        mVar.a(i2, 4);
    }

    public final void a(int i2) throws IOException {
        this.f37898a.a(i2, 3);
    }

    public final void b(int i2) throws IOException {
        this.f37898a.a(i2, 4);
    }

    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof j) {
            this.f37898a.b(i2, (j) obj);
        } else {
            this.f37898a.a(i2, (at) obj);
        }
    }

    public final void a(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.m(list.get(i5).intValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void b(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += m.a();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.d(list.get(i5).longValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void d(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.e(list.get(i5).longValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += m.c();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void f(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).floatValue();
                i4 += m.e();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    public final void g(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).doubleValue();
                i4 += m.f();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    public final void h(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.p(list.get(i5).intValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).booleanValue();
                i4 += m.g();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    public final void a(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof ai) {
            ai aiVar = (ai) list;
            while (i3 < list.size()) {
                Object b2 = aiVar.b(i3);
                if (b2 instanceof String) {
                    this.f37898a.a(i2, (String) b2);
                } else {
                    this.f37898a.a(i2, (j) b2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.a(i2, list.get(i3));
            i3++;
        }
    }

    public final void b(int i2, List<j> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f37898a.a(i2, list.get(i3));
        }
    }

    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.n(list.get(i5).intValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.b(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.c(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).intValue();
                i4 += m.b();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.d(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.e(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                list.get(i5).longValue();
                i4 += m.d();
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.o(list.get(i5).intValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.c(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.d(i2, list.get(i3).intValue());
            i3++;
        }
    }

    public final void n(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f37898a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += m.f(list.get(i5).longValue());
            }
            this.f37898a.b(i4);
            while (i3 < list.size()) {
                this.f37898a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f37898a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    public final void a(int i2, List<?> list, bm bmVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, (Object) list.get(i3), bmVar);
        }
    }

    public final void b(int i2, List<?> list, bm bmVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, (Object) list.get(i3), bmVar);
        }
    }

    public final <K, V> void a(int i2, am.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f37898a.f37893c) {
            int i3 = 0;
            switch (aVar.f37723a) {
                case BOOL:
                    V v = map.get(Boolean.FALSE);
                    if (v != null) {
                        a(i2, false, v, aVar);
                    }
                    V v2 = map.get(Boolean.TRUE);
                    if (v2 != null) {
                        a(i2, true, v2, aVar);
                        return;
                    }
                    return;
                case FIXED32:
                case INT32:
                case SFIXED32:
                case SINT32:
                case UINT32:
                    int[] iArr = new int[map.size()];
                    int i4 = 0;
                    for (K intValue : map.keySet()) {
                        iArr[i4] = intValue.intValue();
                        i4++;
                    }
                    Arrays.sort(iArr);
                    int length = iArr.length;
                    while (i3 < length) {
                        int i5 = iArr[i3];
                        V v3 = map.get(Integer.valueOf(i5));
                        this.f37898a.a(i2, 2);
                        this.f37898a.b(am.a(aVar, Integer.valueOf(i5), v3));
                        am.a(this.f37898a, aVar, Integer.valueOf(i5), v3);
                        i3++;
                    }
                    return;
                case FIXED64:
                case INT64:
                case SFIXED64:
                case SINT64:
                case UINT64:
                    long[] jArr = new long[map.size()];
                    int i6 = 0;
                    for (K longValue : map.keySet()) {
                        jArr[i6] = longValue.longValue();
                        i6++;
                    }
                    Arrays.sort(jArr);
                    int length2 = jArr.length;
                    while (i3 < length2) {
                        long j = jArr[i3];
                        V v4 = map.get(Long.valueOf(j));
                        this.f37898a.a(i2, 2);
                        this.f37898a.b(am.a(aVar, Long.valueOf(j), v4));
                        am.a(this.f37898a, aVar, Long.valueOf(j), v4);
                        i3++;
                    }
                    return;
                case STRING:
                    String[] strArr = new String[map.size()];
                    int i7 = 0;
                    for (K k : map.keySet()) {
                        strArr[i7] = k;
                        i7++;
                    }
                    Arrays.sort(strArr);
                    int length3 = strArr.length;
                    while (i3 < length3) {
                        String str = strArr[i3];
                        V v5 = map.get(str);
                        this.f37898a.a(i2, 2);
                        this.f37898a.b(am.a(aVar, str, v5));
                        am.a(this.f37898a, aVar, str, v5);
                        i3++;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("does not support key type: " + aVar.f37723a);
            }
        } else {
            for (Map.Entry next : map.entrySet()) {
                this.f37898a.a(i2, 2);
                this.f37898a.b(am.a(aVar, next.getKey(), next.getValue()));
                am.a(this.f37898a, aVar, next.getKey(), next.getValue());
            }
        }
    }

    private <V> void a(int i2, boolean z, V v, am.a<Boolean, V> aVar) throws IOException {
        this.f37898a.a(i2, 2);
        this.f37898a.b(am.a(aVar, Boolean.valueOf(z), v));
        am.a(this.f37898a, aVar, Boolean.valueOf(z), v);
    }
}
