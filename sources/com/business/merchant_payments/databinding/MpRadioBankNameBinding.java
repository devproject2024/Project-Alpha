package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpRadioBankNameBinding extends ViewDataBinding {
    public final View divier;
    public final RadioButton radio;
    public final TextView topText;

    public MpRadioBankNameBinding(Object obj, View view, int i2, View view2, RadioButton radioButton, TextView textView) {
        super(obj, view, i2);
        this.divier = view2;
        this.radio = radioButton;
        this.topText = textView;
    }

    public static MpRadioBankNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpRadioBankNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpRadioBankNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_radio_bank_name, viewGroup, z, obj);
    }

    public static MpRadioBankNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpRadioBankNameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpRadioBankNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_radio_bank_name, (ViewGroup) null, false, obj);
    }

    public static MpRadioBankNameBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpRadioBankNameBinding bind(View view, Object obj) {
        return (MpRadioBankNameBinding) ViewDataBinding.bind(obj, view, R.layout.mp_radio_bank_name);
    }
}
