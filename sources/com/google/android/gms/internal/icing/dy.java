package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class dy implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10189a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10190b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dw f10191c;

    private dy(dw dwVar) {
        this.f10191c = dwVar;
        this.f10189a = this.f10191c.f10183c.size();
    }

    public final boolean hasNext() {
        int i2 = this.f10189a;
        return (i2 > 0 && i2 <= this.f10191c.f10183c.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10190b == null) {
            this.f10190b = this.f10191c.f10186f.entrySet().iterator();
        }
        return this.f10190b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List b2 = this.f10191c.f10183c;
        int i2 = this.f10189a - 1;
        this.f10189a = i2;
        return (Map.Entry) b2.get(i2);
    }

    /* synthetic */ dy(dw dwVar, byte b2) {
        this(dwVar);
    }
}
