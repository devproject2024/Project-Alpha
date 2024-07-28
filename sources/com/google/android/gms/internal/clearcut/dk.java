package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class dk extends dq {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ dh f9296a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private dk(dh dhVar) {
        super(dhVar, (byte) 0);
        this.f9296a = dhVar;
    }

    /* synthetic */ dk(dh dhVar, byte b2) {
        this(dhVar);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new dj(this.f9296a, (byte) 0);
    }
}
