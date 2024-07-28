package net.one97.paytm.recharge.ordersummary.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.c;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.j;
import com.squareup.picasso.e;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public final class h extends j implements com.airbnb.lottie.h<Throwable>, j, o {

    /* renamed from: a  reason: collision with root package name */
    private boolean f64141a;

    /* renamed from: h  reason: collision with root package name */
    private boolean f64142h;

    /* renamed from: i  reason: collision with root package name */
    private String f64143i;
    private HashMap j;

    public final View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_order_details_metro_smart_card, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0183, code lost:
        r13 = r13.getItemLevelActions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r14 = "view"
            kotlin.g.b.k.c(r13, r14)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r12.e()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r14 = r14.u()
            if (r14 != 0) goto L_0x0012
            kotlin.g.b.k.a()
        L_0x0012:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            boolean r0 = r0.s
            if (r0 == 0) goto L_0x0027
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0027
            r12.a()
        L_0x0027:
            int r0 = net.one97.paytm.recharge.R.id.operator_logo
            android.view.View r0 = r13.findViewById(r0)
            r9 = r0
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            int r0 = net.one97.paytm.recharge.R.id.operator_name
            android.view.View r0 = r13.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.recharge.R.id.recharge_number
            android.view.View r1 = r13.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.recharge.R.id.operator_message
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.recharge.R.id.recharge_order_id
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.recharge.R.id.recharge_order_time
            android.view.View r13 = r13.findViewById(r4)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r4 = "operatorName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r12.e()
            android.content.Context r5 = r12.getContext()
            if (r5 != 0) goto L_0x006a
            kotlin.g.b.k.a()
        L_0x006a:
            java.lang.String r6 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r4 = r4.T(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r4 = r12.getContext()
            if (r4 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r0 = r0.Q(r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "rechargeNumber"
            if (r4 != 0) goto L_0x009d
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setText(r0)
            goto L_0x00a5
        L_0x009d:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0 = 8
            r1.setVisibility(r0)
        L_0x00a5:
            java.lang.String r0 = "rechargeOrderId"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x00b7
            kotlin.g.b.k.a()
        L_0x00b7:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r0 = r0.o(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.setText(r0)
            java.lang.String r0 = "rechargeOrderTime"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x00d5
            kotlin.g.b.k.a()
        L_0x00d5:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r0 = r0.n(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.e()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r13 = r13.m
            long r0 = r14.getId()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object r13 = r13.get(r0)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r13 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r13
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x0102
            kotlin.g.b.k.a()
        L_0x0102:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.text.SpannableString r0 = r0.b((android.content.Context) r1, (net.one97.paytm.recharge.model.CJROSActionResponseV2) r13)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r10 = 0
            r11 = 1
            if (r1 != 0) goto L_0x012d
            r12.f64154e = r11
            java.lang.String r1 = "operatorMessage"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r1)
            r2.setText(r0)
            r2.setVisibility(r10)
            int r0 = net.one97.paytm.recharge.R.id.group_operator_message
            android.view.View r0 = r12.a((int) r0)
            androidx.constraintlayout.widget.Group r0 = (androidx.constraintlayout.widget.Group) r0
            if (r0 == 0) goto L_0x012d
            r0.setVisibility(r10)
        L_0x012d:
            androidx.fragment.app.Fragment r0 = r12.getParentFragment()
            if (r0 == 0) goto L_0x0181
            androidx.fragment.app.Fragment r0 = r12.getParentFragment()
            boolean r0 = r0 instanceof net.one97.paytm.recharge.ordersummary.f.b
            if (r0 == 0) goto L_0x0181
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r0 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.content.Context r0 = r12.getContext()
            if (r0 != 0) goto L_0x0146
            kotlin.g.b.k.a()
        L_0x0146:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            r1 = 2
            r2 = 3
            net.one97.paytm.recharge.ordersummary.b.a r4 = r12.e()
            androidx.fragment.app.Fragment r3 = r12.getParentFragment()
            if (r3 == 0) goto L_0x0179
            r5 = r3
            net.one97.paytm.recharge.ordersummary.f.b r5 = (net.one97.paytm.recharge.ordersummary.f.b) r5
            r6 = 0
            r7 = 0
            r8 = 192(0xc0, float:2.69E-43)
            r3 = r14
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r0 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r12.f64156g = r0
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r0 = r12.f64156g
            if (r0 == 0) goto L_0x0181
            int r0 = net.one97.paytm.recharge.R.id.lyt_actions
            android.view.View r0 = r12.a((int) r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x0181
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r1 = r12.f64156g
            android.view.View r1 = (android.view.View) r1
            r0.addView(r1)
            goto L_0x0181
        L_0x0179:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener"
            r13.<init>(r14)
            throw r13
        L_0x0181:
            if (r13 == 0) goto L_0x018e
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r13 = r13.getItemLevelActions()
            if (r13 == 0) goto L_0x018e
            net.one97.paytm.recharge.model.CJROSMetroSmartCard r13 = r13.getMetroSmartCard()
            goto L_0x018f
        L_0x018e:
            r13 = 0
        L_0x018f:
            if (r13 == 0) goto L_0x01af
            java.lang.String r0 = r13.getAvmUrl()
            boolean r0 = android.webkit.URLUtil.isValidUrl(r0)
            if (r0 == 0) goto L_0x01af
            int r0 = r13.getVisibility()
            r1 = 2
            if (r0 == r1) goto L_0x01a9
            int r0 = r13.getVisibility()
            r1 = 3
            if (r0 != r1) goto L_0x01af
        L_0x01a9:
            java.lang.String r13 = r13.getAvmUrl()
            r12.f64143i = r13
        L_0x01af:
            r12.f()
            r12.f64153d = r11
            r12.b()
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.e()
            java.lang.String r13 = r13.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r14)
            r14 = r13
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0202
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x01f7 }
            com.squareup.picasso.aa r13 = r14.a((java.lang.String) r13)     // Catch:{ Exception -> 0x01f7 }
            com.paytm.utility.t$b r14 = new com.paytm.utility.t$b     // Catch:{ Exception -> 0x01f7 }
            android.content.res.Resources r0 = r12.getResources()     // Catch:{ Exception -> 0x01f7 }
            int r1 = net.one97.paytm.recharge.R.dimen.dimen_34dp     // Catch:{ Exception -> 0x01f7 }
            float r0 = r0.getDimension(r1)     // Catch:{ Exception -> 0x01f7 }
            int r0 = (int) r0     // Catch:{ Exception -> 0x01f7 }
            r14.<init>(r0, r10, r11)     // Catch:{ Exception -> 0x01f7 }
            com.squareup.picasso.ah r14 = (com.squareup.picasso.ah) r14     // Catch:{ Exception -> 0x01f7 }
            com.squareup.picasso.aa r13 = r13.a((com.squareup.picasso.ah) r14)     // Catch:{ Exception -> 0x01f7 }
            int r14 = net.one97.paytm.recharge.R.color.color_909090     // Catch:{ Exception -> 0x01f7 }
            com.squareup.picasso.aa r13 = r13.a((int) r14)     // Catch:{ Exception -> 0x01f7 }
            net.one97.paytm.recharge.ordersummary.d.h$a r14 = new net.one97.paytm.recharge.ordersummary.d.h$a     // Catch:{ Exception -> 0x01f7 }
            r14.<init>(r12)     // Catch:{ Exception -> 0x01f7 }
            com.squareup.picasso.e r14 = (com.squareup.picasso.e) r14     // Catch:{ Exception -> 0x01f7 }
            r13.a((android.widget.ImageView) r9, (com.squareup.picasso.e) r14)     // Catch:{ Exception -> 0x01f7 }
            return
        L_0x01f7:
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x0201
            r13.startPostponedEnterTransition()
        L_0x0201:
            return
        L_0x0202:
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x020b
            r13.startPostponedEnterTransition()
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.h.a(android.view.View, android.os.Bundle):void");
    }

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f64144a;

        a(h hVar) {
            this.f64144a = hVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64144a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64144a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        View findViewById;
        View findViewById2;
        if (!this.f64141a) {
            View view = getView();
            Group group = view != null ? (Group) view.findViewById(R.id.group_operator_message) : null;
            if (group != null) {
                group.setReferencedIds(new int[]{R.id.smart_card_title, R.id.operator_message});
            }
            View view2 = getView();
            if (!(view2 == null || (findViewById2 = view2.findViewById(R.id.next)) == null)) {
                findViewById2.setVisibility(8);
            }
            View view3 = getView();
            if (!(view3 == null || (findViewById = view3.findViewById(R.id.recharging_avm_anim)) == null)) {
                findViewById.setVisibility(8);
            }
            if (getView() instanceof ConstraintLayout) {
                c cVar = new c();
                View view4 = getView();
                if (view4 != null) {
                    cVar.b((ConstraintLayout) view4);
                    cVar.a(R.id.operator_message, 3, com.paytm.utility.b.c(16));
                    cVar.a(R.id.operator_message, 2, 0, 2);
                    View view5 = getView();
                    if (view5 != null) {
                        cVar.c((ConstraintLayout) view5);
                    } else {
                        throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                }
            }
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
        }
        if (!this.f64142h && !TextUtils.isEmpty(this.f64143i)) {
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView2 != null) {
                cJRRechargeLottieAnimationView2.addLottieOnCompositionLoadedListener(this);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView3 = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView3 != null) {
                cJRRechargeLottieAnimationView3.setFailureListener(this);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView4 = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView4 != null) {
                cJRRechargeLottieAnimationView4.setAnimationFromUrl(this.f64143i);
            }
            CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView5 = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
            if (cJRRechargeLottieAnimationView5 != null) {
                cJRRechargeLottieAnimationView5.playAnimation();
            }
        }
    }

    public final void aB_() {
        View findViewById;
        View findViewById2;
        this.f64141a = true;
        View view = getView();
        Group group = view != null ? (Group) view.findViewById(R.id.group_operator_message) : null;
        if (group != null) {
            group.setReferencedIds(new int[]{R.id.smart_card_title, R.id.operator_message, R.id.next, R.id.recharging_avm_anim});
        }
        View view2 = getView();
        if (!(view2 == null || (findViewById2 = view2.findViewById(R.id.next)) == null)) {
            findViewById2.setVisibility(0);
        }
        View view3 = getView();
        if (!(view3 == null || (findViewById = view3.findViewById(R.id.recharging_avm_anim)) == null)) {
            findViewById.setVisibility(0);
        }
        if (getView() instanceof ConstraintLayout) {
            c cVar = new c();
            View view4 = getView();
            if (view4 != null) {
                cVar.b((ConstraintLayout) view4);
                cVar.a(R.id.operator_message, 3, com.paytm.utility.b.c(8));
                cVar.a(R.id.operator_message, 2, R.id.recharging_avm_anim, 1);
                View view5 = getView();
                if (view5 != null) {
                    cVar.c((ConstraintLayout) view5);
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            }
            throw new u("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        TextView textView = (TextView) a(R.id.recharge_order_id);
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) a(R.id.recharge_order_time);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ImageView imageView = (ImageView) a(R.id.divider_order_id);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.f64154e) {
            Group group = (Group) a(R.id.group_operator_message);
            if (group != null) {
                group.setVisibility(0);
            }
            f();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder((ImageView) a(R.id.divider_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder2, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_time), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder3, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.smart_card_title), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder4, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(375);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new b(this));
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder3, ofPropertyValuesHolder2, ofPropertyValuesHolder4});
        animatorSet.start();
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f64145a;

        b(h hVar) {
            this.f64145a = hVar;
        }

        public final void onAnimationStart(Animator animator) {
            TextView textView = (TextView) this.f64145a.a(R.id.recharge_order_id);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) this.f64145a.a(R.id.recharge_order_time);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f64145a.a(R.id.divider_order_id);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.f64145a.f64154e) {
                Group group = (Group) this.f64145a.a(R.id.group_operator_message);
                if (group != null) {
                    group.setVisibility(0);
                }
                TextView textView3 = (TextView) this.f64145a.a(R.id.smart_card_title);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                this.f64145a.f();
            }
        }
    }

    public final Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (Build.VERSION.SDK_INT >= 21) {
            String x = androidx.core.h.u.x((CJRCircleImageViewV8) a(R.id.operator_logo));
            if (x != null) {
                k.a((Object) x, "it");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) a(R.id.operator_logo);
                k.a((Object) cJRCircleImageViewV8, "operator_logo");
                hashMap.put(x, cJRCircleImageViewV8);
            }
            String x2 = androidx.core.h.u.x((TextView) a(R.id.operator_name));
            if (x2 != null) {
                k.a((Object) x2, "it");
                TextView textView = (TextView) a(R.id.operator_name);
                k.a((Object) textView, "operator_name");
                hashMap.put(x2, textView);
            }
            String x3 = androidx.core.h.u.x((TextView) a(R.id.recharge_number));
            if (x3 != null) {
                k.a((Object) x3, "it");
                TextView textView2 = (TextView) a(R.id.recharge_number);
                k.a((Object) textView2, "recharge_number");
                hashMap.put(x3, textView2);
            }
            String x4 = androidx.core.h.u.x((TextView) a(R.id.recharge_order_id));
            if (x4 != null) {
                k.a((Object) x4, "it");
                TextView textView3 = (TextView) a(R.id.recharge_order_id);
                k.a((Object) textView3, "recharge_order_id");
                hashMap.put(x4, textView3);
            }
            String x5 = androidx.core.h.u.x((TextView) a(R.id.recharge_order_time));
            if (x5 != null) {
                k.a((Object) x5, "it");
                TextView textView4 = (TextView) a(R.id.recharge_order_time);
                k.a((Object) textView4, "recharge_order_time");
                hashMap.put(x5, textView4);
            }
            String x6 = androidx.core.h.u.x((TextView) a(R.id.operator_message));
            if (x6 != null) {
                k.a((Object) x6, "it");
                TextView textView5 = (TextView) a(R.id.operator_message);
                k.a((Object) textView5, "operator_message");
                hashMap.put(x6, textView5);
            }
            String x7 = androidx.core.h.u.x(a(R.id.bg_operator_logo));
            if (x7 != null) {
                k.a((Object) x7, "it");
                View a2 = a(R.id.bg_operator_logo);
                k.a((Object) a2, "bg_operator_logo");
                hashMap.put(x7, a2);
            }
            if (this.f64141a) {
                String x8 = androidx.core.h.u.x((TextView) a(R.id.next));
                if (x8 != null) {
                    k.a((Object) x8, "it");
                    TextView textView6 = (TextView) a(R.id.next);
                    k.a((Object) textView6, "next");
                    hashMap.put(x8, textView6);
                }
                String x9 = androidx.core.h.u.x((CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim));
                if (x9 != null) {
                    k.a((Object) x9, "it");
                    CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = (CJRRechargeLottieAnimationView) a(R.id.recharging_avm_anim);
                    k.a((Object) cJRRechargeLottieAnimationView, "recharging_avm_anim");
                    hashMap.put(x9, cJRRechargeLottieAnimationView);
                }
            }
        }
        if (this.f64156g != null) {
            CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64156g;
            if (cJRRechargeItemActionsListView == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        return hashMap;
    }

    public final /* synthetic */ void onResult(Object obj) {
        this.f64141a = false;
        this.f64142h = true;
        f();
    }
}
