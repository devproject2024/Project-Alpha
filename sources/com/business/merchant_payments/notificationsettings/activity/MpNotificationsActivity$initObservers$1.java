package com.business.merchant_payments.notificationsettings.activity;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationsSettingsDataModel;

public final class MpNotificationsActivity$initObservers$1<T> implements z<b<NotificationsSettingsDataModel>> {
    public final /* synthetic */ MpNotificationsActivity this$0;

    public MpNotificationsActivity$initObservers$1(MpNotificationsActivity mpNotificationsActivity) {
        this.this$0 = mpNotificationsActivity;
    }

    public final void onChanged(b<NotificationsSettingsDataModel> bVar) {
        this.this$0.setNotificationSettings(bVar);
    }
}
