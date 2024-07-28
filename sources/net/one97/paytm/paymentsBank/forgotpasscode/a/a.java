package net.one97.paytm.paymentsBank.forgotpasscode.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.p;

public class a extends p implements net.one97.paytm.paymentsBank.pdc.b.a {

    /* renamed from: a  reason: collision with root package name */
    private View f18371a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f18372b;

    public final void a(Object obj) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18371a = layoutInflater.inflate(R.layout.pb_activity_forgot_passcode_loading, viewGroup, false);
        this.f18372b = (LottieAnimationView) this.f18371a.findViewById(R.id.card_dot_progress_bar);
        LottieAnimationView lottieAnimationView = this.f18372b;
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
        return this.f18371a;
    }

    public void onDestroyView() {
        LottieAnimationView lottieAnimationView = this.f18372b;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
        super.onDestroyView();
    }
}
