package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import java.util.Set;

final class d extends g.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f7904a;

    /* renamed from: b  reason: collision with root package name */
    private final long f7905b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<g.c> f7906c;

    /* synthetic */ d(long j, long j2, Set set, byte b2) {
        this(j, j2, set);
    }

    private d(long j, long j2, Set<g.c> set) {
        this.f7904a = j;
        this.f7905b = j2;
        this.f7906c = set;
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        return this.f7904a;
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.f7905b;
    }

    /* access modifiers changed from: package-private */
    public final Set<g.c> c() {
        return this.f7906c;
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f7904a + ", maxAllowedDelay=" + this.f7905b + ", flags=" + this.f7906c + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g.b) {
            g.b bVar = (g.b) obj;
            return this.f7904a == bVar.a() && this.f7905b == bVar.b() && this.f7906c.equals(bVar.c());
        }
    }

    public final int hashCode() {
        long j = this.f7904a;
        long j2 = this.f7905b;
        return this.f7906c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    static final class a extends g.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f7907a;

        /* renamed from: b  reason: collision with root package name */
        private Long f7908b;

        /* renamed from: c  reason: collision with root package name */
        private Set<g.c> f7909c;

        a() {
        }

        public final g.b.a a(long j) {
            this.f7907a = Long.valueOf(j);
            return this;
        }

        public final g.b.a a() {
            this.f7908b = 86400000L;
            return this;
        }

        public final g.b.a a(Set<g.c> set) {
            if (set != null) {
                this.f7909c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public final g.b b() {
            String str = "";
            if (this.f7907a == null) {
                str = str + " delta";
            }
            if (this.f7908b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f7909c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new d(this.f7907a.longValue(), this.f7908b.longValue(), this.f7909c, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
