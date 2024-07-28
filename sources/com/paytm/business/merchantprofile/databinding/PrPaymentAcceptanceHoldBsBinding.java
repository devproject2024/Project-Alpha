package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public abstract class PrPaymentAcceptanceHoldBsBinding extends ViewDataBinding {
    public final PrDeativateAccountBottomsheetBinding apUi;
    public final TextView contactUsOn;
    public final ConstraintLayout inActiveMerchant;
    public MerchantAccountState mData;
    public InactiveMerchantListener mListener;
    public final Barrier mpLayoutBarrier;
    public final PrReactivationFailedBinding reactivationFailed;

    public abstract void setData(MerchantAccountState merchantAccountState);

    public abstract void setListener(InactiveMerchantListener inactiveMerchantListener);

    public PrPaymentAcceptanceHoldBsBinding(Object obj, View view, int i2, PrDeativateAccountBottomsheetBinding prDeativateAccountBottomsheetBinding, TextView textView, ConstraintLayout constraintLayout, Barrier barrier, PrReactivationFailedBinding prReactivationFailedBinding) {
        super(obj, view, i2);
        this.apUi = prDeativateAccountBottomsheetBinding;
        setContainedBinding(prDeativateAccountBottomsheetBinding);
        this.contactUsOn = textView;
        this.inActiveMerchant = constraintLayout;
        this.mpLayoutBarrier = barrier;
        this.reactivationFailed = prReactivationFailedBinding;
        setContainedBinding(prReactivationFailedBinding);
    }

    public InactiveMerchantListener getListener() {
        return this.mListener;
    }

    public MerchantAccountState getData() {
        return this.mData;
    }

    public static PrPaymentAcceptanceHoldBsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrPaymentAcceptanceHoldBsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrPaymentAcceptanceHoldBsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_payment_acceptance_hold_bs, viewGroup, z, obj);
    }

    public static PrPaymentAcceptanceHoldBsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrPaymentAcceptanceHoldBsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrPaymentAcceptanceHoldBsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_payment_acceptance_hold_bs, (ViewGroup) null, false, obj);
    }

    public static PrPaymentAcceptanceHoldBsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrPaymentAcceptanceHoldBsBinding bind(View view, Object obj) {
        return (PrPaymentAcceptanceHoldBsBinding) ViewDataBinding.bind(obj, view, R.layout.pr_payment_acceptance_hold_bs);
    }
}
