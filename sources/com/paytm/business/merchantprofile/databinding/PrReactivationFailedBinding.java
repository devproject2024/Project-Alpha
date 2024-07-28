package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public abstract class PrReactivationFailedBinding extends ViewDataBinding {
    public final AppCompatImageView iconWarning;
    public MerchantAccountState mData;
    public InactiveMerchantListener mListener;
    public final TextView message;
    public final ConstraintLayout oarent;
    public final TextView title;

    public abstract void setData(MerchantAccountState merchantAccountState);

    public abstract void setListener(InactiveMerchantListener inactiveMerchantListener);

    public PrReactivationFailedBinding(Object obj, View view, int i2, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout, TextView textView2) {
        super(obj, view, i2);
        this.iconWarning = appCompatImageView;
        this.message = textView;
        this.oarent = constraintLayout;
        this.title = textView2;
    }

    public InactiveMerchantListener getListener() {
        return this.mListener;
    }

    public MerchantAccountState getData() {
        return this.mData;
    }

    public static PrReactivationFailedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrReactivationFailedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrReactivationFailedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_reactivation_failed, viewGroup, z, obj);
    }

    public static PrReactivationFailedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrReactivationFailedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrReactivationFailedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_reactivation_failed, (ViewGroup) null, false, obj);
    }

    public static PrReactivationFailedBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrReactivationFailedBinding bind(View view, Object obj) {
        return (PrReactivationFailedBinding) ViewDataBinding.bind(obj, view, R.layout.pr_reactivation_failed);
    }
}
