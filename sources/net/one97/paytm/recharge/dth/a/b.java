package net.one97.paytm.recharge.dth.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.o;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.am;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.widget.CJRPromosViewV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.dth.widget.CJRDTHNewRechargeView;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class b extends a implements l.b, p.a, p.b, net.one97.paytm.recharge.common.e.f, o, CJRDTHNewRechargeView.a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f62659h = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String y;

    /* renamed from: f  reason: collision with root package name */
    net.one97.paytm.recharge.dth.c.a f62660f;

    /* renamed from: g  reason: collision with root package name */
    public CJRItem f62661g;

    /* renamed from: i  reason: collision with root package name */
    private List<CJRAggsItem> f62662i;
    private String j;
    private net.one97.paytm.recharge.common.c.e k;
    /* access modifiers changed from: private */
    public CJRCategoryData l;
    private CJRNextGroupData m;
    private n n;
    private boolean o;
    private CJRRecentOrderV8.a p;
    private CJRRecentOrderV8 q;
    private CJRDTHNewRechargeView r;
    /* access modifiers changed from: private */
    public List<? extends CJRFrequentOrder> s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public long u;
    private CJRPromosViewV8 v;
    private boolean w;
    private CJRBaseRechargePromotionalBannerViewV2 x;
    private HashMap z;

    public final void a(int i2) {
    }

    public final boolean a() {
        return true;
    }

    public final View b(int i2) {
        if (this.z == null) {
            this.z = new HashMap();
        }
        View view = (View) this.z.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.z.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
    }

    public final void f() {
    }

    public final void u() {
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: net.one97.paytm.recharge.dth.a.b$b  reason: collision with other inner class name */
    static final /* synthetic */ class C1213b extends i implements q<String, NetworkCustomError, Object, x> {
        C1213b(b bVar) {
            super(3, bVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(b.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((b) this.receiver).a(str, networkCustomError, obj);
        }
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRCategoryData>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRCategoryData>) (Data) obj);
            return x.f47997a;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x00d6: MOVE  (r8v5 java.util.Collection) = (r8v4 java.util.List)
            	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
            	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
            	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
            */
        public final void invoke(net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData> r8) {
            /*
                r7 = this;
                if (r8 == 0) goto L_0x00f8
                net.one97.paytm.recharge.model.v4.DataState r0 = r8.getDataState()
                if (r0 == 0) goto L_0x000d
                int[] r1 = net.one97.paytm.recharge.dth.a.c.f62669a
                r0.ordinal()
            L_0x000d:
                java.lang.Object r8 = r8.getData()
                net.one97.paytm.recharge.model.v4.CJRCategoryData r8 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r8
                if (r8 == 0) goto L_0x00f8
                r0 = 0
                net.one97.paytm.recharge.di.helper.b r1 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x003c }
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0     // Catch:{ all -> 0x003c }
                android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x003c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
                java.lang.String r3 = "/"
                r2.<init>(r3)     // Catch:{ all -> 0x003c }
                net.one97.paytm.recharge.dth.a.b r3 = r7.this$0     // Catch:{ all -> 0x003c }
                net.one97.paytm.recharge.dth.c.a r3 = r3.f62660f     // Catch:{ all -> 0x003c }
                if (r3 == 0) goto L_0x0030
                java.lang.Object r3 = r3.b()     // Catch:{ all -> 0x003c }
                goto L_0x0031
            L_0x0030:
                r3 = r0
            L_0x0031:
                r2.append(r3)     // Catch:{ all -> 0x003c }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003c }
                net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x003c }
                goto L_0x003d
            L_0x003c:
            L_0x003d:
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                r1.l = r8
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                net.one97.paytm.recharge.dth.c.a r1 = r1.f62660f
                r2 = 1
                if (r1 == 0) goto L_0x0077
                java.util.HashMap<java.lang.String, java.lang.String> r1 = r1.m
                if (r1 == 0) goto L_0x0077
                net.one97.paytm.recharge.dth.a.b r3 = r7.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = r3.l
                net.one97.paytm.recharge.dth.a.b r5 = r7.this$0
                net.one97.paytm.common.entity.CJRItem r5 = r5.f62661g
                if (r5 != 0) goto L_0x005e
                java.lang.String r6 = "mRechargeItem"
                kotlin.g.b.k.a((java.lang.String) r6)
            L_0x005e:
                java.lang.String r5 = r5.getURL()
                java.lang.String r6 = "mRechargeItem.url"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                boolean r3 = r3.a(r1, r4, r5)
                if (r3 != 0) goto L_0x0078
                java.util.Map r1 = (java.util.Map) r1
                java.lang.String r4 = "isFromDeeplink"
                java.lang.String r5 = "1"
                r1.put(r4, r5)
                goto L_0x0078
            L_0x0077:
                r3 = 1
            L_0x0078:
                if (r3 != 0) goto L_0x00c9
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                boolean r1 = r1.t
                java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment"
                if (r1 == 0) goto L_0x009e
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                androidx.fragment.app.Fragment r1 = r1.getParentFragment()
                if (r1 == 0) goto L_0x0098
                net.one97.paytm.recharge.dth.a.f r1 = (net.one97.paytm.recharge.dth.a.f) r1
                net.one97.paytm.recharge.dth.a.b r3 = r7.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.l
                r1.b(r3, r0)
                goto L_0x00b1
            L_0x0098:
                kotlin.u r8 = new kotlin.u
                r8.<init>(r3)
                throw r8
            L_0x009e:
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                androidx.fragment.app.Fragment r1 = r1.getParentFragment()
                if (r1 == 0) goto L_0x00c3
                net.one97.paytm.recharge.dth.a.f r1 = (net.one97.paytm.recharge.dth.a.f) r1
                net.one97.paytm.recharge.dth.a.b r3 = r7.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r3 = r3.l
                r1.a((net.one97.paytm.recharge.model.v4.CJRCategoryData) r3, (net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem) r0)
            L_0x00b1:
                android.os.Handler r1 = new android.os.Handler
                r1.<init>()
                net.one97.paytm.recharge.dth.a.b$c$a r3 = new net.one97.paytm.recharge.dth.a.b$c$a
                r3.<init>(r8, r7)
                java.lang.Runnable r3 = (java.lang.Runnable) r3
                r4 = 600(0x258, double:2.964E-321)
                r1.postDelayed(r3, r4)
                goto L_0x00ce
            L_0x00c3:
                kotlin.u r8 = new kotlin.u
                r8.<init>(r3)
                throw r8
            L_0x00c9:
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                net.one97.paytm.recharge.dth.a.b.b((net.one97.paytm.recharge.dth.a.b) r1, (net.one97.paytm.recharge.model.v4.CJRCategoryData) r8)
            L_0x00ce:
                net.one97.paytm.recharge.dth.a.b r8 = r7.this$0
                java.util.List r8 = r8.s
                if (r8 == 0) goto L_0x00f8
                java.util.Collection r8 = (java.util.Collection) r8
                if (r8 == 0) goto L_0x00f8
                boolean r1 = r8.isEmpty()
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x00f8
                java.util.List r8 = (java.util.List) r8
                net.one97.paytm.recharge.dth.a.b r1 = r7.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r1.l
                if (r2 == 0) goto L_0x00f5
                net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r2 = r2.getExtnAttrs()
                if (r2 == 0) goto L_0x00f5
                java.lang.String r0 = r2.getRecentTempType()
            L_0x00f5:
                net.one97.paytm.recharge.dth.a.b.a((net.one97.paytm.recharge.dth.a.b) r1, (java.util.List) r8, (java.lang.String) r0)
            L_0x00f8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.b.c.invoke(net.one97.paytm.recharge.model.v4.Data):void");
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRCategoryData f62663a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c f62664b;

            a(CJRCategoryData cJRCategoryData, c cVar) {
                this.f62663a = cJRCategoryData;
                this.f62664b = cVar;
            }

            public final void run() {
                b.b(this.f62664b.this$0, this.f62663a);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Bundle bundle) {
            k.c(bundle, "bundle");
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    static {
        String simpleName = b.class.getSimpleName();
        k.a((Object) simpleName, "FJRDTHExistingUserFragment::class.java.simpleName");
        y = simpleName;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:30|31|(1:33)|34|(1:36)(1:37)|(4:39|(1:41)(1:42)|(1:44)|45)|46|(1:48)) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r0 != null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r0.finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        r0 = new android.content.Intent(getActivity(), net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class);
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        if (r1 != null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        r1 = r1.getIntent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0092, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        if (r1 != null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0095, code lost:
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
        if (r1 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        r1 = r1.getIntent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a0, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
        if (r1 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a6, code lost:
        r0.putExtras(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        r0.setFlags(603979776);
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b2, code lost:
        if (r1 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b4, code lost:
        r1.startActivity(r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.os.Bundle r6 = r5.getArguments()
            java.lang.String r0 = "mRechargeItem"
            if (r6 == 0) goto L_0x0047
            java.lang.String r1 = "recharge_item"
            java.io.Serializable r1 = r6.getSerializable(r1)
            if (r1 == 0) goto L_0x003f
            net.one97.paytm.common.entity.CJRItem r1 = (net.one97.paytm.common.entity.CJRItem) r1
            r5.f62661g = r1
            net.one97.paytm.common.entity.CJRItem r1 = r5.f62661g
            if (r1 != 0) goto L_0x001e
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x001e:
            boolean r2 = r1 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0033
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r1
            java.lang.String r1 = r1.getOrigin()
            java.lang.String r2 = "deeplinking"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r3)
            if (r1 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            r5.o = r3
            java.lang.String r1 = "is_recharge_tabs_flow"
            boolean r6 = r6.getBoolean(r1, r4)
            r5.t = r6
            goto L_0x0047
        L_0x003f:
            kotlin.u r6 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem"
            r6.<init>(r0)
            throw r6
        L_0x0047:
            r6 = 0
            net.one97.paytm.common.entity.CJRItem r1 = r5.f62661g     // Catch:{ Exception -> 0x00e6 }
            if (r1 != 0) goto L_0x004f
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00e6 }
        L_0x004f:
            if (r1 == 0) goto L_0x00f0
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x0071 }
            if (r0 == 0) goto L_0x006b
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x0071 }
            if (r0 != 0) goto L_0x0060
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0071 }
        L_0x0060:
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0)     // Catch:{ Exception -> 0x0071 }
            java.lang.Class<net.one97.paytm.recharge.dth.c.a> r1 = net.one97.paytm.recharge.dth.c.a.class
            androidx.lifecycle.ai r0 = r0.a(r1)     // Catch:{ Exception -> 0x0071 }
            goto L_0x006c
        L_0x006b:
            r0 = r6
        L_0x006c:
            net.one97.paytm.recharge.dth.c.a r0 = (net.one97.paytm.recharge.dth.c.a) r0     // Catch:{ Exception -> 0x0071 }
            r5.f62660f = r0     // Catch:{ Exception -> 0x0071 }
            goto L_0x00b7
        L_0x0071:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x007a
            r0.finish()     // Catch:{ Exception -> 0x00e6 }
        L_0x007a:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00e6 }
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()     // Catch:{ Exception -> 0x00e6 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x00e6 }
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00e6 }
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()     // Catch:{ Exception -> 0x00e6 }
            if (r1 == 0) goto L_0x0092
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x0093
        L_0x0092:
            r1 = r6
        L_0x0093:
            if (r1 == 0) goto L_0x00a9
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()     // Catch:{ Exception -> 0x00e6 }
            if (r1 == 0) goto L_0x00a0
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00a1
        L_0x00a0:
            r1 = r6
        L_0x00a1:
            if (r1 != 0) goto L_0x00a6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00e6 }
        L_0x00a6:
            r0.putExtras(r1)     // Catch:{ Exception -> 0x00e6 }
        L_0x00a9:
            r1 = 603979776(0x24000000, float:2.7755576E-17)
            r0.setFlags(r1)     // Catch:{ Exception -> 0x00e6 }
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()     // Catch:{ Exception -> 0x00e6 }
            if (r1 == 0) goto L_0x00b7
            r1.startActivity(r0)     // Catch:{ Exception -> 0x00e6 }
        L_0x00b7:
            net.one97.paytm.recharge.dth.c.a r0 = r5.f62660f     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00f0
            net.one97.paytm.recharge.dth.c.a r0 = r5.f62660f     // Catch:{ Exception -> 0x00e6 }
            if (r0 != 0) goto L_0x00c2
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00e6 }
        L_0x00c2:
            net.one97.paytm.recharge.common.h.b r0 = (net.one97.paytm.recharge.common.h.b) r0     // Catch:{ Exception -> 0x00e6 }
            r5.a((net.one97.paytm.recharge.common.h.b) r0)     // Catch:{ Exception -> 0x00e6 }
            net.one97.paytm.recharge.dth.c.a r0 = r5.f62660f     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00d6
            net.one97.paytm.recharge.dth.a.b$b r1 = new net.one97.paytm.recharge.dth.a.b$b     // Catch:{ Exception -> 0x00e6 }
            r2 = r5
            net.one97.paytm.recharge.dth.a.b r2 = (net.one97.paytm.recharge.dth.a.b) r2     // Catch:{ Exception -> 0x00e6 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00e6 }
            r0.b(r1)     // Catch:{ Exception -> 0x00e6 }
        L_0x00d6:
            net.one97.paytm.recharge.dth.c.a r0 = r5.f62660f     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x00f0
            java.lang.String r1 = "getCategory"
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x00e6 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r6, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r6)     // Catch:{ Exception -> 0x00e6 }
            r0.b(r1, r2)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00f0
        L_0x00e6:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 == 0) goto L_0x00f0
            r0.finish()
        L_0x00f0:
            net.one97.paytm.recharge.dth.c.a r0 = r5.f62660f
            if (r0 == 0) goto L_0x00f6
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.Data<net.one97.paytm.recharge.model.v4.CJRCategoryData>> r6 = r0.x
        L_0x00f6:
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            net.one97.paytm.recharge.dth.a.b$c r0 = new net.one97.paytm.recharge.dth.a.b$c
            r0.<init>(r5)
            kotlin.g.a.b r0 = (kotlin.g.a.b) r0
            net.one97.paytm.recharge.common.utils.g.a(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.b.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dth_existing_user_fragment, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        LiveData liveData;
        List<? extends CJRFrequentOrder> list;
        CJRRecentOrderV8 cJRRecentOrderV8;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        k.a((Object) toolbar, "toolbar");
        String str = "";
        toolbar.setTitle((CharSequence) str);
        if (!this.t) {
            Toolbar toolbar2 = (Toolbar) b(R.id.toolbar);
            k.a((Object) toolbar2, "toolbar");
            a(toolbar2);
        }
        if (this.o) {
            RelativeLayout relativeLayout = (RelativeLayout) b(R.id.lyt_loading);
            k.a((Object) relativeLayout, "lyt_loading");
            ai.a(relativeLayout);
        }
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        Object obj = null;
        if (aVar != null) {
            liveData = aVar.f61414g;
        } else {
            liveData = null;
        }
        if (!(liveData == null || (list = (List) liveData.getValue()) == null)) {
            this.s = list;
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                CJRRecentOrderV8.a aVar2 = new CJRRecentOrderV8.a();
                String string = getString(R.string.recent_header);
                k.a((Object) string, "getString(R.string.recent_header)");
                CJRRecentOrderV8.a a2 = aVar2.a(string);
                a2.l = false;
                a2.f61848a = true;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 <= 0; i2++) {
                    CJRFrequentOrder cJRFrequentOrder = new CJRFrequentOrder();
                    cJRFrequentOrder.setViewType("shimmer");
                    arrayList.add(cJRFrequentOrder);
                }
                CJRRecentOrderV8.a a3 = a2.a((List<? extends CJRFrequentOrder>) arrayList);
                a3.f61930h = true;
                CJRItem cJRItem = this.f62661g;
                if (cJRItem == null) {
                    k.a("mRechargeItem");
                }
                a3.o = cJRItem != null ? cJRItem.getCategoryId() : null;
                a3.n = false;
                CJRRecentOrderV8.a a4 = a3.a(CJRRecentOrderV8.b.DTH.ordinal());
                a4.f61927e = this;
                a4.f61929g = this;
                this.p = a4;
                if (getActivity() != null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    Context context = activity;
                    CJRRecentOrderV8.a aVar3 = this.p;
                    if (aVar3 == null) {
                        k.a();
                    }
                    this.q = new CJRRecentOrderV8(context, aVar3);
                    ((LinearLayout) b(R.id.container_lyt)).addView(this.q);
                }
                if (!this.t && (cJRRecentOrderV8 = this.q) != null) {
                    ViewGroup.LayoutParams layoutParams = cJRRecentOrderV8 != null ? cJRRecentOrderV8.getLayoutParams() : null;
                    if (layoutParams != null) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, com.paytm.utility.b.c(20), 0, 0);
                        CJRRecentOrderV8 cJRRecentOrderV82 = this.q;
                        if (cJRRecentOrderV82 != null) {
                            cJRRecentOrderV82.setLayoutParams(layoutParams2);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    k.a();
                }
                k.a((Object) activity2, "activity!!");
                this.r = new CJRDTHNewRechargeView(activity2, this);
                ((LinearLayout) b(R.id.container_lyt)).addView(this.r);
            }
        }
        Context context2 = getContext();
        CJRItem cJRItem2 = this.f62661g;
        if (cJRItem2 == null) {
            k.a("mRechargeItem");
        }
        String categoryId = cJRItem2.getCategoryId();
        if (categoryId == null) {
            categoryId = str;
        }
        if (!az.c(context2, categoryId)) {
            Context context3 = getContext();
            j childFragmentManager = getChildFragmentManager();
            k.a((Object) childFragmentManager, "childFragmentManager");
            CJRPromosViewV8.b bVar = new CJRPromosViewV8.b();
            String string2 = getString(R.string.title_mobile_promos_landing_screen);
            k.a((Object) string2, "getString(R.string.title…le_promos_landing_screen)");
            CJRPromosViewV8.b a5 = bVar.a(string2);
            a5.f61914d = getString(R.string.promo_action_copy);
            CJRItem cJRItem3 = this.f62661g;
            if (cJRItem3 == null) {
                k.a("mRechargeItem");
            }
            String categoryId2 = cJRItem3.getCategoryId();
            if (categoryId2 != null) {
                str = categoryId2;
            }
            CJRPromosViewV8 cJRPromosViewV8 = new CJRPromosViewV8(context3, childFragmentManager, a5.a(true, str).a((l.b) this), this);
            this.n = cJRPromosViewV8.getErrorListener();
            cJRPromosViewV8.e();
            ((LinearLayout) b(R.id.container_lyt)).addView(cJRPromosViewV8);
            ViewGroup.LayoutParams layoutParams3 = cJRPromosViewV8.getLayoutParams();
            if (layoutParams3 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
                layoutParams4.setMargins(0, com.paytm.utility.b.c(15), 0, 0);
                cJRPromosViewV8.setLayoutParams(layoutParams4);
                this.v = cJRPromosViewV8;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        } else if (getActivity() != null) {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                k.a();
            }
            k.a((Object) activity3, "activity!!");
            CJRItem cJRItem4 = this.f62661g;
            if (cJRItem4 == null) {
                k.a("mRechargeItem");
            }
            String categoryId3 = cJRItem4.getCategoryId();
            if (categoryId3 == null) {
                categoryId3 = str;
            }
            String b2 = az.b(categoryId3);
            CJRItem cJRItem5 = this.f62661g;
            if (cJRItem5 == null) {
                k.a("mRechargeItem");
            }
            String categoryId4 = cJRItem5.getCategoryId();
            String str2 = categoryId4 == null ? str : categoryId4;
            int i3 = R.color.color_f3f7f8;
            int i4 = R.color.color_8f969c;
            net.one97.paytm.recharge.dth.c.a aVar4 = this.f62660f;
            if (aVar4 != null) {
                obj = aVar4.b();
            }
            this.x = new CJRBaseRechargePromotionalBannerViewV2(activity3, b2, true, str2, i3, i4, String.valueOf(obj), (String) null, 128);
            ((LinearLayout) b(R.id.container_lyt)).addView(this.x);
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setActionType(ACTION_TYPE.DELETE_RECENT.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        if (aVar != null) {
            aVar.a("delete_recents", cJRFrequentOrder, (Object) a2);
        }
        CJRRecentOrderV8 cJRRecentOrderV8 = this.q;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.a(cJRFrequentOrder, i2);
        }
    }

    public final void b(CJRFrequentOrder cJRFrequentOrder, int i2) {
        k.c(cJRFrequentOrder, "item");
        Bundle bundle = new Bundle();
        bundle.putInt("key_position", i2);
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        if (aVar != null) {
            aVar.a((Fragment) this, cJRFrequentOrder, bundle);
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel, int i2) {
        k.c(cJRFrequentOrder, "item");
        k.c(cJRAutomaticSubscriptionItemModel, "subscriptionModel");
        Bundle bundle = new Bundle();
        bundle.putInt("key_position", i2);
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        if (aVar != null) {
            aVar.a((Fragment) this, cJRFrequentOrder, cJRAutomaticSubscriptionItemModel, bundle);
        }
    }

    public final void c(CJRFrequentOrder cJRFrequentOrder, int i2) {
        HashMap<String, String> hashMap;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        String str;
        k.c(cJRFrequentOrder, "item");
        if (SystemClock.elapsedRealtime() - this.u >= 2000) {
            this.u = SystemClock.elapsedRealtime();
            if (getParentFragment() != null) {
                net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
                if (!(aVar == null || (dVar = aVar.v) == null)) {
                    net.one97.paytm.recharge.dth.c.a aVar2 = this.f62660f;
                    if (aVar2 == null || (str = aVar2.a()) == null) {
                        str = "";
                    }
                    String str2 = ab.f61496a;
                    k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, str, "recents_selected", (Object) null, (Object) null, str2, (Object) null, (Object) null, 108);
                }
                net.one97.paytm.recharge.dth.c.a aVar3 = this.f62660f;
                if (!(aVar3 == null || (hashMap = aVar3.m) == null)) {
                    hashMap.clear();
                    Map map = hashMap;
                    String productID = cJRFrequentOrder.getProductID();
                    k.a((Object) productID, "item.productID");
                    map.put(CLPConstants.PRODUCT_ID, productID);
                    map.put("isFromRecents", "1");
                    CJRFrequentOrderProduct frequentOrderProduct = cJRFrequentOrder.getFrequentOrderProduct();
                    k.a((Object) frequentOrderProduct, "item.frequentOrderProduct");
                    hashMap.putAll(frequentOrderProduct.getAttributes());
                    hashMap.putAll(cJRFrequentOrder.getConfiguration());
                    if (cJRFrequentOrder.getFrequentOrderProduct() != null) {
                        CJRFrequentOrderProduct frequentOrderProduct2 = cJRFrequentOrder.getFrequentOrderProduct();
                        k.a((Object) frequentOrderProduct2, "item.frequentOrderProduct");
                        if (!TextUtils.isEmpty(frequentOrderProduct2.getFrequentOrderBrand())) {
                            CJRFrequentOrderProduct frequentOrderProduct3 = cJRFrequentOrder.getFrequentOrderProduct();
                            k.a((Object) frequentOrderProduct3, "item.frequentOrderProduct");
                            String frequentOrderBrand = frequentOrderProduct3.getFrequentOrderBrand();
                            k.a((Object) frequentOrderBrand, "item.frequentOrderProduct.frequentOrderBrand");
                            map.put(StringSet.operator, frequentOrderBrand);
                        }
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.b().setProductId(cJRFrequentOrder.getProductID());
                }
                if (this.t) {
                    Fragment parentFragment = getParentFragment();
                    if (parentFragment != null) {
                        ((f) parentFragment).b(this.l, (CJRSelectedGroupItem) null);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                    }
                } else {
                    Fragment parentFragment2 = getParentFragment();
                    if (parentFragment2 != null) {
                        ((f) parentFragment2).a(this.l, (CJRSelectedGroupItem) null);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                    }
                }
                x xVar = x.f47997a;
            }
        }
    }

    public final void g() {
        if (this.t && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).g();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    public final void h() {
        if (this.t && (getActivity() instanceof net.one97.paytm.recharge.common.e.y)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((net.one97.paytm.recharge.common.e.y) activity).h();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62667a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.metro.c.p f62668b;

        f(b bVar, net.one97.paytm.recharge.metro.c.p pVar) {
            this.f62667a = bVar;
            this.f62668b = pVar;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f62667a.u >= 2000) {
                this.f62667a.u = SystemClock.elapsedRealtime();
                if (com.paytm.utility.b.c((Context) this.f62667a.getActivity())) {
                    net.one97.paytm.recharge.dth.c.a aVar = this.f62667a.f62660f;
                    if (aVar != null) {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        aVar.b("getCategory", net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.GET_CATEGORY_CATALOG, ERROR_TYPE.UNDEFINED));
                    }
                    this.f62667a.getChildFragmentManager().a().a((Fragment) this.f62668b).b();
                    FrameLayout frameLayout = (FrameLayout) this.f62667a.b(R.id.no_network_lyt);
                    if (frameLayout != null) {
                        ai.b(frameLayout);
                    }
                    if ((this.f62667a.getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.f62667a.t) {
                        FragmentActivity activity = this.f62667a.getActivity();
                        if (activity != null) {
                            ((AJRRechargeUtilityActivity) activity).i();
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
                    }
                }
            }
        }
    }

    public final void a(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(str, "promo");
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        if (aVar != null && (dVar = aVar.v) != null) {
            net.one97.paytm.recharge.dth.c.a aVar2 = this.f62660f;
            Object b2 = aVar2 != null ? aVar2.b() : null;
            if (b2 == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, b2, "promocode_copy_clicked", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public final void a(CJRAggsItem cJRAggsItem, int i2) {
        HashMap<String, String> hashMap;
        List<GroupAttributesItem> attributes;
        GroupAttributesItem groupAttributesItem;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(cJRAggsItem, "operatorItem");
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        String str = null;
        if (!(aVar == null || (dVar = aVar.v) == null)) {
            net.one97.paytm.recharge.dth.c.a aVar2 = this.f62660f;
            Object b2 = aVar2 != null ? aVar2.b() : null;
            if (b2 == null) {
                k.a();
            }
            String lowerCase = "/Dth".toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            String value = cJRAggsItem.getValue();
            if (value == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, b2, "Select Operator_dropdown_item_selected", lowerCase, value, (Object) null, "manual", "repeat user", 16);
        }
        net.one97.paytm.recharge.common.c.e eVar = this.k;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (getParentFragment() != null) {
            net.one97.paytm.recharge.dth.c.a aVar3 = this.f62660f;
            if (!(aVar3 == null || (hashMap = aVar3.m) == null)) {
                hashMap.clear();
                CJRCategoryData cJRCategoryData = this.l;
                String name = (cJRCategoryData == null || (attributes = cJRCategoryData.getAttributes()) == null || (groupAttributesItem = attributes.get(0)) == null) ? null : groupAttributesItem.getName();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(cJRAggsItem.getValue())) {
                    Map map = hashMap;
                    if (name == null) {
                        k.a();
                    }
                    String value2 = cJRAggsItem.getValue();
                    if (value2 == null) {
                        k.a();
                    }
                    map.put(name, value2);
                }
                if (cJRAggsItem.getProductList() != null && (!cJRAggsItem.getProductList().isEmpty())) {
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    CJRRechargeErrorModel b3 = net.one97.paytm.recharge.widgets.c.d.b();
                    List<CJRProductsItem> productList = cJRAggsItem.getProductList();
                    if (productList == null) {
                        k.a();
                    }
                    b3.setProductId(String.valueOf(productList.get(0).getProductId()));
                }
            }
            if (this.t) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    f fVar = (f) parentFragment;
                    CJRCategoryData cJRCategoryData2 = this.l;
                    CJRNextGroupData cJRNextGroupData = this.m;
                    if (cJRNextGroupData != null) {
                        str = cJRNextGroupData.getGroupName();
                    }
                    fVar.b(cJRCategoryData2, new CJRSelectedGroupItem(str, "inputGrouping", cJRAggsItem.getDisplayValue(), cJRAggsItem.getValue(), i2));
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                }
            } else {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    f fVar2 = (f) parentFragment2;
                    CJRCategoryData cJRCategoryData3 = this.l;
                    CJRNextGroupData cJRNextGroupData2 = this.m;
                    if (cJRNextGroupData2 != null) {
                        str = cJRNextGroupData2.getGroupName();
                    }
                    fVar2.a(cJRCategoryData3, new CJRSelectedGroupItem(str, "inputGrouping", cJRAggsItem.getDisplayValue(), cJRAggsItem.getValue(), i2));
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                }
            }
            x xVar = x.f47997a;
        }
    }

    public final LiveData<CJROffers> a(String str, Object obj) {
        k.c(str, "tag");
        net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
        if (aVar != null) {
            return aVar.c("fetch_promo", "", obj);
        }
        return null;
    }

    public final void b() {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        List<CJRAggsItem> list = this.f62662i;
        if (list != null) {
            Collection collection = list;
            if (collection != null && (!collection.isEmpty())) {
                List list2 = (List) collection;
                net.one97.paytm.recharge.dth.c.a aVar = this.f62660f;
                Object obj = null;
                if (!(aVar == null || (dVar2 = aVar.v) == null)) {
                    net.one97.paytm.recharge.dth.c.a aVar2 = this.f62660f;
                    Object b2 = aVar2 != null ? aVar2.b() : null;
                    if (b2 == null) {
                        k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, b2, "new_recharge_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                }
                CJRSelectOperatorViewV8.b bVar = new CJRSelectOperatorViewV8.b();
                String string = getString(R.string.select_operator);
                k.a((Object) string, "getString(R.string.select_operator)");
                CJRSelectOperatorViewV8.b a2 = bVar.a(string);
                CJRSelectOperatorViewV8.a aVar3 = CJRSelectOperatorViewV8.f61954f;
                a2.f61970h = CJRSelectOperatorViewV8.k;
                a2.f61964b = false;
                this.k = new net.one97.paytm.recharge.common.c.e(a2.a((List<CJRAggsItem>) kotlin.a.k.c(list2)).a((o) this));
                net.one97.paytm.recharge.common.c.e eVar = this.k;
                if (eVar != null) {
                    j childFragmentManager = getChildFragmentManager();
                    k.a((Object) childFragmentManager, "childFragmentManager");
                    eVar.show(childFragmentManager, "select_operator");
                }
                net.one97.paytm.recharge.dth.c.a aVar4 = this.f62660f;
                if (!(aVar4 == null || (dVar = aVar4.v) == null)) {
                    net.one97.paytm.recharge.dth.c.a aVar5 = this.f62660f;
                    if (aVar5 != null) {
                        obj = aVar5.b();
                    }
                    Object obj2 = obj;
                    if (obj2 == null) {
                        k.a();
                    }
                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, "operator_selection_popup", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                }
            }
            x xVar = x.f47997a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r0 = r7.getErrorType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, com.paytm.network.model.NetworkCustomError r7, java.lang.Object r8) {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 == 0) goto L_0x006f
            boolean r0 = r5.isAdded()
            if (r0 != 0) goto L_0x000d
            goto L_0x006f
        L_0x000d:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.l
            r1 = 100
            if (r0 != 0) goto L_0x003f
            if (r7 == 0) goto L_0x0020
            com.paytm.network.model.NetworkCustomError$ErrorType r0 = r7.getErrorType()
            if (r0 == 0) goto L_0x0020
            java.lang.String r0 = r0.name()
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r3 = 1
            java.lang.String r4 = "TimeOutError"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r3)
            if (r0 == 0) goto L_0x003f
            int r6 = net.one97.paytm.recharge.R.id.no_network_lyt
            android.view.View r6 = r5.b((int) r6)
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x003e
            net.one97.paytm.recharge.dth.a.b$d r7 = new net.one97.paytm.recharge.dth.a.b$d
            r7.<init>(r5)
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r6.postDelayed(r7, r1)
        L_0x003e:
            return
        L_0x003f:
            boolean r0 = r7 instanceof net.one97.paytm.recharge.common.utils.at
            if (r0 == 0) goto L_0x004b
            net.one97.paytm.recharge.common.e.n r0 = r5.n
            if (r0 == 0) goto L_0x004a
            r0.a(r6, r7, r8)
        L_0x004a:
            return
        L_0x004b:
            boolean r0 = r7 instanceof net.one97.paytm.recharge.common.utils.as
            if (r0 == 0) goto L_0x006c
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r5.l
            if (r0 != 0) goto L_0x0068
            int r6 = net.one97.paytm.recharge.R.id.no_network_lyt
            android.view.View r6 = r5.b((int) r6)
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0067
            net.one97.paytm.recharge.dth.a.b$e r7 = new net.one97.paytm.recharge.dth.a.b$e
            r7.<init>(r5)
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r6.postDelayed(r7, r1)
        L_0x0067:
            return
        L_0x0068:
            super.a((java.lang.String) r6, (com.paytm.network.model.NetworkCustomError) r7, (java.lang.Object) r8)
            return
        L_0x006c:
            super.a((java.lang.String) r6, (com.paytm.network.model.NetworkCustomError) r7, (java.lang.Object) r8)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.b.a(java.lang.String, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62665a;

        d(b bVar) {
            this.f62665a = bVar;
        }

        public final void run() {
            b.e(this.f62665a);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f62666a;

        e(b bVar) {
            this.f62666a = bVar;
        }

        public final void run() {
            b.e(this.f62666a);
        }
    }

    public final void c() {
        CJRPromosViewV8 cJRPromosViewV8 = this.v;
        if (cJRPromosViewV8 != null) {
            cJRPromosViewV8.g();
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        CJRRecentOrderV8 cJRRecentOrderV8 = this.q;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.e();
        }
        this.q = null;
        this.k = null;
        u();
    }

    public static final /* synthetic */ void b(b bVar, CJRCategoryData cJRCategoryData) {
        CJRCategoryDataHelper cJRCategoryDataHelper;
        RelativeLayout relativeLayout = (RelativeLayout) bVar.b(R.id.lyt_loading);
        if (relativeLayout != null) {
            ai.b(relativeLayout);
        }
        Object obj = null;
        if (bVar.t) {
            Toolbar toolbar = (Toolbar) bVar.b(R.id.toolbar);
            if (toolbar != null) {
                toolbar.setVisibility(8);
            }
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                collapsingToolbarLayout.setVisibility(8);
            }
            AppBarLayout appBarLayout = (AppBarLayout) bVar.b(R.id.app_bar_layout);
            if (appBarLayout != null) {
                appBarLayout.setVisibility(8);
            }
        } else {
            NestedScrollView nestedScrollView = (NestedScrollView) bVar.b(R.id.nested_scroll_view);
            ViewGroup.LayoutParams layoutParams = nestedScrollView != null ? nestedScrollView.getLayoutParams() : null;
            if (!(layoutParams instanceof CoordinatorLayout.d)) {
                layoutParams = null;
            }
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
            if (dVar != null) {
                dVar.a((CoordinatorLayout.Behavior) new AppBarLayout.ScrollingViewBehavior(bVar.getContext(), (AttributeSet) null));
                NestedScrollView nestedScrollView2 = (NestedScrollView) bVar.b(R.id.nested_scroll_view);
                if (nestedScrollView2 != null) {
                    nestedScrollView2.setLayoutParams(dVar);
                }
            }
        }
        CollapsingToolbarLayout collapsingToolbarLayout2 = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout2 != null) {
            collapsingToolbarLayout2.setTitle(cJRCategoryData.getCategoryHeader());
        }
        CollapsingToolbarLayout collapsingToolbarLayout3 = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout3 != null) {
            CollapsingToolbarLayout collapsingToolbarLayout4 = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
            k.a((Object) collapsingToolbarLayout4, "collapsing_toolbar");
            collapsingToolbarLayout3.setExpandedTitleTypeface(Typeface.create(collapsingToolbarLayout4.getExpandedTitleTypeface(), 1));
        }
        CollapsingToolbarLayout collapsingToolbarLayout5 = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
        if (collapsingToolbarLayout5 != null) {
            CollapsingToolbarLayout collapsingToolbarLayout6 = (CollapsingToolbarLayout) bVar.b(R.id.collapsing_toolbar);
            k.a((Object) collapsingToolbarLayout6, "collapsing_toolbar");
            collapsingToolbarLayout5.setCollapsedTitleTypeface(Typeface.create(collapsingToolbarLayout6.getExpandedTitleTypeface(), 1));
        }
        net.one97.paytm.recharge.dth.c.a aVar = bVar.f62660f;
        bVar.m = (aVar == null || (cJRCategoryDataHelper = aVar.f61409b) == null) ? null : cJRCategoryDataHelper.getNextGroupItemData();
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel b2 = net.one97.paytm.recharge.widgets.c.d.b();
        net.one97.paytm.recharge.dth.c.a aVar2 = bVar.f62660f;
        String valueOf = String.valueOf(aVar2 != null ? aVar2.b() : null);
        if (valueOf == null) {
            valueOf = "";
        }
        b2.setScreenName(valueOf);
        CJRNextGroupData cJRNextGroupData = bVar.m;
        if (cJRNextGroupData != null) {
            GroupAttributesItem groupAttributesItem = cJRNextGroupData.getGroupAttributesItem();
            bVar.j = groupAttributesItem != null ? groupAttributesItem.getDisplayName() : null;
            bVar.f62662i = cJRNextGroupData.getAggs();
        }
        if (bVar.getParentFragment() instanceof f) {
            CJRExtensionAttributes extnAttrs = cJRCategoryData.getExtnAttrs();
            String bbpsLogoUrl = extnAttrs != null ? extnAttrs.getBbpsLogoUrl() : null;
            CJRExtensionAttributes extnAttrs2 = cJRCategoryData.getExtnAttrs();
            if (extnAttrs2 != null && extnAttrs2.isBBPSCategoryLogoEnabled() && !TextUtils.isEmpty(bbpsLogoUrl) && URLUtil.isValidUrl(bbpsLogoUrl)) {
                Fragment parentFragment = bVar.getParentFragment();
                if (!(parentFragment instanceof f)) {
                    parentFragment = null;
                }
                f fVar = (f) parentFragment;
                if (fVar != null) {
                    fVar.a(bbpsLogoUrl);
                }
            }
        }
        CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV2 = bVar.x;
        if (cJRBaseRechargePromotionalBannerViewV2 != null) {
            String verticalId = cJRCategoryData.getVerticalId();
            if (verticalId == null) {
                verticalId = "";
            }
            cJRBaseRechargePromotionalBannerViewV2.setVerticalID(verticalId);
        }
        CJRBaseRechargePromotionalBannerViewV2 cJRBaseRechargePromotionalBannerViewV22 = bVar.x;
        if (cJRBaseRechargePromotionalBannerViewV22 != null) {
            net.one97.paytm.recharge.dth.c.a aVar3 = bVar.f62660f;
            if (aVar3 != null) {
                obj = aVar3.b();
            }
            cJRBaseRechargePromotionalBannerViewV22.setScreenNameParams(String.valueOf(obj));
        }
    }

    public static final /* synthetic */ void a(b bVar, List list, String str) {
        Object obj;
        CJRRecentOrderV8 cJRRecentOrderV8 = bVar.q;
        if (cJRRecentOrderV8 != null) {
            boolean z2 = str != null && kotlin.m.p.a(str, "1", true);
            k.c(list, "recents");
            CJRRecentOrderV8.a aVar = cJRRecentOrderV8.f61921f;
            if (aVar != null) {
                aVar.a((List<? extends CJRFrequentOrder>) list);
            }
            cJRRecentOrderV8.getOrNotifyTitleWithViewAll();
            CJRRecentOrderV8.a aVar2 = cJRRecentOrderV8.f61921f;
            if (aVar2 != null) {
                aVar2.q = z2;
            }
            p pVar = cJRRecentOrderV8.f61920e;
            if (pVar != null) {
                CJRRecentOrderV8.a aVar3 = cJRRecentOrderV8.f61921f;
                k.c(aVar3, "pOptions");
                pVar.f60649b = aVar3;
                pVar.notifyDataSetChanged();
            }
            try {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) cJRRecentOrderV8.b(R.id.shimmer_lyt);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.b();
                }
            } catch (Exception unused) {
            }
        }
        if (!bVar.w) {
            Context context = bVar.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.dth.c.a aVar4 = bVar.f62660f;
            if (aVar4 == null || (obj = aVar4.b()) == null) {
                obj = "";
            }
            Integer valueOf = Integer.valueOf(list.size());
            String str2 = ab.f61496a;
            k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "recents_shown", "", valueOf, str2, (Object) null, (Object) null, 96);
            bVar.w = true;
        }
    }

    public static final /* synthetic */ void e(b bVar) {
        if ((bVar.getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !bVar.t) {
            FragmentActivity activity = bVar.getActivity();
            if (activity != null) {
                ((AJRRechargeUtilityActivity) activity).b("");
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
            }
        }
        net.one97.paytm.recharge.metro.c.p pVar = new net.one97.paytm.recharge.metro.c.p();
        pVar.a(new f(bVar, pVar));
        bVar.getChildFragmentManager();
        am.a(bVar.getChildFragmentManager().a().a(R.id.no_network_lyt, pVar, ""));
        FrameLayout frameLayout = (FrameLayout) bVar.b(R.id.no_network_lyt);
        if (frameLayout != null) {
            ai.a(frameLayout);
        }
    }
}
