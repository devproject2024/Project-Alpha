package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class gc implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10685a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10686b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ga f10687c;

    private gc(ga gaVar) {
        this.f10687c = gaVar;
        this.f10685a = this.f10687c.f10679c.size();
    }

    public final boolean hasNext() {
        int i2 = this.f10685a;
        return (i2 > 0 && i2 <= this.f10687c.f10679c.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10686b == null) {
            this.f10686b = this.f10687c.f10682f.entrySet().iterator();
        }
        return this.f10686b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List b2 = this.f10687c.f10679c;
        int i2 = this.f10685a - 1;
        this.f10685a = i2;
        return (Map.Entry) b2.get(i2);
    }

    /* synthetic */ gc(ga gaVar, byte b2) {
        this(gaVar);
    }
}
