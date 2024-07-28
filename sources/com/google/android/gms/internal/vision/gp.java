package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class gp implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f11191a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f11192b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ gn f11193c;

    private gp(gn gnVar) {
        this.f11193c = gnVar;
        this.f11191a = this.f11193c.f11185c.size();
    }

    public final boolean hasNext() {
        int i2 = this.f11191a;
        return (i2 > 0 && i2 <= this.f11193c.f11185c.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f11192b == null) {
            this.f11192b = this.f11193c.f11188f.entrySet().iterator();
        }
        return this.f11192b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List b2 = this.f11193c.f11185c;
        int i2 = this.f11191a - 1;
        this.f11191a = i2;
        return (Map.Entry) b2.get(i2);
    }

    /* synthetic */ gp(gn gnVar, byte b2) {
        this(gnVar);
    }
}
