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
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;

public abstract class MpTransactionDetailSubViewBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final TextView dataProfileBankName;
    public final ImageView imageView3;
    public final ImageView ivPaymode;
    public OnlineTxnDetailsViewModel mViewModel;
    public final TextView profileLabelBankName;
    public final TextView textView10;
    public final TextView textView11;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView14;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;
    public final TextView textView23;
    public final TextView textView24;
    public final TextView textView25;
    public final TextView textView28;
    public final TextView textView29;
    public final TextView textView31;
    public final TextView textView7;
    public final TextView textView8;
    public final TextView textView9;
    public final TextView tvAccountLbl;
    public final TextView tvDirectBank;
    public final TextView tvDirectSettle;
    public final TextView tvIfsc;
    public final TextView tvIfscLbl;
    public final TextView tvOrderId;
    public final TextView tvOrderIdText;
    public final TextView tvPaymentDescriptionText;
    public final TextView utrText;

    public abstract void setViewModel(OnlineTxnDetailsViewModel onlineTxnDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpTransactionDetailSubViewBinding(Object obj, View view, int i2, Barrier barrier2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView15, TextView textView16, TextView textView26, TextView textView27, TextView textView30, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView40, TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView50, TextView textView51) {
        super(obj, view, i2);
        this.barrier = barrier2;
        this.dataProfileBankName = textView;
        this.imageView3 = imageView;
        this.ivPaymode = imageView2;
        this.profileLabelBankName = textView2;
        this.textView10 = textView3;
        this.textView11 = textView4;
        this.textView12 = textView5;
        this.textView13 = textView6;
        this.textView14 = textView15;
        this.textView17 = textView16;
        this.textView18 = textView26;
        this.textView19 = textView27;
        this.textView20 = textView30;
        this.textView21 = textView32;
        this.textView22 = textView33;
        this.textView23 = textView34;
        this.textView24 = textView35;
        this.textView25 = textView36;
        this.textView28 = textView37;
        this.textView29 = textView38;
        this.textView31 = textView39;
        this.textView7 = textView40;
        this.textView8 = textView41;
        this.textView9 = textView42;
        this.tvAccountLbl = textView43;
        this.tvDirectBank = textView44;
        this.tvDirectSettle = textView45;
        this.tvIfsc = textView46;
        this.tvIfscLbl = textView47;
        this.tvOrderId = textView48;
        this.tvOrderIdText = textView49;
        this.tvPaymentDescriptionText = textView50;
        this.utrText = textView51;
    }

    public OnlineTxnDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpTransactionDetailSubViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpTransactionDetailSubViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpTransactionDetailSubViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_transaction_detail_sub_view, viewGroup, z, obj);
    }

    public static MpTransactionDetailSubViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpTransactionDetailSubViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpTransactionDetailSubViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_transaction_detail_sub_view, (ViewGroup) null, false, obj);
    }

    public static MpTransactionDetailSubViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpTransactionDetailSubViewBinding bind(View view, Object obj) {
        return (MpTransactionDetailSubViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_transaction_detail_sub_view);
    }
}
