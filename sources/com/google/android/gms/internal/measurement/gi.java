package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class gi implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f10694a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10695b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f10696c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ ga f10697d;

    private gi(ga gaVar) {
        this.f10697d = gaVar;
        this.f10694a = -1;
    }

    public final boolean hasNext() {
        if (this.f10694a + 1 < this.f10697d.f10679c.size() || (!this.f10697d.f10680d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f10695b) {
            this.f10695b = false;
            this.f10697d.e();
            if (this.f10694a < this.f10697d.f10679c.size()) {
                ga gaVar = this.f10697d;
                int i2 = this.f10694a;
                this.f10694a = i2 - 1;
                Object unused = gaVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f10696c == null) {
            this.f10696c = this.f10697d.f10680d.entrySet().iterator();
        }
        return this.f10696c;
    }

    public final /* synthetic */ Object next() {
        this.f10695b = true;
        int i2 = this.f10694a + 1;
        this.f10694a = i2;
        if (i2 < this.f10697d.f10679c.size()) {
            return (Map.Entry) this.f10697d.f10679c.get(this.f10694a);
        }
        return (Map.Entry) a().next();
    }

    /* synthetic */ gi(ga gaVar, byte b2) {
        this(gaVar);
    }
}
