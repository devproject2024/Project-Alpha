package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class dj implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f9293a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f9294b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dh f9295c;

    private dj(dh dhVar) {
        this.f9295c = dhVar;
        this.f9293a = this.f9295c.f9288c.size();
    }

    /* synthetic */ dj(dh dhVar, byte b2) {
        this(dhVar);
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f9294b == null) {
            this.f9294b = this.f9295c.f9291f.entrySet().iterator();
        }
        return this.f9294b;
    }

    public final boolean hasNext() {
        int i2 = this.f9293a;
        return (i2 > 0 && i2 <= this.f9295c.f9288c.size()) || a().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (a().hasNext()) {
            obj = a().next();
        } else {
            List b2 = this.f9295c.f9288c;
            int i2 = this.f9293a - 1;
            this.f9293a = i2;
            obj = b2.get(i2);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
