package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public abstract class MpCustomAlertDialogBinding extends ViewDataBinding {
    public Boolean mIsNegativeBtnVisible;
    public Boolean mIsTitleVisible;
    public String mMTitle;
    public String mMessage;
    public String mNegativeText;
    public View.OnClickListener mOnNegativeClick;
    public View.OnClickListener mOnPositiveClick;
    public String mPositiveText;
    public final RoboTextView msg;
    public final RoboTextView positiveActionBtn;
    public final RoboTextView title;

    public abstract void setIsNegativeBtnVisible(Boolean bool);

    public abstract void setIsTitleVisible(Boolean bool);

    public abstract void setMTitle(String str);

    public abstract void setMessage(String str);

    public abstract void setNegativeText(String str);

    public abstract void setOnNegativeClick(View.OnClickListener onClickListener);

    public abstract void setOnPositiveClick(View.OnClickListener onClickListener);

    public abstract void setPositiveText(String str);

    public MpCustomAlertDialogBinding(Object obj, View view, int i2, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, i2);
        this.msg = roboTextView;
        this.positiveActionBtn = roboTextView2;
        this.title = roboTextView3;
    }

    public String getMTitle() {
        return this.mMTitle;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getPositiveText() {
        return this.mPositiveText;
    }

    public String getNegativeText() {
        return this.mNegativeText;
    }

    public View.OnClickListener getOnPositiveClick() {
        return this.mOnPositiveClick;
    }

    public View.OnClickListener getOnNegativeClick() {
        return this.mOnNegativeClick;
    }

    public Boolean getIsTitleVisible() {
        return this.mIsTitleVisible;
    }

    public Boolean getIsNegativeBtnVisible() {
        return this.mIsNegativeBtnVisible;
    }

    public static MpCustomAlertDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpCustomAlertDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpCustomAlertDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_custom_alert_dialog, viewGroup, z, obj);
    }

    public static MpCustomAlertDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpCustomAlertDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpCustomAlertDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_custom_alert_dialog, (ViewGroup) null, false, obj);
    }

    public static MpCustomAlertDialogBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpCustomAlertDialogBinding bind(View view, Object obj) {
        return (MpCustomAlertDialogBinding) ViewDataBinding.bind(obj, view, R.layout.mp_custom_alert_dialog);
    }
}
