package com.business.merchant_payments.databinding;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public abstract class MpNotificationItemViewBinding extends ViewDataBinding {
    public final Barrier barrier;
    public final SwitchCompat btnToggleSettings;
    public final ImageView imgAudioAlert;
    public final RoboTextView languageText;
    public Boolean mAudioAlertView;
    public CompoundButton.OnCheckedChangeListener mCheckChangeListener;
    public Drawable mIcon;
    public Boolean mIsChecked;
    public View.OnClickListener mOnClickAction;
    public String mSubtitle;
    public String mTitle;
    public final RoboTextView tvAudioAlert;
    public final RoboTextView tvLanguage;

    public abstract void setAudioAlertView(Boolean bool);

    public abstract void setCheckChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setIcon(Drawable drawable);

    public abstract void setIsChecked(Boolean bool);

    public abstract void setOnClickAction(View.OnClickListener onClickListener);

    public abstract void setSubtitle(String str);

    public abstract void setTitle(String str);

    public MpNotificationItemViewBinding(Object obj, View view, int i2, Barrier barrier2, SwitchCompat switchCompat, ImageView imageView, RoboTextView roboTextView, RoboTextView roboTextView2, RoboTextView roboTextView3) {
        super(obj, view, i2);
        this.barrier = barrier2;
        this.btnToggleSettings = switchCompat;
        this.imgAudioAlert = imageView;
        this.languageText = roboTextView;
        this.tvAudioAlert = roboTextView2;
        this.tvLanguage = roboTextView3;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getSubtitle() {
        return this.mSubtitle;
    }

    public Boolean getIsChecked() {
        return this.mIsChecked;
    }

    public CompoundButton.OnCheckedChangeListener getCheckChangeListener() {
        return this.mCheckChangeListener;
    }

    public View.OnClickListener getOnClickAction() {
        return this.mOnClickAction;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public Boolean getAudioAlertView() {
        return this.mAudioAlertView;
    }

    public static MpNotificationItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpNotificationItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpNotificationItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_notification_item_view, viewGroup, z, obj);
    }

    public static MpNotificationItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpNotificationItemViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpNotificationItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_notification_item_view, (ViewGroup) null, false, obj);
    }

    public static MpNotificationItemViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpNotificationItemViewBinding bind(View view, Object obj) {
        return (MpNotificationItemViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_notification_item_view);
    }
}
