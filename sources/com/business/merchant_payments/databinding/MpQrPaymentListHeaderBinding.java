package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpQrPaymentListHeaderBinding extends ViewDataBinding {
    public final TextView multipleqrHeader;
    public final TextView title;

    public MpQrPaymentListHeaderBinding(Object obj, View view, int i2, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.multipleqrHeader = textView;
        this.title = textView2;
    }

    public static MpQrPaymentListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpQrPaymentListHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpQrPaymentListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_payment_list_header, viewGroup, z, obj);
    }

    public static MpQrPaymentListHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpQrPaymentListHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpQrPaymentListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_payment_list_header, (ViewGroup) null, false, obj);
    }

    public static MpQrPaymentListHeaderBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpQrPaymentListHeaderBinding bind(View view, Object obj) {
        return (MpQrPaymentListHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mp_qr_payment_list_header);
    }
}
