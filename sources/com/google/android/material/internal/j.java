package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.y;
import java.util.Map;

public final class j extends Transition {
    public final void a(y yVar) {
        d(yVar);
    }

    public final void b(y yVar) {
        d(yVar);
    }

    private static void d(y yVar) {
        if (yVar.f4851b instanceof TextView) {
            yVar.f4850a.put("android:textscale:scale", Float.valueOf(((TextView) yVar.f4851b).getScaleX()));
        }
    }

    public final Animator a(ViewGroup viewGroup, y yVar, y yVar2) {
        if (yVar == null || yVar2 == null || !(yVar.f4851b instanceof TextView) || !(yVar2.f4851b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) yVar2.f4851b;
        Map<String, Object> map = yVar.f4850a;
        Map<String, Object> map2 = yVar2.f4850a;
        float f2 = 1.0f;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f2 = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
