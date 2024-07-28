package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class ee implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10198a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10199b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10200c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ dw f10201d;

    private ee(dw dwVar) {
        this.f10201d = dwVar;
        this.f10198a = -1;
    }

    public final boolean hasNext() {
        if (this.f10198a + 1 < this.f10201d.f10183c.size() || (!this.f10201d.f10184d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f10199b) {
            this.f10199b = false;
            this.f10201d.e();
            if (this.f10198a < this.f10201d.f10183c.size()) {
                dw dwVar = this.f10201d;
                int i2 = this.f10198a;
                this.f10198a = i2 - 1;
                Object unused = dwVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10200c == null) {
            this.f10200c = this.f10201d.f10184d.entrySet().iterator();
        }
        return this.f10200c;
    }

    public final /* synthetic */ Object next() {
        this.f10199b = true;
        int i2 = this.f10198a + 1;
        this.f10198a = i2;
        if (i2 < this.f10201d.f10183c.size()) {
            return (Map.Entry) this.f10201d.f10183c.get(this.f10198a);
        }
        return (Map.Entry) a().next();
    }

    /* synthetic */ ee(dw dwVar, byte b2) {
        this(dwVar);
    }
}
