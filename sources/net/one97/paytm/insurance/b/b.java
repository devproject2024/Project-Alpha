package net.one97.paytm.insurance.b;

import com.airbnb.lottie.LottieAnimationView;

public enum b {
    INSTANCE;

    public final void setAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public final void setAnimation(LottieAnimationView lottieAnimationView, String str) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation(str);
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    public final void stopAnimation(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }
}
