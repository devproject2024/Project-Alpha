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

public abstract class MpBwSettlementDetailItemBinding extends ViewDataBinding {
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

    public MpBwSettlementDetailItemBinding(Object obj, View view, int i2, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, ImageView imageView, MpRoboTextView mpRoboTextView3, View view2, ImageView imageView2, MpRoboTextView mpRoboTextView4, LinearLayout linearLayout, MpRoboTextView mpRoboTextView5, MpFlowLayout mpFlowLayout) {
        super(obj, view, i2);
        this.bwSettlementDetailAccountNumberText = mpRoboTextView;
        this.bwSettlementDetailAmountText = mpRoboTextView2;
        this.bwSettlementDetailBankLogoImage = imageView;
        this.bwSettlementDetailBankNameText = mpRoboTextView3;
        this.bwSettlementDetailItemDivider = view2;
        this.bwSettlementDetailItemStatusIcon = imageView2;
        this.bwSettlementDetailItemStatusText = mpRoboTextView4;
        this.bwSettlementSuccessContainer = linearLayout;
        this.bwSettlementUTRText = mpRoboTextView5;
        this.bwsDetailFlowLayout = mpFlowLayout;
    }

    public static MpBwSettlementDetailItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwSettlementDetailItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_detail_item, viewGroup, z, obj);
    }

    public static MpBwSettlementDetailItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwSettlementDetailItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_detail_item, (ViewGroup) null, false, obj);
    }

    public static MpBwSettlementDetailItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailItemBinding bind(View view, Object obj) {
        return (MpBwSettlementDetailItemBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_settlement_detail_item);
    }
}
