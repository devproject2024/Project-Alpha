package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomCheckBox;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.InitiateRefundViewModel;

public abstract class MpInitiateRefundNewBinding extends ViewDataBinding {
    public final LinearLayout amountLyt;
    public final CustomTextView btnRefund;
    public final CoordinatorLayout coordinatorLayout;
    public final CustomTextView errorText;
    public final CustomTextInputEditText etRefundAmount;
    public final ImageView ivClose;
    public InitiateRefundViewModel mInitiateRefundViewModel;
    public final CustomTextView maxRefundableSummary;
    public final CustomTextView pleaseNote;
    public final CustomCheckBox refundTvCommissionCheckbox;
    public final CustomTextView tvAmount;
    public final CustomTextView tvInitiateRefundTitle;
    public final CustomTextView tvRefundMsg;
    public final CustomTextView tvTransactionAmount;

    public abstract void setInitiateRefundViewModel(InitiateRefundViewModel initiateRefundViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpInitiateRefundNewBinding(Object obj, View view, int i2, LinearLayout linearLayout, CustomTextView customTextView, CoordinatorLayout coordinatorLayout2, CustomTextView customTextView2, CustomTextInputEditText customTextInputEditText, ImageView imageView, CustomTextView customTextView3, CustomTextView customTextView4, CustomCheckBox customCheckBox, CustomTextView customTextView5, CustomTextView customTextView6, CustomTextView customTextView7, CustomTextView customTextView8) {
        super(obj, view, i2);
        this.amountLyt = linearLayout;
        this.btnRefund = customTextView;
        this.coordinatorLayout = coordinatorLayout2;
        this.errorText = customTextView2;
        this.etRefundAmount = customTextInputEditText;
        this.ivClose = imageView;
        this.maxRefundableSummary = customTextView3;
        this.pleaseNote = customTextView4;
        this.refundTvCommissionCheckbox = customCheckBox;
        this.tvAmount = customTextView5;
        this.tvInitiateRefundTitle = customTextView6;
        this.tvRefundMsg = customTextView7;
        this.tvTransactionAmount = customTextView8;
    }

    public InitiateRefundViewModel getInitiateRefundViewModel() {
        return this.mInitiateRefundViewModel;
    }

    public static MpInitiateRefundNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpInitiateRefundNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpInitiateRefundNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_initiate_refund_new, viewGroup, z, obj);
    }

    public static MpInitiateRefundNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpInitiateRefundNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpInitiateRefundNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_initiate_refund_new, (ViewGroup) null, false, obj);
    }

    public static MpInitiateRefundNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpInitiateRefundNewBinding bind(View view, Object obj) {
        return (MpInitiateRefundNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_initiate_refund_new);
    }
}
