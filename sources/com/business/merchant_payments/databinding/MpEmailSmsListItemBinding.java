package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.notificationsettings.model.NotificationReceiverModel;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;
import com.paytm.utility.RoboTextView;

public abstract class MpEmailSmsListItemBinding extends ViewDataBinding {
    public final View bgCircle;
    public final RoboTextView btnRemoveReceiver;
    public final ImageView contactImg;
    public NotificationReceiverModel mDataModel;
    public Integer mItemColor;
    public Integer mPosition;
    public EmailAndSmsNotificationViewModel mViewModel;
    public final RoboTextView tvEmailId;
    public final RoboTextView tvPrimaryReceiver;
    public final RoboTextView tvSecondaryReceiver;

    public abstract void setDataModel(NotificationReceiverModel notificationReceiverModel);

    public abstract void setItemColor(Integer num);

    public abstract void setPosition(Integer num);

    public abstract void setViewModel(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel);

    public MpEmailSmsListItemBinding(Object obj, View view, int i2, View view2, RoboTextView roboTextView, ImageView imageView, RoboTextView roboTextView2, RoboTextView roboTextView3, RoboTextView roboTextView4) {
        super(obj, view, i2);
        this.bgCircle = view2;
        this.btnRemoveReceiver = roboTextView;
        this.contactImg = imageView;
        this.tvEmailId = roboTextView2;
        this.tvPrimaryReceiver = roboTextView3;
        this.tvSecondaryReceiver = roboTextView4;
    }

    public Integer getPosition() {
        return this.mPosition;
    }

    public EmailAndSmsNotificationViewModel getViewModel() {
        return this.mViewModel;
    }

    public NotificationReceiverModel getDataModel() {
        return this.mDataModel;
    }

    public Integer getItemColor() {
        return this.mItemColor;
    }

    public static MpEmailSmsListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpEmailSmsListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpEmailSmsListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_email_sms_list_item, viewGroup, z, obj);
    }

    public static MpEmailSmsListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpEmailSmsListItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpEmailSmsListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_email_sms_list_item, (ViewGroup) null, false, obj);
    }

    public static MpEmailSmsListItemBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpEmailSmsListItemBinding bind(View view, Object obj) {
        return (MpEmailSmsListItemBinding) ViewDataBinding.bind(obj, view, R.layout.mp_email_sms_list_item);
    }
}
