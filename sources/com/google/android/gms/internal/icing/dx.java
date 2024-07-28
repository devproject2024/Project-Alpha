package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class dx extends ed {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ dw f10188a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private dx(dw dwVar) {
        super(dwVar, (byte) 0);
        this.f10188a = dwVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new dy(this.f10188a, (byte) 0);
    }

    /* synthetic */ dx(dw dwVar, byte b2) {
        this(dwVar);
    }
}
