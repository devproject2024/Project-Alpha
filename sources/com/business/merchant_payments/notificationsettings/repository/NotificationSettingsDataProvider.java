package com.business.merchant_payments.notificationsettings.repository;

import com.business.merchant_payments.notificationsettings.model.NotificationOnOffDataModel;
import com.business.merchant_payments.notificationsettings.model.SmsEmailOnOffDataModel;
import kotlin.g.b.k;

public final class NotificationSettingsDataProvider {
    public static final NotificationSettingsDataProvider INSTANCE = new NotificationSettingsDataProvider();
    public static NotificationOnOffDataModel mNotificationToggleSettings;

    public final void setNotificationSettings(NotificationOnOffDataModel notificationOnOffDataModel) {
        k.d(notificationOnOffDataModel, "data");
        mNotificationToggleSettings = null;
        mNotificationToggleSettings = NotificationOnOffDataModel.copy$default(notificationOnOffDataModel, (SmsEmailOnOffDataModel) null, (SmsEmailOnOffDataModel) null, 3, (Object) null);
    }

    public final NotificationOnOffDataModel getNotificationSettings() {
        return mNotificationToggleSettings;
    }
}
