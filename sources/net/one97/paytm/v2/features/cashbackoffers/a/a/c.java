package net.one97.paytm.v2.features.cashbackoffers.a.a;

import dagger.a.b;
import dagger.a.g;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.v2.features.cashbackoffers.a.b.k;
import net.one97.paytm.v2.features.cashbackoffers.a.b.s;
import net.one97.paytm.v2.features.cashbackoffers.a.b.t;
import net.one97.paytm.v2.features.cashbackoffers.a.b.u;
import net.one97.paytm.v2.features.cashbackoffers.a.b.v;
import net.one97.paytm.v2.features.cashbackoffers.a.b.w;
import net.one97.paytm.v2.features.cashbackoffers.a.b.x;
import net.one97.paytm.vipcashback.c.d;
import net.one97.paytm.vipcashback.f.f;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final j f20314a;

    /* renamed from: b  reason: collision with root package name */
    private final s f20315b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<d> f20316c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<f> f20317d;

    /* synthetic */ c(v vVar, s sVar, j jVar, byte b2) {
        this(vVar, sVar, jVar);
    }

    private c(v vVar, s sVar, j jVar) {
        this.f20314a = jVar;
        this.f20315b = sVar;
        this.f20316c = b.a(new x(vVar));
        this.f20317d = b.a(new w(vVar));
    }

    public static a a() {
        return new a((byte) 0);
    }

    public final d b() {
        return this.f20316c.get();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private v f20318a;

        /* renamed from: b  reason: collision with root package name */
        private s f20319b;

        /* renamed from: c  reason: collision with root package name */
        private j f20320c;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
        }

        public final a a(v vVar) {
            this.f20318a = (v) g.a(vVar);
            return this;
        }

        public final a a(j jVar) {
            this.f20320c = (j) g.a(jVar);
            return this;
        }

        public final d a() {
            g.a(this.f20318a, v.class);
            if (this.f20319b == null) {
                this.f20319b = new s();
            }
            g.a(this.f20320c, j.class);
            return new c(this.f20318a, this.f20319b, this.f20320c, (byte) 0);
        }
    }

    public final void a(d dVar) {
        dVar.f20727a = t.a(u.a(k.b(this.f20314a)));
        dVar.f20728b = this.f20317d.get();
    }
}
