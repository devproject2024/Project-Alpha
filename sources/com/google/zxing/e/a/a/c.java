package com.google.zxing.e.a.a;

import java.util.ArrayList;
import java.util.List;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final List<b> f40343a;

    /* renamed from: b  reason: collision with root package name */
    final int f40344b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40345c = false;

    c(List<b> list, int i2) {
        this.f40343a = new ArrayList(list);
        this.f40344b = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(List<b> list) {
        return this.f40343a.equals(list);
    }

    public final String toString() {
        return "{ " + this.f40343a + " }";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f40343a.equals(cVar.f40343a) || this.f40345c != cVar.f40345c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f40343a.hashCode() ^ Boolean.valueOf(this.f40345c).hashCode();
    }
}
