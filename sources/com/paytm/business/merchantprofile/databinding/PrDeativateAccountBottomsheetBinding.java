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
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.inactivemerchant.InactiveMerchantListener;
import com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState;

public abstract class PrDeativateAccountBottomsheetBinding extends ViewDataBinding {
    public final AppCompatImageView closeIcon;
    public final AppCompatImageView icon;
    public final AppCompatImageView iconFailed;
    public MerchantAccountState mData;
    public InactiveMerchantListener mListener;
    public final TextView message;
    public final ConstraintLayout oarent;
    public final Barrier prBarrier;
    public final TextView title;

    public abstract void setData(MerchantAccountState merchantAccountState);

    public abstract void setListener(InactiveMerchantListener inactiveMerchantListener);

    public PrDeativateAccountBottomsheetBinding(Object obj, View view, int i2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, TextView textView, ConstraintLayout constraintLayout, Barrier barrier, TextView textView2) {
        super(obj, view, i2);
        this.closeIcon = appCompatImageView;
        this.icon = appCompatImageView2;
        this.iconFailed = appCompatImageView3;
        this.message = textView;
        this.oarent = constraintLayout;
        this.prBarrier = barrier;
        this.title = textView2;
    }

    public InactiveMerchantListener getListener() {
        return this.mListener;
    }

    public MerchantAccountState getData() {
        return this.mData;
    }

    public static PrDeativateAccountBottomsheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrDeativateAccountBottomsheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrDeativateAccountBottomsheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_deativate_account_bottomsheet, viewGroup, z, obj);
    }

    public static PrDeativateAccountBottomsheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrDeativateAccountBottomsheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrDeativateAccountBottomsheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_deativate_account_bottomsheet, (ViewGroup) null, false, obj);
    }

    public static PrDeativateAccountBottomsheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrDeativateAccountBottomsheetBinding bind(View view, Object obj) {
        return (PrDeativateAccountBottomsheetBinding) ViewDataBinding.bind(obj, view, R.layout.pr_deativate_account_bottomsheet);
    }
}
