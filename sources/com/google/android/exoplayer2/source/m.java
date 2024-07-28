package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.w;
import java.util.HashMap;
import java.util.Map;

public final class m extends e<Void> {

    /* renamed from: b  reason: collision with root package name */
    private final o f33216b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33217c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<o.a, o.a> f33218d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<n, o.a> f33219e;

    public m(o oVar) {
        this(oVar, (byte) 0);
    }

    private m(o oVar, byte b2) {
        com.google.android.exoplayer2.g.a.a(true);
        this.f33216b = oVar;
        this.f33217c = Integer.MAX_VALUE;
        this.f33218d = new HashMap();
        this.f33219e = new HashMap();
    }

    public final void a(ad adVar) {
        super.a(adVar);
        a(this.f33216b);
    }

    public final n a(o.a aVar, com.google.android.exoplayer2.f.b bVar, long j) {
        if (this.f33217c == Integer.MAX_VALUE) {
            return this.f33216b.a(aVar, bVar, j);
        }
        Object b2 = b.b(aVar.f33224a);
        o.a aVar2 = aVar.f33224a.equals(b2) ? aVar : new o.a(b2, aVar.f33225b, aVar.f33226c, aVar.f33227d, aVar.f33228e);
        this.f33218d.put(aVar2, aVar);
        n a2 = this.f33216b.a(aVar2, bVar, j);
        this.f33219e.put(a2, aVar2);
        return a2;
    }

    public final void a(n nVar) {
        this.f33216b.a(nVar);
        o.a remove = this.f33219e.remove(nVar);
        if (remove != null) {
            this.f33218d.remove(remove);
        }
    }

    static final class b extends a {

        /* renamed from: b  reason: collision with root package name */
        private final ah f33220b;

        /* renamed from: c  reason: collision with root package name */
        private final int f33221c;

        /* renamed from: d  reason: collision with root package name */
        private final int f33222d;

        /* renamed from: e  reason: collision with root package name */
        private final int f33223e;

        public b(ah ahVar, int i2) {
            super(new w.a(i2));
            this.f33220b = ahVar;
            this.f33221c = ahVar.c();
            this.f33222d = ahVar.b();
            this.f33223e = i2;
            int i3 = this.f33221c;
            if (i3 > 0) {
                com.google.android.exoplayer2.g.a.b(i2 <= Integer.MAX_VALUE / i3, "LoopingMediaSource contains too many periods");
            }
        }

        public final int b() {
            return this.f33222d * this.f33223e;
        }

        public final int c() {
            return this.f33221c * this.f33223e;
        }

        /* access modifiers changed from: protected */
        public final int b(int i2) {
            return i2 / this.f33221c;
        }

        /* access modifiers changed from: protected */
        public final int c(int i2) {
            return i2 / this.f33222d;
        }

        /* access modifiers changed from: protected */
        public final int c(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        /* access modifiers changed from: protected */
        public final ah d() {
            return this.f33220b;
        }

        /* access modifiers changed from: protected */
        public final int d(int i2) {
            return i2 * this.f33221c;
        }

        /* access modifiers changed from: protected */
        public final int e(int i2) {
            return i2 * this.f33222d;
        }

        /* access modifiers changed from: protected */
        public final Object f(int i2) {
            return Integer.valueOf(i2);
        }
    }

    static final class a extends k {
        public a(ah ahVar) {
            super(ahVar);
        }

        public final int a(int i2, int i3, boolean z) {
            int a2 = this.f33210b.a(i2, i3, z);
            return a2 == -1 ? b(z) : a2;
        }

        public final int b(int i2, int i3, boolean z) {
            int b2 = this.f33210b.b(i2, i3, z);
            return b2 == -1 ? a(z) : b2;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ o.a b(o.a aVar) {
        return this.f33217c != Integer.MAX_VALUE ? this.f33218d.get(aVar) : aVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void b(ah ahVar, Object obj) {
        int i2 = this.f33217c;
        a(i2 != Integer.MAX_VALUE ? new b(ahVar, i2) : new a(ahVar), obj);
    }
}
