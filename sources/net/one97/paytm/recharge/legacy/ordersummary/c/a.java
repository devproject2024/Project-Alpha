package net.one97.paytm.recharge.legacy.ordersummary.c;

import android.animation.Animator;
import android.transition.Slide;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

public final class a extends Slide {

    /* renamed from: a  reason: collision with root package name */
    private final int f63064a = 3;

    /* renamed from: b  reason: collision with root package name */
    private final int f63065b = 5;

    public a() {
        super(3);
    }

    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        setSlideEdge(this.f63065b);
        if (viewGroup == null || view == null || transitionValues == null || transitionValues2 == null) {
            return null;
        }
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }
}
