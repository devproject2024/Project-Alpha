package net.one97.paytm.wallet.rateMerchant.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.base.e;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    public final y<o<Float, String>> f71689b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public String f71690c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f71691d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f71692e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f71693f = "";

    /* renamed from: g  reason: collision with root package name */
    public final y<Float> f71694g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<Boolean>> f71695h;

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<net.one97.paytm.wallet.rateMerchant.a.a<o<Float, Boolean>>> f71696i;
    public final net.one97.paytm.wallet.rateMerchant.b.c j;
    private y<a> k;
    private LiveData<net.one97.paytm.wallet.rateMerchant.a.a<String>> l;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f71697a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f71698b;
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.c.b$b  reason: collision with other inner class name */
    static final class C1461b<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71699a;

        C1461b(b bVar) {
            this.f71699a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            a aVar = (a) obj;
            return this.f71699a.j.a(aVar.f71697a, aVar.f71698b, this.f71699a.f71693f);
        }
    }

    static final class c<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71700a;

        c(b bVar) {
            this.f71700a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Float f2 = (Float) obj;
            net.one97.paytm.wallet.rateMerchant.b.c a2 = this.f71700a.j;
            String b2 = this.f71700a.f71690c;
            String c2 = this.f71700a.f71691d;
            String d2 = this.f71700a.f71692e;
            k.a((Object) f2, "it");
            return a2.a(b2, c2, d2, f2.floatValue(), this.f71700a.f71693f);
        }
    }

    static final class d<I, O> implements androidx.arch.core.c.a<X, LiveData<Y>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f71701a;

        d(b bVar) {
            this.f71701a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            o oVar = (o) obj;
            return this.f71701a.j.a(this.f71701a.f71690c, this.f71701a.f71691d, this.f71701a.f71692e, ((Number) oVar.getFirst()).floatValue(), (String) oVar.getSecond(), this.f71701a.f71693f);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(net.one97.paytm.wallet.rateMerchant.b.c r3) {
        /*
            r2 = this;
            java.lang.String r0 = "repository"
            kotlin.g.b.k.c(r3, r0)
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r1 = "WalletCommManager.getWalletCommunicator()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.app.Application r0 = r0.getApplication()
            java.lang.String r1 = "WalletCommManager.getWal…ommunicator().application"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r2.<init>(r0)
            r2.j = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.f71689b = r3
            java.lang.String r3 = ""
            r2.f71690c = r3
            r2.f71691d = r3
            r2.f71692e = r3
            r2.f71693f = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.f71694g = r3
            androidx.lifecycle.y<kotlin.o<java.lang.Float, java.lang.String>> r3 = r2.f71689b
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.b$d r0 = new net.one97.paytm.wallet.rateMerchant.c.b$d
            r0.<init>(r2)
            androidx.arch.core.c.a r0 = (androidx.arch.core.c.a) r0
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r0)
            java.lang.String r0 = "Transformations.switchMa…second, screenName)\n    }"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.f71695h = r3
            androidx.lifecycle.y<java.lang.Float> r3 = r2.f71694g
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.b$c r0 = new net.one97.paytm.wallet.rateMerchant.c.b$c
            r0.<init>(r2)
            androidx.arch.core.c.a r0 = (androidx.arch.core.c.a) r0
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r0)
            java.lang.String r0 = "Transformations.switchMa…et, it, screenName)\n    }"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.f71696i = r3
            androidx.lifecycle.y r3 = new androidx.lifecycle.y
            r3.<init>()
            r2.k = r3
            androidx.lifecycle.y<net.one97.paytm.wallet.rateMerchant.c.b$a> r3 = r2.k
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.wallet.rateMerchant.c.b$b r0 = new net.one97.paytm.wallet.rateMerchant.c.b$b
            r0.<init>(r2)
            androidx.arch.core.c.a r0 = (androidx.arch.core.c.a) r0
            androidx.lifecycle.LiveData r3 = androidx.lifecycle.ah.b(r3, r0)
            java.lang.String r0 = "Transformations.switchMa…Follow, screenName)\n    }"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r2.l = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.rateMerchant.c.b.<init>(net.one97.paytm.wallet.rateMerchant.b.c):void");
    }
}
