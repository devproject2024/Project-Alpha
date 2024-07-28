package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpActivityPostQrScanBinding extends ViewDataBinding {
    public final ConstraintLayout clEarnCashback;
    public final ConstraintLayout clOrderQrAccessories;
    public final ConstraintLayout clPrintQr;
    public final ConstraintLayout clWatchAd;
    public final Guideline guideline;
    public final ImageView ivClose;
    public final CustomTextView tvBtnScanAgain;
    public final CustomTextView tvEarnCashback;
    public final CustomTextView tvOrderQrAccessories;
    public final CustomTextView tvPrintQr;
    public final CustomTextView tvScanStatusText;
    public final CustomTextView tvSubTitle;
    public final CustomTextView tvWatchAd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpActivityPostQrScanBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, Guideline guideline2, ImageView imageView, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5, CustomTextView customTextView6, CustomTextView customTextView7) {
        super(obj, view, i2);
        this.clEarnCashback = constraintLayout;
        this.clOrderQrAccessories = constraintLayout2;
        this.clPrintQr = constraintLayout3;
        this.clWatchAd = constraintLayout4;
        this.guideline = guideline2;
        this.ivClose = imageView;
        this.tvBtnScanAgain = customTextView;
        this.tvEarnCashback = customTextView2;
        this.tvOrderQrAccessories = customTextView3;
        this.tvPrintQr = customTextView4;
        this.tvScanStatusText = customTextView5;
        this.tvSubTitle = customTextView6;
        this.tvWatchAd = customTextView7;
    }

    public static MpActivityPostQrScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityPostQrScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityPostQrScanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_post_qr_scan, viewGroup, z, obj);
    }

    public static MpActivityPostQrScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityPostQrScanBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityPostQrScanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_post_qr_scan, (ViewGroup) null, false, obj);
    }

    public static MpActivityPostQrScanBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityPostQrScanBinding bind(View view, Object obj) {
        return (MpActivityPostQrScanBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_post_qr_scan);
    }
}
