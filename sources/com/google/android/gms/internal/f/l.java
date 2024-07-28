package com.google.android.gms.internal.f;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<o, List<Throwable>> f9480a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f9481b = new ReferenceQueue<>();

    l() {
    }

    public final List<Throwable> a(Throwable th) {
        Reference<? extends Throwable> poll = this.f9481b.poll();
        while (poll != null) {
            this.f9480a.remove(poll);
            poll = this.f9481b.poll();
        }
        List<Throwable> list = this.f9480a.get(new o(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f9480a.putIfAbsent(new o(th, this.f9481b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
