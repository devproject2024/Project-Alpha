package com.sendbird.android;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.sendbird.android.log.Logger;

public final class SendBirdHmsMessagingService extends HmsMessageService {
    public final void onNewToken(String str) {
        Logger.d("++ onNewToken : ".concat(String.valueOf(str)));
        SendBirdPushHelper.onNewToken(str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.sendbird.android.SendBirdHmsMessagingService, android.content.Context, com.huawei.hms.push.HmsMessageService] */
    public final void onMessageReceived(RemoteMessage remoteMessage) {
        SendBirdHmsMessagingService.super.onMessageReceived(remoteMessage);
        Logger.i("remoteMesage : " + remoteMessage.getDataOfMap(), new Object[0]);
        SendBirdPushHelper.onMessageReceived(this, remoteMessage);
    }
}
