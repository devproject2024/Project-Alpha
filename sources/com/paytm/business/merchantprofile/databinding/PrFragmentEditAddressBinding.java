package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.EditAddressViewModel;

public abstract class PrFragmentEditAddressBinding extends ViewDataBinding {
    public final CustomTextInputEditText etAddress1;
    public final CustomTextInputEditText etAddress2;
    public final CustomTextInputEditText etAddress3;
    public final CustomTextInputEditText etCity;
    public final CustomTextInputEditText etPincode;
    public final ImageView ivCross;
    public EditAddressViewModel mViewModel;
    public final LinearLayout parentContainer;
    public final RelativeLayout rlCross;
    public final Spinner stateSpinner;
    public final CustomTextView tvContinue;
    public final CustomTextView tvState;

    public abstract void setViewModel(EditAddressViewModel editAddressViewModel);

    public PrFragmentEditAddressBinding(Object obj, View view, int i2, CustomTextInputEditText customTextInputEditText, CustomTextInputEditText customTextInputEditText2, CustomTextInputEditText customTextInputEditText3, CustomTextInputEditText customTextInputEditText4, CustomTextInputEditText customTextInputEditText5, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, Spinner spinner, CustomTextView customTextView, CustomTextView customTextView2) {
        super(obj, view, i2);
        this.etAddress1 = customTextInputEditText;
        this.etAddress2 = customTextInputEditText2;
        this.etAddress3 = customTextInputEditText3;
        this.etCity = customTextInputEditText4;
        this.etPincode = customTextInputEditText5;
        this.ivCross = imageView;
        this.parentContainer = linearLayout;
        this.rlCross = relativeLayout;
        this.stateSpinner = spinner;
        this.tvContinue = customTextView;
        this.tvState = customTextView2;
    }

    public EditAddressViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrFragmentEditAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentEditAddressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentEditAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_address, viewGroup, z, obj);
    }

    public static PrFragmentEditAddressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentEditAddressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentEditAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_address, (ViewGroup) null, false, obj);
    }

    public static PrFragmentEditAddressBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentEditAddressBinding bind(View view, Object obj) {
        return (PrFragmentEditAddressBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_edit_address);
    }
}
