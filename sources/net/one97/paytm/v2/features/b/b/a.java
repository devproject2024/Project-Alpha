package net.one97.paytm.v2.features.b.b;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.common.entity.vipcashback.ScratchCardData;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.v2.features.offerdetail.ui.CashbackCompaignGameDetail;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.fragment.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f20082a;

    /* renamed from: b  reason: collision with root package name */
    ScratchCardData f20083b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<net.one97.paytm.vipcashback.fragment.f> f20084c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    View f20085d;

    /* renamed from: e  reason: collision with root package name */
    C0357a f20086e = new C0357a(this);

    /* renamed from: f  reason: collision with root package name */
    m<? super Integer, ? super String, x> f20087f = new h(this);

    /* renamed from: g  reason: collision with root package name */
    final ViewGroup f20088g;

    /* renamed from: h  reason: collision with root package name */
    final FragmentActivity f20089h;

    /* renamed from: i  reason: collision with root package name */
    final net.one97.paytm.v2.features.b.c.a f20090i;
    final kotlin.g.a.b<Boolean, x> j;

    static final class g<T> implements z<x> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f20097a = new g();

        g() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static final class b<T> implements z<ArrayList<ScratchCardData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20092a;

        b(a aVar) {
            this.f20092a = aVar;
        }

        /* JADX WARNING: type inference failed for: r12v9, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r12) {
            /*
                r11 = this;
                java.util.ArrayList r12 = (java.util.ArrayList) r12
                net.one97.paytm.v2.features.b.b.a r0 = r11.f20092a
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
                r1 = 0
                java.lang.Object r2 = r12.get(r1)
                net.one97.paytm.common.entity.vipcashback.ScratchCardData r2 = (net.one97.paytm.common.entity.vipcashback.ScratchCardData) r2
                r0.f20083b = r2
                androidx.fragment.app.FragmentActivity r2 = r0.f20089h
                android.content.Context r2 = (android.content.Context) r2
                android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
                int r3 = net.one97.paytm.vipcashback.R.layout.activity_scratchcard
                r4 = 0
                android.view.View r2 = r2.inflate(r3, r4)
                r0.f20085d = r2
                android.view.ViewGroup r2 = r0.f20088g
                android.view.View r3 = r0.f20085d
                r2.addView(r3)
                net.one97.paytm.vipcashback.f.i$a r2 = net.one97.paytm.vipcashback.f.i.f20896a
                java.lang.Object r12 = r12.get(r1)
                java.lang.String r1 = "scratchCardDataList[0]"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
                r5 = r12
                net.one97.paytm.common.entity.vipcashback.ScratchCardData r5 = (net.one97.paytm.common.entity.vipcashback.ScratchCardData) r5
                androidx.fragment.app.FragmentActivity r12 = r0.f20089h
                r6 = r12
                android.content.Context r6 = (android.content.Context) r6
                kotlin.g.a.m<? super java.lang.Integer, ? super java.lang.String, kotlin.x> r7 = r0.f20087f
                java.util.ArrayList<net.one97.paytm.vipcashback.fragment.f> r8 = r0.f20084c
                net.one97.paytm.v2.features.b.b.a$j r12 = new net.one97.paytm.v2.features.b.b.a$j
                r12.<init>(r0)
                r10 = r12
                kotlin.g.a.b r10 = (kotlin.g.a.b) r10
                r9 = 1
                android.view.View r12 = net.one97.paytm.vipcashback.f.i.a.a(r5, r6, r7, r8, r9, r10)
                android.view.View r1 = r0.f20085d
                if (r1 == 0) goto L_0x005b
                int r2 = net.one97.paytm.vipcashback.R.id.scratchCardLayout
                android.view.View r1 = r1.findViewById(r2)
                android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
                goto L_0x005c
            L_0x005b:
                r1 = r4
            L_0x005c:
                if (r1 == 0) goto L_0x0061
                r1.addView(r12)
            L_0x0061:
                android.view.View r12 = r0.f20085d
                if (r12 == 0) goto L_0x006e
                int r1 = net.one97.paytm.vipcashback.R.id.cardLayout
                android.view.View r12 = r12.findViewById(r1)
                r4 = r12
                androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            L_0x006e:
                if (r4 == 0) goto L_0x007a
                net.one97.paytm.v2.features.b.b.a$i r12 = new net.one97.paytm.v2.features.b.b.a$i
                r12.<init>(r0)
                android.view.View$OnTouchListener r12 = (android.view.View.OnTouchListener) r12
                r4.setOnTouchListener(r12)
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.b.b.a.b.onChanged(java.lang.Object):void");
        }
    }

    static final class c<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20093a;

        c(a aVar) {
            this.f20093a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            k.a((Object) networkCustomError, "it");
            d.a.a(networkCustomError, this.f20093a.f20089h, Boolean.FALSE, 8);
        }
    }

    static final class d<T> implements z<com.paytm.network.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20094a;

        d(a aVar) {
            this.f20094a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
            d.a.a(this.f20094a.f20089h, (com.paytm.network.a) obj, false);
        }
    }

    static final class e<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20095a;

        e(a aVar) {
            this.f20095a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f20095a.a();
            }
        }
    }

    static final class f<T> implements z<ScratchCardData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20096a;

        f(a aVar) {
            this.f20096a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            View view;
            a aVar = this.f20096a;
            aVar.f20083b = (ScratchCardData) obj;
            ScratchCardData scratchCardData = aVar.f20083b;
            if (scratchCardData != null && (view = aVar.f20085d) != null) {
                g.a aVar2 = net.one97.paytm.vipcashback.fragment.g.f20995a;
                g.a.a(aVar.f20089h, view, scratchCardData, aVar.f20087f);
            }
        }
    }

    static final class h extends l implements m<Integer, String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(2);
            this.this$0 = aVar;
        }

        public final /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (String) obj2);
            return x.f47997a;
        }

        public final void invoke(int i2, String str) {
            LiveData liveData;
            k.c(str, "id");
            if (i2 == 1) {
                net.one97.paytm.v2.features.b.c.a aVar = this.this$0.f20090i;
                if (!(aVar == null || (liveData = aVar.j) == null)) {
                    liveData.observe(this.this$0.f20089h, this.this$0.f20086e);
                }
                net.one97.paytm.v2.features.b.c.a aVar2 = this.this$0.f20090i;
                if (aVar2 != null) {
                    k.c(str, "refrenceId");
                    net.one97.paytm.v2.a.d dVar = aVar2.f20102a;
                    if (dVar == null) {
                        k.a("repository");
                    }
                    if (dVar != null) {
                        dVar.a(aVar2.f20109h, str);
                    }
                }
            } else if (i2 == 2) {
                Intent intent = new Intent(this.this$0.f20089h, CashbackCompaignGameDetail.class);
                intent.putExtra("gameid", str);
                this.this$0.f20089h.startActivity(intent);
                this.this$0.a();
            } else if (i2 == 3) {
                this.this$0.j.invoke(Boolean.valueOf(this.this$0.f20082a));
                this.this$0.a();
            }
        }
    }

    static final class j extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar) {
            super(1);
            this.this$0 = aVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            List list;
            String str2;
            k.c(str, "cardId");
            a aVar = this.this$0;
            net.one97.paytm.vipcashback.c.a.b().sendNewCustomGTMEventsWithMultipleLabel(aVar.f20089h, "cashback_offers", "scratch_card_scratched", (ArrayList<String>) null, (String) null, "/cashback-landing", "cashback");
            net.one97.paytm.v2.features.b.c.a aVar2 = aVar.f20090i;
            if (aVar2 != null) {
                k.c(str, "cardID");
                ArrayList<ScratchCardData> arrayList = aVar2.f20103b;
                if (arrayList != null) {
                    Collection arrayList2 = new ArrayList();
                    for (Object next : arrayList) {
                        String str3 = ((ScratchCardData) next).scratchCardId;
                        if (str3 != null ? str3.equals(str) : false) {
                            arrayList2.add(next);
                        }
                    }
                    list = (List) arrayList2;
                } else {
                    list = null;
                }
                Collection collection = list;
                if (!(collection == null || collection.isEmpty()) && (str2 = ((ScratchCardData) list.get(0)).scratchCardId) != null) {
                    net.one97.paytm.v2.a.d dVar = aVar2.f20102a;
                    if (dVar == null) {
                        k.a("repository");
                    }
                    dVar.b(aVar2.f20109h, str2);
                }
            }
        }
    }

    public a(ViewGroup viewGroup, FragmentActivity fragmentActivity, net.one97.paytm.v2.features.b.c.a aVar, kotlin.g.a.b<? super Boolean, x> bVar) {
        k.c(viewGroup, "decorView");
        k.c(fragmentActivity, "activity");
        k.c(aVar, "mScratchCardViewModel");
        k.c(bVar, "flipListner");
        this.f20088g = viewGroup;
        this.f20089h = fragmentActivity;
        this.f20090i = aVar;
        this.j = bVar;
    }

    public final void a(ScratchCard scratchCard) {
        LiveData<x> liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        LiveData liveData6;
        k.c(scratchCard, BaseViewModel.PaymentType.CARD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(scratchCard);
        net.one97.paytm.v2.features.b.c.a aVar = this.f20090i;
        if (aVar != null) {
            aVar.a((VIPCashBackOfferV4) null, (ArrayList<ScratchCard>) arrayList);
        }
        net.one97.paytm.v2.features.b.c.a aVar2 = this.f20090i;
        if (!(aVar2 == null || (liveData6 = aVar2.f20106e) == null)) {
            liveData6.observe(this.f20089h, new b(this));
        }
        net.one97.paytm.v2.features.b.c.a aVar3 = this.f20090i;
        if (!(aVar3 == null || (liveData5 = aVar3.f20104c) == null)) {
            liveData5.observe(this.f20089h, new c(this));
        }
        net.one97.paytm.v2.features.b.c.a aVar4 = this.f20090i;
        if (!(aVar4 == null || (liveData4 = aVar4.f20105d) == null)) {
            liveData4.observe(this.f20089h, new d(this));
        }
        net.one97.paytm.v2.features.b.c.a aVar5 = this.f20090i;
        if (!(aVar5 == null || (liveData3 = aVar5.f20110i) == null)) {
            liveData3.observe(this.f20089h, new e(this));
        }
        net.one97.paytm.v2.features.b.c.a aVar6 = this.f20090i;
        if (!(aVar6 == null || (liveData2 = aVar6.f20107f) == null)) {
            liveData2.observe(this.f20089h, new f(this));
        }
        net.one97.paytm.v2.features.b.c.a aVar7 = this.f20090i;
        if (aVar7 != null && (liveData = aVar7.k) != null) {
            liveData.observe(this.f20089h, g.f20097a);
        }
    }

    private final void b() {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        net.one97.paytm.v2.features.b.c.a aVar = this.f20090i;
        LiveData<x> liveData6 = null;
        if (aVar != null) {
            liveData = aVar.f20106e;
        } else {
            liveData = null;
        }
        liveData.removeObservers(this.f20089h);
        net.one97.paytm.v2.features.b.c.a aVar2 = this.f20090i;
        if (aVar2 != null) {
            liveData2 = aVar2.f20104c;
        } else {
            liveData2 = null;
        }
        liveData2.removeObservers(this.f20089h);
        net.one97.paytm.v2.features.b.c.a aVar3 = this.f20090i;
        if (aVar3 != null) {
            liveData3 = aVar3.f20105d;
        } else {
            liveData3 = null;
        }
        liveData3.removeObservers(this.f20089h);
        net.one97.paytm.v2.features.b.c.a aVar4 = this.f20090i;
        if (aVar4 != null) {
            liveData4 = aVar4.f20110i;
        } else {
            liveData4 = null;
        }
        liveData4.removeObservers(this.f20089h);
        net.one97.paytm.v2.features.b.c.a aVar5 = this.f20090i;
        if (aVar5 != null) {
            liveData5 = aVar5.f20107f;
        } else {
            liveData5 = null;
        }
        liveData5.removeObservers(this.f20089h);
        net.one97.paytm.v2.features.b.c.a aVar6 = this.f20090i;
        if (aVar6 != null) {
            liveData6 = aVar6.k;
        }
        liveData6.removeObservers(this.f20089h);
    }

    public static final class i implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20098a;

        i(a aVar) {
            this.f20098a = aVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f20098a.j.invoke(Boolean.valueOf(this.f20098a.f20082a));
            this.f20098a.a();
            return true;
        }
    }

    /* renamed from: net.one97.paytm.v2.features.b.b.a$a  reason: collision with other inner class name */
    public static final class C0357a implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20091a;

        C0357a(a aVar) {
            this.f20091a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            RelativeLayout relativeLayout;
            View childAt;
            net.one97.paytm.vipcashback.fragment.f fVar;
            LiveData liveData;
            RelativeLayout relativeLayout2;
            View childAt2;
            net.one97.paytm.vipcashback.fragment.f fVar2;
            LiveData liveData2;
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            Integer valueOf = hVar != null ? Integer.valueOf(hVar.f20893a) : null;
            if (valueOf != null && valueOf.intValue() == 102) {
                net.one97.paytm.v2.features.b.c.a aVar = this.f20091a.f20090i;
                if (!(aVar == null || (liveData2 = aVar.j) == null)) {
                    liveData2.removeObserver(this);
                }
                View view = this.f20091a.f20085d;
                if (view != null && (relativeLayout2 = (RelativeLayout) view.findViewById(R.id.scratchCardLayout)) != null && (childAt2 = relativeLayout2.getChildAt(0)) != null && (fVar2 = this.f20091a.f20084c.get(0)) != null) {
                    fVar2.a(childAt2, (Object) hVar.f20894b);
                }
            } else if (valueOf != null && valueOf.intValue() == 101) {
                a aVar2 = this.f20091a;
                aVar2.f20082a = true;
                net.one97.paytm.v2.features.b.c.a aVar3 = aVar2.f20090i;
                if (!(aVar3 == null || (liveData = aVar3.j) == null)) {
                    liveData.removeObserver(this);
                }
                View view2 = this.f20091a.f20085d;
                if (view2 != null && (relativeLayout = (RelativeLayout) view2.findViewById(R.id.scratchCardLayout)) != null && (childAt = relativeLayout.getChildAt(0)) != null && (fVar = this.f20091a.f20084c.get(0)) != null) {
                    fVar.a(childAt, (Object) hVar.f20894b);
                }
            } else if (valueOf != null) {
                valueOf.intValue();
            }
        }
    }

    public final void a() {
        b();
        View view = this.f20085d;
        if (view != null) {
            this.f20088g.removeView(view);
        }
    }
}
