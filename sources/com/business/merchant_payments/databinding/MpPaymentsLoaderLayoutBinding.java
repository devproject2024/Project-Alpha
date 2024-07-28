package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.R;

public abstract class MpPaymentsLoaderLayoutBinding extends ViewDataBinding {
    public final LottieAnimationView animationView;

    public MpPaymentsLoaderLayoutBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView) {
        super(obj, view, i2);
        this.animationView = lottieAnimationView;
    }

    public static MpPaymentsLoaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsLoaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsLoaderLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_loader_layout, viewGroup, z, obj);
    }

    public static MpPaymentsLoaderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsLoaderLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsLoaderLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_loader_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsLoaderLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsLoaderLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsLoaderLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_loader_layout);
    }
}
