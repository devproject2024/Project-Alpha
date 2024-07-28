package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpActivityPaymentLinkBinding extends ViewDataBinding {
    public final ImageView back;
    public final CoordinatorLayout coordinatorLayout;
    public final FrameLayout fragmentContainer;
    public final CustomTextView title;
    public final ConstraintLayout toolbar;

    public MpActivityPaymentLinkBinding(Object obj, View view, int i2, ImageView imageView, CoordinatorLayout coordinatorLayout2, FrameLayout frameLayout, CustomTextView customTextView, ConstraintLayout constraintLayout) {
        super(obj, view, i2);
        this.back = imageView;
        this.coordinatorLayout = coordinatorLayout2;
        this.fragmentContainer = frameLayout;
        this.title = customTextView;
        this.toolbar = constraintLayout;
    }

    public static MpActivityPaymentLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityPaymentLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityPaymentLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_payment_link, viewGroup, z, obj);
    }

    public static MpActivityPaymentLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityPaymentLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityPaymentLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_payment_link, (ViewGroup) null, false, obj);
    }

    public static MpActivityPaymentLinkBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityPaymentLinkBinding bind(View view, Object obj) {
        return (MpActivityPaymentLinkBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_payment_link);
    }
}
