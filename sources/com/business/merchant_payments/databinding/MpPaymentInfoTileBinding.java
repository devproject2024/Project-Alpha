package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpPaymentInfoTileBinding extends ViewDataBinding {
    public final MpRoboTextView paymentInfoSubtextLbl;
    public final MpRoboTextView paymentInfoTileLbl;
    public final MpRoboTextView paymentInfoTileVal;

    public MpPaymentInfoTileBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3) {
        super(obj, view, i2);
        this.paymentInfoSubtextLbl = mpRoboTextView;
        this.paymentInfoTileLbl = mpRoboTextView2;
        this.paymentInfoTileVal = mpRoboTextView3;
    }

    public static MpPaymentInfoTileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentInfoTileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentInfoTileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_info_tile, viewGroup, z, obj);
    }

    public static MpPaymentInfoTileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentInfoTileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentInfoTileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_info_tile, (ViewGroup) null, false, obj);
    }

    public static MpPaymentInfoTileBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentInfoTileBinding bind(View view, Object obj) {
        return (MpPaymentInfoTileBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payment_info_tile);
    }
}
