package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.MpFlowLayout;
import com.business.merchant_payments.widget.MpRoboTextView;
import com.paytm.utility.RoboTextView;

public abstract class MpOnlineSettlementElementBinding extends ViewDataBinding {
    public final MpFlowLayout onlinePendingMessageContainer;
    public final MpRoboTextView onlineSettlementAccountNumberText;
    public final MpRoboTextView onlineSettlementAmount;
    public final CustomTextView onlineSettlementAmountDetailsText;
    public final ImageView onlineSettlementArrow;
    public final ImageView onlineSettlementBankImage;
    public final MpRoboTextView onlineSettlementBankText;
    public final MpRoboTextView onlineSettlementDate;
    public final LinearLayout onlineSettlementDetailContainer;
    public final View onlineSettlementDetailDividerBottom;
    public final View onlineSettlementDetailDividerTop;
    public final MpRoboTextView onlineSettlementInProgressText;
    public final MpRoboTextView onlineSettlementPendingContactUs;
    public final RoboTextView onlineSettlementPendingText;
    public final ImageView onlineSettlementStatusImage;
    public final ImageView onlineSettlementStatusImageBottom;
    public final MpRoboTextView onlineSettlementStatusText;
    public final MpRoboTextView onlineSettlementTimeText;
    public final MpRoboTextView onlineSettlementUtrNumber;
    public final CustomTextView settlementAmountText;
    public final CustomTextView settlementAmountValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpOnlineSettlementElementBinding(Object obj, View view, int i2, MpFlowLayout mpFlowLayout, MpRoboTextView mpRoboTextView, MpRoboTextView mpRoboTextView2, CustomTextView customTextView, ImageView imageView, ImageView imageView2, MpRoboTextView mpRoboTextView3, MpRoboTextView mpRoboTextView4, LinearLayout linearLayout, View view2, View view3, MpRoboTextView mpRoboTextView5, MpRoboTextView mpRoboTextView6, RoboTextView roboTextView, ImageView imageView3, ImageView imageView4, MpRoboTextView mpRoboTextView7, MpRoboTextView mpRoboTextView8, MpRoboTextView mpRoboTextView9, CustomTextView customTextView2, CustomTextView customTextView3) {
        super(obj, view, i2);
        this.onlinePendingMessageContainer = mpFlowLayout;
        this.onlineSettlementAccountNumberText = mpRoboTextView;
        this.onlineSettlementAmount = mpRoboTextView2;
        this.onlineSettlementAmountDetailsText = customTextView;
        this.onlineSettlementArrow = imageView;
        this.onlineSettlementBankImage = imageView2;
        this.onlineSettlementBankText = mpRoboTextView3;
        this.onlineSettlementDate = mpRoboTextView4;
        this.onlineSettlementDetailContainer = linearLayout;
        this.onlineSettlementDetailDividerBottom = view2;
        this.onlineSettlementDetailDividerTop = view3;
        this.onlineSettlementInProgressText = mpRoboTextView5;
        this.onlineSettlementPendingContactUs = mpRoboTextView6;
        this.onlineSettlementPendingText = roboTextView;
        this.onlineSettlementStatusImage = imageView3;
        this.onlineSettlementStatusImageBottom = imageView4;
        this.onlineSettlementStatusText = mpRoboTextView7;
        this.onlineSettlementTimeText = mpRoboTextView8;
        this.onlineSettlementUtrNumber = mpRoboTextView9;
        this.settlementAmountText = customTextView2;
        this.settlementAmountValue = customTextView3;
    }

    public static MpOnlineSettlementElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementElementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpOnlineSettlementElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_online_settlement_element, viewGroup, z, obj);
    }

    public static MpOnlineSettlementElementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementElementBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpOnlineSettlementElementBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_online_settlement_element, (ViewGroup) null, false, obj);
    }

    public static MpOnlineSettlementElementBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpOnlineSettlementElementBinding bind(View view, Object obj) {
        return (MpOnlineSettlementElementBinding) ViewDataBinding.bind(obj, view, R.layout.mp_online_settlement_element);
    }
}
