package com.google.c;

import com.google.c.bz;
import java.io.IOException;

public final class am<K, V> {

    /* renamed from: a  reason: collision with root package name */
    final a<K, V> f37722a;

    static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final bz.a f37723a;

        /* renamed from: b  reason: collision with root package name */
        public final K f37724b;

        /* renamed from: c  reason: collision with root package name */
        public final bz.a f37725c;

        /* renamed from: d  reason: collision with root package name */
        public final V f37726d;
    }

    static <K, V> void a(m mVar, a<K, V> aVar, K k, V v) throws IOException {
        w.a(mVar, aVar.f37723a, 1, k);
        w.a(mVar, aVar.f37725c, 2, v);
    }

    static <K, V> int a(a<K, V> aVar, K k, V v) {
        return w.a(aVar.f37723a, 1, k) + w.a(aVar.f37725c, 2, v);
    }
}
