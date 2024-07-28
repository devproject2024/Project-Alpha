package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.ManageQrViewHandler;
import com.business.merchant_payments.widget.shimmer.ShimmerFrameLayout;

public abstract class MpProfileQrPagerItemLayoutBinding extends ViewDataBinding {
    public final ImageView backButton;
    public final Barrier barrier;
    public final View bottomLine1;
    public final View bottomLine2;
    public final CardView cardView;
    public final ImageView ivAllInOne;
    public final TextView llNoPermission;
    public final TextView llRetry;
    public ManageQrViewHandler.QrPageItemViewModelNew mViewModel;
    public final ImageView qrDummyImage;
    public final ImageView qrImage;
    public final ConstraintLayout qrParent;
    public final ShimmerFrameLayout qrShimmer;
    public final MpLayoutVerifyQrPopupBinding verifyQrPopupContainer;

    public abstract void setViewModel(ManageQrViewHandler.QrPageItemViewModelNew qrPageItemViewModelNew);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpProfileQrPagerItemLayoutBinding(Object obj, View view, int i2, ImageView imageView, Barrier barrier2, View view2, View view3, CardView cardView2, ImageView imageView2, TextView textView, TextView textView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout, MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding) {
        super(obj, view, i2);
        MpLayoutVerifyQrPopupBinding mpLayoutVerifyQrPopupBinding2 = mpLayoutVerifyQrPopupBinding;
        this.backButton = imageView;
        this.barrier = barrier2;
        this.bottomLine1 = view2;
        this.bottomLine2 = view3;
        this.cardView = cardView2;
        this.ivAllInOne = imageView2;
        this.llNoPermission = textView;
        this.llRetry = textView2;
        this.qrDummyImage = imageView3;
        this.qrImage = imageView4;
        this.qrParent = constraintLayout;
        this.qrShimmer = shimmerFrameLayout;
        this.verifyQrPopupContainer = mpLayoutVerifyQrPopupBinding2;
        setContainedBinding(mpLayoutVerifyQrPopupBinding2);
    }

    public ManageQrViewHandler.QrPageItemViewModelNew getViewModel() {
        return this.mViewModel;
    }

    public static MpProfileQrPagerItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpProfileQrPagerItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpProfileQrPagerItemLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_profile_qr_pager_item_layout, viewGroup, z, obj);
    }

    public static MpProfileQrPagerItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpProfileQrPagerItemLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpProfileQrPagerItemLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_profile_qr_pager_item_layout, (ViewGroup) null, false, obj);
    }

    public static MpProfileQrPagerItemLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpProfileQrPagerItemLayoutBinding bind(View view, Object obj) {
        return (MpProfileQrPagerItemLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.mp_profile_qr_pager_item_layout);
    }
}
