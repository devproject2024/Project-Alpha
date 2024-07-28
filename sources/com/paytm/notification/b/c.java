package com.paytm.notification.b;

import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    long f43009a;

    /* renamed from: b  reason: collision with root package name */
    String f43010b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f43009a == cVar.f43009a && k.a((Object) this.f43010b, (Object) cVar.f43010b);
    }

    public final int hashCode() {
        long j = this.f43009a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.f43010b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "ActivityLogItem(date=" + this.f43009a + ", value=" + this.f43010b + ")";
    }

    public c(long j, String str) {
        k.c(str, "value");
        this.f43009a = j;
        this.f43010b = str;
    }

    public final void a(String str) {
        k.c(str, "<set-?>");
        this.f43010b = str;
    }
}
