package net.one97.paytm.coins.c;

import com.airbnb.lottie.LottieAnimationView;
import kotlin.g.b.k;

public interface a {

    /* renamed from: net.one97.paytm.coins.c.a$a  reason: collision with other inner class name */
    public static final class C0247a {
        public static void a(LottieAnimationView lottieAnimationView, Boolean bool) {
            k.c(lottieAnimationView, "walletLoader");
            if (bool == null) {
                return;
            }
            if (bool.booleanValue()) {
                lottieAnimationView.setVisibility(0);
                net.one97.paytm.common.widgets.a.a(lottieAnimationView);
                return;
            }
            lottieAnimationView.setVisibility(8);
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        }
    }
}
