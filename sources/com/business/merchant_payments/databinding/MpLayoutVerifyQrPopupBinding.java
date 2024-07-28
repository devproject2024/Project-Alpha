package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public abstract class MpLayoutVerifyQrPopupBinding extends ViewDataBinding {
    public Boolean mShowVerifyQrPopup;
    public final RoboTextView mpVerifyText;
    public final ConstraintLayout parent;
    public final RoboTextView verifyQrNo;
    public final RoboTextView verifyQrYes;

    public abstract void setShowVerifyQrPopup(Boolean bool);

    public MpLayoutVerifyQrPopupBinding(Object obj, View view, int i2, RoboTextView roboTextView, ConstraintLayout constraintLayout, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, i2);
        this.mpVerifyText = roboTextView;
        this.parent = constraintLayout;
        this.verifyQrNo = roboTextView2;
        this.verifyQrYes = roboTextView3;
    }

    public Boolean getShowVerifyQrPopup() {
        return this.mShowVerifyQrPopup;
    }

    public static MpLayoutVerifyQrPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpLayoutVerifyQrPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpLayoutVerifyQrPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_layout_verify_qr_popup, viewGroup, z, obj);
    }

    public static MpLayoutVerifyQrPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpLayoutVerifyQrPopupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpLayoutVerifyQrPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_layout_verify_qr_popup, (ViewGroup) null, false, obj);
    }

    public static MpLayoutVerifyQrPopupBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpLayoutVerifyQrPopupBinding bind(View view, Object obj) {
        return (MpLayoutVerifyQrPopupBinding) ViewDataBinding.bind(obj, view, R.layout.mp_layout_verify_qr_popup);
    }
}
