package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import io.reactivex.rxjava3.a.h;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;

public interface ChatUserDao {
    void deleteAllChatUsers();

    void deleteChatUser(String str);

    h<List<ChatUserEntity>> getAllChatUsers();

    ChatUserEntity getChatUserByIdentifier(String str);

    ChatUserEntity getChatUserBySendbirdId(String str);

    void insert(ChatUserEntity chatUserEntity);

    void upsert(List<ChatUserEntity> list);

    public static final class DefaultImpls {
        public static void upsert(ChatUserDao chatUserDao, List<ChatUserEntity> list) {
            k.c(list, "list");
            for (ChatUserEntity chatUserEntity : list) {
                ChatUserEntity chatUserEntity2 = null;
                if (!p.a("NOT_SET", chatUserEntity.getSendbirdUserId(), true)) {
                    chatUserEntity2 = chatUserDao.getChatUserBySendbirdId(chatUserEntity.getSendbirdUserId());
                }
                if (chatUserEntity2 == null && !p.a("NOT_SET", chatUserEntity.getIdentifier(), true)) {
                    chatUserEntity2 = chatUserDao.getChatUserByIdentifier(chatUserEntity.getIdentifier());
                }
                if (chatUserEntity2 == null) {
                    chatUserDao.insert(chatUserEntity);
                } else {
                    chatUserEntity2.setAvatarUrl(chatUserEntity.getAvatarUrl());
                    chatUserEntity2.setSendbirdUserName(chatUserEntity.getSendbirdUserName());
                    chatUserEntity2.setLastSeenAt(chatUserEntity.getLastSeenAt());
                    chatUserEntity2.setActive(chatUserEntity.isActive());
                    chatUserEntity2.setFriendName(chatUserEntity.getFriendName());
                    chatUserEntity2.setFriendDiscoveryKey(chatUserEntity.getFriendDiscoveryKey());
                    chatUserEntity2.setBlockedByMe(chatUserEntity.isBlockedByMe());
                    chatUserEntity2.setBlockingMe(chatUserEntity.isBlockingMe());
                    chatUserEntity2.setMuted(chatUserEntity.isMuted());
                    chatUserEntity2.setConnectionStatus(chatUserEntity.getConnectionStatus());
                    if (!p.a("NOT_SET", chatUserEntity.getSendbirdUserId(), true)) {
                        chatUserEntity2.setSendbirdUserId(chatUserEntity.getSendbirdUserId());
                    }
                    if (!p.a("NOT_SET", chatUserEntity.getIdentifier(), true)) {
                        chatUserEntity2.setIdentifier(chatUserEntity.getIdentifier());
                    }
                    if (chatUserEntity.getType() != null) {
                        chatUserEntity2.setType(chatUserEntity.getType());
                    }
                    if (chatUserEntity.getPhoneNumber() != null) {
                        chatUserEntity2.setPhoneNumber(chatUserEntity.getPhoneNumber());
                    }
                    if (chatUserEntity.getChatPaymentMetadata() != null) {
                        chatUserEntity2.setChatPaymentMetadata(chatUserEntity.getChatPaymentMetadata());
                    }
                    chatUserDao.insert(chatUserEntity2);
                }
            }
        }
    }
}
