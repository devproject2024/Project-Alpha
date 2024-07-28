package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.d;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.j.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.ordersummary.f.o;

public class CJRRechargeItemActionsListView extends RecyclerView implements View.OnClickListener, o {

    /* renamed from: e  reason: collision with root package name */
    public static final b f64530e = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<CJROSActionItemV2> f64531a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, View> f64532b;

    /* renamed from: c  reason: collision with root package name */
    final net.one97.paytm.recharge.ordersummary.b.a f64533c;

    /* renamed from: d  reason: collision with root package name */
    final List<CJROSActionItemV2> f64534d;

    /* renamed from: f  reason: collision with root package name */
    private final c<String> f64535f;

    /* renamed from: g  reason: collision with root package name */
    private final c<String> f64536g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f64537h;

    /* renamed from: i  reason: collision with root package name */
    private final int f64538i;
    private final CJROrderedCart j;
    private final net.one97.paytm.recharge.ordersummary.f.b k;
    private final boolean l;

    public final int getPositionType() {
        return this.f64538i;
    }

    public final CJROrderedCart getOrderedItem() {
        return this.j;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64533c;
    }

    public final List<CJROSActionItemV2> getItemLevelActions() {
        return this.f64534d;
    }

    public final net.one97.paytm.recharge.ordersummary.f.b getActionsListener() {
        return this.k;
    }

    public /* synthetic */ CJRRechargeItemActionsListView(Context context, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, List list, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        this(context, 3, cJROrderedCart, aVar, list, bVar, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0038, code lost:
        r3 = r3.getSharedElementMap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRRechargeItemActionsListView(android.content.Context r2, int r3, net.one97.paytm.common.entity.shopping.CJROrderedCart r4, net.one97.paytm.recharge.ordersummary.b.a r5, java.util.List<net.one97.paytm.recharge.model.CJROSActionItemV2> r6, net.one97.paytm.recharge.ordersummary.f.b r7, boolean r8) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "orderedItem"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "viewModel"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "itemLevelActions"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "actionsListener"
            kotlin.g.b.k.c(r7, r0)
            r1.<init>(r2)
            r1.f64538i = r3
            r1.j = r4
            r1.f64533c = r5
            r1.f64534d = r6
            r1.k = r7
            r1.l = r8
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1.f64531a = r3
            net.one97.paytm.recharge.ordersummary.f.b r3 = r1.k
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r3 = r3.getOrderActionClickListener()
            r4 = 2
            if (r3 == 0) goto L_0x003e
            java.util.Map r3 = r3.getSharedElementMap()
            if (r3 != 0) goto L_0x0045
        L_0x003e:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>(r4)
            java.util.Map r3 = (java.util.Map) r3
        L_0x0045:
            r1.f64532b = r3
            io.reactivex.rxjava3.j.c r3 = io.reactivex.rxjava3.j.c.a()
            java.lang.String r5 = "ReplaySubject.create()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            r1.f64535f = r3
            io.reactivex.rxjava3.j.c r3 = io.reactivex.rxjava3.j.c.a()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            r1.f64536g = r3
            r3 = 1
            r1.f64537h = r3
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r5 = -2
            r3.<init>(r5, r5)
            r1.setLayoutParams(r3)
            r1.setOverScrollMode(r4)
            r3 = 0
            r1.setNestedScrollingEnabled(r3)
            java.util.List<net.one97.paytm.recharge.model.CJROSActionItemV2> r4 = r1.f64534d
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0076:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00ab
            java.lang.Object r5 = r4.next()
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
            boolean r6 = r5.isEnabled()
            if (r6 == 0) goto L_0x0076
            net.one97.paytm.recharge.ordersummary.f.b r6 = r1.k
            java.lang.String r7 = r5.getmType()
            java.lang.String r8 = "it.getmType()"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            io.reactivex.rxjava3.j.c<java.lang.String> r8 = r1.f64535f
            io.reactivex.rxjava3.j.e r8 = (io.reactivex.rxjava3.j.e) r8
            io.reactivex.rxjava3.j.c<java.lang.String> r0 = r1.f64536g
            io.reactivex.rxjava3.j.e r0 = (io.reactivex.rxjava3.j.e) r0
            boolean r6 = r6.a((java.lang.String) r7, (io.reactivex.rxjava3.j.e<java.lang.String>) r8, (io.reactivex.rxjava3.j.e<java.lang.String>) r0)
            if (r6 != 0) goto L_0x00a5
            r5.setEnabled(r3)
            goto L_0x0076
        L_0x00a5:
            java.util.ArrayList<net.one97.paytm.recharge.model.CJROSActionItemV2> r6 = r1.f64531a
            r6.add(r5)
            goto L_0x0076
        L_0x00ab:
            androidx.recyclerview.widget.LinearLayoutManager r4 = new androidx.recyclerview.widget.LinearLayoutManager
            boolean r5 = r1.l
            r4.<init>(r2, r5, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r4
            r1.setLayoutManager(r4)
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$1 r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$1
            r2.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$a r2 = (androidx.recyclerview.widget.RecyclerView.a) r2
            r1.setAdapter(r2)
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$2 r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$2
            r2.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$h r2 = (androidx.recyclerview.widget.RecyclerView.h) r2
            r1.addItemDecoration(r2)
            io.reactivex.rxjava3.j.c<java.lang.String> r2 = r1.f64535f
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$3 r3 = new net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$3
            r3.<init>(r1)
            io.reactivex.rxjava3.d.g r3 = (io.reactivex.rxjava3.d.g) r3
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$4 r4 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.AnonymousClass4.f64542a
            io.reactivex.rxjava3.d.g r4 = (io.reactivex.rxjava3.d.g) r4
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$5 r5 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.AnonymousClass5.f64543a
            io.reactivex.rxjava3.d.a r5 = (io.reactivex.rxjava3.d.a) r5
            r2.subscribe(r3, r4, r5)
            io.reactivex.rxjava3.j.c<java.lang.String> r2 = r1.f64536g
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$6 r3 = new net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$6
            r3.<init>(r1)
            io.reactivex.rxjava3.d.g r3 = (io.reactivex.rxjava3.d.g) r3
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$7 r4 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.AnonymousClass7.f64545a
            io.reactivex.rxjava3.d.g r4 = (io.reactivex.rxjava3.d.g) r4
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$8 r5 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.AnonymousClass8.f64546a
            io.reactivex.rxjava3.d.a r5 = (io.reactivex.rxjava3.d.a) r5
            r2.subscribe(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.<init>(android.content.Context, int, net.one97.paytm.common.entity.shopping.CJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a, java.util.List, net.one97.paytm.recharge.ordersummary.f.b, boolean):void");
    }

    public final c<String> getEnableActionObservable() {
        return this.f64535f;
    }

    public final c<String> getDisableActionObservable() {
        return this.f64536g;
    }

    public final void setCLickable(boolean z) {
        this.f64537h = z;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static /* synthetic */ CJRRechargeItemActionsListView a(Context context, int i2, int i3, CJROrderedCart cJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a aVar, net.one97.paytm.recharge.ordersummary.f.b bVar, boolean z, boolean z2, int i4) {
            int i5 = i4;
            return a(context, i2, i3, cJROrderedCart, aVar, bVar, (i5 & 64) != 0 ? false : z, (i5 & 128) != 0 ? false : z2);
        }

        private static boolean a(CJROSActionItemV2 cJROSActionItemV2, int i2) {
            k.c(cJROSActionItemV2, "action");
            String str = cJROSActionItemV2.getmType();
            if (k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_IMPS_REFUND()) || k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PAYMENT_NOT_SHOWING())) {
                return false;
            }
            if (!k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PRO_SHARE()) || i2 != 2) {
                return true;
            }
            return false;
        }

        public static TextView a(Context context, int i2, String str) {
            TextView textView;
            k.c(context, "context");
            k.c(str, "value");
            try {
                textView = new TextView(new d(context, i2));
            } catch (Exception e2) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("Item action drawing issue with constructor : " + e2.getMessage());
                textView = new TextView(context);
                int c2 = com.paytm.utility.b.c(10);
                int c3 = com.paytm.utility.b.c(16);
                textView.setPadding(c3, c2, c3, c2);
                textView.setTextColor(androidx.core.content.b.c(context, R.color.color_os_blue));
                textView.setBackgroundResource(R.drawable.selector_os_btn_action_bg_gray);
            }
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            textView.setText(str);
            return textView;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
            if (a(r10, r0) != false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bf, code lost:
            if (a(r10, r0) != false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0033, code lost:
            r1 = r1.getItemLevelActions();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView a(android.content.Context r15, int r16, int r17, net.one97.paytm.common.entity.shopping.CJROrderedCart r18, net.one97.paytm.recharge.ordersummary.b.a r19, net.one97.paytm.recharge.ordersummary.f.b r20, boolean r21, boolean r22) {
            /*
                r0 = r16
                r4 = r19
                java.lang.String r1 = "context"
                r2 = r15
                kotlin.g.b.k.c(r15, r1)
                java.lang.String r1 = "orderedItem"
                r3 = r18
                kotlin.g.b.k.c(r3, r1)
                java.lang.String r1 = "viewModel"
                kotlin.g.b.k.c(r4, r1)
                java.lang.String r1 = "actionsListener"
                r6 = r20
                kotlin.g.b.k.c(r6, r1)
                java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r1 = r4.m
                long r7 = r18.getId()
                java.lang.Long r5 = java.lang.Long.valueOf(r7)
                java.lang.Object r1 = r1.get(r5)
                net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r1
                r5 = 0
                if (r22 == 0) goto L_0x0047
                if (r1 == 0) goto L_0x003e
                net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
                if (r1 == 0) goto L_0x003e
                java.util.List r1 = r1.getVerticalActions()
                goto L_0x003f
            L_0x003e:
                r1 = r5
            L_0x003f:
                boolean r7 = r1 instanceof java.util.ArrayList
                if (r7 != 0) goto L_0x0044
                r1 = r5
            L_0x0044:
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                goto L_0x005c
            L_0x0047:
                if (r1 == 0) goto L_0x0054
                net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r1.getItemLevelActions()
                if (r1 == 0) goto L_0x0054
                java.util.List r1 = r1.getActions()
                goto L_0x0055
            L_0x0054:
                r1 = r5
            L_0x0055:
                boolean r7 = r1 instanceof java.util.ArrayList
                if (r7 != 0) goto L_0x005a
                r1 = r5
            L_0x005a:
                java.util.ArrayList r1 = (java.util.ArrayList) r1
            L_0x005c:
                r7 = 0
                if (r1 == 0) goto L_0x00cc
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r1 = r1.iterator()
            L_0x006c:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto L_0x00c9
                java.lang.Object r9 = r1.next()
                r10 = r9
                net.one97.paytm.recharge.model.CJROSActionItemV2 r10 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r10
                r11 = r21
                boolean r12 = r4.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r0, (boolean) r11)
                java.lang.String r13 = r10.getPayType()
                java.lang.CharSequence r13 = (java.lang.CharSequence) r13
                boolean r13 = android.text.TextUtils.isEmpty(r13)
                r14 = 1
                if (r13 == 0) goto L_0x0097
                if (r12 == 0) goto L_0x00c2
                net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r12 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
                boolean r10 = a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r0)
                if (r10 == 0) goto L_0x00c2
                goto L_0x00c3
            L_0x0097:
                if (r12 == 0) goto L_0x00c2
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r12 = r18.getProductDetail()
                java.lang.String r13 = "orderedItem.productDetail"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
                net.one97.paytm.common.entity.recharge.CJRAttributes r12 = r12.getAttributes()
                java.lang.String r13 = "orderedItem.productDetail.attributes"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
                java.lang.String r12 = r12.getPaytype()
                java.lang.String r13 = r10.getPayType()
                boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r13)
                if (r12 == 0) goto L_0x00c2
                net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r12 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
                boolean r10 = a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r0)
                if (r10 == 0) goto L_0x00c2
                goto L_0x00c3
            L_0x00c2:
                r14 = 0
            L_0x00c3:
                if (r14 == 0) goto L_0x006c
                r8.add(r9)
                goto L_0x006c
            L_0x00c9:
                java.util.List r8 = (java.util.List) r8
                goto L_0x00cd
            L_0x00cc:
                r8 = r5
            L_0x00cd:
                if (r8 == 0) goto L_0x00d3
                int r7 = r8.size()
            L_0x00d3:
                if (r7 == 0) goto L_0x00ed
                net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r9 = new net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView
                if (r8 != 0) goto L_0x00dc
                kotlin.g.b.k.a()
            L_0x00dc:
                r0 = r9
                r1 = r15
                r2 = r17
                r3 = r18
                r4 = r19
                r5 = r8
                r6 = r20
                r7 = r22
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r9
            L_0x00ed:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(android.content.Context, int, int, net.one97.paytm.common.entity.shopping.CJROrderedCart, net.one97.paytm.recharge.ordersummary.b.a, net.one97.paytm.recharge.ordersummary.f.b, boolean, boolean):net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView");
        }
    }

    public final int getItemCount() {
        return this.f64531a.size();
    }

    public static void a(Rect rect) {
        if (rect != null) {
            rect.set(0, com.paytm.utility.b.c(16), com.paytm.utility.b.c(16), 0);
        }
    }

    public Map<String, View> getSharedElementMap() {
        return this.f64532b;
    }

    public void onClick(View view) {
        CJROrderActionsListView orderActionClickListener = this.k.getOrderActionClickListener();
        if (orderActionClickListener != null) {
            orderActionClickListener.a(true, view);
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRechargeItemActionsListView f64547a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CJRRechargeItemActionsListView cJRRechargeItemActionsListView, TextView textView) {
            super(textView);
            k.c(textView, "itemView");
            this.f64547a = cJRRechargeItemActionsListView;
            textView.setOnClickListener(cJRRechargeItemActionsListView);
        }
    }
}
