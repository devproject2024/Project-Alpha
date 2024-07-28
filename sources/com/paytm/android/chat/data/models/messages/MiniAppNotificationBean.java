package com.paytm.android.chat.data.models.messages;

public final class MiniAppNotificationBean extends ChatMessageDataModel {
    private MiniAppNotificationData notifData;

    public final MiniAppNotificationData getNotifData() {
        return this.notifData;
    }

    public final void setNotifData(MiniAppNotificationData miniAppNotificationData) {
        this.notifData = miniAppNotificationData;
    }
}
