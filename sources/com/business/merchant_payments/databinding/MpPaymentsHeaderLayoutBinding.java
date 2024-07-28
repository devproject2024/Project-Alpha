package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;

public abstract class MpPaymentsHeaderLayoutBinding extends ViewDataBinding {
    public final TextView date;
    public PaymentsHeaderModel mModel;

    public abstract void setModel(PaymentsHeaderModel paymentsHeaderModel);

    public MpPaymentsHeaderLayoutBinding(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.date = textView;
    }

    public PaymentsHeaderModel getModel() {
        return this.mModel;
    }

    public static MpPaymentsHeaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsHeaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsHeaderLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_header_layout, viewGroup, z, obj);
    }

    public static MpPaymentsHeaderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsHeaderLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsHeaderLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_header_layout, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsHeaderLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsHeaderLayoutBinding bind(View view, Object obj) {
        return (MpPaymentsHeaderLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_header_layout);
    }
}
