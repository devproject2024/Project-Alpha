package net.one97.paytm.recharge.ordersummary.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.f.d;
import net.one97.paytm.recharge.ordersummary.f.e;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;

public final class CJRBaseRechargePromotionalBannerView extends ScrollView implements net.one97.paytm.recharge.ordersummary.f.a {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f64351a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f64352b;

    /* renamed from: c  reason: collision with root package name */
    private String f64353c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f64354d;

    /* renamed from: e  reason: collision with root package name */
    private StoreFrontGAHandler f64355e;

    /* renamed from: f  reason: collision with root package name */
    private final FragmentActivity f64356f;

    /* renamed from: g  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64357g;

    /* renamed from: h  reason: collision with root package name */
    private final CJROrderedCart f64358h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f64359i;
    private final e j;
    private final String k;

    public final FragmentActivity getContext() {
        return this.f64356f;
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64357g;
    }

    public final CJROrderedCart getOrderedCart() {
        return this.f64358h;
    }

    public final boolean getShowWithMallPromotions() {
        return this.f64359i;
    }

    public final e getBindListener() {
        return this.j;
    }

    public final String getPromotionalUrl() {
        return this.k;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRBaseRechargePromotionalBannerView(androidx.fragment.app.FragmentActivity r21, net.one97.paytm.recharge.ordersummary.b.a r22, net.one97.paytm.common.entity.shopping.CJROrderedCart r23, boolean r24, net.one97.paytm.recharge.ordersummary.f.e r25, java.lang.String r26) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r25
            java.lang.String r4 = "context"
            kotlin.g.b.k.c(r1, r4)
            java.lang.String r4 = "viewModel"
            kotlin.g.b.k.c(r2, r4)
            java.lang.String r4 = "bindListener"
            kotlin.g.b.k.c(r3, r4)
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            r0.<init>(r4)
            r0.f64356f = r1
            r0.f64357g = r2
            r1 = r23
            r0.f64358h = r1
            r1 = r24
            r0.f64359i = r1
            r0.j = r3
            r1 = r26
            r0.k = r1
            java.lang.String r1 = ""
            r0.f64354d = r1
            r1 = -1
            r0.setBackgroundColor(r1)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r3 = -2
            r2.<init>(r1, r3)
            r4 = 5
            int r4 = com.paytm.utility.b.c((int) r4)
            r2.topMargin = r4
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0.setLayoutParams(r2)
            android.widget.LinearLayout r2 = new android.widget.LinearLayout
            androidx.fragment.app.FragmentActivity r4 = r0.f64356f
            android.content.Context r4 = (android.content.Context) r4
            r2.<init>(r4)
            r0.f64351a = r2
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            r2.<init>(r1, r3)
            android.widget.LinearLayout r3 = r0.f64351a
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r3.setLayoutParams(r2)
            android.widget.LinearLayout r2 = r0.f64351a
            r3 = 1
            r2.setOrientation(r3)
            android.widget.LinearLayout r2 = r0.f64351a
            r4 = 393216(0x60000, float:5.51013E-40)
            r2.setDescendantFocusability(r4)
            android.view.View r2 = new android.view.View
            androidx.fragment.app.FragmentActivity r4 = r0.f64356f
            android.content.Context r4 = (android.content.Context) r4
            r2.<init>(r4)
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r5 = 8
            int r6 = com.paytm.utility.b.c((int) r5)
            r4.<init>(r1, r6)
            androidx.fragment.app.FragmentActivity r1 = r0.f64356f
            android.content.res.Resources r1 = r1.getResources()
            int r6 = net.one97.paytm.recharge.R.color.recharge_divider_widgets
            int r1 = r1.getColor(r6)
            r2.setBackgroundColor(r1)
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r2.setLayoutParams(r4)
            android.widget.LinearLayout r1 = r0.f64351a
            r1.addView(r2)
            android.widget.LinearLayout r1 = r0.f64351a
            android.view.View r1 = (android.view.View) r1
            r0.addView(r1)
            boolean r1 = r0.f64359i
            java.lang.String r4 = "view"
            java.lang.String r6 = "mMarketPlaceList"
            java.lang.String r7 = "Summary Page"
            java.lang.String r8 = "PG page"
            r9 = 0
            if (r1 == 0) goto L_0x0185
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r1 = net.one97.paytm.recharge.di.helper.c.aW()
            r0.f64353c = r1
            java.lang.String r1 = r0.f64353c
            androidx.fragment.app.FragmentActivity r10 = r0.f64356f
            android.content.Context r10 = (android.content.Context) r10
            java.lang.String r10 = com.paytm.utility.c.a((android.content.Context) r10, (boolean) r3)
            java.lang.String r1 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r10)
            r0.f64353c = r1
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r10 = r0.f64356f
            android.content.Context r10 = (android.content.Context) r10
            java.lang.String r1 = r1.postRequestBodyForV2(r10, r8, r7)
            java.util.HashMap r10 = com.paytm.utility.b.n()
            android.content.Context r11 = r20.getContext()
            android.view.LayoutInflater r11 = android.view.LayoutInflater.from(r11)
            int r12 = net.one97.paytm.recharge.R.layout.banner_custom_widget
            android.view.View r11 = r11.inflate(r12, r9)
            int r12 = net.one97.paytm.recharge.R.id.dummy_sticky_header
            android.view.View r12 = r11.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            int r13 = net.one97.paytm.recharge.R.id.infinite_border
            android.view.View r13 = r11.findViewById(r13)
            int r14 = net.one97.paytm.recharge.R.id.home_list
            android.view.View r14 = r11.findViewById(r14)
            net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView r14 = (net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView) r14
            androidx.recyclerview.widget.LinearLayoutManager r15 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r5 = r0.f64356f
            android.content.Context r5 = r5.getBaseContext()
            r15.<init>(r5)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r15 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r15
            r14.setLayoutManager(r15)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            net.one97.paytm.recharge.common.utils.ai.b(r11)
            android.widget.LinearLayout r5 = r0.f64351a
            r5.addView(r11)
            androidx.fragment.app.FragmentActivity r5 = r0.f64356f
            android.content.Context r5 = (android.content.Context) r5
            boolean r5 = com.paytm.utility.b.c((android.content.Context) r5)
            if (r5 == 0) goto L_0x0185
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r19 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r19.getFlowName()
            if (r5 == 0) goto L_0x012f
            r5.setRequestBody(r1)
        L_0x012f:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r19.getFlowName()
            if (r5 == 0) goto L_0x013e
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r15 = r15.name()
            r5.setErrorType(r15)
        L_0x013e:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r19.getFlowName()
            if (r5 == 0) goto L_0x014d
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r15 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_FETCH_PROMOTIONAL_BANNER_DATA
            java.lang.String r15 = r15.name()
            r5.setActionType(r15)
        L_0x014d:
            net.one97.paytm.recharge.common.f.c r5 = new net.one97.paytm.recharge.common.f.c
            java.lang.String r15 = r0.f64353c
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$a r16 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$a
            r21 = r16
            r22 = r20
            r23 = r11
            r24 = r12
            r25 = r13
            r26 = r14
            r21.<init>(r22, r23, r24, r25, r26)
            r14 = r16
            net.one97.paytm.recharge.common.e.ai r14 = (net.one97.paytm.recharge.common.e.ai) r14
            net.one97.paytm.common.entity.shopping.CJRHomePageV2 r11 = new net.one97.paytm.common.entity.shopping.CJRHomePageV2
            r11.<init>()
            r16 = r11
            com.paytm.network.model.IJRPaytmDataModel r16 = (com.paytm.network.model.IJRPaytmDataModel) r16
            r17 = 0
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r12 = "fetch_mall_thank_you_data"
            r11 = r5
            r13 = r15
            r15 = r16
            r16 = r17
            r17 = r10
            r18 = r1
            r11.<init>((java.lang.String) r12, (java.lang.String) r13, (net.one97.paytm.recharge.common.e.ai) r14, (com.paytm.network.model.IJRPaytmDataModel) r15, (java.util.Map<java.lang.String, java.lang.String>) r16, (java.util.Map<java.lang.String, java.lang.String>) r17, (java.lang.String) r18, (java.lang.Object) r19)
            r5.a()
        L_0x0185:
            java.lang.String r1 = r0.k
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r5 = net.one97.paytm.recharge.di.helper.c.av()
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0196
            net.one97.paytm.recharge.common.utils.ai.b(r2)
        L_0x0196:
            java.lang.String r1 = r0.k
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0277
            androidx.fragment.app.FragmentActivity r2 = r0.f64356f
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r2 = com.paytm.utility.c.a((android.content.Context) r2, (boolean) r3)
            java.lang.String r12 = kotlin.g.b.k.a((java.lang.String) r1, (java.lang.Object) r2)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            androidx.fragment.app.FragmentActivity r2 = r0.f64356f
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r1 = r1.postRequestBodyForV2(r2, r8, r7)
            java.util.HashMap r2 = com.paytm.utility.b.n()
            android.content.Context r3 = r20.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            int r5 = net.one97.paytm.recharge.R.layout.banner_custom_widget
            android.view.View r3 = r3.inflate(r5, r9)
            int r5 = net.one97.paytm.recharge.R.id.dummy_sticky_header
            android.view.View r5 = r3.findViewById(r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            int r7 = net.one97.paytm.recharge.R.id.infinite_border
            android.view.View r7 = r3.findViewById(r7)
            int r8 = net.one97.paytm.recharge.R.id.home_list
            android.view.View r8 = r3.findViewById(r8)
            net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView r8 = (net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView) r8
            androidx.recyclerview.widget.LinearLayoutManager r10 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r11 = r0.f64356f
            android.content.Context r11 = r11.getBaseContext()
            r10.<init>(r11)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r10 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r10
            r8.setLayoutManager(r10)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.common.utils.ai.b(r3)
            android.widget.LinearLayout r4 = r0.f64351a
            r4.addView(r3)
            androidx.fragment.app.FragmentActivity r4 = r0.f64356f
            android.content.Context r4 = (android.content.Context) r4
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)
            if (r4 == 0) goto L_0x0277
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r18 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r9, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r9)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r18.getFlowName()
            if (r4 == 0) goto L_0x0216
            r4.setRequestBody(r1)
        L_0x0216:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r18.getFlowName()
            if (r4 == 0) goto L_0x0225
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r4.setErrorType(r6)
        L_0x0225:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r18.getFlowName()
            if (r4 == 0) goto L_0x0234
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_FETCH_PROMOTIONAL_BANNER_DATA
            java.lang.String r6 = r6.name()
            r4.setActionType(r6)
        L_0x0234:
            net.one97.paytm.recharge.common.f.c r4 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$b r6 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$b
            r21 = r6
            r22 = r20
            r23 = r3
            r24 = r5
            r25 = r7
            r26 = r8
            r21.<init>(r22, r23, r24, r25, r26)
            r13 = r6
            net.one97.paytm.recharge.common.e.ai r13 = (net.one97.paytm.recharge.common.e.ai) r13
            net.one97.paytm.common.entity.shopping.CJRHomePageV2 r3 = new net.one97.paytm.common.entity.shopping.CJRHomePageV2
            r3.<init>()
            r14 = r3
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            r15 = 0
            r16 = r2
            java.util.Map r16 = (java.util.Map) r16
            java.lang.String r11 = "fetch_promotional_banner_data"
            r10 = r4
            r17 = r1
            r10.<init>((java.lang.String) r11, (java.lang.String) r12, (net.one97.paytm.recharge.common.e.ai) r13, (com.paytm.network.model.IJRPaytmDataModel) r14, (java.util.Map<java.lang.String, java.lang.String>) r15, (java.util.Map<java.lang.String, java.lang.String>) r16, (java.lang.String) r17, (java.lang.Object) r18)
            net.one97.paytm.recharge.common.f.a r4 = (net.one97.paytm.recharge.common.f.a) r4
            androidx.fragment.app.FragmentActivity r1 = r0.f64356f
            android.content.Context r1 = (android.content.Context) r1
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            if (r1 == 0) goto L_0x0272
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.d.b(r4)
            goto L_0x0277
        L_0x0272:
            r1 = 8
            r0.setVisibility(r1)
        L_0x0277:
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$c r1 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$c
            r1.<init>(r0)
            com.paytmmall.clpartifact.common.StoreFrontGAHandler r1 = (com.paytmmall.clpartifact.common.StoreFrontGAHandler) r1
            r0.f64355e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView.<init>(androidx.fragment.app.FragmentActivity, net.one97.paytm.recharge.ordersummary.b.a, net.one97.paytm.common.entity.shopping.CJROrderedCart, boolean, net.one97.paytm.recharge.ordersummary.f.e, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJRBaseRechargePromotionalBannerView(FragmentActivity fragmentActivity, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, e eVar) {
        this(fragmentActivity, aVar, cJROrderedCart, true, eVar, net.one97.paytm.recharge.di.helper.c.av());
        k.c(fragmentActivity, "context");
        k.c(aVar, "viewModel");
        k.c(eVar, "bindListener");
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
    }

    public static final class c extends StoreFrontGAHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerView f64372a;

        public final int getClient() {
            return 1004;
        }

        c(CJRBaseRechargePromotionalBannerView cJRBaseRechargePromotionalBannerView) {
            this.f64372a = cJRBaseRechargePromotionalBannerView;
        }

        public final String getScreenName() {
            return this.f64372a.getViewModel().r();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
            r0 = java.lang.String.valueOf(r0.getVerticalId());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getVerticalID() {
            /*
                r2 = this;
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r0 = r2.f64372a
                net.one97.paytm.recharge.ordersummary.b.a r0 = r0.getViewModel()
                net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
                if (r0 == 0) goto L_0x0016
                long r0 = r0.getVerticalId()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                if (r0 != 0) goto L_0x0018
            L_0x0016:
                java.lang.String r0 = ""
            L_0x0018:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView.c.getVerticalID():java.lang.String");
        }

        public final String getClientRequestID() {
            return this.f64372a.f64354d;
        }
    }

    public final StoreFrontGAHandler getGaListener() {
        return this.f64355e;
    }

    public final void setGaListener(StoreFrontGAHandler storeFrontGAHandler) {
        k.c(storeFrontGAHandler, "<set-?>");
        this.f64355e = storeFrontGAHandler;
    }

    public static final class a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerView f64360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f64361b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f64362c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f64363d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRCustomRecyclerView f64364e;

        a(CJRBaseRechargePromotionalBannerView cJRBaseRechargePromotionalBannerView, View view, RecyclerView recyclerView, View view2, CJRCustomRecyclerView cJRCustomRecyclerView) {
            this.f64360a = cJRBaseRechargePromotionalBannerView;
            this.f64361b = view;
            this.f64362c = recyclerView;
            this.f64363d = view2;
            this.f64364e = cJRCustomRecyclerView;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            View view = this.f64361b;
            k.a((Object) view, "view");
            net.one97.paytm.recharge.common.utils.ai.b(view);
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || p.a(errorMsg)) {
                    cJRRechargeErrorModel.setErrorMsg(str + " api error");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel != null) {
                try {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        CJRBaseRechargePromotionalBannerView cJRBaseRechargePromotionalBannerView = this.f64360a;
                        String str2 = ((CJRHomePageV2) iJRPaytmDataModel).cjrContext.mrequestid;
                        k.a((Object) str2, "response.cjrContext.mrequestid");
                        cJRBaseRechargePromotionalBannerView.f64354d = str2;
                        RecyclerView recyclerView = this.f64362c;
                        k.a((Object) recyclerView, "fixedInfiniteGridHeader");
                        View view = this.f64363d;
                        k.a((Object) view, "infiniteTabBorder");
                        CJRRechargeUtilities.INSTANCE.getHomeFragmentWidgetAdapter(this.f64360a, this.f64360a.getContext(), (CJRHomePageV2) iJRPaytmDataModel, "scds", recyclerView, (CJRItem) null, view, new C1270a(this), this.f64360a.getGaListener());
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                    View view2 = this.f64361b;
                    k.a((Object) view2, "view");
                    net.one97.paytm.recharge.common.utils.ai.b(view2);
                    if (obj instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                        CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                        if (errorMsg == null || p.a(errorMsg)) {
                            cJRRechargeErrorModel.setErrorMsg(e2.getMessage());
                        }
                        az azVar = az.f61525a;
                        az.a(cJRRechargeErrorModel);
                    }
                }
            }
        }

        /* renamed from: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView$a$a  reason: collision with other inner class name */
        public static final class C1270a implements d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f64365a;

            C1270a(a aVar) {
                this.f64365a = aVar;
            }

            public final void a(RecyclerView.a<RecyclerView.v> aVar, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list) {
                k.c(list, "viewList");
                if (aVar != null) {
                    CJRCustomRecyclerView cJRCustomRecyclerView = this.f64365a.f64364e;
                    k.a((Object) cJRCustomRecyclerView, "mMarketPlaceList");
                    cJRCustomRecyclerView.setNestedScrollingEnabled(false);
                    CJRCustomRecyclerView cJRCustomRecyclerView2 = this.f64365a.f64364e;
                    k.a((Object) cJRCustomRecyclerView2, "mMarketPlaceList");
                    cJRCustomRecyclerView2.setAdapter(aVar);
                    View view = this.f64365a.f64361b;
                    k.a((Object) view, "view");
                    net.one97.paytm.recharge.common.utils.ai.a(view);
                }
            }
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerView f64366a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f64367b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView f64368c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f64369d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJRCustomRecyclerView f64370e;

        b(CJRBaseRechargePromotionalBannerView cJRBaseRechargePromotionalBannerView, View view, RecyclerView recyclerView, View view2, CJRCustomRecyclerView cJRCustomRecyclerView) {
            this.f64366a = cJRBaseRechargePromotionalBannerView;
            this.f64367b = view;
            this.f64368c = recyclerView;
            this.f64369d = view2;
            this.f64370e = cJRCustomRecyclerView;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            View view = this.f64367b;
            k.a((Object) view, "view");
            net.one97.paytm.recharge.common.utils.ai.b(view);
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || p.a(errorMsg)) {
                    cJRRechargeErrorModel.setErrorMsg(str + " api error");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel != null) {
                try {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        this.f64366a.f64352b = ((CJRHomePageV2) iJRPaytmDataModel).getGAKey();
                        CJRBaseRechargePromotionalBannerView cJRBaseRechargePromotionalBannerView = this.f64366a;
                        String str2 = ((CJRHomePageV2) iJRPaytmDataModel).cjrContext.mrequestid;
                        k.a((Object) str2, "response.cjrContext.mrequestid");
                        cJRBaseRechargePromotionalBannerView.f64354d = str2;
                        FragmentActivity context = this.f64366a.getContext();
                        CJRHomePageV2 a2 = CJRBaseRechargePromotionalBannerView.a(this.f64366a, (CJRHomePageV2) iJRPaytmDataModel);
                        RecyclerView recyclerView = this.f64368c;
                        k.a((Object) recyclerView, "fixedInfiniteGridHeader");
                        View view = this.f64369d;
                        k.a((Object) view, "infiniteTabBorder");
                        CJRRechargeUtilities.INSTANCE.getHomeFragmentWidgetAdapter(this.f64366a, context, a2, "scds", recyclerView, (CJRItem) null, view, new a(this), this.f64366a.getGaListener());
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                    View view2 = this.f64367b;
                    k.a((Object) view2, "view");
                    net.one97.paytm.recharge.common.utils.ai.b(view2);
                    if (obj instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                        CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                        if (errorMsg == null || p.a(errorMsg)) {
                            cJRRechargeErrorModel.setErrorMsg(e2.getMessage());
                        }
                        az azVar = az.f61525a;
                        az.a(cJRRechargeErrorModel);
                    }
                }
            }
        }

        public static final class a implements d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f64371a;

            a(b bVar) {
                this.f64371a = bVar;
            }

            public final void a(RecyclerView.a<RecyclerView.v> aVar, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list) {
                k.c(list, "viewList");
                if (aVar != null) {
                    net.one97.paytm.recharge.ordersummary.a.b bVar = new net.one97.paytm.recharge.ordersummary.a.b(this.f64371a.f64366a.getContext(), aVar, list);
                    CJRCustomRecyclerView cJRCustomRecyclerView = this.f64371a.f64370e;
                    k.a((Object) cJRCustomRecyclerView, "mMarketPlaceList");
                    cJRCustomRecyclerView.setNestedScrollingEnabled(false);
                    CJRCustomRecyclerView cJRCustomRecyclerView2 = this.f64371a.f64370e;
                    k.a((Object) cJRCustomRecyclerView2, "mMarketPlaceList");
                    cJRCustomRecyclerView2.setAdapter(bVar);
                    View view = this.f64371a.f64367b;
                    k.a((Object) view, "view");
                    net.one97.paytm.recharge.common.utils.ai.a(view);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.common.entity.shopping.CJRHomePageV2 a(net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r10, net.one97.paytm.common.entity.shopping.CJRHomePageV2 r11) {
        /*
            java.util.ArrayList r0 = r11.getmPage()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x005a
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r0.next()
            net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2 r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2) r4
            java.lang.String r5 = "view"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.ArrayList r4 = r4.getHomePageLayoutList()
            if (r4 == 0) goto L_0x000f
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
        L_0x002d:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x000f
            java.lang.Object r6 = r4.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x003e
            kotlin.a.k.a()
        L_0x003e:
            r5 = r6
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r5 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r5
            net.one97.paytm.common.entity.shopping.LayoutType r6 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_SMART_ICON_GRID
            java.lang.String r6 = r6.getName()
            java.lang.String r8 = "layout"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r8 = r5.getLayout()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r8, (boolean) r2)
            if (r6 == 0) goto L_0x0058
            r3 = r5
            goto L_0x000f
        L_0x0058:
            r5 = r7
            goto L_0x002d
        L_0x005a:
            if (r3 == 0) goto L_0x00b1
            net.one97.paytm.recharge.ordersummary.b.a r10 = r10.f64357g
            long r4 = r10.f63997a
            java.lang.String r10 = java.lang.String.valueOf(r4)
            java.util.ArrayList r0 = new java.util.ArrayList
            r4 = 8
            r0.<init>(r4)
            if (r3 == 0) goto L_0x00ac
            java.util.ArrayList r5 = r3.getHomePageItemList()
            if (r5 == 0) goto L_0x00ac
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0079:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00ac
            java.lang.Object r6 = r5.next()
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r6 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r6
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getURL()
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.l(r7)
            java.lang.String r8 = r6.getURL()
            java.lang.String r9 = r6.getURLType()
            net.one97.paytm.recharge.common.utils.z.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r10)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x0079
            if (r1 >= r4) goto L_0x0079
            r0.add(r6)
            int r1 = r1 + 1
            goto L_0x0079
        L_0x00ac:
            if (r3 == 0) goto L_0x00b1
            r3.setmHomePageItemList(r0)
        L_0x00b1:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView.a(net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView, net.one97.paytm.common.entity.shopping.CJRHomePageV2):net.one97.paytm.common.entity.shopping.CJRHomePageV2");
    }
}
