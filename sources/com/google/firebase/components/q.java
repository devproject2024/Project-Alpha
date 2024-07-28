package com.google.firebase.components;

import com.google.firebase.a.a;
import com.google.firebase.a.b;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class q implements c, d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> f38118a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<a<?>> f38119b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f38120c;

    q(Executor executor) {
        this.f38120c = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(com.google.firebase.components.s.a(r1, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = b(r4).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.firebase.a.a<?> r4) {
        /*
            r3 = this;
            com.google.firebase.components.v.a(r4)
            monitor-enter(r3)
            java.util.Queue<com.google.firebase.a.a<?>> r0 = r3.f38119b     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x000f
            java.util.Queue<com.google.firebase.a.a<?>> r0 = r3.f38119b     // Catch:{ all -> 0x0033 }
            r0.add(r4)     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            java.util.Set r0 = r3.b(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            java.lang.Runnable r1 = com.google.firebase.components.s.a(r1, r4)
            r2.execute(r1)
            goto L_0x0018
        L_0x0032:
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.q.a(com.google.firebase.a.a):void");
    }

    private synchronized Set<Map.Entry<b<Object>, Executor>> b(a<?> aVar) {
        Map map = this.f38118a.get(aVar.f37937a);
        if (map == null) {
            return Collections.emptySet();
        }
        return map.entrySet();
    }

    public final synchronized <T> void a(Class<T> cls, Executor executor, b<? super T> bVar) {
        v.a(cls);
        v.a(bVar);
        v.a(executor);
        if (!this.f38118a.containsKey(cls)) {
            this.f38118a.put(cls, new ConcurrentHashMap());
        }
        this.f38118a.get(cls).put(bVar, executor);
    }

    public final <T> void a(Class<T> cls, b<? super T> bVar) {
        a(cls, this.f38120c, bVar);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Queue<a<?>> queue;
        synchronized (this) {
            if (this.f38119b != null) {
                queue = this.f38119b;
                this.f38119b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (a a2 : queue) {
                a(a2);
            }
        }
    }
}
