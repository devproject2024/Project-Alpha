package net.one97.paytm.wallet.newdesign.universalp2p.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.a.a.b;
import androidx.interpolator.a.a.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f71451a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f71452b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final Interpolator f71453c = new androidx.interpolator.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final Interpolator f71454d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final Interpolator f71455e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static void a(final View view, int i2) {
        view.animate().translationY(0.0f).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                view.setVisibility(0);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        }).start();
    }

    public static void a(final View view) {
        view.animate().translationX((float) (-view.getWidth())).setDuration(0).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        }).start();
        view.animate().translationX(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        }).start();
    }

    public static void b(final View view) {
        view.animate().translationX((float) (-view.getWidth())).setDuration(300).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(4);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        }).start();
    }

    public static void b(final View view, int i2) {
        view.animate().translationY((float) view.getHeight()).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        }).start();
    }
}
