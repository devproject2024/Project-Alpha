package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f39472a = new ArrayList();

    public final void a(l lVar) {
        if (lVar == null) {
            lVar = n.f39635a;
        }
        this.f39472a.add(lVar);
    }

    public final int a() {
        return this.f39472a.size();
    }

    public final Iterator<l> iterator() {
        return this.f39472a.iterator();
    }

    public final l a(int i2) {
        return this.f39472a.get(i2);
    }

    public final Number b() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).b();
        }
        throw new IllegalStateException();
    }

    public final String c() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).c();
        }
        throw new IllegalStateException();
    }

    public final double d() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).d();
        }
        throw new IllegalStateException();
    }

    public final long e() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public final int f() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public final boolean g() {
        if (this.f39472a.size() == 1) {
            return this.f39472a.get(0).g();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof i) && ((i) obj).f39472a.equals(this.f39472a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f39472a.hashCode();
    }
}
