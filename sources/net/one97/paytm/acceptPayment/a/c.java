package net.one97.paytm.acceptPayment.a;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppCompatImageView f51971a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f51972b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f51973c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f51974d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f51975e;

    protected c(Object obj, View view, AppCompatImageView appCompatImageView, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, RoboTextView roboTextView, FrameLayout frameLayout) {
        super(obj, view, 0);
        this.f51971a = appCompatImageView;
        this.f51972b = lottieAnimationView;
        this.f51973c = constraintLayout;
        this.f51974d = roboTextView;
        this.f51975e = frameLayout;
    }
}
