package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public abstract class MpToolbarNotificationBinding extends ViewDataBinding {
    public final ImageView btnBack;
    public View.OnClickListener mBackButtonClick;
    public String mTitle;
    public final RoboTextView title;

    public abstract void setBackButtonClick(View.OnClickListener onClickListener);

    public abstract void setTitle(String str);

    public MpToolbarNotificationBinding(Object obj, View view, int i2, ImageView imageView, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.btnBack = imageView;
        this.title = roboTextView;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public View.OnClickListener getBackButtonClick() {
        return this.mBackButtonClick;
    }

    public static MpToolbarNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpToolbarNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpToolbarNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_toolbar_notification, viewGroup, z, obj);
    }

    public static MpToolbarNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpToolbarNotificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpToolbarNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_toolbar_notification, (ViewGroup) null, false, obj);
    }

    public static MpToolbarNotificationBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpToolbarNotificationBinding bind(View view, Object obj) {
        return (MpToolbarNotificationBinding) ViewDataBinding.bind(obj, view, R.layout.mp_toolbar_notification);
    }
}
