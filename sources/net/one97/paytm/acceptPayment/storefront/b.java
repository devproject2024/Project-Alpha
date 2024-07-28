package net.one97.paytm.acceptPayment.storefront;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IClientListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import java.util.HashMap;
import java.util.List;
import kotlin.g;
import kotlin.g.b.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.a.k;
import net.one97.paytm.acceptPayment.model.GAEvent;
import net.one97.paytm.acceptPayment.storefront.e;
import net.one97.paytm.acceptPayment.viewModel.e;
import net.one97.paytm.acceptPayment.viewModel.f;
import net.one97.paytm.acceptPayment.viewModel.j;
import net.one97.paytm.acceptPayment.viewModel.n;
import net.one97.paytm.i.h;
import net.one97.paytm.marketplace.search.a.a;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public k f52125a;

    /* renamed from: b  reason: collision with root package name */
    private final g f52126b = kotlin.h.a(new C0934b(this));

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.marketplace.search.a.a f52127c;

    /* renamed from: d  reason: collision with root package name */
    private a f52128d;

    /* renamed from: e  reason: collision with root package name */
    private final a.C0956a f52129e = new d(this);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f52130f;

    public interface a {
        void a();
    }

    public static final /* synthetic */ void a() {
    }

    public final e b() {
        return (e) this.f52126b.getValue();
    }

    static final class c<T> implements z<n> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52131a;

        c(b bVar) {
            this.f52131a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            n nVar = (n) obj;
            if (nVar instanceof j) {
                com.paytm.network.a aVar = ((j) nVar).f52202a;
                if (aVar != null) {
                    net.one97.paytm.acceptPayment.configs.a.a().b().a(aVar, this.f52131a.getContext());
                }
            } else if (nVar instanceof f) {
                b.a();
                f fVar = (f) nVar;
                NetworkCustomError networkCustomError = fVar.f52198b;
                if (networkCustomError != null) {
                    FragmentActivity activity = this.f52131a.getActivity();
                    if (!(activity instanceof Activity)) {
                        activity = null;
                    }
                    if (activity != null) {
                        net.one97.paytm.acceptPayment.utils.c cVar = net.one97.paytm.acceptPayment.utils.c.f52162a;
                        net.one97.paytm.acceptPayment.utils.c.a(activity, fVar.f52197a, networkCustomError);
                    }
                }
            } else if (nVar instanceof f) {
                List<? extends View> value = this.f52131a.b().f52134b.getValue();
                if (value != null) {
                    net.one97.paytm.marketplace.search.a.a a2 = b.a(this.f52131a);
                    if (value == null) {
                        value = a2.f53335a;
                    }
                    a2.f53335a = value;
                    a2.notifyDataSetChanged();
                }
                b.b(this.f52131a).a();
            } else if (nVar instanceof e) {
                FragmentActivity activity2 = this.f52131a.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            } else if (nVar instanceof a) {
                for (GAEvent gAEvent : ((a) nVar).f52124a) {
                    String.valueOf(net.one97.paytm.acceptPayment.utils.b.a(gAEvent));
                    net.one97.paytm.acceptPayment.utils.b.a(this.f52131a.getContext(), gAEvent);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.marketplace.search.a.a a(b bVar) {
        net.one97.paytm.marketplace.search.a.a aVar = bVar.f52127c;
        if (aVar == null) {
            kotlin.g.b.k.a("sfAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ a b(b bVar) {
        a aVar = bVar.f52128d;
        if (aVar == null) {
            kotlin.g.b.k.a("listener");
        }
        return aVar;
    }

    /* renamed from: net.one97.paytm.acceptPayment.storefront.b$b  reason: collision with other inner class name */
    static final class C0934b extends l implements kotlin.g.a.a<e> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0934b(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        public final e invoke() {
            ai a2 = am.a((Fragment) this.this$0).a(e.class);
            kotlin.g.b.k.b(a2, "ViewModelProviders.of(th…ontViewModel::class.java)");
            return (e) a2;
        }
    }

    public static final class d implements a.C0956a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f52132a;

        public final boolean IsClickEnable() {
            return true;
        }

        public /* synthetic */ void OnItemClick(Item item, int i2, boolean z) {
            IGAClickListener.CC.$default$OnItemClick(this, item, i2, z);
        }

        public final void fireImpression(View view, int i2) {
        }

        public /* synthetic */ void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
            IGAHandlerListener.CC.$default$fireInfiniteGridProductImpression(this, cJRGridProduct, i2);
        }

        public /* synthetic */ int getClient() {
            return IClientListener.CC.$default$getClient(this);
        }

        public /* synthetic */ String getClientRequestID() {
            return IAdListener.CC.$default$getClientRequestID(this);
        }

        d(b bVar) {
            this.f52132a = bVar;
        }

        public final void fireImpression(Item item, int i2) {
            if (item != null) {
                e b2 = this.f52132a.b();
                GAEvent gAEvent = new GAEvent(this.f52132a.b().a(), b.b(item), b.b(item, i2), "Promo Impression", (String) null, (String) null, (String) null, 112, (kotlin.g.b.g) null);
                kotlin.g.b.k.d(gAEvent, "gaEvent");
                Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new e.a(b2, gAEvent, (kotlin.d.d) null), 2, (Object) null);
            }
        }

        public final void OnItemClick(Item item, int i2) {
            if (item != null) {
                net.one97.paytm.acceptPayment.utils.b.a(this.f52132a.getContext(), new GAEvent(this.f52132a.b().a(), b.b(item), b.b(item, i2), "Promo Click", (String) null, (String) null, (String) null, 112, (kotlin.g.b.g) null));
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        e b2 = b();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("url")) == null) {
            str = "";
        }
        kotlin.g.b.k.d(str, "<set-?>");
        b2.f52136d = str;
        e b3 = b();
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(Item.KEY_GA_CATEGORY)) == null) {
            str2 = "";
        }
        kotlin.g.b.k.d(str2, "<set-?>");
        b3.f52133a = str2;
    }

    public final android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = androidx.databinding.f.a(layoutInflater, R.layout.ap_fragment_store_front, viewGroup, false);
        kotlin.g.b.k.b(a2, "DataBindingUtil.inflate(…_front, container, false)");
        this.f52125a = (k) a2;
        this.f52127c = new net.one97.paytm.marketplace.search.a.a(this.f52129e);
        k kVar = this.f52125a;
        if (kVar == null) {
            kotlin.g.b.k.a("mBinding");
        }
        RecyclerView recyclerView = kVar.f52003a;
        kotlin.g.b.k.b(recyclerView, "mBinding.rvWidgets");
        net.one97.paytm.marketplace.search.a.a aVar = this.f52127c;
        if (aVar == null) {
            kotlin.g.b.k.a("sfAdapter");
        }
        recyclerView.setAdapter(aVar);
        k kVar2 = this.f52125a;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mBinding");
        }
        RecyclerView recyclerView2 = kVar2.f52003a;
        kotlin.g.b.k.b(recyclerView2, "mBinding.rvWidgets");
        recyclerView2.setNestedScrollingEnabled(false);
        k kVar3 = this.f52125a;
        if (kVar3 == null) {
            kotlin.g.b.k.a("mBinding");
        }
        RecyclerView recyclerView3 = kVar3.f52003a;
        kotlin.g.b.k.b(recyclerView3, "mBinding.rvWidgets");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        k kVar4 = this.f52125a;
        if (kVar4 == null) {
            kotlin.g.b.k.a("mBinding");
        }
        return kVar4.getRoot();
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.d(context, "context");
        super.onAttach(context);
        if (context instanceof a) {
            this.f52128d = (a) context;
            return;
        }
        throw new Exception("Activity should implement SFFragmentListener");
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e b2 = b();
        String simpleName = b.class.getSimpleName();
        kotlin.g.b.k.b(simpleName, "this.javaClass.simpleName");
        b2.a(simpleName);
        b().f52189i.observe(getViewLifecycleOwner(), new c(this));
    }

    /* access modifiers changed from: private */
    public static String b(Item item) {
        try {
            String name = item.getName();
            String id = item.getId();
            return name + ';' + id;
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static String b(Item item, int i2) {
        try {
            int parentBindPosition = item.getParentBindPosition();
            int size = item.getChildItems() != null ? item.getChildItems().size() : 0;
            String name = item.getName();
            return parentBindPosition + ';' + i2 + ';' + size + ';' + name;
        } catch (Exception unused) {
            return "";
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f52130f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
