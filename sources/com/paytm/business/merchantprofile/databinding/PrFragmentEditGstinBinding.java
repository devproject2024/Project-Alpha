package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextInputLayout;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.EditGstinViewModel;

public abstract class PrFragmentEditGstinBinding extends ViewDataBinding {
    public final CustomTextView addEditGstinSave;
    public final CustomTextInputEditText etGstin;
    public final ImageView ivCross;
    public EditGstinViewModel mViewModel;
    public final RelativeLayout rlCross;
    public final CustomTextInputLayout textInputAccountNumber;

    public abstract void setViewModel(EditGstinViewModel editGstinViewModel);

    public PrFragmentEditGstinBinding(Object obj, View view, int i2, CustomTextView customTextView, CustomTextInputEditText customTextInputEditText, ImageView imageView, RelativeLayout relativeLayout, CustomTextInputLayout customTextInputLayout) {
        super(obj, view, i2);
        this.addEditGstinSave = customTextView;
        this.etGstin = customTextInputEditText;
        this.ivCross = imageView;
        this.rlCross = relativeLayout;
        this.textInputAccountNumber = customTextInputLayout;
    }

    public EditGstinViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrFragmentEditGstinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentEditGstinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentEditGstinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_gstin, viewGroup, z, obj);
    }

    public static PrFragmentEditGstinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentEditGstinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentEditGstinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_gstin, (ViewGroup) null, false, obj);
    }

    public static PrFragmentEditGstinBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentEditGstinBinding bind(View view, Object obj) {
        return (PrFragmentEditGstinBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_edit_gstin);
    }
}
