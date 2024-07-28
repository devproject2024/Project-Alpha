package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.v;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.c.f;
import net.one97.paytm.recharge.common.d.f;
import net.one97.paytm.recharge.common.e.ah;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.d;
import net.one97.paytm.recharge.common.utils.ag;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class r extends h implements w.b, ai {

    /* renamed from: a  reason: collision with root package name */
    d f61383a;

    /* renamed from: b  reason: collision with root package name */
    public v f61384b;

    /* renamed from: c  reason: collision with root package name */
    public CJRBowsePlanGroupingListV8 f61385c;

    /* renamed from: d  reason: collision with root package name */
    public String f61386d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<CJRBrowsePlanProductList> f61387e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public f.a f61388f;

    /* renamed from: g  reason: collision with root package name */
    public Object f61389g;

    /* renamed from: h  reason: collision with root package name */
    private int f61390h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f61391i;

    public final View a(int i2) {
        if (this.f61391i == null) {
            this.f61391i = new HashMap();
        }
        View view = (View) this.f61391i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61391i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ah) {
            this.f61383a = ((ah) context).a();
        }
        if (getParentFragment() instanceof ah) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f61383a = ((ah) parentFragment).a();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f61390h = arguments.getInt(CLPConstants.ARGUMENT_KEY_POSITION);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_recommended_fragment_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f61387e.clear();
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f61385c;
        if (cJRBowsePlanGroupingListV8 != null) {
            List<CJRBrowsePlanProductList> productList = cJRBowsePlanGroupingListV8.getProductList();
            if (productList != null) {
                for (CJRBrowsePlanProductList add : productList) {
                    this.f61387e.add(add);
                }
            }
            if (cJRBowsePlanGroupingListV8.isStopLoading()) {
                a();
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            ArrayList<CJRBrowsePlanProductList> arrayList = this.f61387e;
            w.b bVar = this;
            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = this.f61385c;
            this.f61384b = new v(arrayList, bVar, cJRBowsePlanGroupingListV82 != null && cJRBowsePlanGroupingListV82.isOneToOne(), this.f61388f, this.f61389g, this.f61386d);
            RecyclerView recyclerView = (RecyclerView) a(R.id.browse_plan_recycler_view);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
            Integer hasMore = cJRBowsePlanGroupingListV8.getHasMore();
            if (hasMore != null && hasMore.intValue() == 1) {
                try {
                    RecyclerView recyclerView2 = (RecyclerView) a(R.id.browse_plan_recycler_view);
                    if (recyclerView2 != null) {
                        recyclerView2.addOnScrollListener(new a(linearLayoutManager, cJRBowsePlanGroupingListV8, linearLayoutManager, this));
                    }
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
            }
            RecyclerView recyclerView3 = (RecyclerView) a(R.id.browse_plan_recycler_view);
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(this.f61384b);
            }
        }
        if (this.f61387e.isEmpty()) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.layout_progress_bar);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            TextView textView = (TextView) a(R.id.plans_not_available);
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public static final class a extends ag {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBowsePlanGroupingListV8 f61392a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f61393b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f61394c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8, LinearLayoutManager linearLayoutManager2, r rVar) {
            super(linearLayoutManager);
            this.f61392a = cJRBowsePlanGroupingListV8;
            this.f61393b = linearLayoutManager2;
            this.f61394c = rVar;
        }

        public final void a(int i2) {
            d dVar = this.f61394c.f61383a;
            if (dVar != null) {
                String filter = this.f61392a.getFilter();
                k.a((Object) filter, "groupings.filter");
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                dVar.a("load_more_browse_plan", (ai) this.f61394c, i2, filter, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
            }
        }
    }

    public final void a() {
        List<CJRBrowsePlanProductList> productList;
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f61385c;
        if (cJRBowsePlanGroupingListV8 == null || !cJRBowsePlanGroupingListV8.isOneToOne()) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.layout_progress_bar);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = this.f61385c;
        Integer num = null;
        if ((cJRBowsePlanGroupingListV82 != null ? cJRBowsePlanGroupingListV82.getProductList() : null) != null) {
            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV83 = this.f61385c;
            if (!(cJRBowsePlanGroupingListV83 == null || (productList = cJRBowsePlanGroupingListV83.getProductList()) == null)) {
                num = Integer.valueOf(productList.size());
            }
            if (num == null) {
                k.a();
            }
            if (num.intValue() > 0) {
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.layout_progress_bar);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                    return;
                }
                return;
            }
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.layout_progress_bar);
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
        }
        ProgressBar progressBar = (ProgressBar) a(R.id.loading);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        TextView textView = (TextView) a(R.id.plans_not_available);
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void a(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "itemProduct");
        net.one97.paytm.recharge.common.c.f fVar = new net.one97.paytm.recharge.common.c.f(cJRBrowsePlanProductList, this);
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        f.a aVar = net.one97.paytm.recharge.common.c.f.f60991a;
        fVar.show(childFragmentManager, net.one97.paytm.recharge.common.c.f.f60992d);
    }

    public final void b(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "itemProduct");
        d dVar = this.f61383a;
        if (dVar != null) {
            dVar.a(cJRBrowsePlanProductList);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        CJRBrowsePlanResponseModelV8 cJRBrowsePlanResponseModelV8;
        List<CJRBowsePlanGroupingListV8> groupings;
        String productId;
        List<CJRBowsePlanGroupingListV8> groupings2;
        List<CJRBowsePlanGroupingListV8> groupings3;
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8;
        k.c(str, "tag");
        boolean z = iJRPaytmDataModel instanceof CJRBrowsePlanResponseModelV8;
        if (z && (groupings = cJRBrowsePlanResponseModelV8.getGroupings()) != null && !groupings.isEmpty()) {
            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = (cJRBrowsePlanResponseModelV8 = (CJRBrowsePlanResponseModelV8) iJRPaytmDataModel).getGroupings().get(0);
            k.a((Object) cJRBowsePlanGroupingListV82, "response.groupings[0]");
            List<CJRBrowsePlanProductList> productList = cJRBowsePlanGroupingListV82.getProductList();
            if (productList != null && !productList.isEmpty()) {
                d dVar = this.f61383a;
                if (dVar != null) {
                    net.one97.paytm.recharge.mobile.d.a aVar = (net.one97.paytm.recharge.mobile.d.a) dVar;
                    List<CJRBrowsePlanProductList> list = null;
                    if (!(obj instanceof CJRRechargeErrorModel)) {
                        obj = null;
                    }
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    if (!(cJRRechargeErrorModel == null || (productId = cJRRechargeErrorModel.getProductId()) == null || aVar.V.get(productId) == null)) {
                        WeakHashMap weakHashMap = aVar.V.get(productId);
                        CJRBrowsePlanResponseModelV8 cJRBrowsePlanResponseModelV82 = weakHashMap != null ? (CJRBrowsePlanResponseModelV8) weakHashMap.get(aVar.z.getValue()) : null;
                        if (cJRBrowsePlanResponseModelV82 != null && (groupings2 = cJRBrowsePlanResponseModelV82.getGroupings()) != null) {
                            Iterator<CJRBowsePlanGroupingListV8> it2 = groupings2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                CJRBowsePlanGroupingListV8 next = it2.next();
                                k.a((Object) next, "group");
                                String name = next.getName();
                                CJRBrowsePlanResponseModelV8 cJRBrowsePlanResponseModelV83 = (CJRBrowsePlanResponseModelV8) (!z ? null : iJRPaytmDataModel);
                                if (name.equals((cJRBrowsePlanResponseModelV83 == null || (groupings3 = cJRBrowsePlanResponseModelV83.getGroupings()) == null || (cJRBowsePlanGroupingListV8 = groupings3.get(0)) == null) ? null : cJRBowsePlanGroupingListV8.getName())) {
                                    list = next.getProductList();
                                    break;
                                }
                            }
                        }
                        if (iJRPaytmDataModel != null) {
                            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV83 = cJRBrowsePlanResponseModelV8.getGroupings().get(0);
                            k.a((Object) cJRBowsePlanGroupingListV83, "(response as CJRBrowsePl…onseModelV8).groupings[0]");
                            List<CJRBrowsePlanProductList> productList2 = cJRBowsePlanGroupingListV83.getProductList();
                            if (list != null) {
                                if (list != null) {
                                    ((ArrayList) list).addAll(productList2);
                                } else {
                                    throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList>");
                                }
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8");
                        }
                    }
                    v vVar = this.f61384b;
                    if (vVar != null) {
                        k.c(productList, "products");
                        for (CJRBrowsePlanProductList add : productList) {
                            vVar.f60697a.add(add);
                        }
                        vVar.notifyItemRangeInserted(vVar.f60697a.size(), productList.size());
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.mobile.viewmodel.CJRMobileRechargeViewModel");
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61391i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
