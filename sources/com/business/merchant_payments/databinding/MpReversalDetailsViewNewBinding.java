package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.ReversalDetailsViewModel;
import com.business.merchant_payments.widget.DotProgressBar;

public abstract class MpReversalDetailsViewNewBinding extends ViewDataBinding {
    public final CoordinatorLayout coordinatorLayout;
    public final MpReversalDetailSubViewBinding detailsContainer;
    public final DotProgressBar dotProgressBar;
    public final ImageView ivClose;
    public final ImageView ivNeedHelp;
    public ReversalDetailsViewModel mRefundDetailsViewModel;
    public final View netTopSep;
    public final TextView netTotalAmnt;
    public final TextView netTotalTxt;
    public final TextView refundTvCommission;
    public final TextView refundTvCommissionAmnt;
    public final TextView refundTvGstAmntTxt;
    public final TextView refundTvGstTxt;
    public final TextView refundTvTransferedToBnkAmnt;
    public final TextView refundTvTransferedToBnkTxt;
    public final RelativeLayout rlAmntStatus;
    public final RelativeLayout rlHeader;
    public final RelativeLayout rlNeedHelp;
    public final LinearLayout totalPaymentCollectedContainer;
    public final TextView tvAmnt;
    public final TextView tvDateTime;
    public final TextView tvHeaderLbl;
    public final TextView tvNeedHelp;
    public final TextView tvTxnId;

    public abstract void setRefundDetailsViewModel(ReversalDetailsViewModel reversalDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpReversalDetailsViewNewBinding(Object obj, View view, int i2, CoordinatorLayout coordinatorLayout2, MpReversalDetailSubViewBinding mpReversalDetailSubViewBinding, DotProgressBar dotProgressBar2, ImageView imageView, ImageView imageView2, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        super(obj, view, i2);
        this.coordinatorLayout = coordinatorLayout2;
        this.detailsContainer = mpReversalDetailSubViewBinding;
        setContainedBinding(mpReversalDetailSubViewBinding);
        this.dotProgressBar = dotProgressBar2;
        this.ivClose = imageView;
        this.ivNeedHelp = imageView2;
        this.netTopSep = view2;
        this.netTotalAmnt = textView;
        this.netTotalTxt = textView2;
        this.refundTvCommission = textView3;
        this.refundTvCommissionAmnt = textView4;
        this.refundTvGstAmntTxt = textView5;
        this.refundTvGstTxt = textView6;
        this.refundTvTransferedToBnkAmnt = textView7;
        this.refundTvTransferedToBnkTxt = textView8;
        this.rlAmntStatus = relativeLayout;
        this.rlHeader = relativeLayout2;
        this.rlNeedHelp = relativeLayout3;
        this.totalPaymentCollectedContainer = linearLayout;
        this.tvAmnt = textView9;
        this.tvDateTime = textView10;
        this.tvHeaderLbl = textView11;
        this.tvNeedHelp = textView12;
        this.tvTxnId = textView13;
    }

    public ReversalDetailsViewModel getRefundDetailsViewModel() {
        return this.mRefundDetailsViewModel;
    }

    public static MpReversalDetailsViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpReversalDetailsViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpReversalDetailsViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_reversal_details_view_new, viewGroup, z, obj);
    }

    public static MpReversalDetailsViewNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpReversalDetailsViewNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpReversalDetailsViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_reversal_details_view_new, (ViewGroup) null, false, obj);
    }

    public static MpReversalDetailsViewNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpReversalDetailsViewNewBinding bind(View view, Object obj) {
        return (MpReversalDetailsViewNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_reversal_details_view_new);
    }
}
