package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class go extends gv {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ gn f11190a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private go(gn gnVar) {
        super(gnVar, (byte) 0);
        this.f11190a = gnVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new gp(this.f11190a, (byte) 0);
    }

    /* synthetic */ go(gn gnVar, byte b2) {
        this(gnVar);
    }
}
