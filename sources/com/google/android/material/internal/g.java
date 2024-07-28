package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<a> f36464a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f36465b = null;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f36466c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f36467d = new AnimatorListenerAdapter() {
        public final void onAnimationEnd(Animator animator) {
            if (g.this.f36466c == animator) {
                g.this.f36466c = null;
            }
        }
    };

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f36467d);
        this.f36464a.add(aVar);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f36469a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueAnimator f36470b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f36469a = iArr;
            this.f36470b = valueAnimator;
        }
    }
}
