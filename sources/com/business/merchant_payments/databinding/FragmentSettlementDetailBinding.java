package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class FragmentSettlementDetailBinding extends ViewDataBinding {
    public final ImageView bwSettlementDetailBankLogoImage;
    public final MpRoboTextView bwSettlementDetailBankNameText;
    public final ConstraintLayout clErrorLayout;
    public final ImageView ivBack;
    public final LinearLayout ll;
    public final RecyclerView rvSettlementDetail;
    public final MpRoboTextView tvDate;
    public final MpRoboTextView tvHeading;
    public final MpRoboTextView tvSettledAmnt;
    public final MpRoboTextView tvSettledTo;

    public FragmentSettlementDetailBinding(Object obj, View view, int i2, ImageView imageView, MpRoboTextView mpRoboTextView, ConstraintLayout constraintLayout, ImageView imageView2, LinearLayout linearLayout, RecyclerView recyclerView, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3, MpRoboTextView mpRoboTextView4, MpRoboTextView mpRoboTextView5) {
        super(obj, view, i2);
        this.bwSettlementDetailBankLogoImage = imageView;
        this.bwSettlementDetailBankNameText = mpRoboTextView;
        this.clErrorLayout = constraintLayout;
        this.ivBack = imageView2;
        this.ll = linearLayout;
        this.rvSettlementDetail = recyclerView;
        this.tvDate = mpRoboTextView2;
        this.tvHeading = mpRoboTextView3;
        this.tvSettledAmnt = mpRoboTextView4;
        this.tvSettledTo = mpRoboTextView5;
    }

    public static FragmentSettlementDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static FragmentSettlementDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSettlementDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settlement_detail, viewGroup, z, obj);
    }

    public static FragmentSettlementDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static FragmentSettlementDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSettlementDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_settlement_detail, (ViewGroup) null, false, obj);
    }

    public static FragmentSettlementDetailBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static FragmentSettlementDetailBinding bind(View view, Object obj) {
        return (FragmentSettlementDetailBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_settlement_detail);
    }
}
