package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.QrViewModel;
import com.business.merchant_payments.nonetwork.NoNetworkViewModel;
import com.business.merchant_payments.qr.ManageQrViewHandlerNew;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;

public abstract class MpQrViewNewBinding extends ViewDataBinding {
    public final AppCompatTextView acceptedHere;
    public final View bottomLine1;
    public final View bottomLine2;
    public final CardView cardView;
    public final AppCompatImageView gpayIcon;
    public final AppCompatImageView ivAllInOne;
    public final TextView llNoPermission;
    public final TextView llRetry;
    public QrViewModel mModel;
    public NoNetworkViewModel mNoNetworkViewModel;
    public ManageQrViewHandlerNew.QrPageItemViewModel mViewModel;
    public final AppCompatTextView payUsingPaytmOrAnyOtherUpiApp;
    public final AppCompatImageView paytmLogo;
    public final AppCompatImageView phonePeIcon;
    public final AppCompatTextView poweredBy;
    public final AppCompatImageView ppblIcon;
    public final FrameLayout qrContainer;
    public final ImageView qrDummyImage;
    public final ImageView qrImage;
    public final ConstraintLayout qrOptions;
    public final ShimmerFrameLayout qrShimmer;
    public final AppCompatTextView rlActivateQr;
    public final AppCompatTextView rlDownloadMyQr;
    public final AppCompatTextView rlOrderQrCode;
    public final AppCompatTextView rlShareMyQr;
    public final MpLayoutVerifyQrPopupBinding verifyQrPopupContainer;
    public final AppCompatImageView walletIcon;
    public final AppCompatTextView walletUpiIcon;

    public abstract void setModel(QrViewModel qrViewModel);

    public abstract void setNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel);

    public abstract void setViewModel(ManageQrViewHandlerNew.QrPageItemViewModel qrPageItemViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpQrViewNewBinding(Object obj, View view, int i2, AppCompatTextView appCompatTextView, View view2, View view3, CardView cardView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView5, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding, AppCompatImageView appCompatImageView6, AppCompatTextView appCompatTextView8) {
        super(obj, view, i2);
        MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding2 = mpLayoutVerifyQrPopupBinding;
        this.acceptedHere = appCompatTextView;
        this.bottomLine1 = view2;
        this.bottomLine2 = view3;
        this.cardView = cardView2;
        this.gpayIcon = appCompatImageView;
        this.ivAllInOne = appCompatImageView2;
        this.llNoPermission = textView;
        this.llRetry = textView2;
        this.payUsingPaytmOrAnyOtherUpiApp = appCompatTextView2;
        this.paytmLogo = appCompatImageView3;
        this.phonePeIcon = appCompatImageView4;
        this.poweredBy = appCompatTextView3;
        this.ppblIcon = appCompatImageView5;
        this.qrContainer = frameLayout;
        this.qrDummyImage = imageView;
        this.qrImage = imageView2;
        this.qrOptions = constraintLayout;
        this.qrShimmer = shimmerFrameLayout;
        this.rlActivateQr = appCompatTextView4;
        this.rlDownloadMyQr = appCompatTextView5;
        this.rlOrderQrCode = appCompatTextView6;
        this.rlShareMyQr = appCompatTextView7;
        this.verifyQrPopupContainer = mpLayoutVerifyQrPopupBinding2;
        setContainedBinding(mpLayoutVerifyQrPopupBinding2);
        this.walletIcon = appCompatImageView6;
        this.walletUpiIcon = appCompatTextView8;
    }

    public NoNetworkViewModel getNoNetworkViewModel() {
        return this.mNoNetworkViewModel;
    }

    public QrViewModel getModel() {
        return this.mModel;
    }

    public ManageQrViewHandlerNew.QrPageItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpQrViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpQrViewNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpQrViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_view_new, viewGroup, z, obj);
    }

    public static MpQrViewNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpQrViewNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpQrViewNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_view_new, (ViewGroup) null, false, obj);
    }

    public static MpQrViewNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpQrViewNewBinding bind(View view, Object obj) {
        return (MpQrViewNewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_qr_view_new);
    }
}
