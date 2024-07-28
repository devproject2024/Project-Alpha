package net.one97.paytm.paymentsBank.chequebook.depositedCheque.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.LoadingView;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f17524a = {y.a((v) new w(y.b(a.class), "depositedListAdapter", "getDepositedListAdapter()Lnet/one97/paytm/paymentsBank/chequebook/depositedCheque/CBDepositedChequeAdapter;"))};

    /* renamed from: e  reason: collision with root package name */
    public static final C0269a f17525e = new C0269a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    int f17526b;

    /* renamed from: c  reason: collision with root package name */
    boolean f17527c;

    /* renamed from: d  reason: collision with root package name */
    boolean f17528d;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.chequebook.depositedCheque.b f17529f;

    /* renamed from: g  reason: collision with root package name */
    private final g f17530g = kotlin.h.a(c.INSTANCE);

    /* renamed from: h  reason: collision with root package name */
    private HashMap f17531h;

    /* access modifiers changed from: private */
    public final net.one97.paytm.paymentsBank.chequebook.depositedCheque.a a() {
        return (net.one97.paytm.paymentsBank.chequebook.depositedCheque.a) this.f17530g.getValue();
    }

    public final View a(int i2) {
        if (this.f17531h == null) {
            this.f17531h = new HashMap();
        }
        View view = (View) this.f17531h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f17531h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d<T> implements z<net.one97.paytm.paymentsBank.chequebook.b<List<? extends IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17533a;

        d(a aVar) {
            this.f17533a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.paymentsBank.chequebook.c cVar;
            NetworkCustomError.ErrorType errorType;
            net.one97.paytm.paymentsBank.chequebook.b bVar = (net.one97.paytm.paymentsBank.chequebook.b) obj;
            Integer num = null;
            if (bVar != null) {
                cVar = bVar.f17486a;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int i2 = b.f17535a[cVar.ordinal()];
                boolean z = false;
                if (i2 == 1) {
                    if (!bVar.f17489d) {
                        View a2 = this.f17533a.a(R.id.error_layout);
                        k.a((Object) a2, "error_layout");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.b(a2);
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17533a.a(R.id.wallet_loader));
                        RecyclerView recyclerView = (RecyclerView) this.f17533a.a(R.id.deposited_chq_rv);
                        k.a((Object) recyclerView, "deposited_chq_rv");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.a(recyclerView);
                    } else {
                        net.one97.paytm.paymentsBank.chequebook.depositedCheque.a c2 = this.f17533a.a();
                        if (c2.f17496a && c2.f17497b.size() > 0) {
                            c2.f17496a = false;
                            c2.f17497b.remove(c2.f17497b.size() - 1);
                            c2.notifyItemRemoved(c2.f17497b.size());
                        }
                    }
                    a aVar = this.f17533a;
                    List list = (List) bVar.f17487b;
                    if (list != null) {
                        num = Integer.valueOf(list.size());
                    }
                    if (num == null) {
                        k.a();
                    }
                    if (num.intValue() < 10) {
                        z = true;
                    }
                    aVar.f17528d = z;
                    net.one97.paytm.paymentsBank.chequebook.depositedCheque.a c3 = this.f17533a.a();
                    ResultType resulttype = bVar.f17487b;
                    if (resulttype == null) {
                        k.a();
                    }
                    List list2 = (List) resulttype;
                    k.c(list2, "itemList");
                    Collection collection = list2;
                    if (!collection.isEmpty()) {
                        int size = c3.f17497b.size();
                        c3.f17497b.addAll(collection);
                        c3.notifyItemRangeInserted(size, list2.size());
                    }
                } else if (i2 == 2) {
                    this.f17533a.f17527c = false;
                    if (!bVar.f17489d) {
                        View a3 = this.f17533a.a(R.id.error_layout);
                        k.a((Object) a3, "error_layout");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.a(a3);
                        NetworkCustomError networkCustomError = bVar.f17488c;
                        if (!(networkCustomError == null || (errorType = networkCustomError.getErrorType()) == null || !errorType.equals(NetworkCustomError.ErrorType.NoConnectionError))) {
                            View a4 = this.f17533a.a(R.id.error_layout);
                            k.a((Object) a4, "error_layout");
                            TextView textView = (TextView) a4.findViewById(R.id.tv_message);
                            if (textView != null) {
                                textView.setText(this.f17533a.getString(R.string.no_internet));
                            }
                        }
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f17533a.a(R.id.wallet_loader));
                        RecyclerView recyclerView2 = (RecyclerView) this.f17533a.a(R.id.deposited_chq_rv);
                        k.a((Object) recyclerView2, "deposited_chq_rv");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView2);
                        f.a((Activity) this.f17533a.getActivity(), (Exception) bVar.f17488c, this.f17533a.getClass().getName());
                    }
                } else if (i2 == 3) {
                    this.f17533a.f17527c = true;
                    if (!bVar.f17489d) {
                        View a5 = this.f17533a.a(R.id.error_layout);
                        k.a((Object) a5, "error_layout");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.b(a5);
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f17533a.a(R.id.wallet_loader));
                        RecyclerView recyclerView3 = (RecyclerView) this.f17533a.a(R.id.deposited_chq_rv);
                        k.a((Object) recyclerView3, "deposited_chq_rv");
                        net.one97.paytm.paymentsBank.chequebook.utils.b.b(recyclerView3);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.paymentsBank.chequebook.depositedCheque.b b(a aVar) {
        net.one97.paytm.paymentsBank.chequebook.depositedCheque.b bVar = aVar.f17529f;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    static final class c extends l implements kotlin.g.a.a<net.one97.paytm.paymentsBank.chequebook.depositedCheque.a> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        public final net.one97.paytm.paymentsBank.chequebook.depositedCheque.a invoke() {
            return new net.one97.paytm.paymentsBank.chequebook.depositedCheque.a();
        }
    }

    /* renamed from: net.one97.paytm.paymentsBank.chequebook.depositedCheque.view.a$a  reason: collision with other inner class name */
    public static final class C0269a {
        private C0269a() {
        }

        public /* synthetic */ C0269a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.cb_deposited_cheque_frag, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f17529f = (net.one97.paytm.paymentsBank.chequebook.depositedCheque.b) net.one97.paytm.paymentsBank.chequebook.utils.b.a(this, net.one97.paytm.paymentsBank.chequebook.depositedCheque.b.class);
        net.one97.paytm.paymentsBank.chequebook.depositedCheque.b bVar = this.f17529f;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.f17513a.observe(this, new d(this));
        net.one97.paytm.paymentsBank.chequebook.depositedCheque.b bVar2 = this.f17529f;
        if (bVar2 == null) {
            k.a("viewModel");
        }
        net.one97.paytm.paymentsBank.chequebook.utils.e eVar = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a;
        bVar2.a(net.one97.paytm.paymentsBank.chequebook.utils.e.A());
        View a2 = a(R.id.error_layout);
        k.a((Object) a2, "error_layout");
        ((TextView) a2.findViewById(R.id.tv_retry)).setOnClickListener(new e(this));
        RecyclerView recyclerView = (RecyclerView) a(R.id.deposited_chq_rv);
        recyclerView.setAdapter(a());
        k.a((Object) recyclerView, "this");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new b(this, linearLayoutManager));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17534a;

        e(a aVar) {
            this.f17534a = aVar;
        }

        public final void onClick(View view) {
            a.b(this.f17534a).a(this.f17534a.f17526b);
        }
    }

    public final class b extends net.one97.paytm.paymentsBank.chequebook.utils.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f17532a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            k.c(linearLayoutManager, "layoutManager");
            this.f17532a = aVar;
        }

        public final boolean a() {
            return this.f17532a.f17527c;
        }

        public final void b() {
            a.a(this.f17532a);
        }

        public final boolean c() {
            return this.f17532a.f17528d;
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        aVar.f17526b++;
        net.one97.paytm.paymentsBank.chequebook.depositedCheque.b bVar = aVar.f17529f;
        if (bVar == null) {
            k.a("viewModel");
        }
        bVar.a(aVar.f17526b);
        net.one97.paytm.paymentsBank.chequebook.depositedCheque.a a2 = aVar.a();
        LoadingView loadingView = new LoadingView((String) null, 1, (kotlin.g.b.g) null);
        k.c(loadingView, "emptyDataObject");
        if (a2.f17497b.size() > 0 && !a2.f17496a) {
            a2.f17496a = true;
            a2.f17497b.add(loadingView);
            a2.notifyItemInserted(a2.f17497b.size() - 1);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17531h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
