package com.google.android.gms.internal.firebase_ml;

import java.util.Map;

final class iq implements Comparable<iq>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final K f10011a;

    /* renamed from: b  reason: collision with root package name */
    private V f10012b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ il f10013c;

    iq(il ilVar, Map.Entry<K, V> entry) {
        this(ilVar, (Comparable) entry.getKey(), entry.getValue());
    }

    iq(il ilVar, K k, V v) {
        this.f10013c = ilVar;
        this.f10011a = k;
        this.f10012b = v;
    }

    public final V getValue() {
        return this.f10012b;
    }

    public final V setValue(V v) {
        this.f10013c.e();
        V v2 = this.f10012b;
        this.f10012b = v;
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
        return a(this.f10011a, entry.getKey()) && a(this.f10012b, entry.getValue());
    }

    public final int hashCode() {
        K k = this.f10011a;
        int i2 = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f10012b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f10011a);
        String valueOf2 = String.valueOf(this.f10012b);
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
        return this.f10011a;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((iq) obj).getKey());
    }
}
