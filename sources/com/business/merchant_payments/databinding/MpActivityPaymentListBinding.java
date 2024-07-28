package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.payment.viewmodel.PaymentsListViewModel;

public abstract class MpActivityPaymentListBinding extends ViewDataBinding {
    public final LottieAnimationView animationView;
    public final AppCompatImageView back;
    public final CoordinatorLayout coordinatorLayout;
    public final TextView downloadStatementLabel;
    public final TextView errorHeader;
    public final AppCompatImageView errorIcon;
    public final ConstraintLayout errorLayout;
    public final TextView errorRetryBtn;
    public final TextView errorSummary;
    public final LinearLayout header;
    public PaymentsListViewModel mModel;
    public final MpQrPaymentListHeaderBinding multipleqrHeaderLayout;
    public final RecyclerView paymentsRv;
    public final TextView title;

    public abstract void setModel(PaymentsListViewModel paymentsListViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpActivityPaymentListBinding(Object obj, View view, int i2, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView, CoordinatorLayout coordinatorLayout2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, LinearLayout linearLayout, MpQrPaymentListHeaderBinding mpQrPaymentListHeaderBinding, RecyclerView recyclerView, TextView textView5) {
        super(obj, view, i2);
        MpQrPaymentListHeaderBinding mpQrPaymentListHeaderBinding2 = mpQrPaymentListHeaderBinding;
        this.animationView = lottieAnimationView;
        this.back = appCompatImageView;
        this.coordinatorLayout = coordinatorLayout2;
        this.downloadStatementLabel = textView;
        this.errorHeader = textView2;
        this.errorIcon = appCompatImageView2;
        this.errorLayout = constraintLayout;
        this.errorRetryBtn = textView3;
        this.errorSummary = textView4;
        this.header = linearLayout;
        this.multipleqrHeaderLayout = mpQrPaymentListHeaderBinding2;
        setContainedBinding(mpQrPaymentListHeaderBinding2);
        this.paymentsRv = recyclerView;
        this.title = textView5;
    }

    public PaymentsListViewModel getModel() {
        return this.mModel;
    }

    public static MpActivityPaymentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityPaymentListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityPaymentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_payment_list, viewGroup, z, obj);
    }

    public static MpActivityPaymentListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityPaymentListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityPaymentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_payment_list, (ViewGroup) null, false, obj);
    }

    public static MpActivityPaymentListBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityPaymentListBinding bind(View view, Object obj) {
        return (MpActivityPaymentListBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_payment_list);
    }
}
