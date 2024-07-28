package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;

public abstract class MpSettlementSummaryShimmerCardBinding extends ViewDataBinding {
    public final TextView leftLabel1;
    public final TextView leftLabel2;
    public final TextView leftLabel3;
    public final TextView leftLabel4;
    public final TextView leftLabel5;
    public final TextView leftLabel6;
    public final TextView rightLabel1;
    public final TextView rightLabel2;
    public final TextView rightLabel3;
    public final TextView rightLabel4;
    public final TextView rightLabel5;
    public final TextView rightLabel6;
    public final TextView settlementBottomShimmer;
    public final ShimmerFrameLayout settlementSummaryCardShimmer;
    public final TextView settlementTotalPaymentsShimmer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpSettlementSummaryShimmerCardBinding(Object obj, View view, int i2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, ShimmerFrameLayout shimmerFrameLayout, TextView textView14) {
        super(obj, view, i2);
        this.leftLabel1 = textView;
        this.leftLabel2 = textView2;
        this.leftLabel3 = textView3;
        this.leftLabel4 = textView4;
        this.leftLabel5 = textView5;
        this.leftLabel6 = textView6;
        this.rightLabel1 = textView7;
        this.rightLabel2 = textView8;
        this.rightLabel3 = textView9;
        this.rightLabel4 = textView10;
        this.rightLabel5 = textView11;
        this.rightLabel6 = textView12;
        this.settlementBottomShimmer = textView13;
        this.settlementSummaryCardShimmer = shimmerFrameLayout;
        this.settlementTotalPaymentsShimmer = textView14;
    }

    public static MpSettlementSummaryShimmerCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpSettlementSummaryShimmerCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpSettlementSummaryShimmerCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_summary_shimmer_card, viewGroup, z, obj);
    }

    public static MpSettlementSummaryShimmerCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpSettlementSummaryShimmerCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpSettlementSummaryShimmerCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_summary_shimmer_card, (ViewGroup) null, false, obj);
    }

    public static MpSettlementSummaryShimmerCardBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpSettlementSummaryShimmerCardBinding bind(View view, Object obj) {
        return (MpSettlementSummaryShimmerCardBinding) ViewDataBinding.bind(obj, view, R.layout.mp_settlement_summary_shimmer_card);
    }
}
