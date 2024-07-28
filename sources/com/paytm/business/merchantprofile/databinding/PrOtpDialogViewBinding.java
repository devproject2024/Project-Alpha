package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.viewmodel.OtpDialogViewModel;

public abstract class PrOtpDialogViewBinding extends ViewDataBinding {
    public final ImageView backIV;
    public final CustomTextView btnResendOtp;
    public final FrameLayout containerId;
    public final ImageView crossIv;
    public final View fillerView;
    public OtpDialogViewModel mViewModel;
    public final View marginView;
    public final CustomTextView proceedBtn;
    public final ProgressBar progress;
    public final CustomTextView tvEnterOtp;
    public final CustomTextView tvSentToText;

    public abstract void setViewModel(OtpDialogViewModel otpDialogViewModel);

    public PrOtpDialogViewBinding(Object obj, View view, int i2, ImageView imageView, CustomTextView customTextView, FrameLayout frameLayout, ImageView imageView2, View view2, View view3, CustomTextView customTextView2, ProgressBar progressBar, CustomTextView customTextView3, CustomTextView customTextView4) {
        super(obj, view, i2);
        this.backIV = imageView;
        this.btnResendOtp = customTextView;
        this.containerId = frameLayout;
        this.crossIv = imageView2;
        this.fillerView = view2;
        this.marginView = view3;
        this.proceedBtn = customTextView2;
        this.progress = progressBar;
        this.tvEnterOtp = customTextView3;
        this.tvSentToText = customTextView4;
    }

    public OtpDialogViewModel getViewModel() {
        return this.mViewModel;
    }

    public static PrOtpDialogViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrOtpDialogViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrOtpDialogViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_otp_dialog_view, viewGroup, z, obj);
    }

    public static PrOtpDialogViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrOtpDialogViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrOtpDialogViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_otp_dialog_view, (ViewGroup) null, false, obj);
    }

    public static PrOtpDialogViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrOtpDialogViewBinding bind(View view, Object obj) {
        return (PrOtpDialogViewBinding) ViewDataBinding.bind(obj, view, R.layout.pr_otp_dialog_view);
    }
}
