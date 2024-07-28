package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpPaymentsPermissionDeniedLayoutBinding extends ViewDataBinding {
    public final ConstraintLayout emptyParent;
    public final AppCompatImageView icon;

    public MpPaymentsPermissionDeniedLayoutBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView) {
        super(obj, view, i2);
        this.emptyParent = constraintLayout;
        this.icon = appCompatImageView;
    }

    public static MpPaymentsPermissionDeniedLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsPermissionDeniedLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsPermissionDeniedLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_permission_denied_layout, viewGroup, z, obj);
    }

    public static MpPaymentsPermissionDeniedLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsPermissionDeniedLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsPermissionDeniedLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_permission_denied_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsPermissionDeniedLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsPermissionDeniedLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsPermissionDeniedLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_permission_denied_layout);
    }
}
