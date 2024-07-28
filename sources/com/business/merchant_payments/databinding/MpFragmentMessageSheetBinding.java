package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpFragmentMessageSheetBinding extends ViewDataBinding {
    public final ImageView image;
    public final CustomTextView tvDone;
    public final CustomTextView tvSubTitle;
    public final CustomTextView tvTitle;

    public MpFragmentMessageSheetBinding(Object obj, View view, int i2, ImageView imageView, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3) {
        super(obj, view, i2);
        this.image = imageView;
        this.tvDone = customTextView;
        this.tvSubTitle = customTextView2;
        this.tvTitle = customTextView3;
    }

    public static MpFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpFragmentMessageSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_message_sheet, viewGroup, z, obj);
    }

    public static MpFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpFragmentMessageSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpFragmentMessageSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_fragment_message_sheet, (ViewGroup) null, false, obj);
    }

    public static MpFragmentMessageSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpFragmentMessageSheetBinding bind(View view, Object obj) {
        return (MpFragmentMessageSheetBinding) ViewDataBinding.bind(obj, view, R.layout.mp_fragment_message_sheet);
    }
}
