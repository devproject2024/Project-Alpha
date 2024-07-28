package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.fv  reason: invalid package */
final class fv extends ga {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fq f9653a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private fv(fq fqVar) {
        super(fqVar, (byte) 0);
        this.f9653a = fqVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new fs(this.f9653a, (byte) 0);
    }

    /* synthetic */ fv(fq fqVar, byte b2) {
        this(fqVar);
    }
}
