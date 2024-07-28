package net.one97.paytm.recharge.ordersummary.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import androidx.transition.u;
import com.squareup.picasso.e;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.ordersummary.c.d;
import net.one97.paytm.recharge.ordersummary.c.g;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public final class c extends j implements View.OnClickListener, o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f64099a;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64100h;

    public final View a(int i2) {
        if (this.f64100h == null) {
            this.f64100h = new HashMap();
        }
        View view = (View) this.f64100h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64100h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64100h;
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
        return layoutInflater.inflate(R.layout.content_order_details_credit_card, viewGroup, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
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
            int r0 = net.one97.paytm.recharge.R.id.amount_paid
            android.view.View r0 = r13.findViewById(r0)
            net.one97.paytm.recharge.common.widget.CJRAmountView r0 = (net.one97.paytm.recharge.common.widget.CJRAmountView) r0
            int r1 = net.one97.paytm.recharge.R.id.operator_logo
            android.view.View r1 = r13.findViewById(r1)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            int r1 = net.one97.paytm.recharge.R.id.operator_name
            android.view.View r1 = r13.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = net.one97.paytm.recharge.R.id.recharge_number
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = net.one97.paytm.recharge.R.id.operator_message
            android.view.View r3 = r13.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = net.one97.paytm.recharge.R.id.recharge_order_id
            android.view.View r4 = r13.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = net.one97.paytm.recharge.R.id.recharge_order_time
            android.view.View r5 = r13.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = net.one97.paytm.recharge.R.id.help_payment_not_showing
            android.view.View r13 = r13.findViewById(r6)
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r6 = "amountPaid"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r6 = r12.e()
            android.content.Context r7 = r12.getContext()
            if (r7 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            java.lang.String r8 = "context!!"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r6 = r6.g(r7, r14)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            java.lang.String r0 = "operatorName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r6 = r12.getContext()
            if (r6 != 0) goto L_0x009a
            kotlin.g.b.k.a()
        L_0x009a:
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r0 = r0.T(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            java.lang.String r0 = "rechargeNumber"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x00b8
            kotlin.g.b.k.a()
        L_0x00b8:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.String r0 = r0.Q(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            java.lang.String r0 = "rechargeOrderId"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x00d6
            kotlin.g.b.k.a()
        L_0x00d6:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.String r0 = r0.o(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.lang.String r0 = "rechargeOrderTime"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            android.content.Context r1 = r12.getContext()
            if (r1 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            java.lang.String r0 = r0.n(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r5.setText(r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r12.e()
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r0 = r0.m
            long r1 = r14.getId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r0
            net.one97.paytm.recharge.ordersummary.b.a r1 = r12.e()
            android.content.Context r2 = r12.getContext()
            if (r2 != 0) goto L_0x0121
            kotlin.g.b.k.a()
        L_0x0121:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            android.text.SpannableString r1 = r1.b((android.content.Context) r2, (net.one97.paytm.recharge.model.CJROSActionResponseV2) r0)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r10 = 0
            if (r2 != 0) goto L_0x013c
            java.lang.String r2 = "operatorMessage"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
            r3.setText(r1)
            r3.setVisibility(r10)
        L_0x013c:
            r1 = 0
            r11 = 1
            if (r0 == 0) goto L_0x0185
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r0.getItemLevelActions()
            if (r0 == 0) goto L_0x0185
            java.util.List r0 = r0.getActions()
            if (r0 == 0) goto L_0x0185
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0152:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0183
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.recharge.model.CJROSActionItemV2 r3 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r3
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r4 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r4 = r4.getACTION_TYPE_PAYMENT_NOT_SHOWING()
            java.lang.String r5 = r3.getmType()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r5, (boolean) r11)
            if (r4 == 0) goto L_0x017f
            int r4 = r3.getVisibility()
            r5 = 2
            if (r4 == r5) goto L_0x017d
            int r3 = r3.getVisibility()
            r4 = 3
            if (r3 != r4) goto L_0x017f
        L_0x017d:
            r3 = 1
            goto L_0x0180
        L_0x017f:
            r3 = 0
        L_0x0180:
            if (r3 == 0) goto L_0x0152
            r1 = r2
        L_0x0183:
            net.one97.paytm.recharge.model.CJROSActionItemV2 r1 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r1
        L_0x0185:
            if (r1 == 0) goto L_0x01a3
            java.lang.String r0 = "helpPaymentNotShowing"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            kotlin.o r0 = new kotlin.o
            java.lang.String r2 = r1.getmType()
            r0.<init>(r2, r1)
            r13.setTag(r0)
            r0 = r12
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
            r13.setVisibility(r10)
            r12.f64099a = r11
        L_0x01a3:
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x01f7
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            boolean r13 = r13 instanceof net.one97.paytm.recharge.ordersummary.f.b
            if (r13 == 0) goto L_0x01f7
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView$b r13 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.f64530e
            android.content.Context r0 = r12.getContext()
            if (r0 != 0) goto L_0x01bc
            kotlin.g.b.k.a()
        L_0x01bc:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r8)
            r1 = 2
            r2 = 3
            net.one97.paytm.recharge.ordersummary.b.a r4 = r12.e()
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x01ef
            r5 = r13
            net.one97.paytm.recharge.ordersummary.f.b r5 = (net.one97.paytm.recharge.ordersummary.f.b) r5
            r6 = 0
            r7 = 0
            r8 = 192(0xc0, float:2.69E-43)
            r3 = r14
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r13 = net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView.b.a(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r12.f64156g = r13
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r13 = r12.f64156g
            if (r13 == 0) goto L_0x01f7
            int r13 = net.one97.paytm.recharge.R.id.lyt_actions
            android.view.View r13 = r12.a((int) r13)
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            if (r13 == 0) goto L_0x01f7
            net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView r0 = r12.f64156g
            android.view.View r0 = (android.view.View) r0
            r13.addView(r0)
            goto L_0x01f7
        L_0x01ef:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener"
            r13.<init>(r14)
            throw r13
        L_0x01f7:
            r12.f64153d = r11
            r12.b()
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.e()
            java.lang.String r13 = r13.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r14)
            r14 = r13
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0247
            com.squareup.picasso.w r14 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x023c }
            com.squareup.picasso.aa r13 = r14.a((java.lang.String) r13)     // Catch:{ Exception -> 0x023c }
            com.paytm.utility.t$b r14 = new com.paytm.utility.t$b     // Catch:{ Exception -> 0x023c }
            android.content.res.Resources r0 = r12.getResources()     // Catch:{ Exception -> 0x023c }
            int r1 = net.one97.paytm.recharge.R.dimen.dimen_34dp     // Catch:{ Exception -> 0x023c }
            float r0 = r0.getDimension(r1)     // Catch:{ Exception -> 0x023c }
            int r0 = (int) r0     // Catch:{ Exception -> 0x023c }
            r14.<init>(r0, r10, r11)     // Catch:{ Exception -> 0x023c }
            com.squareup.picasso.ah r14 = (com.squareup.picasso.ah) r14     // Catch:{ Exception -> 0x023c }
            com.squareup.picasso.aa r13 = r13.a((com.squareup.picasso.ah) r14)     // Catch:{ Exception -> 0x023c }
            int r14 = net.one97.paytm.recharge.R.color.color_909090     // Catch:{ Exception -> 0x023c }
            com.squareup.picasso.aa r13 = r13.a((int) r14)     // Catch:{ Exception -> 0x023c }
            net.one97.paytm.recharge.ordersummary.d.c$b r14 = new net.one97.paytm.recharge.ordersummary.d.c$b     // Catch:{ Exception -> 0x023c }
            r14.<init>(r12)     // Catch:{ Exception -> 0x023c }
            com.squareup.picasso.e r14 = (com.squareup.picasso.e) r14     // Catch:{ Exception -> 0x023c }
            r13.a((android.widget.ImageView) r9, (com.squareup.picasso.e) r14)     // Catch:{ Exception -> 0x023c }
            return
        L_0x023c:
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x0246
            r13.startPostponedEnterTransition()
        L_0x0246:
            return
        L_0x0247:
            androidx.fragment.app.Fragment r13 = r12.getParentFragment()
            if (r13 == 0) goto L_0x0250
            r13.startPostponedEnterTransition()
        L_0x0250:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.d.c.a(android.view.View, android.os.Bundle):void");
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64102a;

        b(c cVar) {
            this.f64102a = cVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64102a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64102a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }

    public static final class a extends u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64101a;

        a(c cVar) {
            this.f64101a = cVar;
        }

        public final void b(Transition transition) {
            k.c(transition, "transition");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("onTransitionStart startPostInflate " + c.class.getName());
        }

        public final void a(Transition transition) {
            k.c(transition, "transition");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("onTransitionEnd " + c.class.getName());
            c cVar = this.f64101a;
            cVar.f64153d = true;
            if (((TextView) cVar.a(R.id.recharge_order_id)) != null) {
                this.f64101a.c();
            } else {
                this.f64101a.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        Fragment parentFragment = getParentFragment();
        Object sharedElementEnterTransition = parentFragment != null ? parentFragment.getSharedElementEnterTransition() : null;
        if (!(sharedElementEnterTransition instanceof Transition)) {
            sharedElementEnterTransition = null;
        }
        Transition transition = (Transition) sharedElementEnterTransition;
        if (transition != null) {
            transition.a((Transition.d) new a(this));
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        TextView textView;
        TextView textView2 = (TextView) a(R.id.recharge_order_id);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) a(R.id.recharge_order_time);
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = (TextView) a(R.id.title_amount_paid);
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        ImageView imageView = (ImageView) a(R.id.divider_order_id);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        CJRAmountView cJRAmountView = (CJRAmountView) a(R.id.amount_paid);
        if (cJRAmountView != null) {
            cJRAmountView.setVisibility(0);
        }
        View a2 = a(R.id.divider);
        if (a2 != null) {
            a2.setVisibility(0);
        }
        if (this.f64099a && (textView = (TextView) a(R.id.help_payment_not_showing)) != null) {
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_time), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder2, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.title_amount_paid), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder3, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder((CJRAmountView) a(R.id.amount_paid), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder4, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.help_payment_not_showing), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder5, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder6 = ObjectAnimator.ofPropertyValuesHolder((ImageView) a(R.id.divider_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder6, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder7 = ObjectAnimator.ofPropertyValuesHolder(a(R.id.divider), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder7, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(375);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new C1260c(this));
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2, ofPropertyValuesHolder3, ofPropertyValuesHolder4, ofPropertyValuesHolder5, ofPropertyValuesHolder7, ofPropertyValuesHolder6});
        animatorSet.start();
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.d.c$c  reason: collision with other inner class name */
    public static final class C1260c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f64103a;

        C1260c(c cVar) {
            this.f64103a = cVar;
        }

        public final void onAnimationStart(Animator animator) {
            TextView textView;
            TextView textView2 = (TextView) this.f64103a.a(R.id.recharge_order_id);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = (TextView) this.f64103a.a(R.id.recharge_order_time);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            TextView textView4 = (TextView) this.f64103a.a(R.id.title_amount_paid);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f64103a.a(R.id.divider_order_id);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            CJRAmountView cJRAmountView = (CJRAmountView) this.f64103a.a(R.id.amount_paid);
            if (cJRAmountView != null) {
                cJRAmountView.setVisibility(0);
            }
            View a2 = this.f64103a.a(R.id.divider);
            if (a2 != null) {
                a2.setVisibility(0);
            }
            if (this.f64103a.f64099a && (textView = (TextView) this.f64103a.a(R.id.help_payment_not_showing)) != null) {
                textView.setVisibility(0);
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

    public final void onClick(View view) {
        Object tag = view != null ? view.getTag() : null;
        if (tag instanceof kotlin.o) {
            kotlin.o oVar = (kotlin.o) tag;
            if (!k.a(oVar.getFirst(), (Object) CJROSActionItemV2.Companion.getACTION_TYPE_PAYMENT_NOT_SHOWING())) {
                return;
            }
            if (oVar.getSecond() != null) {
                g.a aVar = g.f64067a;
                String string = getString(R.string.v8_os_help_cc_payment_not_showing);
                k.a((Object) string, "getString(R.string.v8_os…p_cc_payment_not_showing)");
                g.a.a(string, getString(R.string.okay_got_it), kotlin.a.k.b((T[]) new String[]{getString(R.string.v8_os_help_cc_payment_not_showing_msg_1), getString(R.string.v8_os_help_cc_payment_not_showing_msg_2)})).show(getChildFragmentManager(), d.class.getSimpleName());
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.recharge.model.CJROSActionItemV2");
        }
    }
}
