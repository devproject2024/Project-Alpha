package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.do  reason: invalid class name */
final class Cdo implements Comparable<Cdo>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f9299a;

    /* renamed from: b  reason: collision with root package name */
    private V f9300b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dh f9301c;

    Cdo(dh dhVar, K k, V v) {
        this.f9301c = dhVar;
        this.f9299a = k;
        this.f9300b = v;
    }

    Cdo(dh dhVar, Map.Entry<K, V> entry) {
        this(dhVar, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((Cdo) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f9299a, entry.getKey()) && a(this.f9300b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f9299a;
    }

    public final V getValue() {
        return this.f9300b;
    }

    public final int hashCode() {
        K k = this.f9299a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f9300b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final V setValue(V v) {
        this.f9301c.e();
        V v2 = this.f9300b;
        this.f9300b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f9299a);
        String valueOf2 = String.valueOf(this.f9300b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
