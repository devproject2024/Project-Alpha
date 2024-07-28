package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class bm {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<bp, List<Throwable>> f10999a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f11000b = new ReferenceQueue<>();

    bm() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f11000b.poll();
        while (poll != null) {
            this.f10999a.remove(poll);
            poll = this.f11000b.poll();
        }
        List<Throwable> list = this.f10999a.get(new bp(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f10999a.putIfAbsent(new bp(th, this.f11000b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
