package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.z;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.i;
import net.one97.paytm.recharge.ordersummary.f.p;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.h.a;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class CJRFailedOrderSummary extends CJRBaseFailedPendingOrderSummary implements i, p, a.C1266a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f63099a = ((TextView) findViewById(R.id.failed_description));

    /* renamed from: b  reason: collision with root package name */
    private final CJROrderSummary f63100b;

    /* renamed from: c  reason: collision with root package name */
    private final CJROSActionResponseV2 f63101c;

    /* renamed from: d  reason: collision with root package name */
    private final r f63102d;

    public final void aw_() {
    }

    /* access modifiers changed from: protected */
    public final CJROrderSummary getOrderSummary() {
        return this.f63100b;
    }

    /* access modifiers changed from: protected */
    public final r getRechargeOrderSummaryInteractionListener() {
        return this.f63102d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRFailedOrderSummary(android.content.Context r12, android.view.ViewGroup r13, int r14, int r15, net.one97.paytm.common.entity.shopping.CJROrderSummary r16, net.one97.paytm.recharge.model.CJROSActionResponseV2 r17, net.one97.paytm.recharge.ordersummary.f.r r18, android.view.View.OnClickListener r19, net.one97.paytm.recharge.ordersummary.b.a r20) {
        /*
            r11 = this;
            r8 = r11
            r9 = r12
            r10 = r16
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "rootLayout"
            r2 = r13
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "orderSummary"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "viewModel"
            r7 = r20
            kotlin.g.b.k.c(r7, r0)
            r0 = r11
            r1 = r12
            r3 = r14
            r4 = r15
            r5 = r18
            r6 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.f63100b = r10
            r0 = r17
            r8.f63101c = r0
            r0 = r18
            r8.f63102d = r0
            int r0 = net.one97.paytm.recharge.R.id.failed_action_button
            android.view.View r0 = r11.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "actionButton"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            int r2 = net.one97.paytm.recharge.R.id.failed_description
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r8.f63099a = r2
            android.widget.TextView r2 = r8.f63099a
            if (r2 == 0) goto L_0x0053
            r2.setVisibility(r1)
        L_0x0053:
            r11.c()
            r1 = r8
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            boolean r0 = r9 instanceof net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity
            if (r0 != 0) goto L_0x0062
            r0 = 0
            r9 = r0
        L_0x0062:
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r9 = (net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity) r9
            if (r9 == 0) goto L_0x0069
            r9.b()
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRFailedOrderSummary.<init>(android.content.Context, android.view.ViewGroup, int, int, net.one97.paytm.common.entity.shopping.CJROrderSummary, net.one97.paytm.recharge.model.CJROSActionResponseV2, net.one97.paytm.recharge.ordersummary.f.r, android.view.View$OnClickListener, net.one97.paytm.recharge.ordersummary.b.a):void");
    }

    /* access modifiers changed from: protected */
    public final TextView getDescription() {
        return this.f63099a;
    }

    /* access modifiers changed from: protected */
    public final void setDescription(TextView textView) {
        this.f63099a = textView;
    }

    /* access modifiers changed from: protected */
    public void c() {
        CharSequence charSequence;
        if (4 == this.f63100b.getOrderStatus() || 8 == this.f63100b.getOrderStatus()) {
            getTitle().setText(getViewModel().n());
            TextView textView = this.f63099a;
            if (textView != null) {
                textView.setText(getViewModel().m());
                return;
            }
            return;
        }
        TextView title = getTitle();
        net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
        CJROrderedCart cJROrderedCart = this.f63100b.getOrderedCartList().get(0);
        k.a((Object) cJROrderedCart, "orderSummary.orderedCartList[0]");
        if (viewModel.b(cJROrderedCart)) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
            Context context = getContext();
            k.a((Object) context, "context");
            charSequence = viewModel2.C(context);
        } else {
            net.one97.paytm.recharge.ordersummary.b.a viewModel3 = getViewModel();
            Context context2 = getContext();
            k.a((Object) context2, "context");
            charSequence = viewModel3.E(context2);
        }
        title.setText(charSequence);
        TextView textView2 = this.f63099a;
        if (textView2 != null) {
            textView2.setText(getViewModel().b(this.f63101c));
        }
        d();
    }

    /* access modifiers changed from: protected */
    public void d() {
        CharSequence refundDetails = getRefundDetails();
        if (!TextUtils.isEmpty(refundDetails)) {
            View findViewById = findViewById(R.id.message_layout);
            k.a((Object) findViewById, "findViewById<LinearLayout>(R.id.message_layout)");
            ((LinearLayout) findViewById).setVisibility(0);
            View findViewById2 = findViewById(R.id.message);
            k.a((Object) findViewById2, "(findViewById<TextView>(R.id.message))");
            ((TextView) findViewById2).setText(refundDetails);
        }
    }

    /* access modifiers changed from: protected */
    public String getRefundDetails() {
        Class<CJRFailedOrderSummary> cls = CJRFailedOrderSummary.class;
        net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
        IJRPaytmDataModel iJRPaytmDataModel = this.f63100b;
        CJROrderedCart u = getViewModel().u();
        if (u == null) {
            k.a();
        }
        if (viewModel.a(iJRPaytmDataModel, u)) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel2 = getViewModel();
            Context context = getContext();
            k.a((Object) context, "context");
            String F = viewModel2.F(context);
            if (!TextUtils.isEmpty(F)) {
                return F;
            }
            return "";
        } else if (!getViewModel().s) {
            return "";
        } else {
            try {
                Handler handler = new Handler(Looper.getMainLooper());
                d dVar = d.f64967a;
                z.a("fetch_order_detail", getContext(), "Order_summary", this.f63100b.getId(), this, this, this, handler, 1, d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
                return "";
            } catch (NullPointerException e2) {
                cls.getSimpleName();
                q.b(e2.getMessage());
                return "";
            } catch (IllegalStateException e3) {
                cls.getSimpleName();
                q.b(e3.getMessage());
                return "";
            }
        }
    }

    public final boolean a(IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
        CJROrderedCart u = getViewModel().u();
        if (u == null) {
            k.a();
        }
        return viewModel.a(iJRPaytmDataModel, u);
    }

    public void onClick(View view) {
        Map<String, String> rechargeConfiguration;
        super.onClick(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.failed_action_button;
        if (valueOf != null && valueOf.intValue() == i2) {
            view.setEnabled(false);
            CJROrderedCart u = getViewModel().u();
            if (u == null) {
                k.a();
            }
            if (getViewModel().a(u) || getViewModel().b(u)) {
                getViewModel().c("try_again_clicked", (String) null);
            }
            Context context = getContext();
            if (context != null) {
                net.one97.paytm.recharge.ordersummary.h.a aVar = ((AJRechargeOrderSummaryActivity) context).f63981d;
                if (aVar != null) {
                    aVar.f64307a = this;
                }
                CJROrderedCart cJROrderedCart = this.f63100b.getOrderedCartList().get(0);
                if (!(cJROrderedCart == null || (rechargeConfiguration = cJROrderedCart.getRechargeConfiguration()) == null)) {
                    rechargeConfiguration.put("is_for_order_history", "TRUE");
                }
                if (aVar != null) {
                    CJROrderedCart cJROrderedCart2 = this.f63100b.getOrderedCartList().get(0);
                    k.a((Object) cJROrderedCart2, "orderSummary.orderedCartList[0]");
                    aVar.a(cJROrderedCart2, true, true);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        super.a_(str, iJRPaytmDataModel, obj);
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            synchronized (getViewModel()) {
                getViewModel().a((CJROrderSummary) iJRPaytmDataModel);
                x xVar = x.f47997a;
            }
            d();
        }
    }

    public final void au_() {
        View findViewById = findViewById(R.id.failed_action_button);
        if (findViewById != null) {
            findViewById.postDelayed(new b(findViewById), 200);
        }
        Context context = getContext();
        if (!(context instanceof CJRBaseOrderSummaryActivity)) {
            context = null;
        }
        CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity = (CJRBaseOrderSummaryActivity) context;
        if (cJRBaseOrderSummaryActivity != null) {
            cJRBaseOrderSummaryActivity.c(true);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f63104a;

        b(View view) {
            this.f63104a = view;
        }

        public final void run() {
            this.f63104a.setEnabled(true);
        }
    }

    public final void av_() {
        View findViewById = findViewById(R.id.failed_action_button);
        if (findViewById != null) {
            findViewById.postDelayed(new a(findViewById), 200);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f63103a;

        a(View view) {
            this.f63103a = view;
        }

        public final void run() {
            this.f63103a.setEnabled(true);
        }
    }
}
