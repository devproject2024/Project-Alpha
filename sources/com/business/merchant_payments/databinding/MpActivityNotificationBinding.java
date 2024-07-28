package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.business.c.a.a;

public abstract class MpActivityNotificationBinding extends ViewDataBinding {
    public final View emailSettingsOverlay;
    public a mViewmodel;
    public final View notificationSettingsOverlay;
    public final View smsSettingsOverlay;
    public final MpToolbarNotificationBinding toolbar;
    public final MpNotificationItemViewBinding viewEmail;
    public final MpNotificationItemViewBinding viewSms;

    public abstract void setViewmodel(a aVar);

    public MpActivityNotificationBinding(Object obj, View view, int i2, View view2, View view3, View view4, MpToolbarNotificationBinding mpToolbarNotificationBinding, MpNotificationItemViewBinding mpNotificationItemViewBinding, MpNotificationItemViewBinding mpNotificationItemViewBinding2) {
        super(obj, view, i2);
        this.emailSettingsOverlay = view2;
        this.notificationSettingsOverlay = view3;
        this.smsSettingsOverlay = view4;
        this.toolbar = mpToolbarNotificationBinding;
        setContainedBinding(mpToolbarNotificationBinding);
        this.viewEmail = mpNotificationItemViewBinding;
        setContainedBinding(mpNotificationItemViewBinding);
        this.viewSms = mpNotificationItemViewBinding2;
        setContainedBinding(mpNotificationItemViewBinding2);
    }

    public a getViewmodel() {
        return this.mViewmodel;
    }

    public static MpActivityNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_notification, viewGroup, z, obj);
    }

    public static MpActivityNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityNotificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_notification, (ViewGroup) null, false, obj);
    }

    public static MpActivityNotificationBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityNotificationBinding bind(View view, Object obj) {
        return (MpActivityNotificationBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_notification);
    }
}
