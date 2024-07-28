package net.one97.paytm.v2.features.cashbacklanding.c;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.d.f;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;
import net.one97.paytm.v2.features.cashbacklanding.a.a.b;
import net.one97.paytm.v2.features.cashbacklanding.model.CashbackSummary;
import net.one97.paytm.v2.features.cashbacklanding.model.ScratchCardPromo;
import net.one97.paytm.v2.features.cashbackoffers.a.b.j;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.d;
import net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2;
import net.one97.paytm.vipcashback.widget.WrapLinearLayoutManager;

public final class d extends net.one97.paytm.i.h {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.v2.features.b.b.a f20161a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f20162b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbacklanding.d.b f20163c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.v2.features.b.c.a f20164d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public f f20165e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f20166f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineExceptionHandler f20167g = new a(CoroutineExceptionHandler.Key);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f20168h;

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f20170a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    public final View a(int i2) {
        if (this.f20168h == null) {
            this.f20168h = new HashMap();
        }
        View view = (View) this.f20168h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f20168h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class e extends l implements kotlin.g.a.b<ScratchCard, x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ScratchCard) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
            r0 = r0.getWindow();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(net.one97.paytm.common.entity.vipcashback.ScratchCard r7) {
            /*
                r6 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.c(r7, r0)
                net.one97.paytm.v2.features.cashbacklanding.c.d r0 = r6.this$0
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x0018
                android.view.Window r0 = r0.getWindow()
                if (r0 == 0) goto L_0x0018
                android.view.View r0 = r0.getDecorView()
                goto L_0x0019
            L_0x0018:
                r0 = 0
            L_0x0019:
                if (r0 == 0) goto L_0x0050
                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                net.one97.paytm.v2.features.cashbacklanding.c.d r1 = r6.this$0
                net.one97.paytm.v2.features.b.b.a r2 = new net.one97.paytm.v2.features.b.b.a
                androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
                if (r3 != 0) goto L_0x002a
                kotlin.g.b.k.a()
            L_0x002a:
                java.lang.String r4 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                net.one97.paytm.v2.features.cashbacklanding.c.d r4 = r6.this$0
                net.one97.paytm.v2.features.b.c.a r4 = r4.f20164d
                if (r4 != 0) goto L_0x003a
                kotlin.g.b.k.a()
            L_0x003a:
                net.one97.paytm.v2.features.cashbacklanding.c.d$e$1 r5 = new net.one97.paytm.v2.features.cashbacklanding.c.d$e$1
                r5.<init>(r6)
                kotlin.g.a.b r5 = (kotlin.g.a.b) r5
                r2.<init>(r0, r3, r4, r5)
                r1.f20161a = r2
                net.one97.paytm.v2.features.cashbacklanding.c.d r0 = r6.this$0
                net.one97.paytm.v2.features.b.b.a r0 = r0.f20161a
                if (r0 == 0) goto L_0x004f
                r0.a(r7)
            L_0x004f:
                return
            L_0x0050:
                kotlin.u r7 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.view.ViewGroup"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.v2.features.cashbacklanding.c.d.e.invoke(net.one97.paytm.common.entity.vipcashback.ScratchCard):void");
        }
    }

    static final class f<T> implements z<ScratchCard> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20172a;

        f(d dVar) {
            this.f20172a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ScratchCard scratchCard = (ScratchCard) obj;
            if (scratchCard != null) {
                String scratchCardStatus = scratchCard.getScratchCardStatus();
                a.j.C0391a aVar = a.j.f20817a;
                if (k.a((Object) scratchCardStatus, (Object) a.j.f20822f)) {
                    net.one97.paytm.v2.features.cashbacklanding.d.b c2 = this.f20172a.f20163c;
                    if (c2 != null) {
                        Context d2 = this.f20172a.f20162b;
                        if (d2 == null) {
                            k.a();
                        }
                        c2.a(d2);
                    }
                    f a2 = this.f20172a.f20165e;
                    if (a2 != null) {
                        k.c(scratchCard, "data");
                        net.one97.paytm.v2.features.cashbacklanding.d.d dVar = a2.j;
                        if (dVar == null) {
                            k.a("scratchCardViewModel");
                        }
                        if (dVar != null) {
                            dVar.a(scratchCard);
                        }
                    }
                }
            }
        }
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            k.c(fVar, "context");
            k.c(th, "exception");
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            sb.append(" handled !");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext == null) {
            k.a();
        }
        this.f20162b = applicationContext;
        return layoutInflater.inflate(R.layout.fragment_scratchcard_home, (ViewGroup) null);
    }

    public final void onCreate(Bundle bundle) {
        LiveData liveData;
        super.onCreate(bundle);
        Fragment fragment = this;
        b.a a2 = net.one97.paytm.v2.features.cashbacklanding.a.a.b.c().a(new net.one97.paytm.v2.features.cashbacklanding.a.b.e()).a(new net.one97.paytm.v2.features.cashbacklanding.a.b.l(fragment));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            b.a a3 = a2.a(new net.one97.paytm.v2.features.cashbackoffers.a.b.a((AppCompatActivity) activity));
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b.a a4 = a3.a(new j(context));
            a.b.C0384a aVar = a.b.f20777a;
            net.one97.paytm.v2.features.cashbacklanding.a.a.a a5 = a4.a(new net.one97.paytm.v2.features.cashbacklanding.a.b.a(a.b.j)).a();
            this.f20165e = a5.a();
            f fVar = this.f20165e;
            if (fVar == null) {
                k.a();
            }
            a5.a(fVar);
            f fVar2 = this.f20165e;
            if (fVar2 != null) {
                kotlin.g.a.b<? super ScratchCard, x> eVar = new e(this);
                k.c(eVar, "openScratchCard");
                fVar2.f20206h = eVar;
            }
            this.f20164d = a5.b();
            net.one97.paytm.v2.features.b.c.a aVar2 = this.f20164d;
            if (aVar2 != null) {
                a5.a(aVar2);
            }
            net.one97.paytm.v2.features.b.c.a aVar3 = this.f20164d;
            if (!(aVar3 == null || (liveData = aVar3.f20108g) == null)) {
                liveData.observe(this, new f(this));
            }
            f fVar3 = this.f20165e;
            if (fVar3 != null) {
                net.one97.paytm.v2.features.cashbacklanding.d.a aVar4 = fVar3.f20207i;
                if (aVar4 == null) {
                    k.a("cashBackofferViewModel");
                }
                if (aVar4 != null) {
                    a5.a(aVar4);
                }
            }
            f fVar4 = this.f20165e;
            if (fVar4 != null) {
                net.one97.paytm.v2.features.cashbacklanding.d.d dVar = fVar4.j;
                if (dVar == null) {
                    k.a("scratchCardViewModel");
                }
                if (dVar != null) {
                    a5.a(dVar);
                }
            }
            this.f20163c = (net.one97.paytm.v2.features.cashbacklanding.d.b) am.a(fragment).a(net.one97.paytm.v2.features.cashbacklanding.d.b.class);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        RecyclerView recyclerView;
        y<net.one97.paytm.vipcashback.f.h<Object>> yVar;
        LiveData<String> liveData;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.v2.features.cashbacklanding.d.b bVar = this.f20163c;
        if (bVar != null) {
            Context context = this.f20162b;
            if (context == null) {
                k.a();
            }
            bVar.a(context);
        }
        net.one97.paytm.v2.features.cashbacklanding.d.b bVar2 = this.f20163c;
        if (!(bVar2 == null || (liveData = bVar2.f20251c) == null)) {
            liveData.observe(this, c.f20170a);
        }
        net.one97.paytm.v2.features.cashbacklanding.d.b bVar3 = this.f20163c;
        if (!(bVar3 == null || (yVar = bVar3.f20249a.f20054a) == null)) {
            yVar.observe(this, new C0361d(this));
        }
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.storefrontList);
        k.a((Object) recyclerView2, "storefrontList");
        recyclerView2.setLayoutManager(new WrapLinearLayoutManager(this.f20162b));
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.storefrontList);
        k.a((Object) recyclerView3, "storefrontList");
        recyclerView3.setAdapter(this.f20165e);
        b();
        ((SwipeRefreshLayout) a(R.id.swipeRefresh)).setColorSchemeResources(net.one97.paytm.common.assets.R.color.paytm_blue);
        ((SwipeRefreshLayout) a(R.id.swipeRefresh)).setOnRefreshListener(new g(this));
        if (Build.VERSION.SDK_INT >= 23 && (recyclerView = (RecyclerView) a(R.id.storefrontList)) != null) {
            recyclerView.setOnScrollListener(new h(this));
        }
        net.one97.paytm.vipcashback.c.a.b().sendOpenScreenWithDeviceInfo("/cashback-landing", "cashback", getContext());
        this.f20166f = getResources().getDimensionPixelOffset(net.one97.paytm.common.assets.R.dimen.dimen_30dp);
    }

    static final class g implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20173a;

        g(d dVar) {
            this.f20173a = dVar;
        }

        public final void onRefresh() {
            this.f20173a.a();
        }
    }

    private final void b() {
        String a2 = com.paytm.utility.c.a(getContext(), false);
        SFInterface sFInterface = SFInterface.INSTANCE;
        StringBuilder sb = new StringBuilder();
        net.one97.paytm.vipcashback.f.f.a();
        getContext();
        sb.append(net.one97.paytm.vipcashback.f.f.s());
        sb.append("?user_id=");
        sb.append(net.one97.paytm.vipcashback.c.a.b().getUserId(getContext()));
        sb.append(a2);
        String sb2 = sb.toString();
        d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
        sFInterface.getStoreFrontReponse(sb2, d.a.b(), a.c.CASHBACK, new b(this), "cashbackLanding", 1006, (IGAEnableListener) null);
    }

    public static final class b implements SFCallbackListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20169a;

        public /* synthetic */ void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            SFCallbackListener.CC.$default$onFailure(this, i2, iJRPaytmDataModel, networkCustomError);
        }

        b(d dVar) {
            this.f20169a = dVar;
        }

        public final void onSuccess(SanitizedResponseModel sanitizedResponseModel) {
            f a2;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.f20169a.a(R.id.swipeRefresh);
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setEnabled(true);
            }
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.f20169a.a(R.id.swipeRefresh);
            int i2 = 0;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
            if (sanitizedResponseModel != null && (a2 = this.f20169a.f20165e) != null) {
                List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
                k.c(rvWidgets, "rvWidgets");
                a2.f20199a = rvWidgets;
                a2.f20205g = false;
                List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list = a2.f20199a;
                int size = (list != null ? list.size() : 0) - 1;
                if (size >= 0) {
                    while (true) {
                        WidgetLayoutType.Companion companion = WidgetLayoutType.Companion;
                        List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list2 = a2.f20199a;
                        if (list2 == null) {
                            k.a();
                        }
                        if (companion.getLayoutTypeNameNameFromIndex(companion.getLayoutTypeIndexfromName((com.paytmmall.clpartifact.modal.clpCommon.View) list2.get(i2))).equals(a2.f20202d)) {
                            net.one97.paytm.v2.features.cashbacklanding.d.a aVar = a2.f20207i;
                            if (aVar == null) {
                                k.a("cashBackofferViewModel");
                            }
                            aVar.a("");
                        }
                        WidgetLayoutType.Companion companion2 = WidgetLayoutType.Companion;
                        List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list3 = a2.f20199a;
                        if (list3 == null) {
                            k.a();
                        }
                        if (companion2.getLayoutTypeNameNameFromIndex(companion2.getLayoutTypeIndexfromName((com.paytmmall.clpartifact.modal.clpCommon.View) list3.get(i2))).equals(a2.f20203e)) {
                            net.one97.paytm.v2.features.cashbacklanding.d.d dVar = a2.j;
                            if (dVar == null) {
                                k.a("scratchCardViewModel");
                            }
                            dVar.a("");
                        }
                        if (i2 == size) {
                            break;
                        }
                        i2++;
                    }
                }
                a2.notifyDataSetChanged();
            }
        }
    }

    public final void onResume() {
        super.onResume();
        net.one97.paytm.vipcashback.f.g gVar = net.one97.paytm.vipcashback.f.g.f20891a;
        if (net.one97.paytm.vipcashback.f.g.a()) {
            a();
        }
    }

    /* renamed from: net.one97.paytm.v2.features.cashbacklanding.c.d$d  reason: collision with other inner class name */
    public static final class C0361d implements z<net.one97.paytm.vipcashback.f.h<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20171a;

        C0361d(d dVar) {
            this.f20171a = dVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.vipcashback.f.h hVar = (net.one97.paytm.vipcashback.f.h) obj;
            k.c(hVar, "it");
            int i2 = hVar.f20893a;
            ArrayList<CashbackSummary> arrayList = null;
            if (i2 == 101) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.f20171a.a(R.id.swipeRefresh);
                k.a((Object) swipeRefreshLayout, "swipeRefresh");
                swipeRefreshLayout.setEnabled(true);
                if (hVar.f20894b != null) {
                    d dVar = this.f20171a;
                    T t = hVar.f20894b;
                    if (t != null) {
                        ScratchCardPromo.a data = ((ScratchCardPromo) t).getData();
                        if (data != null) {
                            arrayList = data.f20286a;
                        }
                        d.a(dVar, arrayList);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.v2.features.cashbacklanding.model.ScratchCardPromo");
                }
            } else if (i2 == 102) {
                d.a(this.f20171a, (ArrayList) null);
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.f20171a.a(R.id.swipeRefresh);
                k.a((Object) swipeRefreshLayout2, "swipeRefresh");
                swipeRefreshLayout2.setRefreshing(false);
                if (this.f20171a.getActivity() != null) {
                    d.a aVar = net.one97.paytm.vipcashback.f.d.f20859a;
                    Throwable th = hVar.f20895c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        FragmentActivity activity = this.f20171a.getActivity();
                        if (activity != null) {
                            d.a.a(networkCustomError, (FragmentActivity) (AppCompatActivity) activity, (Boolean) null, 12);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            } else if (i2 == 104) {
                d.a(this.f20171a, (ArrayList) null);
                SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.f20171a.a(R.id.swipeRefresh);
                k.a((Object) swipeRefreshLayout3, "swipeRefresh");
                swipeRefreshLayout3.setRefreshing(false);
                d.a aVar2 = net.one97.paytm.vipcashback.f.d.f20859a;
                Context context = this.f20171a.getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                d.a.a(context, (kotlin.g.a.a<x>) new a(this));
            }
        }

        /* renamed from: net.one97.paytm.v2.features.cashbacklanding.c.d$d$a */
        static final class a extends l implements kotlin.g.a.a<x> {
            final /* synthetic */ C0361d this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C0361d dVar) {
                super(0);
                this.this$0 = dVar;
            }

            public final void invoke() {
                FragmentActivity activity = this.this$0.f20171a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        }
    }

    public static final class h extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f20174a;

        h(d dVar) {
            this.f20174a = dVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            StringBuilder sb = new StringBuilder("Debug>>>> setOnScrollChangeListener ");
            RecyclerView recyclerView2 = (RecyclerView) this.f20174a.a(R.id.storefrontList);
            sb.append(recyclerView2 != null ? Integer.valueOf(recyclerView2.computeVerticalScrollOffset()) : null);
            if (this.f20174a.getParentFragment() instanceof FJRCashbackFragmentV2) {
                RecyclerView recyclerView3 = (RecyclerView) this.f20174a.a(R.id.storefrontList);
                if ((recyclerView3 != null ? recyclerView3.computeVerticalScrollOffset() : 0) <= this.f20174a.f20166f) {
                    Fragment parentFragment = this.f20174a.getParentFragment();
                    if (parentFragment != null) {
                        ((FJRCashbackFragmentV2) parentFragment).a(false);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2");
                }
                Fragment parentFragment2 = this.f20174a.getParentFragment();
                if (parentFragment2 != null) {
                    ((FJRCashbackFragmentV2) parentFragment2).a(true);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.vipcashback.fragment.FJRCashbackFragmentV2");
            }
        }
    }

    public final void a() {
        net.one97.paytm.vipcashback.f.g gVar = net.one97.paytm.vipcashback.f.g.f20891a;
        net.one97.paytm.vipcashback.f.g.a(false);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) a(R.id.swipeRefresh);
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setRefreshing(true);
        }
        net.one97.paytm.v2.features.cashbacklanding.d.b bVar = this.f20163c;
        if (bVar != null) {
            Context context = this.f20162b;
            if (context == null) {
                k.a();
            }
            bVar.a(context);
        }
        f fVar = this.f20165e;
        if (fVar != null) {
            fVar.f20199a = null;
            fVar.f20205g = true;
            fVar.f20204f = true;
            fVar.notifyDataSetChanged();
        }
        b();
    }

    public static final /* synthetic */ void a(d dVar, ArrayList arrayList) {
        f fVar = dVar.f20165e;
        if (fVar != null) {
            fVar.f20204f = false;
            if (arrayList != null) {
                fVar.f20200b = arrayList;
                fVar.notifyDataSetChanged();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f20168h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
