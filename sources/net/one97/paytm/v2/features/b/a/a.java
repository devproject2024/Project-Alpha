package net.one97.paytm.v2.features.b.a;

import android.content.Context;
import dagger.a.b;
import dagger.a.g;
import net.one97.paytm.v2.a.c;
import net.one97.paytm.v2.a.d;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.v2.features.cashbackoffers.a.b.k;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.features.b.c.a> f20061a;

    /* renamed from: b  reason: collision with root package name */
    private javax.a.a<Context> f20062b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<c> f20063c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<d> f20064d;

    /* synthetic */ a(net.one97.paytm.v2.features.b.a.a.a aVar, j jVar, byte b2) {
        this(aVar, jVar);
    }

    private a(net.one97.paytm.v2.features.b.a.a.a aVar, j jVar) {
        this.f20061a = b.a(new net.one97.paytm.v2.features.b.a.a.d(aVar));
        this.f20062b = k.a(jVar);
        this.f20063c = b.a(new net.one97.paytm.v2.features.b.a.a.b(aVar, this.f20062b));
        this.f20064d = b.a(new net.one97.paytm.v2.features.b.a.a.c(aVar, this.f20063c));
    }

    public static C0356a a() {
        return new C0356a((byte) 0);
    }

    public final net.one97.paytm.v2.features.b.c.a b() {
        return this.f20061a.get();
    }

    /* renamed from: net.one97.paytm.v2.features.b.a.a$a  reason: collision with other inner class name */
    public static final class C0356a {

        /* renamed from: a  reason: collision with root package name */
        private net.one97.paytm.v2.features.b.a.a.a f20065a;

        /* renamed from: b  reason: collision with root package name */
        private j f20066b;

        /* synthetic */ C0356a(byte b2) {
            this();
        }

        private C0356a() {
        }

        public final C0356a a(net.one97.paytm.v2.features.b.a.a.a aVar) {
            this.f20065a = (net.one97.paytm.v2.features.b.a.a.a) g.a(aVar);
            return this;
        }

        public final C0356a a(j jVar) {
            this.f20066b = (j) g.a(jVar);
            return this;
        }

        public final b a() {
            g.a(this.f20065a, net.one97.paytm.v2.features.b.a.a.a.class);
            g.a(this.f20066b, j.class);
            return new a(this.f20065a, this.f20066b, (byte) 0);
        }
    }

    public final void a(net.one97.paytm.v2.features.b.c.a aVar) {
        aVar.f20102a = this.f20064d.get();
    }
}
