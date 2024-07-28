package com.google.android.gms.internal.p001firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.fz  reason: invalid package */
final class fz implements Comparable<fz>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f9658a;

    /* renamed from: b  reason: collision with root package name */
    private V f9659b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fq f9660c;

    fz(fq fqVar, Map.Entry<K, V> entry) {
        this(fqVar, (Comparable) entry.getKey(), entry.getValue());
    }

    fz(fq fqVar, K k, V v) {
        this.f9660c = fqVar;
        this.f9658a = k;
        this.f9659b = v;
    }

    public final V getValue() {
        return this.f9659b;
    }

    public final V setValue(V v) {
        this.f9660c.e();
        V v2 = this.f9659b;
        this.f9659b = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f9658a, entry.getKey()) && a(this.f9659b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f9658a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f9659b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f9658a);
        String valueOf2 = String.valueOf(this.f9659b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.f9658a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((fz) obj).getKey());
    }
}
