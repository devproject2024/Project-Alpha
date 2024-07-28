package com.paytm.business.merchantprofile.databinding;

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
import com.paytm.business.merchantprofile.R;

public abstract class PrActivityAddMobileOtpBinding extends ViewDataBinding {
    public final FrameLayout containerId;
    public final CoordinatorLayout coordinatorLayout;
    public final RelativeLayout headerOuterMostContainer;
    public final ImageView ivClose;
    public final LinearLayout llLoginPageOuterContainer;
    public final CustomTextView tvConfirm;
    public final CustomTextView tvOtpNum;
    public final CustomTextView tvResendOtp;

    public PrActivityAddMobileOtpBinding(Object obj, View view, int i2, FrameLayout frameLayout, CoordinatorLayout coordinatorLayout2, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3) {
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

    public static PrActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrActivityAddMobileOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_add_mobile_otp, viewGroup, z, obj);
    }

    public static PrActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrActivityAddMobileOtpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrActivityAddMobileOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_activity_add_mobile_otp, (ViewGroup) null, false, obj);
    }

    public static PrActivityAddMobileOtpBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrActivityAddMobileOtpBinding bind(View view, Object obj) {
        return (PrActivityAddMobileOtpBinding) ViewDataBinding.bind(obj, view, R.layout.pr_activity_add_mobile_otp);
    }
}
