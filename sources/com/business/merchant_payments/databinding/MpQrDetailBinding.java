package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;

public abstract class MpQrDetailBinding extends ViewDataBinding {
    public final ConstraintLayout clAllInOneQr;
    public final ConstraintLayout clQuickSettlement;
    public final ConstraintLayout clUnlimitedPayments;
    public final ConstraintLayout clZeroCost;
    public final ImageView imageView2;
    public final ImageView ivAllInOne;
    public final ImageView ivCloseIcon;
    public final ImageView ivQuickSettlement;
    public final ImageView ivUnlimitedPayments;
    public final ImageView ivZeroCost;
    public final CustomTextView tvAllInOneHeading;
    public final CustomTextView tvAllInOneSubheading;
    public final CustomTextView tvDownloadPrintQr;
    public final CustomTextView tvGetAllQrText;
    public final CustomTextView tvInstantSettlement;
    public final CustomTextView tvOrderAllInOneQr;
    public final CustomTextView tvQuickSettlementHeading;
    public final CustomTextView tvQuickSettlementSubheading;
    public final CustomTextView tvUnlimitedPaymentsHeading;
    public final CustomTextView tvUnlimitedPaymentsSubheading;
    public final CustomTextView tvZeroCostHeading;
    public final CustomTextView tvZeroCostSubheading;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpQrDetailBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5, CustomTextView customTextView6, CustomTextView customTextView7, CustomTextView customTextView8, CustomTextView customTextView9, CustomTextView customTextView10, CustomTextView customTextView11, CustomTextView customTextView12) {
        super(obj, view, i2);
        this.clAllInOneQr = constraintLayout;
        this.clQuickSettlement = constraintLayout2;
        this.clUnlimitedPayments = constraintLayout3;
        this.clZeroCost = constraintLayout4;
        this.imageView2 = imageView;
        this.ivAllInOne = imageView3;
        this.ivCloseIcon = imageView4;
        this.ivQuickSettlement = imageView5;
        this.ivUnlimitedPayments = imageView6;
        this.ivZeroCost = imageView7;
        this.tvAllInOneHeading = customTextView;
        this.tvAllInOneSubheading = customTextView2;
        this.tvDownloadPrintQr = customTextView3;
        this.tvGetAllQrText = customTextView4;
        this.tvInstantSettlement = customTextView5;
        this.tvOrderAllInOneQr = customTextView6;
        this.tvQuickSettlementHeading = customTextView7;
        this.tvQuickSettlementSubheading = customTextView8;
        this.tvUnlimitedPaymentsHeading = customTextView9;
        this.tvUnlimitedPaymentsSubheading = customTextView10;
        this.tvZeroCostHeading = customTextView11;
        this.tvZeroCostSubheading = customTextView12;
    }

    public static MpQrDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpQrDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpQrDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_detail, viewGroup, z, obj);
    }

    public static MpQrDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpQrDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpQrDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_detail, (ViewGroup) null, false, obj);
    }

    public static MpQrDetailBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpQrDetailBinding bind(View view, Object obj) {
        return (MpQrDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mp_qr_detail);
    }
}
