package com.paytm.android.chat.data.db.room.dao;

import com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity;
import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.y;
import java.util.List;
import kotlin.g.b.k;

public interface ChatChannelDao {
    b deleteAllChannel();

    b deleteChannel(String str);

    h<List<ChatChannelEntity>> getAllChannel();

    l<ChatChannelEntity> getChannel(String str);

    y<Integer> getChannelCount();

    ChatChannelEntity getChannelDeprecated(String str);

    y<Integer> getPinnedChannelCount();

    b insert(ChatChannelEntity chatChannelEntity);

    void insertDeprecated(ChatChannelEntity chatChannelEntity);

    b updateDraftMessage(String str, String str2);

    b updatePinnedState(String str, boolean z);

    b upsert(List<ChatChannelEntity> list);

    void upsertDeprecated(List<ChatChannelEntity> list);

    public static final class DefaultImpls {

        static final class a<T, R> implements io.reactivex.rxjava3.d.h<ChatChannelEntity, f> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ChatChannelDao f41897a;

            a(ChatChannelDao chatChannelDao) {
                this.f41897a = chatChannelDao;
            }

            public final /* synthetic */ Object apply(Object obj) {
                final ChatChannelEntity chatChannelEntity = (ChatChannelEntity) obj;
                return this.f41897a.getChannel(chatChannelEntity.getChannelUrl()).b(new io.reactivex.rxjava3.d.h<ChatChannelEntity, f>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ a f41898a;

                    {
                        this.f41898a = r1;
                    }

                    public final /* synthetic */ Object apply(Object obj) {
                        ChatChannelEntity chatChannelEntity = (ChatChannelEntity) obj;
                        if (chatChannelEntity == null) {
                            ChatChannelDao chatChannelDao = this.f41898a.f41897a;
                            ChatChannelEntity chatChannelEntity2 = chatChannelEntity;
                            k.a((Object) chatChannelEntity2, "entity");
                            return chatChannelDao.insert(chatChannelEntity2);
                        }
                        chatChannelEntity.setLastMessageTs(chatChannelEntity.getLastMessageTs());
                        chatChannelEntity.setRawChannel(chatChannelEntity.getRawChannel());
                        chatChannelEntity.setCreatedAt(chatChannelEntity.getCreatedAt());
                        chatChannelEntity.setName(chatChannelEntity.getName());
                        chatChannelEntity.setLastMessageId(chatChannelEntity.getLastMessageId());
                        chatChannelEntity.setLastMessageType(chatChannelEntity.getLastMessageType());
                        if (chatChannelEntity.getMessagePreview() != null) {
                            chatChannelEntity.setMessagePreview(chatChannelEntity.getMessagePreview());
                        }
                        chatChannelEntity.setMemberCount(chatChannelEntity.getMemberCount());
                        chatChannelEntity.setMyLastRead(chatChannelEntity.getMyLastRead());
                        chatChannelEntity.setUnreadMessageCount(chatChannelEntity.getUnreadMessageCount());
                        chatChannelEntity.setUnreadMentionCount(chatChannelEntity.getUnreadMentionCount());
                        chatChannelEntity.setData(chatChannelEntity.getData());
                        chatChannelEntity.setBroadcast(chatChannelEntity.isBroadcast());
                        chatChannelEntity.setCustomType(chatChannelEntity.getCustomType());
                        chatChannelEntity.setInvitedAt(chatChannelEntity.getInvitedAt());
                        chatChannelEntity.setDiscoverable(chatChannelEntity.isDiscoverable());
                        chatChannelEntity.setDistinct(chatChannelEntity.isDistinct());
                        chatChannelEntity.setHidden(chatChannelEntity.isHidden());
                        chatChannelEntity.setPublic(chatChannelEntity.isPublic());
                        chatChannelEntity.setPushEnabled(chatChannelEntity.isPushEnabled());
                        chatChannelEntity.setJoinedMemberCount(chatChannelEntity.getJoinedMemberCount());
                        chatChannelEntity.setMembers(chatChannelEntity.getMembers());
                        chatChannelEntity.setMetaData(chatChannelEntity.getMetaData());
                        chatChannelEntity.setReplyAllowed(chatChannelEntity.getReplyAllowed());
                        chatChannelEntity.setPayAllowed(chatChannelEntity.getPayAllowed());
                        chatChannelEntity.setRequestAllowed(chatChannelEntity.getRequestAllowed());
                        return this.f41898a.f41897a.insert(chatChannelEntity);
                    }
                });
            }
        }

        public static void upsertDeprecated(ChatChannelDao chatChannelDao, List<ChatChannelEntity> list) {
            k.c(list, "list");
            for (ChatChannelEntity chatChannelEntity : list) {
                ChatChannelEntity channelDeprecated = chatChannelDao.getChannelDeprecated(chatChannelEntity.getChannelUrl());
                if (channelDeprecated == null) {
                    chatChannelDao.insertDeprecated(chatChannelEntity);
                } else {
                    channelDeprecated.setLastMessageTs(chatChannelEntity.getLastMessageTs());
                    channelDeprecated.setRawChannel(chatChannelEntity.getRawChannel());
                    channelDeprecated.setCreatedAt(chatChannelEntity.getCreatedAt());
                    channelDeprecated.setName(chatChannelEntity.getName());
                    channelDeprecated.setLastMessageId(chatChannelEntity.getLastMessageId());
                    channelDeprecated.setLastMessageType(chatChannelEntity.getLastMessageType());
                    if (chatChannelEntity.getMessagePreview() != null) {
                        channelDeprecated.setMessagePreview(chatChannelEntity.getMessagePreview());
                    }
                    channelDeprecated.setMemberCount(chatChannelEntity.getMemberCount());
                    channelDeprecated.setMyLastRead(chatChannelEntity.getMyLastRead());
                    channelDeprecated.setUnreadMessageCount(chatChannelEntity.getUnreadMessageCount());
                    channelDeprecated.setUnreadMentionCount(chatChannelEntity.getUnreadMentionCount());
                    channelDeprecated.setData(chatChannelEntity.getData());
                    channelDeprecated.setBroadcast(chatChannelEntity.isBroadcast());
                    channelDeprecated.setCustomType(chatChannelEntity.getCustomType());
                    channelDeprecated.setInvitedAt(chatChannelEntity.getInvitedAt());
                    channelDeprecated.setDiscoverable(chatChannelEntity.isDiscoverable());
                    channelDeprecated.setDistinct(chatChannelEntity.isDistinct());
                    channelDeprecated.setHidden(chatChannelEntity.isHidden());
                    channelDeprecated.setPublic(chatChannelEntity.isPublic());
                    channelDeprecated.setPushEnabled(chatChannelEntity.isPushEnabled());
                    channelDeprecated.setJoinedMemberCount(chatChannelEntity.getJoinedMemberCount());
                    channelDeprecated.setMembers(chatChannelEntity.getMembers());
                    channelDeprecated.setMetaData(chatChannelEntity.getMetaData());
                    channelDeprecated.setReplyAllowed(chatChannelEntity.getReplyAllowed());
                    channelDeprecated.setPayAllowed(chatChannelEntity.getPayAllowed());
                    channelDeprecated.setRequestAllowed(chatChannelEntity.getRequestAllowed());
                    chatChannelDao.insertDeprecated(channelDeprecated);
                }
            }
        }

        public static b upsert(ChatChannelDao chatChannelDao, List<ChatChannelEntity> list) {
            k.c(list, "list");
            b b2 = p.fromIterable(list).flatMapCompletable(new a(chatChannelDao)).b(io.reactivex.rxjava3.i.a.b());
            k.a((Object) b2, "Observable.fromIterable(…scribeOn(Schedulers.io())");
            return b2;
        }
    }
}
