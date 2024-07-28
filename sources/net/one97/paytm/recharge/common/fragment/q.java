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
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.c.f;
import net.one97.paytm.recharge.common.e.ah;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.d;
import net.one97.paytm.recharge.common.utils.ag;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class q extends Fragment implements w.b, ai {

    /* renamed from: a  reason: collision with root package name */
    d f61374a;

    /* renamed from: b  reason: collision with root package name */
    public w f61375b;

    /* renamed from: c  reason: collision with root package name */
    public CJRBowsePlanGroupingListV8 f61376c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<CJRBrowsePlanProductList> f61377d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private int f61378e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f61379f;

    public final View a(int i2) {
        if (this.f61379f == null) {
            this.f61379f = new HashMap();
        }
        View view = (View) this.f61379f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61379f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ah) {
            this.f61374a = ((ah) context).a();
        }
        if (getParentFragment() instanceof ah) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f61374a = ((ah) parentFragment).a();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeViewModelActivity");
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f61378e = arguments.getInt(CLPConstants.ARGUMENT_KEY_POSITION);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.recommended_fragment_layout, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        this.f61377d.clear();
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f61376c;
        if (cJRBowsePlanGroupingListV8 != null) {
            List<CJRBrowsePlanProductList> productList = cJRBowsePlanGroupingListV8.getProductList();
            if (productList != null) {
                for (CJRBrowsePlanProductList add : productList) {
                    this.f61377d.add(add);
                }
            }
            if (cJRBowsePlanGroupingListV8.isStopLoading()) {
                a();
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            this.f61375b = new w(this.f61377d, this);
            RecyclerView recyclerView = (RecyclerView) a(R.id.browse_plan_recycler_view);
            k.a((Object) recyclerView, "browse_plan_recycler_view");
            recyclerView.setLayoutManager(linearLayoutManager);
            Integer hasMore = cJRBowsePlanGroupingListV8.getHasMore();
            if (hasMore != null && hasMore.intValue() == 1) {
                try {
                    ((RecyclerView) a(R.id.browse_plan_recycler_view)).addOnScrollListener(new a(linearLayoutManager, cJRBowsePlanGroupingListV8, linearLayoutManager, this));
                } catch (Throwable th) {
                    CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                }
            }
            RecyclerView recyclerView2 = (RecyclerView) a(R.id.browse_plan_recycler_view);
            k.a((Object) recyclerView2, "browse_plan_recycler_view");
            recyclerView2.setAdapter(this.f61375b);
        }
    }

    public static final class a extends ag {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBowsePlanGroupingListV8 f61380a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f61381b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q f61382c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8, LinearLayoutManager linearLayoutManager2, q qVar) {
            super(linearLayoutManager);
            this.f61380a = cJRBowsePlanGroupingListV8;
            this.f61381b = linearLayoutManager2;
            this.f61382c = qVar;
        }

        public final void a(int i2) {
            d dVar = this.f61382c.f61374a;
            if (dVar != null) {
                String filter = this.f61380a.getFilter();
                k.a((Object) filter, "groupings.filter");
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                dVar.a("load_more_browse_plan", (ai) this.f61382c, i2, filter, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
            }
        }
    }

    public final void a() {
        List<CJRBrowsePlanProductList> productList;
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV8 = this.f61376c;
        if (cJRBowsePlanGroupingListV8 == null || !cJRBowsePlanGroupingListV8.isOneToOne()) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.layout_progress_bar);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV82 = this.f61376c;
        Integer num = null;
        if ((cJRBowsePlanGroupingListV82 != null ? cJRBowsePlanGroupingListV82.getProductList() : null) != null) {
            CJRBowsePlanGroupingListV8 cJRBowsePlanGroupingListV83 = this.f61376c;
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
        f fVar = new f(cJRBrowsePlanProductList, this);
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        f.a aVar = f.f60991a;
        fVar.show(childFragmentManager, f.f60992d);
    }

    public final void b(CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "itemProduct");
        d dVar = this.f61374a;
        if (dVar != null) {
            dVar.a(cJRBrowsePlanProductList);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r3, com.paytm.network.model.IJRPaytmDataModel r4, java.lang.Object r5) {
        /*
            r2 = this;
            java.lang.String r5 = "tag"
            kotlin.g.b.k.c(r3, r5)
            boolean r3 = r4 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8
            if (r3 == 0) goto L_0x005f
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8 r4 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanResponseModelV8) r4
            java.util.List r3 = r4.getGroupings()
            if (r3 == 0) goto L_0x005f
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x005f
            java.util.List r3 = r4.getGroupings()
            r4 = 0
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r4 = "response.groupings[0]"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8 r3 = (net.one97.paytm.recharge.model.rechargeutility.CJRBowsePlanGroupingListV8) r3
            java.util.List r3 = r3.getProductList()
            if (r3 == 0) goto L_0x005f
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x005f
            net.one97.paytm.recharge.common.a.w r4 = r2.f61375b
            if (r4 == 0) goto L_0x005f
            java.lang.String r5 = "products"
            kotlin.g.b.k.c(r3, r5)
            java.util.Iterator r5 = r3.iterator()
        L_0x0040:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0052
            java.lang.Object r0 = r5.next()
            net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList r0 = (net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList) r0
            java.util.ArrayList<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r1 = r4.f60705a
            r1.add(r0)
            goto L_0x0040
        L_0x0052:
            java.util.ArrayList<net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList> r5 = r4.f60705a
            int r5 = r5.size()
            int r3 = r3.size()
            r4.notifyItemRangeInserted(r5, r3)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.fragment.q.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f61379f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
