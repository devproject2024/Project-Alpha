package com.airbnb.lottie.f;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    final Set<Animator.AnimatorListener> f6107a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f6108b = new CopyOnWriteArraySet();

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f6108b.add(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f6108b.remove(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.f6108b.clear();
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f6107a.add(animatorListener);
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f6107a.remove(animatorListener);
    }

    public void removeAllListeners() {
        this.f6107a.clear();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        for (Animator.AnimatorListener next : this.f6107a) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    public final void a() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f6108b) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }
}
