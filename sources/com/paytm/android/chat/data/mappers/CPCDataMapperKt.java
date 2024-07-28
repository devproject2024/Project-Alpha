package com.paytm.android.chat.data.mappers;

import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.d.a.a;
import com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.db.room.db_entities.UserInfoSource;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.data.models.messages.MPCPreviewDrawable;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.models.users.payments.UserPaymentDataModel;
import com.paytm.android.chat.data.repository.datastores.ChatLocalUsersDataStore;
import com.paytm.android.chat.g;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;

public final class CPCDataMapperKt {
    public static final ChatChannelEntity mapChatChannelToChannelEntity(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        List<Member> members;
        User inviter;
        User creator;
        k.c(chatGroupChannelDataModel, "chatChannel");
        a aVar = a.f41891a;
        GroupChannel a2 = a.a(chatGroupChannelDataModel.getChannelUrl());
        ChatChannelEntity chatChannelEntity = new ChatChannelEntity();
        chatChannelEntity.setChannelUrl(chatGroupChannelDataModel.getChannelUrl());
        chatChannelEntity.setName(chatGroupChannelDataModel.getReceiverDisplayInfo().getName());
        ChannelMetaData channelMetaData = null;
        chatChannelEntity.setCreatedAt(a2 != null ? Long.valueOf(a2.getCreatedAt()) : null);
        chatChannelEntity.setRawChannel(a2 != null ? a2.serialize() : null);
        chatChannelEntity.setMemberCount(chatGroupChannelDataModel.getMemberCount());
        chatChannelEntity.setMyLastRead(chatGroupChannelDataModel.getMyLastRead());
        chatChannelEntity.setUnreadMessageCount(chatGroupChannelDataModel.getUnreadMessageCount());
        chatChannelEntity.setUnreadMentionCount(chatGroupChannelDataModel.getUnreadMentionCount());
        chatChannelEntity.setData(chatGroupChannelDataModel.getData());
        chatChannelEntity.setCreatedBy((a2 == null || (creator = a2.getCreator()) == null) ? null : creator.getUserId());
        chatChannelEntity.setBroadcast(chatGroupChannelDataModel.isBroadcast());
        chatChannelEntity.setCustomType(chatGroupChannelDataModel.getCustomType());
        if (a2 != null) {
            chatChannelEntity.setInvitedAt(a2.getInvitedAt());
        }
        chatChannelEntity.setInviter((a2 == null || (inviter = a2.getInviter()) == null) ? null : inviter.getUserId());
        chatChannelEntity.setDiscoverable(chatGroupChannelDataModel.isDiscoverable());
        chatChannelEntity.setDistinct(chatGroupChannelDataModel.isDistinct());
        chatChannelEntity.setHidden(chatGroupChannelDataModel.isHidden());
        chatChannelEntity.setPublic(chatGroupChannelDataModel.isPublic());
        chatChannelEntity.setPushEnabled(chatGroupChannelDataModel.isPushEnabled());
        chatChannelEntity.setJoinedMemberCount(chatGroupChannelDataModel.getJoinedMemberCount());
        if (!(a2 == null || (members = a2.getMembers()) == null)) {
            chatChannelEntity.setMembers(members);
        }
        if (a2 != null) {
            channelMetaData = g.a((BaseChannel) a2);
        }
        chatChannelEntity.setMetaData(channelMetaData);
        ChatMessageDataModel lastMessage = chatGroupChannelDataModel.getLastMessage();
        if (lastMessage != null) {
            chatChannelEntity.setLastMessageTs(lastMessage.createdAt);
            chatChannelEntity.setLastMessageId(Long.valueOf(lastMessage.messageId));
            if (p.a(lastMessage.messageType, CommunityPostActivity.TYPE_FILE, true)) {
                chatChannelEntity.setLastMessageType(CommunityPostActivity.TYPE_FILE);
                chatChannelEntity.setMessagePreview(chatGroupChannelDataModel.getLastMessagePreview());
            }
            if (p.a(lastMessage.messageType, StringSet.user, true)) {
                chatChannelEntity.setLastMessageType(StringSet.user);
                chatChannelEntity.setMessagePreview(chatGroupChannelDataModel.getLastMessagePreview());
            }
            if (p.a(lastMessage.messageType, "admin", true)) {
                chatChannelEntity.setLastMessageType("admin");
            }
        }
        chatChannelEntity.setReplyAllowed(ChatVariantUtilKt.isReplyAllowed(chatGroupChannelDataModel.getCustomType(), chatGroupChannelDataModel.getData()));
        chatChannelEntity.setRequestAllowed(ChatVariantUtilKt.isRequestAllowed(chatGroupChannelDataModel.getCustomType(), chatGroupChannelDataModel.getData()));
        chatChannelEntity.setPayAllowed(ChatVariantUtilKt.isPayAllowed(chatGroupChannelDataModel.getCustomType(), chatGroupChannelDataModel.getData()));
        chatChannelEntity.setFake(false);
        return chatChannelEntity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        if ((r1 != null ? com.paytm.android.chat.f.a(r1) : null) != null) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel mapChannelEntityToChatChannel(com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity r43, com.paytm.android.chat.data.repository.datastores.ChatUsersDataStore r44) {
        /*
            r0 = r44
            java.lang.String r1 = "entity"
            r2 = r43
            kotlin.g.b.k.c(r2, r1)
            java.lang.String r1 = "chatLocalUsersDataStore"
            kotlin.g.b.k.c(r0, r1)
            byte[] r1 = r43.getRawChannel()
            com.sendbird.android.BaseChannel r1 = com.sendbird.android.BaseChannel.buildFromSerializedData(r1)
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = new com.paytm.android.chat.bean.ReceiverDisplayInfo
            r3.<init>()
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = new com.paytm.android.chat.data.models.messages.MPCMessagePreview
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r5 = com.paytm.android.chat.data.models.messages.MPCPreviewDrawable.NONE
            java.lang.String r6 = ""
            r4.<init>(r6, r5)
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0051
            boolean r7 = r1 instanceof com.sendbird.android.GroupChannel
            if (r7 == 0) goto L_0x0051
            r3 = r1
            com.sendbird.android.GroupChannel r3 = (com.sendbird.android.GroupChannel) r3
            int r7 = r3.getMemberCount()
            r8 = 2
            com.paytm.android.chat.bean.ReceiverDisplayInfo r8 = com.paytm.android.chat.utils.AppUtilKt.getReceiverDisplayInfo$default(r3, r6, r8, r6)
            com.sendbird.android.BaseMessage r3 = r3.getLastMessage()
            if (r3 == 0) goto L_0x004d
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r4 = com.paytm.android.chat.utils.CPCMessagePreviewUtilsKt.getMessagePreview(r3)
            com.paytm.android.chat.data.db.room.db_entities.ChatMessageEntity r1 = com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.getChatMessageEntity(r1, r3)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r1 = com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(r1, r5)
            r13 = r1
            r14 = r4
            goto L_0x004f
        L_0x004d:
            r14 = r4
            r13 = r6
        L_0x004f:
            r11 = r8
            goto L_0x0055
        L_0x0051:
            r7 = 0
            r11 = r3
            r14 = r4
            r13 = r6
        L_0x0055:
            com.paytm.android.chat.bean.RegistrationStatus r1 = r11.getRegistrationStatus()
            com.paytm.android.chat.bean.RegistrationStatus r3 = com.paytm.android.chat.bean.RegistrationStatus.NOT_ON_PAYTM
            if (r1 == r3) goto L_0x010b
            if (r13 != 0) goto L_0x006d
            java.lang.String r1 = r43.getDraftMessage()
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = com.paytm.android.chat.f.a((java.lang.String) r1)
            goto L_0x006b
        L_0x006a:
            r1 = r6
        L_0x006b:
            if (r1 == 0) goto L_0x010b
        L_0x006d:
            if (r7 <= r5) goto L_0x010b
            boolean r9 = r43.isFake()
            java.lang.String r10 = r43.getChannelUrl()
            boolean r12 = r43.isPinned()
            if (r13 == 0) goto L_0x0082
            java.lang.String r1 = r13.messageType
            r18 = r1
            goto L_0x0084
        L_0x0082:
            r18 = r6
        L_0x0084:
            java.lang.String r1 = r43.getDraftMessage()
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = com.paytm.android.chat.f.a((java.lang.String) r1)
            r15 = r1
            goto L_0x0091
        L_0x0090:
            r15 = r6
        L_0x0091:
            java.util.List r1 = r43.getMembers()
            if (r1 == 0) goto L_0x009e
            java.util.List r0 = r0.getChatUsersFromMembers(r1)
            r16 = r0
            goto L_0x00a0
        L_0x009e:
            r16 = r6
        L_0x00a0:
            if (r13 == 0) goto L_0x00a8
            long r0 = r13.messageId
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
        L_0x00a8:
            r17 = r6
            int r19 = r43.getMemberCount()
            long r20 = r43.getMyLastRead()
            int r22 = r43.getUnreadMessageCount()
            int r23 = r43.getUnreadMentionCount()
            java.lang.String r24 = r43.getData()
            java.lang.String r25 = r43.getCreatedBy()
            boolean r26 = r43.isBroadcast()
            java.lang.String r27 = r43.getCustomType()
            long r0 = r43.getInvitedAt()
            java.lang.Long r28 = java.lang.Long.valueOf(r0)
            java.lang.String r29 = r43.getInviter()
            boolean r30 = r43.isDiscoverable()
            boolean r31 = r43.isDistinct()
            boolean r32 = r43.isHidden()
            boolean r33 = r43.isPublic()
            boolean r34 = r43.isPushEnabled()
            int r36 = r43.getJoinedMemberCount()
            com.paytm.android.chat.bean.ChannelMetaData r35 = r43.getMetaData()
            boolean r38 = r43.getRequestAllowed()
            boolean r39 = r43.getPayAllowed()
            boolean r37 = r43.getReplyAllowed()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = new com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel
            r8 = r0
            r40 = 0
            r41 = 1073741824(0x40000000, float:2.0)
            r42 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return r0
        L_0x010b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.data.mappers.CPCDataMapperKt.mapChannelEntityToChatChannel(com.paytm.android.chat.data.db.room.db_entities.ChatChannelEntity, com.paytm.android.chat.data.repository.datastores.ChatUsersDataStore):com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel");
    }

    public static final ChatChannelEntity mapBaseChannelToChannelEntity(BaseChannel baseChannel) {
        k.c(baseChannel, "channel");
        ChatChannelEntity chatChannelEntity = new ChatChannelEntity();
        String url = baseChannel.getUrl();
        k.a((Object) url, "channel.url");
        chatChannelEntity.setChannelUrl(url);
        if (baseChannel instanceof GroupChannel) {
            GroupChannel groupChannel = (GroupChannel) baseChannel;
            chatChannelEntity.setName(groupChannel.getName());
            chatChannelEntity.setCreatedAt(Long.valueOf(groupChannel.getCreatedAt()));
            chatChannelEntity.setRawChannel(baseChannel.serialize());
            chatChannelEntity.setMemberCount(groupChannel.getMemberCount());
            chatChannelEntity.setMyLastRead(groupChannel.getMyLastRead());
            chatChannelEntity.setUnreadMessageCount(groupChannel.getUnreadMessageCount());
            chatChannelEntity.setUnreadMentionCount(groupChannel.getUnreadMentionCount());
            chatChannelEntity.setData(groupChannel.getData());
            User creator = groupChannel.getCreator();
            String str = null;
            chatChannelEntity.setCreatedBy(creator != null ? creator.getUserId() : null);
            chatChannelEntity.setBroadcast(groupChannel.isBroadcast());
            chatChannelEntity.setCustomType(groupChannel.getCustomType());
            chatChannelEntity.setInvitedAt(groupChannel.getInvitedAt());
            User inviter = groupChannel.getInviter();
            if (inviter != null) {
                str = inviter.getUserId();
            }
            chatChannelEntity.setInviter(str);
            chatChannelEntity.setDiscoverable(groupChannel.isDiscoverable());
            chatChannelEntity.setDistinct(groupChannel.isDistinct());
            chatChannelEntity.setHidden(groupChannel.isHidden());
            chatChannelEntity.setPublic(groupChannel.isPublic());
            chatChannelEntity.setPushEnabled(groupChannel.isPushEnabled());
            chatChannelEntity.setJoinedMemberCount(groupChannel.getJoinedMemberCount());
            List<Member> members = groupChannel.getMembers();
            k.a((Object) members, "channel.members");
            chatChannelEntity.setMembers(members);
            chatChannelEntity.setMetaData(g.a(baseChannel));
            BaseMessage lastMessage = groupChannel.getLastMessage();
            if (lastMessage != null) {
                chatChannelEntity.setLastMessageTs(Long.valueOf(lastMessage.getCreatedAt()));
                chatChannelEntity.setLastMessageId(Long.valueOf(lastMessage.getMessageId()));
                if (lastMessage instanceof FileMessage) {
                    chatChannelEntity.setLastMessageType(CommunityPostActivity.TYPE_FILE);
                    chatChannelEntity.setMessagePreview(CPCMessagePreviewUtilsKt.getMessagePreview(lastMessage));
                }
                if (lastMessage instanceof UserMessage) {
                    chatChannelEntity.setLastMessageType(StringSet.user);
                    chatChannelEntity.setMessagePreview(CPCMessagePreviewUtilsKt.getMessagePreview(lastMessage));
                }
                if (lastMessage instanceof AdminMessage) {
                    chatChannelEntity.setLastMessageType("admin");
                }
            }
            chatChannelEntity.setReplyAllowed(ChatVariantUtilKt.isReplyAllowed(groupChannel.getCustomType(), groupChannel.getData()));
            chatChannelEntity.setRequestAllowed(ChatVariantUtilKt.isRequestAllowed(groupChannel.getCustomType(), groupChannel.getData()));
            chatChannelEntity.setPayAllowed(ChatVariantUtilKt.isPayAllowed(groupChannel.getCustomType(), groupChannel.getData()));
            chatChannelEntity.setFake(false);
        }
        return chatChannelEntity;
    }

    public static final ChatGroupChannelDataModel mapBaseChannelToChatChannel(BaseChannel baseChannel) {
        MPCMessagePreview mPCMessagePreview;
        ChatMessageDataModel chatMessageDataModel;
        List<ChatUserDataModel> list;
        BaseChannel baseChannel2 = baseChannel;
        k.c(baseChannel2, "channel");
        ChatManager b2 = ChatManager.b();
        k.a((Object) b2, "ChatManager.getInstance()");
        ChatLocalUsersDataStore usersDataStore = b2.a().getUsersDataStore();
        if (baseChannel2 instanceof GroupChannel) {
            MPCMessagePreview mPCMessagePreview2 = new MPCMessagePreview("", MPCPreviewDrawable.NONE);
            GroupChannel groupChannel = (GroupChannel) baseChannel2;
            BaseMessage lastMessage = groupChannel.getLastMessage();
            String str = null;
            if (lastMessage != null) {
                mPCMessagePreview = CPCMessagePreviewUtilsKt.getMessagePreview(lastMessage);
                chatMessageDataModel = MessageDBHelperKt.getChatMessageDataModelFromMessageEntity(MessageDBHelperKt.getChatMessageEntity(baseChannel2, lastMessage), true);
            } else {
                mPCMessagePreview = mPCMessagePreview2;
                chatMessageDataModel = null;
            }
            List<ChatUserDataModel> arrayList = new ArrayList<>();
            List<Member> members = groupChannel.getMembers();
            if (members != null) {
                List<ChatUserDataModel> chatUsersFromMembers = usersDataStore.getChatUsersFromMembers(members);
                if (chatUsersFromMembers.isEmpty()) {
                    Iterable<Member> iterable = members;
                    Collection arrayList2 = new ArrayList(kotlin.a.k.a(iterable));
                    for (Member member : iterable) {
                        k.a((Object) member, "it");
                        arrayList2.add(mapUserEntityToChatUser(mapMemberToUserEntity(member)));
                    }
                    chatUsersFromMembers = (List) arrayList2;
                }
                list = chatUsersFromMembers;
            } else {
                list = arrayList;
            }
            String url = groupChannel.getUrl();
            k.a((Object) url, "channel.url");
            ReceiverDisplayInfo receiverDisplayInfo$default = AppUtilKt.getReceiverDisplayInfo$default(groupChannel, (SyncContactBean) null, 2, (Object) null);
            Long valueOf = chatMessageDataModel != null ? Long.valueOf(chatMessageDataModel.messageId) : null;
            String str2 = chatMessageDataModel != null ? chatMessageDataModel.messageType : null;
            int memberCount = groupChannel.getMemberCount();
            long myLastRead = groupChannel.getMyLastRead();
            int unreadMessageCount = groupChannel.getUnreadMessageCount();
            int unreadMentionCount = groupChannel.getUnreadMentionCount();
            String data = groupChannel.getData();
            User creator = groupChannel.getCreator();
            String userId = creator != null ? creator.getUserId() : null;
            boolean isBroadcast = groupChannel.isBroadcast();
            String customType = groupChannel.getCustomType();
            Long valueOf2 = Long.valueOf(groupChannel.getInvitedAt());
            User inviter = groupChannel.getInviter();
            if (inviter != null) {
                str = inviter.getUserId();
            }
            boolean isDiscoverable = groupChannel.isDiscoverable();
            boolean isDistinct = groupChannel.isDistinct();
            boolean isHidden = groupChannel.isHidden();
            boolean isPublic = groupChannel.isPublic();
            boolean isPushEnabled = groupChannel.isPushEnabled();
            int joinedMemberCount = groupChannel.getJoinedMemberCount();
            ChannelMetaData a2 = g.a(baseChannel);
            boolean isReplyAllowed = ChatVariantUtilKt.isReplyAllowed(groupChannel.getCustomType(), groupChannel.getData());
            boolean isPayAllowed = ChatVariantUtilKt.isPayAllowed(groupChannel.getCustomType(), groupChannel.getData());
            boolean isReplyAllowed2 = ChatVariantUtilKt.isReplyAllowed(groupChannel.getCustomType(), groupChannel.getData());
            String name = groupChannel.getName();
            k.a((Object) name, "channel.name");
            return new ChatGroupChannelDataModel(false, url, receiverDisplayInfo$default, false, chatMessageDataModel, mPCMessagePreview, (String) null, list, valueOf, str2, memberCount, myLastRead, unreadMessageCount, unreadMentionCount, data, userId, isBroadcast, customType, valueOf2, str, isDiscoverable, isDistinct, isHidden, isPublic, isPushEnabled, a2, joinedMemberCount, isReplyAllowed2, isReplyAllowed, isPayAllowed, name);
        }
        throw new UnsupportedOperationException("Unknown type for transform");
    }

    public static final ChatChannelEntity mapChannelToEntityOffline(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        k.c(chatGroupChannelDataModel, "channel");
        ChatChannelEntity chatChannelEntity = new ChatChannelEntity();
        chatChannelEntity.setChannelUrl(chatGroupChannelDataModel.getChannelUrl());
        chatChannelEntity.setName("group_channel");
        chatChannelEntity.setCreatedAt(0L);
        chatChannelEntity.setRawChannel((byte[]) null);
        chatChannelEntity.setLastMessageId(chatGroupChannelDataModel.getLastmessageId());
        chatChannelEntity.setMemberCount(chatGroupChannelDataModel.getMemberCount());
        chatChannelEntity.setMyLastRead(chatGroupChannelDataModel.getMyLastRead());
        chatChannelEntity.setUnreadMessageCount(chatGroupChannelDataModel.getUnreadMessageCount());
        chatChannelEntity.setUnreadMentionCount(chatGroupChannelDataModel.getUnreadMentionCount());
        chatChannelEntity.setData(chatGroupChannelDataModel.getData());
        chatChannelEntity.setCreatedBy(chatGroupChannelDataModel.getCreatedBy());
        chatChannelEntity.setBroadcast(chatGroupChannelDataModel.isBroadcast());
        chatChannelEntity.setCustomType(chatGroupChannelDataModel.getCustomType());
        chatChannelEntity.setInvitedAt(0);
        chatChannelEntity.setInviter(chatGroupChannelDataModel.getInviter());
        chatChannelEntity.setDiscoverable(chatGroupChannelDataModel.isDiscoverable());
        chatChannelEntity.setDistinct(chatGroupChannelDataModel.isDistinct());
        chatChannelEntity.setHidden(chatGroupChannelDataModel.isHidden());
        chatChannelEntity.setPublic(chatGroupChannelDataModel.isPublic());
        chatChannelEntity.setPushEnabled(chatGroupChannelDataModel.isPushEnabled());
        chatChannelEntity.setJoinedMemberCount(chatGroupChannelDataModel.getJoinedMemberCount());
        chatChannelEntity.setMembers(new ArrayList());
        chatChannelEntity.setMetaData((ChannelMetaData) null);
        chatChannelEntity.setLastMessageTs(0L);
        chatChannelEntity.setReplyAllowed(chatGroupChannelDataModel.isReplyAllowed());
        chatChannelEntity.setRequestAllowed(chatGroupChannelDataModel.isRequestAllowed());
        chatChannelEntity.setPayAllowed(chatGroupChannelDataModel.isPayAllowed());
        chatChannelEntity.setFake(chatGroupChannelDataModel.isFake());
        return chatChannelEntity;
    }

    public static final ChatUserEntity mapMemberToUserEntity(Member member) {
        k.c(member, StringSet.user);
        ChatUserEntity chatUserEntity = new ChatUserEntity();
        String userId = member.getUserId();
        k.a((Object) userId, "user.userId");
        chatUserEntity.setSendbirdUserId(userId);
        chatUserEntity.setAvatarUrl(member.getProfileUrl());
        chatUserEntity.setSendbirdUserName(member.getNickname());
        chatUserEntity.setLastSeenAt(String.valueOf(member.getLastSeenAt()));
        chatUserEntity.setActive(Boolean.valueOf(member.isActive()));
        chatUserEntity.setFriendName(member.getFriendName());
        chatUserEntity.setFriendDiscoveryKey(member.getFriendDiscoveryKey());
        chatUserEntity.setBlockingMe(member.isBlockingMe());
        chatUserEntity.setBlockedByMe(member.isBlockedByMe());
        chatUserEntity.setMuted(member.isMuted());
        chatUserEntity.setUserMetadata(g.a((User) member));
        chatUserEntity.setRawMember(member.serialize());
        chatUserEntity.setConnectionStatus(member.getConnectionStatus().name());
        return chatUserEntity;
    }

    public static final ChatUserEntity mapChatUserToUserEntity(ChatUserDataModel chatUserDataModel) {
        k.c(chatUserDataModel, StringSet.user);
        ChatUserEntity chatUserEntity = new ChatUserEntity();
        String sendbirdUserId = chatUserDataModel.getSendbirdUserId();
        if (sendbirdUserId != null) {
            chatUserEntity.setSendbirdUserId(sendbirdUserId);
        }
        String identifier = chatUserDataModel.getIdentifier();
        if (identifier != null) {
            chatUserEntity.setIdentifier(identifier);
        }
        chatUserEntity.setAvatarUrl(chatUserDataModel.getAvatarUrl());
        chatUserEntity.setSendbirdUserName(chatUserDataModel.getSendbirdUsername());
        chatUserEntity.setLastSeenAt(String.valueOf(chatUserDataModel.getLastSeenAt()));
        chatUserEntity.setActive(chatUserDataModel.isActive());
        chatUserEntity.setFriendName(chatUserDataModel.getFriendName());
        chatUserEntity.setFriendDiscoveryKey(chatUserDataModel.getFriendDiscoverykey());
        chatUserEntity.setBlockingMe(chatUserDataModel.isBlocking());
        chatUserEntity.setBlockedByMe(chatUserDataModel.isBlockedByMe());
        chatUserEntity.setMuted(chatUserDataModel.isMuted());
        chatUserEntity.setUserMetadata(chatUserDataModel.getUserMetaData());
        chatUserEntity.setRawMember(chatUserDataModel.getRawMember());
        chatUserEntity.setConnectionStatus(chatUserDataModel.getConnectionStatus());
        ChatUserType type = chatUserDataModel.getType();
        chatUserEntity.setType(type != null ? type.toString() : null);
        chatUserEntity.setChatPaymentMetadata(chatUserDataModel.getChatPaymentMetadata());
        return chatUserEntity;
    }

    public static final ChatUserDataModel mapUserEntityToChatUser(ChatUserEntity chatUserEntity) {
        k.c(chatUserEntity, "chatUserEntity");
        String sendbirdUserId = chatUserEntity.getSendbirdUserId();
        String sendbirdUserName = chatUserEntity.getSendbirdUserName();
        String avatarUrl = chatUserEntity.getAvatarUrl();
        String lastSeenAt = chatUserEntity.getLastSeenAt();
        Boolean isActive = chatUserEntity.isActive();
        String friendName = chatUserEntity.getFriendName();
        String friendDiscoveryKey = chatUserEntity.getFriendDiscoveryKey();
        boolean isMuted = chatUserEntity.isMuted();
        byte[] rawMember = chatUserEntity.getRawMember();
        String phoneNumber = chatUserEntity.getPhoneNumber();
        String phoneHash = chatUserEntity.getPhoneHash();
        String contactId = chatUserEntity.getContactId();
        UserInfoSource source = chatUserEntity.getSource();
        UserMetaData userMetadata = chatUserEntity.getUserMetadata();
        UserExtendedMetaData userExtendedMetaData = chatUserEntity.getUserExtendedMetaData();
        Long valueOf = Long.valueOf(chatUserEntity.getLastUpdatedUserExtendedMetaData());
        long createdAt = chatUserEntity.getCreatedAt();
        long updatedAt = chatUserEntity.getUpdatedAt();
        com.paytm.android.chat.contact.a addressBookContact = chatUserEntity.getAddressBookContact();
        boolean isBlockedByMe = chatUserEntity.isBlockedByMe();
        boolean isBlockingMe = chatUserEntity.isBlockingMe();
        String connectionStatus = chatUserEntity.getConnectionStatus();
        return new ChatUserDataModel(sendbirdUserId, chatUserEntity.getIdentifier(), chatUserEntity.getChatUserType(), sendbirdUserName, avatarUrl, lastSeenAt, isActive, friendName, friendDiscoveryKey, isBlockingMe, isBlockedByMe, isMuted, rawMember, phoneNumber, phoneHash, contactId, source, userMetadata, userExtendedMetaData, valueOf, createdAt, updatedAt, chatUserEntity.getChatPaymentMetadata(), addressBookContact, connectionStatus);
    }

    public static final ChatUserEntity mapUserInfoBeanToUserEntity(String str, UsersInfoJsonBean usersInfoJsonBean) {
        k.c(str, "sendbirdId");
        k.c(usersInfoJsonBean, "userInfo");
        ChatUserEntity chatUserEntity = new ChatUserEntity();
        chatUserEntity.setSource(UserInfoSource.USER_API);
        chatUserEntity.setSendbirdUserId(str);
        chatUserEntity.setSendbirdUserName(usersInfoJsonBean.getPfName());
        chatUserEntity.setAvatarUrl(usersInfoJsonBean.getImageUrl());
        chatUserEntity.setPhoneNumber(usersInfoJsonBean.getPhoneNumber());
        String identifier = usersInfoJsonBean.getUserPaymentDataModel().getIdentifier();
        if (identifier != null) {
            chatUserEntity.setIdentifier(identifier);
        }
        chatUserEntity.setType(usersInfoJsonBean.getUserPaymentDataModel().getType());
        chatUserEntity.setChatPaymentMetadata(mapPaymentDataToEntityPaymentData(usersInfoJsonBean.getUserPaymentDataModel()));
        return chatUserEntity;
    }

    public static final ChatUserEntity.ChatPaymentMetadata mapPaymentDataToEntityPaymentData(UserPaymentDataModel userPaymentDataModel) {
        if (userPaymentDataModel == null) {
            return null;
        }
        ChatUserEntity.ChatPaymentMetadata chatPaymentMetadata = new ChatUserEntity.ChatPaymentMetadata((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, 2047, (kotlin.g.b.g) null);
        chatPaymentMetadata.setName(userPaymentDataModel.getName());
        chatPaymentMetadata.setMobileNo(userPaymentDataModel.getMobileNumber());
        chatPaymentMetadata.setBankName(userPaymentDataModel.getBankName());
        chatPaymentMetadata.setMaskedAccNo(userPaymentDataModel.getMaskedAccNo());
        chatPaymentMetadata.setBankLogoUrl(userPaymentDataModel.getBankLogoUrl());
        chatPaymentMetadata.setAccRefId(userPaymentDataModel.getAccRefId());
        chatPaymentMetadata.setIfsc(userPaymentDataModel.getIfsc());
        chatPaymentMetadata.setVpa(userPaymentDataModel.getVpa());
        chatPaymentMetadata.setMid(userPaymentDataModel.getMid());
        chatPaymentMetadata.setVerifiedMerchant(userPaymentDataModel.isVerifiedMerchant());
        chatPaymentMetadata.setTxnCategory(userPaymentDataModel.getTxnCategory());
        return chatPaymentMetadata;
    }
}
