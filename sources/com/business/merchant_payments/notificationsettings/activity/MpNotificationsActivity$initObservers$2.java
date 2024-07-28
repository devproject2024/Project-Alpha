package com.business.merchant_payments.notificationsettings.activity;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;

public final class MpNotificationsActivity$initObservers$2<T> implements z<b<NotificationOnOffDataModel>> {
    public final /* synthetic */ MpNotificationsActivity this$0;

    public MpNotificationsActivity$initObservers$2(MpNotificationsActivity mpNotificationsActivity) {
        this.this$0 = mpNotificationsActivity;
    }

    public final void onChanged(b<NotificationOnOffDataModel> bVar) {
        this.this$0.handleUpdatedSettings(bVar);
    }
}
