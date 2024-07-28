package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity;
import com.paytm.android.chat.data.db.room.helper.MessageInsertOrUpdatedModel;
import com.paytm.android.chat.f;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public interface ChatMessageDao {
    void bulkDeleteByMessageId(List<Long> list);

    void deleteAllMessages();

    void deleteMessage(long j);

    void deleteMessage(long j, String str);

    b deleteMessageForChannel(String str);

    List<ChatMessageEntity> getAllMessages();

    ChatMessageEntity getLatestNotSucceededMessage(String str);

    List<ChatMessageEntity> getMessageBy(String str, long j);

    List<ChatMessageEntity> getMessageBy(String str, String str2);

    h<List<ChatMessageEntity>> getMessageForChannel(String str);

    List<ChatMessageEntity> getNonAdminMessagesByChannelUrl(String str);

    Long getOldestMessageTsForChannel(String str);

    List<ChatMessageEntity> getPreviewTextNotEmptyMessagesByChannelUrl(String str);

    void insert(ChatMessageEntity chatMessageEntity);

    MessageInsertOrUpdatedModel insertOrUpdate(List<ChatMessageEntity> list);

    void markReadEngageEventSent(long j, boolean z);

    void update(ChatMessageEntity chatMessageEntity);

    void updateAnimationState(long j, boolean z);

    public static final class DefaultImpls {
        public static MessageInsertOrUpdatedModel insertOrUpdate(ChatMessageDao chatMessageDao, List<ChatMessageEntity> list) {
            List<ChatMessageEntity> list2;
            k.c(list, "list");
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            for (ChatMessageEntity chatMessageEntity : list) {
                if (f.a(chatMessageEntity.getRequestId()) == null) {
                    list2 = chatMessageDao.getMessageBy(chatMessageEntity.getChannelUrl(), chatMessageEntity.getMessageId());
                } else {
                    list2 = chatMessageDao.getMessageBy(chatMessageEntity.getChannelUrl(), chatMessageEntity.getRequestId());
                }
                if (list2.size() > 0) {
                    for (ChatMessageEntity chatMessageEntity2 : list2) {
                        chatMessageEntity.setId(chatMessageEntity2.getId());
                        chatMessageEntity.setReadEngageEventSent(chatMessageEntity2.getReadEngageEventSent());
                        chatMessageEntity.setShowAnim(chatMessageEntity2.getShowAnim());
                        chatMessageDao.update(chatMessageEntity);
                        arrayList2.add(chatMessageEntity);
                    }
                } else {
                    chatMessageEntity.setShowAnim(Boolean.TRUE);
                    chatMessageDao.insert(chatMessageEntity);
                    arrayList.add(chatMessageEntity);
                }
            }
            return new MessageInsertOrUpdatedModel(arrayList, arrayList2);
        }

        public static void bulkDeleteByMessageId(ChatMessageDao chatMessageDao, List<Long> list) {
            k.c(list, "messageIds");
            for (Number longValue : list) {
                chatMessageDao.deleteMessage(longValue.longValue());
            }
        }
    }
}
