package net.one97.paytm.moneytransfer.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;

public final class c {
    public static void a(final View view, int i2) {
        view.animate().translationX((float) (-view.getWidth())).setDuration(0).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
            }
        }).start();
        view.animate().translationX(0.0f).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
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

    public static void b(final View view, int i2) {
        view.animate().translationX((float) (-view.getWidth())).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
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

    public static void a(final View view) {
        view.animate().translationY((float) view.getHeight()).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(8);
            }
        }).start();
    }

    public static void b(final View view) {
        view.animate().translationY(0.0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
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

    public static void a(ImageView imageView, int i2) {
        imageView.clearAnimation();
        imageView.animate().rotation(i2 == 0 ? 180.0f : 0.0f).setDuration(300).start();
    }
}
