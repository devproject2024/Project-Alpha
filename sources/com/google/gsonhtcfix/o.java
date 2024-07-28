package com.google.gsonhtcfix;

import com.google.gsonhtcfix.b.g;

public final class o extends l {

    /* renamed from: a  reason: collision with root package name */
    public final g<String, l> f39823a = new g<>();

    public final void a(String str, l lVar) {
        if (lVar == null) {
            lVar = n.f39822a;
        }
        this.f39823a.put(str, lVar);
    }

    public final boolean a(String str) {
        return this.f39823a.containsKey(str);
    }

    public final l b(String str) {
        return this.f39823a.get(str);
    }

    public final i c(String str) {
        return (i) this.f39823a.get(str);
    }

    public final o d(String str) {
        return (o) this.f39823a.get(str);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof o) && ((o) obj).f39823a.equals(this.f39823a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f39823a.hashCode();
    }

    public final void a(String str, String str2) {
        l lVar;
        if (str2 == null) {
            lVar = n.f39822a;
        } else {
            lVar = new s((Object) str2);
        }
        a(str, lVar);
    }
}
