package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.ep  reason: invalid package */
public final class ep<K, V> {

    /* renamed from: a  reason: collision with root package name */
    final es<K, V> f9603a;

    /* renamed from: b  reason: collision with root package name */
    private final K f9604b;

    /* renamed from: c  reason: collision with root package name */
    private final V f9605c;

    private ep(gu guVar, K k, gu guVar2, V v) {
        this.f9603a = new es<>(guVar, k, guVar2, v);
        this.f9604b = k;
        this.f9605c = v;
    }

    public static <K, V> ep<K, V> a(gu guVar, K k, gu guVar2, V v) {
        return new ep<>(guVar, k, guVar2, v);
    }

    static <K, V> int a(es<K, V> esVar, K k, V v) {
        return di.a(esVar.f9607a, 1, k) + di.a(esVar.f9608b, 2, v);
    }
}
