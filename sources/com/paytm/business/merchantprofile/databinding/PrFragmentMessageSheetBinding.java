package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;

public abstract class PrFragmentMessageSheetBinding extends ViewDataBinding {
    public final ImageView image;
    public final CustomTextView tvDone;
    public final CustomTextView tvSubTitle;
    public final CustomTextView tvTitle;

    public PrFragmentMessageSheetBinding(Object obj, View view, int i2, ImageView imageView, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3) {
        super(obj, view, i2);
        this.image = imageView;
        this.tvDone = customTextView;
        this.tvSubTitle = customTextView2;
        this.tvTitle = customTextView3;
    }

    public static PrFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrFragmentMessageSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_message_sheet, viewGroup, z, obj);
    }

    public static PrFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrFragmentMessageSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_fragment_message_sheet, (ViewGroup) null, false, obj);
    }

    public static PrFragmentMessageSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrFragmentMessageSheetBinding bind(View view, Object obj) {
        return (PrFragmentMessageSheetBinding) ViewDataBinding.bind(obj, view, R.layout.pr_fragment_message_sheet);
    }
}
