package com.bumptech.glide.load.b.b;

import com.bumptech.glide.g.j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, a> f6774a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final b f6775b = new b();

    c() {
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) j.a(this.f6774a.get(str), "Argument must not be null");
            if (aVar.f6777b > 0) {
                aVar.f6777b--;
                if (aVar.f6777b == 0) {
                    a remove = this.f6774a.remove(str);
                    if (remove.equals(aVar)) {
                        b bVar = this.f6775b;
                        synchronized (bVar.f6778a) {
                            if (bVar.f6778a.size() < 10) {
                                bVar.f6778a.offer(remove);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f6777b);
            }
        }
        aVar.f6776a.unlock();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f6776a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f6777b;

        a() {
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final Queue<a> f6778a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public final a a() {
            a poll;
            synchronized (this.f6778a) {
                poll = this.f6778a.poll();
            }
            return poll == null ? new a() : poll;
        }
    }
}
