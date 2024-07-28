package net.one97.paytm.recharge.legacy.ordersummary.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.widgets.g;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.i;
import org.json.JSONObject;

public class CJRBaseRechargeOrderPaymentDetailsView extends LinearLayout implements ai, i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f63083a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f63084b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f63085c;

    /* renamed from: d  reason: collision with root package name */
    private View f63086d;

    /* renamed from: e  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f63087e;

    /* renamed from: f  reason: collision with root package name */
    private final CJROrderedCart f63088f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f63089g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f63090h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f63091i;
    private HashMap j;

    public View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f63087e;
    }

    public final CJROrderedCart getOrderedCart() {
        return this.f63088f;
    }

    public final boolean getShowPromoCode() {
        return this.f63089g;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0230  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRBaseRechargeOrderPaymentDetailsView(android.content.Context r23, net.one97.paytm.recharge.ordersummary.b.a r24, net.one97.paytm.common.entity.shopping.CJROrderedCart r25, boolean r26, boolean r27) {
        /*
            r22 = this;
            r1 = r22
            r0 = r24
            r2 = r25
            java.lang.String r3 = "Exception"
            java.lang.String r4 = "context"
            r5 = r23
            kotlin.g.b.k.c(r5, r4)
            java.lang.String r6 = "viewModel"
            kotlin.g.b.k.c(r0, r6)
            java.lang.String r6 = "orderedCart"
            kotlin.g.b.k.c(r2, r6)
            r22.<init>(r23)
            r1.f63087e = r0
            r1.f63088f = r2
            r0 = r26
            r1.f63089g = r0
            r0 = r27
            r1.f63090h = r0
            r2 = 0
            r1.f63091i = r2
            net.one97.paytm.recharge.ordersummary.b.a r0 = r1.f63087e
            java.util.List r0 = r0.v()
            boolean r0 = r0.isEmpty()
            r7 = 8
            if (r0 == 0) goto L_0x003d
            r1.setVisibility(r7)
            return
        L_0x003d:
            r8 = 1
            r1.setOrientation(r8)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r9 = -1
            r10 = -2
            r0.<init>(r9, r10)
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r1.setLayoutParams(r0)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            int r5 = r22.getLayoutResId()
            r9 = r1
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r0.inflate(r5, r9, r8)
            r22.a()
            boolean r0 = r1.f63089g
            if (r0 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63088f
            java.lang.String r0 = r0.getPromoCode()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0075
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r0 = 0
            goto L_0x0076
        L_0x0075:
            r0 = 1
        L_0x0076:
            if (r0 != 0) goto L_0x00ce
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63088f
            java.lang.String r0 = r0.getPromoText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x008b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r0 = 0
            goto L_0x008c
        L_0x008b:
            r0 = 1
        L_0x008c:
            if (r0 != 0) goto L_0x00ce
            r1.f63083a = r8
            int r0 = net.one97.paytm.recharge.R.id.layout_promo_code
            android.view.View r0 = r1.findViewById(r0)
            java.lang.String r5 = "(findViewById<View>(R.id.layout_promo_code))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            r0.setVisibility(r2)
            int r0 = net.one97.paytm.recharge.R.id.txt_promo_code
            android.view.View r0 = r1.findViewById(r0)
            java.lang.String r5 = "findViewById<TextView>(R.id.txt_promo_code)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = r1.f63088f
            java.lang.String r5 = r5.getPromoCode()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            int r0 = net.one97.paytm.recharge.R.id.txt_promo_description
            android.view.View r0 = r1.findViewById(r0)
            java.lang.String r5 = "findViewById<TextView>(R.id.txt_promo_description)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = r1.f63088f
            java.lang.String r5 = r5.getPromoText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
        L_0x00ce:
            r22.c()
            net.one97.paytm.recharge.ordersummary.b.a r0 = r1.f63087e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r0.f63998b
            if (r0 != 0) goto L_0x00da
            kotlin.g.b.k.a()
        L_0x00da:
            java.lang.String r5 = r0.getId()
            boolean r0 = r1.f63090h
            r9 = 0
            if (r0 == 0) goto L_0x01bb
            net.one97.paytm.recharge.ordersummary.h.b$a r0 = net.one97.paytm.recharge.ordersummary.h.b.f64312h
            android.content.Context r0 = r22.getContext()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r1.f63087e
            boolean r4 = r4.s
            net.one97.paytm.recharge.ordersummary.h.b r0 = net.one97.paytm.recharge.ordersummary.h.b.a.a(r0, r4)
            java.lang.String r4 = "tap_action"
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = r1.f63088f
            r15 = r1
            net.one97.paytm.recharge.common.e.ai r15 = (net.one97.paytm.recharge.common.e.ai) r15
            r14 = r1
            net.one97.paytm.recharge.ordersummary.f.i r14 = (net.one97.paytm.recharge.ordersummary.f.i) r14
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r13 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            java.lang.String r11 = "tag"
            kotlin.g.b.k.c(r4, r11)
            kotlin.g.b.k.c(r10, r6)
            java.lang.String r6 = "responseListener"
            kotlin.g.b.k.c(r15, r6)
            java.lang.String r6 = "limitExceedListener"
            kotlin.g.b.k.c(r14, r6)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r6 = r10.getTapAction()
            if (r6 == 0) goto L_0x012a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r3 = r10.getTapAction()
            java.lang.String r6 = "orderedCart.tapAction"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            r0.a(r4, r3, r13, r15)
            goto L_0x01bb
        L_0x012a:
            boolean r6 = r0.f64319g
            if (r6 == 0) goto L_0x01b7
            android.content.Context r11 = r0.f64316d     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            java.lang.String r12 = "Payment"
            java.lang.String r6 = r10.getOrderId()     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            net.one97.paytm.recharge.ordersummary.h.b$f r10 = new net.one97.paytm.recharge.ordersummary.h.b$f     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            r10.<init>(r0, r15)     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            r16 = r10
            net.one97.paytm.recharge.common.e.ai r16 = (net.one97.paytm.recharge.common.e.ai) r16     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            net.one97.paytm.recharge.ordersummary.f.p r0 = (net.one97.paytm.recharge.ordersummary.f.p) r0     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            android.os.Handler r10 = new android.os.Handler     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            android.os.Looper r9 = android.os.Looper.getMainLooper()     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            r10.<init>(r9)     // Catch:{ NullPointerException -> 0x018e, IllegalStateException -> 0x0165 }
            r18 = 0
            r9 = r10
            r10 = r4
            r20 = r13
            r13 = r6
            r6 = r14
            r14 = r16
            r21 = r15
            r15 = r0
            r16 = r6
            r17 = r9
            r19 = r20
            net.one97.paytm.recharge.common.utils.z.a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ NullPointerException -> 0x0163, IllegalStateException -> 0x0161 }
            goto L_0x01bb
        L_0x0161:
            r0 = move-exception
            goto L_0x016a
        L_0x0163:
            r0 = move-exception
            goto L_0x0193
        L_0x0165:
            r0 = move-exception
            r20 = r13
            r21 = r15
        L_0x016a:
            r12 = 0
            r13 = 0
            com.paytm.network.model.NetworkCustomError r14 = new com.paytm.network.model.NetworkCustomError
            java.lang.String r6 = r0.getMessage()
            if (r6 != 0) goto L_0x0175
            goto L_0x0176
        L_0x0175:
            r3 = r6
        L_0x0176:
            r14.<init>((java.lang.String) r3)
            r10 = r21
            r11 = r4
            r15 = r20
            r10.a(r11, r12, r13, r14, r15)
            java.lang.Class<net.one97.paytm.recharge.ordersummary.h.b> r3 = net.one97.paytm.recharge.ordersummary.h.b.class
            r3.getSimpleName()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x01bb
        L_0x018e:
            r0 = move-exception
            r20 = r13
            r21 = r15
        L_0x0193:
            r12 = 0
            r13 = 0
            com.paytm.network.model.NetworkCustomError r14 = new com.paytm.network.model.NetworkCustomError
            java.lang.String r6 = r0.getMessage()
            if (r6 != 0) goto L_0x019e
            goto L_0x019f
        L_0x019e:
            r3 = r6
        L_0x019f:
            r14.<init>((java.lang.String) r3)
            r10 = r21
            r11 = r4
            r15 = r20
            r10.a(r11, r12, r13, r14, r15)
            java.lang.Class<net.one97.paytm.recharge.ordersummary.h.b> r3 = net.one97.paytm.recharge.ordersummary.h.b.class
            r3.getSimpleName()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x01bb
        L_0x01b7:
            r6 = r14
            r6.aw_()
        L_0x01bb:
            int r0 = net.one97.paytm.recharge.R.id.txt_order_id
            android.view.View r9 = r1.findViewById(r0)
            boolean r0 = r9 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x01c6
            r9 = 0
        L_0x01c6:
            android.widget.TextView r9 = (android.widget.TextView) r9
            boolean r0 = r1.f63091i
            if (r0 != 0) goto L_0x01d0
            boolean r0 = r1.f63090h
            if (r0 == 0) goto L_0x0226
        L_0x01d0:
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01de
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01dc
            goto L_0x01de
        L_0x01dc:
            r0 = 0
            goto L_0x01df
        L_0x01de:
            r0 = 1
        L_0x01df:
            if (r0 != 0) goto L_0x0226
            if (r9 == 0) goto L_0x01e6
            r9.setVisibility(r2)
        L_0x01e6:
            android.content.Context r0 = r22.getContext()
            int r3 = net.one97.paytm.recharge.R.string.recharge_details_orderid
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r4[r2] = r5
            java.lang.String r0 = r0.getString(r3, r4)
            java.lang.String r3 = "context.getString(R.stri…details_orderid, orderId)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.text.SpannableString r3 = new android.text.SpannableString
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.<init>(r4)
            android.text.style.ForegroundColorSpan r6 = new android.text.style.ForegroundColorSpan
            android.content.Context r8 = r22.getContext()
            int r10 = net.one97.paytm.recharge.R.color.color_222222
            int r8 = androidx.core.content.b.c(r8, r10)
            r6.<init>(r8)
            r8 = 6
            int r4 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String) r5, (int) r2, (boolean) r2, (int) r8)
            int r0 = r0.length()
            r5 = 33
            r3.setSpan(r6, r4, r0, r5)
            if (r9 == 0) goto L_0x022b
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r9.setText(r3)
            goto L_0x022b
        L_0x0226:
            if (r9 == 0) goto L_0x022b
            r9.setVisibility(r7)
        L_0x022b:
            boolean r0 = r1.f63083a
            if (r0 == 0) goto L_0x0230
            goto L_0x0232
        L_0x0230:
            r2 = 8
        L_0x0232:
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.ordersummary.widget.CJRBaseRechargeOrderPaymentDetailsView.<init>(android.content.Context, net.one97.paytm.recharge.ordersummary.b.a, net.one97.paytm.common.entity.shopping.CJROrderedCart, boolean, boolean):void");
    }

    public final boolean getShowOnlyOrderId() {
        return this.f63091i;
    }

    public final boolean getShowOperatorReferenceAndOrderId() {
        return this.f63090h;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargeOrderPaymentDetailsView(Context context, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart) {
        this(context, aVar, cJROrderedCart, false, false);
        k.c(context, "context");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedCart");
    }

    /* access modifiers changed from: protected */
    public final TextView getTitleWithBackground() {
        return this.f63084b;
    }

    /* access modifiers changed from: protected */
    public final void setTitleWithBackground(TextView textView) {
        this.f63084b = textView;
    }

    /* access modifiers changed from: protected */
    public final TextView getTitle() {
        return this.f63085c;
    }

    /* access modifiers changed from: protected */
    public final void setTitle(TextView textView) {
        this.f63085c = textView;
    }

    /* access modifiers changed from: protected */
    public final View getDividerView() {
        return this.f63086d;
    }

    /* access modifiers changed from: protected */
    public final void setDividerView(View view) {
        this.f63086d = view;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.content_base_recharge_order_payment_details;
    }

    /* access modifiers changed from: protected */
    public void a() {
        setBackgroundColor(-1);
        this.f63085c = (TextView) findViewById(R.id.heading_without_background);
        this.f63084b = (TextView) findViewById(R.id.heading_with_background);
        this.f63086d = findViewById(R.id.divider_view);
        TextView textView = this.f63084b;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f63085c;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public int getAdapterLayout() {
        return R.layout.content_recharge_order_payment_detail_item;
    }

    private final void c() {
        List<CJROrderSummaryPayment> v = this.f63087e.v();
        if (!v.isEmpty()) {
            this.f63083a = true;
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            k.a((Object) recyclerView, "rvPaymentDetails");
            recyclerView.setVisibility(0);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new b(this, v));
            RecyclerView.h itemDecorator = getItemDecorator();
            if (itemDecorator != null) {
                recyclerView.addItemDecoration(itemDecorator);
            }
        }
    }

    public static final class b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargeOrderPaymentDetailsView f63097a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f63098b;

        b(CJRBaseRechargeOrderPaymentDetailsView cJRBaseRechargeOrderPaymentDetailsView, List list) {
            this.f63097a = cJRBaseRechargeOrderPaymentDetailsView;
            this.f63098b = list;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            a aVar = (a) vVar;
            k.c(aVar, "holder");
            this.f63097a.a(aVar, (CJROrderSummaryPayment) this.f63098b.get(i2), i2);
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            return this.f63097a.a(viewGroup);
        }

        public final int getItemCount() {
            return this.f63098b.size();
        }
    }

    /* access modifiers changed from: protected */
    public RecyclerView.h getItemDecorator() {
        Drawable a2 = androidx.core.content.b.a(getContext(), R.drawable.divider);
        if (a2 != null) {
            a2.setColorFilter(androidx.core.content.b.c(getContext(), R.color.color_f3f7f8), PorterDuff.Mode.SRC_IN);
        }
        return new g(a2, true);
    }

    /* access modifiers changed from: protected */
    public final a a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(getContext()).inflate(getAdapterLayout(), viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…rLayout(), parent, false)");
        return new a(this, inflate);
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        k.c(aVar, "holder");
        aVar.itemView.setPadding(com.paytm.utility.b.c(20), com.paytm.utility.b.c(15), com.paytm.utility.b.c(20), 0);
    }

    /* access modifiers changed from: protected */
    public String a(Context context, CJROrderSummaryPayment cJROrderSummaryPayment) {
        k.c(context, "context");
        k.c(cJROrderSummaryPayment, "payMode");
        String string = context.getString(R.string.price_container_re, new Object[]{com.paytm.utility.b.a(cJROrderSummaryPayment.getPgAmount())});
        k.a((Object) string, "context.getString(R.stri…Number(payMode.pgAmount))");
        return string;
    }

    private final void d() {
        String str;
        String str2;
        CJRAttributes attributes;
        String str3;
        CJRAttributes attributes2;
        CJRAttributes attributes3;
        if (getContext() != null) {
            View findViewById = findViewById(R.id.txt_operator_reference_id);
            String str4 = null;
            if (!(findViewById instanceof TextView)) {
                findViewById = null;
            }
            TextView textView = (TextView) findViewById;
            CJRFullFillmentObject fullFillmentOject = this.f63088f.getFullFillmentOject();
            JSONObject fullFillment = fullFillmentOject != null ? fullFillmentOject.getFullFillment() : null;
            String string = (!(fullFillment != null ? fullFillment.has(StringSet.operator) : false) || fullFillment == null) ? null : fullFillment.getString(StringSet.operator);
            String string2 = (!(fullFillment != null ? fullFillment.has("opt_ref_id") : false) || fullFillment == null) ? null : fullFillment.getString("opt_ref_id");
            if (fullFillment != null ? fullFillment.has("operatorRefNumber") : false) {
                if (fullFillment != null) {
                    str4 = fullFillment.getString("operatorRefNumber");
                }
                string2 = str4;
            }
            CJROrderSummaryProductDetail productDetail = this.f63088f.getProductDetail();
            if (productDetail == null || (attributes3 = productDetail.getAttributes()) == null || (str = attributes3.getOperatorDisplayLabel()) == null) {
                str = string;
            }
            CharSequence charSequence = string2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView != null) {
                    Context context = getContext();
                    int i2 = R.string.recharge_details_operator_contact_referenceid;
                    Object[] objArr = new Object[3];
                    CJROrderSummaryProductDetail productDetail2 = this.f63088f.getProductDetail();
                    if (productDetail2 == null || (attributes2 = productDetail2.getAttributes()) == null || (str3 = attributes2.getPayTypeDisplayLabel()) == null) {
                        str3 = "";
                    }
                    objArr[0] = str3;
                    if (str == null) {
                        str = "";
                    }
                    objArr[1] = str;
                    objArr[2] = string2;
                    textView.setText(context.getString(i2, objArr));
                    return;
                }
                return;
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                Context context2 = getContext();
                int i3 = R.string.recharge_details_operator_contact_customer_care;
                Object[] objArr2 = new Object[2];
                CJROrderSummaryProductDetail productDetail3 = this.f63088f.getProductDetail();
                if (productDetail3 == null || (attributes = productDetail3.getAttributes()) == null || (str2 = attributes.getPayTypeDisplayLabel()) == null) {
                    str2 = "";
                }
                objArr2[0] = str2;
                if (str == null) {
                    str = "";
                }
                objArr2[1] = str;
                textView.setText(context2.getString(i3, objArr2));
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
        if (iJRPaytmDataModel instanceof CJROSActionResponseV2) {
            String message = ((CJROSActionResponseV2) iJRPaytmDataModel).getMessage();
            if (getContext() != null) {
                CharSequence charSequence = message;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    View findViewById = findViewById(R.id.txt_operator_reference_id);
                    if (!(findViewById instanceof TextView)) {
                        findViewById = null;
                    }
                    TextView textView = (TextView) findViewById;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    if (textView != null) {
                        textView.setText(charSequence);
                        return;
                    }
                    return;
                }
                d();
            }
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        k.c(networkCustomError, "error");
        d();
    }

    public final void aw_() {
        d();
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63092a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f63093b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f63094c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargeOrderPaymentDetailsView f63095d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f63096e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CJRBaseRechargeOrderPaymentDetailsView cJRBaseRechargeOrderPaymentDetailsView, View view) {
            super(view);
            k.c(view, "itemView");
            this.f63095d = cJRBaseRechargeOrderPaymentDetailsView;
            View findViewById = view.findViewById(R.id.title);
            if (findViewById != null) {
                this.f63092a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.transaction_id);
                if (findViewById2 != null) {
                    this.f63093b = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.card_number);
                    if (findViewById3 != null) {
                        this.f63096e = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.amount);
                        if (findViewById4 != null) {
                            this.f63094c = (TextView) findViewById4;
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, CJROrderSummaryPayment cJROrderSummaryPayment, int i2) {
        k.c(aVar, "holder");
        k.c(cJROrderSummaryPayment, "payMode");
        TextView textView = aVar.f63092a;
        net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63087e;
        String paymentBank = cJROrderSummaryPayment.getPaymentBank();
        String paymentMethod = cJROrderSummaryPayment.getPaymentMethod();
        k.a((Object) paymentMethod, "payMode.paymentMethod");
        textView.setText(aVar2.a(paymentBank, paymentMethod, getContext()));
        CharSequence bankTransactionId = cJROrderSummaryPayment.getBankTransactionId();
        if (!(bankTransactionId == null || bankTransactionId.length() == 0)) {
            aVar.f63093b.setVisibility(0);
            aVar.f63093b.setText(getContext().getString(R.string.colon_place_holder, new Object[]{getContext().getString(R.string.transaction_id), cJROrderSummaryPayment.getBankTransactionId()}));
        } else {
            aVar.f63093b.setVisibility(8);
            a(aVar);
        }
        TextView textView2 = aVar.f63094c;
        View view = aVar.itemView;
        k.a((Object) view, "holder.itemView");
        Context context = view.getContext();
        k.a((Object) context, "holder.itemView.context");
        textView2.setText(a(context, cJROrderSummaryPayment));
    }
}
