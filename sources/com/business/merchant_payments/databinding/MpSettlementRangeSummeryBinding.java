package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;

public abstract class MpSettlementRangeSummeryBinding extends ViewDataBinding {
    public SettlementRangeSummaryModel mModelData;
    public final MpDotProgressBarLytBinding mpSettlementRangeLoader;
    public final ConstraintLayout paymentSummary;
    public final TextView paymentSummeryHeader;
    public final TextView settlementAmount;

    public abstract void setModelData(SettlementRangeSummaryModel settlementRangeSummaryModel);

    public MpSettlementRangeSummeryBinding(Object obj, View view, int i2, MpDotProgressBarLytBinding mpDotProgressBarLytBinding, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.mpSettlementRangeLoader = mpDotProgressBarLytBinding;
        setContainedBinding(mpDotProgressBarLytBinding);
        this.paymentSummary = constraintLayout;
        this.paymentSummeryHeader = textView;
        this.settlementAmount = textView2;
    }

    public SettlementRangeSummaryModel getModelData() {
        return this.mModelData;
    }

    public static MpSettlementRangeSummeryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpSettlementRangeSummeryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpSettlementRangeSummeryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_range_summery, viewGroup, z, obj);
    }

    public static MpSettlementRangeSummeryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpSettlementRangeSummeryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpSettlementRangeSummeryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_range_summery, (ViewGroup) null, false, obj);
    }

    public static MpSettlementRangeSummeryBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpSettlementRangeSummeryBinding bind(View view, Object obj) {
        return (MpSettlementRangeSummeryBinding) ViewDataBinding.bind(obj, view, R.layout.mp_settlement_range_summery);
    }
}
