package net.one97.paytm.recharge.mobile_v3.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.d.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.b;
import net.one97.paytm.recharge.common.a.g;
import net.one97.paytm.recharge.common.a.h;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.a.r;
import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.common.e.ae;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.utils.an;
import net.one97.paytm.recharge.common.utils.aq;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.e;
import net.one97.paytm.recharge.common.widget.CJRContactListV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile.widget.CJRMobileInputFieldWidgetV8;
import net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class c extends net.one97.paytm.recharge.mobile.a.d implements View.OnClickListener, b.C1169b, h.c, p.a, p.b, p.c, ae, e.a, CJRMobileInputFieldWidgetV8.a {
    private static final String L;
    /* access modifiers changed from: private */
    public static final String M = M;
    public static final a z = new a((byte) 0);
    /* access modifiers changed from: private */
    public r A;
    private net.one97.paytm.recharge.common.a.b B;
    private boolean C;
    private net.one97.paytm.recharge.common.utils.e D;
    private CJRFrequentOrder E;
    private boolean F;
    private final int G = 10;
    private final io.reactivex.rxjava3.j.b<String> H;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> I;
    /* access modifiers changed from: private */
    public final Handler J;
    private final View.OnClickListener K;
    private HashMap N;

    /* renamed from: f  reason: collision with root package name */
    private boolean f63773f;
    CJRInputFieldsItem n;
    CJRMobileInputFieldWidgetV3 o;
    String p;
    boolean q = true;
    boolean r;
    boolean s;
    final ArrayList<ContactItemModel> t = new ArrayList<>();
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;

    static final class i<T> implements q<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f63777a = new i();

        i() {
        }

        public final /* bridge */ /* synthetic */ boolean test(Object obj) {
            return true;
        }
    }

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public final void a(String str, io.reactivex.rxjava3.b.c cVar) {
    }

    public void an_() {
    }

    public void ap_() {
    }

    public final void ar_() {
    }

    public View b(int i2) {
        if (this.N == null) {
            this.N = new HashMap();
        }
        View view = (View) this.N.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.N.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
    }

    public void u() {
        HashMap hashMap = this.N;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.b.c$c  reason: collision with other inner class name */
    static final class C1248c extends kotlin.g.b.l implements kotlin.g.a.b<List<? extends CJRFrequentOrder>, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1248c(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends CJRFrequentOrder>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends CJRFrequentOrder> list) {
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                c.b(this.this$0);
                this.this$0.a((List<? extends CJRFrequentOrder>) (List) collection);
            }
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.b<List<? extends ContactItemModel>, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends ContactItemModel>) (List) obj);
            return x.f47997a;
        }

        public final void invoke(List<? extends ContactItemModel> list) {
            r c2;
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                List list2 = (List) collection;
                if (this.this$0.y && (c2 = this.this$0.A) != null) {
                    c2.notifyDataSetChanged();
                }
                c.b(this.this$0);
                if (!this.this$0.t.isEmpty()) {
                    this.this$0.t.clear();
                }
                this.this$0.t.addAll(list2);
                this.this$0.b((List<? extends ContactItemModel>) list2);
                c.d(this.this$0);
            }
        }
    }

    static final class g extends kotlin.g.b.l implements kotlin.g.a.b<CJRCategoryData, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCategoryData) obj);
            return x.f47997a;
        }

        public final void invoke(CJRCategoryData cJRCategoryData) {
            net.one97.paytm.recharge.mobile.d.a a2 = this.this$0.f63600h;
            if (a2 != null) {
                a2.p();
            }
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.b<LinkedList<CJRSelectedGroupItem>, x> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar) {
            super(1);
            this.this$0 = cVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((LinkedList<CJRSelectedGroupItem>) (LinkedList) obj);
            return x.f47997a;
        }

        public final void invoke(LinkedList<CJRSelectedGroupItem> linkedList) {
            if (linkedList != null && this.this$0.r) {
                this.this$0.a(linkedList);
            }
        }
    }

    static final class j<T, R> implements io.reactivex.rxjava3.d.h<T, u<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63778a;

        j(c cVar) {
            this.f63778a = cVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final String str = (String) obj;
            return y.a(new ab<IJRPaytmDataModel>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ j f63779a;

                {
                    this.f63779a = r1;
                }

                public final void subscribe(z<IJRPaytmDataModel> zVar) {
                    net.one97.paytm.recharge.common.e.a f2 = this.f63779a.f63778a.I;
                    if (f2 == null) {
                        kotlin.g.b.k.a();
                    }
                    f2.a(zVar);
                    this.f63779a.f63778a.J.post(new Runnable(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f63781a;

                        {
                            this.f63781a = r1;
                        }

                        public final void run() {
                            r c2 = this.f63781a.f63779a.f63778a.A;
                            if (c2 != null) {
                                String str = str;
                                a aVar = c.z;
                                c2.a(str, c.M);
                            }
                        }
                    });
                }
            }).e().subscribeOn(io.reactivex.rxjava3.i.a.b());
        }
    }

    public c() {
        io.reactivex.rxjava3.j.b<String> a2 = io.reactivex.rxjava3.j.b.a();
        kotlin.g.b.k.a((Object) a2, "PublishSubject.create()");
        this.H = a2;
        this.J = new Handler();
        this.K = new e(this);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = c.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJREnterMobileNumberFrag…V3::class.java.simpleName");
        L = simpleName;
    }

    public final void a(CJRRechargeErrorModel cJRRechargeErrorModel) {
        if (getActivity() != null && this.f63600h != null) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            String categoryId = aVar.r.getCategoryId();
            String str = "";
            if (categoryId == null) {
                categoryId = str;
            }
            Map hashMap = new HashMap();
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 == null) {
                kotlin.g.b.k.a();
            }
            String str2 = (String) aVar2.z.getValue();
            if (str2 != null) {
                str = str2;
            }
            hashMap.put("recharge_number", str);
            if (cJRRechargeErrorModel != null) {
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            cJRRechargeUtilities.launchDeeplinkOnRecreate(activity, categoryId, hashMap);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.s = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.e();
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.a((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar3 = this.f63599g;
        if (dVar3 != null) {
            dVar3.f();
        }
        net.one97.paytm.recharge.mobile.d dVar4 = this.f63599g;
        if (dVar4 != null) {
            dVar4.a((n) this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_fragment_enter_mobile_number, viewGroup, false);
    }

    public final void y() {
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setVisibility(8);
        }
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        if (subtitleCollapsingToolbarLayout != null) {
            subtitleCollapsingToolbarLayout.setVisibility(8);
        }
        AppBarLayout appBarLayout = (AppBarLayout) b(R.id.appbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setVisibility(8);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63776a;

        f(c cVar) {
            this.f63776a = cVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f63776a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r5 = r5.f61409b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r6 = "view"
            kotlin.g.b.k.c(r5, r6)
            int r5 = net.one97.paytm.recharge.R.id.backIv
            android.view.View r5 = r4.b((int) r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            net.one97.paytm.recharge.mobile_v3.b.c$f r6 = new net.one97.paytm.recharge.mobile_v3.b.c$f
            r6.<init>(r4)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
            net.one97.paytm.recharge.common.utils.ba r5 = new net.one97.paytm.recharge.common.utils.ba
            r6 = r4
            net.one97.paytm.recharge.common.utils.ba$a r6 = (net.one97.paytm.recharge.common.utils.ba.a) r6
            r5.<init>(r6)
            r4.k = r5
            net.one97.paytm.recharge.common.b.a r5 = r4.f63601i
            java.lang.String r6 = "context!!"
            if (r5 == 0) goto L_0x0042
            android.content.Context r0 = r4.getContext()
            if (r0 != 0) goto L_0x0030
            kotlin.g.b.k.a()
        L_0x0030:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.view.View r5 = r5.b((android.content.Context) r0)
            if (r5 == 0) goto L_0x0042
            boolean r0 = r5 instanceof net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3
            if (r0 == 0) goto L_0x0042
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r5 = (net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3) r5
            r4.a((net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3) r5)
        L_0x0042:
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            r0 = 0
            if (r5 == 0) goto L_0x0050
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
            if (r5 == 0) goto L_0x0050
            androidx.lifecycle.LiveData r5 = r5.getCategoryLiveData()
            goto L_0x0051
        L_0x0050:
            r5 = r0
        L_0x0051:
            net.one97.paytm.recharge.mobile_v3.b.c$g r1 = new net.one97.paytm.recharge.mobile_v3.b.c$g
            r1.<init>(r4)
            kotlin.g.a.b r1 = (kotlin.g.a.b) r1
            net.one97.paytm.recharge.common.utils.g.a(r4, r5, r1)
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.b((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            java.lang.String r1 = "recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r4.getContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r5.setLayoutManager(r2)
            net.one97.paytm.recharge.common.a.r r5 = new net.one97.paytm.recharge.common.a.r
            android.content.Context r2 = r4.getContext()
            if (r2 != 0) goto L_0x0081
            kotlin.g.b.k.a()
        L_0x0081:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r5.<init>(r2)
            r4.A = r5
            net.one97.paytm.recharge.common.a.r r5 = r4.A
            if (r5 == 0) goto L_0x0090
            r6 = 1
            r5.f60663g = r6
        L_0x0090:
            int r5 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r5 = r4.b((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
            net.one97.paytm.recharge.common.a.r r6 = r4.A
            androidx.recyclerview.widget.RecyclerView$a r6 = (androidx.recyclerview.widget.RecyclerView.a) r6
            r5.setAdapter(r6)
            r4.v()
            r4.A()
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x00b1
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r5 = r5.F
            r0 = r5
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
        L_0x00b1:
            net.one97.paytm.recharge.mobile_v3.b.c$h r5 = new net.one97.paytm.recharge.mobile_v3.b.c$h
            r5.<init>(r4)
            kotlin.g.a.b r5 = (kotlin.g.a.b) r5
            net.one97.paytm.recharge.common.utils.g.a(r4, r0, r5)
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r5 = r4.I
            if (r5 != 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00c4
            r5.a()
        L_0x00c4:
            net.one97.paytm.recharge.common.e.a r5 = new net.one97.paytm.recharge.common.e.a
            java.lang.String r6 = M
            r0 = r4
            net.one97.paytm.recharge.common.e.ae r0 = (net.one97.paytm.recharge.common.e.ae) r0
            r5.<init>(r6, r0)
            r4.I = r5
            net.one97.paytm.recharge.common.a.r r5 = r4.A
            if (r5 == 0) goto L_0x00d7
            r5.a((net.one97.paytm.recharge.common.e.ae) r0)
        L_0x00d7:
            io.reactivex.rxjava3.j.b<java.lang.String> r5 = r4.H
            net.one97.paytm.recharge.mobile_v3.b.c$i r6 = net.one97.paytm.recharge.mobile_v3.b.c.i.f63777a
            io.reactivex.rxjava3.d.q r6 = (io.reactivex.rxjava3.d.q) r6
            io.reactivex.rxjava3.a.p r5 = r5.filter(r6)
            net.one97.paytm.recharge.mobile_v3.b.c$j r6 = new net.one97.paytm.recharge.mobile_v3.b.c$j
            r6.<init>(r4)
            io.reactivex.rxjava3.d.h r6 = (io.reactivex.rxjava3.d.h) r6
            io.reactivex.rxjava3.a.p r5 = r5.switchMap(r6)
            io.reactivex.rxjava3.a.x r6 = io.reactivex.rxjava3.i.a.b()
            io.reactivex.rxjava3.a.p r5 = r5.subscribeOn(r6)
            io.reactivex.rxjava3.a.x r6 = io.reactivex.rxjava3.android.b.a.a()
            io.reactivex.rxjava3.a.p r5 = r5.observeOn(r6)
            net.one97.paytm.recharge.common.e.a<com.paytm.network.model.IJRPaytmDataModel> r6 = r4.I
            if (r6 != 0) goto L_0x0103
            kotlin.g.b.k.a()
        L_0x0103:
            io.reactivex.rxjava3.a.w r6 = (io.reactivex.rxjava3.a.w) r6
            r5.subscribe(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void a(List<? extends CJRFrequentOrder> list) {
        List<? extends CJRFrequentOrder> list2;
        kotlin.g.b.k.c(list, "recents");
        if (!this.y) {
            int size = list.size();
            int i2 = this.G;
            List<? extends CJRFrequentOrder> b2 = size > i2 ? kotlin.a.k.b(list, i2) : list;
            r rVar = this.A;
            if (rVar != null) {
                CJRRecentOrderV8.a a2 = new CJRRecentOrderV8.a().a(b2).a(CJRRecentOrderV8.b.MOBILE_V3.ordinal());
                a2.f61927e = this;
                a2.f61928f = this;
                a2.f61929g = this;
                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                CJRRecentOrderV8.a a3 = a2.a(childFragmentManager);
                kotlin.g.b.k.c(list, "recents");
                kotlin.g.b.k.c(a3, "options");
                rVar.f60657a = list;
                if (rVar.f60661e == null) {
                    rVar.f60661e = new ArrayList<>();
                }
                if (rVar.f60662f == null) {
                    rVar.f60662f = new ArrayList<>();
                }
                List<CJRFrequentOrder> list3 = a3.f61931i;
                if (list3 != null) {
                    ArrayList<Object> arrayList = rVar.f60661e;
                    if (arrayList != null && (!arrayList.isEmpty()) && (list2 = rVar.f60657a) != null && (!list2.isEmpty())) {
                        ArrayList<Object> arrayList2 = rVar.f60662f;
                        if (arrayList2 != null) {
                            arrayList2.add((byte) 1);
                        }
                        ArrayList<Object> arrayList3 = rVar.f60661e;
                        if (arrayList3 != null) {
                            arrayList3.add((byte) 1);
                        }
                    }
                    String string = rVar.f60665i.getString(R.string.recent);
                    kotlin.g.b.k.a((Object) string, "context.getString(R.string.recent)");
                    ArrayList<Object> arrayList4 = rVar.f60662f;
                    if (arrayList4 != null) {
                        arrayList4.add(string);
                    }
                    ArrayList<Object> arrayList5 = rVar.f60661e;
                    if (arrayList5 != null) {
                        arrayList5.add(string);
                    }
                    ArrayList<Object> arrayList6 = rVar.f60661e;
                    if (arrayList6 != null) {
                        arrayList6.addAll(list3);
                    }
                    ArrayList<Object> arrayList7 = rVar.f60662f;
                    if (arrayList7 != null) {
                        arrayList7.addAll(list3);
                    }
                    if (rVar.f60661e != null) {
                        ArrayList<Object> arrayList8 = rVar.f60661e;
                        if (arrayList8 == null) {
                            kotlin.g.b.k.a();
                        }
                        rVar.notifyItemRangeChanged(arrayList8.size() - 1, list3.size());
                    }
                }
                rVar.f60658b = new p(a3);
            }
        }
    }

    public void b(List<? extends ContactItemModel> list) {
        kotlin.g.b.k.c(list, Tables.CONTACTS);
        r rVar = this.A;
        if (rVar != null) {
            CJRContactListV8.a aVar = new CJRContactListV8.a();
            String string = getString(R.string.from_your_contacts);
            kotlin.g.b.k.a((Object) string, "getString(R.string.from_your_contacts)");
            CJRContactListV8.a a2 = aVar.a(string).a(list);
            a2.f61862c = this;
            rVar.a(list, a2);
        }
    }

    public boolean a(String str, CJRRelatedCategory cJRRelatedCategory) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        kotlin.g.b.k.c(str, "tag");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setErrorType(ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.RC_CHANGED.name());
        }
        if (cJRRelatedCategory == null) {
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 != null) {
                net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                if (aVar3 == null) {
                    kotlin.g.b.k.a();
                }
                aVar2.a("get.rc.category", aVar3.r.getCategoryId(), (ai) aVar2, (net.one97.paytm.recharge.common.b.a.a) aVar2, (Object) a2);
            }
            return true;
        }
        String url = cJRRelatedCategory.getUrl();
        if (!(url == null || !net.one97.paytm.recharge.common.utils.g.c(url) || (aVar = this.f63600h) == null)) {
            String url2 = cJRRelatedCategory.getUrl();
            if (url2 == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.a("get.rc.category", url2, (Object) a2, (ai) null, (net.one97.paytm.recharge.common.b.a.a) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x00b6
            boolean r1 = r5.isEmpty()
            if (r1 != 0) goto L_0x00b6
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r1 = r4.o
            if (r1 == 0) goto L_0x0010
            r1.c((boolean) r0)
        L_0x0010:
            r4.B()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0019:
            boolean r1 = r5.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r5.next()
            net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem r1 = (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r1
            net.one97.paytm.recharge.model.v4.CJRAggsItem r3 = r1.getItem()
            if (r3 == 0) goto L_0x0030
            java.lang.String r2 = r3.getRegEx()
        L_0x0030:
            boolean r2 = net.one97.paytm.recharge.common.utils.g.c(r2)
            if (r2 == 0) goto L_0x0019
            net.one97.paytm.recharge.model.v4.CJRInputFieldsItem r2 = r4.n
            if (r2 == 0) goto L_0x0019
            net.one97.paytm.recharge.model.v4.CJRAggsItem r1 = r1.getItem()
            if (r1 != 0) goto L_0x0043
            kotlin.g.b.k.a()
        L_0x0043:
            java.lang.String r1 = r1.getRegEx()
            r2.setRegex(r1)
            goto L_0x0019
        L_0x004b:
            r4.r = r0
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x0056
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r5 = r5.j()
            goto L_0x0057
        L_0x0056:
            r5 = r2
        L_0x0057:
            if (r5 == 0) goto L_0x006a
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x0068
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r5 = r5.j()
            if (r5 == 0) goto L_0x0068
            java.lang.String r5 = r5.getRechargeNumber()
            goto L_0x0089
        L_0x0068:
            r5 = r2
            goto L_0x0089
        L_0x006a:
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x0071
            net.one97.paytm.recharge.model.ContactItemModel r5 = r5.C
            goto L_0x0072
        L_0x0071:
            r5 = r2
        L_0x0072:
            if (r5 == 0) goto L_0x0081
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x0068
            net.one97.paytm.recharge.model.ContactItemModel r5 = r5.C
            if (r5 == 0) goto L_0x0068
            java.lang.String r5 = r5.getPhnNo()
            goto L_0x0089
        L_0x0081:
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r5 = r4.o
            if (r5 == 0) goto L_0x0068
            java.lang.String r5 = r5.getInputText()
        L_0x0089:
            net.one97.paytm.recharge.common.b.a r1 = r4.f63601i
            if (r1 == 0) goto L_0x00a5
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r1 = r4.o
            if (r1 != 0) goto L_0x0094
            kotlin.g.b.k.a()
        L_0x0094:
            android.view.View r1 = (android.view.View) r1
            if (r5 != 0) goto L_0x009a
            java.lang.String r5 = ""
        L_0x009a:
            r3 = 1
            boolean r5 = net.one97.paytm.recharge.common.b.a.a((android.view.View) r1, (java.lang.String) r5, (boolean) r3)
            if (r5 != r3) goto L_0x00a5
            r4.w()
            return
        L_0x00a5:
            r4.u = r0
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x00ae
            r5.k()
        L_0x00ae:
            net.one97.paytm.recharge.mobile.d.a r5 = r4.f63600h
            if (r5 == 0) goto L_0x00b5
            r5.a((java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>) r2)
        L_0x00b5:
            return
        L_0x00b6:
            r4.u = r0
            r4.e("")
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.a(java.util.LinkedList):void");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63775a;

        e(c cVar) {
            this.f63775a = cVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            kotlin.g.b.k.a((Object) view, "it");
            if (!eVar.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                this.f63775a.G();
                try {
                    this.f63775a.g("default_flow");
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a(CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3) {
        kotlin.g.b.k.c(cJRMobileInputFieldWidgetV3, "view");
        this.o = cJRMobileInputFieldWidgetV3;
        cJRMobileInputFieldWidgetV3.setFocusOutColor(R.color.white);
        FrameLayout frameLayout = (FrameLayout) cJRMobileInputFieldWidgetV3.a(R.id.lyt_divider);
        kotlin.g.b.k.a((Object) frameLayout, "lyt_divider");
        frameLayout.setVisibility(8);
        cJRMobileInputFieldWidgetV3.setInputHintTextColor(R.color.v3_text_3);
        cJRMobileInputFieldWidgetV3.f();
        cJRMobileInputFieldWidgetV3.requestFocus();
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
        if (cJRMobileInputFieldWidgetV32 != null) {
            cJRMobileInputFieldWidgetV32.c(R.drawable.ic_grey_rounded_cross, new b(this));
        }
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
        if (cJRMobileInputFieldWidgetV33 != null) {
            cJRMobileInputFieldWidgetV33.setSecondaryIconVisibility(8);
        }
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV34 = this.o;
        if (cJRMobileInputFieldWidgetV34 != null) {
            cJRMobileInputFieldWidgetV34.setDividerColor(R.color.white);
        }
        cJRMobileInputFieldWidgetV3.setMInputFieldTextChangeListener(this);
        if (cJRMobileInputFieldWidgetV3.getTag() instanceof a.C1172a) {
            Object tag = cJRMobileInputFieldWidgetV3.getTag();
            if (tag != null) {
                a.C1172a aVar = (a.C1172a) tag;
                if (aVar.f60877c instanceof CJRInputFieldsItem) {
                    this.n = (CJRInputFieldsItem) aVar.f60877c;
                    CJRInputFieldsItem cJRInputFieldsItem = this.n;
                    if (cJRInputFieldsItem != null && cJRInputFieldsItem.isShowPhoneBook()) {
                        C();
                    }
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            cJRMobileInputFieldWidgetV3.setTransitionName(getString(R.string.transition_name_input_field_with_action));
        }
        LinearLayout linearLayout = (LinearLayout) b(R.id.toolbarLL);
        if (linearLayout != null) {
            linearLayout.addView(cJRMobileInputFieldWidgetV3);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63774a;

        b(c cVar) {
            this.f63774a = cVar;
        }

        public final void onClick(View view) {
            this.f63774a.x();
        }
    }

    /* access modifiers changed from: private */
    public final void x() {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.setInputText("");
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.k();
        }
        FragmentActivity activity = getActivity();
        CJRRechargeEditText cJRRechargeEditText = null;
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (inputMethodManager != null) {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRRechargeEditText = cJRMobileInputFieldWidgetV32.getInputView();
            }
            inputMethodManager.showSoftInput(cJRRechargeEditText, 1);
        }
    }

    public final void C() {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.b(R.drawable.ic_contacts_v8, this.K);
        }
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
        ViewGroup.LayoutParams layoutParams = null;
        ImageView actionPrimaryIcon = cJRMobileInputFieldWidgetV32 != null ? cJRMobileInputFieldWidgetV32.getActionPrimaryIcon() : null;
        if (actionPrimaryIcon != null) {
            layoutParams = actionPrimaryIcon.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = com.paytm.utility.b.c(20);
        }
        if (layoutParams != null) {
            layoutParams.height = com.paytm.utility.b.c(20);
        }
        if (actionPrimaryIcon != null) {
            actionPrimaryIcon.setLayoutParams(layoutParams);
        }
    }

    public boolean a(int i2, int i3, Intent intent) {
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        Object obj;
        if (i2 != 100) {
            if (i2 == 607) {
                if (!super.a(i2, i3, intent)) {
                    D();
                }
                return true;
            } else if (i2 == 4568 && i3 == 212 && intent != null && intent.hasExtra(com.paytm.utility.e.aG)) {
                Serializable serializableExtra = intent.getSerializableExtra(com.paytm.utility.e.aG);
                int intExtra = intent.getIntExtra("contactPos", 0);
                if (serializableExtra instanceof ContactItemModel) {
                    a((ContactItemModel) serializableExtra, intExtra, true);
                }
            }
        } else if (i3 == -1) {
            net.one97.paytm.recharge.common.utils.n nVar = net.one97.paytm.recharge.common.utils.n.f61679a;
            List<ContactItemModel> a2 = net.one97.paytm.recharge.common.utils.n.a((Context) getActivity(), intent);
            int intExtra2 = intent != null ? intent.getIntExtra("contactPos", -1) : -1;
            if (!(a2 != null ? a2.isEmpty() : true) && intExtra2 != -1) {
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                a(a2.get(0), intExtra2, true);
            } else if (getContext() != null) {
                az azVar = az.f61525a;
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                az.a(context, ERROR_TYPE.UNDEFINED, ACTION_TYPE.CTA_CONTACT, (String) null, getString(R.string.invalid_mobileno_msg), 8);
            }
        } else if (!(i3 != 0 || (aVar = this.f63600h) == null || (dVar = aVar.v) == null)) {
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 != null) {
                obj = aVar2.e();
            } else {
                obj = null;
            }
            Object obj2 = obj;
            if (obj2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "phonebook_back_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
        return super.a(i2, i3, intent);
    }

    public void D() {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.OPERATOR_SELECTION_FAIL);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(211);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.C) {
            this.C = false;
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
            if (cJRMobileInputFieldWidgetV3 != null) {
                cJRMobileInputFieldWidgetV3.requestFocus();
            }
        }
        E();
    }

    public void E() {
        if (this.s && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).e();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((net.one97.paytm.recharge.common.e.y) activity2).i();
                    this.F = true;
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void w() {
        this.u = false;
        HashMap hashMap = new HashMap(1);
        int i2 = Build.VERSION.SDK_INT;
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((Map<String, ? extends View>) hashMap);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.HashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G() {
        /*
            r6 = this;
            r6.j()
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r6.o
            if (r0 == 0) goto L_0x000a
            r0.clearFocus()
        L_0x000a:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CONTACT_ACTION_CLICK
            r1 = 0
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x0023
            androidx.lifecycle.y<java.lang.Boolean> r0 = r0.K
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r0.getValue()
            r1 = r0
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x0023:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0074
            r0 = 1
            r6.C = r0
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r1 = r6.o
            if (r1 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            android.view.View r1 = (android.view.View) r1
            java.lang.String r2 = "view"
            kotlin.g.b.k.c(r1, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>(r0)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x005d
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x005c }
            java.lang.String r4 = androidx.core.h.u.x(r1)     // Catch:{ Exception -> 0x005c }
            if (r4 != 0) goto L_0x0053
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x005c }
        L_0x0053:
            java.lang.String r5 = "ViewCompat.getTransitionName(view)!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x005c }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x005c }
            goto L_0x005d
        L_0x005c:
        L_0x005d:
            net.one97.paytm.recharge.mobile.d r1 = r6.f63599g
            if (r1 == 0) goto L_0x0073
            java.util.Map r2 = (java.util.Map) r2
            r3 = r6
            net.one97.paytm.recharge.common.a.h$c r3 = (net.one97.paytm.recharge.common.a.h.c) r3
            boolean r4 = r6.F
            if (r4 != 0) goto L_0x006f
            boolean r4 = r6.s
            if (r4 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            r1.a(r2, r3, r0)
        L_0x0073:
            return
        L_0x0074:
            boolean r0 = com.paytm.utility.s.a()
            if (r0 == 0) goto L_0x0085
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r1 = 53
            r6.requestPermissions(r0, r1)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.G():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r3 = r3.f61413f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r2, java.lang.String[] r3, int[] r4) {
        /*
            r1 = this;
            java.lang.String r0 = "permissions"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "grantResults"
            kotlin.g.b.k.c(r4, r0)
            r0 = 53
            if (r2 != r0) goto L_0x0082
            boolean r2 = com.paytm.utility.s.a((int[]) r4)
            r0 = 0
            if (r2 == 0) goto L_0x005c
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CONTACT_PERMISSION_GRANTED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2)
            net.one97.paytm.recharge.mobile.d.a r2 = r1.f63600h
            r3 = 1
            if (r2 == 0) goto L_0x0024
            r2.a((boolean) r3)
        L_0x0024:
            r1.G()
            r1.y = r3
            net.one97.paytm.recharge.mobile.d.a r2 = r1.f63600h
            if (r2 == 0) goto L_0x005b
            net.one97.paytm.recharge.common.b.c r2 = r2.s
            if (r2 == 0) goto L_0x005b
            boolean r2 = r2.a()
            if (r2 != r3) goto L_0x0085
            r1.A()
            net.one97.paytm.recharge.mobile.d.a r2 = r1.f63600h
            if (r2 == 0) goto L_0x005b
            net.one97.paytm.recharge.mobile.d.a r3 = r1.f63600h
            if (r3 == 0) goto L_0x004f
            androidx.lifecycle.y<java.lang.String> r3 = r3.f61413f
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x004f
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x0050
        L_0x004f:
            r3 = r0
        L_0x0050:
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r0 = "frequent_api"
            r2.a((java.lang.String) r0, (java.lang.String) r3, (java.lang.Object) r4)
        L_0x005b:
            return
        L_0x005c:
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CONTACT_PERMISSION_DENIED
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2)
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            android.app.Activity r2 = (android.app.Activity) r2
            java.lang.String r0 = "android.permission.READ_CONTACTS"
            int r2 = com.paytm.utility.s.a(r3, r4, r0, r2)
            if (r2 != 0) goto L_0x0081
            android.content.Context r2 = r1.getContext()
            if (r2 == 0) goto L_0x0081
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.recharge.common.utils.az.g(r2)
        L_0x0081:
            return
        L_0x0082:
            super.onRequestPermissionsResult(r2, r3, r4)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r2.D.containsKey(r5) == true) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "mobileNumber"
            kotlin.g.b.k.c(r5, r0)
            r1 = 1
            r4.r = r1
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            r3 = 0
            if (r2 == 0) goto L_0x0012
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r2 = r2.j()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            if (r2 != 0) goto L_0x0037
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            if (r2 == 0) goto L_0x001c
            net.one97.paytm.recharge.model.ContactItemModel r2 = r2.C
            goto L_0x001d
        L_0x001c:
            r2 = r3
        L_0x001d:
            if (r2 != 0) goto L_0x0037
            net.one97.paytm.recharge.mobile.d.a r2 = r4.f63600h
            if (r2 == 0) goto L_0x002f
            kotlin.g.b.k.c(r5, r0)
            java.util.HashMap<java.lang.String, net.one97.paytm.recharge.common.utils.ac> r0 = r2.D
            boolean r0 = r0.containsKey(r5)
            if (r0 != r1) goto L_0x002f
            goto L_0x0037
        L_0x002f:
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r4.o
            if (r0 == 0) goto L_0x0055
            r0.c((boolean) r1)
            goto L_0x0055
        L_0x0037:
            boolean r0 = r4 instanceof net.one97.paytm.recharge.mobile_v3.b.h
            if (r0 == 0) goto L_0x004d
            net.one97.paytm.recharge.mobile.d.a r0 = r4.f63600h
            if (r0 == 0) goto L_0x0042
            net.one97.paytm.recharge.model.ContactItemModel r0 = r0.C
            goto L_0x0043
        L_0x0042:
            r0 = r3
        L_0x0043:
            if (r0 == 0) goto L_0x004d
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r4.o
            if (r0 == 0) goto L_0x0055
            r0.c((boolean) r1)
            goto L_0x0055
        L_0x004d:
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r4.o
            if (r0 == 0) goto L_0x0055
            r1 = 0
            r0.c((boolean) r1)
        L_0x0055:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.FETCH_MNP
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r3, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            super.a(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.a(java.lang.String, java.lang.String):void");
    }

    public void a(CharSequence charSequence, int i2, int i3, int i4) {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null && cJRMobileInputFieldWidgetV3.f61894e) {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.c(false);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                aVar.n();
            }
        }
    }

    public void F() {
        View b2;
        RecyclerView recyclerView;
        String str;
        CJRFrequentOrder cJRFrequentOrder;
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        Object obj;
        Object e2;
        LiveData liveData;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        List list = null;
        String inputText = cJRMobileInputFieldWidgetV3 != null ? cJRMobileInputFieldWidgetV3.getInputText() : null;
        boolean z2 = false;
        if (!TextUtils.isEmpty(inputText)) {
            RecyclerView recyclerView2 = (RecyclerView) b(R.id.alphabetRV);
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
            View b3 = b(R.id.dummySpaceView);
            if (b3 != null) {
                b3.setVisibility(8);
            }
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.setSecondaryIconVisibility(0);
            }
            String str2 = this.p;
            if (str2 != null) {
                z2 = str2.equals(inputText);
            }
            if (!z2) {
                this.H.onNext(String.valueOf(inputText));
                b(inputText, "via_edit");
                return;
            }
            if (this.f63601i != null) {
                if (inputText == null) {
                    kotlin.g.b.k.a();
                }
                str = net.one97.paytm.recharge.common.b.a.a(inputText);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                a(str, "manual entry");
                if (!this.x) {
                    net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                    if (aVar2 != null) {
                        cJRFrequentOrder = aVar2.j();
                    } else {
                        cJRFrequentOrder = null;
                    }
                    if (cJRFrequentOrder == null) {
                        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                        if (!(aVar3 == null || (liveData = aVar3.f61414g) == null)) {
                            list = (List) liveData.getValue();
                        }
                        if (az.a(str, (List<? extends CJRFrequentOrder>) list) && (aVar = this.f63600h) != null && (dVar = aVar.v) != null) {
                            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                            if (aVar4 == null || (e2 = aVar4.e()) == null) {
                                obj = "";
                            } else {
                                obj = e2;
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "repeat_user_entering_mobile_number", (Object) null, "manual entry", (Object) null, (Object) null, (Object) null, 116);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
        if (cJRMobileInputFieldWidgetV33 != null) {
            cJRMobileInputFieldWidgetV33.setSecondaryIconVisibility(8);
        }
        if ((!this.t.isEmpty()) && (recyclerView = (RecyclerView) b(R.id.alphabetRV)) != null) {
            recyclerView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(getContext())) && (b2 = b(R.id.dummySpaceView)) != null) {
            b2.setVisibility(0);
        }
        this.H.onNext("");
    }

    private final void c(String str, String str2) {
        View b2;
        RecyclerView recyclerView;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str)) {
            RecyclerView recyclerView2 = (RecyclerView) b(R.id.alphabetRV);
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
            View b3 = b(R.id.dummySpaceView);
            if (b3 != null) {
                b3.setVisibility(8);
            }
            String str3 = this.p;
            if (str3 != null) {
                z2 = str3.equals(str);
            }
            if (!z2) {
                this.H.onNext(str);
                b(str, "via_edit");
                return;
            }
            String a2 = this.f63601i != null ? net.one97.paytm.recharge.common.b.a.a(str) : null;
            if (!TextUtils.isEmpty(a2)) {
                if (a2 == null) {
                    kotlin.g.b.k.a();
                }
                a(a2, str2);
                return;
            }
            return;
        }
        if ((!this.t.isEmpty()) && (recyclerView = (RecyclerView) b(R.id.alphabetRV)) != null) {
            recyclerView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(getContext())) && (b2 = b(R.id.dummySpaceView)) != null) {
            b2.setVisibility(0);
        }
        this.H.onNext("");
    }

    public final void a(ContactItemModel contactItemModel, int i2, boolean z2) {
        kotlin.g.b.k.c(contactItemModel, "contact");
        this.p = contactItemModel.getPhnNo();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        Object obj = null;
        if (aVar != null) {
            aVar.a((CJRProductsItem) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a((CJRFrequentOrder) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            aVar3.C = contactItemModel;
        }
        this.q = false;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.setInputText("");
        }
        this.q = true;
        if (this instanceof h) {
            if (z2) {
                this.v = true;
                this.w = false;
            } else {
                this.w = true;
                this.v = false;
            }
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.a(this.p);
            }
        } else {
            String str = this.p;
            if (str == null) {
                str = "";
            }
            c(str, z2 ? "phonebook" : "contact screen");
        }
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        if (aVar4 != null) {
            net.one97.paytm.recharge.ordersummary.h.d dVar = aVar4.v;
            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
            if (aVar5 != null) {
                obj = aVar5.e();
            }
            Object obj2 = obj;
            if (obj2 == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "phonebook_contact_selected", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            if (getActivity() != null && !TextUtils.isEmpty(com.paytm.utility.b.l((Context) getActivity())) && kotlin.m.p.a(this.p, com.paytm.utility.b.l(getContext()), true)) {
                h("default_flow");
            }
        }
    }

    public void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.DELETE_RECENT_CLICK);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.DELETE_RECENT.name());
            }
            aVar.a("delete_recents", cJRFrequentOrder, (Object) a2);
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "clear_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder r12, int r13) {
        /*
            r11 = this;
            java.lang.String r0 = "item"
            kotlin.g.b.k.c(r12, r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.SETUP_AUTOMATIC_CLICK
            r1 = 0
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            r11.E = r12
            net.one97.paytm.recharge.mobile.d.a r0 = r11.f63600h
            if (r0 == 0) goto L_0x0027
            net.one97.paytm.recharge.ordersummary.h.d r2 = r0.v
            java.lang.Object r3 = r0.e()
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 112(0x70, float:1.57E-43)
            java.lang.String r4 = "setup_autopay_clicked"
            java.lang.String r5 = ""
            java.lang.String r6 = "ellipses menu"
            net.one97.paytm.recharge.ordersummary.h.d.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0027:
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x008b
            net.one97.paytm.recharge.common.utils.e r0 = new net.one97.paytm.recharge.common.utils.e
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()
            if (r2 != 0) goto L_0x003e
            kotlin.g.b.k.a()
        L_0x003e:
            java.lang.String r3 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = r2
            android.app.Activity r3 = (android.app.Activity) r3
            java.util.Map r2 = r12.getConfiguration()
            if (r2 == 0) goto L_0x0056
            java.lang.String r12 = r12.TAG_RECHARGE_NUMBER
            java.lang.Object r12 = r2.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            r4 = r12
            goto L_0x0057
        L_0x0056:
            r4 = r1
        L_0x0057:
            if (r4 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            androidx.fragment.app.j r5 = r11.getChildFragmentManager()
            java.lang.String r12 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            net.one97.paytm.recharge.mobile.d.a r12 = r11.f63600h
            if (r12 == 0) goto L_0x0077
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r12 = r12.f61409b
            if (r12 == 0) goto L_0x0077
            net.one97.paytm.recharge.model.v4.CJRCategoryData r12 = r12.getCategoryData()
            if (r12 == 0) goto L_0x0077
            java.lang.Long r1 = r12.getCategoryId()
        L_0x0077:
            r6 = r1
            r7 = r11
            net.one97.paytm.recharge.common.utils.e$a r7 = (net.one97.paytm.recharge.common.utils.e.a) r7
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r11.D = r0
            net.one97.paytm.recharge.common.utils.e r12 = r11.D
            if (r12 != 0) goto L_0x0088
            kotlin.g.b.k.a()
        L_0x0088:
            r12.f61622g = r13
            return
        L_0x008b:
            android.content.Context r12 = r11.getContext()
            android.content.Context r13 = r11.getContext()
            if (r13 == 0) goto L_0x00a2
            android.content.res.Resources r13 = r13.getResources()
            if (r13 == 0) goto L_0x00a2
            int r0 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r13 = r13.getString(r0)
            goto L_0x00a3
        L_0x00a2:
            r13 = r1
        L_0x00a3:
            android.content.Context r0 = r11.getContext()
            if (r0 == 0) goto L_0x00b5
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x00b5
            int r1 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r1 = r0.getString(r1)
        L_0x00b5:
            com.paytm.utility.g.c(r12, r13, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.b(net.one97.paytm.common.entity.recharge.CJRFrequentOrder, int):void");
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        kotlin.g.b.k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.MANAGE_AUTOMATIC_CLICK);
        Bundle bundle = new Bundle();
        bundle.putInt("key_position", i2);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a((Fragment) this, cJRFrequentOrder, cJRAutomaticSubscriptionItemModel, bundle);
        }
    }

    public void c(CJRFrequentOrder cJRFrequentOrder, int i2) {
        Integer num;
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.RECENT_CLICK);
        if (this.u) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                num = aVar.W;
            } else {
                num = null;
            }
            if (num == null || i2 != num.intValue()) {
                B();
            }
        }
        if (getActivity() instanceof net.one97.paytm.recharge.common.e.y) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).j();
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
        this.u = true;
        this.p = cJRFrequentOrder.getRechargeNumber();
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a((CJRProductsItem) null);
        }
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            aVar3.a(cJRFrequentOrder);
        }
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        if (aVar4 != null) {
            aVar4.C = null;
        }
        net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
        if (aVar5 != null) {
            aVar5.W = Integer.valueOf(i2);
        }
        this.q = false;
        this.q = true;
        String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
        kotlin.g.b.k.a((Object) rechargeNumber, "item.rechargeNumber");
        c(rechargeNumber, (String) null);
        f("default_flow");
    }

    public final void b_(String str) {
        super.b_(str);
        this.p = str;
        this.q = false;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.setInputText("");
        }
        this.q = true;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
        if (cJRMobileInputFieldWidgetV32 != null) {
            cJRMobileInputFieldWidgetV32.a(str);
        }
    }

    public final void as_() {
        super.as_();
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (net.one97.paytm.recharge.common.utils.g.c(cJRMobileInputFieldWidgetV3 != null ? cJRMobileInputFieldWidgetV3.getInputText() : null)) {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 == null) {
                kotlin.g.b.k.a();
            }
            a(cJRMobileInputFieldWidgetV32.getInputText(), "manual entry");
        }
    }

    public final void g() {
        if (this.s && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).g();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public final void h() {
        if (this.s && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).h();
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public void onClick(View view) {
        if (view != null) {
            Integer.valueOf(view.getId());
        }
    }

    public void l() {
        super.l();
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.c(false);
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63782a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f63783b;

        k(c cVar, androidx.appcompat.app.c cVar2) {
            this.f63782a = cVar;
            this.f63783b = cVar2;
        }

        public final void onClick(View view) {
            this.f63783b.dismiss();
            new Handler().postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f63784a;

                {
                    this.f63784a = r1;
                }

                public final void run() {
                    FragmentActivity activity = this.f63784a.f63782a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }, 100);
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f63785a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f63786b;

        l(c cVar, androidx.appcompat.app.c cVar2) {
            this.f63785a = cVar;
            this.f63786b = cVar2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
            r4 = r4.y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                androidx.appcompat.app.c r0 = r3.f63786b
                r0.dismiss()
                net.one97.paytm.recharge.widgets.c.e r0 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
                java.lang.String r1 = "it"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
                net.one97.paytm.recharge.widgets.c.e r1 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
                int r1 = r1.getDELAY_1000_MILLI()
                boolean r4 = r0.validateIsAlreadyClicked(r4, r1)
                if (r4 != 0) goto L_0x0049
                net.one97.paytm.recharge.mobile_v3.b.c r4 = r3.f63785a
                net.one97.paytm.recharge.mobile.d.a r4 = r4.f63600h
                if (r4 == 0) goto L_0x002d
                androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r4 = r4.y
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x002d
                java.lang.Object r4 = r4.getValue()
                net.one97.paytm.recharge.model.v4.CJRRelatedCategory r4 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r4
                goto L_0x002e
            L_0x002d:
                r4 = 0
            L_0x002e:
                net.one97.paytm.recharge.mobile_v3.b.c r0 = r3.f63785a
                java.lang.String r1 = "get.rc.category"
                boolean r4 = r0.a((java.lang.String) r1, (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r4)
                if (r4 != 0) goto L_0x0049
                android.os.Handler r4 = new android.os.Handler
                r4.<init>()
                net.one97.paytm.recharge.mobile_v3.b.c$l$1 r0 = new net.one97.paytm.recharge.mobile_v3.b.c$l$1
                r0.<init>(r3)
                java.lang.Runnable r0 = (java.lang.Runnable) r0
                r1 = 100
                r4.postDelayed(r0, r1)
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.c.l.onClick(android.view.View):void");
        }
    }

    public void a(String str, NetworkCustomError networkCustomError, Object obj) {
        Fragment c2;
        if (getActivity() != null && isAdded()) {
            if (networkCustomError instanceof an) {
                if (!(((an) networkCustomError).getError() instanceof as) || com.paytm.utility.b.c(getContext())) {
                    net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                    if (aVar != null) {
                        aVar.E = false;
                    }
                    if (getActivity() != null && isAdded() && getFragmentManager() != null) {
                        Context context = getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        c.a aVar2 = new c.a(context);
                        View inflate = getLayoutInflater().inflate(R.layout.no_internet_retry_dialog, (ViewGroup) null);
                        aVar2.a(inflate);
                        aVar2.a(false);
                        androidx.appcompat.app.c a2 = aVar2.a();
                        kotlin.g.b.k.a((Object) a2, "dialogBuilder.create()");
                        View findViewById = inflate.findViewById(R.id.title);
                        kotlin.g.b.k.a((Object) findViewById, "(dialogView.findViewById<View>(R.id.title))");
                        findViewById.setVisibility(8);
                        View findViewById2 = inflate.findViewById(R.id.message);
                        kotlin.g.b.k.a((Object) findViewById2, "(dialogView.findViewById<TextView>(R.id.message))");
                        ((TextView) findViewById2).setText(getString(R.string.v3_error_fetch_category));
                        TextView textView = (TextView) inflate.findViewById(R.id.btn_back);
                        kotlin.g.b.k.a((Object) textView, "backBtn");
                        textView.setText(getString(R.string.cancel_option_str));
                        textView.setOnClickListener(new k(this, a2));
                        TextView textView2 = (TextView) inflate.findViewById(R.id.btn_retry);
                        kotlin.g.b.k.a((Object) textView2, "retryBtn");
                        textView2.setText(getString(R.string.v3_error_fetch_category_action_retry));
                        textView2.setOnClickListener(new l(this, a2));
                        a2.show();
                    }
                }
            } else if (networkCustomError instanceof aq) {
                if (obj instanceof CJRRechargeErrorModel) {
                    aq aqVar = (aq) networkCustomError;
                    if (aqVar.getError() instanceof net.one97.paytm.recharge.common.utils.c) {
                        CRUFlowModel flowName = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.AUTH.name());
                        }
                    } else if (aqVar.getError() instanceof as) {
                        CRUFlowModel flowName2 = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName2 != null) {
                            flowName2.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                        }
                    } else {
                        CRUFlowModel flowName3 = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName3 != null) {
                            flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                    }
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    cJRRechargeErrorModel.setUserFacing(a.b.SILENT);
                    az azVar = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                }
                net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
                if (dVar != null && (c2 = dVar.c()) != null) {
                    String str2 = "";
                    if (c2 instanceof h) {
                        h hVar = (h) c2;
                        if (hVar.f63600h != null) {
                            net.one97.paytm.recharge.mobile.d.a aVar3 = hVar.f63600h;
                            if (aVar3 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (aVar3.j() != null) {
                                if (hVar.f63601i != null) {
                                    if (hVar.f63601i == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    str2 = net.one97.paytm.recharge.common.b.a.a(((aq) networkCustomError).getMobileNumber());
                                }
                                hVar.c(str2);
                                return;
                            }
                        }
                        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = hVar.o;
                        if (cJRMobileInputFieldWidgetV3 != null) {
                            cJRMobileInputFieldWidgetV3.c(false);
                        }
                        hVar.B();
                        hVar.e("");
                    } else if (c2 instanceof c) {
                        c cVar = (c) c2;
                        if (cVar.f63600h != null) {
                            net.one97.paytm.recharge.mobile.d.a aVar4 = cVar.f63600h;
                            if (aVar4 == null) {
                                kotlin.g.b.k.a();
                            }
                            if (aVar4.j() != null) {
                                if (cVar.f63601i != null) {
                                    if (cVar.f63601i == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    str2 = net.one97.paytm.recharge.common.b.a.a(((aq) networkCustomError).getMobileNumber());
                                }
                                cVar.c(str2);
                                return;
                            }
                        }
                        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = cVar.o;
                        if (cJRMobileInputFieldWidgetV32 != null) {
                            cJRMobileInputFieldWidgetV32.c(false);
                        }
                        cVar.B();
                        cVar.e("");
                    }
                }
            } else {
                super.a(str, networkCustomError, obj);
            }
        }
    }

    public void onStop() {
        Boolean bool;
        LiveData liveData;
        super.onStop();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData = aVar.H) == null || (bool = (Boolean) liveData.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE) && this.o != null) {
            FragmentActivity activity = getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
                if (cJRMobileInputFieldWidgetV3 == null) {
                    kotlin.g.b.k.a();
                }
                inputMethodManager.hideSoftInputFromWindow(cJRMobileInputFieldWidgetV3.getWindowToken(), 0);
            }
        }
    }

    public void onDestroyView() {
        j();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.n();
        }
        if (this.s && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                net.one97.paytm.recharge.common.e.y yVar = (net.one97.paytm.recharge.common.e.y) activity;
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    yVar.b(activity2.getResources().getString(R.string.recharge_tabs_toolbar_title));
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        ((net.one97.paytm.recharge.common.e.y) activity3).az_();
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type android.content.Context");
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
        }
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((net.one97.paytm.recharge.common.e.p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.b((n) this);
        }
        super.onDestroyView();
        r rVar = this.A;
        if (rVar != null) {
            rVar.f60657a = null;
            rVar.f60658b = null;
            rVar.f60659c = null;
            rVar.f60660d = null;
            ArrayList<Object> arrayList = rVar.f60661e;
            if (arrayList != null) {
                arrayList.clear();
            }
            rVar.f60661e = null;
            ArrayList<Object> arrayList2 = rVar.f60662f;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            rVar.f60662f = null;
            rVar.f60664h = null;
        }
        this.A = null;
        this.n = null;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.a();
        }
        this.o = null;
        this.p = null;
        net.one97.paytm.recharge.common.utils.e eVar = this.D;
        if (eVar != null) {
            eVar.f61616a = null;
            eVar.f61617b = null;
            eVar.f61618c = null;
            eVar.f61619d = null;
            eVar.f61620e = null;
            eVar.f61621f = null;
            eVar.f61623h = null;
        }
        this.D = null;
        this.E = null;
        u();
    }

    public void aq_() {
        net.one97.paytm.recharge.common.utils.e eVar;
        String str;
        int i2;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String str2 = null;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.PERFORM_AUTO_PAY_VERIFY_CALL);
        if (this.E != null && (eVar = this.D) != null && (str = eVar.f61619d) != null) {
            CJRFrequentOrder cJRFrequentOrder = this.E;
            if (cJRFrequentOrder != null) {
                str2 = cJRFrequentOrder.getRechargeNumber();
            }
            if (kotlin.m.p.a(str, str2, true) && this.f63600h != null) {
                Bundle bundle = new Bundle();
                net.one97.paytm.recharge.common.utils.e eVar2 = this.D;
                if (eVar2 != null) {
                    i2 = eVar2.f61622g;
                } else {
                    i2 = -1;
                }
                bundle.putInt("key_position", i2);
                net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                if (aVar == null) {
                    kotlin.g.b.k.a();
                }
                Fragment fragment = this;
                CJRFrequentOrder cJRFrequentOrder2 = this.E;
                if (cJRFrequentOrder2 == null) {
                    kotlin.g.b.k.a();
                }
                aVar.a(fragment, cJRFrequentOrder2, bundle);
            }
        }
    }

    public void onPause() {
        boolean z2;
        if (!this.s || !(getParentFragment() instanceof g)) {
            z2 = true;
        } else {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                z2 = ((g) parentFragment).f63846a;
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile_v3.fragment.FJRMobileControllerFragmentV3");
            }
        }
        if (z2) {
            j();
        }
        super.onPause();
    }

    public void i(String str) {
        if (str == null) {
            str = "via_edit";
        }
        super.i(str);
    }

    public final void d(String str) {
        String str2;
        Object e2;
        LiveData liveData;
        kotlin.g.b.k.c(str, "correctedNumber");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.SHOW_WRONG_NUMBER_DIALOG);
        x();
        ba baVar = this.k;
        if (baVar != null) {
            Context context = getContext();
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (!(aVar == null || (liveData = aVar.f61413f) == null)) {
                liveData.getValue();
            }
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 == null || (e2 = aVar2.e()) == null || (str2 = e2.toString()) == null) {
                str2 = "";
            }
            baVar.a(str, context, str2);
        }
    }

    public final void a(char c2) {
        j();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.ALPHABET_FILTER_ITEM_CLICK);
        r rVar = this.A;
        Integer a2 = rVar != null ? rVar.a(c2) : null;
        if (a2 != null && a2.intValue() >= 0) {
            RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
            RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(a2.intValue(), 0);
            }
        }
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        r rVar;
        if (kotlin.g.b.k.a((Object) str, (Object) M) && (rVar = this.A) != null) {
            rVar.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.recharge.common.e.a<IJRPaytmDataModel> aVar = this.I;
        if (aVar != null) {
            aVar.a();
        }
        this.I = null;
    }

    public final void A() {
        LiveData<List<ContactItemModel>> liveData;
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            if (androidx.core.content.b.a((Context) activity, "android.permission.READ_CONTACTS") != 0) {
                net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
                if (aVar != null) {
                    aVar.a(false);
                    return;
                }
                return;
            }
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a(true);
        }
        if (this.f63600h != null) {
            androidx.loader.a.a a2 = androidx.loader.a.a.a(this);
            kotlin.g.b.k.a((Object) a2, "LoaderManager.getInstanc…erMobileNumberFragmentV3)");
            liveData = net.one97.paytm.recharge.mobile.d.a.a(a2);
        } else {
            liveData = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new d(this));
    }

    /* access modifiers changed from: protected */
    public void v() {
        LiveData liveData;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            liveData = aVar.f61414g;
        } else {
            liveData = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new C1248c(this));
    }

    public final void z() {
        if (this.f63600h != null) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.f61412e) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setActionType(ACTION_TYPE.RECREATE.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setErrorType(ERROR_TYPE.UI_DISTORT.name());
                }
                a(a2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void B() {
        RecyclerView.v vVar;
        if (this.f63600h != null) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null) {
                kotlin.g.b.k.a();
            }
            if (aVar.j() != null) {
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                if (aVar2 == null) {
                    kotlin.g.b.k.a();
                }
                if (aVar2.W != null) {
                    RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
                    if (recyclerView != null) {
                        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                        if (aVar3 == null) {
                            kotlin.g.b.k.a();
                        }
                        Integer num = aVar3.W;
                        if (num == null) {
                            kotlin.g.b.k.a();
                        }
                        vVar = recyclerView.findViewHolderForLayoutPosition(num.intValue());
                    } else {
                        vVar = null;
                    }
                    if (vVar instanceof net.one97.paytm.recharge.mobile_v3.c.e) {
                        ((net.one97.paytm.recharge.mobile_v3.c.e) vVar).d();
                    } else if (vVar instanceof net.one97.paytm.recharge.mobile_v3.c.d) {
                        ((net.one97.paytm.recharge.mobile_v3.c.d) vVar).e();
                    } else if (vVar instanceof net.one97.paytm.recharge.mobile_v3.c.c) {
                        ((net.one97.paytm.recharge.mobile_v3.c.c) vVar).c();
                    } else if (vVar instanceof g.a) {
                        ((g.a) vVar).a();
                    } else if (vVar instanceof g.c) {
                        ((g.c) vVar).a();
                    }
                }
            }
        }
    }

    public void f() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED, (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }

    public final void e() {
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "phonebook_back_button_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
        }
    }

    public final void a(String str, NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(str, "tag");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a(str, 0, (IJRPaytmDataModel) null, networkCustomError, (Object) null);
        }
    }

    public static final /* synthetic */ void b(c cVar) {
        if (!TextUtils.isEmpty(com.paytm.utility.b.l(cVar.getContext())) && !cVar.f63773f) {
            View b2 = cVar.b(R.id.dummySpaceView);
            if (b2 != null) {
                b2.setVisibility(0);
            }
            cVar.f63773f = true;
            r rVar = cVar.A;
            if (rVar != null) {
                ContactItemModel contactItemModel = new ContactItemModel(com.paytm.utility.b.aa(cVar.getContext()), com.paytm.utility.b.l(cVar.getContext()), com.paytm.utility.b.al(cVar.getContext()), true);
                CJRContactListV8.a aVar = new CJRContactListV8.a();
                aVar.f61862c = cVar;
                rVar.a(contactItemModel, aVar);
            }
        }
    }

    public static final /* synthetic */ void d(c cVar) {
        if (cVar.B == null) {
            ArrayList arrayList = new ArrayList();
            for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
                arrayList.add(Character.valueOf(c2));
            }
            RecyclerView recyclerView = (RecyclerView) cVar.b(R.id.alphabetRV);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            RecyclerView recyclerView2 = (RecyclerView) cVar.b(R.id.alphabetRV);
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(cVar.getContext()));
            }
            cVar.B = new net.one97.paytm.recharge.common.a.b(arrayList, cVar);
            RecyclerView recyclerView3 = (RecyclerView) cVar.b(R.id.alphabetRV);
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(cVar.B);
            }
        }
    }
}
