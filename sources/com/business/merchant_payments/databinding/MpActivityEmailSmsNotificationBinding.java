package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.R;
import com.business.merchant_payments.notificationsettings.BindingUtils;
import com.business.merchant_payments.notificationsettings.adapter.NotificationReceiverListAdapter;
import com.business.merchant_payments.notificationsettings.viewmodel.EmailAndSmsNotificationViewModel;
import com.paytm.utility.RoboTextView;

public abstract class MpActivityEmailSmsNotificationBinding extends ViewDataBinding {
    public final ConstraintLayout bgPaymentMsg;
    public final View bgReceiveFor;
    public final RoboTextView btnAddNew;
    public NotificationReceiverListAdapter mAdapter;
    public BindingUtils.Companion mBindingUtils;
    public EmailAndSmsNotificationViewModel mViewModel;
    public final RoboTextView paymentMsg;
    public final MpReceiveForItemViewBinding refundView;
    public final RecyclerView rvReceiver;
    public final MpToolbarNotificationBinding toolbar;
    public final MpReceiveForItemViewBinding transactionView;
    public final RoboTextView tvReceiveFor;

    public abstract void setAdapter(NotificationReceiverListAdapter notificationReceiverListAdapter);

    public abstract void setBindingUtils(BindingUtils.Companion companion);

    public abstract void setViewModel(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel);

    public MpActivityEmailSmsNotificationBinding(Object obj, View view, int i2, ConstraintLayout constraintLayout, View view2, RoboTextView roboTextView, RoboTextView roboTextView2, MpReceiveForItemViewBinding mpReceiveForItemViewBinding, RecyclerView recyclerView, MpToolbarNotificationBinding mpToolbarNotificationBinding, MpReceiveForItemViewBinding mpReceiveForItemViewBinding2, RoboTextView roboTextView3) {
        super(obj, view, i2);
        this.bgPaymentMsg = constraintLayout;
        this.bgReceiveFor = view2;
        this.btnAddNew = roboTextView;
        this.paymentMsg = roboTextView2;
        this.refundView = mpReceiveForItemViewBinding;
        setContainedBinding(mpReceiveForItemViewBinding);
        this.rvReceiver = recyclerView;
        this.toolbar = mpToolbarNotificationBinding;
        setContainedBinding(mpToolbarNotificationBinding);
        this.transactionView = mpReceiveForItemViewBinding2;
        setContainedBinding(mpReceiveForItemViewBinding2);
        this.tvReceiveFor = roboTextView3;
    }

    public NotificationReceiverListAdapter getAdapter() {
        return this.mAdapter;
    }

    public BindingUtils.Companion getBindingUtils() {
        return this.mBindingUtils;
    }

    public EmailAndSmsNotificationViewModel getViewModel() {
        return this.mViewModel;
    }

    public static MpActivityEmailSmsNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpActivityEmailSmsNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpActivityEmailSmsNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_email_sms_notification, viewGroup, z, obj);
    }

    public static MpActivityEmailSmsNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpActivityEmailSmsNotificationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpActivityEmailSmsNotificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_activity_email_sms_notification, (ViewGroup) null, false, obj);
    }

    public static MpActivityEmailSmsNotificationBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpActivityEmailSmsNotificationBinding bind(View view, Object obj) {
        return (MpActivityEmailSmsNotificationBinding) ViewDataBinding.bind(obj, view, R.layout.mp_activity_email_sms_notification);
    }
}
