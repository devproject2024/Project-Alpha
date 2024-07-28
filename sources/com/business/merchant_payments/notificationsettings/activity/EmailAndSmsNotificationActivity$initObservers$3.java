package com.business.merchant_payments.notificationsettings.activity;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;

public final class EmailAndSmsNotificationActivity$initObservers$3<T> implements z<b<NotificationOnOffDataModel>> {
    public final /* synthetic */ EmailAndSmsNotificationActivity this$0;

    public EmailAndSmsNotificationActivity$initObservers$3(EmailAndSmsNotificationActivity emailAndSmsNotificationActivity) {
        this.this$0 = emailAndSmsNotificationActivity;
    }

    public final void onChanged(b<NotificationOnOffDataModel> bVar) {
        this.this$0.handleUpdatedSettings(bVar);
    }
}
