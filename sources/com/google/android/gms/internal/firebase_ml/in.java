package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class in implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10006a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10007b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ il f10008c;

    private in(il ilVar) {
        this.f10008c = ilVar;
        this.f10006a = this.f10008c.f10000c.size();
    }

    public final boolean hasNext() {
        int i2 = this.f10006a;
        return (i2 > 0 && i2 <= this.f10008c.f10000c.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10007b == null) {
            this.f10007b = this.f10008c.f10003f.entrySet().iterator();
        }
        return this.f10007b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List b2 = this.f10008c.f10000c;
        int i2 = this.f10006a - 1;
        this.f10006a = i2;
        return (Map.Entry) b2.get(i2);
    }

    /* synthetic */ in(il ilVar, byte b2) {
        this(ilVar);
    }
}
