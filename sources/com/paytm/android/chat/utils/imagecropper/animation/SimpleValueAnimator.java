package com.paytm.android.chat.utils.imagecropper.animation;

public interface SimpleValueAnimator {
    void addAnimatorListener(SimpleValueAnimatorListener simpleValueAnimatorListener);

    void cancelAnimation();

    boolean isAnimationStarted();

    void startAnimation(long j);
}
