package net.one97.paytm.recharge.dth.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.e.f;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.o;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.am;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.common.widget.CJRPromosViewV8;
import net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8;
import net.one97.paytm.recharge.dth.a.b;
import net.one97.paytm.recharge.metro.c.p;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRExtensionAttributes;
import net.one97.paytm.recharge.model.v4.CJRNextGroupData;
import net.one97.paytm.recharge.model.v4.CJRProductsItem;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.model.v4.GroupAttributesItem;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class d extends a implements q, l.b, f, o {

    /* renamed from: f  reason: collision with root package name */
    public static final a f62670f = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public net.one97.paytm.recharge.dth.c.a f62671g;

    /* renamed from: h  reason: collision with root package name */
    private CJRItem f62672h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CJRCategoryData f62673i;
    private CJRNextGroupData j;
    /* access modifiers changed from: private */
    public boolean k;
    private n l;
    private CJRSelectOperatorViewV8 m;
    /* access modifiers changed from: private */
    public boolean n;
    private CJRPromosViewV8 o;
    /* access modifiers changed from: private */
    public long p;
    /* access modifiers changed from: private */
    public RelativeLayout q;
    /* access modifiers changed from: private */
    public LottieAnimationView r;
    private final String s = "dth";
    /* access modifiers changed from: private */
    public CJRBaseRechargePromotionalBannerViewV2 t;
    private HashMap u;

    public final void a(int i2) {
    }

    public final boolean a() {
        return true;
    }

    public final View b(int i2) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.u.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void l() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        u();
    }

    public final void u() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final /* synthetic */ class c extends i implements kotlin.g.a.q<String, NetworkCustomError, Object, x> {
        c(d dVar) {
            super(3, dVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final kotlin.k.d getOwner() {
            return y.b(d.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            ((d) this.receiver).a(str, networkCustomError, obj);
        }
    }

    /* renamed from: net.one97.paytm.recharge.dth.a.d$d  reason: collision with other inner class name */
    static final class C1214d extends kotlin.g.b.l implements kotlin.g.a.b<Data<? extends CJRCategoryData>, x> {
        final /* synthetic */ d this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1214d(d dVar) {
            super(1);
            this.this$0 = dVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Data<CJRCategoryData>) (Data) obj);
            return x.f47997a;
        }

        public final void invoke(Data<CJRCategoryData> data) {
            DataState dataState;
            CJRCategoryData data2;
            boolean z;
            String str;
            HashMap<String, String> hashMap;
            Object obj = null;
            if (data != null) {
                dataState = data.getDataState();
            } else {
                dataState = null;
            }
            if (dataState != null) {
                int i2 = e.f62679a[dataState.ordinal()];
                if (i2 == 1) {
                    this.this$0.c();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.this$0.c(0);
                    }
                } else if (!this.this$0.k) {
                    this.this$0.c(10);
                }
            }
            if (data != null && (data2 = data.getData()) != null) {
                if (!this.this$0.n) {
                    d dVar = this.this$0;
                    Toolbar toolbar = (Toolbar) dVar.b(R.id.toolbar);
                    k.a((Object) toolbar, "toolbar");
                    dVar.a(toolbar);
                }
                try {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    Context context = this.this$0.getContext();
                    StringBuilder sb = new StringBuilder("/");
                    net.one97.paytm.recharge.dth.c.a c2 = this.this$0.f62671g;
                    sb.append(c2 != null ? c2.b() : null);
                    net.one97.paytm.recharge.di.helper.b.a(context, sb.toString());
                } catch (Throwable unused) {
                }
                this.this$0.f62673i = data2;
                net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel b2 = net.one97.paytm.recharge.widgets.c.d.b();
                net.one97.paytm.recharge.dth.c.a c3 = this.this$0.f62671g;
                String valueOf = String.valueOf(c3 != null ? c3.b() : null);
                if (valueOf == null) {
                    valueOf = "";
                }
                b2.setScreenName(valueOf);
                d.e(this.this$0);
                net.one97.paytm.recharge.dth.c.a c4 = this.this$0.f62671g;
                if (c4 == null || (hashMap = c4.m) == null) {
                    z = true;
                } else {
                    d dVar3 = this.this$0;
                    CJRCategoryData d2 = dVar3.f62673i;
                    String url = d.f(this.this$0).getURL();
                    k.a((Object) url, "mRechargeItem.url");
                    z = dVar3.a(hashMap, d2, url);
                }
                if (!z) {
                    if (this.this$0.n) {
                        Fragment parentFragment = this.this$0.getParentFragment();
                        if (parentFragment != null) {
                            ((f) parentFragment).b(this.this$0.f62673i, (CJRSelectedGroupItem) null);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                        }
                    } else {
                        Fragment parentFragment2 = this.this$0.getParentFragment();
                        if (parentFragment2 != null) {
                            ((f) parentFragment2).a(this.this$0.f62673i, (CJRSelectedGroupItem) null);
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
                        }
                    }
                    new Handler().postDelayed(new a(data2, this), 600);
                } else {
                    if (this.this$0.getParentFragment() instanceof f) {
                        CJRExtensionAttributes extnAttrs = data2.getExtnAttrs();
                        String bbpsLogoUrl = extnAttrs != null ? extnAttrs.getBbpsLogoUrl() : null;
                        CJRExtensionAttributes extnAttrs2 = data2.getExtnAttrs();
                        if (extnAttrs2 != null && extnAttrs2.isBBPSCategoryLogoEnabled() && !TextUtils.isEmpty(bbpsLogoUrl) && URLUtil.isValidUrl(bbpsLogoUrl)) {
                            Fragment parentFragment3 = this.this$0.getParentFragment();
                            if (!(parentFragment3 instanceof f)) {
                                parentFragment3 = null;
                            }
                            f fVar = (f) parentFragment3;
                            if (fVar != null) {
                                fVar.a(bbpsLogoUrl);
                            }
                        }
                    }
                    this.this$0.c(10);
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.this$0.b(R.id.collapsing_toolbar);
                    if (collapsingToolbarLayout != null) {
                        collapsingToolbarLayout.setTitle(data2.getCategoryHeader());
                    }
                    CollapsingToolbarLayout collapsingToolbarLayout2 = (CollapsingToolbarLayout) this.this$0.b(R.id.collapsing_toolbar);
                    if (collapsingToolbarLayout2 != null) {
                        CollapsingToolbarLayout collapsingToolbarLayout3 = (CollapsingToolbarLayout) this.this$0.b(R.id.collapsing_toolbar);
                        k.a((Object) collapsingToolbarLayout3, "collapsing_toolbar");
                        collapsingToolbarLayout2.setExpandedTitleTypeface(Typeface.create(collapsingToolbarLayout3.getExpandedTitleTypeface(), 1));
                    }
                    CollapsingToolbarLayout collapsingToolbarLayout4 = (CollapsingToolbarLayout) this.this$0.b(R.id.collapsing_toolbar);
                    if (collapsingToolbarLayout4 != null) {
                        CollapsingToolbarLayout collapsingToolbarLayout5 = (CollapsingToolbarLayout) this.this$0.b(R.id.collapsing_toolbar);
                        k.a((Object) collapsingToolbarLayout5, "collapsing_toolbar");
                        collapsingToolbarLayout4.setCollapsedTitleTypeface(Typeface.create(collapsingToolbarLayout5.getExpandedTitleTypeface(), 1));
                    }
                }
                CJRBaseRechargePromotionalBannerViewV2 g2 = this.this$0.t;
                if (g2 != null) {
                    CJRCategoryData d3 = this.this$0.f62673i;
                    if (d3 == null || (str = d3.getVerticalId()) == null) {
                        str = "";
                    }
                    g2.setVerticalID(str);
                }
                CJRBaseRechargePromotionalBannerViewV2 g3 = this.this$0.t;
                if (g3 != null) {
                    net.one97.paytm.recharge.dth.c.a c5 = this.this$0.f62671g;
                    if (c5 != null) {
                        obj = c5.b();
                    }
                    g3.setScreenNameParams(String.valueOf(obj));
                }
            }
        }

        /* renamed from: net.one97.paytm.recharge.dth.a.d$d$a */
        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRCategoryData f62675a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1214d f62676b;

            a(CJRCategoryData cJRCategoryData, C1214d dVar) {
                this.f62675a = cJRCategoryData;
                this.f62676b = dVar;
            }

            public final void run() {
                this.f62676b.this$0.c(10);
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.f62676b.this$0.b(R.id.collapsing_toolbar);
                if (collapsingToolbarLayout != null) {
                    collapsingToolbarLayout.setTitle(this.f62675a.getCategoryHeader());
                }
                CollapsingToolbarLayout collapsingToolbarLayout2 = (CollapsingToolbarLayout) this.f62676b.this$0.b(R.id.collapsing_toolbar);
                if (collapsingToolbarLayout2 != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout3 = (CollapsingToolbarLayout) this.f62676b.this$0.b(R.id.collapsing_toolbar);
                    k.a((Object) collapsingToolbarLayout3, "collapsing_toolbar");
                    collapsingToolbarLayout2.setExpandedTitleTypeface(Typeface.create(collapsingToolbarLayout3.getExpandedTitleTypeface(), 1));
                }
                CollapsingToolbarLayout collapsingToolbarLayout4 = (CollapsingToolbarLayout) this.f62676b.this$0.b(R.id.collapsing_toolbar);
                if (collapsingToolbarLayout4 != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout5 = (CollapsingToolbarLayout) this.f62676b.this$0.b(R.id.collapsing_toolbar);
                    k.a((Object) collapsingToolbarLayout5, "collapsing_toolbar");
                    collapsingToolbarLayout4.setCollapsedTitleTypeface(Typeface.create(collapsingToolbarLayout5.getExpandedTitleTypeface(), 1));
                }
            }
        }
    }

    public static final /* synthetic */ CJRItem f(d dVar) {
        CJRItem cJRItem = dVar.f62672h;
        if (cJRItem == null) {
            k.a("mRechargeItem");
        }
        return cJRItem;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(Bundle bundle) {
            k.c(bundle, "bundle");
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:24|25|(1:27)|28|(1:30)(1:31)|(4:33|(1:35)(1:36)|(1:38)|39)|40|(1:42)) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r0 != null) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        r0.finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r0 = new android.content.Intent(getActivity(), net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class);
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
        if (r1 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007b, code lost:
        r1 = r1.getIntent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
        if (r1 != null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (r1 != null) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        r1 = r1.getIntent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        if (r1 == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        r0.putExtras(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
        r0.setFlags(603979776);
        r1 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        if (r1 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
        r1.startActivity(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d0, code lost:
        r0 = getActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d5, code lost:
        if (r0 != null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d7, code lost:
        r0.finish();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onCreate(r11)
            android.os.Bundle r11 = r10.getArguments()
            if (r11 == 0) goto L_0x003e
            java.lang.String r0 = "recharge_item"
            java.io.Serializable r0 = r11.getSerializable(r0)
            if (r0 == 0) goto L_0x0036
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0
            r10.f62672h = r0
            net.one97.paytm.common.entity.CJRItem r0 = r10.f62672h
            if (r0 != 0) goto L_0x001e
            java.lang.String r1 = "mRechargeItem"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001e:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r2 = 0
            if (r1 == 0) goto L_0x002a
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            boolean r0 = r0.isDeepLinking()
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            r10.k = r0
            java.lang.String r0 = "is_recharge_tabs_flow"
            boolean r11 = r11.getBoolean(r0, r2)
            r10.n = r11
            goto L_0x003e
        L_0x0036:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.CJRItem"
            r11.<init>(r0)
            throw r11
        L_0x003e:
            r11 = 0
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x005f }
            if (r0 == 0) goto L_0x0059
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x005f }
            if (r0 != 0) goto L_0x004e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x005f }
        L_0x004e:
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0)     // Catch:{ Exception -> 0x005f }
            java.lang.Class<net.one97.paytm.recharge.dth.c.a> r1 = net.one97.paytm.recharge.dth.c.a.class
            androidx.lifecycle.ai r0 = r0.a(r1)     // Catch:{ Exception -> 0x005f }
            goto L_0x005a
        L_0x0059:
            r0 = r11
        L_0x005a:
            net.one97.paytm.recharge.dth.c.a r0 = (net.one97.paytm.recharge.dth.c.a) r0     // Catch:{ Exception -> 0x005f }
            r10.f62671g = r0     // Catch:{ Exception -> 0x005f }
            goto L_0x00a5
        L_0x005f:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x00d0 }
            if (r0 == 0) goto L_0x0068
            r0.finish()     // Catch:{ Exception -> 0x00d0 }
        L_0x0068:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00d0 }
            androidx.fragment.app.FragmentActivity r1 = r10.getActivity()     // Catch:{ Exception -> 0x00d0 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Exception -> 0x00d0 }
            java.lang.Class<net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity> r2 = net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity.class
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d0 }
            androidx.fragment.app.FragmentActivity r1 = r10.getActivity()     // Catch:{ Exception -> 0x00d0 }
            if (r1 == 0) goto L_0x0080
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0081
        L_0x0080:
            r1 = r11
        L_0x0081:
            if (r1 == 0) goto L_0x0097
            androidx.fragment.app.FragmentActivity r1 = r10.getActivity()     // Catch:{ Exception -> 0x00d0 }
            if (r1 == 0) goto L_0x008e
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x008f
        L_0x008e:
            r1 = r11
        L_0x008f:
            if (r1 != 0) goto L_0x0094
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00d0 }
        L_0x0094:
            r0.putExtras(r1)     // Catch:{ Exception -> 0x00d0 }
        L_0x0097:
            r1 = 603979776(0x24000000, float:2.7755576E-17)
            r0.setFlags(r1)     // Catch:{ Exception -> 0x00d0 }
            androidx.fragment.app.FragmentActivity r1 = r10.getActivity()     // Catch:{ Exception -> 0x00d0 }
            if (r1 == 0) goto L_0x00a5
            r1.startActivity(r0)     // Catch:{ Exception -> 0x00d0 }
        L_0x00a5:
            net.one97.paytm.recharge.dth.c.a r0 = r10.f62671g     // Catch:{ Exception -> 0x00d0 }
            if (r0 == 0) goto L_0x00da
            r10.f62671g = r0     // Catch:{ Exception -> 0x00d0 }
            r1 = r0
            net.one97.paytm.recharge.common.h.b r1 = (net.one97.paytm.recharge.common.h.b) r1     // Catch:{ Exception -> 0x00d0 }
            r10.a((net.one97.paytm.recharge.common.h.b) r1)     // Catch:{ Exception -> 0x00d0 }
            net.one97.paytm.recharge.dth.c.a r1 = r10.f62671g     // Catch:{ Exception -> 0x00d0 }
            if (r1 == 0) goto L_0x00c0
            net.one97.paytm.recharge.dth.a.d$c r2 = new net.one97.paytm.recharge.dth.a.d$c     // Catch:{ Exception -> 0x00d0 }
            r3 = r10
            net.one97.paytm.recharge.dth.a.d r3 = (net.one97.paytm.recharge.dth.a.d) r3     // Catch:{ Exception -> 0x00d0 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00d0 }
            r1.b(r2)     // Catch:{ Exception -> 0x00d0 }
        L_0x00c0:
            java.lang.String r1 = "getCategory"
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a     // Catch:{ Exception -> 0x00d0 }
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.GET_CATEGORY_CATALOG     // Catch:{ Exception -> 0x00d0 }
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED     // Catch:{ Exception -> 0x00d0 }
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)     // Catch:{ Exception -> 0x00d0 }
            r0.b(r1, r2)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00da
        L_0x00d0:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L_0x00da
            r0.finish()
        L_0x00da:
            android.content.Context r0 = r10.getContext()
            boolean r0 = net.one97.paytm.recharge.common.utils.z.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x014e
            java.lang.String r0 = r10.s
            net.one97.paytm.recharge.dth.c.a r1 = r10.f62671g
            if (r1 == 0) goto L_0x00ef
            java.lang.String r1 = r1.a()
            goto L_0x00f0
        L_0x00ef:
            r1 = r11
        L_0x00f0:
            boolean r1 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r1)
            if (r1 == 0) goto L_0x0103
            net.one97.paytm.recharge.dth.c.a r11 = r10.f62671g
            if (r11 != 0) goto L_0x00fd
            kotlin.g.b.k.a()
        L_0x00fd:
            java.lang.String r0 = r11.a()
        L_0x0101:
            r2 = r0
            goto L_0x0127
        L_0x0103:
            net.one97.paytm.recharge.dth.c.a r1 = r10.f62671g
            if (r1 == 0) goto L_0x0111
            java.lang.Object r1 = r1.b()
            if (r1 == 0) goto L_0x0111
            java.lang.String r11 = r1.toString()
        L_0x0111:
            boolean r11 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r11)
            if (r11 == 0) goto L_0x0101
            net.one97.paytm.recharge.dth.c.a r11 = r10.f62671g
            if (r11 != 0) goto L_0x011e
            kotlin.g.b.k.a()
        L_0x011e:
            java.lang.Object r11 = r11.b()
            java.lang.String r0 = r11.toString()
            goto L_0x0101
        L_0x0127:
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d
            android.content.Context r11 = r10.getContext()
            if (r11 != 0) goto L_0x0132
            kotlin.g.b.k.a()
        L_0x0132:
            java.lang.String r0 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            r1.<init>(r11)
            java.lang.String r6 = net.one97.paytm.recharge.common.utils.ab.f61496a
            java.lang.String r11 = "CJRRechargeUtilityConstant.UTILITY"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r11)
            r7 = 0
            r8 = 0
            r9 = 96
            java.lang.String r3 = "recents_not_shown"
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x014e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.d.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dth_first_time_user, (ViewGroup) null, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.progress_view);
        if (findViewById != null) {
            this.q = (RelativeLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.loading_threedots);
            if (findViewById2 != null) {
                this.r = (LottieAnimationView) findViewById2;
                if (!this.n && com.paytm.utility.b.c((Context) getActivity())) {
                    Toolbar toolbar = (Toolbar) b(R.id.toolbar);
                    k.a((Object) toolbar, "toolbar");
                    a(toolbar);
                }
                if (this.k) {
                    c();
                }
                androidx.lifecycle.y<Data<CJRCategoryData>> yVar = null;
                if (this.n) {
                    Toolbar toolbar2 = (Toolbar) b(R.id.toolbar);
                    k.a((Object) toolbar2, "toolbar");
                    toolbar2.setVisibility(8);
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) b(R.id.collapsing_toolbar);
                    k.a((Object) collapsingToolbarLayout, "collapsing_toolbar");
                    collapsingToolbarLayout.setVisibility(8);
                    AppBarLayout appBarLayout = (AppBarLayout) b(R.id.app_bar_layout);
                    k.a((Object) appBarLayout, "app_bar_layout");
                    appBarLayout.setVisibility(8);
                } else {
                    NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.nested_scroll_view);
                    k.a((Object) nestedScrollView, "nested_scroll_view");
                    ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
                    if (layoutParams != null) {
                        CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                        dVar.a((CoordinatorLayout.Behavior) new AppBarLayout.ScrollingViewBehavior(getContext(), (AttributeSet) null));
                        NestedScrollView nestedScrollView2 = (NestedScrollView) b(R.id.nested_scroll_view);
                        k.a((Object) nestedScrollView2, "nested_scroll_view");
                        nestedScrollView2.setLayoutParams(dVar);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
                    }
                }
                net.one97.paytm.recharge.dth.c.a aVar = this.f62671g;
                if (aVar != null) {
                    yVar = aVar.x;
                }
                g.a(this, yVar, new C1214d(this));
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void a(CJRAggsItem cJRAggsItem, int i2) {
        HashMap<String, String> hashMap;
        List<GroupAttributesItem> attributes;
        GroupAttributesItem groupAttributesItem;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(cJRAggsItem, "operatorItem");
        String str = null;
        try {
            net.one97.paytm.recharge.dth.c.a aVar = this.f62671g;
            if (!(aVar == null || (dVar = aVar.v) == null)) {
                net.one97.paytm.recharge.dth.c.a aVar2 = this.f62671g;
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
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, b2, "Select Operator_dropdown_item_selected", lowerCase, value, (Object) null, "manual", "new user", 16);
            }
        } catch (Throwable unused) {
        }
        if (getParentFragment() != null) {
            net.one97.paytm.recharge.dth.c.a aVar3 = this.f62671g;
            if (!(aVar3 == null || (hashMap = aVar3.m) == null)) {
                hashMap.clear();
                CJRCategoryData cJRCategoryData = this.f62673i;
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
            if (this.n) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    f fVar = (f) parentFragment;
                    CJRCategoryData cJRCategoryData2 = this.f62673i;
                    CJRNextGroupData cJRNextGroupData = this.j;
                    if (cJRNextGroupData != null) {
                        str = cJRNextGroupData.getGroupName();
                    }
                    fVar.b(cJRCategoryData2, new CJRSelectedGroupItem(str, "inputGrouping", cJRAggsItem.getDisplayValue(), cJRAggsItem.getValue(), i2));
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
            }
            Fragment parentFragment2 = getParentFragment();
            if (parentFragment2 != null) {
                f fVar2 = (f) parentFragment2;
                CJRCategoryData cJRCategoryData3 = this.f62673i;
                CJRNextGroupData cJRNextGroupData2 = this.j;
                if (cJRNextGroupData2 != null) {
                    str = cJRNextGroupData2.getGroupName();
                }
                fVar2.a(cJRCategoryData3, new CJRSelectedGroupItem(str, "inputGrouping", cJRAggsItem.getDisplayValue(), cJRAggsItem.getValue(), i2));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.dth.fragment.FJRDTHLandingFragment");
        }
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        StringBuilder sb = new StringBuilder();
        b.a aVar4 = b.f62659h;
        sb.append(b.y);
        sb.append(" parent fragment is null");
        net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
    }

    public final void a(String str) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        k.c(str, "promo");
        try {
            net.one97.paytm.recharge.dth.c.a aVar = this.f62671g;
            if (aVar != null && (dVar = aVar.v) != null) {
                net.one97.paytm.recharge.dth.c.a aVar2 = this.f62671g;
                Object b2 = aVar2 != null ? aVar2.b() : null;
                if (b2 == null) {
                    k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, b2, "promocode_copy_clicked", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
            }
        } catch (Throwable unused) {
        }
    }

    public final LiveData<CJROffers> a(String str, Object obj) {
        k.c(str, "tag");
        net.one97.paytm.recharge.dth.c.a aVar = this.f62671g;
        if (aVar != null) {
            return aVar.c(str, "", obj);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r0 = r5.getErrorType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4, com.paytm.network.model.NetworkCustomError r5, java.lang.Object r6) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            net.one97.paytm.recharge.model.v4.CJRCategoryData r0 = r3.f62673i
            if (r0 != 0) goto L_0x002b
            if (r5 == 0) goto L_0x0018
            com.paytm.network.model.NetworkCustomError$ErrorType r0 = r5.getErrorType()
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.name()
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            r1 = 1
            java.lang.String r2 = "TimeOutError"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x002b
            r4 = 10
            r3.c((int) r4)
            r3.d()
            return
        L_0x002b:
            boolean r0 = r5 instanceof net.one97.paytm.recharge.common.utils.at
            if (r0 == 0) goto L_0x0037
            net.one97.paytm.recharge.common.e.n r0 = r3.l
            if (r0 == 0) goto L_0x0036
            r0.a(r4, r5, r6)
        L_0x0036:
            return
        L_0x0037:
            boolean r0 = r5 instanceof net.one97.paytm.recharge.common.utils.as
            if (r0 == 0) goto L_0x003f
            r3.d()
            return
        L_0x003f:
            super.a((java.lang.String) r4, (com.paytm.network.model.NetworkCustomError) r5, (java.lang.Object) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.d.a(java.lang.String, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    public final void b() {
        CJRPromosViewV8 cJRPromosViewV8 = this.o;
        if (cJRPromosViewV8 != null) {
            cJRPromosViewV8.g();
        }
    }

    private final void d() {
        if ((getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.n) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRRechargeUtilityActivity) activity).b("");
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
            }
        }
        p pVar = new p();
        pVar.a(new e(this, pVar));
        getChildFragmentManager();
        am.a(getChildFragmentManager().a().a(R.id.no_network_lyt, pVar, ""));
        FrameLayout frameLayout = (FrameLayout) b(R.id.no_network_lyt);
        if (frameLayout != null) {
            ai.a(frameLayout);
        }
        c(10);
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f62677a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f62678b;

        e(d dVar, p pVar) {
            this.f62677a = dVar;
            this.f62678b = pVar;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f62677a.p >= 2000) {
                this.f62677a.p = SystemClock.elapsedRealtime();
                if (com.paytm.utility.b.c((Context) this.f62677a.getActivity())) {
                    net.one97.paytm.recharge.dth.c.a c2 = this.f62677a.f62671g;
                    if (c2 != null) {
                        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                        c2.b("getCategory", net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.GET_CATEGORY_CATALOG, ERROR_TYPE.UNDEFINED));
                    }
                    this.f62677a.getChildFragmentManager().a().a((Fragment) this.f62678b).b();
                    FrameLayout frameLayout = (FrameLayout) this.f62677a.b(R.id.no_network_lyt);
                    k.a((Object) frameLayout, "no_network_lyt");
                    ai.b(frameLayout);
                    if ((this.f62677a.getActivity() instanceof net.one97.paytm.recharge.common.e.y) && !this.f62677a.n) {
                        FragmentActivity activity = this.f62677a.getActivity();
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

    public final void c() {
        ba.a(this.r);
        ba.a(0, (View) this.q);
    }

    public final void c(int i2) {
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null && relativeLayout != null && relativeLayout.getVisibility() == 0) {
            new Handler().postDelayed(new b(this), (long) i2);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f62674a;

        b(d dVar) {
            this.f62674a = dVar;
        }

        public final void run() {
            ba.a(8, (View) this.f62674a.q);
            ba.b(this.f62674a.r);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0033: MOVE  (r4v2 java.util.Collection) = 
          (r4v1 java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    public static final /* synthetic */ void e(net.one97.paytm.recharge.dth.a.d r15) {
        /*
            int r0 = net.one97.paytm.recharge.R.id.container_lyt
            android.view.View r0 = r15.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            net.one97.paytm.recharge.dth.c.a r0 = r15.f62671g
            r1 = 0
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r0 = r0.f61409b
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r0 = r0.getNextGroupItemData()
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            r15.j = r0
            net.one97.paytm.recharge.model.v4.CJRNextGroupData r0 = r15.j
            r2 = 1
            if (r0 == 0) goto L_0x00ba
            net.one97.paytm.recharge.model.v4.GroupAttributesItem r3 = r0.getGroupAttributesItem()
            if (r3 == 0) goto L_0x002c
            java.lang.String r3 = r3.getDisplayName()
            goto L_0x002d
        L_0x002c:
            r3 = r1
        L_0x002d:
            java.util.List r4 = r0.getAggs()
            if (r4 == 0) goto L_0x00ba
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x00ba
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r2
            if (r4 == 0) goto L_0x00ba
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8 r4 = new net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8
            android.content.Context r5 = r15.getContext()
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r6 = new net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b
            r6.<init>()
            if (r3 != 0) goto L_0x004d
            java.lang.String r3 = "Select an operator"
        L_0x004d:
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r3 = r6.a((java.lang.String) r3)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$a r6 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.f61954f
            int r6 = net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8.k
            r3.f61970h = r6
            r3.f61971i = r2
            r6 = 0
            r3.f61964b = r6
            r3.k = r6
            java.util.List r0 = r0.getAggs()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.a.k.c(r0)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r0 = r3.a((java.util.List<net.one97.paytm.recharge.model.v4.CJRAggsItem>) r0)
            r3 = r15
            net.one97.paytm.recharge.common.e.o r3 = (net.one97.paytm.recharge.common.e.o) r3
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8$b r0 = r0.a((net.one97.paytm.recharge.common.e.o) r3)
            r4.<init>(r5, r0)
            r15.m = r4
            int r0 = net.one97.paytm.recharge.R.id.container_lyt
            android.view.View r0 = r15.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8 r3 = r15.m
            android.view.View r3 = (android.view.View) r3
            r0.addView(r3)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8 r0 = r15.m
            if (r0 == 0) goto L_0x0091
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
        L_0x0091:
            if (r1 == 0) goto L_0x00b2
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            int r0 = com.paytm.utility.b.c((int) r6)
            r3 = 15
            int r3 = com.paytm.utility.b.c((int) r3)
            r4 = 10
            int r4 = com.paytm.utility.b.c((int) r4)
            r1.setMargins(r0, r3, r6, r4)
            net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8 r0 = r15.m
            if (r0 == 0) goto L_0x00ba
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r0.setLayoutParams(r1)
            goto L_0x00ba
        L_0x00b2:
            kotlin.u r15 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
            r15.<init>(r0)
            throw r15
        L_0x00ba:
            android.content.Context r0 = r15.getContext()
            net.one97.paytm.common.entity.CJRItem r1 = r15.f62672h
            java.lang.String r3 = "mRechargeItem"
            if (r1 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00c7:
            java.lang.String r1 = r1.getCategoryId()
            java.lang.String r4 = ""
            if (r1 != 0) goto L_0x00d0
            r1 = r4
        L_0x00d0:
            boolean r0 = net.one97.paytm.recharge.common.utils.az.c(r0, r1)
            if (r0 == 0) goto L_0x012d
            androidx.fragment.app.FragmentActivity r0 = r15.getActivity()
            if (r0 == 0) goto L_0x0190
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r0 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2
            androidx.fragment.app.FragmentActivity r6 = r15.getActivity()
            if (r6 != 0) goto L_0x00e7
            kotlin.g.b.k.a()
        L_0x00e7:
            java.lang.String r1 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            net.one97.paytm.common.entity.CJRItem r1 = r15.f62672h
            if (r1 != 0) goto L_0x00f3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00f3:
            java.lang.String r1 = r1.getCategoryId()
            if (r1 != 0) goto L_0x00fa
            r1 = r4
        L_0x00fa:
            java.lang.String r7 = net.one97.paytm.recharge.common.utils.az.b((java.lang.String) r1)
            r8 = 1
            net.one97.paytm.common.entity.CJRItem r1 = r15.f62672h
            if (r1 != 0) goto L_0x0106
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0106:
            java.lang.String r1 = r1.getCategoryId()
            if (r1 != 0) goto L_0x010e
            r9 = r4
            goto L_0x010f
        L_0x010e:
            r9 = r1
        L_0x010f:
            int r10 = net.one97.paytm.recharge.R.color.color_f3f7f8
            int r11 = net.one97.paytm.recharge.R.color.color_8f969c
            r12 = 0
            r13 = 0
            r14 = 192(0xc0, float:2.69E-43)
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r15.t = r0
            int r0 = net.one97.paytm.recharge.R.id.container_lyt
            android.view.View r0 = r15.b((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r15 = r15.t
            android.view.View r15 = (android.view.View) r15
            r0.addView(r15)
            return
        L_0x012d:
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r0 = new net.one97.paytm.recharge.common.widget.CJRPromosViewV8
            android.content.Context r1 = r15.getContext()
            androidx.fragment.app.j r5 = r15.getChildFragmentManager()
            java.lang.String r6 = "childFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r6 = new net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b
            r6.<init>()
            int r7 = net.one97.paytm.recharge.R.string.title_mobile_promos_landing_screen
            java.lang.String r7 = r15.getString(r7)
            java.lang.String r8 = "getString(R.string.title…le_promos_landing_screen)"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r6 = r6.a((java.lang.String) r7)
            int r7 = net.one97.paytm.recharge.R.string.promo_action_copy
            java.lang.String r7 = r15.getString(r7)
            r6.f61914d = r7
            net.one97.paytm.common.entity.CJRItem r7 = r15.f62672h
            if (r7 != 0) goto L_0x015f
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x015f:
            java.lang.String r3 = r7.getCategoryId()
            if (r3 != 0) goto L_0x0166
            r3 = r4
        L_0x0166:
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r2 = r6.a(r2, r3)
            r3 = r15
            net.one97.paytm.recharge.common.a.l$b r3 = (net.one97.paytm.recharge.common.a.l.b) r3
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r2 = r2.a((net.one97.paytm.recharge.common.a.l.b) r3)
            r3 = r15
            net.one97.paytm.recharge.common.e.t r3 = (net.one97.paytm.recharge.common.e.t) r3
            r0.<init>(r1, r5, r2, r3)
            net.one97.paytm.recharge.common.e.n r1 = r0.getErrorListener()
            r15.l = r1
            r0.e()
            int r1 = net.one97.paytm.recharge.R.id.container_lyt
            android.view.View r1 = r15.b((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
            r15.o = r0
        L_0x0190:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.dth.a.d.e(net.one97.paytm.recharge.dth.a.d):void");
    }
}
