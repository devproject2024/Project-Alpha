package net.one97.paytm.v2.features.cashbacklanding.a.a;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import net.one97.paytm.v2.a.c;
import net.one97.paytm.v2.features.cashbacklanding.a.b.e;
import net.one97.paytm.v2.features.cashbacklanding.a.b.g;
import net.one97.paytm.v2.features.cashbacklanding.a.b.h;
import net.one97.paytm.v2.features.cashbacklanding.a.b.i;
import net.one97.paytm.v2.features.cashbacklanding.a.b.k;
import net.one97.paytm.v2.features.cashbacklanding.a.b.l;
import net.one97.paytm.v2.features.cashbacklanding.a.b.m;
import net.one97.paytm.v2.features.cashbacklanding.c.f;
import net.one97.paytm.v2.features.cashbacklanding.d.d;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f20112a;

    /* renamed from: b  reason: collision with root package name */
    private javax.a.a<AppCompatActivity> f20113b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.features.cashbacklanding.d.a> f20114c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<d> f20115d;

    /* renamed from: e  reason: collision with root package name */
    private javax.a.a<f> f20116e;

    /* renamed from: f  reason: collision with root package name */
    private javax.a.a<Context> f20117f;

    /* renamed from: g  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.features.cashbackoffers.b.f> f20118g;

    /* renamed from: h  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.a.f> f20119h;

    /* renamed from: i  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.a.b> f20120i;
    private javax.a.a<net.one97.paytm.v2.features.b.c.a> j;
    private javax.a.a<c> k;
    private javax.a.a<net.one97.paytm.v2.a.d> l;

    /* synthetic */ b(e eVar, net.one97.paytm.v2.features.cashbackoffers.a.b.a aVar, net.one97.paytm.v2.features.cashbacklanding.a.b.a aVar2, j jVar, l lVar, byte b2) {
        this(eVar, aVar, aVar2, jVar, lVar);
    }

    private b(e eVar, net.one97.paytm.v2.features.cashbackoffers.a.b.a aVar, net.one97.paytm.v2.features.cashbacklanding.a.b.a aVar2, j jVar, l lVar) {
        this.f20112a = eVar;
        this.f20113b = net.one97.paytm.v2.features.cashbackoffers.a.b.b.a(aVar);
        this.f20114c = dagger.a.b.a(new k(eVar, this.f20113b));
        this.f20115d = dagger.a.b.a(new i(eVar, this.f20113b));
        this.f20116e = dagger.a.b.a(new m(lVar));
        this.f20117f = net.one97.paytm.v2.features.cashbackoffers.a.b.k.a(jVar);
        this.f20118g = dagger.a.b.a(new net.one97.paytm.v2.features.cashbacklanding.a.b.d(aVar2, this.f20117f));
        this.f20119h = dagger.a.b.a(new net.one97.paytm.v2.features.cashbacklanding.a.b.b(aVar2, this.f20117f));
        this.f20120i = dagger.a.b.a(new net.one97.paytm.v2.features.cashbacklanding.a.b.c(aVar2, this.f20119h));
        this.j = dagger.a.b.a(new net.one97.paytm.v2.features.cashbacklanding.a.b.j(eVar, this.f20113b));
        this.k = dagger.a.b.a(new g(eVar, this.f20117f));
        this.l = dagger.a.b.a(new h(eVar, this.k));
    }

    public static a c() {
        return new a((byte) 0);
    }

    public final f a() {
        return this.f20116e.get();
    }

    public final net.one97.paytm.v2.features.b.c.a b() {
        return this.j.get();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private e f20121a;

        /* renamed from: b  reason: collision with root package name */
        private net.one97.paytm.v2.features.cashbackoffers.a.b.a f20122b;

        /* renamed from: c  reason: collision with root package name */
        private net.one97.paytm.v2.features.cashbacklanding.a.b.a f20123c;

        /* renamed from: d  reason: collision with root package name */
        private j f20124d;

        /* renamed from: e  reason: collision with root package name */
        private l f20125e;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
        }

        public final a a(e eVar) {
            this.f20121a = (e) dagger.a.g.a(eVar);
            return this;
        }

        public final a a(net.one97.paytm.v2.features.cashbackoffers.a.b.a aVar) {
            this.f20122b = (net.one97.paytm.v2.features.cashbackoffers.a.b.a) dagger.a.g.a(aVar);
            return this;
        }

        public final a a(net.one97.paytm.v2.features.cashbacklanding.a.b.a aVar) {
            this.f20123c = (net.one97.paytm.v2.features.cashbacklanding.a.b.a) dagger.a.g.a(aVar);
            return this;
        }

        public final a a(j jVar) {
            this.f20124d = (j) dagger.a.g.a(jVar);
            return this;
        }

        public final a a(l lVar) {
            this.f20125e = (l) dagger.a.g.a(lVar);
            return this;
        }

        public final a a() {
            if (this.f20121a == null) {
                this.f20121a = new e();
            }
            dagger.a.g.a(this.f20122b, net.one97.paytm.v2.features.cashbackoffers.a.b.a.class);
            dagger.a.g.a(this.f20123c, net.one97.paytm.v2.features.cashbacklanding.a.b.a.class);
            dagger.a.g.a(this.f20124d, j.class);
            dagger.a.g.a(this.f20125e, l.class);
            return new b(this.f20121a, this.f20122b, this.f20123c, this.f20124d, this.f20125e, (byte) 0);
        }
    }

    public final void a(net.one97.paytm.v2.features.cashbacklanding.d.a aVar) {
        aVar.f20243e = this.f20118g.get();
    }

    public final void a(d dVar) {
        dVar.f20271e = this.f20120i.get();
    }

    public final void a(f fVar) {
        fVar.f20207i = this.f20114c.get();
        fVar.j = this.f20115d.get();
        fVar.k = net.one97.paytm.v2.features.cashbacklanding.a.b.f.a();
        fVar.l = net.one97.paytm.v2.features.cashbacklanding.a.b.f.a();
    }

    public final void a(net.one97.paytm.v2.features.b.c.a aVar) {
        aVar.f20102a = this.l.get();
    }
}
