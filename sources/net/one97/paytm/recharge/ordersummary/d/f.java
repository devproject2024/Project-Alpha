package net.one97.paytm.recharge.ordersummary.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.c.e;
import net.one97.paytm.recharge.common.e.ac;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.c.c;
import net.one97.paytm.recharge.ordersummary.c.g;
import net.one97.paytm.recharge.ordersummary.c.i;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.f.q;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargeFooterNavigationView;
import net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class f extends q implements ViewTreeObserver.OnScrollChangedListener, ac, net.one97.paytm.recharge.ordersummary.f.b, q, CJRInstantRefundWidget.d {
    private HashMap A;

    /* renamed from: a  reason: collision with root package name */
    boolean f64111a;

    /* renamed from: b  reason: collision with root package name */
    protected CJROrderedCart f64112b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Integer> f64113c = new ArrayList<>(3);

    /* renamed from: d  reason: collision with root package name */
    CJROSActionResponseV2 f64114d;

    /* renamed from: e  reason: collision with root package name */
    final io.reactivex.rxjava3.j.c<Object[]> f64115e;
    private boolean r;
    private net.one97.paytm.recharge.ordersummary.g.f s;
    private CJROrderActionsListView t;
    private net.one97.paytm.recharge.ordersummary.widget.a u;
    private final int v;
    private int w;
    private boolean x;
    private ScrollView y;
    private final a z;

    public View a(int i2) {
        if (this.A == null) {
            this.A = new HashMap();
        }
        View view = (View) this.A.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.A.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2) {
    }

    public boolean ax_() {
        return false;
    }

    public void b() {
        HashMap hashMap = this.A;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class e<T> implements io.reactivex.rxjava3.d.g<Object[]> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64127a;

        e(f fVar) {
            this.f64127a = fVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            Object[] objArr = (Object[]) obj;
            TextView textView = (TextView) this.f64127a.a(R.id.txt_status_header);
            if (textView != null) {
                Object obj2 = objArr[0];
                if (obj2 != null) {
                    textView.setText((String) obj2);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                }
            }
            TextView textView2 = (TextView) this.f64127a.a(R.id.txt_status_header);
            if (textView2 != null) {
                Context context = this.f64127a.getContext();
                if (context == null) {
                    k.a();
                }
                Object obj3 = objArr[1];
                if (obj3 != null) {
                    textView2.setBackgroundColor(androidx.core.content.b.c(context, ((Integer) obj3).intValue()));
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    public f() {
        io.reactivex.rxjava3.j.c<Object[]> a2 = io.reactivex.rxjava3.j.c.a();
        k.a((Object) a2, "ReplaySubject.create()");
        this.f64115e = a2;
        this.v = com.paytm.utility.b.c(100);
        this.x = true;
        this.z = new a(this);
    }

    /* access modifiers changed from: protected */
    public final void a(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "<set-?>");
        this.f64112b = cJROrderedCart;
    }

    /* access modifiers changed from: protected */
    public final CJROrderedCart d() {
        CJROrderedCart cJROrderedCart = this.f64112b;
        if (cJROrderedCart == null) {
            k.a("orderedItem");
        }
        return cJROrderedCart;
    }

    public static final class a extends RecyclerView.a<RecyclerView.v> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64116a;

        a(f fVar) {
            this.f64116a = fVar;
        }

        public final int getItemCount() {
            return this.f64116a.f64113c.size();
        }

        public final int getItemViewType(int i2) {
            return this.f64116a.b(i2);
        }

        public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            return this.f64116a.a(viewGroup, i2);
        }

        public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
            k.c(vVar, "holder");
            this.f64116a.a(vVar, i2);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f64111a = arguments != null ? arguments.getBoolean("recharge.show.item.details") : false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_base_os_failed_pending_v8, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        CJRBaseRechargeFooterNavigationView cJRBaseRechargeFooterNavigationView = (CJRBaseRechargeFooterNavigationView) a(R.id.bottom_navigation);
        k.a((Object) cJRBaseRechargeFooterNavigationView, "bottom_navigation");
        cJRBaseRechargeFooterNavigationView.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        super.onActivityCreated(bundle);
        CJROrderSummary cJROrderSummary = r().f63998b;
        if (cJROrderSummary == null) {
            k.a();
        }
        k.c(cJROrderSummary, "orderedSummary");
        this.n = cJROrderSummary;
        Bundle arguments = getArguments();
        this.f64111a = arguments != null ? arguments.getBoolean("recharge.show.item.details") : false;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("recharge_item") : null;
        if (serializable != null) {
            this.f64112b = (CJROrderedCart) serializable;
            HashMap<Long, CJROSActionResponseV2> hashMap = r().m;
            CJROrderedCart cJROrderedCart = this.f64112b;
            if (cJROrderedCart == null) {
                k.a("orderedItem");
            }
            this.f64114d = hashMap.get(Long.valueOf(cJROrderedCart.getId()));
            CJROrderSummary k = k();
            CJROrderedCart cJROrderedCart2 = this.f64112b;
            if (cJROrderedCart2 == null) {
                k.a("orderedItem");
            }
            a(k, cJROrderedCart2);
            if (!(getActivity() == null || ((FrameLayout) a(R.id.floating_nav_bar)) == null)) {
                this.y = (ScrollView) a(R.id.scroll_main);
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                FrameLayout frameLayout = (FrameLayout) a(R.id.floating_nav_bar);
                k.a((Object) frameLayout, "floating_nav_bar");
                this.u = new net.one97.paytm.recharge.ordersummary.widget.a(activity, frameLayout);
            }
            if (bundle != null) {
                this.r = bundle.getBoolean("isEnterTransitionEnded");
                if (this.f64114d == null && bundle.containsKey("tapActionRes")) {
                    Serializable serializable2 = bundle.getSerializable("tapActionRes");
                    if (!(serializable2 instanceof CJROSActionResponseV2)) {
                        serializable2 = null;
                    }
                    this.f64114d = (CJROSActionResponseV2) serializable2;
                    if (this.f64114d != null) {
                        Map map = r().m;
                        CJROrderedCart cJROrderedCart3 = this.f64112b;
                        if (cJROrderedCart3 == null) {
                            k.a("orderedItem");
                        }
                        map.put(Long.valueOf(cJROrderedCart3.getId()), this.f64114d);
                    }
                }
            }
            o();
            Context context = getContext();
            if (context != null) {
                a(new FrameLayout(context));
            }
            g();
            ScrollView scrollView = this.y;
            if (!(scrollView == null || (viewTreeObserver2 = scrollView.getViewTreeObserver()) == null)) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
            }
            ScrollView scrollView2 = this.y;
            if (scrollView2 != null && (viewTreeObserver = scrollView2.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnScrollChangedListener(this);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderedCart");
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putSerializable("tapActionRes", this.f64114d);
        bundle.putBoolean("isEnterTransitionEnded", this.r);
        super.onSaveInstanceState(bundle);
    }

    public void onScrollChanged() {
        ScrollView scrollView = this.y;
        this.w = Math.max(0, scrollView != null ? scrollView.getScrollY() : 0);
    }

    private void d(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderedSummary");
        this.f64113c.clear();
        if (cJROrderSummary.getOrderStatus() == 4 || cJROrderSummary.getOrderStatus() == 8) {
            this.f64113c.add(1);
        } else if (cJROrderSummary.getOrderStatus() == 2) {
            this.f64113c.add(0);
            CJROrderedCart cJROrderedCart = this.f64112b;
            if (cJROrderedCart == null) {
                k.a("orderedItem");
            }
            if (k.a((Object) cJROrderedCart.getItemStatus(), (Object) "7")) {
                this.f64113c.add(10);
                return;
            }
            net.one97.paytm.recharge.ordersummary.b.a r2 = r();
            CJROrderedCart cJROrderedCart2 = this.f64112b;
            if (cJROrderedCart2 == null) {
                k.a("orderedItem");
            }
            if (r2.b(cJROrderedCart2)) {
                this.f64113c.add(5);
                int w2 = w();
                if (w2 != -1) {
                    this.f64113c.add(Integer.valueOf(w2));
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.ordersummary.b.a r3 = r();
            CJROrderedCart cJROrderedCart3 = this.f64112b;
            if (cJROrderedCart3 == null) {
                k.a("orderedItem");
            }
            if (r3.a(cJROrderedCart3)) {
                CJROrderedCart cJROrderedCart4 = this.f64112b;
                if (cJROrderedCart4 == null) {
                    k.a("orderedItem");
                }
                if (k.a((Object) "34", (Object) cJROrderedCart4.getItemStatus())) {
                    this.f64113c.add(9);
                } else {
                    this.f64113c.add(3);
                }
                int w3 = w();
                if (w3 != -1) {
                    this.f64113c.add(Integer.valueOf(w3));
                    return;
                }
                return;
            }
            this.f64113c.add(4);
        } else {
            this.f64113c.add(2);
            this.f64113c.add(8);
        }
    }

    private int w() {
        net.one97.paytm.recharge.ordersummary.b.a r2 = r();
        CJROrderedCart cJROrderedCart = this.f64112b;
        if (cJROrderedCart == null) {
            k.a("orderedItem");
        }
        if (r2.d(cJROrderedCart)) {
            CJRRechargeUtilities.INSTANCE.debugLog("Merchant : IMPS Enabled");
            return 7;
        }
        net.one97.paytm.recharge.ordersummary.b.a r3 = r();
        IJRPaytmDataModel k = k();
        CJROrderedCart cJROrderedCart2 = this.f64112b;
        if (cJROrderedCart2 == null) {
            k.a("orderedItem");
        }
        if (r3.a(k, cJROrderedCart2)) {
            CJROrderedCart cJROrderedCart3 = this.f64112b;
            if (cJROrderedCart3 == null) {
                k.a("orderedItem");
            }
            CJRRefund refund = cJROrderedCart3.getRefund();
            k.a((Object) refund, "orderedItem.refund");
            Collection transactionDetails = refund.getTransactionDetails();
            if (!(transactionDetails == null || transactionDetails.isEmpty())) {
                return 6;
            }
            CJRRechargeUtilities.INSTANCE.debugLog("getRefundStatus : has refund description : no trxn detail");
            b((l) this);
            return 6;
        }
        CJRRechargeUtilities.INSTANCE.debugLog("getRefundStatus : in has no refund description");
        b((l) this);
        return -1;
    }

    /* access modifiers changed from: protected */
    public final int b(int i2) {
        Integer num = this.f64113c.get(i2);
        k.a((Object) num, "statusList[position]");
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public RecyclerView.v a(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 != 6) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_status_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…atus_item, parent, false)");
            net.one97.paytm.recharge.ordersummary.b.a r2 = r();
            CJROrderedCart cJROrderedCart = this.f64112b;
            if (cJROrderedCart == null) {
                k.a("orderedItem");
            }
            return new net.one97.paytm.recharge.ordersummary.e.c(inflate, r2, cJROrderedCart, this.f64114d, this.f64111a, this.f64115e, this);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_os_refund_status_list, viewGroup, false);
        k.a((Object) inflate2, "LayoutInflater.from(pare…atus_list, parent, false)");
        net.one97.paytm.recharge.ordersummary.b.a r3 = r();
        CJROrderedCart cJROrderedCart2 = this.f64112b;
        if (cJROrderedCart2 == null) {
            k.a("orderedItem");
        }
        return new net.one97.paytm.recharge.ordersummary.e.b(inflate2, r3, cJROrderedCart2, this.f64114d, this.f64111a, this.f64115e, this);
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof net.one97.paytm.recharge.ordersummary.e.c) {
            ((net.one97.paytm.recharge.ordersummary.e.c) vVar).a(b(i2));
        } else if (vVar instanceof net.one97.paytm.recharge.ordersummary.e.b) {
            b(i2);
            ((net.one97.paytm.recharge.ordersummary.e.b) vVar).a();
        }
    }

    public void a(CJROrderSummary cJROrderSummary) {
        Object obj;
        ArrayList<CJRTransactionDetails> transactionDetails;
        boolean z2;
        k.c(cJROrderSummary, "orderSummary");
        if (getActivity() != null && getContext() != null && isAdded()) {
            ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
            k.a((Object) orderedCartList, "orderSummary.orderedCartList");
            Iterator it2 = orderedCartList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                CJROrderedCart cJROrderedCart = (CJROrderedCart) obj;
                k.a((Object) cJROrderedCart, "it");
                long id = cJROrderedCart.getId();
                CJROrderedCart cJROrderedCart2 = this.f64112b;
                if (cJROrderedCart2 == null) {
                    k.a("orderedItem");
                }
                if (id == cJROrderedCart2.getId()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            CJROrderedCart cJROrderedCart3 = (CJROrderedCart) obj;
            if (cJROrderedCart3 != null) {
                this.f64112b = cJROrderedCart3;
                ArrayList arrayList = new ArrayList(this.f64113c);
                d(cJROrderSummary);
                Iterator it3 = arrayList.iterator();
                boolean z3 = false;
                int i2 = 0;
                while (it3.hasNext()) {
                    it3.next();
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    if (i2 <= 1 && i2 < this.f64113c.size()) {
                        z3 = !k.a((Object) (Integer) arrayList.get(i2), (Object) this.f64113c.get(i2));
                    }
                    i2 = i3;
                }
                if (z3) {
                    CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : open new status screen");
                    if (!this.f64111a) {
                        super.a(cJROrderSummary);
                    } else if (!k.a((Object) cJROrderedCart3.getItemStatus(), (Object) "7")) {
                        Bundle bundle = new Bundle();
                        r().m.remove(Long.valueOf(cJROrderedCart3.getId()));
                        bundle.putString("recharge.component.name", f.class.getName());
                        a(r(), cJROrderedCart3, bundle);
                    } else {
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    }
                } else if (arrayList.size() != this.f64113c.size()) {
                    CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : has refund description");
                    this.z.notifyItemRangeChanged(0, this.f64113c.size());
                } else {
                    CJRRefund refund = cJROrderedCart3.getRefund();
                    if (refund != null && (transactionDetails = refund.getTransactionDetails()) != null && (!transactionDetails.isEmpty())) {
                        CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : has refund description & trxn detail");
                        this.z.notifyItemChanged(this.f64113c.size() - 1);
                    } else if ((!k.a((Object) cJROrderedCart3.getItemStatus(), (Object) "7")) && !r().b(cJROrderedCart3) && !r().a(cJROrderedCart3)) {
                        if (!r().s && !this.f64111a) {
                            return;
                        }
                        if (this.f64111a) {
                            b((l) this);
                        } else if (this.f64183h <= 3.0d) {
                            CJRRechargeUtilities.INSTANCE.debugLog("Post : onOrderSummaryLoaded : pool for pending order");
                            super.a(cJROrderSummary);
                        }
                    }
                }
            } else {
                CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : open new status screen");
                if (!this.f64111a) {
                    super.a(cJROrderSummary);
                    return;
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.onBackPressed();
                }
            }
        }
    }

    public final void b(l lVar) {
        long u2 = u();
        CJRRechargeUtilities.INSTANCE.debugLog("Post: Order Pending Screen : exponentialBackOff:".concat(String.valueOf(u2)));
        View view = getView();
        if (view != null) {
            view.postDelayed(new g(this, lVar), u2);
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f64133b;

        g(f fVar, l lVar) {
            this.f64132a = fVar;
            this.f64133b = lVar;
        }

        public final void run() {
            f fVar = this.f64132a;
            l lVar = this.f64133b;
            if (lVar == null) {
                lVar = fVar;
            }
            fVar.a(lVar);
        }
    }

    public final void a(Context context, ViewGroup viewGroup, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(cJROrderSummary, "orderSummary");
        CJRRechargeUtilities.INSTANCE.debugLog("Did Nothing when Pending screen refreshed self");
        d(k());
        this.z.notifyItemRangeChanged(0, this.f64113c.size());
        o();
    }

    public final void a(Context context, ViewGroup viewGroup, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, r rVar, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(cJROrderSummary, "orderSummary");
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog(f.class.getName() + " : getFailedOrderSummaryLayout");
        super.a(context, viewGroup, cJROrderSummary, cJROSActionResponseV2, rVar, onClickListener);
        o();
    }

    public CJROrderActionsListView getOrderActionClickListener() {
        return this.t;
    }

    /* access modifiers changed from: protected */
    public void h() {
        boolean z2 = false;
        if (this.f64111a) {
            i iVar = this.m;
            if (iVar != null) {
                iVar.f64077c = false;
                return;
            }
            return;
        }
        i iVar2 = this.m;
        if (iVar2 != null) {
            if (k().getOrderStatus() == 2) {
                z2 = true;
            }
            iVar2.f64077c = z2;
        }
    }

    public final void f(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        h();
        super.f(cJROrderedCart);
    }

    public final void a(DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener, String str) {
        k.c(cJROrderSummaryAction, "action");
        k.c(str, "from");
        try {
            at_();
            CJRRechargeUtilities.INSTANCE.debugLog("Cancel Order");
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.OS_CTA_CANCEL.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setOtherDetails(str);
            }
            b.a aVar = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b.a.a(context, r().s).a("tap_action", cJROrderSummaryAction, a2, new C1261f(this, dialogInterface, onDismissListener, cJROrderSummaryAction));
        } catch (Exception unused) {
            CJRRechargeUtilities.INSTANCE.debugLog("Failed to Cancel Order: Exception");
            if (!(dialogInterface == null || onDismissListener == null)) {
                onDismissListener.onDismiss(dialogInterface);
            }
            o();
        }
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.d.f$f  reason: collision with other inner class name */
    public static final class C1261f implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64128a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DialogInterface f64129b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f64130c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64131d;

        C1261f(f fVar, DialogInterface dialogInterface, DialogInterface.OnDismissListener onDismissListener, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64128a = fVar;
            this.f64129b = dialogInterface;
            this.f64130c = onDismissListener;
            this.f64131d = cJROrderSummaryAction;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            DialogInterface.OnDismissListener onDismissListener;
            DialogInterface.OnDismissListener onDismissListener2;
            k.c(str, "tag");
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                try {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    Context context = this.f64128a.getContext();
                    if (!(context instanceof Activity)) {
                        context = null;
                    }
                    Activity activity = (Activity) context;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                    CJRRechargeUtilities.handleError$default(cJRRechargeUtilities, str, activity, (Fragment) null, networkCustomError, false, net.one97.paytm.recharge.ordersummary.h.c.f64332b, obj, 20, (Object) null);
                } catch (Throwable unused) {
                }
                DialogInterface dialogInterface = this.f64129b;
                if (!(dialogInterface == null || (onDismissListener2 = this.f64130c) == null)) {
                    onDismissListener2.onDismiss(dialogInterface);
                }
                this.f64128a.o();
            } else if (k.a((Object) CJROSActionItemV2.Companion.getACTION_TYPE_CANCEL_ORDER_ITEM(), (Object) this.f64131d.getmType())) {
                this.f64128a.v();
            } else {
                DialogInterface dialogInterface2 = this.f64129b;
                if (!(dialogInterface2 == null || (onDismissListener = this.f64130c) == null)) {
                    onDismissListener.onDismiss(dialogInterface2);
                }
                this.f64128a.o();
            }
            if ((obj instanceof CJRRechargeErrorModel) && !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || p.a(errorMsg)) {
                    cJRRechargeErrorModel.setErrorMsg("Cancel order api error " + this.f64131d.getmType());
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            DialogInterface.OnDismissListener onDismissListener;
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                this.f64128a.v();
            }
            DialogInterface dialogInterface = this.f64129b;
            if (dialogInterface != null && (onDismissListener = this.f64130c) != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        String str;
        String str2;
        String str3;
        String str4;
        CJROrderSummaryAction cJROrderSummaryAction2 = cJROrderSummaryAction;
        DialogInterface.OnDismissListener onDismissListener2 = onDismissListener;
        k.c(cJROrderSummaryAction2, "action");
        String str5 = null;
        try {
            String valueOf = String.valueOf(r().f63997a);
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.c(getContext(), ba.i(valueOf), SDKConstants.AI_CANCEL_TRANSACTION_CLICKED, (String) null);
        } catch (Throwable unused) {
        }
        if (2 == k().getOrderStatus()) {
            net.one97.paytm.recharge.ordersummary.b.a r2 = r();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            CJROrderedCart cJROrderedCart = this.f64112b;
            if (cJROrderedCart == null) {
                k.a("orderedItem");
            }
            if (r2.n(context, cJROrderedCart)) {
                k.c(cJROrderSummaryAction2, "action");
                CJROrderedCart cJROrderedCart2 = this.f64112b;
                if (cJROrderedCart2 == null) {
                    k.a("orderedItem");
                }
                CJROrderSummaryProductDetail productDetail = cJROrderedCart2.getProductDetail();
                String valueOf2 = String.valueOf(productDetail != null ? Long.valueOf(productDetail.getCategoryId()) : null);
                c.a aVar = net.one97.paytm.recharge.ordersummary.c.c.f64038b;
                net.one97.paytm.recharge.ordersummary.b.a r3 = r();
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "context!!");
                CJROrderedCart cJROrderedCart3 = this.f64112b;
                if (cJROrderedCart3 == null) {
                    k.a("orderedItem");
                }
                String a2 = r3.a(context2, cJROrderedCart3);
                Context context3 = getContext();
                String string = context3 != null ? context3.getString(R.string.v8_os_cancel_insurence_pst_btn_txt) : null;
                if (string == null) {
                    k.a();
                }
                k.a((Object) string, "context?.getString(R.str…_insurence_pst_btn_txt)!!");
                Context context4 = getContext();
                String string2 = context4 != null ? context4.getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt) : null;
                if (string2 == null) {
                    k.a();
                }
                net.one97.paytm.recharge.ordersummary.b.a r4 = r();
                Context context5 = getContext();
                if (context5 == null) {
                    k.a();
                }
                k.a((Object) context5, "context!!");
                String str6 = r4.f(context5).get(0);
                Context context6 = getContext();
                if (context6 != null) {
                    int i2 = R.string.v8_os_cancel_unsurence_sub_msg;
                    Object[] objArr = new Object[1];
                    net.one97.paytm.recharge.ordersummary.b.a r5 = r();
                    Context context7 = getContext();
                    if (context7 == null) {
                        k.a();
                    }
                    k.a((Object) context7, "context!!");
                    CJROrderedCart cJROrderedCart4 = this.f64112b;
                    if (cJROrderedCart4 == null) {
                        k.a("orderedItem");
                    }
                    objArr[0] = r5.b(context7, cJROrderedCart4);
                    str5 = context6.getString(i2, objArr);
                }
                if (str5 == null) {
                    k.a();
                }
                k.a((Object) str5, "context?.getString(R.str…ontext!!, orderedItem))!!");
                CJROrderedCart cJROrderedCart5 = this.f64112b;
                if (cJROrderedCart5 == null) {
                    k.a("orderedItem");
                }
                net.one97.paytm.recharge.ordersummary.c.c a3 = c.a.a(a2, string, string2, str6, str5, String.valueOf(cJROrderedCart5.getSubTotal()));
                a3.f64228c = new h(this, valueOf2, onDismissListener2, cJROrderSummaryAction2);
                a3.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
                return;
            }
        }
        if (k.a((Object) CJROSActionItemV2.Companion.getACTION_TYPE_CANCEL_ORDER_ITEM(), (Object) cJROrderSummaryAction.getmType())) {
            c.a aVar2 = net.one97.paytm.recharge.ordersummary.c.c.f64038b;
            net.one97.paytm.recharge.ordersummary.b.a r6 = r();
            Context context8 = getContext();
            if (context8 == null) {
                k.a();
            }
            k.a((Object) context8, "context!!");
            CJROrderedCart cJROrderedCart6 = this.f64112b;
            if (cJROrderedCart6 == null) {
                k.a("orderedItem");
            }
            String a4 = r6.a(context8, cJROrderedCart6);
            Context context9 = getContext();
            String string3 = context9 != null ? context9.getString(R.string.v8_os_cancel_insurence_pst_btn_txt) : null;
            if (string3 == null) {
                k.a();
            }
            k.a((Object) string3, "context?.getString(R.str…_insurence_pst_btn_txt)!!");
            Context context10 = getContext();
            String string4 = context10 != null ? context10.getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt) : null;
            if (string4 == null) {
                k.a();
            }
            Context context11 = getContext();
            if (context11 != null) {
                int i3 = R.string.v8_os_cancel_confirmation_msg_to_original_source_if_completed;
                Object[] objArr2 = new Object[1];
                net.one97.paytm.recharge.ordersummary.b.a r7 = r();
                Context context12 = getContext();
                if (context12 == null) {
                    k.a();
                }
                k.a((Object) context12, "context!!");
                CJROrderedCart cJROrderedCart7 = this.f64112b;
                if (cJROrderedCart7 == null) {
                    k.a("orderedItem");
                }
                objArr2[0] = r7.b(context12, cJROrderedCart7);
                str3 = context11.getString(i3, objArr2);
            } else {
                str3 = null;
            }
            if (str3 == null) {
                k.a();
            }
            k.a((Object) str3, "context?.getString(R.str…ontext!!, orderedItem))!!");
            Context context13 = getContext();
            if (context13 != null) {
                int i4 = R.string.v8_os_cancel_unsurence_sub_msg;
                Object[] objArr3 = new Object[1];
                net.one97.paytm.recharge.ordersummary.b.a r8 = r();
                Context context14 = getContext();
                if (context14 == null) {
                    k.a();
                }
                k.a((Object) context14, "context!!");
                CJROrderedCart cJROrderedCart8 = this.f64112b;
                if (cJROrderedCart8 == null) {
                    k.a("orderedItem");
                }
                objArr3[0] = r8.b(context14, cJROrderedCart8);
                str4 = context13.getString(i4, objArr3);
            } else {
                str4 = null;
            }
            if (str4 == null) {
                k.a();
            }
            k.a((Object) str4, "context?.getString(R.str…ontext!!, orderedItem))!!");
            net.one97.paytm.recharge.ordersummary.c.c a5 = c.a.a(a4, string3, string4, str3, str4, "");
            a5.f64228c = new c(this, onDismissListener2, cJROrderSummaryAction2);
            a5.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
            return;
        }
        c.a aVar3 = net.one97.paytm.recharge.ordersummary.c.c.f64038b;
        net.one97.paytm.recharge.ordersummary.b.a r9 = r();
        Context context15 = getContext();
        if (context15 == null) {
            k.a();
        }
        k.a((Object) context15, "context!!");
        CJROrderedCart cJROrderedCart9 = this.f64112b;
        if (cJROrderedCart9 == null) {
            k.a("orderedItem");
        }
        String a6 = r9.a(context15, cJROrderedCart9);
        Context context16 = getContext();
        String string5 = context16 != null ? context16.getString(R.string.v8_os_cancel_insurence_pst_btn_txt) : null;
        if (string5 == null) {
            k.a();
        }
        k.a((Object) string5, "context?.getString(R.str…_insurence_pst_btn_txt)!!");
        Context context17 = getContext();
        String string6 = context17 != null ? context17.getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt) : null;
        if (string6 == null) {
            k.a();
        }
        Context context18 = getContext();
        if (context18 != null) {
            int i5 = R.string.v8_os_cancel_confirmation_msg_to_original_source;
            Object[] objArr4 = new Object[1];
            net.one97.paytm.recharge.ordersummary.b.a r10 = r();
            Context context19 = getContext();
            if (context19 == null) {
                k.a();
            }
            k.a((Object) context19, "context!!");
            CJROrderedCart cJROrderedCart10 = this.f64112b;
            if (cJROrderedCart10 == null) {
                k.a("orderedItem");
            }
            objArr4[0] = r10.b(context19, cJROrderedCart10);
            str = context18.getString(i5, objArr4);
        } else {
            str = null;
        }
        if (str == null) {
            k.a();
        }
        k.a((Object) str, "context?.getString(R.str…ontext!!, orderedItem))!!");
        Context context20 = getContext();
        if (context20 != null) {
            int i6 = R.string.v8_os_cancel_unsurence_sub_msg;
            Object[] objArr5 = new Object[1];
            net.one97.paytm.recharge.ordersummary.b.a r11 = r();
            Context context21 = getContext();
            if (context21 == null) {
                k.a();
            }
            k.a((Object) context21, "context!!");
            CJROrderedCart cJROrderedCart11 = this.f64112b;
            if (cJROrderedCart11 == null) {
                k.a("orderedItem");
            }
            objArr5[0] = r11.b(context21, cJROrderedCart11);
            str2 = context20.getString(i6, objArr5);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            k.a();
        }
        k.a((Object) str2, "context?.getString(R.str…ontext!!, orderedItem))!!");
        CJROrderedCart cJROrderedCart12 = this.f64112b;
        if (cJROrderedCart12 == null) {
            k.a("orderedItem");
        }
        net.one97.paytm.recharge.ordersummary.c.c a7 = c.a.a(a6, string5, string6, str, str2, String.valueOf(cJROrderedCart12.getSubTotal()));
        a7.f64228c = new d(this, onDismissListener2, cJROrderSummaryAction2);
        a7.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64121a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f64122b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64123c;

        c(f fVar, DialogInterface.OnDismissListener onDismissListener, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64121a = fVar;
            this.f64122b = onDismissListener;
            this.f64123c = cJROrderSummaryAction;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                DialogInterface.OnDismissListener onDismissListener = this.f64122b;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialogInterface);
                    return;
                }
                return;
            }
            this.f64121a.a(dialogInterface, this.f64123c, this.f64122b, "from payment pending cancel");
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f64125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64126c;

        d(f fVar, DialogInterface.OnDismissListener onDismissListener, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64124a = fVar;
            this.f64125b = onDismissListener;
            this.f64126c = cJROrderSummaryAction;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                DialogInterface.OnDismissListener onDismissListener = this.f64125b;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialogInterface);
                    return;
                }
                return;
            }
            this.f64124a.a(dialogInterface, this.f64126c, this.f64125b, "from operator pending cancel");
        }
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        if (isAdded() && getContext() != null) {
            g.a aVar = net.one97.paytm.recharge.ordersummary.c.g.f64067a;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            String string = context.getString(R.string.v8_os_action_money_deducted);
            k.a((Object) string, "context!!.getString(R.st…os_action_money_deducted)");
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            String string2 = context2.getString(R.string.okay_got_it);
            net.one97.paytm.recharge.ordersummary.b.a r2 = r();
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            k.a((Object) context3, "context!!");
            net.one97.paytm.recharge.ordersummary.c.g a2 = g.a.a(string, string2, r2.e(context3));
            a2.f64228c = onClickListener;
            a2.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.g.class.getSimpleName());
        }
    }

    public final void a(DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction, DialogInterface.OnDismissListener onDismissListener) {
        k.c(cJROrderSummaryAction, "action");
        at_();
        if (this.s == null) {
            t.b bVar = new b(this, onDismissListener, dialogInterface, cJROrderSummaryAction);
            e.a aVar = net.one97.paytm.recharge.common.b.c.e.f60936b;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            this.s = new net.one97.paytm.recharge.ordersummary.g.f(bVar, e.a.a(context), k());
        }
        net.one97.paytm.recharge.ordersummary.g.f fVar = this.s;
        if (fVar != null) {
            fVar.a(0, (String) null);
        }
    }

    public static final class b implements t.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f64118b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DialogInterface f64119c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64120d;

        public final void a(int i2, int i3) {
        }

        b(f fVar, DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64117a = fVar;
            this.f64118b = onDismissListener;
            this.f64119c = dialogInterface;
            this.f64120d = cJROrderSummaryAction;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel, Integer num) {
            this.f64117a.o();
            DialogInterface.OnDismissListener onDismissListener = this.f64118b;
            if (onDismissListener != null) {
                onDismissListener.onDismiss((DialogInterface) null);
            }
            this.f64117a.a(iJRPaytmDataModel, num, this.f64119c, this.f64120d, this.f64118b);
        }

        public final void a(NetworkCustomError networkCustomError, Integer num) {
            k.c(networkCustomError, "error");
            this.f64117a.o();
            DialogInterface.OnDismissListener onDismissListener = this.f64118b;
            if (onDismissListener != null) {
                onDismissListener.onDismiss((DialogInterface) null);
            }
            f fVar = this.f64117a;
            k.c(networkCustomError, "error");
            if (num != null && num.intValue() == 0) {
                String alertMessage = !TextUtils.isEmpty(networkCustomError.getAlertMessage()) ? networkCustomError.getAlertMessage() : null;
                String alertTitle = TextUtils.isEmpty(networkCustomError.getAlertTitle()) ? networkCustomError.getAlertTitle() : null;
                if (TextUtils.isEmpty(networkCustomError.getMessage()) || !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError) || fVar.getContext() == null) {
                    ba.a(fVar.getContext(), alertMessage, alertTitle);
                    return;
                }
                try {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    Context context = fVar.getContext();
                    if (!(context instanceof Activity)) {
                        context = null;
                    }
                    c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                    CJRRechargeUtilities.handleError$default(cJRRechargeUtilities, (String) null, (Activity) context, (Fragment) null, networkCustomError, false, net.one97.paytm.recharge.ordersummary.h.c.f64332b, (Object) null, 20, (Object) null);
                } catch (Throwable unused) {
                }
            }
        }
    }

    static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f64134a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f64135b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnDismissListener f64136c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64137d;

        h(f fVar, String str, DialogInterface.OnDismissListener onDismissListener, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64134a = fVar;
            this.f64135b = str;
            this.f64136c = onDismissListener;
            this.f64137d = cJROrderSummaryAction;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                try {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.c(this.f64134a.getContext(), ba.i(this.f64135b), "popup_wait_for_confirmation_clicked", (String) null);
                } catch (Throwable unused) {
                }
                DialogInterface.OnDismissListener onDismissListener = this.f64136c;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(dialogInterface);
                    return;
                }
                return;
            }
            try {
                net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                net.one97.paytm.recharge.di.helper.b.c(this.f64134a.getContext(), ba.i(this.f64135b), "popup_cancel_clicked", (String) null);
            } catch (Throwable unused2) {
            }
            this.f64134a.a(dialogInterface, this.f64137d, this.f64136c);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f9 A[Catch:{ Exception -> 0x00ff }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r9, java.lang.Integer r10, android.content.DialogInterface r11, net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r12, android.content.DialogInterface.OnDismissListener r13) {
        /*
            r8 = this;
            java.lang.String r0 = "action"
            kotlin.g.b.k.c(r12, r0)
            if (r10 != 0) goto L_0x0008
            return
        L_0x0008:
            int r10 = r10.intValue()
            if (r10 != 0) goto L_0x0106
            if (r9 == 0) goto L_0x0106
            boolean r10 = r9 instanceof net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8
            r0 = 0
            if (r10 != 0) goto L_0x0016
            r9 = r0
        L_0x0016:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r9 = (net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8) r9
            r10 = 0
            if (r9 == 0) goto L_0x0073
            r1 = 1
            java.util.List r2 = r9.getOtherRefundConsultView()     // Catch:{ Exception -> 0x0073 }
            if (r2 == 0) goto L_0x0073
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0073 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0073 }
            r3 = 0
            r4 = 0
        L_0x002a:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0071
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x0071 }
            int r6 = r4 + 1
            if (r4 >= 0) goto L_0x003b
            kotlin.a.k.a()     // Catch:{ Exception -> 0x0071 }
        L_0x003b:
            net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8 r5 = (net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8) r5     // Catch:{ Exception -> 0x0071 }
            java.lang.String r4 = "TO_INSTANT"
            java.lang.String r7 = r5.getDestination()     // Catch:{ Exception -> 0x0071 }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x006f
            java.lang.String r4 = "true"
            java.lang.String r7 = r5.getEnableStatus()     // Catch:{ Exception -> 0x0071 }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x0058
            r4 = r6
            r3 = 1
            goto L_0x002a
        L_0x0058:
            java.lang.String r4 = "IMPS_ACCOUNT_NOT_EXIST"
            java.lang.String r5 = r5.getDisableReason()     // Catch:{ Exception -> 0x0071 }
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r1)     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x006f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x006d }
            r9.setStatus(r3)     // Catch:{ Exception -> 0x006d }
            r3 = 1
            goto L_0x006f
        L_0x006d:
            goto L_0x0074
        L_0x006f:
            r4 = r6
            goto L_0x002a
        L_0x0071:
            r1 = r3
            goto L_0x0074
        L_0x0073:
            r1 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x00f9
            if (r9 == 0) goto L_0x008c
            net.one97.paytm.common.entity.shopping.CJROrderedCart r11 = r8.f64112b     // Catch:{ Exception -> 0x00ff }
            if (r11 != 0) goto L_0x0081
            java.lang.String r13 = "orderedItem"
            kotlin.g.b.k.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00ff }
        L_0x0081:
            double r1 = r11.getSubTotal()     // Catch:{ Exception -> 0x00ff }
            java.lang.Double r11 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x00ff }
            r9.setRefundAmount(r11)     // Catch:{ Exception -> 0x00ff }
        L_0x008c:
            if (r9 == 0) goto L_0x00b3
            android.content.Context r11 = r8.getContext()     // Catch:{ Exception -> 0x00ff }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r12 = r12.getUrlParams()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r13 = "action.urlParams"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r12 = r12.getUrl()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r11 = com.paytm.utility.b.c((android.content.Context) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r12 = "CJRAppCommonUtility.addS…xt, action.urlParams.url)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r12 = " "
            java.lang.String r13 = "%20"
            java.lang.String r10 = kotlin.m.p.a(r11, r12, r13, r10)     // Catch:{ Exception -> 0x00ff }
            r9.setCancelUrl(r10)     // Catch:{ Exception -> 0x00ff }
        L_0x00b3:
            if (r9 == 0) goto L_0x00c0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.k()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x00ff }
            r9.setOrderId(r10)     // Catch:{ Exception -> 0x00ff }
        L_0x00c0:
            if (r9 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.k()     // Catch:{ Exception -> 0x00ff }
            r9.setOrderSummary(r10)     // Catch:{ Exception -> 0x00ff }
        L_0x00c9:
            androidx.fragment.app.j r10 = r8.getChildFragmentManager()     // Catch:{ Exception -> 0x00ff }
            java.lang.String r11 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x00ff }
            net.one97.paytm.recharge.ordersummary.c.f$a r11 = net.one97.paytm.recharge.ordersummary.c.f.f64058b     // Catch:{ Exception -> 0x00ff }
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9     // Catch:{ Exception -> 0x00ff }
            net.one97.paytm.recharge.ordersummary.b.a r11 = r8.r()     // Catch:{ Exception -> 0x00ff }
            if (r11 == 0) goto L_0x00e5
            boolean r11 = r11.a()     // Catch:{ Exception -> 0x00ff }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ Exception -> 0x00ff }
            goto L_0x00e6
        L_0x00e5:
            r11 = r0
        L_0x00e6:
            net.one97.paytm.recharge.ordersummary.c.f r9 = net.one97.paytm.recharge.ordersummary.c.f.a.a(r9, r11)     // Catch:{ Exception -> 0x00ff }
            r11 = r8
            net.one97.paytm.recharge.ordersummary.f.q r11 = (net.one97.paytm.recharge.ordersummary.f.q) r11     // Catch:{ Exception -> 0x00ff }
            r9.f64061a = r11     // Catch:{ Exception -> 0x00ff }
            java.lang.Class<net.one97.paytm.recharge.ordersummary.c.f> r11 = net.one97.paytm.recharge.ordersummary.c.f.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ Exception -> 0x00ff }
            r9.show((androidx.fragment.app.j) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x00ff }
            return
        L_0x00f9:
            java.lang.String r9 = "from instant refund api"
            r8.a(r11, r12, r13, r9)     // Catch:{ Exception -> 0x00ff }
            return
        L_0x00ff:
            android.content.Context r9 = r8.getContext()
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r0)
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.f.a(com.paytm.network.model.IJRPaytmDataModel, java.lang.Integer, android.content.DialogInterface, net.one97.paytm.common.entity.shopping.CJROrderSummaryAction, android.content.DialogInterface$OnDismissListener):void");
    }

    public final void v() {
        CJRRechargeUtilities.INSTANCE.debugLog("onRefreshAfterImpsCancel : request fresh instant");
        x();
        a((l) this);
    }

    public final void j() {
        at_();
    }

    public final void a(Boolean bool) {
        if (bool == null) {
            k.a();
        }
        if (!bool.booleanValue()) {
            o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        r5 = r5.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "actionType"
            kotlin.g.b.k.c(r5, r0)
            android.content.Context r0 = r4.getContext()
            boolean r0 = r0 instanceof net.one97.paytm.recharge.ordersummary.f.n
            if (r0 == 0) goto L_0x0079
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r0 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r0 = r0.getACTION_TYPE_SHARE()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r0)
            java.lang.String r0 = "orderedItem"
            java.lang.String r1 = ""
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen"
            if (r5 == 0) goto L_0x0045
            android.content.Context r5 = r4.getContext()
            if (r5 == 0) goto L_0x003f
            net.one97.paytm.recharge.ordersummary.f.n r5 = (net.one97.paytm.recharge.ordersummary.f.n) r5
            if (r6 != 0) goto L_0x0034
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = r4.f64112b
            if (r6 != 0) goto L_0x0030
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0030:
            java.lang.String r6 = r6.getName()
        L_0x0034:
            if (r6 != 0) goto L_0x0037
            r6 = r1
        L_0x0037:
            android.view.View r0 = r4.getView()
            r5.a(r6, r0)
            return
        L_0x003f:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r2)
            throw r5
        L_0x0045:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            if (r5 == 0) goto L_0x0056
            android.view.Window r5 = r5.getWindow()
            if (r5 == 0) goto L_0x0056
            android.view.View r5 = r5.getDecorView()
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            android.content.Context r3 = r4.getContext()
            if (r3 == 0) goto L_0x0073
            net.one97.paytm.recharge.ordersummary.f.n r3 = (net.one97.paytm.recharge.ordersummary.f.n) r3
            if (r6 != 0) goto L_0x006c
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = r4.f64112b
            if (r6 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0068:
            java.lang.String r6 = r6.getName()
        L_0x006c:
            if (r6 != 0) goto L_0x006f
            r6 = r1
        L_0x006f:
            r3.a(r6, r5)
            goto L_0x0079
        L_0x0073:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r2)
            throw r5
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.f.a(java.lang.String, java.lang.String):void");
    }

    public void onClick(View view) {
        k.c(view, "v");
        if (view.getId() == R.id.share) {
            CJROrderActionsListView cJROrderActionsListView = this.t;
            if (cJROrderActionsListView != null) {
                cJROrderActionsListView.onClick(view);
                return;
            }
            return;
        }
        super.onClick(view);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r19 = this;
            r0 = r19
            net.one97.paytm.recharge.ordersummary.b.a r1 = r19.r()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r1.f63998b
            if (r1 != 0) goto L_0x000d
            kotlin.g.b.k.a()
        L_0x000d:
            java.util.ArrayList r1 = r1.getOrderAction()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64112b
            java.lang.String r3 = "orderedItem"
            if (r2 != 0) goto L_0x001a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x001a:
            java.util.ArrayList r2 = r2.getAction()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r0.f64112b
            if (r4 != 0) goto L_0x0025
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0025:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r4 = r4.getTapAction()
            r5 = 1
            if (r4 != 0) goto L_0x016d
            if (r1 == 0) goto L_0x0038
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r5
            if (r4 == r5) goto L_0x0043
        L_0x0038:
            if (r2 == 0) goto L_0x016d
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r5
            if (r2 != r5) goto L_0x016d
        L_0x0043:
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            if (r1 == 0) goto L_0x00d4
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r1 = r1.iterator()
        L_0x0057:
            boolean r6 = r1.hasNext()
            java.lang.String r7 = "it"
            if (r6 == 0) goto L_0x007d
            java.lang.Object r6 = r1.next()
            r8 = r6
            net.one97.paytm.common.entity.shopping.CJRAction r8 = (net.one97.paytm.common.entity.shopping.CJRAction) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            java.lang.String r7 = r8.getType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r8 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r8 = r8.getACTION_TYPE_CANCEL_ORDER_ITEM()
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r5)
            if (r7 == 0) goto L_0x0057
            r4.add(r6)
            goto L_0x0057
        L_0x007d:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r1 = r4.iterator()
        L_0x0085:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00d4
            java.lang.Object r4 = r1.next()
            net.one97.paytm.common.entity.shopping.CJRAction r4 = (net.one97.paytm.common.entity.shopping.CJRAction) r4
            com.google.gsonhtcfix.f r6 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00b2 }
            r6.<init>()     // Catch:{ Exception -> 0x00b2 }
            com.google.gsonhtcfix.f r8 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x00b2 }
            r8.<init>()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = r8.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.Class<net.one97.paytm.recharge.model.CJROSActionItemV2> r9 = net.one97.paytm.recharge.model.CJROSActionItemV2.class
            java.lang.Object r6 = r6.a((java.lang.String) r8, r9)     // Catch:{ Exception -> 0x00b2 }
            net.one97.paytm.recharge.model.CJROSActionItemV2 r6 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r6     // Catch:{ Exception -> 0x00b2 }
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x00b2 }
            r8 = 4
            r6.setButtonType(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.add(r6)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x0085
        L_0x00b2:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r6 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Unable to add order-action "
            r8.<init>(r9)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            java.lang.String r9 = r4.getName()
            if (r9 != 0) goto L_0x00c9
            java.lang.String r9 = r4.getLabel()
        L_0x00c9:
            r8.append(r9)
            java.lang.String r4 = r8.toString()
            r6.debugLog(r4)
            goto L_0x0085
        L_0x00d4:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            if (r1 != 0) goto L_0x00e9
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x00e9
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = new net.one97.paytm.recharge.model.CJROSActionResponseV2
            r1.<init>()
            r0.f64114d = r1
        L_0x00e9:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            if (r1 == 0) goto L_0x016d
            if (r1 != 0) goto L_0x00f2
            kotlin.g.b.k.a()
        L_0x00f2:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
            if (r1 != 0) goto L_0x0107
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            if (r1 != 0) goto L_0x00ff
            kotlin.g.b.k.a()
        L_0x00ff:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r4 = new net.one97.paytm.recharge.model.CJROSActionResponseV2
            r4.<init>()
            r1.setItemLevelActions(r4)
        L_0x0107:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            if (r1 != 0) goto L_0x010e
            kotlin.g.b.k.a()
        L_0x010e:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
            if (r1 != 0) goto L_0x0117
            kotlin.g.b.k.a()
        L_0x0117:
            java.util.List r1 = r1.getActions()
            if (r1 == 0) goto L_0x0135
            java.util.LinkedHashSet r4 = new java.util.LinkedHashSet
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            r4.<init>(r6)
            java.util.Collection r2 = (java.util.Collection) r2
            r4.addAll(r2)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r1.clear()
            java.util.Collection r4 = (java.util.Collection) r4
            r1.addAll(r4)
            goto L_0x0151
        L_0x0135:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            if (r1 != 0) goto L_0x013c
            kotlin.g.b.k.a()
        L_0x013c:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
            if (r1 != 0) goto L_0x0145
            kotlin.g.b.k.a()
        L_0x0145:
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Collection r2 = (java.util.Collection) r2
            r4.<init>(r2)
            java.util.List r4 = (java.util.List) r4
            r1.setActions(r4)
        L_0x0151:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r19.r()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r1 = r1.m
            java.util.Map r1 = (java.util.Map) r1
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64112b
            if (r2 != 0) goto L_0x0160
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0160:
            long r6 = r2.getId()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r4 = r0.f64114d
            r1.put(r2, r4)
        L_0x016d:
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r1 = r0.f64115e
            net.one97.paytm.recharge.ordersummary.d.f$e r2 = new net.one97.paytm.recharge.ordersummary.d.f$e
            r2.<init>(r0)
            io.reactivex.rxjava3.d.g r2 = (io.reactivex.rxjava3.d.g) r2
            r1.subscribe(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r19.k()
            r0.d(r1)
            int r1 = net.one97.paytm.recharge.R.id.status_list
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x0198
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r19.getContext()
            r2.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r1.setLayoutManager(r2)
        L_0x0198:
            int r1 = net.one97.paytm.recharge.R.id.status_list
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x01a9
            net.one97.paytm.recharge.ordersummary.d.f$a r2 = r0.z
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r1.setAdapter(r2)
        L_0x01a9:
            android.content.Context r1 = r19.getContext()
            boolean r2 = r1 instanceof net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity
            r4 = 0
            if (r2 != 0) goto L_0x01b3
            r1 = r4
        L_0x01b3:
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = (net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity) r1
            if (r1 == 0) goto L_0x01ba
            r1.b()
        L_0x01ba:
            android.content.Context r1 = r19.getContext()
            boolean r1 = r1 instanceof net.one97.paytm.recharge.ordersummary.f.n
            if (r1 == 0) goto L_0x0256
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.f64114d
            r2 = 0
            if (r1 == 0) goto L_0x0217
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
            if (r1 == 0) goto L_0x0217
            java.util.List r1 = r1.getActions()
            if (r1 == 0) goto L_0x0217
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r1 = r1.iterator()
        L_0x01e0:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0213
            java.lang.Object r7 = r1.next()
            r8 = r7
            net.one97.paytm.recharge.model.CJROSActionItemV2 r8 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r8
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r9 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r9 = r9.getACTION_TYPE_SHARE()
            java.lang.String r10 = r8.getmType()
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r5)
            if (r9 == 0) goto L_0x020c
            int r9 = r8.getToolbarVisibility()
            if (r9 == r5) goto L_0x020a
            int r8 = r8.getToolbarVisibility()
            r9 = 3
            if (r8 != r9) goto L_0x020c
        L_0x020a:
            r8 = 1
            goto L_0x020d
        L_0x020c:
            r8 = 0
        L_0x020d:
            if (r8 == 0) goto L_0x01e0
            r6.add(r7)
            goto L_0x01e0
        L_0x0213:
            r1 = r6
            java.util.List r1 = (java.util.List) r1
            goto L_0x0218
        L_0x0217:
            r1 = r4
        L_0x0218:
            if (r1 == 0) goto L_0x0256
            int r6 = r1.size()
            if (r6 != r5) goto L_0x0256
            android.content.Context r6 = r19.getContext()
            boolean r6 = r6 instanceof net.one97.paytm.recharge.ordersummary.f.n
            if (r6 == 0) goto L_0x0256
            android.content.Context r6 = r19.getContext()
            if (r6 == 0) goto L_0x024e
            net.one97.paytm.recharge.ordersummary.f.n r6 = (net.one97.paytm.recharge.ordersummary.f.n) r6
            r7 = r0
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            android.view.View r6 = r6.a(r7)
            kotlin.o r7 = new kotlin.o
            java.lang.Object r8 = r1.get(r2)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r8 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r8
            java.lang.String r8 = r8.getmType()
            java.lang.Object r1 = r1.get(r2)
            r7.<init>(r8, r1)
            r6.setTag(r7)
            goto L_0x0256
        L_0x024e:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen"
            r1.<init>(r2)
            throw r1
        L_0x0256:
            r0.r = r5
            boolean r1 = r0.f64111a
            if (r1 != 0) goto L_0x0260
            boolean r1 = r0.r
            if (r1 == 0) goto L_0x0393
        L_0x0260:
            boolean r1 = r0.r
            android.view.View r2 = r19.getView()
            if (r2 == 0) goto L_0x0271
            int r5 = net.one97.paytm.recharge.R.id.status_main
            android.view.View r2 = r2.findViewById(r5)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            goto L_0x0272
        L_0x0271:
            r2 = r4
        L_0x0272:
            boolean r5 = r2 instanceof android.widget.LinearLayout
            if (r5 != 0) goto L_0x0277
            r2 = r4
        L_0x0277:
            android.view.View r5 = r19.getView()
            if (r5 == 0) goto L_0x0286
            int r6 = net.one97.paytm.recharge.R.id.status_recharge_item
            android.view.View r5 = r5.findViewById(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            goto L_0x0287
        L_0x0286:
            r5 = r4
        L_0x0287:
            boolean r6 = r5 instanceof android.widget.LinearLayout
            if (r6 != 0) goto L_0x028c
            goto L_0x028d
        L_0x028c:
            r4 = r5
        L_0x028d:
            if (r4 == 0) goto L_0x0393
            androidx.transition.Slide r5 = new androidx.transition.Slide
            r5.<init>()
            if (r1 != 0) goto L_0x029f
            r1 = r4
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6 = r5
            androidx.transition.Transition r6 = (androidx.transition.Transition) r6
            androidx.transition.v.a((android.view.ViewGroup) r1, (androidx.transition.Transition) r6)
        L_0x029f:
            net.one97.paytm.recharge.ordersummary.widget.CJRFailedPendingOrderDetailsView r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRFailedPendingOrderDetailsView
            android.content.Context r8 = r19.getContext()
            if (r8 != 0) goto L_0x02aa
            kotlin.g.b.k.a()
        L_0x02aa:
            java.lang.String r6 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = r0.f64112b
            if (r9 != 0) goto L_0x02b6
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x02b6:
            net.one97.paytm.recharge.ordersummary.b.a r10 = r19.r()
            boolean r11 = r0.f64111a
            r18 = r0
            net.one97.paytm.recharge.ordersummary.f.b r18 = (net.one97.paytm.recharge.ordersummary.f.b) r18
            r7 = r1
            r12 = r18
            r7.<init>(r8, r9, r10, r11, r12)
            android.view.View r1 = (android.view.View) r1
            r5.c((android.view.View) r1)
            r4.addView(r1)
            boolean r1 = r0.f64111a
            if (r1 != 0) goto L_0x0355
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r19.k()
            int r1 = r1.getOrderStatus()
            r7 = 2
            if (r1 != r7) goto L_0x0355
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r1 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r19.getContext()
            if (r13 != 0) goto L_0x02e8
            kotlin.g.b.k.a()
        L_0x02e8:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r19.r()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r7 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.l
            r16 = 1
            r12 = r1
            r17 = r18
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r1 = (android.view.View) r1
            r5.c((android.view.View) r1)
            r4.addView(r1)
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r1 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r19.getContext()
            if (r13 != 0) goto L_0x0310
            kotlin.g.b.k.a()
        L_0x0310:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r19.r()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r7 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.m
            r16 = 1
            r12 = r1
            r17 = r18
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r1 = (android.view.View) r1
            r5.c((android.view.View) r1)
            r4.addView(r1)
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r1 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r13 = r19.getContext()
            if (r13 != 0) goto L_0x0338
            kotlin.g.b.k.a()
        L_0x0338:
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r19.r()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r7 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r15 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.k
            r16 = 1
            r12 = r1
            r17 = r18
            r12.<init>(r13, r14, r15, r16, r17)
            android.view.View r1 = (android.view.View) r1
            r5.c((android.view.View) r1)
            r4.addView(r1)
        L_0x0355:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView$a r1 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.f64443a
            android.content.Context r12 = r19.getContext()
            if (r12 != 0) goto L_0x0360
            kotlin.g.b.k.a()
        L_0x0360:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r6)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = r0.f64112b
            if (r14 != 0) goto L_0x036a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x036a:
            net.one97.paytm.recharge.ordersummary.b.a r15 = r19.r()
            r13 = 1
            r17 = 0
            r16 = r18
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.a.a(r12, r13, r14, r15, r16, r17)
            r0.t = r1
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r1 = r0.t
            if (r1 == 0) goto L_0x0393
            if (r1 != 0) goto L_0x0382
            kotlin.g.b.k.a()
        L_0x0382:
            android.view.View r1 = (android.view.View) r1
            r5.c((android.view.View) r1)
            if (r2 != 0) goto L_0x038c
            kotlin.g.b.k.a()
        L_0x038c:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r1 = r0.t
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
        L_0x0393:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.f.g():void");
    }

    private void x() {
        this.f64184i = true;
        this.f64183h = 5.0d;
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        k.c(instance, "<set-?>");
        this.j = instance;
        this.j.setTimeInMillis(this.j.getTimeInMillis() - ((long) (((double) this.f64182g) * this.f64183h)));
    }
}
