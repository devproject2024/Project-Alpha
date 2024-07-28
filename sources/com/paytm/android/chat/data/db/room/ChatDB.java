package com.paytm.android.chat.data.db.room;

import androidx.room.j;
import com.paytm.android.chat.data.db.room.dao.ChatChannelDao;
import com.paytm.android.chat.data.db.room.dao.ChatChannelUsersJoinDao;
import com.paytm.android.chat.data.db.room.dao.ChatMessageDao;
import com.paytm.android.chat.data.db.room.dao.ChatUserDao;
import com.paytm.android.chat.data.db.room.dao.SendbirdNotificationDao;
import com.paytm.android.chat.data.db.room.dao.UserExtendedMetadataDao;

public abstract class ChatDB extends j {
    public abstract ChatChannelDao chatChannelDao();

    public abstract ChatChannelUsersJoinDao chatChannelUserDao();

    public abstract ChatMessageDao chatMessageDao();

    public abstract ChatUserDao chatUserDao();

    public abstract SendbirdNotificationDao sendbirdNotificationDao();

    public abstract UserExtendedMetadataDao userExtendedMetaDataDao();
}
