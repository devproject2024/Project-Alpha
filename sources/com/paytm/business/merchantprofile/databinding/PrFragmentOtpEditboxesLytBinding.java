package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;

public abstract class PrFragmentOtpEditboxesLytBinding extends ViewDataBinding {
    public final CustomTextInputEditText editOtpChar1;
    public final CustomTextInputEditText editOtpChar2;
    public final CustomTextInputEditText editOtpChar3;
    public final CustomTextInputEditText editOtpChar4;
    public final CustomTextInputEditText editOtpChar5;
    public final CustomTextInputEditText editOtpChar6;
    public final CustomTextView errorOtpTv;

    public PrFragmentOtpEditboxesLytBinding(Object obj, View view, int i2, CustomTextInputEditText customTextInputEditText, CustomTextInputEditText customTextInputEditText2, CustomTextInputEditText customTextInputEditText3, CustomTextInputEditText customTextInputEditText4, CustomTextInputEditText customTextInputEditText5, CustomTextInputEditText customTextInputEditText6, CustomTextView customTextView) {
        super(obj, view, i2);
        this.editOtpChar1 = customTextInputEditText;
        this.editOtpChar2 = customTextInputEditText2;
        this.editOtpChar3 = customTextInputEditText3;
        this.editOtpChar4 = customTextInputEditText4;
        this.editOtpChar5 = customTextInputEditText5;
        this.editOtpChar6 = customTextInputEditText6;
        this.errorOtpTv = customTextView;
    }

    public static PrFragmentOtpEditboxesLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentOtpEditboxesLytBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentOtpEditboxesLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_otp_editboxes_lyt, viewGroup, z, obj);
    }

    public static PrFragmentOtpEditboxesLytBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentOtpEditboxesLytBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentOtpEditboxesLytBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_otp_editboxes_lyt, (ViewGroup) null, false, obj);
    }

    public static PrFragmentOtpEditboxesLytBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentOtpEditboxesLytBinding bind(View view, Object obj) {
        return (PrFragmentOtpEditboxesLytBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_otp_editboxes_lyt);
    }
}
