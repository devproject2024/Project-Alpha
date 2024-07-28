package net.one97.paytm.recharge.mobile.a;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.contactsSdk.database.Tables;
import com.paytm.network.model.NetworkCustomError;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.shopping.CJROffers;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.common.a.l;
import net.one97.paytm.recharge.common.b.a;
import net.one97.paytm.recharge.common.e.n;
import net.one97.paytm.recharge.common.e.p;
import net.one97.paytm.recharge.common.e.r;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.an;
import net.one97.paytm.recharge.common.utils.at;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.t;
import net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8;
import net.one97.paytm.recharge.common.widget.CJRPromosViewV8;
import net.one97.paytm.recharge.common.widget.CJRRecentOrderV8;
import net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.mobile.widget.CJRMobileInputFieldWidgetV8;
import net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8;
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

public class j extends e implements View.OnClickListener, l.b, net.one97.paytm.recharge.common.e.f {
    public static final a C = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String T;
    /* access modifiers changed from: package-private */
    public CJRMobileRadioGroupV8<?> B;
    /* access modifiers changed from: private */
    public boolean D;
    private n E;
    /* access modifiers changed from: private */
    public CJRCategoryData F;
    private CJRRecentOrderV8.a G;
    private CJRRecentOrderV8 H;
    /* access modifiers changed from: private */
    public CJRPromosViewV8 I;
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
    private boolean Q;
    /* access modifiers changed from: private */
    public CJRBaseRechargePromotionalBannerViewV2 R;
    private final View.OnClickListener S = new e(this);
    private HashMap U;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f63662f;

    public final void E() {
    }

    public void H() {
    }

    public void a(int i2) {
    }

    public final boolean a() {
        return true;
    }

    public View b(int i2) {
        if (this.U == null) {
            this.U = new HashMap();
        }
        View view = (View) this.U.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.U.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void u() {
        HashMap hashMap = this.U;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    static final class b<T> implements z<LinkedList<CJRSelectedGroupItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63663a;

        b(j jVar) {
            this.f63663a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            LinkedList linkedList = (LinkedList) obj;
            if (linkedList != null && this.f63663a.r) {
                this.f63663a.a((LinkedList<CJRSelectedGroupItem>) linkedList);
            }
        }
    }

    static final class d extends kotlin.g.b.l implements kotlin.g.a.b<CJRFrequentOrder, x> {
        final /* synthetic */ j this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j jVar) {
            super(1);
            this.this$0 = jVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRFrequentOrder) obj);
            return x.f47997a;
        }

        public final void invoke(CJRFrequentOrder cJRFrequentOrder) {
            CJRMobileRadioGroupV8 i2;
            if (cJRFrequentOrder != null && (i2 = this.this$0.B) != null) {
                i2.setViewSelectedByUser(false);
            }
        }
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.b<CJRCategoryData, x> {
        final /* synthetic */ j this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(j jVar) {
            super(1);
            this.this$0 = jVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRCategoryData) obj);
            return x.f47997a;
        }

        /* JADX WARNING: type inference failed for: r6v5, types: [androidx.lifecycle.y<net.one97.paytm.common.entity.recharge.CJRFrequentOrder>] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(net.one97.paytm.recharge.model.v4.CJRCategoryData r19) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.model.v4.CJRCategoryData r2 = r2.F
                r3 = 0
                if (r2 != 0) goto L_0x0041
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                r2.F = r1
                net.one97.paytm.recharge.di.helper.b r2 = net.one97.paytm.recharge.di.helper.b.f62652a     // Catch:{ all -> 0x003e }
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0     // Catch:{ all -> 0x003e }
                android.content.Context r2 = r2.getContext()     // Catch:{ all -> 0x003e }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
                java.lang.String r5 = "/"
                r4.<init>(r5)     // Catch:{ all -> 0x003e }
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0     // Catch:{ all -> 0x003e }
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h     // Catch:{ all -> 0x003e }
                if (r5 != 0) goto L_0x002a
                kotlin.g.b.k.a()     // Catch:{ all -> 0x003e }
            L_0x002a:
                java.lang.Object r5 = r5.e()     // Catch:{ all -> 0x003e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003e }
                r4.append(r5)     // Catch:{ all -> 0x003e }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x003e }
                net.one97.paytm.recharge.di.helper.b.a((android.content.Context) r2, (java.lang.String) r4)     // Catch:{ all -> 0x003e }
                goto L_0x00c2
            L_0x003e:
                goto L_0x00c2
            L_0x0041:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                if (r2 == 0) goto L_0x004a
                r2.e()
            L_0x004a:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.shimmer_container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
                java.lang.String r4 = "shimmer_container_category_input_fields"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
                r2.setClickable(r3)
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.shimmer_container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
                r2.b()
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r4 = net.one97.paytm.recharge.R.id.container_category_input_fields
                android.view.View r2 = r2.b((int) r4)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                r2.removeAllViews()
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                androidx.lifecycle.z r2 = r2.K
                if (r2 == 0) goto L_0x008d
                net.one97.paytm.recharge.mobile.a.j r4 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r4 = r4.f63600h
                if (r4 == 0) goto L_0x008d
                androidx.lifecycle.y<java.lang.String> r4 = r4.z
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x008d
                r4.removeObserver(r2)
            L_0x008d:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                androidx.lifecycle.z<java.lang.Boolean> r2 = r2.t
                if (r2 == 0) goto L_0x00ab
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x00ab
                androidx.lifecycle.y<java.lang.Boolean> r2 = r2.K
                androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
                if (r2 == 0) goto L_0x00ab
                net.one97.paytm.recharge.mobile.a.j r4 = r0.this$0
                androidx.lifecycle.z<java.lang.Boolean> r4 = r4.t
                if (r4 != 0) goto L_0x00a8
                kotlin.g.b.k.a()
            L_0x00a8:
                r2.removeObserver(r4)
            L_0x00ab:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                androidx.lifecycle.z r2 = r2.N
                if (r2 == 0) goto L_0x00c2
                net.one97.paytm.recharge.mobile.a.j r4 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r4 = r4.f63600h
                if (r4 == 0) goto L_0x00c2
                androidx.lifecycle.y<java.lang.Boolean> r4 = r4.H
                androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
                if (r4 == 0) goto L_0x00c2
                r4.removeObserver(r2)
            L_0x00c2:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                if (r2 == 0) goto L_0x00d1
                net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
                net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r4 = net.one97.paytm.recharge.widgets.c.d.b()
                r2.b((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r4)
            L_0x00d1:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r2 = r2.f63600h
                r4 = 1
                if (r2 == 0) goto L_0x00ed
                boolean r2 = r2.f61411d
                if (r2 != r4) goto L_0x00ed
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.automatic_add_new_bill_title
                android.view.View r2 = r2.b((int) r5)
                android.widget.TextView r2 = (android.widget.TextView) r2
                if (r2 == 0) goto L_0x00ed
                android.view.View r2 = (android.view.View) r2
                net.one97.paytm.recharge.common.utils.ai.a(r2)
            L_0x00ed:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.toolbar_layout
                android.view.View r2 = r2.b((int) r5)
                net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout r2 = (net.one97.paytm.recharge.common.widget.SubtitleCollapsingToolbarLayout) r2
                java.lang.String r5 = "toolbar_layout"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                java.lang.String r5 = r5.a((net.one97.paytm.recharge.model.v4.CJRCategoryData) r1)
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r2.setTitle(r5)
            L_0x0107:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                r5 = 8
                r6 = 0
                if (r2 == 0) goto L_0x01c5
                boolean r2 = r2.b()
                if (r2 != r4) goto L_0x01c5
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.b.a r2 = r2.f63601i
                if (r2 != 0) goto L_0x011f
                kotlin.g.b.k.a()
            L_0x011f:
                net.one97.paytm.recharge.mobile.a.j r7 = r0.this$0
                android.content.Context r7 = r7.getContext()
                if (r7 != 0) goto L_0x012a
                kotlin.g.b.k.a()
            L_0x012a:
                java.lang.String r8 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
                android.view.View r2 = r2.a((android.content.Context) r7)
                if (r2 == 0) goto L_0x013a
                java.lang.Object r7 = r2.getTag()
                goto L_0x013b
            L_0x013a:
                r7 = r6
            L_0x013b:
                boolean r8 = r7 instanceof net.one97.paytm.recharge.common.b.a.C1172a
                if (r8 != 0) goto L_0x0140
                r7 = r6
            L_0x0140:
                net.one97.paytm.recharge.common.b.a$a r7 = (net.one97.paytm.recharge.common.b.a.C1172a) r7
                if (r7 == 0) goto L_0x0147
                net.one97.paytm.recharge.common.b.a$b r7 = r7.f60875a
                goto L_0x0148
            L_0x0147:
                r7 = r6
            L_0x0148:
                if (r7 != 0) goto L_0x014b
                goto L_0x0107
            L_0x014b:
                int[] r8 = net.one97.paytm.recharge.mobile.a.k.f63671a
                int r7 = r7.ordinal()
                r7 = r8[r7]
                if (r7 == r4) goto L_0x0165
                r5 = 2
                if (r7 == r5) goto L_0x0159
                goto L_0x0107
            L_0x0159:
                boolean r5 = r2 instanceof net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8
                if (r5 == 0) goto L_0x0107
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = (net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r2
                r5.a((net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8) r2)
                goto L_0x0107
            L_0x0165:
                net.one97.paytm.recharge.mobile.a.j r7 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r7 = r7.f63600h
                if (r7 == 0) goto L_0x0107
                boolean r7 = r7.f61411d
                if (r7 != 0) goto L_0x0107
                net.one97.paytm.recharge.mobile.a.j r7 = r0.this$0
                java.lang.String r8 = "view"
                kotlin.g.b.k.c(r2, r8)
                r8 = r2
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8 r8 = (net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8) r8
                r7.B = r8
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r8 = r7.B
                if (r8 == 0) goto L_0x0189
                net.one97.paytm.recharge.mobile.a.j$c r9 = new net.one97.paytm.recharge.mobile.a.j$c
                r9.<init>(r7)
                android.widget.RadioGroup$OnCheckedChangeListener r9 = (android.widget.RadioGroup.OnCheckedChangeListener) r9
                r8.setCheckedChangedListener(r9)
            L_0x0189:
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r8 = r7.B
                if (r8 == 0) goto L_0x0194
                android.widget.TextView r8 = r8.f62092b
                if (r8 == 0) goto L_0x0194
                r8.setVisibility(r5)
            L_0x0194:
                int r5 = net.one97.paytm.recharge.R.id.container_main
                android.view.View r5 = r7.b((int) r5)
                android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
                r5.addView(r2, r3)
                net.one97.paytm.recharge.mobile.widget.CJRMobileRadioGroupV8<?> r2 = r7.B
                if (r2 == 0) goto L_0x01b1
                net.one97.paytm.recharge.mobile.d.a r5 = r7.f63600h
                if (r5 != 0) goto L_0x01aa
                kotlin.g.b.k.a()
            L_0x01aa:
                java.util.HashMap<java.lang.String, java.lang.String> r5 = r5.m
                java.util.Map r5 = (java.util.Map) r5
                r2.a(r5)
            L_0x01b1:
                net.one97.paytm.recharge.mobile.d.a r2 = r7.f63600h
                if (r2 == 0) goto L_0x01b7
                androidx.lifecycle.y<net.one97.paytm.common.entity.recharge.CJRFrequentOrder> r6 = r2.B
            L_0x01b7:
                androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
                net.one97.paytm.recharge.mobile.a.j$d r2 = new net.one97.paytm.recharge.mobile.a.j$d
                r2.<init>(r7)
                kotlin.g.a.b r2 = (kotlin.g.a.b) r2
                net.one97.paytm.recharge.common.utils.g.a(r7, r6, r2)
                goto L_0x0107
            L_0x01c5:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r7 = net.one97.paytm.recharge.R.id.lyt_shimmer_category
                android.view.View r2 = r2.b((int) r7)
                androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
                java.lang.String r7 = "lyt_shimmer_category"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
                r2.setVisibility(r5)
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.container_main
                android.view.View r2 = r2.b((int) r5)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                java.lang.String r5 = "container_main"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
                r2.setVisibility(r3)
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0     // Catch:{ Exception -> 0x01f9 }
                int r5 = net.one97.paytm.recharge.R.id.shimmer_mobile     // Catch:{ Exception -> 0x01f9 }
                android.view.View r2 = r2.b((int) r5)     // Catch:{ Exception -> 0x01f9 }
                net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2     // Catch:{ Exception -> 0x01f9 }
                if (r2 == 0) goto L_0x01fa
                r2.b()     // Catch:{ Exception -> 0x01f9 }
                goto L_0x01fa
            L_0x01f9:
            L_0x01fa:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                android.content.Context r2 = r2.getContext()
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h
                java.lang.String r7 = ""
                if (r5 == 0) goto L_0x0212
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
                if (r5 == 0) goto L_0x0212
                java.lang.String r5 = r5.getCategoryId()
                if (r5 != 0) goto L_0x0213
            L_0x0212:
                r5 = r7
            L_0x0213:
                boolean r2 = net.one97.paytm.recharge.common.utils.az.c(r2, r5)
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r5 = r5.I
                if (r5 == 0) goto L_0x023f
                if (r2 != 0) goto L_0x023f
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.I
                if (r2 != 0) goto L_0x022c
                kotlin.g.b.k.a()
            L_0x022c:
                r2.setVisibility(r3)
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.I
                if (r2 != 0) goto L_0x023a
                kotlin.g.b.k.a()
            L_0x023a:
                r2.e()
                goto L_0x03b2
            L_0x023f:
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r5 = r5.R
                if (r5 == 0) goto L_0x031b
                if (r2 == 0) goto L_0x02d3
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.R
                if (r2 == 0) goto L_0x026b
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h
                if (r5 == 0) goto L_0x0267
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
                if (r5 == 0) goto L_0x0267
                net.one97.paytm.recharge.model.v4.CJRCategoryData r5 = r5.getCategoryData()
                if (r5 == 0) goto L_0x0267
                java.lang.String r5 = r5.getVerticalId()
                if (r5 != 0) goto L_0x0268
            L_0x0267:
                r5 = r7
            L_0x0268:
                r2.setVerticalID(r5)
            L_0x026b:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.R
                if (r2 == 0) goto L_0x0287
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h
                if (r5 != 0) goto L_0x027c
                kotlin.g.b.k.a()
            L_0x027c:
                java.lang.Object r5 = r5.e()
                java.lang.String r5 = r5.toString()
                r2.setScreenNameParams(r5)
            L_0x0287:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.R
                if (r2 == 0) goto L_0x0294
                java.lang.String r2 = r2.getCurrentCategoryId()
                goto L_0x0295
            L_0x0294:
                r2 = r6
            L_0x0295:
                r5 = r2
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h
                if (r5 == 0) goto L_0x02ae
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
                if (r5 == 0) goto L_0x02ae
                java.lang.String r5 = r5.getCategoryId()
                if (r5 != 0) goto L_0x02af
            L_0x02ae:
                r5 = r7
            L_0x02af:
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r4)
                if (r2 != 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.R
                if (r2 == 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r5.f63600h
                if (r5 == 0) goto L_0x02cd
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
                if (r5 == 0) goto L_0x02cd
                java.lang.String r5 = r5.getCategoryId()
                if (r5 != 0) goto L_0x02ce
            L_0x02cd:
                r5 = r7
            L_0x02ce:
                r2.a((java.lang.String) r5)
                goto L_0x03b2
            L_0x02d3:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r2 = r2.b((int) r5)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                if (r2 == 0) goto L_0x02ea
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r5 = r5.R
                android.view.View r5 = (android.view.View) r5
                r2.removeView(r5)
            L_0x02ea:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                r2.R = r6
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r5 = r2.f63600h
                if (r5 == 0) goto L_0x02ff
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r5 = r5.f61409b
                if (r5 == 0) goto L_0x02ff
                java.lang.String r5 = r5.getCategoryId()
                if (r5 != 0) goto L_0x0300
            L_0x02ff:
                r5 = r7
            L_0x0300:
                r2.k(r5)
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.I
                if (r2 == 0) goto L_0x030e
                r2.setVisibility(r3)
            L_0x030e:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.I
                if (r2 == 0) goto L_0x03b2
                r2.e()
                goto L_0x03b2
            L_0x031b:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                if (r2 == 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r2 = r2.R
                if (r2 != 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r2 = r2.I
                if (r2 == 0) goto L_0x034f
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r2 = r2.b((int) r5)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                if (r2 == 0) goto L_0x034a
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.common.widget.CJRPromosViewV8 r5 = r5.I
                android.view.View r5 = (android.view.View) r5
                r2.removeView(r5)
            L_0x034a:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                r2.I = null
            L_0x034f:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r5 = new net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2
                androidx.fragment.app.FragmentActivity r9 = r2.getActivity()
                if (r9 != 0) goto L_0x035c
                kotlin.g.b.k.a()
            L_0x035c:
                java.lang.String r8 = "activity!!"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r8)
                net.one97.paytm.recharge.mobile.a.j r8 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r8 = r8.f63600h
                if (r8 == 0) goto L_0x0371
                net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper r8 = r8.f61409b
                if (r8 == 0) goto L_0x0371
                java.lang.String r8 = r8.getCategoryId()
                if (r8 != 0) goto L_0x0372
            L_0x0371:
                r8 = r7
            L_0x0372:
                java.lang.String r10 = net.one97.paytm.recharge.common.utils.az.b((java.lang.String) r8)
                r11 = 1
                net.one97.paytm.recharge.mobile.a.j r8 = r0.this$0
                net.one97.paytm.recharge.mobile.d.a r8 = r8.f63600h
                if (r8 == 0) goto L_0x038a
                net.one97.paytm.common.entity.CJRItem r8 = r8.r
                if (r8 == 0) goto L_0x038a
                java.lang.String r8 = r8.getCategoryId()
                if (r8 != 0) goto L_0x0388
                goto L_0x038a
            L_0x0388:
                r12 = r8
                goto L_0x038b
            L_0x038a:
                r12 = r7
            L_0x038b:
                int r13 = net.one97.paytm.recharge.R.color.color_f3f7f8
                int r14 = net.one97.paytm.recharge.R.color.color_8f969c
                r15 = 0
                r16 = 0
                r17 = 192(0xc0, float:2.69E-43)
                r8 = r5
                r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)
                r2.R = r5
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                int r5 = net.one97.paytm.recharge.R.id.container_content
                android.view.View r2 = r2.b((int) r5)
                android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
                if (r2 == 0) goto L_0x03b2
                net.one97.paytm.recharge.mobile.a.j r5 = r0.this$0
                net.one97.paytm.recharge.ordersummary.widget.CJRBaseRechargePromotionalBannerViewV2 r5 = r5.R
                android.view.View r5 = (android.view.View) r5
                r2.addView(r5)
            L_0x03b2:
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                if (r1 == 0) goto L_0x03c0
                net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r5 = r19.getExtnAttrs()
                if (r5 == 0) goto L_0x03c0
                java.lang.String r6 = r5.getBbpsLogoUrl()
            L_0x03c0:
                r2.f63662f = r6
                net.one97.paytm.recharge.mobile.a.j r2 = r0.this$0
                if (r1 == 0) goto L_0x03d4
                net.one97.paytm.recharge.model.v4.CJRExtensionAttributes r1 = r19.getExtnAttrs()
                if (r1 == 0) goto L_0x03d4
                boolean r1 = r1.isBBPSCategoryLogoEnabled()
                if (r1 != r4) goto L_0x03d4
                r3 = 1
            L_0x03d4:
                r2.D = r3
                net.one97.paytm.recharge.mobile.a.j r1 = r0.this$0
                r1.I()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.j.f.invoke(net.one97.paytm.recharge.model.v4.CJRCategoryData):void");
        }
    }

    static final class g extends kotlin.g.b.l implements kotlin.g.a.b<List<? extends CJRFrequentOrder>, x> {
        final /* synthetic */ j this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(j jVar) {
            super(1);
            this.this$0 = jVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends CJRFrequentOrder>) (List) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
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
                net.one97.paytm.recharge.mobile.a.j r0 = r9.this$0
                r0.a((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRFrequentOrder>) r10)
                return
            L_0x0013:
                net.one97.paytm.recharge.mobile.a.j r10 = r9.this$0
                android.content.Context r10 = r10.getContext()
                if (r10 == 0) goto L_0x006f
                net.one97.paytm.recharge.mobile.a.j r10 = r9.this$0
                android.content.Context r10 = r10.getContext()
                boolean r10 = com.paytm.utility.d.c(r10)
                if (r10 == 0) goto L_0x006f
                net.one97.paytm.recharge.ordersummary.h.d r0 = new net.one97.paytm.recharge.ordersummary.h.d
                net.one97.paytm.recharge.mobile.a.j r10 = r9.this$0
                android.content.Context r10 = r10.getContext()
                if (r10 != 0) goto L_0x0034
                kotlin.g.b.k.a()
            L_0x0034:
                java.lang.String r1 = "context!!"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
                r0.<init>(r10)
                net.one97.paytm.recharge.mobile.a.j r10 = r9.this$0
                net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
                if (r10 == 0) goto L_0x0048
                java.lang.Object r10 = r10.e()
                if (r10 != 0) goto L_0x005c
            L_0x0048:
                net.one97.paytm.recharge.mobile.a.j r10 = r9.this$0
                net.one97.paytm.recharge.mobile.d.a r10 = r10.f63600h
                if (r10 == 0) goto L_0x0057
                net.one97.paytm.common.entity.CJRItem r10 = r10.r
                if (r10 == 0) goto L_0x0057
                java.lang.String r10 = r10.getCategoryId()
                goto L_0x0058
            L_0x0057:
                r10 = 0
            L_0x0058:
                java.lang.String r10 = net.one97.paytm.recharge.common.utils.ba.i(r10)
            L_0x005c:
                if (r10 != 0) goto L_0x0060
                java.lang.String r10 = ""
            L_0x0060:
                r1 = r10
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 112(0x70, float:1.57E-43)
                java.lang.String r2 = "recents_not_shown"
                java.lang.String r3 = ""
                java.lang.String r4 = ""
                net.one97.paytm.recharge.ordersummary.h.d.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            L_0x006f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.j.g.invoke(java.util.List):void");
        }
    }

    static final class h<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63666a;

        h(j jVar) {
            this.f63666a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (kotlin.g.b.k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f63666a.ay_();
            }
        }
    }

    static final class i extends kotlin.g.b.l implements kotlin.g.a.b<CJRRelatedCategory, x> {
        final /* synthetic */ j this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(j jVar) {
            super(1);
            this.this$0 = jVar;
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
                CJRMobileRadioGroupV8 i2 = this.this$0.B;
                if (i2 != null && (radioGroup = i2.getRadioGroup()) != null && (childCount = radioGroup.getChildCount()) >= 0) {
                    int i3 = 0;
                    while (true) {
                        View childAt = radioGroup.getChildAt(i3);
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
                                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                            }
                        }
                        if (i3 == childCount) {
                            break;
                        }
                        i3++;
                    }
                }
                this.this$0.M = false;
            }
        }
    }

    static final class m<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63670a;

        m(j jVar) {
            this.f63670a = jVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (this.f63670a.J) {
                this.f63670a.j(str);
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
        String simpleName = j.class.getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "FJRMobileLandingFragmentV8::class.java.simpleName");
        T = simpleName;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.a((p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.a((n) this);
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.P = arguments.getBoolean("is_recharge_tabs_flow", false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_fragment_mobile_landing, viewGroup, false);
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
        if (this.P) {
            A();
        } else {
            N();
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
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_mobile);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
        } catch (Exception unused) {
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        LiveData liveData4 = null;
        if (aVar == null || (cJRCategoryDataHelper = aVar.f61409b) == null) {
            liveData = null;
        } else {
            liveData = cJRCategoryDataHelper.getCategoryLiveData();
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData, new f(this));
        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63600h;
        if (aVar2 != null) {
            liveData2 = aVar2.f61414g;
        } else {
            liveData2 = null;
        }
        net.one97.paytm.recharge.common.utils.g.a(this, liveData2, new g(this));
        B();
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
            this.R = new CJRBaseRechargePromotionalBannerViewV2(activity, b2, true, str4, R.color.color_f3f7f8, R.color.color_8f969c, (String) null, (String) null, 192);
            LinearLayout linearLayout = (LinearLayout) b(R.id.container_content);
            if (linearLayout != null) {
                linearLayout.addView(this.R);
            }
        }
        this.N = new h(this);
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
        net.one97.paytm.recharge.common.utils.g.a(this, liveData4, new i(this));
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
        this.I = new CJRPromosViewV8(getActivity(), childFragmentManager, a2.a(true, str).a((l.b) this), this);
        CJRPromosViewV8 cJRPromosViewV8 = this.I;
        if (cJRPromosViewV8 == null) {
            kotlin.g.b.k.a();
        }
        this.E = cJRPromosViewV8.getErrorListener();
        CJRPromosViewV8 cJRPromosViewV82 = this.I;
        if (cJRPromosViewV82 == null) {
            kotlin.g.b.k.a();
        }
        cJRPromosViewV82.f();
        x();
    }

    /* access modifiers changed from: private */
    public final void I() {
        if (!this.D || TextUtils.isEmpty(this.f63662f) || !URLUtil.isValidUrl(this.f63662f)) {
            if (this.P) {
                FJRRechargeUtilityBaseV2.b bVar = this.j;
                if (bVar != null) {
                    bVar.a("");
                    return;
                }
                return;
            }
            LinearLayout linearLayout = (LinearLayout) b(R.id.bbpsLL);
            if (linearLayout != null) {
                ai.b(linearLayout);
            }
        } else if (this.P) {
            FJRRechargeUtilityBaseV2.b bVar2 = this.j;
            if (bVar2 != null) {
                bVar2.a(this.f63662f);
            }
        } else {
            LinearLayout linearLayout2 = (LinearLayout) b(R.id.bbpsLL);
            if (linearLayout2 != null) {
                ai.a(linearLayout2);
            }
            w.a().a(this.f63662f).a((ImageView) b(R.id.bbpsIV), (com.squareup.picasso.e) new k(this));
        }
    }

    public static final class k implements com.squareup.picasso.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63668a;

        public final void onError(Exception exc) {
        }

        k(j jVar) {
            this.f63668a = jVar;
        }

        public final void onSuccess() {
            Context context = this.f63668a.getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            SubtitleCollapsingToolbarLayout.LayoutParams layoutParams = new SubtitleCollapsingToolbarLayout.LayoutParams((int) context.getTheme().obtainStyledAttributes(new int[]{16843499}).getDimension(0, 0.0f));
            layoutParams.setMargins(0, 0, com.paytm.utility.b.c(60), 0);
            layoutParams.a();
            Toolbar toolbar = (Toolbar) this.f63668a.b(R.id.toolbar);
            if (toolbar != null) {
                toolbar.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void x() {
        LinearLayout linearLayout = (LinearLayout) b(R.id.container_content);
        CJRPromosViewV8 cJRPromosViewV8 = this.I;
        if (cJRPromosViewV8 == null) {
            kotlin.g.b.k.a();
        }
        linearLayout.addView(cJRPromosViewV8);
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
        if (charSequence == null || kotlin.m.p.a(charSequence)) {
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
        Object obj;
        kotlin.g.b.k.c(list, "recents");
        int indexOfChild = ((LinearLayout) b(R.id.container_content)).indexOfChild((ShimmerFrameLayout) b(R.id.shimmer_mobile));
        if (!this.Q) {
            Context context = getContext();
            if (context == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) context, "context!!");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(context);
            net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
            if (aVar == null || (obj = aVar.e()) == null) {
                obj = "";
            }
            Integer valueOf = Integer.valueOf(list.size());
            String str2 = ab.f61496a;
            kotlin.g.b.k.a((Object) str2, "CJRRechargeUtilityConstant.UTILITY");
            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, obj, "recents_shown", "", valueOf, str2, (Object) null, (Object) null, 96);
            this.Q = true;
        }
        if (this.H == null) {
            CJRRecentOrderV8.a aVar2 = new CJRRecentOrderV8.a();
            String string = getString(R.string.recent_header);
            kotlin.g.b.k.a((Object) string, "getString(R.string.recent_header)");
            CJRRecentOrderV8.a a2 = aVar2.a(string);
            a2.f61930h = true;
            CJRRecentOrderV8.a a3 = a2.a(list);
            net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63600h;
            if (aVar3 == null || (cJRItem = aVar3.r) == null) {
                str = null;
            } else {
                str = cJRItem.getCategoryId();
            }
            a3.o = str;
            CJRRecentOrderV8.a a4 = a3.a(CJRRecentOrderV8.b.MOBILE.ordinal());
            a4.f61927e = this;
            a4.f61929g = this;
            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63600h;
            if (aVar4 == null) {
                kotlin.g.b.k.a();
            }
            this.G = a4.a((r) aVar4);
            if (getActivity() != null) {
                Context activity = getActivity();
                CJRRecentOrderV8.a aVar5 = this.G;
                if (aVar5 == null) {
                    kotlin.g.b.k.a();
                }
                this.H = new CJRRecentOrderV8(activity, aVar5);
                ((LinearLayout) b(R.id.container_content)).addView(this.H, indexOfChild + 1);
            }
            B();
        }
    }

    public final void b(List<? extends ContactItemModel> list) {
        kotlin.g.b.k.c(list, Tables.CONTACTS);
        CJRRecentOrderV8 cJRRecentOrderV8 = this.H;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.getNotifyAdapterDataChange();
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63664a;

        c(j jVar) {
            this.f63664a = jVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            net.one97.paytm.recharge.ordersummary.h.d dVar;
            net.one97.paytm.recharge.mobile.d.a aVar;
            if (!this.f63664a.M) {
                RadioButton radioButton = radioGroup != null ? (RadioButton) radioGroup.findViewById(i2) : null;
                if ((radioButton != null ? radioButton.getTag() : null) instanceof CJRRelatedCategory) {
                    Object tag = radioButton.getTag();
                    if (tag != null) {
                        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) tag;
                        ((ShimmerFrameLayout) this.f63664a.b(R.id.shimmer_container_category_input_fields)).a();
                        CJRMobileRadioGroupV8 i3 = this.f63664a.B;
                        if (!(i3 == null || !i3.f62091a || (aVar = this.f63664a.f63600h) == null)) {
                            aVar.l();
                        }
                        net.one97.paytm.recharge.mobile.d.a aVar2 = this.f63664a.f63600h;
                        if (aVar2 != null) {
                            aVar2.a(cJRRelatedCategory);
                        }
                        net.one97.paytm.recharge.mobile.d.a aVar3 = this.f63664a.f63600h;
                        if (!(aVar3 == null || (dVar = aVar3.v) == null)) {
                            net.one97.paytm.recharge.mobile.d.a aVar4 = this.f63664a.f63600h;
                            Object e2 = aVar4 != null ? aVar4.e() : null;
                            if (e2 == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.recharge.ordersummary.h.d.a(dVar, e2, kotlin.g.b.k.a(cJRRelatedCategory.getLabel(), (Object) "_selected"), (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
                        }
                        if (net.one97.paytm.recharge.common.utils.g.c(cJRRelatedCategory.getUrl())) {
                            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                            a2.setErrorType(ERROR_TYPE.UNDEFINED);
                            CRUFlowModel flowName = a2.getFlowName();
                            if (flowName != null) {
                                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
                            }
                            CRUFlowModel flowName2 = a2.getFlowName();
                            if (flowName2 != null) {
                                flowName2.setActionType(ACTION_TYPE.RC_CHANGED.name());
                            }
                            net.one97.paytm.recharge.mobile.d.a aVar5 = this.f63664a.f63600h;
                            if (aVar5 != null) {
                                String url = cJRRelatedCategory.getUrl();
                                if (url == null) {
                                    kotlin.g.b.k.a();
                                }
                                if (!aVar5.a("get.rc.category", url, (Object) a2, (net.one97.paytm.recharge.common.e.ai) null, (net.one97.paytm.recharge.common.b.a.a) null)) {
                                    ((ShimmerFrameLayout) this.f63664a.b(R.id.shimmer_container_category_input_fields)).b();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.v4.CJRRelatedCategory");
                }
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63665a;

        e(j jVar) {
            this.f63665a = jVar;
        }

        public final void onClick(View view) {
            j jVar = this.f63665a;
            net.one97.paytm.recharge.mobile.d.a aVar = jVar.f63600h;
            if (aVar != null) {
                Boolean bool = (Boolean) aVar.H.getValue();
                if (bool == null) {
                    bool = Boolean.FALSE;
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE)) {
                    CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = jVar.o;
                    if (cJRInputFieldWithActionWidgetV8 == null) {
                        kotlin.g.b.k.a();
                    }
                    View view2 = cJRInputFieldWithActionWidgetV8;
                    kotlin.g.b.k.c(view2, "view");
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
                    net.one97.paytm.recharge.mobile.d dVar = jVar.f63599g;
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
        L();
        if (this.P) {
            A();
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
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
                    }
                    throw new u("null cannot be cast to non-null type android.content.Context");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeInterface");
            }
            return;
        }
        N();
    }

    public void onStop() {
        x xVar;
        super.onStop();
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            if (this.f61110b != null) {
                t.a(cJRInputFieldWithActionWidgetV8);
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

    private void N() {
        Toolbar toolbar = (Toolbar) b(R.id.toolbar);
        kotlin.g.b.k.a((Object) toolbar, "toolbar");
        toolbar.setVisibility(0);
        SubtitleCollapsingToolbarLayout subtitleCollapsingToolbarLayout = (SubtitleCollapsingToolbarLayout) b(R.id.toolbar_layout);
        kotlin.g.b.k.a((Object) subtitleCollapsingToolbarLayout, "toolbar_layout");
        subtitleCollapsingToolbarLayout.setVisibility(0);
        AppBarLayout appBarLayout = (AppBarLayout) b(R.id.appbar_layout);
        kotlin.g.b.k.a((Object) appBarLayout, "appbar_layout");
        appBarLayout.setVisibility(0);
        a((Toolbar) b(R.id.toolbar));
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.scroll_view);
        kotlin.g.b.k.a((Object) nestedScrollView, "scroll_view");
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
        if (layoutParams != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) layoutParams;
            dVar.a((CoordinatorLayout.Behavior) new AppBarLayout.ScrollingViewBehavior(getContext(), (AttributeSet) null));
            NestedScrollView nestedScrollView2 = (NestedScrollView) b(R.id.scroll_view);
            kotlin.g.b.k.a((Object) nestedScrollView2, "scroll_view");
            nestedScrollView2.setLayoutParams(dVar);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public boolean a(int i2, int i3, Intent intent) {
        CJRRecentOrderV8 cJRRecentOrderV8;
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
                    CJRRecentOrderV8 cJRRecentOrderV82 = this.H;
                    if (cJRRecentOrderV82 != null) {
                        cJRRecentOrderV82.a(Integer.valueOf(intExtra), str);
                    }
                }
                return true;
            }
        } else if (i3 == -1) {
            Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("key_position", -1)) : null;
            if ((valueOf == null || valueOf.intValue() != -1) && (cJRRecentOrderV8 = this.H) != null) {
                cJRRecentOrderV8.a(valueOf, "is_refresh_needed");
            }
        }
        return super.a(i2, i3, intent);
    }

    public void w() {
        net.one97.paytm.recharge.mobile.d.a aVar;
        LiveData liveData;
        net.one97.paytm.recharge.mobile.d.a aVar2;
        LiveData liveData2;
        net.one97.paytm.recharge.mobile.d.a aVar3;
        LiveData liveData3;
        TextView textView = (TextView) b(R.id.scroll_empty_view);
        if (textView != null) {
            textView.requestFocus();
        }
        this.O = false;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.b(false);
        }
        z<String> zVar = this.K;
        if (!(zVar == null || (aVar3 = this.f63600h) == null || (liveData3 = aVar3.z) == null)) {
            liveData3.removeObserver(zVar);
        }
        if (!(this.t == null || (aVar2 = this.f63600h) == null || (liveData2 = aVar2.K) == null)) {
            z<Boolean> zVar2 = this.t;
            if (zVar2 == null) {
                kotlin.g.b.k.a();
            }
            liveData2.removeObserver(zVar2);
        }
        z<LinkedList<CJRSelectedGroupItem>> zVar3 = this.L;
        if (!(zVar3 == null || (aVar = this.f63600h) == null || (liveData = aVar.F) == null)) {
            liveData.removeObserver(zVar3);
        }
        HashMap hashMap = new HashMap(1);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Map map = hashMap;
                String x = androidx.core.h.u.x((CJRProceedWidgetV8) b(R.id.btn_proceed));
                if (x == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) x, "ViewCompat.getTransitionName(btn_proceed)!!");
                CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) b(R.id.btn_proceed);
                kotlin.g.b.k.a((Object) cJRProceedWidgetV8, "btn_proceed");
                map.put(x, cJRProceedWidgetV8);
            } catch (Exception unused) {
            }
        }
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((Map<String, ? extends View>) hashMap);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r4 = r4.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ay_() {
        /*
            r6 = this;
            int r0 = net.one97.paytm.recharge.R.id.scroll_empty_view
            android.view.View r0 = r6.b((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 == 0) goto L_0x000d
            r0.requestFocus()
        L_0x000d:
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r6.o
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x006e
            r3 = 0
            r0.setInputFieldClickListener(r3)
            r0.b((boolean) r2)
            int r4 = net.one97.paytm.recharge.R.drawable.ic_close_dialog
            net.one97.paytm.recharge.mobile.a.j$l r5 = new net.one97.paytm.recharge.mobile.a.j$l
            r5.<init>(r6)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r0.c(r4, r5)
            net.one97.paytm.recharge.mobile.d.a r4 = r6.f63600h
            if (r4 == 0) goto L_0x0037
            androidx.lifecycle.y<java.lang.String> r4 = r4.z
            androidx.lifecycle.LiveData r4 = (androidx.lifecycle.LiveData) r4
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0038
        L_0x0037:
            r4 = r3
        L_0x0038:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0049
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r4 = r6.o
            if (r4 == 0) goto L_0x0049
            r5 = 8
            r4.setSecondaryIconVisibility(r5)
        L_0x0049:
            boolean r4 = r6.O
            if (r4 != 0) goto L_0x006b
            r6.O = r2
            androidx.fragment.app.FragmentActivity r4 = r6.getActivity()
            if (r4 == 0) goto L_0x005c
            java.lang.String r5 = "input_method"
            java.lang.Object r4 = r4.getSystemService(r5)
            goto L_0x005d
        L_0x005c:
            r4 = r3
        L_0x005d:
            boolean r5 = r4 instanceof android.view.inputmethod.InputMethodManager
            if (r5 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r3 = r4
        L_0x0063:
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            if (r3 == 0) goto L_0x006b
            r4 = 2
            r3.toggleSoftInput(r4, r1)
        L_0x006b:
            r0.d()
        L_0x006e:
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            java.lang.String r3 = "btn_proceed"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            r1 = r6
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.recharge.R.id.btn_proceed
            android.view.View r0 = r6.b((int) r0)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r0 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r0
            int r1 = net.one97.paytm.recharge.R.string.proceed_re
            java.lang.String r1 = r6.getString(r1)
            r0.setProceedBtnText(r1)
            net.one97.paytm.recharge.mobile.d r0 = r6.f63599g
            if (r0 == 0) goto L_0x00a7
            r1 = r6
            net.one97.paytm.recharge.common.e.p r1 = (net.one97.paytm.recharge.common.e.p) r1
            r0.a((net.one97.paytm.recharge.common.e.p) r1)
        L_0x00a7:
            net.one97.paytm.recharge.mobile.d r0 = r6.f63599g
            if (r0 == 0) goto L_0x00b1
            r1 = r6
            net.one97.paytm.recharge.common.e.n r1 = (net.one97.paytm.recharge.common.e.n) r1
            r0.a((net.one97.paytm.recharge.common.e.n) r1)
        L_0x00b1:
            net.one97.paytm.recharge.common.utils.ba r0 = r6.k
            if (r0 == 0) goto L_0x00bb
            r1 = r6
            net.one97.paytm.recharge.common.utils.ba$a r1 = (net.one97.paytm.recharge.common.utils.ba.a) r1
            r0.a((net.one97.paytm.recharge.common.utils.ba.a) r1)
        L_0x00bb:
            androidx.lifecycle.z<java.lang.String> r0 = r6.K
            if (r0 != 0) goto L_0x00c8
            net.one97.paytm.recharge.mobile.a.j$m r0 = new net.one97.paytm.recharge.mobile.a.j$m
            r0.<init>(r6)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r6.K = r0
        L_0x00c8:
            r6.J = r2
            androidx.lifecycle.z<java.lang.String> r0 = r6.K
            if (r0 == 0) goto L_0x00de
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x00de
            androidx.lifecycle.y<java.lang.String> r1 = r1.z
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x00de
            r2 = r6
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            r1.observe(r2, r0)
        L_0x00de:
            androidx.lifecycle.z<java.lang.Boolean> r0 = r6.t
            if (r0 == 0) goto L_0x00f9
            net.one97.paytm.recharge.mobile.d.a r0 = r6.f63600h
            if (r0 == 0) goto L_0x00f9
            androidx.lifecycle.y<java.lang.Boolean> r0 = r0.K
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            if (r0 == 0) goto L_0x00f9
            r1 = r6
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            androidx.lifecycle.z<java.lang.Boolean> r2 = r6.t
            if (r2 != 0) goto L_0x00f6
            kotlin.g.b.k.a()
        L_0x00f6:
            r0.observe(r1, r2)
        L_0x00f9:
            androidx.lifecycle.z<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r0 = r6.L
            if (r0 == 0) goto L_0x010d
            net.one97.paytm.recharge.mobile.d.a r1 = r6.f63600h
            if (r1 == 0) goto L_0x010d
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r1 = r1.F
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            if (r1 == 0) goto L_0x010d
            r2 = r6
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            r1.observe(r2, r0)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.j.ay_():void");
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63669a;

        l(j jVar) {
            this.f63669a = jVar;
        }

        public final void onClick(View view) {
            j jVar = this.f63669a;
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = jVar.o;
            if (cJRInputFieldWithActionWidgetV8 != null) {
                cJRInputFieldWithActionWidgetV8.setInputText("");
            }
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = jVar.o;
            if (cJRInputFieldWithActionWidgetV82 != null) {
                cJRInputFieldWithActionWidgetV82.setSecondaryIconVisibility(8);
            }
            net.one97.paytm.recharge.mobile.d.a aVar = jVar.f63600h;
            if (aVar != null) {
                aVar.k();
            }
            FragmentActivity activity = jVar.getActivity();
            CJRRechargeEditText cJRRechargeEditText = null;
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV83 = jVar.o;
                if (cJRInputFieldWithActionWidgetV83 != null) {
                    cJRRechargeEditText = cJRInputFieldWithActionWidgetV83.getInputView();
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
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8;
        LiveData liveData;
        super.b(charSequence, i2, i3, i4);
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar == null || (liveData = aVar.H) == null || (bool = (Boolean) liveData.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.FALSE) && (cJRInputFieldWithActionWidgetV8 = this.o) != null) {
            cJRInputFieldWithActionWidgetV8.setDividerColor(R.color.color_ebebeb);
        }
    }

    public final void a(CharSequence charSequence, int i2, int i3, int i4) {
        super.a(charSequence, i2, i3, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r11.equals(r2) != true) goto L_0x0066;
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
            if (r1 != r2) goto L_0x00e9
            net.one97.paytm.recharge.widgets.c.e r1 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            net.one97.paytm.recharge.widgets.c.e r2 = net.one97.paytm.recharge.widgets.c.e.INSTANCE
            int r2 = r2.getDELAY_1000_MILLI()
            boolean r11 = r1.validateIsAlreadyClicked(r11, r2)
            if (r11 == 0) goto L_0x0036
            return
        L_0x0036:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x0051
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
        L_0x0051:
            java.lang.String r11 = r10.p
            r1 = 1
            if (r11 == 0) goto L_0x0066
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = r10.o
            if (r2 == 0) goto L_0x005f
            java.lang.String r2 = r2.getInputText()
            goto L_0x0060
        L_0x005f:
            r2 = r0
        L_0x0060:
            boolean r11 = r11.equals(r2)
            if (r11 == r1) goto L_0x0084
        L_0x0066:
            net.one97.paytm.recharge.common.b.a r11 = r10.f63601i
            if (r11 == 0) goto L_0x00e9
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r11 = r10.o
            if (r11 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            android.view.View r11 = (android.view.View) r11
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r2 = r10.o
            if (r2 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r2 = r2.getInputText()
            boolean r11 = net.one97.paytm.recharge.common.b.a.a((android.view.View) r11, (java.lang.String) r2, (boolean) r1)
            if (r11 != r1) goto L_0x00e9
        L_0x0084:
            net.one97.paytm.recharge.mobile.d.a r11 = r10.f63600h
            if (r11 == 0) goto L_0x00e9
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRProductsItem> r2 = r11.G
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.recharge.model.v4.CJRProductsItem r2 = (net.one97.paytm.recharge.model.v4.CJRProductsItem) r2
            if (r2 == 0) goto L_0x00da
            androidx.lifecycle.y<java.util.LinkedList<net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem>> r3 = r11.F
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            java.lang.Object r3 = r3.getValue()
            java.util.LinkedList r3 = (java.util.LinkedList) r3
            if (r3 == 0) goto L_0x00c9
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r1
            if (r3 != r1) goto L_0x00c9
            java.lang.String r2 = r2.getPaytype()
            if (r2 == 0) goto L_0x00c9
            androidx.lifecycle.y<net.one97.paytm.recharge.model.v4.CJRRelatedCategory> r3 = r11.y
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            java.lang.Object r3 = r3.getValue()
            net.one97.paytm.recharge.model.v4.CJRRelatedCategory r3 = (net.one97.paytm.recharge.model.v4.CJRRelatedCategory) r3
            if (r3 == 0) goto L_0x00bf
            java.lang.String r0 = r3.getValue()
        L_0x00bf:
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
            if (r0 != r1) goto L_0x00c9
            r10.w()
            return
        L_0x00c9:
            r10.r = r1
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r0 = r10.o
            if (r0 != 0) goto L_0x00d2
            kotlin.g.b.k.a()
        L_0x00d2:
            java.lang.String r0 = r0.getInputText()
            r11.a((java.lang.String) r0, true)
            return
        L_0x00da:
            net.one97.paytm.recharge.common.widget.CJRInputFieldWithActionWidgetV8 r11 = r10.o
            if (r11 == 0) goto L_0x00e4
            java.lang.String r11 = r11.getInputText()
            if (r11 != 0) goto L_0x00e6
        L_0x00e4:
            java.lang.String r11 = ""
        L_0x00e6:
            r10.a(r11, r0)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile.a.j.onClick(android.view.View):void");
    }

    public final void l() {
        super.l();
    }

    public final void a(String str, NetworkCustomError networkCustomError, Object obj) {
        if (getActivity() != null && isAdded()) {
            if (networkCustomError instanceof at) {
                n nVar = this.E;
                if (nVar != null) {
                    nVar.a(str, networkCustomError, obj);
                }
            } else if (!(networkCustomError instanceof an)) {
                super.a(str, networkCustomError, obj);
            }
        }
    }

    public final void a(CJRInstruct cJRInstruct) {
        if (!(cJRInstruct instanceof CJRInstruct.openCouponsActivity) && !(cJRInstruct instanceof CJRInstruct.openRechargePaymentActivity)) {
            super.a(cJRInstruct);
        }
    }

    public final void a(CJRFrequentOrder cJRFrequentOrder, int i2) {
        kotlin.g.b.k.c(cJRFrequentOrder, "item");
        super.a(cJRFrequentOrder, i2);
        CJRRecentOrderV8 cJRRecentOrderV8 = this.H;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.a(cJRFrequentOrder, i2);
        }
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

    public final boolean K() {
        new Handler().postDelayed(new C1239j(this), 100);
        NestedScrollView nestedScrollView = (NestedScrollView) b(R.id.scroll_view);
        if (nestedScrollView != null) {
            nestedScrollView.c(0);
        }
        return false;
    }

    /* renamed from: net.one97.paytm.recharge.mobile.a.j$j  reason: collision with other inner class name */
    static final class C1239j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f63667a;

        C1239j(j jVar) {
            this.f63667a = jVar;
        }

        public final void run() {
            NestedScrollView nestedScrollView = (NestedScrollView) this.f63667a.b(R.id.scroll_view);
            if (nestedScrollView != null) {
                nestedScrollView.c(0);
            }
        }
    }

    public final void L() {
        CJRPromosViewV8 cJRPromosViewV8 = this.I;
        if (cJRPromosViewV8 != null) {
            cJRPromosViewV8.g();
        }
    }

    public void onDestroy() {
        this.H = null;
        ba baVar = this.k;
        if (baVar != null) {
            baVar.a((ba.a) null);
        }
        super.onDestroy();
    }

    public final boolean J() {
        if (this.j != null) {
            I();
            if (TextUtils.isEmpty(this.f63662f) || !URLUtil.isValidUrl(this.f63662f)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void a(CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8) {
        String str;
        LiveData liveData;
        LiveData liveData2;
        kotlin.g.b.k.c(cJRInputFieldWithActionWidgetV8, "view");
        this.o = cJRInputFieldWithActionWidgetV8;
        CJRMobileInputFieldWidgetV8 cJRMobileInputFieldWidgetV8 = (CJRMobileInputFieldWidgetV8) cJRInputFieldWithActionWidgetV8;
        cJRMobileInputFieldWidgetV8.setMInputFieldTextChangeListener(this);
        cJRInputFieldWithActionWidgetV8.b(false);
        cJRInputFieldWithActionWidgetV8.setInputFieldClickListener(this.S);
        if (cJRMobileInputFieldWidgetV8.getTag() instanceof a.C1172a) {
            Object tag = cJRMobileInputFieldWidgetV8.getTag();
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
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.data.CJRCategoryInputFieldHelperV8.Entry");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            cJRMobileInputFieldWidgetV8.setTransitionName(getString(R.string.transition_name_input_field_with_action));
        }
        ((LinearLayout) b(R.id.container_category_input_fields)).addView(cJRInputFieldWithActionWidgetV8);
        ViewGroup.LayoutParams layoutParams = cJRMobileInputFieldWidgetV8.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(com.paytm.utility.b.c(21), 0, com.paytm.utility.b.c(21), 0);
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
                    CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
                    if (cJRInputFieldWithActionWidgetV82 != null) {
                        cJRInputFieldWithActionWidgetV82.setInputText("");
                    }
                    this.q = true;
                    this.y = true;
                    CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV83 = this.o;
                    if (cJRInputFieldWithActionWidgetV83 != null) {
                        cJRInputFieldWithActionWidgetV83.a(this.p);
                    }
                }
                if (!com.paytm.utility.b.c(str)) {
                    H();
                    return;
                }
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public void onDestroyView() {
        CJRCategoryDataHelper cJRCategoryDataHelper;
        net.one97.paytm.recharge.common.b.a aVar;
        net.one97.paytm.recharge.common.utils.w wVar;
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> cVar;
        io.reactivex.rxjava3.j.c<List<CJRAutomaticSubscriptionItemModel>> cVar2;
        net.one97.paytm.recharge.mobile.d dVar = this.f63599g;
        if (dVar != null) {
            dVar.b((p) this);
        }
        net.one97.paytm.recharge.mobile.d dVar2 = this.f63599g;
        if (dVar2 != null) {
            dVar2.b((n) this);
        }
        super.onDestroyView();
        this.I = null;
        CJRRecentOrderV8 cJRRecentOrderV8 = this.H;
        if (cJRRecentOrderV8 != null) {
            cJRRecentOrderV8.e();
        }
        this.H = null;
        this.G = null;
        this.B = null;
        this.F = null;
        this.E = null;
        this.L = null;
        this.K = null;
        this.N = null;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_mobile);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setAutoStart(false);
        }
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

    public void D() {
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
        if (cJRInputFieldWithActionWidgetV8 != null) {
            cJRInputFieldWithActionWidgetV8.c(false);
        }
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void j(String str) {
        this.q = false;
        if (net.one97.paytm.recharge.common.utils.g.c(str)) {
            this.p = str;
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8 = this.o;
            if (cJRInputFieldWithActionWidgetV8 != null) {
                cJRInputFieldWithActionWidgetV8.setInputText("");
            }
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82 = this.o;
            if (cJRInputFieldWithActionWidgetV82 != null) {
                cJRInputFieldWithActionWidgetV82.a(str);
            }
        } else {
            this.p = null;
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV83 = this.o;
            if (cJRInputFieldWithActionWidgetV83 != null) {
                cJRInputFieldWithActionWidgetV83.setInputText("");
            }
        }
        this.q = true;
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.p();
        }
    }

    public final void F() {
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV8;
        LiveData liveData;
        String str;
        CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV82;
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
            CJRInputFieldWithActionWidgetV8 cJRInputFieldWithActionWidgetV83 = this.o;
            Boolean bool = null;
            String inputText = cJRInputFieldWithActionWidgetV83 != null ? cJRInputFieldWithActionWidgetV83.getInputText() : null;
            if (!TextUtils.isEmpty(inputText)) {
                if (this.w) {
                    str = "phonebook";
                } else if (this.x) {
                    str = "contact screen";
                } else {
                    str = this.y ? "prefilled" : "manual entry";
                }
                String str3 = str;
                String str4 = this.p;
                if (!(str4 != null ? str4.equals(inputText) : false)) {
                    b(inputText, str3);
                    if (!this.y) {
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
                        if (!this.y) {
                            net.one97.paytm.recharge.mobile.d.a aVar6 = this.f63600h;
                            if (aVar6 != null) {
                                cJRFrequentOrder = aVar6.j();
                            } else {
                                cJRFrequentOrder = null;
                            }
                            if (cJRFrequentOrder == null) {
                                net.one97.paytm.recharge.mobile.d.a aVar7 = this.f63600h;
                                if (!(!az.a(str2, (List<? extends CJRFrequentOrder>) (aVar7 == null || (liveData3 = aVar7.f61414g) == null) ? null : (List) liveData3.getValue()) || (aVar = this.f63600h) == null || (dVar = aVar.v) == null)) {
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
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE) && (cJRInputFieldWithActionWidgetV82 = this.o) != null) {
                    cJRInputFieldWithActionWidgetV82.setSecondaryIconVisibility(0);
                }
                this.x = false;
                this.w = false;
                this.y = false;
            } else {
                net.one97.paytm.recharge.mobile.d.a aVar10 = this.f63600h;
                if (!(aVar10 == null || (liveData = aVar10.H) == null)) {
                    bool = (Boolean) liveData.getValue();
                }
                if (kotlin.g.b.k.a((Object) bool, (Object) Boolean.TRUE) && (cJRInputFieldWithActionWidgetV8 = this.o) != null) {
                    cJRInputFieldWithActionWidgetV8.setSecondaryIconVisibility(8);
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
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "promo");
        net.one97.paytm.recharge.mobile.d.a aVar = this.f63600h;
        if (aVar != null) {
            aVar.L = kotlin.m.p.a(aVar.L, str, true) ? str : "";
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
