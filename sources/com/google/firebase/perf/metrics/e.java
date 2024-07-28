package com.google.firebase.perf.metrics;

import com.google.android.gms.internal.p001firebaseperf.bq;
import com.google.android.gms.internal.p001firebaseperf.by;
import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.firebase.perf.internal.zzs;
import java.util.Arrays;
import java.util.List;

final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Trace f39277a;

    e(Trace trace) {
        this.f39277a = trace;
    }

    /* access modifiers changed from: package-private */
    public final by a() {
        by.a b2 = by.b().a(this.f39277a.f39268a).a(this.f39277a.f39272e.f9736a).b(this.f39277a.f39272e.a(this.f39277a.f39273f));
        for (zza next : this.f39277a.f39271d.values()) {
            b2.a(next.f39278a, next.f39279b.get());
        }
        List<Trace> list = this.f39277a.f39270c;
        if (!list.isEmpty()) {
            for (Trace eVar : list) {
                b2.a(new e(eVar).a());
            }
        }
        b2.b(this.f39277a.getAttributes());
        bq[] a2 = zzs.a(this.f39277a.f39269b);
        if (a2 != null) {
            b2.b((Iterable<? extends bq>) Arrays.asList(a2));
        }
        return (by) ((dq) b2.k());
    }
}
