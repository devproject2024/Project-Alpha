package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;

public abstract class PrRadioBankNameBinding extends ViewDataBinding {
    public final View divier;
    public final RadioButton radio;
    public final TextView topText;

    public PrRadioBankNameBinding(Object obj, View view, int i2, View view2, RadioButton radioButton, TextView textView) {
        super(obj, view, i2);
        this.divier = view2;
        this.radio = radioButton;
        this.topText = textView;
    }

    public static PrRadioBankNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrRadioBankNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrRadioBankNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_radio_bank_name, viewGroup, z, obj);
    }

    public static PrRadioBankNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrRadioBankNameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrRadioBankNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_radio_bank_name, (ViewGroup) null, false, obj);
    }

    public static PrRadioBankNameBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrRadioBankNameBinding bind(View view, Object obj) {
        return (PrRadioBankNameBinding) ViewDataBinding.bind(obj, view, R.layout.pr_radio_bank_name);
    }
}
