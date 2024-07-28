package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.AcceptPaymentViewModel;

public abstract class MpPaymentSettlementTabsBinding extends ViewDataBinding {
    public AcceptPaymentViewModel mModel;
    public final TextView paymentsTab;
    public final TextView settlementsTab;
    public final ConstraintLayout tabs;

    public abstract void setModel(AcceptPaymentViewModel acceptPaymentViewModel);

    public MpPaymentSettlementTabsBinding(Object obj, View view, int i2, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        super(obj, view, i2);
        this.paymentsTab = textView;
        this.settlementsTab = textView2;
        this.tabs = constraintLayout;
    }

    public AcceptPaymentViewModel getModel() {
        return this.mModel;
    }

    public static MpPaymentSettlementTabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentSettlementTabsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentSettlementTabsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_settlement_tabs, viewGroup, z, obj);
    }

    public static MpPaymentSettlementTabsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentSettlementTabsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentSettlementTabsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_settlement_tabs, (ViewGroup) null, false, obj);
    }

    public static MpPaymentSettlementTabsBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentSettlementTabsBinding bind(View view, Object obj) {
        return (MpPaymentSettlementTabsBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payment_settlement_tabs);
    }
}
