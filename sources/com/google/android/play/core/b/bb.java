package com.google.android.play.core.b;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class bb {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<ba, List<Throwable>> f37280a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f37281b = new ReferenceQueue<>();

    bb() {
    }

    public final List<Throwable> a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f37281b.poll();
            if (poll == null) {
                break;
            }
            this.f37280a.remove(poll);
        }
        List<Throwable> list = this.f37280a.get(new ba(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f37280a.putIfAbsent(new ba(th, this.f37281b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
