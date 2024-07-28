package com.arthurivanets.arvi.b.a;

final class c<K, V> implements a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f30993a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final a<K, V> f30994b;

    c(a<K, V> aVar) {
        com.arthurivanets.arvi.b.b.c.a((Object) aVar);
        this.f30994b = aVar;
    }

    public final V a(K k, V v) {
        V a2;
        synchronized (this.f30993a) {
            a2 = this.f30994b.a(k, v);
        }
        return a2;
    }

    public final V b(K k, V v) {
        V b2;
        synchronized (this.f30993a) {
            b2 = this.f30994b.b(k, v);
        }
        return b2;
    }

    public final V a(K k) {
        V a2;
        synchronized (this.f30993a) {
            a2 = this.f30994b.a(k);
        }
        return a2;
    }
}
