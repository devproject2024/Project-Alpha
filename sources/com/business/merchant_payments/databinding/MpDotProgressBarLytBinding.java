package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.R;

public abstract class MpDotProgressBarLytBinding extends ViewDataBinding {
    public final LottieAnimationView animationView;

    public MpDotProgressBarLytBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView) {
        super(obj, view, i2);
        this.animationView = lottieAnimationView;
    }

    public static MpDotProgressBarLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpDotProgressBarLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpDotProgressBarLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_dot_progress_bar_lyt, viewGroup, z, obj);
    }

    public static MpDotProgressBarLytBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpDotProgressBarLytBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpDotProgressBarLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_dot_progress_bar_lyt, (ViewGroup) null, false, obj);
    }

    public static MpDotProgressBarLytBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpDotProgressBarLytBinding bind(View view, Object obj) {
        return (MpDotProgressBarLytBinding) ViewDataBinding.bind(obj, view, R.layout.mp_dot_progress_bar_lyt);
    }
}
