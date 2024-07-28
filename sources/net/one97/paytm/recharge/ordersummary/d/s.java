package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;
import net.one97.paytm.recharge.ordersummary.widget.CJRPaymentReminderWidgetV8;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class s extends net.one97.paytm.recharge.legacy.ordersummary.a.b {
    private static final long C = C;
    private static final long D = D;
    private static final long E = E;
    public static final a k = new a((byte) 0);
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public boolean B = true;
    private HashMap F;
    protected Fragment j;
    private CardView p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public CJRPaymentReminderWidgetV8 r;
    private CJROrderActionsListView s;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.j.e<String> t;
    /* access modifiers changed from: private */
    public io.reactivex.rxjava3.j.e<String> u;
    private boolean v;
    private io.reactivex.rxjava3.b.c w;
    private boolean x;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.ordersummary.widget.a y;
    /* access modifiers changed from: private */
    public final int z = com.paytm.utility.b.c(100);

    static final class i<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f64237a = new i();

        i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class j implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final j f64238a = new j();

        j() {
        }

        public final void run() {
        }
    }

    public final View a(int i2) {
        if (this.F == null) {
            this.F = new HashMap();
        }
        View view = (View) this.F.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.F.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void d(View view) {
    }

    public final void e(View view) {
    }

    static final class h<T> implements io.reactivex.rxjava3.d.g<CJROrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64236a;

        h(s sVar) {
            this.f64236a = sVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) obj;
            s sVar = this.f64236a;
            kotlin.g.b.k.a((Object) cJROrderSummary, "it");
            sVar.a(cJROrderSummary);
        }
    }

    static final class k<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64239a;

        k(s sVar) {
            this.f64239a = sVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f64239a.q = true;
                io.reactivex.rxjava3.j.e l = this.f64239a.t;
                if (l != null) {
                    l.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT());
                    return;
                }
                return;
            }
            io.reactivex.rxjava3.j.e a2 = this.f64239a.u;
            if (a2 != null) {
                a2.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT());
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.x = arguments != null ? arguments.getBoolean("recharge.show.item.details") : false;
        if (!this.x) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.a((Transition) new Fade());
            transitionSet.a(375);
            setEnterTransition(transitionSet);
            postponeEnterTransition();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_container_success_recharge_order_summary_v8, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o();
    }

    public static final class m implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64241a;

        public final void a(boolean z) {
        }

        public final void b() {
        }

        m(s sVar) {
            this.f64241a = sVar;
        }

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            io.reactivex.rxjava3.j.e a2 = this.f64241a.u;
            if (a2 != null) {
                a2.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC());
            }
            CJRPaymentReminderWidgetV8 b2 = this.f64241a.r;
            if (b2 != null) {
                b2.setAutomaticResponse((CJRAutomaticSubscriptionCheckModel) null);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 203) {
            if (i2 != 2020) {
                super.onActivityResult(i2, i3, intent);
            }
        } else if (i3 == -1) {
            d().n = null;
            d().a((q) new m(this));
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        try {
            bundle.putSerializable("tapActionRes", d().m.get(Long.valueOf(c().getId())));
        } catch (Exception e2) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("P2 SuccessDetail screen : onSaveInstanceState : ViewModel is not initialized");
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((Throwable) e2);
        }
        super.onSaveInstanceState(bundle);
    }

    public final void a(View view, Bundle bundle) {
        Window window;
        View decorView;
        View findViewById;
        View findViewById2;
        View findViewById3;
        kotlin.g.b.k.c(view, "view");
        Bundle arguments = getArguments();
        this.x = arguments != null ? arguments.getBoolean("recharge.show.item.details") : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && arguments2.containsKey("recharge_item")) {
            Bundle arguments3 = getArguments();
            Serializable serializable = arguments3 != null ? arguments3.getSerializable("recharge_item") : null;
            if (serializable != null) {
                d((CJROrderedCart) serializable);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderedCart");
            }
        }
        if (bundle != null) {
            CJRRechargeUtilities.INSTANCE.debugLog("success-detail : screen re-created");
            if (bundle.containsKey("tapActionRes")) {
                Serializable serializable2 = bundle.getSerializable("tapActionRes");
                if (!(serializable2 instanceof CJROSActionResponseV2)) {
                    serializable2 = null;
                }
                CJROSActionResponseV2 cJROSActionResponseV2 = (CJROSActionResponseV2) serializable2;
                if (cJROSActionResponseV2 != null) {
                    d().m.put(Long.valueOf(c().getId()), cJROSActionResponseV2);
                }
            }
            this.v = true;
        } else {
            CJRRechargeUtilities.INSTANCE.debugLog("success-detail : screen created");
        }
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nestedScrollView);
        if (nestedScrollView != null) {
            nestedScrollView.setNestedScrollingEnabled(false);
        }
        View findViewById4 = view.findViewById(R.id.container_details);
        if (findViewById4 != null) {
            this.f63022d = (LinearLayout) findViewById4;
            View findViewById5 = view.findViewById(R.id.container_card_recharge_item);
            if (!(findViewById5 instanceof CardView)) {
                findViewById5 = null;
            }
            this.p = (CardView) findViewById5;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                kotlin.g.b.k.a((Object) activity, "it");
                FrameLayout frameLayout = (FrameLayout) a(R.id.floating_nav_bar);
                kotlin.g.b.k.a((Object) frameLayout, "floating_nav_bar");
                this.y = new net.one97.paytm.recharge.ordersummary.widget.a(activity, frameLayout);
            }
            Toolbar toolbar = (Toolbar) a(R.id.toolbar);
            if (!(toolbar == null || (findViewById3 = toolbar.findViewById(R.id.custom_toolbar)) == null)) {
                findViewById3.findViewById(R.id.textView45);
            }
            Toolbar toolbar2 = (Toolbar) a(R.id.toolbar);
            if (!(toolbar2 == null || (findViewById2 = toolbar2.findViewById(R.id.custom_toolbar)) == null)) {
                findViewById2.findViewById(R.id.share);
            }
            Toolbar toolbar3 = (Toolbar) a(R.id.toolbar);
            if (!(toolbar3 == null || (findViewById = toolbar3.findViewById(R.id.custom_toolbar)) == null)) {
                findViewById.findViewById(R.id.home);
            }
            setEnterSharedElementCallback(new e());
            CJRRechargeUtilities.INSTANCE.debugLog("onNonLollipopTransitionStart " + s.class.getName());
            FragmentActivity activity2 = getActivity();
            if (!(activity2 == null || (window = activity2.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
                decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            }
            CardView cardView = this.p;
            if (cardView != null) {
                cardView.setCardElevation(0.0f);
            }
            CardView cardView2 = this.p;
            if (cardView2 != null) {
                cardView2.setRadius(0.0f);
            }
            if (!this.v) {
                View view2 = this.f63020b;
                if (view2 != null) {
                    view2.postDelayed(new n(this), E);
                } else {
                    this.v = true;
                }
            }
            if (getView() != null) {
                View view3 = getView();
                if (view3 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) view3, "view!!");
                b(view3);
            }
            c(view);
            a(view);
            j();
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    /* access modifiers changed from: private */
    public final void j() {
        if (q() && getActivity() != null && (getActivity() instanceof AJRechargeOrderSummaryActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) activity;
                CJROrderSummary cJROrderSummary = d().f63998b;
                if (cJROrderSummary == null) {
                    kotlin.g.b.k.a();
                }
                String id = cJROrderSummary.getId();
                kotlin.g.b.k.a((Object) id, "viewModel.getOrderSummaryResponse()!!.id");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                aJRechargeOrderSummaryActivity.a(id, net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.OS_POOLING, ERROR_TYPE.UNDEFINED));
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.util.List} */
    /* JADX WARNING: type inference failed for: r0v30, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            boolean r0 = r0 instanceof net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r10.getContext()
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
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x0035
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            if (r0 == 0) goto L_0x0035
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0035
            r1 = 67108864(0x4000000, float:1.5046328E-36)
            r0.addFlags(r1)
        L_0x0035:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r10.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r1 = 0
            if (r0 == 0) goto L_0x0045
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            if (r0 == 0) goto L_0x01a2
            com.google.android.material.appbar.AppBarLayout$LayoutParams r0 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r0
            android.content.Context r2 = r10.getContext()
            if (r2 != 0) goto L_0x0053
            kotlin.g.b.k.a()
        L_0x0053:
            int r2 = com.paytm.utility.b.N((android.content.Context) r2)
            r0.topMargin = r2
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r10.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r2 = 0
            if (r0 == 0) goto L_0x0071
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x0071
            r0.setBackgroundColor(r2)
        L_0x0071:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r10.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            if (r0 == 0) goto L_0x008e
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x008e
            int r3 = net.one97.paytm.recharge.R.id.textView45
            android.view.View r0 = r0.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x008f
        L_0x008e:
            r0 = r1
        L_0x008f:
            if (r0 == 0) goto L_0x0094
            r0.setVisibility(r2)
        L_0x0094:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r10.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            if (r0 == 0) goto L_0x00b1
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x00b1
            int r3 = net.one97.paytm.recharge.R.id.share
            android.view.View r0 = r0.findViewById(r3)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x00b2
        L_0x00b1:
            r0 = r1
        L_0x00b2:
            net.one97.paytm.recharge.ordersummary.b.a r3 = r10.d()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r3 = r3.m
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r10.c()
            long r4 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r3 = r3.get(r4)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r3 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r3
            r4 = 1
            if (r3 == 0) goto L_0x012f
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r3 = r3.getItemLevelActions()
            if (r3 == 0) goto L_0x012f
            java.util.List r3 = r3.getActions()
            if (r3 == 0) goto L_0x012f
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r3 = r3.iterator()
        L_0x00e6:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x012b
            java.lang.Object r6 = r3.next()
            r7 = r6
            net.one97.paytm.recharge.model.CJROSActionItemV2 r7 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r7
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r8 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r8 = r8.getACTION_TYPE_PRO_SHARE()
            java.lang.String r9 = r7.getmType()
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r4)
            if (r8 != 0) goto L_0x0124
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r8 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r8 = r8.getACTION_TYPE_SHARE()
            java.lang.String r9 = r7.getmType()
            boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r4)
            if (r8 == 0) goto L_0x0122
            int r8 = r7.getToolbarVisibility()
            r9 = 2
            if (r8 == r9) goto L_0x0124
            int r7 = r7.getToolbarVisibility()
            r8 = 3
            if (r7 != r8) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r7 = 0
            goto L_0x0125
        L_0x0124:
            r7 = 1
        L_0x0125:
            if (r7 == 0) goto L_0x00e6
            r5.add(r6)
            goto L_0x00e6
        L_0x012b:
            r3 = r5
            java.util.List r3 = (java.util.List) r3
            goto L_0x0130
        L_0x012f:
            r3 = r1
        L_0x0130:
            if (r3 == 0) goto L_0x0165
            int r5 = r3.size()
            if (r5 != r4) goto L_0x0165
            android.content.Context r4 = r10.getContext()
            boolean r4 = r4 instanceof net.one97.paytm.recharge.ordersummary.f.n
            if (r4 == 0) goto L_0x0165
            if (r0 == 0) goto L_0x0158
            kotlin.o r4 = new kotlin.o
            java.lang.Object r5 = r3.get(r2)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r5 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r5
            java.lang.String r5 = r5.getmType()
            java.lang.Object r3 = r3.get(r2)
            r4.<init>(r5, r3)
            r0.setTag(r4)
        L_0x0158:
            if (r0 == 0) goto L_0x0160
            r3 = r10
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r0.setOnClickListener(r3)
        L_0x0160:
            if (r0 == 0) goto L_0x0165
            r0.setVisibility(r2)
        L_0x0165:
            int r0 = net.one97.paytm.recharge.R.id.toolbar
            android.view.View r0 = r10.a((int) r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            if (r0 == 0) goto L_0x0182
            android.view.View r0 = (android.view.View) r0
            int r3 = net.one97.paytm.recharge.R.id.custom_toolbar
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x0182
            int r1 = net.one97.paytm.recharge.R.id.home
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0182:
            if (r1 == 0) goto L_0x0187
            r1.setVisibility(r2)
        L_0x0187:
            if (r1 == 0) goto L_0x0193
            net.one97.paytm.recharge.ordersummary.d.s$l r0 = new net.one97.paytm.recharge.ordersummary.d.s$l
            r0.<init>(r10)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r1.setOnClickListener(r0)
        L_0x0193:
            int r0 = net.one97.paytm.recharge.R.id.appbar_layout
            android.view.View r0 = r10.a((int) r0)
            com.google.android.material.appbar.AppBarLayout r0 = (com.google.android.material.appbar.AppBarLayout) r0
            if (r0 == 0) goto L_0x01a1
            r1 = -1
            r0.setBackgroundColor(r1)
        L_0x01a1:
            return
        L_0x01a2:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.s.e():void");
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64240a;

        l(s sVar) {
            this.f64240a = sVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f64240a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public static final class e extends androidx.core.app.o {
        e() {
        }
    }

    static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64242a;

        n(s sVar) {
            this.f64242a = sVar;
        }

        public final void run() {
            s sVar = this.f64242a;
            View c2 = sVar.f63020b;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            sVar.g(c2);
        }
    }

    public final void c(View view) {
        kotlin.g.b.k.c(view, "view");
        if (d().k.size() > 1) {
            this.w = d().f63999c.subscribe(new h(this), i.f64237a, j.f64238a);
        }
        this.f63020b = LayoutInflater.from(getContext()).inflate(g(), (ViewGroup) null);
        View view2 = this.f63020b;
        if (view2 == null) {
            kotlin.g.b.k.a();
        }
        TextView textView = (TextView) view2.findViewById(R.id.txt_banner_recharge_status);
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d2 = d();
            Context context = textView.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            textView.setText(d2.a(context, false, c(), this.x));
        }
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d3 = d();
            Context context2 = textView.getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            textView.setBackgroundColor(d3.a(context2, c(), this.x));
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.txt_banner_status);
        if (frameLayout != null) {
            frameLayout.addView(this.f63020b, new ViewGroup.LayoutParams(-1, -2));
        }
        Fragment c2 = getChildFragmentManager().c(d().h());
        if (c2 == null || (!kotlin.g.b.k.a((Object) c2.getClass().getName(), (Object) d().h()))) {
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.container_frame_recharge_item);
            if (getContext() != null) {
                Bundle bundle = new Bundle();
                if (getArguments() != null) {
                    bundle.putAll(getArguments());
                }
                Context context3 = getContext();
                if (context3 == null) {
                    kotlin.g.b.k.a();
                }
                Fragment instantiate = Fragment.instantiate(context3, d().h(), bundle);
                kotlin.g.b.k.a((Object) instantiate, "instantiate(context!!, v…rDetailsFragment(), args)");
                this.j = instantiate;
                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                for (Fragment a2 : childFragmentManager.g()) {
                    androidx.fragment.app.q a3 = getChildFragmentManager().a();
                    kotlin.g.b.k.a((Object) a3, "childFragmentManager.beginTransaction()");
                    a3.a(a2);
                    a3.c();
                }
                androidx.fragment.app.q a4 = getChildFragmentManager().a();
                kotlin.g.b.k.a((Object) frameLayout2, "containerFrameRechargeItem");
                int id = frameLayout2.getId();
                Fragment fragment = this.j;
                if (fragment == null) {
                    kotlin.g.b.k.a("successCategoryFragment");
                }
                a4.a(id, fragment, d().h()).c();
            }
        }
    }

    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f64234b;

        f(s sVar, View view) {
            this.f64233a = sVar;
            this.f64234b = view;
        }

        public final void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            NestedScrollView nestedScrollView = (NestedScrollView) this.f64233a.a(R.id.nestedScrollView);
            if (!(nestedScrollView == null || (viewTreeObserver = nestedScrollView.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            this.f64233a.f63019a = new Rect();
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.f64233a.a(R.id.nestedScrollView);
            if (nestedScrollView2 != null) {
                nestedScrollView2.getHitRect(this.f64233a.f63019a);
            }
            int[] iArr = {0, 0};
            NestedScrollView nestedScrollView3 = (NestedScrollView) this.f64233a.a(R.id.nestedScrollView);
            if (nestedScrollView3 != null) {
                nestedScrollView3.getLocationOnScreen(iArr);
            }
            Rect d2 = this.f64233a.f63019a;
            if (d2 != null) {
                d2.left = iArr[0];
            }
            Rect d3 = this.f64233a.f63019a;
            if (d3 != null) {
                d3.top = iArr[1];
            }
            this.f64233a.f(this.f64234b);
        }
    }

    public final void a(View view) {
        ViewTreeObserver viewTreeObserver;
        kotlin.g.b.k.c(view, "view");
        NestedScrollView nestedScrollView = (NestedScrollView) a(R.id.nestedScrollView);
        if (!(nestedScrollView == null || (viewTreeObserver = nestedScrollView.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new f(this, view));
        }
        NestedScrollView nestedScrollView2 = (NestedScrollView) a(R.id.nestedScrollView);
        if (nestedScrollView2 != null) {
            nestedScrollView2.setOnScrollChangeListener(new g(this));
        }
    }

    static final class g implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64235a;

        g(s sVar) {
            this.f64235a = sVar;
        }

        public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            this.f64235a.A = nestedScrollView != null ? nestedScrollView.computeVerticalScrollOffset() : 0;
            if (this.f64235a.A > this.f64235a.z && this.f64235a.B) {
                net.one97.paytm.recharge.ordersummary.widget.a h2 = this.f64235a.y;
                if (h2 != null) {
                    h2.b();
                }
                this.f64235a.B = false;
            } else if (this.f64235a.A < this.f64235a.z && !this.f64235a.B) {
                net.one97.paytm.recharge.ordersummary.widget.a h3 = this.f64235a.y;
                if (h3 != null) {
                    h3.a();
                }
                this.f64235a.B = true;
            }
        }
    }

    public final void f(View view) {
        kotlin.g.b.k.c(view, "view");
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog("initBannerStatusView " + s.class.getSimpleName());
        if (this.v) {
            this.v = false;
            View view2 = this.f63020b;
            if (view2 == null) {
                kotlin.g.b.k.a();
            }
            view2.postDelayed(new d(this), E);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64232a;

        d(s sVar) {
            this.f64232a = sVar;
        }

        public final void run() {
            s sVar = this.f64232a;
            View c2 = sVar.f63020b;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            sVar.g(c2);
        }
    }

    static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64243a;

        o(s sVar) {
            this.f64243a = sVar;
        }

        public final void run() {
            this.f64243a.j();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        if ((r3 == null || r3.isEmpty()) != false) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean q() {
        /*
            r6 = this;
            net.one97.paytm.recharge.ordersummary.b.a r0 = r6.d()
            boolean r0 = r0.s
            r1 = 0
            if (r0 == 0) goto L_0x0084
            net.one97.paytm.recharge.ordersummary.b.a r0 = r6.d()
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r0.k
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 1
            if (r0 <= r2) goto L_0x0084
            net.one97.paytm.recharge.ordersummary.b.a r0 = r6.d()
            boolean r0 = r0.t()
            if (r0 != 0) goto L_0x0083
            net.one97.paytm.recharge.ordersummary.b.a r0 = r6.d()
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r0.k
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0039
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0080
        L_0x0039:
            java.util.Iterator r0 = r0.iterator()
        L_0x003d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0080
            java.lang.Object r3 = r0.next()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            java.lang.String r4 = r3.getItemStatus()
            java.lang.String r5 = "7"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r4)
            r4 = r4 ^ r2
            if (r4 == 0) goto L_0x007b
            net.one97.paytm.common.entity.shopping.CJRRefund r4 = r3.getRefund()
            if (r4 == 0) goto L_0x0079
            net.one97.paytm.common.entity.shopping.CJRRefund r3 = r3.getRefund()
            java.lang.String r4 = "it.refund"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.util.ArrayList r3 = r3.getTransactionDetails()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0076
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r3 = 0
            goto L_0x0077
        L_0x0076:
            r3 = 1
        L_0x0077:
            if (r3 == 0) goto L_0x007b
        L_0x0079:
            r3 = 1
            goto L_0x007c
        L_0x007b:
            r3 = 0
        L_0x007c:
            if (r3 == 0) goto L_0x003d
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            if (r0 == 0) goto L_0x0084
        L_0x0083:
            return r2
        L_0x0084:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.s.q():boolean");
    }

    public final void g(View view) {
        kotlin.g.b.k.c(view, "bannerView");
        if (this.x) {
            view.setVisibility(0);
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.0f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new p(this, view));
        view.setVisibility(4);
        view.startAnimation(scaleAnimation);
    }

    public static final class p implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64244a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f64245b;

        public final void onAnimationEnd(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        p(s sVar, View view) {
            this.f64244a = sVar;
            this.f64245b = view;
        }

        public final void onAnimationStart(Animation animation) {
            this.f64245b.setVisibility(0);
        }
    }

    public final String a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String str;
        String str2;
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart cJROrderedCart;
        String rechargeNumber;
        CJRAttributes attributes;
        CJRAttributes attributes2;
        int i2 = R.string.recharge_of;
        Object[] objArr = new Object[4];
        String str3 = "";
        if (cJROrderSummaryProductDetail == null || (attributes2 = cJROrderSummaryProductDetail.getAttributes()) == null || (str = attributes2.getPayTypeDisplayLabel()) == null) {
            str = str3;
        }
        objArr[0] = str;
        if (cJROrderSummaryProductDetail == null || (attributes = cJROrderSummaryProductDetail.getAttributes()) == null || (str2 = attributes.getOperatorDisplayLabel()) == null) {
            str2 = str3;
        }
        objArr[1] = str2;
        objArr[2] = str3;
        CJROrderSummary cJROrderSummary = this.n;
        if (!(cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || (cJROrderedCart = orderedCartList.get(0)) == null || (rechargeNumber = cJROrderedCart.getRechargeNumber()) == null)) {
            str3 = rechargeNumber;
        }
        objArr[3] = str3;
        String string = getString(i2, objArr);
        kotlin.g.b.k.a((Object) string, "getString(R.string.recha…0)?.rechargeNumber ?: \"\")");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r1.longValue() != r2) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r1.longValue() == r2) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[Catch:{ Exception -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(net.one97.paytm.common.entity.shopping.CJROrderedCart r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0012
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r8.getProductDetail()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0012
            long r1 = r1.getCategoryId()     // Catch:{ Exception -> 0x002e }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            long r2 = net.one97.paytm.recharge.common.utils.ba.f61544f     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            long r4 = r1.longValue()     // Catch:{ Exception -> 0x002e }
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x002d
        L_0x0020:
            long r2 = net.one97.paytm.recharge.common.utils.ba.f61545g     // Catch:{ Exception -> 0x002e }
            if (r1 != 0) goto L_0x0025
            goto L_0x002e
        L_0x0025:
            long r4 = r1.longValue()     // Catch:{ Exception -> 0x002e }
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002e
        L_0x002d:
            return r0
        L_0x002e:
            java.lang.String r8 = super.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.s.c(net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = "view"
            r2 = r19
            kotlin.g.b.k.c(r2, r1)
            boolean r1 = r0.x
            java.lang.String r2 = "context!!"
            r3 = 1
            if (r1 != 0) goto L_0x00f1
            net.one97.paytm.recharge.ordersummary.b.a r1 = r18.d()
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r1 = r1.k
            java.util.List r1 = (java.util.List) r1
            int r1 = r1.size()
            if (r1 <= r3) goto L_0x004a
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 != 0) goto L_0x0025
            kotlin.g.b.k.a()
        L_0x0025:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r10 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r5 = r18.getContext()
            if (r5 != 0) goto L_0x0030
            kotlin.g.b.k.a()
        L_0x0030:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r18.d()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r4 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r7 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.n
            r8 = 2
            r9 = r0
            net.one97.paytm.recharge.ordersummary.f.b r9 = (net.one97.paytm.recharge.ordersummary.f.b) r9
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            android.view.View r10 = (android.view.View) r10
            r1.addView(r10)
        L_0x004a:
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 != 0) goto L_0x0051
            kotlin.g.b.k.a()
        L_0x0051:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r10 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r5 = r18.getContext()
            if (r5 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r18.d()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r4 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r7 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.l
            r8 = 2
            r17 = r0
            net.one97.paytm.recharge.ordersummary.f.b r17 = (net.one97.paytm.recharge.ordersummary.f.b) r17
            r4 = r10
            r9 = r17
            r4.<init>(r5, r6, r7, r8, r9)
            android.view.View r10 = (android.view.View) r10
            r1.addView(r10)
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 != 0) goto L_0x0080
            kotlin.g.b.k.a()
        L_0x0080:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r4 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r12 = r18.getContext()
            if (r12 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            net.one97.paytm.recharge.ordersummary.b.a r13 = r18.d()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r5 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r14 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.m
            r15 = 2
            r11 = r4
            r16 = r17
            r11.<init>(r12, r13, r14, r15, r16)
            android.view.View r4 = (android.view.View) r4
            r1.addView(r4)
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 != 0) goto L_0x00ab
            kotlin.g.b.k.a()
        L_0x00ab:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget r4 = new net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget
            android.content.Context r12 = r18.getContext()
            if (r12 != 0) goto L_0x00b6
            kotlin.g.b.k.a()
        L_0x00b6:
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            net.one97.paytm.recharge.ordersummary.b.a r13 = r18.d()
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$b r5 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.f64459b
            int r14 = net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.k
            r15 = 2
            r11 = r4
            r16 = r17
            r11.<init>(r12, r13, r14, r15, r16)
            android.view.View r4 = (android.view.View) r4
            r1.addView(r4)
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 == 0) goto L_0x00f1
            net.one97.paytm.recharge.ordersummary.widget.CJROrderPaymentDetailsViewV8 r4 = new net.one97.paytm.recharge.ordersummary.widget.CJROrderPaymentDetailsViewV8
            android.content.Context r5 = r18.getContext()
            if (r5 != 0) goto L_0x00de
            kotlin.g.b.k.a()
        L_0x00de:
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r18.d()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = r18.c()
            r4.<init>(r5, r6, r7)
            android.view.View r4 = (android.view.View) r4
            r1.addView(r4)
        L_0x00f1:
            net.one97.paytm.recharge.ordersummary.b.a r1 = r18.d()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r1 = r1.m
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r18.c()
            long r4 = r4.getId()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r1 = r1.get(r4)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r1
            r4 = 0
            if (r1 == 0) goto L_0x0111
            java.util.List r5 = r1.getOrderLevelWidgets()
            goto L_0x0112
        L_0x0111:
            r5 = r4
        L_0x0112:
            boolean r6 = r0.x
            java.lang.String r7 = "activity!!"
            r8 = 2
            r9 = 0
            if (r6 != 0) goto L_0x01ba
            if (r5 == 0) goto L_0x015e
            r6 = r5
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r6 = r6.iterator()
        L_0x012a:
            boolean r11 = r6.hasNext()
            if (r11 == 0) goto L_0x015a
            java.lang.Object r11 = r6.next()
            r12 = r11
            net.one97.paytm.recharge.model.CJROSActionItemV2 r12 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r12
            java.lang.String r13 = r12.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r14 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r14 = r14.getACTION_TYPE_STORE_FRONT()
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x0153
            net.one97.paytm.recharge.ordersummary.b.a r13 = r18.d()
            boolean r12 = r13.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r12, (int) r8, false)
            if (r12 == 0) goto L_0x0153
            r12 = 1
            goto L_0x0154
        L_0x0153:
            r12 = 0
        L_0x0154:
            if (r12 == 0) goto L_0x012a
            r10.add(r11)
            goto L_0x012a
        L_0x015a:
            r6 = r10
            java.util.List r6 = (java.util.List) r6
            goto L_0x015f
        L_0x015e:
            r6 = r4
        L_0x015f:
            if (r6 == 0) goto L_0x01ba
            r10 = r6
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r3
            if (r10 != r3) goto L_0x01ba
            java.lang.Object r6 = r6.get(r9)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r6 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r6
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r6 = r6.getUrlParams()
            if (r6 == 0) goto L_0x017e
            java.lang.String r6 = r6.getUrl()
            r16 = r6
            goto L_0x0180
        L_0x017e:
            r16 = r4
        L_0x0180:
            r6 = r16
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01ba
            boolean r6 = android.webkit.URLUtil.isValidUrl(r16)
            if (r6 == 0) goto L_0x01ba
            android.widget.LinearLayout r6 = r0.f63022d
            if (r6 == 0) goto L_0x01ba
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r17 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView
            androidx.fragment.app.FragmentActivity r11 = r18.getActivity()
            if (r11 != 0) goto L_0x019f
            kotlin.g.b.k.a()
        L_0x019f:
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            net.one97.paytm.recharge.ordersummary.b.a r12 = r18.d()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r13 = r18.c()
            r14 = 0
            r15 = r0
            net.one97.paytm.recharge.ordersummary.f.e r15 = (net.one97.paytm.recharge.ordersummary.f.e) r15
            r10 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r10 = r17
            android.view.View r10 = (android.view.View) r10
            r6.addView(r10)
        L_0x01ba:
            if (r5 == 0) goto L_0x01f5
            r6 = r5
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x01c3:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x01f0
            java.lang.Object r10 = r6.next()
            r11 = r10
            net.one97.paytm.recharge.model.CJROSActionItemV2 r11 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r11
            java.lang.String r12 = r11.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r13 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r13 = r13.getACTION_TYPE_AUTOMATIC()
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x01ec
            net.one97.paytm.recharge.ordersummary.b.a r12 = r18.d()
            boolean r11 = r12.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r11, (int) r8, false)
            if (r11 == 0) goto L_0x01ec
            r11 = 1
            goto L_0x01ed
        L_0x01ec:
            r11 = 0
        L_0x01ed:
            if (r11 == 0) goto L_0x01c3
            goto L_0x01f1
        L_0x01f0:
            r10 = r4
        L_0x01f1:
            r6 = r10
            net.one97.paytm.recharge.model.CJROSActionItemV2 r6 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r6
            goto L_0x01f6
        L_0x01f5:
            r6 = r4
        L_0x01f6:
            if (r6 == 0) goto L_0x0206
            net.one97.paytm.recharge.ordersummary.b.a r6 = r18.d()
            net.one97.paytm.recharge.ordersummary.d.s$b r10 = new net.one97.paytm.recharge.ordersummary.d.s$b
            r10.<init>(r0)
            net.one97.paytm.recharge.common.e.q r10 = (net.one97.paytm.recharge.common.e.q) r10
            r6.a((net.one97.paytm.recharge.common.e.q) r10)
        L_0x0206:
            if (r5 == 0) goto L_0x023d
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x020e:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x023b
            java.lang.Object r6 = r5.next()
            r10 = r6
            net.one97.paytm.recharge.model.CJROSActionItemV2 r10 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r10
            java.lang.String r11 = r10.getmType()
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r12 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r12 = r12.getACTION_TYPE_BILL_CONSENT()
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x0237
            net.one97.paytm.recharge.ordersummary.b.a r11 = r18.d()
            boolean r10 = r11.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r8, false)
            if (r10 == 0) goto L_0x0237
            r10 = 1
            goto L_0x0238
        L_0x0237:
            r10 = 0
        L_0x0238:
            if (r10 == 0) goto L_0x020e
            r4 = r6
        L_0x023b:
            net.one97.paytm.recharge.model.CJROSActionItemV2 r4 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r4
        L_0x023d:
            if (r4 == 0) goto L_0x0242
            r18.r()
        L_0x0242:
            android.content.Context r4 = r18.getContext()
            if (r4 == 0) goto L_0x025f
            net.one97.paytm.recharge.ordersummary.widget.CJRBBPSWidget r5 = new net.one97.paytm.recharge.ordersummary.widget.CJRBBPSWidget
            java.lang.String r6 = "it"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r18.d()
            r5.<init>(r4, r6, r1)
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 == 0) goto L_0x025f
            android.view.View r5 = (android.view.View) r5
            r1.addView(r5)
        L_0x025f:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView$a r1 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.f64443a
            android.content.Context r10 = r18.getContext()
            if (r10 != 0) goto L_0x026a
            kotlin.g.b.k.a()
        L_0x026a:
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r2)
            r11 = 2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r12 = r18.c()
            net.one97.paytm.recharge.ordersummary.b.a r13 = r18.d()
            r14 = r0
            net.one97.paytm.recharge.ordersummary.f.b r14 = (net.one97.paytm.recharge.ordersummary.f.b) r14
            boolean r1 = r0.x
            if (r1 != 0) goto L_0x028d
            net.one97.paytm.recharge.ordersummary.b.a r1 = r18.d()
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r1 = r1.k
            java.util.List r1 = (java.util.List) r1
            int r1 = r1.size()
            if (r1 <= r3) goto L_0x028d
            r15 = 1
            goto L_0x028e
        L_0x028d:
            r15 = 0
        L_0x028e:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r1 = net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView.a.a(r10, r11, r12, r13, r14, r15)
            r0.s = r1
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r1 = r0.s
            if (r1 == 0) goto L_0x02a6
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 != 0) goto L_0x029f
            kotlin.g.b.k.a()
        L_0x029f:
            net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView r2 = r0.s
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
        L_0x02a6:
            boolean r1 = r0.x
            if (r1 != 0) goto L_0x02e2
            net.one97.paytm.recharge.ordersummary.b.a r1 = r18.d()
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x02f1
            android.widget.LinearLayout r1 = r0.f63022d
            if (r1 == 0) goto L_0x02e1
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerView
            androidx.fragment.app.FragmentActivity r9 = r18.getActivity()
            if (r9 != 0) goto L_0x02c3
            kotlin.g.b.k.a()
        L_0x02c3:
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            net.one97.paytm.recharge.ordersummary.b.a r10 = r18.d()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r11 = r18.c()
            r12 = 0
            r13 = r0
            net.one97.paytm.recharge.ordersummary.f.e r13 = (net.one97.paytm.recharge.ordersummary.f.e) r13
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r14 = net.one97.paytm.recharge.di.helper.c.av()
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14)
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2)
        L_0x02e1:
            return
        L_0x02e2:
            int r1 = net.one97.paytm.recharge.R.id.paytm_trust
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargeFooterPaytmTrustView r1 = (net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargeFooterPaytmTrustView) r1
            if (r1 == 0) goto L_0x02f1
            r2 = 8
            r1.setVisibility(r2)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.s.b(android.view.View):void");
    }

    public static final class b implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f64230a;

        b(s sVar) {
            this.f64230a = sVar;
        }

        public final void b() {
            CJRPaymentReminderWidgetV8 b2 = this.f64230a.r;
            if (b2 != null) {
                b2.setAutomaticResponse(this.f64230a.d().n);
            }
        }

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
            CJRPaymentReminderWidgetV8 b2 = this.f64230a.r;
            if (b2 != null) {
                b2.setAutomaticResponse((CJRAutomaticSubscriptionCheckModel) null);
            }
        }

        public final void a(boolean z) {
            if (z) {
                this.f64230a.i();
            }
        }
    }

    public final boolean a(String str, io.reactivex.rxjava3.j.e<String> eVar, io.reactivex.rxjava3.j.e<String> eVar2) {
        kotlin.g.b.k.c(str, "type");
        kotlin.g.b.k.c(eVar, "enableActionObservable");
        kotlin.g.b.k.c(eVar2, "disableActionObservable");
        this.t = eVar;
        this.u = eVar2;
        if (kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC())) {
            d().a((q) new c(eVar));
            return false;
        } else if (!kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_BILL_CONSENT())) {
            return super.a(str, eVar, eVar2);
        } else {
            r();
            return false;
        }
    }

    public static final class c implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ io.reactivex.rxjava3.j.e f64231a;

        public final void a(CJRAutomaticSubscriptionItemModel cJRAutomaticSubscriptionItemModel) {
        }

        public final void a(boolean z) {
        }

        c(io.reactivex.rxjava3.j.e eVar) {
            this.f64231a = eVar;
        }

        public final void b() {
            this.f64231a.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_AUTOMATIC());
        }
    }

    public void setBillConsent(CJROrderSummaryAction cJROrderSummaryAction) {
        net.one97.paytm.recharge.common.h.f fVar;
        net.one97.paytm.recharge.common.utils.j jVar;
        kotlin.g.b.k.c(cJROrderSummaryAction, "action");
        if (this.q && (fVar = this.f63024f) != null && (jVar = fVar.f61441d) != null) {
            androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            jVar.a(childFragmentManager);
        }
    }

    public final void i() {
        Context context = getContext();
        if (context == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) context, "context!!");
        this.r = new CJRPaymentReminderWidgetV8(context, d(), c(), this, 2);
        LinearLayout linearLayout = this.f63022d;
        if (linearLayout == null) {
            kotlin.g.b.k.a();
        }
        linearLayout.addView(this.r, 0);
    }

    private void r() {
        net.one97.paytm.recharge.common.h.f fVar;
        LiveData liveData;
        CJROrderSummarySubscription subscription = c().getSubscription();
        if (!(subscription != null ? subscription.getIsApplicable() : false) && (fVar = this.f63024f) != null && (liveData = fVar.f61442e) != null) {
            liveData.observe(this, new k(this));
        }
    }

    public CJROrderActionsListView getOrderActionClickListener() {
        return this.s;
    }

    public final void f(CJROrderedCart cJROrderedCart) {
        net.one97.paytm.recharge.ordersummary.c.i iVar;
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        if (this.x && (iVar = this.m) != null) {
            iVar.f64077c = false;
        }
        super.f(cJROrderedCart);
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "actionType");
        if (!(getContext() instanceof net.one97.paytm.recharge.ordersummary.f.n)) {
            return;
        }
        if (kotlin.g.b.k.a((Object) str, (Object) CJROSActionItemV2.Companion.getACTION_TYPE_SHARE())) {
            Context context = getContext();
            if (context != null) {
                net.one97.paytm.recharge.ordersummary.f.n nVar = (net.one97.paytm.recharge.ordersummary.f.n) context;
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
                net.one97.paytm.recharge.ordersummary.f.n nVar2 = (net.one97.paytm.recharge.ordersummary.f.n) context2;
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

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.share;
        if (valueOf != null && valueOf.intValue() == i2) {
            CJROrderActionsListView cJROrderActionsListView = this.s;
            if (cJROrderActionsListView != null) {
                cJROrderActionsListView.onClick(view);
                return;
            }
            return;
        }
        super.onClick(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        io.reactivex.rxjava3.b.c cVar = this.w;
        if (cVar != null) {
            if (cVar == null) {
                kotlin.g.b.k.a();
            }
            if (!cVar.isDisposed()) {
                io.reactivex.rxjava3.b.c cVar2 = this.w;
                if (cVar2 == null) {
                    kotlin.g.b.k.a();
                }
                cVar2.dispose();
            }
        }
        b();
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        View view = this.f63020b;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.txt_banner_recharge_status) : null;
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d2 = d();
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            textView.setText(d2.a(context, false, c(), this.x));
        }
        if (textView != null) {
            net.one97.paytm.recharge.ordersummary.b.a d3 = d();
            Context context2 = textView.getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            textView.setBackgroundColor(d3.a(context2, c(), this.x));
        }
        View view2 = getView();
        if (view2 != null) {
            net.one97.paytm.recharge.ordersummary.b.a d4 = d();
            double d5 = d4.f64000d;
            d4.f64000d = 1.0d + d5;
            view2.postDelayed(new o(this), ((long) Math.pow(2.0d, d5)) * 1000);
        }
    }
}
