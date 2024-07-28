package net.one97.paytm.notification;

import android.content.Context;
import com.google.firebase.messaging.RemoteMessage;
import com.paytm.notification.fcm.PaytmNotificationService;
import com.sendbird.android.constant.StringSet;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.b.d;

public class NotificationService extends PaytmNotificationService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        d.b().k();
        CJRJarvisApplication.s();
        if (!remoteMessage.b().containsKey(StringSet.sendbird)) {
            super.onMessageReceived(remoteMessage);
        } else if (d.a() != null) {
            d.a().a((Context) this, remoteMessage);
        }
    }
}
