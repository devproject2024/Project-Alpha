package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;
import com.business.merchant_payments.widget.DotProgressBar;

public abstract class MpTransactionDetailBinding extends ViewDataBinding {
    public final TextView commission;
    public final TextView commissionAmnt;
    public final CoordinatorLayout coordinatorLayout;
    public final MpTransactionDetailSubViewBinding detailsContainer;
    public final DotProgressBar dotProgressBar;
    public final TextView gstAmntTxt;
    public final TextView gstTxt;
    public final LinearLayout headerInnerContainer;
    public final ScrollView headerOuterMostContainer;
    public final TextView initiateRefundBtn;
    public final ImageView ivClose;
    public final ImageView ivNeedHelp;
    public final ImageView ivPrintReciept;
    public final ImageView ivStatus;
    public final LinearLayout llSettlementDetailContainer;
    public OnlineTxnDetailsViewModel mViewModel;
    public final View netTopSep;
    public final TextView netTotalAmnt;
    public final TextView netTotalTxt;
    public final RelativeLayout rlAmntStatus;
    public final RelativeLayout rlDate;
    public final RelativeLayout rlIncentiveStrip;
    public final LinearLayout rlNeedHelp;
    public final LinearLayout rlPrintReciept;
    public final RelativeLayout rlWarning;
    public final LinearLayout totalPaymentCollectedContainer;
    public final TextView transferedToBnkAmnt;
    public final TextView transferedToBnkTxt;
    public final TextView tvAmnt;
    public final TextView tvDateTime;
    public final TextView tvDetail;
    public final TextView tvIncentiveAmt;
    public final TextView tvNeedHelp;
    public final TextView tvPrintReciept;
    public final TextView tvSettlementDateText;
    public final TextView tvSettlementDateTitle;
    public final TextView tvSettlementDetailHeader;
    public final TextView tvTxnId;
    public final TextView tvUtrText;
    public final TextView utrTitle;
    public final ImageView warningImage;

    public abstract void setViewModel(OnlineTxnDetailsViewModel onlineTxnDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpTransactionDetailBinding(Object obj, View view, int i2, TextView textView, TextView textView2, CoordinatorLayout coordinatorLayout2, MpTransactionDetailSubViewBinding mpTransactionDetailSubViewBinding, DotProgressBar dotProgressBar2, TextView textView3, TextView textView4, LinearLayout linearLayout, ScrollView scrollView, TextView textView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, View view2, TextView textView6, TextView textView7, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout4, LinearLayout linearLayout5, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, ImageView imageView5) {
        super(obj, view, i2);
        this.commission = textView;
        this.commissionAmnt = textView2;
        this.coordinatorLayout = coordinatorLayout2;
        this.detailsContainer = mpTransactionDetailSubViewBinding;
        setContainedBinding(mpTransactionDetailSubViewBinding);
        this.dotProgressBar = dotProgressBar2;
        this.gstAmntTxt = textView3;
        this.gstTxt = textView4;
        this.headerInnerContainer = linearLayout;
        this.headerOuterMostContainer = scrollView;
        this.initiateRefundBtn = textView5;
        this.ivClose = imageView;
        this.ivNeedHelp = imageView2;
        this.ivPrintReciept = imageView3;
        this.ivStatus = imageView4;
        this.llSettlementDetailContainer = linearLayout2;
        this.netTopSep = view2;
        this.netTotalAmnt = textView6;
        this.netTotalTxt = textView7;
        this.rlAmntStatus = relativeLayout;
        this.rlDate = relativeLayout2;
        this.rlIncentiveStrip = relativeLayout3;
        this.rlNeedHelp = linearLayout3;
        this.rlPrintReciept = linearLayout4;
        this.rlWarning = relativeLayout4;
        this.totalPaymentCollectedContainer = linearLayout5;
        this.transferedToBnkAmnt = textView8;
        this.transferedToBnkTxt = textView9;
        this.tvAmnt = textView10;
        this.tvDateTime = textView11;
        this.tvDetail = textView12;
        this.tvIncentiveAmt = textView13;
        this.tvNeedHelp = textView14;
        this.tvPrintReciept = textView15;
        this.tvSettlementDateText = textView16;
        this.tvSettlementDateTitle = textView17;
        this.tvSettlementDetailHeader = textView18;
        this.tvTxnId = textView19;
        this.tvUtrText = textView20;
        this.utrTitle = textView21;
        this.warningImage = imageView5;
    }

    public OnlineTxnDetailsViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpTransactionDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpTransactionDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpTransactionDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_transaction_detail, viewGroup, z, obj);
    }

    public static MpTransactionDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpTransactionDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpTransactionDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_transaction_detail, (ViewGroup) null, false, obj);
    }

    public static MpTransactionDetailBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpTransactionDetailBinding bind(View view, Object obj) {
        return (MpTransactionDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mp_transaction_detail);
    }
}
