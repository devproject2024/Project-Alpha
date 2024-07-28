package com.google.android.datatransport.runtime.scheduling.a;

import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.l;

final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private final long f7842a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7843b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7844c;

    b(long j, l lVar, h hVar) {
        this.f7842a = j;
        if (lVar != null) {
            this.f7843b = lVar;
            if (hVar != null) {
                this.f7844c = hVar;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public final long a() {
        return this.f7842a;
    }

    public final l b() {
        return this.f7843b;
    }

    public final h c() {
        return this.f7844c;
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f7842a + ", transportContext=" + this.f7843b + ", event=" + this.f7844c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f7842a == hVar.a() && this.f7843b.equals(hVar.b()) && this.f7844c.equals(hVar.c());
        }
    }

    public final int hashCode() {
        long j = this.f7842a;
        return this.f7844c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f7843b.hashCode()) * 1000003);
    }
}
