package com.google.gsonhtcfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f39821a = new ArrayList();

    public final void a(l lVar) {
        if (lVar == null) {
            lVar = n.f39822a;
        }
        this.f39821a.add(lVar);
    }

    public final Iterator<l> iterator() {
        return this.f39821a.iterator();
    }

    public final Number a() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public final String b() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).b();
        }
        throw new IllegalStateException();
    }

    public final double c() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final long d() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public final int e() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public final boolean f() {
        if (this.f39821a.size() == 1) {
            return this.f39821a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof i) && ((i) obj).f39821a.equals(this.f39821a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f39821a.hashCode();
    }
}
