package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJROrderActionsListView;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;

public final class p extends k implements View.OnClickListener, z<CJRTaggedObservable<?>>, o {

    /* renamed from: d  reason: collision with root package name */
    private Group f64173d;

    /* renamed from: e  reason: collision with root package name */
    private Group f64174e;

    /* renamed from: f  reason: collision with root package name */
    private final a f64175f = new a(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f64176g;

    public final void a() {
        HashMap hashMap = this.f64176g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View b(int i2) {
        if (this.f64176g == null) {
            this.f64176g = new HashMap();
        }
        View view = (View) this.f64176g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64176g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        CJRTaggedObservable cJRTaggedObservable = (CJRTaggedObservable) obj;
        String tag = cJRTaggedObservable != null ? cJRTaggedObservable.getTag() : null;
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode != -598231028) {
                if (hashCode != 1511711440 || !tag.equals("fetch_total_contribution")) {
                    return;
                }
                if (!(cJRTaggedObservable.getData() instanceof CJRContributionData) || !isAdded() || isDetached() || getContext() == null) {
                    c();
                    return;
                }
                Object data = cJRTaggedObservable.getData();
                if (data != null) {
                    a((CJRContributionData) data);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJRContributionData");
            } else if (tag.equals("tag.contribution.data.request.loader")) {
                ConstraintLayout constraintLayout = (ConstraintLayout) b(R.id.real_contribution_details);
                if (constraintLayout != null) {
                    ai.b(constraintLayout);
                }
                try {
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
                    if (shimmerFrameLayout != null) {
                        ai.a(shimmerFrameLayout);
                    }
                    ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
                    if (shimmerFrameLayout2 != null) {
                        shimmerFrameLayout2.a();
                    }
                } catch (Exception unused) {
                    ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
                    if (shimmerFrameLayout3 != null) {
                        ai.a(shimmerFrameLayout3);
                    }
                }
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_storefront_pm_care_fund, viewGroup, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.util.List} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r12) {
        /*
            r11 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r12, r0)
            int r0 = net.one97.paytm.recharge.R.id.operator_logo
            android.view.View r0 = r12.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r1 = net.one97.paytm.recharge.R.id.operator_name
            android.view.View r1 = r12.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.recharge.R.id.tv_contibution_amount
            android.view.View r2 = r12.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.recharge.R.id.tv_contibution_amount_2
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.recharge.R.id.group_with_total_contribution
            android.view.View r4 = r12.findViewById(r4)
            androidx.constraintlayout.widget.Group r4 = (androidx.constraintlayout.widget.Group) r4
            r11.f64173d = r4
            int r4 = net.one97.paytm.recharge.R.id.group_without_total_contribution
            android.view.View r4 = r12.findViewById(r4)
            androidx.constraintlayout.widget.Group r4 = (androidx.constraintlayout.widget.Group) r4
            r11.f64174e = r4
            net.one97.paytm.recharge.ordersummary.b.a r4 = r11.b()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = r4.u()
            if (r4 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            net.one97.paytm.recharge.ordersummary.b.a r5 = r11.b()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r5 = r5.m
            long r6 = r4.getId()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.Object r5 = r5.get(r6)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r5 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r5
            net.one97.paytm.recharge.ordersummary.b.a r6 = r11.b()
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.CJRContributionData>> r6 = r6.r
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r6 = (net.one97.paytm.recharge.widgets.model.CJRTaggedObservable) r6
            r7 = 0
            if (r6 == 0) goto L_0x0070
            java.lang.Object r8 = r6.getData()
            net.one97.paytm.recharge.model.CJRContributionData r8 = (net.one97.paytm.recharge.model.CJRContributionData) r8
            goto L_0x0071
        L_0x0070:
            r8 = r7
        L_0x0071:
            if (r8 != 0) goto L_0x00ba
            android.content.Context r6 = r11.getContext()
            boolean r6 = r6 instanceof net.one97.paytm.recharge.common.e.ai
            if (r6 == 0) goto L_0x00cd
            net.one97.paytm.recharge.ordersummary.b.a r6 = r11.b()
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.CJRContributionData>> r6 = r6.r
            r8 = r11
            androidx.lifecycle.q r8 = (androidx.lifecycle.q) r8
            r9 = r11
            androidx.lifecycle.z r9 = (androidx.lifecycle.z) r9
            r6.observe(r8, r9)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r11.b()
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.CJRContributionData>> r6 = r6.r
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r8 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            java.lang.String r9 = "tag.contribution.data.request.loader"
            r8.<init>(r9, r7)
            r6.setValue(r8)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r11.b()
            android.content.Context r8 = r11.getContext()
            if (r8 == 0) goto L_0x00b2
            net.one97.paytm.recharge.common.e.ai r8 = (net.one97.paytm.recharge.common.e.ai) r8
            net.one97.paytm.recharge.widgets.c.d r9 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r9 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r7)
            java.lang.String r10 = "fetch_total_contribution"
            r6.a((java.lang.String) r10, (net.one97.paytm.recharge.common.e.ai) r8, (java.lang.Object) r9)
            goto L_0x00cd
        L_0x00b2:
            kotlin.u r12 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.common.listener.IJRRechargeXVolleyListener"
            r12.<init>(r0)
            throw r12
        L_0x00ba:
            java.lang.Object r6 = r6.getData()
            if (r6 != 0) goto L_0x00c3
            kotlin.g.b.k.a()
        L_0x00c3:
            java.lang.String r8 = "contributionData.data!!"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            net.one97.paytm.recharge.model.CJRContributionData r6 = (net.one97.paytm.recharge.model.CJRContributionData) r6
            r11.a((net.one97.paytm.recharge.model.CJRContributionData) r6)
        L_0x00cd:
            java.lang.String r6 = "operatorName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r11.b()
            android.content.Context r8 = r11.getContext()
            if (r8 != 0) goto L_0x00df
            kotlin.g.b.k.a()
        L_0x00df:
            java.lang.String r9 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r6 = r6.R(r8)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.setText(r6)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r11.b()
            android.content.Context r6 = r11.getContext()
            if (r6 != 0) goto L_0x00fa
            kotlin.g.b.k.a()
        L_0x00fa:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r1 = r1.g(r6, r4)
            java.lang.String r6 = "tvContributionAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            java.lang.String r2 = "tvContributionAmount2"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            r3.setText(r1)
            int r1 = net.one97.paytm.recharge.R.id.content_child_container
            android.view.View r1 = r12.findViewById(r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            int r2 = net.one97.paytm.recharge.R.id.shimmer_image_group_care
            android.view.View r2 = r12.findViewById(r2)
            net.one97.paytm.common.views.ShimmerFrameLayout r2 = (net.one97.paytm.common.views.ShimmerFrameLayout) r2
            int r3 = net.one97.paytm.recharge.R.id.img_action_base
            android.view.View r3 = r12.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            androidx.constraintlayout.widget.c r6 = new androidx.constraintlayout.widget.c
            r6.<init>()
            r6.b((androidx.constraintlayout.widget.ConstraintLayout) r1)
            java.lang.String r8 = "imgLayout"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            int r8 = r3.getId()
            java.lang.String r9 = "343:142"
            r6.a((int) r8, (java.lang.String) r9)
            r6.c((androidx.constraintlayout.widget.ConstraintLayout) r1)
            androidx.fragment.app.Fragment r1 = r11.getParentFragment()
            r6 = 1
            r8 = 0
            if (r1 == 0) goto L_0x0238
            androidx.fragment.app.Fragment r1 = r11.getParentFragment()
            boolean r1 = r1 instanceof net.one97.paytm.recharge.ordersummary.f.b
            if (r1 == 0) goto L_0x0238
            if (r5 == 0) goto L_0x0193
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r1 = r5.getItemLevelActions()
            if (r1 == 0) goto L_0x0193
            java.util.List r1 = r1.getActions()
            if (r1 == 0) goto L_0x0193
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x016f:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0190
            java.lang.Object r7 = r1.next()
            r9 = r7
            net.one97.paytm.recharge.model.CJROSActionItemV2 r9 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r9
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r10 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r10 = r10.getACTION_TYPE_PRO_SHARE()
            java.lang.String r9 = r9.getmType()
            boolean r9 = kotlin.m.p.a((java.lang.String) r10, (java.lang.String) r9, (boolean) r6)
            if (r9 == 0) goto L_0x016f
            r5.add(r7)
            goto L_0x016f
        L_0x0190:
            r7 = r5
            java.util.List r7 = (java.util.List) r7
        L_0x0193:
            java.lang.String r1 = "shimmerGroupCare"
            r5 = 8
            if (r7 == 0) goto L_0x022c
            int r9 = r7.size()
            if (r9 != r6) goto L_0x022c
            java.lang.Object r9 = r7.get(r8)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r9 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r9
            java.lang.String r9 = r9.getImageUrlGroupCare()
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x01c5
            r2.a()
            com.squareup.picasso.w r10 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x01c5 }
            com.squareup.picasso.aa r9 = r10.a((java.lang.String) r9)     // Catch:{ Exception -> 0x01c5 }
            net.one97.paytm.recharge.ordersummary.d.p$a r10 = r11.f64175f     // Catch:{ Exception -> 0x01c5 }
            com.squareup.picasso.e r10 = (com.squareup.picasso.e) r10     // Catch:{ Exception -> 0x01c5 }
            r9.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r10)     // Catch:{ Exception -> 0x01c5 }
            goto L_0x01d1
        L_0x01c5:
            r2.b()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setVisibility(r5)
            r3.setVisibility(r5)
        L_0x01d1:
            java.lang.Object r1 = r7.get(r8)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r1 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r1
            java.lang.String r1 = r1.getImageUrlShare()
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01f0
            java.util.concurrent.Executor r2 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            net.one97.paytm.recharge.ordersummary.d.p$b r3 = new net.one97.paytm.recharge.ordersummary.d.p$b
            r3.<init>(r1)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.execute(r3)
        L_0x01f0:
            int r1 = net.one97.paytm.recharge.R.id.action_btn_base
            android.view.View r12 = r12.findViewById(r1)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r1 = "actionView"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            kotlin.o r1 = new kotlin.o
            java.lang.Object r2 = r7.get(r8)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r2 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r2
            java.lang.String r2 = r2.getmType()
            java.lang.Object r3 = r7.get(r8)
            r1.<init>(r2, r3)
            r12.setTag(r1)
            r1 = r11
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r12.setOnClickListener(r1)
            java.lang.Object r1 = r7.get(r8)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r1 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r1
            java.lang.String r1 = r1.getLabel()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r12.setText(r1)
            r12.setVisibility(r8)
            goto L_0x0238
        L_0x022c:
            r2.b()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setVisibility(r5)
            r3.setVisibility(r5)
        L_0x0238:
            net.one97.paytm.recharge.ordersummary.b.a r12 = r11.b()
            java.lang.String r12 = r12.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0270
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x0270 }
            com.squareup.picasso.aa r12 = r1.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0270 }
            com.paytm.utility.t$b r1 = new com.paytm.utility.t$b     // Catch:{ Exception -> 0x0270 }
            android.content.res.Resources r2 = r11.getResources()     // Catch:{ Exception -> 0x0270 }
            int r3 = net.one97.paytm.recharge.R.dimen.dimen_34dp     // Catch:{ Exception -> 0x0270 }
            float r2 = r2.getDimension(r3)     // Catch:{ Exception -> 0x0270 }
            int r2 = (int) r2     // Catch:{ Exception -> 0x0270 }
            r1.<init>(r2, r8, r6)     // Catch:{ Exception -> 0x0270 }
            com.squareup.picasso.ah r1 = (com.squareup.picasso.ah) r1     // Catch:{ Exception -> 0x0270 }
            com.squareup.picasso.aa r12 = r12.a((com.squareup.picasso.ah) r1)     // Catch:{ Exception -> 0x0270 }
            int r1 = net.one97.paytm.recharge.R.color.color_ffffff     // Catch:{ Exception -> 0x0270 }
            com.squareup.picasso.aa r12 = r12.a((int) r1)     // Catch:{ Exception -> 0x0270 }
            r12.a((android.widget.ImageView) r0)     // Catch:{ Exception -> 0x0270 }
        L_0x0270:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.p.a(android.view.View):void");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f64178a;

        b(String str) {
            this.f64178a = str;
        }

        public final void run() {
            try {
                w.a().a(this.f64178a).f();
            } catch (Exception unused) {
            }
        }
    }

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f64177a;

        a(p pVar) {
            this.f64177a = pVar;
        }

        public final void onSuccess() {
            ImageView imageView;
            ShimmerFrameLayout shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2;
            View view = this.f64177a.getView();
            if (!(view == null || (shimmerFrameLayout2 = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_image_group_care)) == null)) {
                shimmerFrameLayout2.b();
            }
            View view2 = this.f64177a.getView();
            if (!(view2 == null || (shimmerFrameLayout = (ShimmerFrameLayout) view2.findViewById(R.id.shimmer_image_group_care)) == null)) {
                shimmerFrameLayout.setVisibility(8);
            }
            View view3 = this.f64177a.getView();
            if (view3 != null && (imageView = (ImageView) view3.findViewById(R.id.img_action_base)) != null) {
                imageView.setVisibility(0);
            }
        }

        public final void onError(Exception exc) {
            ImageView imageView;
            ShimmerFrameLayout shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2;
            k.c(exc, "e");
            View view = this.f64177a.getView();
            if (!(view == null || (shimmerFrameLayout2 = (ShimmerFrameLayout) view.findViewById(R.id.shimmer_image_group_care)) == null)) {
                shimmerFrameLayout2.b();
            }
            View view2 = this.f64177a.getView();
            if (!(view2 == null || (shimmerFrameLayout = (ShimmerFrameLayout) view2.findViewById(R.id.shimmer_image_group_care)) == null)) {
                shimmerFrameLayout.setVisibility(8);
            }
            View view3 = this.f64177a.getView();
            if (view3 != null && (imageView = (ImageView) view3.findViewById(R.id.img_action_base)) != null) {
                imageView.setVisibility(8);
            }
        }
    }

    private final void a(CJRContributionData cJRContributionData) {
        c();
        if (getView() != null) {
            View view = getView();
            if (view == null) {
                k.a();
            }
            TextView textView = (TextView) view.findViewById(R.id.tv_total_contribution_amount);
            CJROrderedCart u = b().u();
            if (u == null) {
                k.a();
            }
            net.one97.paytm.recharge.ordersummary.b.a b2 = b();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            CharSequence a2 = b2.a(context, cJRContributionData, u);
            if (!TextUtils.isEmpty(a2)) {
                k.a((Object) textView, "tvTotalContributionAmount");
                textView.setText(a2);
                textView.setVisibility(0);
                View view2 = getView();
                if (view2 == null) {
                    k.a();
                }
                View findViewById = view2.findViewById(R.id.title_total_contribution);
                k.a((Object) findViewById, "view!!.findViewById<Text…title_total_contribution)");
                ((TextView) findViewById).setVisibility(0);
                Group group = this.f64173d;
                if (group != null) {
                    group.setVisibility(0);
                    return;
                }
                return;
            }
            Group group2 = this.f64174e;
            if (group2 != null) {
                group2.setVisibility(0);
            }
        }
    }

    private final void c() {
        Group group;
        ConstraintLayout constraintLayout = (ConstraintLayout) b(R.id.real_contribution_details);
        if (constraintLayout != null) {
            ai.a(constraintLayout);
        }
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
            if (shimmerFrameLayout2 != null) {
                ai.b(shimmerFrameLayout2);
            }
        } catch (Exception unused) {
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) b(R.id.shimmer_contribution_details);
            if (shimmerFrameLayout3 != null) {
                ai.b(shimmerFrameLayout3);
            }
        }
        CJRTaggedObservable value = b().r.getValue();
        if ((value != null ? (CJRContributionData) value.getData() : null) == null && (group = this.f64174e) != null) {
            group.setVisibility(0);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.action_btn_base;
        if (valueOf != null && valueOf.intValue() == i2 && getParentFragment() != null && (getParentFragment() instanceof net.one97.paytm.recharge.ordersummary.f.b)) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                CJROrderActionsListView orderActionClickListener = ((net.one97.paytm.recharge.ordersummary.f.b) parentFragment).getOrderActionClickListener();
                if (orderActionClickListener != null) {
                    orderActionClickListener.onClick(view);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
        }
    }

    public final Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (((CJRCircleImageViewV8) b(R.id.operator_logo)) == null) {
            return hashMap;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String x = androidx.core.h.u.x((CJRCircleImageViewV8) b(R.id.operator_logo));
            if (x != null) {
                k.a((Object) x, "it");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.operator_logo);
                k.a((Object) cJRCircleImageViewV8, "operator_logo");
                hashMap.put(x, cJRCircleImageViewV8);
            }
            String x2 = androidx.core.h.u.x((TextView) b(R.id.operator_name));
            if (x2 != null) {
                k.a((Object) x2, "it");
                TextView textView = (TextView) b(R.id.operator_name);
                k.a((Object) textView, "operator_name");
                hashMap.put(x2, textView);
            }
            String x3 = androidx.core.h.u.x(b(R.id.bg_operator_logo));
            if (x3 != null) {
                k.a((Object) x3, "it");
                View b2 = b(R.id.bg_operator_logo);
                k.a((Object) b2, "bg_operator_logo");
                hashMap.put(x3, b2);
            }
        }
        if (this.f64164c != null) {
            CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64164c;
            if (cJRRechargeItemActionsListView == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        return hashMap;
    }
}
