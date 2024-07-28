package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.n;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.d.q;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.ordersummary.g.f;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class CJRPendingOrderSummary extends CJRBaseFailedPendingOrderSummary implements DialogInterface.OnClickListener, l, t.b {

    /* renamed from: a  reason: collision with root package name */
    private double f63105a = 1.0d;

    /* renamed from: b  reason: collision with root package name */
    private Calendar f63106b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public l f63107c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f63108d;

    /* renamed from: e  reason: collision with root package name */
    private String f63109e;

    /* renamed from: f  reason: collision with root package name */
    private String f63110f;

    /* renamed from: g  reason: collision with root package name */
    private f f63111g;

    /* renamed from: h  reason: collision with root package name */
    private CJRProcessingOrderSummaryLayout f63112h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f63113i;
    private CJROrderSummary j;
    private final r k;

    public final void a(int i2, int i3) {
    }

    public final void c() {
    }

    public final ViewGroup getRootLayout() {
        return this.f63113i;
    }

    public final void setRootLayout(ViewGroup viewGroup) {
        k.c(viewGroup, "<set-?>");
        this.f63113i = viewGroup;
    }

    public final CJROrderSummary getOrderSummary() {
        return this.j;
    }

    public final void setOrderSummary(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "<set-?>");
        this.j = cJROrderSummary;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRPendingOrderSummary(Context context, ViewGroup viewGroup, CJROrderSummary cJROrderSummary, CJROSActionResponseV2 cJROSActionResponseV2, r rVar, View.OnClickListener onClickListener, int i2, net.one97.paytm.recharge.ordersummary.b.a aVar) {
        super(context, viewGroup, i2, R.drawable.ic_pending_copy, rVar, onClickListener, aVar);
        String str;
        CharSequence charSequence;
        boolean z;
        CJROrderSummaryActionURLParams urlParams;
        List<CJROSActionItemV2> actions;
        List<CJROSActionItemV2> actions2;
        Context context2 = context;
        ViewGroup viewGroup2 = viewGroup;
        CJROrderSummary cJROrderSummary2 = cJROrderSummary;
        CJROSActionResponseV2 cJROSActionResponseV22 = cJROSActionResponseV2;
        View.OnClickListener onClickListener2 = onClickListener;
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = aVar;
        k.c(context2, "context");
        k.c(viewGroup2, "rootLayout");
        k.c(cJROrderSummary2, "orderSummary");
        k.c(aVar2, "viewModel");
        this.f63113i = viewGroup2;
        this.j = cJROrderSummary2;
        this.k = rVar;
        Calendar instance = Calendar.getInstance();
        k.a((Object) instance, "Calendar.getInstance()");
        this.f63106b = instance;
        if (aVar2.s) {
            if (onClickListener2 instanceof l) {
                this.f63107c = (l) onClickListener2;
            }
            postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CJRPendingOrderSummary f63114a;

                {
                    this.f63114a = r1;
                }

                public final void run() {
                    l a2 = this.f63114a.f63107c;
                    if (a2 != null) {
                        a2.a((l) this.f63114a);
                    }
                }
            }, getExponentialBackoff());
        }
        TextView textView = (TextView) findViewById(R.id.pending_action_button);
        View findViewById = findViewById(R.id.message_layout);
        k.a((Object) findViewById, "findViewById<LinearLayout>(R.id.message_layout)");
        ((LinearLayout) findViewById).setVisibility(0);
        View findViewById2 = findViewById(R.id.message);
        k.a((Object) findViewById2, "findViewById<TextView>(R.id.message)");
        this.f63108d = (TextView) findViewById2;
        if (1 == this.j.getOrderStatus()) {
            str = context2.getString(R.string.money_already_deducted);
            k.a((Object) str, "context.getString(R.string.money_already_deducted)");
            k.a((Object) textView, "actionButton");
            textView.setVisibility(0);
            getTitle().setText(aVar.p());
            this.f63108d.setText(aVar.o());
        } else {
            CJROrderedCart cJROrderedCart = this.j.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.orderedCartList[0]");
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            k.a((Object) productDetail, "orderSummary.orderedCartList[0].productDetail");
            CJRAttributes attributes = productDetail.getAttributes();
            k.a((Object) attributes, "orderSummary.orderedCart….productDetail.attributes");
            this.f63110f = attributes.getPayTypeDisplayLabel();
            getTitle().setText(aVar2.m(context2));
            TextView textView2 = this.f63108d;
            if (TextUtils.isEmpty(cJROSActionResponseV22 != null ? cJROSActionResponseV2.getMessage() : null)) {
                charSequence = aVar2.l(context2);
            } else {
                charSequence = aVar2.a(cJROSActionResponseV22);
            }
            textView2.setText(charSequence);
            if (cJROSActionResponseV22 != null && (actions2 = cJROSActionResponseV2.getActions()) != null) {
                Iterable iterable = actions2;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (k.a((Object) ((CJROSActionItemV2) it2.next()).getLabel(), (Object) "Cancel")) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                k.a((Object) textView, "actionButton");
                textView.setVisibility(0);
                String g2 = aVar2.g(context2);
                if (cJROSActionResponseV22 == null || (actions = cJROSActionResponseV2.getActions()) == null) {
                    r10 = null;
                } else {
                    for (CJROSActionItemV2 cJROSActionItemV2 : actions) {
                        if (k.a((Object) cJROSActionItemV2.getLabel(), (Object) "Cancel")) {
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                this.f63109e = (cJROSActionItemV2 == null || (urlParams = cJROSActionItemV2.getUrlParams()) == null) ? null : urlParams.getUrl();
                String c2 = com.paytm.utility.b.c(context2, this.f63109e);
                k.a((Object) c2, "CJRAppCommonUtility.addS…Token(context, cancelUrl)");
                this.f63109e = p.a(c2, " ", "%20", false);
                str = g2;
            } else {
                str = "";
            }
            View findViewById3 = findViewById(R.id.container_main);
            LinearLayout linearLayout = (LinearLayout) (!(findViewById3 instanceof LinearLayout) ? null : findViewById3);
            int indexOfChild = linearLayout != null ? linearLayout.indexOfChild(findViewById(R.id.need_help)) : -1;
            if (indexOfChild >= 0 && linearLayout != null) {
                Context context3 = getContext();
                k.a((Object) context3, "context");
                net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
                CJROrderedCart u = getViewModel().u();
                if (u == null) {
                    k.a();
                }
                linearLayout.addView(new CJRBaseRechargeOrderPaymentDetailsView(context3, viewModel, u), indexOfChild + 1);
            }
        }
        k.a((Object) textView, "actionButton");
        textView.setText(str);
        textView.setOnClickListener(this);
        d();
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) (!(context2 instanceof AJRechargeOrderSummaryActivity) ? null : context2);
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.b();
        }
    }

    public final void a(l lVar) {
        k.c(lVar, "onSummaryListener");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        this.j = cJROrderSummary;
        if (2 == cJROrderSummary.getOrderStatus()) {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart, "orderSummary.orderedCartList[0]");
            if ("7".equals(cJROrderedCart.getItemStatus())) {
                l lVar = this.f63107c;
                if (lVar != null) {
                    lVar.c();
                    return;
                }
                return;
            }
        }
        if (!(4 == cJROrderSummary.getOrderStatus() || 8 == cJROrderSummary.getOrderStatus())) {
            net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
            CJROrderedCart cJROrderedCart2 = cJROrderSummary.getOrderedCartList().get(0);
            k.a((Object) cJROrderedCart2, "orderSummary.orderedCartList[0]");
            if (!viewModel.a(cJROrderedCart2)) {
                if (this.f63105a < 4.0d) {
                    postDelayed(new a(this), getExponentialBackoff());
                    return;
                }
                return;
            }
        }
        if (getClickListener() instanceof q) {
            View.OnClickListener clickListener = getClickListener();
            if (clickListener != null) {
                ((q) clickListener).c(cJROrderSummary);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.fragment.FJRPreSuccessRechargeOrderSummaryFragment");
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRPendingOrderSummary f63115a;

        a(CJRPendingOrderSummary cJRPendingOrderSummary) {
            this.f63115a = cJRPendingOrderSummary;
        }

        public final void run() {
            l a2 = this.f63115a.f63107c;
            if (a2 != null) {
                a2.a((l) this.f63115a);
            }
        }
    }

    private final long getExponentialBackoff() {
        double d2 = this.f63105a;
        this.f63105a = 1.0d + d2;
        return ((long) Math.pow(2.0d, d2)) * 1000;
    }

    public final CJRProcessingOrderSummaryLayout getProcessingOrderSummaryLayoutView() {
        return this.f63112h;
    }

    public final void setProcessingOrderSummaryLayoutView(CJRProcessingOrderSummaryLayout cJRProcessingOrderSummaryLayout) {
        this.f63112h = cJRProcessingOrderSummaryLayout;
    }

    private final void d() {
        net.one97.paytm.recharge.ordersummary.b.a viewModel = getViewModel();
        Context context = getContext();
        k.a((Object) context, "context");
        SpannableString d2 = viewModel.d(context);
        CharSequence charSequence = d2;
        int a2 = p.a(charSequence, "My", 0, false, 6);
        if (a2 != -1) {
            int i2 = a2 + 9;
            d2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getContext(), R.color.order_summary_blue)), a2, i2, 33);
            d2.setSpan(new b(this), a2, i2, 33);
        }
        TextView textView = (TextView) findViewById(R.id.recharge_pending_message);
        k.a((Object) textView, "pendingMessage");
        textView.setText(charSequence);
        textView.setVisibility(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final class b extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRPendingOrderSummary f63116a;

        b(CJRPendingOrderSummary cJRPendingOrderSummary) {
            this.f63116a = cJRPendingOrderSummary;
        }

        public final void onClick(View view) {
            k.c(view, "widget");
            Context context = this.f63116a.getContext();
            if (context != null) {
                ((Activity) context).onBackPressed();
                if (this.f63116a.getViewModel().s) {
                    try {
                        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                        Context context2 = this.f63116a.getContext();
                        k.a((Object) context2, "context");
                        c cVar = c.f62654a;
                        cJRRechargeUtilities.launchDeeplink(context2, c.bH(), new CJRHomePageItem());
                    } catch (Exception unused) {
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            k.c(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x013c, code lost:
        r0 = (r0 = r0.getOrderedCartList()).get(0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x01a2
            int r0 = r11.getId()
            int r1 = net.one97.paytm.recharge.R.id.pending_action_button
            if (r0 != r1) goto L_0x01a2
            net.one97.paytm.common.entity.shopping.CJROrderSummary r11 = r10.j
            int r11 = r11.getOrderStatus()
            java.lang.String r0 = "context"
            r1 = 1
            r2 = 0
            if (r1 != r11) goto L_0x0059
            android.content.Context r11 = r10.getContext()
            int r1 = net.one97.paytm.recharge.R.string.money_already_deducted
            java.lang.String r11 = r11.getString(r1)
            java.lang.String r1 = "context.getString(R.string.money_already_deducted)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            android.content.Context r1 = r10.getContext()
            int r3 = net.one97.paytm.recharge.R.string.okay_got_it
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r3 = "context.getString(R.string.okay_got_it)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.content.Context r3 = r10.getContext()
            int r4 = net.one97.paytm.recharge.R.string.still_need_help
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.string.still_need_help)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r10.getViewModel()
            android.content.Context r5 = r10.getContext()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            java.util.List r0 = r4.e(r5)
            r6 = r0
            r4 = r1
            r5 = r3
            r1 = 0
        L_0x0056:
            r3 = r11
            goto L_0x011e
        L_0x0059:
            net.one97.paytm.recharge.ordersummary.b.a r11 = r10.getViewModel()
            java.lang.String r3 = "cancel_transaction_clicked"
            r11.c(r3, (java.lang.String) null)
            android.content.Context r11 = r10.getContext()
            int r3 = net.one97.paytm.recharge.R.string.please_note
            java.lang.String r11 = r11.getString(r3)
            java.lang.String r3 = "context.getString(R.string.please_note)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)
            android.content.Context r3 = r10.getContext()
            int r4 = net.one97.paytm.recharge.R.string.cancel_anyway
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.string.cancel_anyway)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r10.getViewModel()
            android.content.Context r5 = r10.getContext()
            if (r5 != 0) goto L_0x008d
            kotlin.g.b.k.a()
        L_0x008d:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r10.j
            java.util.ArrayList r6 = r6.getOrderedCartList()
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r7 = "orderSummary.orderedCartList[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            java.lang.String r4 = r4.m(r5, r6)
            net.one97.paytm.recharge.ordersummary.b.a r5 = r10.getViewModel()
            android.content.Context r6 = r10.getContext()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            java.util.List r0 = r5.i(r6)
            net.one97.paytm.recharge.ordersummary.b.a r5 = r10.getViewModel()
            android.content.Context r6 = r10.getContext()
            if (r6 != 0) goto L_0x00be
            kotlin.g.b.k.a()
        L_0x00be:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r10.j
            java.util.ArrayList r8 = r8.getOrderedCartList()
            java.lang.Object r8 = r8.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            boolean r5 = r5.n(r6, r8)
            if (r5 == 0) goto L_0x0118
            net.one97.paytm.recharge.ordersummary.b.a r0 = r10.getViewModel()
            android.content.Context r3 = r10.getContext()
            if (r3 != 0) goto L_0x00e0
            kotlin.g.b.k.a()
        L_0x00e0:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r10.j
            java.util.ArrayList r4 = r4.getOrderedCartList()
            java.lang.Object r4 = r4.get(r2)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            java.lang.String r0 = r0.d(r3, r4)
            android.content.Context r3 = r10.getContext()
            int r4 = net.one97.paytm.recharge.R.string.imps_wait_for_confirmation
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.stri…ps_wait_for_confirmation)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r10.getViewModel()
            android.content.Context r5 = r10.getContext()
            if (r5 != 0) goto L_0x010f
            kotlin.g.b.k.a()
        L_0x010f:
            java.util.List r4 = r4.f(r5)
            r5 = r3
            r6 = r4
            r3 = r11
            r4 = r0
            goto L_0x011e
        L_0x0118:
            r6 = r0
            r5 = r4
            r1 = 0
            r4 = r3
            goto L_0x0056
        L_0x011e:
            android.content.Context r11 = r10.getContext()
            if (r11 == 0) goto L_0x019a
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            androidx.fragment.app.j r11 = r11.getSupportFragmentManager()
            java.lang.String r0 = "(context as AppCompatAct…y).supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            if (r1 == 0) goto L_0x0187
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r10.j
            r1 = 0
            if (r0 == 0) goto L_0x014e
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x014e
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x014e
            double r7 = r0.getSubTotal()
            java.lang.Double r0 = java.lang.Double.valueOf(r7)
            r8 = r0
            goto L_0x014f
        L_0x014e:
            r8 = r1
        L_0x014f:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r10.j
            if (r0 != 0) goto L_0x0156
            kotlin.g.b.k.a()
        L_0x0156:
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x0170
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0170
            long r0 = r0.getCategoryId()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
        L_0x0170:
            java.lang.String r9 = java.lang.String.valueOf(r1)
            net.one97.paytm.recharge.ordersummary.c.h$a r0 = net.one97.paytm.recharge.ordersummary.c.h.f64069a
            r7 = r10
            android.content.DialogInterface$OnClickListener r7 = (android.content.DialogInterface.OnClickListener) r7
            net.one97.paytm.recharge.ordersummary.c.h r0 = net.one97.paytm.recharge.ordersummary.c.h.a.a(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Class<net.one97.paytm.recharge.ordersummary.c.h> r1 = net.one97.paytm.recharge.ordersummary.c.h.class
            java.lang.String r1 = r1.getSimpleName()
            r0.show((androidx.fragment.app.j) r11, (java.lang.String) r1)
            return
        L_0x0187:
            net.one97.paytm.recharge.ordersummary.d.r$a r0 = net.one97.paytm.recharge.ordersummary.d.r.f64226d
            r0 = r10
            android.content.DialogInterface$OnClickListener r0 = (android.content.DialogInterface.OnClickListener) r0
            net.one97.paytm.recharge.ordersummary.d.r r0 = net.one97.paytm.recharge.ordersummary.d.r.a.a(r3, r4, r5, r6, r0)
            java.lang.Class<net.one97.paytm.recharge.ordersummary.d.r> r1 = net.one97.paytm.recharge.ordersummary.d.r.class
            java.lang.String r1 = r1.getSimpleName()
            r0.show((androidx.fragment.app.j) r11, (java.lang.String) r1)
            return
        L_0x019a:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            r11.<init>(r0)
            throw r11
        L_0x01a2:
            super.onClick(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRPendingOrderSummary.onClick(android.view.View):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.content.DialogInterface r8, int r9) {
        /*
            r7 = this;
            r8 = 1
            r0 = -2
            if (r9 != r0) goto L_0x0016
            net.one97.paytm.common.entity.shopping.CJROrderSummary r9 = r7.j
            int r9 = r9.getOrderStatus()
            if (r8 != r9) goto L_0x00df
            int r8 = net.one97.paytm.recharge.R.id.need_help
            android.view.View r8 = r7.findViewById(r8)
            r7.onClick(r8)
            return
        L_0x0016:
            android.content.Context r9 = r7.getContext()
            r0 = 0
            if (r9 == 0) goto L_0x005b
            android.content.Context r9 = r7.getContext()
            boolean r9 = com.paytm.utility.b.c((android.content.Context) r9)
            if (r9 != 0) goto L_0x005b
            net.one97.paytm.recharge.common.utils.az r8 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r8 = r7.getContext()
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            android.content.Context r2 = r7.getContext()
            if (r2 == 0) goto L_0x0044
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x0044
            int r3 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0045
        L_0x0044:
            r2 = r0
        L_0x0045:
            android.content.Context r3 = r7.getContext()
            if (r3 == 0) goto L_0x0057
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0057
            int r0 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r0 = r3.getString(r0)
        L_0x0057:
            net.one97.paytm.recharge.common.utils.az.a(r8, r9, r1, r2, r0)
            return
        L_0x005b:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r9 = r7.j
            int r9 = r9.getOrderStatus()
            if (r8 == r9) goto L_0x00df
            net.one97.paytm.recharge.ordersummary.b.a r8 = r7.getViewModel()
            android.content.Context r9 = r7.getContext()
            if (r9 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r7.j
            java.util.ArrayList r1 = r1.getOrderedCartList()
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r2 = "orderSummary.orderedCartList[0]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            boolean r8 = r8.n(r9, r1)
            if (r8 == 0) goto L_0x00b2
            r7.a()
            net.one97.paytm.recharge.ordersummary.g.f r8 = r7.f63111g
            if (r8 != 0) goto L_0x00aa
            net.one97.paytm.recharge.ordersummary.g.f r8 = new net.one97.paytm.recharge.ordersummary.g.f
            r9 = r7
            net.one97.paytm.recharge.ordersummary.f.t$b r9 = (net.one97.paytm.recharge.ordersummary.f.t.b) r9
            net.one97.paytm.recharge.common.b.c.e$a r0 = net.one97.paytm.recharge.common.b.c.e.f60936b
            android.content.Context r0 = r7.getContext()
            java.lang.String r1 = "context"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.common.b.c.e r0 = net.one97.paytm.recharge.common.b.c.e.a.a(r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r7.j
            r8.<init>(r9, r0, r1)
            r7.f63111g = r8
        L_0x00aa:
            net.one97.paytm.recharge.ordersummary.g.f r8 = r7.f63111g
            if (r8 == 0) goto L_0x00b1
            r8.a(0, (java.lang.String) null)
        L_0x00b1:
            return
        L_0x00b2:
            java.lang.String r8 = r7.f63109e
            if (r8 == 0) goto L_0x00df
            r7.a()
            r7.getContext()
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.b r8 = new net.one97.paytm.recharge.common.f.b
            java.lang.String r3 = r7.f63109e
            r4 = r7
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r9 = new net.one97.paytm.recharge.model.CJROSActionResponseV2
            r9.<init>()
            r5 = r9
            com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
            net.one97.paytm.recharge.widgets.c.d r9 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            java.lang.String r2 = "fetch_hit_cancel_api"
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            net.one97.paytm.recharge.common.f.a r8 = (net.one97.paytm.recharge.common.f.a) r8
            net.one97.paytm.recharge.common.f.d.b(r8)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRPendingOrderSummary.onClick(android.content.DialogInterface, int):void");
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        super.a_(str, iJRPaytmDataModel, obj);
        if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setActionType(ACTION_TYPE.OS_CTA_CANCEL.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            Context context = getContext();
            if (context != null) {
                String id = this.j.getId();
                k.a((Object) id, "orderSummary.id");
                ((CJRBaseOrderSummaryActivity) context).b(id, a2);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.CJRBaseOrderSummaryActivity");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ff A[Catch:{ Exception -> 0x013f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r9, java.lang.Integer r10) {
        /*
            r8 = this;
            r8.b()
            if (r10 != 0) goto L_0x0006
            return
        L_0x0006:
            int r10 = r10.intValue()
            if (r10 != 0) goto L_0x0146
            if (r9 == 0) goto L_0x0146
            boolean r10 = r9 instanceof net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8
            r0 = 0
            if (r10 != 0) goto L_0x0014
            r9 = r0
        L_0x0014:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r9 = (net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8) r9
            r10 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0093
            java.util.List r2 = r9.getOtherRefundConsultView()     // Catch:{ Exception -> 0x0093 }
            if (r2 == 0) goto L_0x0093
            if (r2 == 0) goto L_0x002b
            int r3 = r2.size()     // Catch:{ Exception -> 0x0093 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0093 }
            goto L_0x002c
        L_0x002b:
            r3 = r0
        L_0x002c:
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0093 }
            if (r3 <= 0) goto L_0x0093
            if (r2 == 0) goto L_0x0093
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0093 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0093 }
            r3 = 0
            r4 = 0
        L_0x003c:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x0091 }
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x0091 }
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x004d
            kotlin.a.k.a()     // Catch:{ Exception -> 0x0091 }
        L_0x004d:
            net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8 r5 = (net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8) r5     // Catch:{ Exception -> 0x0091 }
            if (r5 == 0) goto L_0x0056
            java.lang.String r3 = r5.getDestination()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0057
        L_0x0056:
            r3 = r0
        L_0x0057:
            java.lang.String r7 = "TO_INSTANT"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x008f
            if (r5 == 0) goto L_0x0066
            java.lang.String r3 = r5.getEnableStatus()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0067
        L_0x0066:
            r3 = r0
        L_0x0067:
            java.lang.String r7 = "true"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x0072
        L_0x0070:
            r4 = 1
            goto L_0x0094
        L_0x0072:
            if (r5 == 0) goto L_0x008f
            java.lang.String r3 = r5.getDisableReason()     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x008f
            java.lang.String r5 = "IMPS_ACCOUNT_NOT_EXIST"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r1)     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x008f
            if (r9 == 0) goto L_0x008e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0070 }
            r9.setStatus(r3)     // Catch:{ Exception -> 0x0070 }
            r3 = r6
            r4 = 1
            goto L_0x003c
        L_0x008e:
            r4 = 1
        L_0x008f:
            r3 = r6
            goto L_0x003c
        L_0x0091:
            goto L_0x0094
        L_0x0093:
            r4 = 0
        L_0x0094:
            if (r4 == 0) goto L_0x00ff
            if (r9 == 0) goto L_0x00b7
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.j     // Catch:{ Exception -> 0x013f }
            if (r1 == 0) goto L_0x00b3
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x013f }
            if (r1 == 0) goto L_0x00b3
            java.lang.Object r10 = r1.get(r10)     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10     // Catch:{ Exception -> 0x013f }
            if (r10 == 0) goto L_0x00b3
            double r1 = r10.getSubTotal()     // Catch:{ Exception -> 0x013f }
            java.lang.Double r10 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x013f }
            goto L_0x00b4
        L_0x00b3:
            r10 = r0
        L_0x00b4:
            r9.setRefundAmount(r10)     // Catch:{ Exception -> 0x013f }
        L_0x00b7:
            if (r9 == 0) goto L_0x00be
            java.lang.String r10 = r8.f63109e     // Catch:{ Exception -> 0x013f }
            r9.setCancelUrl(r10)     // Catch:{ Exception -> 0x013f }
        L_0x00be:
            if (r9 == 0) goto L_0x00cd
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.j     // Catch:{ Exception -> 0x013f }
            if (r10 == 0) goto L_0x00c9
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x013f }
            goto L_0x00ca
        L_0x00c9:
            r10 = r0
        L_0x00ca:
            r9.setOrderId(r10)     // Catch:{ Exception -> 0x013f }
        L_0x00cd:
            if (r9 == 0) goto L_0x00d4
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.j     // Catch:{ Exception -> 0x013f }
            r9.setOrderSummary(r10)     // Catch:{ Exception -> 0x013f }
        L_0x00d4:
            android.content.Context r10 = r8.getContext()     // Catch:{ Exception -> 0x013f }
            if (r10 == 0) goto L_0x00f7
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10     // Catch:{ Exception -> 0x013f }
            androidx.fragment.app.j r10 = r10.getSupportFragmentManager()     // Catch:{ Exception -> 0x013f }
            java.lang.String r1 = "(context as AppCompatAct…y).supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.ordersummary.c.f$a r1 = net.one97.paytm.recharge.ordersummary.c.f.f64058b     // Catch:{ Exception -> 0x013f }
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.ordersummary.c.f r9 = net.one97.paytm.recharge.ordersummary.c.f.a.a(r9, java.lang.Boolean.FALSE)     // Catch:{ Exception -> 0x013f }
            java.lang.Class<net.one97.paytm.recharge.ordersummary.c.f> r1 = net.one97.paytm.recharge.ordersummary.c.f.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x013f }
            r9.show((androidx.fragment.app.j) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x013f }
            return
        L_0x00f7:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x013f }
            java.lang.String r10 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            r9.<init>(r10)     // Catch:{ Exception -> 0x013f }
            throw r9     // Catch:{ Exception -> 0x013f }
        L_0x00ff:
            net.one97.paytm.recharge.ordersummary.d.a$a$a r9 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.PROCESSING     // Catch:{ Exception -> 0x013f }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.j     // Catch:{ Exception -> 0x013f }
            java.lang.String r10 = r10.getPaymentStatus()     // Catch:{ Exception -> 0x013f }
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r1)     // Catch:{ Exception -> 0x013f }
            if (r9 != 0) goto L_0x013e
            java.lang.String r9 = r8.f63109e     // Catch:{ Exception -> 0x013f }
            if (r9 == 0) goto L_0x013e
            r8.a()     // Catch:{ Exception -> 0x013f }
            r8.getContext()     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.common.f.d.a()     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.common.f.b r9 = new net.one97.paytm.recharge.common.f.b     // Catch:{ Exception -> 0x013f }
            java.lang.String r2 = "fetch_hit_cancel_api"
            java.lang.String r3 = r8.f63109e     // Catch:{ Exception -> 0x013f }
            r4 = r8
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r10 = new net.one97.paytm.recharge.model.CJROSActionResponseV2     // Catch:{ Exception -> 0x013f }
            r10.<init>()     // Catch:{ Exception -> 0x013f }
            r5 = r10
            com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.widgets.c.d r10 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)     // Catch:{ Exception -> 0x013f }
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.common.f.a r9 = (net.one97.paytm.recharge.common.f.a) r9     // Catch:{ Exception -> 0x013f }
            net.one97.paytm.recharge.common.f.d.b(r9)     // Catch:{ Exception -> 0x013f }
        L_0x013e:
            return
        L_0x013f:
            android.content.Context r9 = r8.getContext()
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r0)
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRPendingOrderSummary.a(com.paytm.network.model.IJRPaytmDataModel, java.lang.Integer):void");
    }

    public final void a(NetworkCustomError networkCustomError, Integer num) {
        k.c(networkCustomError, "error");
        d dVar = d.f64967a;
        String str = null;
        a("", 0, (IJRPaytmDataModel) null, networkCustomError, d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        try {
            if (!TextUtils.isEmpty(networkCustomError.getMessage()) && CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError) && getContext() != null) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Context context = getContext();
                if (context != null) {
                    cJRRechargeUtilities.showSessionTimeoutAlert((Activity) context, (String) null, (Bundle) null, networkCustomError, false, true);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.app.Activity");
            }
        } catch (Exception unused) {
        }
        if (num != null && num.intValue() == 0) {
            String alertMessage = !TextUtils.isEmpty(networkCustomError.getAlertMessage()) ? networkCustomError.getAlertMessage() : null;
            if (TextUtils.isEmpty(networkCustomError.getAlertTitle())) {
                str = networkCustomError.getAlertTitle();
            }
            ba.a(getContext(), alertMessage, str);
        }
    }
}
