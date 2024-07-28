package com.google.android.gms.internal.measurement;

import java.util.Map;

final class gf implements Comparable<gf>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f10690a;

    /* renamed from: b  reason: collision with root package name */
    private V f10691b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ga f10692c;

    gf(ga gaVar, Map.Entry<K, V> entry) {
        this(gaVar, (Comparable) entry.getKey(), entry.getValue());
    }

    gf(ga gaVar, K k, V v) {
        this.f10692c = gaVar;
        this.f10690a = k;
        this.f10691b = v;
    }

    public final V getValue() {
        return this.f10691b;
    }

    public final V setValue(V v) {
        this.f10692c.e();
        V v2 = this.f10691b;
        this.f10691b = v;
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
        return a(this.f10690a, entry.getKey()) && a(this.f10691b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f10690a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f10691b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f10690a);
        String valueOf2 = String.valueOf(this.f10691b);
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
        return this.f10690a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((gf) obj).getKey());
    }
}
