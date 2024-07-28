package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import dagger.a.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.a.a;

public final class f implements c<g> {

    /* renamed from: a  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7891a;

    public f(a<com.google.android.datatransport.runtime.d.a> aVar) {
        this.f7891a = aVar;
    }

    public final /* synthetic */ Object get() {
        g.a a2 = new g.a().a(d.DEFAULT, g.b.d().a(30000).a().b()).a(d.HIGHEST, g.b.d().a(1000).a().b()).a(d.VERY_LOW, g.b.d().a(86400000).a().a((Set<g.c>) Collections.unmodifiableSet(new HashSet(Arrays.asList(new g.c[]{g.c.NETWORK_UNMETERED, g.c.DEVICE_IDLE})))).b());
        a2.f7915a = this.f7891a.get();
        if (a2.f7915a == null) {
            throw new NullPointerException("missing required property: clock");
        } else if (a2.f7916b.keySet().size() >= d.values().length) {
            Map<d, g.b> map = a2.f7916b;
            a2.f7916b = new HashMap();
            return (g) dagger.a.g.a(new com.google.android.datatransport.runtime.scheduling.jobscheduling.c(a2.f7915a, map), "Cannot return null from a non-@Nullable @Provides method");
        } else {
            throw new IllegalStateException("Not all priorities have been configured");
        }
    }
}
