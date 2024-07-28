package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;

public abstract class MpBwSettlementDetailNewBinding extends ViewDataBinding {
    public final ConstraintLayout bwDetailBankLogoAccNumberContainer;
    public final MpRoboTextView bwPipe;
    public final MpRoboTextView bwSettlementDetailAccountNumberText;
    public final MpRoboTextView bwSettlementDetailAmountText;
    public final ImageView bwSettlementDetailBankLogoImage;
    public final ConstraintLayout bwSettlementDetailBankNameContainer;
    public final MpRoboTextView bwSettlementDetailBankNameText;
    public final View bwSettlementDetailItemDivider;
    public final ImageView bwSettlementDetailItemStatusIcon;
    public final MpRoboTextView bwSettlementDetailItemStatusText;
    public final ConstraintLayout bwSettlementDetailNewSettledAtContainer;
    public final MpRoboTextView bwSettlementUTRText;
    public final MpRoboTextView bwSettlementUTRText2;
    public final MpRoboTextView viewAllPendingSettlementTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBwSettlementDetailNewBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, MpRoboTextView mpRoboTextView3, ImageView imageView, ConstraintLayout constraintLayout2, MpRoboTextView mpRoboTextView4, View view2, ImageView imageView2, MpRoboTextView mpRoboTextView5, ConstraintLayout constraintLayout3, MpRoboTextView mpRoboTextView6, MpRoboTextView mpRoboTextView7, MpRoboTextView mpRoboTextView8) {
        super(obj, view, i2);
        this.bwDetailBankLogoAccNumberContainer = constraintLayout;
        this.bwPipe = mpRoboTextView;
        this.bwSettlementDetailAccountNumberText = mpRoboTextView2;
        this.bwSettlementDetailAmountText = mpRoboTextView3;
        this.bwSettlementDetailBankLogoImage = imageView;
        this.bwSettlementDetailBankNameContainer = constraintLayout2;
        this.bwSettlementDetailBankNameText = mpRoboTextView4;
        this.bwSettlementDetailItemDivider = view2;
        this.bwSettlementDetailItemStatusIcon = imageView2;
        this.bwSettlementDetailItemStatusText = mpRoboTextView5;
        this.bwSettlementDetailNewSettledAtContainer = constraintLayout3;
        this.bwSettlementUTRText = mpRoboTextView6;
        this.bwSettlementUTRText2 = mpRoboTextView7;
        this.viewAllPendingSettlementTime = mpRoboTextView8;
    }

    public static MpBwSettlementDetailNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwSettlementDetailNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_detail_new, viewGroup, z, obj);
    }

    public static MpBwSettlementDetailNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwSettlementDetailNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_detail_new, (ViewGroup) null, false, obj);
    }

    public static MpBwSettlementDetailNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwSettlementDetailNewBinding bind(View view, Object obj) {
        return (MpBwSettlementDetailNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_settlement_detail_new);
    }
}
