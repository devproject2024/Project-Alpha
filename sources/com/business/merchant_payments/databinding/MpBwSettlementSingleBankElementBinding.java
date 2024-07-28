package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpFlowLayout;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.paytm.utility.RoboTextView;

public abstract class MpBwSettlementSingleBankElementBinding extends ViewDataBinding {
    public final RoboTextView bwFailedSettlementText;
    public final RoboTextView bwMultipleAccountText;
    public final RoboTextView bwPendingSettlementText;
    public final View bwSettlementAmountBottomDivider;
    public final MpRoboTextView bwSettlementAmountDetailHeader;
    public final LinearLayout bwSettlementAmountDetailsContainer;
    public final View bwSettlementAmountTopDivider;
    public final ImageView bwSettlementArrow;
    public final MpRoboTextView bwSettlementDateHeader;
    public final LinearLayout bwSettlementDetailContainer;
    public final MpRoboTextView bwSettlementDetailsHeaderText;
    public final MpFlowLayout bwSettlementElementContactUsPending;
    public final LinearLayout bwSettlementElementRoot;
    public final LinearLayout bwSettlementElementSubHeader;
    public final MpRoboTextView bwSettlementMultiBankAccountNumber;
    public final ImageView bwSettlementMultiBankLogo;
    public final MpRoboTextView bwSettlementMultiBankName;
    public final MpRoboTextView bwSettlementOverAllAmountData;
    public final MpRoboTextView bwSettlementOverAllAmountText;
    public final RelativeLayout bwSettlementOverallAmountContainer;
    public final ConstraintLayout bwSettlementSingleBankListItemDetailContainer;
    public final ImageView bwSettlementStatusIcon;
    public final MpRoboTextView bwSettlementToLabel;
    public final MpRoboTextView bwSettlementTotalAmount;
    public final ImageView bwSingleBankSettlementStatusImage;
    public final MpRoboTextView bwSingleBankSettlementTimeText;
    public final MpRoboTextView bwSingleBankSettlementUTRText;
    public final MpRoboTextView contactUsClickableText;
    public final MpPendingSettlementCardItemBinding pendingSettlementCard;
    public final MpRoboTextView tvViewAll;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpBwSettlementSingleBankElementBinding(Object obj, View view, int i2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3, View view2, MpRoboTextView mpRoboTextView, LinearLayout linearLayout, View view3, ImageView imageView, MpRoboTextView mpRoboTextView2, LinearLayout linearLayout2, MpRoboTextView mpRoboTextView3, MpFlowLayout mpFlowLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, MpRoboTextView mpRoboTextView4, ImageView imageView2, MpRoboTextView mpRoboTextView5, MpRoboTextView mpRoboTextView6, MpRoboTextView mpRoboTextView7, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, ImageView imageView3, MpRoboTextView mpRoboTextView8, MpRoboTextView mpRoboTextView9, ImageView imageView4, MpRoboTextView mpRoboTextView10, MpRoboTextView mpRoboTextView11, MpRoboTextView mpRoboTextView12, MpPendingSettlementCardItemBinding mpPendingSettlementCardItemBinding, MpRoboTextView mpRoboTextView13) {
        super(obj, view, i2);
        MpPendingSettlementCardItemBinding mpPendingSettlementCardItemBinding2 = mpPendingSettlementCardItemBinding;
        this.bwFailedSettlementText = roboTextView;
        this.bwMultipleAccountText = roboTextView2;
        this.bwPendingSettlementText = roboTextView3;
        this.bwSettlementAmountBottomDivider = view2;
        this.bwSettlementAmountDetailHeader = mpRoboTextView;
        this.bwSettlementAmountDetailsContainer = linearLayout;
        this.bwSettlementAmountTopDivider = view3;
        this.bwSettlementArrow = imageView;
        this.bwSettlementDateHeader = mpRoboTextView2;
        this.bwSettlementDetailContainer = linearLayout2;
        this.bwSettlementDetailsHeaderText = mpRoboTextView3;
        this.bwSettlementElementContactUsPending = mpFlowLayout;
        this.bwSettlementElementRoot = linearLayout3;
        this.bwSettlementElementSubHeader = linearLayout4;
        this.bwSettlementMultiBankAccountNumber = mpRoboTextView4;
        this.bwSettlementMultiBankLogo = imageView2;
        this.bwSettlementMultiBankName = mpRoboTextView5;
        this.bwSettlementOverAllAmountData = mpRoboTextView6;
        this.bwSettlementOverAllAmountText = mpRoboTextView7;
        this.bwSettlementOverallAmountContainer = relativeLayout;
        this.bwSettlementSingleBankListItemDetailContainer = constraintLayout;
        this.bwSettlementStatusIcon = imageView3;
        this.bwSettlementToLabel = mpRoboTextView8;
        this.bwSettlementTotalAmount = mpRoboTextView9;
        this.bwSingleBankSettlementStatusImage = imageView4;
        this.bwSingleBankSettlementTimeText = mpRoboTextView10;
        this.bwSingleBankSettlementUTRText = mpRoboTextView11;
        this.contactUsClickableText = mpRoboTextView12;
        this.pendingSettlementCard = mpPendingSettlementCardItemBinding2;
        setContainedBinding(mpPendingSettlementCardItemBinding2);
        this.tvViewAll = mpRoboTextView13;
    }

    public static MpBwSettlementSingleBankElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBwSettlementSingleBankElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBwSettlementSingleBankElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_single_bank_element, viewGroup, z, obj);
    }

    public static MpBwSettlementSingleBankElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBwSettlementSingleBankElementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBwSettlementSingleBankElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bw_settlement_single_bank_element, (ViewGroup) null, false, obj);
    }

    public static MpBwSettlementSingleBankElementBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBwSettlementSingleBankElementBinding bind(View view, Object obj) {
        return (MpBwSettlementSingleBankElementBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bw_settlement_single_bank_element);
    }
}
