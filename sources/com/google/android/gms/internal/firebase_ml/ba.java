package com.google.android.gms.internal.firebase_ml;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class ba {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<bd, List<Throwable>> f9760a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f9761b = new ReferenceQueue<>();

    ba() {
    }

    public final List<Throwable> a(Throwable th) {
        Reference<? extends Throwable> poll = this.f9761b.poll();
        while (poll != null) {
            this.f9760a.remove(poll);
            poll = this.f9761b.poll();
        }
        List<Throwable> list = this.f9760a.get(new bd(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f9760a.putIfAbsent(new bd(th, this.f9761b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
