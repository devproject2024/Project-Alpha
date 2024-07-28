package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.paytm.business.merchantprofile.R;
import com.paytm.business.merchantprofile.widget.CustomRadioGroup;

public abstract class PrMerchantSwitchBottomSheetBinding extends ViewDataBinding {
    public final TextView header;
    public final CustomRadioGroup options;
    public final TextView subHeader;

    public PrMerchantSwitchBottomSheetBinding(Object obj, View view, int i2, TextView textView, CustomRadioGroup customRadioGroup, TextView textView2) {
        super(obj, view, i2);
        this.header = textView;
        this.options = customRadioGroup;
        this.subHeader = textView2;
    }

    public static PrMerchantSwitchBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrMerchantSwitchBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrMerchantSwitchBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_merchant_switch_bottom_sheet, viewGroup, z, obj);
    }

    public static PrMerchantSwitchBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrMerchantSwitchBottomSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrMerchantSwitchBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_merchant_switch_bottom_sheet, (ViewGroup) null, false, obj);
    }

    public static PrMerchantSwitchBottomSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrMerchantSwitchBottomSheetBinding bind(View view, Object obj) {
        return (PrMerchantSwitchBottomSheetBinding) ViewDataBinding.bind(obj, view, R.layout.pr_merchant_switch_bottom_sheet);
    }
}
