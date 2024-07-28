package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotels2.R;

public abstract class gi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29832a;

    /* renamed from: b  reason: collision with root package name */
    public final Toolbar f29833b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29834c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f29835d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29836e;

    /* renamed from: f  reason: collision with root package name */
    protected SRPHeaderViewModel f29837f;

    public abstract void a(SRPHeaderViewModel sRPHeaderViewModel);

    protected gi(Object obj, View view, ImageView imageView, Toolbar toolbar, TextView textView, LottieAnimationView lottieAnimationView, TextView textView2) {
        super(obj, view, 0);
        this.f29832a = imageView;
        this.f29833b = toolbar;
        this.f29834c = textView;
        this.f29835d = lottieAnimationView;
        this.f29836e = textView2;
    }

    public static gi a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (gi) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hotel4_srp_loader, viewGroup, false, f.a());
    }
}
