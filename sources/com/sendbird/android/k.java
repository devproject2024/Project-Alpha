package com.sendbird.android;

import com.appsflyer.internal.referrer.Payload;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.Command;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.TimeoutScheduler;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

final class k {

    /* renamed from: c  reason: collision with root package name */
    private static TimeoutScheduler f44723c;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, SendBird.ChannelHandler> f44724a;

    /* renamed from: b  reason: collision with root package name */
    final w f44725b;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f44826a = new k((byte) 0);
    }

    /* synthetic */ k(byte b2) {
        this();
    }

    private k() {
        this.f44724a = new ConcurrentHashMap();
        this.f44725b = new w();
    }

    /* access modifiers changed from: package-private */
    public final void a(BaseChannel baseChannel) {
        for (SendBird.ChannelHandler onChannelChanged : this.f44724a.values()) {
            onChannelChanged.onChannelChanged(baseChannel);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Command command, final BaseChannel baseChannel, boolean z) {
        final BaseMessage createMessage = BaseMessage.createMessage(command);
        if (createMessage != null) {
            Logger.d("__ cacheExisted = %s", Boolean.valueOf(z));
            if (createMessage.isGroupChannel()) {
                Sender sender = createMessage.mSender;
                User currentUser = SendBird.getCurrentUser();
                if (!(sender == null || currentUser == null || sender.getUserId().equals(SendBird.getCurrentUser().getUserId()))) {
                    SendBird.getInstance().sendCommand(Command.c(createMessage.getChannelUrl(), createMessage.mMessageId), false, new Command.SendCommandHandler() {
                        public final void onResult(Command command, SendBirdException sendBirdException) {
                            StringBuilder sb = new StringBuilder("sendCommand(MACK) => ");
                            sb.append(sendBirdException != null ? sendBirdException.getMessage() : Payload.RESPONSE_OK);
                            Logger.d(sb.toString());
                        }
                    });
                }
                User currentUser2 = SendBird.getCurrentUser();
                if (BaseMessage.belongsTo(createMessage, currentUser2)) {
                    currentUser2.updatePropertiesByUser(createMessage.mSender);
                }
                final GroupChannel groupChannel = (GroupChannel) baseChannel;
                boolean z2 = !z;
                if (groupChannel != null) {
                    final AtomicBoolean atomicBoolean = new AtomicBoolean();
                    if (z2) {
                        atomicBoolean.set(!createMessage.isSilent() || BaseMessage.belongsTo(createMessage, SendBird.getCurrentUser()));
                        if (groupChannel.isEphemeral() && atomicBoolean.get()) {
                            groupChannel.setLastMessageByCreatedAt(createMessage);
                            if (!BaseMessage.belongsTo(createMessage, SendBird.getCurrentUser())) {
                                groupChannel.setUnreadMessageCount(groupChannel.getUnreadMessageCount() + 1);
                            }
                            if (createMessage.isMentionedFromSomeoneToMe()) {
                                groupChannel.setUnreadMentionCount(groupChannel.getUnreadMentionCount() + 1);
                            }
                        }
                    } else {
                        groupChannel.setHiddenState(GroupChannel.HiddenState.UNHIDDEN);
                        atomicBoolean.set((!createMessage.isSilent() || BaseMessage.belongsTo(createMessage, SendBird.getCurrentUser())) && (groupChannel.mHasBeenUpdated || groupChannel.getLastMessage() == null || groupChannel.getLastMessage().getCreatedAt() < createMessage.getCreatedAt()));
                        if (atomicBoolean.get()) {
                            groupChannel.setLastMessageByCreatedAt(createMessage);
                            if (!BaseMessage.belongsTo(createMessage, SendBird.getCurrentUser())) {
                                groupChannel.setUnreadMessageCount(groupChannel.getUnreadMessageCount() + 1);
                            }
                            if (createMessage.isMentionedFromSomeoneToMe()) {
                                groupChannel.setUnreadMentionCount(groupChannel.getUnreadMentionCount() + 1);
                            }
                            groupChannel.mHasBeenUpdated = true;
                        }
                    }
                    if (createMessage.shouldForceUpdateLastMessage()) {
                        atomicBoolean.compareAndSet(false, groupChannel.setLastMessageByCreatedAt(createMessage));
                    }
                    Sender sender2 = createMessage.mSender;
                    if (sender2 != null && groupChannel.mMemberMap.containsKey(sender2.getUserId())) {
                        groupChannel.mMemberMap.get(sender2.getUserId()).updatePropertiesBySender(sender2);
                    }
                    SendBirdPushHelper.messageDelivered(createMessage);
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                next.onMessageReceived(groupChannel, createMessage);
                                Logger.d("__ callChannelChanged = %s", Boolean.valueOf(atomicBoolean.get()));
                                if (atomicBoolean.get()) {
                                    next.onChannelChanged(groupChannel);
                                }
                                if (createMessage.isMentionedFromSomeoneToMe()) {
                                    next.onMentionReceived(groupChannel, createMessage);
                                }
                            }
                        }
                    });
                }
            } else if (baseChannel != null) {
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                            if (OpenChannel.isEnteredChannel(baseChannel.getUrl())) {
                                next.onMessageReceived(baseChannel, createMessage);
                            }
                            if (createMessage.isMentionedFromSomeoneToMe()) {
                                next.onMentionReceived(baseChannel, createMessage);
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Command command, final BaseChannel baseChannel, boolean z) {
        final BaseMessage createMessage = BaseMessage.createMessage(command);
        if (createMessage != null && baseChannel != null) {
            if (baseChannel instanceof GroupChannel) {
                final GroupChannel groupChannel = (GroupChannel) baseChannel;
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                AtomicBoolean atomicBoolean2 = new AtomicBoolean();
                boolean z2 = true;
                if (SendBird.getCurrentUser() != null && createMessage.getCreatedAt() > groupChannel.getMyReadTs()) {
                    JsonObject asJsonObject = command.c().getAsJsonObject();
                    if (asJsonObject.has(StringSet.old_values)) {
                        BaseMessageParams.MentionType mentionType = createMessage.getMentionType();
                        List<String> mentionedUserIds = createMessage.getMentionedUserIds();
                        BaseMessageParams.MentionType mentionType2 = BaseMessageParams.MentionType.USERS;
                        JsonObject asJsonObject2 = asJsonObject.get(StringSet.old_values).getAsJsonObject();
                        if (asJsonObject2.has(StringSet.mention_type)) {
                            String asString = asJsonObject2.get(StringSet.mention_type).getAsString();
                            if (asString.equals(StringSet.users)) {
                                mentionType = BaseMessageParams.MentionType.USERS;
                            } else {
                                mentionType = asString.equals("channel") ? BaseMessageParams.MentionType.CHANNEL : mentionType2;
                            }
                        }
                        if (asJsonObject2.has(StringSet.mentioned_user_ids)) {
                            JsonArray asJsonArray = asJsonObject2.get(StringSet.mentioned_user_ids).getAsJsonArray();
                            if (asJsonArray != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                                    arrayList.add(asJsonArray.get(i2).getAsString());
                                }
                                mentionedUserIds = arrayList;
                            } else {
                                mentionedUserIds = null;
                            }
                        }
                        boolean z3 = mentionedUserIds != null && mentionedUserIds.contains(SendBird.getCurrentUser().getUserId());
                        if (mentionType == BaseMessageParams.MentionType.USERS && !z3 && createMessage.isMentionedFromSomeoneToMe()) {
                            if (z && !createMessage.isSilent()) {
                                groupChannel.setUnreadMentionCount(groupChannel.getUnreadMentionCount() + 1);
                            }
                            atomicBoolean2.set(true);
                            atomicBoolean.set(true);
                        }
                    }
                }
                AtomicBoolean atomicBoolean3 = new AtomicBoolean();
                if (!createMessage.isSilent() || BaseMessage.belongsTo(createMessage, SendBird.getCurrentUser())) {
                    BaseMessage lastMessage = groupChannel.getLastMessage();
                    if (!atomicBoolean2.get() && lastMessage != null && lastMessage.getCreatedAt() >= createMessage.getCreatedAt()) {
                        if (lastMessage.getCreatedAt() == createMessage.getCreatedAt()) {
                            if (lastMessage.getMessageId() != createMessage.getMessageId() || lastMessage.getUpdatedAt() >= createMessage.getUpdatedAt()) {
                                z2 = false;
                            }
                        }
                    }
                    atomicBoolean3.set(z2);
                }
                if (atomicBoolean3.get()) {
                    groupChannel.setLastMessage(createMessage);
                }
                final AtomicBoolean atomicBoolean4 = atomicBoolean3;
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                            next.onMessageUpdated(groupChannel, createMessage);
                            if (atomicBoolean4.get()) {
                                next.onChannelChanged(groupChannel);
                            }
                            if (atomicBoolean.get()) {
                                next.onMentionReceived(groupChannel, createMessage);
                            }
                        }
                    }
                });
                return;
            }
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ChannelHandler onMessageUpdated : k.this.f44724a.values()) {
                        onMessageUpdated.onMessageUpdated(baseChannel, createMessage);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Command command, final BaseChannel baseChannel) {
        if (baseChannel != null) {
            final ReactionEvent reactionEvent = new ReactionEvent(command.c());
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ChannelHandler onReactionUpdated : k.this.f44724a.values()) {
                        onReactionUpdated.onReactionUpdated(baseChannel, reactionEvent);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        if (r6.getUnreadMentionCount() != 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (r6.getUnreadMentionCount() == 0) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.sendbird.android.Command r5, com.sendbird.android.BaseChannel r6, boolean r7) {
        /*
            r4 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            com.sendbird.android.ReadStatus r0 = new com.sendbird.android.ReadStatus
            com.sendbird.android.shadow.com.google.gson.JsonElement r5 = r5.c()
            r0.<init>(r5)
            com.sendbird.android.GroupChannel r6 = (com.sendbird.android.GroupChannel) r6
            r5 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0063
            com.sendbird.android.User r7 = r0.getReader()
            java.lang.String r7 = r7.getUserId()
            long r2 = r0.getTimestamp()
            r6.updateReadReceipt(r7, r2)
            com.sendbird.android.User r7 = com.sendbird.android.SendBird.getCurrentUser()
            if (r7 == 0) goto L_0x003f
            com.sendbird.android.User r7 = r0.getReader()
            java.lang.String r7 = r7.getUserId()
            com.sendbird.android.User r0 = com.sendbird.android.SendBird.getCurrentUser()
            java.lang.String r0 = r0.getUserId()
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x003f
            r7 = 1
            goto L_0x0040
        L_0x003f:
            r7 = 0
        L_0x0040:
            if (r7 == 0) goto L_0x0061
            int r0 = r6.getUnreadMessageCount()
            if (r0 > 0) goto L_0x004e
            int r0 = r6.getUnreadMentionCount()
            if (r0 <= 0) goto L_0x0061
        L_0x004e:
            r6.setUnreadMessageCount(r1)
            r6.setUnreadMentionCount(r1)
            int r0 = r6.getUnreadMessageCount()
            if (r0 == 0) goto L_0x0090
            int r0 = r6.getUnreadMentionCount()
            if (r0 != 0) goto L_0x0061
            goto L_0x0090
        L_0x0061:
            r5 = 0
            goto L_0x0090
        L_0x0063:
            com.sendbird.android.User r7 = com.sendbird.android.SendBird.getCurrentUser()
            if (r7 == 0) goto L_0x0081
            com.sendbird.android.User r7 = r0.getReader()
            java.lang.String r7 = r7.getUserId()
            com.sendbird.android.User r0 = com.sendbird.android.SendBird.getCurrentUser()
            java.lang.String r0 = r0.getUserId()
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0081
            r7 = 1
            goto L_0x0082
        L_0x0081:
            r7 = 0
        L_0x0082:
            if (r7 == 0) goto L_0x0061
            int r0 = r6.getUnreadMessageCount()
            if (r0 == 0) goto L_0x0090
            int r0 = r6.getUnreadMentionCount()
            if (r0 != 0) goto L_0x0061
        L_0x0090:
            com.sendbird.android.k$32 r0 = new com.sendbird.android.k$32
            r0.<init>(r7, r6, r5)
            com.sendbird.android.SendBird.runOnUIThread(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.k.c(com.sendbird.android.Command, com.sendbird.android.BaseChannel, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final void d(Command command, BaseChannel baseChannel, boolean z) {
        if (baseChannel != null) {
            JsonObject asJsonObject = command.c().getAsJsonObject();
            final GroupChannel groupChannel = (GroupChannel) baseChannel;
            Logger.d("++ hasChannelCached : ".concat(String.valueOf(z)));
            Logger.d("++ channel : ".concat(String.valueOf(groupChannel)));
            if (asJsonObject.has(StringSet.updated)) {
                JsonObject asJsonObject2 = asJsonObject.get(StringSet.updated).getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entrySet = asJsonObject2.entrySet();
                if (z) {
                    for (Map.Entry next : entrySet) {
                        groupChannel.updateDeliveryReceipt((String) next.getKey(), ((JsonElement) next.getValue()).getAsLong());
                    }
                }
                User currentUser = SendBird.getCurrentUser();
                if (currentUser != null) {
                    boolean has = asJsonObject2.has(currentUser.getUserId());
                    if (!has || entrySet.size() > 1) {
                        Logger.d("++ isMyReceipt : " + has + ", receipt size : " + entrySet.size());
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                for (SendBird.ChannelHandler onDeliveryReceiptUpdated : k.this.f44724a.values()) {
                                    onDeliveryReceiptUpdated.onDeliveryReceiptUpdated(groupChannel);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Command command, final BaseChannel baseChannel) {
        if (baseChannel != null) {
            final i iVar = new i(command.c());
            User currentUser = SendBird.getCurrentUser();
            boolean z = true;
            switch (iVar.f44718b) {
                case CHANNEL_INVITE:
                    final GroupChannel groupChannel = (GroupChannel) baseChannel;
                    if (groupChannel.isSuper()) {
                        groupChannel.setMemberCount(iVar.a(), iVar.f44721e);
                    }
                    final User user = new User(iVar.a().getAsJsonObject().get("inviter"));
                    final ArrayList arrayList = new ArrayList();
                    Iterator<JsonElement> it2 = iVar.a().getAsJsonObject().get("invitees").getAsJsonArray().iterator();
                    while (it2.hasNext()) {
                        JsonObject asJsonObject = it2.next().getAsJsonObject();
                        String asString = asJsonObject.get("user_id").getAsString();
                        Member member = groupChannel.mMemberMap.get(asString);
                        if (currentUser != null && currentUser.getUserId().equals(asString)) {
                            groupChannel.setHiddenState(GroupChannel.HiddenState.UNHIDDEN);
                            if (groupChannel.getMyMemberState() != Member.MemberState.JOINED) {
                                groupChannel.setMyMemberState(Member.MemberState.INVITED);
                            }
                            if (iVar.a().getAsJsonObject().has("invited_at")) {
                                groupChannel.setInvitedAt(iVar.a().getAsJsonObject().get("invited_at").getAsLong());
                            }
                        }
                        if (member == null) {
                            asJsonObject.addProperty("state", "invited");
                            Member member2 = new Member(asJsonObject);
                            if (!groupChannel.isSuper()) {
                                groupChannel.addMember(member2, iVar.f44721e);
                            }
                            arrayList.add(member2);
                        } else {
                            arrayList.add(member);
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onUserReceivedInvitation : k.this.f44724a.values()) {
                                onUserReceivedInvitation.onUserReceivedInvitation(groupChannel, user, arrayList);
                            }
                        }
                    });
                    return;
                case CHANNEL_DECLINE_INVITE:
                    final GroupChannel groupChannel2 = (GroupChannel) baseChannel;
                    final User user2 = new User(iVar.a().getAsJsonObject().get("inviter"));
                    final Member member3 = new Member(iVar.a().getAsJsonObject().get("invitee"));
                    if (groupChannel2.isSuper()) {
                        groupChannel2.setMemberCount(iVar.a(), iVar.f44721e);
                    } else {
                        groupChannel2.removeMember(member3);
                    }
                    if (currentUser != null && currentUser.getUserId().equals(member3.getUserId())) {
                        groupChannel2.setMyMemberState(Member.MemberState.NONE);
                        groupChannel2.setInvitedAt(0);
                        if (!groupChannel2.isPublic()) {
                            GroupChannel.removeChannelFromCache(groupChannel2.getUrl());
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onUserDeclinedInvitation : k.this.f44724a.values()) {
                                onUserDeclinedInvitation.onUserDeclinedInvitation(groupChannel2, user2, member3);
                            }
                        }
                    });
                    return;
                case CHANNEL_JOIN:
                    final GroupChannel groupChannel3 = (GroupChannel) baseChannel;
                    ArrayList arrayList2 = new ArrayList();
                    if (iVar.a().getAsJsonObject().has(StringSet.users)) {
                        JsonArray asJsonArray = iVar.a().getAsJsonObject().get(StringSet.users).getAsJsonArray();
                        for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                            arrayList2.add(new Member(asJsonArray.get(i2)));
                        }
                    } else {
                        arrayList2.add(new Member(iVar.a()));
                    }
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        final Member member4 = (Member) arrayList2.get(i3);
                        if (groupChannel3.isSuper()) {
                            groupChannel3.setMemberCount(iVar.a(), iVar.f44721e);
                        } else {
                            groupChannel3.addMember(member4, iVar.f44721e);
                            groupChannel3.updateJoinedMemberCount();
                        }
                        if (currentUser != null && currentUser.getUserId().equals(member4.getUserId())) {
                            groupChannel3.setMyMemberState(Member.MemberState.JOINED);
                        }
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                for (SendBird.ChannelHandler onUserJoined : k.this.f44724a.values()) {
                                    onUserJoined.onUserJoined(groupChannel3, member4);
                                }
                            }
                        });
                    }
                    return;
                case CHANNEL_LEAVE:
                    final GroupChannel groupChannel4 = (GroupChannel) baseChannel;
                    final Member member5 = new Member(iVar.a());
                    if (groupChannel4.isSuper()) {
                        groupChannel4.setMemberCount(iVar.a(), iVar.f44721e);
                    } else {
                        groupChannel4.removeMember(member5);
                        groupChannel4.updateJoinedMemberCount();
                    }
                    if (currentUser != null && currentUser.getUserId().equals(member5.getUserId())) {
                        groupChannel4.setMyMemberState(Member.MemberState.NONE);
                        groupChannel4.setUnreadMessageCount(0);
                        groupChannel4.setUnreadMentionCount(0);
                        groupChannel4.setInvitedAt(0);
                        if (!groupChannel4.isPublic()) {
                            GroupChannel.removeChannelFromCache(groupChannel4.getUrl());
                        }
                    }
                    final boolean updateTypingStatus = groupChannel4.updateTypingStatus(member5, false);
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                next.onUserLeft(groupChannel4, member5);
                                if (updateTypingStatus) {
                                    next.onTypingStatusUpdated(groupChannel4);
                                }
                            }
                        }
                    });
                    return;
                case TYPING_START:
                case TYPING_END:
                    final GroupChannel groupChannel5 = (GroupChannel) baseChannel;
                    User user3 = new User(iVar.a());
                    if (iVar.f44718b != j.TYPING_START) {
                        z = false;
                    }
                    groupChannel5.updateTypingStatus(user3, z);
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onTypingStatusUpdated : k.this.f44724a.values()) {
                                onTypingStatusUpdated.onTypingStatusUpdated(groupChannel5);
                            }
                        }
                    });
                    return;
                case CHANNEL_ENTER:
                case CHANNEL_EXIT:
                    final OpenChannel openChannel = (OpenChannel) baseChannel;
                    JsonObject asJsonObject2 = iVar.a().getAsJsonObject();
                    if (asJsonObject2.has("participant_count")) {
                        openChannel.setParticipantCount(asJsonObject2.get("participant_count").getAsInt());
                    }
                    final User user4 = new User(iVar.a());
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                if (iVar.f44718b == j.CHANNEL_ENTER) {
                                    next.onUserEntered(openChannel, user4);
                                } else {
                                    next.onUserExited(openChannel, user4);
                                }
                            }
                        }
                    });
                    return;
                case USER_CHANNEL_MUTE:
                case USER_CHANNEL_UNMUTE:
                    final User user5 = new User(iVar.a());
                    if (baseChannel instanceof GroupChannel) {
                        GroupChannel groupChannel6 = (GroupChannel) baseChannel;
                        String userId = user5.getUserId();
                        if (iVar.f44718b != j.USER_CHANNEL_MUTE) {
                            z = false;
                        }
                        groupChannel6.updateMutedState(userId, z);
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                if (iVar.f44718b == j.USER_CHANNEL_MUTE) {
                                    next.onUserMuted(baseChannel, user5);
                                } else {
                                    next.onUserUnmuted(baseChannel, user5);
                                }
                            }
                        }
                    });
                    return;
                case USER_CHANNEL_BAN:
                case USER_CHANNEL_UNBAN:
                    final User user6 = new User(iVar.a());
                    if (iVar.f44718b == j.USER_CHANNEL_BAN) {
                        if (baseChannel instanceof GroupChannel) {
                            GroupChannel groupChannel7 = (GroupChannel) baseChannel;
                            if (groupChannel7.isSuper()) {
                                groupChannel7.setMemberCount(iVar.a(), iVar.f44721e);
                            } else {
                                groupChannel7.removeMember(user6);
                                groupChannel7.updateJoinedMemberCount();
                            }
                            if (SendBird.getCurrentUser() != null && SendBird.getCurrentUser().getUserId().equals(user6.getUserId())) {
                                groupChannel7.setMyMemberState(Member.MemberState.NONE);
                                groupChannel7.setUnreadMessageCount(0);
                                groupChannel7.setUnreadMentionCount(0);
                                groupChannel7.setInvitedAt(0);
                                if (!groupChannel7.isPublic()) {
                                    GroupChannel.removeChannelFromCache(groupChannel7.getUrl());
                                }
                            }
                        } else if (currentUser != null && currentUser.getUserId().equals(user6.getUserId())) {
                            OpenChannel.removeChannelFromEntered(iVar.f44719c);
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                if (iVar.f44718b == j.USER_CHANNEL_BAN) {
                                    next.onUserBanned(baseChannel, user6);
                                } else {
                                    next.onUserUnbanned(baseChannel, user6);
                                }
                            }
                        }
                    });
                    return;
                case CHANNEL_FREEZE:
                case CHANNEL_UNFREEZE:
                    JsonObject asJsonObject3 = iVar.a().getAsJsonObject();
                    if (asJsonObject3.has("freeze")) {
                        baseChannel.setFreeze(asJsonObject3.get("freeze").getAsBoolean());
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler next : k.this.f44724a.values()) {
                                if (iVar.f44718b == j.CHANNEL_FREEZE) {
                                    next.onChannelFrozen(baseChannel);
                                } else {
                                    next.onChannelUnfrozen(baseChannel);
                                }
                            }
                        }
                    });
                    return;
                case CHANNEL_PROP_CHANGED:
                    if (baseChannel instanceof GroupChannel) {
                        GroupChannel groupChannel8 = (GroupChannel) baseChannel;
                        if (!groupChannel8.isMyUnreadMentionCountEnabled()) {
                            groupChannel8.setUnreadMentionCount(0);
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onChannelChanged : k.this.f44724a.values()) {
                                onChannelChanged.onChannelChanged(baseChannel);
                            }
                        }
                    });
                    return;
                case CHANNEL_DELETED:
                    if (baseChannel instanceof GroupChannel) {
                        GroupChannel.removeChannelFromCache(iVar.f44719c);
                    } else {
                        OpenChannel.removeChannelFromCache(iVar.f44719c);
                        OpenChannel.removeChannelFromEntered(iVar.f44719c);
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onChannelDeleted : k.this.f44724a.values()) {
                                onChannelDeleted.onChannelDeleted(iVar.f44719c, baseChannel instanceof GroupChannel ? BaseChannel.ChannelType.GROUP : BaseChannel.ChannelType.OPEN);
                            }
                        }
                    });
                    return;
                case CHANNEL_META_DATA_CHANGED:
                case CHANNEL_META_COUNTERS_CHANGED:
                    a(baseChannel, iVar);
                    return;
                case CHANNEL_HIDDEN:
                    if (baseChannel instanceof GroupChannel) {
                        final GroupChannel groupChannel9 = (GroupChannel) baseChannel;
                        JsonObject asJsonObject4 = iVar.a().getAsJsonObject();
                        if (asJsonObject4.has("hide_previous_messages") && asJsonObject4.get("hide_previous_messages").getAsBoolean()) {
                            groupChannel9.setUnreadMessageCount(0);
                            groupChannel9.setUnreadMentionCount(0);
                            groupChannel9.parseMessageOffset(iVar.f44717a);
                        }
                        if (!asJsonObject4.has("allow_auto_unhide") || asJsonObject4.get("allow_auto_unhide").getAsBoolean()) {
                            groupChannel9.setHiddenState(GroupChannel.HiddenState.HIDDEN_ALLOW_AUTO_UNHIDE);
                        } else {
                            groupChannel9.setHiddenState(GroupChannel.HiddenState.HIDDEN_PREVENT_AUTO_UNHIDE);
                        }
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                for (SendBird.ChannelHandler onChannelHidden : k.this.f44724a.values()) {
                                    onChannelHidden.onChannelHidden(groupChannel9);
                                }
                            }
                        });
                        return;
                    }
                    return;
                case CHANNEL_UNHIDDEN:
                    if (baseChannel instanceof GroupChannel) {
                        final GroupChannel groupChannel10 = (GroupChannel) baseChannel;
                        groupChannel10.setHiddenState(GroupChannel.HiddenState.UNHIDDEN);
                        SendBird.runOnUIThread(new Runnable() {
                            public final void run() {
                                for (SendBird.ChannelHandler onChannelChanged : k.this.f44724a.values()) {
                                    onChannelChanged.onChannelChanged(groupChannel10);
                                }
                            }
                        });
                        return;
                    }
                    return;
                case CHANNEL_OPERATOR_CHANGED:
                    a(iVar, baseChannel);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(i iVar, final BaseChannel baseChannel) {
        Logger.d(">> handleChannelOperatorsChange");
        JsonObject asJsonObject = iVar.a().getAsJsonObject();
        ArrayList arrayList = new ArrayList();
        JsonArray asJsonArray = asJsonObject.has("operators") ? asJsonObject.get("operators").getAsJsonArray() : null;
        if (asJsonArray != null) {
            for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                arrayList.add(new User(asJsonArray.get(i2)));
            }
            if (iVar.f44720d.equals(BaseChannel.ChannelType.GROUP.value())) {
                GroupChannel groupChannel = (GroupChannel) baseChannel;
                User currentUser = SendBird.getCurrentUser();
                if (currentUser != null) {
                    groupChannel.setMyRole(arrayList.contains(currentUser) ? Member.Role.OPERATOR : Member.Role.NONE);
                }
                groupChannel.updateOperators(arrayList, iVar.f44721e);
            } else {
                ((OpenChannel) baseChannel).updateOperators(arrayList, iVar.f44721e);
            }
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ChannelHandler onOperatorUpdated : k.this.f44724a.values()) {
                        onOperatorUpdated.onOperatorUpdated(baseChannel);
                    }
                }
            });
        }
    }

    private void a(final BaseChannel baseChannel, i iVar) {
        try {
            JsonObject asJsonObject = iVar.a().getAsJsonObject();
            int i2 = 0;
            if (iVar.f44718b == j.CHANNEL_META_DATA_CHANGED) {
                if (asJsonObject.has("created")) {
                    final HashMap hashMap = new HashMap();
                    for (Map.Entry next : asJsonObject.getAsJsonObject("created").entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onMetaDataCreated : k.this.f44724a.values()) {
                                onMetaDataCreated.onMetaDataCreated(baseChannel, hashMap);
                            }
                        }
                    });
                }
                if (asJsonObject.has(StringSet.updated)) {
                    final HashMap hashMap2 = new HashMap();
                    for (Map.Entry next2 : asJsonObject.getAsJsonObject(StringSet.updated).entrySet()) {
                        if (((JsonElement) next2.getValue()).isJsonPrimitive()) {
                            hashMap2.put(next2.getKey(), ((JsonElement) next2.getValue()).getAsString());
                        }
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onMetaDataUpdated : k.this.f44724a.values()) {
                                onMetaDataUpdated.onMetaDataUpdated(baseChannel, hashMap2);
                            }
                        }
                    });
                }
                if (asJsonObject.has(StringSet.deleted)) {
                    final ArrayList arrayList = new ArrayList();
                    JsonArray asJsonArray = asJsonObject.getAsJsonArray(StringSet.deleted);
                    while (i2 < asJsonArray.size()) {
                        if (asJsonArray.get(i2).isJsonPrimitive()) {
                            arrayList.add(asJsonArray.get(i2).getAsString());
                        }
                        i2++;
                    }
                    SendBird.runOnUIThread(new Runnable() {
                        public final void run() {
                            for (SendBird.ChannelHandler onMetaDataDeleted : k.this.f44724a.values()) {
                                onMetaDataDeleted.onMetaDataDeleted(baseChannel, arrayList);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (asJsonObject.has("created")) {
                final HashMap hashMap3 = new HashMap();
                for (Map.Entry next3 : asJsonObject.getAsJsonObject("created").entrySet()) {
                    if (((JsonElement) next3.getValue()).isJsonPrimitive()) {
                        hashMap3.put(next3.getKey(), Integer.valueOf(((JsonElement) next3.getValue()).getAsInt()));
                    }
                }
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        for (SendBird.ChannelHandler onMetaCountersCreated : k.this.f44724a.values()) {
                            onMetaCountersCreated.onMetaCountersCreated(baseChannel, hashMap3);
                        }
                    }
                });
            }
            if (asJsonObject.has(StringSet.updated)) {
                final HashMap hashMap4 = new HashMap();
                for (Map.Entry next4 : asJsonObject.getAsJsonObject(StringSet.updated).entrySet()) {
                    if (((JsonElement) next4.getValue()).isJsonPrimitive()) {
                        hashMap4.put(next4.getKey(), Integer.valueOf(((JsonElement) next4.getValue()).getAsInt()));
                    }
                }
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        for (SendBird.ChannelHandler onMetaCountersUpdated : k.this.f44724a.values()) {
                            onMetaCountersUpdated.onMetaCountersUpdated(baseChannel, hashMap4);
                        }
                    }
                });
            }
            if (asJsonObject.has(StringSet.deleted)) {
                final ArrayList arrayList2 = new ArrayList();
                JsonArray asJsonArray2 = asJsonObject.getAsJsonArray(StringSet.deleted);
                while (i2 < asJsonArray2.size()) {
                    if (asJsonArray2.get(i2).isJsonPrimitive()) {
                        arrayList2.add(asJsonArray2.get(i2).getAsString());
                    }
                    i2++;
                }
                SendBird.runOnUIThread(new Runnable() {
                    public final void run() {
                        for (SendBird.ChannelHandler onMetaCountersDeleted : k.this.f44724a.values()) {
                            onMetaCountersDeleted.onMetaCountersDeleted(baseChannel, arrayList2);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Command command) {
        User user;
        User user2;
        x xVar = new x(command.c());
        User currentUser = SendBird.getCurrentUser();
        int i2 = AnonymousClass28.f44780b[xVar.f45338a.ordinal()];
        User user3 = null;
        if (i2 == 1) {
            if (xVar.a() == null || !xVar.a().getAsJsonObject().has("blocker") || !xVar.a().getAsJsonObject().has("blockee")) {
                user = null;
            } else {
                user3 = new User(xVar.a().getAsJsonObject().get("blocker"));
                user = new User(xVar.a().getAsJsonObject().get("blockee"));
            }
            if (user3 != null) {
                if (currentUser != null && currentUser.getUserId().equals(user3.getUserId())) {
                    for (Map.Entry<String, GroupChannel> value : GroupChannel.sCachedChannels.entrySet()) {
                        Member member = ((GroupChannel) value.getValue()).mMemberMap.get(user.getUserId());
                        if (member != null) {
                            member.setIsBlockedByMe(false);
                        }
                    }
                }
                if (currentUser != null && currentUser.getUserId().equals(user.getUserId())) {
                    for (Map.Entry<String, GroupChannel> value2 : GroupChannel.sCachedChannels.entrySet()) {
                        Member member2 = ((GroupChannel) value2.getValue()).mMemberMap.get(user3.getUserId());
                        if (member2 != null) {
                            member2.setIsBlockingMe(false);
                        }
                    }
                }
            }
        } else if (i2 == 2) {
            if (xVar.a() == null || !xVar.a().getAsJsonObject().has("blocker") || !xVar.a().getAsJsonObject().has("blockee")) {
                user2 = null;
            } else {
                user3 = new User(xVar.a().getAsJsonObject().get("blocker"));
                user2 = new User(xVar.a().getAsJsonObject().get("blockee"));
            }
            if (user3 != null) {
                if (currentUser != null && currentUser.getUserId().equals(user3.getUserId())) {
                    for (Map.Entry<String, GroupChannel> value3 : GroupChannel.sCachedChannels.entrySet()) {
                        Member member3 = ((GroupChannel) value3.getValue()).mMemberMap.get(user2.getUserId());
                        if (member3 != null) {
                            member3.setIsBlockedByMe(true);
                        }
                    }
                }
                if (currentUser != null && currentUser.getUserId().equals(user2.getUserId())) {
                    for (Map.Entry<String, GroupChannel> value4 : GroupChannel.sCachedChannels.entrySet()) {
                        Member member4 = ((GroupChannel) value4.getValue()).mMemberMap.get(user3.getUserId());
                        if (member4 != null) {
                            member4.setIsBlockingMe(true);
                        }
                    }
                }
            }
        } else if (i2 == 3 && xVar.a() != null && xVar.a().getAsJsonObject().has("friend_discoveries")) {
            JsonArray asJsonArray = xVar.a().getAsJsonObject().get("friend_discoveries").getAsJsonArray();
            final ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < asJsonArray.size(); i3++) {
                arrayList.add(new User(asJsonArray.get(i3)));
            }
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.UserEventHandler onFriendsDiscovered : new ArrayList(SendBird.getInstance().mUserEventHandlers.values())) {
                        onFriendsDiscovered.onFriendsDiscovered(arrayList);
                    }
                }
            });
        }
    }

    /* renamed from: com.sendbird.android.k$28  reason: invalid class name */
    static /* synthetic */ class AnonymousClass28 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f44780b = new int[y.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(3:53|54|56)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(51:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|56) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0051 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0089 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0101 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x010d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0119 */
        static {
            /*
                com.sendbird.android.y[] r0 = com.sendbird.android.y.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f44780b = r0
                r0 = 1
                int[] r1 = f44780b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.y r2 = com.sendbird.android.y.USER_UNBLOCK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f44780b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.y r3 = com.sendbird.android.y.USER_BLOCK     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f44780b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.y r4 = com.sendbird.android.y.FRIEND_DISCOVERED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.sendbird.android.j[] r3 = com.sendbird.android.j.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f44779a = r3
                int[] r3 = f44779a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.sendbird.android.j r4 = com.sendbird.android.j.CHANNEL_INVITE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.sendbird.android.j r3 = com.sendbird.android.j.CHANNEL_DECLINE_INVITE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_JOIN     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_LEAVE     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.sendbird.android.j r1 = com.sendbird.android.j.TYPING_START     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0072 }
                com.sendbird.android.j r1 = com.sendbird.android.j.TYPING_END     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x007d }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_ENTER     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_EXIT     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0095 }
                com.sendbird.android.j r1 = com.sendbird.android.j.USER_CHANNEL_MUTE     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.sendbird.android.j r1 = com.sendbird.android.j.USER_CHANNEL_UNMUTE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.sendbird.android.j r1 = com.sendbird.android.j.USER_CHANNEL_BAN     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                com.sendbird.android.j r1 = com.sendbird.android.j.USER_CHANNEL_UNBAN     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_FREEZE     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00d1 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_UNFREEZE     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00dd }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_PROP_CHANGED     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00e9 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_DELETED     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x00f5 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_META_DATA_CHANGED     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0101 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_META_COUNTERS_CHANGED     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x010d }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_HIDDEN     // Catch:{ NoSuchFieldError -> 0x010d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010d }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010d }
            L_0x010d:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0119 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_UNHIDDEN     // Catch:{ NoSuchFieldError -> 0x0119 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0119 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0119 }
            L_0x0119:
                int[] r0 = f44779a     // Catch:{ NoSuchFieldError -> 0x0125 }
                com.sendbird.android.j r1 = com.sendbird.android.j.CHANNEL_OPERATOR_CHANGED     // Catch:{ NoSuchFieldError -> 0x0125 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0125 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0125 }
            L_0x0125:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.k.AnonymousClass28.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Command command, final BaseChannel baseChannel) {
        if (baseChannel != null) {
            final long asLong = command.c().getAsJsonObject().get(StringSet.msg_id).getAsLong();
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ChannelHandler onMessageDeleted : k.this.f44724a.values()) {
                        onMessageDeleted.onMessageDeleted(baseChannel, asLong);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(Command command, final BaseChannel baseChannel) {
        if (baseChannel != null) {
            final ThreadInfoUpdateEvent threadInfoUpdateEvent = new ThreadInfoUpdateEvent(command.c().getAsJsonObject());
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    for (SendBird.ChannelHandler onThreadInfoUpdated : k.this.f44724a.values()) {
                        onThreadInfoUpdated.onThreadInfoUpdated(baseChannel, threadInfoUpdateEvent);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (f44723c == null) {
            f44723c = new TimeoutScheduler((TimeoutScheduler.TimeoutEventhandler) new TimeoutScheduler.TimeoutEventhandler() {
                public final void onTimeout(Object obj) {
                    for (final GroupChannel next : GroupChannel.sCachedChannels.values()) {
                        if (next.invalidateTypingStatus()) {
                            SendBird.runOnUIThread(new Runnable() {
                                public final void run() {
                                    for (SendBird.ChannelHandler onTypingStatusUpdated : k.this.f44724a.values()) {
                                        onTypingStatusUpdated.onTypingStatusUpdated(next);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
        if (f44723c.f44672a.get()) {
            f44723c.a();
        } else {
            f44723c.c();
        }
    }

    static void b() {
        TimeoutScheduler timeoutScheduler = f44723c;
        if (timeoutScheduler != null) {
            timeoutScheduler.a(false);
        }
    }

    static void c() throws ExecutionException, InterruptedException {
        Collection<OpenChannel> enteredChannels = OpenChannel.getEnteredChannels();
        if (enteredChannels.size() > 0 && !SendBird.isAppBackground()) {
            Logger.d("Enter open channels: " + enteredChannels.size());
            ArrayList<String> arrayList = new ArrayList<>();
            for (OpenChannel next : OpenChannel.getEnteredChannels()) {
                next.enter(false, (OpenChannel.OpenChannelEnterHandler) null).get();
                String url = next.getUrl();
                if (url != null && url.length() > 0) {
                    arrayList.add(url);
                }
            }
            if (arrayList.size() > 0) {
                for (String removeChannelFromEntered : arrayList) {
                    OpenChannel.removeChannelFromEntered(removeChannelFromEntered);
                }
            }
        }
    }
}
