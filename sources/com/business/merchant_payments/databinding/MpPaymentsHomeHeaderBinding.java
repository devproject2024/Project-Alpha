package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsHeaderModel;

public abstract class MpPaymentsHomeHeaderBinding extends ViewDataBinding {
    public final TextView date;
    public PaymentsHeaderModel mModel;

    public abstract void setModel(PaymentsHeaderModel paymentsHeaderModel);

    public MpPaymentsHomeHeaderBinding(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.date = textView;
    }

    public PaymentsHeaderModel getModel() {
        return this.mModel;
    }

    public static MpPaymentsHomeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsHomeHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsHomeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_home_header, viewGroup, z, obj);
    }

    public static MpPaymentsHomeHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsHomeHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsHomeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_home_header, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsHomeHeaderBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsHomeHeaderBinding bind(View view, Object obj) {
        return (MpPaymentsHomeHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_home_header);
    }
}
