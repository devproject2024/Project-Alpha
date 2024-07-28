package androidx.browser.trusted;

import android.app.NotificationChannel;
import android.app.NotificationManager;

final class a {
    static boolean a(NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }
}
