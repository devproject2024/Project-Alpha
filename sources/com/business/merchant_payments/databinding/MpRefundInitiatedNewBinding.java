package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.RefundInitiatedViewModel;

public abstract class MpRefundInitiatedNewBinding extends ViewDataBinding {
    public final CustomTextView amount;
    public final RelativeLayout containerCc;
    public final ImageView ivClose;
    public final LinearLayout lytRefundAmount;
    public RefundInitiatedViewModel mRefundInitiatedViewModel;
    public final LinearLayout refundDateLyt;
    public final ImageView statusImage;
    public final CustomTextView tvCustomerDetailsHeader;
    public final CustomTextView tvCustomerIdText;
    public final CustomTextView tvCustomerIdTitle;
    public final CustomTextView tvEmailIdText;
    public final CustomTextView tvEmailIdTitle;
    public final CustomTextView tvMobileNoText;
    public final CustomTextView tvMobileNoTitle;
    public final CustomTextView tvOrderIdText;
    public final CustomTextView tvOrderIdTitle;
    public final CustomTextView tvPaymentAmountText;
    public final CustomTextView tvPaymentAmountTitle;
    public final CustomTextView tvPaymentDateText;
    public final CustomTextView tvPaymentDateTitle;
    public final CustomTextView tvPaymentDetailHeader;
    public final CustomTextView tvRefundDate;
    public final CustomTextView tvRefundId;
    public final CustomTextView tvRefundStatus;

    public abstract void setRefundInitiatedViewModel(RefundInitiatedViewModel refundInitiatedViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpRefundInitiatedNewBinding(Object obj, View view, int i2, CustomTextView customTextView, RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView2, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, CustomTextView customTextView5, CustomTextView customTextView6, CustomTextView customTextView7, CustomTextView customTextView8, CustomTextView customTextView9, CustomTextView customTextView10, CustomTextView customTextView11, CustomTextView customTextView12, CustomTextView customTextView13, CustomTextView customTextView14, CustomTextView customTextView15, CustomTextView customTextView16, CustomTextView customTextView17, CustomTextView customTextView18) {
        super(obj, view, i2);
        this.amount = customTextView;
        this.containerCc = relativeLayout;
        this.ivClose = imageView;
        this.lytRefundAmount = linearLayout;
        this.refundDateLyt = linearLayout2;
        this.statusImage = imageView2;
        this.tvCustomerDetailsHeader = customTextView2;
        this.tvCustomerIdText = customTextView3;
        this.tvCustomerIdTitle = customTextView4;
        this.tvEmailIdText = customTextView5;
        this.tvEmailIdTitle = customTextView6;
        this.tvMobileNoText = customTextView7;
        this.tvMobileNoTitle = customTextView8;
        this.tvOrderIdText = customTextView9;
        this.tvOrderIdTitle = customTextView10;
        this.tvPaymentAmountText = customTextView11;
        this.tvPaymentAmountTitle = customTextView12;
        this.tvPaymentDateText = customTextView13;
        this.tvPaymentDateTitle = customTextView14;
        this.tvPaymentDetailHeader = customTextView15;
        this.tvRefundDate = customTextView16;
        this.tvRefundId = customTextView17;
        this.tvRefundStatus = customTextView18;
    }

    public RefundInitiatedViewModel getRefundInitiatedViewModel() {
        return this.mRefundInitiatedViewModel;
    }

    public static MpRefundInitiatedNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpRefundInitiatedNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpRefundInitiatedNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_initiated_new, viewGroup, z, obj);
    }

    public static MpRefundInitiatedNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpRefundInitiatedNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpRefundInitiatedNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_initiated_new, (ViewGroup) null, false, obj);
    }

    public static MpRefundInitiatedNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpRefundInitiatedNewBinding bind(View view, Object obj) {
        return (MpRefundInitiatedNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_refund_initiated_new);
    }
}
