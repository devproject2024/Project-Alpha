package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.SendbirdNotificationEntity;
import io.reactivex.rxjava3.a.h;
import java.util.List;

public interface SendbirdNotificationDao {
    void addEntry(SendbirdNotificationEntity sendbirdNotificationEntity);

    void clearAllEntry();

    List<SendbirdNotificationEntity> getAllNotification();

    h<Integer> getAllNotificationCountFlowable();
}
