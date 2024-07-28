package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.f;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.e.j;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class d implements f {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<j> f31435a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<a> f31436b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private final PriorityQueue<a> f31437c;

    /* renamed from: d  reason: collision with root package name */
    private a f31438d;

    /* renamed from: e  reason: collision with root package name */
    private long f31439e;

    /* renamed from: f  reason: collision with root package name */
    private long f31440f;

    /* access modifiers changed from: protected */
    public abstract void a(i iVar);

    public void d() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean e();

    /* access modifiers changed from: protected */
    public abstract e f();

    public d() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f31436b.add(new a((byte) 0));
        }
        this.f31435a = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.f31435a.add(new b(this, (byte) 0));
        }
        this.f31437c = new PriorityQueue<>();
    }

    public void a(long j) {
        this.f31439e = j;
    }

    /* renamed from: h */
    public i a() throws g {
        com.google.android.exoplayer2.g.a.b(this.f31438d == null);
        if (this.f31436b.isEmpty()) {
            return null;
        }
        this.f31438d = this.f31436b.pollFirst();
        return this.f31438d;
    }

    /* renamed from: b */
    public void a(i iVar) throws g {
        com.google.android.exoplayer2.g.a.a(iVar == this.f31438d);
        if (iVar.j_()) {
            a(this.f31438d);
        } else {
            a aVar = this.f31438d;
            long j = this.f31440f;
            this.f31440f = 1 + j;
            long unused = aVar.f31441f = j;
            this.f31437c.add(this.f31438d);
        }
        this.f31438d = null;
    }

    /* renamed from: g */
    public j b() throws g {
        if (this.f31435a.isEmpty()) {
            return null;
        }
        while (!this.f31437c.isEmpty() && this.f31437c.peek().f31312d <= this.f31439e) {
            a poll = this.f31437c.poll();
            if (poll.c()) {
                j pollFirst = this.f31435a.pollFirst();
                pollFirst.a(4);
                a(poll);
                return pollFirst;
            }
            a((i) poll);
            if (e()) {
                e f2 = f();
                if (!poll.j_()) {
                    j pollFirst2 = this.f31435a.pollFirst();
                    pollFirst2.a(poll.f31312d, f2, Long.MAX_VALUE);
                    a(poll);
                    return pollFirst2;
                }
            }
            a(poll);
        }
        return null;
    }

    private void a(a aVar) {
        aVar.a();
        this.f31436b.add(aVar);
    }

    public void c() {
        this.f31440f = 0;
        this.f31439e = 0;
        while (!this.f31437c.isEmpty()) {
            a(this.f31437c.poll());
        }
        a aVar = this.f31438d;
        if (aVar != null) {
            a(aVar);
            this.f31438d = null;
        }
    }

    static final class a extends i implements Comparable<a> {
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f31441f;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (c() != aVar.c()) {
                return c() ? 1 : -1;
            }
            long j = this.f31312d - aVar.f31312d;
            if (j == 0) {
                j = this.f31441f - aVar.f31441f;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    final class b extends j {
        private b() {
        }

        /* synthetic */ b(d dVar, byte b2) {
            this();
        }

        public final void e() {
            d dVar = d.this;
            a();
            dVar.f31435a.add(this);
        }
    }
}
