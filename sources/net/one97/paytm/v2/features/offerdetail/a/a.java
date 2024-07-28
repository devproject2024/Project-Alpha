package net.one97.paytm.v2.features.offerdetail.a;

import android.content.Context;
import dagger.a.g;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.v2.features.cashbackoffers.a.b.k;
import net.one97.paytm.v2.features.offerdetail.a.a.c;
import net.one97.paytm.v2.features.offerdetail.a.a.d;
import net.one97.paytm.v2.features.offerdetail.b.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.features.offerdetail.c.a> f20432a;

    /* renamed from: b  reason: collision with root package name */
    private javax.a.a<Context> f20433b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.v2.features.offerdetail.b.a> f20434c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<b> f20435d;

    /* synthetic */ a(net.one97.paytm.v2.features.offerdetail.a.a.a aVar, j jVar, byte b2) {
        this(aVar, jVar);
    }

    private a(net.one97.paytm.v2.features.offerdetail.a.a.a aVar, j jVar) {
        this.f20432a = dagger.a.b.a(new net.one97.paytm.v2.features.offerdetail.a.a.b(aVar));
        this.f20433b = k.a(jVar);
        this.f20434c = dagger.a.b.a(new d(aVar, this.f20433b));
        this.f20435d = dagger.a.b.a(new c(aVar, this.f20434c));
    }

    public static C0369a a() {
        return new C0369a((byte) 0);
    }

    public final net.one97.paytm.v2.features.offerdetail.c.a b() {
        return this.f20432a.get();
    }

    /* renamed from: net.one97.paytm.v2.features.offerdetail.a.a$a  reason: collision with other inner class name */
    public static final class C0369a {

        /* renamed from: a  reason: collision with root package name */
        private net.one97.paytm.v2.features.offerdetail.a.a.a f20436a;

        /* renamed from: b  reason: collision with root package name */
        private j f20437b;

        /* synthetic */ C0369a(byte b2) {
            this();
        }

        private C0369a() {
        }

        public final C0369a a(net.one97.paytm.v2.features.offerdetail.a.a.a aVar) {
            this.f20436a = (net.one97.paytm.v2.features.offerdetail.a.a.a) g.a(aVar);
            return this;
        }

        public final C0369a a(j jVar) {
            this.f20437b = (j) g.a(jVar);
            return this;
        }

        public final b a() {
            g.a(this.f20436a, net.one97.paytm.v2.features.offerdetail.a.a.a.class);
            g.a(this.f20437b, j.class);
            return new a(this.f20436a, this.f20437b, (byte) 0);
        }
    }

    public final void a(net.one97.paytm.v2.features.offerdetail.c.a aVar) {
        aVar.f20450a = this.f20435d.get();
    }
}
