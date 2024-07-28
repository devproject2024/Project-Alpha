package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpBwSettlementAmountToHoldDialogBinding extends ViewDataBinding {
    public final LinearLayout container;
    public final ImageView crossBtn;

    public MpBwSettlementAmountToHoldDialogBinding(Object obj, View view, int i2, LinearLayout linearLayout, ImageView imageView) {
        super(obj, view, i2);
        this.container = linearLayout;
        this.crossBtn = imageView;
    }

    public static MpBwSettlementAmountToHoldDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwSettlementAmountToHoldDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwSettlementAmountToHoldDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_amount_to_hold_dialog, viewGroup, z, obj);
    }

    public static MpBwSettlementAmountToHoldDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwSettlementAmountToHoldDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwSettlementAmountToHoldDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_amount_to_hold_dialog, (ViewGroup) null, false, obj);
    }

    public static MpBwSettlementAmountToHoldDialogBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwSettlementAmountToHoldDialogBinding bind(View view, Object obj) {
        return (MpBwSettlementAmountToHoldDialogBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_settlement_amount_to_hold_dialog);
    }
}
