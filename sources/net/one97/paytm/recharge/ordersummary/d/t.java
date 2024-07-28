package net.one97.paytm.recharge.ordersummary.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.o;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import java.util.HashMap;
import java.util.Map;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.n;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;
import net.one97.paytm.recharge.ordersummary.widget.CJRPaymentReminderWidgetV8;
import net.one97.paytm.recharge.ordersummary.widget.a;

public final class t extends net.one97.paytm.recharge.legacy.ordersummary.a.c implements a.C1271a {
    private LinearLayout A;
    /* access modifiers changed from: private */
    public CJRPaymentReminderWidgetV8 B;
    private CJRBaseRechargePromotionalBannerView C;
    private CJROrderActionsListView D;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.j.e<String> E;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.j.e<String> F;
    /* access modifiers changed from: private */
    public CJRRechargeAdWidgetLayout G;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.ordersummary.widget.a H;
    /* access modifiers changed from: private */
    public final int I = com.paytm.utility.b.c(100);
    /* access modifiers changed from: private */
    public int J;
    /* access modifiers changed from: private */
    public boolean K = true;
    private boolean L;
    private ViewTreeObserver.OnGlobalLayoutListener M;
    private NestedScrollView.b N;
    private HashMap O;
    HashMap<String, View> p = new HashMap<>(2);
    Fragment q;
    protected ObjectAnimator r;
    /* access modifiers changed from: private */
    public boolean s;
    /* access modifiers changed from: private */
    public Rect t;
    /* access modifiers changed from: private */
    public int u;
    private Integer v = 0;
    private Integer w = 0;
    private final int x = com.paytm.utility.b.c(-25);
    /* access modifiers changed from: private */
    public boolean y;
    private Boolean z;

    public final View a(int i2) {
        if (this.O == null) {
            this.O = new HashMap();
        }
        View view = (View) this.O.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.O.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.O;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void d(View view) {
    }

    public final void e(View view) {
    }

    static final class f<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64251a;

        f(t tVar) {
            this.f64251a = tVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f64251a.y = true;
                io.reactivex.rxjava3.j.e p = this.f64251a.E;
                if (p != null) {
                    p.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT());
                    return;
                }
                return;
            }
            io.reactivex.rxjava3.j.e a2 = this.f64251a.F;
            if (a2 != null) {
                a2.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r2 = (r2 = r2.getWindow()).getDecorView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r2) {
        /*
            r1 = this;
            super.onCreate(r2)
            androidx.fragment.app.FragmentActivity r2 = r1.getActivity()
            if (r2 == 0) goto L_0x001e
            android.view.Window r2 = r2.getWindow()
            if (r2 == 0) goto L_0x001e
            android.view.View r2 = r2.getDecorView()
            if (r2 == 0) goto L_0x001e
            int r2 = r2.getSystemUiVisibility()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            r1.v = r2
            java.lang.Integer r2 = r1.v
            r1.w = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r2 < r0) goto L_0x003e
            java.lang.Integer r2 = r1.v
            if (r2 != 0) goto L_0x0032
            kotlin.g.b.k.a()
        L_0x0032:
            int r2 = r2.intValue()
            r2 = r2 ^ 8192(0x2000, float:1.14794E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.w = r2
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.t.onCreate(android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_recharge_store_front, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o();
    }

    public static final class i implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64254a;

        public final void a(boolean z) {
        }

        public final void b() {
        }

        i(t tVar) {
            this.f64254a = tVar;
        }

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            io.reactivex.rxjava3.j.e a2 = this.f64254a.F;
            if (a2 != null) {
                a2.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC());
            }
            CJRPaymentReminderWidgetV8 b2 = this.f64254a.B;
            if (b2 != null) {
                b2.setAutomaticResponse((CJRAutomaticSubscriptionCheckModel) null);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 203) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == -1) {
            d().n = null;
            d().a((q) new i(this));
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        try {
            bundle.putSerializable("tapActionRes", d().m.get(Long.valueOf(c().getId())));
        } catch (Exception e2) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("P2 SuccessSummary screen : onSaveInstanceState : ViewModel is not initialized");
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((Throwable) e2);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r26, android.os.Bundle r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            java.lang.String r3 = "view"
            kotlin.g.b.k.c(r1, r3)
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0046
            r0.L = r6
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r7 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r8 = "storefront-new : screen re-created"
            r7.debugLog(r8)
            java.lang.String r7 = "tapActionRes"
            boolean r8 = r2.containsKey(r7)
            if (r8 == 0) goto L_0x004f
            java.io.Serializable r2 = r2.getSerializable(r7)
            boolean r7 = r2 instanceof net.one97.paytm.recharge.model.CJROSActionResponseV2
            if (r7 != 0) goto L_0x002a
            r2 = r5
        L_0x002a:
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r2
            if (r2 == 0) goto L_0x004f
            net.one97.paytm.recharge.ordersummary.b.a r7 = r25.d()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r7 = r7.m
            java.util.Map r7 = (java.util.Map) r7
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = r25.c()
            long r8 = r8.getId()
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r7.put(r8, r2)
            goto L_0x004f
        L_0x0046:
            r0.L = r4
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r7 = "storefront-new : screen created"
            r2.debugLog(r7)
        L_0x004f:
            android.os.Bundle r2 = r25.getArguments()
            if (r2 != 0) goto L_0x005d
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r2 = "storefront-new : argument is null"
            r1.debugLog(r2)
            return
        L_0x005d:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r25.d()
            net.one97.paytm.recharge.ordersummary.b.a r7 = r25.d()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r7.f63998b
            r2.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r7)
            int r2 = net.one97.paytm.recharge.R.id.container_other_items
            android.view.View r2 = r1.findViewById(r2)
            java.lang.String r7 = "view.findViewById<Linear…id.container_other_items)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r0.A = r2
            int r2 = net.one97.paytm.recharge.R.id.container_frame_recharge_item
            android.view.View r2 = r1.findViewById(r2)
            androidx.fragment.app.FragmentActivity r7 = r25.getActivity()
            java.lang.String r8 = "it"
            if (r7 == 0) goto L_0x00a3
            net.one97.paytm.recharge.ordersummary.widget.a r9 = new net.one97.paytm.recharge.ordersummary.widget.a
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            int r10 = net.one97.paytm.recharge.R.id.floating_nav_bar
            android.view.View r10 = r0.a((int) r10)
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            java.lang.String r11 = "floating_nav_bar"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            r11 = r0
            net.one97.paytm.recharge.ordersummary.widget.a$a r11 = (net.one97.paytm.recharge.ordersummary.widget.a.C1271a) r11
            r9.<init>(r7, r10, r11)
            r0.H = r9
        L_0x00a3:
            net.one97.paytm.recharge.ordersummary.b.a r7 = r25.d()
            boolean r7 = r7.c()
            java.lang.String r9 = "containerCard"
            if (r7 == 0) goto L_0x00b5
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            r2.setBackground(r5)
        L_0x00b5:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = r25.c()
            r0.g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r7)
            r25.n()
            if (r2 == 0) goto L_0x00c7
            r7 = r0
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r2.setOnClickListener(r7)
        L_0x00c7:
            androidx.fragment.app.j r7 = r25.getChildFragmentManager()
            net.one97.paytm.recharge.ordersummary.b.a r10 = r25.d()
            java.lang.String r10 = r10.f()
            androidx.fragment.app.Fragment r7 = r7.c((java.lang.String) r10)
            java.lang.String r10 = "childFragmentManager"
            if (r7 == 0) goto L_0x00f2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            net.one97.paytm.recharge.ordersummary.b.a r11 = r25.d()
            java.lang.String r11 = r11.f()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r11)
            r7 = r7 ^ r6
            if (r7 == 0) goto L_0x0163
        L_0x00f2:
            android.content.Context r7 = r25.getContext()
            if (r7 == 0) goto L_0x0163
            android.content.Context r7 = r25.getContext()
            if (r7 != 0) goto L_0x0101
            kotlin.g.b.k.a()
        L_0x0101:
            net.one97.paytm.recharge.ordersummary.b.a r11 = r25.d()
            java.lang.String r11 = r11.f()
            androidx.fragment.app.Fragment r7 = androidx.fragment.app.Fragment.instantiate(r7, r11)
            r0.q = r7
            androidx.fragment.app.j r7 = r25.getChildFragmentManager()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)
            java.util.List r7 = r7.g()
            java.util.Iterator r7 = r7.iterator()
        L_0x011e:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x013e
            java.lang.Object r11 = r7.next()
            androidx.fragment.app.Fragment r11 = (androidx.fragment.app.Fragment) r11
            androidx.fragment.app.j r12 = r25.getChildFragmentManager()
            androidx.fragment.app.q r12 = r12.a()
            java.lang.String r13 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            r12.a((androidx.fragment.app.Fragment) r11)
            r12.c()
            goto L_0x011e
        L_0x013e:
            androidx.fragment.app.j r7 = r25.getChildFragmentManager()
            androidx.fragment.app.q r7 = r7.a()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r9)
            int r2 = r2.getId()
            androidx.fragment.app.Fragment r9 = r0.q
            if (r9 != 0) goto L_0x0154
            kotlin.g.b.k.a()
        L_0x0154:
            net.one97.paytm.recharge.ordersummary.b.a r11 = r25.d()
            java.lang.String r11 = r11.f()
            androidx.fragment.app.q r2 = r7.a(r2, r9, r11)
            r2.c()
        L_0x0163:
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r25.c()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            if (r2 == 0) goto L_0x0178
            long r11 = r2.getCategoryId()
            java.lang.String r2 = java.lang.String.valueOf(r11)
            goto L_0x0179
        L_0x0178:
            r2 = r5
        L_0x0179:
            java.lang.String r2 = net.one97.paytm.recharge.di.helper.c.b(r2)
            android.content.Context r7 = r25.getContext()
            java.lang.String r9 = "context!!"
            java.lang.String r11 = "topLinearLayout"
            if (r7 == 0) goto L_0x01c5
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01c5
            net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout r7 = new net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout
            android.content.Context r12 = r25.getContext()
            if (r12 != 0) goto L_0x019b
            kotlin.g.b.k.a()
        L_0x019b:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            androidx.fragment.app.j r13 = r25.getChildFragmentManager()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)
            if (r2 != 0) goto L_0x01aa
            kotlin.g.b.k.a()
        L_0x01aa:
            net.one97.paytm.recharge.ordersummary.b.a r10 = r25.d()
            java.lang.String r10 = r10.r()
            r7.<init>(r12, r13, r2, r10)
            r0.G = r7
            android.widget.LinearLayout r2 = r0.A
            if (r2 != 0) goto L_0x01be
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x01be:
            net.one97.paytm.recharge.common.widget.CJRRechargeAdWidgetLayout r7 = r0.G
            android.view.View r7 = (android.view.View) r7
            r2.addView(r7)
        L_0x01c5:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r25.d()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r2 = r2.m
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = r25.c()
            long r12 = r7.getId()
            java.lang.Long r7 = java.lang.Long.valueOf(r12)
            java.lang.Object r2 = r2.get(r7)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r2
            if (r2 == 0) goto L_0x01e4
            java.util.List r7 = r2.getOrderLevelWidgets()
            goto L_0x01e5
        L_0x01e4:
            r7 = r5
        L_0x01e5:
            if (r7 == 0) goto L_0x022a
            r10 = r7
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r10 = r10.iterator()
        L_0x01f5:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x0226
            java.lang.Object r13 = r10.next()
            r14 = r13
            net.one97.paytm.recharge.model.CJROSActionItemV2 r14 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r14
            java.lang.String r15 = r14.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r16 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r5 = r16.getACTION_TYPE_STORE_FRONT()
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x021e
            net.one97.paytm.recharge.ordersummary.b.a r5 = r25.d()
            boolean r5 = r5.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r14, (int) r6, false)
            if (r5 == 0) goto L_0x021e
            r5 = 1
            goto L_0x021f
        L_0x021e:
            r5 = 0
        L_0x021f:
            if (r5 == 0) goto L_0x0224
            r12.add(r13)
        L_0x0224:
            r5 = 0
            goto L_0x01f5
        L_0x0226:
            r5 = r12
            java.util.List r5 = (java.util.List) r5
            goto L_0x022b
        L_0x022a:
            r5 = 0
        L_0x022b:
            if (r5 == 0) goto L_0x0291
            r10 = r5
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r6
            if (r10 != r6) goto L_0x0291
            java.lang.Object r5 = r5.get(r4)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r5 = r5.getUrlParams()
            if (r5 == 0) goto L_0x024a
            java.lang.String r5 = r5.getUrl()
            r24 = r5
            goto L_0x024c
        L_0x024a:
            r24 = 0
        L_0x024c:
            r5 = r24
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0291
            boolean r5 = android.webkit.URLUtil.isValidUrl(r24)
            if (r5 == 0) goto L_0x0291
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r5 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView
            androidx.fragment.app.FragmentActivity r10 = r25.getActivity()
            if (r10 != 0) goto L_0x0267
            kotlin.g.b.k.a()
        L_0x0267:
            java.lang.String r12 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r12)
            net.one97.paytm.recharge.ordersummary.b.a r20 = r25.d()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r21 = r25.c()
            r22 = 0
            r23 = r0
            net.one97.paytm.recharge.ordersummary.f.e r23 = (net.one97.paytm.recharge.ordersummary.f.e) r23
            r18 = r5
            r19 = r10
            r18.<init>(r19, r20, r21, r22, r23, r24)
            r0.C = r5
            android.widget.LinearLayout r5 = r0.A
            if (r5 != 0) goto L_0x028a
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x028a:
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r10 = r0.C
            android.view.View r10 = (android.view.View) r10
            r5.addView(r10)
        L_0x0291:
            if (r7 == 0) goto L_0x02cc
            r5 = r7
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x029a:
            boolean r10 = r5.hasNext()
            if (r10 == 0) goto L_0x02c7
            java.lang.Object r10 = r5.next()
            r12 = r10
            net.one97.paytm.recharge.model.CJROSActionItemV2 r12 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r12
            java.lang.String r13 = r12.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r14 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r14 = r14.getACTION_TYPE_AUTOMATIC()
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x02c3
            net.one97.paytm.recharge.ordersummary.b.a r13 = r25.d()
            boolean r12 = r13.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r12, (int) r6, false)
            if (r12 == 0) goto L_0x02c3
            r12 = 1
            goto L_0x02c4
        L_0x02c3:
            r12 = 0
        L_0x02c4:
            if (r12 == 0) goto L_0x029a
            goto L_0x02c8
        L_0x02c7:
            r10 = 0
        L_0x02c8:
            r5 = r10
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
            goto L_0x02cd
        L_0x02cc:
            r5 = 0
        L_0x02cd:
            if (r5 == 0) goto L_0x02dd
            net.one97.paytm.recharge.ordersummary.b.a r5 = r25.d()
            net.one97.paytm.recharge.ordersummary.d.t$k r10 = new net.one97.paytm.recharge.ordersummary.d.t$k
            r10.<init>(r0)
            net.one97.paytm.recharge.common.e.q r10 = (net.one97.paytm.recharge.common.e.q) r10
            r5.a((net.one97.paytm.recharge.common.e.q) r10)
        L_0x02dd:
            if (r7 == 0) goto L_0x031d
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r5 = r7.iterator()
        L_0x02e5:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0314
            java.lang.Object r7 = r5.next()
            r10 = r7
            net.one97.paytm.recharge.model.CJROSActionItemV2 r10 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r10
            java.lang.String r12 = r10.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r13 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r13 = r13.getACTION_TYPE_BILL_CONSENT()
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x030e
            net.one97.paytm.recharge.ordersummary.b.a r12 = r25.d()
            boolean r10 = r12.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r6, false)
            if (r10 == 0) goto L_0x030e
            r10 = 1
            goto L_0x030f
        L_0x030e:
            r10 = 0
        L_0x030f:
            if (r10 == 0) goto L_0x02e5
            r17 = r7
            goto L_0x0316
        L_0x0314:
            r17 = 0
        L_0x0316:
            r5 = r17
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
            r17 = r5
            goto L_0x031f
        L_0x031d:
            r17 = 0
        L_0x031f:
            if (r17 == 0) goto L_0x0324
            r25.t()
        L_0x0324:
            android.content.Context r5 = r25.getContext()
            if (r5 == 0) goto L_0x0342
            net.one97.paytm.recharge.ordersummary.widget.CJRBBPSWidget r7 = new net.one97.paytm.recharge.ordersummary.widget.CJRBBPSWidget
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            net.one97.paytm.recharge.ordersummary.b.a r8 = r25.d()
            r7.<init>(r5, r8, r2)
            android.widget.LinearLayout r2 = r0.A
            if (r2 != 0) goto L_0x033d
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x033d:
            android.view.View r7 = (android.view.View) r7
            r2.addView(r7)
        L_0x0342:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView$a r2 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.f64443a
            android.content.Context r12 = r25.getContext()
            if (r12 != 0) goto L_0x034d
            kotlin.g.b.k.a()
        L_0x034d:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r9)
            r13 = 1
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = r25.c()
            net.one97.paytm.recharge.ordersummary.b.a r15 = r25.d()
            r16 = r0
            net.one97.paytm.recharge.ordersummary.f.b r16 = (net.one97.paytm.recharge.ordersummary.f.b) r16
            net.one97.paytm.recharge.ordersummary.b.a r2 = r25.d()
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r2 = r2.k
            java.util.List r2 = (java.util.List) r2
            int r2 = r2.size()
            if (r2 <= r6) goto L_0x036e
            r17 = 1
            goto L_0x0370
        L_0x036e:
            r17 = 0
        L_0x0370:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r2 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.a.a(r12, r13, r14, r15, r16, r17)
            r0.D = r2
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r2 = r0.D
            if (r2 == 0) goto L_0x0388
            android.widget.LinearLayout r2 = r0.A
            if (r2 != 0) goto L_0x0381
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0381:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r5 = r0.D
            android.view.View r5 = (android.view.View) r5
            r2.addView(r5)
        L_0x0388:
            android.widget.LinearLayout r2 = r0.A
            if (r2 != 0) goto L_0x038f
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x038f:
            r2.getId()
            r25.i()
            kotlin.g.b.k.c(r1, r3)
            int r2 = net.one97.paytm.recharge.R.id.container_frame_recharge_item
            android.view.View r1 = r1.findViewById(r2)
            net.one97.paytm.recharge.ordersummary.d.t$b r2 = new net.one97.paytm.recharge.ordersummary.d.t$b
            r2.<init>()
            androidx.core.app.o r2 = (androidx.core.app.o) r2
            r0.setExitSharedElementCallback(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x03d1
            android.content.Context r2 = r25.getContext()
            if (r2 != 0) goto L_0x03b7
            kotlin.g.b.k.a()
        L_0x03b7:
            androidx.transition.t r2 = androidx.transition.t.a((android.content.Context) r2)
            int r3 = net.one97.paytm.recharge.R.transition.storefront_exit_transition
            androidx.transition.Transition r2 = r2.a((int) r3)
            java.lang.String r3 = "fragmentExitTransition"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r7 = 375(0x177, double:1.853E-321)
            r2.a((long) r7)
            r2.a((android.view.View) r1, (boolean) r6)
            r0.setExitTransition(r2)
        L_0x03d1:
            r2 = 2
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r2]
            android.util.Property r3 = android.view.View.SCALE_X
            float[] r5 = new float[r6]
            r7 = 1064514355(0x3f733333, float:0.95)
            r5[r4] = r7
            android.animation.PropertyValuesHolder r3 = android.animation.PropertyValuesHolder.ofFloat(r3, r5)
            r2[r4] = r3
            android.util.Property r3 = android.view.View.SCALE_Y
            float[] r5 = new float[r6]
            r7 = 1064682127(0x3f75c28f, float:0.96)
            r5[r4] = r7
            android.animation.PropertyValuesHolder r3 = android.animation.PropertyValuesHolder.ofFloat(r3, r5)
            r2[r6] = r3
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r1, r2)
            java.lang.String r3 = "ObjectAnimator.ofPropert…oat(View.SCALE_Y, 0.96F))"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.r = r2
            android.animation.ObjectAnimator r2 = r0.r
            java.lang.String r3 = "cardViewScaleUpAnimation"
            if (r2 != 0) goto L_0x0406
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0406:
            r4 = 100
            r2.setDuration(r4)
            android.animation.ObjectAnimator r2 = r0.r
            if (r2 != 0) goto L_0x0412
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0412:
            android.view.animation.DecelerateInterpolator r4 = new android.view.animation.DecelerateInterpolator
            r4.<init>()
            android.animation.TimeInterpolator r4 = (android.animation.TimeInterpolator) r4
            r2.setInterpolator(r4)
            android.animation.ObjectAnimator r2 = r0.r
            if (r2 != 0) goto L_0x0423
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0423:
            net.one97.paytm.recharge.ordersummary.d.t$c r3 = new net.one97.paytm.recharge.ordersummary.d.t$c
            r3.<init>(r0, r1)
            android.animation.Animator$AnimatorListener r3 = (android.animation.Animator.AnimatorListener) r3
            r2.addListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.t.a(android.view.View, android.os.Bundle):void");
    }

    public static final class k implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64256a;

        k(t tVar) {
            this.f64256a = tVar;
        }

        public final void b() {
            CJRPaymentReminderWidgetV8 b2 = this.f64256a.B;
            if (b2 != null) {
                b2.setAutomaticResponse(this.f64256a.d().n);
            }
        }

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            CJRPaymentReminderWidgetV8 b2 = this.f64256a.B;
            if (b2 != null) {
                b2.setAutomaticResponse((CJRAutomaticSubscriptionCheckModel) null);
            }
        }

        public final void a(boolean z) {
            if (z) {
                this.f64256a.s();
            }
        }
    }

    public final void q() {
        if (!this.L) {
            CJROrderedCart c2 = c();
            LinearLayout linearLayout = this.A;
            if (linearLayout == null) {
                kotlin.g.b.k.a("topLinearLayout");
            }
            a(c2, 0, linearLayout, j(), this.H);
        }
    }

    /* JADX WARNING: type inference failed for: r0v41, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r4 = this;
            android.content.Context r0 = r4.getContext()
            boolean r0 = r0 instanceof net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r4.getContext()
            if (r0 == 0) goto L_0x0016
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r0 = (net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity) r0
            r1 = 8
            r0.a((int) r1)
            goto L_0x001e
        L_0x0016:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity"
            r0.<init>(r1)
            throw r0
        L_0x001e:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r4.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r1 = 0
            if (r0 == 0) goto L_0x002e
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            if (r0 == 0) goto L_0x0160
            net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout$LayoutParams r0 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout.LayoutParams) r0
            android.content.Context r2 = r4.getContext()
            if (r2 != 0) goto L_0x003c
            kotlin.g.b.k.a()
        L_0x003c:
            int r2 = com.paytm.utility.b.N((android.content.Context) r2)
            r0.topMargin = r2
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r4.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r2 = 0
            if (r0 == 0) goto L_0x005a
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x005a
            r0.setBackgroundColor(r2)
        L_0x005a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r0 < r3) goto L_0x0071
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 == 0) goto L_0x0071
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0071
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r0.addFlags(r3)
        L_0x0071:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r0 >= r3) goto L_0x0098
            int r0 = net.one97.paytm.recharge.R.id.nestedScrollView
            android.view.View r0 = r4.a((int) r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            if (r0 == 0) goto L_0x0086
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0087
        L_0x0086:
            r0 = r1
        L_0x0087:
            if (r0 == 0) goto L_0x0090
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r0
            int r3 = r4.x
            r0.topMargin = r3
            goto L_0x0098
        L_0x0090:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        L_0x0098:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r4.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            if (r0 == 0) goto L_0x00b5
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x00b5
            int r3 = net.one97.paytm.recharge.R.id.textView45
            android.view.View r0 = r0.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x00b6
        L_0x00b5:
            r0 = r1
        L_0x00b6:
            if (r0 == 0) goto L_0x00bb
            r0.setVisibility(r2)
        L_0x00bb:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r4.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            if (r0 == 0) goto L_0x00d8
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x00d8
            int r1 = net.one97.paytm.recharge.R.id.home
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x00d8:
            if (r1 == 0) goto L_0x00dd
            r1.setVisibility(r2)
        L_0x00dd:
            if (r1 == 0) goto L_0x00e9
            net.one97.paytm.recharge.ordersummary.d.t$g r0 = new net.one97.paytm.recharge.ordersummary.d.t$g
            r0.<init>(r4)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r1.setOnClickListener(r0)
        L_0x00e9:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r4.c()
            java.lang.String r0 = r0.getItemStatus()
            java.lang.String r1 = "7"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x010b
            android.content.Context r0 = r4.getContext()
            if (r0 != 0) goto L_0x0102
            kotlin.g.b.k.a()
        L_0x0102:
            int r1 = net.one97.paytm.recharge.R.color.recharge_order_success
            int r0 = androidx.core.content.b.c(r0, r1)
            r4.u = r0
            goto L_0x013c
        L_0x010b:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.d()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r4.c()
            boolean r0 = r0.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)
            if (r0 == 0) goto L_0x012b
            android.content.Context r0 = r4.getContext()
            if (r0 != 0) goto L_0x0122
            kotlin.g.b.k.a()
        L_0x0122:
            int r1 = net.one97.paytm.recharge.R.color.recharge_order_failed
            int r0 = androidx.core.content.b.c(r0, r1)
            r4.u = r0
            goto L_0x013c
        L_0x012b:
            android.content.Context r0 = r4.getContext()
            if (r0 != 0) goto L_0x0134
            kotlin.g.b.k.a()
        L_0x0134:
            int r1 = net.one97.paytm.recharge.R.color.recharge_order_pending
            int r0 = androidx.core.content.b.c(r0, r1)
            r4.u = r0
        L_0x013c:
            int r0 = net.one97.paytm.recharge.R.id.appbar_layout
            android.view.View r0 = r4.a((int) r0)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            if (r0 == 0) goto L_0x014b
            int r1 = r4.u
            r0.setBackgroundColor(r1)
        L_0x014b:
            int r0 = net.one97.paytm.recharge.R.id.appbar_layout
            android.view.View r0 = r4.a((int) r0)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            if (r0 == 0) goto L_0x015f
            net.one97.paytm.recharge.ordersummary.d.t$h r1 = new net.one97.paytm.recharge.ordersummary.d.t$h
            r1.<init>(r4)
            com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
            r0.a((com.google.android.material.appbar.AppBarLayout.b) r1)
        L_0x015f:
            return
        L_0x0160:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.t.e():void");
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64252a;

        g(t tVar) {
            this.f64252a = tVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f64252a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class h implements AppBarLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64253a;

        h(t tVar) {
            this.f64253a = tVar;
        }

        public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            CJRRechargeAdWidgetLayout e2;
            if (((NestedScrollView) this.f64253a.a(R.id.nestedScrollView)) != null && ((Toolbar) this.f64253a.a(R.id.toolbar)) != null) {
                int abs = Math.abs(i2);
                t tVar = this.f64253a;
                kotlin.g.b.k.a((Object) appBarLayout, "p0");
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                Toolbar toolbar = (Toolbar) this.f64253a.a(R.id.toolbar);
                kotlin.g.b.k.a((Object) toolbar, "toolbar");
                t.a(tVar, totalScrollRange, abs, toolbar.getHeight());
                t tVar2 = this.f64253a;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange();
                Toolbar toolbar2 = (Toolbar) this.f64253a.a(R.id.toolbar);
                kotlin.g.b.k.a((Object) toolbar2, "toolbar");
                toolbar2.getHeight();
                t.b(tVar2, totalScrollRange2, abs, this.f64253a.u);
                CJRRechargeAdWidgetLayout e3 = this.f64253a.G;
                if (e3 != null && e3.getLocalVisibleRect(this.f64253a.f63019a) && (e2 = this.f64253a.G) != null) {
                    e2.a();
                }
            }
        }
    }

    public static final class b extends o {
        b() {
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64247a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f64248b;

        c(t tVar, View view) {
            this.f64247a = tVar;
            this.f64248b = view;
        }

        public final void onAnimationEnd(Animator animator) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f64247a.q instanceof net.one97.paytm.recharge.ordersummary.f.o) {
                    HashMap<String, View> hashMap = this.f64247a.p;
                    Fragment fragment = this.f64247a.q;
                    if (fragment != null) {
                        hashMap.putAll(((net.one97.paytm.recharge.ordersummary.f.o) fragment).getSharedElementMap());
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharedElementProvider");
                    }
                }
                try {
                    Map map = this.f64247a.p;
                    String x = androidx.core.h.u.x(this.f64248b);
                    if (x == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) x, "ViewCompat.getTransitionName(containerCard)!!");
                    View view = this.f64248b;
                    kotlin.g.b.k.a((Object) view, "containerCard");
                    map.put(x, view);
                } catch (Exception unused) {
                }
            }
            t tVar = this.f64247a;
            View view2 = tVar.f63020b;
            ViewParent parent = view2 != null ? view2.getParent() : null;
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(tVar.f63020b);
            }
            t tVar2 = this.f64247a;
            t.super.a(tVar2.p);
        }
    }

    private final void g(CJROrderedCart cJROrderedCart) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        TextView textView = (TextView) a(R.id.recharge_title);
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d2 = d();
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            textView.setText(d2.S(context));
        }
        CJRAmountView cJRAmountView = (CJRAmountView) a(R.id.recharge_amount);
        if (cJRAmountView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d3 = d();
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context2, "context!!");
            cJRAmountView.setText(d3.l(context2, cJROrderedCart));
        }
        if (this.M == null) {
            this.M = new d(this);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nestedScrollView);
        if (!(nestedScrollView == null || (viewTreeObserver2 = nestedScrollView.getViewTreeObserver()) == null)) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.M);
        }
        NestedScrollView nestedScrollView2 = (NestedScrollView) a(R.id.nestedScrollView);
        if (!(nestedScrollView2 == null || (viewTreeObserver = nestedScrollView2.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(this.M);
        }
        if (this.N == null) {
            this.N = new e(this);
        }
        NestedScrollView nestedScrollView3 = (NestedScrollView) a(R.id.nestedScrollView);
        if (nestedScrollView3 != null) {
            nestedScrollView3.setOnScrollChangeListener(this.N);
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64249a;

        d(t tVar) {
            this.f64249a = tVar;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            NestedScrollView nestedScrollView = (NestedScrollView) this.f64249a.a(R.id.nestedScrollView);
            if (!(nestedScrollView == null || (viewTreeObserver = nestedScrollView.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            this.f64249a.f63019a = new Rect();
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.f64249a.a(R.id.nestedScrollView);
            if (nestedScrollView2 != null) {
                nestedScrollView2.getHitRect(this.f64249a.f63019a);
            }
            int[] iArr = {0, 0};
            NestedScrollView nestedScrollView3 = (NestedScrollView) this.f64249a.a(R.id.nestedScrollView);
            if (nestedScrollView3 != null) {
                nestedScrollView3.getLocationOnScreen(iArr);
            }
            Rect f2 = this.f64249a.f63019a;
            if (f2 != null) {
                f2.left = iArr[0];
            }
            Rect f3 = this.f64249a.f63019a;
            if (f3 != null) {
                f3.top = iArr[1];
            }
            this.f64249a.t = new Rect();
            Toolbar toolbar = (Toolbar) this.f64249a.a(R.id.toolbar);
            if (toolbar != null) {
                toolbar.getHitRect(this.f64249a.t);
            }
            Rect g2 = this.f64249a.t;
            if (g2 == null) {
                kotlin.g.b.k.a();
            }
            if (g2.bottom != 0) {
                this.f64249a.s = true;
            }
            int[] iArr2 = {0, 0};
            Toolbar toolbar2 = (Toolbar) this.f64249a.a(R.id.toolbar);
            if (toolbar2 != null) {
                toolbar2.getLocationOnScreen(iArr2);
            }
            Rect g3 = this.f64249a.t;
            if (g3 != null) {
                g3.left = iArr2[0];
            }
            Rect g4 = this.f64249a.t;
            if (g4 != null) {
                g4.top = iArr2[1];
            }
            NestedScrollView nestedScrollView4 = (NestedScrollView) this.f64249a.a(R.id.nestedScrollView);
            if (nestedScrollView4 != null) {
                this.f64249a.f((View) nestedScrollView4);
            }
        }
    }

    static final class e implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64250a;

        e(t tVar) {
            this.f64250a = tVar;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            CJRRechargeAdWidgetLayout e2;
            if (this.f64250a.f63019a != null) {
                if (i3 != 0 && !this.f64250a.f63021c) {
                    this.f64250a.f63021c = true;
                    t tVar = this.f64250a;
                    View j = tVar.f63020b;
                    if (j == null) {
                        kotlin.g.b.k.a();
                    }
                    tVar.g(j);
                    NestedScrollView nestedScrollView2 = (NestedScrollView) this.f64250a.a(R.id.nestedScrollView);
                    if (nestedScrollView2 != null) {
                        nestedScrollView2.setTranslationY(0.0f);
                    }
                } else if (i3 == 0 && this.f64250a.f63021c) {
                    this.f64250a.f63021c = false;
                    t tVar2 = this.f64250a;
                    View j2 = tVar2.f63020b;
                    if (j2 == null) {
                        kotlin.g.b.k.a();
                    }
                    tVar2.h(j2);
                }
                CJRRechargeAdWidgetLayout e3 = this.f64250a.G;
                if (!(e3 == null || !e3.getLocalVisibleRect(this.f64250a.f63019a) || (e2 = this.f64250a.G) == null)) {
                    e2.a();
                }
                this.f64250a.J = nestedScrollView.computeVerticalScrollOffset();
                if (this.f64250a.J > this.f64250a.I && this.f64250a.K) {
                    net.one97.paytm.recharge.ordersummary.widget.a n = this.f64250a.H;
                    if (n != null) {
                        n.b();
                    }
                    this.f64250a.K = false;
                } else if (this.f64250a.J < this.f64250a.I && !this.f64250a.K) {
                    net.one97.paytm.recharge.ordersummary.widget.a n2 = this.f64250a.H;
                    if (n2 != null) {
                        n2.a();
                    }
                    this.f64250a.K = true;
                }
            }
        }
    }

    static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f64255a;

        j(t tVar) {
            this.f64255a = tVar;
        }

        public final void run() {
            AppBarLayout appBarLayout = (AppBarLayout) this.f64255a.a(R.id.appbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setExpanded(true, true);
            }
            NestedScrollView nestedScrollView = (NestedScrollView) this.f64255a.a(R.id.nestedScrollView);
            if (nestedScrollView != null) {
                nestedScrollView.a(33);
            }
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.f64255a.a(R.id.nestedScrollView);
            if (nestedScrollView2 != null) {
                nestedScrollView2.scrollTo(0, 10);
            }
            if (this.f64255a.f63020b != null) {
                t tVar = this.f64255a;
                View j = tVar.f63020b;
                if (j == null) {
                    kotlin.g.b.k.a();
                }
                tVar.h(j);
            }
        }
    }

    public final void r() {
        View view = getView();
        if (view != null) {
            view.postDelayed(new j(this), 100);
        }
    }

    public final int g() {
        return d().a(true);
    }

    public final SpannableString h() {
        net.one97.paytm.recharge.ordersummary.b.a d2 = d();
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        return d2.a(context, true, c(), false);
    }

    public final void f(View view) {
        kotlin.g.b.k.c(view, "view");
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog("initBannerStatusView " + t.class.getSimpleName());
        super.f(view);
        View view2 = this.f63020b;
        if (view2 == null) {
            kotlin.g.b.k.a();
        }
        Rect rect = this.t;
        if (rect == null) {
            kotlin.g.b.k.a();
        }
        view2.setY((float) rect.bottom);
        Rect rect2 = this.t;
        if (rect2 == null) {
            kotlin.g.b.k.a();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, rect2.bottom);
        View a2 = a(R.id.space);
        if (a2 != null) {
            a2.setLayoutParams(layoutParams);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.s) {
            g(c());
        } else if (kotlin.g.b.k.a((Object) this.z, (Object) Boolean.FALSE)) {
            r();
        }
    }

    public final LinearLayout.LayoutParams j() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        return layoutParams;
    }

    public final void a(String str, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        View view = getView();
        if (view == null) {
            kotlin.g.b.k.a();
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container_other_items);
        if (linearLayout != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            linearLayout.addView(new CJRBaseRechargePromotionalBannerView(activity, d(), c(), false, this, net.one97.paytm.recharge.di.helper.c.av()));
        }
    }

    public final void a(HashMap<String, View> hashMap) {
        kotlin.g.b.k.c(hashMap, "sharedElementsMap");
        this.p.clear();
        this.p.putAll(hashMap);
        ObjectAnimator objectAnimator = this.r;
        if (objectAnimator == null) {
            kotlin.g.b.k.a("cardViewScaleUpAnimation");
        }
        objectAnimator.start();
    }

    public final boolean a(String str, io.reactivex.rxjava3.j.e<String> eVar, io.reactivex.rxjava3.j.e<String> eVar2) {
        kotlin.g.b.k.c(str, "type");
        kotlin.g.b.k.c(eVar, "enableActionObservable");
        kotlin.g.b.k.c(eVar2, "disableActionObservable");
        this.E = eVar;
        this.F = eVar2;
        if (kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC())) {
            d().a((q) new a(eVar));
            return false;
        } else if (!kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT())) {
            return super.a(str, eVar, eVar2);
        } else {
            t();
            return false;
        }
    }

    public static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ io.reactivex.rxjava3.j.e f64246a;

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        }

        public final void a(boolean z) {
        }

        a(io.reactivex.rxjava3.j.e eVar) {
            this.f64246a = eVar;
        }

        public final void b() {
            this.f64246a.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC());
        }
    }

    public final void setBillConsent(CJROrderSummaryAction cJROrderSummaryAction) {
        net.one97.paytm.recharge.common.h.f fVar;
        net.one97.paytm.recharge.common.utils.j jVar;
        kotlin.g.b.k.c(cJROrderSummaryAction, "action");
        if (this.y && (fVar = this.f63024f) != null && (jVar = fVar.f61441d) != null) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            jVar.a(childFragmentManager);
        }
    }

    private void t() {
        net.one97.paytm.recharge.common.h.f fVar;
        LiveData liveData;
        CJROrderSummarySubscription subscription = c().getSubscription();
        if (!(subscription != null ? subscription.getIsApplicable() : false) && (fVar = this.f63024f) != null && (liveData = fVar.f61442e) != null) {
            liveData.observe(this, new f(this));
        }
    }

    public final void s() {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        this.B = new CJRPaymentReminderWidgetV8(context, d(), c(), this, 1);
        if (this.C != null) {
            LinearLayout linearLayout = this.A;
            if (linearLayout == null) {
                kotlin.g.b.k.a("topLinearLayout");
            }
            int indexOfChild = linearLayout.indexOfChild(this.C);
            if (indexOfChild == 0) {
                LinearLayout linearLayout2 = this.A;
                if (linearLayout2 == null) {
                    kotlin.g.b.k.a("topLinearLayout");
                }
                indexOfChild = linearLayout2.indexOfChild(this.D);
            }
            LinearLayout linearLayout3 = this.A;
            if (linearLayout3 == null) {
                kotlin.g.b.k.a("topLinearLayout");
            }
            linearLayout3.addView(this.B, indexOfChild);
        }
    }

    public final CJROrderActionsListView getOrderActionClickListener() {
        return this.D;
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "actionType");
        if (!(getContext() instanceof n)) {
            return;
        }
        if (kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_SHARE())) {
            Context context = getContext();
            if (context != null) {
                n nVar = (n) context;
                if (str2 == null) {
                    str2 = c().getName();
                }
                if (str2 == null) {
                    str2 = "";
                }
                nVar.a(str2, getView());
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen");
        } else if (kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_SHARE_VOUCHER_CODE())) {
            Context context2 = getContext();
            if (context2 != null) {
                n nVar2 = (n) context2;
                String name = c().getName();
                if (name == null) {
                    name = "";
                }
                nVar2.a(name, (FrameLayout) a(R.id.container_frame_recharge_item));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRSharableScreen");
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (getContext() instanceof AJRechargeOrderSummaryActivity) {
            Context context = getContext();
            if (context != null) {
                ((AJRechargeOrderSummaryActivity) context).a(8);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
            }
        }
        b();
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.container_frame_recharge_item;
        if (valueOf != null && valueOf.intValue() == i2) {
            p();
        }
    }

    public final void p() {
        a(this.p);
    }

    public static final /* synthetic */ void a(t tVar, int i2, int i3, int i4) {
        View view;
        NestedScrollView nestedScrollView;
        if (i3 >= i2 - i4) {
            tVar.z = Boolean.TRUE;
            NestedScrollView nestedScrollView2 = (NestedScrollView) tVar.a(R.id.nestedScrollView);
            int i5 = (i2 - i3) - i4;
            float translationY = (i5 != 0 ? ((float) i5) / ((float) i2) : 0.0f) * (nestedScrollView2 != null ? nestedScrollView2.getTranslationY() : 0.0f);
            if (translationY <= 0.0f && (nestedScrollView = (NestedScrollView) tVar.a(R.id.nestedScrollView)) != null) {
                nestedScrollView.setTranslationY(translationY);
                return;
            }
            return;
        }
        tVar.z = Boolean.FALSE;
        float c2 = (float) com.paytm.utility.b.c(-65);
        float f2 = (float) tVar.x;
        int i6 = (i2 - i3) - i4;
        float f3 = (i6 != 0 ? ((float) i6) / ((float) i2) : 0.0f) * c2;
        if (f3 <= 0.0f) {
            float max = Math.max(f3, f2);
            NestedScrollView nestedScrollView3 = (NestedScrollView) tVar.a(R.id.nestedScrollView);
            if (nestedScrollView3 != null) {
                nestedScrollView3.setTranslationY(max);
            }
            if (max == f2 && (view = tVar.f63020b) != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.findViewById(net.one97.paytm.recharge.R.id.custom_toolbar);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void b(net.one97.paytm.recharge.ordersummary.d.t r5, int r6, int r7, int r8) {
        /*
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r5.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r1 = 0
            if (r0 == 0) goto L_0x001e
            android.view.View r0 = (android.view.View) r0
            int r2 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r2)
            if (r0 == 0) goto L_0x001e
            int r2 = net.one97.paytm.recharge.R.id.textView45
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            int r2 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r2 = r5.a((int) r2)
            androidx.appcompat.widget.Toolbar r2 = (androidx.appcompat.widget.Toolbar) r2
            if (r2 == 0) goto L_0x003b
            android.view.View r2 = (android.view.View) r2
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r2 = r2.findViewById(r3)
            if (r2 == 0) goto L_0x003b
            int r1 = net.one97.paytm.recharge.R.id.home
            android.view.View r1 = r2.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x003b:
            android.animation.ArgbEvaluator r2 = new android.animation.ArgbEvaluator
            r2.<init>()
            int r7 = r6 - r7
            if (r7 == 0) goto L_0x0048
            float r7 = (float) r7
            float r6 = (float) r6
            float r7 = r7 / r6
            goto L_0x0049
        L_0x0048:
            r7 = 0
        L_0x0049:
            r6 = 1065353216(0x3f800000, float:1.0)
            float r6 = r6 - r7
            if (r0 == 0) goto L_0x0051
            r0.setAlpha(r6)
        L_0x0051:
            int r0 = net.one97.paytm.recharge.R.id.container_parallax_status
            android.view.View r0 = r5.a((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x005e
            r0.setAlpha(r7)
        L_0x005e:
            r0 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object r8 = r2.evaluate(r7, r3, r8)
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Int"
            if (r8 == 0) goto L_0x0102
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            int r4 = net.one97.paytm.recharge.R.id.appbar_layout
            android.view.View r4 = r5.a((int) r4)
            com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
            if (r4 == 0) goto L_0x0082
            r4.setBackgroundColor(r8)
        L_0x0082:
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r7 = r2.evaluate(r7, r4, r0)
            if (r7 == 0) goto L_0x00fc
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r1 == 0) goto L_0x009f
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r1.setColorFilter(r7, r0)
        L_0x009f:
            r7 = 1056964608(0x3f000000, float:0.5)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x00e6
            android.view.Window r6 = r6.getWindow()
            if (r6 == 0) goto L_0x00e6
            android.view.View r6 = r6.getDecorView()
            if (r6 == 0) goto L_0x00e6
            java.lang.Integer r7 = r5.v
            if (r7 != 0) goto L_0x00be
            kotlin.g.b.k.a()
        L_0x00be:
            int r7 = r7.intValue()
            r6.setSystemUiVisibility(r7)
            goto L_0x00e6
        L_0x00c6:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x00e6
            android.view.Window r6 = r6.getWindow()
            if (r6 == 0) goto L_0x00e6
            android.view.View r6 = r6.getDecorView()
            if (r6 == 0) goto L_0x00e6
            java.lang.Integer r7 = r5.w
            if (r7 != 0) goto L_0x00df
            kotlin.g.b.k.a()
        L_0x00df:
            int r7 = r7.intValue()
            r6.setSystemUiVisibility(r7)
        L_0x00e6:
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 21
            if (r6 < r7) goto L_0x00fb
            androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
            if (r5 == 0) goto L_0x00fb
            android.view.Window r5 = r5.getWindow()
            if (r5 == 0) goto L_0x00fb
            r5.setStatusBarColor(r8)
        L_0x00fb:
            return
        L_0x00fc:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        L_0x0102:
            kotlin.u r5 = new kotlin.u
            r5.<init>(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.t.b(net.one97.paytm.recharge.ordersummary.d.t, int, int, int):void");
    }
}
