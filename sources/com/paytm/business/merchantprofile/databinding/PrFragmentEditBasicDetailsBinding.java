package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.EditBasicDetailsViewModel;

public abstract class PrFragmentEditBasicDetailsBinding extends ViewDataBinding {
    public final RelativeLayout coordinatorLayout;
    public final CustomTextInputEditText etInput;
    public final ImageView ivCross;
    public EditBasicDetailsViewModel mViewModel;
    public final LinearLayout rlCross;
    public final LinearLayout rlMiddleContainer;

    public abstract void setViewModel(EditBasicDetailsViewModel editBasicDetailsViewModel);

    public PrFragmentEditBasicDetailsBinding(Object obj, View view, int i2, RelativeLayout relativeLayout, CustomTextInputEditText customTextInputEditText, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i2);
        this.coordinatorLayout = relativeLayout;
        this.etInput = customTextInputEditText;
        this.ivCross = imageView;
        this.rlCross = linearLayout;
        this.rlMiddleContainer = linearLayout2;
    }

    public EditBasicDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrFragmentEditBasicDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentEditBasicDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentEditBasicDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_basic_details, viewGroup, z, obj);
    }

    public static PrFragmentEditBasicDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentEditBasicDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentEditBasicDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_edit_basic_details, (ViewGroup) null, false, obj);
    }

    public static PrFragmentEditBasicDetailsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentEditBasicDetailsBinding bind(View view, Object obj) {
        return (PrFragmentEditBasicDetailsBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_edit_basic_details);
    }
}
