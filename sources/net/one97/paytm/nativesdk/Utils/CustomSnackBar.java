package net.one97.paytm.nativesdk.Utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CustomSnackBar {
    private static final int ANIMATION_DURATION = 350;

    public interface Duration {
        public static final int INDEFINATE = 0;
        public static final int LENGTH_LONG = 3500;
        public static final int LENGTH_SHORT = 2500;
    }

    public static void showView(final CoordinatorLayout coordinatorLayout, final View view, int i2) {
        coordinatorLayout.addView(view);
        CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
        dVar.f2605c = 48;
        dVar.height = 1;
        view.setLayoutParams(dVar);
        view.setVisibility(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(Resources.getSystem().getDisplayMetrics().widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int measuredHeight = view.getMeasuredHeight();
        ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{1, measuredHeight});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(350);
        ofInt.setStartDelay(350);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (measuredHeight > intValue) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = intValue;
                    view.setLayoutParams(layoutParams);
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.height = -2;
                view.setLayoutParams(layoutParams2);
            }
        });
        if (i2 > 0) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    CustomSnackBar.hideView(coordinatorLayout, view);
                }
            }, (long) i2);
        }
        ofInt.start();
    }

    public static void hideView(final CoordinatorLayout coordinatorLayout, final View view) {
        view.post(new Runnable() {
            public final void run() {
                ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{view.getHeight(), 0});
                ofInt.setInterpolator(new AccelerateInterpolator());
                ofInt.setDuration(350);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (intValue > 0) {
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            layoutParams.height = intValue;
                            view.setLayoutParams(layoutParams);
                            return;
                        }
                        view.setVisibility(8);
                        coordinatorLayout.removeView(view);
                    }
                });
                ofInt.start();
            }
        });
    }
}
