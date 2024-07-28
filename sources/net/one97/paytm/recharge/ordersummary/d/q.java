package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRFailedOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRMetroTicketCancelledOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRPendingOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class q extends a implements View.OnClickListener, net.one97.paytm.recharge.ordersummary.f.l {

    /* renamed from: a  reason: collision with root package name */
    private CJRProcessingOrderSummaryLayout f64179a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f64180b;

    /* renamed from: f  reason: collision with root package name */
    protected FrameLayout f64181f;

    /* renamed from: g  reason: collision with root package name */
    final long f64182g = 2000;

    /* renamed from: h  reason: collision with root package name */
    double f64183h = 1.0d;

    /* renamed from: i  reason: collision with root package name */
    boolean f64184i;
    Calendar j;
    protected net.one97.paytm.recharge.ordersummary.b.a k;
    protected net.one97.paytm.recharge.ordersummary.f.l p;
    protected net.one97.paytm.recharge.ordersummary.f.r q;

    public interface a {
        void a();
    }

    public View a(int i2) {
        if (this.f64180b == null) {
            this.f64180b = new HashMap();
        }
        View view = (View) this.f64180b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64180b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void b() {
        HashMap hashMap = this.f64180b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public q() {
        Calendar instance = Calendar.getInstance();
        kotlin.g.b.k.a((Object) instance, "Calendar.getInstance()");
        this.j = instance;
    }

    /* access modifiers changed from: protected */
    public final void a(FrameLayout frameLayout) {
        kotlin.g.b.k.c(frameLayout, "<set-?>");
        this.f64181f = frameLayout;
    }

    /* access modifiers changed from: protected */
    public final FrameLayout q() {
        FrameLayout frameLayout = this.f64181f;
        if (frameLayout == null) {
            kotlin.g.b.k.a("parentContainer");
        }
        return frameLayout;
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.ordersummary.b.a r() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.ordersummary.f.l s() {
        net.one97.paytm.recharge.ordersummary.f.l lVar = this.p;
        if (lVar == null) {
            kotlin.g.b.k.a("orderSummaryRequestListener");
        }
        return lVar;
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.ordersummary.f.r t() {
        net.one97.paytm.recharge.ordersummary.f.r rVar = this.q;
        if (rVar == null) {
            kotlin.g.b.k.a("orderSummaryListener");
        }
        return rVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_pre_success_recharge_order_summary, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.parent_container);
        if (findViewById != null) {
            this.f64181f = (FrameLayout) findViewById;
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getContext() instanceof net.one97.paytm.recharge.ordersummary.f.r) {
            Context context = getContext();
            if (context != null) {
                this.q = (net.one97.paytm.recharge.ordersummary.f.r) context;
                if (getContext() instanceof net.one97.paytm.recharge.ordersummary.f.l) {
                    Context context2 = getContext();
                    if (context2 != null) {
                        this.p = (net.one97.paytm.recharge.ordersummary.f.l) context2;
                        net.one97.paytm.recharge.ordersummary.f.r rVar = this.q;
                        if (rVar == null) {
                            kotlin.g.b.k.a("orderSummaryListener");
                        }
                        this.k = rVar.l();
                        net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
                        if (aVar == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        this.n = aVar.f63998b;
                        boolean z = true;
                        if (bundle != null) {
                            b(true);
                            this.f64183h = bundle.getDouble("retryCount", 1.0d);
                            this.f64184i = bundle.getBoolean("rechargeProcessing", this.f64184i);
                            Serializable serializable = bundle.getSerializable("startTime");
                            if (!(serializable instanceof Calendar)) {
                                serializable = null;
                            }
                            Calendar calendar = (Calendar) serializable;
                            if (calendar == null) {
                                calendar = Calendar.getInstance();
                                kotlin.g.b.k.a((Object) calendar, "Calendar.getInstance()");
                            }
                            this.j = calendar;
                        }
                        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
                        if (aVar2 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        if (aVar2.a()) {
                            TransitionSet transitionSet = new TransitionSet();
                            transitionSet.a((Transition) new Fade());
                            transitionSet.a(375);
                            setExitTransition(transitionSet);
                        }
                        net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.k;
                        if (aVar3 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        boolean z2 = aVar3.s;
                        if ((g() > this.f64182g) || !z2) {
                            z = false;
                        }
                        a(z);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJROrderSummaryRequired");
                }
                throw new Exception("Context must implement " + net.one97.paytm.recharge.ordersummary.f.l.class.getName());
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.RechargeOrderSummaryInteractionListener");
        }
        throw new Exception("Context must implement " + net.one97.paytm.recharge.ordersummary.f.r.class.getName());
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        bundle.putSerializable("startTime", this.j);
        bundle.putDouble("retryCount", this.f64183h);
        bundle.putBoolean("rechargeProcessing", this.f64184i);
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARNING: type inference failed for: r12v54, types: [java.io.Serializable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0130, code lost:
        if (r12.f64001e != false) goto L_0x0187;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r12) {
        /*
            r11 = this;
            java.lang.String r0 = "viewModel"
            if (r12 == 0) goto L_0x00e2
            r12 = 0
            r11.b((boolean) r12)
            android.content.Context r12 = r11.getContext()
            boolean r12 = com.paytm.utility.b.c((android.content.Context) r12)
            if (r12 == 0) goto L_0x00db
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r1 = "Post: Payment Processing"
            r12.debugLog(r1)
            android.content.Context r3 = r11.getContext()
            if (r3 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            java.lang.String r12 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r12)
            android.widget.FrameLayout r12 = r11.f64181f
            if (r12 != 0) goto L_0x0030
            java.lang.String r1 = "parentContainer"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0030:
            r4 = r12
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.os.Bundle r12 = r11.getArguments()
            if (r12 == 0) goto L_0x0040
            java.lang.String r1 = "recharge cart"
            java.io.Serializable r12 = r12.getSerializable(r1)
            goto L_0x0041
        L_0x0040:
            r12 = 0
        L_0x0041:
            r5 = r12
            net.one97.paytm.common.entity.CJRRechargeCart r5 = (net.one97.paytm.common.entity.CJRRechargeCart) r5
            r6 = r11
            net.one97.paytm.recharge.ordersummary.f.l r6 = (net.one97.paytm.recharge.ordersummary.f.l) r6
            r7 = r11
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            net.one97.paytm.recharge.ordersummary.f.r r12 = r11.q
            java.lang.String r1 = "orderSummaryListener"
            if (r12 != 0) goto L_0x0053
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0053:
            java.lang.String r12 = "context"
            kotlin.g.b.k.c(r3, r12)
            java.lang.String r12 = "rootLayout"
            kotlin.g.b.k.c(r4, r12)
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.k
            if (r12 != 0) goto L_0x0064
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0064:
            java.lang.String r12 = r12.i()
            java.lang.Class<net.one97.paytm.recharge.ordersummary.widget.CJRProcessingOrderSummaryLayoutV8> r2 = net.one97.paytm.recharge.ordersummary.widget.CJRProcessingOrderSummaryLayoutV8.class
            java.lang.String r2 = r2.getName()
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r2)
            if (r12 == 0) goto L_0x008b
            net.one97.paytm.recharge.ordersummary.widget.CJRProcessingOrderSummaryLayoutV8 r12 = new net.one97.paytm.recharge.ordersummary.widget.CJRProcessingOrderSummaryLayoutV8
            net.one97.paytm.recharge.ordersummary.f.r r8 = r11.q
            if (r8 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            net.one97.paytm.recharge.ordersummary.b.a r9 = r11.k
            if (r9 != 0) goto L_0x0084
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0084:
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout r12 = (net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout) r12
            goto L_0x00a0
        L_0x008b:
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout r12 = new net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout
            net.one97.paytm.recharge.ordersummary.f.r r8 = r11.q
            if (r8 != 0) goto L_0x0094
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0094:
            net.one97.paytm.recharge.ordersummary.b.a r9 = r11.k
            if (r9 != 0) goto L_0x009b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x009b:
            r10 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x00a0:
            r11.f64179a = r12
            long r0 = r11.u()
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Post: All Order Pending : exponentialBackOff:"
            java.lang.String r2 = r3.concat(r2)
            r12.debugLog(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.n
            if (r12 != 0) goto L_0x00ca
            android.view.View r12 = r11.getView()
            if (r12 == 0) goto L_0x00c9
            net.one97.paytm.recharge.ordersummary.d.q$s r2 = new net.one97.paytm.recharge.ordersummary.d.q$s
            r2.<init>(r11)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r12.postDelayed(r2, r0)
        L_0x00c9:
            return
        L_0x00ca:
            android.view.View r12 = r11.getView()
            if (r12 == 0) goto L_0x00da
            net.one97.paytm.recharge.ordersummary.d.q$t r2 = new net.one97.paytm.recharge.ordersummary.d.q$t
            r2.<init>(r11)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r12.postDelayed(r2, r0)
        L_0x00da:
            return
        L_0x00db:
            r12 = r11
            net.one97.paytm.recharge.ordersummary.f.l r12 = (net.one97.paytm.recharge.ordersummary.f.l) r12
            r11.a((net.one97.paytm.recharge.ordersummary.f.l) r12)
            return
        L_0x00e2:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.n
            r1 = 1
            if (r12 != 0) goto L_0x00fc
            android.content.Context r12 = r11.getContext()
            boolean r12 = com.paytm.utility.b.c((android.content.Context) r12)
            if (r12 == 0) goto L_0x00f5
            r11.a((boolean) r1)
            return
        L_0x00f5:
            r12 = r11
            net.one97.paytm.recharge.ordersummary.f.l r12 = (net.one97.paytm.recharge.ordersummary.f.l) r12
            r11.a((net.one97.paytm.recharge.ordersummary.f.l) r12)
            return
        L_0x00fc:
            r11.d()
            r12 = 4
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.k()
            int r2 = r2.getOrderStatus()
            if (r12 == r2) goto L_0x0187
            r12 = 8
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.k()
            int r2 = r2.getOrderStatus()
            if (r12 == r2) goto L_0x0187
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.k
            if (r12 != 0) goto L_0x011d
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x011d:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r12 = r12.k
            java.util.List r12 = (java.util.List) r12
            int r12 = r12.size()
            if (r12 != r1) goto L_0x0133
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.k
            if (r12 != 0) goto L_0x012e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x012e:
            boolean r12 = r12.f64001e
            if (r12 == 0) goto L_0x0133
            goto L_0x0187
        L_0x0133:
            r12 = 2
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.k()
            int r2 = r2.getOrderStatus()
            if (r12 != r2) goto L_0x0178
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.k
            if (r12 != 0) goto L_0x0145
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0145:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r12 = r12.k
            java.util.List r12 = (java.util.List) r12
            int r12 = r12.size()
            if (r12 != r1) goto L_0x0169
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.k
            if (r12 != 0) goto L_0x0156
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0156:
            boolean r12 = r12.f64003g
            if (r12 == 0) goto L_0x0169
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x0161
            return
        L_0x0161:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.k()
            r11.d(r12)
            return
        L_0x0169:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = "History: Multi-item, Success default handling"
            r12.debugLog(r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.k()
            r11.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r12)
            return
        L_0x0178:
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x017f
            return
        L_0x017f:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.k()
            r11.d(r12)
            return
        L_0x0187:
            android.content.Context r12 = r11.getContext()
            if (r12 != 0) goto L_0x018e
            return
        L_0x018e:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.k()
            r11.c(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.q.a(boolean):void");
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64224a;

        s(q qVar) {
            this.f64224a = qVar;
        }

        public final void run() {
            q qVar = this.f64224a;
            qVar.a((net.one97.paytm.recharge.ordersummary.f.l) qVar);
        }
    }

    static final class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64225a;

        t(q qVar) {
            this.f64225a = qVar;
        }

        public final void run() {
            q qVar = this.f64225a;
            CJROrderSummary cJROrderSummary = qVar.n;
            if (cJROrderSummary == null) {
                kotlin.g.b.k.a();
            }
            qVar.a(cJROrderSummary);
        }
    }

    public final void c() {
        net.one97.paytm.recharge.ordersummary.f.l lVar = this.p;
        if (lVar == null) {
            kotlin.g.b.k.a("orderSummaryRequestListener");
        }
        lVar.c();
    }

    public final void a(net.one97.paytm.recharge.ordersummary.f.l lVar) {
        kotlin.g.b.k.c(lVar, "onSummaryListener");
        if (isAdded()) {
            net.one97.paytm.recharge.ordersummary.f.l lVar2 = this.p;
            if (lVar2 == null) {
                kotlin.g.b.k.a("orderSummaryRequestListener");
            }
            lVar2.a(lVar);
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64216b;

        n(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64215a = qVar;
            this.f64216b = cJROrderSummary;
        }

        public final void run() {
            this.f64215a.a(this.f64216b);
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64217a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64218b;

        o(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64217a = qVar;
            this.f64218b = cJROrderSummary;
        }

        public final void run() {
            this.f64217a.a(this.f64218b);
        }
    }

    static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64219a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64220b;

        p(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64219a = qVar;
            this.f64220b = cJROrderSummary;
        }

        public final void run() {
            this.f64219a.a(this.f64220b);
        }
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.d.q$q  reason: collision with other inner class name */
    static final class C1262q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64221a;

        C1262q(q qVar) {
            this.f64221a = qVar;
        }

        public final void run() {
            q qVar = this.f64221a;
            qVar.a((net.one97.paytm.recharge.ordersummary.f.l) qVar);
        }
    }

    static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64223b;

        r(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64222a = qVar;
            this.f64223b = cJROrderSummary;
        }

        public final void run() {
            this.f64222a.a(this.f64223b);
        }
    }

    private long g() {
        Calendar instance = Calendar.getInstance();
        kotlin.g.b.k.a((Object) instance, "current");
        return instance.getTimeInMillis() - this.j.getTimeInMillis();
    }

    public final long u() {
        double d2 = this.f64183h;
        this.f64183h = 1.0d + d2;
        return ((long) Math.pow(2.0d, d2)) * 1000;
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z) {
        net.one97.paytm.recharge.ordersummary.f.r rVar = this.q;
        if (rVar == null) {
            kotlin.g.b.k.a("orderSummaryListener");
        }
        rVar.a(z);
    }

    public void a(Context context, ViewGroup viewGroup, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, net.one97.paytm.recharge.ordersummary.f.r rVar, View.OnClickListener onClickListener) {
        Context context2 = context;
        kotlin.g.b.k.c(context, "context");
        ViewGroup viewGroup2 = viewGroup;
        kotlin.g.b.k.c(viewGroup, "rootLayout");
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Bundle j2 = aVar.j();
        String string = j2.getString("recharge.component.name");
        int i2 = j2.getInt("recharge.layout.id");
        int i3 = j2.getInt("recharge.logo.id");
        if (kotlin.m.p.a(CJRMetroTicketCancelledOrderSummary.class.getName(), string, true)) {
            net.one97.paytm.recharge.ordersummary.f.r rVar2 = this.q;
            if (rVar2 == null) {
                kotlin.g.b.k.a("orderSummaryListener");
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
            if (aVar2 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            new CJRMetroTicketCancelledOrderSummary(context, viewGroup, i2, i3, cJROrderSummary, cJROSActionResponseV2, rVar2, onClickListener, aVar2);
            return;
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.k;
        if (aVar3 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (aVar3.a()) {
            net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
            if (aVar4 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar4.u();
            if (u == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
            if (aVar5 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar5.m.put(Long.valueOf(u.getId()), cJROSActionResponseV2);
            j2.putSerializable("recharge_item", u);
            net.one97.paytm.recharge.ordersummary.f.r rVar3 = this.q;
            if (rVar3 == null) {
                kotlin.g.b.k.a("orderSummaryListener");
            }
            if (string == null) {
                string = "";
            }
            rVar3.a(string, false, j2);
            return;
        }
        CJROSActionResponseV2 cJROSActionResponseV22 = cJROSActionResponseV2;
        net.one97.paytm.recharge.ordersummary.f.r rVar4 = this.q;
        if (rVar4 == null) {
            kotlin.g.b.k.a("orderSummaryListener");
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.k;
        if (aVar6 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        new CJRFailedOrderSummary(context, viewGroup, i2, i3, cJROrderSummary, cJROSActionResponseV2, rVar4, onClickListener, aVar6);
    }

    public void a(Context context, ViewGroup viewGroup, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, View.OnClickListener onClickListener) {
        Context context2 = context;
        kotlin.g.b.k.c(context, "context");
        ViewGroup viewGroup2 = viewGroup;
        kotlin.g.b.k.c(viewGroup, "rootLayout");
        CJROrderSummary cJROrderSummary2 = cJROrderSummary;
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Bundle k2 = aVar.k();
        String string = k2.getString("recharge.component.name");
        int i2 = k2.getInt("recharge.layout.id");
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (aVar2.a()) {
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.k;
            if (aVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar3.u();
            if (u == null) {
                kotlin.g.b.k.a();
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
            if (aVar4 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar4.m.put(Long.valueOf(u.getId()), cJROSActionResponseV2);
            k2.putSerializable("recharge_item", u);
            net.one97.paytm.recharge.ordersummary.f.r rVar = this.q;
            if (rVar == null) {
                kotlin.g.b.k.a("orderSummaryListener");
            }
            if (string == null) {
                string = "";
            }
            rVar.a(string, false, k2);
            return;
        }
        CJROSActionResponseV2 cJROSActionResponseV22 = cJROSActionResponseV2;
        net.one97.paytm.recharge.ordersummary.f.r rVar2 = this.q;
        if (rVar2 == null) {
            kotlin.g.b.k.a("orderSummaryListener");
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
        if (aVar5 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        new CJRPendingOrderSummary(context, viewGroup, cJROrderSummary, cJROSActionResponseV2, rVar2, onClickListener, i2, aVar5);
    }

    public final void a(CJROrderSummary cJROrderSummary, boolean z) {
        while (true) {
            kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar.u();
            String str = null;
            if (z) {
                b(false);
                net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (aVar2.k.size() != 1) {
                    if (u != null) {
                        str = u.getItemStatus();
                    }
                    if (!kotlin.g.b.k.a((Object) "7", (Object) str)) {
                        if (getContext() != null) {
                            net.one97.paytm.recharge.ordersummary.f.l lVar = this.p;
                            if (lVar == null) {
                                kotlin.g.b.k.a("orderSummaryRequestListener");
                            }
                            lVar.c();
                            return;
                        }
                        return;
                    }
                }
                CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout = this.f64179a;
                if (cJRProcessingOrderSummaryLayout != null) {
                    cJRProcessingOrderSummaryLayout.b(cJROrderSummary, new j(this));
                    return;
                }
                q qVar = this;
                if (qVar.getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.f.l lVar2 = qVar.p;
                    if (lVar2 == null) {
                        kotlin.g.b.k.a("orderSummaryRequestListener");
                    }
                    lVar2.c();
                    return;
                }
                return;
            }
            try {
                CJRRechargeUtilities.INSTANCE.debugLog("Requested for default Success tap-action");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setTag(getTag());
                }
                c.a aVar3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                c.a.a("tap_action_static", context, cJROrderSummary, aVar4.s, (ai) new k(this, u, cJROrderSummary), (Object) a2);
                return;
            } catch (Exception unused) {
                CJRRechargeUtilities.INSTANCE.debugLog("Payment Success Screen - Must Provide Default Local TapAction Response");
                if (isAdded() && getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    HashMap<Long, CJROSActionResponseV2> hashMap = aVar5.m;
                    if (u == null) {
                        kotlin.g.b.k.a();
                    }
                    hashMap.remove(Long.valueOf(u.getId()));
                    z = true;
                } else {
                    return;
                }
            }
        }
    }

    public static final class j implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64207a;

        j(q qVar) {
            this.f64207a = qVar;
        }

        public final void a() {
            if (this.f64207a.getContext() != null) {
                this.f64207a.s().c();
            }
        }
    }

    public static final class k implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64208a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64209b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64210c;

        k(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64208a = qVar;
            this.f64209b = cJROrderedCart;
            this.f64210c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            CJRRechargeUtilities.INSTANCE.debugLog("Payment Success Screen - Must Provide Default Local TapAction Response");
            if (this.f64208a.isAdded() && this.f64208a.getContext() != null) {
                HashMap<Long, CJROSActionResponseV2> hashMap = this.f64208a.r().m;
                CJROrderedCart cJROrderedCart = this.f64209b;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.remove(Long.valueOf(cJROrderedCart.getId()));
                this.f64208a.a(this.f64210c, true);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (this.f64208a.isAdded() && this.f64208a.getContext() != null) {
                if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                    Map map = this.f64208a.r().m;
                    CJROrderedCart cJROrderedCart = this.f64209b;
                    if (cJROrderedCart == null) {
                        kotlin.g.b.k.a();
                    }
                    map.put(Long.valueOf(cJROrderedCart.getId()), iJRPaytmDataModel);
                }
                this.f64208a.a(this.f64210c, true);
            }
        }
    }

    public final void b(CJROrderSummary cJROrderSummary) {
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        if (isAdded() && getContext() != null) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar.u();
            CJROrderSummaryAction tapAction = u != null ? u.getTapAction() : null;
            if (tapAction != null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (aVar2.a()) {
                    try {
                        CJRRechargeUtilities.INSTANCE.debugLog("Post: Order Success item - requested for tap-action");
                        b.a aVar3 = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                        Context context = getContext();
                        if (context == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) context, "context!!");
                        net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                        if (aVar4 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        net.one97.paytm.recharge.ordersummary.h.b a2 = b.a.a(context, aVar4.s);
                        net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
                        if (aVar5 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        if (aVar5.a()) {
                            c.a aVar6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                            net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.k;
                            if (aVar7 == null) {
                                kotlin.g.b.k.a("viewModel");
                            }
                            long j2 = aVar7.f63997a;
                            String itemStatus = u.getItemStatus();
                            kotlin.g.b.k.a((Object) itemStatus, "rechargeItem.itemStatus");
                            a2.a(c.a.a(j2, itemStatus));
                        }
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                        CRUFlowModel flowName = a3.getFlowName();
                        if (flowName != null) {
                            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                        CRUFlowModel flowName2 = a3.getFlowName();
                        if (flowName2 != null) {
                            flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                        }
                        CRUFlowModel flowName3 = a3.getFlowName();
                        if (flowName3 != null) {
                            flowName3.setTag(getTag());
                        }
                        a2.a("tap_action", tapAction, a3, new l(this, u, cJROrderSummary));
                        return;
                    } catch (Exception unused) {
                        CJRRechargeUtilities.INSTANCE.debugLog("Post: Payment Success Screen: Tap Action Error - Must Provide Default Local TapAction Response");
                        net.one97.paytm.recharge.ordersummary.b.a aVar8 = this.k;
                        if (aVar8 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        aVar8.m.remove(Long.valueOf(u.getId()));
                        net.one97.paytm.recharge.ordersummary.b.a aVar9 = this.k;
                        if (aVar9 == null) {
                            kotlin.g.b.k.a("viewModel");
                        }
                        a(cJROrderSummary, !aVar9.a());
                        return;
                    }
                }
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar10 = this.k;
            if (aVar10 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            a(cJROrderSummary, !aVar10.a());
        }
    }

    public static final class l implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64211a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64212b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64213c;

        l(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64211a = qVar;
            this.f64212b = cJROrderedCart;
            this.f64213c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLog("Post: Payment Success Screen: Tap Action Error - Must Provide Default Local TapAction Response");
            this.f64211a.r().m.remove(Long.valueOf(this.f64212b.getId()));
            q qVar = this.f64211a;
            boolean z = true;
            qVar.a(this.f64213c, !qVar.r().a());
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg != null && !kotlin.m.p.a(errorMsg)) {
                    z = false;
                }
                if (z) {
                    cJRRechargeErrorModel.setErrorMsg("Error while fetching tap action response");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                this.f64211a.r().m.put(Long.valueOf(this.f64212b.getId()), iJRPaytmDataModel);
                this.f64211a.a(this.f64213c, true);
            }
        }
    }

    public final void b(CJROrderSummary cJROrderSummary, boolean z) {
        while (true) {
            kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar.u();
            if (z) {
                CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout = this.f64179a;
                if (cJRProcessingOrderSummaryLayout != null) {
                    cJRProcessingOrderSummaryLayout.c(cJROrderSummary, new d(this, cJROrderSummary, u));
                    return;
                }
                q qVar = this;
                qVar.b(false);
                CJRRechargeUtilities.INSTANCE.debugLog("History: Payment Failed item");
                if (qVar.getContext() != null) {
                    Context context = qVar.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context, "context!!");
                    FrameLayout frameLayout = qVar.f64181f;
                    if (frameLayout == null) {
                        kotlin.g.b.k.a("parentContainer");
                    }
                    ViewGroup viewGroup = frameLayout;
                    CJROrderSummary k2 = qVar.k();
                    net.one97.paytm.recharge.ordersummary.b.a aVar2 = qVar.k;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    HashMap<Long, CJROSActionResponseV2> hashMap = aVar2.m;
                    if (u == null) {
                        kotlin.g.b.k.a();
                    }
                    CJROSActionResponseV2 cJROSActionResponseV2 = hashMap.get(Long.valueOf(u.getId()));
                    net.one97.paytm.recharge.ordersummary.f.r rVar = qVar.q;
                    if (rVar == null) {
                        kotlin.g.b.k.a("orderSummaryListener");
                    }
                    qVar.a(context, viewGroup, k2, cJROSActionResponseV2, rVar, this);
                    return;
                }
                return;
            }
            try {
                CJRRechargeUtilities.INSTANCE.debugLog("Requested for default Failed tap-action");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setTag(getTag());
                }
                c.a aVar3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                Context context2 = getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context2, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                c.a.a("tap_action_static", context2, cJROrderSummary, aVar4.s, (ai) new e(this, u, cJROrderSummary), (Object) a2);
                return;
            } catch (Exception unused) {
                CJRRechargeUtilities.INSTANCE.debugLog("Payment Failed Screen - Must Provide Default Local TapAction Response");
                if (isAdded() && getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    HashMap<Long, CJROSActionResponseV2> hashMap2 = aVar5.m;
                    if (u == null) {
                        kotlin.g.b.k.a();
                    }
                    hashMap2.remove(Long.valueOf(u.getId()));
                    z = true;
                } else {
                    return;
                }
            }
        }
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64190a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64191b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64192c;

        d(q qVar, CJROrderSummary cJROrderSummary, CJROrderedCart cJROrderedCart) {
            this.f64190a = qVar;
            this.f64191b = cJROrderSummary;
            this.f64192c = cJROrderedCart;
        }

        public final void a() {
            this.f64190a.b(false);
            CJRRechargeUtilities.INSTANCE.debugLog("Post: Payment Failed Screen");
            if (this.f64190a.getContext() != null) {
                q qVar = this.f64190a;
                Context context = qVar.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                ViewGroup q = this.f64190a.q();
                CJROrderSummary cJROrderSummary = this.f64191b;
                HashMap<Long, CJROSActionResponseV2> hashMap = this.f64190a.r().m;
                CJROrderedCart cJROrderedCart = this.f64192c;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a();
                }
                qVar.a(context, q, cJROrderSummary, hashMap.get(Long.valueOf(cJROrderedCart.getId())), this.f64190a.t(), this.f64190a);
            }
        }
    }

    public static final class e implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64194b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64195c;

        e(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64193a = qVar;
            this.f64194b = cJROrderedCart;
            this.f64195c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLog("Payment Failed Screen - Must Provide Default Local TapAction Response");
            boolean z = true;
            if (this.f64193a.isAdded() && this.f64193a.getContext() != null) {
                HashMap<Long, CJROSActionResponseV2> hashMap = this.f64193a.r().m;
                CJROrderedCart cJROrderedCart = this.f64194b;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.remove(Long.valueOf(cJROrderedCart.getId()));
                this.f64193a.b(this.f64195c, true);
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg != null && !kotlin.m.p.a(errorMsg)) {
                    z = false;
                }
                if (z) {
                    cJRRechargeErrorModel.setErrorMsg("Error while fetching tap action response");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (this.f64193a.isAdded() && this.f64193a.getContext() != null) {
                if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                    Map map = this.f64193a.r().m;
                    CJROrderedCart cJROrderedCart = this.f64194b;
                    if (cJROrderedCart == null) {
                        kotlin.g.b.k.a();
                    }
                    map.put(Long.valueOf(cJROrderedCart.getId()), iJRPaytmDataModel);
                }
                this.f64193a.b(this.f64195c, true);
            }
        }
    }

    public final void c(CJROrderSummary cJROrderSummary) {
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        if (2 != cJROrderSummary.getOrderStatus()) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            b(cJROrderSummary, !aVar.a());
            return;
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (aVar2.k.size() == 1) {
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.k;
            if (aVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar3.u();
            if (u == null) {
                kotlin.g.b.k.a();
            }
            if (u.getTapAction() == null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                b(cJROrderSummary, !aVar4.a());
                return;
            }
            try {
                CJRRechargeUtilities.INSTANCE.debugLog("Order Failed item - requested for tap-action");
                b.a aVar5 = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.k;
                if (aVar6 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                net.one97.paytm.recharge.ordersummary.h.b a2 = b.a.a(context, aVar6.s);
                net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.k;
                if (aVar7 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (aVar7.a()) {
                    c.a aVar8 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                    net.one97.paytm.recharge.ordersummary.b.a aVar9 = this.k;
                    if (aVar9 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    long j2 = aVar9.f63997a;
                    String itemStatus = u.getItemStatus();
                    kotlin.g.b.k.a((Object) itemStatus, "orderedItem.itemStatus");
                    a2.a(c.a.a(j2, itemStatus));
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a3.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a3.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                }
                CRUFlowModel flowName3 = a3.getFlowName();
                if (flowName3 != null) {
                    flowName3.setTag(getTag());
                }
                CJROrderSummaryAction tapAction = u.getTapAction();
                kotlin.g.b.k.a((Object) tapAction, "orderedItem.tapAction");
                a2.a("tap_action", tapAction, a3, new b(this, u, cJROrderSummary));
            } catch (Exception unused) {
                if (isAdded() && getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar10 = this.k;
                    if (aVar10 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar10.m.remove(Long.valueOf(u.getId()));
                    net.one97.paytm.recharge.ordersummary.b.a aVar11 = this.k;
                    if (aVar11 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    b(cJROrderSummary, !aVar11.a());
                }
            }
        } else {
            if (this.f64179a != null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar12 = this.k;
                if (aVar12 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (!aVar12.f64002f) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar13 = this.k;
                    if (aVar13 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    if (!aVar13.t()) {
                        CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout = this.f64179a;
                        if (cJRProcessingOrderSummaryLayout == null) {
                            kotlin.g.b.k.a();
                        }
                        cJRProcessingOrderSummaryLayout.c(cJROrderSummary, new c(this, cJROrderSummary));
                        return;
                    }
                }
            }
            CJRRechargeUtilities.INSTANCE.debugLog("History: Multi-item all failed");
            if (getContext() != null) {
                b(cJROrderSummary);
            }
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64186b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64187c;

        b(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64185a = qVar;
            this.f64186b = cJROrderedCart;
            this.f64187c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            boolean z = true;
            if (this.f64185a.isAdded() && this.f64185a.getContext() != null) {
                this.f64185a.r().m.remove(Long.valueOf(this.f64186b.getId()));
                q qVar = this.f64185a;
                qVar.b(this.f64187c, !qVar.r().a());
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg != null && !kotlin.m.p.a(errorMsg)) {
                    z = false;
                }
                if (z) {
                    cJRRechargeErrorModel.setErrorMsg("Error while fetching tap action response");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (this.f64185a.isAdded() && this.f64185a.getContext() != null) {
                if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                    this.f64185a.r().m.put(Long.valueOf(this.f64186b.getId()), iJRPaytmDataModel);
                }
                this.f64185a.b(this.f64187c, true);
            }
        }
    }

    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64189b;

        c(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64188a = qVar;
            this.f64189b = cJROrderSummary;
        }

        public final void a() {
            CJRRechargeUtilities.INSTANCE.debugLog("Post: Multi-item all failed");
            if (this.f64188a.getContext() != null) {
                this.f64188a.b(this.f64189b);
            }
        }
    }

    public final void c(CJROrderSummary cJROrderSummary, boolean z) {
        while (true) {
            kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar.u();
            if (z) {
                CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout = this.f64179a;
                if (cJRProcessingOrderSummaryLayout != null) {
                    cJRProcessingOrderSummaryLayout.a(cJROrderSummary, new f(this, cJROrderSummary, u));
                    return;
                }
                q qVar = this;
                qVar.b(false);
                CJRRechargeUtilities.INSTANCE.debugLog("History: Payment Pending item");
                if (qVar.getContext() != null) {
                    Context context = qVar.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) context, "context!!");
                    FrameLayout frameLayout = qVar.f64181f;
                    if (frameLayout == null) {
                        kotlin.g.b.k.a("parentContainer");
                    }
                    ViewGroup viewGroup = frameLayout;
                    net.one97.paytm.recharge.ordersummary.b.a aVar2 = qVar.k;
                    if (aVar2 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    HashMap<Long, CJROSActionResponseV2> hashMap = aVar2.m;
                    if (u == null) {
                        kotlin.g.b.k.a();
                    }
                    CJROSActionResponseV2 cJROSActionResponseV2 = hashMap.get(Long.valueOf(u.getId()));
                    if (qVar.q == null) {
                        kotlin.g.b.k.a("orderSummaryListener");
                    }
                    qVar.a(context, viewGroup, cJROrderSummary, cJROSActionResponseV2, this);
                    return;
                }
                return;
            }
            try {
                CJRRechargeUtilities.INSTANCE.debugLog("Requested for default Pending tap-action");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                }
                CRUFlowModel flowName3 = a2.getFlowName();
                if (flowName3 != null) {
                    flowName3.setTag(getTag());
                }
                c.a aVar3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                Context context2 = getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context2, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                c.a.a("tap_action_static", context2, cJROrderSummary, aVar4.s, (ai) new g(this, u, cJROrderSummary), (Object) a2);
                return;
            } catch (Exception unused) {
                CJRRechargeUtilities.INSTANCE.debugLog("Post: Payment Pending Screen - Must Provide Default Local TapAction Response");
                if (isAdded() && getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.k;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    HashMap<Long, CJROSActionResponseV2> hashMap2 = aVar5.m;
                    if (u == null) {
                        kotlin.g.b.k.a();
                    }
                    hashMap2.remove(Long.valueOf(u.getId()));
                    z = true;
                } else {
                    return;
                }
            }
        }
    }

    public static final class f implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64197b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64198c;

        f(q qVar, CJROrderSummary cJROrderSummary, CJROrderedCart cJROrderedCart) {
            this.f64196a = qVar;
            this.f64197b = cJROrderSummary;
            this.f64198c = cJROrderedCart;
        }

        public final void a() {
            this.f64196a.b(false);
            CJRRechargeUtilities.INSTANCE.debugLog("Post: Payment Pending Screen");
            if (this.f64196a.getContext() != null) {
                q qVar = this.f64196a;
                Context context = qVar.getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                ViewGroup q = this.f64196a.q();
                CJROrderSummary cJROrderSummary = this.f64197b;
                HashMap<Long, CJROSActionResponseV2> hashMap = this.f64196a.r().m;
                CJROrderedCart cJROrderedCart = this.f64198c;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a();
                }
                this.f64196a.t();
                qVar.a(context, q, cJROrderSummary, hashMap.get(Long.valueOf(cJROrderedCart.getId())), this.f64196a);
            }
        }
    }

    public static final class g implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64200b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64201c;

        g(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64199a = qVar;
            this.f64200b = cJROrderedCart;
            this.f64201c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLog("Payment Pending Screen - Must Provide Default Local TapAction Response");
            if (this.f64199a.isAdded() && this.f64199a.getContext() != null) {
                HashMap<Long, CJROSActionResponseV2> hashMap = this.f64199a.r().m;
                CJROrderedCart cJROrderedCart = this.f64200b;
                if (cJROrderedCart == null) {
                    kotlin.g.b.k.a();
                }
                hashMap.remove(Long.valueOf(cJROrderedCart.getId()));
                this.f64199a.c(this.f64201c, true);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (this.f64199a.isAdded() && this.f64199a.getContext() != null) {
                if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                    Map map = this.f64199a.r().m;
                    CJROrderedCart cJROrderedCart = this.f64200b;
                    if (cJROrderedCart == null) {
                        kotlin.g.b.k.a();
                    }
                    map.put(Long.valueOf(cJROrderedCart.getId()), iJRPaytmDataModel);
                }
                this.f64199a.c(this.f64201c, true);
            }
        }
    }

    private void d(CJROrderSummary cJROrderSummary) {
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        if (2 != cJROrderSummary.getOrderStatus()) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            c(cJROrderSummary, !aVar.a());
            return;
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.k;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (aVar2.k.size() == 1) {
            net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.k;
            if (aVar3 == null) {
                kotlin.g.b.k.a("viewModel");
            }
            CJROrderedCart u = aVar3.u();
            if (u == null) {
                kotlin.g.b.k.a();
            }
            if (u.getTapAction() == null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.k;
                if (aVar4 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                c(cJROrderSummary, !aVar4.a());
                return;
            }
            try {
                CJRRechargeUtilities.INSTANCE.debugLog("Order Pending item - requested for tap-action");
                b.a aVar5 = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.k;
                if (aVar6 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                net.one97.paytm.recharge.ordersummary.h.b a2 = b.a.a(context, aVar6.s);
                net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.k;
                if (aVar7 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (aVar7.a()) {
                    c.a aVar8 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                    net.one97.paytm.recharge.ordersummary.b.a aVar9 = this.k;
                    if (aVar9 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    long j2 = aVar9.f63997a;
                    String itemStatus = u.getItemStatus();
                    kotlin.g.b.k.a((Object) itemStatus, "orderedItem.itemStatus");
                    a2.a(c.a.a(j2, itemStatus));
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a3.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a3.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
                }
                CRUFlowModel flowName3 = a3.getFlowName();
                if (flowName3 != null) {
                    flowName3.setTag(getTag());
                }
                CJROrderSummaryAction tapAction = u.getTapAction();
                kotlin.g.b.k.a((Object) tapAction, "orderedItem.tapAction");
                a2.a("tap_action", tapAction, a3, new h(this, u, cJROrderSummary));
            } catch (Exception unused) {
                if (isAdded() && getContext() != null) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar10 = this.k;
                    if (aVar10 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    aVar10.m.remove(Long.valueOf(u.getId()));
                    net.one97.paytm.recharge.ordersummary.b.a aVar11 = this.k;
                    if (aVar11 == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    c(cJROrderSummary, !aVar11.a());
                }
            }
        } else {
            if (this.f64179a != null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar12 = this.k;
                if (aVar12 == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                if (!aVar12.f64002f) {
                    CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout = this.f64179a;
                    if (cJRProcessingOrderSummaryLayout == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRProcessingOrderSummaryLayout.a(cJROrderSummary, new i(this, cJROrderSummary));
                    return;
                }
            }
            CJRRechargeUtilities.INSTANCE.debugLog("History: Multi-item all pending");
            if (getContext() != null) {
                b(cJROrderSummary);
            }
        }
    }

    public static final class h implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderedCart f64203b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64204c;

        h(q qVar, CJROrderedCart cJROrderedCart, CJROrderSummary cJROrderSummary) {
            this.f64202a = qVar;
            this.f64203b = cJROrderedCart;
            this.f64204c = cJROrderSummary;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            boolean z = true;
            if (this.f64202a.isAdded() && this.f64202a.getContext() != null) {
                this.f64202a.r().m.remove(Long.valueOf(this.f64203b.getId()));
                q qVar = this.f64202a;
                qVar.c(this.f64204c, !qVar.r().a());
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg != null && !kotlin.m.p.a(errorMsg)) {
                    z = false;
                }
                if (z) {
                    cJRRechargeErrorModel.setErrorMsg("Error while fetching tap action response");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (this.f64202a.isAdded() && this.f64202a.getContext() != null) {
                if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
                    this.f64202a.r().m.put(Long.valueOf(this.f64203b.getId()), iJRPaytmDataModel);
                }
                this.f64202a.c(this.f64204c, true);
            }
        }
    }

    public static final class i implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f64205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64206b;

        i(q qVar, CJROrderSummary cJROrderSummary) {
            this.f64205a = qVar;
            this.f64206b = cJROrderSummary;
        }

        public final void a() {
            CJRRechargeUtilities.INSTANCE.debugLog("Post: Multi-item all pending");
            if (this.f64205a.getContext() != null) {
                this.f64205a.b(this.f64206b);
            }
        }
    }

    public void onClick(View view) {
        kotlin.g.b.k.c(view, "v");
        int id = view.getId();
        if (id == R.id.txt_help || id == R.id.need_help || id == R.drawable.ic_help || id == R.id.need_help) {
            view.setEnabled(false);
            view.postDelayed(new m(view), 200);
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
            if (aVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            aVar.c("help_clicked", (String) null);
            net.one97.paytm.recharge.ordersummary.c.i iVar = this.m;
            if (iVar != null) {
                iVar.f64077c = false;
            }
            ArrayList<CJROrderedCart> orderedCartList = k().getOrderedCartList();
            if (orderedCartList == null) {
                kotlin.g.b.k.a();
            }
            CJROrderedCart cJROrderedCart = orderedCartList.get(0);
            kotlin.g.b.k.a((Object) cJROrderedCart, "orderedSummary.orderedCartList!![0]");
            f(cJROrderedCart);
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f64214a;

        m(View view) {
            this.f64214a = view;
        }

        public final void run() {
            this.f64214a.setEnabled(true);
        }
    }

    private final void d() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummary cJROrderSummary = this.n;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null) {
            for (CJROrderedCart cJROrderedCart : orderedCartList) {
                net.one97.paytm.recharge.ordersummary.b.a aVar = this.k;
                if (aVar == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                kotlin.g.b.k.a((Object) cJROrderedCart, "it");
                String c2 = aVar.c(cJROrderedCart);
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        w.a().a(c2).f();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c4, code lost:
        if (r2.s() == false) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f5, code lost:
        if (r2.t() != false) goto L_0x0119;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.common.entity.shopping.CJROrderSummary r7) {
        /*
            r6 = this;
            java.lang.String r0 = "orderSummary"
            kotlin.g.b.k.c(r7, r0)
            r6.n = r7
            r6.d()
            long r0 = r6.g()
            int r2 = r7.getOrderStatus()
            r3 = 1
            r4 = 2
            if (r4 != r2) goto L_0x001a
            boolean r2 = r6.f64184i
            if (r2 == 0) goto L_0x0027
        L_0x001a:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            java.lang.String r4 = "viewModel"
            if (r2 != 0) goto L_0x0023
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0023:
            boolean r2 = r2.f64002f
            if (r2 == 0) goto L_0x007d
        L_0x0027:
            long r4 = r6.f64182g
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0069
            boolean r0 = r6.f64184i
            if (r0 == 0) goto L_0x0038
            r6.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7, (net.one97.paytm.common.entity.shopping.CJROrderedCart) null)
            r6.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7)
            return
        L_0x0038:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r1 = "Post: Order Processing"
            r0.debugLog(r1)
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout r0 = r6.f64179a
            if (r0 == 0) goto L_0x0046
            r0.a(r7)
        L_0x0046:
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            java.lang.String r1 = "Calendar.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r6.j = r0
            r6.f64184i = r3
            android.view.View r0 = r6.getView()
            if (r0 == 0) goto L_0x0068
            net.one97.paytm.recharge.ordersummary.d.q$n r1 = new net.one97.paytm.recharge.ordersummary.d.q$n
            r1.<init>(r6, r7)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            long r2 = r6.f64182g
            r4 = 2
            long r2 = r2 + r4
            r0.postDelayed(r1, r2)
        L_0x0068:
            return
        L_0x0069:
            android.view.View r2 = r6.getView()
            if (r2 == 0) goto L_0x007c
            net.one97.paytm.recharge.ordersummary.d.q$o r3 = new net.one97.paytm.recharge.ordersummary.d.q$o
            r3.<init>(r6, r7)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            long r4 = r6.f64182g
            long r4 = r4 - r0
            r2.postDelayed(r3, r4)
        L_0x007c:
            return
        L_0x007d:
            r2 = 4
            int r5 = r7.getOrderStatus()
            if (r2 == r5) goto L_0x0176
            r2 = 8
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r6.k()
            int r5 = r5.getOrderStatus()
            if (r2 == r5) goto L_0x0176
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0097:
            boolean r2 = r2.f64001e
            if (r2 != 0) goto L_0x0176
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00a2
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00a2:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r2 = r2.k
            java.util.List r2 = (java.util.List) r2
            int r2 = r2.size()
            if (r2 <= r3) goto L_0x00c8
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00b3
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00b3:
            boolean r2 = r2.t()
            if (r2 != 0) goto L_0x00c8
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00c0
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00c0:
            boolean r2 = r2.s()
            if (r2 != 0) goto L_0x00c8
            goto L_0x0176
        L_0x00c8:
            int r2 = r7.getOrderStatus()
            if (r3 == r2) goto L_0x0119
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00d5
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00d5:
            boolean r2 = r2.f64003g
            if (r2 != 0) goto L_0x0119
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00e0
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00e0:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r2 = r2.k
            java.util.List r2 = (java.util.List) r2
            int r2 = r2.size()
            if (r2 <= r3) goto L_0x00f8
            net.one97.paytm.recharge.ordersummary.b.a r2 = r6.k
            if (r2 != 0) goto L_0x00f1
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00f1:
            boolean r2 = r2.t()
            if (r2 == 0) goto L_0x00f8
            goto L_0x0119
        L_0x00f8:
            long r2 = r6.f64182g
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0105
            r6.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7, (net.one97.paytm.common.entity.shopping.CJROrderedCart) null)
            r6.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7)
            return
        L_0x0105:
            android.view.View r2 = r6.getView()
            if (r2 == 0) goto L_0x0118
            net.one97.paytm.recharge.ordersummary.d.q$r r3 = new net.one97.paytm.recharge.ordersummary.d.q$r
            r3.<init>(r6, r7)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            long r4 = r6.f64182g
            long r4 = r4 - r0
            r2.postDelayed(r3, r4)
        L_0x0118:
            return
        L_0x0119:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "Post: All Order Pending : TimeElapsed:"
            java.lang.String r4 = r5.concat(r4)
            r2.debugLog(r4)
            r4 = 7000(0x1b58, double:3.4585E-320)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x013d
            double r0 = r6.f64183h
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x013d
            r6.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7, (net.one97.paytm.common.entity.shopping.CJROrderedCart) null)
            r6.d(r7)
            return
        L_0x013d:
            int r7 = r7.getOrderStatus()
            if (r3 != r7) goto L_0x014b
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = "Post: Payment Pending"
            r7.debugLog(r0)
            goto L_0x0152
        L_0x014b:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r0 = "Post: All Order Pending"
            r7.debugLog(r0)
        L_0x0152:
            long r0 = r6.u()
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Post: All Order Pending : exponentialBackOff:"
            java.lang.String r2 = r3.concat(r2)
            r7.debugLog(r2)
            android.view.View r7 = r6.getView()
            if (r7 == 0) goto L_0x0175
            net.one97.paytm.recharge.ordersummary.d.q$q r2 = new net.one97.paytm.recharge.ordersummary.d.q$q
            r2.<init>(r6)
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r7.postDelayed(r2, r0)
        L_0x0175:
            return
        L_0x0176:
            long r2 = r6.f64182g
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0183
            r6.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7, (net.one97.paytm.common.entity.shopping.CJROrderedCart) null)
            r6.c(r7)
            return
        L_0x0183:
            android.view.View r2 = r6.getView()
            if (r2 == 0) goto L_0x0196
            net.one97.paytm.recharge.ordersummary.d.q$p r3 = new net.one97.paytm.recharge.ordersummary.d.q$p
            r3.<init>(r6, r7)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            long r4 = r6.f64182g
            long r4 = r4 - r0
            r2.postDelayed(r3, r4)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.q.a(net.one97.paytm.common.entity.shopping.CJROrderSummary):void");
    }
}
