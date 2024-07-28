package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class cb {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<ca, List<Throwable>> f10519a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f10520b = new ReferenceQueue<>();

    cb() {
    }

    public final List<Throwable> a(Throwable th) {
        Reference<? extends Throwable> poll = this.f10520b.poll();
        while (poll != null) {
            this.f10519a.remove(poll);
            poll = this.f10520b.poll();
        }
        List<Throwable> list = this.f10519a.get(new ca(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f10519a.putIfAbsent(new ca(th, this.f10520b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
