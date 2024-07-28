package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.ChatChannelUsersJoinEntity;
import io.reactivex.rxjava3.a.h;
import java.util.List;
import kotlin.g.b.k;

public interface ChatChannelUsersJoinDao {
    void deleteAllChannelUsers();

    void deleteChannelUser(String str);

    h<List<ChatChannelUsersJoinEntity>> getAllChannelUsers();

    ChatChannelUsersJoinEntity getChannelForUniqueId(String str);

    void insert(ChatChannelUsersJoinEntity chatChannelUsersJoinEntity);

    void upsert(List<ChatChannelUsersJoinEntity> list);

    public static final class DefaultImpls {
        public static void upsert(ChatChannelUsersJoinDao chatChannelUsersJoinDao, List<ChatChannelUsersJoinEntity> list) {
            k.c(list, "list");
            for (ChatChannelUsersJoinEntity insert : list) {
                chatChannelUsersJoinDao.insert(insert);
            }
        }
    }
}
