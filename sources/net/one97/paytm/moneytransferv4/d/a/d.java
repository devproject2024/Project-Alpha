package net.one97.paytm.moneytransferv4.d.a;

import android.content.Context;
import androidx.lifecycle.ai;
import java.util.Map;
import net.one97.paytm.m.f;
import net.one97.paytm.m.h;
import net.one97.paytm.moneytransferv4.a.a.c;
import net.one97.paytm.moneytransferv4.a.b.b;
import net.one97.paytm.moneytransferv4.a.b.g;
import net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity;
import net.one97.paytm.moneytransferv4.accounts.i;
import net.one97.paytm.moneytransferv4.accounts.j;
import net.one97.paytm.moneytransferv4.accounts.k;
import net.one97.paytm.moneytransferv4.b.a.a.a.d.e;

public final class d implements a {
    private javax.a.a<f> A;
    private javax.a.a<Map<Class<? extends ai>, javax.a.a<ai>>> B;
    private javax.a.a<q> C;

    /* renamed from: a  reason: collision with root package name */
    private javax.a.a<Context> f55371a;

    /* renamed from: b  reason: collision with root package name */
    private javax.a.a<b> f55372b;

    /* renamed from: c  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.a.b.a> f55373c;

    /* renamed from: d  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.a.b.d> f55374d;

    /* renamed from: e  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.a.b.a> f55375e;

    /* renamed from: f  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.a.b.f> f55376f;

    /* renamed from: g  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.c.a.b> f55377g;

    /* renamed from: h  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.c.a.a> f55378h;

    /* renamed from: i  reason: collision with root package name */
    private javax.a.a<net.one97.paytm.moneytransferv4.c.a.d> f55379i;
    private javax.a.a<net.one97.paytm.moneytransferv4.c.a.a> j;
    private javax.a.a<net.one97.paytm.upi.registration.b.a.a.a> k;
    private javax.a.a<net.one97.paytm.upi.registration.b.a.b.a> l;
    private javax.a.a<net.one97.paytm.upi.h.a> m;
    private javax.a.a<net.one97.paytm.upi.registration.b.a.b> n;
    private javax.a.a<net.one97.paytm.upi.registration.b.a.a> o;
    private javax.a.a<net.one97.paytm.upi.profile.b.b.a> p;
    private javax.a.a<net.one97.paytm.upi.profile.b.a.a> q;
    private javax.a.a<net.one97.paytm.upi.profile.b.a> r;
    private javax.a.a<net.one97.paytm.upi.passbook.b.a.b.a> s;
    private javax.a.a<net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d> t;
    private javax.a.a<i> u;
    private javax.a.a<net.one97.paytm.upi.passbook.b.a.a.a> v;
    private javax.a.a<net.one97.paytm.upi.passbook.b.a.a> w;
    private javax.a.a<c> x;
    private javax.a.a<net.one97.paytm.moneytransferv4.accountsbottomsheet.c> y;
    private javax.a.a<e> z;

    /* synthetic */ d(b bVar, e eVar, byte b2) {
        this(bVar, eVar);
    }

    private d(b bVar, e eVar) {
        this.f55371a = dagger.a.b.a(new c(bVar));
        this.f55372b = new net.one97.paytm.moneytransferv4.a.b.c(this.f55371a);
        this.f55373c = dagger.a.b.a(this.f55372b);
        this.f55374d = new net.one97.paytm.moneytransferv4.a.b.e(this.f55371a);
        this.f55375e = dagger.a.b.a(this.f55374d);
        this.f55376f = dagger.a.b.a(new g(this.f55373c, this.f55375e));
        this.f55377g = new net.one97.paytm.moneytransferv4.c.a.c(this.f55371a);
        this.f55378h = dagger.a.b.a(this.f55377g);
        this.f55379i = new net.one97.paytm.moneytransferv4.c.a.e(this.f55378h);
        this.j = dagger.a.b.a(this.f55379i);
        this.k = new n(this.f55371a);
        this.l = new o(this.f55371a);
        this.m = dagger.a.b.a(new f(eVar, this.f55371a));
        this.n = new p(this.k, this.l, this.m);
        this.o = dagger.a.b.a(this.n);
        this.p = new l(this.f55371a);
        this.q = new k(this.f55371a);
        this.r = new m(this.p, this.q, this.n);
        this.s = new j(this.f55371a);
        this.t = new net.one97.paytm.moneytransferv4.home.presentation.viewmodel.e(this.f55376f, this.j, this.o, this.r, this.s, this.f55371a);
        this.u = new j(this.r, this.o);
        this.v = new i(this.f55371a);
        this.w = new h(this.s, this.v);
        this.x = new net.one97.paytm.moneytransferv4.a.a.d(this.w);
        this.y = new net.one97.paytm.moneytransferv4.accountsbottomsheet.d(this.r, this.o);
        this.z = new net.one97.paytm.moneytransferv4.b.a.a.a.d.f(this.w);
        this.A = new h(this.r, this.o, this.f55376f, this.w);
        this.B = dagger.a.e.a(6).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.d.class, this.t).a(i.class, this.u).a(c.class, this.x).a(net.one97.paytm.moneytransferv4.accountsbottomsheet.c.class, this.y).a(e.class, this.z).a(f.class, this.A).a();
        this.C = dagger.a.b.a(new r(this.B));
    }

    public static a a() {
        return new a((byte) 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private b f55380a;

        /* renamed from: b  reason: collision with root package name */
        private e f55381b;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
        }

        public final a a(b bVar) {
            this.f55380a = (b) dagger.a.g.a(bVar);
            return this;
        }

        public final a a() {
            dagger.a.g.a(this.f55380a, b.class);
            if (this.f55381b == null) {
                this.f55381b = new e();
            }
            return new d(this.f55380a, this.f55381b, (byte) 0);
        }
    }

    public final void a(net.one97.paytm.moneytransferv4.home.presentation.view.a aVar) {
        aVar.f55528b = this.C.get();
    }

    public final void a(k kVar) {
        kVar.f54988a = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.accountsbottomsheet.a aVar) {
        aVar.f55005a = this.C.get();
    }

    public final void a(AccountSettingsActivity accountSettingsActivity) {
        accountSettingsActivity.f54862a = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.a.a.a aVar) {
        aVar.f54786b = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.accountsbottomsheet.g gVar) {
        gVar.f55056a = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.accounts.b bVar) {
        bVar.f54903a = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.accounts.f fVar) {
        fVar.f54925a = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.b bVar) {
        bVar.f55103b = this.C.get();
    }

    public final void a(net.one97.paytm.moneytransferv4.b.a.a.a.g.a aVar) {
        aVar.f55293a = p.a(n.a(this.f55371a.get()), o.a(this.f55371a.get()), this.m.get());
    }

    public final void a(net.one97.paytm.moneytransferv4.b.a.a.a.d.c cVar) {
        cVar.f55241a = this.C.get();
    }

    public final void a(net.one97.paytm.m.d dVar) {
        dVar.f53162a = this.C.get();
    }
}
