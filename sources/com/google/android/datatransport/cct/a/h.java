package com.google.android.datatransport.cct.a;

final class h extends n {

    /* renamed from: a  reason: collision with root package name */
    private final long f7702a;

    h(long j) {
        this.f7702a = j;
    }

    public final long a() {
        return this.f7702a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f7702a == ((n) obj).a();
    }

    public final int hashCode() {
        long j = this.f7702a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f7702a + "}";
    }
}
