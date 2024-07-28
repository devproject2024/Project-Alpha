package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsSummaryModel;

public abstract class MpPaymentsSummaryLayoutBinding extends ViewDataBinding {
    public final View divider;
    public PaymentsSummaryModel mModel;
    public final TextView rewardsPoints;
    public final TextView rpHeader;
    public final AppCompatImageView rpIcon;
    public final TextView taHeader;
    public final TextView totalAmount;
    public final TextView totalPayments;
    public final TextView tpHeader;

    public abstract void setModel(PaymentsSummaryModel paymentsSummaryModel);

    public MpPaymentsSummaryLayoutBinding(Object obj, View view, int i2, View view2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.divider = view2;
        this.rewardsPoints = textView;
        this.rpHeader = textView2;
        this.rpIcon = appCompatImageView;
        this.taHeader = textView3;
        this.totalAmount = textView4;
        this.totalPayments = textView5;
        this.tpHeader = textView6;
    }

    public PaymentsSummaryModel getModel() {
        return this.mModel;
    }

    public static MpPaymentsSummaryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsSummaryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsSummaryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_summary_layout, viewGroup, z, obj);
    }

    public static MpPaymentsSummaryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsSummaryLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsSummaryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_summary_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsSummaryLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsSummaryLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsSummaryLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_summary_layout);
    }
}
