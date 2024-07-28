package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;

public abstract class MpSettlementElementShimmerBinding extends ViewDataBinding {
    public final ImageView leftIcon1;
    public final TextView leftSubLabel1;
    public final TextView leftTextLabel1;
    public final TextView rightlabel1;
    public final ShimmerFrameLayout settlementElementShimmer;

    public MpSettlementElementShimmerBinding(Object obj, View view, int i2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, ShimmerFrameLayout shimmerFrameLayout) {
        super(obj, view, i2);
        this.leftIcon1 = imageView;
        this.leftSubLabel1 = textView;
        this.leftTextLabel1 = textView2;
        this.rightlabel1 = textView3;
        this.settlementElementShimmer = shimmerFrameLayout;
    }

    public static MpSettlementElementShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpSettlementElementShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpSettlementElementShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_element_shimmer, viewGroup, z, obj);
    }

    public static MpSettlementElementShimmerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpSettlementElementShimmerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpSettlementElementShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_settlement_element_shimmer, (ViewGroup) null, false, obj);
    }

    public static MpSettlementElementShimmerBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpSettlementElementShimmerBinding bind(View view, Object obj) {
        return (MpSettlementElementShimmerBinding) ViewDataBinding.bind(obj, view, R.layout.mp_settlement_element_shimmer);
    }
}
