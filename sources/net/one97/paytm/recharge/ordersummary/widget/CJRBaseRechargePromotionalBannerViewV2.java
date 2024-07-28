package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.f.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRBaseRechargePromotionalBannerViewV2 extends ScrollView implements net.one97.paytm.recharge.ordersummary.f.a {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f64373a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f64374b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View f64375c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJRCustomRecyclerView f64376d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f64377e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f64378f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f64379g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.a<RecyclerView.v> f64380h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f64381i;
    private ShimmerFrameLayout j;
    private StoreFrontGAHandler k;
    private final d l;
    private final FragmentActivity m;
    private String n;
    /* access modifiers changed from: private */
    public final boolean o;
    private String p;
    private final int q;
    private final int r;
    private String s;
    private String t;

    public final FragmentActivity getContext() {
        return this.m;
    }

    public final String getPromotionalUrl() {
        return this.n;
    }

    public final void setPromotionalUrl(String str) {
        this.n = str;
    }

    public final String getCategoryId() {
        return this.p;
    }

    public final void setCategoryId(String str) {
        k.c(str, "<set-?>");
        this.p = str;
    }

    public final int getTitleBgColor() {
        return this.q;
    }

    public final int getTitleTextColor() {
        return this.r;
    }

    public final String getPScreenName() {
        return this.s;
    }

    public final void setPScreenName(String str) {
        k.c(str, "<set-?>");
        this.s = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRBaseRechargePromotionalBannerViewV2(androidx.fragment.app.FragmentActivity r12, java.lang.String r13, boolean r14, java.lang.String r15, int r16, int r17, java.lang.String r18, java.lang.String r19, int r20) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r5 = 0
            goto L_0x000a
        L_0x0009:
            r5 = r14
        L_0x000a:
            r1 = r0 & 8
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0012
            r6 = r2
            goto L_0x0013
        L_0x0012:
            r6 = r15
        L_0x0013:
            r1 = r0 & 16
            r3 = -1
            if (r1 == 0) goto L_0x001a
            r7 = -1
            goto L_0x001c
        L_0x001a:
            r7 = r16
        L_0x001c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0022
            r8 = -1
            goto L_0x0024
        L_0x0022:
            r8 = r17
        L_0x0024:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            r9 = r2
            goto L_0x002c
        L_0x002a:
            r9 = r18
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0032
            r10 = r2
            goto L_0x0034
        L_0x0032:
            r10 = r19
        L_0x0034:
            r2 = r11
            r3 = r12
            r4 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2.<init>(androidx.fragment.app.FragmentActivity, java.lang.String, boolean, java.lang.String, int, int, java.lang.String, java.lang.String, int):void");
    }

    public final String getVerticalId() {
        return this.t;
    }

    public final void setVerticalId(String str) {
        k.c(str, "<set-?>");
        this.t = str;
    }

    /* JADX WARNING: type inference failed for: r2v27, types: [android.view.View] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CJRBaseRechargePromotionalBannerViewV2(androidx.fragment.app.FragmentActivity r2, java.lang.String r3, boolean r4, java.lang.String r5, int r6, int r7, java.lang.String r8, java.lang.String r9) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r0 = "categoryId"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "pScreenName"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "verticalId"
            kotlin.g.b.k.c(r9, r0)
            r0 = r2
            android.content.Context r0 = (android.content.Context) r0
            r1.<init>(r0)
            r1.m = r2
            r1.n = r3
            r1.o = r4
            r1.p = r5
            r1.q = r6
            r1.r = r7
            r1.s = r8
            r1.t = r9
            java.lang.String r2 = ""
            r1.f64381i = r2
            r2 = -1
            r1.setBackgroundColor(r2)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r4 = -2
            r3.<init>(r2, r4)
            r5 = 5
            int r5 = com.paytm.utility.b.c((int) r5)
            r3.topMargin = r5
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r1.setLayoutParams(r3)
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            androidx.fragment.app.FragmentActivity r5 = r1.m
            android.content.Context r5 = (android.content.Context) r5
            r3.<init>(r5)
            r1.f64373a = r3
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r3.<init>(r2, r4)
            android.widget.LinearLayout r2 = r1.f64373a
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r2.setLayoutParams(r3)
            android.widget.LinearLayout r2 = r1.f64373a
            r3 = 1
            r2.setOrientation(r3)
            android.widget.LinearLayout r2 = r1.f64373a
            r3 = 393216(0x60000, float:5.51013E-40)
            r2.setDescendantFocusability(r3)
            android.widget.LinearLayout r2 = r1.f64373a
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
            android.content.Context r2 = r1.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = net.one97.paytm.recharge.R.layout.banner_custom_widget_v2
            r4 = 0
            android.view.View r2 = r2.inflate(r3, r4)
            r1.f64375c = r2
            android.view.View r2 = r1.f64375c
            if (r2 == 0) goto L_0x008e
            int r3 = net.one97.paytm.recharge.R.id.dummy_sticky_header
            android.view.View r2 = r2.findViewById(r3)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            goto L_0x008f
        L_0x008e:
            r2 = r4
        L_0x008f:
            if (r2 == 0) goto L_0x0104
            r1.f64377e = r2
            android.view.View r2 = r1.f64375c
            if (r2 == 0) goto L_0x00a0
            int r3 = net.one97.paytm.recharge.R.id.txt_title
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x00a1
        L_0x00a0:
            r2 = r4
        L_0x00a1:
            r1.f64379g = r2
            android.view.View r2 = r1.f64375c
            if (r2 == 0) goto L_0x00ae
            int r3 = net.one97.paytm.recharge.R.id.infinite_border
            android.view.View r2 = r2.findViewById(r3)
            goto L_0x00af
        L_0x00ae:
            r2 = r4
        L_0x00af:
            r1.f64378f = r2
            android.view.View r2 = r1.f64375c
            if (r2 == 0) goto L_0x00be
            int r3 = net.one97.paytm.recharge.R.id.shimmer_lyt
            android.view.View r2 = r2.findViewById(r3)
            net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
            goto L_0x00bf
        L_0x00be:
            r2 = r4
        L_0x00bf:
            r1.j = r2
            android.view.View r2 = r1.f64375c
            if (r2 == 0) goto L_0x00ce
            int r3 = net.one97.paytm.recharge.R.id.home_list
            android.view.View r2 = r2.findViewById(r3)
            r4 = r2
            net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView r4 = (net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView) r4
        L_0x00ce:
            r1.f64376d = r4
            net.one97.paytm.recharge.common.utils.CJRCustomRecyclerView r2 = r1.f64376d
            if (r2 == 0) goto L_0x00e4
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.fragment.app.FragmentActivity r4 = r1.m
            android.content.Context r4 = r4.getBaseContext()
            r3.<init>(r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r2.setLayoutManager(r3)
        L_0x00e4:
            android.widget.LinearLayout r2 = r1.f64373a
            android.view.View r3 = r1.f64375c
            r2.addView(r3)
            r1.b()
            r1.a()
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2$b r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2$b
            r2.<init>(r1)
            com.paytmmall.clpartifact.common.StoreFrontGAHandler r2 = (com.paytmmall.clpartifact.common.StoreFrontGAHandler) r2
            r1.k = r2
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2$c r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2$c
            r2.<init>(r1)
            net.one97.paytm.recharge.ordersummary.f.d r2 = (net.one97.paytm.recharge.ordersummary.f.d) r2
            r1.l = r2
            return
        L_0x0104:
            kotlin.u r2 = new kotlin.u
            java.lang.String r3 = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2.<init>(androidx.fragment.app.FragmentActivity, java.lang.String, boolean, java.lang.String, int, int, java.lang.String, java.lang.String):void");
    }

    public final void setVerticalID(String str) {
        k.c(str, "pVerticalId");
        this.t = str;
    }

    public final void setScreenNameParams(String str) {
        k.c(str, "screenNameParams");
        this.s = str;
    }

    public static final class b extends StoreFrontGAHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerViewV2 f64383a;

        public final int getClient() {
            return 1007;
        }

        b(CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV2) {
            this.f64383a = cJRBaseRechargePromotionalBannerViewV2;
        }

        public final String getScreenName() {
            return this.f64383a.getPScreenName();
        }

        public final String getVerticalID() {
            return this.f64383a.getVerticalId();
        }

        public final String getClientRequestID() {
            return this.f64383a.f64381i;
        }
    }

    public final StoreFrontGAHandler getGaListener() {
        return this.k;
    }

    public final void setGaListener(StoreFrontGAHandler storeFrontGAHandler) {
        k.c(storeFrontGAHandler, "<set-?>");
        this.k = storeFrontGAHandler;
    }

    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerViewV2 f64384a;

        c(CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV2) {
            this.f64384a = cJRBaseRechargePromotionalBannerViewV2;
        }

        public final void a(RecyclerView.a<RecyclerView.v> aVar, List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list) {
            k.c(list, "viewList");
            this.f64384a.c();
            if (aVar != null) {
                net.one97.paytm.recharge.ordersummary.a.b bVar = new net.one97.paytm.recharge.ordersummary.a.b(this.f64384a.getContext(), aVar, list);
                CJRCustomRecyclerView f2 = this.f64384a.f64376d;
                if (f2 != null) {
                    f2.setNestedScrollingEnabled(false);
                }
                CJRCustomRecyclerView f3 = this.f64384a.f64376d;
                if (f3 != null) {
                    f3.setAdapter(aVar);
                }
                CJRCustomRecyclerView f4 = this.f64384a.f64376d;
                if (f4 != null) {
                    ai.a(f4);
                }
                if (this.f64384a.o && bVar.getItemCount() > 0) {
                    if (!(this.f64384a.getTitleBgColor() == -1 || this.f64384a.getTitleTextColor() == -1)) {
                        TextView h2 = this.f64384a.f64379g;
                        if (h2 != null) {
                            h2.setBackgroundColor(androidx.core.content.b.c(this.f64384a.getContext(), this.f64384a.getTitleBgColor()));
                        }
                        TextView h3 = this.f64384a.f64379g;
                        if (h3 != null) {
                            h3.setTextColor(androidx.core.content.b.c(this.f64384a.getContext(), this.f64384a.getTitleTextColor()));
                        }
                    }
                    TextView h4 = this.f64384a.f64379g;
                    if (h4 != null) {
                        ai.a(h4);
                    }
                }
                View b2 = this.f64384a.f64375c;
                if (b2 != null) {
                    ai.a(b2);
                    return;
                }
                return;
            }
            View b3 = this.f64384a.f64375c;
            if (b3 != null) {
                ai.b(b3);
            }
        }
    }

    public final d getHomePageDataPopulateListener() {
        return this.l;
    }

    private final void a() {
        String str = this.n;
        if (TextUtils.isEmpty(str)) {
            c();
            View view = this.f64375c;
            if (view != null) {
                ai.b(view);
                return;
            }
            return;
        }
        String a2 = k.a(str, (Object) com.paytm.utility.c.a((Context) this.m, true));
        String postRequestBodyForV2 = CJRRechargeUtilities.INSTANCE.postRequestBodyForV2(this.m, "PG page", "Summary Page");
        HashMap<String, String> n2 = com.paytm.utility.b.n();
        if (com.paytm.utility.b.c((Context) this.m)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a3.getFlowName();
            if (flowName != null) {
                flowName.setRequestBody(postRequestBodyForV2);
            }
            CRUFlowModel flowName2 = a3.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName3 = a3.getFlowName();
            if (flowName3 != null) {
                flowName3.setActionType(ACTION_TYPE.OS_FETCH_PROMOTIONAL_BANNER_DATA.name());
            }
            net.one97.paytm.recharge.common.f.a cVar = new net.one97.paytm.recharge.common.f.c("fetch_promotional_banner_data", a2, (net.one97.paytm.recharge.common.e.ai) new a(this), (IJRPaytmDataModel) new CJRHomePageV2(), (Map<String, String>) null, (Map<String, String>) n2, postRequestBodyForV2, (Object) a3);
            if (com.paytm.utility.b.c((Context) this.m)) {
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
                return;
            }
            setVisibility(8);
            return;
        }
        View view2 = this.f64375c;
        if (view2 != null) {
            ai.b(view2);
        }
    }

    public static final class a implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseRechargePromotionalBannerViewV2 f64382a;

        a(CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV2) {
            this.f64382a = cJRBaseRechargePromotionalBannerViewV2;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f64382a.c();
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || p.a(errorMsg)) {
                    cJRRechargeErrorModel.setErrorMsg(str + " api error");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
            View b2 = this.f64382a.f64375c;
            if (b2 != null) {
                ai.b(b2);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel != null) {
                try {
                    if (iJRPaytmDataModel instanceof CJRHomePageV2) {
                        this.f64382a.f64374b = ((CJRHomePageV2) iJRPaytmDataModel).getGAKey();
                        CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV2 = this.f64382a;
                        String str2 = ((CJRHomePageV2) iJRPaytmDataModel).cjrContext.mrequestid;
                        k.a((Object) str2, "response.cjrContext.mrequestid");
                        cJRBaseRechargePromotionalBannerViewV2.f64381i = str2;
                        CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV22 = this.f64382a;
                        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                        net.one97.paytm.recharge.ordersummary.f.a aVar = this.f64382a;
                        FragmentActivity context = this.f64382a.getContext();
                        CJRHomePageV2 a2 = CJRBaseRechargePromotionalBannerViewV2.a((CJRHomePageV2) iJRPaytmDataModel);
                        RecyclerView d2 = this.f64382a.f64377e;
                        if (d2 == null) {
                            k.a();
                        }
                        View e2 = this.f64382a.f64378f;
                        if (e2 == null) {
                            k.a();
                        }
                        cJRBaseRechargePromotionalBannerViewV22.f64380h = cJRRechargeUtilities.getHomeFragmentWidgetAdapter(aVar, context, a2, "scds", d2, (CJRItem) null, e2, this.f64382a.getHomePageDataPopulateListener(), this.f64382a.getGaListener());
                    }
                } catch (Exception e3) {
                    this.f64382a.c();
                    q.d(e3.getMessage());
                    View b2 = this.f64382a.f64375c;
                    if (b2 != null) {
                        ai.b(b2);
                    }
                    if (obj instanceof CJRRechargeErrorModel) {
                        CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                        CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                        if (errorMsg == null || p.a(errorMsg)) {
                            cJRRechargeErrorModel.setErrorMsg(e3.getMessage());
                        }
                        az azVar = az.f61525a;
                        az.a(cJRRechargeErrorModel);
                    }
                }
            }
        }
    }

    public final String getCurrentCategoryId() {
        return this.p;
    }

    public final void a(String str) {
        k.c(str, "pCategoryId");
        if (TextUtils.isEmpty(str)) {
            View view = this.f64375c;
            if (view != null) {
                ai.b(view);
                return;
            }
            return;
        }
        this.p = str;
        this.n = az.b(str);
        b();
        a();
    }

    private final void b() {
        CJRCustomRecyclerView cJRCustomRecyclerView = this.f64376d;
        if (cJRCustomRecyclerView != null) {
            ai.b(cJRCustomRecyclerView);
        }
        ShimmerFrameLayout shimmerFrameLayout = this.j;
        if (shimmerFrameLayout != null) {
            ai.a(shimmerFrameLayout);
        }
        ShimmerFrameLayout shimmerFrameLayout2 = this.j;
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.a();
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        ShimmerFrameLayout shimmerFrameLayout = this.j;
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        ShimmerFrameLayout shimmerFrameLayout2 = this.j;
        if (shimmerFrameLayout2 != null) {
            ai.b(shimmerFrameLayout2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.common.entity.shopping.CJRHomePageV2 a(net.one97.paytm.common.entity.shopping.CJRHomePageV2 r10) {
        /*
            java.util.ArrayList r0 = r10.getmPage()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x005b
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x005b
            java.lang.Object r4 = r0.next()
            net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2 r4 = (net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2) r4
            java.lang.String r5 = "view"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.util.ArrayList r4 = r4.getHomePageLayoutList()
            if (r4 == 0) goto L_0x000f
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
        L_0x002e:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x000f
            java.lang.Object r6 = r4.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L_0x003f
            kotlin.a.k.a()
        L_0x003f:
            r5 = r6
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r5 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r5
            net.one97.paytm.common.entity.shopping.LayoutType r6 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_SMART_ICON_GRID
            java.lang.String r6 = r6.getName()
            java.lang.String r8 = "layout"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r8 = r5.getLayout()
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r8, (boolean) r2)
            if (r6 == 0) goto L_0x0059
            r3 = r5
            goto L_0x000f
        L_0x0059:
            r5 = r7
            goto L_0x002e
        L_0x005b:
            if (r3 == 0) goto L_0x00ac
            java.util.ArrayList r0 = new java.util.ArrayList
            r4 = 8
            r0.<init>(r4)
            if (r3 == 0) goto L_0x00a7
            java.util.ArrayList r5 = r3.getHomePageItemList()
            if (r5 == 0) goto L_0x00a7
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0072:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r6 = r5.next()
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r6 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r6
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getURL()
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.ba.l(r7)
            java.lang.String r8 = r6.getURL()
            java.lang.String r9 = r6.getURLType()
            net.one97.paytm.recharge.common.utils.z.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            java.lang.String r8 = ""
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x0072
            if (r1 >= r4) goto L_0x0072
            r0.add(r6)
            int r1 = r1 + 1
            goto L_0x0072
        L_0x00a7:
            if (r3 == 0) goto L_0x00ac
            r3.setmHomePageItemList(r0)
        L_0x00ac:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2.a(net.one97.paytm.common.entity.shopping.CJRHomePageV2):net.one97.paytm.common.entity.shopping.CJRHomePageV2");
    }
}
