package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;

public abstract class PrFragmentRequestConfirmationBinding extends ViewDataBinding {
    public final ImageView image;
    public final CustomTextView tvDesc;
    public final CustomTextView tvDone;
    public final CustomTextView tvSubTitle;
    public final CustomTextView tvTitle;

    public PrFragmentRequestConfirmationBinding(Object obj, View view, int i2, ImageView imageView, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4) {
        super(obj, view, i2);
        this.image = imageView;
        this.tvDesc = customTextView;
        this.tvDone = customTextView2;
        this.tvSubTitle = customTextView3;
        this.tvTitle = customTextView4;
    }

    public static PrFragmentRequestConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentRequestConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentRequestConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_request_confirmation, viewGroup, z, obj);
    }

    public static PrFragmentRequestConfirmationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentRequestConfirmationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentRequestConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_request_confirmation, (ViewGroup) null, false, obj);
    }

    public static PrFragmentRequestConfirmationBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentRequestConfirmationBinding bind(View view, Object obj) {
        return (PrFragmentRequestConfirmationBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_request_confirmation);
    }
}
