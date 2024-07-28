package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    public int f35900a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f35901b = 2;

    /* renamed from: c  reason: collision with root package name */
    public int f35902c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ViewPropertyAnimator f35903d;

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.f35900a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i2);
    }

    private void a(V v, int i2, long j, TimeInterpolator timeInterpolator) {
        this.f35903d = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f35903d = null;
            }
        });
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i3 > 0) {
            if (this.f35901b != 1) {
                ViewPropertyAnimator viewPropertyAnimator = this.f35903d;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                    v.clearAnimation();
                }
                this.f35901b = 1;
                a(v, this.f35900a + this.f35902c, 175, a.f35802c);
            }
        } else if (i3 < 0 && this.f35901b != 2) {
            ViewPropertyAnimator viewPropertyAnimator2 = this.f35903d;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.cancel();
                v.clearAnimation();
            }
            this.f35901b = 2;
            a(v, 0, 225, a.f35803d);
        }
    }
}
