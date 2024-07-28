package com.travel.citybus.brts.citybus;

import kotlin.g.b.k;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    String f23309a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof n) && k.a((Object) this.f23309a, (Object) ((n) obj).f23309a);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f23309a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRIntermediateStopModel(name=" + this.f23309a + ")";
    }

    public n(String str) {
        k.c(str, "name");
        this.f23309a = str;
    }
}
