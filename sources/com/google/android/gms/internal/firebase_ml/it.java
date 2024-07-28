package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

final class it implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10015a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10016b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10017c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ il f10018d;

    private it(il ilVar) {
        this.f10018d = ilVar;
        this.f10015a = -1;
    }

    public final boolean hasNext() {
        if (this.f10015a + 1 < this.f10018d.f10000c.size() || (!this.f10018d.f10001d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f10016b) {
            this.f10016b = false;
            this.f10018d.e();
            if (this.f10015a < this.f10018d.f10000c.size()) {
                il ilVar = this.f10018d;
                int i2 = this.f10015a;
                this.f10015a = i2 - 1;
                Object unused = ilVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10017c == null) {
            this.f10017c = this.f10018d.f10001d.entrySet().iterator();
        }
        return this.f10017c;
    }

    public final /* synthetic */ Object next() {
        this.f10016b = true;
        int i2 = this.f10015a + 1;
        this.f10015a = i2;
        if (i2 < this.f10018d.f10000c.size()) {
            return (Map.Entry) this.f10018d.f10000c.get(this.f10015a);
        }
        return (Map.Entry) a().next();
    }

    /* synthetic */ it(il ilVar, byte b2) {
        this(ilVar);
    }
}
