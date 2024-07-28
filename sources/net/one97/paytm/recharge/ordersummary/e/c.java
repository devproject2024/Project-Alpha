package net.one97.paytm.recharge.ordersummary.e;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;

public class c extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final ImageView f64273a;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f64274b;

    /* renamed from: c  reason: collision with root package name */
    final TextView f64275c;

    /* renamed from: d  reason: collision with root package name */
    final TextView f64276d;

    /* renamed from: e  reason: collision with root package name */
    final TextView f64277e;

    /* renamed from: f  reason: collision with root package name */
    final LinearLayout f64278f;

    /* renamed from: g  reason: collision with root package name */
    final View f64279g;

    /* renamed from: h  reason: collision with root package name */
    final net.one97.paytm.recharge.ordersummary.b.a f64280h;

    /* renamed from: i  reason: collision with root package name */
    final CJROrderedCart f64281i;
    final CJROSActionResponseV2 j;
    final io.reactivex.rxjava3.j.c<Object[]> k;
    final net.one97.paytm.recharge.ordersummary.f.b l;
    private final String m = "money.deducted";
    private final View n;
    private final boolean o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2, boolean z, io.reactivex.rxjava3.j.c<Object[]> cVar, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        super(view);
        k.c(view, "itemView");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        k.c(cVar, "titleTextObservable");
        k.c(bVar, "actionListener");
        this.f64280h = aVar;
        this.f64281i = cJROrderedCart;
        this.j = cJROSActionResponseV2;
        this.o = z;
        this.k = cVar;
        this.l = bVar;
        this.f64273a = (ImageView) view.findViewById(R.id.status_logo);
        this.f64274b = (ImageView) view.findViewById(R.id.status_previous);
        this.f64275c = (TextView) view.findViewById(R.id.title);
        this.f64276d = (TextView) view.findViewById(R.id.subtitle);
        this.f64277e = (TextView) view.findViewById(R.id.status_time);
        this.f64278f = (LinearLayout) view.findViewById(R.id.lytActions);
        this.f64279g = view.findViewById(R.id.separator);
        this.n = view.findViewById(R.id.separator_top);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r26) {
        /*
            r25 = this;
            r0 = r25
            android.widget.LinearLayout r1 = r0.f64278f
            if (r1 == 0) goto L_0x000b
            r1.removeAllViews()
            kotlin.x r1 = kotlin.x.f47997a
        L_0x000b:
            java.lang.String r1 = "statusPrevious"
            r2 = 8
            java.lang.String r3 = "statusLogo"
            java.lang.String r4 = "separator"
            r5 = 0
            java.lang.String r6 = "separatorTop"
            r7 = 2
            java.lang.String r8 = "lytActions"
            java.lang.String r9 = "title"
            r10 = 1
            java.lang.String r11 = "subtitle"
            java.lang.String r12 = "statusTime"
            java.lang.String r13 = "itemView.context"
            r14 = 0
            java.lang.String r15 = "itemView"
            switch(r26) {
                case 0: goto L_0x0765;
                case 1: goto L_0x068f;
                case 2: goto L_0x0514;
                case 3: goto L_0x039f;
                case 4: goto L_0x02b4;
                case 5: goto L_0x0178;
                case 6: goto L_0x0028;
                case 7: goto L_0x006b;
                case 8: goto L_0x002a;
                case 9: goto L_0x039f;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0827
        L_0x002a:
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_pending_type3
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r0.f64281i
            java.lang.String r2 = r2.j(r3, r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.widget.TextView r1 = r0.f64275c
            int r2 = net.one97.paytm.recharge.R.style.OSPreviousStatusTitle
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r2)
            android.widget.TextView r1 = r0.f64275c
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            int r3 = net.one97.paytm.recharge.R.color.recharge_next_order
            int r2 = androidx.core.content.b.c(r2, r3)
            r1.setTextColor(r2)
            return
        L_0x006b:
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_pending_type3
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.a((android.content.Context) r3, (boolean) r14)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r4 = r0.j
            java.lang.String r1 = r1.a((android.content.Context) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3, (net.one97.paytm.recharge.model.CJROSActionResponseV2) r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00bc
            android.widget.TextView r2 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r1.setVisibility(r14)
        L_0x00bc:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            if (r2 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            boolean r1 = r1.n(r2, r3)
            if (r1 == 0) goto L_0x0827
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r0.j
            if (r1 == 0) goto L_0x0119
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
            if (r1 == 0) goto L_0x0119
            java.util.List r1 = r1.getActions()
            if (r1 == 0) goto L_0x0119
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x00ea:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0115
            java.lang.Object r2 = r1.next()
            r3 = r2
            net.one97.paytm.recharge.model.CJROSActionItemV2 r3 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r3
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r4 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r4 = r4.getACTION_TYPE_IMPS_REFUND()
            java.lang.String r6 = r3.getmType()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r6, (boolean) r10)
            if (r4 == 0) goto L_0x0111
            net.one97.paytm.recharge.ordersummary.b.a r4 = r0.f64280h
            boolean r3 = r4.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r3, (int) r10, false)
            if (r3 == 0) goto L_0x0111
            r3 = 1
            goto L_0x0112
        L_0x0111:
            r3 = 0
        L_0x0112:
            if (r3 == 0) goto L_0x00ea
            goto L_0x0116
        L_0x0115:
            r2 = r5
        L_0x0116:
            r5 = r2
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
        L_0x0119:
            if (r5 == 0) goto L_0x0827
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            int r2 = net.one97.paytm.recharge.R.style.OSStatusActionTextMerchantIMPS
            java.lang.String r3 = r5.getLabel()
            java.lang.String r4 = "impsAction.label"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.widget.TextView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r1, r2, r3)
            kotlin.o r2 = new kotlin.o
            java.lang.String r3 = r5.getmType()
            r2.<init>(r3, r5)
            r1.setTag(r2)
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            if (r2 == 0) goto L_0x0170
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            r3 = 16
            int r3 = com.paytm.utility.b.c((int) r3)
            r2.topMargin = r3
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r1.setLayoutParams(r2)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
            android.widget.LinearLayout r1 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r1.setVisibility(r14)
            goto L_0x0827
        L_0x0170:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
            r1.<init>(r2)
            throw r1
        L_0x0178:
            java.lang.Object[] r5 = new java.lang.Object[r7]
            net.one97.paytm.recharge.ordersummary.b.a r7 = r0.f64280h
            android.view.View r11 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r15)
            android.content.Context r11 = r11.getContext()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)
            java.lang.String r7 = r7.p(r11)
            r5[r14] = r7
            int r7 = net.one97.paytm.recharge.R.color.recharge_order_cancelled
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r10] = r7
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r7 = r0.k
            r7.onNext(r5)
            android.widget.ImageView r5 = r0.f64273a
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            r5.setVisibility(r2)
            android.view.View r2 = r0.n
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r2.setVisibility(r14)
            android.widget.ImageView r2 = r0.f64274b
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setVisibility(r14)
            android.widget.ImageView r1 = r0.f64274b
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_previous_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.s(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.widget.TextView r1 = r0.f64275c
            int r2 = net.one97.paytm.recharge.R.style.OSPreviousStatusTitle
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            java.lang.String r1 = r1.i(r2, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0209
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x0209:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r1.f63998b
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            boolean r1 = r1.a((com.paytm.network.model.IJRPaytmDataModel) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            if (r1 == 0) goto L_0x0258
            android.view.View r1 = r0.f64279g
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.n
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.f64279g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r14)
            android.view.View r1 = r0.n
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r14)
            goto L_0x0278
        L_0x0258:
            android.view.View r1 = r0.n
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r4 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r4)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.n
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r14)
        L_0x0278:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            r17 = 1
            r18 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            net.one97.paytm.recharge.ordersummary.b.a r3 = r0.f64280h
            net.one97.paytm.recharge.ordersummary.f.b r4 = r0.l
            r22 = 0
            r23 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r16 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r1 == 0) goto L_0x0827
            android.widget.LinearLayout r2 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r2.setVisibility(r14)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
            return
        L_0x02b4:
            java.lang.Object[] r1 = new java.lang.Object[r7]
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.r(r3)
            r1[r14] = r2
            int r2 = net.one97.paytm.recharge.R.color.recharge_order_pending
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r10] = r2
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r2 = r0.k
            r2.onNext(r1)
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_pending_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.u(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r4 = r0.j
            java.lang.String r1 = r1.b(r2, r3, r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0328
            android.widget.TextView r2 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r1.setVisibility(r14)
        L_0x0328:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            java.lang.String r1 = r1.i(r2, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0354
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x0354:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            r17 = 1
            r18 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            net.one97.paytm.recharge.ordersummary.b.a r3 = r0.f64280h
            net.one97.paytm.recharge.ordersummary.f.b r4 = r0.l
            r22 = 0
            r23 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r16 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r1 == 0) goto L_0x038f
            android.widget.LinearLayout r2 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r2.setVisibility(r14)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
        L_0x038f:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            boolean r1 = r1.s
            if (r1 != 0) goto L_0x0399
            boolean r1 = r0.o
            if (r1 == 0) goto L_0x0827
        L_0x0399:
            net.one97.paytm.recharge.ordersummary.f.b r1 = r0.l
            r1.b((net.one97.paytm.recharge.ordersummary.f.l) r5)
            return
        L_0x039f:
            java.lang.Object[] r5 = new java.lang.Object[r7]
            net.one97.paytm.recharge.ordersummary.b.a r7 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r2 = r7.q(r2)
            r5[r14] = r2
            int r2 = net.one97.paytm.recharge.R.color.recharge_order_failed
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5[r10] = r2
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r2 = r0.k
            r2.onNext(r5)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r2.f63998b
            com.paytm.network.model.IJRPaytmDataModel r5 = (com.paytm.network.model.IJRPaytmDataModel) r5
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = r0.f64281i
            boolean r2 = r2.a((com.paytm.network.model.IJRPaytmDataModel) r5, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r7)
            if (r2 != 0) goto L_0x03e3
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = r0.f64281i
            boolean r2 = r2.d((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)
            if (r2 == 0) goto L_0x03db
            goto L_0x03e3
        L_0x03db:
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_failed_type2
            r1.setImageResource(r2)
            goto L_0x040a
        L_0x03e3:
            android.widget.ImageView r2 = r0.f64273a
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 8
            r2.setVisibility(r3)
            android.widget.ImageView r2 = r0.f64274b
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setVisibility(r14)
            android.widget.ImageView r1 = r0.f64274b
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_previous_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            int r2 = net.one97.paytm.recharge.R.style.OSPreviousStatusTitle
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r2)
            android.widget.TextView r1 = r0.f64276d
            int r2 = net.one97.paytm.recharge.R.style.OSPreviousStatusSubTitle
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r2)
        L_0x040a:
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.t(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r5 = r0.j
            java.lang.String r1 = r1.b(r2, r3, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0454
            android.widget.TextView r2 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r1.setVisibility(r14)
        L_0x0454:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            java.lang.String r1 = r1.i(r2, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0480
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x0480:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            r17 = 1
            r18 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            net.one97.paytm.recharge.ordersummary.b.a r3 = r0.f64280h
            net.one97.paytm.recharge.ordersummary.f.b r5 = r0.l
            r22 = 0
            r23 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r16 = r1
            r19 = r2
            r20 = r3
            r21 = r5
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r1 == 0) goto L_0x04bb
            android.widget.LinearLayout r2 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r2.setVisibility(r14)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
        L_0x04bb:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r1.f63998b
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r0.f64281i
            boolean r1 = r1.a((com.paytm.network.model.IJRPaytmDataModel) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            if (r1 != 0) goto L_0x04d3
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            boolean r1 = r1.d((net.one97.paytm.common.entity.shopping.CJROrderedCart) r2)
            if (r1 == 0) goto L_0x0827
        L_0x04d3:
            android.view.View r1 = r0.f64279g
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.n
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.f64279g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r14)
            android.view.View r1 = r0.n
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r14)
            return
        L_0x0514:
            java.lang.Object[] r1 = new java.lang.Object[r7]
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.x(r3)
            r1[r14] = r2
            int r2 = net.one97.paytm.recharge.R.color.recharge_order_pending
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r10] = r2
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r2 = r0.k
            r2.onNext(r1)
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_pending_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.y(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r1 = r1.A(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0584
            android.widget.TextView r2 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r1.setVisibility(r14)
        L_0x0584:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r1 = r1.B(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x05ae
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x05ae:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            r17 = 1
            r18 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            net.one97.paytm.recharge.ordersummary.b.a r3 = r0.f64280h
            net.one97.paytm.recharge.ordersummary.f.b r7 = r0.l
            r22 = 0
            r23 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r16 = r1
            r19 = r2
            r20 = r3
            r21 = r7
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r1 == 0) goto L_0x05ea
            android.widget.LinearLayout r2 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r2.setVisibility(r14)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
            goto L_0x0646
        L_0x05ea:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            int r2 = net.one97.paytm.recharge.R.style.OSStatusActionTextBGGrayBorder
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r7 = net.one97.paytm.recharge.R.string.v8_os_action_money_deducted
            java.lang.String r3 = r3.getString(r7)
            java.lang.String r7 = "itemView.context.getStri…os_action_money_deducted)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
            android.widget.TextView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r1, r2, r3)
            kotlin.o r2 = new kotlin.o
            java.lang.String r3 = r0.m
            r2.<init>(r3, r5)
            r1.setTag(r2)
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            if (r2 == 0) goto L_0x0687
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            r3 = 16
            int r3 = com.paytm.utility.b.c((int) r3)
            r2.topMargin = r3
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r1.setLayoutParams(r2)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
            android.widget.LinearLayout r1 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r1.setVisibility(r14)
        L_0x0646:
            android.view.View r1 = r0.f64279g
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_pending_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.n
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_pending_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            android.view.View r1 = r0.f64279g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r14)
            android.view.View r1 = r0.n
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            r1.setVisibility(r14)
            return
        L_0x0687:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
            r1.<init>(r2)
            throw r1
        L_0x068f:
            java.lang.Object[] r1 = new java.lang.Object[r7]
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.w(r3)
            r1[r14] = r2
            int r2 = net.one97.paytm.recharge.R.color.recharge_order_failed
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r10] = r2
            io.reactivex.rxjava3.j.c<java.lang.Object[]> r2 = r0.k
            r2.onNext(r1)
            android.widget.ImageView r1 = r0.f64273a
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_failed_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.lang.String r2 = r2.v(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r1 = r1.A(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x06ff
            android.widget.TextView r2 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64276d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r1.setVisibility(r14)
        L_0x06ff:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r1 = r1.B(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0729
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x0729:
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.view.View r1 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)
            android.content.Context r1 = r1.getContext()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            r17 = 1
            r18 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            net.one97.paytm.recharge.ordersummary.b.a r3 = r0.f64280h
            net.one97.paytm.recharge.ordersummary.f.b r4 = r0.l
            r22 = 0
            r23 = 0
            r24 = 192(0xc0, float:2.69E-43)
            r16 = r1
            r19 = r2
            r20 = r3
            r21 = r4
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            if (r1 == 0) goto L_0x0827
            android.widget.LinearLayout r2 = r0.f64278f
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r2.setVisibility(r14)
            android.widget.LinearLayout r2 = r0.f64278f
            android.view.View r1 = (android.view.View) r1
            r2.addView(r1)
            return
        L_0x0765:
            android.widget.ImageView r2 = r0.f64273a
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 8
            r2.setVisibility(r3)
            android.widget.ImageView r2 = r0.f64274b
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setVisibility(r14)
            android.widget.ImageView r1 = r0.f64274b
            int r2 = net.one97.paytm.recharge.R.drawable.ic_os_status_previous_type2
            r1.setImageResource(r2)
            android.widget.TextView r1 = r0.f64275c
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f64280h
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            android.text.SpannableString r2 = r2.z(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            android.widget.TextView r1 = r0.f64275c
            int r2 = net.one97.paytm.recharge.R.style.OSPreviousStatusTitle
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r2)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            android.view.View r2 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            android.content.Context r2 = r2.getContext()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r13)
            java.lang.String r1 = r1.B(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x07cb
            android.widget.TextView r2 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            r2.setText(r1)
            android.widget.TextView r1 = r0.f64277e
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r12)
            r1.setVisibility(r14)
        L_0x07cb:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64280h
            if (r1 == 0) goto L_0x07d9
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r0.f64281i
            boolean r1 = r1.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r2)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
        L_0x07d9:
            boolean r1 = r5.booleanValue()
            if (r1 != 0) goto L_0x0807
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r0.f64281i
            java.lang.String r1 = r1.getItemStatus()
            java.lang.String r2 = "7"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            r1 = r1 ^ r10
            if (r1 == 0) goto L_0x0807
            android.view.View r1 = r0.f64279g
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_pending_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
            goto L_0x081f
        L_0x0807:
            android.view.View r1 = r0.f64279g
            androidx.appcompat.widget.f r2 = androidx.appcompat.widget.f.b()
            android.view.View r3 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r15)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.drawable.shape_os_success_line
            android.graphics.drawable.Drawable r2 = r2.a((android.content.Context) r3, (int) r5)
            androidx.core.h.u.a((android.view.View) r1, (android.graphics.drawable.Drawable) r2)
        L_0x081f:
            android.view.View r1 = r0.f64279g
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r14)
        L_0x0827:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.e.c.a(int):void");
    }

    public void onClick(View view) {
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof o) {
            o oVar = (o) tag;
            if (k.a(oVar.getFirst(), (Object) this.m)) {
                this.l.a((DialogInterface.OnClickListener) new a(this));
            } else if (k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_IMPS_REFUND())) {
                view.setEnabled(false);
                view.setClickable(false);
                net.one97.paytm.recharge.ordersummary.f.b bVar = this.l;
                Object second = oVar.getSecond();
                if (second != null) {
                    bVar.a((DialogInterface) null, (CJROrderSummaryAction) (CJROSActionItemV2) second, (DialogInterface.OnDismissListener) new b(view));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
            }
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64282a;

        a(c cVar) {
            this.f64282a = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                this.f64282a.l.f(this.f64282a.f64281i);
            }
        }
    }

    static final class b implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f64283a;

        b(View view) {
            this.f64283a = view;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f64283a.setEnabled(true);
            this.f64283a.setClickable(true);
        }
    }
}
