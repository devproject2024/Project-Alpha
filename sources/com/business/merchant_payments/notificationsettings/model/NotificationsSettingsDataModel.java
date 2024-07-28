package com.business.merchant_payments.notificationsettings.model;

import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.k;

public final class NotificationsSettingsDataModel extends BaseModel {
    public final NotificationOnOffDataModel notifications;
    public final ReceiverInfoDataModel receiverInfo;

    public static /* synthetic */ NotificationsSettingsDataModel copy$default(NotificationsSettingsDataModel notificationsSettingsDataModel, NotificationOnOffDataModel notificationOnOffDataModel, ReceiverInfoDataModel receiverInfoDataModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            notificationOnOffDataModel = notificationsSettingsDataModel.notifications;
        }
        if ((i2 & 2) != 0) {
            receiverInfoDataModel = notificationsSettingsDataModel.receiverInfo;
        }
        return notificationsSettingsDataModel.copy(notificationOnOffDataModel, receiverInfoDataModel);
    }

    public final NotificationOnOffDataModel component1() {
        return this.notifications;
    }

    public final ReceiverInfoDataModel component2() {
        return this.receiverInfo;
    }

    public final NotificationsSettingsDataModel copy(NotificationOnOffDataModel notificationOnOffDataModel, ReceiverInfoDataModel receiverInfoDataModel) {
        k.d(notificationOnOffDataModel, "notifications");
        k.d(receiverInfoDataModel, "receiverInfo");
        return new NotificationsSettingsDataModel(notificationOnOffDataModel, receiverInfoDataModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationsSettingsDataModel)) {
            return false;
        }
        NotificationsSettingsDataModel notificationsSettingsDataModel = (NotificationsSettingsDataModel) obj;
        return k.a((Object) this.notifications, (Object) notificationsSettingsDataModel.notifications) && k.a((Object) this.receiverInfo, (Object) notificationsSettingsDataModel.receiverInfo);
    }

    public final int hashCode() {
        NotificationOnOffDataModel notificationOnOffDataModel = this.notifications;
        int i2 = 0;
        int hashCode = (notificationOnOffDataModel != null ? notificationOnOffDataModel.hashCode() : 0) * 31;
        ReceiverInfoDataModel receiverInfoDataModel = this.receiverInfo;
        if (receiverInfoDataModel != null) {
            i2 = receiverInfoDataModel.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NotificationsSettingsDataModel(notifications=" + this.notifications + ", receiverInfo=" + this.receiverInfo + ")";
    }

    public final NotificationOnOffDataModel getNotifications() {
        return this.notifications;
    }

    public NotificationsSettingsDataModel(NotificationOnOffDataModel notificationOnOffDataModel, ReceiverInfoDataModel receiverInfoDataModel) {
        k.d(notificationOnOffDataModel, "notifications");
        k.d(receiverInfoDataModel, "receiverInfo");
        this.notifications = notificationOnOffDataModel;
        this.receiverInfo = receiverInfoDataModel;
    }

    public final ReceiverInfoDataModel getReceiverInfo() {
        return this.receiverInfo;
    }
}
