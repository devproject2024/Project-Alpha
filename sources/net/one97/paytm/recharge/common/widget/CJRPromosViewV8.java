package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.c.d;
import net.one97.paytm.recharge.common.e.f;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.s;
import net.one97.paytm.recharge.common.e.t;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.at;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.widget.CJRBaseHeaderListLayoutV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.widgets.b.c;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRPromosViewV8 extends CJRBaseHeaderListLayoutV8 implements l.c, n, c<Object> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f61907g = new a((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    public l f61908e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61909f;

    /* renamed from: h  reason: collision with root package name */
    private d f61910h;

    /* renamed from: i  reason: collision with root package name */
    private final j f61911i;
    private final b j;
    private final t k;
    private HashMap l;

    public final View b(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final j getFragmentManager() {
        return this.f61911i;
    }

    public final b getOption() {
        return this.j;
    }

    public final t getPromoCodesOwner() {
        return this.k;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRPromosViewV8(Context context, j jVar, b bVar, t tVar) {
        super(context, bVar);
        int i2;
        k.c(jVar, "fragmentManager");
        k.c(bVar, "option");
        k.c(tVar, "promoCodesOwner");
        this.f61911i = jVar;
        this.j = bVar;
        this.k = tVar;
        setTag("Promo");
        a(this.j.f61912b);
        b(this.j.f61913c);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.container_shimmer_item_promo);
        Integer num = this.j.j;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0 && this.j.k > 0) {
            linearLayout.removeAllViews();
            int i3 = this.j.k;
            for (int i4 = 0; i4 < i3; i4++) {
                LayoutInflater from = LayoutInflater.from(getContext());
                Integer num2 = this.j.j;
                if (num2 == null) {
                    k.a();
                }
                from.inflate(num2.intValue(), linearLayout, true);
            }
        }
        RecyclerView recyclerView = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setVisibility(0);
        this.f61908e = new l(this.j.f61917g, this.j.f61914d, this.j.f61916f, this, this.k, this.j.l);
        if (this.j.f61919i == CJRRecentOrderV8.b.MOBILE_V3) {
            TextView textView = (TextView) b(R.id.txt_title);
            if (textView != null) {
                textView.setBackgroundResource(R.color.v3_promo_title_bg);
            }
            TextView textView2 = (TextView) b(R.id.txt_title);
            if (textView2 != null) {
                textView2.setTextColor(androidx.core.content.b.c(getContext(), R.color.v3_text_2));
            }
            TextView textView3 = (TextView) b(R.id.txt_viewall);
            if (textView3 != null) {
                textView3.setBackgroundResource(R.color.v3_promo_title_bg);
            }
            TextView textView4 = (TextView) b(R.id.txt_viewall);
            k.a((Object) textView4, "txt_viewall");
            textView4.setTypeface(Typeface.create("sans-serif-medium", 0));
            l lVar = this.f61908e;
            if (lVar == null) {
                k.a("adapter");
            }
            lVar.f60591c = false;
            l lVar2 = this.f61908e;
            if (lVar2 == null) {
                k.a("adapter");
            }
            lVar2.f60592d = false;
        }
        RecyclerView recyclerView2 = (RecyclerView) b(R.id.recycler_view);
        k.a((Object) recyclerView2, "recycler_view");
        l lVar3 = this.f61908e;
        if (lVar3 == null) {
            k.a("adapter");
        }
        recyclerView2.setAdapter(lVar3);
        FrameLayout frameLayout = (FrameLayout) b(R.id.no_network_container_promo);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.ArrayList] */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0040: MOVE  (r1v6 java.util.Collection) = (r1v5 java.util.Collection)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void a(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = "tag"
            kotlin.g.b.k.c(r4, r0)
            int r0 = r4.hashCode()
            r1 = 892583754(0x3533bf4a, float:6.696106E-7)
            if (r0 == r1) goto L_0x0011
            goto L_0x00a3
        L_0x0011:
            java.lang.String r0 = "fetch_promo"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x00a3
            boolean r4 = r5 instanceof net.one97.paytm.common.entity.shopping.CJROffers
            r0 = 0
            if (r4 != 0) goto L_0x001f
            r5 = r0
        L_0x001f:
            net.one97.paytm.common.entity.shopping.CJROffers r5 = (net.one97.paytm.common.entity.shopping.CJROffers) r5
            r4 = 1
            if (r5 != 0) goto L_0x0026
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            r3.f61909f = r1
            int r1 = net.one97.paytm.recharge.R.id.shimmer_layout_promo
            android.view.View r1 = r3.b(r1)
            net.one97.paytm.common.views.ShimmerFrameLayout r1 = (net.one97.paytm.common.views.ShimmerFrameLayout) r1
            if (r1 == 0) goto L_0x0038
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.recharge.common.utils.ai.b(r1)
        L_0x0038:
            if (r5 == 0) goto L_0x0088
            java.util.ArrayList r1 = r5.getOfferCodes()
            if (r1 == 0) goto L_0x0088
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0088
            boolean r2 = r1.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0088
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            net.one97.paytm.recharge.common.a.l r4 = r3.f61908e
            if (r4 != 0) goto L_0x0056
            java.lang.String r5 = "adapter"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0056:
            r5 = r1
            java.util.List r5 = (java.util.List) r5
            r4.a((java.util.List<? extends net.one97.paytm.common.entity.shopping.CJROfferCode>) r5)
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r4 = r3.j
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r4 = r4.f61919i
            net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$b r5 = net.one97.paytm.recharge.common.widget.CJRRecentOrderV8.b.MOBILE_V3
            java.lang.String r2 = ""
            if (r4 != r5) goto L_0x0084
            int r4 = r1.size()
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8$b r5 = r3.j
            int r5 = r5.l
            if (r4 <= r5) goto L_0x0080
            android.content.Context r4 = r3.getContext()
            if (r4 == 0) goto L_0x007c
            int r5 = net.one97.paytm.recharge.R.string.v3_action_view_all
            java.lang.String r0 = r4.getString(r5)
        L_0x007c:
            r3.b((java.lang.String) r0)
            return
        L_0x0080:
            r3.b((java.lang.String) r2)
            return
        L_0x0084:
            r3.b((java.lang.String) r2)
            return
        L_0x0088:
            if (r5 == 0) goto L_0x008e
            java.util.ArrayList r0 = r5.getOfferCodes()
        L_0x008e:
            if (r0 == 0) goto L_0x009e
            java.util.ArrayList r5 = r5.getOfferCodes()
            if (r5 == 0) goto L_0x009d
            boolean r5 = r5.isEmpty()
            if (r5 != r4) goto L_0x00a3
            goto L_0x009e
        L_0x009d:
            return
        L_0x009e:
            r4 = 8
            r3.setVisibility(r4)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.widget.CJRPromosViewV8.a(java.lang.String, java.lang.Object):void");
    }

    public final void e() {
        if (this.j.f61915e) {
            try {
                l lVar = this.f61908e;
                if (lVar == null) {
                    k.a("adapter");
                }
                lVar.a((List<? extends CJROfferCode>) new ArrayList());
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_layout_promo);
                if (shimmerFrameLayout != null) {
                    ai.a(shimmerFrameLayout);
                }
                ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) b(R.id.shimmer_layout_promo);
                if (shimmerFrameLayout2 != null) {
                    shimmerFrameLayout2.a();
                }
            } catch (Exception unused) {
            }
            t tVar = this.k;
            LiveData<CJROffers> liveData = null;
            if (tVar instanceof s) {
                liveData = ((s) tVar).e();
            } else if (tVar instanceof f) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                a2.setErrorType(ERROR_TYPE.UNDEFINED);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setActionType(ACTION_TYPE.FETCH_PROMOS.name());
                }
                liveData = ((f) this.k).a("fetch_promo", a2);
            }
            if (liveData != null) {
                liveData.observe(this.k, new net.one97.paytm.recharge.widgets.a.c("fetch_promo", this));
                return;
            }
            return;
        }
        ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) b(R.id.shimmer_layout_promo);
        if (shimmerFrameLayout3 != null) {
            ai.b(shimmerFrameLayout3);
        }
    }

    public final void f() {
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_layout_promo);
            if (shimmerFrameLayout != null) {
                ai.a(shimmerFrameLayout);
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) b(R.id.shimmer_layout_promo);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.a();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        super.a(str);
        if (p.a(str, getContext().getString(R.string.exclusive_cashback_title), true)) {
            ((TextView) b(R.id.txt_title)).setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_ffffff));
            ((TextView) b(R.id.txt_title)).setTextColor(androidx.core.content.b.c(getContext(), R.color.color_222222));
            ((TextView) b(R.id.txt_title)).setAllCaps(false);
            View b2 = b(R.id.promoTopDivider);
            k.a((Object) b2, "promoTopDivider");
            b2.setVisibility(0);
        }
    }

    public final void a(List<? extends CJROfferCode> list) {
        k.c(list, "offerCodes");
        l lVar = this.f61908e;
        if (lVar == null) {
            k.a("adapter");
        }
        lVar.a(list);
    }

    public final void g() {
        l lVar = this.f61908e;
        if (lVar == null) {
            k.a("adapter");
        }
        if (!lVar.f60589a.isEmpty()) {
            int size = lVar.f60589a.size();
            int i2 = lVar.f60590b;
            if (i2 >= 0 && size > i2) {
                CJROfferCode cJROfferCode = lVar.f60589a.get(lVar.f60590b);
                k.a((Object) cJROfferCode, "offerList[lastCheckedPos]");
                if (!lVar.a(cJROfferCode)) {
                    lVar.notifyItemChanged(lVar.f60590b);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        boolean d2 = super.d();
        if (this.j.f61919i == CJRRecentOrderV8.b.MOBILE_V3) {
            if (d2) {
                ((TextView) b(R.id.txt_viewall)).setText(R.string.v3_action_view_less);
                l lVar = this.f61908e;
                if (lVar == null) {
                    k.a("adapter");
                }
                lVar.f60591c = true;
                lVar.notifyItemRangeChanged(Math.min(lVar.f60596h, lVar.f60589a.size()), lVar.f60589a.size());
            } else {
                ((TextView) b(R.id.txt_viewall)).setText(R.string.v3_action_view_all);
                l lVar2 = this.f61908e;
                if (lVar2 == null) {
                    k.a("adapter");
                }
                lVar2.f60591c = false;
                lVar2.notifyItemRangeChanged(Math.min(lVar2.f60596h, lVar2.f60589a.size()), lVar2.f60589a.size());
            }
        }
        return d2;
    }

    public final void a(String str, String str2) {
        k.c(str, "title");
        k.c(str2, "txtTermAndCondition");
        if (this.f61910h == null) {
            this.f61910h = new d();
        }
        Bundle bundle = new Bundle();
        bundle.putString("tnc_title", str);
        bundle.putString("tnc_text", str2);
        d dVar = this.f61910h;
        if (dVar == null) {
            k.a();
        }
        dVar.setArguments(bundle);
        d dVar2 = this.f61910h;
        if (dVar2 == null) {
            k.a();
        }
        if (!dVar2.isAdded()) {
            d dVar3 = this.f61910h;
            if (dVar3 == null) {
                k.a();
            }
            if (dVar3.getFragmentManager() == null) {
                d dVar4 = this.f61910h;
                if (dVar4 == null) {
                    k.a();
                }
                j jVar = this.f61911i;
                d.a aVar = d.f60981a;
                dVar4.show(jVar, d.f60982d);
            }
        }
    }

    public static final class b extends CJRBaseHeaderListLayoutV8.a {

        /* renamed from: b  reason: collision with root package name */
        String f61912b;

        /* renamed from: c  reason: collision with root package name */
        String f61913c;

        /* renamed from: d  reason: collision with root package name */
        public String f61914d;

        /* renamed from: e  reason: collision with root package name */
        boolean f61915e;

        /* renamed from: f  reason: collision with root package name */
        l.b f61916f;

        /* renamed from: g  reason: collision with root package name */
        public List<CJROfferCode> f61917g;

        /* renamed from: h  reason: collision with root package name */
        public String f61918h = "";

        /* renamed from: i  reason: collision with root package name */
        CJRRecentOrderV8.b f61919i;
        Integer j;
        public int k = -1;
        public int l = -1;

        public final b a(String str) {
            k.c(str, "title");
            this.f61912b = str;
            return this;
        }

        public final b a(l.b bVar) {
            k.c(bVar, "clickListener");
            this.f61916f = bVar;
            return this;
        }

        public final b a(boolean z, String str) {
            k.c(str, "categoryId");
            this.f61915e = z;
            return this;
        }

        public final b a(List<CJROfferCode> list) {
            k.c(list, "promoList");
            this.f61917g = list;
            return this;
        }

        public final b a(int i2) {
            this.j = Integer.valueOf(i2);
            return this;
        }

        public final b a(CJRRecentOrderV8.b bVar) {
            k.c(bVar, "type");
            this.f61919i = bVar;
            return this;
        }
    }

    public final n getErrorListener() {
        return this;
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        if (networkCustomError instanceof at) {
            this.f61909f = true;
            setVisibility(8);
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final RecyclerView.h a(CJRBaseHeaderListLayoutV8.a aVar) {
        k.c(aVar, "mBaseOption");
        Context context = getContext();
        k.a((Object) context, "context");
        return new net.one97.paytm.recharge.common.utils.p(context, aVar.f61848a, true);
    }
}
