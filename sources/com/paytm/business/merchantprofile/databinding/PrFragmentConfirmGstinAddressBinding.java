package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.ConfirmGstinAddressViewModel;

public abstract class PrFragmentConfirmGstinAddressBinding extends ViewDataBinding {
    public final ImageView ivCross;
    public ConfirmGstinAddressViewModel mViewModel;
    public final RelativeLayout rlCross;

    public abstract void setViewModel(ConfirmGstinAddressViewModel confirmGstinAddressViewModel);

    public PrFragmentConfirmGstinAddressBinding(Object obj, View view, int i2, ImageView imageView, RelativeLayout relativeLayout) {
        super(obj, view, i2);
        this.ivCross = imageView;
        this.rlCross = relativeLayout;
    }

    public ConfirmGstinAddressViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrFragmentConfirmGstinAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentConfirmGstinAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentConfirmGstinAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_confirm_gstin_address, viewGroup, z, obj);
    }

    public static PrFragmentConfirmGstinAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentConfirmGstinAddressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentConfirmGstinAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_confirm_gstin_address, (ViewGroup) null, false, obj);
    }

    public static PrFragmentConfirmGstinAddressBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentConfirmGstinAddressBinding bind(View view, Object obj) {
        return (PrFragmentConfirmGstinAddressBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_confirm_gstin_address);
    }
}
