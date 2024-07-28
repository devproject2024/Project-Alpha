package net.one97.paytm.recharge.mobile_v3.b;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity;
import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.common.e.ad;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.an;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.at;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.utils.u;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.common.widget.CJRPromosViewV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;
import net.one97.paytm.recharge.mobile_v3.a.e;
import net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3;
import net.one97.paytm.recharge.mobile_v3.widget.CJRRechargeEditText;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRInputFieldsItem;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.CJRRelatedCategory;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public class h extends c implements View.OnClickListener, View.OnFocusChangeListener, l.b, ad, net.one97.paytm.recharge.common.e.f, net.one97.paytm.recharge.mobile_v3.d.b, net.one97.paytm.recharge.mobile_v3.d.c, net.one97.paytm.recharge.widgets.b.b {
    public static final a C = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String aa;
    /* access modifiers changed from: package-private */
    public CJRMobileRadioGroupV8<?> A;
    boolean B;
    /* access modifiers changed from: private */
    public CJRCategoryData D;
    /* access modifiers changed from: private */
    public CJRRecentOrderV8.a E;
    private net.one97.paytm.recharge.common.e.n F;
    /* access modifiers changed from: private */
    public CJRPromosViewV8 G;
    private final int H = 2;
    /* access modifiers changed from: private */
    public CJRRecentOrderV8 I;
    /* access modifiers changed from: private */
    public boolean J;
    /* access modifiers changed from: private */
    public z<String> K;
    private z<LinkedList<CJRSelectedGroupItem>> L;
    /* access modifiers changed from: private */
    public boolean M;
    /* access modifiers changed from: private */
    public z<Boolean> N;
    private boolean O;
    private boolean P;
    /* access modifiers changed from: private */
    public NestedScrollView Q;
    private ViewFlipper R;
    private boolean S;
    /* access modifiers changed from: private */
    public View T;
    private boolean U;
    private net.one97.paytm.recharge.mobile_v3.a.e V;
    private CJRFrequentOrder W;
    private Integer X;
    /* access modifiers changed from: private */
    public CJRBaseRechargePromotionalBannerViewV2 Y;
    private final View.OnClickListener Z = new f(this);
    private HashMap ab;

    /* renamed from: f  reason: collision with root package name */
    private final String f63857f = "scroll.view.height";

    public final void E() {
    }

    public void J() {
    }

    public final void a(int i2) {
    }

    public final boolean a() {
        return false;
    }

    public View b(int i2) {
        if (this.ab == null) {
            this.ab = new HashMap();
        }
        View view = (View) this.ab.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.ab.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void u() {
        HashMap hashMap = this.ab;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class b<T> implements z<LinkedList<CJRSelectedGroupItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63858a;

        b(h hVar) {
            this.f63858a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            LinkedList linkedList = (LinkedList) obj;
            if (linkedList != null && this.f63858a.r) {
                this.f63858a.a((LinkedList<CJRSelectedGroupItem>) linkedList);
            }
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.b<CJRFrequentOrder, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRFrequentOrder) obj);
            return x.f47997a;
        }

        public final void invoke(CJRFrequentOrder cJRFrequentOrder) {
            CJRMobileRadioGroupV8 m;
            if (cJRFrequentOrder != null && (m = this.this$0.A) != null) {
                m.setViewSelectedByUser(false);
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.mobile_v3.b.h$h  reason: collision with other inner class name */
    static final class C1251h extends kotlin.g.b.l implements kotlin.g.a.b<CJRCategoryData, x> {
        final /* synthetic */ u $heightViewListener;
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1251h(h hVar, u uVar) {
            super(1);
            this.this$0 = hVar;
            this.$heightViewListener = uVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCategoryData) obj);
            return x.f47997a;
        }

        /* JADX WARNING: type inference failed for: r5v14, types: [androidx.lifecycle.y<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>] */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f9, code lost:
            r2 = r18.getExtnAttrs();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(net.one97.paytm.recharge.model.v4.CJRCategoryData r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.D
                r3 = 0
                if (r2 != 0) goto L_0x0071
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                r2.D = r1
                net.one97.paytm.recharge.di.helper.b r2 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x003f }
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0     // Catch:{ all -> 0x003f }
                android.content.Context r2 = r2.getContext()     // Catch:{ all -> 0x003f }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
                java.lang.String r5 = "/"
                r4.<init>(r5)     // Catch:{ all -> 0x003f }
                net.one97.paytm.recharge.mobile_v3.b.h r5 = r0.this$0     // Catch:{ all -> 0x003f }
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h     // Catch:{ all -> 0x003f }
                if (r5 != 0) goto L_0x002c
                kotlin.g.b.k.a()     // Catch:{ all -> 0x003f }
            L_0x002c:
                java.lang.Object r5 = r5.e()     // Catch:{ all -> 0x003f }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003f }
                r4.append(r5)     // Catch:{ all -> 0x003f }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x003f }
                net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r2, (java.lang.String) r4)     // Catch:{ all -> 0x003f }
                goto L_0x0040
            L_0x003f:
            L_0x0040:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                boolean r2 = r2.s
                if (r2 != 0) goto L_0x00e3
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                androidx.core.widget.NestedScrollView r2 = r2.Q
                if (r2 == 0) goto L_0x005b
                android.view.ViewTreeObserver r2 = r2.getViewTreeObserver()
                if (r2 == 0) goto L_0x005b
                net.one97.paytm.recharge.common.utils.u r4 = r0.$heightViewListener
                android.view.ViewTreeObserver$OnGlobalLayoutListener r4 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r4
                r2.removeOnGlobalLayoutListener(r4)
            L_0x005b:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                androidx.core.widget.NestedScrollView r2 = r2.Q
                if (r2 == 0) goto L_0x00e3
                android.view.ViewTreeObserver r2 = r2.getViewTreeObserver()
                if (r2 == 0) goto L_0x00e3
                net.one97.paytm.recharge.common.utils.u r4 = r0.$heightViewListener
                android.view.ViewTreeObserver$OnGlobalLayoutListener r4 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r4
                r2.addOnGlobalLayoutListener(r4)
                goto L_0x00e3
            L_0x0071:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                if (r2 == 0) goto L_0x007c
                r2.e()
            L_0x007c:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.shimmer_container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
                java.lang.String r4 = "shimmer_container_category_input_fields"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                r2.setClickable(r3)
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.shimmer_container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
                r2.b()
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r2.removeAllViews()
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                androidx.lifecycle.z r2 = r2.K
                if (r2 == 0) goto L_0x00c1
                net.one97.paytm.recharge.mobile_v3.b.h r4 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r4 = r4.f63600h
                if (r4 == 0) goto L_0x00c1
                androidx.lifecycle.y<java.lang.String> r4 = r4.z
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x00c1
                r4.removeObserver(r2)
            L_0x00c1:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                androidx.lifecycle.z r2 = r2.N
                if (r2 == 0) goto L_0x00da
                net.one97.paytm.recharge.mobile_v3.b.h r4 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r4 = r4.f63600h
                if (r4 == 0) goto L_0x00da
                androidx.lifecycle.y<java.lang.Boolean> r4 = r4.H
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x00da
                r4.removeObserver(r2)
            L_0x00da:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r2 = r2.o
                if (r2 == 0) goto L_0x00e3
                r2.g()
            L_0x00e3:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x00f4
                net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.b()
                r2.b((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r4)
            L_0x00f4:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                r4 = 1
                if (r2 == 0) goto L_0x0112
                boolean r2 = r2.f61411d
                if (r2 != r4) goto L_0x0112
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.automatic_add_new_bill_title
                android.view.View r2 = r2.b((int) r5)
                android.widget.TextView r2 = (android.widget.TextView) r2
                if (r2 == 0) goto L_0x0112
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.a(r2)
            L_0x0112:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.toolbar_layout
                android.view.View r2 = r2.b((int) r5)
                net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r2 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r2
                java.lang.String r5 = "toolbar_layout"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
                net.one97.paytm.recharge.mobile_v3.b.h r5 = r0.this$0
                java.lang.String r5 = r5.a((net.one97.paytm.recharge.model.v4.CJRCategoryData) r1)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r2.setTitle(r5)
            L_0x012c:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                r5 = 0
                if (r2 == 0) goto L_0x01e5
                boolean r2 = r2.b()
                if (r2 != r4) goto L_0x01e5
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                if (r2 != 0) goto L_0x0146
                kotlin.g.b.k.a()
            L_0x0146:
                net.one97.paytm.recharge.mobile_v3.b.h r6 = r0.this$0
                android.content.Context r6 = r6.getContext()
                if (r6 != 0) goto L_0x0151
                kotlin.g.b.k.a()
            L_0x0151:
                java.lang.String r7 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                android.view.View r2 = r2.a((android.content.Context) r6)
                if (r2 == 0) goto L_0x0161
                java.lang.Object r6 = r2.getTag()
                goto L_0x0162
            L_0x0161:
                r6 = r5
            L_0x0162:
                boolean r7 = r6 instanceof net.one97.paytm.recharge.common.b.a.C1172a
                if (r7 != 0) goto L_0x0167
                r6 = r5
            L_0x0167:
                net.one97.paytm.recharge.common.b.a$a r6 = (net.one97.paytm.recharge.common.b.a.C1172a) r6
                if (r6 == 0) goto L_0x016e
                net.one97.paytm.recharge.common.b.a$b r6 = r6.f60875a
                goto L_0x016f
            L_0x016e:
                r6 = r5
            L_0x016f:
                if (r6 != 0) goto L_0x0172
                goto L_0x012c
            L_0x0172:
                int[] r7 = net.one97.paytm.recharge.mobile_v3.b.i.f63868a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r4) goto L_0x018c
                r5 = 2
                if (r6 == r5) goto L_0x0180
                goto L_0x012c
            L_0x0180:
                boolean r5 = r2 instanceof net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3
                if (r5 == 0) goto L_0x012c
                net.one97.paytm.recharge.mobile_v3.b.h r5 = r0.this$0
                net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r2 = (net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3) r2
                r5.a((net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3) r2)
                goto L_0x012c
            L_0x018c:
                net.one97.paytm.recharge.mobile_v3.b.h r6 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r6 = r6.f63600h
                if (r6 == 0) goto L_0x012c
                boolean r6 = r6.f61411d
                if (r6 != 0) goto L_0x012c
                net.one97.paytm.recharge.mobile_v3.b.h r6 = r0.this$0
                java.lang.String r7 = "view"
                kotlin.g.b.k.c(r2, r7)
                r7 = r2
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8 r7 = (net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8) r7
                r6.A = r7
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r7 = r6.A
                if (r7 == 0) goto L_0x01b2
                net.one97.paytm.recharge.mobile_v3.b.h$c r8 = new net.one97.paytm.recharge.mobile_v3.b.h$c
                r8.<init>(r6)
                android.widget.RadioGroup$OnCheckedChangeListener r8 = (android.widget.RadioGroup.OnCheckedChangeListener) r8
                r7.setCheckedChangedListener(r8)
            L_0x01b2:
                int r7 = net.one97.paytm.recharge.R.id.container_main
                android.view.View r7 = r6.b((int) r7)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                if (r7 == 0) goto L_0x01bf
                r7.addView(r2, r3)
            L_0x01bf:
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r2 = r6.A
                if (r2 == 0) goto L_0x01d1
                net.one97.paytm.recharge.mobile.d.a r7 = r6.f63600h
                if (r7 != 0) goto L_0x01ca
                kotlin.g.b.k.a()
            L_0x01ca:
                java.util.HashMap<java.lang.String, java.lang.String> r7 = r7.m
                java.util.Map r7 = (java.util.Map) r7
                r2.a(r7)
            L_0x01d1:
                net.one97.paytm.recharge.mobile.d.a r2 = r6.f63600h
                if (r2 == 0) goto L_0x01d7
                androidx.lifecycle.y<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r5 = r2.B
            L_0x01d7:
                androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
                net.one97.paytm.recharge.mobile_v3.b.h$d r2 = new net.one97.paytm.recharge.mobile_v3.b.h$d
                r2.<init>(r6)
                kotlin.g.a.b r2 = (kotlin.g.a.b) r2
                net.one97.paytm.recharge.common.utils.g.a(r6, r5, r2)
                goto L_0x012c
            L_0x01e5:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r6 = net.one97.paytm.recharge.R.id.container_main
                android.view.View r2 = r2.b((int) r6)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                java.lang.String r6 = "container_main"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
                r2.setVisibility(r3)
                if (r1 == 0) goto L_0x0204
                net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r2 = r18.getExtnAttrs()
                if (r2 == 0) goto L_0x0204
                java.lang.String r2 = r2.getBbpsLogoUrl()
                goto L_0x0205
            L_0x0204:
                r2 = r5
            L_0x0205:
                if (r1 == 0) goto L_0x0243
                net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r1 = r18.getExtnAttrs()
                if (r1 == 0) goto L_0x0243
                boolean r1 = r1.isBBPSCategoryLogoEnabled()
                if (r1 != r4) goto L_0x0243
                r1 = r2
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x0243
                boolean r1 = android.webkit.URLUtil.isValidUrl(r2)
                if (r1 == 0) goto L_0x0243
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                android.view.View r1 = r1.T
                if (r1 == 0) goto L_0x022d
                r1.setVisibility(r3)
            L_0x022d:
                com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
                com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                int r6 = net.one97.paytm.recharge.R.id.iv_logo_bbps
                android.view.View r2 = r2.b((int) r6)
                android.widget.ImageView r2 = (android.widget.ImageView) r2
                r1.a((android.widget.ImageView) r2)
                goto L_0x0250
            L_0x0243:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                android.view.View r1 = r1.T
                if (r1 == 0) goto L_0x0250
                r2 = 8
                r1.setVisibility(r2)
            L_0x0250:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                r1.aA_()
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                android.content.Context r1 = r1.getContext()
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                java.lang.String r6 = ""
                if (r2 == 0) goto L_0x026f
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
                if (r2 == 0) goto L_0x026f
                java.lang.String r2 = r2.getCategoryId()
                if (r2 != 0) goto L_0x0270
            L_0x026f:
                r2 = r6
            L_0x0270:
                boolean r1 = net.one97.paytm.recharge.common.utils.az.c(r1, r2)
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.G
                if (r2 == 0) goto L_0x029c
                if (r1 != 0) goto L_0x029c
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r1 = r1.G
                if (r1 != 0) goto L_0x0289
                kotlin.g.b.k.a()
            L_0x0289:
                r1.setVisibility(r3)
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r1 = r1.G
                if (r1 != 0) goto L_0x0297
                kotlin.g.b.k.a()
            L_0x0297:
                r1.e()
                goto L_0x043e
            L_0x029c:
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.Y
                if (r2 == 0) goto L_0x0386
                if (r1 == 0) goto L_0x0336
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r1 = r1.Y
                if (r1 == 0) goto L_0x02ca
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x02c6
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
                if (r2 == 0) goto L_0x02c6
                net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.getCategoryData()
                if (r2 == 0) goto L_0x02c6
                java.lang.String r2 = r2.getVerticalId()
                if (r2 != 0) goto L_0x02c7
            L_0x02c6:
                r2 = r6
            L_0x02c7:
                r1.setVerticalID(r2)
            L_0x02ca:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r1 = r1.Y
                if (r1 == 0) goto L_0x02e8
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 != 0) goto L_0x02dd
                kotlin.g.b.k.a()
            L_0x02dd:
                java.lang.Object r2 = r2.e()
                java.lang.String r2 = r2.toString()
                r1.setScreenNameParams(r2)
            L_0x02e8:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r1 = r1.Y
                if (r1 == 0) goto L_0x02f4
                java.lang.String r5 = r1.getCurrentCategoryId()
            L_0x02f4:
                r1 = r5
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r1 = r1.f63600h
                if (r1 == 0) goto L_0x030f
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r1 = r1.f61409b
                if (r1 == 0) goto L_0x030f
                java.lang.String r1 = r1.getCategoryId()
                if (r1 != 0) goto L_0x0310
            L_0x030f:
                r1 = r6
            L_0x0310:
                boolean r1 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r4)
                if (r1 != 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r1 = r1.Y
                if (r1 == 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x0330
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
                if (r2 == 0) goto L_0x0330
                java.lang.String r2 = r2.getCategoryId()
                if (r2 != 0) goto L_0x0331
            L_0x0330:
                r2 = r6
            L_0x0331:
                r1.a((java.lang.String) r2)
                goto L_0x043e
            L_0x0336:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                int r2 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r1 = r1.b((int) r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                if (r1 == 0) goto L_0x034d
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.Y
                android.view.View r2 = (android.view.View) r2
                r1.removeView(r2)
            L_0x034d:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                r1.Y = r5
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r1.f63600h
                if (r2 == 0) goto L_0x0364
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
                if (r2 == 0) goto L_0x0364
                java.lang.String r2 = r2.getCategoryId()
                if (r2 != 0) goto L_0x0365
            L_0x0364:
                r2 = r6
            L_0x0365:
                r1.k((java.lang.String) r2)
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r1 = r1.G
                if (r1 != 0) goto L_0x0373
                kotlin.g.b.k.a()
            L_0x0373:
                r1.setVisibility(r3)
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r1 = r1.G
                if (r1 != 0) goto L_0x0381
                kotlin.g.b.k.a()
            L_0x0381:
                r1.e()
                goto L_0x043e
            L_0x0386:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                if (r1 == 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r1 = r1.Y
                if (r1 != 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r1 = r1.G
                if (r1 == 0) goto L_0x03ba
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                int r2 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r1 = r1.b((int) r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                if (r1 == 0) goto L_0x03b5
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.G
                android.view.View r2 = (android.view.View) r2
                r1.removeView(r2)
            L_0x03b5:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                r1.G = null
            L_0x03ba:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2
                androidx.fragment.app.FragmentActivity r8 = r1.getActivity()
                if (r8 != 0) goto L_0x03c7
                kotlin.g.b.k.a()
            L_0x03c7:
                java.lang.String r3 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
                net.one97.paytm.recharge.mobile_v3.b.h r3 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r3 = r3.f63600h
                if (r3 == 0) goto L_0x03de
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r3.f61409b
                if (r3 == 0) goto L_0x03de
                java.lang.String r3 = r3.getCategoryId()
                if (r3 != 0) goto L_0x03df
            L_0x03de:
                r3 = r6
            L_0x03df:
                java.lang.String r9 = net.one97.paytm.recharge.common.utils.az.b((java.lang.String) r3)
                r10 = 1
                net.one97.paytm.recharge.mobile_v3.b.h r3 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r3 = r3.f63600h
                if (r3 == 0) goto L_0x03f9
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r3 = r3.f61409b
                if (r3 == 0) goto L_0x03f9
                java.lang.String r3 = r3.getCategoryId()
                if (r3 != 0) goto L_0x03f7
                goto L_0x03f9
            L_0x03f7:
                r11 = r3
                goto L_0x03fa
            L_0x03f9:
                r11 = r6
            L_0x03fa:
                int r12 = net.one97.paytm.recharge.R.color.v3_promo_title_bg
                int r13 = net.one97.paytm.recharge.R.color.v3_text_2
                r14 = 0
                r15 = 0
                r16 = 192(0xc0, float:2.69E-43)
                r7 = r2
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
                r1.Y = r2
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                int r2 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r1 = r1.b((int) r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                if (r1 == 0) goto L_0x043e
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.Y
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.mobile_v3.b.h r3 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r3 = r3.b((int) r5)
                android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
                if (r3 != 0) goto L_0x042c
                kotlin.g.b.k.a()
            L_0x042c:
                net.one97.paytm.recharge.mobile_v3.b.h r5 = r0.this$0
                int r7 = net.one97.paytm.recharge.R.id.container_recents
                android.view.View r5 = r5.b((int) r7)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                int r3 = r3.indexOfChild(r5)
                int r3 = r3 + r4
                r1.addView(r2, r3)
            L_0x043e:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                int r2 = net.one97.paytm.recharge.R.id.footer_menu
                android.view.View r1 = r1.b((int) r2)
                net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3 r1 = (net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3) r1
                if (r1 == 0) goto L_0x045c
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x0458
                java.lang.Object r2 = r2.e()
                if (r2 != 0) goto L_0x0459
            L_0x0458:
                r2 = r6
            L_0x0459:
                r1.setEventCategory(r2)
            L_0x045c:
                net.one97.paytm.recharge.mobile_v3.b.h r1 = r0.this$0
                int r2 = net.one97.paytm.recharge.R.id.footer_menu
                android.view.View r1 = r1.b((int) r2)
                net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3 r1 = (net.one97.paytm.recharge.mobile_v3.widget.CJRFooterViewWidgetV3) r1
                if (r1 == 0) goto L_0x047e
                net.one97.paytm.recharge.mobile_v3.b.h r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x047a
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r2 = r2.f61409b
                if (r2 == 0) goto L_0x047a
                java.lang.String r2 = r2.getCategoryId()
                if (r2 != 0) goto L_0x047b
            L_0x047a:
                r2 = r6
            L_0x047b:
                r1.setCategory(r2)
            L_0x047e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.C1251h.invoke(net.one97.paytm.recharge.model.v4.CJRCategoryData):void");
        }
    }

    static final class i extends kotlin.g.b.l implements kotlin.g.a.b<List<? extends CJRFrequentOrder>, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends CJRFrequentOrder>) (List) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
            r10 = r10.r;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r10) {
            /*
                r9 = this;
                if (r10 == 0) goto L_0x0013
                r0 = r10
                java.util.Collection r0 = (java.util.Collection) r0
                boolean r0 = r0.isEmpty()
                r1 = 1
                r0 = r0 ^ r1
                if (r0 != r1) goto L_0x0013
                net.one97.paytm.recharge.mobile_v3.b.h r0 = r9.this$0
                r0.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r10)
                return
            L_0x0013:
                net.one97.paytm.recharge.mobile_v3.b.h r0 = r9.this$0
                int r1 = net.one97.paytm.recharge.R.id.shimmer_lyt_recent
                android.view.View r0 = r0.b((int) r1)
                net.one97.paytm.common.views.ShimmerFrameLayout r0 = (net.one97.paytm.common.views.ShimmerFrameLayout) r0
                r0.b()
                net.one97.paytm.recharge.mobile_v3.b.h r0 = r9.this$0
                int r1 = net.one97.paytm.recharge.R.id.shimmer_lyt_recent
                android.view.View r0 = r0.b((int) r1)
                net.one97.paytm.common.views.ShimmerFrameLayout r0 = (net.one97.paytm.common.views.ShimmerFrameLayout) r0
                java.lang.String r1 = "shimmer_lyt_recent"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                r1 = 8
                r0.setVisibility(r1)
                net.one97.paytm.recharge.mobile_v3.b.h r0 = r9.this$0
                net.one97.paytm.recharge.common.widget.CJRRecentOrderV8$a r0 = r0.E
                if (r0 == 0) goto L_0x0043
                if (r10 == 0) goto L_0x0043
                net.one97.paytm.recharge.mobile_v3.b.h r0 = r9.this$0
                r0.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r10)
            L_0x0043:
                net.one97.paytm.recharge.mobile_v3.b.h r10 = r9.this$0
                android.content.Context r10 = r10.getContext()
                boolean r10 = net.one97.paytm.recharge.common.utils.z.a((android.content.Context) r10)
                if (r10 == 0) goto L_0x009b
                net.one97.paytm.recharge.ordersummary.h.d r0 = new net.one97.paytm.recharge.ordersummary.h.d
                net.one97.paytm.recharge.mobile_v3.b.h r10 = r9.this$0
                android.content.Context r10 = r10.getContext()
                if (r10 != 0) goto L_0x005c
                kotlin.g.b.k.a()
            L_0x005c:
                java.lang.String r1 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
                r0.<init>(r10)
                net.one97.paytm.recharge.mobile_v3.b.h r10 = r9.this$0
                net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
                if (r10 == 0) goto L_0x0072
                java.lang.Object r10 = r10.e()
                if (r10 != 0) goto L_0x0088
            L_0x0072:
                net.one97.paytm.recharge.mobile_v3.b.h r10 = r9.this$0
                net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
                if (r10 == 0) goto L_0x0083
                net.one97.paytm.common.entity.CJRItem r10 = r10.r
                if (r10 == 0) goto L_0x0083
                java.lang.String r10 = r10.getCategoryId()
                goto L_0x0084
            L_0x0083:
                r10 = 0
            L_0x0084:
                java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.i(r10)
            L_0x0088:
                if (r10 != 0) goto L_0x008c
                java.lang.String r10 = ""
            L_0x008c:
                r1 = r10
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 112(0x70, float:1.57E-43)
                java.lang.String r2 = "recents_not_shown"
                java.lang.String r3 = ""
                java.lang.String r4 = ""
                net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.i.invoke(java.util.List):void");
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63863a;

        j(h hVar) {
            this.f63863a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f63863a.I();
            }
        }
    }

    static final class k extends kotlin.g.b.l implements kotlin.g.a.b<CJRRelatedCategory, x> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(h hVar) {
            super(1);
            this.this$0 = hVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRRelatedCategory) obj);
            return x.f47997a;
        }

        public final void invoke(CJRRelatedCategory cJRRelatedCategory) {
            RadioGroup radioGroup;
            int childCount;
            if (cJRRelatedCategory != null) {
                this.this$0.M = true;
                CJRMobileRadioGroupV8 m = this.this$0.A;
                if (m != null && (radioGroup = m.getRadioGroup()) != null && (childCount = radioGroup.getChildCount()) >= 0) {
                    int i2 = 0;
                    while (true) {
                        View childAt = radioGroup.getChildAt(i2);
                        if ((childAt != null ? childAt.getTag() : null) instanceof CJRRelatedCategory) {
                            Object tag = childAt.getTag();
                            if (tag != null) {
                                CJRRelatedCategory cJRRelatedCategory2 = (CJRRelatedCategory) tag;
                                String value = cJRRelatedCategory.getValue();
                                if (value != null ? value.equals(cJRRelatedCategory2.getValue()) : false) {
                                    radioGroup.check(childAt.getId());
                                    break;
                                }
                            } else {
                                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                            }
                        }
                        if (i2 == childCount) {
                            break;
                        }
                        i2++;
                    }
                }
                this.this$0.M = false;
            }
        }
    }

    static final class o<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63867a;

        o(h hVar) {
            this.f63867a = hVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (this.f63867a.J) {
                this.f63867a.j(str);
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

    static {
        String simpleName = h.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJRMobileLandingFragmentV3::class.java.simpleName");
        aa = simpleName;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v3_fragment_mobile_landing, viewGroup, false);
    }

    public void e(int i2) {
        ViewFlipper viewFlipper = this.R;
        if (viewFlipper != null) {
            if (viewFlipper == null) {
                kotlin.g.b.k.a();
            }
            View findViewById = viewFlipper.findViewById(i2);
            ViewFlipper viewFlipper2 = this.R;
            if (viewFlipper2 == null) {
                kotlin.g.b.k.a();
            }
            ViewFlipper viewFlipper3 = this.R;
            if (viewFlipper3 == null) {
                kotlin.g.b.k.a();
            }
            viewFlipper2.setDisplayedChild(viewFlipper3.indexOfChild(findViewById));
            ViewFlipper viewFlipper4 = this.R;
            if (viewFlipper4 == null) {
                kotlin.g.b.k.a();
            }
            viewFlipper4.setVisibility(0);
            if (findViewById instanceof ShimmerFrameLayout) {
                ((ShimmerFrameLayout) findViewById).a();
            }
        }
    }

    public void aA_() {
        NestedScrollView nestedScrollView = this.Q;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
        ViewFlipper viewFlipper = this.R;
        if (viewFlipper != null) {
            viewFlipper.setVisibility(8);
        }
        ViewFlipper viewFlipper2 = this.R;
        ViewParent parent = viewFlipper2 != null ? viewFlipper2.getParent() : null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            ViewFlipper viewFlipper3 = this.R;
            if (viewFlipper3 == null) {
                kotlin.g.b.k.a();
            }
            viewGroup.removeView(viewFlipper3);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        LiveData<CJRCategoryData> liveData;
        LiveData liveData2;
        HashMap<String, String> hashMap;
        String str;
        LiveData liveData3;
        String str2;
        CJRItem cJRItem;
        String str3;
        String str4;
        CJRItem cJRItem2;
        String categoryId;
        CJRItem cJRItem3;
        CJRItem cJRItem4;
        String str5;
        String str6;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        kotlin.g.b.k.c(view, "view");
        this.U = true;
        this.Q = (NestedScrollView) view.findViewById(R.id.scroll_view);
        this.R = (ViewFlipper) view.findViewById(R.id.shimmer_view_flipper);
        this.T = view.findViewById(R.id.container_logo_bbps);
        e(R.id.lyt_content_shimmer_mobile_landing);
        ((ShimmerFrameLayout) b(R.id.shimmer_lyt_recent)).a();
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_lyt_recent);
        kotlin.g.b.k.a((Object) shimmerFrameLayout, "shimmer_lyt_recent");
        shimmerFrameLayout.setVisibility(0);
        LiveData liveData4 = null;
        if (this.s) {
            NestedScrollView nestedScrollView = this.Q;
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(8);
            }
            CoordinatorLayout.d dVar = new CoordinatorLayout.d(-1, -1);
            NestedScrollView nestedScrollView2 = this.Q;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setFillViewport(true);
            }
            NestedScrollView nestedScrollView3 = this.Q;
            if (nestedScrollView3 != null) {
                nestedScrollView3.setLayoutParams(dVar);
            }
            y();
        } else {
            NestedScrollView nestedScrollView4 = this.Q;
            if (nestedScrollView4 != null) {
                nestedScrollView4.setVisibility(4);
            }
            ViewFlipper viewFlipper = this.R;
            ViewGroup.LayoutParams layoutParams = viewFlipper != null ? viewFlipper.getLayoutParams() : null;
            if (!(layoutParams instanceof CoordinatorLayout.d)) {
                layoutParams = null;
            }
            CoordinatorLayout.d dVar2 = (CoordinatorLayout.d) layoutParams;
            if (dVar2 != null) {
                dVar2.topMargin = com.paytm.utility.b.c(30);
            }
            ViewFlipper viewFlipper2 = this.R;
            if (viewFlipper2 != null) {
                viewFlipper2.setLayoutParams(dVar2);
            }
            O();
        }
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        kotlin.g.b.k.a((Object) toolbar, "toolbar");
        toolbar.setTitle((CharSequence) "");
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        kotlin.g.b.k.a((Object) subtitleCollapsingToolbarLayout, "toolbar_layout");
        ((SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout)).setExpandedTitleTypeface(Typeface.create(subtitleCollapsingToolbarLayout.getExpandedTitleTypeface(), 1));
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout2 = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        kotlin.g.b.k.a((Object) subtitleCollapsingToolbarLayout2, "toolbar_layout");
        ((SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout)).setCollapsedTitleTypeface(Typeface.create(subtitleCollapsingToolbarLayout2.getExpandedTitleTypeface(), 1));
        this.k = new ba(this);
        u uVar = new u(this.f63857f, this);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (cJRCategoryDataHelper = aVar.f61409b) == null) {
            liveData = null;
        } else {
            liveData = cJRCategoryDataHelper.getCategoryLiveData();
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new C1251h(this, uVar));
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            liveData2 = aVar2.f61414g;
        } else {
            liveData2 = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData2, new i(this));
        A();
        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
        if (aVar3 != null) {
            hashMap = aVar3.m;
        } else {
            hashMap = null;
        }
        if (hashMap != null && hashMap.containsKey("promo")) {
            String str7 = hashMap.get("promo");
            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
            if (aVar4 != null) {
                if (str7 == null) {
                    str6 = "";
                } else {
                    str6 = str7;
                }
                aVar4.L = str6;
            }
            hashMap.remove("promo");
            Context context = getContext();
            Object systemService = context != null ? context.getSystemService("clipboard") : null;
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            l.a aVar5 = net.one97.paytm.recharge.common.a.l.f60588i;
            ClipData newPlainText = ClipData.newPlainText(net.one97.paytm.recharge.common.a.l.o, str7);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
        } else if (hashMap != null && hashMap.containsKey(Utility.EVENT_CATEGORY_PROMOCODE)) {
            String str8 = hashMap.get(Utility.EVENT_CATEGORY_PROMOCODE);
            net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
            if (aVar6 != null) {
                if (str8 == null) {
                    str5 = "";
                } else {
                    str5 = str8;
                }
                aVar6.L = str5;
            }
            hashMap.remove(Utility.EVENT_CATEGORY_PROMOCODE);
            Context context2 = getContext();
            Object systemService2 = context2 != null ? context2.getSystemService("clipboard") : null;
            if (!(systemService2 instanceof ClipboardManager)) {
                systemService2 = null;
            }
            ClipboardManager clipboardManager2 = (ClipboardManager) systemService2;
            l.a aVar7 = net.one97.paytm.recharge.common.a.l.f60588i;
            ClipData newPlainText2 = ClipData.newPlainText(net.one97.paytm.recharge.common.a.l.o, str8);
            if (clipboardManager2 != null) {
                clipboardManager2.setPrimaryClip(newPlainText2);
            }
        }
        Context context3 = getContext();
        net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
        if (aVar8 == null || (cJRItem4 = aVar8.r) == null || (str = cJRItem4.getCategoryId()) == null) {
            str = "";
        }
        if (!az.c(context3, str)) {
            net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
            if (aVar9 == null || (cJRItem = aVar9.r) == null || (str2 = cJRItem.getCategoryId()) == null) {
                str2 = "";
            }
            k(str2);
        } else if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
            if (aVar10 == null || (cJRItem3 = aVar10.r) == null || (str3 = cJRItem3.getCategoryId()) == null) {
                str3 = "";
            }
            String b2 = az.b(str3);
            net.one97.paytm.recharge.mobile.d.a aVar11 = this.f63600h;
            if (aVar11 == null || (cJRItem2 = aVar11.r) == null || (categoryId = cJRItem2.getCategoryId()) == null) {
                str4 = "";
            } else {
                str4 = categoryId;
            }
            this.Y = new CJRBaseRechargePromotionalBannerViewV2(activity, b2, true, str4, R.color.v3_promo_title_bg, R.color.v3_text_2, (String) null, (String) null, 192);
            ((LinearLayout) b(R.id.container_content)).addView(this.Y, ((LinearLayout) b(R.id.container_content)).indexOfChild((LinearLayout) b(R.id.container_recents)) + 1);
        }
        this.N = new j(this);
        net.one97.paytm.recharge.mobile.d.a aVar12 = this.f63600h;
        if (!(aVar12 == null || (liveData3 = aVar12.H) == null)) {
            q qVar = this;
            z<Boolean> zVar = this.N;
            if (zVar == null) {
                kotlin.g.b.k.a();
            }
            liveData3.observe(qVar, zVar);
        }
        net.one97.paytm.recharge.mobile.d.a aVar13 = this.f63600h;
        if (aVar13 != null) {
            liveData4 = aVar13.y;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData4, new k(this));
    }

    /* access modifiers changed from: private */
    public final void k(String str) {
        androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
        kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
        CJRPromosViewV8.b bVar = new CJRPromosViewV8.b();
        String string = getString(R.string.title_mobile_promos_landing_screen);
        kotlin.g.b.k.a((Object) string, "getString(R.string.title…le_promos_landing_screen)");
        CJRPromosViewV8.b a2 = bVar.a(string);
        a2.f61914d = getString(R.string.promo_action_copy);
        CJRPromosViewV8.b a3 = a2.a(true, str).a((l.b) this);
        a3.k = this.H;
        CJRPromosViewV8.b a4 = a3.a(R.layout.v3_shimmer_lyt_item_promo).a(CJRRecentOrderV8.b.MOBILE_V3);
        a4.l = this.H;
        this.G = new CJRPromosViewV8(getActivity(), childFragmentManager, a4, this);
        CJRPromosViewV8 cJRPromosViewV8 = this.G;
        if (cJRPromosViewV8 == null) {
            kotlin.g.b.k.a();
        }
        this.F = cJRPromosViewV8.getErrorListener();
        CJRPromosViewV8 cJRPromosViewV82 = this.G;
        if (cJRPromosViewV82 == null) {
            kotlin.g.b.k.a();
        }
        cJRPromosViewV82.f();
        K();
    }

    private void K() {
        if (((LinearLayout) b(R.id.container_content)) != null && ((LinearLayout) b(R.id.container_recents)) != null) {
            LinearLayout linearLayout = (LinearLayout) b(R.id.container_content);
            CJRPromosViewV8 cJRPromosViewV8 = this.G;
            if (cJRPromosViewV8 == null) {
                kotlin.g.b.k.a();
            }
            linearLayout.addView(cJRPromosViewV8, ((LinearLayout) b(R.id.container_content)).indexOfChild((LinearLayout) b(R.id.container_recents)) + 1);
        }
    }

    public String a(CJRCategoryData cJRCategoryData) {
        String str;
        String categoryHeader;
        CJRItem cJRItem;
        String name;
        if (cJRCategoryData != null) {
            str = cJRCategoryData.getCategoryHeader();
        } else {
            str = null;
        }
        CharSequence charSequence = str;
        if (charSequence == null || p.a(charSequence)) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (cJRItem = aVar.r) == null || (name = cJRItem.getName()) == null) {
                return "";
            }
            return name;
        } else if (cJRCategoryData == null || (categoryHeader = cJRCategoryData.getCategoryHeader()) == null) {
            return "";
        } else {
            return categoryHeader;
        }
    }

    public void a(List<? extends CJRFrequentOrder> list) {
        String str;
        CJRItem cJRItem;
        CJRRecentOrderV8.a aVar;
        Object obj;
        Object e2;
        kotlin.g.b.k.c(list, "recents");
        this.S = true;
        if (!this.P) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (aVar2 == null || (e2 = aVar2.e()) == null) {
                obj = "";
            } else {
                obj = e2;
            }
            Integer valueOf = Integer.valueOf(list.size());
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "recents_shown", "", valueOf, str2, (Object) null, (Object) null, 96);
            this.P = true;
        }
        if (this.I == null || this.y) {
            if (getActivity() != null) {
                CJRRecentOrderV8.a aVar3 = new CJRRecentOrderV8.a();
                String string = getString(R.string.recent_title_for_mobile_screen);
                kotlin.g.b.k.a((Object) string, "getString(R.string.recent_title_for_mobile_screen)");
                CJRRecentOrderV8.a a2 = aVar3.a(string);
                a2.f61930h = true;
                a2.s = this;
                CJRRecentOrderV8.a a3 = a2.a(list);
                net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                Context context2 = null;
                if (aVar4 == null || (cJRItem = aVar4.r) == null) {
                    str = null;
                } else {
                    str = cJRItem.getCategoryId();
                }
                a3.o = str;
                CJRRecentOrderV8.a a4 = a3.a(CJRRecentOrderV8.b.MOBILE_V3.ordinal());
                a4.f61927e = this;
                a4.f61928f = this;
                a4.f61929g = this;
                androidx.fragment.app.j childFragmentManager = getChildFragmentManager();
                kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
                CJRRecentOrderV8.a a5 = a4.a(childFragmentManager);
                net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                if (aVar5 == null) {
                    kotlin.g.b.k.a();
                }
                this.E = a5.a((r) aVar5);
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_lyt_recent);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.b();
                }
                ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) b(R.id.shimmer_lyt_recent);
                if (shimmerFrameLayout2 != null) {
                    shimmerFrameLayout2.setVisibility(8);
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    context2 = activity.getApplicationContext();
                }
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                CJRRecentOrderV8.a aVar6 = this.E;
                if (aVar6 == null) {
                    kotlin.g.b.k.a();
                }
                this.I = new CJRRecentOrderV8(context2, aVar6);
                if (this.y) {
                    new Handler().postDelayed(new g(this), 2000);
                } else {
                    LinearLayout linearLayout = (LinearLayout) b(R.id.container_recents);
                    if (linearLayout != null) {
                        linearLayout.addView(this.I);
                    }
                }
            }
            A();
        } else if (list.isEmpty() && (aVar = this.E) != null) {
            aVar.a("");
        }
        this.y = false;
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63862a;

        g(h hVar) {
            this.f63862a = hVar;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f63862a.b(R.id.container_recents);
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f63862a.b(R.id.container_recents);
            if (linearLayout2 != null) {
                linearLayout2.addView(this.f63862a.I);
            }
        }
    }

    public final void b(List<? extends ContactItemModel> list) {
        kotlin.g.b.k.c(list, Tables.CONTACTS);
        CJRRecentOrderV8 cJRRecentOrderV8 = this.I;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.getNotifyAdapterDataChange();
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63859a;

        c(h hVar) {
            this.f63859a = hVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.mobile.d.a b2;
            ShimmerFrameLayout shimmerFrameLayout;
            if (!this.f63859a.M) {
                Object obj = null;
                RadioButton radioButton = radioGroup != null ? (RadioButton) radioGroup.findViewById(i2) : null;
                if ((radioButton != null ? radioButton.getTag() : null) instanceof CJRRelatedCategory) {
                    Object tag = radioButton.getTag();
                    if (tag != null) {
                        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                        if (this.f63859a.o == null && (shimmerFrameLayout = (ShimmerFrameLayout) this.f63859a.b(R.id.shimmer_container_category_input_fields)) != null) {
                            shimmerFrameLayout.a();
                        }
                        CJRMobileRadioGroupV8 m = this.f63859a.A;
                        if (!(m == null || !m.f62091a || (b2 = this.f63859a.f63600h) == null)) {
                            b2.l();
                        }
                        net.one97.paytm.recharge.mobile.d.a b3 = this.f63859a.f63600h;
                        if (b3 != null) {
                            b3.a(cJRRelatedCategory);
                        }
                        net.one97.paytm.recharge.mobile.d.a b4 = this.f63859a.f63600h;
                        if (!(b4 == null || (dVar = b4.v) == null)) {
                            net.one97.paytm.recharge.mobile.d.a b5 = this.f63859a.f63600h;
                            if (b5 != null) {
                                obj = b5.e();
                            }
                            Object obj2 = obj;
                            if (obj2 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj2, kotlin.g.b.k.a(cJRRelatedCategory.getLabel(), (Object) "_selected"), (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                        }
                        this.f63859a.a("get.rc.category", cJRRelatedCategory);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63861a;

        f(h hVar) {
            this.f63861a = hVar;
        }

        public final void onClick(View view) {
            h hVar = this.f63861a;
            net.one97.paytm.recharge.mobile.d.a aVar = hVar.f63600h;
            if (aVar != null) {
                Boolean bool = (Boolean) aVar.H.getValue();
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE)) {
                    CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = hVar.o;
                    if (cJRMobileInputFieldWidgetV3 == null) {
                        kotlin.g.b.k.a();
                    }
                    View view2 = cJRMobileInputFieldWidgetV3;
                    kotlin.g.b.k.c(view2, "view");
                    hVar.B = false;
                    EditText editText = (EditText) hVar.b(R.id.scroll_empty_view);
                    if (editText != null) {
                        editText.clearFocus();
                    }
                    CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = hVar.o;
                    if (cJRMobileInputFieldWidgetV32 != null) {
                        cJRMobileInputFieldWidgetV32.clearFocus();
                    }
                    HashMap hashMap = new HashMap(1);
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            Map map = hashMap;
                            String x = androidx.core.h.u.x(view2);
                            if (x == null) {
                                kotlin.g.b.k.a();
                            }
                            kotlin.g.b.k.a((Object) x, "ViewCompat.getTransitionName(view)!!");
                            map.put(x, view2);
                        } catch (Exception unused) {
                        }
                    }
                    net.one97.paytm.recharge.mobile.d dVar = hVar.f63599g;
                    if (dVar != null) {
                        dVar.a((Map<String, ? extends View>) hashMap);
                    }
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "Enter Mobile Number_field _clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        }
    }

    public void onStart() {
        super.onStart();
        CJRPromosViewV8 cJRPromosViewV8 = this.G;
        if (cJRPromosViewV8 != null) {
            cJRPromosViewV8.g();
        }
        if (this.s) {
            y();
            if (getActivity() instanceof y) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    y yVar = (y) activity;
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        yVar.b(activity2.getResources().getString(R.string.recharge_tabs_toolbar_title));
                        FragmentActivity activity3 = getActivity();
                        if (activity3 != null) {
                            ((y) activity3).az_();
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type android.content.Context");
                    }
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                }
            }
        } else {
            O();
        }
        L();
    }

    public void onResume() {
        super.onResume();
        N();
    }

    public void onStop() {
        x xVar;
        super.onStop();
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            if (this.f61110b != null) {
                t.a(cJRMobileInputFieldWidgetV3);
                xVar = x.f47997a;
            } else {
                xVar = null;
            }
            if (xVar != null) {
                return;
            }
        }
        t tVar = this.f61110b;
        if (tVar != null) {
            tVar.a();
            x xVar2 = x.f47997a;
        }
    }

    public void onDestroyView() {
        CJRCategoryDataHelper cJRCategoryDataHelper;
        net.one97.paytm.recharge.common.b.a aVar;
        w wVar;
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> cVar;
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> cVar2;
        super.onDestroyView();
        this.G = null;
        CJRRecentOrderV8 cJRRecentOrderV8 = this.I;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.e();
        }
        this.I = null;
        this.E = null;
        this.A = null;
        this.D = null;
        this.F = null;
        this.L = null;
        this.K = null;
        this.N = null;
        this.W = null;
        this.X = null;
        this.V = null;
        try {
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (!(aVar2 == null || (cVar2 = aVar2.l) == null)) {
                cVar2.onComplete();
            }
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (!(aVar3 == null || (cVar = aVar3.l) == null)) {
                cVar.c();
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.recharge.common.utils.y yVar = net.one97.paytm.recharge.common.utils.y.f61814b;
        net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.recharge.mobile.d.a) null);
        net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
        if (!(aVar4 == null || (wVar = aVar4.t) == null)) {
            wVar.a();
        }
        net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
        if (!(aVar5 == null || (aVar = aVar5.x) == null)) {
            aVar.a();
        }
        net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
        if (!(aVar6 == null || (cJRCategoryDataHelper = aVar6.f61409b) == null)) {
            cJRCategoryDataHelper.clear();
        }
        u();
    }

    private void O() {
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setVisibility(0);
        }
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        if (subtitleCollapsingToolbarLayout != null) {
            subtitleCollapsingToolbarLayout.setVisibility(0);
        }
        AppBarLayout appBarLayout = (AppBarLayout) b(R.id.appbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setVisibility(0);
        }
        a((Toolbar) b(R.id.toolbar));
        NestedScrollView nestedScrollView = this.Q;
        ViewGroup.LayoutParams layoutParams = nestedScrollView != null ? nestedScrollView.getLayoutParams() : null;
        if (!(layoutParams instanceof CoordinatorLayout.d)) {
            layoutParams = null;
        }
        CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
        if (dVar != null) {
            dVar.a((CoordinatorLayout.Behavior) new AppBarLayout.ScrollingViewBehavior(getContext(), (AttributeSet) null));
        }
        NestedScrollView nestedScrollView2 = this.Q;
        if (nestedScrollView2 != null) {
            nestedScrollView2.setLayoutParams(dVar);
        }
    }

    public final void a(String str, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        int i2;
        ViewTreeObserver viewTreeObserver;
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(onGlobalLayoutListener, "layoutListener");
        if (kotlin.g.b.k.a((Object) str, (Object) this.f63857f) && getView() != null) {
            View view = getView();
            if (view == null) {
                kotlin.g.b.k.a();
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container_footer);
            View view2 = getView();
            if (view2 == null) {
                kotlin.g.b.k.a();
            }
            View findViewById = view2.findViewById(R.id.divider_footer);
            NestedScrollView nestedScrollView = this.Q;
            if (!(nestedScrollView == null || (viewTreeObserver = nestedScrollView.getViewTreeObserver()) == null)) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            View view3 = getView();
            if (view3 == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) view3, "view!!");
            int height = view3.getHeight();
            View view4 = getView();
            if (view4 == null) {
                kotlin.g.b.k.a();
            }
            View findViewById2 = view4.findViewById(R.id.clp_footer_height_controller);
            kotlin.g.b.k.a((Object) findViewById2, "emptyView");
            int height2 = findViewById2.getHeight();
            View view5 = getView();
            if (view5 == null) {
                kotlin.g.b.k.a();
            }
            AppBarLayout appBarLayout = (AppBarLayout) view5.findViewById(R.id.appbar_layout);
            kotlin.g.b.k.a((Object) appBarLayout, "appBarLayout");
            int height3 = appBarLayout.getHeight();
            View view6 = getView();
            if (view6 == null) {
                kotlin.g.b.k.a();
            }
            Toolbar toolbar = (Toolbar) view6.findViewById(R.id.toolbar);
            kotlin.g.b.k.a((Object) toolbar, "toolbarView");
            int height4 = toolbar.getHeight();
            int i3 = height3 - height4;
            NestedScrollView nestedScrollView2 = this.Q;
            int height5 = nestedScrollView2 != null ? nestedScrollView2.getHeight() : 0;
            if (height2 == 0 && height >= (i2 = height5 + i3)) {
                ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
                if (layoutParams != null) {
                    CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
                    AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
                    behavior.setDragCallback(new net.one97.paytm.recharge.widgets.c.f(false));
                    dVar.a((CoordinatorLayout.Behavior) behavior);
                    appBarLayout.setLayoutParams(dVar);
                    androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                    cVar.b(constraintLayout);
                    cVar.a(findViewById2.getId(), 6, 0, 6);
                    cVar.a(findViewById2.getId(), 7, 0, 7);
                    cVar.a(findViewById2.getId(), 3, 0, 3);
                    int id = findViewById2.getId();
                    kotlin.g.b.k.a((Object) findViewById, "footerDivider");
                    cVar.a(id, 4, findViewById.getId(), 3);
                    cVar.a(findViewById2.getId(), height - ((i2 + height4) + findViewById.getHeight()));
                    cVar.c(constraintLayout);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            }
        }
    }

    public boolean a(int i2, int i3, Intent intent) {
        CJRRecentOrderV8 cJRRecentOrderV8;
        Integer num = null;
        if (i2 != 203) {
            if (i2 == 204) {
                if (i3 == -1 && intent != null && intent.getBooleanExtra("is_refresh_needed", false)) {
                    int intExtra = intent.getIntExtra("key_position", -1);
                    intent.getSerializableExtra("selected_automatic_subscribed_item");
                    String str = "key_is_delete_automatic";
                    if (!intent.getBooleanExtra(str, false)) {
                        str = "is_refresh_needed";
                    } else if (getActivity() != null) {
                        h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                        FragmentActivity activity = getActivity();
                        if (activity == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) activity, "activity!!");
                        View a2 = h.a.a((Activity) activity);
                        h.a aVar2 = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                        h.a.a(a2);
                    }
                    CJRRecentOrderV8 cJRRecentOrderV82 = this.I;
                    if (cJRRecentOrderV82 != null) {
                        cJRRecentOrderV82.a(Integer.valueOf(intExtra), str);
                    }
                }
                return true;
            } else if (i2 == 983 && i3 == -1 && intent != null) {
                Serializable serializableExtra = intent.getSerializableExtra("recentItem");
                if (!(serializableExtra instanceof CJRFrequentOrder)) {
                    serializableExtra = null;
                }
                CJRFrequentOrder cJRFrequentOrder = (CJRFrequentOrder) serializableExtra;
                if (cJRFrequentOrder != null) {
                    int intExtra2 = intent.getIntExtra("recentItemPos", 0);
                    net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                    if (aVar3 != null) {
                        aVar3.W = Integer.valueOf(intExtra2);
                    }
                    c(cJRFrequentOrder, intExtra2);
                }
            }
        } else if (i3 == -1) {
            if (intent != null) {
                num = Integer.valueOf(intent.getIntExtra("key_position", -1));
            }
            if ((num == null || num.intValue() != -1) && (cJRRecentOrderV8 = this.I) != null) {
                cJRRecentOrderV8.a(num, "is_refresh_needed");
            }
        }
        return super.a(i2, i3, intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r1 = r1.j();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w() {
        /*
            r6 = this;
            r0 = 0
            r6.B = r0
            boolean r1 = r6.u
            if (r1 != 0) goto L_0x0015
            int r1 = net.one97.paytm.recharge.R.id.scroll_empty_view
            android.view.View r1 = r6.b((int) r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x003d
            r1.requestFocus()
            goto L_0x003d
        L_0x0015:
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            r2 = 0
            if (r1 == 0) goto L_0x0025
            net.one97.paytm.common.entity.recharge.CJRFrequentOrder r1 = r1.j()
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.getRechargeNumber()
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            net.one97.paytm.recharge.mobile.d.a r3 = r6.f63600h
            if (r3 == 0) goto L_0x0036
            androidx.lifecycle.y<java.lang.String> r3 = r3.z
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            if (r3 == 0) goto L_0x0036
            java.lang.Object r2 = r3.getValue()
            java.lang.String r2 = (java.lang.String) r2
        L_0x0036:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r0)
            if (r1 != 0) goto L_0x003d
            return
        L_0x003d:
            r6.O = r0
            boolean r1 = r6.u
            if (r1 != 0) goto L_0x004a
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r1 = r6.o
            if (r1 == 0) goto L_0x004a
            r1.b((boolean) r0)
        L_0x004a:
            androidx.lifecycle.z<java.lang.String> r1 = r6.K
            if (r1 == 0) goto L_0x005b
            net.one97.paytm.recharge.mobile.d.a r2 = r6.f63600h
            if (r2 == 0) goto L_0x005b
            androidx.lifecycle.y<java.lang.String> r2 = r2.z
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x005b
            r2.removeObserver(r1)
        L_0x005b:
            androidx.lifecycle.z<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r1 = r6.L
            if (r1 == 0) goto L_0x006c
            net.one97.paytm.recharge.mobile.d.a r2 = r6.f63600h
            if (r2 == 0) goto L_0x006c
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r2 = r2.F
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x006c
            r2.removeObserver(r1)
        L_0x006c:
            java.util.HashMap r1 = new java.util.HashMap
            r2 = 1
            r1.<init>(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x00a3
            r2 = r1
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x00a2 }
            int r3 = net.one97.paytm.recharge.R.id.btn_proceed     // Catch:{ Exception -> 0x00a2 }
            android.view.View r3 = r6.b((int) r3)     // Catch:{ Exception -> 0x00a2 }
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r3 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r3     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r3 = androidx.core.h.u.x(r3)     // Catch:{ Exception -> 0x00a2 }
            if (r3 != 0) goto L_0x008c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00a2 }
        L_0x008c:
            java.lang.String r4 = "ViewCompat.getTransitionName(btn_proceed)!!"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00a2 }
            int r4 = net.one97.paytm.recharge.R.id.btn_proceed     // Catch:{ Exception -> 0x00a2 }
            android.view.View r4 = r6.b((int) r4)     // Catch:{ Exception -> 0x00a2 }
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r4 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r4     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = "btn_proceed"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x00a2 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a3
        L_0x00a2:
        L_0x00a3:
            r6.u = r0
            net.one97.paytm.recharge.mobile.d r0 = r6.f63599g
            if (r0 == 0) goto L_0x00ae
            java.util.Map r1 = (java.util.Map) r1
            r0.b((java.util.Map<java.lang.String, ? extends android.view.View>) r1)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.w():void");
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63866a;

        n(h hVar) {
            this.f63866a = hVar;
        }

        public final void onClick(View view) {
            h hVar = this.f63866a;
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeEditText cJRRechargeEditText = null;
            net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.ACTION_CLEAR_FIELD_CLICK);
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = hVar.o;
            if (cJRMobileInputFieldWidgetV3 != null) {
                cJRMobileInputFieldWidgetV3.setInputText("");
            }
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = hVar.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.setSecondaryIconVisibility(8);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = hVar.f63600h;
            if (aVar != null) {
                aVar.k();
            }
            FragmentActivity activity = hVar.getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = hVar.o;
                if (cJRMobileInputFieldWidgetV33 != null) {
                    cJRRechargeEditText = cJRMobileInputFieldWidgetV33.getInputView();
                }
                inputMethodManager.showSoftInput(cJRRechargeEditText, 1);
            }
        }
    }

    public final void a(String str, String str2) {
        kotlin.g.b.k.c(str, "mobileNumber");
        this.J = false;
        super.a(str, str2);
    }

    public final void b(CharSequence charSequence, int i2, int i3, int i4) {
        Boolean bool;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3;
        LiveData liveData;
        super.b(charSequence, i2, i3, i4);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData = aVar.H) == null || (bool = (Boolean) liveData.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE) && (cJRMobileInputFieldWidgetV3 = this.o) != null) {
            cJRMobileInputFieldWidgetV3.setDividerColor(R.color.v3_input_focus_out);
        }
    }

    public final void a(CharSequence charSequence, int i2, int i3, int i4) {
        super.a(charSequence, i2, i3, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r11.equals(r2) != true) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x000c
            int r1 = r11.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r2 = r10.b((int) r2)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r2 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r2
            java.lang.String r3 = "btn_proceed"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            int r2 = r2.getId()
            if (r1 != 0) goto L_0x0021
            return
        L_0x0021:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x00f0
            net.one97.paytm.recharge.widgets.c.e r1 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            net.one97.paytm.recharge.widgets.c.e r2 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            int r2 = r2.getDELAY_1000_MILLI()
            boolean r11 = r1.validateIsAlreadyClicked(r11, r2)
            if (r11 == 0) goto L_0x0036
            return
        L_0x0036:
            net.one97.paytm.recharge.widgets.c.d r11 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r11 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.PROCEED_CLICK
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r11)
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0058
            net.one97.paytm.recharge.ordersummary.h.d r1 = r11.v
            java.lang.Object r2 = r11.e()
            java.lang.String r3 = net.one97.paytm.common.utility.d.ez
            java.lang.String r11 = "CJRGTMConstants.GTM_EVENT_PROCEED_CLICKED"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r11)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 124(0x7c, float:1.74E-43)
            net.one97.paytm.recharge.ordersummary.h.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0058:
            java.lang.String r11 = r10.p
            r1 = 1
            if (r11 == 0) goto L_0x006d
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r2 = r10.o
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r2.getInputText()
            goto L_0x0067
        L_0x0066:
            r2 = r0
        L_0x0067:
            boolean r11 = r11.equals(r2)
            if (r11 == r1) goto L_0x008b
        L_0x006d:
            net.one97.paytm.recharge.common.b.a r11 = r10.f63601i
            if (r11 == 0) goto L_0x00f0
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r11 = r10.o
            if (r11 != 0) goto L_0x0078
            kotlin.g.b.k.a()
        L_0x0078:
            android.view.View r11 = (android.view.View) r11
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r2 = r10.o
            if (r2 != 0) goto L_0x0081
            kotlin.g.b.k.a()
        L_0x0081:
            java.lang.String r2 = r2.getInputText()
            boolean r11 = net.one97.paytm.recharge.common.b.a.a((android.view.View) r11, (java.lang.String) r2, (boolean) r1)
            if (r11 != r1) goto L_0x00f0
        L_0x008b:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x00f0
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r2 = r11.G
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x00e1
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r3 = r11.F
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            java.lang.Object r3 = r3.getValue()
            java.util.LinkedList r3 = (java.util.LinkedList) r3
            if (r3 == 0) goto L_0x00d0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r1
            if (r3 != r1) goto L_0x00d0
            java.lang.String r2 = r2.getPaytype()
            if (r2 == 0) goto L_0x00d0
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r3 = r11.y
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r3 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r3
            if (r3 == 0) goto L_0x00c6
            java.lang.String r0 = r3.getValue()
        L_0x00c6:
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
            if (r0 != r1) goto L_0x00d0
            r10.w()
            return
        L_0x00d0:
            r10.r = r1
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r10.o
            if (r0 != 0) goto L_0x00d9
            kotlin.g.b.k.a()
        L_0x00d9:
            java.lang.String r0 = r0.getInputText()
            r11.a((java.lang.String) r0, true)
            return
        L_0x00e1:
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r11 = r10.o
            if (r11 == 0) goto L_0x00eb
            java.lang.String r11 = r11.getInputText()
            if (r11 != 0) goto L_0x00ed
        L_0x00eb:
            java.lang.String r11 = ""
        L_0x00ed:
            r10.a(r11, r0)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.onClick(android.view.View):void");
    }

    public final void l() {
        super.l();
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        CRUFlowModel flowName;
        if (getActivity() != null && isAdded()) {
            if (networkCustomError instanceof an) {
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_container_category_input_fields);
                if (shimmerFrameLayout != null) {
                    shimmerFrameLayout.b();
                }
                CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
                if (cJRMobileInputFieldWidgetV3 != null) {
                    cJRMobileInputFieldWidgetV3.g();
                }
                B();
                if (obj instanceof CJRRechargeErrorModel) {
                    an anVar = (an) networkCustomError;
                    if (anVar.getError() instanceof net.one97.paytm.recharge.common.utils.c) {
                        CRUFlowModel flowName2 = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName2 != null) {
                            flowName2.setErrorType(ERROR_TYPE.AUTH.name());
                        }
                    } else if (anVar.getError() instanceof as) {
                        CRUFlowModel flowName3 = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName3 != null) {
                            flowName3.setErrorType(ERROR_TYPE.NO_CONNECTION.name());
                        }
                    } else {
                        CRUFlowModel flowName4 = ((CJRRechargeErrorModel) obj).getFlowName();
                        if (flowName4 != null) {
                            flowName4.setErrorType(ERROR_TYPE.UNDEFINED.name());
                        }
                    }
                    CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                    CRUFlowModel flowName5 = cJRRechargeErrorModel.getFlowName();
                    CharSequence actionType = flowName5 != null ? flowName5.getActionType() : null;
                    if ((actionType == null || p.a(actionType)) && (flowName = cJRRechargeErrorModel.getFlowName()) != null) {
                        flowName.setActionType(ACTION_TYPE.FETCH_MNP.name());
                    }
                    az azVar = az.f61525a;
                    az.a(cJRRechargeErrorModel);
                }
            } else if (networkCustomError instanceof at) {
                net.one97.paytm.recharge.common.e.n nVar = this.F;
                if (nVar != null) {
                    nVar.a(str, networkCustomError, obj);
                }
            } else {
                super.a(str, networkCustomError, obj);
            }
        }
    }

    public final void a(CJRInstruct cJRInstruct) {
        if (!(cJRInstruct instanceof CJRInstruct.openCouponsActivity) && !(cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity)) {
            super.a(cJRInstruct);
        }
    }

    public final void f() {
        j();
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.OPEN_RECENTS_RECHARGE_SCREEN);
        super.f();
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        if (com.paytm.utility.b.c(getContext())) {
            super.a(cJRFrequentOrder, i2);
            CJRRecentOrderV8 cJRRecentOrderV8 = this.I;
            if (cJRRecentOrderV8 != null) {
                cJRRecentOrderV8.a(cJRFrequentOrder, i2);
                return;
            }
            return;
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.a("", 0, (IJRPaytmDataModel) null, (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), (Object) null);
        }
    }

    public final void d(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        j();
        if (com.paytm.utility.b.c(getContext())) {
            this.W = cJRFrequentOrder;
            this.X = Integer.valueOf(i2);
            e.a aVar = net.one97.paytm.recharge.mobile_v3.a.e.f63750b;
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            String string = context.getString(R.string.delete_recent_bottom_sheet_title);
            kotlin.g.b.k.a((Object) string, "context!!.getString(R.st…ecent_bottom_sheet_title)");
            Context context2 = getContext();
            if (context2 == null) {
                kotlin.g.b.k.a();
            }
            String string2 = context2.getString(R.string.v8_os_cancel_insurence_pst_btn_txt);
            kotlin.g.b.k.a((Object) string2, "context!!.getString(R.st…el_insurence_pst_btn_txt)");
            Context context3 = getContext();
            if (context3 == null) {
                kotlin.g.b.k.a();
            }
            String string3 = context3.getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt);
            Context context4 = getContext();
            if (context4 == null) {
                kotlin.g.b.k.a();
            }
            String string4 = context4.getString(R.string.delete_recent_bottom_sheet_message);
            kotlin.g.b.k.a((Object) string4, "context!!.getString(R.st…ent_bottom_sheet_message)");
            Context context5 = getContext();
            if (context5 == null) {
                kotlin.g.b.k.a();
            }
            String string5 = context5.getString(R.string.delete_recent_bottom_sheet_confirmation_message);
            kotlin.g.b.k.a((Object) string5, "context!!.getString(R.st…eet_confirmation_message)");
            kotlin.g.b.k.c(string, "title");
            kotlin.g.b.k.c(string2, "positiveButtontext");
            kotlin.g.b.k.c(string4, StringSet.messages);
            kotlin.g.b.k.c(string5, "confirmationMsg");
            net.one97.paytm.recharge.mobile_v3.a.e eVar = new net.one97.paytm.recharge.mobile_v3.a.e();
            Bundle bundle = new Bundle();
            bundle.putString("title", string);
            if (!TextUtils.isEmpty(string2)) {
                bundle.putString("posbtntxt", string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                bundle.putString("negbtntxt", string3);
            }
            if (!TextUtils.isEmpty(string5)) {
                bundle.putString(net.one97.paytm.recharge.mobile_v3.a.e.f63751f, string5);
            }
            bundle.putSerializable(StringSet.messages, string4);
            bundle.putInt("bullet_color", R.color.v8_recharge_bullet);
            eVar.setArguments(bundle);
            this.V = eVar;
            net.one97.paytm.recharge.mobile_v3.a.e eVar2 = this.V;
            if (eVar2 == null) {
                kotlin.g.b.k.a();
            }
            eVar2.f64228c = new net.one97.paytm.recharge.widgets.a.b("delete_recents", this);
            net.one97.paytm.recharge.mobile_v3.a.e eVar3 = this.V;
            if (eVar3 == null) {
                kotlin.g.b.k.a();
            }
            eVar3.show(getChildFragmentManager(), net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
            return;
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            aVar2.a("", 0, (IJRPaytmDataModel) null, (NetworkCustomError) new as(false, 1, (kotlin.g.b.g) null), (Object) null);
        }
    }

    public final void c(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        this.J = false;
        super.c(cJRFrequentOrder, i2);
    }

    public final void f(String str) {
        kotlin.g.b.k.c(str, "label");
        super.f("landing_screen");
    }

    public final void g(String str) {
        kotlin.g.b.k.c(str, "label");
        super.g("landing_screen");
    }

    public final void h(String str) {
        kotlin.g.b.k.c(str, "label");
        super.h("landing_screen");
    }

    public final void i(String str) {
        if (str == null) {
            str = "landing_screen";
        }
        super.i(str);
    }

    public final boolean L() {
        if (!this.U) {
            new Handler().postDelayed(new l(this), 100);
            NestedScrollView nestedScrollView = this.Q;
            if (nestedScrollView != null) {
                nestedScrollView.c(0);
            }
        } else {
            NestedScrollView nestedScrollView2 = this.Q;
            if (nestedScrollView2 != null) {
                nestedScrollView2.postDelayed(new m(this), 200);
            }
        }
        this.U = false;
        return false;
    }

    static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63864a;

        l(h hVar) {
            this.f63864a = hVar;
        }

        public final void run() {
            NestedScrollView c2 = this.f63864a.Q;
            if (c2 != null) {
                c2.c(0);
            }
        }
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63865a;

        m(h hVar) {
            this.f63865a = hVar;
        }

        public final void run() {
            NestedScrollView c2 = this.f63865a.Q;
            if (c2 != null) {
                c2.a(33);
            }
        }
    }

    public void onDestroy() {
        this.I = null;
        ba baVar = this.k;
        if (baVar != null) {
            baVar.a((ba.a) null);
        }
        super.onDestroy();
    }

    public final void a(boolean z) {
        if (getActivity() instanceof AJRRechargeUtilityActivity) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((AJRRechargeUtilityActivity) activity).a(z, false);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.activity.AJRRechargeUtilityActivity");
        }
    }

    public void onFocusChange(View view, boolean z) {
        CJRRechargeEditText inputView;
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (!(cJRMobileInputFieldWidgetV3 == null || (inputView = cJRMobileInputFieldWidgetV3.getInputView()) == null)) {
            num = Integer.valueOf(inputView.getId());
        }
        if (!kotlin.g.b.k.a((Object) valueOf, (Object) num)) {
            return;
        }
        if (z) {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.setInputHintTextColor(R.color.v3_text_3);
                return;
            }
            return;
        }
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
        if (cJRMobileInputFieldWidgetV33 != null) {
            cJRMobileInputFieldWidgetV33.setInputHintTextColor(R.color.v3_text_2);
        }
    }

    public final boolean a(String str, MotionEvent motionEvent) {
        Boolean bool;
        LiveData liveData;
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == 1647421367 && str.equals("dispatch.touch.event") && motionEvent != null && motionEvent.getAction() == 1) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: mobile-landing: dispatchTouchEvent to amount-input-field : ".concat(String.valueOf(motionEvent)));
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (liveData = aVar.H) == null || (bool = (Boolean) liveData.getValue()) == null) {
                bool = Boolean.FALSE;
            }
            if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE)) {
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.setVisibility(0);
                }
                this.B = false;
            }
        }
        return false;
    }

    public final boolean a(String str, KeyEvent keyEvent) {
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() == -789823017 && str.equals("dispatch.key.event")) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("key-intercept: mobile-landing screen: dispatchKeyEventPreIme : pressed");
            if (keyEvent != null && keyEvent.getKeyCode() == 4) {
                this.B = true;
                EditText editText = (EditText) b(R.id.scroll_empty_view);
                if (editText != null) {
                    editText.postDelayed(new e(this), 300);
                }
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                if (cJRProceedWidgetV8 != null) {
                    cJRProceedWidgetV8.setVisibility(8);
                }
            }
        }
        return false;
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f63860a;

        e(h hVar) {
            this.f63860a = hVar;
        }

        public final void run() {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.f63860a.o;
            if (cJRMobileInputFieldWidgetV3 != null) {
                cJRMobileInputFieldWidgetV3.clearFocus();
            }
            EditText editText = (EditText) this.f63860a.b(R.id.scroll_empty_view);
            if (editText != null) {
                editText.requestFocus();
            }
        }
    }

    public final boolean ax_() {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        HashMap<String, Stack<String>> actionsMap = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null).getActionsMap();
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        if (actionsMap.containsKey(net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null).getRechargeItemCategoryId())) {
            net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            HashMap<String, Stack<String>> actionsMap2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null).getActionsMap();
            net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            actionsMap2.remove(net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null).getRechargeItemCategoryId());
        }
        return super.ax_();
    }

    public final void a(String str, DialogInterface dialogInterface, int i2) {
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        TextView textView;
        kotlin.g.b.k.c(str, "tag");
        if (str.hashCode() != 1322899172 || !str.equals("delete_recents")) {
            return;
        }
        if (i2 == -2) {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        } else if (this.W != null && this.X != null) {
            net.one97.paytm.recharge.mobile_v3.a.e eVar = this.V;
            if (eVar != null) {
                if (!(eVar.getContext() == null || (textView = (TextView) eVar.a(R.id.positive_button)) == null)) {
                    Context context = eVar.getContext();
                    if (context == null) {
                        kotlin.g.b.k.a();
                    }
                    textView.setTextColor(androidx.core.content.b.c(context, R.color.white));
                }
                CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) eVar.a(R.id.loading_three_dots_lav);
                if (cJRRechargeLottieAnimationView != null) {
                    cJRRechargeLottieAnimationView.setVisibility(0);
                    cJRRechargeLottieAnimationView.setAnimation("Payments-Loader.json");
                    cJRRechargeLottieAnimationView.loop(true);
                    cJRRechargeLottieAnimationView.playAnimation();
                }
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar2 = this.V;
            if (eVar2 != null) {
                eVar2.setCancelable(false);
                eVar2.f63752a = true;
            }
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.DELETE_RECENT_CLICK);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (!(aVar == null || (dVar = aVar.v) == null)) {
                net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
                if (aVar2 == null) {
                    kotlin.g.b.k.a();
                }
                net.one97.paytm.recharge.ordersummary.h.d.a(dVar, aVar2.e(), "clear_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            a2.setErrorType(ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.DELETE_RECENT.name());
            }
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (aVar3 != null) {
                CJRFrequentOrder cJRFrequentOrder = this.W;
                if (cJRFrequentOrder == null) {
                    kotlin.g.b.k.a();
                }
                ai aiVar = this;
                kotlin.g.b.k.c("delete_recents", "tag");
                kotlin.g.b.k.c(cJRFrequentOrder, "recentOrder");
                kotlin.g.b.k.c(aiVar, "onSuccess");
                aVar3.s.a("delete_recents", aiVar, cJRFrequentOrder, (Object) a2);
            }
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        List<CJRFrequentOrder> orderList;
        if (str != null && str.hashCode() == 1322899172 && str.equals("delete_recents")) {
            CJRRecentOrderV8 cJRRecentOrderV8 = this.I;
            if (cJRRecentOrderV8 != null) {
                CJRFrequentOrder cJRFrequentOrder = this.W;
                if (cJRFrequentOrder == null) {
                    kotlin.g.b.k.a();
                }
                Integer num = this.X;
                if (num == null) {
                    kotlin.g.b.k.a();
                }
                cJRRecentOrderV8.a(cJRFrequentOrder, num.intValue());
            }
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                CJRFrequentOrder cJRFrequentOrder2 = this.W;
                if (cJRFrequentOrder2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.c("delete_recents", "tag");
                kotlin.g.b.k.c(cJRFrequentOrder2, "recentOrder");
                aVar.j = cJRFrequentOrder2;
                CJRFrequentOrderList frequentOrderList = CJRRechargeUtilities.INSTANCE.getFrequentOrderList();
                if (!(frequentOrderList == null || (orderList = frequentOrderList.getOrderList()) == null || !orderList.contains(aVar.j))) {
                    frequentOrderList.getOrderList().remove(aVar.j);
                }
                aVar.a("delete_recents", obj);
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar = this.V;
            if (eVar != null) {
                eVar.b();
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar2 = this.V;
            if (eVar2 != null) {
                eVar2.dismiss();
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar3 = this.V;
            if (eVar3 != null) {
                eVar3.a();
                return;
            }
            return;
        }
        super.a_(str, iJRPaytmDataModel, obj);
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        if (str != null && str.hashCode() == 1322899172 && str.equals("delete_recents")) {
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar != null) {
                aVar.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar = this.V;
            if (eVar != null) {
                eVar.b();
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar2 = this.V;
            if (eVar2 != null) {
                eVar2.a();
            }
            net.one97.paytm.recharge.mobile_v3.a.e eVar3 = this.V;
            if (eVar3 != null) {
                eVar3.dismiss();
                return;
            }
            return;
        }
        super.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
    }

    public final boolean a(String str, CJRRelatedCategory cJRRelatedCategory) {
        kotlin.g.b.k.c(str, "tag");
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            String string = getString(R.string.v3_fetching_details);
            kotlin.g.b.k.a((Object) string, "getString(R.string.v3_fetching_details)");
            cJRMobileInputFieldWidgetV3.e(string);
        }
        boolean a2 = super.a(str, cJRRelatedCategory);
        if (!a2) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_container_category_input_fields);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
            if (cJRMobileInputFieldWidgetV32 != null) {
                cJRMobileInputFieldWidgetV32.g();
            }
        }
        return a2;
    }

    public final void a(CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3) {
        String str;
        LiveData liveData;
        LiveData liveData2;
        kotlin.g.b.k.c(cJRMobileInputFieldWidgetV3, "view");
        this.o = cJRMobileInputFieldWidgetV3;
        cJRMobileInputFieldWidgetV3.setFocusOutColor(R.color.v3_text_2);
        cJRMobileInputFieldWidgetV3.setInputHintTextColor(R.color.v3_text_2);
        cJRMobileInputFieldWidgetV3.setInputFocusChangeListener(this);
        cJRMobileInputFieldWidgetV3.f();
        cJRMobileInputFieldWidgetV3.setMInputFieldTextChangeListener(this);
        cJRMobileInputFieldWidgetV3.b(false);
        cJRMobileInputFieldWidgetV3.setInputFieldClickListener(this.Z);
        cJRMobileInputFieldWidgetV3.setOnKeyUpDownListener(this);
        if (cJRMobileInputFieldWidgetV3.getTag() instanceof a.C1172a) {
            Object tag = cJRMobileInputFieldWidgetV3.getTag();
            if (tag != null) {
                a.C1172a aVar = (a.C1172a) tag;
                if (aVar.f60877c instanceof CJRInputFieldsItem) {
                    this.n = (CJRInputFieldsItem) aVar.f60877c;
                    CJRInputFieldsItem cJRInputFieldsItem = this.n;
                    if (cJRInputFieldsItem != null && cJRInputFieldsItem.isShowPhoneBook()) {
                        C();
                    }
                }
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            cJRMobileInputFieldWidgetV3.setTransitionName(getString(R.string.transition_name_input_field_with_action));
        }
        LinearLayout linearLayout = (LinearLayout) b(R.id.container_category_input_fields);
        if (linearLayout != null) {
            linearLayout.addView(cJRMobileInputFieldWidgetV3);
        }
        ViewGroup.LayoutParams layoutParams = cJRMobileInputFieldWidgetV3.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(com.paytm.utility.b.c(21), com.paytm.utility.b.c(10), com.paytm.utility.b.c(21), 0);
            if (this.L == null) {
                this.L = new b(this);
            }
            net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
            if (!(aVar2 == null || (liveData2 = aVar2.F) == null)) {
                q qVar = this;
                z<LinkedList<CJRSelectedGroupItem>> zVar = this.L;
                if (zVar == null) {
                    kotlin.g.b.k.a();
                }
                liveData2.observe(qVar, zVar);
            }
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (!(aVar3 == null || (liveData = aVar3.H) == null)) {
                q qVar2 = this;
                z<Boolean> zVar2 = this.N;
                if (zVar2 == null) {
                    kotlin.g.b.k.a();
                }
                liveData.observe(qVar2, zVar2);
            }
            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
            if (aVar4 == null) {
                kotlin.g.b.k.a();
            }
            String str2 = (String) aVar4.z.getValue();
            if (str2 == null) {
                str2 = "";
            }
            j(str2);
            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
            if (aVar5 != null && !aVar5.A) {
                aVar5.A = true;
                Map map = aVar5.m;
                kotlin.g.b.k.c(map, "deepLinkParams");
                if (map.containsKey("recharge_number")) {
                    str = (String) map.get("recharge_number");
                } else if (map.containsKey("number")) {
                    str = (String) map.get("number");
                } else if (map.containsKey(ContactColumn.PHONE_NUMBER)) {
                    str = (String) map.get(ContactColumn.PHONE_NUMBER);
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    this.p = str;
                    this.q = false;
                    CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
                    if (cJRMobileInputFieldWidgetV32 != null) {
                        cJRMobileInputFieldWidgetV32.setInputText("");
                    }
                    this.q = true;
                    this.x = true;
                    CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
                    if (cJRMobileInputFieldWidgetV33 != null) {
                        cJRMobileInputFieldWidgetV33.a(this.p);
                    }
                }
                if (!com.paytm.utility.b.c(str)) {
                    J();
                }
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                net.one97.paytm.recharge.widgets.c.d.a((CJRRechargeErrorModel) null, ACTION_TYPE.DEEPLINK_MOBILE_NUMBER_ENTERED);
                return;
            }
            return;
        }
        throw new kotlin.u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        r2 = r2.f61413f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void N() {
        /*
            r5 = this;
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 == 0) goto L_0x00b0
            android.content.Context r0 = r5.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x00b0
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x0015
            kotlin.g.b.k.a()
        L_0x0015:
            net.one97.paytm.recharge.common.b.c r0 = r0.s
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00b0
            boolean r0 = r5.S
            r1 = 1
            if (r0 != 0) goto L_0x0058
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            boolean r0 = r0.Q
            if (r0 != 0) goto L_0x0058
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x0034
            kotlin.g.b.k.a()
        L_0x0034:
            r0.Q = r1
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 == 0) goto L_0x0058
            net.one97.paytm.recharge.mobile.d.a r2 = r5.f63600h
            r3 = 0
            if (r2 == 0) goto L_0x004c
            androidx.lifecycle.y<java.lang.String> r2 = r2.f61413f
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x004d
        L_0x004c:
            r2 = r3
        L_0x004d:
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r3 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r3, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r3)
            java.lang.String r4 = "frequent_api"
            r0.a((java.lang.String) r4, (java.lang.String) r2, (java.lang.Object) r3)
        L_0x0058:
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            boolean r0 = r0.R
            if (r0 != 0) goto L_0x0092
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x006a
            kotlin.g.b.k.a()
        L_0x006a:
            io.reactivex.rxjava3.j.c<java.util.List<net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel>> r0 = r0.l
            java.lang.Object r0 = r0.b()
            if (r0 != 0) goto L_0x0092
            net.one97.paytm.recharge.mobile.d.a r0 = r5.f63600h
            if (r0 != 0) goto L_0x0079
            kotlin.g.b.k.a()
        L_0x0079:
            r0.R = r1
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.RECENT_SUBSCRIPTION_STATUS
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.mobile.d.a r2 = r5.f63600h
            if (r2 == 0) goto L_0x0092
            net.one97.paytm.recharge.mobile.d.a r3 = r5.f63600h
            net.one97.paytm.recharge.common.e.ai r3 = (net.one97.paytm.recharge.common.e.ai) r3
            java.lang.String r4 = "check_subscription"
            r2.c((java.lang.String) r4, (net.one97.paytm.recharge.common.e.ai) r3, (java.lang.Object) r0)
        L_0x0092:
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r0 = r5.G
            if (r0 == 0) goto L_0x00b0
            boolean r0 = r0.f61909f
            if (r0 != r1) goto L_0x00b0
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r0 = r5.G
            if (r0 != 0) goto L_0x00a1
            kotlin.g.b.k.a()
        L_0x00a1:
            r1 = 0
            r0.setVisibility(r1)
            net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r0 = r5.G
            if (r0 != 0) goto L_0x00ac
            kotlin.g.b.k.a()
        L_0x00ac:
            r0.e()
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.N():void");
    }

    public void D() {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3 = this.o;
        if (cJRMobileInputFieldWidgetV3 != null) {
            cJRMobileInputFieldWidgetV3.c(false);
        }
        B();
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void j(String str) {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3;
        this.q = false;
        if (net.one97.paytm.recharge.common.utils.g.c(str)) {
            this.p = str;
            if (!this.u) {
                CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32 = this.o;
                if (cJRMobileInputFieldWidgetV32 != null) {
                    cJRMobileInputFieldWidgetV32.setInputText("");
                }
                CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
                if (cJRMobileInputFieldWidgetV33 != null) {
                    cJRMobileInputFieldWidgetV33.a(str);
                }
            }
        } else {
            this.p = null;
            if (!this.u && (cJRMobileInputFieldWidgetV3 = this.o) != null) {
                cJRMobileInputFieldWidgetV3.setInputText("");
            }
        }
        this.q = true;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.p();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r4 = r4.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I() {
        /*
            r6 = this;
            boolean r0 = r6.u
            if (r0 != 0) goto L_0x0011
            int r0 = net.one97.paytm.recharge.R.id.scroll_empty_view
            android.view.View r0 = r6.b((int) r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            if (r0 == 0) goto L_0x0011
            r0.requestFocus()
        L_0x0011:
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r0 = r6.o
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x007e
            r3 = 0
            r0.setInputFieldClickListener(r3)
            r0.b((boolean) r2)
            int r4 = net.one97.paytm.recharge.R.drawable.ic_grey_rounded_cross
            net.one97.paytm.recharge.mobile_v3.b.h$n r5 = new net.one97.paytm.recharge.mobile_v3.b.h$n
            r5.<init>(r6)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r0.c(r4, r5)
            net.one97.paytm.recharge.mobile.d.a r4 = r6.f63600h
            if (r4 == 0) goto L_0x003b
            androidx.lifecycle.y<java.lang.String> r4 = r4.z
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            if (r4 == 0) goto L_0x003b
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x003c
        L_0x003b:
            r4 = r3
        L_0x003c:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x004d
            net.one97.paytm.recharge.mobile_v3.widget.CJRMobileInputFieldWidgetV3 r4 = r6.o
            if (r4 == 0) goto L_0x004d
            r5 = 8
            r4.setSecondaryIconVisibility(r5)
        L_0x004d:
            boolean r4 = r6.O
            if (r4 != 0) goto L_0x0073
            boolean r4 = r6.B
            if (r4 != 0) goto L_0x0073
            r6.O = r2
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 == 0) goto L_0x0064
            java.lang.String r5 = "input_method"
            java.lang.Object r4 = r4.getSystemService(r5)
            goto L_0x0065
        L_0x0064:
            r4 = r3
        L_0x0065:
            boolean r5 = r4 instanceof android.view.inputmethod.InputMethodManager
            if (r5 != 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r3 = r4
        L_0x006b:
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            if (r3 == 0) goto L_0x0073
            r4 = 2
            r3.toggleSoftInput(r4, r1)
        L_0x0073:
            boolean r3 = r6.u
            if (r3 != 0) goto L_0x007e
            boolean r3 = r6.B
            if (r3 != 0) goto L_0x007e
            r0.d()
        L_0x007e:
            boolean r0 = r6.B
            if (r0 != 0) goto L_0x008f
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x008f
            r0.setVisibility(r1)
        L_0x008f:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x009f
            r1 = r6
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x009f:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            if (r0 == 0) goto L_0x00b2
            int r1 = net.one97.paytm.recharge.R.string.proceed_re
            java.lang.String r1 = r6.getString(r1)
            r0.setProceedBtnText(r1)
        L_0x00b2:
            net.one97.paytm.recharge.mobile.d r0 = r6.f63599g
            if (r0 == 0) goto L_0x00bc
            r1 = r6
            net.one97.paytm.recharge.common.e.p r1 = (net.one97.paytm.recharge.common.e.p) r1
            r0.a((net.one97.paytm.recharge.common.e.p) r1)
        L_0x00bc:
            net.one97.paytm.recharge.mobile.d r0 = r6.f63599g
            if (r0 == 0) goto L_0x00c6
            r1 = r6
            net.one97.paytm.recharge.common.e.n r1 = (net.one97.paytm.recharge.common.e.n) r1
            r0.a((net.one97.paytm.recharge.common.e.n) r1)
        L_0x00c6:
            net.one97.paytm.recharge.common.utils.ba r0 = r6.k
            if (r0 == 0) goto L_0x00d0
            r1 = r6
            net.one97.paytm.recharge.common.utils.ba$a r1 = (net.one97.paytm.recharge.common.utils.ba.a) r1
            r0.a((net.one97.paytm.recharge.common.utils.ba.a) r1)
        L_0x00d0:
            androidx.lifecycle.z<java.lang.String> r0 = r6.K
            if (r0 != 0) goto L_0x00dd
            net.one97.paytm.recharge.mobile_v3.b.h$o r0 = new net.one97.paytm.recharge.mobile_v3.b.h$o
            r0.<init>(r6)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r6.K = r0
        L_0x00dd:
            r6.J = r2
            androidx.lifecycle.z<java.lang.String> r0 = r6.K
            if (r0 == 0) goto L_0x00f3
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x00f3
            androidx.lifecycle.y<java.lang.String> r1 = r1.z
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x00f3
            r2 = r6
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            r1.observe(r2, r0)
        L_0x00f3:
            androidx.lifecycle.z<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r0 = r6.L
            if (r0 == 0) goto L_0x0107
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x0107
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r1 = r1.F
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x0107
            r2 = r6
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            r1.observe(r2, r0)
        L_0x0107:
            r6.N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.b.h.I():void");
    }

    public final void F() {
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV3;
        LiveData liveData;
        String str;
        CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV32;
        LiveData liveData2;
        String str2;
        CJRFrequentOrder cJRFrequentOrder;
        net.one97.paytm.recharge.mobile.d.a aVar;
        net.one97.paytm.recharge.ordersummary.h.d dVar;
        Object obj;
        Object e2;
        LiveData liveData3;
        CJRFrequentOrder cJRFrequentOrder2;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        net.one97.paytm.recharge.ordersummary.h.d dVar2;
        Object obj2;
        Object e3;
        LiveData liveData4;
        if (this.q) {
            CJRMobileInputFieldWidgetV3 cJRMobileInputFieldWidgetV33 = this.o;
            Boolean bool = null;
            String inputText = cJRMobileInputFieldWidgetV33 != null ? cJRMobileInputFieldWidgetV33.getInputText() : null;
            if (!TextUtils.isEmpty(inputText)) {
                if (this.v) {
                    str = "phonebook";
                } else if (this.w) {
                    str = "contact screen";
                } else {
                    str = this.x ? "prefilled" : "manual entry";
                }
                String str3 = str;
                String str4 = this.p;
                if (!(str4 != null ? str4.equals(inputText) : false)) {
                    b(inputText, str3);
                    if (!this.x) {
                        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
                        if (aVar3 != null) {
                            cJRFrequentOrder2 = aVar3.j();
                        } else {
                            cJRFrequentOrder2 = null;
                        }
                        if (cJRFrequentOrder2 == null) {
                            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
                            if (!(!az.a(inputText, (List<? extends CJRFrequentOrder>) (aVar4 == null || (liveData4 = aVar4.f61414g) == null) ? null : (List) liveData4.getValue()) || (aVar2 = this.f63600h) == null || (dVar2 = aVar2.v) == null)) {
                                net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63600h;
                                if (aVar5 == null || (e3 = aVar5.e()) == null) {
                                    obj2 = "";
                                } else {
                                    obj2 = e3;
                                }
                                net.one97.paytm.recharge.ordersummary.h.d.a(dVar2, obj2, "repeat_user_entering_mobile_number", (Object) null, str3, (Object) null, (Object) null, (Object) null, 116);
                            }
                        }
                    }
                } else {
                    if (this.f63601i != null) {
                        if (inputText == null) {
                            kotlin.g.b.k.a();
                        }
                        str2 = net.one97.paytm.recharge.common.b.a.a(inputText);
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2 == null) {
                            kotlin.g.b.k.a();
                        }
                        a(str2, str3);
                        if (!this.x) {
                            net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                            if (aVar6 != null) {
                                cJRFrequentOrder = aVar6.j();
                            } else {
                                cJRFrequentOrder = null;
                            }
                            if (cJRFrequentOrder == null) {
                                net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                                if (!(!az.a(inputText, (List<? extends CJRFrequentOrder>) (aVar7 == null || (liveData3 = aVar7.f61414g) == null) ? null : (List) liveData3.getValue()) || (aVar = this.f63600h) == null || (dVar = aVar.v) == null)) {
                                    net.one97.paytm.recharge.mobile.d.a aVar8 = this.f63600h;
                                    if (aVar8 == null || (e2 = aVar8.e()) == null) {
                                        obj = "";
                                    } else {
                                        obj = e2;
                                    }
                                    net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "repeat_user_entering_mobile_number", (Object) null, str3, (Object) null, (Object) null, (Object) null, 116);
                                }
                            }
                        }
                    }
                }
                net.one97.paytm.recharge.mobile.d.a aVar9 = this.f63600h;
                if (!(aVar9 == null || (liveData2 = aVar9.H) == null)) {
                    bool = (Boolean) liveData2.getValue();
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE) && (cJRMobileInputFieldWidgetV32 = this.o) != null) {
                    cJRMobileInputFieldWidgetV32.setSecondaryIconVisibility(0);
                }
                this.w = false;
                this.v = false;
                this.x = false;
            } else {
                net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
                if (!(aVar10 == null || (liveData = aVar10.H) == null)) {
                    bool = (Boolean) liveData.getValue();
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE) && (cJRMobileInputFieldWidgetV3 = this.o) != null) {
                    cJRMobileInputFieldWidgetV3.setSecondaryIconVisibility(8);
                }
            }
            this.J = false;
            net.one97.paytm.recharge.mobile.d.a aVar11 = this.f63600h;
            if (aVar11 != null) {
                if (inputText == null) {
                    inputText = "";
                }
                aVar11.a(inputText);
            }
        }
        this.w = false;
        this.v = false;
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "promo");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.L = p.a(aVar.L, str, true) ? str : "";
            net.one97.paytm.recharge.ordersummary.h.d.a(aVar.v, aVar.e(), "promocode_copy_clicked", (Object) null, str, (Object) null, (Object) null, (Object) null, 116);
        }
    }

    public final LiveData<CJROffers> a(String str, Object obj) {
        String str2;
        CJRCategoryDataHelper cJRCategoryDataHelper;
        kotlin.g.b.k.c(str, "tag");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null) {
            return null;
        }
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 == null || (cJRCategoryDataHelper = aVar2.f61409b) == null || (str2 = cJRCategoryDataHelper.getCategoryId()) == null) {
            str2 = "";
        }
        return aVar.c(str, str2, obj);
    }
}
