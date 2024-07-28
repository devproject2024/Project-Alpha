package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpOnlineSettlementSummaryCardBinding extends ViewDataBinding {
    public final View bottomDivider;
    public final MpRoboTextView onlineSettlementByTexts;
    public final LinearLayout onlineSettlementDynamicData;
    public final LinearLayout onlineSettlementSummaryRoot;
    public final MpRoboTextView onlineSettlementSummaryTotalAmountText;
    public final LinearLayout onlineSettlementTotalPaymentsContainer;
    public final MpRoboTextView onlineSettlementTotalPaymentsText;
    public final MpRoboTextView settlementSummaryCardAmount;

    public MpOnlineSettlementSummaryCardBinding(Object obj, View view, int i2, View view2, MpRoboTextView mpRoboTextView, LinearLayout linearLayout, LinearLayout linearLayout2, MpRoboTextView mpRoboTextView2, LinearLayout linearLayout3, MpRoboTextView mpRoboTextView3, MpRoboTextView mpRoboTextView4) {
        super(obj, view, i2);
        this.bottomDivider = view2;
        this.onlineSettlementByTexts = mpRoboTextView;
        this.onlineSettlementDynamicData = linearLayout;
        this.onlineSettlementSummaryRoot = linearLayout2;
        this.onlineSettlementSummaryTotalAmountText = mpRoboTextView2;
        this.onlineSettlementTotalPaymentsContainer = linearLayout3;
        this.onlineSettlementTotalPaymentsText = mpRoboTextView3;
        this.settlementSummaryCardAmount = mpRoboTextView4;
    }

    public static MpOnlineSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpOnlineSettlementSummaryCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_online_settlement_summary_card, viewGroup, z, obj);
    }

    public static MpOnlineSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpOnlineSettlementSummaryCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_online_settlement_summary_card, (ViewGroup) null, false, obj);
    }

    public static MpOnlineSettlementSummaryCardBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementSummaryCardBinding bind(View view, Object obj) {
        return (MpOnlineSettlementSummaryCardBinding) ViewDataBinding.bind(obj, view, R.layout.mp_online_settlement_summary_card);
    }
}
