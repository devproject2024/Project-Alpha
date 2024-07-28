package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

final class im extends is {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ il f10005a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private im(il ilVar) {
        super(ilVar, (byte) 0);
        this.f10005a = ilVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new in(this.f10005a, (byte) 0);
    }

    /* synthetic */ im(il ilVar, byte b2) {
        this(ilVar);
    }
}
