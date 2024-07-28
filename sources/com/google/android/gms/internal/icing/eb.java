package com.google.android.gms.internal.icing;

import java.util.Map;

final class eb implements Comparable<eb>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f10194a;

    /* renamed from: b  reason: collision with root package name */
    private V f10195b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dw f10196c;

    eb(dw dwVar, Map.Entry<K, V> entry) {
        this(dwVar, (Comparable) entry.getKey(), entry.getValue());
    }

    eb(dw dwVar, K k, V v) {
        this.f10196c = dwVar;
        this.f10194a = k;
        this.f10195b = v;
    }

    public final V getValue() {
        return this.f10195b;
    }

    public final V setValue(V v) {
        this.f10196c.e();
        V v2 = this.f10195b;
        this.f10195b = v;
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
        return a(this.f10194a, entry.getKey()) && a(this.f10195b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f10194a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f10195b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f10194a);
        String valueOf2 = String.valueOf(this.f10195b);
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
        return this.f10194a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((eb) obj).getKey());
    }
}
