package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpCustomSnackbarViewBinding extends ViewDataBinding {
    public final CustomTextView descriptionSbTv;
    public final LinearLayoutCompat sbViewLl;
    public final CustomTextView titleSbTv;

    public MpCustomSnackbarViewBinding(Object obj, View view, int i2, CustomTextView customTextView, LinearLayoutCompat linearLayoutCompat, CustomTextView customTextView2) {
        super(obj, view, i2);
        this.descriptionSbTv = customTextView;
        this.sbViewLl = linearLayoutCompat;
        this.titleSbTv = customTextView2;
    }

    public static MpCustomSnackbarViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpCustomSnackbarViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpCustomSnackbarViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_custom_snackbar_view, viewGroup, z, obj);
    }

    public static MpCustomSnackbarViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpCustomSnackbarViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpCustomSnackbarViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_custom_snackbar_view, (ViewGroup) null, false, obj);
    }

    public static MpCustomSnackbarViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpCustomSnackbarViewBinding bind(View view, Object obj) {
        return (MpCustomSnackbarViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_custom_snackbar_view);
    }
}
