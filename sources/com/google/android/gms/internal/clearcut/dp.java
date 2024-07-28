package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class dp implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f9302a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9303b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f9304c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ dh f9305d;

    private dp(dh dhVar) {
        this.f9305d = dhVar;
        this.f9302a = -1;
    }

    /* synthetic */ dp(dh dhVar, byte b2) {
        this(dhVar);
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f9304c == null) {
            this.f9304c = this.f9305d.f9289d.entrySet().iterator();
        }
        return this.f9304c;
    }

    public final boolean hasNext() {
        return this.f9302a + 1 < this.f9305d.f9288c.size() || (!this.f9305d.f9289d.isEmpty() && a().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.f9303b = true;
        int i2 = this.f9302a + 1;
        this.f9302a = i2;
        return (Map.Entry) (i2 < this.f9305d.f9288c.size() ? this.f9305d.f9288c.get(this.f9302a) : a().next());
    }

    public final void remove() {
        if (this.f9303b) {
            this.f9303b = false;
            this.f9305d.e();
            if (this.f9302a < this.f9305d.f9288c.size()) {
                dh dhVar = this.f9305d;
                int i2 = this.f9302a;
                this.f9302a = i2 - 1;
                Object unused = dhVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
