package net.one97.paytm.paymentsBank.chequebook.returnedCheque.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.LoadingView;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f17746a = {y.a((v) new w(y.b(a.class), "returnedListAdapter", "getReturnedListAdapter()Lnet/one97/paytm/paymentsBank/chequebook/returnedCheque/CBReturnedChequeAdapter;"))};

    /* renamed from: e  reason: collision with root package name */
    public static final C0284a f17747e = new C0284a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    int f17748b;

    /* renamed from: c  reason: collision with root package name */
    boolean f17749c;

    /* renamed from: d  reason: collision with root package name */
    boolean f17750d;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.chequebook.returnedCheque.b f17751f;

    /* renamed from: g  reason: collision with root package name */
    private final g f17752g = kotlin.h.a(d.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f17753h;

    /* access modifiers changed from: private */
    public final net.one97.paytm.paymentsBank.chequebook.returnedCheque.a a() {
        return (net.one97.paytm.paymentsBank.chequebook.returnedCheque.a) this.f17752g.getValue();
    }

    public final View a(int i2) {
        if (this.f17753h == null) {
            this.f17753h = new HashMap();
        }
        View view = (View) this.f17753h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17753h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17755a;

        c(a aVar) {
            this.f17755a = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x01e7  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x01f1  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x01fc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.paymentsBank.chequebook.b r9 = (net.one97.paytm.paymentsBank.chequebook.b) r9
                r0 = 0
                if (r9 == 0) goto L_0x0008
                net.one97.paytm.paymentsBank.chequebook.c r1 = r9.f17486a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.b.f17757a
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 0
                java.lang.String r3 = "returned_chq_rv"
                java.lang.String r4 = "error_layout"
                r5 = 1
                if (r1 == r5) goto L_0x00de
                r0 = 2
                if (r1 == r0) goto L_0x005b
                r0 = 3
                if (r1 == r0) goto L_0x0024
                goto L_0x00dd
            L_0x0024:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                r0.f17749c = r5
                boolean r9 = r9.f17489d
                if (r9 != 0) goto L_0x00dd
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r9 = r8.f17755a
                int r0 = net.one97.paytm.paymentsBank.R.id.error_layout
                android.view.View r9 = r9.a((int) r0)
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(r9)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r9 = r8.f17755a
                int r0 = net.one97.paytm.paymentsBank.R.id.wallet_loader
                android.view.View r9 = r9.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
                net.one97.paytm.common.widgets.a.a(r9)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r9 = r8.f17755a
                int r0 = net.one97.paytm.paymentsBank.R.id.returned_chq_rv
                android.view.View r9 = r9.a((int) r0)
                androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r3)
                android.view.View r9 = (android.view.View) r9
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(r9)
                goto L_0x00dd
            L_0x005b:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                r0.f17749c = r2
                boolean r0 = r9.f17489d
                if (r0 != 0) goto L_0x00dd
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                int r1 = net.one97.paytm.paymentsBank.R.id.error_layout
                android.view.View r0 = r0.a((int) r1)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                net.one97.paytm.paymentsBank.chequebook.utils.b.a(r0)
                com.paytm.network.model.NetworkCustomError r0 = r9.f17488c
                if (r0 == 0) goto L_0x00a5
                com.paytm.network.model.NetworkCustomError$ErrorType r0 = r0.getErrorType()
                if (r0 == 0) goto L_0x00a5
                com.paytm.network.model.NetworkCustomError$ErrorType r1 = com.paytm.network.model.NetworkCustomError.ErrorType.NoConnectionError
                boolean r0 = r0.equals(r1)
                if (r0 != r5) goto L_0x00a5
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                int r1 = net.one97.paytm.paymentsBank.R.id.error_layout
                android.view.View r0 = r0.a((int) r1)
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                int r1 = net.one97.paytm.paymentsBank.R.id.tv_message
                android.view.View r0 = r0.findViewById(r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                if (r0 == 0) goto L_0x00a5
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r2 = net.one97.paytm.paymentsBank.R.string.no_internet
                java.lang.String r1 = r1.getString(r2)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
            L_0x00a5:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                int r1 = net.one97.paytm.paymentsBank.R.id.wallet_loader
                android.view.View r0 = r0.a((int) r1)
                com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
                net.one97.paytm.common.widgets.a.b(r0)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                int r1 = net.one97.paytm.paymentsBank.R.id.returned_chq_rv
                android.view.View r0 = r0.a((int) r1)
                androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(r0)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r0 = r8.f17755a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.app.Activity r0 = (android.app.Activity) r0
                com.paytm.network.model.NetworkCustomError r9 = r9.f17488c
                java.lang.Exception r9 = (java.lang.Exception) r9
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                java.lang.Class r1 = r1.getClass()
                java.lang.String r1 = r1.getName()
                net.one97.paytm.bankCommon.utils.f.a((android.app.Activity) r0, (java.lang.Exception) r9, (java.lang.String) r1)
            L_0x00dd:
                return
            L_0x00de:
                ResultType r1 = r9.f17487b
                java.util.List r1 = (java.util.List) r1
                if (r1 == 0) goto L_0x0194
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r5
                if (r1 != r5) goto L_0x0194
                ResultType r1 = r9.f17487b
                java.util.List r1 = (java.util.List) r1
                if (r1 == 0) goto L_0x00fc
                int r1 = r1.size()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L_0x00fd
            L_0x00fc:
                r1 = r0
            L_0x00fd:
                if (r1 != 0) goto L_0x0102
                kotlin.g.b.k.a()
            L_0x0102:
                int r1 = r1.intValue()
                if (r1 <= r5) goto L_0x0194
                boolean r1 = r9.f17489d
                if (r1 != 0) goto L_0x013a
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r6 = net.one97.paytm.paymentsBank.R.id.error_layout
                android.view.View r1 = r1.a((int) r6)
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(r1)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.wallet_loader
                android.view.View r1 = r1.a((int) r4)
                com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
                net.one97.paytm.common.widgets.a.b(r1)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.returned_chq_rv
                android.view.View r1 = r1.a((int) r4)
                androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                android.view.View r1 = (android.view.View) r1
                net.one97.paytm.paymentsBank.chequebook.utils.b.a(r1)
                goto L_0x0163
            L_0x013a:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.a r1 = r1.a()
                boolean r3 = r1.f17721a
                if (r3 == 0) goto L_0x0163
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r1.f17722b
                int r3 = r3.size()
                if (r3 <= 0) goto L_0x0163
                r1.f17721a = r2
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r1.f17722b
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r4 = r1.f17722b
                int r4 = r4.size()
                int r4 = r4 - r5
                r3.remove(r4)
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r1.f17722b
                int r3 = r3.size()
                r1.notifyItemRemoved(r3)
            L_0x0163:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.a r1 = r1.a()
                ResultType r3 = r9.f17487b
                if (r3 != 0) goto L_0x0170
                kotlin.g.b.k.a()
            L_0x0170:
                java.util.List r3 = (java.util.List) r3
                java.lang.String r4 = "itemList"
                kotlin.g.b.k.c(r3, r4)
                r4 = r3
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r6 = r4.isEmpty()
                r6 = r6 ^ r5
                if (r6 == 0) goto L_0x01df
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r6 = r1.f17722b
                int r6 = r6.size()
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r7 = r1.f17722b
                r7.addAll(r4)
                int r3 = r3.size()
                r1.notifyItemRangeInserted(r6, r3)
                goto L_0x01df
            L_0x0194:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.no_returned_chq_lyt
                android.view.View r1 = r1.a((int) r4)
                java.lang.String r4 = "no_returned_chq_lyt"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                net.one97.paytm.paymentsBank.chequebook.utils.b.a(r1)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.no_cb_tv
                android.view.View r1 = r1.a((int) r4)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.String r4 = "no_cb_tv"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r4 = r8.f17755a
                int r6 = net.one97.paytm.paymentsBank.R.string.no_returned_cb
                java.lang.String r4 = r4.getString(r6)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r1.setText(r4)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.wallet_loader
                android.view.View r1 = r1.a((int) r4)
                com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
                net.one97.paytm.common.widgets.a.b(r1)
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                int r4 = net.one97.paytm.paymentsBank.R.id.returned_chq_rv
                android.view.View r1 = r1.a((int) r4)
                androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                android.view.View r1 = (android.view.View) r1
                net.one97.paytm.paymentsBank.chequebook.utils.b.b(r1)
            L_0x01df:
                net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a r1 = r8.f17755a
                ResultType r9 = r9.f17487b
                java.util.List r9 = (java.util.List) r9
                if (r9 == 0) goto L_0x01ef
                int r9 = r9.size()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            L_0x01ef:
                if (r0 != 0) goto L_0x01f4
                kotlin.g.b.k.a()
            L_0x01f4:
                int r9 = r0.intValue()
                r0 = 10
                if (r9 >= r0) goto L_0x01fd
                r2 = 1
            L_0x01fd:
                r1.f17750d = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a.c.onChanged(java.lang.Object):void");
        }
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.returnedCheque.b b(a aVar) {
        net.one97.paytm.paymentsBank.chequebook.returnedCheque.b bVar = aVar.f17751f;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    static final class d extends l implements kotlin.g.a.a<net.one97.paytm.paymentsBank.chequebook.returnedCheque.a> {
        public static final d INSTANCE = new d();

        d() {
            super(0);
        }

        public final net.one97.paytm.paymentsBank.chequebook.returnedCheque.a invoke() {
            return new net.one97.paytm.paymentsBank.chequebook.returnedCheque.a();
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.returnedCheque.view.a$a  reason: collision with other inner class name */
    public static final class C0284a {
        private C0284a() {
        }

        public /* synthetic */ C0284a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.cb_returned_cheque_frag, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f17751f = (net.one97.paytm.paymentsBank.chequebook.returnedCheque.b) net.one97.paytm.paymentsBank.chequebook.utils.b.a(this, net.one97.paytm.paymentsBank.chequebook.returnedCheque.b.class);
        net.one97.paytm.paymentsBank.chequebook.returnedCheque.b bVar = this.f17751f;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.f17736a.observe(this, new c(this));
        net.one97.paytm.paymentsBank.chequebook.returnedCheque.b bVar2 = this.f17751f;
        if (bVar2 == null) {
            k.a("viewModel");
        }
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        bVar2.a(net.one97.paytm.paymentsBank.chequebook.utils.e.A());
        View a2 = a(R.id.error_layout);
        k.a((Object) a2, "error_layout");
        ((TextView) a2.findViewById(R.id.tv_retry)).setOnClickListener(new e(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.returned_chq_rv);
        recyclerView.setAdapter(a());
        k.a((Object) recyclerView, "this");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new b(this, linearLayoutManager));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17756a;

        e(a aVar) {
            this.f17756a = aVar;
        }

        public final void onClick(View view) {
            a.b(this.f17756a).a(this.f17756a.f17748b);
        }
    }

    public final class b extends net.one97.paytm.paymentsBank.chequebook.utils.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17754a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            k.c(linearLayoutManager, "layoutManager");
            this.f17754a = aVar;
        }

        public final boolean a() {
            return this.f17754a.f17749c;
        }

        public final void b() {
            a.a(this.f17754a);
        }

        public final boolean c() {
            return this.f17754a.f17750d;
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        aVar.f17748b++;
        net.one97.paytm.paymentsBank.chequebook.returnedCheque.b bVar = aVar.f17751f;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.a(aVar.f17748b);
        net.one97.paytm.paymentsBank.chequebook.returnedCheque.a a2 = aVar.a();
        LoadingView loadingView = new LoadingView((String) null, 1, (kotlin.g.b.g) null);
        k.c(loadingView, "emptyDataObject");
        if (a2.f17722b.size() > 0 && !a2.f17721a) {
            a2.f17721a = true;
            a2.f17722b.add(loadingView);
            a2.notifyItemInserted(a2.f17722b.size() - 1);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17753h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
