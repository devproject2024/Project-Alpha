package com.google.gson;

import com.google.gson.internal.g;

public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final g<String, l> f39636a = new g<>();

    public final void a(String str, l lVar) {
        g<String, l> gVar = this.f39636a;
        if (lVar == null) {
            lVar = n.f39635a;
        }
        gVar.put(str, lVar);
    }

    public final void a(String str, String str2) {
        a(str, str2 == null ? n.f39635a : new r(str2));
    }

    public final void a(String str, Number number) {
        a(str, number == null ? n.f39635a : new r(number));
    }

    public final boolean a(String str) {
        return this.f39636a.containsKey(str);
    }

    public final l b(String str) {
        return this.f39636a.get(str);
    }

    public final r c(String str) {
        return (r) this.f39636a.get(str);
    }

    public final i d(String str) {
        return (i) this.f39636a.get(str);
    }

    public final o e(String str) {
        return (o) this.f39636a.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof o) && ((o) obj).f39636a.equals(this.f39636a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f39636a.hashCode();
    }
}
