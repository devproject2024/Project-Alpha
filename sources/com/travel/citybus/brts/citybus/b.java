package com.travel.citybus.brts.citybus;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    String f23278a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof b) && k.a((Object) this.f23278a, (Object) ((b) obj).f23278a);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f23278a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRBPDPModel(name=" + this.f23278a + ")";
    }

    public b(String str) {
        k.c(str, "name");
        this.f23278a = str;
    }
}
