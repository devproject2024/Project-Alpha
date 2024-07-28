package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;
import com.paytm.utility.RoboTextView;

public abstract class MpBwSettlementSummaryCardBinding extends ViewDataBinding {
    public final LinearLayout bwAlreadySettledAmountDetailsContainer;
    public final MpRoboTextView bwAlreadySettledAmountValue;
    public final ConstraintLayout bwAlreadySettledToBankContainer;
    public final MpRoboTextView bwAlreadySettledToBankText;
    public final RelativeLayout bwAvailableBalanceContainer;
    public final MpRoboTextView bwAvailableBalanceText;
    public final MpRoboTextView bwAvailableBalanceValue;
    public final MpRoboTextView bwBankAccountNumberText;
    public final MpRoboTextView bwMinAmtNextSettlementText;
    public final MpRoboTextView bwNextSettlementText;
    public final LinearLayout bwPendingAmountDetailsContainer;
    public final MpRoboTextView bwPendingAmountValue;
    public final ConstraintLayout bwPendingToBankContainer;
    public final MpRoboTextView bwPendingToBankText;
    public final ImageView bwSettleNowBankImage;
    public final ConstraintLayout bwSettleNowButton;
    public final ConstraintLayout bwSettleNowContainer;
    public final ShimmerFrameLayout bwSettlementSumaryBankDetailShimmer;
    public final ImageView bwSettlementSummaryAlreadySettledArrowImage;
    public final ImageView bwSettlementSummaryPendingArrowImage;
    public final MpRoboTextView bwSettlementToolTip;
    public final MpRoboTextView bwSettlementTotalPaymentsToday;
    public final TextView bwShimerSettlementFreq;
    public final TextView bwShimmerBankDetail;
    public final ImageView bwShimmerBankImage;
    public final ImageView bwShimmerSettleNowBtn;
    public final View bwSummaryCardDivider1;
    public final View bwSummaryCardDivider2;
    public final ConstraintLayout clDisableSettleNowInfo;
    public final ImageView icLock;
    public final RelativeLayout rlPendingHeader;
    public final RelativeLayout rlSummaryHeader;
    public final RoboTextView tagInstantSettlement;
    public final TextView tvDisableSettleNowInfo;
    public final MpRoboTextView tvPendingViewAll;
    public final TextView tvSettleNow;
    public final MpRoboTextView tvSettledViewAll;
    public final MpRoboTextView tvSettlementDetailTxt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBwSettlementSummaryCardBinding(Object obj, View view, int i2, LinearLayout linearLayout, MpRoboTextView mpRoboTextView, ConstraintLayout constraintLayout, MpRoboTextView mpRoboTextView2, RelativeLayout relativeLayout, MpRoboTextView mpRoboTextView3, MpRoboTextView mpRoboTextView4, MpRoboTextView mpRoboTextView5, MpRoboTextView mpRoboTextView6, MpRoboTextView mpRoboTextView7, LinearLayout linearLayout2, MpRoboTextView mpRoboTextView8, ConstraintLayout constraintLayout2, MpRoboTextView mpRoboTextView9, ImageView imageView, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ShimmerFrameLayout shimmerFrameLayout, ImageView imageView2, ImageView imageView3, MpRoboTextView mpRoboTextView10, MpRoboTextView mpRoboTextView11, TextView textView, TextView textView2, ImageView imageView4, ImageView imageView5, View view2, View view3, ConstraintLayout constraintLayout5, ImageView imageView6, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RoboTextView roboTextView, TextView textView3, MpRoboTextView mpRoboTextView12, TextView textView4, MpRoboTextView mpRoboTextView13, MpRoboTextView mpRoboTextView14) {
        super(obj, view, i2);
        this.bwAlreadySettledAmountDetailsContainer = linearLayout;
        this.bwAlreadySettledAmountValue = mpRoboTextView;
        this.bwAlreadySettledToBankContainer = constraintLayout;
        this.bwAlreadySettledToBankText = mpRoboTextView2;
        this.bwAvailableBalanceContainer = relativeLayout;
        this.bwAvailableBalanceText = mpRoboTextView3;
        this.bwAvailableBalanceValue = mpRoboTextView4;
        this.bwBankAccountNumberText = mpRoboTextView5;
        this.bwMinAmtNextSettlementText = mpRoboTextView6;
        this.bwNextSettlementText = mpRoboTextView7;
        this.bwPendingAmountDetailsContainer = linearLayout2;
        this.bwPendingAmountValue = mpRoboTextView8;
        this.bwPendingToBankContainer = constraintLayout2;
        this.bwPendingToBankText = mpRoboTextView9;
        this.bwSettleNowBankImage = imageView;
        this.bwSettleNowButton = constraintLayout3;
        this.bwSettleNowContainer = constraintLayout4;
        this.bwSettlementSumaryBankDetailShimmer = shimmerFrameLayout;
        this.bwSettlementSummaryAlreadySettledArrowImage = imageView2;
        this.bwSettlementSummaryPendingArrowImage = imageView3;
        this.bwSettlementToolTip = mpRoboTextView10;
        this.bwSettlementTotalPaymentsToday = mpRoboTextView11;
        this.bwShimerSettlementFreq = textView;
        this.bwShimmerBankDetail = textView2;
        this.bwShimmerBankImage = imageView4;
        this.bwShimmerSettleNowBtn = imageView5;
        this.bwSummaryCardDivider1 = view2;
        this.bwSummaryCardDivider2 = view3;
        this.clDisableSettleNowInfo = constraintLayout5;
        this.icLock = imageView6;
        this.rlPendingHeader = relativeLayout2;
        this.rlSummaryHeader = relativeLayout3;
        this.tagInstantSettlement = roboTextView;
        this.tvDisableSettleNowInfo = textView3;
        this.tvPendingViewAll = mpRoboTextView12;
        this.tvSettleNow = textView4;
        this.tvSettledViewAll = mpRoboTextView13;
        this.tvSettlementDetailTxt = mpRoboTextView14;
    }

    public static MpBwSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwSettlementSummaryCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_summary_card, viewGroup, z, obj);
    }

    public static MpBwSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwSettlementSummaryCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwSettlementSummaryCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_summary_card, (ViewGroup) null, false, obj);
    }

    public static MpBwSettlementSummaryCardBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwSettlementSummaryCardBinding bind(View view, Object obj) {
        return (MpBwSettlementSummaryCardBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_settlement_summary_card);
    }
}
