package net.one97.paytm.recharge.coupons.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRSelectedRecharge;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ag;
import net.one97.paytm.recharge.coupons.a.a;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.model.CJRCouponGrid;

public final class a extends Fragment implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.coupons.a.a f62266a;

    /* renamed from: b  reason: collision with root package name */
    public CJRCouponGrid f62267b = new CJRCouponGrid();

    /* renamed from: c  reason: collision with root package name */
    public String f62268c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f62269d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f62270e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f62271f = "";

    /* renamed from: g  reason: collision with root package name */
    private C1195a f62272g;

    /* renamed from: h  reason: collision with root package name */
    private net.one97.paytm.recharge.coupons.e.b f62273h;

    /* renamed from: i  reason: collision with root package name */
    private ag f62274i;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.coupons.c.a j;
    private HashMap k;

    private View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_deal_coupon, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.j = (net.one97.paytm.recharge.coupons.c.a) activity;
            if (getActivity() != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                this.f62273h = (net.one97.paytm.recharge.coupons.e.b) am.a(activity2).a(net.one97.paytm.recharge.coupons.e.b.class);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.coupons.interfaces.IJROnScrollChangedListener");
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        net.one97.paytm.recharge.coupons.e.b bVar = this.f62273h;
        ArrayList<CJRGridProduct> gridLayout = this.f62267b.getGridLayout();
        k.a((Object) gridLayout, "mCouponGrid.gridLayout");
        this.f62266a = new net.one97.paytm.recharge.coupons.a.a(context, bVar, gridLayout, this.f62268c, this.f62269d, this, this.f62270e, this.f62271f);
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        this.f62272g = new C1195a(context2);
        x.e eVar = new x.e();
        eVar.element = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = (RecyclerView) a(R.id.dealCouponRecyclerView);
        k.a((Object) recyclerView, "dealCouponRecyclerView");
        recyclerView.setLayoutManager((LinearLayoutManager) eVar.element);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.dealCouponRecyclerView);
        k.a((Object) recyclerView2, "dealCouponRecyclerView");
        recyclerView2.setAdapter(this.f62266a);
        RecyclerView recyclerView3 = (RecyclerView) a(R.id.dealNoContent);
        k.a((Object) recyclerView3, "dealNoContent");
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView4 = (RecyclerView) a(R.id.dealNoContent);
        k.a((Object) recyclerView4, "dealNoContent");
        recyclerView4.setAdapter(this.f62272g);
        this.f62274i = new b(this, eVar, (LinearLayoutManager) eVar.element);
        RecyclerView recyclerView5 = (RecyclerView) a(R.id.dealCouponRecyclerView);
        ag agVar = this.f62274i;
        if (agVar == null) {
            k.a();
        }
        recyclerView5.addOnScrollListener(agVar);
        RecyclerView recyclerView6 = (RecyclerView) a(R.id.dealNoContent);
        ag agVar2 = this.f62274i;
        if (agVar2 == null) {
            k.a();
        }
        recyclerView6.addOnScrollListener(agVar2);
        b();
    }

    public static final class b extends ag {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f62277b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, x.e eVar, LinearLayoutManager linearLayoutManager) {
            super(linearLayoutManager);
            this.f62276a = aVar;
            this.f62277b = eVar;
        }

        public final void a(int i2) {
            net.one97.paytm.recharge.coupons.a.a a2 = this.f62276a.f62266a;
            if (a2 != null) {
                a2.a();
            }
            net.one97.paytm.recharge.coupons.c.a b2 = this.f62276a.j;
            if (b2 != null) {
                b2.b();
            }
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                FragmentActivity activity = this.f62276a.getActivity();
                if (activity != null) {
                    ((AJRCouponsActivityV8) activity).f();
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8");
            }
        }
    }

    public final void a(CJRCouponGrid cJRCouponGrid, ArrayList<String> arrayList, ArrayList<CJRSelectedRecharge> arrayList2, HashMap<String, String> hashMap, Integer num) {
        net.one97.paytm.recharge.coupons.a.a aVar;
        k.c(cJRCouponGrid, "dataModel");
        k.c(arrayList, "selectedCouponList");
        k.c(arrayList2, "selectedRechargeIdList");
        k.c(hashMap, "rechargeConfig");
        this.f62267b = cJRCouponGrid;
        if (!(this.f62266a == null || this.f62267b.getGridLayout() == null || (aVar = this.f62266a) == null)) {
            ArrayList<CJRGridProduct> gridLayout = this.f62267b.getGridLayout();
            k.a((Object) gridLayout, "mCouponGrid.gridLayout");
            aVar.a(gridLayout, arrayList, arrayList2, hashMap, this.f62269d, num);
        }
        b();
    }

    public final void b() {
        if (this.f62267b.getGridLayout().size() > 0) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmerNoContent);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.setVisibility(8);
            }
            RecyclerView recyclerView = (RecyclerView) a(R.id.dealCouponRecyclerView);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            try {
                ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmerNoContent);
                if (shimmerFrameLayout2 != null) {
                    shimmerFrameLayout2.b();
                }
            } catch (Exception unused) {
            }
        } else {
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.dealCouponRecyclerView);
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) a(R.id.shimmerNoContent);
            if (shimmerFrameLayout3 != null) {
                shimmerFrameLayout3.setVisibility(0);
            }
            try {
                ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) a(R.id.shimmerNoContent);
                if (shimmerFrameLayout4 != null) {
                    shimmerFrameLayout4.a();
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final void onPause() {
        super.onPause();
        net.one97.paytm.recharge.coupons.a.a aVar = this.f62266a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: net.one97.paytm.recharge.coupons.b.a$a  reason: collision with other inner class name */
    public static final class C1195a extends RecyclerView.a<C1196a> {

        /* renamed from: a  reason: collision with root package name */
        private Context f62275a;

        public final int getItemCount() {
            return 4;
        }

        public C1195a(Context context) {
            k.c(context, "context");
            this.f62275a = context;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            k.c((C1196a) vVar, "holder");
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f62275a).inflate(R.layout.v8_item_no_coupons, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…o_coupons, parent, false)");
            return new C1196a(inflate);
        }

        /* renamed from: net.one97.paytm.recharge.coupons.b.a$a$a  reason: collision with other inner class name */
        public static final class C1196a extends RecyclerView.v {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1196a(View view) {
                super(view);
                k.c(view, "view");
            }
        }
    }

    public final void a() {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof AJRCouponsActivityV8)) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ((AJRCouponsActivityV8) activity2).f();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
