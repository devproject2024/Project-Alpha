package com.google.android.gms.internal.vision;

import java.util.Map;

final class gt implements Comparable<gt>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f11196a;

    /* renamed from: b  reason: collision with root package name */
    private V f11197b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ gn f11198c;

    gt(gn gnVar, Map.Entry<K, V> entry) {
        this(gnVar, (Comparable) entry.getKey(), entry.getValue());
    }

    gt(gn gnVar, K k, V v) {
        this.f11198c = gnVar;
        this.f11196a = k;
        this.f11197b = v;
    }

    public final V getValue() {
        return this.f11197b;
    }

    public final V setValue(V v) {
        this.f11198c.e();
        V v2 = this.f11197b;
        this.f11197b = v;
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
        return a(this.f11196a, entry.getKey()) && a(this.f11197b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f11196a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f11197b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f11196a);
        String valueOf2 = String.valueOf(this.f11197b);
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
        return this.f11196a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((gt) obj).getKey());
    }
}
