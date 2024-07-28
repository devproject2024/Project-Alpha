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
import com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel;

public abstract class MpReversalDetailSubViewBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final TextView dataProfileBankName;
    public final ImageView ivPaymode;
    public ReversalDetailsViewModel mViewModel;
    public final TextView profileLabelBankName;
    public final TextView textView14;
    public final TextView textView15;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView25;
    public final TextView textView27;
    public final TextView textView30;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView tvBank;
    public final TextView tvDirectSettleVia;
    public final TextView tvOrderId;
    public final TextView tvOrderIdText;
    public final TextView tvPaymentDescriptionText;
    public final TextView tvSettledAmnt;

    public abstract void setViewModel(ReversalDetailsViewModel reversalDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpReversalDetailSubViewBinding(Object obj, View view, int i2, Barrier barrier2, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView16, TextView textView22, TextView textView23, TextView textView24, TextView textView26, TextView textView28, TextView textView29, TextView textView31, TextView textView32) {
        super(obj, view, i2);
        this.barrier = barrier2;
        this.dataProfileBankName = textView;
        this.ivPaymode = imageView;
        this.profileLabelBankName = textView2;
        this.textView14 = textView3;
        this.textView15 = textView4;
        this.textView17 = textView5;
        this.textView18 = textView6;
        this.textView19 = textView9;
        this.textView20 = textView10;
        this.textView21 = textView11;
        this.textView25 = textView12;
        this.textView27 = textView13;
        this.textView30 = textView16;
        this.textView7 = textView22;
        this.textView8 = textView23;
        this.tvBank = textView24;
        this.tvDirectSettleVia = textView26;
        this.tvOrderId = textView28;
        this.tvOrderIdText = textView29;
        this.tvPaymentDescriptionText = textView31;
        this.tvSettledAmnt = textView32;
    }

    public ReversalDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpReversalDetailSubViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpReversalDetailSubViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpReversalDetailSubViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_reversal_detail_sub_view, viewGroup, z, obj);
    }

    public static MpReversalDetailSubViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpReversalDetailSubViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpReversalDetailSubViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_reversal_detail_sub_view, (ViewGroup) null, false, obj);
    }

    public static MpReversalDetailSubViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpReversalDetailSubViewBinding bind(View view, Object obj) {
        return (MpReversalDetailSubViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_reversal_detail_sub_view);
    }
}
