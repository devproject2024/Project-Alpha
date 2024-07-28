package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public abstract class PrPaymentsInActiveMerchantBinding extends ViewDataBinding {
    public final LottieAnimationView animationView;
    public final TextView contactUsOn;
    public final AppCompatImageView icon;
    public final ConstraintLayout inActiveMerchant;
    public MerchantAccountState mData;
    public InactiveMerchantListener mListener;
    public final TextView message;
    public final PrPastPaymentBinding pastPayment;
    public final Barrier prBarrier;
    public final TextView title;

    public abstract void setData(MerchantAccountState merchantAccountState);

    public abstract void setListener(InactiveMerchantListener inactiveMerchantListener);

    public PrPaymentsInActiveMerchantBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, TextView textView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView2, PrPastPaymentBinding prPastPaymentBinding, Barrier barrier, TextView textView3) {
        super(obj, view, i2);
        this.animationView = lottieAnimationView;
        this.contactUsOn = textView;
        this.icon = appCompatImageView;
        this.inActiveMerchant = constraintLayout;
        this.message = textView2;
        this.pastPayment = prPastPaymentBinding;
        setContainedBinding(prPastPaymentBinding);
        this.prBarrier = barrier;
        this.title = textView3;
    }

    public InactiveMerchantListener getListener() {
        return this.mListener;
    }

    public MerchantAccountState getData() {
        return this.mData;
    }

    public static PrPaymentsInActiveMerchantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrPaymentsInActiveMerchantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrPaymentsInActiveMerchantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_payments_in_active_merchant, viewGroup, z, obj);
    }

    public static PrPaymentsInActiveMerchantBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrPaymentsInActiveMerchantBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrPaymentsInActiveMerchantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_payments_in_active_merchant, (ViewGroup) null, false, obj);
    }

    public static PrPaymentsInActiveMerchantBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrPaymentsInActiveMerchantBinding bind(View view, Object obj) {
        return (PrPaymentsInActiveMerchantBinding) ViewDataBinding.bind(obj, view, R.layout.pr_payments_in_active_merchant);
    }
}
