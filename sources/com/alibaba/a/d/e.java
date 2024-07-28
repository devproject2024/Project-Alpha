package com.alibaba.a.d;

import com.alipay.mobile.nebula.util.tar.TarConstants;

public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V>[] f6368a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6369b;

    public e() {
        this((byte) 0);
    }

    public e(byte b2) {
        this.f6369b = 1023;
        this.f6368a = new a[TarConstants.EOF_BLOCK];
    }

    public final V a(K k) {
        for (a<K, V> aVar = this.f6368a[System.identityHashCode(k) & this.f6369b]; aVar != null; aVar = aVar.f6373d) {
            if (k == aVar.f6371b) {
                return aVar.f6372c;
            }
        }
        return null;
    }

    public final boolean a(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i2 = this.f6369b & identityHashCode;
        for (a<K, V> aVar = this.f6368a[i2]; aVar != null; aVar = aVar.f6373d) {
            if (k == aVar.f6371b) {
                aVar.f6372c = v;
                return true;
            }
        }
        this.f6368a[i2] = new a<>(k, v, identityHashCode, this.f6368a[i2]);
        return false;
    }

    protected static final class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final int f6370a;

        /* renamed from: b  reason: collision with root package name */
        public final K f6371b;

        /* renamed from: c  reason: collision with root package name */
        public V f6372c;

        /* renamed from: d  reason: collision with root package name */
        public final a<K, V> f6373d;

        public a(K k, V v, int i2, a<K, V> aVar) {
            this.f6371b = k;
            this.f6372c = v;
            this.f6373d = aVar;
            this.f6370a = i2;
        }
    }
}
