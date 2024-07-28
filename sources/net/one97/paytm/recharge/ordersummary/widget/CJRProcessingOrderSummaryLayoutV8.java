package net.one97.paytm.recharge.ordersummary.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout;
import net.one97.paytm.recharge.ordersummary.d.q;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.h.d;

public class CJRProcessingOrderSummaryLayoutV8 extends CJRProcessingOrderSummaryLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f64512a = "pending_animation.json";

    /* renamed from: b  reason: collision with root package name */
    private String f64513b = "cancel_animation.json";

    /* renamed from: c  reason: collision with root package name */
    private String f64514c = "success_animation.json";

    /* renamed from: d  reason: collision with root package name */
    private final long f64515d = 700;

    /* renamed from: e  reason: collision with root package name */
    private CJRProcessingOrderSummaryChildLayoutV8 f64516e;

    /* renamed from: f  reason: collision with root package name */
    private CJRProcessingOrderSummaryChildLayoutV8 f64517f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryLayoutV8(Context context, ViewGroup viewGroup, CJRRechargeCart cJRRechargeCart, l lVar, View.OnClickListener onClickListener, r rVar, net.one97.paytm.recharge.ordersummary.b.a aVar) {
        super(context, viewGroup, cJRRechargeCart, lVar, onClickListener, rVar, aVar);
        k.c(context, "mContext");
        k.c(viewGroup, "rootLayout");
        k.c(aVar, "viewModel");
    }

    /* access modifiers changed from: protected */
    public final String getPENDING_LOTTIE_JSON() {
        return this.f64512a;
    }

    /* access modifiers changed from: protected */
    public final void setPENDING_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f64512a = str;
    }

    /* access modifiers changed from: protected */
    public final String getFAILED_LOTTIE_JSON() {
        return this.f64513b;
    }

    /* access modifiers changed from: protected */
    public final void setFAILED_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f64513b = str;
    }

    /* access modifiers changed from: protected */
    public final String getSUCCESS_LOTTIE_JSON() {
        return this.f64514c;
    }

    /* access modifiers changed from: protected */
    public final void setSUCCESS_LOTTIE_JSON(String str) {
        k.c(str, "<set-?>");
        this.f64514c = str;
    }

    public final long getDELAY_IN_MILLI_FINAL_STATE_TRANSITION() {
        return this.f64515d;
    }

    public int getLayoutResId() {
        return R.layout.recharge_order_summary_processing_v8;
    }

    public final void a() {
        View findViewById = getRootLayout().findViewById(R.id.message);
        if (findViewById != null) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            Context context = getContext();
            k.a((Object) context, "context");
            ((TextView) findViewById).setText(viewModel.P(context));
            View findViewById2 = getRootLayout().findViewById(R.id.operator);
            if (findViewById2 != null) {
                net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
                Context context2 = getContext();
                k.a((Object) context2, "context");
                ((TextView) findViewById2).setText(viewModel2.O(context2));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: protected */
    public final CJRProcessingOrderSummaryChildLayoutV8 getPaymentProcessingView() {
        return this.f64516e;
    }

    /* access modifiers changed from: protected */
    public final void setPaymentProcessingView(CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8) {
        this.f64516e = cJRProcessingOrderSummaryChildLayoutV8;
    }

    public final void b() {
        a();
        View findViewById = getRootLayout().findViewById(R.id.child_container);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById;
            Context context = linearLayout.getContext();
            k.a((Object) context, "context");
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            Context context2 = linearLayout.getContext();
            k.a((Object) context2, "context");
            String L = viewModel.L(context2);
            net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
            Context context3 = linearLayout.getContext();
            k.a((Object) context3, "context");
            String K = viewModel2.K(context3);
            net.one97.paytm.recharge.ordersummary.b.a viewModel3 = getViewModel();
            Context context4 = linearLayout.getContext();
            k.a((Object) context4, "context");
            String N = viewModel3.N(context4);
            net.one97.paytm.recharge.ordersummary.b.a viewModel4 = getViewModel();
            Context context5 = linearLayout.getContext();
            k.a((Object) context5, "context");
            this.f64516e = new CJRProcessingOrderSummaryChildLayoutV8(context, L, K, N, viewModel4.M(context5), "", R.layout.processing_order_summary_child_v8);
            linearLayout.addView(this.f64516e);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    /* access modifiers changed from: protected */
    public final CJRProcessingOrderSummaryChildLayoutV8 getRechargeProcessingView() {
        return this.f64517f;
    }

    /* access modifiers changed from: protected */
    public final void setRechargeProcessingView(CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8) {
        this.f64517f = cJRProcessingOrderSummaryChildLayoutV8;
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8 = this.f64516e;
        if (cJRProcessingOrderSummaryChildLayoutV8 != null) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            Context context = cJRProcessingOrderSummaryChildLayoutV8.getContext();
            k.a((Object) context, "context");
            cJRProcessingOrderSummaryChildLayoutV8.setTitleReceived(viewModel.N(context));
            net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
            Context context2 = cJRProcessingOrderSummaryChildLayoutV8.getContext();
            k.a((Object) context2, "context");
            cJRProcessingOrderSummaryChildLayoutV8.setDescriptionReceived(viewModel2.M(context2));
            cJRProcessingOrderSummaryChildLayoutV8.a((AnimatorListenerAdapter) new c(this, cJROrderSummary));
            cJRProcessingOrderSummaryChildLayoutV8.a(this.f64514c);
            net.one97.paytm.recharge.ordersummary.b.a viewModel3 = getViewModel();
            d.a aVar = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
            viewModel3.c(net.one97.paytm.recharge.ordersummary.h.d.o, (String) null);
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryLayoutV8 f64520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummary f64521b;

        c(CJRProcessingOrderSummaryLayoutV8 cJRProcessingOrderSummaryLayoutV8, CJROrderSummary cJROrderSummary) {
            this.f64520a = cJRProcessingOrderSummaryLayoutV8;
            this.f64521b = cJROrderSummary;
        }

        public final void onAnimationEnd(Animator animator) {
            View findViewById = this.f64520a.getRootLayout().findViewById(R.id.child_container);
            if (findViewById != null) {
                LinearLayout linearLayout = (LinearLayout) findViewById;
                CJRProcessingOrderSummaryLayoutV8 cJRProcessingOrderSummaryLayoutV8 = this.f64520a;
                Context context = linearLayout.getContext();
                k.a((Object) context, "context");
                net.one97.paytm.recharge.ordersummary.b.a b2 = this.f64520a.getViewModel();
                Context context2 = linearLayout.getContext();
                k.a((Object) context2, "context");
                String H = b2.H(context2);
                net.one97.paytm.recharge.ordersummary.b.a b3 = this.f64520a.getViewModel();
                Context context3 = linearLayout.getContext();
                k.a((Object) context3, "context");
                String G = b3.G(context3);
                net.one97.paytm.recharge.ordersummary.b.a b4 = this.f64520a.getViewModel();
                Context context4 = linearLayout.getContext();
                k.a((Object) context4, "context");
                String J = b4.J(context4);
                net.one97.paytm.recharge.ordersummary.b.a b5 = this.f64520a.getViewModel();
                Context context5 = linearLayout.getContext();
                k.a((Object) context5, "context");
                cJRProcessingOrderSummaryLayoutV8.setRechargeProcessingView(new CJRProcessingOrderSummaryChildLayoutV8(context, H, G, J, b5.I(context5), CJRProcessingOrderSummaryLayoutV8.b(this.f64521b), R.layout.processing_order_summary_child_v8));
                linearLayout.addView(this.f64520a.getRechargeProcessingView());
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
    }

    public final void a(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8 = this.f64517f;
        if (cJRProcessingOrderSummaryChildLayoutV8 != null) {
            cJRProcessingOrderSummaryChildLayoutV8.a(this.f64512a);
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            d.a aVar2 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
            viewModel.c(net.one97.paytm.recharge.ordersummary.h.d.t, (String) null);
        } else {
            CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV82 = this.f64516e;
            if (cJRProcessingOrderSummaryChildLayoutV82 != null) {
                cJRProcessingOrderSummaryChildLayoutV82.a(this.f64512a);
                net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
                d.a aVar3 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                viewModel2.c(net.one97.paytm.recharge.ordersummary.h.d.q, (String) null);
            }
        }
        postDelayed(new b(aVar), this.f64515d);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q.a f64519a;

        b(q.a aVar) {
            this.f64519a = aVar;
        }

        public final void run() {
            this.f64519a.a();
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryChildLayoutV8 f64522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryLayoutV8 f64523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q.a f64524c;

        d(CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8, CJRProcessingOrderSummaryLayoutV8 cJRProcessingOrderSummaryLayoutV8, q.a aVar) {
            this.f64522a = cJRProcessingOrderSummaryChildLayoutV8;
            this.f64523b = cJRProcessingOrderSummaryLayoutV8;
            this.f64524c = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            this.f64522a.a(this.f64523b.getSUCCESS_LOTTIE_JSON());
            net.one97.paytm.recharge.ordersummary.b.a b2 = this.f64523b.getViewModel();
            d.a aVar = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
            b2.c(net.one97.paytm.recharge.ordersummary.h.d.r, (String) null);
            this.f64522a.postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f64525a;

                {
                    this.f64525a = r1;
                }

                public final void run() {
                    this.f64525a.f64524c.a();
                }
            }, this.f64523b.getDELAY_IN_MILLI_FINAL_STATE_TRANSITION());
        }
    }

    public final void b(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8 = this.f64517f;
        if (cJRProcessingOrderSummaryChildLayoutV8 != null) {
            cJRProcessingOrderSummaryChildLayoutV8.a((AnimatorListenerAdapter) new d(cJRProcessingOrderSummaryChildLayoutV8, this, aVar));
            return;
        }
        CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV82 = this.f64516e;
        if (cJRProcessingOrderSummaryChildLayoutV82 != null) {
            cJRProcessingOrderSummaryChildLayoutV82.a((AnimatorListenerAdapter) new e(cJRProcessingOrderSummaryChildLayoutV82, this, aVar));
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryChildLayoutV8 f64526a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRProcessingOrderSummaryLayoutV8 f64527b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q.a f64528c;

        e(CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8, CJRProcessingOrderSummaryLayoutV8 cJRProcessingOrderSummaryLayoutV8, q.a aVar) {
            this.f64526a = cJRProcessingOrderSummaryChildLayoutV8;
            this.f64527b = cJRProcessingOrderSummaryLayoutV8;
            this.f64528c = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            this.f64526a.a(this.f64527b.getSUCCESS_LOTTIE_JSON());
            net.one97.paytm.recharge.ordersummary.b.a b2 = this.f64527b.getViewModel();
            d.a aVar = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
            b2.c(net.one97.paytm.recharge.ordersummary.h.d.o, (String) null);
            this.f64526a.postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ e f64529a;

                {
                    this.f64529a = r1;
                }

                public final void run() {
                    this.f64529a.f64528c.a();
                }
            }, this.f64527b.getDELAY_IN_MILLI_FINAL_STATE_TRANSITION());
        }
    }

    public final void c(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV8 = this.f64517f;
        if (cJRProcessingOrderSummaryChildLayoutV8 != null) {
            cJRProcessingOrderSummaryChildLayoutV8.a(this.f64513b);
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            d.a aVar2 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
            viewModel.c(net.one97.paytm.recharge.ordersummary.h.d.s, (String) null);
        } else {
            CJRProcessingOrderSummaryChildLayoutV8 cJRProcessingOrderSummaryChildLayoutV82 = this.f64516e;
            if (cJRProcessingOrderSummaryChildLayoutV82 != null) {
                cJRProcessingOrderSummaryChildLayoutV82.a(this.f64513b);
                net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
                d.a aVar3 = net.one97.paytm.recharge.ordersummary.h.d.f64339c;
                viewModel2.c(net.one97.paytm.recharge.ordersummary.h.d.p, (String) null);
            }
        }
        postDelayed(new a(aVar), this.f64515d);
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q.a f64518a;

        a(q.a aVar) {
            this.f64518a = aVar;
        }

        public final void run() {
            this.f64518a.a();
        }
    }
}
