package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpFlowLayout;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpBwItemSettlementDetailBinding extends ViewDataBinding {
    public final MpRoboTextView bwPendingSettlementTime;
    public final MpRoboTextView bwSettlementDetailAccountNumberText;
    public final MpRoboTextView bwSettlementDetailAmountText;
    public final ImageView bwSettlementDetailBankLogoImage;
    public final MpRoboTextView bwSettlementDetailBankNameText;
    public final View bwSettlementDetailItemDivider;
    public final ImageView bwSettlementDetailItemStatusIcon;
    public final MpRoboTextView bwSettlementDetailItemStatusText;
    public final LinearLayout bwSettlementSuccessContainer;
    public final MpRoboTextView bwSettlementUTRText;
    public final MpFlowLayout bwsDetailFlowLayout;

    public MpBwItemSettlementDetailBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3, ImageView imageView, MpRoboTextView mpRoboTextView4, View view2, ImageView imageView2, MpRoboTextView mpRoboTextView5, LinearLayout linearLayout, MpRoboTextView mpRoboTextView6, MpFlowLayout mpFlowLayout) {
        super(obj, view, i2);
        this.bwPendingSettlementTime = mpRoboTextView;
        this.bwSettlementDetailAccountNumberText = mpRoboTextView2;
        this.bwSettlementDetailAmountText = mpRoboTextView3;
        this.bwSettlementDetailBankLogoImage = imageView;
        this.bwSettlementDetailBankNameText = mpRoboTextView4;
        this.bwSettlementDetailItemDivider = view2;
        this.bwSettlementDetailItemStatusIcon = imageView2;
        this.bwSettlementDetailItemStatusText = mpRoboTextView5;
        this.bwSettlementSuccessContainer = linearLayout;
        this.bwSettlementUTRText = mpRoboTextView6;
        this.bwsDetailFlowLayout = mpFlowLayout;
    }

    public static MpBwItemSettlementDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwItemSettlementDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwItemSettlementDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_item_settlement_detail, viewGroup, z, obj);
    }

    public static MpBwItemSettlementDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwItemSettlementDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwItemSettlementDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_item_settlement_detail, (ViewGroup) null, false, obj);
    }

    public static MpBwItemSettlementDetailBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwItemSettlementDetailBinding bind(View view, Object obj) {
        return (MpBwItemSettlementDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_item_settlement_detail);
    }
}
