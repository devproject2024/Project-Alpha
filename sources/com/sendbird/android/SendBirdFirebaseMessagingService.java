package com.sendbird.android;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public final class SendBirdFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "SENDBIRD_PUSH";

    public final void onNewToken(String str) {
        SendBirdPushHelper.onNewToken(str);
    }

    public final void onMessageReceived(RemoteMessage remoteMessage) {
        new StringBuilder("++ onMessageReceived : ").append(remoteMessage);
        SendBirdPushHelper.onMessageReceived(this, remoteMessage);
    }
}
