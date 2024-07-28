package com.google.android.datatransport.cct.a;

import java.util.List;

final class d extends j {

    /* renamed from: a  reason: collision with root package name */
    private final List<m> f7669a;

    d(List<m> list) {
        if (list != null) {
            this.f7669a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public final List<m> a() {
        return this.f7669a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.f7669a.equals(((j) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f7669a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f7669a + "}";
    }
}
