package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpActivityQrNotPrintedBinding extends ViewDataBinding {
    public final FrameLayout fragmentContainer;

    public MpActivityQrNotPrintedBinding(Object obj, View view, int i2, FrameLayout frameLayout) {
        super(obj, view, i2);
        this.fragmentContainer = frameLayout;
    }

    public static MpActivityQrNotPrintedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityQrNotPrintedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityQrNotPrintedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_qr_not_printed, viewGroup, z, obj);
    }

    public static MpActivityQrNotPrintedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityQrNotPrintedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityQrNotPrintedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_qr_not_printed, (ViewGroup) null, false, obj);
    }

    public static MpActivityQrNotPrintedBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityQrNotPrintedBinding bind(View view, Object obj) {
        return (MpActivityQrNotPrintedBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_qr_not_printed);
    }
}
