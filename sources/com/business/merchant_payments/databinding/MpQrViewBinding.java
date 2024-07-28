package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.newhome.QrViewModel;
import com.business.merchant_payments.nonetwork.NoNetworkViewModel;

public abstract class MpQrViewBinding extends ViewDataBinding {
    public QrViewModel mModel;
    public NoNetworkViewModel mNoNetworkViewModel;
    public final MpProfileQrPagerItemLayoutBinding qrContainer;
    public final TextView rlActivateQr;
    public final ConstraintLayout rlContainer;
    public final TextView rlDownloadMyQr;
    public final TextView rlOrderQrCode;
    public final TextView rlShareMyQr;

    public abstract void setModel(QrViewModel qrViewModel);

    public abstract void setNoNetworkViewModel(NoNetworkViewModel noNetworkViewModel);

    public MpQrViewBinding(Object obj, View view, int i2, MpProfileQrPagerItemLayoutBinding mpProfileQrPagerItemLayoutBinding, TextView textView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.qrContainer = mpProfileQrPagerItemLayoutBinding;
        setContainedBinding(mpProfileQrPagerItemLayoutBinding);
        this.rlActivateQr = textView;
        this.rlContainer = constraintLayout;
        this.rlDownloadMyQr = textView2;
        this.rlOrderQrCode = textView3;
        this.rlShareMyQr = textView4;
    }

    public NoNetworkViewModel getNoNetworkViewModel() {
        return this.mNoNetworkViewModel;
    }

    public QrViewModel getModel() {
        return this.mModel;
    }

    public static MpQrViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpQrViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpQrViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_view, viewGroup, z, obj);
    }

    public static MpQrViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpQrViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpQrViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_qr_view, (ViewGroup) null, false, obj);
    }

    public static MpQrViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpQrViewBinding bind(View view, Object obj) {
        return (MpQrViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_qr_view);
    }
}
