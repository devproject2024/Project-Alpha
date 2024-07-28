package com.travel.citybus.brts.citybus;

import kotlin.g.b.k;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    int f23317a;

    /* renamed from: b  reason: collision with root package name */
    Object f23318b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f23317a == pVar.f23317a && k.a(this.f23318b, pVar.f23318b);
    }

    public final int hashCode() {
        int i2 = this.f23317a * 31;
        Object obj = this.f23318b;
        return i2 + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        return "CJRSelectBusStopModel(type=" + this.f23317a + ", data=" + this.f23318b + ")";
    }

    public p(int i2, Object obj) {
        k.c(obj, "data");
        this.f23317a = i2;
        this.f23318b = obj;
    }
}
