package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;

public abstract class MpRequestMoneyShimmerBinding extends ViewDataBinding {
    public final LinearLayout layoutItem;
    public final CustomTextView paymentListAmount;
    public final CustomTextView paymentListDate;
    public final CustomTextView paymentListDescription;
    public final CustomTextView paymentListTime;
    public final ShimmerFrameLayout requestMoneyShimmer;

    public MpRequestMoneyShimmerBinding(Object obj, View view, int i2, LinearLayout linearLayout, CustomTextView customTextView, CustomTextView customTextView2, CustomTextView customTextView3, CustomTextView customTextView4, ShimmerFrameLayout shimmerFrameLayout) {
        super(obj, view, i2);
        this.layoutItem = linearLayout;
        this.paymentListAmount = customTextView;
        this.paymentListDate = customTextView2;
        this.paymentListDescription = customTextView3;
        this.paymentListTime = customTextView4;
        this.requestMoneyShimmer = shimmerFrameLayout;
    }

    public static MpRequestMoneyShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpRequestMoneyShimmerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpRequestMoneyShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_request_money_shimmer, viewGroup, z, obj);
    }

    public static MpRequestMoneyShimmerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpRequestMoneyShimmerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpRequestMoneyShimmerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_request_money_shimmer, (ViewGroup) null, false, obj);
    }

    public static MpRequestMoneyShimmerBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpRequestMoneyShimmerBinding bind(View view, Object obj) {
        return (MpRequestMoneyShimmerBinding) ViewDataBinding.bind(obj, view, R.layout.mp_request_money_shimmer);
    }
}
