package net.one97.paytm.recharge.metro.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.i.h;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2;
import net.one97.paytm.recharge.metro.activity.AJRActiveMetroTicketListActivity;
import net.one97.paytm.recharge.metro.c.e;
import net.one97.paytm.recharge.metro.d.g;
import net.one97.paytm.recharge.metro.d.j;
import net.one97.paytm.recharge.metro.d.l;
import net.one97.paytm.recharge.metro.d.p;
import net.one97.paytm.recharge.metro.d.q;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.ordersummary.f.i;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class b extends h implements ai, e.a, p.b, i, net.one97.paytm.recharge.ordersummary.f.p {

    /* renamed from: a  reason: collision with root package name */
    private String f63281a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJROrderedCart f63282b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f63283c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f63284d;

    /* renamed from: e  reason: collision with root package name */
    private String f63285e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f63286f;

    /* renamed from: g  reason: collision with root package name */
    private LottieAnimationView f63287g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends CJRActiveMetroTicketModel> f63288h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f63289i;
    private String j;
    private HashMap k;

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public final void aw_() {
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_active_metro_tickets, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r6v3, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r18, android.os.Bundle r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Class<net.one97.paytm.recharge.metro.c.b> r2 = net.one97.paytm.recharge.metro.c.b.class
            java.lang.String r3 = "view"
            kotlin.g.b.k.c(r0, r3)
            int r3 = net.one97.paytm.recharge.R.id.tickets
            android.view.View r3 = r0.findViewById(r3)
            if (r3 == 0) goto L_0x01b8
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            r1.f63286f = r3
            int r3 = net.one97.paytm.recharge.R.id.loading_threedots_lav
            android.view.View r3 = r0.findViewById(r3)
            if (r3 == 0) goto L_0x01b0
            com.airbnb.lottie.LottieAnimationView r3 = (com.airbnb.lottie.LottieAnimationView) r3
            r1.f63287g = r3
            int r3 = net.one97.paytm.recharge.R.id.txt_title
            android.view.View r3 = r0.findViewById(r3)
            if (r3 == 0) goto L_0x01a8
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.f63289i = r3
            android.os.Bundle r3 = r17.getArguments()
            r4 = 0
            java.lang.String r5 = "activeMetroTickets"
            r6 = 0
            if (r3 == 0) goto L_0x0173
            boolean r3 = r3.containsKey(r5)
            if (r3 != 0) goto L_0x0173
            int r3 = net.one97.paytm.recharge.R.id.progress_view
            android.view.View r0 = r0.findViewById(r3)
            androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
            if (r0 == 0) goto L_0x004d
            r0.setVisibility(r4)
        L_0x004d:
            com.airbnb.lottie.LottieAnimationView r0 = r1.f63287g
            if (r0 == 0) goto L_0x0056
            java.lang.String r3 = "Payments-Loader.json"
            r0.setAnimation((java.lang.String) r3)
        L_0x0056:
            com.airbnb.lottie.LottieAnimationView r0 = r1.f63287g
            r3 = 1
            if (r0 == 0) goto L_0x005e
            r0.loop(r3)
        L_0x005e:
            com.airbnb.lottie.LottieAnimationView r0 = r1.f63287g
            if (r0 == 0) goto L_0x0065
            r0.playAnimation()
        L_0x0065:
            android.os.Bundle r0 = r17.getArguments()
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0075
            java.lang.String r5 = "order_id"
            java.lang.String r0 = r0.getString(r5, r4)
            if (r0 != 0) goto L_0x0076
        L_0x0075:
            r0 = r4
        L_0x0076:
            r1.f63281a = r0
            android.os.Bundle r0 = r17.getArguments()
            java.lang.String r4 = "Payment"
            if (r0 == 0) goto L_0x0088
            java.lang.String r5 = "From"
            java.lang.String r0 = r0.getString(r5, r4)
            if (r0 != 0) goto L_0x0089
        L_0x0088:
            r0 = r4
        L_0x0089:
            r1.f63285e = r0
            android.os.Bundle r0 = r17.getArguments()
            if (r0 == 0) goto L_0x0098
            java.lang.String r4 = "cart_product"
            java.io.Serializable r0 = r0.getSerializable(r4)
            goto L_0x0099
        L_0x0098:
            r0 = r6
        L_0x0099:
            boolean r4 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderedCart
            if (r4 != 0) goto L_0x009e
            r0 = r6
        L_0x009e:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            r1.f63282b = r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63282b
            if (r0 == 0) goto L_0x00ab
            java.lang.String r4 = r1.f63281a
            r0.setOrderId(r4)
        L_0x00ab:
            r1.f63284d = r3
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63282b
            if (r0 == 0) goto L_0x00c3
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x00c3
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r0.getConfigTicketType()
            if (r0 != 0) goto L_0x00d9
        L_0x00c3:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63282b
            if (r0 == 0) goto L_0x00d8
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x00d8
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = r0.getTicketType()
            goto L_0x00d9
        L_0x00d8:
            r0 = r6
        L_0x00d9:
            r1.j = r0
            net.one97.paytm.recharge.metro.f.c$a r0 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r0 = net.one97.paytm.recharge.metro.f.c.f63579d
            java.lang.String r4 = r1.j
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r3)
            if (r0 == 0) goto L_0x0101
            android.widget.TextView r0 = r1.f63289i
            if (r0 == 0) goto L_0x0118
            android.content.Context r3 = r17.getContext()
            if (r3 == 0) goto L_0x00fa
            int r4 = net.one97.paytm.recharge.R.string.msg_metro_fetching_tickets
            java.lang.String r3 = r3.getString(r4)
            goto L_0x00fb
        L_0x00fa:
            r3 = r6
        L_0x00fb:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            goto L_0x0118
        L_0x0101:
            android.widget.TextView r0 = r1.f63289i
            if (r0 == 0) goto L_0x0118
            android.content.Context r3 = r17.getContext()
            if (r3 == 0) goto L_0x0112
            int r4 = net.one97.paytm.recharge.R.string.msg_metro_fetching_pass_details
            java.lang.String r3 = r3.getString(r4)
            goto L_0x0113
        L_0x0112:
            r3 = r6
        L_0x0113:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0118:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63282b
            if (r0 == 0) goto L_0x0121
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r0 = r0.getTapAction()
            goto L_0x0122
        L_0x0121:
            r0 = r6
        L_0x0122:
            if (r0 == 0) goto L_0x0130
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r1.f63282b
            if (r0 == 0) goto L_0x012c
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r6 = r0.getTapAction()
        L_0x012c:
            r1.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r6)
            return
        L_0x0130:
            java.lang.String r7 = "fetch_order_detail"
            android.content.Context r8 = r17.getContext()     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            java.lang.String r9 = r1.f63285e     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            java.lang.String r10 = r1.f63281a     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            r11 = r1
            net.one97.paytm.recharge.common.e.ai r11 = (net.one97.paytm.recharge.common.e.ai) r11     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            r12 = r1
            net.one97.paytm.recharge.ordersummary.f.p r12 = (net.one97.paytm.recharge.ordersummary.f.p) r12     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            r13 = r1
            net.one97.paytm.recharge.ordersummary.f.i r13 = (net.one97.paytm.recharge.ordersummary.f.i) r13     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            android.os.Handler r14 = new android.os.Handler     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            r14.<init>(r0)     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            r15 = 1
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r16 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            net.one97.paytm.recharge.common.utils.z.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ NullPointerException -> 0x0167, IllegalStateException -> 0x015b }
            return
        L_0x015b:
            r0 = move-exception
            r2.getSimpleName()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            return
        L_0x0167:
            r0 = move-exception
            r2.getSimpleName()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            return
        L_0x0173:
            r1.f63284d = r4
            android.os.Bundle r0 = r17.getArguments()
            if (r0 == 0) goto L_0x0182
            java.lang.String r2 = "operator"
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0183
        L_0x0182:
            r0 = r6
        L_0x0183:
            r1.j = r0
            android.os.Bundle r0 = r17.getArguments()
            if (r0 == 0) goto L_0x018f
            java.io.Serializable r6 = r0.getSerializable(r5)
        L_0x018f:
            if (r6 == 0) goto L_0x01a0
            java.util.List r6 = (java.util.List) r6
            r1.f63288h = r6
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r0 = r1.f63288h
            if (r0 != 0) goto L_0x019c
            kotlin.g.b.k.a()
        L_0x019c:
            r1.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r0)
            return
        L_0x01a0:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>"
            r0.<init>(r2)
            throw r0
        L_0x01a8:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            r0.<init>(r2)
            throw r0
        L_0x01b0:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView"
            r0.<init>(r2)
            throw r0
        L_0x01b8:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* renamed from: net.one97.paytm.recharge.metro.c.b$b  reason: collision with other inner class name */
    public static final class C1224b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = (CJRActiveMetroTicketQRItemModel) t2;
            k.a((Object) cJRActiveMetroTicketQRItemModel, "it");
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel2 = (CJRActiveMetroTicketQRItemModel) t;
            k.a((Object) cJRActiveMetroTicketQRItemModel2, "it");
            return kotlin.b.a.a(Boolean.valueOf(kotlin.m.p.a("ACTIVE", cJRActiveMetroTicketQRItemModel.getStatus(), true)), Boolean.valueOf(kotlin.m.p.a("ACTIVE", cJRActiveMetroTicketQRItemModel2.getStatus(), true)));
        }
    }

    public static final class c<T> implements Comparator<T> {
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0061, code lost:
            if (kotlin.m.p.a("ACTIVE", r7.getStatus(), true) != false) goto L_0x0065;
         */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int compare(T r7, T r8) {
            /*
                r6 = this;
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r8 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r8
                java.util.List r0 = r8.getQrCodes()
                java.lang.String r1 = "it.qrCodes"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r2 = 1
                r0 = r0 ^ r2
                java.lang.String r3 = "it.qrCodes[0]"
                java.lang.String r4 = "ACTIVE"
                r5 = 0
                if (r0 == 0) goto L_0x0033
                java.util.List r8 = r8.getQrCodes()
                java.lang.Object r8 = r8.get(r5)
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r8 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r8
                java.lang.String r8 = r8.getStatus()
                boolean r8 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r8, (boolean) r2)
                if (r8 == 0) goto L_0x0033
                r8 = 1
                goto L_0x0034
            L_0x0033:
                r8 = 0
            L_0x0034:
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
                java.lang.Comparable r8 = (java.lang.Comparable) r8
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
                java.util.List r0 = r7.getQrCodes()
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r0 = r0 ^ r2
                if (r0 == 0) goto L_0x0064
                java.util.List r7 = r7.getQrCodes()
                java.lang.Object r7 = r7.get(r5)
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
                net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r7
                java.lang.String r7 = r7.getStatus()
                boolean r7 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r7, (boolean) r2)
                if (r7 == 0) goto L_0x0064
                goto L_0x0065
            L_0x0064:
                r2 = 0
            L_0x0065:
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
                java.lang.Comparable r7 = (java.lang.Comparable) r7
                int r7 = kotlin.b.a.a(r8, r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.b.c.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    public final void onResume() {
        super.onResume();
        if (!this.f63283c) {
            a();
        }
    }

    private final void a(List<? extends CJRActiveMetroTicketModel> list) {
        RecyclerView recyclerView = this.f63286f;
        if ((recyclerView != null ? recyclerView.getAdapter() : null) instanceof a) {
            RecyclerView recyclerView2 = this.f63286f;
            if (recyclerView2 == null) {
                k.a();
            }
            RecyclerView.a adapter = recyclerView2.getAdapter();
            if (adapter != null) {
                ((a) adapter).a(new ArrayList(list));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRActiveMetroTicketsFragment.CJRTicketsAdapter");
        }
        RecyclerView recyclerView3 = this.f63286f;
        if (recyclerView3 != null) {
            recyclerView3.setNestedScrollingEnabled(false);
        }
        RecyclerView recyclerView4 = this.f63286f;
        if (recyclerView4 != null) {
            recyclerView4.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView5 = this.f63286f;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(new a(this, list));
        }
    }

    final class a extends RecyclerView.a<p> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63290a;

        /* renamed from: b  reason: collision with root package name */
        private List<? extends CJRActiveMetroTicketModel> f63291b;

        public a(b bVar, List<? extends CJRActiveMetroTicketModel> list) {
            k.c(list, "tickets");
            this.f63290a = bVar;
            this.f63291b = list;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            p pVar = (p) vVar;
            k.c(pVar, "holder");
            CJROrderedCart b2 = this.f63290a.f63282b;
            pVar.a(b2 != null ? b2.getProductDetail() : null, this.f63290a.f63284d ? this.f63291b : kotlin.a.k.a(this.f63291b.get(i2)));
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            p pVar;
            k.c(viewGroup, "parent");
            p.a aVar = p.f63520g;
            View inflate = this.f63290a.getLayoutInflater().inflate(R.layout.active_metro_ticket_item, viewGroup, false);
            k.a((Object) inflate, "layoutInflater\n         …cket_item, parent, false)");
            p.b bVar = this.f63290a;
            k.c(inflate, "itemView");
            c.d.a aVar2 = c.d.Companion;
            switch (q.f63528a[c.d.a.a(i2).ordinal()]) {
                case 1:
                    pVar = new g(inflate, bVar);
                    break;
                case 2:
                    pVar = new l(inflate, bVar);
                    break;
                case 3:
                    pVar = new j(inflate, bVar);
                    break;
                case 4:
                    pVar = new p(inflate, bVar);
                    break;
                case 5:
                    pVar = new net.one97.paytm.recharge.metro.d.k(inflate, bVar);
                    break;
                case 6:
                    pVar = new net.one97.paytm.recharge.metro.d.i(inflate, bVar);
                    break;
                default:
                    pVar = new p(inflate, bVar);
                    break;
            }
            return pVar;
        }

        public final int getItemViewType(int i2) {
            String str;
            Collection arrayList = new ArrayList();
            for (Object next : this.f63291b) {
                if (((CJRActiveMetroTicketModel) next).isPass()) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (!list.isEmpty()) {
                str = ((CJRActiveMetroTicketModel) list.get(i2)).getProductType();
            } else if (!this.f63291b.isEmpty()) {
                String subType = ((CJRActiveMetroTicketModel) this.f63291b.get(i2)).getSubType();
                str = subType == null ? ((CJRActiveMetroTicketModel) this.f63291b.get(i2)).getProductType() : subType;
            } else {
                str = null;
            }
            c.d.a aVar = c.d.Companion;
            int a2 = c.d.a.a(str);
            if (this.f63290a.f63284d) {
                return a2;
            }
            if (a2 == c.d.MUMBAI_METRO_QR.getValue()) {
                return c.d.MUMBAI_METRO_QR_TICKET.getValue();
            }
            if (a2 == c.d.MUMBAI_METRO_TP.getValue()) {
                return c.d.MUMBAI_METRO_TP_TICKET.getValue();
            }
            if (a2 == c.d.MUMBAI_METRO_SVP.getValue()) {
                return c.d.MUMBAI_METRO_SVP_TICKET.getValue();
            }
            return c.d.NONE.getValue();
        }

        public final int getItemCount() {
            if (this.f63290a.f63284d) {
                return 1;
            }
            return this.f63291b.size();
        }

        public final void a(List<? extends CJRActiveMetroTicketModel> list) {
            k.c(list, "tickets");
            List<? extends CJRActiveMetroTicketModel> list2 = this.f63291b;
            if (list2 != null) {
                ArrayList arrayList = (ArrayList) list2;
                arrayList.clear();
                arrayList.addAll(list);
                notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>");
        }
    }

    private static List<CJRActiveMetroTicketModel> b(List<? extends CJRActiveMetroTicketModel> list) {
        Iterable<CJRActiveMetroTicketModel> iterable = list;
        for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : iterable) {
            List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel.getQrCodes();
            List a2 = qrCodes != null ? kotlin.a.k.a(qrCodes, new C1224b()) : null;
            List<CJRActiveMetroTicketQRItemModel> qrCodes2 = cJRActiveMetroTicketModel.getQrCodes();
            if (!(qrCodes2 instanceof ArrayList)) {
                qrCodes2 = null;
            }
            ArrayList arrayList = (ArrayList) qrCodes2;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (arrayList != null) {
                if (a2 == null) {
                    k.a();
                }
                arrayList.addAll(a2);
            }
        }
        return new ArrayList<>(kotlin.a.k.a(iterable, new c()));
    }

    private final void a() {
        if (this.f63288h != null && getContext() != null) {
            List<? extends CJRActiveMetroTicketModel> list = this.f63288h;
            if (list == null) {
                k.a();
            }
            a(list);
        }
    }

    private final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        CJROrderSummaryActionURLParams urlParams;
        String url;
        CardView cardView;
        if (cJROrderSummaryAction != null && (urlParams = cJROrderSummaryAction.getUrlParams()) != null && (url = urlParams.getUrl()) != null) {
            if (!(url.length() == 0)) {
                this.f63283c = true;
                View view = getView();
                if (!(view == null || (cardView = (CardView) view.findViewById(R.id.progress_view)) == null)) {
                    cardView.setVisibility(0);
                }
                b.a aVar = net.one97.paytm.recharge.ordersummary.h.b.f64312h;
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                k.a((Object) context, "context!!");
                net.one97.paytm.recharge.ordersummary.h.b a2 = b.a.a(context);
                d dVar = d.f64967a;
                a2.a("tap_action", cJROrderSummaryAction, d.a(ACTION_TYPE.OS_TAP_ACTION, ERROR_TYPE.UNDEFINED), this);
                c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                net.one97.paytm.recharge.metro.f.c.l = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = r3.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.paytm.network.model.IJRPaytmDataModel r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r1 = 0
            if (r0 == 0) goto L_0x001f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r3
            java.util.ArrayList r3 = r3.getOrderedCartList()
            if (r3 == 0) goto L_0x001a
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            if (r3 == 0) goto L_0x001a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r3 = r3.getTapAction()
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x001f
            r3 = 1
            return r3
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.b.a(com.paytm.network.model.IJRPaytmDataModel):boolean");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1005 && i3 == 1006) {
            CJROrderedCart cJROrderedCart = this.f63282b;
            a(cJROrderedCart != null ? cJROrderedCart.getTapAction() : null);
        }
    }

    public final void a(View view, int i2) {
        k.c(view, "itemView");
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(getContext(), "mumbai metro qr", "view_ticket_clicked", "", "", "/utility/active-tickets", "utility");
        } catch (Throwable unused) {
        }
        Bundle bundle = new Bundle();
        List arrayList = new ArrayList();
        List<? extends CJRActiveMetroTicketModel> list = this.f63288h;
        CJRActiveMetroTicketModel cJRActiveMetroTicketModel = list != null ? (CJRActiveMetroTicketModel) list.get(i2) : null;
        if (cJRActiveMetroTicketModel == null) {
            k.a();
        }
        arrayList.add(cJRActiveMetroTicketModel);
        a(bundle, (List<? extends CJRActiveMetroTicketModel>) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r3 = (r3 = r3.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2, net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3) {
        /*
            r1 = this;
            java.lang.String r0 = "productDetail"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r2 = "pass"
            kotlin.g.b.k.c(r3, r2)
            android.content.Context r2 = r1.getContext()
            boolean r2 = r2 instanceof net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity
            if (r2 == 0) goto L_0x006c
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r1.f63282b
            if (r2 == 0) goto L_0x006c
            if (r2 == 0) goto L_0x0040
            java.util.Map r2 = r2.getRechargeConfiguration()
            if (r2 == 0) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r1.f63282b
            if (r3 == 0) goto L_0x0036
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()
            if (r3 == 0) goto L_0x0036
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()
            if (r3 == 0) goto L_0x0036
            boolean r3 = r3.isProductDisabled()
            if (r3 != 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = "is_product_rechargable"
            r2.put(r0, r3)
        L_0x0040:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r1.f63282b
            if (r2 == 0) goto L_0x0051
            java.util.Map r2 = r2.getRechargeConfiguration()
            if (r2 == 0) goto L_0x0051
            java.lang.String r3 = "is_for_order_history"
            java.lang.String r0 = "TRUE"
            r2.put(r3, r0)
        L_0x0051:
            android.content.Context r2 = r1.getContext()
            if (r2 == 0) goto L_0x0064
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r2 = (net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity) r2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = r1.f63282b
            if (r3 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            r2.a(r3, true, true)
            goto L_0x006c
        L_0x0064:
            kotlin.u r2 = new kotlin.u
            java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity"
            r2.<init>(r3)
            throw r2
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.b.a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail, net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel):void");
    }

    public final void b(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        k.c(cJROrderSummaryProductDetail, "productDetail");
        k.c(cJRActiveMetroTicketModel, "pass");
        CJRUtilityAlertV2 cJRUtilityAlertV2 = new CJRUtilityAlertV2();
        CJRAttributes attributes2 = cJROrderSummaryProductDetail.getAttributes();
        String str = null;
        cJRUtilityAlertV2.setHeading(attributes2 != null ? attributes2.getAlert_heading() : null);
        CJRAttributes attributes3 = cJROrderSummaryProductDetail.getAttributes();
        if (attributes3 != null) {
            str = attributes3.getAlert_message();
        }
        cJRUtilityAlertV2.setMessage(str);
        cJRUtilityAlertV2.setPositive_btn_txt(getString(R.string.confirm_re));
        Bundle bundle = new Bundle();
        bundle.putString(StringSet.operator, this.j);
        bundle.putSerializable("extra_home_data", cJRUtilityAlertV2);
        bundle.putSerializable("activeMetroTickets", cJRActiveMetroTicketModel);
        CJROrderedCart cJROrderedCart = this.f63282b;
        bundle.putBoolean("is_cancellable", (cJROrderedCart == null || (productDetail = cJROrderedCart.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null) ? false : attributes.isCancellable());
        if (getContext() != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            Fragment instantiate = Fragment.instantiate(context, e.class.getName(), bundle);
            if (instantiate != null) {
                e eVar = (e) instantiate;
                eVar.a((e.a) this);
                eVar.show(getChildFragmentManager(), e.class.getName());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroGenerateQrCodeDialogFragment");
        }
    }

    public final void a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List<? extends CJRActiveMetroTicketModel> list, boolean z) {
        String str;
        String str2;
        k.c(cJROrderSummaryProductDetail, "productDetail");
        k.c(list, "tickets");
        try {
            if (list.size() > 1) {
                str2 = CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED;
                str = "/utility/all-active-tickets";
            } else {
                str2 = "view_ticket_clicked";
                str = "/utility/active-tickets";
            }
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(getContext(), c(), str2, "", "", str, "utility");
        } catch (Throwable unused) {
        }
        ArrayList arrayList = (ArrayList) b(list);
        Bundle bundle = new Bundle();
        List list2 = arrayList;
        Collection arrayList2 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((CJRActiveMetroTicketModel) next).getQrCodes() != null) {
                z2 = true;
            }
            if (z2) {
                arrayList2.add(next);
            }
        }
        List list3 = (List) arrayList2;
        Object obj = list3;
        if (arrayList.size() <= 1) {
            if (list3.isEmpty()) {
                startActivity(new Intent(getContext(), AJRActiveMetroTicketListActivity.class).putExtra(StringSet.operator, this.j).putExtra("show_single_tickets", z).putExtra("activeMetroTickets", (ArrayList) b((List<? extends CJRActiveMetroTicketModel>) list2)));
                return;
            }
            Object obj2 = list3.get(0);
            obj = obj2;
            if (obj2 == null) {
                throw new u("null cannot be cast to non-null type java.io.Serializable");
            }
        }
        bundle.putSerializable("activeMetroTickets", (Serializable) obj);
        a(bundle, (List<? extends CJRActiveMetroTicketModel>) list2);
    }

    private final void a(Bundle bundle, List<? extends CJRActiveMetroTicketModel> list) {
        String str;
        String str2;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        CJROrderSummaryProductDetail productDetail2;
        CJROrderSummaryProductDetail productDetail3;
        String brandName;
        if (!net.one97.paytm.recharge.metro.f.d.INSTANCE.validateIsAlreadyClicked(this)) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            boolean z = false;
            if (arguments.getBoolean("metro_offline", false)) {
                c.d.a aVar = c.d.Companion;
                String subType = ((CJRActiveMetroTicketModel) list.get(0)).getSubType();
                if (subType == null) {
                    subType = ((CJRActiveMetroTicketModel) list.get(0)).getProductType();
                }
                String b2 = c.d.a.b(subType);
                if (b2 == null) {
                    b2 = this.j;
                }
                bundle.putString(StringSet.operator, b2);
            } else {
                String str3 = this.j;
                if (str3 == null) {
                    c.d.a aVar2 = c.d.Companion;
                    String subType2 = ((CJRActiveMetroTicketModel) list.get(0)).getSubType();
                    if (subType2 == null) {
                        subType2 = ((CJRActiveMetroTicketModel) list.get(0)).getProductType();
                    }
                    str3 = c.d.a.b(subType2);
                }
                bundle.putString(StringSet.operator, str3);
            }
            bundle.putBoolean("show_single_tickets", true);
            if (list != null) {
                bundle.putSerializable("activeMetroTickets", (ArrayList) list);
                try {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(getContext(), c(), CJRGTMConstants.MONEY_TRANSFER_EVENT_ACTION_SAVED_ACCOUNTS_VIEW_ALL_CLICKED, "", "", "/utility/active-tickets", "utility");
                } catch (Throwable unused) {
                }
                CJROrderedCart cJROrderedCart = this.f63282b;
                String str4 = null;
                if (cJROrderedCart == null || (productDetail3 = cJROrderedCart.getProductDetail()) == null || (brandName = productDetail3.getBrandName()) == null) {
                    str = null;
                } else if (brandName != null) {
                    str = brandName.toLowerCase();
                    k.a((Object) str, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = "Mumbai Metro".toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (!k.a((Object) str, (Object) lowerCase)) {
                    String lowerCase2 = "Delhi Metro".toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    if (k.a((Object) str, (Object) lowerCase2)) {
                        str2 = "DELHI_METRO";
                    } else {
                        String lowerCase3 = "Hyderabad Metro".toLowerCase();
                        k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                        if (k.a((Object) str, (Object) lowerCase3)) {
                            str2 = "HYDERABAD_METRO";
                        }
                    }
                    CJROrderedCart cJROrderedCart2 = this.f63282b;
                    if (!(cJROrderedCart2 == null || (productDetail2 = cJROrderedCart2.getProductDetail()) == null)) {
                        str4 = productDetail2.getBrandName();
                    }
                    bundle.putString("metroTicketVariant", str4);
                    bundle.putString("metro_request_type", str2);
                    CJROrderedCart cJROrderedCart3 = this.f63282b;
                    if (!(cJROrderedCart3 == null || (productDetail = cJROrderedCart3.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null)) {
                        z = attributes.isCancellable();
                    }
                    bundle.putBoolean("is_cancellable", z);
                    g gVar = new g();
                    gVar.setCancelable(true);
                    gVar.setArguments(bundle);
                    androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                    k.a((Object) childFragmentManager, "childFragmentManager");
                    gVar.show(childFragmentManager, b.class.getName());
                    return;
                }
                str2 = "MUMBAI_METRO";
                CJROrderedCart cJROrderedCart22 = this.f63282b;
                str4 = productDetail2.getBrandName();
                bundle.putString("metroTicketVariant", str4);
                bundle.putString("metro_request_type", str2);
                CJROrderedCart cJROrderedCart32 = this.f63282b;
                z = attributes.isCancellable();
                bundle.putBoolean("is_cancellable", z);
                g gVar2 = new g();
                gVar2.setCancelable(true);
                gVar2.setArguments(bundle);
                androidx.fragment.app.j childFragmentManager2 = getChildFragmentManager();
                k.a((Object) childFragmentManager2, "childFragmentManager");
                gVar2.show(childFragmentManager2, b.class.getName());
                return;
            }
            throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>");
        }
    }

    public final void a(String str, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        k.c(cJRActiveMetroTicketModel, "ticket");
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            net.one97.paytm.recharge.di.helper.b.a(getContext(), "mumbai metro qr", "view_ticket_clicked", "", "", "/utility/active-tickets", "utility");
        } catch (Throwable unused) {
        }
        Bundle bundle = new Bundle();
        List arrayList = new ArrayList();
        arrayList.add(cJRActiveMetroTicketModel);
        a(bundle, (List<? extends CJRActiveMetroTicketModel>) arrayList);
        CJROrderedCart cJROrderedCart = this.f63282b;
        a(cJROrderedCart != null ? cJROrderedCart.getTapAction() : null);
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r11v14, types: [net.one97.paytm.common.entity.shopping.CJROrderSummaryAction] */
    /* JADX WARNING: type inference failed for: r11v16 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r9, com.paytm.network.model.IJRPaytmDataModel r10, java.lang.Object r11) {
        /*
            r8 = this;
            java.lang.String r11 = "tag"
            kotlin.g.b.k.c(r9, r11)
            if (r10 == 0) goto L_0x01f9
            boolean r9 = r10 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r11 = 0
            r0 = 0
            if (r9 == 0) goto L_0x0061
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = r8.f63282b
            if (r9 != 0) goto L_0x002e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r10
            java.util.ArrayList r9 = r10.getOrderedCartList()
            if (r9 == 0) goto L_0x0021
            java.lang.Object r9 = r9.get(r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9
            goto L_0x0022
        L_0x0021:
            r9 = r11
        L_0x0022:
            r8.f63282b = r9
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = r8.f63282b
            if (r9 == 0) goto L_0x0052
            java.lang.String r10 = r8.f63281a
            r9.setOrderId(r10)
            goto L_0x0052
        L_0x002e:
            if (r9 != 0) goto L_0x0033
            kotlin.g.b.k.a()
        L_0x0033:
            monitor-enter(r9)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r10     // Catch:{ all -> 0x005e }
            java.util.ArrayList r10 = r10.getOrderedCartList()     // Catch:{ all -> 0x005e }
            if (r10 == 0) goto L_0x0043
            java.lang.Object r10 = r10.get(r0)     // Catch:{ all -> 0x005e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10     // Catch:{ all -> 0x005e }
            goto L_0x0044
        L_0x0043:
            r10 = r11
        L_0x0044:
            r8.f63282b = r10     // Catch:{ all -> 0x005e }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = r8.f63282b     // Catch:{ all -> 0x005e }
            if (r10 == 0) goto L_0x004f
            java.lang.String r0 = r8.f63281a     // Catch:{ all -> 0x005e }
            r10.setOrderId(r0)     // Catch:{ all -> 0x005e }
        L_0x004f:
            kotlin.x r10 = kotlin.x.f47997a     // Catch:{ all -> 0x005e }
            monitor-exit(r9)
        L_0x0052:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = r8.f63282b
            if (r9 == 0) goto L_0x005a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r11 = r9.getTapAction()
        L_0x005a:
            r8.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r11)
            return
        L_0x005e:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x0061:
            boolean r9 = r10 instanceof net.one97.paytm.recharge.model.CJROSActionResponseV2
            if (r9 == 0) goto L_0x01f9
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r10 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r10
            java.util.List r9 = r10.getTickets()
            java.util.List r10 = r10.getPasses()
            java.util.List r9 = net.one97.paytm.recharge.metro.f.c.a.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r9, (java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r10)
            if (r9 == 0) goto L_0x01f9
            boolean r10 = r9.isEmpty()
            if (r10 != 0) goto L_0x01f9
            r8.f63288h = r9
            net.one97.paytm.recharge.metro.f.c$e r9 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r9 = r9.getValue()
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r10 = r8.f63288h
            if (r10 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            java.lang.Object r10 = r10.get(r0)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            java.lang.String r10 = r10.getType()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x01b4
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r9 = r8.f63288h
            if (r9 != 0) goto L_0x00a3
            kotlin.g.b.k.a()
        L_0x00a3:
            java.lang.Object r9 = r9.get(r0)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
            if (r9 == 0) goto L_0x00af
            java.util.List r11 = r9.getQrCodes()
        L_0x00af:
            java.util.Iterator r9 = r11.iterator()
        L_0x00b3:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01b4
            java.lang.Object r10 = r9.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r10
            java.lang.String r11 = "qrcodes"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            java.lang.String r11 = r10.getPreviousQrCodeId()
            boolean r1 = r8.isAdded()
            if (r1 == 0) goto L_0x00b3
            android.content.Context r1 = r8.getContext()
            if (r1 == 0) goto L_0x00b3
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x00b3
            java.lang.String r10 = r10.getStatus()
            java.lang.String r2 = "ACTIVE"
            boolean r10 = r2.equals(r10)
            if (r10 == 0) goto L_0x00b3
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r9 = "prevQrCodeId"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r9)
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r9 = r8.f63288h
            if (r9 != 0) goto L_0x00f7
            kotlin.g.b.k.a()
        L_0x00f7:
            java.lang.Object r9 = r9.get(r0)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
            android.content.Context r10 = r8.getContext()
            if (r10 != 0) goto L_0x0106
            kotlin.g.b.k.a()
        L_0x0106:
            java.lang.String r2 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            java.lang.String r2 = "prevQrCodeId"
            kotlin.g.b.k.c(r11, r2)
            java.lang.String r2 = "newtTicket"
            kotlin.g.b.k.c(r9, r2)
            java.lang.String r2 = "context"
            kotlin.g.b.k.c(r10, r2)
            java.util.List r2 = net.one97.paytm.recharge.metro.f.c.a.a((android.content.Context) r10)
            if (r2 == 0) goto L_0x01b4
            java.util.concurrent.CopyOnWriteArraySet r3 = new java.util.concurrent.CopyOnWriteArraySet
            java.util.Collection r2 = (java.util.Collection) r2
            r3.<init>(r2)
            java.util.Iterator r2 = r3.iterator()
        L_0x012b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x01b4
            java.lang.Object r4 = r2.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x012b
            java.lang.String r5 = "ticket"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.List r5 = r4.getQrCodes()
            if (r5 == 0) goto L_0x012b
            java.util.List r5 = r4.getQrCodes()
            java.util.Iterator r5 = r5.iterator()
        L_0x0151:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x012b
            java.lang.Object r6 = r5.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r6
            java.lang.String r7 = "qrCode"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getQrCodeId()
            boolean r7 = r11.equals(r7)
            if (r7 == 0) goto L_0x0151
            java.util.List r11 = r4.getQrCodes()
            int r11 = r11.size()
            r1 = 1
            if (r11 != r1) goto L_0x017b
            r3.remove(r4)
            goto L_0x0182
        L_0x017b:
            java.util.List r11 = r4.getQrCodes()
            r11.remove(r6)
        L_0x0182:
            r3.add(r9)
            net.one97.paytm.recharge.common.utils.ax$a r9 = net.one97.paytm.recharge.common.utils.ax.f61521a
            android.content.Context r9 = r10.getApplicationContext()
            java.lang.String r11 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            com.paytm.utility.f$a r11 = com.paytm.utility.f.a.METRO_PREF
            com.paytm.b.a.a r9 = net.one97.paytm.recharge.common.utils.ax.a.a(r9, r11)
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r10)
            java.lang.String r1 = "CJRAppCommonUtility.getUserId(context)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r1 = r1.a((java.lang.Object) r3)
            r9.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r0)
            java.lang.String r10 = com.paytm.utility.b.n((android.content.Context) r10)
            java.lang.String r11 = "metroActiveTickets"
            r9.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r0)
        L_0x01b4:
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r9 = r8.f63288h
            if (r9 != 0) goto L_0x01bd
            kotlin.g.b.k.a()
        L_0x01bd:
            boolean r9 = net.one97.paytm.recharge.metro.f.c.a.c((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r9)
            net.one97.paytm.recharge.metro.f.b$a r10 = net.one97.paytm.recharge.metro.f.b.f63570c
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r10 = r8.f63288h
            if (r10 != 0) goto L_0x01ca
            kotlin.g.b.k.a()
        L_0x01ca:
            java.lang.Object r10 = r10.get(r0)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            long r10 = r10.getProductId()
            net.one97.paytm.recharge.metro.f.b.a.a(r10, r9)
            r8.f63283c = r0
            com.airbnb.lottie.LottieAnimationView r9 = r8.f63287g
            if (r9 == 0) goto L_0x01e0
            r9.cancelAnimation()
        L_0x01e0:
            android.view.View r9 = r8.getView()
            if (r9 == 0) goto L_0x01f5
            int r10 = net.one97.paytm.recharge.R.id.progress_view
            android.view.View r9 = r9.findViewById(r10)
            androidx.cardview.widget.CardView r9 = (androidx.cardview.widget.CardView) r9
            if (r9 == 0) goto L_0x01f5
            r10 = 8
            r9.setVisibility(r10)
        L_0x01f5:
            r8.a()
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.c.b.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    private String c() {
        String str;
        String str2;
        CJROrderSummaryProductDetail productDetail;
        String brandName;
        CJROrderedCart cJROrderedCart = this.f63282b;
        if (cJROrderedCart == null || (productDetail = cJROrderedCart.getProductDetail()) == null || (brandName = productDetail.getBrandName()) == null) {
            str = null;
        } else if (brandName != null) {
            str = brandName.toLowerCase();
            k.a((Object) str, "(this as java.lang.String).toLowerCase()");
        } else {
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = "Mumbai Metro".toLowerCase();
        k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
        if (!k.a((Object) str, (Object) lowerCase)) {
            String lowerCase2 = "Delhi Metro".toLowerCase();
            k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (k.a((Object) str, (Object) lowerCase2)) {
                String str3 = this.j;
                if (str3 != null) {
                    if (str3 != null) {
                        String lowerCase3 = str3.toLowerCase();
                        k.a((Object) lowerCase3, "(this as java.lang.String).toLowerCase()");
                        if (lowerCase3 != null) {
                            String lowerCase4 = "Trip Pass".toLowerCase();
                            k.a((Object) lowerCase4, "(this as java.lang.String).toLowerCase()");
                            if (kotlin.m.p.a((CharSequence) lowerCase3, (CharSequence) lowerCase4, false)) {
                                return "delhi metro trip pass";
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                String str4 = this.j;
                if (str4 == null) {
                    return "";
                }
                if (str4 != null) {
                    String lowerCase5 = str4.toLowerCase();
                    k.a((Object) lowerCase5, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase5 == null) {
                        return "";
                    }
                    String lowerCase6 = "Metro QR Ticket".toLowerCase();
                    k.a((Object) lowerCase6, "(this as java.lang.String).toLowerCase()");
                    if (kotlin.m.p.a((CharSequence) lowerCase5, (CharSequence) lowerCase6, false)) {
                        return "delhi metro qr";
                    }
                    return "";
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase7 = "Hyderabad Metro".toLowerCase();
            k.a((Object) lowerCase7, "(this as java.lang.String).toLowerCase()");
            if (!k.a((Object) str, (Object) lowerCase7) || (str2 = this.j) == null) {
                return "";
            }
            if (str2 != null) {
                String lowerCase8 = str2.toLowerCase();
                k.a((Object) lowerCase8, "(this as java.lang.String).toLowerCase()");
                if (lowerCase8 == null) {
                    return "";
                }
                String lowerCase9 = "Metro QR Ticket".toLowerCase();
                k.a((Object) lowerCase9, "(this as java.lang.String).toLowerCase()");
                if (kotlin.m.p.a((CharSequence) lowerCase8, (CharSequence) lowerCase9, false)) {
                    return "hyderabad metro qr";
                }
                return "";
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } else if (TextUtils.isEmpty(this.j)) {
            return "";
        } else {
            String str5 = this.j;
            if (str5 != null) {
                if (str5 != null) {
                    String lowerCase10 = str5.toLowerCase();
                    k.a((Object) lowerCase10, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase10 != null) {
                        String lowerCase11 = "Trip Pass".toLowerCase();
                        k.a((Object) lowerCase11, "(this as java.lang.String).toLowerCase()");
                        if (kotlin.m.p.a((CharSequence) lowerCase10, (CharSequence) lowerCase11, false)) {
                            return "mumbai metro trip pass";
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            String str6 = this.j;
            if (str6 != null) {
                if (str6 != null) {
                    String lowerCase12 = str6.toLowerCase();
                    k.a((Object) lowerCase12, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase12 != null) {
                        String lowerCase13 = "Metro QR Ticket".toLowerCase();
                        k.a((Object) lowerCase13, "(this as java.lang.String).toLowerCase()");
                        if (kotlin.m.p.a((CharSequence) lowerCase12, (CharSequence) lowerCase13, false)) {
                            return "mumbai metro qr";
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            String str7 = this.j;
            if (str7 == null) {
                return "";
            }
            if (str7 != null) {
                String lowerCase14 = str7.toLowerCase();
                k.a((Object) lowerCase14, "(this as java.lang.String).toLowerCase()");
                if (lowerCase14 == null) {
                    return "";
                }
                String lowerCase15 = "Store Value Pass".toLowerCase();
                k.a((Object) lowerCase15, "(this as java.lang.String).toLowerCase()");
                if (kotlin.m.p.a((CharSequence) lowerCase14, (CharSequence) lowerCase15, false)) {
                    return "mumbai metro store value pass";
                }
                return "";
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
