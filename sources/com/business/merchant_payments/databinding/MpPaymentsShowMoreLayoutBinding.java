package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsShowMoreModel;

public abstract class MpPaymentsShowMoreLayoutBinding extends ViewDataBinding {
    public final LottieAnimationView animationView;
    public PaymentsShowMoreModel mModel;
    public final TextView showLessBtn;
    public final TextView showMoreBtn;

    public abstract void setModel(PaymentsShowMoreModel paymentsShowMoreModel);

    public MpPaymentsShowMoreLayoutBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.animationView = lottieAnimationView;
        this.showLessBtn = textView;
        this.showMoreBtn = textView2;
    }

    public PaymentsShowMoreModel getModel() {
        return this.mModel;
    }

    public static MpPaymentsShowMoreLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsShowMoreLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsShowMoreLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_show_more_layout, viewGroup, z, obj);
    }

    public static MpPaymentsShowMoreLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsShowMoreLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsShowMoreLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_show_more_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsShowMoreLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsShowMoreLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsShowMoreLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_show_more_layout);
    }
}
