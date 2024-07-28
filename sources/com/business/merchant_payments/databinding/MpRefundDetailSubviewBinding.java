package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;

public abstract class MpRefundDetailSubviewBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final TextView dataProfileBankName;
    public final ImageView ivPaymode;
    public RefundDetailsViewModel mViewModel;
    public final TextView profileLabelBankName;
    public final TextView textView10;
    public final TextView textView11;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView14;
    public final TextView textView15;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView25;
    public final TextView textView27;
    public final TextView textView28;
    public final TextView textView31;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textView9;
    public final TextView tvBank;
    public final TextView tvDirectSettleVia;
    public final TextView tvOrderId;
    public final TextView tvOrderIdText;
    public final TextView tvPaymentDescriptionText;

    public abstract void setViewModel(RefundDetailsViewModel refundDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpRefundDetailSubviewBinding(Object obj, View view, int i2, Barrier barrier2, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView16, TextView textView22, TextView textView23, TextView textView24, TextView textView26, TextView textView29, TextView textView30, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView40, TextView textView41, TextView textView42, TextView textView43) {
        super(obj, view, i2);
        this.barrier = barrier2;
        this.dataProfileBankName = textView;
        this.ivPaymode = imageView;
        this.profileLabelBankName = textView2;
        this.textView10 = textView3;
        this.textView11 = textView4;
        this.textView12 = textView5;
        this.textView13 = textView6;
        this.textView14 = textView16;
        this.textView15 = textView22;
        this.textView17 = textView23;
        this.textView18 = textView24;
        this.textView19 = textView26;
        this.textView20 = textView29;
        this.textView21 = textView30;
        this.textView25 = textView32;
        this.textView27 = textView33;
        this.textView28 = textView34;
        this.textView31 = textView35;
        this.textView7 = textView36;
        this.textView8 = textView37;
        this.textView9 = textView38;
        this.tvBank = textView39;
        this.tvDirectSettleVia = textView40;
        this.tvOrderId = textView41;
        this.tvOrderIdText = textView42;
        this.tvPaymentDescriptionText = textView43;
    }

    public RefundDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpRefundDetailSubviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpRefundDetailSubviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpRefundDetailSubviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_detail_subview, viewGroup, z, obj);
    }

    public static MpRefundDetailSubviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpRefundDetailSubviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpRefundDetailSubviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_detail_subview, (ViewGroup) null, false, obj);
    }

    public static MpRefundDetailSubviewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpRefundDetailSubviewBinding bind(View view, Object obj) {
        return (MpRefundDetailSubviewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_refund_detail_subview);
    }
}
