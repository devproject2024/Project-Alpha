package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpActivityAddMobileOtpBinding extends ViewDataBinding {
    public final FrameLayout containerId;
    public final CoordinatorLayout coordinatorLayout;
    public final RelativeLayout headerOuterMostContainer;
    public final ImageView ivClose;
    public final LinearLayout llLoginPageOuterContainer;
    public final CustomTextView tvConfirm;
    public final CustomTextView tvOtpNum;
    public final CustomTextView tvResendOtp;

    public MpActivityAddMobileOtpBinding(Object obj, View view, int i2, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout2, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3) {
        super(obj, view, i2);
        this.containerId = frameLayout;
        this.coordinatorLayout = coordinatorLayout2;
        this.headerOuterMostContainer = relativeLayout;
        this.ivClose = imageView;
        this.llLoginPageOuterContainer = linearLayout;
        this.tvConfirm = customTextView;
        this.tvOtpNum = customTextView2;
        this.tvResendOtp = customTextView3;
    }

    public static MpActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityAddMobileOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_add_mobile_otp, viewGroup, z, obj);
    }

    public static MpActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityAddMobileOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_add_mobile_otp, (ViewGroup) null, false, obj);
    }

    public static MpActivityAddMobileOtpBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityAddMobileOtpBinding bind(View view, Object obj) {
        return (MpActivityAddMobileOtpBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_add_mobile_otp);
    }
}
