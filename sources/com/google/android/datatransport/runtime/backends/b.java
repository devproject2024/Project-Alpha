package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.g;

public final class b extends g {

    /* renamed from: a  reason: collision with root package name */
    private final g.a f7747a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7748b;

    public b(g.a aVar, long j) {
        if (aVar != null) {
            this.f7747a = aVar;
            this.f7748b = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final g.a a() {
        return this.f7747a;
    }

    public final long b() {
        return this.f7748b;
    }

    public final String toString() {
        return "BackendResponse{status=" + this.f7747a + ", nextRequestWaitMillis=" + this.f7748b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f7747a.equals(gVar.a()) && this.f7748b == gVar.b();
        }
    }

    public final int hashCode() {
        long j = this.f7748b;
        return ((this.f7747a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }
}
