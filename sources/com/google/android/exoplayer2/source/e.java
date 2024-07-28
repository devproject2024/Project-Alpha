package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import java.io.IOException;
import java.util.HashMap;

public abstract class e<T> extends b {

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<T, b> f33035b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Handler f33036c;

    /* renamed from: d  reason: collision with root package name */
    private ad f33037d;

    /* access modifiers changed from: protected */
    public o.a b(o.a aVar) {
        return aVar;
    }

    /* access modifiers changed from: protected */
    public abstract void b(ah ahVar, Object obj);

    protected e() {
    }

    public void a(ad adVar) {
        this.f33037d = adVar;
        this.f33036c = new Handler();
    }

    public final void b() throws IOException {
        for (b bVar : this.f33035b.values()) {
            bVar.f33041a.b();
        }
    }

    public final void a() {
        for (b next : this.f33035b.values()) {
            next.f33041a.a(next.f33042b);
            next.f33041a.a(next.f33043c);
        }
        this.f33035b.clear();
    }

    /* access modifiers changed from: protected */
    public final void a(o oVar) {
        com.google.android.exoplayer2.g.a.a(!this.f33035b.containsKey((Object) null));
        $$Lambda$e$hhtuiBnJoqQQsWOr0FdLcZt1bc r0 = new o.b((Object) null) {
            private final /* synthetic */ Object f$1;

            {
                this.f$1 = r2;
            }

            public final void onSourceInfoRefreshed(o oVar, ah ahVar, Object obj) {
                e.this.a(this.f$1, oVar, ahVar, obj);
            }
        };
        a aVar = new a(this);
        this.f33035b.put((Object) null, new b(oVar, r0, aVar));
        oVar.a((Handler) com.google.android.exoplayer2.g.a.a(this.f33036c), (p) aVar);
        oVar.a((o.b) r0, this.f33037d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Object obj, o oVar, ah ahVar, Object obj2) {
        b(ahVar, obj2);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final o f33041a;

        /* renamed from: b  reason: collision with root package name */
        public final o.b f33042b;

        /* renamed from: c  reason: collision with root package name */
        public final p f33043c;

        public b(o oVar, o.b bVar, p pVar) {
            this.f33041a = oVar;
            this.f33042b = bVar;
            this.f33043c = pVar;
        }
    }

    final class a implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f33038a;

        /* renamed from: b  reason: collision with root package name */
        private final T f33039b = null;

        /* renamed from: c  reason: collision with root package name */
        private p.a f33040c;

        public a(T t) {
            this.f33038a = t;
            this.f33040c = t.a((o.a) null);
        }

        public final void a(int i2, o.a aVar) {
            if (d(i2, aVar)) {
                this.f33040c.a();
            }
        }

        public final void b(int i2, o.a aVar) {
            if (d(i2, aVar)) {
                this.f33040c.b();
            }
        }

        public final void a(int i2, o.a aVar, p.b bVar, p.c cVar) {
            if (d(i2, aVar)) {
                this.f33040c.a(bVar, a(cVar));
            }
        }

        public final void b(int i2, o.a aVar, p.b bVar, p.c cVar) {
            if (d(i2, aVar)) {
                this.f33040c.b(bVar, a(cVar));
            }
        }

        public final void c(int i2, o.a aVar, p.b bVar, p.c cVar) {
            if (d(i2, aVar)) {
                this.f33040c.c(bVar, a(cVar));
            }
        }

        public final void a(int i2, o.a aVar, p.b bVar, p.c cVar, IOException iOException, boolean z) {
            if (d(i2, aVar)) {
                this.f33040c.a(bVar, a(cVar), iOException, z);
            }
        }

        public final void c(int i2, o.a aVar) {
            if (d(i2, aVar)) {
                this.f33040c.c();
            }
        }

        public final void a(int i2, o.a aVar, p.c cVar) {
            if (d(i2, aVar)) {
                this.f33040c.a(a(cVar));
            }
        }

        public final void b(int i2, o.a aVar, p.c cVar) {
            if (d(i2, aVar)) {
                this.f33040c.b(a(cVar));
            }
        }

        private boolean d(int i2, o.a aVar) {
            o.a aVar2;
            if (aVar != null) {
                aVar2 = this.f33038a.b(aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            if (this.f33040c.f33229a == i2 && ae.a((Object) this.f33040c.f33230b, (Object) aVar2)) {
                return true;
            }
            this.f33040c = this.f33038a.a(i2, aVar2);
            return true;
        }

        private static p.c a(p.c cVar) {
            long j = cVar.f33246f;
            long j2 = cVar.f33247g;
            if (j == cVar.f33246f && j2 == cVar.f33247g) {
                return cVar;
            }
            return new p.c(cVar.f33241a, cVar.f33242b, cVar.f33243c, cVar.f33244d, cVar.f33245e, j, j2);
        }
    }
}
