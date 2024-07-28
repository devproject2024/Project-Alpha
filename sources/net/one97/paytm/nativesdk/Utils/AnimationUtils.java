package net.one97.paytm.nativesdk.Utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class AnimationUtils {
    public static void slideDown(final View view) {
        view.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = 1;
        view.setLayoutParams(layoutParams);
        view.measure(View.MeasureSpec.makeMeasureSpec(Resources.getSystem().getDisplayMetrics().widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int measuredHeight = view.getMeasuredHeight();
        ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{1, measuredHeight});
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
        ofInt.start();
    }

    public static void slideUp(final View view) {
        view.post(new Runnable() {
            public final void run() {
                ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{view.getHeight(), 0});
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
                    }
                });
                ofInt.start();
            }
        });
    }

    public static void rotate180(final View view) {
        view.post(new Runnable() {
            public final void run() {
                ValueAnimator ofInt = ObjectAnimator.ofInt(new int[]{(int) view.getRotation(), ((int) view.getRotation()) + AppConstants.READ_TIME_OUT});
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (intValue > 0) {
                            view.setRotation((float) intValue);
                            view.invalidate();
                        }
                    }
                });
                ofInt.start();
            }
        });
    }
}
