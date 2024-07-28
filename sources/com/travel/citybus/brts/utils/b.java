package com.travel.citybus.brts.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.View;

public final class b {
    public static Animator a(View view, View view2) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("visibility");
        objectAnimator.setObjectValues(new Object[]{0, 8});
        objectAnimator.setDuration(0);
        objectAnimator.setEvaluator(new a());
        objectAnimator.setTarget(view);
        view2.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationY", new float[]{0.0f, (float) (-view2.getMeasuredHeight())});
        ofFloat.setDuration(350);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).before(objectAnimator);
        return animatorSet;
    }

    public static class a implements TypeEvaluator<Integer> {
        public final /* bridge */ /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
            return f2 == 1.0f ? (Integer) obj2 : (Integer) obj;
        }
    }
}
