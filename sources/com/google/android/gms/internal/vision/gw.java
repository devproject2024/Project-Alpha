package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class gw implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f11200a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11201b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f11202c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ gn f11203d;

    private gw(gn gnVar) {
        this.f11203d = gnVar;
        this.f11200a = -1;
    }

    public final boolean hasNext() {
        if (this.f11200a + 1 < this.f11203d.f11185c.size() || (!this.f11203d.f11186d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f11201b) {
            this.f11201b = false;
            this.f11203d.e();
            if (this.f11200a < this.f11203d.f11185c.size()) {
                gn gnVar = this.f11203d;
                int i2 = this.f11200a;
                this.f11200a = i2 - 1;
                Object unused = gnVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f11202c == null) {
            this.f11202c = this.f11203d.f11186d.entrySet().iterator();
        }
        return this.f11202c;
    }

    public final /* synthetic */ Object next() {
        this.f11201b = true;
        int i2 = this.f11200a + 1;
        this.f11200a = i2;
        if (i2 < this.f11203d.f11185c.size()) {
            return (Map.Entry) this.f11203d.f11185c.get(this.f11200a);
        }
        return (Map.Entry) a().next();
    }

    /* synthetic */ gw(gn gnVar, byte b2) {
        this(gnVar);
    }
}
