package com.business.merchant_payments.notificationsettings.viewmodel;

import androidx.arch.core.c.a;
import androidx.lifecycle.LiveData;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.repository.NotificationsRepository;
import kotlin.g.b.k;

public final class EmailAndSmsNotificationViewModel$updateNotificationSettingsLiveData$1<I, O> implements a<Boolean, LiveData<b<NotificationOnOffDataModel>>> {
    public final /* synthetic */ EmailAndSmsNotificationViewModel this$0;

    public EmailAndSmsNotificationViewModel$updateNotificationSettingsLiveData$1(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        this.this$0 = emailAndSmsNotificationViewModel;
    }

    public final LiveData<b<NotificationOnOffDataModel>> apply(Boolean bool) {
        k.b(bool, "flag");
        if (bool.booleanValue()) {
            return NotificationsRepository.INSTANCE.updateNotificationSettings(this.this$0.mNotificationSettingsToUpdate);
        }
        return com.business.common_module.utilities.a.a.a();
    }
}
