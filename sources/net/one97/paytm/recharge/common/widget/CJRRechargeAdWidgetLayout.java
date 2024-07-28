package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.viewpager.widget.ViewPager;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.a.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.fragment.n;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRRechargeAdWidgetLayout extends FrameLayout implements ai {

    /* renamed from: a  reason: collision with root package name */
    public static final a f61932a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private View f61933b = LayoutInflater.from(getContext()).inflate(R.layout.layout_recharge_ads_widget, this, true);

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f61934c;

    /* renamed from: d  reason: collision with root package name */
    private CirclePageIndicator f61935d;

    /* renamed from: e  reason: collision with root package name */
    private ConstraintLayout f61936e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f61937f = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRHomePageLayoutV2 f61938g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRHomePageItem> f61939h;

    /* renamed from: i  reason: collision with root package name */
    private final j f61940i;
    private String j;
    private final String k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRRechargeAdWidgetLayout(Context context, j jVar, String str, String str2) {
        super(context);
        k.c(context, "context");
        k.c(jVar, "fm");
        k.c(str, "requestedUrl");
        k.c(str2, "gaScreenName");
        this.f61940i = jVar;
        this.j = str;
        this.k = str2;
        View view = this.f61933b;
        this.f61934c = view != null ? (ViewPager) view.findViewById(R.id.viewPager) : null;
        View view2 = this.f61933b;
        this.f61935d = view2 != null ? (CirclePageIndicator) view2.findViewById(R.id.view_page_indicator) : null;
        View view3 = this.f61933b;
        this.f61936e = view3 != null ? (ConstraintLayout) view3.findViewById(R.id.container_lyt) : null;
        if (!TextUtils.isEmpty(this.j)) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.STOREFRONT_ADS_WIDGET.name());
            }
            String str3 = this.j;
            if (com.paytm.utility.b.c(getContext())) {
                p.create(new c(this, str3, a2, "fetch_ads_widget_api")).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new d(this));
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final j getFm() {
        return this.f61940i;
    }

    public final String getGaScreenName() {
        return this.k;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class c<T> implements s<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRechargeAdWidgetLayout f61946a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61947b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f61948c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f61949d;

        c(CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout, String str, Object obj, String str2) {
            this.f61946a = cJRRechargeAdWidgetLayout;
            this.f61947b = str;
            this.f61948c = obj;
            this.f61949d = str2;
        }

        public final void subscribe(r<CJRHomePageV2> rVar) {
            CRUFlowModel flowName;
            k.a((Object) rVar, "emitter");
            if (!rVar.isDisposed()) {
                String a2 = CJRRechargeAdWidgetLayout.a(this.f61946a, this.f61947b);
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Context context = this.f61946a.getContext();
                k.a((Object) context, "context");
                String storeFrontAdApiBody = cJRRechargeUtilities.getStoreFrontAdApiBody(context);
                HashMap hashMap = new HashMap();
                String n = com.paytm.utility.b.n(this.f61946a.getContext());
                String a3 = com.paytm.utility.d.a(this.f61946a.getContext());
                if (!TextUtils.isEmpty(n) && com.paytm.utility.b.r(this.f61946a.getContext())) {
                    k.a((Object) n, "userId");
                    hashMap.put("user_id", n);
                }
                if (!TextUtils.isEmpty(a3)) {
                    k.a((Object) a3, "ssoToken");
                    hashMap.put(AppConstants.SSO_TOKEN, a3);
                }
                Object obj = this.f61948c;
                if ((obj instanceof CJRRechargeErrorModel) && (flowName = ((CJRRechargeErrorModel) obj).getFlowName()) != null) {
                    flowName.setRequestBody(storeFrontAdApiBody);
                }
                net.one97.paytm.recharge.common.f.c cVar = new net.one97.paytm.recharge.common.f.c(this.f61949d, a2, (ai) this.f61946a, (IJRPaytmDataModel) new CJRHomePageV2(), (Map<String, String>) null, (Map<String, String>) hashMap, storeFrontAdApiBody, this.f61948c);
                this.f61946a.getContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(cVar);
            }
        }
    }

    public static final class d implements w<CJRHomePageV2> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRechargeAdWidgetLayout f61950a;

        public final void onComplete() {
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            k.c(cVar, "d");
        }

        d(CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout) {
            this.f61950a = cJRRechargeAdWidgetLayout;
        }

        public final /* synthetic */ void onNext(Object obj) {
            k.c((CJRHomePageV2) obj, "t");
        }

        public final void onError(Throwable th) {
            k.c(th, "e");
            this.f61950a.b();
        }
    }

    public static final class e implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f61951a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRRechargeAdWidgetLayout f61952b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61953c;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        e(ArrayList arrayList, CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout, String str) {
            this.f61951a = arrayList;
            this.f61952b = cJRRechargeAdWidgetLayout;
            this.f61953c = str;
        }

        public final void onPageSelected(int i2) {
            CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout = this.f61952b;
            Object obj = this.f61951a.get(0);
            k.a(obj, "views[0]");
            String layout = ((CJRHomePageLayoutV2) obj).getLayout();
            k.a((Object) layout, "views[0].layout");
            cJRRechargeAdWidgetLayout.a(i2, layout);
        }
    }

    public final void a() {
        String str;
        ViewPager viewPager = this.f61934c;
        int currentItem = viewPager != null ? viewPager.getCurrentItem() : 0;
        CJRHomePageLayoutV2 cJRHomePageLayoutV2 = this.f61938g;
        if (cJRHomePageLayoutV2 == null || (str = cJRHomePageLayoutV2.getLayout()) == null) {
            str = "";
        }
        a(currentItem, str);
    }

    /* access modifiers changed from: private */
    public final void a(int i2, String str) {
        try {
            ArrayList<CJRHomePageItem> arrayList = this.f61939h;
            if (arrayList == null) {
                k.a();
            }
            CJRHomePageItem cJRHomePageItem = arrayList.get(i2);
            k.a((Object) cJRHomePageItem, "pageItems!![position]");
            CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            if (!cJRHomePageItem2.isItemViewed()) {
                CJRRechargeUtilities.INSTANCE.debugLog("AdsWidget: isVisible");
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                Context context = getContext();
                k.a((Object) context, "context");
                net.one97.paytm.recharge.di.helper.b.a(cJRHomePageItem2, i2, "", "", context, this.k, str);
                cJRHomePageItem2.setItemViewed();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        ConstraintLayout constraintLayout = this.f61936e;
        if (constraintLayout != null) {
            net.one97.paytm.recharge.common.utils.ai.b(constraintLayout);
        }
    }

    public final class b extends o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRRechargeAdWidgetLayout f61941a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<CJRHomePageItem> f61942b;

        /* renamed from: c  reason: collision with root package name */
        private final int f61943c;

        /* renamed from: d  reason: collision with root package name */
        private final String f61944d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f61945e;

        public final Parcelable saveState() {
            return null;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout, j jVar, ArrayList<CJRHomePageItem> arrayList, int i2, String str, boolean z) {
            super(jVar);
            k.c(jVar, "fm");
            k.c(arrayList, "pageItemList");
            k.c(str, "requestID");
            this.f61941a = cJRRechargeAdWidgetLayout;
            this.f61942b = arrayList;
            this.f61943c = i2;
            this.f61944d = str;
            this.f61945e = z;
        }

        public final Fragment getItem(int i2) {
            CJRHomePageItem cJRHomePageItem = this.f61942b.get(i2);
            k.a((Object) cJRHomePageItem, "pageItemList[position]");
            CJRHomePageItem cJRHomePageItem2 = cJRHomePageItem;
            CJRHomePageLayoutV2 a2 = this.f61941a.f61938g;
            String str = null;
            cJRHomePageItem2.setParentName(a2 != null ? a2.getName() : null);
            CJRHomePageLayoutV2 a3 = this.f61941a.f61938g;
            cJRHomePageItem2.setParentItem(a3 != null ? a3.getName() : null);
            CJRHomePageLayoutV2 a4 = this.f61941a.f61938g;
            if (a4 != null) {
                str = a4.getLayout();
            }
            cJRHomePageItem2.setLayoutType(str);
            cJRHomePageItem2.setWidgetPosition(i2);
            cJRHomePageItem2.setmContainerInstanceID(CJRRechargeAdWidgetLayout.a(this.f61941a.f61938g));
            cJRHomePageItem2.setSourceInfo(CJRRechargeAdWidgetLayout.b(this.f61941a.f61938g));
            n.a aVar = n.f61333a;
            CJRHomePageItem cJRHomePageItem3 = this.f61942b.get(i2);
            k.a((Object) cJRHomePageItem3, "pageItemList[position]");
            CJRHomePageItem cJRHomePageItem4 = cJRHomePageItem3;
            int i3 = this.f61943c;
            String str2 = this.f61944d;
            boolean z = this.f61945e;
            String gaScreenName = this.f61941a.getGaScreenName();
            k.c(cJRHomePageItem4, "pageItem");
            k.c(str2, "requestId");
            k.c(gaScreenName, "gaScreenName");
            n nVar = new n();
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", cJRHomePageItem4);
            bundle.putInt("layoutId", i3);
            bundle.putString("requestId", str2);
            bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
            bundle.putBoolean("roundedCorner", z);
            bundle.putString("gaScreenName", gaScreenName);
            nVar.setArguments(bundle);
            return nVar;
        }

        public final int getCount() {
            return this.f61942b.size();
        }

        public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            try {
                super.restoreState(parcelable, classLoader);
            } catch (Exception e2) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            }
        }
    }

    public static String a(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        String str;
        if (cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getDatasources() == null || cJRHomePageLayoutV2.getDatasources().size() <= 0 || (str = cJRHomePageLayoutV2.getDatasources().get(0).getmContainerInstanceID()) == null) {
            return "";
        }
        return str;
    }

    public static HashMap<String, Object> b(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!(cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getDatasources() == null || cJRHomePageLayoutV2.getDatasources().size() <= 0)) {
            Map map = hashMap;
            String str = cJRHomePageLayoutV2.getDatasources().get(0).getmContainerInstanceID();
            if (str == null) {
                str = "";
            }
            map.put("source_container_instance_id", str);
            String str2 = cJRHomePageLayoutV2.getDatasources().get(0).getmContainerID();
            if (str2 == null) {
                str2 = "";
            }
            map.put("source_container_id", str2);
        }
        return hashMap;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0042: MOVE  (r12v9 java.util.Collection) = 
          (r12v8 java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2>)
        
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    public final void a_(java.lang.String r11, com.paytm.network.model.IJRPaytmDataModel r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r13 = "tag"
            kotlin.g.b.k.c(r11, r13)
            int r13 = r11.hashCode()
            r0 = 298233011(0x11c6acb3, float:3.1345326E-28)
            if (r13 == r0) goto L_0x0011
            goto L_0x0229
        L_0x0011:
            java.lang.String r13 = "fetch_ads_widget_api"
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x0229
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r11 = "AdsWidget api response received"
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r11)
            android.content.Context r11 = r10.getContext()
            r13 = 1
            r0 = 0
            if (r11 == 0) goto L_0x0200
            androidx.fragment.app.j r11 = r10.f61940i
            boolean r11 = r11.h()
            if (r11 != 0) goto L_0x0200
            if (r12 == 0) goto L_0x01f8
            net.one97.paytm.common.entity.shopping.CJRHomePageV2 r12 = (net.one97.paytm.common.entity.shopping.CJRHomePageV2) r12
            net.one97.paytm.common.entity.shopping.CJRContext r11 = r12.cjrContext
            if (r11 == 0) goto L_0x003c
            java.lang.String r11 = r11.mrequestid
            if (r11 != 0) goto L_0x003e
        L_0x003c:
            java.lang.String r11 = ""
        L_0x003e:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2> r12 = r12.mPage
            if (r12 == 0) goto L_0x01f7
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01f7
            boolean r1 = r12.isEmpty()
            r1 = r1 ^ r13
            if (r1 == 0) goto L_0x01f7
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r12 = r12.get(r0)
            java.lang.String r1 = "pages[0]"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2 r12 = (net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2) r12
            java.util.ArrayList r12 = r12.getHomePageLayoutList()
            if (r12 == 0) goto L_0x01f7
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01f7
            boolean r1 = r12.isEmpty()
            r1 = r1 ^ r13
            if (r1 == 0) goto L_0x01f7
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r1 = r12.get(r0)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r1
            r10.f61938g = r1
            java.lang.Object r1 = r12.get(r0)
            java.lang.String r2 = "views[0]"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r1
            java.lang.String r1 = r1.getLayout()
            java.lang.String r3 = "views[0].layout"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            androidx.viewpager.widget.ViewPager r3 = r10.f61934c
            java.lang.String r4 = "thin-banner"
            java.lang.String r5 = "h1-banner"
            java.lang.String r6 = "new-thin-banner"
            java.lang.String r7 = "new-h1-banner"
            if (r3 == 0) goto L_0x0143
            r3 = 12
            int r3 = com.paytm.utility.b.c((int) r3)
            androidx.viewpager.widget.ViewPager r8 = r10.f61934c
            if (r8 != 0) goto L_0x00a5
            kotlin.g.b.k.a()
        L_0x00a5:
            r8.setPageMargin(r3)
            androidx.constraintlayout.widget.c r8 = new androidx.constraintlayout.widget.c
            r8.<init>()
            androidx.constraintlayout.widget.ConstraintLayout r9 = r10.f61936e
            r8.b((androidx.constraintlayout.widget.ConstraintLayout) r9)
            int r9 = r1.hashCode()
            switch(r9) {
                case -1010852669: goto L_0x0122;
                case 326236211: goto L_0x010b;
                case 388274352: goto L_0x00f4;
                case 562539744: goto L_0x00bb;
                default: goto L_0x00b9;
            }
        L_0x00b9:
            goto L_0x0139
        L_0x00bb:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0139
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x00c8
            kotlin.g.b.k.a()
        L_0x00c8:
            int r1 = r1.getId()
            java.lang.String r9 = "360:101"
            r8.a((int) r1, (java.lang.String) r9)
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x00d8
            kotlin.g.b.k.a()
        L_0x00d8:
            int r1 = r1.getId()
            r9 = 6
            r8.a((int) r1, (int) r9, (int) r3)
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x00e7
            kotlin.g.b.k.a()
        L_0x00e7:
            int r1 = r1.getId()
            r9 = 7
            r8.a((int) r1, (int) r9, (int) r3)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r10.f61937f = r1
            goto L_0x013e
        L_0x00f4:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0139
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x0101
            kotlin.g.b.k.a()
        L_0x0101:
            int r1 = r1.getId()
            java.lang.String r3 = "5:3"
            r8.a((int) r1, (java.lang.String) r3)
            goto L_0x013e
        L_0x010b:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0139
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x0118
            kotlin.g.b.k.a()
        L_0x0118:
            int r1 = r1.getId()
            java.lang.String r3 = "3:1"
            r8.a((int) r1, (java.lang.String) r3)
            goto L_0x013e
        L_0x0122:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0139
            androidx.viewpager.widget.ViewPager r1 = r10.f61934c
            if (r1 != 0) goto L_0x012f
            kotlin.g.b.k.a()
        L_0x012f:
            int r1 = r1.getId()
            java.lang.String r3 = "16:9"
            r8.a((int) r1, (java.lang.String) r3)
            goto L_0x013e
        L_0x0139:
            r1 = 8
            r10.setVisibility(r1)
        L_0x013e:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r10.f61936e
            r8.c((androidx.constraintlayout.widget.ConstraintLayout) r1)
        L_0x0143:
            java.lang.Object r1 = r12.get(r0)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r1
            java.lang.String r1 = r1.getLayout()
            r3 = -1
            if (r1 == 0) goto L_0x0180
            int r8 = r1.hashCode()
            switch(r8) {
                case -1010852669: goto L_0x0176;
                case 326236211: goto L_0x016d;
                case 388274352: goto L_0x0164;
                case 562539744: goto L_0x015b;
                default: goto L_0x015a;
            }
        L_0x015a:
            goto L_0x0180
        L_0x015b:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0180
            int r1 = net.one97.paytm.recharge.R.layout.layout_type_thin_banner
            goto L_0x017e
        L_0x0164:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x0180
            int r1 = net.one97.paytm.recharge.R.layout.layout_type_h1_banner
            goto L_0x017e
        L_0x016d:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0180
            int r1 = net.one97.paytm.recharge.R.layout.layout_type_new_thin_banner
            goto L_0x017e
        L_0x0176:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0180
            int r1 = net.one97.paytm.recharge.R.layout.layout_type_new_h1_banner
        L_0x017e:
            r5 = r1
            goto L_0x0181
        L_0x0180:
            r5 = -1
        L_0x0181:
            if (r5 == r3) goto L_0x01f7
            java.lang.Object r1 = r12.get(r0)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2 r1 = (net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2) r1
            java.util.ArrayList r1 = r1.getHomePageItemList()
            r10.f61939h = r1
            net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout$b r8 = new net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout$b
            androidx.fragment.app.j r3 = r10.f61940i
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r4 = r10.f61939h
            if (r4 != 0) goto L_0x019d
            kotlin.g.b.k.a()
        L_0x019d:
            java.lang.Boolean r1 = r10.f61937f
            if (r1 == 0) goto L_0x01a7
            boolean r0 = r1.booleanValue()
            r7 = r0
            goto L_0x01a8
        L_0x01a7:
            r7 = 0
        L_0x01a8:
            r1 = r8
            r2 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            androidx.viewpager.widget.ViewPager r0 = r10.f61934c
            if (r0 == 0) goto L_0x01b7
            androidx.viewpager.widget.a r8 = (androidx.viewpager.widget.a) r8
            r0.setAdapter(r8)
        L_0x01b7:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r0 = r10.f61939h
            if (r0 != 0) goto L_0x01be
            kotlin.g.b.k.a()
        L_0x01be:
            int r0 = r0.size()
            if (r0 <= r13) goto L_0x01ce
            net.one97.paytm.common.widgets.CirclePageIndicator r13 = r10.f61935d
            if (r13 == 0) goto L_0x01d7
            android.view.View r13 = (android.view.View) r13
            net.one97.paytm.recharge.common.utils.ai.a(r13)
            goto L_0x01d7
        L_0x01ce:
            net.one97.paytm.common.widgets.CirclePageIndicator r13 = r10.f61935d
            if (r13 == 0) goto L_0x01d7
            android.view.View r13 = (android.view.View) r13
            net.one97.paytm.recharge.common.utils.ai.b(r13)
        L_0x01d7:
            net.one97.paytm.common.widgets.CirclePageIndicator r13 = r10.f61935d
            if (r13 == 0) goto L_0x01e0
            androidx.viewpager.widget.ViewPager r0 = r10.f61934c
            r13.setViewPager(r0)
        L_0x01e0:
            net.one97.paytm.common.widgets.CirclePageIndicator r13 = r10.f61935d
            if (r13 == 0) goto L_0x01ee
            net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout$e r0 = new net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout$e
            r0.<init>(r12, r10, r11)
            androidx.viewpager.widget.ViewPager$e r0 = (androidx.viewpager.widget.ViewPager.e) r0
            r13.setOnPageChangeListener(r0)
        L_0x01ee:
            androidx.constraintlayout.widget.ConstraintLayout r11 = r10.f61936e
            if (r11 == 0) goto L_0x01f7
            android.view.View r11 = (android.view.View) r11
            net.one97.paytm.recharge.common.utils.ai.a(r11)
        L_0x01f7:
            return
        L_0x01f8:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageV2"
            r11.<init>(r12)
            throw r11
        L_0x0200:
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "AdsWidget api response received : Context isNULL "
            r11.<init>(r12)
            android.content.Context r12 = r10.getContext()
            if (r12 != 0) goto L_0x0210
            goto L_0x0211
        L_0x0210:
            r13 = 0
        L_0x0211:
            r11.append(r13)
            java.lang.String r12 = " | FM-Destroyed is "
            r11.append(r12)
            androidx.fragment.app.j r12 = r10.f61940i
            boolean r12 = r12.h()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r11)
        L_0x0229:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        if (str.hashCode() == 298233011 && str.equals("fetch_ads_widget_api")) {
            b();
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || kotlin.m.p.a(errorMsg)) {
                    cJRRechargeErrorModel.setErrorMsg("error while showing STOREFRONT_ADS_WIDGET");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }
    }

    public static final /* synthetic */ String a(CJRRechargeAdWidgetLayout cJRRechargeAdWidgetLayout, String str) {
        return str + com.paytm.utility.c.a(cJRRechargeAdWidgetLayout.getContext(), false) + "&device=android&resolution=" + com.paytm.utility.b.U(cJRRechargeAdWidgetLayout.getContext());
    }
}
