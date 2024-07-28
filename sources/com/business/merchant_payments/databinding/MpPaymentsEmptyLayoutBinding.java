package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpPaymentsEmptyLayoutBinding extends ViewDataBinding {
    public final ConstraintLayout emptyParent;
    public final AppCompatImageView icon;
    public final TextView summary;
    public final TextView viewPastPayments;

    public MpPaymentsEmptyLayoutBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.emptyParent = constraintLayout;
        this.icon = appCompatImageView;
        this.summary = textView;
        this.viewPastPayments = textView2;
    }

    public static MpPaymentsEmptyLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsEmptyLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsEmptyLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_empty_layout, viewGroup, z, obj);
    }

    public static MpPaymentsEmptyLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsEmptyLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsEmptyLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_empty_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsEmptyLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsEmptyLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsEmptyLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_empty_layout);
    }
}
