package com.alipay.imobile.network.quake;

import android.os.Handler;
import android.os.Looper;
import com.alipay.iap.android.common.b.c;
import com.alipay.imobile.network.quake.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class n implements e.C0203e {

    /* renamed from: a  reason: collision with root package name */
    final PriorityBlockingQueue<e> f14936a;

    /* renamed from: b  reason: collision with root package name */
    final PriorityBlockingQueue<e> f14937b;

    /* renamed from: c  reason: collision with root package name */
    final BlockingQueue<j> f14938c;

    /* renamed from: d  reason: collision with root package name */
    final o f14939d;

    /* renamed from: e  reason: collision with root package name */
    l f14940e;

    /* renamed from: f  reason: collision with root package name */
    h f14941f;

    /* renamed from: g  reason: collision with root package name */
    i f14942g;

    /* renamed from: h  reason: collision with root package name */
    m f14943h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f14944i;
    private final Map<String, Queue<e>> j;
    private final Set<e> k;
    private final List<Object> l;

    public n(m mVar) {
        this(mVar, new k(new Handler(Looper.getMainLooper())));
    }

    private n(m mVar, o oVar) {
        this.f14944i = new AtomicInteger();
        this.j = new HashMap();
        this.k = new HashSet();
        this.f14936a = new PriorityBlockingQueue<>();
        this.f14937b = new PriorityBlockingQueue<>();
        this.f14938c = new PriorityBlockingQueue();
        this.l = new ArrayList();
        this.f14939d = oVar;
        this.f14943h = mVar;
    }

    public final e b(e eVar) {
        eVar.f14775g = this;
        synchronized (this.k) {
            this.k.add(eVar);
        }
        eVar.f14776h = Integer.valueOf(this.f14944i.incrementAndGet());
        eVar.a("add-to-queue");
        if (!eVar.f14777i) {
            this.f14937b.add(eVar);
            return eVar;
        }
        synchronized (this.j) {
            String b2 = eVar.b().b(eVar);
            if (this.j.containsKey(b2)) {
                Queue queue = this.j.get(b2);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(eVar);
                this.j.put(b2, queue);
                String str = c.f14737a;
                c.a("Request for cacheKey=%s is in flight, putting on hold.", b2);
                c.b();
            } else {
                this.j.put(b2, (Object) null);
                this.f14936a.add(eVar);
            }
        }
        return eVar;
    }

    public final void a(e eVar) {
        synchronized (this.k) {
            this.k.remove(eVar);
        }
        synchronized (this.l) {
            Iterator<Object> it2 = this.l.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        if (eVar.f14777i) {
            synchronized (this.j) {
                String b2 = this.f14943h.a(eVar.q).b(eVar);
                Queue remove = this.j.remove(b2);
                if (remove != null) {
                    String str = c.f14737a;
                    c.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), b2);
                    c.b();
                    this.f14936a.addAll(remove);
                }
            }
        }
    }
}
