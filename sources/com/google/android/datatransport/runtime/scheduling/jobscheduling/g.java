package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class g {

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.runtime.d.a a();

    /* access modifiers changed from: package-private */
    public abstract Map<d, b> b();

    public static abstract class b {

        public static abstract class a {
            public abstract a a();

            public abstract a a(long j);

            public abstract a a(Set<c> set);

            public abstract b b();
        }

        /* access modifiers changed from: package-private */
        public abstract long a();

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set<c> c();

        public static a d() {
            return new d.a().a((Set<c>) Collections.emptySet());
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public com.google.android.datatransport.runtime.d.a f7915a;

        /* renamed from: b  reason: collision with root package name */
        public Map<com.google.android.datatransport.d, b> f7916b = new HashMap();

        public final a a(com.google.android.datatransport.d dVar, b bVar) {
            this.f7916b.put(dVar, bVar);
            return this;
        }
    }

    public final long a(com.google.android.datatransport.d dVar, long j, int i2) {
        long a2 = j - a().a();
        b bVar = b().get(dVar);
        return Math.min(Math.max(((long) Math.pow(2.0d, (double) (i2 - 1))) * bVar.a(), a2), bVar.b());
    }
}
