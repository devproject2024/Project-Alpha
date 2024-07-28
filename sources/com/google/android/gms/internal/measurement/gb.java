package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class gb extends gh {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ga f10684a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private gb(ga gaVar) {
        super(gaVar, (byte) 0);
        this.f10684a = gaVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new gc(this.f10684a, (byte) 0);
    }

    /* synthetic */ gb(ga gaVar, byte b2) {
        this(gaVar);
    }
}
