package com.paytmmall.clpartifact.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class AnimationUtil {
    public static void expand(View view) {
        view.startAnimation(expandAction(view));
    }

    private static Animation expandAction(final View view) {
        if (view == null) {
            return null;
        }
        view.measure(-1, -2);
        final int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        view.setVisibility(0);
        AnonymousClass1 r1 = new Animation() {
            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                view.getLayoutParams().height = f2 == 1.0f ? -2 : (int) (((float) measuredHeight) * f2);
                view.requestLayout();
            }
        };
        r1.setDuration((long) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(r1);
        return r1;
    }

    public static void collapse(final View view) {
        if (view != null) {
            final int measuredHeight = view.getMeasuredHeight();
            AnonymousClass2 r1 = new Animation() {
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
            r1.setDuration((long) (((float) measuredHeight) / view.getContext().getResources().getDisplayMetrics().density));
            view.startAnimation(r1);
        }
    }
}
