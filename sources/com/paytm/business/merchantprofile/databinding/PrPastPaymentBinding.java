package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public abstract class PrPastPaymentBinding extends ViewDataBinding {
    public MerchantAccountState mData;
    public InactiveMerchantListener mListener;
    public final ConstraintLayout parent;
    public final TextView viewPastPayments;

    public abstract void setData(MerchantAccountState merchantAccountState);

    public abstract void setListener(InactiveMerchantListener inactiveMerchantListener);

    public PrPastPaymentBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i2);
        this.parent = constraintLayout;
        this.viewPastPayments = textView;
    }

    public InactiveMerchantListener getListener() {
        return this.mListener;
    }

    public MerchantAccountState getData() {
        return this.mData;
    }

    public static PrPastPaymentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrPastPaymentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrPastPaymentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_past_payment, viewGroup, z, obj);
    }

    public static PrPastPaymentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrPastPaymentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrPastPaymentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_past_payment, (ViewGroup) null, false, obj);
    }

    public static PrPastPaymentBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrPastPaymentBinding bind(View view, Object obj) {
        return (PrPastPaymentBinding) ViewDataBinding.bind(obj, view, R.layout.pr_past_payment);
    }
}
