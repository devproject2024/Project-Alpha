package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpPaymentssSummeryItemBinding extends ViewDataBinding {
    public final TextView paymentSummeryHeader;
    public final TextView paymentsAmount;
    public final TextView paymentsCount;
    public final ConstraintLayout paymentsNumberContainer;

    public MpPaymentssSummeryItemBinding(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout) {
        super(obj, view, i2);
        this.paymentSummeryHeader = textView;
        this.paymentsAmount = textView2;
        this.paymentsCount = textView3;
        this.paymentsNumberContainer = constraintLayout;
    }

    public static MpPaymentssSummeryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentssSummeryItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentssSummeryItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_paymentss_summery_item, viewGroup, z, obj);
    }

    public static MpPaymentssSummeryItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentssSummeryItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentssSummeryItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_paymentss_summery_item, (ViewGroup) null, false, obj);
    }

    public static MpPaymentssSummeryItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentssSummeryItemBinding bind(View view, Object obj) {
        return (MpPaymentssSummeryItemBinding) ViewDataBinding.bind(obj, view, R.layout.mp_paymentss_summery_item);
    }
}
