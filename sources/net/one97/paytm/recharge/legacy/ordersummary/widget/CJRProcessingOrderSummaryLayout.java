package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.b;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.p;
import androidx.transition.v;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.d.q;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.h.d;

public class CJRProcessingOrderSummaryLayout extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private CJROrderSummary f63117a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewGroup f63118b;

    /* renamed from: c  reason: collision with root package name */
    private final CJRRechargeCart f63119c;

    /* renamed from: d  reason: collision with root package name */
    private final l f63120d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnClickListener f63121e;

    /* renamed from: f  reason: collision with root package name */
    private final r f63122f;

    /* renamed from: g  reason: collision with root package name */
    private final a f63123g;

    public final ViewGroup getRootLayout() {
        return this.f63118b;
    }

    /* access modifiers changed from: protected */
    public final CJRRechargeCart getCart() {
        return this.f63119c;
    }

    /* access modifiers changed from: protected */
    public final l getOnSummaryRequired() {
        return this.f63120d;
    }

    /* access modifiers changed from: protected */
    public final View.OnClickListener getClickListener() {
        return this.f63121e;
    }

    /* access modifiers changed from: protected */
    public final r getRechargeOrderSummaryInteractionListener() {
        return this.f63122f;
    }

    public final a getViewModel() {
        return this.f63123g;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryLayout(Context context, ViewGroup viewGroup, CJRRechargeCart cJRRechargeCart, l lVar, View.OnClickListener onClickListener, r rVar, a aVar) {
        super(context, (AttributeSet) null, 0);
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(aVar, "viewModel");
        this.f63118b = viewGroup;
        this.f63119c = cJRRechargeCart;
        this.f63120d = lVar;
        this.f63121e = onClickListener;
        this.f63122f = rVar;
        this.f63123g = aVar;
        setBackgroundColor(b.c(context, 17170443));
        LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        v.a(new p(this.f63118b, this));
        b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRProcessingOrderSummaryLayout(Context context, ViewGroup viewGroup, CJRRechargeCart cJRRechargeCart, l lVar, View.OnClickListener onClickListener, r rVar, a aVar, byte b2) {
        this(context, viewGroup, cJRRechargeCart, lVar, onClickListener, rVar, aVar);
        k.c(context, "context");
        k.c(viewGroup, "rootLayout");
        k.c(aVar, "viewModel");
    }

    /* access modifiers changed from: protected */
    public final CJROrderSummary getOrderSummary() {
        return this.f63117a;
    }

    /* access modifiers changed from: protected */
    public final void setOrderSummary(CJROrderSummary cJROrderSummary) {
        this.f63117a = cJROrderSummary;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.recharge_order_summary_processing;
    }

    /* access modifiers changed from: protected */
    public void a() {
        View findViewById = this.f63118b.findViewById(R.id.operator);
        if (findViewById != null) {
            a aVar = this.f63123g;
            Context context = getContext();
            k.a((Object) context, "context");
            ((TextView) findViewById).setText(aVar.a(context));
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0048, code lost:
        r8 = r8.getCart();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r9 = this;
            r9.a()
            android.view.ViewGroup r0 = r9.f63118b
            int r1 = net.one97.paytm.recharge.R.id.message
            android.view.View r0 = r0.findViewById(r1)
            if (r0 == 0) goto L_0x0088
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.recharge.ordersummary.b.a r1 = r9.f63123g
            android.content.Context r2 = r9.getContext()
            java.lang.String r3 = "context"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r1 = r1.D(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            androidx.transition.p r0 = new androidx.transition.p
            android.view.ViewGroup r1 = r9.f63118b
            int r2 = net.one97.paytm.recharge.R.id.child_container
            android.view.View r1 = r1.findViewById(r2)
            if (r1 == 0) goto L_0x0080
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryChildLayout r2 = new net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryChildLayout
            android.content.Context r4 = r9.getContext()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.content.Context r3 = r9.getContext()
            int r5 = net.one97.paytm.recharge.R.string.processing_amount
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 0
            net.one97.paytm.common.entity.CJRRechargeCart r8 = r9.f63119c
            if (r8 == 0) goto L_0x0053
            net.one97.paytm.common.entity.shopping.CJRCart r8 = r8.getCart()
            if (r8 == 0) goto L_0x0053
            java.lang.String r8 = r8.getFinalPrice()
            goto L_0x0054
        L_0x0053:
            r8 = 0
        L_0x0054:
            java.lang.String r8 = com.paytm.utility.b.x((java.lang.String) r8)
            r6[r7] = r8
            java.lang.String r3 = r3.getString(r5, r6)
            java.lang.String r5 = "context.getString(R.stri…(cart?.cart?.finalPrice))"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            android.content.Context r5 = r9.getContext()
            int r6 = net.one97.paytm.recharge.R.string.from_your_bank_wallet
            java.lang.String r5 = r5.getString(r6)
            java.lang.String r6 = "context.getString(R.string.from_your_bank_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r6 = ""
            r2.<init>(r4, r3, r5, r6)
            android.view.View r2 = (android.view.View) r2
            r0.<init>(r1, r2)
            androidx.transition.v.a((androidx.transition.p) r0)
            return
        L_0x0080:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup"
            r0.<init>(r1)
            throw r0
        L_0x0088:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout.b():void");
    }

    public void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        a aVar = this.f63123g;
        d.a aVar2 = d.f64339c;
        aVar.c(d.o, (String) null);
        View findViewById = this.f63118b.findViewById(R.id.child_container);
        if (findViewById != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            Context context = getContext();
            k.a((Object) context, "context");
            a aVar3 = this.f63123g;
            Context context2 = getContext();
            k.a((Object) context2, "context");
            String c2 = aVar3.c(context2);
            if (c2 == null) {
                c2 = "";
            }
            Context context3 = getContext();
            int i2 = R.string.of_amount;
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.orderedCartList[0]");
            String string = context3.getString(i2, new Object[]{com.paytm.utility.b.a(cJROrderedCart.getSubTotal())});
            k.a((Object) string, "context.getString(R.stri…redCartList[0].subTotal))");
            CJRProcessingOrderSummaryChildLayout cJRProcessingOrderSummaryChildLayout = new CJRProcessingOrderSummaryChildLayout(context, c2, string, b(cJROrderSummary));
            if (Build.VERSION.SDK_INT >= 21) {
                TransitionManager.go(new Scene(viewGroup, cJRProcessingOrderSummaryChildLayout), new net.one97.paytm.recharge.legacy.ordersummary.c.a());
            } else {
                v.a(new p(viewGroup, cJRProcessingOrderSummaryChildLayout), (Transition) new AutoTransition());
            }
            View findViewById2 = this.f63118b.findViewById(R.id.message);
            if (findViewById2 != null) {
                a aVar4 = this.f63123g;
                Context context4 = getContext();
                k.a((Object) context4, "context");
                ((TextView) findViewById2).setText(aVar4.k(context4));
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public void a(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        aVar.a();
        if (2 != cJROrderSummary.getOrderStatus()) {
            a aVar2 = this.f63123g;
            d.a aVar3 = d.f64339c;
            aVar2.c(d.q, (String) null);
            return;
        }
        a aVar4 = this.f63123g;
        d.a aVar5 = d.f64339c;
        aVar4.c(d.t, (String) null);
    }

    public void b(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        aVar.a();
        a aVar2 = this.f63123g;
        d.a aVar3 = d.f64339c;
        aVar2.c(d.r, (String) null);
    }

    public void c(CJROrderSummary cJROrderSummary, q.a aVar) {
        k.c(cJROrderSummary, "orderSummary");
        k.c(aVar, "listener");
        aVar.a();
        if (2 != cJROrderSummary.getOrderStatus()) {
            a aVar2 = this.f63123g;
            d.a aVar3 = d.f64339c;
            aVar2.c(d.p, (String) null);
            return;
        }
        a aVar4 = this.f63123g;
        d.a aVar5 = d.f64339c;
        aVar4.c(d.s, (String) null);
    }

    public static String b(CJROrderSummary cJROrderSummary) {
        String str;
        CJROrderSummaryProductDetail productDetail;
        String thumbnail;
        CJROrderSummaryProductDetail productDetail2;
        k.c(cJROrderSummary, "orderSummary");
        CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
        if (cJROrderedCart == null || (productDetail2 = cJROrderedCart.getProductDetail()) == null || (str = productDetail2.getImageUrl()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        CJROrderedCart cJROrderedCart2 = cJROrderSummary.getOrderedCartList().get(0);
        if (cJROrderedCart2 == null || (productDetail = cJROrderedCart2.getProductDetail()) == null || (thumbnail = productDetail.getThumbnail()) == null) {
            return "";
        }
        return thumbnail;
    }
}
