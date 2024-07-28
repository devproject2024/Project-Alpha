package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.d;
import com.google.android.datatransport.runtime.d.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import java.util.Map;

public final class c extends g {

    /* renamed from: a  reason: collision with root package name */
    private final a f7902a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<d, g.b> f7903b;

    public c(a aVar, Map<d, g.b> map) {
        if (aVar != null) {
            this.f7902a = aVar;
            if (map != null) {
                this.f7903b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public final a a() {
        return this.f7902a;
    }

    /* access modifiers changed from: package-private */
    public final Map<d, g.b> b() {
        return this.f7903b;
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f7902a + ", values=" + this.f7903b + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f7902a.equals(gVar.a()) && this.f7903b.equals(gVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f7902a.hashCode() ^ 1000003) * 1000003) ^ this.f7903b.hashCode();
    }
}
