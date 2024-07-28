package com.google.android.gms.internal.p001firebaseperf;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.l  reason: invalid package */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<k, List<Throwable>> f9706a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f9707b = new ReferenceQueue<>();

    l() {
    }

    public final List<Throwable> a(Throwable th) {
        Reference<? extends Throwable> poll = this.f9707b.poll();
        while (poll != null) {
            this.f9706a.remove(poll);
            poll = this.f9707b.poll();
        }
        List<Throwable> list = this.f9706a.get(new k(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f9706a.putIfAbsent(new k(th, this.f9707b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
