package com.paytm.android.chat.data.db.room.helper;

import com.paytm.android.chat.data.db.room.DBManager;
import com.paytm.android.chat.data.db.room.db_entities.SendbirdNotificationEntity;
import io.reactivex.rxjava3.a.h;
import java.util.List;
import kotlin.g.b.k;

public final class NotificationDBHelperKt {
    public static final h<Integer> getAllNotificationCountFlowable() {
        return DBManager.INSTANCE.getDb().sendbirdNotificationDao().getAllNotificationCountFlowable();
    }

    public static final List<SendbirdNotificationEntity> getAllNotificationMessage() {
        return DBManager.INSTANCE.getDb().sendbirdNotificationDao().getAllNotification();
    }

    public static final void addNotificationEntry(String str, String str2, String str3) {
        k.c(str, "id");
        k.c(str2, "channelUrl");
        k.c(str3, "payload");
        SendbirdNotificationEntity sendbirdNotificationEntity = new SendbirdNotificationEntity();
        sendbirdNotificationEntity.setId(str);
        sendbirdNotificationEntity.setChannelUrl(str2);
        sendbirdNotificationEntity.setPayload(str3);
        DBManager.INSTANCE.getDb().sendbirdNotificationDao().addEntry(sendbirdNotificationEntity);
    }

    public static final void clearNotificationTable() {
        DBManager.INSTANCE.getDb().sendbirdNotificationDao().clearAllEntry();
    }
}
