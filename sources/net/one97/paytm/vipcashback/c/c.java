package net.one97.paytm.vipcashback.c;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper;
import net.one97.paytm.v2.features.cashbackoffers.a.a.c;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.v2.features.cashbackoffers.a.b.v;
import net.one97.paytm.vipcashback.f.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f20716a;

    /* renamed from: b  reason: collision with root package name */
    public String f20717b;

    /* renamed from: c  reason: collision with root package name */
    public d f20718c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.cashback.posttxn.a f20719d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20720e;

    /* renamed from: f  reason: collision with root package name */
    private final String f20721f = getClass().getSimpleName();

    static final class e<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f20726a = new e();

        e() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static final class a<T> implements z<PostTxnScratchCardWrapper> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20722a;

        a(c cVar) {
            this.f20722a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0053, code lost:
            r0 = r0.getWindow();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r11) {
            /*
                r10 = this;
                net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper r11 = (net.one97.paytm.common.entity.vipcashback.PostTxnScratchCardWrapper) r11
                boolean r0 = r11.isStageComplete
                if (r0 == 0) goto L_0x0136
                net.one97.paytm.vipcashback.c.c r0 = r10.f20722a
                boolean r0 = r0.f20720e
                if (r0 == 0) goto L_0x004c
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r0 = r11.vipCashBackOfferV4
                java.lang.String r1 = "it.vipCashBackOfferV4"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.cashback.posttxn.InfoV4 r0 = r0.getInfo()
                java.lang.String r1 = "it.vipCashBackOfferV4.info"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.cashback.posttxn.Campaign r0 = r0.getCampaign()
                java.lang.String r1 = "it.vipCashBackOfferV4.info.campaign"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                int r0 = r0.getId()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                r5.add(r0)
                net.one97.paytm.vipcashback.c.b r1 = net.one97.paytm.vipcashback.c.a.b()
                net.one97.paytm.vipcashback.c.c r0 = r10.f20722a
                androidx.fragment.app.FragmentActivity r0 = r0.f20716a
                r2 = r0
                android.content.Context r2 = (android.content.Context) r2
                r6 = 0
                java.lang.String r3 = "/app_open"
                java.lang.String r4 = "scratch_card_loaded"
                java.lang.String r7 = "/homepage"
                java.lang.String r8 = "cashback"
                r1.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8)
            L_0x004c:
                net.one97.paytm.vipcashback.c.c r0 = r10.f20722a
                androidx.fragment.app.FragmentActivity r0 = r0.f20716a
                r1 = 0
                if (r0 == 0) goto L_0x005e
                android.view.Window r0 = r0.getWindow()
                if (r0 == 0) goto L_0x005e
                android.view.View r0 = r0.getDecorView()
                goto L_0x005f
            L_0x005e:
                r0 = r1
            L_0x005f:
                if (r0 == 0) goto L_0x012e
                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                net.one97.paytm.vipcashback.c.e r2 = new net.one97.paytm.vipcashback.c.e
                net.one97.paytm.vipcashback.c.c r3 = r10.f20722a
                androidx.fragment.app.FragmentActivity r3 = r3.f20716a
                if (r3 != 0) goto L_0x006e
                kotlin.g.b.k.a()
            L_0x006e:
                net.one97.paytm.vipcashback.c.c r4 = r10.f20722a
                net.one97.paytm.cashback.posttxn.a r4 = r4.f20719d
                r2.<init>(r0, r3, r4)
                net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4 r0 = r11.vipCashBackOfferV4
                java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard> r11 = r11.scratchCards
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.d.f r3 = (kotlin.d.f) r3
                kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r3)
                r5 = 0
                r6 = 0
                net.one97.paytm.vipcashback.c.e$g r3 = new net.one97.paytm.vipcashback.c.e$g
                r3.<init>(r2, r1)
                r7 = r3
                kotlin.g.a.m r7 = (kotlin.g.a.m) r7
                r8 = 3
                r9 = 0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
                r2.f20739c = r0
                r2.f20740d = r11
                net.one97.paytm.v2.features.b.a.a$a r1 = net.one97.paytm.v2.features.b.a.a.a()
                net.one97.paytm.v2.features.cashbackoffers.a.b.j r3 = new net.one97.paytm.v2.features.cashbackoffers.a.b.j
                androidx.fragment.app.FragmentActivity r4 = r2.f20742f
                android.content.Context r4 = (android.content.Context) r4
                r3.<init>(r4)
                net.one97.paytm.v2.features.b.a.a$a r1 = r1.a((net.one97.paytm.v2.features.cashbackoffers.a.b.j) r3)
                net.one97.paytm.v2.features.b.a.a.a r3 = new net.one97.paytm.v2.features.b.a.a.a
                androidx.fragment.app.FragmentActivity r4 = r2.f20742f
                r3.<init>(r4)
                net.one97.paytm.v2.features.b.a.a$a r1 = r1.a((net.one97.paytm.v2.features.b.a.a.a) r3)
                net.one97.paytm.v2.features.b.a.b r1 = r1.a()
                net.one97.paytm.v2.features.b.c.a r3 = r1.b()
                r2.f20738b = r3
                net.one97.paytm.v2.features.b.c.a r3 = r2.f20738b
                if (r3 != 0) goto L_0x00c3
                kotlin.g.b.k.a()
            L_0x00c3:
                r1.a(r3)
                net.one97.paytm.v2.features.b.c.a r1 = r2.f20738b
                if (r1 == 0) goto L_0x00de
                androidx.lifecycle.y<java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCardData>> r1 = r1.f20106e
                androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
                if (r1 == 0) goto L_0x00de
                androidx.fragment.app.FragmentActivity r3 = r2.f20742f
                androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3
                net.one97.paytm.vipcashback.c.e$c r4 = new net.one97.paytm.vipcashback.c.e$c
                r4.<init>(r2)
                androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
                r1.observe(r3, r4)
            L_0x00de:
                net.one97.paytm.v2.features.b.c.a r1 = r2.f20738b
                if (r1 == 0) goto L_0x00f6
                androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r1 = r1.f20104c
                androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
                if (r1 == 0) goto L_0x00f6
                androidx.fragment.app.FragmentActivity r3 = r2.f20742f
                androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3
                net.one97.paytm.vipcashback.c.e$d r4 = new net.one97.paytm.vipcashback.c.e$d
                r4.<init>(r2)
                androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
                r1.observe(r3, r4)
            L_0x00f6:
                net.one97.paytm.v2.features.b.c.a r1 = r2.f20738b
                if (r1 == 0) goto L_0x010e
                androidx.lifecycle.y<com.paytm.network.a> r1 = r1.f20105d
                androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
                if (r1 == 0) goto L_0x010e
                androidx.fragment.app.FragmentActivity r3 = r2.f20742f
                androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3
                net.one97.paytm.vipcashback.c.e$e r4 = new net.one97.paytm.vipcashback.c.e$e
                r4.<init>(r2)
                androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
                r1.observe(r3, r4)
            L_0x010e:
                net.one97.paytm.v2.features.b.c.a r1 = r2.f20738b
                if (r1 == 0) goto L_0x0126
                androidx.lifecycle.LiveData<kotlin.x> r1 = r1.k
                if (r1 == 0) goto L_0x0126
                androidx.fragment.app.FragmentActivity r3 = r2.f20742f
                if (r3 != 0) goto L_0x011d
                kotlin.g.b.k.a()
            L_0x011d:
                androidx.lifecycle.q r3 = (androidx.lifecycle.q) r3
                net.one97.paytm.vipcashback.c.e$f r4 = net.one97.paytm.vipcashback.c.e.f.f20751a
                androidx.lifecycle.z r4 = (androidx.lifecycle.z) r4
                r1.observe(r3, r4)
            L_0x0126:
                net.one97.paytm.v2.features.b.c.a r1 = r2.f20738b
                if (r1 == 0) goto L_0x0136
                r1.a((net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4) r0, (java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.ScratchCard>) r11)
                return
            L_0x012e:
                kotlin.u r11 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup"
                r11.<init>(r0)
                throw r11
            L_0x0136:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.c.c.a.onChanged(java.lang.Object):void");
        }
    }

    static final class b<T> implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20723a;

        b(c cVar) {
            this.f20723a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.paytm.network.a aVar = (com.paytm.network.a) obj;
            k.c(aVar, H5Event.TYPE_CALL);
            FragmentActivity fragmentActivity = this.f20723a.f20716a;
            if (fragmentActivity != null) {
                d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                d.a.a((Context) fragmentActivity, aVar, false);
            }
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.c.c$c  reason: collision with other inner class name */
    static final class C0380c<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20724a;

        C0380c(c cVar) {
            this.f20724a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            k.c(networkCustomError, "error");
            if (this.f20724a.f20716a != null) {
                d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                FragmentActivity fragmentActivity = this.f20724a.f20716a;
                if (fragmentActivity == null) {
                    k.a();
                }
                d.a.a(networkCustomError, fragmentActivity, Boolean.FALSE, 8);
            }
        }
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20725a;

        d(c cVar) {
            this.f20725a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            if (this.f20725a.f20719d != null && (this.f20725a.f20719d instanceof net.one97.paytm.cashback.posttxn.b)) {
                net.one97.paytm.cashback.posttxn.a aVar = this.f20725a.f20719d;
                if (aVar != null) {
                    ((net.one97.paytm.cashback.posttxn.b) aVar).a("Cashback", booleanValue);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.cashback.posttxn.CashbackH5AnimationListner");
            }
        }
    }

    public final void a(FragmentActivity fragmentActivity) {
        k.c(fragmentActivity, "appCompatActivity");
        this.f20716a = fragmentActivity;
        com.google.android.play.core.splitcompat.a.b((Context) this.f20716a);
    }

    public final void a() {
        LiveData<String> liveData;
        LiveData liveData2;
        LiveData liveData3;
        if (this.f20716a != null) {
            c.a a2 = net.one97.paytm.v2.features.cashbackoffers.a.a.c.a();
            FragmentActivity fragmentActivity = this.f20716a;
            if (fragmentActivity == null) {
                k.a();
            }
            c.a a3 = a2.a(new j(fragmentActivity));
            FragmentActivity fragmentActivity2 = this.f20716a;
            if (fragmentActivity2 != null) {
                net.one97.paytm.v2.features.cashbackoffers.a.a.d a4 = a3.a(new v(fragmentActivity2)).a();
                this.f20718c = a4.b();
                d dVar = this.f20718c;
                if (dVar == null) {
                    k.a();
                }
                a4.a(dVar);
                d dVar2 = this.f20718c;
                if (dVar2 == null) {
                    k.a();
                }
                LiveData liveData4 = dVar2.f20729c;
                FragmentActivity fragmentActivity3 = this.f20716a;
                if (fragmentActivity3 == null) {
                    k.a();
                }
                liveData4.observe(fragmentActivity3, new a(this));
                d dVar3 = this.f20718c;
                if (dVar3 == null) {
                    k.a();
                }
                LiveData liveData5 = dVar3.f20730d;
                FragmentActivity fragmentActivity4 = this.f20716a;
                if (fragmentActivity4 == null) {
                    k.a();
                }
                liveData5.observe(fragmentActivity4, new b(this));
                d dVar4 = this.f20718c;
                if (!(dVar4 == null || (liveData3 = dVar4.f20731e) == null)) {
                    FragmentActivity fragmentActivity5 = this.f20716a;
                    if (fragmentActivity5 == null) {
                        k.a();
                    }
                    liveData3.observe(fragmentActivity5, new C0380c(this));
                }
                d dVar5 = this.f20718c;
                if (!(dVar5 == null || (liveData2 = dVar5.f20733g) == null)) {
                    liveData2.observeForever(new d(this));
                }
                d dVar6 = this.f20718c;
                if (dVar6 != null && (liveData = dVar6.f20734h) != null) {
                    FragmentActivity fragmentActivity6 = this.f20716a;
                    if (fragmentActivity6 == null) {
                        k.a();
                    }
                    liveData.observe(fragmentActivity6, e.f20726a);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }
}
