package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class aq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final cs f23618a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f23619b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23620c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f23621d;

    /* renamed from: e  reason: collision with root package name */
    public final RoboTextView f23622e;

    /* renamed from: f  reason: collision with root package name */
    protected SRPSharedViewModel f23623f;

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    protected aq(Object obj, View view, cs csVar, LottieAnimationView lottieAnimationView, ImageView imageView, RoboTextView roboTextView, RoboTextView roboTextView2) {
        super(obj, view, 2);
        this.f23618a = csVar;
        setContainedBinding(this.f23618a);
        this.f23619b = lottieAnimationView;
        this.f23620c = imageView;
        this.f23621d = roboTextView;
        this.f23622e = roboTextView2;
    }

    public static aq a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (aq) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_srp_loading, viewGroup, false, f.a());
    }
}
