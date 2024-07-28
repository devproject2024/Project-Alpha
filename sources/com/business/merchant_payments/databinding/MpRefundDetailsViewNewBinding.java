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
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;
import com.business.merchant_payments.widget.DotProgressBar;

public abstract class MpRefundDetailsViewNewBinding extends ViewDataBinding {
    public final CoordinatorLayout coordinatorLayout;
    public final DotProgressBar dotProgressBar;
    public final ImageView ivClose;
    public final ImageView ivNeedHelp;
    public final ImageView ivPrintReciept;
    public RefundDetailsViewModel mRefundDetailsViewModel;
    public final View netTopSep;
    public final TextView netTotalAmnt;
    public final TextView netTotalTxt;
    public final MpRefundDetailSubviewBinding refundDetailSubview;
    public final TextView refundTvCommission;
    public final TextView refundTvCommissionAmnt;
    public final TextView refundTvGstAmntTxt;
    public final TextView refundTvGstTxt;
    public final TextView refundTvTransferedOnDate;
    public final TextView refundTvTransferedToBnkAmnt;
    public final TextView refundTvTransferedToBnkTxt;
    public final RelativeLayout rlAmntStatus;
    public final RelativeLayout rlHeader;
    public final LinearLayout rlNeedHelp;
    public final LinearLayout rlPrintReciept;
    public final LinearLayout totalPaymentCollectedContainer;
    public final TextView tvAmnt;
    public final TextView tvDateTime;
    public final TextView tvHeaderLbl;
    public final TextView tvNeedHelp;
    public final TextView tvPrintReciept;
    public final TextView tvTxnId;

    public abstract void setRefundDetailsViewModel(RefundDetailsViewModel refundDetailsViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpRefundDetailsViewNewBinding(Object obj, View view, int i2, CoordinatorLayout coordinatorLayout2, DotProgressBar dotProgressBar2, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, TextView textView, TextView textView2, MpRefundDetailSubviewBinding mpRefundDetailSubviewBinding, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        super(obj, view, i2);
        this.coordinatorLayout = coordinatorLayout2;
        this.dotProgressBar = dotProgressBar2;
        this.ivClose = imageView;
        this.ivNeedHelp = imageView2;
        this.ivPrintReciept = imageView3;
        this.netTopSep = view2;
        this.netTotalAmnt = textView;
        this.netTotalTxt = textView2;
        this.refundDetailSubview = mpRefundDetailSubviewBinding;
        setContainedBinding(mpRefundDetailSubviewBinding);
        this.refundTvCommission = textView3;
        this.refundTvCommissionAmnt = textView4;
        this.refundTvGstAmntTxt = textView5;
        this.refundTvGstTxt = textView6;
        this.refundTvTransferedOnDate = textView7;
        this.refundTvTransferedToBnkAmnt = textView8;
        this.refundTvTransferedToBnkTxt = textView9;
        this.rlAmntStatus = relativeLayout;
        this.rlHeader = relativeLayout2;
        this.rlNeedHelp = linearLayout;
        this.rlPrintReciept = linearLayout2;
        this.totalPaymentCollectedContainer = linearLayout3;
        this.tvAmnt = textView10;
        this.tvDateTime = textView11;
        this.tvHeaderLbl = textView12;
        this.tvNeedHelp = textView13;
        this.tvPrintReciept = textView14;
        this.tvTxnId = textView15;
    }

    public RefundDetailsViewModel getRefundDetailsViewModel() {
        return this.mRefundDetailsViewModel;
    }

    public static MpRefundDetailsViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpRefundDetailsViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpRefundDetailsViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_details_view_new, viewGroup, z, obj);
    }

    public static MpRefundDetailsViewNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpRefundDetailsViewNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpRefundDetailsViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_refund_details_view_new, (ViewGroup) null, false, obj);
    }

    public static MpRefundDetailsViewNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpRefundDetailsViewNewBinding bind(View view, Object obj) {
        return (MpRefundDetailsViewNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_refund_details_view_new);
    }
}
