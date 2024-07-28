package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import com.business.merchant_payments.widget.CircularImageView;

public abstract class MpPaymentsTransactionItemBinding extends ViewDataBinding {
    public final TextView amount;
    public final TextView cardMachineStatus;
    public final View divider;
    public final CircularImageView icon;
    public final ImageView ivInstantSettled;
    public PaymentsTransactionModel mModel;
    public final TextView name;
    public final TextView time;
    public final ConstraintLayout transactionRoot;

    public abstract void setModel(PaymentsTransactionModel paymentsTransactionModel);

    public MpPaymentsTransactionItemBinding(Object obj, View view, int i2, TextView textView, TextView textView2, View view2, CircularImageView circularImageView, ImageView imageView, TextView textView3, TextView textView4, ConstraintLayout constraintLayout) {
        super(obj, view, i2);
        this.amount = textView;
        this.cardMachineStatus = textView2;
        this.divider = view2;
        this.icon = circularImageView;
        this.ivInstantSettled = imageView;
        this.name = textView3;
        this.time = textView4;
        this.transactionRoot = constraintLayout;
    }

    public PaymentsTransactionModel getModel() {
        return this.mModel;
    }

    public static MpPaymentsTransactionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentsTransactionItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentsTransactionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_transaction_item, viewGroup, z, obj);
    }

    public static MpPaymentsTransactionItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentsTransactionItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentsTransactionItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payments_transaction_item, (ViewGroup) null, false, obj);
    }

    public static MpPaymentsTransactionItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentsTransactionItemBinding bind(View view, Object obj) {
        return (MpPaymentsTransactionItemBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payments_transaction_item);
    }
}
