package net.one97.paytm.recharge.creditcard;

import android.animation.Animator;
import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public final class CJRCardReturnTransition extends Transition implements Animator.AnimatorListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f62341c = new a((byte) 0);
    private static final String l = l;
    private static final String m = m;
    private static final String[] n = {l, m};

    /* renamed from: a  reason: collision with root package name */
    boolean f62342a;

    /* renamed from: b  reason: collision with root package name */
    CJRCreditCardModelV8 f62343b;

    /* renamed from: d  reason: collision with root package name */
    private View f62344d;

    /* renamed from: e  reason: collision with root package name */
    private View f62345e;

    /* renamed from: f  reason: collision with root package name */
    private View f62346f;

    /* renamed from: g  reason: collision with root package name */
    private View f62347g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f62348h;

    /* renamed from: i  reason: collision with root package name */
    private float f62349i;
    private float j;
    private float k;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public CJRCardReturnTransition() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRCardReturnTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final String[] getTransitionProperties() {
        return n;
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, true);
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, false);
    }

    private static void a(TransitionValues transitionValues, boolean z) {
        View view;
        if (transitionValues != null && (view = transitionValues.view) != null && view.getId() == R.id.cc_card_view) {
            View view2 = transitionValues.view;
            if (view2 != null) {
                Map map = transitionValues.values;
                k.a((Object) map, "transitionValues.values");
                map.put(l, (CardView) view2);
                Map map2 = transitionValues.values;
                k.a((Object) map2, "transitionValues.values");
                map2.put(m, Boolean.valueOf(z));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.cardview.widget.CardView");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r0 = r0.getDisplayCardNumber();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r12, android.transition.TransitionValues r13, android.transition.TransitionValues r14) {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x01f2
            if (r13 == 0) goto L_0x01f2
            if (r14 != 0) goto L_0x0008
            goto L_0x01f2
        L_0x0008:
            java.util.Map r13 = r13.values
            java.lang.String r14 = l
            java.lang.Object r13 = r13.get(r14)
            if (r13 == 0) goto L_0x01ea
            androidx.cardview.widget.CardView r13 = (androidx.cardview.widget.CardView) r13
            int r14 = net.one97.paytm.recharge.R.id.appbar_layout
            android.view.View r12 = r12.findViewById(r14)
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12
            int r14 = net.one97.paytm.recharge.R.id.etCreditCard
            android.view.View r14 = r13.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "cardNumber"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r0 = r11.f62343b
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = r0.getDisplayCardNumber()
            if (r0 == 0) goto L_0x0038
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x003b
        L_0x0038:
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x003b:
            r14.setText(r0)
            int r14 = net.one97.paytm.recharge.R.id.etCreditCardHint
            android.view.View r14 = r13.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "cardHint"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r0 = r11.f62343b
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = r0.getDisplayCardNumber()
            if (r0 == 0) goto L_0x0058
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x005b
        L_0x0058:
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x005b:
            r14.setText(r0)
            int r14 = net.one97.paytm.recharge.R.id.txt_card_number
            android.view.View r14 = r13.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r11.f62348h = r14
            android.widget.TextView r14 = r11.f62348h
            if (r14 != 0) goto L_0x006f
            kotlin.g.b.k.a()
        L_0x006f:
            net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8 r0 = r11.f62343b
            if (r0 == 0) goto L_0x007c
            java.lang.String r0 = r0.getDisplayCardNumber()
            if (r0 == 0) goto L_0x007c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x007f
        L_0x007c:
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x007f:
            r14.setText(r0)
            android.graphics.Rect r14 = new android.graphics.Rect
            r14.<init>()
            r13.getGlobalVisibleRect(r14)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = net.one97.paytm.recharge.R.id.creditcardnumber_get_view
            android.view.View r1 = r13.findViewById(r1)
            r11.f62344d = r1
            android.view.View r1 = r11.f62344d
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            r1.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            int r2 = net.one97.paytm.recharge.R.id.creditcardnumber_set_view
            android.view.View r2 = r13.findViewById(r2)
            r11.f62345e = r2
            android.view.View r2 = r11.f62345e
            if (r2 != 0) goto L_0x00b5
            kotlin.g.b.k.a()
        L_0x00b5:
            r2.getGlobalVisibleRect(r1)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            int r2 = net.one97.paytm.recharge.R.id.amount_view
            android.view.View r2 = r13.findViewById(r2)
            r11.f62347g = r2
            android.view.View r2 = r11.f62347g
            if (r2 != 0) goto L_0x00cc
            kotlin.g.b.k.a()
        L_0x00cc:
            r2.getGlobalVisibleRect(r1)
            int r1 = net.one97.paytm.recharge.R.id.rupee_view
            android.view.View r13 = r13.findViewById(r1)
            r11.f62346f = r13
            int r13 = r0.top
            int r1 = r14.top
            int r13 = r13 - r1
            int r13 = java.lang.Math.abs(r13)
            r1 = 2
            int r13 = r13 / r1
            float r13 = (float) r13
            r11.f62349i = r13
            android.view.View r13 = r11.f62344d
            android.util.Property r2 = android.view.View.TRANSLATION_Y
            r3 = 1
            float[] r4 = new float[r3]
            r5 = 0
            r6 = 0
            r4[r6] = r5
            android.animation.ObjectAnimator r13 = android.animation.ObjectAnimator.ofFloat(r13, r2, r4)
            android.view.View r2 = r11.f62344d
            android.util.Property r4 = android.view.View.ALPHA
            float[] r5 = new float[r1]
            r5 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r2, r4, r5)
            java.lang.String r4 = "animCCGetViewAlpha"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.view.animation.AccelerateInterpolator r4 = new android.view.animation.AccelerateInterpolator
            r5 = 1073741824(0x40000000, float:2.0)
            r4.<init>(r5)
            android.animation.TimeInterpolator r4 = (android.animation.TimeInterpolator) r4
            r2.setInterpolator(r4)
            int r0 = r0.top
            int r4 = r14.top
            int r0 = r0 - r4
            int r0 = java.lang.Math.abs(r0)
            int r0 = r0 / r1
            float r0 = (float) r0
            r11.j = r0
            android.view.View r0 = r11.f62345e
            android.util.Property r4 = android.view.View.TRANSLATION_Y
            float[] r5 = new float[r3]
            float r7 = r11.f62349i
            r5[r6] = r7
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r4, r5)
            android.view.View r4 = r11.f62345e
            android.util.Property r5 = android.view.View.ALPHA
            float[] r7 = new float[r1]
            r7 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofFloat(r4, r5, r7)
            java.lang.String r5 = "animCCSetViewAlpha"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.view.animation.AccelerateDecelerateInterpolator r5 = new android.view.animation.AccelerateDecelerateInterpolator
            r5.<init>()
            android.animation.TimeInterpolator r5 = (android.animation.TimeInterpolator) r5
            r4.setInterpolator(r5)
            int r14 = r14.bottom
            int r14 = java.lang.Math.abs(r14)
            float r14 = (float) r14
            r11.k = r14
            android.view.View r14 = r11.f62347g
            android.util.Property r5 = android.view.View.TRANSLATION_Y
            float[] r7 = new float[r3]
            float r8 = r11.k
            r7[r6] = r8
            android.animation.ObjectAnimator r14 = android.animation.ObjectAnimator.ofFloat(r14, r5, r7)
            android.view.View r5 = r11.f62347g
            android.util.Property r7 = android.view.View.ALPHA
            float[] r8 = new float[r1]
            r8 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofFloat(r5, r7, r8)
            android.view.View r7 = r11.f62347g
            android.util.Property r8 = android.view.View.SCALE_Y
            float[] r9 = new float[r1]
            r9 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r7, r8, r9)
            android.view.View r8 = r11.f62346f
            android.util.Property r9 = android.view.View.TRANSLATION_Y
            float[] r3 = new float[r3]
            float r10 = r11.k
            r3[r6] = r10
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r8, r9, r3)
            android.view.View r6 = r11.f62346f
            android.util.Property r8 = android.view.View.ALPHA
            float[] r9 = new float[r1]
            r9 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofFloat(r6, r8, r9)
            android.view.View r8 = r11.f62346f
            android.util.Property r9 = android.view.View.SCALE_Y
            float[] r10 = new float[r1]
            r10 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r10)
            android.util.Property r9 = android.view.View.ALPHA
            float[] r1 = new float[r1]
            r1 = {0, 1065353216} // fill-array
            android.animation.ObjectAnimator r12 = android.animation.ObjectAnimator.ofFloat(r12, r9, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r12)
            boolean r12 = r11.f62342a
            if (r12 != 0) goto L_0x01bf
            r1.add(r13)
            r1.add(r2)
        L_0x01bf:
            r1.add(r0)
            r1.add(r4)
            r1.add(r14)
            r1.add(r5)
            r1.add(r7)
            r1.add(r3)
            r1.add(r6)
            r1.add(r8)
            android.animation.AnimatorSet r12 = new android.animation.AnimatorSet
            r12.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            r12.playTogether(r1)
            r13 = r11
            android.animation.Animator$AnimatorListener r13 = (android.animation.Animator.AnimatorListener) r13
            r12.addListener(r13)
            android.animation.Animator r12 = (android.animation.Animator) r12
            return r12
        L_0x01ea:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type androidx.cardview.widget.CardView"
            r12.<init>(r13)
            throw r12
        L_0x01f2:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.creditcard.CJRCardReturnTransition.createAnimator(android.view.ViewGroup, android.transition.TransitionValues, android.transition.TransitionValues):android.animation.Animator");
    }

    public final void onAnimationStart(Animator animator) {
        View view;
        if (!this.f62342a && (view = this.f62344d) != null) {
            view.setVisibility(0);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        TextView textView = this.f62348h;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.f62345e;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f62346f;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f62347g;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }
}
