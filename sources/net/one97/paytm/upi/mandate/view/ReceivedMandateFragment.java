package net.one97.paytm.upi.mandate.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.f.c;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.view.b;
import net.one97.paytm.upi.mandate.view.k;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.VerticalSpaceItemDecoration;

public final class ReceivedMandateFragment extends h implements k.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f67477a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.f.c f67478b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f67479c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f67480d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f67481e;

    /* renamed from: f  reason: collision with root package name */
    private View f67482f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f67483g;

    /* renamed from: h  reason: collision with root package name */
    private View f67484h;

    /* renamed from: i  reason: collision with root package name */
    private View f67485i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    private RefreshListReceiver l;
    private HashMap m;

    static final class c<T> implements z<r<List<? extends Object>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReceivedMandateFragment f67489a;

        c(ReceivedMandateFragment receivedMandateFragment) {
            this.f67489a = receivedMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            if (rVar != null) {
                int i2 = l.f67550a[rVar.f67411a.ordinal()];
                if (i2 == 1) {
                    this.f67489a.j = true;
                    ReceivedMandateFragment.e(this.f67489a);
                } else if (i2 == 2) {
                    this.f67489a.j = false;
                    ReceivedMandateFragment.a(this.f67489a, (List) rVar.f67412b, rVar.f67414d);
                } else if (i2 == 3) {
                    this.f67489a.j = false;
                    if (rVar.f67413c instanceof t.a) {
                        ReceivedMandateFragment.a(this.f67489a, ((t.a) rVar.f67413c).f67420a);
                        return;
                    }
                    ReceivedMandateFragment.a(this.f67489a, (String) null);
                    ReceivedMandateFragment.a(this.f67489a, rVar.f67413c);
                }
            }
        }
    }

    static final class d<T> implements z<c.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReceivedMandateFragment f67490a;

        d(ReceivedMandateFragment receivedMandateFragment) {
            this.f67490a = receivedMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            c.a aVar = (c.a) obj;
            if (aVar != null && (aVar instanceof c.a.C1362a)) {
                RecyclerView.a adapter = ReceivedMandateFragment.f(this.f67490a).getAdapter();
                if (adapter != null) {
                    k kVar = (k) adapter;
                    if (kotlin.a.k.e(kVar.f67510b) instanceof b.C1372b) {
                        kVar.f67510b.remove(0);
                        kVar.notifyItemRemoved(0);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.view.ReceivedMandateAdapter");
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.f.c a(ReceivedMandateFragment receivedMandateFragment) {
        net.one97.paytm.upi.mandate.f.c cVar = receivedMandateFragment.f67478b;
        if (cVar == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        return cVar;
    }

    public static final /* synthetic */ RecyclerView f(ReceivedMandateFragment receivedMandateFragment) {
        RecyclerView recyclerView = receivedMandateFragment.f67477a;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvReceivedMandateList");
        }
        return recyclerView;
    }

    public final class RefreshListReceiver extends BroadcastReceiver {
        public RefreshListReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && p.a("action_refresh_received_mandates", intent.getAction(), true)) {
                if (ReceivedMandateFragment.this.isResumed()) {
                    ReceivedMandateFragment.a(ReceivedMandateFragment.this).a();
                } else {
                    ReceivedMandateFragment.a(ReceivedMandateFragment.this).f67229d = true;
                }
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_received_mandate, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.rvMandateList);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.rvMandateList)");
        this.f67477a = (RecyclerView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ivEmptyImage);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.ivEmptyImage)");
        this.f67480d = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tvEmptyMessage);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.tvEmptyMessage)");
        this.f67481e = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.wallet_loader);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.wallet_loader)");
        this.f67479c = (LottieAnimationView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.empty_view);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.empty_view)");
        this.f67482f = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.ll_error_container);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.ll_error_container)");
        this.f67484h = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.tv_error_msg);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.tv_error_msg)");
        this.f67483g = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.tv_retry);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.tv_retry)");
        this.f67485i = findViewById8;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        RecyclerView recyclerView = this.f67477a;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvReceivedMandateList");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new k(this));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(24));
        recyclerView.addOnScrollListener(new a(this, linearLayoutManager));
        View view = this.f67485i;
        if (view == null) {
            kotlin.g.b.k.a("tvRetry");
        }
        view.setOnClickListener(new e(this));
        this.l = new RefreshListReceiver();
        IntentFilter intentFilter = new IntentFilter("action_refresh_received_mandates");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
        RefreshListReceiver refreshListReceiver = this.l;
        if (refreshListReceiver == null) {
            kotlin.g.b.k.a();
        }
        a2.a(refreshListReceiver, intentFilter);
        return inflate;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReceivedMandateFragment f67491a;

        e(ReceivedMandateFragment receivedMandateFragment) {
            this.f67491a = receivedMandateFragment;
        }

        public final void onClick(View view) {
            ReceivedMandateFragment.a(this.f67491a).a();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.mandate.f.c.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ateViewModel::class.java)");
        this.f67478b = (net.one97.paytm.upi.mandate.f.c) a2;
        net.one97.paytm.upi.mandate.f.c cVar = this.f67478b;
        if (cVar == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        q qVar = this;
        cVar.f67226a.observe(qVar, new c(this));
        net.one97.paytm.upi.mandate.f.c cVar2 = this.f67478b;
        if (cVar2 == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        cVar2.f67227b.observe(qVar, new d(this));
        net.one97.paytm.upi.mandate.f.c cVar3 = this.f67478b;
        if (cVar3 == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        cVar3.a();
    }

    private final void b() {
        RecyclerView recyclerView = this.f67477a;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvReceivedMandateList");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (!(adapter instanceof k)) {
            adapter = null;
        }
        k kVar = (k) adapter;
        if (kVar != null && kVar.f67509a && kVar.f67510b.size() > 0) {
            kVar.f67509a = false;
            kVar.f67510b.remove(kVar.f67510b.size() - 1);
            kVar.notifyItemRemoved(kVar.f67510b.size());
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReceivedMandateFragment f67488a;

        b(ReceivedMandateFragment receivedMandateFragment) {
            this.f67488a = receivedMandateFragment;
        }

        public final void run() {
            RecyclerView.a adapter = ReceivedMandateFragment.f(this.f67488a).getAdapter();
            if (!(adapter instanceof k)) {
                adapter = null;
            }
            k kVar = (k) adapter;
            if (kVar != null) {
                Object obj = new Object();
                if (kVar.f67510b.size() > 0 && !kVar.f67509a) {
                    kVar.f67509a = true;
                    kVar.f67510b.add(obj);
                    kVar.notifyItemInserted(kVar.f67510b.size() - 1);
                }
            }
            net.one97.paytm.upi.mandate.f.c a2 = ReceivedMandateFragment.a(this.f67488a);
            if (UpiAppUtils.isNetworkAvailable(a2.f67232g)) {
                a2.f67228c++;
                a2.b();
                return;
            }
            a2.f67226a.setValue(new r(net.one97.paytm.upi.mandate.utils.u.ERROR, (Object) null, t.i.f67428a, a2.f67231f, 2));
        }
    }

    private final int c() {
        RecyclerView recyclerView = this.f67477a;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvReceivedMandateList");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (!(adapter instanceof k)) {
            adapter = null;
        }
        k kVar = (k) adapter;
        if (kVar != null) {
            return kVar.getItemCount();
        }
        return 0;
    }

    public final void onResume() {
        super.onResume();
        net.one97.paytm.upi.mandate.f.c cVar = this.f67478b;
        if (cVar == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        if (cVar.f67229d) {
            cVar.a();
            cVar.f67229d = false;
        }
    }

    public final void a() {
        net.one97.paytm.upi.mandate.f.c cVar = this.f67478b;
        if (cVar == null) {
            kotlin.g.b.k.a("receivedMandateViewModel");
        }
        kotlin.g.b.k.c("action_remove_banner", "action");
        if ("action_remove_banner".hashCode() == -485498626) {
            cVar.f67230e = false;
            cVar.f67227b.setValue(c.a.C1362a.f67234a);
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (getActivity() != null) {
            if (this.l != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
                RefreshListReceiver refreshListReceiver = this.l;
                if (refreshListReceiver == null) {
                    kotlin.g.b.k.a();
                }
                a2.a((BroadcastReceiver) refreshListReceiver);
            }
            this.l = null;
        }
        HashMap hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final class a extends g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReceivedMandateFragment f67487a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ReceivedMandateFragment receivedMandateFragment, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            kotlin.g.b.k.c(linearLayoutManager, "layoutManager");
            this.f67487a = receivedMandateFragment;
        }

        public final boolean c() {
            return this.f67487a.j;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            ReceivedMandateFragment.c(this.f67487a);
        }

        public final boolean b() {
            return this.f67487a.k;
        }
    }

    public static final /* synthetic */ void c(ReceivedMandateFragment receivedMandateFragment) {
        RecyclerView recyclerView = receivedMandateFragment.f67477a;
        if (recyclerView == null) {
            kotlin.g.b.k.a("rvReceivedMandateList");
        }
        recyclerView.post(new b(receivedMandateFragment));
    }

    public static final /* synthetic */ void e(ReceivedMandateFragment receivedMandateFragment) {
        View view = receivedMandateFragment.f67484h;
        if (view == null) {
            kotlin.g.b.k.a("errorView");
        }
        view.setVisibility(8);
        View view2 = receivedMandateFragment.f67482f;
        if (view2 == null) {
            kotlin.g.b.k.a("emptyView");
        }
        view2.setVisibility(8);
        if (receivedMandateFragment.c() == 0) {
            LottieAnimationView lottieAnimationView = receivedMandateFragment.f67479c;
            if (lottieAnimationView == null) {
                kotlin.g.b.k.a("walletLoader");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
        }
    }

    public static final /* synthetic */ void a(ReceivedMandateFragment receivedMandateFragment, List list, boolean z) {
        View view = receivedMandateFragment.f67484h;
        if (view == null) {
            kotlin.g.b.k.a("errorView");
        }
        view.setVisibility(8);
        LottieAnimationView lottieAnimationView = receivedMandateFragment.f67479c;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("walletLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        receivedMandateFragment.b();
        receivedMandateFragment.k = (list != null ? list.size() : 0) < 20;
        if (list != null) {
            Collection collection = list;
            if (true ^ collection.isEmpty()) {
                View view2 = receivedMandateFragment.f67482f;
                if (view2 == null) {
                    kotlin.g.b.k.a("emptyView");
                }
                view2.setVisibility(8);
                RecyclerView recyclerView = receivedMandateFragment.f67477a;
                if (recyclerView == null) {
                    kotlin.g.b.k.a("rvReceivedMandateList");
                }
                recyclerView.setVisibility(0);
                RecyclerView recyclerView2 = receivedMandateFragment.f67477a;
                if (recyclerView2 == null) {
                    kotlin.g.b.k.a("rvReceivedMandateList");
                }
                RecyclerView.a adapter = recyclerView2.getAdapter();
                if (adapter != null) {
                    k kVar = (k) adapter;
                    if (z) {
                        kotlin.g.b.k.c(list, "data");
                        int size = kVar.f67510b.size();
                        kVar.f67510b.addAll(collection);
                        kVar.notifyItemRangeInserted(size, list.size());
                        return;
                    }
                    kotlin.g.b.k.c(list, "data");
                    kVar.f67510b.clear();
                    kVar.f67510b.addAll(collection);
                    kVar.notifyDataSetChanged();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.view.ReceivedMandateAdapter");
            }
        }
        if (receivedMandateFragment.c() == 0) {
            View view3 = receivedMandateFragment.f67482f;
            if (view3 == null) {
                kotlin.g.b.k.a("emptyView");
            }
            view3.setVisibility(0);
            RecyclerView recyclerView3 = receivedMandateFragment.f67477a;
            if (recyclerView3 == null) {
                kotlin.g.b.k.a("rvReceivedMandateList");
            }
            recyclerView3.setVisibility(8);
            ImageView imageView = receivedMandateFragment.f67480d;
            if (imageView == null) {
                kotlin.g.b.k.a("ivEmptyImage");
            }
            imageView.setImageResource(R.drawable.ic_img_no_received_mandates);
            TextView textView = receivedMandateFragment.f67481e;
            if (textView == null) {
                kotlin.g.b.k.a("tvEmptyMessage");
            }
            textView.setText(receivedMandateFragment.getString(R.string.upi_mandate_empty_received_msg));
        }
    }

    public static final /* synthetic */ void a(ReceivedMandateFragment receivedMandateFragment, String str) {
        View view = receivedMandateFragment.f67482f;
        if (view == null) {
            kotlin.g.b.k.a("emptyView");
        }
        view.setVisibility(8);
        LottieAnimationView lottieAnimationView = receivedMandateFragment.f67479c;
        if (lottieAnimationView == null) {
            kotlin.g.b.k.a("walletLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        receivedMandateFragment.b();
        if (receivedMandateFragment.c() == 0) {
            View view2 = receivedMandateFragment.f67484h;
            if (view2 == null) {
                kotlin.g.b.k.a("errorView");
            }
            view2.setVisibility(0);
            TextView textView = receivedMandateFragment.f67483g;
            if (textView == null) {
                kotlin.g.b.k.a("errorMsg");
            }
            if (str == null) {
                str = receivedMandateFragment.getString(R.string.upi_some_went_wrong);
            }
            textView.setText(str);
            RecyclerView recyclerView = receivedMandateFragment.f67477a;
            if (recyclerView == null) {
                kotlin.g.b.k.a("rvReceivedMandateList");
            }
            recyclerView.setVisibility(8);
        } else if (receivedMandateFragment.getUserVisibleHint()) {
            Toast.makeText(receivedMandateFragment.getActivity(), str != null ? str : receivedMandateFragment.getString(R.string.upi_some_went_wrong), 0).show();
        }
    }

    public static final /* synthetic */ void a(ReceivedMandateFragment receivedMandateFragment, t tVar) {
        if (receivedMandateFragment.getActivity() == null) {
            return;
        }
        if (tVar instanceof t.i) {
            CustomDialog.showAlert(receivedMandateFragment.getActivity(), receivedMandateFragment.getResources().getString(R.string.no_connection), receivedMandateFragment.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.a) {
            Context context = receivedMandateFragment.getContext();
            if (context != null) {
                String str = ((t.a) tVar).f67420a;
                if (str == null) {
                    str = receivedMandateFragment.getString(R.string.upi_some_went_wrong);
                    kotlin.g.b.k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
                }
                f.a(context, str, 0);
            }
        } else if (tVar instanceof t.d) {
            Context context2 = receivedMandateFragment.getContext();
            if (context2 != null) {
                String string = receivedMandateFragment.getString(R.string.upi_some_went_wrong);
                kotlin.g.b.k.a((Object) string, "getString(R.string.upi_some_went_wrong)");
                f.a(context2, string, 0);
            }
        } else if (tVar instanceof t.k) {
            Context context3 = receivedMandateFragment.getContext();
            if (context3 != null) {
                String string2 = receivedMandateFragment.getString(R.string.upi_profile_fetch_error);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.upi_profile_fetch_error)");
                f.a(context3, string2, 0);
            }
        } else if (tVar instanceof t.f) {
            Context context4 = receivedMandateFragment.getContext();
            if (context4 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = receivedMandateFragment.getString(R.string.something_went_wrong);
                    kotlin.g.b.k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                f.a(context4, str2, 1);
            }
        } else if ((tVar instanceof t.j) && receivedMandateFragment.getUserVisibleHint()) {
            i a2 = i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateListActivity.class.getName();
            a2.b().e(receivedMandateFragment.getActivity());
        }
    }
}
