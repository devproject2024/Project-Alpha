package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.homepagedialogs.HomePageSuccessPopup;

public abstract class MpSuccessPopupBinding extends ViewDataBinding {
    public HomePageSuccessPopup.HomePageNotificationPopupListener mListener;
    public String mMessage;
    public final ImageView successIcon;
    public final CustomTextView txtCongratsStatic;

    public abstract void setListener(HomePageSuccessPopup.HomePageNotificationPopupListener homePageNotificationPopupListener);

    public abstract void setMessage(String str);

    public MpSuccessPopupBinding(Object obj, View view, int i2, ImageView imageView, CustomTextView customTextView) {
        super(obj, view, i2);
        this.successIcon = imageView;
        this.txtCongratsStatic = customTextView;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public HomePageSuccessPopup.HomePageNotificationPopupListener getListener() {
        return this.mListener;
    }

    public static MpSuccessPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpSuccessPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpSuccessPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_success_popup, viewGroup, z, obj);
    }

    public static MpSuccessPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpSuccessPopupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpSuccessPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_success_popup, (ViewGroup) null, false, obj);
    }

    public static MpSuccessPopupBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpSuccessPopupBinding bind(View view, Object obj) {
        return (MpSuccessPopupBinding) ViewDataBinding.bind(obj, view, R.layout.mp_success_popup);
    }
}
