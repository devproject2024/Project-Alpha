package net.one97.paytm.upi.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.interpolator.a.a.a;
import androidx.interpolator.a.a.b;
import androidx.interpolator.a.a.c;
import com.airbnb.lottie.LottieAnimationView;

public class AnimationUtils {
    public static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new a();
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new b();
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new c();

    public static float lerp(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int lerp(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }

    public static int expandWidth(final View view, int i2) {
        final int measuredWidth = i2 - view.getMeasuredWidth();
        AnonymousClass1 r0 = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                view.getLayoutParams().width = f2 == 1.0f ? -2 : (int) (((float) measuredWidth) * f2);
                view.requestLayout();
            }
        };
        if (measuredWidth > 0) {
            int i3 = (int) (((float) measuredWidth) / view.getContext().getResources().getDisplayMetrics().density);
            r0.setDuration((long) i3);
            view.startAnimation(r0);
            return i3;
        }
        view.setVisibility(0);
        return 0;
    }

    public static int collapseWidth(final View view) {
        final int measuredWidth = view.getMeasuredWidth();
        AnonymousClass3 r1 = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                if (f2 == 1.0f) {
                    view.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredWidth;
                layoutParams.width = i2 - ((int) (((float) i2) * f2));
                view.requestLayout();
            }
        };
        if (measuredWidth <= 0) {
            return 0;
        }
        int i2 = (int) (((float) measuredWidth) / view.getContext().getResources().getDisplayMetrics().density);
        r1.setDuration((long) i2);
        view.startAnimation(r1);
        return i2;
    }

    public static int expandHeight(final View view, int i2) {
        final int measuredHeight = view.getMeasuredHeight();
        if (i2 != -1) {
            measuredHeight = i2 - view.getMeasuredHeight();
        }
        AnonymousClass4 r4 = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                view.getLayoutParams().height = f2 == 1.0f ? -2 : (int) (((float) measuredHeight) * f2);
                view.requestLayout();
            }
        };
        int i3 = (int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density);
        r4.setDuration(1000);
        view.startAnimation(r4);
        return i3;
    }

    public static int collapseHeight(final View view) {
        final int measuredHeight = view.getMeasuredHeight();
        AnonymousClass5 r1 = new Animation() {
            public final boolean willChangeBounds() {
                return true;
            }

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                if (f2 == 1.0f) {
                    view.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i2 = measuredHeight;
                layoutParams.height = i2 - ((int) (((float) i2) * f2));
                view.requestLayout();
            }
        };
        int i2 = (int) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density);
        r1.setDuration((long) i2);
        view.startAnimation(r1);
        return i2;
    }

    public static void expandView(final View view, int i2) {
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

    public static void expandView2(final View view, int i2) {
        view.animate().translationY(50.0f).setDuration((long) i2).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        }).start();
    }

    public static void expandViewAlongWidth(final View view, int i2) {
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

    public static void collapseViewAlongWidth(final View view, int i2) {
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

    public static void collapseView(final View view, int i2) {
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

    public static void setJsonLottieAnimation(LottieAnimationView lottieAnimationView, String str) {
        if (lottieAnimationView != null && !TextUtils.isEmpty(str)) {
            lottieAnimationView.setAnimationFromJson(str, (String) null);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
            lottieAnimationView.setVisibility(0);
        }
    }
}
